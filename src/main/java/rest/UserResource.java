/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.RentalArrangementDTO;
import dtos.UserDTO;
import entities.User;
import facades.UserFacade;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;
import utils.EMF_Creator;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 *
 * @author 45319
 */
@Path("user")
public class UserResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    private static final UserFacade UF = UserFacade.getUserFacade(EMF);
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    @Context
    private UriInfo context;

    @Context
    SecurityContext securityContext;

    public UserResource() {
    }
    
    //US 1
    @Path("conf")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllConferences() throws Exception{
        return Response.ok(gson.toJson(UF.getAllConferences()), MediaType.APPLICATION_JSON).build();
    }
     //US 2
    @Path("conf/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllTalksByGivenConference(@PathParam("id") Long id) throws Exception {
        return Response.ok(gson.toJson(UF.getAllTalksByGivenConference(id)), MediaType.APPLICATION_JSON).build();
    }
    
    //US 3
    @Path("speak/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllTalksByGivenSpeaker(@PathParam("id") Long id) throws Exception {
        return Response.ok(gson.toJson(UF.getAllTalksByGivenSpeaker(id)),MediaType.APPLICATION_JSON).build();            
    }
   

}
    

