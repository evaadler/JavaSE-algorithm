package cleancode.old.sql;

/**
 * SqlGenerator
 *
 * @author Alicia
 * @description
 * @date 2020/6/12
 */
public abstract class SqlGenerator {
    public SqlGenerator(String table, Column[] columns){}
    abstract public String generate();
}
