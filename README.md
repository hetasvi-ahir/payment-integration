# payment-integration
Repository for payment Integration in spring boot using RazorPay

For more information checkout the RazorPay-Integration.docx file .

Steps to Create Account in Razorpay.

Step 1 : Go to https://x.razorpay.com/auth

Step 2 : Click on Sign up to create new Account .

Step 3 : Enter necessary Information .

Step 4 : After successful Account creation you will be redirected to Dashboard. Now select Try RazorpayX [Test Mode]

Step 5 : Click on the profile icon  , Which will open a dropdown menu . Go to My accounts and Settings.

Step 6 : Go to Developer Controls

Step 7 : Generate Key for Test mode . 

Step 8 : Download Key details.

Steps to integrate it with Spring boot

Step 1 : Set the secret key and Secret in application.properties file.

Step 2 : Add RazorPay dependency .

Step 3 : Create one home.html file to redirect it to the checkout of payment of Razorpay and handle failure and success of the payment .

Step 4 : Create one DTO TransactionDetails .

Step 5 : Create Payment Service to create Razorpay client and create an order.

Step 6 : Create one Controller to access the home.html page . 

Step 7 : Generate Order Id through localhost:8080/payment/createTransaction/10  

Step 8 : Go to localhost:8080 in browser  and click on pay button .

Step 9 : It will redirect to razor pay Try both scenarios .  Success 

Step 10 : Failure 
