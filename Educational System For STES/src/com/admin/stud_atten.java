package com.admin;

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
import com.report.attendancemaster;

/**
 * Servlet implementation class stud_atten
 */
@WebServlet("/stud_atten")
public class stud_atten extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public stud_atten() {
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
		HttpSession session=request.getSession(true);
		
	   		
	   		String classname=request.getParameter("stdlevel");
		System.out.println("Class Name=>"+classname);
			try {
				Connection con = Dbconn.conn();
				Statement st3 = con.createStatement();
				int flag=0;
				String studname=null;
				ResultSet rs1 = st3.executeQuery("select * from studentdetails where  stdlevel='"+classname+"'");
				while(rs1.next())
				{
					studname=rs1.getString("name");
					String id=rs1.getString("id");
					flag=1;
					System.out.println(id);
					attendancemaster.createreport(id,classname,studname);
				}
				
				System.out.println("Flag=>"+flag);
			//	if(flag==1)
				{
					
					pw.println("<html><script>alert('Report Download Successfully');</script><body>");
					pw.println("");
					pw.println("</body></html>");
				}
				
				
			    
				
			}  catch (SQLException | ClassNotFoundException | ParseException e) {

				e.printStackTrace();
			}
		//	
				RequestDispatcher rd = request.getRequestDispatcher("/StudentAttendanceReport.jsp");
				rd.include(request, response);
	}

}
