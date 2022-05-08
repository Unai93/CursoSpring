# Carrera desarrollador spring
## Semana 1
### Curso de __SPRING__ Core

1. Introducción

	- __SPRING__ es un framework de código abierto para la creación de aplicaciones empresariales en Java que tiene estructura modular y gran flexibilidad para implementar distintos tipos de arquitecturas según las necesidades de la aplicación. 
	- Se origina como respuesta al modelo __EJB__ más complejo y menos adaptable y es un complemento al modelo __JAVA EE__ 
	- __SPRING__, dentro de la aplicación empresarial, actúa principalmente en la capa de aplicación, aunque también lo hace con sus capas fronterizas, la capa de Interfaz de Usuario y la capa de Datos.
	- Un patrón de diseño es una solución a un problema, que ya ha sido utilizada, y cuya efectividad ha sido probada;
además, es reutilizable en problemas con circunstancias similares.
	- En __SPRING__ se usarán patrones de diseño como: la inyección de dependencias, Singleton, Prototype, Proxy, MVC, Front Controller y Fatory. 
	- La inversión de control consiste en que los métodos definidos por el usuario para adaptar el framework, a menudo, serán llamados desde el mismo framework, en lugar de desde el código de aplicación del usuario. El framework a veces desempeña el papel de programa principal en la coordinación y secuenciación de actividad de la aplicación. Esta inversión de control proporciona al framework la posibilidad de servir como un esqueleto extensible. El usuario proporciona métodos que adaptan los algoritmos genéricos, dotanto así de independencia a los objetos.
	- La inyección de dependencias es una forma de inversión de control. Si un objeto necesita de otros, en lugar de instanciarlos, declara una serie de dependencias y esperará que le sean proporcionadas.

