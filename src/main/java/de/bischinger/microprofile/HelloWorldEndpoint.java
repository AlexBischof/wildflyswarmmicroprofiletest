package de.bischinger.microprofile;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.health.Health;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Timed;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.Response.ok;

@Health
@Counted(name="HelloMetric",displayName = "helloMetric", absolute = true)
@Path("/hello")
public class HelloWorldEndpoint {

 @Inject
 @ConfigProperty(name="my.long.property", defaultValue = "123")
 Long injectedLongValue;

  @GET
  @Produces("text/plain")
  @Counted(name="HelloMetric2",displayName = "helloMetric2", absolute = true)
  @Timed
  public Response doGet() {
    return ok("Hello from WildFly Swarm!:" + injectedLongValue).build();
  }
}