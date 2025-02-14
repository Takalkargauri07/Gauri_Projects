<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<!--[if lt IE 7 ]><html class="ie ie6" lang="en"> <![endif]-->
<!--[if IE 7 ]><html class="ie ie7" lang="en"> <![endif]-->
<!--[if IE 8 ]><html class="ie ie8" lang="en"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!--><html lang="en"> <!--<![endif]-->

<!-- course-login40:16  -->
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<meta name="keywords" content="">
<title>Student Enhancement System for STES</title>
<link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon"/>
<link rel="apple-touch-icon" href="images/apple-touch-icon.png"/>
<link rel="apple-touch-icon" sizes="57x57" href="images/apple-touch-icon-57x57.png"/>
<link rel="apple-touch-icon" sizes="72x72" href="images/xapple-touch-icon-72x72.png.pagespeed.ic.lf5d8kCpOf.png"/>
<link rel="apple-touch-icon" sizes="76x76" href="images/xapple-touch-icon-76x76.png.pagespeed.ic.ATZZpSeito.png"/>
<link rel="apple-touch-icon" sizes="114x114" href="images/xapple-touch-icon-114x114.png.pagespeed.ic.Fi5O5s2tzL.png"/>
<link rel="apple-touch-icon" sizes="120x120" href="images/xapple-touch-icon-120x120.png.pagespeed.ic.uPQH0sygdV.png"/>
<link rel="apple-touch-icon" sizes="144x144" href="images/xapple-touch-icon-144x144.png.pagespeed.ic.yZ9-_sm5OF.png"/>
<link rel="apple-touch-icon" sizes="152x152" href="images/xapple-touch-icon-152x152.png.pagespeed.ic.gThaVrKtXF.png"/>
<link rel="apple-touch-icon" sizes="180x180" href="images/xapple-touch-icon-180x180.png.pagespeed.ic.Q8Pmsj5fQM.png"/>
<link rel="stylesheet" type="text/css" href="rs-plugin/css/A.settings.css.pagespeed.cf.xeOyGChsgq.css" media="screen"/>
<link rel="stylesheet" type="text/css" href="A.fonts%2c%2c_font-awesome-4.3.0%2c%2c_css%2c%2c_font-awesome.min.css%2bcss%2c%2c_bootstrap.css%2bcss%2c%2c_animate.css%2cMcc.kSNwpaaMDX.css.pagespeed.cf.w2G3xGgFf0.css"/>
<link rel="stylesheet" type="text/css" href="css/A.menu.css.pagespeed.cf.0_hLwXzYkZ.css">
<link rel="stylesheet" type="text/css" href="css/A.carousel.css.pagespeed.cf.VktteGiLwl.css">
<link rel="stylesheet" type="text/css" href="A.style.css%2bcss%2c%2c_custom.css%2cMcc.HvWh1qoob-.css.pagespeed.cf.pWH5huNcWh.css"/>
<script>
var stateObject = {
"FE": {
"Computer": ["", ""],
"IT": ["", ""],
},
"SE": {
	"Computer": ["", ""],
	"IT": ["", ""],	
}, "TE": {
	"Computer": ["", ""],
	"IT": ["", ""],
},
 "BE": {
	 "Computer": ["", ""],
	 "IT": ["", ""],

	},
}
window.onload = function () {
var countySel = document.getElementById("countySel"),
stateSel = document.getElementById("stateSel"),
districtSel = document.getElementById("districtSel");
for (var country in stateObject) {
	countySel.options[countySel.options.length] = new Option(country, country);
	}
	countySel.onchange = function () {
	stateSel.length = 1; // remove all options bar first
	
	if (this.selectedIndex < 1) return; // done 
	for (var state in stateObject[this.value]) {
	stateSel.options[stateSel.options.length] = new Option(state, state);
	}
	}
	countySel.onchange(); // reset in case page is reloaded
	stateSel.onchange = function () {
	
	if (this.selectedIndex < 1) return; // done 
	var district = stateObject[countySel.value][this.value];
	for (var i = 0; i < district.length; i++) {
	
	}
	}
	}
	</script>
</head>
<body class="login" style="background-image: url('images/IMG_6397.JPG');margin: 15px;background-size: 30-35% auto;">
<div id="loader">
<div class="loader-container">
<img src="images/site.gif" alt="" class="loader-site">
</div>
</div>
<div id="wrapper">
<div class="container">
<div class="row login-wrapper">
<div class="col-md-6 col-md-offset-3">
<div class="logo logo-center">
<a href="index-2.html"><img src="images/log.png" alt=""></a>
</div>
<div class="panel panel-login">
<div class="panel-heading">
<div class="row">
 <div class="col-xs-6">
