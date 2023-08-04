- > docker run --name mysql-container --network springboot-mysql-network -e MYSQL_DATABASE=employee  -e MYSQL_PASSWORD=Admin -e MYSQL_ROOT_PASSWORD=Admin -d mysql:latest
- > docker exec -it mysql-container mysql -u root -p 
* Above command asks to enter password give  MYSQL_ROOT_PASSWORD
* To check list of available databases
- > show databases;
* To run our spring image have to use 
- > run --network springboot-mysql-network --name crudjarcontainer -p 8080:8080 -d richeb/crud-jar:v1

