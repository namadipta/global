<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html lang="en">
    
<!-- Mirrored from coderthemes.com/velonic_2.1/admin_2/index.html by HTTrack Website Copier/3.x [XR&CO'2014], Tue, 15 Dec 2015 12:19:53 GMT -->
<head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="A fully featured admin theme which can be used to build CRM, CMS, etc.">
        <meta name="author" content="Coderthemes">

        <link rel="shortcut icon" href="<c:url value="/resources/theme/img/favicon_1.ico" />">

        <title>BGS Software</title>

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

        <!-- sweet alerts -->
        <link href="<c:url value="/resources/theme/assets/sweet-alert/sweet-alert.min.css"/>" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="<c:url value="/resources/theme/css/style.css"/>" rel="stylesheet">
        <link href="<c:url value="/resources/theme/css/helper.css"/>" rel="stylesheet">
        


        <!-- HTML5 shim and Respond.js IE8 support of HTML5 tooltipss and media queries -->
<!--[if lt IE 9]>
  <script src="<c:url value="/resources/theme/js/html5shiv.js"/>"></script>
  <script src="<c:url value="/resources/theme/js/respond.min.js"/>"></script>
<![endif]-->
<style type="text/css">

#new_bill :hover {
    cursor: pointer;
}
#view_customers :hover {
    cursor: pointer;
}
#view_stock :hover {
    cursor: pointer;
}
#add_stock :hover {
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
                    <span class="nav-label">BGS System</span>
                </a>
            </div>
            <!-- / brand -->
         
            <!-- Navbar Start -->
            <nav class="navigation">
                <ul class="list-unstyled">
                	<li class="active"><a href="<c:url value="/dashboard.htm"/>"><i class="ion-home"></i> <span class="nav-label">Dashboard</span></a></li>
