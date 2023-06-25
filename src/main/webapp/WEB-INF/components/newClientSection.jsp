<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<section class="bg-light py-4 mb-4">
    <div class="container">
        <div class="row">
            <div class="col-md-6">
               <button type="button" class="btn btn-success" data-bs-toggle="modal" data-bs-target="#exampleModal">
                + Add new client
              </button>
            </div>
            <div class="col-md-3">
                <div class="card text-bg-primary mb-3 text-center" style="max-width: 18rem;">
                    <div class="card-header">Saldo Total</div>
                    <div class="card-body">
                        <p class="card-text"><fmt:formatNumber value="${totalBalance}" type="currency" /></p>
                    </div>
                </div>
            </div>
            <div class="col-md-3">
                <div class="card text-bg-danger mb-3 text-center" style="max-width: 18rem;">
                    <div class="card-header">Cantidad de clientes</div>
                    <div class="card-body">
                        <p class="card-text">${totalClients}</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>