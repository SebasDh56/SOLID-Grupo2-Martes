-------Reflexión sobre el Principio SOLID aplicado (SRP)---------------------------------

En este ejercicio se aplicó el principio de responsabilidad única (SRP), uno de los cinco principios SOLID. Este principio establece que una clase debe tener una sola razón para cambiar, es decir, debe encargarse únicamente de una responsabilidad dentro del sistema.

En el código original, la clase UserManager realizaba varias tareas a la vez: validaba, guardaba datos y enviaba notificaciones. Esto generaba acoplamiento innecesario y dificultaba la mantenibilidad.

Tras la refactorización, se separaron las responsabilidades en cuatro clases especializadas:

UserValidator: valida email y contraseña.

UserRepository: gestiona la persistencia del usuario.

NotificationService: envía notificaciones.

UserManager: coordina el proceso sin asumir funciones adicionales.

Esta separación permite que cada clase evolucione de forma independiente. Si cambia el modo de validar, guardar o notificar, solo debe modificarse la clase correspondiente, sin afectar al resto. Esto mejora la claridad del código, facilita pruebas unitarias y reduce el acoplamiento, logrando un diseño más limpio y sostenible a largo plazo.

-----------Reflexión sobre el Principio SOLID aplicado (OCP)-------------------------------

En este ejercicio se aplicó el Principio Abierto/Cerrado (Open/Closed Principle), uno de los pilares del conjunto SOLID. Este principio establece que las clases deben estar abiertas para extensión pero cerradas para modificación. Es decir, el diseño debe permitir agregar nuevas funcionalidades sin alterar el código existente.

El código original utilizaba múltiples condicionales dentro de NotificationService para verificar el tipo de notificación, lo que generaba varios problemas:

Cada nuevo tipo de notificación requería modificar la clase.

Aumentaba el acoplamiento y la probabilidad de introducir errores.

Violaba directamente el OCP al necesitar cambios constantes.

Tras la refactorización, se definió una interfaz Notification con un método send, y se crearon implementaciones independientes para cada tipo de notificación: EmailNotification, SMSNotification y PushNotification. Gracias al uso de polimorfismo, NotificationService ya no depende de condicionales ni necesita modificarse cuando se agregan nuevas notificaciones.

Este enfoque permite que el sistema crezca de forma ordenada y segura: agregar un nuevo canal de notificación implica únicamente crear una nueva clase que implemente la interfaz, sin cambiar el código ya probado. Esto mejora la mantenibilidad, reduce el riesgo de errores y hace que el diseño sea flexible ante futuros cambios.

En conclusión, aplicar el principio OCP ayuda a construir software extensible, robusto y preparado para evolucionar, evitando que los módulos centrales se vean afectados por nuevas necesidades. Este ejercicio demuestra cómo una estructura basada en interfaces y polimorfismo facilita el cumplimiento de este principio.

--------------------Reflexión sobre el Principio SOLID aplicado (LSP)-----------------------------------

En este ejercicio se aplicó el Principio de Sustitución de Liskov (LSP), el cual establece que los objetos de una subclase deben poder reemplazar a los de su clase base sin alterar el correcto funcionamiento del programa. Esto implica que las subclases deben respetar completamente el contrato definido por la clase padre o la interfaz que implementan.

En el código original, la clase Fish heredaba de Animal, que incluía un método walk(). Sin embargo, al no poder caminar, Fish sobrescribía el método lanzando una excepción. Esto generaba un comportamiento inesperado: un Fish, siendo un tipo de Animal, no podía ser utilizado de manera segura donde se esperaba un Animal con capacidad de caminar. Esta situación representa una violación directa al LSP, ya que la subclase no podía cumplir las promesas de su clase base.

Para resolver este problema, se rediseñó la jerarquía dividiendo correctamente los comportamientos. Se creó una interfaz general Animal que contiene únicamente operaciones comunes a todos los animales, y una interfaz Walkable para aquellos que sí pueden caminar. Esto permite que solo las clases que realmente poseen esta habilidad implementen dicha interfaz, evitando sobrescrituras problemáticas o excepciones forzadas.

Con esta refactorización, cada subclase cumple adecuadamente el contrato de las interfaces que implementa, y cualquier objeto puede sustituirse sin generar errores ni comportamientos inesperados. Esto aumenta la coherencia del diseño, reduce el acoplamiento conceptual y asegura que el sistema sea más mantenible y extensible, respetando completamente el principio LSP.