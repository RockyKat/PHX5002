package ngdemo.mysql.service;

import ngdemo.mysql.domain.SQL;
import ngdemo.mysql.DBConnect;
// ORIGINALLY returns canned info to REST service.
//MODIFY to perform specified entry on database.
//Methods here call DBCOnnect class and do their thing.

public class SQLService {

    public SQL getDefaultSQL() {
        SQL sql = new SQL();
        sql.setFirstName("My SQL Server");
        sql.setLastName("Demo Database Access.");
        sql.setBmp("mysql.png");
        return sql;
    }
 
    //Needs to be filled out. Just preventing compile errors for now.
    //DBConnect will do the JDBC work.
    //Return filled out SQL object to REST method.
    public SQL createARow(String firstname, String lastname)
    {
    	String myFirstName = firstname;
    	String myLastName = lastname;
    	DBConnect connect = new DBConnect();
    	SQL rtnSQL = connect.createARowNotDemo(myFirstName,myLastName);
    	return rtnSQL;
    }
    
    public SQL readARow(int primaryKey)
    {
    	int primarykey = primaryKey;
    	DBConnect connect = new DBConnect();
    	SQL rtnSQL = connect.readARowNotDemo(primarykey);
    	return rtnSQL;
    }
    
    public SQL updateARow(String firstName, String lastName, int primaryKey)
    {
    	String firstname = firstName;
    	String lastname = lastName;
    	int primarykey = primaryKey;
    	DBConnect connect = new DBConnect();
    	SQL rtnSQL = connect.updateARowNotDemo(firstname,lastname,primarykey);
    	return rtnSQL;
    }
    public SQL deleteARow(int primaryKey)
    {
       int primarykey = primaryKey;
       
       DBConnect connect = new DBConnect();
       SQL rtnSQL = connect.deleteARowNotDemo(primarykey);
       
       return rtnSQL;
    }
}