package com.userinfo;

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
 * Servlet implementation class feepay
 */
@WebServlet("/feepay")
public class feepay extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public feepay() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		HttpSession session = request.getSession(true);
		String Student_Name = (String) session.getAttribute("name");
		String Student_Email_ID = (String) session.getAttribute("s_email");
		String Student_Mobile_No = (String) session.getAttribute("contactno");
		String Cast_Name = request.getParameter("txtstate").replace("'","");
		System.out.println(Cast_Name);
		String Year_data = request.getParameter("section_data");
		String Account_No = request.getParameter("txtSubject1");
		String IFSC_Code = request.getParameter("txtSubject2");
		String Amount = request.getParameter("stdclass");
		String Paid_Fee = request.getParameter("txtSubject4");
		int a = Integer.valueOf(Amount);
		int s = Integer.valueOf(Paid_Fee);
		int total = a - s;
		String Remaining_Fee = String.valueOf(total);

		String Transaction_ID = Dbconn.generateTransactionId();
		Date day = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String Date_time_Data = formatter.format(day);

		try {
			Connection con = Dbconn.conn();
			Statement st1 = con.createStatement();
			Statement st3 = con.createStatement();

			st3.executeUpdate("insert into student_fee (Student_Name,Student_Email_ID,Student_Mobile_No,Cast_Name,Years_data,Account_No,CodeIFSC,Amount,Paid_Fee,Remaining_Fee,Transaction_ID,Date_time_Data)  values('"
					+ Student_Name
					+ "','"
					+ Student_Email_ID
					+ "' , '"
					+ Student_Mobile_No
					+ "' ,'"
					+ Cast_Name
					+ "','"
					+ Year_data
					+ "','"
					+ Account_No
					+ "','"
					+ IFSC_Code
					+ "','"
					+ Amount
					+ "','"
					+ Paid_Fee
					+ "','"
					+ Remaining_Fee
					+ "','" + Transaction_ID + "','" + Date_time_Data + "')");

			pw.println("<html><script>alert('Fee Paid Successfully');</script><body>");
			pw.println("");
			pw.println("</body></html>");
			RequestDispatcher rd = request
					.getRequestDispatcher("/S_ShowFeePage.jsp");
			rd.include(request, response);

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

}
