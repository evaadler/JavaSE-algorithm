package cleancode.old.sql;

import sun.rmi.rmic.Generator;

/**
 * SelectWithCriterialSql
 *
 * @author Alicia
 * @description
 * @date 2020/6/13
 */
public class SelectWithCriterialSql extends SqlGenerator {

    public SelectWithCriterialSql(String table, Column[] columns) {
        super(table, columns);
    }

    @Override
    public String generate() {
        return null;
    }
}
