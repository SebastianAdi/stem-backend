# stem-backend

To run the application on your local system - 

1. Fire a query 'create database db_name';

2. In application.properties change the following properties
    spring.datasource.url=jdbc:mysql://localhost:3306/your_db_name
    spring.datasource.username=your_connection_username
    spring.datasource.password=your_connection_password
    
3. Hit the following url to populate hospital table via spring batch
    http://localhost:8080/job  
    
4. Run department.sql and doctor.sql in your local database to populate the department and doctor table
