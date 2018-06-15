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
        <script src="<c:url value="/resources/theme/functionality/bill.js"/>"></script>
        <script src="<c:url value="/resources/theme/functionality/shortCutKey.js"/>"></script>
        
         <!-- Plugins css -->
        <link href="<c:url value="/resources/theme/assets/modal-effect/css/component.css"/>" rel="stylesheet">
		<link href="<c:url value="/resources/theme/assets/timepicker/bootstrap-datepicker.min.css"/>" rel="stylesheet" />
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/theme/assets/select2/select2.css"/>" />
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/theme/assets/select2/select3.css"/>" />

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
	font-size: 12px;
	padding: 0px 0px 20px;
}
#customer_table tr:hover {
    cursor: pointer;
    
}
#cloneRow{
 padding: 10px;
    display: inline;
    border-radius: 2px;
    font-family: inherit;
    border: 0;
    margin: 0 10px;
    background: #ebc142;
    font-size: 14px;
    font-weight: 400;
    line-height: 1.42857143;
    color: white;
    width: auto;
    height: 100%;
    box-sizing: content-box;
    cursor:pointer;
    text-align:center;
    border: 1px solid #ebc142;
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

                <!-- Page Content Start -->
            <!-- ================== -->

            <div class="wraper container-fluid" style="padding-top: 0px;">
                 <div class="row">
                    <div class="col-md-12">
                        <div class="panel panel-default">
                                   <form:form class="cmxform form-horizontal tasi-form" id="newBill" method="POST"  modelAttribute="billItem" action="new_bill_generation.htm" novalidate="novalidate">
                        
                            <div class="panel-heading">
                                <h3 class="panel-title">New Bill</h3>
                                	<c:if test="${null != status && searchHappen=='true'}">
								<%
									String status = (String) request.getAttribute("status");
										String message = (String) request.getAttribute("message");
										if (status.equals("error")) {
								%>
								<div class="alert alert-warning alert-dismissable">
								<button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
									
										${message}
									</div>
								
								<%
									} else {
								%>
								<div class="alert alert-success alert-dismissable">
								<button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
									Bill Has been generated
											successfully.Bill Id is - ${message}
								</div>
								<%
									}
								%>
							</c:if>
							 <div class="form-group" style="margin-top: 1%; margin-bottom: 0px;">
                                <div class="form-group" style="width: 50%;overflow: hidden;float: left;">
															<label style="margin-left: 6%;">CustomerName:-</label><div class="col-sm-50" style="display: inline;">
																	<form:select  class="selectCustomer" data-placeholder="Choose a Customer.." id="customerId" name="customerId"  path="customerDetails" onchange="selectCustomerDetails(this.value,$(this).closest('tr').index())" >
																		<option value="#">&nbsp;</option>
																		<c:forEach items="${customerList}" var="customerList">
																			<form:option value="${customerList.name}###${customerList.customerId}###${customerList.godownNo}" >
																			${customerList.name}-${customerList.godownNo}</form:option>
																		</c:forEach>
																	</form:select>
																</div>
															</div>
										 <div class="form-group" id="buttonSection" style="width: 50%;overflow: hidden;float: right;display: none;">	<span id="cloneRow" style="margin-right :5px">Add Row</span> 				 
										 <button class="btn btn-warning m-b-5" style="float:right;margin-right :10%"> <i class="fa fa-rocket"></i> <span>Generate Bill</span> </button>
											</div>				 
                                
                            </div>
                            <div class="panel-body" style="padding-top: 0px;display: none;">
                          
                                <div class="row">
                                    <div class="col-md-12 col-sm-12 col-xs-12">
                                        <div class="table-responsive" style="overflow: auto;max-height:380px; white-space: nowrap;">
                                            <table class="table" id="billTable">
                                                <thead>
                                              <tr>
												<th>#</th>
												<th>Product Name</th>
												<th>Product Descripion</th>
												<th>Batch Number</th>
												<th>Mfg Date</th>
												<th>Expiry Date</th>
												<th>Quantity</th>
												<th>Unit Price</th>
												<th>vat  %</th>
												<th>Total Price</th>
											</tr>
                                                </thead>
                                                <tbody>
                                                
                                                <c:forEach items="${billItem.billItems}" var="indiItem" varStatus="status">
                                                    <tr id="actualRow${status.count}">
                                                    
                                                        <td>${status.count}</td>
                                                        <td>
															<div class="form-group">
																<div class="col-sm-80">
																	<form:select  class="selectProduct" data-placeholder="Choose a Product.." id="billItems[${status.index}].productName" name="billItems[${status.index}].productName"  path="billItems[${status.index}].productName" onchange="populateDetails(this.value,$(this).closest('tr').index())">
																		<option value="#">&nbsp;</option>
																		<c:forEach items="${stockList}" var="stockName">
																			<form:option value="${stockName.productId}###${stockName.productName}###${stockName.product_desc}###${stockName.productBatchNo}###${stockName.productMfgDt}###${stockName.productExpiryDt}###${stockName.productQuantity}###${stockName.productSellingPrice}###${stockName.productSellVat}" >
																			${stockName.productName}-${stockName.product_desc}-${stockName.productBatchNo}-${stockName.productMfgDt}-${stockName.productExpiryDt}-${stockName.productQuantity}</form:option>
																		</c:forEach>
																	</form:select>
																</div>
															</div>
													</td>
                                                        
                                                        <td> <form:input class=" form-control" id="billItems[${status.index}].pdesc"  path="billItems[${status.index}].pdesc" name="billItems[${status.index}].pdesc" type="text"/></td>
                                                        <td> <form:input class=" form-control" id="billItems[${status.index}].batchNumber" path="billItems[${status.index}].batchNumber" name="billItems[${status.index}].batchNumber" type="text"/></td> 
                                                        <td> <form:input class=" form-control" id="billItems[${status.index}].mfgDate" path="billItems[${status.index}].mfgDate" name="billItems[${status.index}].mfgDate" type="text"/></td> 
                                                        <td> <form:input class=" form-control" id="billItems[${status.index}].expDate" path="billItems[${status.index}].expDate" name="billItems[${status.index}].expDate" type="text"/></td> 
                                                        <td> <form:input class=" form-control" id="billItems[${status.index}].quantity" path="billItems[${status.index}].quantity" name="billItems[${status.index}].quantity" type="text" onchange="Bill.calculateTotalPrice($(this).closest('tr').index())"/></td> 
                                                        <td> <form:input class=" form-control" id="billItems[${status.index}].price" path="billItems[${status.index}].price" name="billItems[${status.index}].price" type="text" onchange="Bill.calculateTotalPrice($(this).closest('tr').index())"/></td> 
                                                        <td> <form:input class=" form-control" id="billItems[${status.index}].sellvat" path="billItems[${status.index}].sellvat" name="billItems[${status.index}].sellvat" type="text" onchange="Bill.calculateTotalPrice($(this).closest('tr').index())"/></td> 
                                                        <td> <form:input class=" form-control" id="billItems[${status.index}].totalPrice" path="billItems[${status.index}].totalPrice" name="billItems[${status.index}].totalPrice" type="text"/></td>
                                                        <input class=" form-control" id="billItems[${status.index}].vatAmount"  name="billItems[${status.index}].vatAmount" type="hidden"/>
                                                        <input class=" form-control" id="billItems[${status.index}].subTotalAmount"  name="billItems[${status.index}].subTotalAmount" type="hidden"/>
                                                    </tr>
                                                    </c:forEach>
                                                   
                                                </tbody>
                                            </table>
                                          
                                        </div>
                                    </div>
                                      <div id="total_Amount_div" >
                                         <div class="table-responsive" style="overflow: auto;max-height:600px; white-space: nowrap;">
                                            <table class="table" id="billTable">
                                              <tbody>
                                                
                                               
                                                    <tr >
                                                        <td><label>Sub-Total= </label></td>
                                                        <td><form:input class=" form-control" type="text" id="subtotal" path="basicAmount"></form:input></td>
                                                        
                                                  
                                                        <td> <label>Vat= </label></td>
                                                        <td><form:input class=" form-control" type="text" id="totalVat" path="vatAmount"></form:input></td>
                                                        
                                                   
                                                        <td><label> Total Amount= </label></td>
                                                        <td><form:input class=" form-control" type="text" id="totalAmount" path="billAmount"></form:input></td>
                                                   
                                                        <td><label>Paid Amount= </label></td>
                                                        <td><form:input class=" form-control" type="text" id="paidAmount" path="paidAmount" onchange="Bill.calculatedueAmount()"></form:input></td>
                                                        
                                                    
                                                        <td> <label>Due Amount= </label></td>
                                                        <td><form:input class=" form-control" type="text" id="dueAmount" path="dueAmount"></form:input></td>
                                                        
                                                    </tr>	
                                                </tbody>
                                            </table>
                                            <form:input class=" form-control" id="billDate"  name="billDate" type="hidden" path="billDate"/><br>
                                            </div>
                                            </div>
                                </div>
                            </div>
                            </form:form>
                                                                                           
                            
                        </div>
                    </div>
                </div> <!-- End row -->
