  
  
  
  <jsp:include page="Header.jsp"/>
  
  
  <!--INIZIO CONTAINER CENTRALE-->
        <div id="container-centrale">
            <div class="login-clean">
                <form method="GET" action="Login">
                    <h2 class="sr-only">Login Form</h2>
                    <div class="illustration">
                        <img src="profilo.png" width="50%">
                    </div>
                    <div class="form-group">
                        <input class="form-control" type="email" name="email"  placeholder="Email" />
                    </div>
                    <div class="form-group">
                        <input class="form-control" type="password" name="password" placeholder="Password" />
                    </div>
                    <div class="form-group">
                        <button class="btn btn-secondary btn-block" type="submit">Log In</button>
                    </div>
                </form>
            </div>
        </div>
<!--FINE CONTAINER CENTRALE-->
    <jsp:include page="Footer.jsp"/>