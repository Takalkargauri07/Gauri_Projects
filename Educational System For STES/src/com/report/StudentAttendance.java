package com.report;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.connection.Dbconn;

/**
 * Servlet implementation class StudentAttendance
 */
@WebServlet("/StudentAttendance")
public class StudentAttendance extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentAttendance() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		HttpSession session=request.getSession(true);
		
	   		String id=(String)session.getAttribute("std_id");
	   		String classname=(String)session.getAttribute("stdlevel");
		System.out.println("Class Name=>"+classname+"\tID=>"+id);
			try {
				Connection con = Dbconn.conn();
				Statement st3 = con.createStatement();
				int flag=0;
				String studname=null;
				ResultSet rs1 = st3.executeQuery("select * from studentdetails where  id='"+id+"'");
				if(rs1.next())
				{
					studname=rs1.getString("name");
					flag=1;
				}
				else
				{
					flag=0;
					
				}
				System.out.println("Flag=>"+flag);
				if(flag==1)
				{
					attendancemaster.createreport(id,classname,studname);
					pw.println("<html><script>alert('Report Download Successfully');</script><body>");
					pw.println("");
					pw.println("</body></html>");
				}
				else
				{
					pw.println("<html><script>alert('Wrong Student ID and Std');</script><body>");
					pw.println("");
					pw.println("</body></html>");
				}
				
			    
				
			}  catch (SQLException | ClassNotFoundException | ParseException e) {

				e.printStackTrace();
			}
		//	HttpSession session=request.getSession(true);
			String msg=(String)session.getAttribute("msg");//, "TeacherInfo");
			System.out.println("Msg=>"+msg);
			if(msg.equals("TeacherInfo"))
			{
				RequestDispatcher rd = request.getRequestDispatcher("/TStudentAttendanceReport.jsp");
				rd.include(request, response);
				
			}
			else if(msg.equals("UserInfo"))
			{
				
				RequestDispatcher rd = request.getRequestDispatcher("/SHomePage.jsp");
				rd.include(request, response);
			}
			else
			{
				RequestDispatcher rd = request.getRequestDispatcher("/StudentAttendanceReport.jsp");
				rd.include(request, response);
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		String classname = request.getParameter("sm2a");
		String id = request.getParameter("sm");
		String section=request.getParameter("sectionmsg");
		HttpSession session=request.getSession(true);
		System.out.println("Class Name=>"+classname+"ID=>"+id);
			try {
				Connection con = Dbconn.conn();
				Statement st3 = con.createStatement();
				int flag=0;
				String studname=null;
				ResultSet rs1 = st3.executeQuery("select * from studentdetails where  id='"+id+"'");
				if(rs1.next())
				{
					studname=rs1.getString("name");
					flag=1;
				}
				else
				{
					flag=0;
					
				}
				System.out.println("Flag=>"+flag);
				if(flag==1)
				{
					attendancemaster.createreport(id,classname,studname);
					pw.println("<html><script>alert('Report Download Successfully');</script><body>");
					pw.println("");
					pw.println("</body></html>");
				}
				else
				{
					pw.println("<html><script>alert('Wrong Student ID and Std');</script><body>");
					pw.println("");
					pw.println("</body></html>");
				}
				
			    
				
			}  catch (SQLException | ClassNotFoundException | ParseException e) {

				e.printStackTrace();
			}
		//	HttpSession session=request.getSession(true);
			String msg=(String)session.getAttribute("msg");//, "TeacherInfo");
			if(msg.equals("TeacherInfo"))
			{
				RequestDispatcher rd = request.getRequestDispatcher("/TStudentAttendanceReport.jsp");
				rd.include(request, response);
				
			}
			else if(msg.equals("UserInfo"))
			{
				
				RequestDispatcher rd = request.getRequestDispatcher("/S_StudentAttendanceReport.jsp");
				rd.include(request, response);
			}
			else
			{
				RequestDispatcher rd = request.getRequestDispatcher("/StudentAttendanceReport.jsp");
				rd.include(request, response);
			}
			
	}

}
