- > docker run --name mysql-container --network springboot-mysql-network -e MYSQL_DATABASE=employee  -e MYSQL_PASSWORD=Admin -e MYSQL_ROOT_PASSWORD=11234 -d mysql:latest



- > docker exec -it sql-container mysql -u root -p 
* Above command asks to enter password give  MYSQL_ROOT_PASSWORD

- > show databases;

