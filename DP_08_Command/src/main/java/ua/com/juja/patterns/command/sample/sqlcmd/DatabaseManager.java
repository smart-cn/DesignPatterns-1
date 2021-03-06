package ua.com.juja.patterns.command.sample.sqlcmd;

import java.util.List;
import java.util.Set;

/**
 * Created by indigo on 25.08.2015.
 */
public interface DatabaseManager {

    List<DataSet> getTableData(String tableName);

    int getSize(String tableName);

    Set<String> getTableNames();

    void connect(String database, String userName, String password);

    void clear(String tableName);

    void create(String tableName, DataSet input);

    void update(String tableName, int id, DataSet newValue);

    Set<String> getTableColumns(String tableName);

    boolean isConnected();

    List<DataSet> remove(String tableName, String column, String value);
}
