<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.io.BufferedWriter"%>
<%@page import="java.io.FileWriter"%>
<%@page import="java.net.NetworkInterface"%>
<%@page import="java.net.InetAddress"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.util.Calendar"%>
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
						<p><jsp:include page="title.jsp"></jsp:include> </p>
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
									data-toggle="dropdown" class="dropdown-toggle">Upload Data
										<b class="fa fa-angle-down"></b>
								</a>
									<ul class="dropdown-menu">
										<li>
											<div class="ttmenu-content">
												<div class="row">
													<div class="col-md-6">
														<div class="box">
															<ul>
																<li><a href="QUploadPage.jsp">Add Assignment</a></li>
																<li><a href="T_NotesUploadPage.jsp">Upload
																		Notes</a></li>
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
									<h1>Show Time Table Info</h1>
								</div>
								<div class="col-md-6 text-right">
									<div class="bread">
										<ol class="breadcrumb">
											<li><a href="#">Home</a></li>
											<li class="active">Show Time Table Info</li>
										</ol>
									</div>
								</div>
							</div>
						</div>
						<div class="blog-wrapper">
							<div class="blog-desc">
								<div class="shop-cart">
									<div class="edit-profile">
										<form name="form1" action=T_TimeTablePage.jsp method="post">
											<table class="table">
												<tr style="width: 404px;">
													<td class="lable">Select Year:</td>
													<td><select name="stdlevel" id="countySel" size="1"
														class="form-control" onchange="this.form.submit()">
															<option value="" selected="selected">select
																Year</option>
													</select></td>
												</tr>
												<tr style="width: 404px;">
													<td class="lable">Select Department:</td>
													<td><select name="stdclass" id="stateSel" size="1"
														class="form-control">
															<option value="" selected="selected">Selected
																Department</option>
													</select></td>
												</tr>
												<tr style="width: 404px;">
													<td class="lable">Select Division:</td>
													<td><select class="form-control" class="form-control"
														id="Group1" name="section_data" required>
															<option>Select Division.</option>
															<option value="A">A</option>
															<option value="B">B</option>
															<option value="C">C</option>

													</select></td>

												</tr>
												<tr>

													<td colspan="2" align="center"><input type="submit"
														value="Search" style="height: 30px;" /></td>
												</tr>
											</table>
										</form>
										<%
											String state = request.getParameter("stdlevel");
											String countrya = request.getParameter("stdclass");
											String section_data = request.getParameter("section_data");
											System.out.println("Level=>" + state);
											String timedata = "8:00-8:45" + "@" + "8:45-9:30" + "@"
													+ "9:30-10:00" + "@" + "10:00-10:45" + "@" + "10:45-11:30"
													+ "@" + "11:30-12:15" + "@" + "12:15-1:00";
											String[] t1 = timedata.split("@");
											if (state == null) {

											} else if (state.equals("FE")) {
												
										%>
										<table class="table">
											<tr>
												<td>Day</td>
												<td><%=t1[0]%></td>
												<td><%=t1[1]%></td>
												<td><%=t1[2]%></td>
												<td><%=t1[3]%></td>
												<td><%=t1[4]%></td>
												<td><%=t1[5]%></td>
											</tr>
											<%
												Connection con = Dbconn.conn();
													Statement stfifo2 = con.createStatement();
													ResultSet rs;
													rs = stfifo2
															.executeQuery("select * from tblmastertime where stdlevel='"
																	+ state
																	+ "' and classname='"
																	+ countrya
																	+ "' and section_data='" + section_data + "'");

													while (rs.next()) {
											%>


											<tr>
												<td><%=rs.getString(1)%></td>
												<td><%=rs.getString(2)%></td>
												<td><%=rs.getString(3)%></td>
												<td><%=rs.getString(4)%></td>
												<td><%=rs.getString(5)%></td>
												<td><%=rs.getString(6)%></td>
												<td><%=rs.getString(7)%></td>
											</tr>
											<%
												}
											%>
										</table>

										<%
											} else if (state.equals("SE")) {
												System.out.println("Level=>" + state);
										%>

										<table class="table">
											<tr>
												<td>Day</td>
												<td><%=t1[0]%></td>
												<td><%=t1[1]%></td>
												<td><%=t1[2]%></td>
												<td><%=t1[3]%></td>
												<td><%=t1[4]%></td>
												<td><%=t1[5]%></td>
												<td><%=t1[6]%></td>

											</tr>
											<%
												Connection con = Dbconn.conn();
													Statement stfifo2 = con.createStatement();
													ResultSet rs;
													String stdid = (String) session.getAttribute("stdid");
													rs = stfifo2
															.executeQuery("select * from tblmastertime where stdlevel='"
																	+ state
																	+ "' and classname='"
																	+ countrya
																	+ "' and section_data='" + section_data + "'");

													while (rs.next()) {
											%>


											<tr>
												<td><%=rs.getString(1)%></td>
												<td><%=rs.getString(2)%></td>
												<td><%=rs.getString(3)%></td>
												<td><%=rs.getString(4)%></td>
												<td><%=rs.getString(5)%></td>
												<td><%=rs.getString(6)%></td>
												<td><%=rs.getString(7)%></td>
												<td><%=rs.getString(8)%></td>
											</tr>
											<%
												}
											%>
										</table>
										<%
											} else if (state.equals("TE")) {
												System.out.println("Level=>" + state);
										%>
										<table class="table">
											<tr>
												<td>Day</td>
												<td><%=t1[0]%></td>
												<td><%=t1[1]%></td>
												<td><%=t1[2]%></td>
												<td><%=t1[3]%></td>
												<td><%=t1[4]%></td>
												<td><%=t1[5]%></td>


											</tr>
											<%
												Connection con = Dbconn.conn();
													Statement stfifo2 = con.createStatement();
													ResultSet rs;
													//String stdid=(String)session.getAttribute("stdid");
													rs = stfifo2
															.executeQuery("select * from tblmastertime where stdlevel='"
																	+ state
																	+ "' and classname='"
																	+ countrya
																	+ "' and section_data='" + section_data + "'");

													while (rs.next()) {
											%>


											<tr>
												<td><%=rs.getString(1)%></td>
												<td><%=rs.getString(2)%></td>
												<td><%=rs.getString(3)%></td>
												<td><%=rs.getString(4)%></td>
												<td><%=rs.getString(5)%></td>
												<td><%=rs.getString(6)%></td>
												
											</tr>
											<%
												}
											%>
										</table>
										<%
											} else if (state.equals("BE")) {
												System.out.println("Level=>" + state);
										%>
										<table style="width: 100%" border="1">
											<tr>
												<td>Day</td>
												<td><%=t1[0]%></td>
												<td><%=t1[1]%></td>
												<td><%=t1[2]%></td>
												<td><%=t1[3]%></td>
												<td><%=t1[4]%></td>


											</tr>
											<%
												Connection con = Dbconn.conn();
													Statement stfifo2 = con.createStatement();
													ResultSet rs;
													String stdid = (String) session.getAttribute("stdid");
													rs = stfifo2
															.executeQuery("select * from tblmastertime where stdlevel='"
																	+ state
																	+ "' and classname='"
																	+ countrya
																	+ "' and section_data='" + section_data + "'");

													while (rs.next()) {
											%>


											<tr>
												<td><%=rs.getString(1)%></td>
												<td><%=rs.getString(2)%></td>
												<td><%=rs.getString(3)%></td>
												<td><%=rs.getString(4)%></td>
												<td><%=rs.getString(5)%></td>
												<td><%=rs.getString(6)%></td>
											</tr>
											<%
												}
											%>
										</table>
										<%
											}
										%>



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