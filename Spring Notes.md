#Spring
- Java Framework for making Enterprise Level applications
- Framework VS Library
	- Framework
		- You write code to fit into the application
		- The application calls your code
		- You HAVE to code the way Spring wants you to.
			- You are building a Spring application
	- Library
		- You use someone elses code in your application
- Usually web applications but not strictly
- Came out in 2009* maybe?
- Before Spring there was EJB (Entity Java Beans)
	- Very buggy
	- Hard to work with
	- Proprietary software that you had to pay Oracle for
- Spring killed EJBs
	- Spring was free
	- Open source
	- also much better
- The heart of Spring is the IoC container (Inversion of Control)
	- Called Spring CORE
	- Main purpose is to control the lifecycle and management of Spring Beans
		- Lifecycle
			- How many instances of this bean exist in the application
			- When do they get created
		- Management
			- Fulfilling of dependencies in beans
			- Done via dependency injection
	- Spring Beans are objects that are managed by the IoC container
	- In newer versions of Spring, the IoC container is called the application context
		- Previously called the Bean Factory
- Spring is modular by design
	- Spring CORE
		- IoC Container
	- Spring WEB
		- Creating controllers
	- Spring DATA
		- Creating a persistence layer (DAOS/Repositories)
	- Spring AOP
		- Aspect Oriented Programming
	- Spring Actuator
		- Metrics for your application
	- Spring Security
		- Everything security related

#Spring BOOT
- A highly opinionated version of Spring
	- It will do a lot of the default configuration that you would normally do in Spring if not using Spring Boot
	- Quickly creates backend servers
- All configuration for the appplication is in an application.properties file
- Autogenerates many beans without you having to explicitly define them
- Will automatically create an IoC container co hold your beans 
- NOT A MODULE OF SPRING

#Spring DATA
- persistence module for Spring
	- Think of DAOS except Spring calls them repositories
- Setting up spring data
	- Driver and datasource URL listed in application.properties
	- Annotated entity class(es)
	- `@EntityScan(basePackages = {"package holding entities"})`
		- tells Spring DATA where to look for entities
	- `@EnableJpaRepoositories(basePackages = {"package holding repos"})`
	- Create a repository interface
		- `@Repository`
		- `extends CrudRepository<EntityType, PrimaryKeyType>`
		- Anywhere you want to use the repo
			- `@Autowired`
				- Tells Spring to find a bean of this type and inject it

#Spring AOP
- Aspect Oriented Programming
	- A paradigm of programming much like functional or OOP
- The biggest plus to AOP is to avoid code entanglement
	- your methods should only have to concern themselves with their own logic
- CCC (Cross Cutting Concern)
	- Any problem or issue in an application that cannot be addressed by a single layer
		- the cuts across multiple layers
	- Examples
		- logging
		- security
- Aspects
	- Classes dedicated to a cross cutting concern
		- Addressing the entirety of a CCC in one place
			- `@Aspect`
- Advice
	- Methods that will be called when certain *joinpoints* are used
		- `@Before`
		- `@After`
		- `@Around`
		- `@AfterThrowing`(advice only is applied if an exeption escapes the method)
		- `@AfterReturning`(advice only applied if method concludes successfully)
- Joinpoint
	- Any place in an application in an application where an advice method chould be called
		- In Spring this is when a method is invoked
- Pointcut
	- A regular expression that defines what joinpoints an advice method works on
		- Hook method
			- Private method with no implementation
				- `private void myJoinPoint(){}`
				- `@Pointcut("regex")`

#Spring WEB
- Module responsible for creating the API web layer/controllers
- Annotations
	- `@Controller`
	- `@RestController`
	- `@ResponseBody`
	- `@RequestBody`
	- `@PathVariable`
	- `@QueryParam`
	- `@GetMapping`
	- `@PostMapping`
	- `@PutMapping`
- Spring MVC diagram
- Spring does a lot for you under the hood
	1. Front Controller design pattern
		- All requests are first funneled to a single location
		- Those requests are then sent to the appropriate controller
	2. Every HTTP request went to a dispatcher Servlet bean
		- Then it reads a handler mapper bean
			- This maps the HTTP request URI to a specific controller method
	3. The request is then sent to a controller to be handled
	4. 5. 6. are all related to server side rendering
		- Type of webapp where the HTML CSS and JS is rendered by the backend and sent to the front end along with the data (older way of doing things)
		- The applications we make with the backend just sends the data(model) 
		- Spring would match your data model to an html template and send it back

#Spring Actuator
- The metrics and dev-tools module of Spring
- There are other dev-tools modules
- Contains helpful endpoints for managing your Spring application

#Tips for Spring
- infinite JSONS from an endpoint
	- comes from bi-directional mappings btw your entities
	- EX. A movie has a set of actors and then that actor has a set of movies
	- Solutions
		- `@JsonIgnore` to prevent that field from being turned into a JSON
		- Or avoid bidirectional mappings
			- it is ok to do extra HTTP requests to do something
		- Or use `@BackReference`/`@ManageReference`
- H2 (in memory database for testing)
	- H2 Database Engine in Maven
- 
