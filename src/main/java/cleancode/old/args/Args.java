package cleancode.old.args;

import com.sun.javafx.image.impl.IntArgb;
import com.sun.org.apache.xpath.internal.Arg;
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
    private boolean valid;
    private Set<Character> unexpectedArguments = new TreeSet<Character>();
    private Set<Character> argsFound = new HashSet<>();
    private Iterator<String> currentArgument;
    private char errorArgumentId = '\0';
    private String errorParameter = "TILT";
    private Map<Character, ArgumentMarshaler> marshalers = new HashMap<>();
   // private ArgsException.ErrorCode errorCode = ArgsException.ErrorCode.OK;
    private List<String> argsList;



    public Args(String schema, String[] args) throws ParseException, ArgsException{
        this.schema = schema;
        this.argsList = Arrays.asList(args);
        valid = parse();
    }


    private boolean parse() throws ArgsException, ParseException{
        if (schema.length() == 0 && argsList.size() == 0) {
            return true;
        }
        parseSchema();
        try {
            parseArguments();
        } catch (ArgsException e){

        }

        return valid;
    }

    private boolean parseSchema() throws ArgsException{
        for (String element : schema.split(",")) {
            if (element.length() > 0) {
                String trimmedElement = element.trim();
                parseSchemaElement(trimmedElement);
            }
        }
        return true;
    }

    private void parseSchemaElement(String element) throws ArgsException{
        char elementId = element.charAt(0);
        String elementTail = element.substring(1);
        validateSchemaElementId(elementId);
        // TODO boi 加商品类型那块可以参考这里
        if (elementTail.length() == 0){
            marshalers.put(elementId, new BooleanArgumentMarshaler());
        }else if (elementTail.equals("*")){
            marshalers.put(elementId, new StringArgumentMarshaler());
        }else if(elementTail.equals("#")) {
            marshalers.put(elementId, new IntegerArgumentMarshaler());
        } else if (elementTail.equals("##")){
            marshalers.put(elementId, new DoubleArgumentMarshaler());
        }else {
            throw new ArgsException(String.format("Argument: %c" +
                    " has invalid format: %s.",elementId, elementTail));
        }
    }

    private void validateSchemaElementId(char elementId) throws ArgsException {
        if (!Character.isLetter(elementId)) {
            // boi中抛异常抽取那块可以参考这里
            throw new ArgsException("Bad character:" + elementId + "in Args format " + schema);
        }
    }

    private void parseStringSchemaElement(char elementId) {
        ArgumentMarshaler m = new StringArgumentMarshaler();
        //stringArgs.put(elementId, m);
        marshalers.put(elementId, m);
    }

    private boolean isStringSchemaElement(String elementTail) {
        return elementTail.equals("*");
    }

    private boolean isBooleanSchemaElement(String elementTail) {
        return elementTail.length() == 0;
    }

    private boolean isIntegerSchemaElement(String elementTail) {
        return elementTail.equals("#");
    }


    private boolean parseArguments() throws ArgsException{
        for (currentArgument = argsList.iterator(); currentArgument.hasNext(); ) {
            String arg = currentArgument.next();
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
            //errorCode = ArgsException.ErrorCode.UNEXPECTED_ARGUMENT;
            valid = false;
        }
    }

    private boolean setArgument(char argChar) throws ArgsException {
        ArgumentMarshaler m = marshalers.get(argChar);
        if (m == null) {
            return false;
        }
        try {
            m.set(currentArgument);
            return true;
        } catch (ArgsException e) {
            valid = false;
            errorArgumentId = argChar;
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



    private String unexpectArgumentMessage() {
        StringBuffer message = new StringBuffer("Argument(s) -");
        for (char c : unexpectedArguments) {
            message.append(c);
        }
        message.append(" unexpected");
        return message.toString();
    }

    public boolean getBoolean(char arg) {
        ArgumentMarshaler am  = marshalers.get(arg);
        boolean b = false;
        try {
            b = am!=null && (boolean) am.get();
        } catch (ClassCastException e){
            b = false;
        }
        return b;
    }

    public String getString(char arg){
        ArgumentMarshaler am = marshalers.get(arg);

        try {
            return am == null ? "" : (String)am.get();
        } catch (ClassCastException e) {
            return "";
        }
    }

    public int getInt(char arg){
         ArgumentMarshaler am = marshalers.get(arg);
         try {
             return am == null ? 0 : (Integer)am.get();
         }catch (ClassCastException e) {
             return 0;
         }

    }

    public double getDouble(char arg) {
        ArgumentMarshaler am = marshalers.get(arg);
        try {
            return am == null ? 0 : (Double)am.get();
        }catch (Exception e){
            return 0.0;
        }
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
}


