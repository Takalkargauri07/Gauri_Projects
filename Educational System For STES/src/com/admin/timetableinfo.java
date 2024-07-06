package com.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
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
 * Servlet implementation class timetableinfo
 */
@WebServlet("/timetableinfo")
public class timetableinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public timetableinfo() {
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
		String dates = request.getParameter("txtdate");
		String txtSubject1 = request.getParameter("txtSubject1");
		String txtSubject2 = request.getParameter("txtSubject2");
		String txtSubject3 = request.getParameter("txtSubject3");
		String txtSubject4 = request.getParameter("txtSubject4");
		String txtSubject5 = request.getParameter("txtSubject5");
		String txtSubject6 = request.getParameter("txtSubject6");
		String txtSubject7 = request.getParameter("txtSubject7");
		//String txtSubject8 = request.getParameter("txtSubject8");
		String std_name=request.getParameter("sm");
		String Student_ID = null,Student_Name,Student_Email_ID;//,section_data = null;
		String section_data=request.getParameter("section_data");
		String state=request.getParameter("txtstate");
		String classname=request.getParameter("stdclass");
		System.out.println("LeveL=>"+state);
		
			try {
				Connection con = Dbconn.conn();
				
				Statement st1 = con.createStatement();
				Statement st2 = con.createStatement();
				Statement st3 = con.createStatement();
				Statement st4 = con.createStatement();
				Statement st5 = con.createStatement();
				Statement st6 = con.createStatement();
				Statement st7 = con.createStatement();
				Statement st8 = con.createStatement();
				Statement st9 = con.createStatement();
				ResultSet rs1 = st1.executeQuery("select * from studentdetails where classname='"+classname+"' and section_data='"+section_data+"'");

				while(rs1.next())
				{
					
					Student_ID=rs1.getString("id");
					Student_Name=rs1.getString("name");
					Student_Email_ID=rs1.getString("email");
					section_data=rs1.getString("section_data");
				}
			   if(state.equals("FE"))
			   {
//				   st3.executeUpdate("insert into tblpretimetable values('" + dates
//							+ "' , '" + txtSubject1 + "','"+txtSubject2+"','"+txtSubject3+"','"+txtSubject4+"','"+txtSubject5+"','"+txtSubject6+"','"+classname+"')");
				   st7.executeUpdate("insert into tblmastertime(Day,h1,h2,h3,h4,h5,h6,stdlevel,classname,section_data,id) values('" + dates
							+ "' , '" + txtSubject1 + "','"+txtSubject2+"','"+txtSubject3+"','"+txtSubject4+"','"+txtSubject5+"','"+txtSubject6+"','"+state.replace(" Class","")+"','"+classname+"','"+section_data+"','"+Student_ID+"')");
					

			   }
			   else if(state.equals("SE"))
			   {
//				   st4.executeUpdate("insert into tblpritimetable values('" + dates
//							+ "' , '" + txtSubject1 + "','"+txtSubject2+"','"+txtSubject3+"','"+txtSubject4+"','"+txtSubject5+"','"+txtSubject6+"','"+txtSubject7+"','"+classname+"')");
				   st8.executeUpdate("insert into tblmastertime(Day,h1,h2,h3,h4,h5,h6,h7,stdlevel,classname,section_data,id) values('" + dates
							+ "' , '" + txtSubject1 + "','"+txtSubject2+"','"+txtSubject3+"','"+txtSubject4+"','"+txtSubject5+"','"+txtSubject6+"','"+txtSubject7+"','"+state.replace(" Class","")+"','"+classname+"','"+section_data+"','"+Student_ID+"')");
					

			   }
			   else if(state.equals("TE"))
			   {
//				   st5.executeUpdate("insert into tblsectimetable values('" + dates
//							+ "' , '" + txtSubject1 + "','"+txtSubject2+"','"+txtSubject3+"','"+txtSubject4+"','"+txtSubject5+"','"+txtSubject6+"','"+classname+"')");
				   st9.executeUpdate("insert into tblmastertime(Day,h1,h2,h3,h4,h5,h6,stdlevel,classname,section_data,id) values('" + dates
							+ "' , '" + txtSubject1 + "','"+txtSubject2+"','"+txtSubject3+"','"+txtSubject4+"','"+txtSubject5+"','"+txtSubject6+"','"+state.replace(" Class","")+"','"+classname+"','"+section_data+"','"+Student_ID+"')");
					

			   }
			   else if(state.equals("BE"))
			   {
				   st9.executeUpdate("insert into tblmastertime(Day,h1,h2,h3,h4,h5,stdlevel,classname,section_data,id) values('" + dates
							+ "' , '" + txtSubject1 + "','"+txtSubject2+"','"+txtSubject3+"','"+txtSubject4+"','"+txtSubject5+"','"+state.replace(" Class","")+"','"+classname+"','"+section_data+"','"+Student_ID+"')");
						

			   }
			   
				
				
			    pw.println("<html><script>alert('Save Time Table  Successfully');</script><body>");
				pw.println("");
				pw.println("</body></html>");
				
			} catch (ClassNotFoundException e) {

				e.printStackTrace();
			} catch (SQLException e) {

				e.printStackTrace();
			}
			RequestDispatcher rd = request.getRequestDispatcher("/TimeTablePage.jsp");
			rd.include(request, response);
	}

}
