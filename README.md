# Instructions
You will need to make sure you have [Maven](https://maven.apache.org/guides/index.html) installed on your machine and a [PostgreSQL](https://www.postgresql.org/) server running.

Once you have cloned the repository, copy the contents of the application.template.properties file into a new file named application.properties. 

You will need to provide the url to the database, as well as the username and password for a user with read and write privileges on the table that the application accesses.

    spring.datasource.url=spring.datasource.url=jdbc:postgresql://localhost:5432/your_database_name
    spring.datasource.username=your_username
    spring.datasource.password=your_password
    
## Running the Application
Once you have everything set up, navigate in the command prompt to the root folder of the project and run: 

    mvnw spring-boot:run

The application should download its dependencies and start up the server. 

The endpoint is /getCourses, and the parameters accepted are code and prefix. 

Here is an example request and response from the command prompt:

    curl "localhost:8080/getCourses?code=404&prefix=ENG"
    [{"advisingRequisiteCode":"ENG404","coreLiteratureRequirement":"NULL","catalogText":"Studies how English has evolved, from Indo-European ancestor, through Old and Middle English to present. Texts from different periods read, looking at how grammar, vocabulary and pronunciation have changed. Possible scenarios for future of languate discussed.","code":"ENG  404                      ","codeNumber":404,"prefix":"ENG","codeSanitized":"ENG-404","fees":"0","title":"HISTORY OF THE ENGLISH LANGUAGE","defaultCreditHours":"4","divisionCode":"UG","feeType":"NULL","fixedVariableCredit":"F","maxCreditHours":4,"minCreditHours":4}]
