package individual;

import java.util.List;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/records")
public class Controller {

    private RecordsService service = Main.context.getBean("bean", RecordsService.class);
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Record> get() {
        return service.getRecords();
    }

}
