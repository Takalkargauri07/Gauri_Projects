package com.userinfo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.connection.Dbconn;

/**
 * Servlet implementation class StudentRegister
 */
@WebServlet("/StudentRegister")
public class StudentRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	public String OTPData() {
		StringBuilder ss = new StringBuilder();
		String numbers = "1234567890";
	      Random random = new Random();
	      char[] otp = new char[6];

	      for(int i = 0; i< 6 ; i++) {
	         otp[i] = numbers.charAt(random.nextInt(numbers.length()));
	         ss.append(otp[i]);
	      }

		return ss.toString();

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		HttpSession session = request.getSession(true);
		String name = request.getParameter("txtName");
		session.setAttribute("Rname", name);
		String addres = request.getParameter("txtAddress");
		session.setAttribute("Raddres", addres);
		String email = request.getParameter("txtEmail");
		session.setAttribute("Remail", email);
		String gender = request.getParameter("rdoGender");
		session.setAttribute("Rgender", gender);
		String pwwd = request.getParameter("passPassword");
		session.setAttribute("Rpwwd", pwwd);
		String cntct = request.getParameter("txtContact");
		session.setAttribute("Rcntct", cntct);
		String uname=request.getParameter("rdo1");
		session.setAttribute("Runame", uname);
		String stdnumber=request.getParameter("stdlevel");
		session.setAttribute("Rstdnumber", stdnumber);
		String stdclass=request.getParameter("stdclass");
		session.setAttribute("Rstdclass", stdclass);
		String section_data=request.getParameter("section_data");
		session.setAttribute("Rsection_data", section_data);
//		String subject=request.getParameter("txtsubject");
//		session.setAttribute("Rtxtsubject", subject);
		System.out.println(uname);
		try {
			Connection con = Dbconn.conn();
			Statement st1 = con.createStatement();
			Statement st3 = con.createStatement();
			st3.executeUpdate("TRUNCATE table tblotp");
//			if (uname.equals("UserInfo"))
//			{
				st3.executeUpdate("insert into studentdetails(name,addr,gender,email,contactno,pwd,stdlevel,classname,section_data) values('" + name
						+ "' , '" + addres + "'  , '" + gender + "' , '" + email
						+ "' ," + cntct + " , '" + pwwd
						+ "','"+stdnumber.replace(" Class","")+"','"+stdclass+"','"+section_data+"')");
			
//			}
//			else if (uname.equals("TeacherInfo"))
//			{
//				st3.executeUpdate("insert into teacherdetails(name,addr,gender,email,contactno,pwd,stdlevel,classname,section_data,Subject_name) values('" + name
//						+ "' , '" + addres + "'  , '" + gender + "' , '" + email
//						+ "' ," + cntct + " , '" + pwwd
//						+ "','"+stdnumber.replace(" Class","")+"','"+stdclass+"','"+section_data+"','"+subject+"')");
//			
//			}
			pw.println("<html><script>alert('Register Successfully');</script><body>");
			pw.println("");
			pw.println("</body></html>");
			RequestDispatcher rd = request.getRequestDispatcher("/THomePage.jsp");
			rd.include(request, response);
			
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		 
	}

}
