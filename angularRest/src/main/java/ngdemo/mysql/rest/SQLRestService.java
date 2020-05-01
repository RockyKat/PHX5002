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


	


	//Create a row  given first and last name.
	   @GET
	   @Path("/create/{varX}/{varY}")
	   @Produces(MediaType.APPLICATION_JSON)
	   public SQL createARow(@PathParam("varX") String firstname,@PathParam("varY") String lastname)
	   {
		  SQLService sqlService = new SQLService();
		  int rtnval = sqlService.createARow(firstname,lastname);
          return (SQL) null;
	   }
	   
	   //Read a row given primary key.
	   @GET
	   @Path("/read/{primaryKey}")
	   @Produces(MediaType.APPLICATION_JSON)
	   public SQL readARow(@PathParam("primaryKey") int primaryKey)
	   {
		   return (SQL) null;
	   }

	   //Update a row given firstname, lastname, primary key
	   @GET
	   @Path("/update/{firstname}/{lastname}/{primaryKey}")
	   @Produces(MediaType.APPLICATION_JSON)
	   public SQL updateARow(@PathParam("firstname") String firstname,@PathParam("lastname") String lastname, @PathParam("primaryKey") int primaryKey)			   
	   {
	      return (SQL) null;  
	   }

	   //Delete a row given primary key.
	   @GET
	   @Path("/delete/{primaryKey}")
	   @Produces(MediaType.APPLICATION_JSON)
	   public SQL deleteARow(@PathParam("primaryKey") int primaryKey)
	   {
	      return (SQL) null;   
	   }
			  
	   
}
