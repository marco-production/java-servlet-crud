<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
        <title>Client list</title>
    </head>
    <body>
        <!-- Header -->
        <jsp:include page="../WEB-INF/components/header.jsp">
            <jsp:param name="title" value="Client Details"></jsp:param>
        </jsp:include>

        <section id="client-details" class="mt-5">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="card" style="width: 18rem;">
                            <ul class="list-group list-group-flush">
                              <li class="list-group-item"><b>Id:</b> ${client.id}</li>
                              <li class="list-group-item"><b>First name:</b> ${client.name}</li>
                              <li class="list-group-item"><b>Last name:</b> ${client.lastname}</li>
                              <li class="list-group-item"><b>Email:</b> ${client.email}</li>
                              <li class="list-group-item"><b>Phone Number:</b> ${client.phoneNumber}</li>
                              <li class="list-group-item"><b>Balance:</b> ${client.balance}</li>
                              <li class="list-group-item"><b>Created at:</b> ${client.createdAt}</li>
                              <li class="list-group-item"><b>Updated at:</b> ${client.updatedAt}</li>
                            </ul>
                        </div>
                        <br>
                        <a class="btn btn-secondary" href="${pageContext.request.contextPath}/ClientController" role="button">Go back</a>
                    </div>
                </div>
            </div>

        </section>

        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js" integrity="sha384-fbbOQedDUMZZ5KreZpsbe1LCZPVmfTnH7ois6mU1QK+m14rQ1l2bGBq41eYeM/fS" crossorigin="anonymous"></script>
    </body>
</html>
