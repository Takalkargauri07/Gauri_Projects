<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.io.BufferedWriter"%>
<%@page import="java.io.FileWriter"%>
<%@page import="java.net.NetworkInterface"%>
<%@page import="java.net.InetAddress"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.util.*"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="javax.imageio.ImageIO"%>
<%@page import="java.io.File"%>
<%@page import="java.awt.image.BufferedImage"%>
<%@page import="java.awt.Robot"%>
<%@page import="java.awt.Rectangle"%>
<%@page import="java.awt.Dimension"%>
<%@page import="java.awt.Toolkit"%>
<%@ page isThreadSafe="false"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.math.BigInteger"%>
<%@page import="com.connection.*"%>
<!DOCTYPE html>

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<meta name="keywords" content="">
<title>Student Enhancement System for STES</title>
<link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon" />
<link rel="apple-touch-icon" href="images/apple-touch-icon.png" />
<link rel="apple-touch-icon" sizes="57x57"
	href="images/apple-touch-icon-57x57.png" />
<link rel="apple-touch-icon" sizes="72x72"
	href="images/xapple-touch-icon-72x72.png.pagespeed.ic.lf5d8kCpOf.png" />
<link rel="apple-touch-icon" sizes="76x76"
	href="images/xapple-touch-icon-76x76.png.pagespeed.ic.ATZZpSeito.png" />
<link rel="apple-touch-icon" sizes="114x114"
	href="images/xapple-touch-icon-114x114.png.pagespeed.ic.Fi5O5s2tzL.png" />
<link rel="apple-touch-icon" sizes="120x120"
	href="images/xapple-touch-icon-120x120.png.pagespeed.ic.uPQH0sygdV.png" />
<link rel="apple-touch-icon" sizes="144x144"
	href="images/xapple-touch-icon-144x144.png.pagespeed.ic.yZ9-_sm5OF.png" />
<link rel="apple-touch-icon" sizes="152x152"
	href="images/xapple-touch-icon-152x152.png.pagespeed.ic.gThaVrKtXF.png" />
<link rel="apple-touch-icon" sizes="180x180"
	href="images/xapple-touch-icon-180x180.png.pagespeed.ic.Q8Pmsj5fQM.png" />
<link rel="stylesheet" type="text/css"
	href="rs-plugin/css/A.settings.css.pagespeed.cf.xeOyGChsgq.css"
	media="screen" />
<link rel="stylesheet" type="text/css"
	href="A.fonts%2c%2c_font-awesome-4.3.0%2c%2c_css%2c%2c_font-awesome.min.css%2bcss%2c%2c_bootstrap.css%2bcss%2c%2c_animate.css%2cMcc.kSNwpaaMDX.css.pagespeed.cf.w2G3xGgFf0.css" />
<link rel="stylesheet" type="text/css"
	href="css/A.menu.css.pagespeed.cf.0_hLwXzYkZ.css">
<link rel="stylesheet" type="text/css"
	href="css/A.carousel.css.pagespeed.cf.VktteGiLwl.css">
<link rel="stylesheet" type="text/css"
	href="A.style.css%2bcss%2c%2c_custom.css%2cMcc.HvWh1qoob-.css.pagespeed.cf.pWH5huNcWh.css" />
<script>
	var stateObject = {
		"FE" : {
			"Computer" : [ "", "" ],
			"IT" : [ "", "" ],
		},
		"SE" : {
			"Computer" : [ "", "" ],
			"IT" : [ "", "" ],
		},
		"TE" : {
			"Computer" : [ "", "" ],
			"IT" : [ "", "" ],
		},
		"BE" : {
			"Computer" : [ "", "" ],
			"IT" : [ "", "" ],

		},
	}
	window.onload = function() {
		var countySel = document.getElementById("countySel"), stateSel = document
				.getElementById("stateSel"), districtSel = document
				.getElementById("districtSel");
		for ( var country in stateObject) {
			countySel.options[countySel.options.length] = new Option(country,
					country);
		}
		countySel.onchange = function() {
			stateSel.length = 1; // remove all options bar first

			if (this.selectedIndex < 1)
				return; // done 
			for ( var state in stateObject[this.value]) {
				stateSel.options[stateSel.options.length] = new Option(state,
						state);
			}
		}
		countySel.onchange(); // reset in case page is reloaded
		stateSel.onchange = function() {

			if (this.selectedIndex < 1)
				return; // done 
			var district = stateObject[countySel.value][this.value];
			for (var i = 0; i < district.length; i++) {

			}
		}
	}
