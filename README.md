# Proyecto: Gestor de Navegación Intergaláctica (StarNav) #
Bienvenido, Cadete de Navegación

Enhorabuena.

Has sido seleccionado oficialmente para formar parte del Programa StarNav, el sistema encargado de coordinar la navegación, abastecimiento y estado operativo de la flota intergaláctica de la UNSA.

---

Tu misión no es menor:
vas a construir, desde cero, el núcleo lógico que permitirá registrar naves, localizar unidades activas y gestionar su combustible antes de que entren en rutas de exploración, convoy o combate.

No se espera que lo sepas todo.
Se espera que sigas el protocolo.
---
## Como buen cadete has de seguir las metodología de Entrenamiento ##

#### Este proyecto sigue estrictamente el enfoque TDD (Test-Driven Development): ####

- Primero escribes las pruebas
- Después escribes el código mínimo para que pasen
- Nada de improvisar
- Nada de atajos

Cada decisión que tomes debe estar respaldada por una prueba.
---
## Reglamento Oficial (SOLID y Buenas Prácticas)

Estas normas no son opcionales. Son protocolo estándar de la flota:

#### SRP – Responsabilidad Única

Cada clase cumple una única función.
No mezcles lógica de almacenamiento con lógica de presentación ni con reglas de negocio.

#### Prohibido Código Cableado (Hardcoded)

No se aceptan datos fijos en bucles ni suposiciones de tamaño.
Todo debe funcionar dinámicamente, usando el tamaño real de las estructuras de datos.

#### TDD Estricto

No se crean clases “porque sí”.
Cada clase nace porque una prueba de JUnit 5 la exige.
---
 ## Requisitos Tecnológicos a Implementar
 
#### Enumerado Estricto: TipoMision

Debes crear un enumerado que represente el nivel de peligro de una ruta.

Constructor privado
Propiedad privada nivelPeligro (int)
Getter público

Valores oficiales:

EXPLORACION → Peligro 1
CONVOY → Peligro 3
COMBATE → Peligro 5

Este enum define riesgo, no comportamiento.

#### Interfaz de Control: Gestionable

Define el contrato que debe cumplir cualquier sistema de gestión de naves.

Debe declarar exactamente estos métodos:

void agregar(Nave nave)
Optional<Nave> buscarPorId(String id)
boolean actualizarCombustible(String id, double nuevoCombustible)

Nada más.
Nada menos.

##### Entidad Central: Nave

Cada nave registrada en la flota debe contener:

id (String)
nombre (String)
combustible (double)
tipoMision (TipoMision)

## ⚠️ Regla crítica de identificación
Debes sobrescribir equals() y hashCode() para que dos naves sean iguales únicamente si comparten el mismo id.

No importa el nombre.
No importa el combustible.
El ID es la identidad.

#### Persistencia y Estructuras de Datos (CRUD)

Implementarás la interfaz Gestionable en una clase encargada de almacenar las naves (por ejemplo, FlotaEspacial).

Reglas obligatorias:

Usa un HashMap
Clave → id
Valor → objeto Nave
Justificación: búsquedas O(1)
Usa un ArrayList auxiliar si necesitas recorrer, listar o filtrar
Siempre con bucles no cableados
📖 Historias de Usuario
(Casos de Prueba en JUnit 5)

### Tu misión es crear un archivo/os de pruebas (por ejemplo FlotaTest.java) que garantice el cumplimiento de las historias de usuario:

#### Historia 1: Registro de Naves (Create)

Dado que la flota está vacía
Cuando agrego una nueva nave
Entonces el sistema debe guardarla correctamente

#### Historia 2: Búsqueda Segura (Read con Optional)

Dado que una nave existe
Cuando la busco por su ID
Entonces se devuelve un Optional presente

Y si no existe
Optional.isPresent() debe ser false

Nada de null.
El radar nunca falla.

#### Historia 3: Recarga de Energía (Update)

Dado que una nave está registrada
Cuando actualizo su combustible
Entonces:

El valor se actualiza
El método devuelve true

Si la nave no existe:

No se actualiza nada
El método devuelve false

## Salida Oficial Esperada en Consola

Cuando el sistema principal se ejecute, la consola debe mostrar exactamente esto:

=== INICIANDO SISTEMA STARNAV ===
[INFO] Registrando naves en la flota...

[OK] Nave 'Enterprise' registrada con éxito. 

[OK] Nave 'Milano' registrada con éxito. 

=== BUSCANDO NAVES (Uso de Optionals) ===
¿Existe la nave NX-01?: SÍ -> Nombre: Enterprise | Misión: EXPLORACION (Peligro: 1)

¿Existe la nave X-WING?: NO -> Nave no encontrada en el radar.

=== REPORTE DE ACTUALIZACIÓN (CRUD - Update) ===

[UPDATE] Actualizando combustible de la Milano...

¡Combustible actualizado con éxito a 95.5%!

=== LISTADO COMPLETO DE LA FLOTA (Loops No Cableados) ===

Nave 1: ID: NX-01 | Nombre: Enterprise | Combustible: 100.0L

Nave 2: ID: M-01 | Nombre: Milano | Combustible: 95.5L

=================================


## Si tu sistema cumple todo lo anterior:

Has aplicado SOLID
Has trabajado con TDD real
Has evitado hardcodeo
Has entendido Optionals, equals/hashCode y estructuras de datos

As Cumplido con tu primera asignación oficial como ingeniero de la flota.

Buena suerte, cadete.
StarNav confía en tu código. 