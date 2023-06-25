<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section id="client">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th scope="col">Id</th>
                            <th scope="col">First name</th>
                            <th scope="col">Last name</th>
                            <th scope="col">Email</th>
                            <th scope="col">Phone Number</th>
                            <th scope="col">Balance</th>
                            <th scope="col">Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="client" items="${clients}">

                            <tr>
                                <th>${client.id}</th>
                                <td>${client.name}</td>
                                <td>${client.lastname}</td>
                                <td>${client.email}</td>
                                <td>${client.phoneNumber}</td>
                                <td>${client.balance}</td>
                                <td>
                                    <a class="btn btn-info" href="#" role="button">View</a>
                                    <a class="btn btn-warning" href="#" role="button">Edit</a>
                                    <a class="btn btn-danger" href="#" role="button">Delete</a>
                                </td>
                            </tr>
                        </c:forEach>

                    </tbody>
                </table>
            </div>
        </div>
    </div>

</section>