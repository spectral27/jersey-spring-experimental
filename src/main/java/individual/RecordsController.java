package individual;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
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

    

}
