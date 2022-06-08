# P1_ColaConPrioridad

Práctica donde trabajaremos con una cola con Prioridad donde no se puedan meter elementos repetidos

Crearemos un modelo de un proceso donde tengamos una id asignada, un nombre de proceso y un estado.
Ese estado puede ser PENDIENTE, PROCESANDO, TERMINADO.

Después, crearemos un repositorio con una cola donde metamos un proceso dependiendo de su prioridad. Cuanto menor número
de la prioridad tenga antes saldrá de la cola. Se añadirá por orden de llegada, pero al sacar un elemento solo se sacará si el nivel
de prioridad es el mínimo, en caso contrario, se buscará el siguiente elemento con mayor numero de prioridad (el siguiente que tenga menos prioridad).