<%--                 	<li ><a href="<c:url value="/new_bill.htm"/>"><i class="ion-ios7-people"></i> <span class="nav-label">New Bill</span></a></li>
 --%>                    <li ><a href="<c:url value="/add_customer_page_view.htm"/>"><i class="ion-ios7-people"></i> <span class="nav-label">Add Customer</span></a></li>
                    <li ><a href="<c:url value="/view_customer.htm"/>"><i class="ion-ios7-calendar"></i> <span class="nav-label">View Customer</span></a></li>
                    <li ><a href="<c:url value="/view_stock.htm"/>"><i class="ion-ios7-paper-outline "></i> <span class="nav-label">View Stock Details</span></a></li>
                    <li ><a href="<c:url value="/add_stock_page_view.htm"/>"><i class="ion-ios7-calendar-outline "></i> <span class="nav-label">Add New Item</span></a></li>
                    <%-- <li class="active"><a href="<c:url value="/dashboard"/>"><i class="ion-home"></i> <span class="nav-label">Dashboard</span></a></li>
                    <li ><a href="<c:url value="/employee/all" />"><i class="ion-ios7-people"></i> <span class="nav-label">Employee Management</span></a></li>
                    <li ><a href="<c:url value="/employee/all"/>"><i class="ion-ios7-calendar"></i> <span class="nav-label">Leave Management</span></a></li>
                    <li ><a href="<c:url value="/employee/all"/>"><i class="ion-ios7-calendar-outline "></i> <span class="nav-label">Holiday List</span></a></li>
                    <li ><a href="<c:url value="/employee/all"/>"><i class="ion-ios7-paper-outline "></i> <span class="nav-label">Notice</span></a></li> --%>
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
                
                <!-- Search -->
                <form role="search" class="navbar-left app-search pull-left hidden-xs">
                  <input type="text" placeholder="Search..." class="form-control">
                  <a href="#"><i class="fa fa-search"></i></a>
                </form>
                
                <!-- Left navbar -->
                <nav class=" navbar-default hidden-xs" role="navigation">
                    <ul class="nav navbar-nav">
                        <li class="dropdown">
                          <a data-toggle="dropdown" class="dropdown-toggle" href="#">English <span class="caret"></span></a>
                            <ul role="menu" class="dropdown-menu">
                                <li><a href="#">German</a></li>
                                <li><a href="#">French</a></li>
                                <li><a href="#">Italian</a></li>
                                <li><a href="#">Spanish</a></li>
                            </ul>
                        </li>
                        <li><a href="#">Files</a></li>
                    </ul>
                </nav>
                
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


            <!-- Page Content Start -->
            <!-- ================== -->

            <div class="wraper container-fluid">
                <div class="page-title"> 
                    <h3 class="title">Welcome !</h3> 
                </div>



                <div class="row">
                    <div class="col-lg-3 col-sm-6">
                        <div class="widget-panel widget-style-2 white-bg" id="new_bill" onclick="location.href='new_bill.htm';">
                            <i class="ion-eye text-pink"></i> 
                            <h2></h2>
                            <div>New Bill</div>
                        </div>
                    </div>
                    <div class="col-lg-3 col-sm-6">
                        <div class="widget-panel widget-style-2 white-bg" id="add_stock" onclick="location.href='';">
                             <i class="ion-ios7-pricetag text-info"></i> 
                            <h2 ></h2>
                            <div>Add Stock</div>
                        </div>
                    </div>
                    <div class="col-lg-3 col-sm-6">
                        <div class="widget-panel widget-style-2 white-bg" id="view_stock" onclick="location.href='view_stock.htm';">
                            <i class="ion-wifi text-purple"></i> 
                            <h2 ></h2>
                            <div>View Stock</div>
                        </div>
                    </div>
                    <div class="col-lg-3 col-sm-6">
                        <div class="widget-panel widget-style-2 white-bg" id="view_customers" onclick="location.href='view_customer.htm';">
                           <i class="ion-android-contacts text-success"></i> 
                            <div>View Customer</div>
                        </div>
                    </div>
                   
                </div> <!-- end row -->



                <div class="row">
                    

                    <div class="col-lg-6">
                        <div class="portlet"><!-- /primary heading -->
                            <div class="portlet-heading">
                                <h3 class="portlet-title text-dark text-uppercase">
                                    Yearly Sales Report
                                </h3>
                                <div class="portlet-widgets">
                                    <a href="javascript:;" data-toggle="reload"><i class="ion-refresh"></i></a>
                                    <span class="divider"></span>
                                    <a data-toggle="collapse" data-parent="#accordion1" href="#portlet2"><i class="ion-minus-round"></i></a>
                                    <span class="divider"></span>
                                    <a href="#" data-toggle="remove"><i class="ion-close-round"></i></a>
                                </div>
                                <div class="clearfix"></div>
                            </div>
                            <div id="portlet2" class="panel-collapse collapse in">
                                <div class="portlet-body">
                                    <div id="morris-area-example" style="height: 320px;"></div>
                                    <div class="row text-center m-t-30 m-b-30">
                                        <div class="col-sm-3 col-xs-6">
                                            <h4>$ 14</h4>
                                            <small class="text-muted"> Today's Sales</small>
                                        </div>
                                        <div class="col-sm-3 col-xs-6">
                                            <h4>$ 967</h4>
                                            <small class="text-muted">This Week's Sales</small>
                                        </div>
                                        <div class="col-sm-3 col-xs-6">
                                            <h4>$ 4500</h4>
                                            <small class="text-muted">This Month's Sales</small>
                                        </div>
                                        <div class="col-sm-3 col-xs-6">
                                            <h4>$ 87,000</h4>
                                            <small class="text-muted">This Year's Sales</small>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div> <!-- /Portlet -->
                        
                    </div>


                     <div class="row">
                    

                    <div class="col-lg-6">
                        <div class="portlet"><!-- /primary heading -->
                            <div class="portlet-heading">
                                <h3 class="portlet-title text-dark text-uppercase">
                                    Weekly Sales Report
                                </h3>
                                <div class="portlet-widgets">
                                    <a href="javascript:;" data-toggle="reload"><i class="ion-refresh"></i></a>
                                    <span class="divider"></span>
                                    <a data-toggle="collapse" data-parent="#accordion2" href="#portlet2"><i class="ion-minus-round"></i></a>
                                    <span class="divider"></span>
                                    <a href="#" data-toggle="remove"><i class="ion-close-round"></i></a>
                                </div>
                                <div class="clearfix"></div>
                            </div>
                            <div id="portlet2" class="panel-collapse collapse in">
                                <div class="portlet-body">
                                    <div id="morris-area-example-1" style="height: 320px;"></div>
                                    <div class="row text-center m-t-30 m-b-30">
                                        <div class="col-sm-3 col-xs-6">
                                            <h4>$ 14</h4>
                                            <small class="text-muted"> Today's Sales</small>
                                        </div>
                                        <div class="col-sm-3 col-xs-6">
                                            <h4>$ 967</h4>
                                            <small class="text-muted">This Week's Sales</small>
                                        </div>
                                        <div class="col-sm-3 col-xs-6">
                                            <h4>$ 4500</h4>
                                            <small class="text-muted">This Month's Sales</small>
                                        </div>
                                        <div class="col-sm-3 col-xs-6">
                                            <h4>$ 87,000</h4>
                                            <small class="text-muted">This Year's Sales</small>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div> <!-- /Portlet -->
                        
                    </div>


               
                    
                </div> <!-- End row -->


            </div>
            <!-- Page Content Ends -->
            <!-- ================== -->

            <!-- Footer Start -->
            <!-- Footer Ends -->



        </section>
        <!-- Main Content Ends -->
        


        <!-- js placed at the end of the document so the pages load faster -->
        <script src="<c:url value="/resources/theme/js/jquery.js"/>"></script>
        <script src="<c:url value="/resources/theme/js/bootstrap.min.js"/>"></script>
        <script src="<c:url value="/resources/theme/js/modernizr.min.js"/>"></script>
        <script src="<c:url value="/resources/theme/js/pace.min.js"/>"></script>
        <script src="<c:url value="/resources/theme/js/wow.min.js"/>"></script>
        <script src="<c:url value="/resources/theme/js/jquery.scrollTo.min.js"/>"></script>
        <script src="<c:url value="/resources/theme/js/jquery.nicescroll.js"/>" type="text/javascript"></script>
        
        <script src="<c:url value="/resources/theme/assets/chat/moment-2.2.1.js"/>"></script>

        <!-- Counter-up -->
        <script src="<c:url value="/resources/theme/js/waypoints.min.js"/>" type="text/javascript"></script>
        <script src="<c:url value="/resources/theme/js/jquery.counterup.min.js"/>" type="text/javascript"></script>

        <!-- EASY PIE CHART JS -->
        <script src="<c:url value="/resources/theme/assets/easypie-chart/easypiechart.min.js"/>"></script>
        <script src="<c:url value="/resources/theme/assets/easypie-chart/jquery.easypiechart.min.js"/>"></script>
        <script src="<c:url value="/resources/theme/assets/easypie-chart/example.js"/>"></script>


        <!--C3 Chart-->
        <script src="<c:url value="/resources/theme/assets/c3-chart/d3.v3.min.js"/>"></script>
        <script src="<c:url value="/resources/theme/assets/c3-chart/c3.js"/>"></script>

        <!--Morris Chart-->
        <script src="<c:url value="/resources/theme/assets/morris/morris.min.js"/>"></script>
        <script src="<c:url value="/resources/theme/assets/morris/raphael.min.js"/>"></script>

        <!-- sparkline --> 
        <script src="<c:url value="/resources/theme/assets/sparkline-chart/jquery.sparkline.min.js"/>" type="text/javascript"></script>
        <script src="<c:url value="/resources/theme/assets/sparkline-chart/chart-sparkline.js"/>" type="text/javascript"></script> 

        <!-- sweet alerts -->
        <script src="<c:url value="/resources/theme/assets/sweet-alert/sweet-alert.min.js"/>"></script>
        <script src="<c:url value="/resources/theme/assets/sweet-alert/sweet-alert.init.js"/>"></script>

        <script src="<c:url value="/resources/theme/js/jquery.app.js"/>"></script>
        <!-- Chat -->
        <script src="<c:url value="/resources/theme/js/jquery.chat.js"/>"></script>
        <!-- Dashboard -->
        <script src="<c:url value="/resources/theme/js/jquery.dashboard.js"/>"></script>

        <!-- Todo -->
        <script src="<c:url value="/resources/theme/js/jquery.todo.js"/>"></script>


        <script type="text/javascript">
        /* ==============================================
             Counter Up
             =============================================== */
            jQuery(document).ready(function($) {
                $('.counter').counterUp({
                    delay: 100,
                    time: 1200
                });
            });
        </script>
    

    </body>

<!-- Mirrored from coderthemes.com/velonic_2.1/admin_2/index.html by HTTrack Website Copier/3.x [XR&CO'2014], Tue, 15 Dec 2015 12:21:21 GMT -->
</html>
       