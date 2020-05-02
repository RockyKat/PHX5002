package ngdemo.mysql.rest;

import ngdemo.mysql.domain.SQL;
import ngdemo.mysql.service.SQLService;
import ngdemo.mysql.DBConnect;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.PathParam;

//ORIGINALLY: GETS DEFAULT DATABASE ENTRIES...ONLY COMMENT THIS STUFF OUT.
//MODIFIED: CREATES, READS, UPDATES, DELETES entries from sakila customer database.

@Path("/sql")
public class SQLRestService {

/*    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public SQL getDefaultSQLInJSON() 
    {
        SQLService sqlService = new SQLService();
        
        DBConnect connect = new DBConnect();
		 connect.getData();      
        
        return sqlService.getDefaultSQL();
        
        //I'm going to add the access to DB sakila here just for test.
    }*/
	
	// Duplicate of my original demo. Does all CRUD ops.
	   @GET
		@Path("/demo")
	    @Produces(MediaType.APPLICATION_JSON)
	    public SQL getDefaultSQLInJSON() 
	    {
	        SQLService sqlService = new SQLService();
	        
	         DBConnect connect = new DBConnect();
			 connect.getData();    		 
			 System.out.println("NEw SQL in SQL directory");
			 
			 connect.updateData();
			 
			 System.out.println("MORE NEW SQLL");
			 
			 connect.createARow();
			 System.out.println("CREATED A ROW");
			 
			 connect.deleteARow();
			 System.out.println("DELETED A ROW");
	        
	        SQL mia = sqlService.getDefaultSQL();
	        System.out.println("Returned mia");
	        return mia;
	    }


	


	//Create a row  given first and last name...AFTER DEMO AND UNTESTED
	   @GET
	   @Path("/create/{varX}/{varY}")
	   @Produces(MediaType.APPLICATION_JSON)
	   public SQL createARow(@PathParam("varX") String firstName,@PathParam("varY") String lastName)
	   {
		  String lastname = lastName;
		  String firstname = firstName;
		  SQLService sqlService = new SQLService();
		  SQL mySQL = sqlService.createARow(firstname,lastname);
          return mySQL;
	   }
	   
	   //Read a row given primary key.
	   @GET
	   @Path("/read/{primaryKey}")
	   @Produces(MediaType.APPLICATION_JSON)
	   public SQL readARow(@PathParam("primaryKey") int primaryKey)
	   {
		   //Read the desired row - sqlService call
		   int primarykey = primaryKey;
		   SQLService sqlService = new SQLService();
		   SQL mySQL = sqlService.readARow(primarykey);
		   return mySQL;
	   }

	   //Update a row given firstname, lastname, primary key
	   @GET
	   @Path("/update/{firstname}/{lastname}/{primaryKey}")
	   @Produces(MediaType.APPLICATION_JSON)
	   public SQL updateARow(@PathParam("firstname") String firstName,@PathParam("lastname") String lastName, @PathParam("primaryKey") int primaryKey)			   
	   {
		 //Update the desired row - sqlService call
		   String firstname = firstName;
		   String lastname = lastName;
		   int primarykey = primaryKey;
		   SQLService sqlService = new SQLService();
		   SQL mySQL = sqlService.updateARow(firstname,lastname,primarykey);
	      return (SQL) null;  
	   }

	   //Delete a row given primary key.
	   @GET
	   @Path("/delete/{primaryKey}")
	   @Produces(MediaType.APPLICATION_JSON)
	   public SQL deleteARow(@PathParam("primaryKey") int primaryKey)
	   {
		   //Delete the desired row...sqlService call.
	      return (SQL) null;   
	   }
			  
	   
}
