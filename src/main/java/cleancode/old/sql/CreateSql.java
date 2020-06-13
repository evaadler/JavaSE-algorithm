package cleancode.old.sql;

/**
 * CreateSql
 *
 * @author Alicia
 * @description
 * @date 2020/6/12
 */
public class CreateSql extends SqlGenerator {
    public CreateSql(String table, Column[] columns) {
        super(table, columns);
    }

    @Override
    public String generate() {
        return null;
    }
}
