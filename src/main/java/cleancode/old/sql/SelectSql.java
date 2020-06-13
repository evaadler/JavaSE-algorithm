package cleancode.old.sql;

/**
 * SelectSql
 *
 * @author Alicia
 * @description
 * @date 2020/6/12
 */
public class SelectSql extends SqlGenerator{
    public SelectSql(String table, Column[] columns) {
        super(table, columns);
    }

    @Override
    public String generate() {
        return null;
    }
}
