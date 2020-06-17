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
    private Set<Character> argsFound = new HashSet<>();
    private Iterator<String> currentArgument;
    private Map<Character, ArgumentMarshaler> marshalers = new HashMap<>();
    private List<String> argsList;



    public Args(String schema, String[] args) throws ParseException, ArgsException{
        this.schema = schema;
        this.argsList = Arrays.asList(args);
        parse();
    }


    private void parse() throws ArgsException, ParseException{
        parseSchema();
        parseArguments();
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
            throw new ArgsException(ErrorCode.INVALID_FORMAT,elementId, elementTail);
        }
    }

    private void validateSchemaElementId(char elementId) throws ArgsException {
        if (!Character.isLetter(elementId)) {
            // boi中抛异常抽取那块可以参考这里
            throw new ArgsException(ErrorCode.INVALID_ARGUMENT_NAMW, schema);
        }
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
            //unexpectedArguments.add(argChar);
            throw new ArgsException(ErrorCode.UNEXPECTED_ARGUMENT, argChar, null);
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
            e.setErrorArgumentId(argChar);
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
}


