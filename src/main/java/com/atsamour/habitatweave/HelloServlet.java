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


  private static final String DB_USERNAME = System.getenv("OPENSHIFT_MYSQL_DB_USERNAME");
  private static final String DB_PASSWORD = System.getenv("OPENSHIFT_MYSQL_DB_PASSWORD");
  private static final String DB_DATABASE = "mysql";
  private static final String DB_HOST = System.getenv("OPENSHIFT_MYSQL_DB_HOST");
  private static final String DB_PORT = System.getenv("OPENSHIFT_MYSQL_DB_PORT");

    protected void doGet(HttpServletRequest reqest, HttpServletResponse response)
            throws ServletException, IOException {
        ServletOutputStream out = response.getOutputStream();
        out.write("Hello from servlet".getBytes());
        out.write( ("\n " + DB_HOST + " " +DB_PORT) .getBytes());
        out.write("Hello from servlet".getBytes());
        out.write("Hello from servlet".getBytes());

        out.flush();
        out.close();
    }
    
}