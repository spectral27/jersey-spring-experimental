package individual;

import java.io.IOException;
import java.net.URI;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static String URL = "http://localhost:8080";

    public static ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
    
    public static void main(String[] args) throws IOException {
        ResourceConfig config = new ResourceConfig().packages("individual");
        HttpServer server = GrizzlyHttpServerFactory.createHttpServer(URI.create(URL), config);
        
        System.out.println("Jersey app started with endpoints available at: " + URL);
        System.out.println("Hit Ctrl-C to stop it.");
        
        System.in.read();
        
        server.shutdownNow();
    }

}
