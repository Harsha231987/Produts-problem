Clone Project
-------------
git clone 'Project GIT URL'


App Usage
---------
cd prizy-pricer
mvn clean install
java -jar target/prizy-pricer-1.1.8.RELEASE.jar


Debug Mode
----------------
java -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005 -jar target/prizy-pricer-1.1.8.RELEASE.jar


Save Product
-------------
curl -v -X POST -H "Content-Type: application/json" -d '{"barcode" : "B12BUU33", "name" : "Product 1"}'  http://localhost:8080/product


GET Product
------------
curl -v -X GET http://localhost:8080/product/1


Get Survey Data
----------------
curl -v -X GET http://localhost:8080/productSurvey/1


Get Price Details
-----------------
http://localhost:8080/getProductPriceDetails/<barcode>
curl -v -X GET http://localhost:8080/getProductPriceDetails/B1234
