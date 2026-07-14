[README_plantilla_EFT.md](https://github.com/user-attachments/files/28673507/README_plantilla_EFT.md)

![Duoc UC](https://www.duoc.cl/wp-content/uploads/2022/09/logo-0.png)
# 🧠 Semana 8
**Actividad Sumativa 3: Interfaces e integración con colecciones genéricas**

## 👤 Autor del proyecto
- **Nombre completo:** [Ariel Gustavo Loncon Lefimil]
- **Sección:** [009A]
- **Carrera:** Desarrollo de aplicaciones
- **Sede:** [Online]

---

## 📘 Descripción general del sistema
Este proyecto consiste en el diseño e implementacion de un sistema de gestión administrativo, para la agencia de turismo "Llanquihue Tour", ubicada en la región de Los Lagos. El propósito principal de esta aplicación es automatizar la gestión de datos vinculados a la operación de la agencia, incluyendo guías turísticos, operadores locales y servicios turísticos. Todo esto contando con un sistema de una interfaz gráfica básica para facilitar la interacción por parte del personal administrativo.

---

## 🛠️ Actualización: Semana 8 - Integrando Interfaces, Polimorfismo y Estructuras Dinámicas
El objetivo de esta semana fue robustecer y flexibilizar la arquitectura del sistema mediante la incorporación de interfaces comunes, el uso de verificación de tipos dinámicos (`instanceof`) y el desarrollo de una interfaz gráfica de usuario (GUI) interactiva que simula la administración y persistencia de múltiples entidades en tiempo real.
### Componentes y Lógica Implementada:
* **Contrato Común (`Registrable`):** Se definió e implementó la interfaz `Registrable` en la capa de modelo. Esto permite que entidades completamente distintas (como `Guia`, `Tours`, `Operadores` y la superclase abstracta `ServicioTuristico`) unifiquen comportamientos esenciales:
    * `mostrarResumen()`: Salida estructurada de información clave por consola.
    * `getRowData()`: Mapeo polimórfico de atributos a un arreglo de `String[]` para poblar dinámicamente tablas en la interfaz gráfica.
* **Colección Heterogénea Global (`gestorEntidades`):** Se estructuró un motor de administración centralizado basado en una colección dinámica `ArrayList<Registrable>`. 
    * **Polimorfismo Puro:** El método `mostrarTodo()` recorre la lista invocando `.mostrarResumen()` de forma dinámica.
* **Interfaz Gráfica de Usuario (GUI Swing):** Se diseñó una experiencia visual de escritorio robusta en el paquete `ui`:
    * `PanelPrincipal`: Consola de control administrativa con un componente `JTable` que se actualiza en tiempo real según el filtro seleccionado de una listadesplegable(`JComboBox`).
    * `VentanaAgregar`: Formulario modal inteligente que utiliza un contenedor dinámico `CardLayout`. Renderiza exclusivamente los campos obligatorios del tipo de entidad que se desea registrar, aplicando control de excepciones para inputs inválidos.
* **Persistencia y Sincronización de Datos:** Se implementó comunicación de E/S de archivos planos (`.txt`) mediante `BufferedWriter` y `FileWriter` en modo append. El sistema lee el estado de la base de datos simulada al iniciar la aplicación (`GestorGlobal`) y añade nuevos registros de manera ordenada respetando la semántica de almacenamiento original.

---

## 🧱 Estructura general del proyecto
## Características Principales (POO) y Arquitectura
* **Encapsulamiento:** Todos los atributos de las clases del dominio son privados (`private`) y cuentan con métodos de acceso públicos (`getters` y `setters`).
* **Composición:** Implementación de relaciones lógicas donde una clase contiene a otra como atributo central (por ejemplo, los datos de una persona).
* **Sobrescritura de métodos (`@Override`):** Redefinición de firmas de métodos clave para que cada entidad responda con su propia semántica y formato, asegurando salidas limpias y legibles en consola y pantallas.
* **Validación de Datos:** Uso de clases especializadas (rut, email) para asegurar que solo información con formato válido ingrese al sistema.
* **Persistencia Completa de E/S (Entrada/Salida):** Sincronización bidireccional con archivos planos `.txt` en el directorio `resources/`. El sistema realiza la lectura inicial (`BufferedReader`) y añade nuevos registros (`BufferedWriter` en modo append) al confirmar operaciones en la GUI.
* **Herencia:** Extensión de clases base generales para representar de manera eficiente y jerárquica los datos específicos dentro del ecosistema de la agencia de Tours (como el nombre y cantidad de horas).
* **Polimorfismo:** Capacidad de enviar el mismo mensaje `mostrarInformacion()` a diferentes tipos de objetos y que cada uno responda de forma coherente a su naturaleza.
* **Sobrescritura de métodos (`@Override`):** Cada subclase proporciona una implementación específica que extiende o personaliza la lógica de la superclase.
* **Colecciones Genéricas:** Uso eficiente de `List` para almacenar y recorrer la jerarquía de servicios de manera dinámica.
**Abstracción:** Definición de la clase abstracta base `ServicioTuristico`, la cual actúa como plantilla conceptual para la jerarquía de servicios, impidiendo instanciaciones directas y obligando a definir implementaciones concretas en sus subclases.
* **Desacoplamiento mediante Interfaces:** Implementación de la interfaz `Registrable` como un contrato de comportamiento. Clases totalmente independientes en la jerarquía (como `Guia`, `Tours`, `Operadores` y la superclase `ServicioTuristico`) implementan esta interfaz, permitiendo tratarlas bajo una referencia común y unificada.
* **Arquitectura Multicapa (N-Tier):** Organización modular del código fuente en paquetes especializados (`model`, `data`, `ui`, `util`), garantizando un bajo acoplamiento, alta cohesión y facilitando el mantenimiento del software.

---

## 📋 Formato de los archivos de entrada
El sistema procesa archivos de texto (.txt) ubicados en la carpeta resources/. Cada línea debe respetar la siguiente estructura, utilizando punto y coma (;) como delimitador:
* tours.txt: id;nombre;tipo;produccion (ej: 1;City Tour;Cultural;15000)
* guias.txt: rut;nombre;email (ej: 12.345.678-9;Juan Perez;juan@email.cl)
* operadores.txt: nombre;area (ej: Transportes Sur;Logística)
* Nota: El sistema valida automáticamente el formato de los datos. Si una línea no cumple con el formato exigido, será descartada y se notificará el error en la consola.

---

## 🔍 Filtros y lógica aplicada
El sistema ha evolucionado de filtros estáticos en consola a un motor de búsqueda, segmentación y validación dinámico integrado directamente con la interfaz gráfica:
* **Filtrado Polimórfico Genérico (Java Streams & Reflection):** En lugar de filtros rígidos, la clase `GestorGlobal` implementa un método genérico parametrizado:
  `public <T> List<T> filtrarPorTipo(Class<T> clase)`
  Este método utiliza la API de **Streams de Java** junto con **Reflection** (`clase::isInstance` y `clase::cast`) para escanear la colección unificada de tipo `Registrable` y extraer en tiempo real solo los objetos que pertenecen a la categoría seleccionada en la GUI.
* **Segmentación Visual por Categorías (UI Dinámica):** A través del componente de selección de la interfaz (`JComboBox`), el usuario puede alternar entre las entidades del sistema (*Tours, Guías, Operadores, Ruta Gastronómica, Paseo Lacustre, Excursión Cultural*). Al seleccionar una categoría:
  * La tabla principal (`JTable`) reestructura dinámicamente sus columnas.
  * El sistema realiza un *downcasting* seguro para poblar las filas con los atributos exclusivos de la subclase correspondiente utilizando el contrato `getRowData()`.
* **Barrera de Validación de Integridad (Formularios GUI):**
  Antes de persistir cualquier nuevo registro en los archivos `.txt` de la carpeta `resources/`, la ventana interactiva `VentanaAgregar` actúa como un filtro de integridad física y lógica:
  * **Validación de Formatos Críticos:** Se integran las utilidades `rut` y `email` para impedir el ingreso de cadenas maliciosas o con formato incorrecto.
  * **Control de Excepciones (Try-Catch):** El sistema captura activamente excepciones de formato numérico (`NumberFormatException`) o campos vacíos (`IllegalArgumentException`), interrumpiendo el flujo de escritura y notificando al usuario de forma amigable mediante ventanas emergentes (`JOptionPane.showMessageDialog`), evitando así que los archivos planos se corrompan con datos corruptos

---

## 🚀 Instrucciones de ejecución
Para ejecutar correctamente la aplicación "LlanquihueTourApp", asegúrate de seguir estos pasos en tu entorno de desarrollo (IDE como IntelliJ IDEA, NetBeans, etc).
## Requisitos previos:
* Tener instalado Java JDK 8 o superior.
* Para las carpetas del directorio resources/ en la raíz del proyecto, con los archivos tours.txt, guias.txt y operadores.txt si llegan a no estar, el mismo codigo las creara, pero sin datos a mostrar.
## Compilación y ejecución:
* Ubica la clase Main.java dentro del paquete com.LlanquihueTourApp.ui.
* Compila el proyecto para asegurar que todas las dependencias del modelo y utilidades estén vinculadas.
* Ejecuta el método main de la clase Main.
## Interacción con el sistema:
* Una vez iniciado, el programa desplegará un entorno gráfico dinámico controlado por mouse y teclado:
* En la parte superior de la pantalla, selecciona la categoría que deseas consultar desde la lista desplegable (**ComboBox**) (Ej: *Tours*, *Guías*, *Ruta Gastronómica*, etc.).
* Haz clic en el botón **"Ver Registros"**. El sistema leerá dinámicamente el archivo plano correspondiente, filtrará los datos en memoria aplicando polimorfismo y los listará en la tabla central (**JTable**), adaptando las columnas de forma inteligente a cada entidad.
* **Agregar Nuevos Registros (Persistencia en Tiempo Real):**
  * Presiona el botón **"Agregar Nuevo"**. Se abrirá una ventana de diálogo emergente (`JDialog`).
  * Selecciona qué tipo de entidad deseas registrar en el ComboBox superior, el formulario cambiará de forma instantánea mostrando únicamente los campos correspondientes a esa clase.
  * Completa los campos y presiona **"Guardar"**. El sistema validará los formatos de entrada (incluyendo la estructura sintáctica de RUT y Email mediante las clases de utilidad), escribirá la nueva línea en el archivo `.txt` correspondiente mediante E/S de datos (`BufferedWriter`) y te notificará el éxito de la operación..
* **Eliminar Registros:**
  * Selecciona cualquier fila de la tabla de visualización.
  * Haz clic en **"Eliminar Registro"** para quitar el elemento de la base de datos simulada y actualizar la vista de forma inmediata.
* **Cierre Seguro:**
  * Al hacer clic en el botón **"Salir"** o cerrar la ventana, la aplicación detendrá la máquina virtual de Java (JVM) de forma segura, garantizando que todos los buffers de escritura hacia los archivos `.txt` hayan sido cerrados y guardados correctamente en el disco.
     
---

```plaintext

  📁 resources           #Carpeta que almacena los aerchivos de entrada
    ├── guias.txt
    ├── operadores.txt
    ├── tours.txt
    ├── Servicios.txt
  📁 src/com/LlanquihueTourApp/
    ├── data/             # Gestores de lectura y persistencia de archivos (Persistencia E/S)
    │   ├── GestorArchivo.java
    │   ├── GestorGuias.java
    │   ├── GestorOperadores.java
    │   └── GestorDatos.java
    │   └── GestorServicios.java
    │   └── gestorEntidades.java  <-- [NUEVO] Procesamiento polimórfico e instanceof
    ├── model/            # Entidades del dominio
    │   ├── Guia.java
    │   ├── Operadores.java
    │   └── Tours.java
    │   └── ServicioTuristico.java
    │   └── RutaGastronomica.java
    │   └── PaseoLacustre.java
    │   └── ExcursionCultural.java
    │   └── Registrable.java      <-- [NUEVO] Interfaz común del sistema
    ├── ui/               # Interfaz de usuario swing
    │   └── Main.java
    │   └── PanelPrincipal.java   <-- [NUEVO] Ventana de control, JTable y filtros
    │   └── VentanaAgregar.java   <-- [NUEVO] JDialog modal con CardLayout interactivo
    └── util/             # Clases de validación y utilidades
        ├── email.java
        └── rut.java
---


**Fecha de entrega:** \[13/07/2026]

---

© Duoc UC | Escuela de Informática y Telecomunicaciones | Actividad Sumativa 3: Interfaces e integración con colecciones genéricas
