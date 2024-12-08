In the first Part, I have used Python to implement the "isTaskDescriptionPalindrome" function.

In both Second and third Part, I have implemented the Task Management System using Spring Boot framework and I chose the "Dependency Injection" as a design principale because 
in Spring Boot its easier using the Annotations.

I Have organized my project into : entities / services / repositories / controllers (API endpoints) (Part3) 

I have used Docker for containerization  and enviroment management :

To start the app:
1- Build the application artifact using : mvn clean package -DskipTests
2- Build the docker image of the app :  docker build -t task-manager:latest .
3- Launch both app and db containers using docker compose : docker-compose up -d



