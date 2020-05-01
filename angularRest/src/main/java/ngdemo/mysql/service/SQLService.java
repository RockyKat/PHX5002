package ngdemo.mysql.service;

import ngdemo.mysql.domain.SQL;
// ORIGINALLY returns canned info to REST service.
//MODIFY to perform specified entry on database.

public class SQLService {

    public SQL getDefaultSQL() {
        SQL sql = new SQL();
        sql.setFirstName("My SQL Server");
        sql.setLastName("Demo Database Access.");
        sql.setBmp("mysql.png");
        return sql;
    }
 
    //Needs to be filled out. Just preventing compile errors for now.
    public int createARow(String firstname, String lastname)
    {
    	return 0;
    }
}