2. Contenedor de inversión de control

	- Un __bean__ se trata de un objeto gestionado por nuestro contenedor de inversión de control, se crean con los metadatos que proporcionamos, debemos darle un id único dentro del contenedor e indicar la clase sobre la que lo definimos.
	- Un __bean__ se puede crear mediante 
		```
		appContext.getBean(id)
		appContext.getBean(id,class)
		appContext.getBean(class)

	- La inyección de dependencias puede hacerse vía setter, vía constructor o por referencia a otro bean.
	- Spring también permite la inyección automática entre beans que se necesitan, reduciendo así la configuración necesaria. Puede hacerse en función del nombre o del tipo de la propiedad requerida, o de los argumentos del constructor. Tiene por contra que los tipos primitivos y los String no se pueden autoinyectar, y que se pueden producir inexactitudes o ambigüedades.
	- Mediante instrucciones específicas se puede excluir beans de ser autoinyectados o dar preferencia a un bean frente al resto del mismo tipo para ser autoinyectados

3. Ámbito y ciclo de vida de un Bean
	- Una vez definido un bean pueden crearse instancias de la clase sobre la que se definde el bean.
	- En el ámbito singleton, se crea una única instancia. Todas las referencias a ese bean serán el mismo objeto. Este es el ámbito por defecto.
	- En el ámbito prototype, se crea una instancia, en tiempo de ejecución, cada vez que le requiere.
	- Existen otros ámbitos como el ámbito web, el ámbito request, el ámbito session y el ámbito application.
	- Se puede interactuar mediante callbacks en los distintos momentos del ciclo de vida de un bean. Esto puede hacerse implementando las interfaces InicializingBean y DisposableBean o mediante la configuración vía xml.
	
4. Configuración basada en anotaciones

	- Al configurar mediante anotaciones evitaremos la configuración con XML, reduciéndola al mínimo.
	- @Required indica que una propiedad debe ser necesariamente inyectada, si no, produce una excepción, evita NullPointerExceptions.
	- @Autowired tiene el mismo efecto que la configuración vía XML, buca el bean adecuado y lo inyecta en la dependencia, realizando un autocableado por tipo. Puede usarse en el método stter, en la definición de la porpiedad y en el constructor. Si no encuentra ningún bean candidato, profuce excepción, salvo que se configure para hacer lo contrario.
	- Cuándo hay más de un bean de un tipo, la propiedad primary nos permite indicar cual tendrá prioridad, es decir, cuál es el único que será inyectado de todos los del mismo tipo. Si hay más de uno, saltará una excepción.
	- Mediante @Qualifier, se puede buscar un bean específico entre todos los del mismo tipo, ya sea indicando su nombre, los argumentos de un método o a través de un valor de qualifier indicado en el XML. También pueden crearse anotaciones que extiendan @Qualifier, dando lugart a código más legible.
	- @PostConstruct y @PreDestroy permiten especificar métodos para estos distintos puntos del ciclo de vida del bean.
	- Mediante el uso de estereotipos podremos anotar los componentes candidatos para el escaneado. Tenemos el estereotipo básico @Component, del que derivan @Service, @Repository y @Controller.
	
5. Configutación a través de __java__

	- Mediante __JAVACONFIG__ se puede prescindir por completo de XML
	- @Configuration indica, a nivel de clase, que en ésta, se va a definir uno o más de un @Bean (que será una etiquera a nivel de método).
	- Mediante AnnotationConfigApplicationContext registeamos las clases de configuración. El escaneao tiene el mismo comportamiento que en XML
 
## Semanas 2 y 3
### Curso de Spring Boot y Spring MVC 5: Creando una aplicación con Spring Boot y Spring MVC 

Spring boot facilita la creación de aplicaciones basadas en Spring independientes. Usa un servidor embebido, proporciona dependencias iniciales que facilitan la configuración, puede llegar a permitir la configuración automática de librerías de terceros, etc.

1. Spring Boot

	- La convención sobre configuración es
un patrón de diseño de software usado por muchos frameworks que trata de
minimizar el número de decisiones que un programador tiene que tomar al usar dicho framework, pero sin perder la flexibilidad.
	- Si la convención sobre configuración es
suficiente para lograr un determinado
comportamiento, el programador no tiene
que configurar nada explícitamente.
	-Si la convención no es suficiente para
obtener el comportamiento deseado,
configuramos los aspectos necesarios.
	- Estructura del proyecto:
	
		- POM.XML con los datos de nuestro proyecto, Pom parent, propiedades, dependencias y plugins.
		- Código fuente con el código de la aplicación, los recurso y test.
		- Librerías (asociadas a las depencencias incluidas en el POM)
		
	- En la clase main se usa la anotación @SpringBootApplication que realiza la configuración automáticamente. Y con SpringApplication.run(Application.class,args) comienza la ejecución de Spring, el servidor de Tomcar y posteriormente, la aplicación.
	- En el POM existen un tipo de depencencias llamadas STARTER con descriptores de dependencia fáciles de usar, que son una ventanilla única para agregar a un proyecto las tecnologías de Spring y otras relacionadas y que nos evitan añadir las dependencias una a una. Esto añade múltiples ficheros .jar y diferentes elementos de configuración, pero solo aquellos necesarios para el tipo de proyecto que queremos realizar. Pueden añadirse en la definición del proyecto, o posteriormente, modificando el POM.
	
2. Spring Web MVC

	- Una aplicación Web es una herramienta accesible a través de una red (generalmente internet) mediante un navegador web.
	- No requieren instalación ni actualización por parte del usuario, son multiplataforma y multidispositivo, son de fácil acceso, ahorran tiempo al programador, ahorran espacio al cliente, etc. Por contra, tienen menor velocidad y capacidad de procesamiento, menos funcionalidades que aplicaciones nativas y pueden presentar problemas de disponibilidad, ya sea por falta de conectividad, por caida de servidores, etc.
	- Están basadas en el protocolo HTTP, se accede a ellas mediante una URL, utilizando métodos como GET, POST, HEAD, PUT, PATCH, etc; estos métodos devolverán siempre, aunque no necesariamente únicamente, un código de respuesta HTTP, que indicará si el resultado de la petición es satisfactorio o, en caso de error, de qué tipo de error se trata.
	- En estas aplicaciones se utiliza el patrón de diseño MVC, es decir Modelo - Vista - Controlador, que permite una mayor adaptación a los cambios en la aplicación, y da soporte a múltiples tipos de vistas distintas; así como el patrón DAO, DATA ACCESS OBJECT, que permite separar el código principal de la estructura de la base de datos.
	- La aplicación Web tendrá la siguiente estructura:
	
		- Controladorees: Clases con métodos que atienden a las peticiones desde el navegador, acceden al modelo y lo devuelven a la vista.
		- Modelo: clases que modelan los objetos del modelo de negocio, respositorios y servicios, cada uno de estos en un paquete distinto (uno para las clases, otro para repositorios y otro para servicios).
		- Vistas: plantillas que serán procesadas y se visualizan en el navegador, y recursos estáticos, como CSS, imágenes, JS, etc.
		- Otros elementos como configuración, seguridad. utilidades...
	
	- Conceptos de Java EE
	
		- Servlet: Clase que nos permite gestionar peticiones/respuestasde una aplicación
servidora.Usualmente usados en contextos web bajo el protocolo HTTP. Se ejecutan en un contenedor de servlets (por ejemplo, Tomcat)
		- WEB.XML Descriptor de despliegue: Fichero que indica cómo desplegar en el servidor los componentes de la aplicación.
		- FILTER: Permiten transformar las peticiones, las respuestas HTTP, el  circuito normal que seguirían éstas en función de su contenido. Por ejemplo: cambiar la codificación a UTF-8.
		
	- Uso de estos conceptos en Spring MVC:
	
		- Dispatcher Servlet: despacha todas las peticiones (delegando en otras clases).
		- Contextos: Una aplicación Spring necesita un ApplicationContext: contenedor de inversión de control, en las aplicaciones web tenemos WebApplicationContext.
		- Uso de beans que colaboran con el Dispatcher Servlet para el mapeo de peticiones a métodos de un controlador y para transformar los nombres de vistas en vistas con las que renderizar una respuesta.
	- Spting Boot realiza automáticamente la configuración del Dispatcher Servlet.
	- El Controlador es la clase que se va a encargar de atender peticiones y derivarnos a una vista adecuada. Se crea en una clase normal de java mediante la anotación @Controller, y sus métodos irán anotados con @RequestMapping o sus derivados (@GetMapping, @PostMaping,etc.) no importa el nombe de las funciones y éstas no tienen por qué recibir parámetros, además si devuelven un String, será la ruta de la plantilla sin la extensión (.html) que será resuelto por el ViewResolver configurado.
		- Pueden pasarse datos a la vista con java.util.Map, org.springframework.ui.Model, org.springframework.ui.ModelMap.
		- @ModelAttribute permite acceder a un objeto del modelo
		- @RequestBody permite acceder a un objeto del cuerpo de la petición
		- HttpEntity<?> permite acceder a la petición (encabezado y cuerpo)
		- Si no devuelven un String, los métodos pueden devolver un @ResponseBody + cualquier tipo de dato, un HttpEntity< ?>, ResponseEntity< ?> (respuesta HTTP completa) o un ModelAndView (modelo con la vista en un solo objeto).
		- Un controlador puede tener cuantos métodos sean necesarios, el límite lo establece el diseño de clases de la aplicación.
		- A una petición se le puede pasar información tanto en el path de la URL como en la query de la URL, mediante @PathVariable y @RequestParam respectivamente.

	- La vista es la parte encargada de renderizar las
plantillas que visualizará el usuario.
		- Thymeleaf es un motor de plantillas que enfatiza el uso de plantillas naturales. Su integración con Spring es muy sencilla, e inmediata con Spring Boot.
		- Spring Boot + el starter de Thymeleaf es la forma más sencilla de realizar la configuración, pues se configuran automáticamente el ViewResolver, el TemplateEngine y el TemplateResolver. Aunque esta congiguración puede cambiarse posteriormente.
	- El contenido estático (ficheros .html, Imágenes, CSS, JS, etc.) se almacena en la carpeta /src/main/resources/static 
	- Spring ofrece funcionalidades para el manejo de formularios. Se realiza a través de un objeto, llamado Command Object, que es el bean que servirá para almacenar la información recogida en el formulario. Este objeto debe tener tantos atributos (con getters y setters) como campos tenga el formulario.
		- Para envíar un objeto al formulario se utiliza @GetMapping y se añade al modelo un Command Object con los datos que queramos enviar al formulario. En el formulario se toma el Command Object del contexto y se asocia cada uno de sus atributos al campo correspondiente del formulario. Para procesar los datos se utiliza @PostMapping, se recoge el objeto enviado desde el formulario con los datos y lo redirigimos al controlador pertinente.
		- Para la validación de los formularios, Spring permite usar el estándar JSR-303/JSR-380 Bean ValidationAPI. Spring Boot configura por defecto la implementación de este estándar. Mediante las anotaciones de validación indicamos las restricciones de los campos. Algunos son @NotNull, @Min, @Max, @NotEmpty,etc. Los mensajes de validación por defecto se pueden cambiar, ya sea indicándolo en la anotación o a través de los ficheros de properties.  
		- Indicando que el formulario es multipart (< form enctype="multipart/form-data" >) podremos enviar los datos del formulario y datos binarios, a la vez. Después, en el @PostMapping del formulario, podremos acceder al input file mediante @RequestParam("nombre del campo"). Mediante la clase FileSystemStorageService podremos almacenar estos archivos en nuestro sistemas de archivos. Esta clase dispone de los metodos load, loadAsResource, init y deleteAll para manejar el sistema de archivos, aunque los archivos también pueden almacenarse en la nube o en sitios especializados para el tipo de archivo en cuestión.
		
	- Spring Security dota a las aplicaciones JavaEE de seguridad, su integración mediante SpringBoot es muy sencilla con spring-boot-starter-security en el POM.XML (o en la creación del proyecto). Ese servicio de seguridad consta de dos procesos, el de autenticación (¿Quién eres?), y el de autorización (¿Para qué tienes permiso?).
		- Añadiendo el paquete seguridad, creando una clase de configuración de seguridad que extienda de WebSecurityConfigurerAdapter, anotada con @EnableWebSecurity. Después creando la configuración del método de autenticación a través de un objeto de la calse AuthenticationManagerBuilder para indicar los usuarios autorizados. Solo con eso ya se pide la autenticación para todas las url, se crea el formulario de login, se permite el inicio de acceso con el usuario y contraseña indicados, se permie hacer logout, se evitan ataques CSRF y se proporciona la intecración con los métodos del API Servlet (HttpServletRequest). Además la clase de configutración registra un filtro de Servlet llamado pringSecurityFilterChain, que garantiza la protección de las URLs redirigiendo al login a los usuarios no autenticados.
		- Faltaría por configurar la autorización, a través de un objeto de la clase HttpSecurity, el login, el logout para adaptarlos a nuestro gusto y cambiar las autorizaciones que no queramos que sean tan restrictivas como lo son por defecto.

	- HTTPSESSION:
		- Es una Interfaz que ofrece Java EE
		- Es un Map en el que se almacenan pares clave - objeto.
		- Cuando creamos una sesión, se envía una  cookie, que el navegador mantiene y reenvía en todas las peticiones siguientes (JSESSIONID).
		- La sesión es individual: cada usuario tiene la suya; los datos no se comparten entre sesiones. 
		- Spring Security la usa cuando nos logueamos. Así nos permite navegar entre páginas que requieren autenticación sin volver a loguearnos.
		- Podemos @Autowired el objeto HttpSession en cualquier controlador, y pasarlo como argumento de cualquier método en un controlador.
		- Depende de la implementación del servidor sobre el que se despliega la aplicación
		- Presenta problemas de escalabilidad

	- SPRINGSESSION:
		- Integración transparente con HttpSession.
		- Independencia de la implementación del servidor de aplicaciones.
		- Sesiones en cluster.
		- Múltiples sesiones en un solo navegador.
		- Uso en APIs RESTful
		- Spring Session 2.0 además, tiene entre otros el módulo Redis para el almacenamiento de sesiones.
		- Para integrarlo en nuestro proyecto hay que instalar redis (vía docker), actualizar el pom.xml parsa añadir las dependencias y la configuración en application.properties (spring.session.store-type=redis), el resto lo hace Spring Boot automáticamente. Pueden configurarse otros aspectos como la duración de una sesión, el modo de volcado de datos, el puerto del servidor Redis, etc.

3. Spring Data JPA

	- La mayoría de las aplicaciones necesitan que la  información sea persistente, es decir, que esta sobreviva más allá de una sesión o de un tiempo determinado, para ello la solución está en el uso de bases de datos.
	- En Spring puede usarse directamente JDBC, directamente Hibernate, JPA sobre Hibernate o se puede usar Spring Data.
	- SPRING DATA JPA ofrece un modelo consistente de programación para acceder a datos y, además, facilita el uso de bases de datos relacionales y NoSQL.
	- En Spring data, las entidades serán clases Java anotadas con @Entity, deberán tener una clave primaria anotada con @Id sobre esta propiedad o sobre su getter. @Entity se mapea con una tabla que se llame igual que la clase, con un @Table adicional, se puede cambiar el nombre. Lo mismo ocurre para los atributos, pudiéndose cabiar el nombrecon @Column. Además @Column permite definir propiedades como Nullable, Name, Insertable, Updatable o Length.
	- Para el uso de claves primarias es habitual usar campos artificiales con el nombre id y de tipo long. JPA lo puede generar automáticamente si lo indicamos con @GeneteratedValue. Con auto, hiberate escoge la estrategia para asignarlo, con sequence, se usa una secuencia, con identity se usa un campo autonumérico y con table se hace a partir du una tabla extra.
	- JPA permite el mapeo de valores asociados asociando dos entidad, para ello debemos indicar la multiplicidad @ManyToOne, @OneToMany, @ManyToMany o @OneToOne.
	- Spring Data JPA ofrece varios mecanismos para la realización de consultas sobre las bases de datos.
	
		- Las derivadas del nombre del método.
		- Las @Query (Consultas JPQL o nativas SQL)
		- Consultas con QueryDLS.
		- Consultas con Query By Examlple
		- etc.
		
	- Para las consultas derivadas del nombre del método definimos métodos ne nuestro repositorio de manera que: la consulta empiece por find, read, query, count o get + ... + By + ...; siendo este By el delimitador para definir los criterios. En el primer espacio podrían ir elementos limitadores de la consulta como First, Top (o Top + número), All, etc. En el segundo se añadirían los criterios utilizando los nombres de los atributos y elementos como Distinct, And, Or, Between, Like, In, OrderBy, etc.
	- Para las consultas JPQL o SQL la consulta se hará con @Query("consulta"). A esta consulta se le pueden pasar arguméntos con ?1, ?2, ... y parámetros con :nombre, :apellidos, ....
	- Para QueryDLS habrá que crear una interfaz que extienda de QuerydlsPredicateExecutor, en la que se encuentran métodos como findById, findAll, count, exist, etc.
	- QueryByExample se basa en búsqueda peoporcionando un ejemplo de lo quequeremos encontrar.
	
## Semana 4
### Curso de desarrollo de una API REST con Spring Boot

1. Introducción

	- REST es un nuevo enfoque de la arquitectura de aplicaciones empresariales. Se basa en el protocolo HTTP, sin estados,
los recursos son representados por URIs, su interfaz es uniforme y utiliza un sisema de capas.
Ofrece como ventajas la separación de cliente - servidor, es más visible, fiable y escalable, soporta variedad de formatos: JSON,XML,...; en general, es más rápido y utiliza menos ancho de banda.

	- Con Lonbok, haciendo uso de las anotaciones @Seter, @Getter, @RequiredArgsConstructor, @ToString, etc; evitaremos tener que generar getters, setters, constructoes, equals, etc.

	- En Spring Boot se utilizará @RestController para los controladores orientados a REST. Es una combinación de @Controller y @ResponseBody. Al incluir la dependencia starter web, se incluyen algunos conversores poe defecto para entregar al cliente el contenido en un formato determinado: StringHttpMessageConverter, que convierte a cadenas de caracteres, y 
MappingJackson[2] HttpMessageConverter: convierte a JSON usando Jackson. Además se usarán las clases HttpEntity < T> (que representa una petición o respuesta HTTP), RequestEntity < T>, ResponseEntity < T>, MediaType y HttpHeaders.

2. Primer servicio REST con Spring Boot

	- Anotaciones para el mapero de rutas a operaciones CRUD: @GetMapping, @PostMapping, @PutMapping, @DeleteMapping.
	- @RequestBody permite inyectar el cuerpo de la petición en un objeto, @PathVariable permite inyectar un fragmento de la URI en una variable
	- Mediante la clase ResponseEntity indicaremos el código de respuesta, de modo que en un Get devolveremos el código 200 ok si se encuentra el recurso y 404 Not Found si no, en el POST el 201 Created, etc.
	- El patrón DTO: Data Transfer Object; es un objeto POJO que agrupa datos de la capa de negocio, y es recomendable usarlos en lugar de usar las entidades tal cual fuera de la capa de lógica de negocio. Pueden tener parte de los datos de una sola entidad, algunos datos de más de una entidad o incluso todos los datos de varias entidades. Está pensado para aligerar las transacciones entre cliente y servidor. Con ModelMapper se facilita la creación de DTO mediante asignación dinámica, tendremos que añadirlo a las dependencias y crear un bean del tipo ModelMapper para la aplicación; la transformación a DTO puede hacerse explicitamente en el controlador, o creando un componente independiente para inyectar donde haga falta.

3. Manejo de errores y excepciones

	- @ResponseStatus nos permite indicar código de estado y un texto de respuesta para nuestras propias excepciones.
	- El mensaje de error por defecto de Spring (DefaultErrorAttributes) contiene la fecha, el estado (código), el nombre del error, el mensaje y la ruta en la que se ha producido. Es posible que queramos modificarlo y hacer nuestro propio mensaje de error. Se hará un modelo de este mensaje en una clase POJO qe deberá incluir los campos que estimemos necesarios.
	- @ExceptionHandler es una anotación que nos permite unificar excepciones y personalizar los mensajes. La anotación puede ubicarse en un método de cualquier controlador y manejará las excepciones del tipo indicado que se produzcan en dicho controlador. Puede recibir como argumento una instancia de una excepción, objetos Request, Response, objetos de sesión, Locale,etc. Como retorno, puede devolver void, String, @ResponseBody, HttpEntity, ResponseEntity, o un Model, ModelAndView o Map (motor de plantillas).

	- @ControllerAdvice es una expecialización de @Component para clases que declaran los métodos @ExceptionHandler, @InitBinder o @ModelAttribure para ser compartidos entr múltiples clases de @Controlles. 
		- @RestControllerAdvice unifica @ControllerAdvice y @ResponseBody. 
		- Para manejar una excepción, se escogerá el primer método dentro de la clase @ControllerAdvice que esté anotado para tratar la excepción con @ExceptionHandler. 
		- Puede haber más de una clase anotada con @ControllerAdvice, en cuyo caso, puede ser recomendable el use de @Order o @Priority para establecer una preferencia en el tratamiento de errores. 
		- En caso de varias opciones para una excepción dentro de una clase, escogerá la más cercana a la raíz.
		- Si no se indica lo contrario, la anotación hace que la clase trate posibles excepciones en cualquier controlador. Podemos acotar el radio de acción especificando el package, las clases, anotaciones, etc.
		- Las clases anotadas como @ControllerAdvice pueden extender ResponseEntityExceptionHandler, que proporciona una lista de métodos que podemos sobreescribir como handleExceptionInternal, handleMissingPathVariable, handleTypeMismatch... además de poder añadir nuestros propios métodos. Si se sobreescribe handleExceptionInternal, el resto de errores manejados por la clase base ResponseEntityExceptionHandler utilizarán nuestra clase de error.
		
	- ResponseStatusException, disponible desde Spring 5, se trata como cualquier otra excepción y nos permite indicar el estado (HttpStatus - obligatorio), la razón (String - opcional) y la causa (Throwable - opcional). Permite el manejo de errores con poco esfuerzo, es un tipo de excepción que puede llevar asociados distintos códigos de estado en distintos lugares, no requiere tantas clases de excepción personalizadas, permite un mayor control en el manjo de las excepciones... pero por contra se pierde la globalidad ganada con @ControllerAdvice, habrá duplicación de código y el modelo de error será el estándar, así que si se quiere modificar, habrá que hacerlo creando un @Component que esxtienda a DefaultErrorAtrributes y sobreescribir el método getErrorAttributes.

4. Manejo de CORS
	
	- Por razones de seguridad, los navegadores prohíben las llamadas AJAX a reursos que residen fuera del origen actual. CORS es una especificación del W3C implementada por casi todos los navegadores que permite especificar que dominios estarán autorizados y para qué.
	- Consiste en un mecanismo que utiliza cabeceras HTTP adicionales para permitir a un cliente accefer a recursos desde un origen diferente al servidor actual.
	- En Spring pueden configurarse mediente @CrossOrigin
	
		- Disponible desde Spring 4.2
		- A nivel de método o de clase (controlador).
		- Atributos como origins, methods, maxAge, allowCredentials(true), allowedHeaders, exposedHeaders, etc.
	
5. Subida de ficheros

	- Cuando Spring procesa una petición multiparte nos permite acceder a ésta o éstas a través de @RequestParam. La clase MultipartFile, tiene los métodos convenientes para procesar el fichero.
		- La interfaz StorageService tiene los métodos que debería proporcionarnos un servicio de almacenamiento de ficheros.
		- La clase FileSystemStorageServide sirve para el almacenamiento en nuestro sistema de archivos, y dispone de los métodos: store, load, loadAsResource...
		- Las clases de error StorageException y StorageFileNotFoundException.
		- La clase Application para la inicialización
		- En controlador, el método serveFile.
		
	- Uso de @RequestParam vs @RequestPart
		
		- @RequestParam asocia un parámetro de la petición a un argumento de un método de un controlador, puede usarse en peticiones multiparte y es válido para anotar MultipartFile, pero si no es de tipo String o MultipartFile necesita un Converter registrado.
		- @RequestPart asocia una parte de una petición multiparte a un argumento de un método de un controlador, es análogo a @RequestBody, puede usarse con un MultipartFile o cualquier tipo de dato que tenga asociado un HttpMessageConverter.
		- Es probable que @Request`Param se usa con campos de formulario clave-valor, mientras que @RequestPart se use con partes con contenido más complejo: JSON, XML...
		 

