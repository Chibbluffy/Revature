#GCP
- Google Cloud Platform
- 3rd largest in the world
	- fastest growing
- GCP built by google devs
- AWS built by Amazon IT Infrastructure 

#GCP Services
- SQL
	- Creates a VM that already has a version of SQL downloaded on it
	- opens the correct ports for connecting to the SQL database
	- Optimized for database usage
- Storage
	- Create buckets that are uniquely named (world)
	- these buckets can store any type of file
	- Can hold folders too
	- Static Web Site Hosting
		- way of deploying front-ends to users
		- put all html, css, js into a bucket and make public
		- very easy to do
		- very cost effective and reliable
		- less likely to fail than your VM
- Compute Engine
	- primary service for creating VMs in GCP
	- Advantages to hosting backends using GCP VMs
		- takes only a few minutes to create a VM
		- can pick any OS
			- can even choose custom boot disk (like copy of another VM)
		- publicly accessible
			- remember to disable firewall appropriately
		- delete instances whenever needed
		- Pay only what you are using
			- really saves on cost
		- GCP conveniently allows SSH through browser
	- Disk Storage
		- hard disk drive that a VM uses
		- Can detach a disk from a VM
		- Copy a disk/machine image

#Linux
- Operating system
	- based on Unix and written by Linus Torvalds
- Unix was designed in the early 1970s by AT&T
	- Operating system for mainframe computers
	- Multiple users would use the mainframe at the same time
		- this is why you have to have permissions on files
		- sudo (super user do) execute command as root user with complete access to machine
	- No graphics in a Unix system
		- everything done in text based terminal
- Why is it so popular for cloud computing and web server deployments?
	- it is essentially free
	- very lean and bare. no bloatware
	- Well established package managers
- Linux commands
	- `cd`
	- `ls`
	- `touch`
	- `mkdir`
	- nano, vim, emacs
	- `ps`
	- `mv`
	- `cp`
	- `rm`
	- `sudo`
	- `echo`
	- `man`
	- `cat`
	- `export`
	- `curl -O`
	- `chmod`
	- `tar -xzvf`
	- `./`
	- `grep`

#OWASP
- Open Web Application Security Project
- Non profit software organization dedicated to promoting good security practices
- Publish tutorials or hold meetings on how best to approach security
	- General security guidelines
		- Security should be layered
			- don't rely on one safeguard
		- design applications and permissions
			- If the only IP address that can access a database is known
			- then make the restrictions such that the firewall only allows that IP address
			- If a computer only needs access to a single bucket, ideally that computer only has access to that single bucket
- OWASP Top 10
	- the most common security flaws in applicatios that year
	1. **injection**
	2. **broken authentication**
	3. sensitive data exposure
	4. XML external entities
	5. broken access control
	6. security misconfiguration
	7. cross site scripting
	8. **insecure deserialization**
	9. using components with known vulnerabilities
	10. **insufficient logging and monitoring**

#Hibernate
- **ORM tool, object relational mapping framework**
- Advantages
	- object oriented
	1. SQL agnostic
	2. very easy and fast to use
	3. 3 ways to make queries
		1. Criteria
		2. HQL
		3. SQL
- hibernate.cfg.xml
	- details of connection
	- object/class mapping to tables
- Sessionfactory
	- should only use one, very large
	- Connection to the database
	- methods
		- opensession
		- gettransaction
		- begintransaction
		- gettransaction.save/update/delete
		- gettransaction.commit
		- close
- annotations
	- table
	- manytomany
	- onetomany
	- entity
	- id
	- column(name=)
	- generatedvalue(strategy=)
- lazy load/eager load
	- Lazy object is **PROXY** object
- Exception
	- LazyInitializationException
	- happens when you close the session before getting object
- states of an object in hibernate
	- **transient**
	- **persistent**
	- **detached**
- 3 ways to query
	- criteria
	- HQL
	- SQL
- Cascading
	- one to many, many to many
		- if you make an object attached to another object, it will update and change on the databases tables
- ACID
	- Atomic - all or nothing. 
	- Consistent - 
	- Isolated - 
	- Durable - failures should be graceful
- @joincolumn
- @OneToMany(mappedBy=, fetch=, cascade=)
- avoid native SQL in hibernate
	- not SQL agnostic
	- whenever using SQL queries, do not get LIST. gets RESULTSET
	- difficult to work with
- Phantom read (isolation issues)
- dirty read (isolation issue)
- @ManyToMany modes
	- create-drop
	- create
	- alter
- interfaces of hibernate
	- 
- Isolation levels
	- Read committed
	- Read uncommitted
	- repeatable read
	- serializable
- 

HIBERNATE
GCP
CI PIPELINE

Jenkins = Automated build server
Hibernate interfaces
- criteria API
- sessionfactory
- configuration
- query
- transaction

QC questions to review
- DevOps
- CI vs CD
- Jenkins
- Gradle framework
- Config file for hibernate
- get/load eager/lazy
- 
