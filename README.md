# springfox springboot starter

> base on the springfox library, which is useful to reference the swagger ui, just simple wrapper it and can easy use in the springboot


### how to use?

* if you use maven, just add the pom dependency to the pom.xml

```
 <dependency>
  <groupId>com.dwb.middleware</groupId>
  <artifactId>springfox-springboot-starter</artifactId>
  <version>1.1-SNAPSHOT</version>
</dependency>
```
* the configuration in the application.properties

```
springfox.swagger.contact-name=walis
# the switch, true to show the interfaces info in the swagger ui
springfox.swagger.doc-switch=true
springfox.swagger.email=wq19880601@gmail.com
springfox.swagger.title=service downgrade
springfox.swagger.version=1.0.0
# the prefix in the swagger interfaces
springfox.swagger.path-mapping=/dd
# just the show the matched urls in you spring mvc controller
springfox.swagger.path-match=/exp.*
springfox.swagger.description=springfox for swagger ui example
```




