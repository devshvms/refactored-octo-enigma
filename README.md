# refactored-octo-enigma
spring-boot APP-ONE

**PRE-REQUISITE** 
maven tool
java v17

**STEPS**
1. clone repo
2. Run following command in directory POM.xml is present.
    mvn spring-boot:run
3. If you see started application ... at port 8081 open http://localhost:8081/actuator in browser.
4. if you're getting some error check java version, default port 8081 if its not free.

**What all packages covered?**
1. spring-boot-web
2. spring-boot-starter and test
3. spring-boot-actuator
4. spring-boot-security and test with filters
5. springdoc-openapi-ui [docs_link](https://redocly.com/redoc/)

## More Details 

1. spring security dependency added with some small tweaks [TO_WATCH](https://www.youtube.com/watch?v=EeXFwR21J1A)
2. To authenticate: `/login` to access actuator (admin, ADMIN, ~~QazXsw@12~~) (user, USER, ~~pass~~) username, role, password respt.
3. GitHub repo is polling to `http://<ip>:8080/github-webhook/` link on any commit in master branch. 
5. `springdoc.show-actuator=true` will expose actuator endpoints to api docs 
6. UI is access-able at: `/swagger-ui/index.html`