package ngdemo.phxsql.rest;

import ngdemo.phxsql.domain.PHXSQL;
import ngdemo.phxsql.service.PHXSQLService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.PathParam;

//DEALS WITH PHXSQL database only. Demos JDBC CRUD ops.

@Path("/mysql")
public class PHXSQLRestService {


	
	// Duplicate of my original demo. Does all CRUD ops.
	   @GET
		@Path("/demo")
	    @Produces(MediaType.APPLICATION_JSON)
	    public PHXSQL getDefaultSQLInJSON() 
	    {
	        PHXSQLService phxsqlService = new PHXSQLService();
	        
	        phxsqlService.doDemo();
	        PHXSQL mia = phxsqlService.getDefaultSQL();
	        System.out.println("Returned miaa");
	        return mia;
	    }


	


	//Create a row  given first and last name...AFTER DEMO AND UNTESTED
	   @GET
	   @Path("/create/{varX}/{varY}")
	   @Produces(MediaType.APPLICATION_JSON)
	   public PHXSQL createARow(@PathParam("varX") String firstName,@PathParam("varY") String lastName)
	   {
		  String lastname = lastName;
		  String firstname = firstName;
		  PHXSQLService sqlService = new PHXSQLService();
		  PHXSQL mySQL = sqlService.createARow(firstname,lastname);
          return mySQL;
	   }
	   
	   //Read a row given primary key.
	   @GET
	   @Path("/read/{primaryKey}")
	   @Produces(MediaType.APPLICATION_JSON)
	   public PHXSQL readARow(@PathParam("primaryKey") int primaryKey)
	   {
		   //Read the desired row - sqlService call
		   int primarykey = primaryKey;
		   PHXSQLService sqlService = new PHXSQLService();
		   PHXSQL mySQL = sqlService.readARow(primarykey);
		   return mySQL;
	   }

	   //Update a row given firstname, lastname, primary key
	   @GET
	   @Path("/update/{firstname}/{lastname}/{primaryKey}")
	   @Produces(MediaType.APPLICATION_JSON)
	   public PHXSQL updateARow(@PathParam("firstname") String firstName,@PathParam("lastname") String lastName, @PathParam("primaryKey") int primaryKey)			   
	   {
		 //Update the desired row - sqlService call
		   String firstname = firstName;
		   String lastname = lastName;
		   int primarykey = primaryKey;
		   PHXSQLService sqlService = new PHXSQLService();
		   PHXSQL mySQL = sqlService.updateARow(firstname,lastname,primarykey);
	      return mySQL;  
	   }

	   
	   //Delete a row given primary key.
	   @GET
	   @Path("/delete/{primaryKey}")
	   @Produces(MediaType.APPLICATION_JSON)
	   public PHXSQL deleteARow(@PathParam("primaryKey") int primaryKey)
	   {
		   //Delete the desired row...sqlService call.
	      return (PHXSQL) null;   
	   }
			  
	   
}
