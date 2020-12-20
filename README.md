# ProductComparisionService
Product to hunt the product

We have intially only added the file base data soruce integration using Spring boot 
We can acutually use ETL Framework to do Injetion of data from different channel.

For now I have used the embedded SQL H2 Database for the Poc completion.

I have not used any Cache system and alsonot used any of the in memory optimization framework just for the sack of POC completion.

To Run the Code , You can directly run the jar under target folder , or you can run it on docker as wel.

To Connect Database below is the user 
http://localhost:8080/h2

To Search the product , end point will considred below URL
http://localhost:8080/api/v1/search?pname=iphone%206&category=phone


