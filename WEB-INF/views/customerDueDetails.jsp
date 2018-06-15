 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html lang="en">
    
<!-- Mirrored from coderthemes.com/velonic_2.1/admin_2/login.html by HTTrack Website Copier/3.x [XR&CO'2014], Tue, 15 Dec 2015 12:23:59 GMT -->
<head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">

        <link rel="shortcut icon" href="<c:url value="/resources/theme/img/favicon_1.ico" />">

        <title>Welcome To BGS</title>

        


        <!-- Bootstrap core CSS -->
        <link href="<c:url value="/resources/theme/css/bootstrap.min.css" />" rel="stylesheet">
        <link href="<c:url value="/resources/theme/css/bootstrap-reset.css"/>" rel="stylesheet">

        <!--Animation css-->
        <link href="<c:url value="/resources/theme/css/animate.css"/>" rel="stylesheet">

        <!--Icon-fonts css-->
        <link href="<c:url value="/resources/theme/assets/font-awesome/css/font-awesome.css"/>" rel="stylesheet" />
        <link href="<c:url value="/resources/theme/assets/ionicon/css/ionicons.min.css"/>" rel="stylesheet" />

        <!--Morris Chart CSS -->
        <link rel="stylesheet" href="<c:url value="/resources/theme/assets/morris/morris.css"/>">


        <!-- Custom styles for this template -->
        <link href="<c:url value="/resources/theme/css/style.css"/>" rel="stylesheet">
        <link href="<c:url value="/resources/theme/css/helper.css"/>" rel="stylesheet">
        

        <!-- HTML5 shim and Respond.js IE8 support of HTML5 tooltipss and media queries -->
<!--[if lt IE 9]>
  <script src="<c:url value="/resources/theme/js/html5shiv.js"/>"></script>
  <script src="<c:url value="/resources/theme/js/respond.min.js"/>"></script>
<![endif]-->
<style type="text/css">
#customer_due_table tr:hover {
    cursor: pointer;
    
}

</style>
<script>
  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
  })(window,document,'script','../../../www.google-analytics.com/analytics.html','ga');

  ga('create', 'UA-62751496-1', 'auto');
  ga('send', 'pageview');

</script>

    </head>
<body>
 <div class="row">
                    <div class="col-md-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title">Customer Due Details</h3>
                            </div>
                            <div class="panel-body">
                             <c:if test="${customerDueDetails ==null && searchHappen=='true'}">
				                    <p class="text-danger">No transaction found for this customer </p>
				             </c:if>  
                          <c:choose>
				             <c:when test="${customerDueDetails!=null}">
                            
                                <div class="row">
                                    <div class="col-md-12 col-sm-12 col-xs-12">
                                        <div class="table-responsive">
                                            <table class="table" id="customer_due_table">
                                                <thead>
											<tr>
												<th>CustomerId</th>
												<th>Godown #</th>
												<th>Name  </th>
												<th>Bill No.</th>
												<th>Bill Date</th>
												<th>Bill Amount</th>
												<th>Paid Amount</th>
												<th>Due Amount</th>
											</tr>
										</thead>
                                                <tbody>
											<c:forEach items="${customerDueDetails}" var="customerDue">
												<tr>
													<td>${customerDue.customerId}</td>
													<td>${customerDue.goddownNo}</td>
													<td>${customerDue.name}</td>
													<td>${customerDue.billNo}</td>
													<td>${customerDue.billDate}</td>
													<td>${customerDue.billAmount}</td>
													<td>${customerDue.paidAmount}</td>
													<td>${customerDue.dueAmount}</td>
<%-- 													<td>${customerDue.totalBalance}</td>
 --%>												</tr>
											</c:forEach>
										</tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </c:when>
                            </c:choose>
                            </div>
                            </div>
                            </div>
                            
                            </div>
         <script type="text/javascript">
		function addDataHandlers() {
			 var table = document.getElementById("customer_due_table");
			    var rows = table.getElementsByTagName("tr");
			    for(i = 0; i < rows.length; i++) {
			        var currentRow = table.rows[i];
			        var createClickHandler = function (row) {
			            return function () {
			                var cell = row.getElementsByTagName("td")[0];
			                var customerId = cell.innerHTML;
			                alert("customerId:" + id);
			                Customer.customerDueDetails(customerId);
			            };
			        };

			        currentRow.onclick = createClickHandler(currentRow);
			    }
		}
		window.onload = addDataHandlers();
		/* $('#manager').select2(); */
		</script>
                            </body>
                            </html>