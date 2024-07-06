package com.teacher;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.connection.Dbconn;

/**
 * Servlet implementation class fileupload
 */
@WebServlet("/fileupload")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
maxFileSize = 1024 * 1024 * 10, // 10MB
maxRequestSize = 1024 * 1024 * 50)
public class fileupload extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static String data = null;
	public static String ContentType = null;
	public static String fileName = null,strOriginal;
	public static long size;
	File finalpath;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public fileupload() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		InputStream inputStream = null;
		Connection con;
		String id=request.getParameter("transactionid");
		Part filePart = request.getPart("txt_search");
		String txtsection=request.getParameter("txtsection");
		String txtSubject1=request.getParameter("txtSubject1");
		String stdname=request.getParameter("txtname");
		fileName = getFileName(filePart);
		size = filePart.getSize();
		ContentType = filePart.getContentType();
		inputStream = filePart.getInputStream();
		System.out.print("File" + filePart);
		System.out.print("\nFileName:-" + fileName);
		System.out.print("\nFileSize:-" + size);
		System.out.println("\nFileContentType:-" + ContentType);
		
		try {
			con = Dbconn.conn();
			
			String sql = "INSERT INTO tblassignmentdata values (?,?,?,?,?,?)";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, id);
			statement.setString(2, txtSubject1);
			statement.setString(3, fileName);
			statement.setBlob(4, inputStream);
			statement.setString(5, stdname);
			statement.setString(6,txtsection);
			statement.executeUpdate();
			
			pw.println("<html><script>alert('File Uploaded Sucessfully');</script><body>");
			pw.println("");
			pw.println("</body></html>");
			RequestDispatcher rd = request
					.getRequestDispatcher("/QUploadPage.jsp");
			rd.include(request, response);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
