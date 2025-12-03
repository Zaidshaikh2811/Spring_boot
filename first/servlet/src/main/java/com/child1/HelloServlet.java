package com.child1;

import javax.servlet.http.HttpServlet;

public class HelloServlet extends HttpServlet {
 public void service(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) {
  try {
   response.setContentType("text/html");
    response.setCharacterEncoding("UTF-8");

   response.getWriter().println("<!DOCTYPE html>" +
           "<html lang=\"en\">" +
           "<head>" +
              "<meta charset=\"UTF-8\">" +
                "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">" +
                "<title>Hello Servlet</title>" +
              "</head>" +
                "<body>" +
                    "<h1>Hello, World!</h1>" +
                    "<p>This is a simple servlet response.</p>" +
                    "<p>Current time: " + java.time.LocalTime.now() + "</p>" +
                    "<p>Current date: " + java.time.LocalDate.now() + "</p>" +
                    "<p>Current date and time: " + java.time.LocalDateTime.now() + "</p>" +
                    "<p>Current timestamp: " + java.time.Instant.now() + "</p>" +
                    "<p>Current date and time with zone: " + java.time.ZonedDateTime.now() + "</p>" +
                    "<p>Current date and time with offset: " + java.time.OffsetDateTime.now() + "</p>" +
                    "<p>Current date and time with offset from UTC: " + java.time.OffsetTime.now() + "</p>" +
                    "<p>Current date and time with zone ID: " + java.time.ZonedDateTime.now(java.time.ZoneId.systemDefault()) + "</p>" +
                    "<p>Current date and time with zone offset: " + java.time.ZonedDateTime.now(java.time.ZoneOffset.UTC) + "</p>" +
                    "<p>Current date and time with custom zone: " + java.time.ZonedDateTime.now(java.time.ZoneId.of("America/New_York")) + "</p>" +
                    "<p>Current date and time with custom offset: " + java.time.OffsetDateTime.now(java.time.ZoneOffset.of("-05:00")) + "</p>" +
                    "<p>Current date and time with custom zone ID: " + java.time.ZonedDateTime.now(java.time.ZoneId.of("Europe/London")) + "</p>" +
                    "<p>Current date and time with custom zone offset: " + java.time.ZonedDateTime.now(java.time.ZoneOffset.of("+01:00")) + "</p>" +
                    "<p>Current date and time with custom zone ID and offset: " + java.time.ZonedDateTime.now(java.time.ZoneId.of("Asia/Tokyo")) + "</p>"



           );
  } catch (java.io.IOException e) {
   e.printStackTrace();
  }
 }

}
