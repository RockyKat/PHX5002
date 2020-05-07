package ngdemo.rest;

import ngdemo.domain.SQL;
import ngdemo.service.SQLService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

//I'm putting all of my testing of CRUD in here because I don't want to mess
//with front end via C instructions.
//I'll normalize things with him Tuesday.
@Path("/sql")
public class SQLRestService {


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public SQL getDefaultSQLInJSON() 
    {
        SQLService sqlService = new SQLService();
      
        SQL mia = sqlService.getDefaultSQL();
        System.out.println("Returned mia");
        return mia;
    }
}
