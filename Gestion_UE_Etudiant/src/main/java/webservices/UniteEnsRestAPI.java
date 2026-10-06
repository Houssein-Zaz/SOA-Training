package webservices;

import entities.UniteEnseignement;
import metiers.UniteEnseignementBusiness;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/ue")
public class UniteEnsRestAPI {

    static UniteEnseignementBusiness helper =new UniteEnseignementBusiness();
    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    //getListUES
    public Response getListUe(){
        return  Response.status(200)
                .entity(helper.getListeUE())
                .build();

    }
    @Path("/add")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response addUniteEnseignement(UniteEnseignement ue){
        if (helper.addUniteEnseignement(ue))

        {
            return Response.status(201).entity("succes").build();
        }
        else{
            return Response.status(400).entity("erreur").build();
        }
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{code}")
    public Response getUEByCode(@PathParam("code") int code){
        return Response.status(200).entity(helper.getUEByCode(code)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/")
    public Response getUEBySemestre(@QueryParam("semsetre") int semsetre){
        return Response.status(200).entity(helper.getUEBySemestre(semsetre)).build();
    }

    @DELETE
    @Path("/{code}")
    public Response deleteUniteEnseignement(@PathParam("code") int code){
        return Response.status(200).entity(helper.deleteUniteEnseignement(code)).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{code}")
    public Response updateUniteEnseignement(@PathParam("code") int code, UniteEnseignement updatedUE){
        return Response.status(200).entity(helper.updateUniteEnseignement(code,updatedUE)).build();

    }


    }

