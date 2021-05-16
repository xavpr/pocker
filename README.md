## Poker Game System

## This API is built with the following technologies
- spring boot framework
- maven
- H2 database
- JPA
- lombock
- mapstruct
- swagger

## Access
- to the application: http://localhost:8080/swagger-ui/index.html
- to the database: http://localhost:8080/h2-console

## Tradeoffs
- 
## Other information
- I used Intellij and Java JDK 15
- if mapstruct raises the following error in IntelliJ:
  Cannot invoke "java.net.URL.toExternalForm()" because "resource" is null
  Then add "-Djps.track.ap.dependencies=false" in File/Settings / Build, Execution, Deployment / Compiler 
In Shared Build process VM options field
