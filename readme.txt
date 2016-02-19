1) to run we need to have installed Java 8 (I used 1.8.0_51)
2) for build I used Apache Maven (I used 3.3.3)
3) archive contains creditcard-processor-1.0-SNAPSHOT-jar-with-dependencies.jar but if you want to build you can do "mvn clean install" in /creditrcard-processor/credit-card-processor/ folder. It will build everything and run unit test.
4) in the folder creditrcard-processor run.sh is located (if it is not executable, "chmod +x run.sh" should help)
5) you can use sample input from junit tests "./run.sh < credit-card-processor/src/test/resources/base_test.txt"

I used Java because it is crossplatform.
I used Apache Maven. It build project with all dependencies to one jar and also run Junit tests during build.
Source code located under creditrcard-processor/credit-card-processor/src/main/java/dzvz
Tests are located in creditrcard-processor/credit-card-processor/src/test/java/dzvz/CreditCardBalanceTrackerTest.java


Classes:
dzvz.clientsCreditCardConsoleClient - client which will listen input and use Operation class to figure out the operation.
CreditCardService uses InMemoryCreditCardRepository.
All implemented using operations (even summary).




