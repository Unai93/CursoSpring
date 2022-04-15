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
