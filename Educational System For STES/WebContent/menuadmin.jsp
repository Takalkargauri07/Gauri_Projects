<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<ul class="sf-menu dropdown">
		<li><a href="AdminPage.jsp">Home</a></li>
		<li><a class="has_submenu" href="#">Register</a>
			<ul>
				<li><a href="StudentPage.jsp">Student Register</a></li>
				<li><a href="TeacherRPage.jsp">Teacher Register</a></li>

			</ul></li>
			
		<li><a href="NoticesPage.jsp">Notices</a></li>


		<li><a href="TimeTablePage.jsp">TimeTable</a></li>
		<li><a class="has_submenu" href="#">Report</a>
			<ul>
				
				<li><a href="StudentAttendanceReport.jsp">Attendance Report</a></li>

			</ul></li>
<li><a class="has_submenu" href="#">Show Doubts Data</a>
			<ul>
				<li><a href="Admin_ShowdoubtsPage.jsp">Show Doubts
				</a></li>


			</ul></li>
		<li><a href="LoginPage">LogOut</a></li>

	</ul>

</body>
</html>