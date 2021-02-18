#Java Questions  
1. What is Java?  
	Strongly and statically typed high level language  
	automatic memory management  
	write once run anywhere  
	Scalable and OOP  
	100% Pass-by-value  
2. What is in the JDK/JRE?   
	JDK is development kit, and encompasses JRE, and JVM. JRE is just the runtime Environment, and encompasses the JVM. JVM is just the virtual machine used to run and process these programs  
3. What is Git?  
	A Distributed Version control system.  
	Use a lot in command line, push, pull, fetch, commit, add, branch  
	Very good collaborating tool  
4. What is a constructor?  
	Initializer for an object. It sets up initial values, etc  
	Must be SAME name as object itself  
	Can overload constructors as much as you want  
	The only methods in Java without a return type  
	Can call super of parent class  
5. Tell me about some of the control statements in Java?   
	#???  
6. What are the scopes of a java variable?    
	Class/Static - only one copy, attached to class itself  
	Instance/Object - one copy per object made. attached to object  
	method - variables passed into the function  
	local/block - variables defined within the function  
	THERE IS NO GLOBAL SCOPE
7. Overloading/overriding  
	OverRiding is you overwrite the previous version of the function from a parent class  
	OverLoading is when you have multiple methods with the same name, but different parameters so that it can be more flexible  
8. What is an array?  
	A data structure that allows you to store a list of values of the same type.
9. What are varargs?  
	a variable number of arguments can be passed into a function, and it will be treated like an array
10. What are the access modifiers?  
	public - used anywhere  
	private - used only in same class  
	protected - can be used package and inherited packages
	default - can be used in same package
11. What is a String?  
12. String, StringBuilder, StringBuffer  
	String is immutable  
	StringBuilder allows you to mutate your String for faster string manipulations  
	StringBuffer is a ThreadSafe version of StringBuilder  
13. Strings outside of String pool?   
14. Exceptions  
15. Checked vs unchecked  
	Checked - Must clarify with ```throws Exception``` that an Exception can occur. Must also `try` and `catch` to handle the exception
	Unchecked - Runtime exception. It happens
16. Finally  
	Run at the end of any try catch block no matter if there was an exception or not.
17. Polymorphism  
	One object many labels
	Essentially, functions with the same name in the same scope. You can have OverRiding and you can have OverLoading.  
	OverRiding is you overwrite the previous version of the function from a parent class  
	OverLoading is when you have multiple methods with the same name, but different parameters so that it can be more flexible  
18. Abstraction  
	
19. Encapsulation  
	
20. Inheritance  
	
21. Garbage Collection  
	Java is automatic garbage collection. You can give it a push with gc, but it probably won't do anything. 
22. finalize  
	Basically declares a constant. Finalize makes the variable unchangeable, and unupdatable. 
	For Functions and classes, it makes it not able to be overridden.
23. Abstract Classes  
	Cannot directly be instantiated. Must have a child class that extends it, and then you instantiate the child class
24. Interfaces  
	
25. Marker interfaces  
	Literally a blank interface. Does nothing except mark an object as something-able
26. Functional Interfaces  
	
27. File I/O  
	
28. Scanner  
	A class that helps with reading in input
29. Serialization  
	Not secure anymore. Used to be the way that you can save objects to file, so you can use it again later 
30. transient  
	
31. Collections API   
	Most commonly used API. Everything inherits from Collection class, except for Map  
	Iterable  
32. ArrayList vs LinkedList  
33. Maps  
34. Generics  
35. JUnit  
36. Annotations  
37. Maven  
38. Maven lifecycle  
39. Comparator  
40. Threads  
41. Synchronized  
42. Runnable  
43. Deadlock  
44. Log4j  
45. Equals vs ==  
	The same for an object until it is overridden. For objects, it compares the memory address by default
46. Object class  
	Everything inherits from the object class except for primitives
47. Lambdas  
	Functions stored in a variable. Allows functional programming and callback functions


About me? Goodchecked vs unchecked?Core features of Java? pretty verbose, WORA, Object orientedscopes? The global scope. variable scope. why to override? change the return type... (need to be careful when saying that)constrcutors? fineObject class? most objects inherit the object classimportant methods? could not remember important methodslist vs set? good



Thread
Lambdas
static class

About me? pretty good
Overloading vs Overriding? good
== vs .equals()? good
what is a toString()? good
checked vs unchecked exception? good
create my own lambda? only one method I think (function assigned to a variable)
create my own thread? fine (hard question)
String vs StringBuilder? good
Scopes in Java? good
make something class scope? make it private
are access modifiers and scopes related? yes but not same


Wrapper class
- Object version of a primitive
Autoboxing
- primitive to wrapper
unboxing
- wrapper to primitive

JDK, JRE, JVM
Scanner class

Primitives
- float, int, double, long,  char, byte, boolean, 
Lambdas
- in-line function. Functional programming. To make one, you do an interface with only one method.

Collections 
- most commonly used data structure objects. All are iterable except for map
- LL, ArrayList, map
String class
- Object, immutable, string pool.

Comparator
Java

Scopes
Threading

Exception
Access Modifiers
Errors

try catch catch
organize specific first?

Abstraction
Constructors

Polymorphism
Overloading/overriding

Encapsulation
list/set, queue/stack

inheritance
JUnit

interfaces
Gradle
- Dependency manager tool
Log
- levels: Info, warn, errer, debug

abstraction
- ***Intent over implementation


Use newline with Scanner makes it easier
