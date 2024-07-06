<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>

<%@page import="java.sql.Connection"%>
<%@page import="java.io.BufferedWriter"%>
<%@page import="java.io.FileWriter"%>
<%@page import="java.net.NetworkInterface"%>
<%@page import="java.net.InetAddress"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.sql.PreparedStatement"%>
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
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<!--[if lt IE 7 ]><html class="ie ie6" lang="en"> <![endif]-->
<!--[if IE 7 ]><html class="ie ie7" lang="en"> <![endif]-->
<!--[if IE 8 ]><html class="ie ie8" lang="en"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!-->
<html lang="en">
<!--<![endif]-->

<!-- page-shop-cart40:58 GMT -->
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<meta name="keywords" content="">
<title>LearnPLUS | Learning Management System HTML Template</title>
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
								<li><a href="AdminPage.jsp">Home</a></li>
								<li><a href="TeacherRPage.jsp">Teacher Register</a></li>
								<li><a href="NoticesPage.jsp">Notices</a></li>
								<li><a href="TimeTablePage.jsp">TimeTable</a></li>
								<li><a href="StudentAttendanceReport.jsp">Attendance
										Report</a></li>
								<li><a href="Admin_ShowdoubtsPage.jsp">Show Doubts</a></li>
								<li><a href="LoginPage">LogOut</a></li>
							</ul>
							<ul class="nav navbar-nav navbar-right">
								<li><a class="btn btn-primary" href="LoginPage"><i
										class="fa fa-sign-in"></i> Admin Page</a></li>
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
									<h1>Show Doubts</h1>
								</div>
								<div class="col-md-6 text-right">
									<div class="bread">
										<ol class="breadcrumb">
											<li><a href="#">Home</a></li>
											<li class="active">Show Doubts Info</li>
										</ol>
									</div>
								</div>
							</div>
						</div>
						<div class="blog-wrapper">
							<div class="blog-desc">
								<div class="shop-cart">
									<div class="edit-profile">
										<table class="table">
											<thead>
												<tr>
													<th><h3>Student Email</h3></th>
													<th><h3>Student Mobile No</h3></th>
													<th><h3>Cast</h3></th>
													<th><h3>Total Fee</h3></th>
													<th><h3>Paid Fee</h3></th>
													<th><h3>Account No</h3></th>
													<th><h3>Date</h3></th>
													<th><h3>Transaction_ID</h3></th>
													

												</tr>
											</thead>
											<tbody>
												<%
													Connection connection = Dbconn.conn();
													Statement statement = connection.createStatement();
									ResultSet resultset =statement.executeQuery("select * from student_fee") ; 
													while (resultset.next()) {
												%>
												<tr>
													 <td> <%= resultset.getString("Student_Email_ID") %> </td>
           <td> <%= resultset.getString("Student_Mobile_No") %> </td>
           
              <td> <%= resultset.getString("Cast_Name") %> </td>
           <td> <%= resultset.getString("Amount") %> </td>
              <td> <%= resultset.getString("Paid_Fee") %> </td>
              <td> <%= resultset.getString("Account_No") %> </td>
              <td><%=resultset.getString("Date_time_Data") %></td>
               <td><%=resultset.getString("Transaction_ID") %></td>
												</tr>
												<%
													}
												%>
											</tbody>
										</table>



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