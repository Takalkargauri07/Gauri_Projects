package com.report;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.connection.Dbconn;

/**
 * Servlet implementation class assignmentdata
 */
@WebServlet("/assignmentdata")
public class assignmentdata extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public assignmentdata() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String filename=request.getParameter("filenamedb");
		   int BUFFER_SIZE = 1024*100;
	Connection connection;
			try {
				connection = Dbconn.conn();
			
Statement statement = connection.createStatement();
ResultSet result1 =statement.executeQuery("select * from tblassignmentdata where fileName='"+filename+"' ") ; 
			if(result1.next())
				  {
		                // gets file name and file blob data
		                String fileName = result1.getString("FileName");
		                Blob blob = result1.getBlob("datafile");
		                InputStream inputStream = blob.getBinaryStream();
		                int fileLength = inputStream.available();
		                 
		                System.out.println("fileLength = " + fileLength);
		 
		                ServletContext context = getServletContext();
		 
		                // sets MIME type for the file download
		                String mimeType = context.getMimeType(fileName);
		                if (mimeType == null) {        
		                    mimeType = "application/octet-stream";
		                }              
		                 
		                // set content properties and header attributes for the response
		                response.setContentType(mimeType);
		                response.setContentLength(fileLength);
		                String headerKey = "Content-Disposition";
		                String headerValue = String.format("attachment; filename=\"%s\"", fileName);
		                response.setHeader(headerKey, headerValue);
		 
		                // writes the file to the client
		                OutputStream outStream = response.getOutputStream();
		                 
		                byte[] buffer = new byte[BUFFER_SIZE];
		                int bytesRead = -1;
		                 
		                while ((bytesRead = inputStream.read(buffer)) != -1) {
		                    outStream.write(buffer, 0, bytesRead);
		                }
		                 
		                inputStream.close();
		                outStream.close();             
		            } else {
		                // no file found
//		                response.getWriter().print("File not found for the id: " + fileName);  
		            }
			} catch (ClassNotFoundException e) {
				// 
				e.printStackTrace();
			} catch (SQLException e) {
				// 
				e.printStackTrace();
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
