<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Piattaforma di Recruitment</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <!--codice di bootstra />-->

    <style>

        html,body, .container,.full-height{
            height:100%;
        }

        #logo{
            width: 100%;
            height: auto;
            padding-top: 60px;
        }
        #linea{
            width: 100%;
            height:9px;
        }

        #username{
            margin-top:90px;
        }


        #login{
            margin-top:80px;
            margin-left:20px;
        }


        #frasedue{
            color:#ffffff;
            padding-left:220px;
            padding-top:247px;
            font-size:70pt;
        }

        #frasetre{
            color:#ffffff;
            padding-left:235px;
            padding-top:10px;
            font-size:28pt;
        }

        #username{
            border-color:#ffffff;

        }

        #pwd{
            border-color:#ffffff;
        }


    </style>

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" >
    <title>Documento senza titolo</title>
</head>
<body>
<div class="container col-xs-12 col-sm-12 col-md-12 col-lg-12">
    <div class="col-xs-12 col-sm-6 col-md-6 col-lg-4 full-height">
        <form action="LoginServlet" method="post">
        <div class="row">
            <div class="col-lg-1">
            </div>
            <div class="col-lg-10">
                <img id="logo" src="logoapp.png"/>
            </div>
            <div class="col-lg-1">
            </div>
        </div>
        <div class="row">
            <div class="col-lg-1">
            </div>
            <div class="col-lg-10">
                <div class="form-group">
                    <input type="text" class="form-control" id="username" placeholder="Username" name="user">
                </div>
            </div>
            <div class="col-lg-1">
            </div>
        </div>

        <div class="row">
            <div class="col-lg-1">
            </div>
            <div class="col-lg-10" >
                <div class="form-group">
                    <img src="linea.png" id="linea"/>
                </div>
            </div>
            <div class="col-lg-1">
            </div>
        </div>

        <div class="row">
            <div class="col-lg-1">
            </div>
            <div class="col-lg-10">
                <div class="form-group">
                    <input type="password" class="form-control" id="pwd" placeholder="Password" name="pwd">
                </div>
            </div>
            <div class="col-lg-1">
            </div>
        </div>

        <div class="row">
            <div class="col-lg-1">
            </div>
            <div class="col-lg-4">
                <div class="checkbox">
                    <label><input type="checkbox"> Remember me</label>
                </div>
            </div>
            <div class="col-lg-2">
            </div>
            <div class="col-lg-4">
                <div class="link">
                    <label><a id="m_login_forget_password" class="m-link">Forgot Password</a></label>
                </div>
            </div>
            <div class="col-lg-1">
            </div>
        </div>
        <div class="row">
            <div class="col-lg-4">
            </div>
            <div class="col-lg-4">
                <div class="form-group">
                    <button type="submit" id="login" value="Login" name="bott">Log In</button>
                </div>
            </div>
            <div class="col-lg-4" >
            </div>
        </div>
        </form>

<a href="registrazioneCandidato.jsp">Registrati</a>

<button type="submit" formaction="/registrazioneCandidato.jsp">Registrati</button>



        <div class="row">
            <div class="col-lg-1">
            </div>
            <div class="col-lg-10">
                <%if (session.getAttribute("esitoLogin") != null)
                {
                %>
                <div class="alert alert-danger alert-dismissible fade in">
                    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                    <strong>Login errato!</strong>
                </div>
                <%}%>
            </div>
            <div class="col-lg-1" >
            </div>
        </div>
    </div>

    <div class="col-xs-12 col-sm-6 col-md-6 col-lg-8 full-height" style="background-image:url('fondotre.jpg')">
        <!-- e responsiv 		in celulare, tablet, laptop e PC
        <img src="fondotre.jpg" id="fondo" />-->

        <h1 id="frasedue">ISCRIVITI</h1>
        <h2 id="frasetre">e scopri i nostri vantaggi.</h2>
    </div>
</div>
</body>
</html>