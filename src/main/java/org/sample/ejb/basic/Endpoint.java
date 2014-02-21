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
         [0m[0m17:53:41,513 INFO  [stdout] (default task-12) Principal's name according to EJB: anonymous
         [0m[0m17:53:41,514 INFO  [stdout] (default task-12) Principal's name according to Servlet: jpkrohling
         [0m[0m17:53:41,514 INFO  [stdout] (default task-12) Is user in role 'user'? true
         [0m[0m17:53:41,514 INFO  [stdout] (default task-12) Is user in role 'admin'? false
         */
        System.out.println("Principal's name according to EJB: " + sc.getCallerPrincipal().getName());
        System.out.println("Principal's name according to Servlet: " + request.getUserPrincipal().getName());
        System.out.println("Is user in role 'user'? " + request.isUserInRole("user"));
        System.out.println("Is user in role 'admin'? " + request.isUserInRole("admin"));
        return Response.ok().build();
    }

}
