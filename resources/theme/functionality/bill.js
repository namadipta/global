var totalVat=0;
var totalAmount=0;
var subtotal=0;
var Bill={

		populateData :function(selectedDatas,index){
			var spanSelect=index+1;
			$('#select2-chosen-'+spanSelect+'').text(selectedDatas[1].trim());

			$('[name="billItems['+index+'].pdesc"]').val(selectedDatas[2].trim());
			$('[name="billItems['+index+'].batchNumber"]').val(selectedDatas[3].trim());
			$('[name="billItems['+index+'].mfgDate"]').val(selectedDatas[4].trim());
			$('[name="billItems['+index+'].expDate"]').val(selectedDatas[5].trim());

			var quantity=selectedDatas[6].trim();
			var price=selectedDatas[7].trim();
			var vat=selectedDatas[8].trim();
			
			Bill.priceCalculation(price,quantity,vat,index); 
			$( '[name="billItems['+index+'].quantity"]' ).focus();
			$( '[name="billItems['+index+'].quantity"]' ).select();
		},
		calculateTotalPrice :function(index){
			var price=  $('[name="billItems['+index+'].price"]').val();
			var quantity=$('[name="billItems['+index+'].quantity"]').val();               
			var vat= $('[name="billItems['+index+'].sellvat"]').val();
			Bill.priceCalculation(price,quantity,vat,index);
		} ,
		priceCalculation :function(price,quantity,vat,index){
			$('[name="billItems['+index+'].price"]').val(price);
			$('[name="billItems['+index+'].quantity"]').val(quantity);
			$('[name="billItems['+index+'].sellvat"]').val(vat);

			var vatAndPrice=price;
			if(vat !=0){
				vatAmountItems=(price*vat)/100;
				
				subtotalForItem=price-vatAmountItems;
			}
			var deductTotal=$('[name="billItems['+index+'].totalPrice"]').val();
			totalAmount=totalAmount-deductTotal;
			
			
			var deductsubtotal=$('[name="billItems['+index+'].subTotalAmount"]').val();
			subtotal=subtotal-deductsubtotal;
			
			var deductvat=$('[name="billItems['+index+'].vatAmount"]').val();
			totalVat=totalVat-deductvat;
			
			$('[name="billItems['+index+'].totalPrice"]').val(Bill.round(price * quantity,2));
			totalAmount=totalAmount+(price * quantity);
			$('#totalAmount').val(Bill.round(totalAmount,2));
			
			$('[name="billItems['+index+'].vatAmount"]').val(Bill.round(vatAmountItems  * quantity,2));
			totalVat=totalVat+(vatAmountItems * quantity);
			$('#totalVat').val(Bill.round(totalVat,2));
			
			$('[name="billItems['+index+'].subTotalAmount"]').val(Bill.round(subtotalForItem  * quantity,2));
			subtotal=subtotal+(subtotalForItem * quantity);
			$('#subtotal').val(Bill.round(subtotal,2));
			
		},
		resetData :function(index){
			
			var deductTotal=$('[name="billItems['+index+'].totalPrice"]').val();
			var deductVat=$('[name="billItems['+index+'].vatAmount"]').val();
			var deductSubTotal=$('[name="billItems['+index+'].subTotalAmount"]').val();
			
			$('[name="billItems['+index+'].price"]').val('0.0');
			$('[name="billItems['+index+'].quantity"]').val('');
			$('[name="billItems['+index+'].sellvat"]').val('0.0');
			$('[name="billItems['+index+'].totalPrice"]').val('0.0');
			$('[name="billItems['+index+'].pdesc"]').val('');
			$('[name="billItems['+index+'].batchNumber"]').val('');
			$('[name="billItems['+index+'].mfgDate"]').val('');
			$('[name="billItems['+index+'].expDate"]').val('');
			$('[name="billItems['+index+'].subTotalAmount"]').val('0.0');
			$('[name="billItems['+index+'].vatAmount"]').val('0.0');
			
			totalAmount=totalAmount-deductTotal;
			$('#totalAmount').val(Bill.round(totalAmount,2));
			
			subtotal=subtotal-deductSubTotal;
			$('#subtotal').val(Bill.round(subtotal,2));
			
			totalVat=totalVat-deductVat;
			$('#totalVat').val(Bill.round(totalVat,2));
		},
		
		calculatedueAmount :function(){
			var totalAmount=$('#totalAmount').val();
			var paidAmount= $('#paidAmount').val();
			$('#dueAmount').val(Bill.round(totalAmount-paidAmount,2));
		},
		 round :function(value, decimals) {
		    return Number(Math.round(value + 'e' + decimals) + 'e-' + decimals);
		}
}