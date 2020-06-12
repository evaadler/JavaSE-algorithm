package cleancode.old.sql;

import org.apache.logging.log4j.core.tools.picocli.CommandLine;

/**
 * Sql
 * 生成提供恰当元数据的 SQL 格式化字符串
 * 暂不支持update语句，当需要时，需要"打开"这个类进行修改
 *
 * @author Alicia
 * @description
 * @date 2020/6/12
 */
public class Sql {
    public Sql(String table, Column[] columns){}
    public String create(){return "";}
    public String insert(Object[] fields){return "";}
    public String selectAll(){return "";}
    public String findByKey(String keyColumn, String keyValue){return "";}
    public String select(Column column, String pattern){return "";}
    public String select(Criteria criteria){return "";}
    public String preparedInsert(){return "";}
    private String columnList(Column[] columns){return "";}
    private String valueList(Object[] fields, final Column[] columns){return "";}
    private String selectWithCriteria(String criteria){return "";}
    private String placeholderList(Column[] columns){return "";}
}
