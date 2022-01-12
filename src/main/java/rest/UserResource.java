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

    @Path("adduser")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public UserDTO createUser(UserDTO u) throws Exception {
        return UF.create(u);
    }

    @Path("addarrangement")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public UserDTO addRentalArrangement(RentalArrangementDTO raDTO) {
        System.out.println(raDTO);
        return UF.addRentalArrangement(raDTO);
    }
    
    @Path("{username}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllArrangementsWithGivenUsername(@PathParam("username") String username) throws Exception{
        return Response.ok(gson.toJson(UF.getAllArrangementsWithGivenUsername(username)), MediaType.APPLICATION_JSON).build();
    }
    
    @Path("userinfo/{username}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserByUsername(@PathParam("username") String username) throws Exception {
        UserDTO uDTO = UF.getUser(username);
        return Response.ok(gson.toJson(uDTO), MediaType.APPLICATION_JSON).build();
    }
    
    @Path("addfunds")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public UserDTO addBalance(UserDTO u) {
        return UF.addBalance(u);
    }
}
    

