<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang=it-IT>
<head>
<title>MENU OFFICINA</title>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

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
	footer{    position: absolute;
    background-color: #a2a2a2;
    color: red;
    bottom: 0;
    width: 100%;}
	footer a{color:white;}
</style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">Home</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
	<li class="nav-item">
        <a class="nav-link" href="utenti.html">Utenti</a>
      </li>
	 <li class="nav-item">
        <a class="nav-link" href="#">Auto</a>
      </li> 
	  <li class="nav-item">
        <a class="nav-link" href="#">Dispositivi</a>
      </li> 
	  <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="submenuutenti" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Scadenze
        </a>
        <div class="dropdown-menu" aria-labelledby="submenuutenti">
          <a class="dropdown-item" href="#">Amministrative</a>
          <a class="dropdown-item" href="#">Noleggio</a>
        
        </div>
      </li>
	   <li class="nav-item">
        <a class="nav-link" href="#">Guasti</a>
      </li>
	  
	  
  
    </ul>
    <form class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>
  </div>
</nav>

<section class="content-header">
<div class=container>
<div class=row>
<div class=col-md-3>
<div class="info-box">
            <span class="info-box-icon bg-aqua">109943</span>

            <div class="info-box-content">
              <span class="info-box-text">GUASTI</span>
            
            </div>
            <!-- /.info-box-content -->
          </div>
</div>
<div class=col-md-3>
<div class="info-box">
            <span class="info-box-icon bg-aqua">10</span>

            <div class="info-box-content">
              <span class="info-box-text">SCADENZE</span>
             
            </div>
            <!-- /.info-box-content -->
          </div>
</div>
<div class=col-md-3>
<div class="info-box">
            <span class="info-box-icon bg-aqua">10</span>

            <div class="info-box-content">
              <span class="info-box-text">APPUNTAMENTI</span>
             
            </div>
            <!-- /.info-box-content -->
          </div>
</div>
<div class=col-md-3>
<div class="info-box">
            <span class="info-box-icon bg-aqua">10</span>

            <div class="info-box-content">
              <span class="info-box-text">PREVENTIVI</span>
            
            </div>
            <!-- /.info-box-content -->
          </div>
</div>
</div>
</div>
</section>
<!--
<div id=main-container class=container>
<p class=ptitolomenu style=color:black;>VIANELLO'S PROJECT</p>
<p class=ptitolomenu>MENU'</p>
<ol id=ulmenu>
<li><a href="autoguasti.html"> Visualizza auto con guasti</a></li>
<li>Visualizza lista utenti</li>
<li>Visualizza auto dell'azienda</li>
<li>Visualizza tutti i dispositivi</li>
<li>VISUALIZZA AUTO CON REVISIONE IN SCADENZA</li>
<li>AGGIUNGI NUOVA AUTO DELL'AZIENDA</li>
<li>LOG OUT</li>
</ol>

</div>

<div id=alerts-container >
<p id=palerts>Notifiche</p>
<a href="notifiche.html">Hai 5 notifiche.</a>

</div>
-->

<!--Footer-->
<footer class="page-footer font-small blue pt-4 mt-4">

    <!--Footer Links-->
    <div class="container-fluid text-center text-md-left">
        <div class="row">

            <!--First column-->
            <div class="col-md-6">
                <h5 class="text-uppercase">Footer Content</h5>
                <p>Here you can use rows and columns here to organize your footer content.</p>
            </div>
            <!--/.First column-->

            <!--Second column-->
            <div class="col-md-6">
                <h5 class="text-uppercase">Links</h5>
                <ul class="list-unstyled">
                    <li>
                        <a href="#!">Link 1</a>
                    </li>
                    <li>
                        <a href="#!">Link 2</a>
                    </li>
                    <li>
                        <a href="#!">Link 3</a>
                    </li>
                    <li>
                        <a href="#!">Link 4</a>
                    </li>
                </ul>
            </div>
            <!--/.Second column-->
        </div>
    </div>
    <!--/.Footer Links-->

    <!--Copyright-->
    <div class="footer-copyright py-3 text-center">
        Â© 2018 Copyright:
        <a href="https://mdbootstrap.com/material-design-for-bootstrap/"> MDBootstrap.com </a>
    </div>
    <!--/.Copyright-->

</footer>
<!--/.Footer-->
</body>
</html>


