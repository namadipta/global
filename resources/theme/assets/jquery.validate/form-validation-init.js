!function($) {
    "use strict";

    var FormValidator = function() {
        this.$addCustomer = $("#addCustomer");
        this.$addStock = $("#addStock");
    };

    FormValidator.prototype.init = function() {
        $.validator.setDefaults({
            submitHandler: function() { this.$addCustomer.submit(); 
            this.$addStock.submit(); 
            }
        });


        this.$addCustomer.validate({
            rules: {
                name: {
                    required: true,
                    minlength: 2
                },
                gnumber: {
                    required: true,
                },
                mobile: {
                    required: true,
                    number: true,
                    minlength: 10,
                    maxlength:10
                },
                email: {
                    required: true,
                    email: true
                },
                
            },
            messages: {
            	name: {
                    required: "Please enter a name",
                    minlength: "Your username must consist of at least 2 characters"
                },
                gnumber: {
                    required: "Please enter a Godown number",
                },
                mobile: {
                    required: "Please enter a valid mobile number",
                    minlength: "Mobile number must consist of 10 characters",
                    maxlength: "Mobile number must consist of 10 characters"

                },

                email: "Please enter a valid email address",
            }
        });
        this.$addStock.validate({
            rules: {
            	productName: {
                    required: true,
                    minlength: 2
                },
                quantity: {
                    required: true,
                },
                purchasePrice: {
                	   required: true,
                },
            },
            messages: {
            	productName: {
                    required: "Please enter a ProductName",
                    minlength: "Your ProductName must consist of at least 2 characters"
                },
                quantity: {
                    required: "Please enter a qunatity",
                },
                purchasePrice: {
                	 required: "Please enter a purchase price",
                },

            }
        });
        $( "#dob" ).datepicker({
			inline: true
		});
    },
    //init
    $.FormValidator = new FormValidator, $.FormValidator.Constructor = FormValidator
}(window.jQuery),



//initializing 
function($) {
    "use strict";
    $.FormValidator.init()
}(window.jQuery);