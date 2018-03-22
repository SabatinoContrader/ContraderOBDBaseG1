<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html lang=it-IT>
<head>
<title>LOGIN</title>
<script
  src="https://code.jquery.com/jquery-3.3.1.min.js"
  integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
  crossorigin="anonymous"></script>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/bs4/dt-1.10.16/cr-1.4.1/r-2.2.1/datatables.min.css"/>
 


 
<script type="text/javascript" src="https://cdn.datatables.net/v/bs4/dt-1.10.16/cr-1.4.1/r-2.2.1/datatables.min.js"></script>
<style>
#main-container{
margin-left:20%;

width:60%;
position:absolute;
background-color:#a2a2a2;

top:10;
}
#alerts-container{
width:60%;
margin-left:20%;
height:100px;
background-color:red;
position:absolute;
bottom:0;
text-align:center;
}
#palerts,.ptitolomenu{
text-transform:uppercase;
color:white;
font-size:24px;
text-align:center;
}
#ulmenu{
    text-align: center;
    list-style: none;
    padding-left: 0;}
#ulmenu li,#ulmenu li a{
text-transform:uppercase;
color:white;
cursor:pointer;
padding:10;
text-decoration:none;}
#ulmenu li:hover,#ulmenu li a:hover{
color:red;}
.info-box{
display: block;
    min-height: 90px;
    background: #fff;
    width: 100%;
    box-shadow: 0 1px 1px rgba(0,0,0,0.1);
    border-radius: 2px;
    margin-bottom: 15px;}
	.info-box-icon{
	    border-top-left-radius: 2px;
    border-top-right-radius: 0;
    border-bottom-right-radius: 0;
    border-bottom-left-radius: 2px;
    display: block;
    height: 90px;
 
    text-align: center;
    font-size: 45px;
    line-height: 90px;
    background: rgba(0,0,0,0.2);
	}
	.bg-aqua{background-color:#00c0ef !important;color:white;font-size:22px;}
	.content-header{    position: relative;
    padding: 15px 15px 0 15px;}
	footer{    
    background-color: #a2a2a2;
    color: red;
    bottom: 0;
    width: 100%;}
	footer a{color:white;}
	.container .container-fluid{    padding-top: 50px;
    padding-bottom: 50px;}
	
.card-container.card {
    max-width: 350px;
    padding: 40px 40px;
}

.btn {
    font-weight: 700;
    height: 36px;
    -moz-user-select: none;
    -webkit-user-select: none;
    user-select: none;
    cursor: default;
}

/*
 * Card component
 */
.card {
    background-color: #F7F7F7;
    /* just in case there no content*/
    padding: 20px 25px 30px;
    margin: 0 auto 25px;
    margin-top: 50px;
    /* shadows and rounded borders */
    -moz-border-radius: 2px;
    -webkit-border-radius: 2px;
    border-radius: 2px;
    -moz-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
    -webkit-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
    box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
}

.profile-img-card {
    width: 96px;
    height: 96px;
    margin: 0 auto 10px;
    display: block;
    -moz-border-radius: 50%;
    -webkit-border-radius: 50%;
    border-radius: 50%;
}

/*
 * Form styles
 */
.profile-name-card {
    font-size: 16px;
    font-weight: bold;
    text-align: center;
    margin: 10px 0 0;
    min-height: 1em;
}

.reauth-email {
    display: block;
    color: #404040;
    line-height: 2;
    margin-bottom: 10px;
    font-size: 14px;
    text-align: center;
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
    -moz-box-sizing: border-box;
    -webkit-box-sizing: border-box;
    box-sizing: border-box;
}

.form-signin #inputEmail,
.form-signin #inputPassword {
    direction: ltr;
    height: 44px;
    font-size: 16px;
}

.form-signin input[type=email],
.form-signin input[type=password],
.form-signin input[type=text],
.form-signin button {
    width: 100%;
    display: block;
    margin-bottom: 10px;
    z-index: 1;
    position: relative;
    -moz-box-sizing: border-box;
    -webkit-box-sizing: border-box;
    box-sizing: border-box;
}

.form-signin .form-control:focus {
    border-color: rgb(104, 145, 162);
    outline: 0;
    -webkit-box-shadow: inset 0 1px 1px rgba(0,0,0,.075),0 0 8px rgb(104, 145, 162);
    box-shadow: inset 0 1px 1px rgba(0,0,0,.075),0 0 8px rgb(104, 145, 162);
}

.btn.btn-signin {
    /*background-color: #4d90fe; */
    background-color: rgb(104, 145, 162);
    /* background-color: linear-gradient(rgb(104, 145, 162), rgb(12, 97, 33));*/
    padding: 0px;
    font-weight: 700;
    font-size: 14px;
    height: 36px;
    -moz-border-radius: 3px;
    -webkit-border-radius: 3px;
    border-radius: 3px;
    border: none;
    -o-transition: all 0.218s;
    -moz-transition: all 0.218s;
    -webkit-transition: all 0.218s;
    transition: all 0.218s;
}

.btn.btn-signin:hover,
.btn.btn-signin:active,
.btn.btn-signin:focus {
    background-color: rgb(12, 97, 33);
}

.forgot-password {
    color: rgb(104, 145, 162);
}

.forgot-password:hover,
.forgot-password:active,
.forgot-password:focus{
    color: rgb(12, 97, 33);
}
#titlogin{   
 text-align: center;
    color: #5c7f8e;
    font-weight: bold;
    font-size: 32px;}
</style>
</head>
	<%@ page import = "com.project.model.*" %>
<%
Utente u = (Utente)session.getAttribute("Utente");
if(u != null ){
	switch(u.getRuolo()){
	case 0:
		response.sendRedirect("utente_home.jsp");
		break;
	case 1:
		response.sendRedirect("home_officina");
	break;
	case 2:
		response.sendRedirect("home_admin");
		break;
	case 3:
		//INFINITE LOOP, FAME DA LOOP
		//TO DO
	case 4:
		response.sendRedirect("home_cliente-business_admin.jsp");
		break;
		
	}
} %>
<body>
  <div class="container">
        <div class="card card-container">
            <!-- <img class="profile-img-card" src="//lh3.googleusercontent.com/-6V8xOA6M7BA/AAAAAAAAAAI/AAAAAAAAAAA/rzlHcD0KYwo/photo.jpg?sz=120" alt="" /> -->
           <!-- <img id="profile-img" class="profile-img-card" src="//ssl.gstatic.com/accounts/ui/avatar_2x.png" />-->
		   <p id=titlogin>Accedi</p>
            <p id="profile-name" class="profile-name-card"></p>
            <form class="form-signin" action="LogInServlet" method = "POST">
                <span id="reauth-email" class="reauth-email"></span>
                <input type="text" id="inputEmail" class="form-control" placeholder="Email address" autofocus name="email">
                <input type="password" id="inputPassword" class="form-control" placeholder="Password" name="pwd">
              
                <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit" value="Login" name="butt">Sign in</button>
            </form><!-- /form -->
         
        </div><!-- /card-container -->
    </div><!-- /container -->


</body>
</html>


