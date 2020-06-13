package cleancode.old.sql;

/**
 * PreparedInsertSql
 *
 * @author Alicia
 * @description
 * @date 2020/6/13
 */
public class PreparedInsertSql extends SqlGenerator {
    public PreparedInsertSql(String table, Column[] columns) {
        super(table, columns);
    }

    @Override
    public String generate() {
        return null;
    }

    private String placeholderList(Column[] columns){return "";}
}
