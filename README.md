# **URL Shortener Service**

This is a **Spring Boot** based URL Shortener service, which uses an embedded H2 Databse instance. Please ensure you have [Java 8 development SDK](http://www.oracle.com/technetwork/java/javase/downloads/index-jsp-138363.html) installed in your local machine. Then launch the app by executing `gradlew clean bootRun` from the project root directory.

Browse to http://localhost:8080 for index route. The app use HATEOAS to make REST API perusal easier.

You might need the **Lombok plugin** for your IDE to run it in your IDE (*Eclipse/IntelliJ*). 