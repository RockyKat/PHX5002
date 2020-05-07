package ngdemo.service;

import ngdemo.domain.SQL;

public class SQLService {

	//ORIGINAL SQL SERVICE ... SETS FIELDS IN SQL OBJECT IT CREATES.
    public SQL getDefaultSQL() {
        SQL sql = new SQL();
        sql.setFirstName("My SQL Server");
        sql.setLastName("Demo Database Access.");
        sql.setBmp("mysql.png");
        return sql;
    }
}