package objektno2.fit.resource;

import objektno2.fit.model.GrupniTrening;
import objektno2.fit.service.GrupniTreningService;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/grupniTrening")
public class GrupniTreningResource {

    @Inject
    private GrupniTreningService grupniTreningService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/add")
    public Response addGrupniTrening(GrupniTrening grupniTrening) {
        try {
            grupniTreningService.createGrupniTrening(grupniTrening);
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(e.getMessage())
                    .build();
        }
        return Response.ok().build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getAll")
    public Response getAllGrupniTreninzi() {
        try {
            List<GrupniTrening> treninzi = grupniTreningService.getAllGrupniTreninzi();
            return Response.ok(treninzi).build();
        } catch (Exception e) {
            return Response.status(Response.Status.NO_CONTENT)
                    .entity(e.getMessage())
                    .build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/findByNaziv")
    public Response findByNaziv(@QueryParam("naziv") String naziv) {
        if (naziv == null || naziv.isEmpty()) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Naziv nije proslijeđen")
                    .build();
        }
        try {
            List<GrupniTrening> treninzi = grupniTreningService.findByNaziv(naziv);
            return Response.ok(treninzi).build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(e.getMessage())
                    .build();
        }
    }
}