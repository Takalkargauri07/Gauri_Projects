package com.teacher;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.connection.Dbconn;

/**
 * Servlet implementation class attendancesave
 */
@WebServlet("/attendancesave")
public class attendancesave extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static String msg1, msg2, msg3, msg4, msg5, msg6, msg7;
	public static String t1, t2, t3, t4, t5, t6, t7;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public attendancesave() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// HttpSession session=request.getSession(true);
		try {
			String levelname = request.getParameter("txtstd_num");

			t1 = request.getParameter("Checkbox1");
			t2 = request.getParameter("Checkbox2");
			t3 = request.getParameter("Checkbox3");
			t4 = request.getParameter("Checkbox4");
			t5 = request.getParameter("Checkbox5");
			t6 = request.getParameter("Checkbox6");
			t7 = request.getParameter("Checkbox7");
			HttpSession session = request.getSession(true);
			String teacheremailid = (String) session.getAttribute("email");
			//String txtid = request.getParameter("txtid");
			String txtid = request.getParameter("txtid");
			String Studentclass = request.getParameter("Student_ID");
			String Studentsection = request.getParameter("Studentsection");
			String txtdate = request.getParameter("txtdate");
			System.out.println("Studentclass=>" + Studentclass);
			//System.out.println("id=>" + txtid);
			System.out.println("levelname=>" + levelname);
			System.out.println("Studentsection=>" + Studentsection);

			Date day = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			String dates = formatter.format(day);
			Connection con = Dbconn.conn();
			Statement st7 = con.createStatement();
			Statement st8 = con.createStatement();
			Statement st9 = con.createStatement();
			if (levelname.equals("FE")) {
				
				
			//	for (String txtid : userID)
				{
					
					String[] S1 = request.getParameterValues("txtid");
					String[] S2 = request.getParameterValues("txtid");
					String[] S3 = request.getParameterValues("txtid");
					String[] S4 = request.getParameterValues("txtid");
					String[] S5 = request.getParameterValues("txtid");
					String[] S6 = request.getParameterValues("txtid");
					for (String sub1 : S1)
					{
						if (sub1 == null || sub1.isEmpty()) {
							msg1 = "No";

						} else {
							msg1 = "Yes";
						}
						
					}
					for (String sub2 : S2)
					{
						//
						if (sub2 == null || sub2.isEmpty()) {
							msg2 = "No";

						} else {
							msg2 = "Yes";
						}
						
					}
					for (String sub3 : S3){
						// 3
						if (sub3 == null || sub3.isEmpty()) {
							msg3 = "No";

						} else {
							msg3 = "Yes";
						}
						
					}
					for (String sub4 : S4){
						// 4
						if (sub4 == null || sub4.isEmpty()) {
							msg4 = "No";

						} else {
							msg4 = "Yes";
						}
						
					}
					for (String sub5 : S5){
						// 5
						if (sub5 == null || sub5.isEmpty()) {
							msg5 = "No";

						} else {
							msg5 = "Yes";
						}
						
					}
					for (String sub6 : S6)
					{
						if (sub6 == null || sub6.isEmpty()) {
							msg6 = "No";

						} else {
							msg6 = "Yes";
						}
					}
					
					
					
				st7.executeUpdate("insert into tblmasterattendance(Day,h1,h2,h3,h4,h5,h6,stdlevel,classname,section_data,id,teacheremailid,Day_Name) values('"
						+ dates
						+ "' , '"
						+ msg1
						+ "','"
						+ msg2
						+ "','"
						+ msg3
						+ "','"
						+ msg4
						+ "','"
						+ msg5
						+ "','"
						+ msg6
						+ "','"
						+ levelname
						+ "','"
						+ Studentclass
						+ "','"
						+ Studentsection
						+ "','"
						+ txtid
						+ "','"
						+ teacheremailid
						+ "','"
						+ txtdate
						+ "')");
				}

			} else if (levelname.equals("SE")) {
				if (t1 == null || t1.isEmpty()) {
					msg1 = "No";

				} else {
					msg1 = "Yes";
				}
				//
				if (t2 == null || t2.isEmpty()) {
					msg2 = "No";

				} else {
					msg2 = "Yes";
				}
				// 3
				if (t3 == null || t3.isEmpty()) {
					msg3 = "No";

				} else {
					msg3 = "Yes";
				}
				// 4
				if (t4 == null || t4.isEmpty()) {
					msg4 = "No";

				} else {
					msg4 = "Yes";
				}
				// 5
				if (t5 == null || t5.isEmpty()) {
					msg5 = "No";

				} else {
					msg5 = "Yes";
				}
				// 6
				if (t6 == null || t6.isEmpty()) {
					msg6 = "No";

				} else {
					msg6 = "Yes";
				}
				// 7
				if (t7 == null || t7.isEmpty()) {
					msg7 = "No";

				} else {
					msg7 = "Yes";
				}
				//for (String txtid : userID) 
				{
				st8.executeUpdate("insert into tblmasterattendance(Day,h1,h2,h3,h4,h5,h6,h7,stdlevel,classname,section_data,id,teacheremailid,Day_Name) values('"
						+ dates
						+ "' , '"
						+ msg1
						+ "','"
						+ msg2
						+ "','"
						+ msg3
						+ "','"
						+ msg4
						+ "','"
						+ msg5
						+ "','"
						+ msg6
						+ "','"
						+ msg7
						+ "','"
						+ levelname
						+ "','"
						+ Studentclass
						+ "','"
						+ Studentsection
						+ "','"
						+ txtid
						+ "','"
						+ teacheremailid + "','" + txtdate + "')");
				}

			} else if (levelname.equals("TE")) {
				if (t1 == null || t1.isEmpty()) {
					msg1 = "No";

				} else {
					msg1 = "Yes";
				}
				//
				if (t2 == null || t2.isEmpty()) {
					msg2 = "No";

				} else {
					msg2 = "Yes";
				}
				// 3
				if (t3 == null || t3.isEmpty()) {
					msg3 = "No";

				} else {
					msg3 = "Yes";
				}
				// 4
				if (t4 == null || t4.isEmpty()) {
					msg4 = "No";

				} else {
					msg4 = "Yes";
				}
				// 5
				if (t5 == null || t5.isEmpty()) {
					msg5 = "No";

				} else {
					msg5 = "Yes";
				}
				// 6
				if (t6 == null || t6.isEmpty()) {
					msg6 = "No";

				} else {
					msg6 = "Yes";
				}
				//for (String txtid : userID)
				{
				st9.executeUpdate("insert into tblmasterattendance(Day,h1,h2,h3,h4,h5,h6,stdlevel,classname,section_data,id,teacheremailid,Day_Name) values('"
						+ dates
						+ "' , '"
						+ msg1
						+ "','"
						+ msg2
						+ "','"
						+ msg3
						+ "','"
						+ msg4
						+ "','"
						+ msg5
						+ "','"
						+ msg6
						+ "','"
						+ levelname
						+ "','"
						+ Studentclass
						+ "','"
						+ Studentsection
						+ "','"
						+ txtid
						+ "','"
						+ teacheremailid + "','" + txtdate + "')");
				}

			} else if (levelname.equals("BE")) {
				if (t1 == null || t1.isEmpty()) {
					msg1 = "No";

				} else {
					msg1 = "Yes";
				}
				//
				if (t2 == null || t2.isEmpty()) {
					msg2 = "No";

				} else {
					msg2 = "Yes";
				}
				// 3
				if (t3 == null || t3.isEmpty()) {
					msg3 = "No";

				} else {
					msg3 = "Yes";
				}
				// 4
				if (t4 == null || t4.isEmpty()) {
					msg4 = "No";

				} else {
					msg4 = "Yes";
				}
				// 5
				if (t5 == null || t5.isEmpty()) {
					msg5 = "No";

				} else {
					msg5 = "Yes";
				}
				// 6
				if (t6 == null || t6.isEmpty()) {
					msg6 = "No";

				} else {
					msg6 = "Yes";
				}
				//for (String txtid : userID)
				{
				st9.executeUpdate("insert into tblmasterattendance(Day,h1,h2,h3,h4,h5,h6,stdlevel,classname,section_data,id,teacheremailid,Day_Name) values('"
						+ dates
						+ "' , '"
						+ msg1
						+ "','"
						+ msg2
						+ "','"
						+ msg3
						+ "','"
						+ msg4
						+ "','"
						+ msg5
						+ "','"
						+ msg6
						+ "','"
						+ levelname
						+ "','"
						+ Studentclass
						+ "','"
						+ Studentsection
						+ "','"
						+ txtid
						+ "','"
						+ teacheremailid + "','" + txtdate + "')");
				}

			} else {
				System.out.println("a");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		RequestDispatcher rd = request
				.getRequestDispatcher("/T_AttendanceReportPage.jsp");
		rd.include(request, response);
	}

}
