package org.acme;


import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

@Path("/labseq")
public class LabseqResource {

    @Inject
    ValueServiceImpl valuesService;

    @GET
    @Path("/{n}")
    @Operation(summary = "Get labseq value", description = "returns the value of the lab sequence")
    @APIResponse(responseCode = "200", description = "Labseq value")
    @APIResponse(responseCode = "400", description = "Inserted value invalid")
    public Long getN(@PathParam("n") int n)  {
        return valuesService.getValue(n);
    }
}
