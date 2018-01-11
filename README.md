# A Starter Software Project
This starter software project includes a front-end and back-end developed using the following technology stack:
* [Vue.js](https://vuejs.org/) as the primary front-end framework
* [Spring Boot](https://projects.spring.io/spring-boot/) as the primary back-end framework
* An embedded database for persisting data objects
* An embedded search index for efficiently querying data objects (to be refactored into, once the limits of "live" querying the relational database has been reached)
 
## Building and Running the Application
 
### Prerequisites
* Java 8
* Node 9.3.0 or higher
* Update environments as necessary to ensure these commands are available via the command line: `java`, `node`, and `npm`
  
We recommend installing the above dependencies via package managers like [Homebrew](https://brew.sh/).
Otherwise, Google for installation instructions applicable to your operating system.

### On Mac or Unix/Linux
From the project root directory:
* Execute this command to build the app: `./mvnw clean package`
* Execute this command to run the app: `java -jar target/rei-prototype-0.0.1-SNAPSHOT.jar`

### On Windows
From the project root directory:
* Execute this command to build the app: `mvnw.cmd clean package`
* Execute this command to run the app: `java -jar target/rei-prototype-0.0.1-SNAPSHOT.jar`

## Backend Development Tips
* Learn about Java or languages with a Java-like syntax
* Familiarize yourself with the [Spring Boot framework](https://projects.spring.io/spring-boot/) (a defacto standard).
* Backend files reside in `src/main/java`, per the standard [Maven project directory layout](https://maven.apache.org/guides/introduction/introduction-to-the-standard-directory-layout.html).
* To view how, or even whether, data is being persisted in the embedded database:
  * Point your browser at: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
  * At the prompt, use `jdbc:h2:mem:testdb` for "JDBC URL", `sa` for "User Name", leave "Password" blank
  * You are now looking at a database web client, where you can directly issue SQL commands

## Frontend Development Tips

### Files to Edit
A frontend build has already been configured for you, no need to fiddle with additional configurations.
Simply focus on editing these files:
* `src/main/javascript/index.html`; and
* Any files in `src/main/javascript/src`

For additional information about the structure of the frontend project in `src/main/javascript`, follow [this link](http://vuejs-templates.github.io/webpack/structure.html).

### [Hot-Loading](https://www.quora.com/Whats-hot-loading-in-Webpack-and-how-does-it-work) Frontend while Proxying to Separate Backend
In order to shorten your feedback loop by avoiding time wasted waiting for backend builds, we recommend running the frontend separately from the backend.

To do so:
* Execute this command from the project's root directory: `java -jar target/rei-prototype-0.0.1-SNAPSHOT.jar`
* Execute this command from the `src/main/javascript` directory: `npm run dev`

Executing the above commands results in:
* An instance of the UI running on [http://localhost:3000](http://localhost:3000) with support for hot-reloading
* An instance of the UI proxying requests to its backend running on [http://localhost:8080](http://localhost:8080)

### Available RESTful Endpoints
This project facilitates learning and/or rapid application development by providing sample RESTful endpoints that may be modified.
These sample endpoints allow for the typical Create, Read, Update, and, Deletion (CRUD) of Contact records.

Here are the endpoints:
* `POST http://localhost:8080/api/contacts` - create a new contact, use the more specific `people` endpoint if the contact is a person.
* `POST http://localhost:8080/api/people` - create a new contact of type person.
* `GET http://localhost:8080/api/contacts` - retrieve a paginated set of contacts.
* `GET http://localhost:8080/api/contacts/{id}` - retrieve a contact by the provided id.
* `DELETE http://localhost:8080/api/contacts/{id}` - marks a contact as inactive, so it does not show up in queries.
