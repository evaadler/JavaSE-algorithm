package cleancode.old.args;

import org.omg.CORBA.PUBLIC_MEMBER;
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
    private char errorArgumentId = '\0';

    private Map<Character, ArgumentMarshaler> intArgs = new HashMap<>();

    enum ErrorCode {
        OK, MISSING_STRING, MISSING_INTEGER, INVALID_INTEGER,
    }

    private ErrorCode errorCode = ErrorCode.OK;

    public Args(String schema, String[] args) throws ParseException, ArgsException{
        this.schema = schema;
        this.args = args;
        valid = parse();
    }


    private boolean parse() throws ArgsException, ParseException{
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

    private void parseIntegerSchemaElement(char elementId) {
        intArgs.put(elementId, new IntegerArgumentMarshaler());
    }

    private boolean parseArguments() throws ArgsException{
        for (currentArgument = 0; currentArgument < args.length; currentArgument++) {
            String arg = args[currentArgument];
            parseArgument(arg);
        }
        return true;
    }

    private void parseArgument(String arg) throws ArgsException{
        if (arg.startsWith("-")) {
            parseElements(arg);
        }
    }

    private void parseElements(String arg) throws ArgsException{
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
            stringArgs.get(argChar).set(args[currentArgument]);
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
        try {
            booleanArgs.get(argChar).set("true");
        } catch (ArgsException e){

        }

    }

    private boolean isBoolean(char argChar) {
        return booleanArgs.containsKey(argChar);
    }

    private boolean isIntArg(char argChar) {
        return intArgs.containsKey(argChar);
    }

    private void setIntArg(char argChar) throws ArgsException{
        currentArgument++;
        String parameter = null;
        try {
            parameter = args[currentArgument];
            intArgs.get(argChar).set(parameter);
        } catch (ArrayIndexOutOfBoundsException e) {
            valid = false;
            errorArgumentId = argChar;
            errorCode = ErrorCode.MISSING_INTEGER;
            throw new ArgsException();
        } catch (ArgsException e) {
            valid = false;
            errorArgumentId = argChar;
            errorCode = ErrorCode.INVALID_INTEGER;
            throw e;
        }
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
        return am!=null && (boolean) am.get();
    }

    public String getString(char arg){
        Args.ArgumentMarshaler am = stringArgs.get(args);
        return am == null ? "" : (String)am.get();
    }

    public int getInt(char arg){
         Args.ArgumentMarshaler am = intArgs.get(arg);
        return am == null ? 0 : (Integer)am.get();
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
    private abstract class ArgumentMarshaler {

        public abstract void set(String s) throws ArgsException;

        public abstract Object get();

        private class BooleanArgumentMarshaler extends ArgumentMarshaler{
            private boolean booleanValue = false;

            @Override
            public void set(String s) {
                booleanValue = true;
            }
            @Override
            public Object get() {return booleanValue;}
        }

        private class StringArgumentMarshaler extends ArgumentMarshaler{
            private String stringValue;

            @Override
            public void set(String s) {
                stringValue = s;
            }

            @Override
            public Object get() {
                return stringValue;
            }
        }

        private class IntegerArgumentMarshaler extends ArgumentMarshaler{
            private int integerValue = 0;

            @Override
            public void set(String s) throws ArgsException{
                try {
                    integerValue = Integer.parseInt(s);
                } catch (NumberFormatException e){
                    throw new ArgsException();
                }
            }

            @Override
            public Object get() {
                return integerValue;
            }
        }
    }

}


