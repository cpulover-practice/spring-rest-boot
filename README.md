# List of practiced topics

### Spring Boot Dependencies
- Spring Web
- Spring Data JPA
- H2 Database
- Lombok
- Spring Boot DevTools
- Validation
- Spring HATEOAS
- Spring Boot Actuator: supports monitoring
- Spring Data REST HAL Broswer: supports monitoring

### Rest Controller
[[UserRestController]()]
- @RequestBody: bind the request body to request method parameter 
- Recommend: return a created status (201) for POST method 
- Recommend: return customized error for single entity methods (GET, DELETE) in case not found
- Recommend: apply Validation API for POST, PUT method 
[[User]()]
- HATEOAS

### Internationalization
1. Configure LocaleResolver and default Locale 
[[SpringRestBootApplication]()]
2. Create resource for messages (important: use ```_```) 
[[message.properties]()] [[message_french.properties]()] [[message_vietnam.properties]()]
3. Configure ResourceBundleMessageSource with the created sources 
   - In the application 
[[SpringRestBootApplication]()]
   - In 
[application.properties]()
4. Inject the MessageSource into Rest Controller 
[[DemoRestController]()]
5. Update the internationalized API

### Negotiation: XML Support
- Support XML request and response
- Add Jackson Dataformat XML dependency 
[[URL](https://mvnrepository.com/artifact/com.fasterxml.jackson.dataformat/jackson-dataformat-xml)]
- To get XML response, set "Accept" key header as "application/xml" in REST client tool
- If both XML and JSON is enable, XML is selected as response format in the browser

### Swagger: Documentation
- Add Springfox dependency and SNAPSHOT repository 
[[pom.xml]()]
- Create Configuration class and customize the document 
[[SwaggerConfig]()]
- Use @ApiModel and @ApiModelProperty to add description for resources in the document 
[[User]()]
- Built-in endpoints:
  - ```/v2/api-docs```
  - ```/swagger-ui/index.html```

### Monitoring
- Depenencies: Spring Boot Actuator and Spring Data REST HAL Broswer
- Built-in Actuator endpoints 
[[URL](https://docs.spring.io/spring-boot/docs/current/reference/html/production-ready-features.html)]
- HAL browser = API client tool (can perform POST/PUT request): root path or ```browser/index.html```
- Not recommend to use Actuator to monitor for the production because of the performance impact

### Filtering
Exclude bean fields from the JSON response
#### Static filtering 
[[User]()]
- Use @JsonIgnore for bean fields
- Use @JsonIgnoreProperties for bean class

#### Dynamic filtering
1. Create View as collection of different views for the bean 
[[UserView]()]
2. Use @JsonView for bean fields 
[[User]()]
3. User @JsonView on the request methods to apply the views 
[[UserFilteringRestController]()]

---

### Notes
- @PathVariable and @RequestParam: bind path variable to request method parameter 
[[DemoRestController]()]
- Recommend: convert application.properties to application.yml for hierarchical structure
- To use special characters in application.yml, put in ```''``` or ```""```
- Use ```value``` to map multiple endpoints to one method 
[[UserFilteringRestController]()]


