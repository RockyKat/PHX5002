package ngdemo.rest;

import ngdemo.domain.Home;
import ngdemo.domain.SQL;
import ngdemo.mysql.DBConnectSwap;
import ngdemo.mysql.service.SQLService;
import ngdemo.service.HomeService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/home")
public class HomeRestService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Home getDefaultHomeInJSON() 
    {
        HomeService homeService = new HomeService();
        return homeService.getDefaultHome();
    }
 
    //This is the one thing I know he wants for sure...read entire table with JDBC.
    //To make things visually consistent I left the default settings for Home object.
    //CGN
    @GET
    @Path("/readTable")
    @Produces(MediaType.APPLICATION_JSON)
    public Home ReadSwapTable()
    {
        HomeService homeService = new HomeService();
    	DBConnectSwap connect = new DBConnectSwap();
	    connect.getData();    	
	    
	    Home mia = homeService.getDefaultHome();
	    System.out.println("Returned mia");
	    return mia;
    }
    
    @GET
    @Path("/create/{varX}/{varY}")
    @Produces(MediaType.APPLICATION_JSON)
    public Home createARow(@PathParam("varX") String firstName,@PathParam("varY") String lastName)
    {
    	
	    String lastname = lastName;
		String firstname = firstName;
		HomeService homeService = new HomeService();
		//Home myHome = homeService.createARow(firstname,lastname);
        //return myHome;
		return (Home) null;
    }
    
    @GET
    @Path("/read")
    @Produces(MediaType.APPLICATION_JSON)
    public Home readARow()
    {
    	return (Home) null;
    }
    
    @GET
    @Path("/update")
    @Produces(MediaType.APPLICATION_JSON)
    public Home updateARow()
    {
    	return (Home) null;
    }
    
    @GET
    @Path("/delete")
    @Produces(MediaType.APPLICATION_JSON)
    public Home deleteARow()
    {
    	return (Home) null;
    }    
    
}