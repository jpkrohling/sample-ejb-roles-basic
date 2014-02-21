package org.sample.ejb.basic;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/endpoint")
@Stateless
public class Endpoint {

    @Inject
    HttpServletRequest request;

    @Resource
    SessionContext sc;

    @GET
    public Response get() {
        /**
         [0m17:57:55,298 INFO  [stdout] (default task-4) Principal's name according to EJB: quickstartUser
         [0m[0m17:57:55,299 INFO  [stdout] (default task-4) Principal's name according to Servlet: quickstartUser
         [0m[0m17:57:55,299 INFO  [stdout] (default task-4) Is user in role 'guest'? true
         [0m[0m17:57:55,299 INFO  [stdout] (default task-4) Is user in role 'app-user'? false
         */
        System.out.println("Principal's name according to EJB: " + sc.getCallerPrincipal().getName());
        System.out.println("Principal's name according to Servlet: " + request.getUserPrincipal().getName());
        System.out.println("Is user in role 'guest'? " + request.isUserInRole("guest"));
        System.out.println("Is user in role 'app-user'? " + request.isUserInRole("app-user"));
        return Response.ok().build();
    }

}
