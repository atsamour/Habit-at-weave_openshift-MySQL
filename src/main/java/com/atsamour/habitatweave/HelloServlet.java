package com.atsamour.habitatweave;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet(
        name = "MyServlet", 
        urlPatterns = {"/hello"}
    )
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest reqest, HttpServletResponse response)
            throws ServletException, IOException {
        ServletOutputStream out = response.getOutputStream();

   String DB_USERNAME = System.getenv("OPENSHIFT_MYSQL_DB_USERNAME");
 String DB_PASSWORD = System.getenv("OPENSHIFT_MYSQL_DB_PASSWORD");
  String DB_HOST = System.getenv("OPENSHIFT_MYSQL_DB_HOST");
  String DB_PORT = System.getenv("OPENSHIFT_MYSQL_DB_PORT");
        out.write("Hello from servlet".getBytes());
        out.write( ("\n " + DB_HOST + " " +DB_PORT +" "+DB_USERNAME+" "+DB_PASSWORD) .getBytes());
        out.write("Hello from servlet".getBytes());
        out.write("Hello from servlet".getBytes());

        out.flush();
        out.close();
    }
    
}