## Prerequisites to run tests

- Java 11
- maven 3
- terminal
- git
- intelliJ

## Steps to run tests
1. `git clone `
2. `mvn clean test`
3. find jUnit reports under `target/surefire-reports/` directory
4. `.txt` files contain requests and responses for failed tests
5. `.xml` files are the reports that can be used by a build tool like jenkins for test reports


## mvn Dependencies
- [REST-assured](https://github.com/rest-assured/rest-assured)
- [jUnit](https://github.com/junit-team/junit4)
- [Hamcrest](https://hamcrest.org/)
- [Lombok](https://projectlombok.org/)
- [gson](https://github.com/google/gson)
- [Shazamcrest](https://github.com/shazam/shazamcrest)

## Test Design
- All Code is under `src/test/java/org.hbahuguna.petstore` package
- `config` package contains REST-Assured configurations to run tests
- `data` package contains `beans` and `model` packages
- `beans` package contains beans for expected pet responses
- `model` package contains POJOs to deserialize responses and build expected beans for tests
- `request` package was intended to keep code related to requests. Right now it has an Enum to pass different status requests to findByStatus endpoint.
- `test` package contains the tests for both endpoints
- test classes extend from a base class that contains methods for POST and GET
- `findByStatus` is not reliably returning same results, so we need to post a pet and then verify that recently created pet exists in the response
- this way our tests are more reliable, since it creates its own data
- each time post creates a random name and then we check in the response that there exists a pet with this randomly generated name
- There is a bug that was discovered, when we pass "&" as a status, its returns a valid response

  
 
 

