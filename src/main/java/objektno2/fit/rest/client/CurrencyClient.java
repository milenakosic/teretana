package objektno2.fit.rest.client;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import objektno2.fit.model.CurrencyResponse;
import objektno2.fit.model.TimeApi;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/api")
@RegisterRestClient(configKey = "currency-api")
public interface CurrencyClient {
    @GET
    @Path("/rates")
    @Produces(MediaType.APPLICATION_JSON)
    CurrencyResponse getCurenncy(@QueryParam("from") String from, @QueryParam("to") String to);
}