6. Documentando nuestra API REST

	- Una API que no está documentada posiblemente será difícil de utilizar. No todo el mundo entiende lo mismo por REST y en ocasiones, se implementan reglas de validación que nos obligan a utilizar tipos de datos concretos.
	- La documentación se puede crear con Spring REST Docs o con Swagger + SwaggerUI.
	- Spring Rest Docs combina la documentación escrita a mano con Asciidactor y fragmentos autogenerados producidos con Spring MVC Test. Está dentro del paraguas de Sptring, pero nos obliga a escribir los test y tenerlos actualizados.
	- Swagger es un framework de código abierto que ayuda a los desarrolladores a diseñar, construir, documentary  construir servicios web RESTful. Para nosotros, Swagger son una serie de reglas, especificaciones y herramientas que nos ayudar a documentar nuestras APIs.
	- Swagger utiliza un json que incluye toda la documentación de nuestra API, además, Swagger UI es capaz de transformar ese JSON y hacerlo interactivo, lo que nos permite probar las peticiones, incluso con nuestros propios datos.
	- SpringFox es un conjunto de librerías que nos permite generar automáticamente la documentaciópn de nuestra API. Es capaz de generar esta documentación en formato Swagger, de este modo, no tenemos que generar manualmente el ficher swagger.json y dispondremos de clases y anotaciones para afinar la configuración.
	
		- Habrá que añadir las dependencias al pom.xml.
		- Anotación @EnableSwagger2 en una clase @Configuration.
		- Necesitamos un bean de tipo Docket que incluya la configuración para generar la documentación.
		- Podemos personalizar (a través de anotaciones y programáticamente) el resultado de la documentación.
		- Podemos incluir una ApiInfo acorde a nuestro proyecto.
		- Disponemos de algunas anotaciones que nos permiten personalizar determinados aspectos:
	
			+ A nivel de método de controlador: @ApiOperation, @ApiResponse/s @ApiParam.
			+ A nivel de objetos POJO: @ApiModelProperty, que nos permite personalizar la información de cada propiedad del modelo: nombre, tipo de dato, valor de ejemplo, posicón.

