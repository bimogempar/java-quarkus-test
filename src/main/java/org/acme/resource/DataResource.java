package org.acme.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.acme.service.ExternalApiService;

@Path("/data")
public class DataResource {

    @Inject
    ExternalApiService externalApiService;

    @GET
    @Path("/fetch")
    @Produces(MediaType.APPLICATION_JSON)
    public String fetchData() {
        externalApiService.fetchAndProcessData();
        return "{\"status\": \"success\"}";
    }
}