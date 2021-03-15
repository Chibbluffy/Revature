#Angular Architecture
- modular in design
	- every application has a root module
		- main registry for components and other modules that comprise your angular application
			- FormsModule
			- HttpClientModule
			- MaterialModules
			- RoutingModule
		- app.module.ts file
- Components
	- Visual aspect of an angular application
	- They are what a person sees and interacts with
	- Logical chunk of HTML/CSS/TS
	- Reusable
	- can be nested
	- every application has app-root as main component
		- bootstrap component
			- first component pulled into the index.html
	- 3 parts of any component
		1. decorator
			- @Component()
				- contains meta-info like the selector and link to template
		2. HTML template (Visual)
			- defined directly in the component or reference a file elsewhere
		3. TS class
			- logic for the component
			- Variables and methods that work on the template
	- Whenever a component is rendered for the first time, it calls the `ngOnInit()` function
- Services
	- Singletons
		- when you create a service, angular will only ever make one instance of that service
	- Services via dependency injection are put into your components
		- `Constructor(private someService:SomeService)`
	- Are used to share data between components
	- Reuse commonly used functions in your application without having to retype functions
		- DRY = do not repeat yourself
- Pipes
	- Transform values
	- Must have an input and MUST give out some output
	- Very helpful for formatting and converting information in the HTML
		- `{{x | currency:'USD'}}`

#Binding in Angular
- One way binding
	- interpolation
		- TS -> HTML
			- `name:string = "adam"` -> `{{name}}`
	- event binding
		- HTML -> TS
			- `<button (click)="hello()">` -> `hello()`
	- property binding
		- example later
		- 
- Two way binding
	- `[(ngModel)]`
		- HTML <=> TS
		- Simultaneously talk to each other

#Routing
- app.routingmodule.ts
	- has a variable called routes
		- can add route objects
		- `{path:"home", component:HomeComponent}`
	- router-outlet tag in app-component.html where the selected component will get placed into

#***Directives***
- Custom HTML specific to angular
- Makes our HTML dynamic
- 3 types of directives
	1. Component directive
		- custom HTML tag 
		- <app-table-component>
	2. Structural Directive
		- *ngFor
		- *ngIf
		- Manipulate DOM by adding or removing elements
	3. Attribute Directive
		- custom attributes
		- [(ngModel)]

#Angular CLI commands
- `ng new projectname` creates new project
- `ng generate component` creates and updates files
- `ng generate service` creates and updates files
- `ng generate pipe` creates and updates files
- `ng serve` runs dev server, autoload
- `ng build` transpiles and links code into a deliverable. Gets created in the dist/projectname
- `ng add packagename` installs a package

#HTTP Requests in Angular
- import HTTPClientModule in app.module.ts
- dependency inject in constructor the HttpClient
	- usually only services inject this
- `http.get<model-type>("url")`
	- default returns an observable
	- `.toPromise()` to turn to a promise
	- Observables are more powerful than promises
	- with a promise you are waiting on 1 thing to come back
	- You can subscribe to an observable and perform a function every time you get an update
		- similar in concept to webhooks
		- 
