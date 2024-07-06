package com.teacher;

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
 * Servlet implementation class maskpage
 */
@WebServlet("/maskpage")
public class maskpage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public maskpage() {
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
		String txtSubject1 = request.getParameter("txtSubject1");
		String txtSubject2 = request.getParameter("txtSubject2");
		String txtSubject3 = request.getParameter("txtSubject3");
		String txtSubject4 = request.getParameter("txtSubject4");
		String txtSubject5 = request.getParameter("txtSubject5");
		String txtSubject6 = request.getParameter("txtSubject6");
		String txtSubject7 = request.getParameter("txtSubject7");
		String txtstd_num=request.getParameter("txtstd_num");
		String Studentsection=request.getParameter("Student_ID"); 
		String Student_ID=request.getParameter("Studentsection");
		String levelname=request.getParameter("txtstd_num");
		String section_data=request.getParameter("section_data");
		int flag=0;
			try {
				Connection con = Dbconn.conn();
				int total=0;//Integer.valueOf(txtSubject1)+Integer.valueOf(txtSubject2)+Integer.valueOf(txtSubject3)+Integer.valueOf(txtSubject4)+Integer.valueOf(txtSubject5)+Integer.valueOf(txtSubject6)+Integer.valueOf(txtSubject7);
				double pre=0;//(double)(total*100)/700;
				Statement st3 = con.createStatement();
				
//				Statement stRegister11=con.createStatement();
//				 ResultSet rsLogin11=stRegister11.executeQuery("select * from tblmark where Student_ID='" +Student_ID+ "'");
//				 if(rsLogin11.next())
//				 {
//					 flag=1;
//				 }
				
				
				
				
				
				
				Statement stRegister1=con.createStatement();
				 ResultSet rsLogin1=stRegister1.executeQuery("select * from tblmark where Student_ID='" +Student_ID+ "'");
				 if(rsLogin1.next())
				 {
					 flag=1;
				 }
				 System.out.println("Flag=>"+flag);
				 
				 
				 if(levelname.equals("FE"))
				   {
					 total=Integer.valueOf(txtSubject1)+Integer.valueOf(txtSubject2)+Integer.valueOf(txtSubject3)+Integer.valueOf(txtSubject4)+Integer.valueOf(txtSubject5)+Integer.valueOf(txtSubject6);
					   pre=(double)(total*100)/600;
					   if(flag==1)
						 {
							 Statement stRegister11=con.createStatement();
							stRegister11.executeUpdate("update tblmark set Subject1='"+txtSubject1+"',Subject2='"+txtSubject2+"',Subject3='"+txtSubject3+"',Subject4='"+txtSubject4+"',Subject5='"+txtSubject5+"',Subject6='"+txtSubject6+"',Total='"+total+"',Pre_Total='"+pre+"',Studentsection='"+Studentsection+"',section_data='"+section_data+"' where Student_ID='" +Student_ID+ "'");
							 
						 }
						 else{
							 
								st3.executeUpdate("insert into tblmark(Subject1,Subject2,Subject3,Subject4,Subject5,Subject6,Total,Pre_Total,Std_Name,Student_ID,Studentsection,section_data) values('" + txtSubject1 + "'  , '" + txtSubject2 + "' , '" + txtSubject3
										+ "' ," + txtSubject4 + " , '" + txtSubject5
										+ "','" + txtSubject6
										+ "','"+total+"','"+pre+"','"+txtstd_num+"','"+Student_ID+"','"+Studentsection+"','"+section_data+"')");
							   
						 }

				   }
				   else if(levelname.equals("SE"))
				   {
					   total=Integer.valueOf(txtSubject1)+Integer.valueOf(txtSubject2)+Integer.valueOf(txtSubject3)+Integer.valueOf(txtSubject4)+Integer.valueOf(txtSubject5)+Integer.valueOf(txtSubject6)+Integer.valueOf(txtSubject7);
					   pre=(double)(total*100)/700;
					   if(flag==1)
						 {
							 Statement stRegister11=con.createStatement();
							stRegister11.executeUpdate("update tblmark set Subject1='"+txtSubject1+"',Subject2='"+txtSubject2+"',Subject3='"+txtSubject3+"',Subject4='"+txtSubject4+"',Subject5='"+txtSubject5+"',Subject6='"+txtSubject6+"',Subject7='"+txtSubject7+"',Total='"+total+"',Pre_Total='"+pre+"',Studentsection='"+Studentsection+"',section_data='"+section_data+"' where Student_ID='" +Student_ID+ "'");
							 
						 }
						 else{
							 
								st3.executeUpdate("insert into tblmark(Subject1,Subject2,Subject3,Subject4,Subject5,Subject6,Subject7,Total,Pre_Total,Std_Name,Student_ID,Studentsection,section_data) values('" + txtSubject1 + "'  , '" + txtSubject2 + "' , '" + txtSubject3
										+ "' ," + txtSubject4 + " , '" + txtSubject5
										+ "','"+txtSubject6+"','"+txtSubject7+"','"+total+"','"+pre+"','"+txtstd_num+"','"+Student_ID+"','"+Studentsection+"','"+section_data+"')");
							   
						 }

				   }
				   else if(levelname.equals("TE"))
				   {
					  total=Integer.valueOf(txtSubject1)+Integer.valueOf(txtSubject2)+Integer.valueOf(txtSubject3)+Integer.valueOf(txtSubject4)+Integer.valueOf(txtSubject5)+Integer.valueOf(txtSubject6);
					  pre=(double)(total*100)/600;
					  if(flag==1)
						 {
							 Statement stRegister11=con.createStatement();
							stRegister11.executeUpdate("update tblmark set Subject1='"+txtSubject1+"',Subject2='"+txtSubject2+"',Subject3='"+txtSubject3+"',Subject4='"+txtSubject4+"',Subject5='"+txtSubject5+"',Subject6='"+txtSubject6+"',Total='"+total+"',Pre_Total='"+pre+"',Studentsection='"+Studentsection+"',section_data='"+section_data+"' where Student_ID='" +Student_ID+ "'");
							 
						 }
						 else{
							 
								st3.executeUpdate("insert into tblmark(Subject1,Subject2,Subject3,Subject4,Subject5,Subject6,Total,Pre_Total,Std_Name,Student_ID,Studentsection,section_data) values('" + txtSubject1 + "'  , '" + txtSubject2 + "' , '" + txtSubject3
										+ "' ," + txtSubject4 + " , '" + txtSubject5
										+ "','"+txtSubject6+"','"+total+"','"+pre+"','"+txtstd_num+"','"+Student_ID+"','"+Studentsection+"','"+section_data+"')");
							   
						 }
				   }
				   else if(levelname.equals("BE"))
				   {
					   total=Integer.valueOf(txtSubject1)+Integer.valueOf(txtSubject2)+Integer.valueOf(txtSubject3)+Integer.valueOf(txtSubject4)+Integer.valueOf(txtSubject5)+Integer.valueOf(txtSubject6);
					   pre=(double)(total*100)/600;
					   if(flag==1)
						 {
							 Statement stRegister11=con.createStatement();
							stRegister11.executeUpdate("update tblmark set Subject1='"+txtSubject1+"',Subject2='"+txtSubject2+"',Subject3='"+txtSubject3+"',Subject4='"+txtSubject4+"',Subject5='"+txtSubject5+"',Subject6='"+txtSubject6+"',Total='"+total+"',Pre_Total='"+pre+"',Studentsection='"+Studentsection+"',section_data='"+section_data+"' where Student_ID='" +Student_ID+ "'");
							 
						 }
						 else{
							 
								st3.executeUpdate("insert into tblmark(Subject1,Subject2,Subject3,Subject4,Subject5,Subject6,Total,Pre_Total,Std_Name,Student_ID,Studentsection,section_data) values('" + txtSubject1 + "'  , '" + txtSubject2 + "' , '" + txtSubject3
										+ "' ," + txtSubject4 + " , '" + txtSubject5
										+ "','"+txtSubject6+"','"+total+"','"+pre+"','"+txtstd_num+"','"+Student_ID+"','"+Studentsection+"','"+section_data+"')");
							   
						 }
				   }
				 
				 
				 
				 
				 
				 
			pw.println("<html><script>alert('Mark Successfully');</script><body>");
				pw.println("");
				pw.println("</body></html>");
			
			} catch (ClassNotFoundException e) {

				e.printStackTrace();
			} catch (SQLException e) {

				e.printStackTrace();
			}
			RequestDispatcher rd = request.getRequestDispatcher("/MarksPage.jsp");
			rd.include(request, response);
	}

}
