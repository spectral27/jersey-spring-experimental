package individual;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/records")
public class RecordsController {

    private RecordsService service = Main.context.getBean("recordsService", RecordsService.class);
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get() {
        try {
            return Response.status(Status.OK).entity(service.getRecords()).build();
        } catch (IOException e) {
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            e.printStackTrace(printWriter);
            String stackTraceString = stringWriter.toString();
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity(stackTraceString).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insert(Record record) {
        try {
            service.insertRecord(record);
            return Response.status(Status.OK).build();
        } catch (IOException e) {
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            e.printStackTrace(printWriter);
            String stackTraceString = stringWriter.toString();
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity(stackTraceString).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") String id) {
        try {
            service.deleteRecord(id);
            return Response.status(Status.OK).build();
        } catch (IOException e) {
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            e.printStackTrace(printWriter);
            String stackTraceString = stringWriter.toString();
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity(stackTraceString).build();
        }
    }

}
