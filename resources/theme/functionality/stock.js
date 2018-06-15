var Stock={
	searchProductDetails :function(productId){
		  $("subViewDiv").hide();
		$.ajax({
			   url: 'view_stock_details.htm',
			   data: {
			      productId: productId,
			   
			   },
			   error: function(dataError) {
			      $('#info').html('<p>An error has occurred</p>');
			   },
			   dataType: 'html',
			   success: function(data) {
				   $("#subViewDiv").html( data );
				   $("subViewDiv").show();
				  
			   },
			   type: 'GET'
			});
	}
}