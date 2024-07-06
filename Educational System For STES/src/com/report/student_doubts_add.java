package com.report;

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
import javax.servlet.http.HttpSession;

import com.connection.Dbconn;

/**
 * Servlet implementation class student_doubts_add
 */
@WebServlet("/student_doubts_add")
public class student_doubts_add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public student_doubts_add() {
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
		HttpSession session = request.getSession(true);
		PrintWriter pw = response.getWriter();
		String name = request.getParameter("txtName");
		String addres = request.getParameter("txtAddress");
		String Start_Time=request.getParameter("txttime");
		String emailid=(String)session.getAttribute("s_email");
		String mobileno=(String)session.getAttribute("contactno");
			try {
				Connection con = Dbconn.conn();
				Statement st3 = con.createStatement();
				
			    st3.executeUpdate("insert into tblstudent_doubts(SubjectNotices,MessageNotices,Start_Time,Student_email_id,Mobile_no) values('" + name
						+ "' , '" + addres + "','"+Start_Time+"','"+emailid+"','"+mobileno+"')");
			    pw.println("<html><script>alert('Save Doubts Successfully');</script><body>");
				pw.println("");
				pw.println("</body></html>");
				
			} catch (ClassNotFoundException e) {

				e.printStackTrace();
			} catch (SQLException e) {

				e.printStackTrace();
			}
			RequestDispatcher rd = request.getRequestDispatcher("/Student_doubtsPage.jsp");
			rd.include(request, response);
	
	}

}
