<%  String role = (String) session.getAttribute("role");
            String id = (String) session.getAttribute("id");
            String username = (String) session.getAttribute("username");
            session.setAttribute("buttoncheck", false); %>
    <% if ( role != null && id != null ) { %>
        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="home.jsp">Contrader | OBD project</a>
            </div>
            <!-- /.navbar-header -->

            <ul class="nav navbar-top-links navbar-right">
                <!-- /.dropdown -->
                <li>
                    <a href="javascript:{}" onclick="document.getElementById('logout').submit(); return false;">
                        <i class="fa fa-sign-out fa-fw"></i> Logout
                    </a>
                    <form action="MainDispatcherServlet" method="post" id="logout">
                        <input value="Logout:Logout" name="button" type="hidden">
                    </form>
                </li>
            </ul>
            <!-- /.navbar-top-links -->

            <%@ include file = "nav.jsp" %>

                <!-- /.navbar-static-side -->
        </nav>
        <% } else { 
        session.setAttribute("view", "index.jsp");
        response.sendRedirect("index.jsp"); } %>