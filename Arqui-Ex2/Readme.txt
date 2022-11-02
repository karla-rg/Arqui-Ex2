Patron de comportamiento command: Command es un patrón de diseño de comportamiento que convierte una solicitud en un objeto independiente que contiene toda la información sobre la solicitud.
Esta transformación permite parametrizar los métodos con diferentes solicitudes, retrasar o poner en cola la ejecución de una solicitud y soportar operaciones que no se pueden realizar.
BankOps es usada para generar los comandos que corresponden a las respectivas operaciones bancarias soportadas.
Estas implementan la interfaz BankOp con un solo metodo "execute()". Los comandos contienen una referencia a su "receiver" y la clase ClientInterface es considerada la clase "sender".

Patron creacional singleton: Singleton es un patrón de diseño creacional que permite asegurarnos de que una clase tenga una única instancia, a la vez que proporciona un punto de acceso global a dicha instancia.
La clase RepositorySingleton fue utilizada para definir los metodos que permiten agregar y actualizar los objetos de Account.

Patron estructural facade: Facade es un patrón de diseño estructural que proporciona una interfaz simplificada a una biblioteca, un framework o cualquier otro grupo complejo de clases.
Fue utilizado en la clase ClientInterface fungiendo como un menu para que el usuario pudiera hacer uso de las cuentas desde la clase RepositoryAccount, permitiendo de esta manera
la recopilacion de los parametros para la realizacion de las diferentes operaciones que son enviados a AdminAcc.
