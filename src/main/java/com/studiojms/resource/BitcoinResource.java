package com.studiojms.resource;

import com.studiojms.model.Bitcoin;
import com.studiojms.service.IBitcoinService;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/bitcoin")
public class BitcoinResource {

    @Inject
    @RestClient
    private IBitcoinService bitcoinService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Bitcoin> list() {
        return bitcoinService.list();
    }
}
