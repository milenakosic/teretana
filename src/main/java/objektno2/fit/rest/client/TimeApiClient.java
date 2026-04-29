package objektno2.fit.rest.client;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import objektno2.fit.model.TimeApi;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

    @Path("/api/time/current")
    @RegisterRestClient(configKey = "timezone-api")
    public interface TimeApiClient {
        @GET
        @Path("/ip")
        @Produces(MediaType.APPLICATION_JSON)
        TimeApi getTimeZoneByIp(@QueryParam("ipAddress") String ipAdress);
    }
