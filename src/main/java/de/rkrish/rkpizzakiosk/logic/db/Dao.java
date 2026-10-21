package de.rkrish.rkpizzakiosk.logic.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public abstract class Dao<T> {
    //region 3. [C]reate [R]ead [U]pdate [D]elete-Operationen

    public abstract void insertDataRecords(Connection dbConnection, List<T> dataRecordsToInsert);
    public abstract void insertDataRecord(Connection dbConnection, T dataRecordToInsert);
    protected abstract void insert(T dataRecordToInsert, Statement insertStatement) throws SQLException;


    public abstract List<T> getAllDataRecords(Connection dbConnection);
    public abstract T getDataRecordById(Connection dbConnection, Integer id);

    public abstract void updateDataRecord(Connection dbConnection, T dataRecordToUpdate);

    public abstract void deleteDataRecord(Connection dbConnection, Integer id);
    //endregion

    //region 4. Hilfsmethoden und Funktionen
    protected abstract T getModelFromResultSet(ResultSet resultSet) throws SQLException;

    //endregion

}