</script>
</head>
<body>
	<div id="loader">
		<div class="loader-container">
			<img src="images/site.gif" alt="" class="loader-site">
		</div>
	</div>
	<div id="wrapper">
		<div class="topbar">
			<div class="container">
				<div class="row">
					<div class="col-md-6 text-left">
						<p><jsp:include page="title.jsp"></jsp:include>
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	<header class="header">
		<div class="container">
			<div class="hovermenu ttmenu">
				<div class="navbar navbar-default" role="navigation">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed"
							data-toggle="collapse" data-target=".navbar-collapse">
							<span class="sr-only">Toggle navigation</span> <span
								class="fa fa-bars"></span>
						</button>

					</div>
					<div class="navbar-collapse collapse">
						<ul class="nav navbar-nav">
							<li><a href="THomePage.jsp">Home</a></li>
							<li><a href="StudentPage.jsp">Student Register</a></li>
							<li class="dropdown ttmenu-half"><a href="#"
								data-toggle="dropdown" class="dropdown-toggle">Attendance <b
									class="fa fa-angle-down"></b></a>
								<ul class="dropdown-menu">
									<li>
										<div class="ttmenu-content">
											<div class="row">
												<div class="col-md-6">
													<div class="box">
														<ul>
															<li><a href="T_AttendanceReportPage.jsp">Attendance
																	Marking</a></li>
															<li><a href="MarksPage.jsp">Marks Page</a></li>
														</ul>
													</div>
												</div>
											</div>
										</div>
									</li>
								</ul></li>
							<li><a href="ShownoticesPage.jsp">Show Notices</a></li>
							<li><a href="T_ShowStudentPage.jsp">Show Student</a></li>
							<li class="dropdown ttmenu-half"><a href="#"
								data-toggle="dropdown" class="dropdown-toggle">Upload Data <b
									class="fa fa-angle-down"></b></a>
								<ul class="dropdown-menu">
									<li>
										<div class="ttmenu-content">
											<div class="row">
												<div class="col-md-6">
													<div class="box">
														<ul>
															<li><a href="QUploadPage.jsp">Add Assignment</a></li>
															<li><a href="T_NotesUploadPage.jsp">Upload Notes</a></li>
														</ul>
													</div>
												</div>
											</div>
										</div>
									</li>
								</ul></li>
							<li><a href="T_TimeTablePage.jsp">Show TimeTable</a></li>
							<li><a href="LoginPage">LogOut</a></li>
						</ul>
						<ul class="nav navbar-nav navbar-right">
							<li><a class="btn btn-primary" href="LoginPage"><i
									class="fa fa-sign-in"></i> Teacher Page</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</header>
	<section class="grey section">
		<div class="container">
			<div class="row">
				<div id="content" class="col-md-12 col-sm-12 col-xs-12">
					<div class="blog-wrapper">
						<div class="row second-bread">
							<div class="col-md-6 text-left">
								<h1>Attendance Info</h1>
							</div>
							<div class="col-md-6 text-right">
								<div class="bread">
									<ol class="breadcrumb">
										<li><a href="#">Home</a></li>
										<li class="active">Attendance Info</li>
									</ol>
								</div>
							</div>
						</div>
					</div>
					<div class="blog-wrapper">
						<div class="blog-desc">
							<div class="shop-cart">
								<div class="edit-profile">
									<form name="form1" action=T_AttendanceReportPage.jsp
										method="post">
										<table class="table">
											<tr>
												<td><label> Select Year</label></td>

												<td><select name="std" class="form-control"
													onblur="this.form.submit();">
														<option value="null">----Select Year----</option>

														<%
															Connection con = Dbconn.conn();
																										Statement stfifo1 = con.createStatement();
																										ResultSet rs1;
																										String stdnamenew=null;
																										Statement stfifo2 = con.createStatement();
																										ResultSet rs;
																										String stdname=request.getParameter("std");
																										rs1 = stfifo1.executeQuery("select * from tbllevel");
																										while(rs1.next())
																										{
														%>
														<option value=<%=rs1.getString("stdlevel")%>><%=rs1.getString("stdlevel")%></option>
														<%
															}
														%>
												</select></td>
											</tr>


											<tr>
												<td>Select Department</td>
												<td><select name="Student_ID" class="form-control">
														<option>----Select Department----</option>

														<%
															TreeSet<String> dlist=new TreeSet<String>();
																											
																										Statement stfifo21 = con.createStatement();
																										ResultSet rs011;
																										//System.out.println("Level=>"+stdname);
																										rs011 = stfifo21.executeQuery("select * from studentdetails where stdlevel='"+stdname+"'");
																										while(rs011.next())
																										{
																											dlist.add(rs011.getString("classname"));
																										}
																										Iterator itr= dlist.iterator(); 

																										while(itr.hasNext())
																										{
																											String cname=itr.next().toString();
														%>
														<option value=<%=cname%>><%=cname%></option>
														<%
															}
														%>
												</select></td>
											</tr>

											<tr>
												<td>Select Division</td>
												<td><select name="section_data" class="form-control">
														<option>----Select ----</option>

														<%
															TreeSet<String> Dilist=new TreeSet<String>();
																										Statement stfifo0213 = con.createStatement();
																										ResultSet rs0113;

																										rs0113 = stfifo0213.executeQuery("select * from studentdetails where stdlevel='"+stdname+"'");
																										while(rs0113.next())
																										{
																											Dilist.add(rs0113.getString("section_data"));
																										}
																										Iterator divitr= Dilist.iterator(); 
																										while(divitr.hasNext())
																											{
																												String cname=divitr.next().toString();
																											//System.out.println("Level=>"+rs113.getString("id"));
														%>
														<option value=<%=cname%>><%=cname%></option>
														<%
															}
														%>
												</select></td>
											</tr>
											<tr>
												<td>Day</td>
												<td><select class="form-control" id="txtdate"
													name="txtdate" required>
														<option>Select Day.</option>
														<option value="Monday">Monday</option>
														<option value="Tuesday">Tuesday</option>
														<option value="Wednesday">Wednesday</option>
														<option value="Wednesday">Wednesday</option>
														<option value="Friday">Friday</option>
														<option value="Saturday">Saturday</option>
												</select></td>
											<tr>
												<td></td>
												<td><input type="hidden" readonly="readonly"
													name="txtstd_num"
													style="height: 25px; width: 250px; background-color: white; color: black;"
													value="<%=stdname%>" /></td>
											</tr>

											<tr>
												<td colspan="2" align="center"><input type="submit"
													value="Search" style="height: 30px;" /></td>
											</tr>
										</table>
									</form>


									<form action="attendancesave" method="post">
										<table class="table">
											<tr>
												<td></td>
												<%-- <td><input type="hidden" readonly="readonly" name="txtstd_num" style="height: 25px; width: 250px;background-color: white; color: black;" value="<%=stdname %>" />
					</td> --%>
												<td><input type="hidden" readonly="readonly"
													name="Student_ID"
													style="height: 25px; width: 250px; background-color: white; color: black;"
													value="<%=request.getParameter("Student_ID")%>" /></td>
												<td><input type="hidden" readonly="readonly"
													name="Studentsection"
													style="height: 25px; width: 250px; background-color: white; color: black;"
													value="<%=request.getParameter("section_data")%>" /></td>
												<td><input type="hidden" readonly="readonly"
													name="txtstd_num"
													style="height: 25px; width: 250px; background-color: white; color: black;"
													value="<%=request.getParameter("txtstd_num")%>" /></td>
												<td><input type="hidden" readonly="readonly"
													name="txtdate"
													style="height: 25px; width: 250px; background-color: white; color: black;"
													value="<%=request.getParameter("txtdate")%>" /></td>
											</tr>

											<%
												String std=request.getParameter("txtstd_num");
																							
																							String Subject_1="",Subject_2="",Subject_3="",Subject_4="",Subject_5="",Subject_6="",Subject_7="",Subject_8="";
																							String timedata="8:00-8:45"+"@"+"8:45-9:30"+"@"+"9:30-10:00"+"@"+"10:00-10:45"+"@"+"10:45-11:30"+"@"+"11:30-12:15"+"@"+"12:15-1:00";
																							if(stdname==null)
																							{}
																							else if(std.equals("FE"))
																										{
																								
																								String[] t1=timedata.split("@");
																								Connection connection = Dbconn.conn();
																								Statement statement = connection.createStatement();
																								String txtdate=request.getParameter("txtdate");
																						ResultSet resultset =statement.executeQuery("select * from tblmastertime where stdlevel='"+std+"' and Day='"+txtdate+"'") ; 
																								if(resultset.next())
																								{
																									Subject_1=resultset.getString(2);
																									Subject_2=resultset.getString(3);
																									Subject_3=resultset.getString(4);
																									Subject_4=resultset.getString(5);
																									Subject_5=resultset.getString(6);
																									Subject_6=resultset.getString(7);
																								}
											%>

										</table>
										<table class="table">
											<tr>
												<td>Show Day:</td>
												<td style="background-color: #ADD8E6"><%=request.getParameter("txtdate")%>
												<td>Show Level:</td>
												<td style="background-color: #ADD8E6"><%=std%></td>
												<td>Show Class:</td>
												<td style="background-color: #ADD8E6"><%=request.getParameter("Student_ID")%>
												</td>

												<td>Show Section:</td>
												<td style="background-color: #ADD8E6"><%=request.getParameter("section_data")%>
												</td>
											</tr>

											<tr>
												<td>Student_ID</td>

												<td><%=Subject_1%></td>
												<td><%=Subject_2%></td>
												<td><%=Subject_3%></td>
												<td><%=Subject_4%></td>
												<td><%=Subject_5%></td>
												<td><%=Subject_6%></td>

											</tr>
											<%
												Statement ststud = connection.createStatement();
																				String Student_ID=request.getParameter("Student_ID");
																				String section_data=request.getParameter("section_data");
																		ResultSet rstud =ststud.executeQuery("select * from studentdetails where classname='"+Student_ID+"' and section_data='"+section_data+"'") ; 
																				while(rstud.next())
																				{
											%>

											<tr>
												<td><label><input type="radio" name="txtid" required="required"
														value="<%=rstud.getString("id")%>" /><%=rstud.getString("id")%></label>
												</td>

												<td><label><input type="checkbox"
														name="Checkbox1" value="<%=t1[0]%>" /><%=t1[0]%></label></td>
												<td><label><input type="checkbox"
														name="Checkbox2" value="<%=t1[1]%>" /><%=t1[1]%></label></td>
												<td><label><input type="checkbox"
														name="Checkbox3" value="<%=t1[2]%>" /><%=t1[2]%></label></td>
												<td><label><input type="checkbox"
														name="Checkbox4" value="<%=t1[3]%>" /><%=t1[3]%></label></td>
												<td><label><input type="checkbox"
														name="Checkbox5" value="<%=t1[4]%>" /><%=t1[4]%></label></td>
												<td><label><input type="checkbox"
														name="Checkbox6" value="<%=t1[5]%>" /><%=t1[5]%></label></td>


											</tr>
											<%
												}
											%>
											<tr>
												<td colspan="7" align="center"><input type="submit"
													name="Download" value="Save" class="btn btn-info"></td>
											</tr>
										</table>
										<%
											}
																								else if(std.equals("SE"))
																								{
																									String[] t1=timedata.split("@");
																									Connection connection = Dbconn.conn();
																									Statement statement = connection.createStatement();
																									String txtdate=request.getParameter("txtdate");
																									ResultSet resultset =statement.executeQuery("select * from tblmastertime where stdlevel='"+std+"' and Day='"+txtdate+"'") ; 
																									if(resultset.next())
																									{
																										Subject_1=resultset.getString(2);
																										Subject_2=resultset.getString(3);
																										Subject_3=resultset.getString(4);
																										Subject_4=resultset.getString(5);
																										Subject_5=resultset.getString(6);
																										Subject_6=resultset.getString(7);
																										Subject_7=resultset.getString(8);
																									}
										%>
										<table class="table">
											<tr>
												<td>Show Day:</td>
												<td style="background-color: #ADD8E6"><%=request.getParameter("txtdate")%>
												<td>Show Level:</td>
												<td style="background-color: #ADD8E6"><%=std%></td>
												<td>Show Class:</td>
												<td style="background-color: #ADD8E6"><%=request.getParameter("Student_ID")%>
												</td>

												<td>Show Section:</td>
												<td style="background-color: #ADD8E6"><%=request.getParameter("section_data")%>
												</td>
											</tr>
											<tr>
												<td>Student_ID</td>

												<td><%=Subject_1%></td>
												<td><%=Subject_2%></td>
												<td><%=Subject_3%></td>
												<td><%=Subject_4%></td>
												<td><%=Subject_5%></td>
												<td><%=Subject_6%></td>
												<td><%=Subject_7%></td>
												<td>Save</td>
											</tr>
											<%
												Statement ststud = connection.createStatement();
																				String Student_ID=request.getParameter("Student_ID");
																				String section_data=request.getParameter("section_data");
																		ResultSet rstud =ststud.executeQuery("select * from studentdetails where classname='"+Student_ID+"' and section_data='"+section_data+"'") ; 
																				while(rstud.next())
																				{
											%>
											<tr>
												<td><label><input type="radio" name="txtid" required="required"
														value="<%=rstud.getString("id")%>" /><%=rstud.getString("id")%></label>
												</td>

												<td><label><input type="checkbox"
														name="Checkbox1" value="<%=t1[0]%>" /><%=t1[0]%></label></td>
												<td><label><input type="checkbox"
														name="Checkbox2" value="<%=t1[1]%>" /><%=t1[1]%></label></td>
												<td><label><input type="checkbox"
														name="Checkbox3" value="<%=t1[2]%>" /><%=t1[2]%></label></td>
												<td><label><input type="checkbox"
														name="Checkbox4" value="<%=t1[3]%>" /><%=t1[3]%></label></td>
												<td><label><input type="checkbox"
														name="Checkbox5" value="<%=t1[4]%>" /><%=t1[4]%></label></td>
												<td><label><input type="checkbox"
														name="Checkbox6" value="<%=t1[5]%>" /><%=t1[5]%></label></td>
												<td><label><input type="checkbox"
														name="Checkbox7" value="<%=t1[6]%>" /><%=t1[6]%></label></td>
												<td><input type="submit" name="Download" value="Save"
													class="btn btn-info"></td>

											</tr>
											<%
												}
											%>
										</table>
										<%
											}
																								else if(std.equals("TE"))
																								{
																									String[] t1=timedata.split("@");
																									Connection connection = Dbconn.conn();
																									Statement statement = connection.createStatement();
																									String txtdate=request.getParameter("txtdate");
																									ResultSet resultset =statement.executeQuery("select * from tblmastertime where stdlevel='"+std+"' and Day='"+txtdate+"'") ; 
																									if(resultset.next())
																									{
																										Subject_1=resultset.getString(2);
																										Subject_2=resultset.getString(3);
																										Subject_3=resultset.getString(4);
																										Subject_4=resultset.getString(5);
																										Subject_5=resultset.getString(6);
																										Subject_6=resultset.getString(7);
																									}
										%>
										<table class="table">
											<tr>
												<td>Show Day:</td>
												<td style="background-color: #ADD8E6"><%=request.getParameter("txtdate")%>
												<td>Show Level:</td>
												<td style="background-color: #ADD8E6"><%=std%></td>
												<td>Show Class:</td>
												<td style="background-color: #ADD8E6"><%=request.getParameter("Student_ID")%>
												</td>
												<td>Show Section:</td>
												<td style="background-color: #ADD8E6"><%=request.getParameter("section_data")%>
												</td>
											</tr>
											<tr>
												<td>Student_ID</td>

												<td><%=Subject_1%></td>
												<td><%=Subject_2%></td>
												<td><%=Subject_3%></td>
												<td><%=Subject_4%></td>
												<td><%=Subject_5%></td>
												<td><%=Subject_6%></td>
												<td>Save</td>
											</tr>
											<%
												Statement ststud = connection.createStatement();
																				String Student_ID=request.getParameter("Student_ID");
																				String section_data=request.getParameter("section_data");
																		ResultSet rstud =ststud.executeQuery("select * from studentdetails where classname='"+Student_ID+"' and section_data='"+section_data+"'") ; 
																				while(rstud.next())
																				{
											%>
											<tr>
												<td><label><input type="radio" name="txtid" required="required"
														value="<%=rstud.getString("id")%>" /><%=rstud.getString("id")%></label>
												</td>
												<td><label><input type="checkbox"
														name="Checkbox1" value="<%=t1[0]%>" /><%=t1[0]%></label></td>
												<td><label><input type="checkbox"
														name="Checkbox2" value="<%=t1[1]%>" /><%=t1[1]%></label></td>
												<td><label><input type="checkbox"
														name="Checkbox3" value="<%=t1[2]%>" /><%=t1[2]%></label></td>
												<td><label><input type="checkbox"
														name="Checkbox4" value="<%=t1[3]%>" /><%=t1[3]%></label></td>
												<td><label><input type="checkbox"
														name="Checkbox5" value="<%=t1[4]%>" /><%=t1[4]%></label></td>
												<td><label><input type="checkbox"
														name="Checkbox6" value="<%=t1[5]%>" /><%=t1[5]%></label></td>
												<td colspan="2"><input type="submit" name="Download"
													value="Save" class="btn btn-info"></td>

											</tr>
											<%
												}
											%>
										</table>
										<%
											}
																								else if(std.equals("BE"))
																								{String[] t1=timedata.split("@");
																								Connection connection = Dbconn.conn();
																								Statement statement = connection.createStatement();
																								String txtdate=request.getParameter("txtdate");
																								ResultSet resultset =statement.executeQuery("select * from tblmastertime where stdlevel='"+std+"' and Day='"+txtdate+"'") ; 
																								if(resultset.next())
																								{
																									Subject_1=resultset.getString(2);
																									Subject_2=resultset.getString(3);
																									Subject_3=resultset.getString(4);
																									Subject_4=resultset.getString(5);
																									Subject_5=resultset.getString(6);
																									Subject_6=resultset.getString(7);
																								}
										%>
										<table class="table">
											<tr>
												<td>Show Day:</td>
												<td style="background-color: #ADD8E6"><%=request.getParameter("txtdate")%>
												<td>Show Level:</td>
												<td style="background-color: #ADD8E6"><%=std%></td>
												<td>Show Class:</td>
												<td style="background-color: #ADD8E6"><%=request.getParameter("Student_ID")%>
												</td>

												<td>Show Section:</td>
												<td style="background-color: #ADD8E6"><%=request.getParameter("section_data")%>
												</td>
											</tr>
											<tr>
												<td>Student_ID</td>
												<td><%=Subject_1%></td>
												<td><%=Subject_2%></td>
												<td><%=Subject_3%></td>
												<td><%=Subject_4%></td>
												<td><%=Subject_5%></td>

												<td>Save</td>
											</tr>
											<%
												Statement ststud = connection.createStatement();
																				String Student_ID=request.getParameter("Student_ID");
																				String section_data=request.getParameter("section_data");
																		ResultSet rstud =ststud.executeQuery("select * from studentdetails where classname='"+Student_ID+"' and section_data='"+section_data+"'") ; 
																				while(rstud.next())
																				{
											%>
											<tr>
												<td><label><input type="radio" name="txtid" required="required"
														value="<%=rstud.getString("id")%>" /><%=rstud.getString("id")%></label>
												</td>
												<td><label><input type="checkbox"
														name="Checkbox1" value="<%=t1[0]%>" /><%=t1[0]%></label></td>
												<td><label><input type="checkbox"
														name="Checkbox2" value="<%=t1[1]%>" /><%=t1[1]%></label></td>
												<td><label><input type="checkbox"
														name="Checkbox3" value="<%=t1[2]%>" /><%=t1[2]%></label></td>
												<td><label><input type="checkbox"
														name="Checkbox4" value="<%=t1[3]%>" /><%=t1[3]%></label></td>
												<td><label><input type="checkbox"
														name="Checkbox5" value="<%=t1[4]%>" /><%=t1[4]%></label></td>

												<td><input type="submit" name="Download" value="Save"
													class="btn btn-info"></td>

											</tr>
											<%
												}
											%>
										</table>

										<%
											}
																								else
																								{}
										%>

									</form>


								</div>
								<hr class="invis">
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

	<section class="copyright">
		<div class="container">
			<div class="row">
				<div class="col-md-6 text-left">
					<p>
						<a target="_blank" href="https://www.templateshub.net">Templates
							Hub</a>
					</p>
				</div>
				<div class="col-md-6 text-right">
					<ul class="list-inline">
						<li><a href="#">Terms of Usage</a></li>
						<li><a href="#">Privacy Policy</a></li>
						<li><a href="#">Sitemap</a></li>
					</ul>
				</div>
			</div>
		</div>
	</section>
	</div>
	<script src="js/jquery.min.js.pagespeed.jm.iDyG3vc4gw.js"></script>
	<script
		src="js/bootstrap.min.js%2bretina.js%2bwow.js.pagespeed.jc.pMrMbVAe_E.js"></script>
	<script>
		eval(mod_pagespeed_gFRwwUbyVc);
	</script>
	<script>
		eval(mod_pagespeed_rQwXk4AOUN);
	</script>
	<script>
		eval(mod_pagespeed_U0OPgGhapl);
	</script>
	<script src="js/carousel.js%2bcustom.js.pagespeed.jc.nVhk-UfDsv.js"></script>
	<script>
		eval(mod_pagespeed_6Ja02QZq$f);
	</script>
	<script>
		eval(mod_pagespeed_KxQMf5X6rF);
	</script>
</body>

<!-- page-shop-cart00 GMT -->
</html>