## Semana 5
### Curso de elementos avanzados en tu API REST con Spring Boot

1. Algunas mejoras para nuestra API
	
	- Paginación de resultados
	
		- Por eficacia y para mejorar la experiencia de usuario, cuando el número de resultados de una consulta es grande, es necesario dividirlos.
		- Con Spring Data JPA los repositorios permiten realizar consultas paginadas, con JpaRepository. Existe el método Page< T> findAll(Pageable pageable), y todas las consultas pueden ser del tipo Page< T> findByAlgo(Algo algo, Pageable pageable).
		- Pageable es un elemento de entrada en una consulta paginada. Una interfaz con la información necesaria para extraer una página de resultados, que además dispone de métodos como getPageNumber(), getPageSize y getSort().
		- Page < T> es el resultado de una consulta paginada. Se trata de una sublista de una lista de objetos que además tiene información sobre la posición de ésta en la lista completa. Tiene métodos como getContent(), getTotalPages(), getTotalElements(), getNumber(), getSize() y getNumberOfElements().
		- La paginación debe ser soportada por la capa de persistencia subyacente. Las clase Page y Pageable pertenecen a Spring Data, no a Spring Web. Spring Boot configura automáticamente el soporte web Spring Data Web Support, lo que nos permite usar Pageable en un controlador.
		
	- Manejo de parámetros en el Query
	
		- Con la anotación @RequestParam posdemos recoger cualquier parámetro del controlador, puede darse un valor por defecto y puede indicarse si estos parámetros son obligatorios u opcionales. Habrá que ajustar el método en el controlador, servicio, repositorio y hacer algún añadido en el manejo de errores.
		- Con Specification podemos crear predicados reutilizables para utilizar con Criteria Query que pueden ser todo los complejos que necesitemos. JpaSpecificationExecutor: Un repostrio que además de CrudRepository extienda a JpaSpecificationExecutor podrá ejecutar consultas con un Specification.
	
	- Soporte para XML
		
		- Un API REST debe definirse en base a recursos, pero éstos, pueden tener diferentes formatos en su representación (JSON, XML,...). Mediante encabezados puede indicarse el formato que se envía o se recibe (Content-Type y Accept). Spring Boot al detectar Jackson 2 en el classpath, formatea por defecto a JSON, por tanto si intentamos utilizar otro formato sin más, obtendremos un error 406 (Not Acceptable). Para XML habrá que añadir las dependencias de Jackson XML.
	
