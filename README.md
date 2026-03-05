# RentCar
Plantilla inicial para la aplicación de alquiler de coches

Vamos a desarrollar una  aplicación de Renting para una pequeña empresa.
Nos hemos reunido con el cliente y hemos recogido estos requisitos:

• Los clientes pueden alquilar los coches en la oficina física.  
• Los clientes van a tener un id, dni, nombre y apellidos.  
• Los coches van a tener una matrícula además de un modelo. A cada modelo se
  le aplicará un precio por día distinto.  
• Los alquileres van a tener una fecha de inicio y una fecha de fin.
• Cada oficina tendrá una dirección y un cargo extra en caso de que la entrega no sea en la fecha indicada.

![image](uml.png)

Necesitamos un diagrama de casos de uso que cubra las funcionalidades mínimas para que los clientes puedan alquilar.

Además partimos de un desarrollo inicial que cubre todas las funcionalidades CRUD de la clase cliente.

¿Qué debéis hacer?
Siguiendo con la arquitectura propuesta, desarrollar todas las funcionalidades obtenidas en los casos de uso.
Para ello, debéis:
1. Desarrollar las clases necesarias para cumplir con los casos de uso.
2. Refactorizar el código si es necesario.
3. Repetir los pasos anteriores hasta completar todas las funcionalidades.  



''Qué hacer cuando al crear un nuevo objeto necesite de otro''

Ejemplo Coche:

    System.out.print("Matrícula: ");
    String plate = scanner.next();
    
    System.out.print("ID del Modelo: ");
    int modelId = scanner.nextInt();
    
    System.out.print("ID de la Oficina: ");
    int officeId = scanner.nextInt();'
    
    carController.add(plate, modelId, officeId);

En este caso, el coche necesita un modelo y una oficina. Para ello, lo que hacemos es pedir al usuario el id de cada uno de ellos. 
Luego le llega al controller, el controller se lo envía tal cual a service y es justamente service quien se encarga de buscar el modelo y la oficina correspondientes a esos ids y crear el coche con ellos.

Importante: CarService necesita usar el service de modelo y el service de oficina, por lo que es necesario inyectar ambos servicios en el service de coche.
Por último a CarRepository le llega el coche ya creado, con su modelo y su oficina, y lo guarda sin necesidad de preocuparse por nada más.


