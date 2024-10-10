# Prime numbers generator

A recruitment assignment app with requirements outlined at the end of this README.

## Structure

App is comprised of a backend written in Java 11 using Spring Boot and a frontend written in React (specifically Next.js).

## How to run

You will need to have Docker installed.
```bash
    docker compose up --build --detached
```

After the containers boot up go to http://localhost:3000 to access the UI.

## Build tools used

Gradle 8.10.2 - Java / backend

Next.js 14.2.14 - React / frontend

Both frontend and backend have their own Dockerfiles for building them.

## Possible improvements
- Frontend can only call backend on localhost (it's hardcoded), this would not allow for actual deployment.
- Spring Boot for Java 11 is out-of-support (open-source, Enterprise is still going). I could try out other frameworks.
- Spring Boot also allows for serving static files from /static directory, so the React frontend could be unnecessary by writing a simple html+javascript file. Although in a bigger app this would make more complicated UIs harder to write. 

## Assignment requirements

Write a web application with a Java-based backend that will allow calculating the prime numbers using any method (e.g., the Sieve of Eratosthenes). 
The application must contain a web page with a user interface that will allow entering the upper boundary of the prime numbers we want to calculate.

The solution should be delivered in the form of link to the project on your GitHub, or a zip archive containing: 

• The source code 
• Short instruction on how to run the application 
• Details of the type and version of build tools (if used). 

Other information: 
    • Use Java 11 
    • Starting the application should be possible using only one command. 
