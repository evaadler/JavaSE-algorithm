package cleancode.old.sql;

/**
 * InsertSql
 *
 * @author Alicia
 * @description
 * @date 2020/6/13
 */
public class InsertSql extends SqlGenerator {

    public InsertSql(String table, Column[] columns) {
        super(table, columns);
    }

    @Override
    public String generate() {
        return null;
    }

    private String valueList(Object[] fields, final Column[] columns){
        return "";
    }
}