2. Modelos de datos más complejos
	
	- Ajuste de clases con JSONView
	
		- Jackson 2 + Spring nos proporcionan un mecanismo para seleccionar qué campos de un objeto serán transformados a JSON, lo que permite tener para un solo objeto Java diferentes representaciones JSON, esto puede usarse tanto en entidades como en DTO.
		- Definimos una clase que tendrá dentro varias interfaces. Estas interfaces serán las diferentes vistas para la clase o entidad. además, algunas de estas interfaces pueden heredar unas de otras. 
		- En el modelo se usará @JsonView sobre los diferentes atributos, definiendo para cada uno, en qué vista o vistas lo vamos a querer obtener. Los atributos que no tengan ningún JsonView asociado se obtendrán siempre.
		- A nivel de método se anota con @JsonView con la vista que queremos obtener.
		- Tambien se añade en application.properties: spring.jackson.mapper.default-view-inclusion=true
		- Es recomendable usarlo cuando tenemos distintos métodos que devuelvan distintas vistas de una misma clase, o cuando en función del ROL del usuario que hace la petición queremos devolver más o menos campos.
	
	- No es lo mismo crear un controlador para una entidad sin asociaciones que para una entidad asociada con otras. Si la entidad tiene asociaciones, debemos considerar qué hacer al respecto, ya sea al listar, al crear, al editar...
	
		- Asociaciones many-to-one
		
			- En el GET de Todos, seguramente no se requieran todos los atributos y sea mejor usar un DTO.
			- En el GET de Uno (por ID), segytamente se busque una representación más completa, por lo que se usará otro DTO diferente, analizando qué atributos son necesarios (que tal vez no sean todos).
			- En el POST, dependerá mucho del tipo de atributos, si existen datos derivados (que dependen de más de un campo), etc. Lo habiual es que para una entidad con varias asociaciones se necesite otro DTO diferente.
			- En el PUT, generalmente servirá el mismo DTO que el del POST, pero si algunos atributos no son modificables, o lo son pero de una forma "especial", es posible que haga falta un nuevo DTO.	
			- En el DELETE no suele hacer falta la representación, basta con el ID, pues no se suele devolver contenido. En caso de querer devolver el elemento eliminado se usaría el DTO del GET por ID.
			
		- Asociaciones one-to-many
	
			- Suele ser complementaria a la asociación de muchos a uno. Los expertos en JPA/Hibernate no recomiendan implementar asociaciones uno a muchos unidireccionales, ya que provocan mal rendimiento, se recomienda por tanto un tratamiento bidireccional. Para que esta bidirecionalidad no provoque errores al usar lombok. Usando a nivle de entidad las anotaciones @OneToMany(...) y @ManyToOne con @JoinColumn(...).A nivel de JSON las anotaciones JsonManagedReference para el enlace padre o reenvío y JsonBackReference para el enlace hijo.
			- En el GET Todos, la mejor solución será crear un DTO con dos niveles, uno para la parte padre y otro para la hija.
			- En el GET por ID seguramente no haga falta devolver atributos que hagan relación a otras asociaciones, se podría usar DTO en la parte hija de la relación o también @JsonView.
			- En el POST lo mejor es crear un DTO que tenga los datos de las dos partes.
			- En el PUT es posible que sea necesario un nuevo DTO, pero tal vez se pueda usar el mismo que para el POST
			- Para el DELETE posiblemente necesitemos un borrado en cascada (si se elimina por ejemplo una categoría, habría que eliminar los elementos que tienen esa categoría), generalemene no necesita reprsentación, igual que en las many-to-one.

		- Asociaciones many to many
	 		- Lo mejor es la bidireccionalidad y proceder igual que en el caso anterior.
	 
