package ngdemo.phxswap.rest;

import ngdemo.phxswap.domain.PHXSWAP;
import ngdemo.phxswap.service.PHXSWAPService;
import ngdemo.service.HomeService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/swap")
public class PHXSWAPRestService {

	//I can't see why anybody would use this.
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public PHXSWAP getDefaultHomeInJSON() 
    {
        PHXSWAPService phxSwapService = new PHXSWAPService();
        return phxSwapService.getDefaultPHXSWAP();
    }
 
    //This is the one thing I know he wants for sure...read entire table with JDBC.
    //To make things visually consistent I left the default settings for Home object.
    //CGN
    @GET
    @Path("/readTable")
    @Produces(MediaType.APPLICATION_JSON)
    public PHXSWAP ReadSwapTable()
    {
        PHXSWAPService phxswapService = new PHXSWAPService();
	    phxswapService.getData();    	
	    
	    System.out.println("RETURNED PHXSWAP TABLE");
	    return (PHXSWAP) null;
    }
    
    @GET
    @Path("/create/{PackageName}/{CurrentVersion}")
    @Produces(MediaType.APPLICATION_JSON)
    public PHXSWAP createARow(@PathParam("PackageName") String PackageName,@PathParam("CurrentVersion") String CurrentVersion)
    {
    	
	    String packageName = PackageName;
		String currentVersion = CurrentVersion;
		PHXSWAPService phxswapService = new PHXSWAPService();
		//Home myHome = homeService.createARow(firstname,lastname);
		PHXSWAP myswap = phxswapService.createARow(packageName,currentVersion);
        return myswap;
    }
    
    @GET
    @Path("/read")
    @Produces(MediaType.APPLICATION_JSON)
    public PHXSWAP readARow()
    {
    	return (PHXSWAP) null;
    }
    
    @GET
    @Path("/update")
    @Produces(MediaType.APPLICATION_JSON)
    public PHXSWAP updateARow()
    {
    	return (PHXSWAP) null;
    }
    
    @GET
    @Path("/delete")
    @Produces(MediaType.APPLICATION_JSON)
    public PHXSWAP deleteARow()
    {
    	return (PHXSWAP) null;
    }    
    
}