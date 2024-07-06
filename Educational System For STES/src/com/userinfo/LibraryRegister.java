package com.userinfo;

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
 * Servlet implementation class LibraryRegister
 */
@WebServlet("/LibraryRegister")
public class LibraryRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LibraryRegister() {
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
		String email = request.getParameter("txtEmail");
		String gender = request.getParameter("rdoGender");
		String pwwd = request.getParameter("passPassword");
		String cntct = request.getParameter("txtContact");
		String uname=request.getParameter("rdo1");
		String stdnumber=request.getParameter("stdlevel");
		String stdclass=request.getParameter("stdclass");
		String section_data=request.getParameter("section_data");
		
		System.out.println(uname);
		try {
			Connection con = Dbconn.conn();
			Statement st1 = con.createStatement();
			Statement st3 = con.createStatement();
			
		    st3.executeUpdate("insert into librarydetails(name,addr,gender,email,contactno,pwd,stdlevel,classname,section_data,Subject_name) values('" + name
					+ "' , '" + addres + "'  , '" + gender + "' , '" + email
					+ "' ," + cntct + " , '" + pwwd
					+ "','"+stdnumber.replace(" Class","")+"','"+stdclass+"','"+section_data+"')");
		    pw.println("<html><script>alert('Register Successfully');</script><body>");
			pw.println("");
			pw.println("</body></html>");
			
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher("/AdminPage.jsp");
		rd.include(request, response); 
	}

}
