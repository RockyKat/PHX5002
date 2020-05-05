//Calls the Service class to do the real work
package ngdemo.drooltest.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ngdemo.drooltest.domain.DroolObject;
import ngdemo.drooltest.service.DroolObjectService;



@Path("/drool")
public class DroolObjectRestService {
	
	
    @GET
	@Path("/demo")
    @Produces(MediaType.APPLICATION_JSON)
    public DroolObject getDefaultSQLInJSON() 
    {
       DroolObjectService droolService = new DroolObjectService();
       droolService.executeDrools();
    	
       return (DroolObject) null;
    }
			
	
}