3. HATEOAS y Spring data REST test

	- Principios HATEOAS y HAL
	
		- HATEOAS: Hypermedia as the engine of application state → Hipermedia como el motor del estado de la aplicación. Dado un punto de entrada genérico de la aplicación podemos ser capaces de descubrir recursos. La información devuelta por el servidor siempre incluye hipervínculos. 
		- HAL:  Hypertext Application Language. Estándar para definir hipermedia como enlaces a recursos externos dentro de código XML o JSON.
		- Proyecto SpringHATEOAS: facilita la creación de representaciones REST que siguen el principio HATEOAS. Se centra en la creación de enlaces y el ensamblaje de representación.
		- SpringHAL Browser/Explorer nos proporciona una aplicación web para cruzar nuestra API REST y forma parte de Spring Data REST.
		- Spring Data REST es la suma de Spring Data + Spring HATEOAS + HAL. Permite exponer, de forma muy sencilla, repositorios de Spring Data como si fuera un API Rest que sigue los principios HATEOAS y en formato HAL.
	
	- Spring Data REST
	
		- Spring Data REST es parte del proyecto general Spring Data y facilita la creación de servicios web REST basados en hipermedios sobre los repositorios de Spring Data. Se basa en los repositorios de Spring Data, analiza el modelo de dominio de nuestra aplicación y expone los recursos HTTP controlados por hipermedia (HATEOAS).

			- Expone una API REST reconocible (discoverable) para nuestro modelo de dominio utilizando HAL.
			- Expone recursos de tipo item, colección y asociación que representan a nuestro modelo.
			- Soporta paginación a través de links navegacionales.
			- Soporte para filtrado de colecciones.
			- Expone mecanismos de búsqueda para métodos de consulta definidos en nuestros repositorios.
			-  Podemos engancharnos (hook) en el manejo de peticiones REST y
