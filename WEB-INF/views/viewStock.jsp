<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@ page session="false" %>
<html lang="en">
    
<!-- Mirrored from coderthemes.com/velonic_2.1/admin_2/table-datatable.html by HTTrack Website Copier/3.x [XR&CO'2014], Tue, 15 Dec 2015 12:23:05 GMT -->
<head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">

        <link rel="shortcut icon" href="<c:url value="/resources/theme/img/favicon_1.ico" />">

        <title>WelCome To BGS</title>

        


        <!-- Bootstrap core CSS -->
        <link href="<c:url value="/resources/theme/css/bootstrap.min.css"/>" rel="stylesheet">
        <link href="<c:url value="/resources/theme/css/bootstrap-reset.css"/>" rel="stylesheet">

         <!--Animation css-->
        <link href="<c:url value="/resources/theme/css/animate.css"/>" rel="stylesheet">

        <!--Icon-fonts css-->
        <link href="<c:url value="/resources/theme/assets/font-awesome/css/font-awesome.css"/>" rel="stylesheet" />
        <link href="<c:url value="/resources/theme/assets/ionicon/css/ionicons.min.css"/>" rel="stylesheet" />

        <!-- DataTables 
        <link href="<c:url value="/resources/theme/assets/datatables/jquery.dataTables.min.css"/>" rel="stylesheet" type="text/css" />
       -->
        <!-- Responsive-table -->
        <link href="<c:url value="/resources/theme/assets/responsive-table/rwd-table.min.css"/>" rel="stylesheet" type="text/css" media="screen"/>
        
        
         <!-- Plugins css -->
        <link href="<c:url value="/resources/theme/assets/modal-effect/css/component.css"/>" rel="stylesheet">
		<link href="<c:url value="/resources/theme/assets/timepicker/bootstrap-datepicker.min.css"/>" rel="stylesheet" />
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/theme/assets/select2/select2.css"/>" />


        <!-- Custom styles for this template -->
        <link href="<c:url value="/resources/theme/css/style.css"/>" rel="stylesheet">
        <link href="<c:url value="/resources/theme/css/helper.css"/>" rel="stylesheet">
        

        <!-- HTML5 shim and Respond.js IE8 support of HTML5 tooltipss and media queries -->

        <!-- HTML5 shim and Respond.js IE8 support of HTML5 tooltipss and media queries -->
<!--[if lt IE 9]>
  <script src="<c:url value="/resources/theme/js/html5shiv.js"/>"></script>
  <script src="<c:url value="/resources/theme/js/respond.min.js"/>"></script>
<![endif]-->
<style type="text/css">
.panel-heading {
	border-color: #EFF2F7;
	font-size: 16px;
	padding: 0px 0px 50px;
}

#product_table tr:hover {
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

                <!-- Aside Start-->
        <aside class="left-panel">

            <!-- brand -->
            <div class="logo">
                <a href="<c:url value="/dashboard.htm"/>" class="logo-expanded">
                    <i class="ion-social-buffer"></i>
                    <span class="nav-label">WelCome To BGS</span>
                </a>
            </div>
            <!-- / brand -->
        
            <!-- Navbar Start -->
            <nav class="navigation">
                <ul class="list-unstyled">
                    <li ><a href="<c:url value="/dashboard.htm"/>"><i class="ion-home"></i> <span class="nav-label">Dashboard</span></a></li>
<%--                     <li class="active"><a href="<c:url value="/projects"/>"><i class="ion-ios7-people"></i> <span class="nav-label">Projects</span></a></li>
                   <li ><a href="<c:url value="/leave"/>"><i class="ion-ios7-calendar"></i> <span class="nav-label">Leave</span></a></li>
                    <li ><a href="#"><i class="ion-ios7-calendar-outline "></i> <span class="nav-label">Holiday List</span></a></li>
                    <li ><a href="#"><i class="ion-ios7-paper-outline "></i> <span class="nav-label">Notice</span></a></li>  --%> 
                 </ul>
            </nav>
                
        </aside>
        <!-- Aside Ends-->


        <!--Main Content Start -->
        <section class="content">
            
			            <!-- Header -->
            <header class="top-head container-fluid">
                <button type="button" class="navbar-toggle pull-left">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                
               
                <!-- Right navbar -->
                <ul class="list-inline navbar-right top-menu top-right-menu">  
                    <!-- mesages -->  
                    <li class="dropdown">
                        <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                            <i class="fa fa-envelope-o "></i>
                            <span class="badge badge-sm up bg-purple count">4</span>
                        </a>
                        <ul class="dropdown-menu extended fadeInUp animated nicescroll" tabindex="5001">
                            <li>
                                <p>Messages</p>
                            </li>
                            <li>
                                <a href="#">
                                    <span class="pull-left"><img src="<c:url value="/resources/theme/img/avatar-2.jpg"/>" class="img-circle thumb-sm m-r-15" alt="img"></span>
                                    <span class="block"><strong>John smith</strong></span>
                                    <span class="media-body block">New tasks needs to be done<br><small class="text-muted">10 seconds ago</small></span>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <span class="pull-left"><img src="<c:url value="/resources/theme/img/avatar-3.jpg"/>" class="img-circle thumb-sm m-r-15" alt="img"></span>
                                    <span class="block"><strong>John smith</strong></span>
                                    <span class="media-body block">New tasks needs to be done<br><small class="text-muted">3 minutes ago</small></span>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <span class="pull-left"><img src="<c:url value="/resources/theme/img/avatar-4.jpg"/>" class="img-circle thumb-sm m-r-15" alt="img"></span>
                                    <span class="block"><strong>John smith</strong></span>
                                    <span class="media-body block">New tasks needs to be done<br><small class="text-muted">10 minutes ago</small></span>
                                </a>
                            </li>
                            <li>
                                <p><a href="inbox.html" class="text-right">See all Messages</a></p>
                            </li>
                        </ul>
                    </li>
                    <!-- /messages -->
                    <!-- Notification -->
                    <li class="dropdown">
                        <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                            <i class="fa fa-bell-o"></i>
                            <span class="badge badge-sm up bg-pink count">3</span>
                        </a>
                        <ul class="dropdown-menu extended fadeInUp animated nicescroll" tabindex="5002">
                            <li class="noti-header">
                                <p>Notifications</p>
                            </li>
                            <li>
                                <a href="#">
                                    <span class="pull-left"><i class="fa fa-user-plus fa-2x text-info"></i></span>
                                    <span>New user registered<br><small class="text-muted">5 minutes ago</small></span>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <span class="pull-left"><i class="fa fa-diamond fa-2x text-primary"></i></span>
                                    <span>Use animate.css<br><small class="text-muted">5 minutes ago</small></span>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <span class="pull-left"><i class="fa fa-bell-o fa-2x text-danger"></i></span>
                                    <span>Send project demo files to client<br><small class="text-muted">1 hour ago</small></span>
                                </a>
                            </li>
                            
                            <li>
                                <p><a href="#" class="text-right">See all notifications</a></p>
                            </li>
                        </ul>
                    </li>
                    <!-- /Notification -->

                    <!-- user login dropdown start-->
                    <li class="dropdown text-center">
                        <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                            <img alt="" src="<c:url value="/resources/theme/img/avatar-2.jpg"/>" class="img-circle profile-img thumb-sm">
                            <span class="username">John Deo </span> <span class="caret"></span>
                        </a>
                        <ul class="dropdown-menu extended pro-menu fadeInUp animated" tabindex="5003" style="overflow: hidden; outline: none;">
                            <li><a href="<c:url value="/profile" />"><i class="fa fa-briefcase"></i>Profile</a></li>
                            <li><a href="#"><i class="fa fa-cog"></i> Settings</a></li>
                           <!--  <li><a href="#"><i class="fa fa-bell"></i> Friends <span class="label label-info pull-right mail-info">5</span></a></li> -->
                            <li><a href="<c:url value="/logout"/>"><i class="fa fa-sign-out"></i> Log Out</a></li>
                        </ul>
                    </li>
                    <!-- user login dropdown end -->       
                </ul>
                <!-- End right navbar -->

            </header>
            <!-- Header Ends -->


          <!-- ================== -->

            <div class="wraper container-fluid">
                <div class="page-title"> 
                    <h3 class="title"></h3> 
                </div>


                <div class="row">
                    <div class="col-md-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title"> View Or Edit Stock</h3>
                            </div>
                            <div class="panel-body">
                             <form class="form-horizontal" method="post" role="form" action="view_stock.htm" id="stockView" modelAttribute="stockSearchDetails">
                                    
                                    <div class="form-group">
                                        <label class="col-md-2 control-label" for="example-input1-group2"></label>
                                        <div class="col-md-3">
                                            <div class="input-group">
                                               
                                                <input type="text" class="form-control" placeholder="Search..." name="searchString">
                                            
                                             <span class="input-group-btn">
                                                <button onclick="formSubmit()" type="button" class="btn btn-effect-ripple btn-primary"><i class="fa fa-search"></i></button>
                                                </span></div>
                                        </div>
                                        
                                    </div> <!-- form-group -->

                                    
                                  
                             </form>
							 <c:if test="${stockList ==null && searchHappen=='true'}">
								<p class="text-danger">No matching stock found</p>
							</c:if>
                            <c:choose>
				             <c:when test="${stockList!=null}">
                            
                                <div class="row">
                                    <div class="col-md-12 col-sm-12 col-xs-12">
                                        <div class="table-responsive">
                                            <table class="table" id="product_table">
                                                <thead>
											<tr>
												<th>Product Id</th>
												<th>Product Name</th>
												<th>Product Description</th>
												
											</tr>
										</thead>
                                                <tbody>
											<c:forEach items="${stockList}" var="stockdetails">
							                <tr>
												<td>${stockdetails.productId}</td>
												<td>${stockdetails.productName}</td>
												<td>${stockdetails.product_desc}</td>
											</tr>
										</c:forEach>
										</tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </c:when>
                            </c:choose>
                            
                            <div id="subViewDiv"></div>
                         
                        </div>
                    </div>
                </div> <!-- End row -->
</div>
</div>
             
          
        </section>
          
        



        <!-- js placed at the end of the document so the pages load faster -->
        <script src="<c:url value="/resources/theme/js/jquery.js"/>"></script>
        <script src="<c:url value="/resources/theme/js/bootstrap.min.js"/>"></script>
        <script src="<c:url value="/resources/theme/js/pace.min.js"/>"></script>
         <script src="<c:url value="/resources/theme/js/modernizr.min.js"/>"></script>
        <script src="<c:url value="/resources/theme/js/wow.min.js"/>"></script>
        <script src="<c:url value="/resources/theme/js/jquery.nicescroll.js"/>" type="text/javascript"></script>

		<!-- Modal-Effect -->
        <script src="<c:url value="/resources/theme/assets/modal-effect/js/classie.js"/>"></script>
        <script src="<c:url value="/resources/theme/assets/modal-effect/js/modalEffects.js"/>"></script>
		
        <script src="<c:url value="/resources/theme/js/jquery.app.js"/>"></script>

       <%--  <script src="<c:url value="/resources/theme/assets/datatables/jquery.dataTables.min.js"/>"></script>
        <script src="<c:url value="/resources/theme/assets/datatables/dataTables.bootstrap.js"/>"></script> --%>

		 <!-- responsive-table--> 
        <script src="<c:url value="/resources/theme/assets/responsive-table/rwd-table.min.js"/>" type="text/javascript"></script>
	    <script src="<c:url value="/resources/theme/functionality/stock.js"/>"></script>
		
		<!-- datepicker -->
		 <script src="<c:url value="/resources/theme/assets/timepicker/bootstrap-datepicker.js"/>"></script>
		 
		 <!-- multi select2 -->
		 <script src="<c:url value="/resources/theme/assets/select2/select2.min.js"/>" type="text/javascript"></script>
        <script type="text/javascript">
		
		function formSubmit(){
			$('#stockView').submit();
		}
		function addRowHandlers() {
		    var rows = document.getElementById("product_table").rows;
		  
		    for (i = 0; i < rows.length; i++) {
		        rows[i].onclick = function(){ return function(){
		               var productId = this.cells[0].innerHTML;
		               if(productId != 'Product Id'){
		            	   Stock.searchProductDetails(productId);
		               }
		               
		        };}(rows[i]);
		    }
		}
		window.onload = addRowHandlers();
		/* $('#manager').select2(); */
		</script>
		
    </body>

</html>
