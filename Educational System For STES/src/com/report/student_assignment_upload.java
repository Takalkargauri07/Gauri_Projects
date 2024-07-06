package com.report;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.connection.Dbconn;

/**
 * Servlet implementation class student_assignment_upload
 */
@WebServlet("/student_assignment_upload")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
maxFileSize = 1024 * 1024 * 10, // 10MB
maxRequestSize = 1024 * 1024 * 50)
public class student_assignment_upload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public student_assignment_upload() {
        super();
        // TODO Auto-generated constructor stub
    }
    String getFileName(Part filePart) {
		for (String cd : filePart.getHeader("content-disposition").split(";")) {
			if (cd.trim().startsWith("filename")) {
				String fileName = cd.substring(cd.indexOf('=') + 1).trim()
						.replace("\"", "");
				return fileName.substring(fileName.lastIndexOf('/') + 1)
						.substring(fileName.lastIndexOf('\\') + 1);
				// return cd.substring(cd.indexOf('=') + 1).trim().replace("\"",
				// "") ;
			}

		}
		return null;

	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		HttpSession session = request.getSession(true);
		InputStream inputStream = null;
		Connection con;
		String id=request.getParameter("transactionid");
		Part filePart = request.getPart("txt_search");
		String txtsection=request.getParameter("txtsection");
		String txtSubject1=request.getParameter("txtSubject1");
		String stdname=request.getParameter("txtname");
		String semailid=(String)session.getAttribute("s_email");
		String fileName = getFileName(filePart);
		inputStream = filePart.getInputStream();
		System.out.print("File" + filePart);
		System.out.print("\nFileName:-" + fileName);
	
		
		try {
			con = Dbconn.conn();
			
			String sql = "INSERT INTO tblstudent_assignmentdata values (?,?,?,?,?,?,?)";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, id);
			statement.setString(2, txtSubject1);
			statement.setString(3, fileName);
			statement.setBlob(4, inputStream);
			statement.setString(5, stdname);
			statement.setString(6,txtsection);
			statement.setString(7,semailid);
			statement.executeUpdate();
			
			pw.println("<html><script>alert('File Uploaded Sucessfully');</script><body>");
			pw.println("");
			pw.println("</body></html>");
			RequestDispatcher rd = request
					.getRequestDispatcher("/Student_Assignment_Upload.jsp");
			rd.include(request, response);

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
