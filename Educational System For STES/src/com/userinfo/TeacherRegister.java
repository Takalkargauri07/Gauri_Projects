package com.userinfo;

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
import javax.servlet.http.HttpSession;

import com.connection.Dbconn;

/**
 * Servlet implementation class TeacherRegister
 */
@WebServlet("/TeacherRegister")
public class TeacherRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherRegister() {
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
		HttpSession session = request.getSession(true);
		String name = (String)session.getAttribute("Rname");
		String addres =(String)session.getAttribute("Raddres");
		String email = (String)session.getAttribute("Remail");
		String gender = (String)session.getAttribute("Rname");
		String pwwd = (String)session.getAttribute("Rpwwd");
		String cntct = (String)session.getAttribute("Rcntct");
		String uname=(String)session.getAttribute("Runame");
		String stdnumber=(String)session.getAttribute("Rstdnumber");
		String stdclass=(String)session.getAttribute("Rstdclass");
		String section_data=(String)session.getAttribute("Rsection_data");
		String subject=(String)session.getAttribute("Rtxtsubject");
		String otpcode=request.getParameter("otpcode");
		String dbotpcode="";
		try {
			Connection con = Dbconn.conn();
			
			Statement st3 = con.createStatement();
			Statement st1 = con.createStatement();
			ResultSet rs=st1.executeQuery("select * from tblotp where emailid='"+email+"'");
			if(rs.next())
			{
				dbotpcode=rs.getString("otpcode");
			}
			if(otpcode.equals(dbotpcode))
			{
			if (uname.equals("UserInfo"))
			{
				st3.executeUpdate("insert into studentdetails(name,addr,gender,email,contactno,pwd,stdlevel,classname,section_data,Subject_name) values('" + name
						+ "' , '" + addres + "'  , '" + gender + "' , '" + email
						+ "' ," + cntct + " , '" + pwwd
						+ "','"+stdnumber.replace(" Class","")+"','"+stdclass+"','"+section_data+"','"+subject+"')");
			}
			else if (uname.equals("TeacherInfo"))
			{
				st3.executeUpdate("insert into teacherdetails(name,addr,gender,email,contactno,pwd,stdlevel,classname,section_data,Subject_name) values('" + name
						+ "' , '" + addres + "'  , '" + gender + "' , '" + email
						+ "' ," + cntct + " , '" + pwwd
						+ "','"+stdnumber.replace(" Class","")+"','"+stdclass+"','"+section_data+"','"+subject+"')");
			}
			else if (uname.equals("LibraryInfo"))
			{
				st3.executeUpdate("insert into librarydetails(name,addr,gender,email,contactno,pwd,stdlevel,classname,section_data,Subject_name) values('" + name
						+ "' , '" + addres + "'  , '" + gender + "' , '" + email
						+ "' ," + cntct + " , '" + pwwd
						+ "','"+stdnumber.replace(" Class","")+"','"+stdclass+"','"+section_data+"')");
			}
			 pw.println("<html><script>alert('Register Successfully');</script><body>");
			pw.println("");
			pw.println("</body></html>");
			RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
			rd.include(request, response); 
			}
			else
			{
				pw.println("<html><script>alert('OTP Wrong');</script><body>");
				pw.println("");
				pw.println("</body></html>");
				RequestDispatcher rd = request.getRequestDispatcher("/OTPCode.jsp");
				rd.include(request, response); 
			}
			
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
	}

}