<!-- <a href="#" class="active" id="login-form-link">Login</a> -->
</div>
 <div class="col-xs-6">
<!-- <a href="#" id="register-form-link">Register</a> -->
</div>
</div>
<hr>
</div>
<div class="panel-body">
<div class="row">
<div class="col-lg-12">
<form id="login-form" action=LoginPage method="post" role="form" style="display: block;">
<div class="form-group text-center">
<input type="radio"
						name="rdo1" required value="UserInfo" id="User" />&nbsp;Student&nbsp;&nbsp;<input
						type="radio" required name="rdo1" value="AuthorInfo" id="Author" />&nbsp;Admin&nbsp;&nbsp;
						<input 	type="radio" required name="rdo1" value="TeacherInfo" id="Owner" />&nbsp;Teacher
						
</div>
<div class="form-group">
<input type="text" name="username" id="username" tabindex="1" class="form-control" placeholder="Username" value="">
</div>
<div class="form-group">
<input type="password" name="password" id="password" tabindex="2" class="form-control" placeholder="Password">
</div>

<div class="form-group">
<div class="row">
<div class="col-sm-12">
<button type="submit" class="form-control btn btn-default">Login Account</button>
</div>
</div>
</div>

</form>
<form id="register-form" action="StudentRegister" method="post" role="form" style="display: none;">
<div class="form-group text-center">
<input type="radio"
						name="rdo1" required value="UserInfo" id="User" />&nbsp;Student&nbsp;&nbsp;
						<input 	type="radio" required name="rdo1" value="TeacherInfo" id="Owner" />&nbsp;Teacher
						
</div>
<div class="form-group">
<label>Select Level</label>
<select name="stdlevel" id="countySel" size="1" class="form-control" onchange="this.form.submit()">
<option value="" selected="selected">select Level</option>
</select>
</div>
<div class="form-group">
<label>Select Class</label>
<select name="stdclass" id="stateSel" size="1" class="form-control">
<option value="" selected="selected">Selected class</option>
</select>
</div>
<div class="form-group">
<label>Select Section</label>
<select class="form-control" class="form-control" id="Group1" name="section_data" required>
													<option>Select Section.</option>
													<option value="A">A</option>
													<option value="B">B</option>
													<option value="C">C</option>
													
											</select>
</div>
<div class="form-group">
<label>User Name</label>
<input type="text" required  pattern="[a-zA-z\\s]*"  name="txtName" class="form-control"  />
</div>
<div class="form-group">
<label>Address</label>
<input type="text" name="txtAddress" class="form-control" required="" />
</div>
<div class="form-group">
<label>Select Gender</label>
<select class="form-control" class="form-control" id="male" name="rdoGender" required>
													<option>Select Gender</option>
													<option value="Male">Male</option>
													<option value="Female">Female</option>
											</select>
</div>
<div class="form-group">
<label>Email ID</label>
<input type="text" required="" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" name="txtEmail" class="form-control" />
</div>
<div class="form-group">
<label>Contact No</label>
<input type="text" required="" pattern="[7-9]{1}[0-9]{9}" maxlength="10" title="Not a valid Phone Number" name="txtContact" class="form-control" />
</div>
<div class="form-group">
<label>Password</label>
<input type="password" required="" name="passPassword" class="form-control" />
</div>
<div class="form-group">
<label>Subject</label>
<input type="text" required  name="txtsubject" class="form-control"  />
</div>
<input type="submit" value="Save Details" class="btn btn-primary" />
</form>
</div>
</div>
</div>
</div>
</div>
</div>
</div>
</div>
<script src="js/jquery.min.js.pagespeed.jm.iDyG3vc4gw.js"></script>
<script src="js/bootstrap.min.js%2bretina.js%2bwow.js.pagespeed.jc.pMrMbVAe_E.js"></script><script>eval(mod_pagespeed_gFRwwUbyVc);</script>
<script>eval(mod_pagespeed_rQwXk4AOUN);</script>
<script>eval(mod_pagespeed_U0OPgGhapl);</script>
<script src="js/carousel.js%2bcustom.js.pagespeed.jc.nVhk-UfDsv.js"></script><script>eval(mod_pagespeed_6Ja02QZq$f);</script>
<script>eval(mod_pagespeed_KxQMf5X6rF);</script>
</body>

<!-- course-login40:17  -->
</html>