</div>

             
          
        </section>
    
        <!-- Main Content Ends -->
        
          <!-- Main Content Ends -->
        



    



        <!-- js placed at the end of the document so the pages load faster -->
        <script src="<c:url value="/resources/theme/js/jquery.js"/>"></script>
       <script src="<c:url value="/resources/theme/js/bootstrap.min.js"/>"></script>
       <script src="<c:url value="/resources/theme/js/pace.min.js"/>"></script>
       <script src="<c:url value="/resources/theme/js/wow.min.js"/>"></script>
       <script src="<c:url value="/resources/theme/js/jquery.nicescroll.js"/>"></script>
       


        <script src="<c:url value="/resources/theme/assets/tagsinput/jquery.tagsinput.min.js"/>"></script>
        <script src="<c:url value="/resources/theme/assets/toggles/toggles.min.js"/>"></script>
        <script src="<c:url value="/resources/theme/assets/timepicker/bootstrap-timepicker.min.js"/>"></script>
        <script src="<c:url value="/resources/theme/assets/timepicker/bootstrap-datepicker.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/resources/theme/assets/colorpicker/bootstrap-colorpicker.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/resources/theme/assets/jquery-multi-select/jquery.multi-select.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/resources/theme/assets/jquery-multi-select/jquery.quicksearch.js"/>"></script>
        <script src="<c:url value="/resources/theme/assets/bootstrap-inputmask/bootstrap-inputmask.min.js"/>" type="text/javascript"></script>
        <script type="text/javascript" src="<c:url value="/resources/theme/assets/spinner/spinner.min.js"/>"></script>
        <script src="<c:url value="/resources/theme/assets/select2/select2.min.js"/>" type="text/javascript"></script>
        <script src="<c:url value="/resources/theme/assets/select2/select3.min.js"/>" type="text/javascript"></script>

       <script src="<c:url value="/resources/theme/js/jquery.app.js"/>"></script>


        <script>
             $(document).ready(function() {
                   $(".navbar-toggle").click(); 
                // Tags Input
                jQuery('#tags').tagsInput({width:'auto'});

                // Form Toggles
                jQuery('.toggle').toggles({on: true});

                // Time Picker
                jQuery('#timepicker').timepicker({defaultTIme: false});
                jQuery('#timepicker2').timepicker({showMeridian: false});
                jQuery('#timepicker3').timepicker({minuteStep: 15});

                // Date Picker
                jQuery('#datepicker').datepicker();
                jQuery('#datepicker-inline').datepicker();
                jQuery('#datepicker-multiple').datepicker({
                    numberOfMonths: 3,
                    showButtonPanel: true
                });
                //colorpicker start

                $('.colorpicker-default').colorpicker({
                    format: 'hex'
                });
                $('.colorpicker-rgba').colorpicker();


               

                //spinner start
                $('#spinner1').spinner();
                $('#spinner2').spinner({disabled: true});
                $('#spinner3').spinner({value:0, min: 0, max: 10});
                $('#spinner4').spinner({value:0, step: 5, min: 0, max: 200});
                //spinner end

                // Select2
                jQuery(".selectProduct").select2({
                    width: '200px'
                });
                jQuery(".selectCustomer").select3({
                    width: '200px'
                });
                $(".select2-container").css("width","200px");
                
               
                
                jQuery("#billDate").val(new Date());
                
            });
             
           function populateDetails (seletedData,index){
        	   if(seletedData != '#'){
        		   var selectedDatas=seletedData.split("###");
                  	Bill.populateData(selectedDatas,index);
                   }   
        	   else{
        		   Bill.resetData(index);
        	   }
                	
           }
           function selectCustomerDetails (seletedData,index){
        	   if(seletedData != '#'){
        		   $('.panel-body').show();
        		   $('#buttonSection').show();
        	   }
        	   else{
        		   $('.panel-body').hide();
        		   $('#buttonSection').hide();
        	   }
                	
           }
           shortcut.add("alt+p", function() {
               $('#paidAmount').focus();
               $('#paidAmount').select();
           });
           shortcut.add("alt+g", function() {
               $('#newBill').submit();
           }); 
           shortcut.add("alt+a", function() {
               $('#cloneRow').click();
           }); 
           shortcut.add("ctrl+enter", function() {
               // Do something
           }); 
           
           
           $('#billTable tr:gt(5)').css("display","none");
           var showCounter=5;
           $('#cloneRow').on('click', function()
        		   {
        	   
        	   $('#billTable tr:gt('+showCounter+'):lt(1)').css("display","table-row");
        	   showCounter++;
        		   });
        </script>

    </body>


<!--  alert('Add Row');
        	  var rowcount= $('#billTable tr').length;
        	      var row = document.getElementById("actualRow1"); // find row to copy
        	      var table = document.getElementById("billTable"); // find table to append to
        	      var clone = row.cloneNode(true); // copy children too
        	      clone.id = rowcount; // change id or other attributes/contents
        	      table.appendChild(clone); // add new row to end of table
        	    } -->
</html>
        