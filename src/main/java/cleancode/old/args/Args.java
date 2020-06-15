package cleancode.old.args;

import sun.util.locale.ParseStatus;


import java.text.ParseException;
import java.util.*;

/**
 * Args
 *
 * @author Alicia
 * @description
 * @date 2020/6/15
 */
public class Args {
    private String schema;
    private String[] args;
    private boolean valid;
    private Set<Character> unexpectedArguments = new TreeSet<Character>();
    private Map<Character, ArgumentMarshaler> booleanArgs = new HashMap<>();

    private Map<Character, ArgumentMarshaler> stringArgs = new HashMap<>();
    private Set<Character> argsFound = new HashSet<>();
    private int currentArgument;
    private char errorArgument = '\0';

    enum ErrorCode {
        OK, MISSING_STRING
    }

    private ErrorCode errorCode = ErrorCode.OK;

    public Args(String schema, String[] args) throws ParseException{
        this.schema = schema;
        this.args = args;
        valid = parse();
    }


    private boolean parse() throws ParseException{
        if (schema.length() == 0 && args.length == 0) {
            return true;
        }
        parseSchema();
        parseArguments();
        return valid;
    }

    private boolean parseSchema() throws ParseException{
        for (String element : schema.split(",")) {
            if (element.length() > 0) {
                String trimmedElement = element.trim();
                parseSchemaElement(trimmedElement);
            }
        }
        return true;
    }

    private void parseSchemaElement(String element) throws ParseException{
        char elementId = element.charAt(0);
        String elementTail = element.substring(1);
        validateSchemaElementId(elementId);
        // TODO boi 加商品类型那块可以参考这里
        if (isBooleanSchemaElement(elementTail)){
            parseBooleanSchemaElement(elementId);
        }else if (isStringSchemaElement(elementTail)){
            parseStringSchemaElement(elementId);
        }
    }

    private void validateSchemaElementId(char elementId) throws ParseException {
        if (!Character.isLetter(elementId)) {
            // boi中抛异常抽取那块可以参考这里
            throw new ParseException("Bad character:" + elementId + "in Args format " + schema, 0);
        }
    }

    private void parseStringSchemaElement(char elementId) {
        stringArgs.put(elementId, new StringArgumentMarshaler());
    }

    private boolean isStringSchemaElement(String elementTail) {
        return elementTail.equals("*");
    }

    private boolean isBooleanSchemaElement(String elementTail) {
        return elementTail.length() == 0;
    }

    private void parseBooleanSchemaElement(char elementId) {
        booleanArgs.put(elementId, new BooleanArgumentMarshaler());
    }

    private boolean parseArguments() {
        for (currentArgument = 0; currentArgument < args.length; currentArgument++) {
            String arg = args[currentArgument];
            parseArgument(arg);
        }
        return true;
    }

    private void parseArgument(String arg) {
        if (arg.startsWith("-")) {
            parseElements(arg);
        }
    }

    private void parseElements(String arg) {
        for (int i = 1; i < arg.length(); i++) {
            parseElement(arg.charAt(i));
        }
    }

    private void parseElement(char argChar) throws ArgsException{
        if (setArgument(argChar)) {
            argsFound.add(argChar);
        } else {
            unexpectedArguments.add(argChar);
            valid = false;
        }
    }

    private boolean setArgument(char argChar) throws ArgsException {
        boolean set = true;
        if (isBoolean(argChar)){
            setBooleanArg(argChar, true);
        }else if(isString(argChar)){
            setStringArg(argChar, "");
        }else{
            set = false;
        }
        return set;
    }

    private void setStringArg(char argChar, String s) throws ArgsException{
        currentArgument ++;
        try {
            stringArgs.get(argChar).setString(args[currentArgument]);
        }catch (ArrayIndexOutOfBoundsException e) {
            valid = false;
            errorArgument = argChar;
            errorCode = ErrorCode.MISSING_STRING;
            throw new ArgsException();
        }

    }

    private boolean isString(char argChar) {
        return stringArgs.containsKey(argChar);
    }



    private void setBooleanArg(char argChar, boolean value) {
        //booleanArgs.put(argChar, value);
        booleanArgs.get(argChar).setBoolean(value);
    }

    private boolean isBoolean(char argChar) {
        return booleanArgs.containsKey(argChar);
    }

    public int cardinality() {
        return argsFound.size();
    }

    public String usage() {
        if (schema.length() > 0) {
            return "-[" + schema + "]";
        } else {
            return "";
        }
    }

    public String errorMessage() throws Exception{
        if (unexpectedArguments.size() > 0) {
            return unexpectArgumentMessage();
        } else {
            switch (errorCode) {
                case MISSING_STRING:
                    return String.format("Could not find string parameter for -%c.",
                            errorArgument);
                case OK:
                    throw new Exception("TILT: Should not get here.");
            }
            return "";
        }
    }

    private String unexpectArgumentMessage() {
        StringBuffer message = new StringBuffer("Argument(s) -");
        for (char c : unexpectedArguments) {
            message.append(c);
        }
        message.append(" unexpected");
        return message.toString();
    }

    public boolean getBoolean(char arg) {
        Args.ArgumentMarshaler am  = booleanArgs.get(arg);
        return am!=null && am.getBoolean();
    }

    public String getString(char arg){
        Args.ArgumentMarshaler am = stringArgs.get(args);
        return am == null ? "" : am.getString();
    }

    private String blankIfNull(String s) {
        return s==null ? "":s;
    }

    public boolean has(char arg){
        return argsFound.contains(arg);
    }

    public boolean isValid() {
        return valid;
    }

    /**
     * 许多不同类型，类似的方法
     */
    private class ArgumentMarshaler {
        private boolean booleanValue = false;
        private String stringValue;

        public void setBoolean(boolean value) {
            booleanValue = value;
        }

        public boolean getBoolean() {return booleanValue;}

        public String getString() {
            return stringValue == null ? "" : stringValue;
        }

        public void setString(String stringValue) {
            this.stringValue = stringValue;
        }

        class BooleanArgumentMarshaler extends ArgumentMarshaler{}

        private class StringArgumentMarshaler extends ArgumentMarshaler{}

        private class IntegerArgumentMarshaler extends ArgumentMarshaler{}
    }

}


