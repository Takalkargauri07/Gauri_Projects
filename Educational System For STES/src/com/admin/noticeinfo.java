package com.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.connection.Dbconn;

/**
 * Servlet implementation class noticeinfo
 */
@WebServlet("/noticeinfo")
public class noticeinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public noticeinfo() {
        super();
        // TODO Auto-generated constructor stub
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
		String name = request.getParameter("txtName");
		String addres = request.getParameter("txtAddress");
		String End_Date=request.getParameter("txtend");
		String Start_Time=request.getParameter("txttime");
			try {
				Connection con = Dbconn.conn();
				Statement st3 = con.createStatement();
				
			    st3.executeUpdate("insert into tblnotices(SubjectNotices,MessageNotices,Start_Time,End_Date) values('" + name
						+ "' , '" + addres + "','"+Start_Time+"','"+End_Date+"')");
			    pw.println("<html><script>alert('Save Notices Successfully');</script><body>");
				pw.println("");
				pw.println("</body></html>");
				
			} catch (ClassNotFoundException e) {

				e.printStackTrace();
			} catch (SQLException e) {

				e.printStackTrace();
			}
			RequestDispatcher rd = request.getRequestDispatcher("/NoticesPage.jsp");
			rd.include(request, response);
	}

}
