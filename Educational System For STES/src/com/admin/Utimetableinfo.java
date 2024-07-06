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
import javax.servlet.http.HttpSession;

import com.connection.Dbconn;

/**
 * Servlet implementation class Utimetableinfo
 */
@WebServlet("/Utimetableinfo")
public class Utimetableinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Utimetableinfo() {
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
		String txtid=request.getParameter("txtid");
		HttpSession session=request.getSession(true);
		
		String state=(String)session.getAttribute("state");;
		String classname=(String)session.getAttribute("classname");
		Connection con;
		try {
			con = Dbconn.conn();
			Statement stfifo1 = con.createStatement();
			if(state.equals("Pre-Primary Class"))
			{
				String txtSubject1=request.getParameter("txtSubject1");
				String txtSubject2=request.getParameter("txtSubject2");
				String txtSubject3=request.getParameter("txtSubject3");
				String txtSubject4=request.getParameter("txtSubject4");
				String txtSubject5=request.getParameter("txtSubject5");
			stfifo1.executeUpdate("update tblmastertime set h1='"+txtSubject1+"',h2='"+txtSubject2+"',h3='"+txtSubject3+"',h4='"+txtSubject4+"',h5='"+txtSubject5+"' where id_time='"+txtid+"'");
			}
			else if(state.equals("Primary Class"))
			{
				String txtSubject1=request.getParameter("txtSubject1");
				String txtSubject2=request.getParameter("txtSubject2");
				String txtSubject3=request.getParameter("txtSubject3");
				String txtSubject4=request.getParameter("txtSubject4");
				String txtSubject5=request.getParameter("txtSubject5");
				String txtSubject6=request.getParameter("txtSubject6");
				String txtSubject7=request.getParameter("txtSubject7");
				stfifo1.executeUpdate("update tblmastertime set h1='"+txtSubject1+"',h2='"+txtSubject2+"',h3='"+txtSubject3+"',h4='"+txtSubject4+"',h5='"+txtSubject5+"',h6='"+txtSubject6+"',h7='"+txtSubject7+"' where id_time='"+txtid+"'");
			}
			else if(state.equals("Secondary Class"))
			{
				String txtSubject1=request.getParameter("txtSubject1");
				String txtSubject2=request.getParameter("txtSubject2");
				String txtSubject3=request.getParameter("txtSubject3");
				String txtSubject4=request.getParameter("txtSubject4");
				String txtSubject5=request.getParameter("txtSubject5");
				String txtSubject6=request.getParameter("txtSubject6");
				stfifo1.executeUpdate("update tblmastertime set h1='"+txtSubject1+"',h2='"+txtSubject2+"',h3='"+txtSubject3+"',h4='"+txtSubject4+"',h5='"+txtSubject5+"',h6='"+txtSubject6+"' where id_time='"+txtid+"'");
			}
			else if(state.equals("Higher_Secondary Class"))
			{
				String txtSubject1=request.getParameter("txtSubject1");
				String txtSubject2=request.getParameter("txtSubject2");
				String txtSubject3=request.getParameter("txtSubject3");
				String txtSubject4=request.getParameter("txtSubject4");
				String txtSubject5=request.getParameter("txtSubject5");
				String txtSubject6=request.getParameter("txtSubject6");
				stfifo1.executeUpdate("update tblmastertime set h1='"+txtSubject1+"',h2='"+txtSubject2+"',h3='"+txtSubject3+"',h4='"+txtSubject4+"',h5='"+txtSubject5+"',h6='"+txtSubject6+"' where id_time='"+txtid+"'");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 pw.println("<html><script>alert('Update Successfully');</script><body>");
			pw.println("");
			pw.println("</body></html>");
		RequestDispatcher rd = request.getRequestDispatcher("/TimeTableShow.jsp");
		rd.include(request, response);
		
	}

}
