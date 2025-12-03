package com.child1;

import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        Tomcat tomcat = new Tomcat();


        try {
            Context ctx = tomcat.addContext("",  null);
            Tomcat.addServlet( ctx, "helloServlet", new HelloServlet());


            ctx.addServletMappingDecoded("/hello", "helloServlet");
            tomcat.start();
            System.out.println("Tomcat started on port 8080");
            tomcat.getServer().await();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
