/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groupfbank_json;

import com.kryptag.rabbitmqconnector.MessageClasses.LoanResponse;
import com.kryptag.rabbitmqconnector.RMQConnection;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Plamen
 */
@Path("api")
public class RestService {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public RestService() {
        
    }
    
    
    @Path("/entrypoint")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    public void getRequestJson() {
//        BankMessage bankmessage = response.fromGson(request);
//        bankmessage to loan response?
        RMQConnection rmqCon = new RMQConnection("guest", "guest", "datdb.cphbusiness.dk", 5672, "hello");
        LoanResponse responsemessage = new LoanResponse((float) 4.092,"ssn");
        rmqCon.createConnection();
        //convert response to string
//        rmqCon.sendMessage(responsemessage);
        
    }

    /**
     * Retrieves representation of an instance of groupfbank_json.RestService
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of RestService
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
}
