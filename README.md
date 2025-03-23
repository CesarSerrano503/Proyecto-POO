# MultiWorks - Sistema de Gestión de Clientes, Empleados y Proyectos

Proyecto académico desarrollado en Java que permite registrar y gestionar clientes, empleados, proyectos, cotizaciones, asignaciones y subtareas. Incluye interfaz gráfica con Java Swing 

- Lenguaje: Java
- Entorno: IntelliJ IDEA
- Interfaz gráfica: Java Swing
- Estructura: Programación Orientada a Objetos (POO)
- Control de versiones: Git + GitHub

Cómo ejecutar el proyecto'

1. Clonar el repositorio:
   git clone [https://github.com/usuario/Proyecto-POO.git](https://github.com/CesarSerrano503/Proyecto-POO)

2. Abrir en IntelliJ IDEA

3. Ejecutar el archivo `Main.java` para la versión gráfica


Menú Principal

![image](https://github.com/user-attachments/assets/9de5d363-aa51-47a6-bf98-f12f2aaed021)

Pantalla principal del sistema, desde la cual se accede a todos los módulos: clientes, empleados, proyectos, cotizaciones, asignaciones y subtareas.

 Lista de Clientes
Interfaz que muestra todos los clientes registrados en el sistema. Desde aquí se puede acceder a la opción de registrar un nuevo cliente o volver al menú principal.

![image](https://github.com/user-attachments/assets/69ab72c7-c131-4986-a2b9-11e60f439c31)

Registro de Cliente
Formulario para registrar un nuevo cliente. Incluye campos para ingresar el nombre, DUI, tipo de persona, teléfono, correo y dirección.
Al hacer clic en Guardar, el sistema valida los datos y registra al cliente en la lista general.

![image](https://github.com/user-attachments/assets/2a99c586-8ed7-477b-9e15-d5ae47349947)


 Lista de Empleados
Interfaz que muestra todos los empleados registrados en el sistema. Se visualizan los campos clave: ID, Nombre, DUI, Tipo de Persona y Tipo de Contratación.
Incluye botones para registrar un nuevo empleado y volver al menú principal.

![image](https://github.com/user-attachments/assets/04d9b16f-c4c5-460e-af3b-3043b651b634)

Registro de Empleado
Formulario para ingresar un nuevo empleado al sistema. Incluye campos para nombre, DUI, tipo de persona, tipo de contratación, teléfono, correo y dirección.
El botón Guardar valida los datos y registra al empleado, quien luego aparecerá en la lista general.

![image](https://github.com/user-attachments/assets/c839f42e-b973-4537-8a7d-084d057e84d4)

 Lista de Proyectos
Pantalla que muestra todos los proyectos registrados en el sistema. Cada fila incluye: ID, Nombre del Proyecto, ID del Cliente asociado, Estado, Fecha de Inicio y Fecha de Fin.
Incluye botones para registrar un nuevo proyecto y volver al menú principal.

![image](https://github.com/user-attachments/assets/7f549d5f-f04a-4b73-98a4-932b00ae8967)

 Lista de Proyectos
Pantalla que muestra todos los proyectos registrados en el sistema. Cada fila incluye: ID, Nombre del Proyecto, ID del Cliente asociado, Estado, Fecha de Inicio y Fecha de Fin.
Incluye botones para registrar un nuevo proyecto y volver al menú principal.

![image](https://github.com/user-attachments/assets/3bed100e-efde-4502-8d28-bcd32cc8bdc8)


Registro de Proyecto
Formulario para crear un nuevo proyecto dentro del sistema. Permite ingresar:

![image](https://github.com/user-attachments/assets/896ba32d-b182-4ad8-8a72-18446cc325b8)

Lista de Cotizaciones
Ventana donde se muestra el listado de todas las cotizaciones registradas en el sistema.
Cada fila de la tabla presenta:

ID de Cotización

ID del Cliente asociado

Estado (Ej. "En proceso", "Finalizada")

Costo Total de la cotización

Fecha de Creación

En la parte inferior, el usuario puede:

Presionar Registrar nueva cotización para abrir el formulario correspondiente

Usar el botón Volver al menú para regresar al panel principal

![image](https://github.com/user-attachments/assets/80df4e22-0d34-4b91-ab33-278ecf6f8f97)

 Registrar Cotización: Esta pantalla permite registrar una nueva cotización para un cliente. 
 El formulario solicita el ID del cliente al que se asociará, el estado actual de la cotización (por ejemplo, "En proceso") y el costo total estimado. Una vez completado, el botón "Guardar" permite almacenar la cotización en el sistema.
 
![image](https://github.com/user-attachments/assets/55c6bd45-3790-4bca-a941-356f3c3b3cd6)

 Lista de Asignaciones: Esta pantalla muestra todas las asignaciones de actividades registradas en el sistema. Incluye columnas como ID, ID de cotización, ID de empleado, área asignada, costo por hora, fechas de inicio y fin, cantidad de 
 horas trabajadas, costo base, porcentaje extra y el total calculado. En la parte inferior, se encuentran los botones "Registrar nueva asignación" para agregar una nueva entrada y "Volver al menú" para regresar a la pantalla principal.
 
![image](https://github.com/user-attachments/assets/0b471649-fbf3-4f74-b6bf-bd1a041e59a2)


 Registrar Asignación: Esta pantalla permite ingresar una nueva asignación de actividad a 
 un empleado. El usuario debe completar campos como ID de cotización, ID de empleado, área asignada, costo por hora, fechas y horas de inicio y fin, cantidad de horas trabajadas, costo base, incremento extra (%) y finalmente el costo total.
 Este último se calcula automáticamente cuando se presiona el botón "Calcular y Guardar", que además guarda la información ingresada.
 
![image](https://github.com/user-attachments/assets/e11d4c58-1d60-4dd0-a3f6-add849f57007)


Lista de Subtareas: Esta pantalla muestra una tabla con todas las subtareas registradas en el sistema, incluyendo su ID, ID de asignación, título y descripción. Desde aquí, el usuario puede acceder al formulario para Registrar nueva subtarea o puede regresar al 
Menú principal utilizando el botón correspondiente.

![image](https://github.com/user-attachments/assets/9cb6dd95-49ed-441b-8da4-2db95c34236f)

Registrar Subtarea: En esta ventana, el usuario puede registrar una nueva subtarea ingresando el ID de Asignación correspondiente, el Título de la subtarea y una Descripción detallada. Al finalizar, puede hacer clic en el botón Guardar para almacenar la 
subtarea dentro del sistema.

![image](https://github.com/user-attachments/assets/395838c1-8cac-40d0-8306-6df72237e044)











**Autor**: César Serrano  
**Curso**: Programación Orientada a Objetos  
**Año**: 2025
