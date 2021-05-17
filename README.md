## Poker Game System

A poker game system with the following functionalities:

- Create and delete a game
- Create a deck
- Add a deck to a game deck
- Add and remove players from a game
- Deal cards to a player in a game from the game deck
- Get the list of cards for a player
- Get the list of players in a game along with the total added value of all the cards each player holds
- Get the count of how many cards per suit are left undealt in the game deck
- Get the count of each card (suit and value) remaining in the game deck
- Shuffle the game deck

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


## Other information
- I used Intellij and Java JDK 15
- Two players are already in database (id 1 and 2)
- if mapstruct raises the following error in IntelliJ:
  Cannot invoke "java.net.URL.toExternalForm()" because "resource" is null
  Then add "-Djps.track.ap.dependencies=false" in File/Settings / Build, Execution, Deployment / Compiler 
In Shared Build process VM options field

## Improvement
- More test could be added but there was not enough time, maybe integration test
- Database versioning with liquibase for example
- Refactoring Game Service which may be too big
- Maybe Move some logic from Game to another class