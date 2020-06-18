package cleancode.modelMethod;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.StatementCallback;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.util.Assert;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * CustomJdbcTemplate
 *
 * @author Alicia
 * @description
 * @date 2020/6/17
 */
public class CustomJdbcTemplate {

    public <T> T execute(StatementCallback<T> action) throws DataAccessException{
        Assert.notNull(action, "Callback object must not be null");

        Connection con = DataSourceUtils.getConnection(getDataSource());
        Statement stmt = null;
//        try {
//            Connection conToUse = con;
//            if (this.nativeJdbcExtractor != null && this.nativeJdbcExtractor.isNativeConnctionNecessaryForNativeStatements()){
//                conToUse = this.nativeJdbcExtractor.getNativeConncetion(con);
//            }
//
//            stmt = conToUse.createStatement();
//            applyStatementSettings(stmt);
//            Statement stmtToUse = stmt;
//            if (this.nativeJdbcExtractor != null){
//                stmtToUse = this.nativeJdbcExtractor.getNativeStatement(stmt);
//            }
//            T result = action.doInStatement(stmtToUse);
//            handleWarnings(stmt);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        return null;
    }

    private DataSource getDataSource() {
        return null;
    }
}
