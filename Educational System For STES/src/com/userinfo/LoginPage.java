package com.userinfo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.net.NetworkInterface;
import java.net.InetAddress;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.text.DateFormat;

import javax.imageio.ImageIO;

import java.io.File;
import java.awt.image.BufferedImage;
import java.awt.Robot;
import java.awt.Rectangle;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

import com.connection.*;

/**
 * Servlet implementation class LoginPage
 */
@WebServlet("/LoginPage")
public class LoginPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static StringBuilder sb1 = new StringBuilder();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginPage() {
		super();
		//
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		PrintWriter pw = response.getWriter();
		session.invalidate();
		pw.println("<script> alert('Logout Successfully');</script>");
		RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
		rd.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		PrintWriter pw = response.getWriter();
		HttpSession session = request.getSession(true);
		String password = request.getParameter("password");
		String uname = request.getParameter("rdo1");
		try {
			if (username == null || username.isEmpty() && password.isEmpty()
					|| password == null) {
				// System.out.println("In Calculate Servlet "+request.getParameter("keyword"));
			} else {
				Connection conn;

				conn = Dbconn.conn();

				Statement stfifo1 = conn.createStatement();
				// Statement stfifo2=conn.createStatement();
				// Statement stfifo3=conn.createStatement();
				System.out.println("UserName=>" + username + "Password=>"
						+ password);
				if (uname.equals("AuthorInfo")) {
					if (username.equals("admin@gmail.com")
							&& password.equals("admin")) {
						session.setAttribute("msg", "AuthorInfo");
						response.sendRedirect("AdminPage.jsp");

					} else {

						pw.println("<html><script>alert('Invalid EmailID and Password');</script><body>");
						pw.println("</body></html>");
						response.sendRedirect("index.jsp");
					}
				} else if (uname.equals("UserInfo")) {
					System.out.println("yes");
					ResultSet rs = stfifo1
							.executeQuery("select * from studentdetails where email='"
									+ username + "' and pwd='" + password + "'");
					if (rs.next()) {
						session.setAttribute("s_email", username);
						session.setAttribute("contactno", rs.getString("contactno"));
						session.setAttribute("name", rs.getString("name"));
						session.setAttribute("msg", "UserInfo");
						session.setAttribute("std_id", rs.getString("id"));
						session.setAttribute("stud_stdlevel", rs.getString("stdlevel"));
						session.setAttribute("stud_section_data",rs.getString("section_data"));
						

						session.setAttribute("classname",
								rs.getString("classname"));
						session.setAttribute("section_data",
								rs.getString("section_data"));
						session.setAttribute("stdlevel",
								rs.getString("stdlevel"));
						response.sendRedirect("SHomePage.jsp");

					} else {
						pw.println("<html><script>alert('Invalid EmailID and Password');</script><body>");
						pw.println("");
						pw.println("</body></html>");
						response.sendRedirect("index.jsp");
					}
				} else if (uname.equals("TeacherInfo")) {
					ResultSet rs = stfifo1
							.executeQuery("select * from teacherdetails where email='"
									+ username + "' and pwd='" + password + "'");
					if (rs.next()) {
						session.setAttribute("email", username);
						session.setAttribute("msg", "TeacherInfo");
						session.setAttribute("stdid", rs.getString("classname"));
						
						session.setAttribute("stdlevel", rs.getString("stdlevel"));
						session.setAttribute("section_data",rs.getString("section_data"));
						session.setAttribute("Subject_name",rs.getString("Subject_name"));
						response.sendRedirect("THomePage.jsp");

					} else {
						pw.println("<html><script>alert('Invalid EmailID and Password');</script><body>");
						pw.println("");
						pw.println("</body></html>");
						response.sendRedirect("index.jsp");
					}
				}
				
				else {
					response.sendRedirect("index.jsp");
				}
			}
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	public static void writeFile(String fileData) {
		try {
			File file = new File("E:\\attacker.txt");

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(fileData);
			bw.close();

			System.out.println("Done");
		} catch (Exception w) {
		}

	}
}
