# litcal
This is a sample webapp using spring-boot, embedded tomcat, and thymeleaf.

It requires Java 8u121.  OpenJDK is fine, and recommended.  If not, use Oracle
Java and remove the mission control app.

This is a work in progress.  So it is not nearly done.  The goal is for it to
show a Roman Catholic liturgical calendar for the input year when done.

I've implemented a lot of features in the pom.xml:

* Code coverage
* PMD
* FindBugs
* Checkstyle
* jacoco code coverage
* errorprone compiler enhancement
* lombok
* maven wrapper
* tattletale report

The generated javadoc properly uses the delomboked source, and provides the
appropriate javadoc directives.

This project also includes the NetBeans project files.  NetBeans has the best
maven integration, IMHO.

It would be nice to have a mail agent listening on port 25, which would accept
mail sent to "matt@localhost".

To run, make sure nothing is using port 8080, and on the command line,

**./mvnw spring-boot:run**

Point your browser to [http://localhost:8080/litcal](http://localhost:8080/litcal)
