spring-antbuild
===============

Project based on http://docs.spring.io/docs/Spring-MVC-step-by-step adapted as per tomcat deployment guide.

Dependencies are now managed with Gradle.

Run the following command before using Ant so the required JARs are copied to
`ProyectoWeb/lib` and later packaged in the WAR:

```
gradle copyDependencies
```

Eclipse project files included with all dependant jars remain for convenience.

Start DB: 
	java -classpath dependencies/hsqldb-2.3.2.jar org.hsqldb.Server -database test