otros eventos a través del manejo de ApplicationEvents de Spring.
			- Expone metadatos sobre el modelo como un esquema JSON o ALPS
			- Permite definir representaciones específicas del modelo a través de proyecciones.
			- Envía una variante personalizada del HAL browser para aprovechar los metadatos expuestos.
			- Permite personalizaciones avanzadas de los recursos predeterminados expuestos.
			- Actualmente (versión 3.2.0) soporta JPA, MongoDB, Neo4j, Solr, Cassandra y Gemfire.

	- Configuración
	
		- En la cración de un nuevo proyecto Spring Starter Project se deben incluir además de las dependencias usuales (Web, Data Jpa, H2, Lombok), Rest Repositories y Rest Repositories HAL Browser.

		-Spring Data REST nos permite customizar o configurar algunos aspectos como la URI base, la estrategia de detección de repositorios, los parámeros de paginación, el formato de salida...

	- Paginación y búsqueda
	
		- En lugar de devolver un gran conjunto de resultados, Spring Data REST reconoce algunos parámetros de URL que influyen en el tamaño de la página y el número de la página de inicio. Si nuestro repositorio extiende a PagingAndSortingRepository<T, ID> (o a JpaRepository<T, ID>, que a su vez extiende al anterior), y accedemos a la lista de todas las entidades, obtendremos las 20 primeras. Podemos modificar el tamaño o cambiar el número de página con los parámetros page y size en la URL.
		- Spring Data REST también es capaz de exponer nuestras consultas en el repositorio como endpoints. Estas, además, también puede ser paginadas.
		- Las búsquedas paginadas suelen producir varios enlaces para navegar a las demás páginas. El tipo o número de enlaces dependen del tamaño y página y la página actual.
		- Spring Data REST reconoce los parámetros de ordenación utilizados por los repositorios subyacentes. Para ordenar sus resultados en una propiedad en particular, agregamos el parámetro sort a la URL con el nombre de la propiedad sobre la que deseamos ordenar los resultados. Se puede controlar la dirección de la ordenación agregando una coma (,) al nombre de la propiedad más 'asc' o 'desc'. 

	- Proyecciones
	
		- Por defecto, Spring Data REST exporta los objetos de dominio tal cual están definidos. Los datos primitivos, se exportan tal cual. Para los datos que asocian con otro modelo, si hay un repositorio exportado, como una URI (también objeto anidado embedded); si no hay repositorio exportado, como un objeto anidado. 
		- Nos puede interesar tener algunos endpoints en los cuales los datos que se obtengan del objeto no sean todos, sino solamente unos pocos.
		- Las proyecciones con Spring Data Rest se definen a través de una interfaz, con @Projection se indica el nombre de la proyección y la clase sobre la que se define. Con un método getter por cada dato que queremos exportar.
		 ```
		 	@Projection(name = "ciudadSinUbicacion", types = { Ciudad.class })
			public interface CiudadProj {
			String getNombre();
			}

	- Excerpts: Composición de modelos
		-Se trata de una proyección que queremos usar en lugar del modelo habitual. Se aplica automáticamente a un recurso de tipo colección. Suele ser habitual obtener estructura de objetos diferentes cuando obtenemos un listado de una entidad, y cuando obtenemos una sola instancia de la entidad (en el listado, normalmente, no obtenemos tantos datos).

		- La anotación @RepositoryRestResource incluye la propiedad excerptProjection, que nos permite indicar una proyección para usar como excerpt de este repositorio.

		- Si nuestra clase modelo incluye asociaciones, es posible que en la proyección que vamos a usar en los recursos de tipo colección necesitemos algunos de los datos asociados. Es posible componer un objeto con los datos asociados para que la respuesta que obtenga el cliente sea algo más completa.
		
4. Elementos orientados a producción

	- Añadir una base de datos real: Postgresql
		
		- Postgresql es un sistema gestor de base de datos gratuíta, opensource, multiplataforma, con alta concurrencia y ofrecido gratuitamente en plataformas como heroku.
		- Docker es un contenedor de aplicaciones. Éstos son entornos ligeros de tiempo de ejecución que proporcionan a las aplicaciones los archivos, las variables y las bibliotecas que necesitan para ejecutarse, maximizando de esta forma su portabilidad.

		- Para conectar la API REST con Postgresql se debe añadir la dependencia en el pom.xml y añadir las properties necesarias para definir los parámetros del Datasource.

	- Creación de un nuevo perfil de configuración
		- Los perfiles de Spring permiten un mecanismo para para separar determinadas partes en la configuración de un proyecto. Podemos hacer que cada una de esas partes esté disponible en un determinado entorno.
		- @Profile, Anotación que puede acompañar a @Component y sus derivados, @Configuration o @ConfigurationProperties. A través de ella indicamos el perfil o perfiles en los cuales tendremos a nuestra disposición dicho componente.
		- La propiedad spring.profiles.active nos permite indicar el perfil (o perfiles) activos.Se puede especificar de diferentes formas.

			- En application.propperties.
			- A través del pom.xml
			- A través de un parámetro de la JVM
			- A través de una variable de entorno (según el sistema operativo)
			
		- Dejaremos las propiedades comunes en application.properties y crearemos un nuevo fichero por perfil. El nombre será application-{profile}.properties.

	- Monitorización con Actuador
		
		- Spring Boot Actuator es una librería que proporciona herramientas de monitorización y
administración. Se acceden a ellas a través de endpoints REST, JMX o una aplicación web. Con Spring Boot 2.X hay un gran rediseño de los actuators que ya se venían utilizando en la versión 1.x
		- Por defecto, se habilitan solamente dos actuators. Podemos activar el resto de actuators con la propiedad management.endpoints.web.exposure.include=*
		- Health defecto solamente nos indica si está UP o no. Podemos ver más info si establecemos la propiedad management.endpoint.health.show-details=always.
		- Spring Boot Admin es un proyecto no oficial. Proporciona una interfaz gráfica desarrollada en Angular.js para monitorizar aplicaciones Spring-Boot aprovechando la información proporcionada por los endpoints de spring-boot-actuator. Está inspirado en microservicios

	- Heroku
		- Heroku proporciona un mayor nivel de abstracción sobre las instancias de la nube (Amazon EC2).
		- Se ocupan de todos los aspectos de su "plataforma" (de ahí PaaS).
		- Despliega una aplicación empujando commits a un repositorio git en heroku.
		- Capa gratuíta para aplicaciones de diversos tipos (Java, Javascript, Python) y bases de datos (Postgresql, ...)

