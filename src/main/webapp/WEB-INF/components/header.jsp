<%
    String title = request.getParameter("title");
%>

<header id="main-header" class="py-2 bg-primary text-white">
    <div class="container">
        <div class="row">
            <div class="col-md-6">
                <h1><%= title %></h1>
            </div>
        </div>
    </div>
</header>