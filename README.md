[README_plantilla_EFT.md](https://github.com/user-attachments/files/28673507/README_plantilla_EFT.md)

![Duoc UC](https://www.duoc.cl/wp-content/uploads/2022/09/logo-0.png)
# 🧠 Semana 6
**Actividad Formativa 4: Creación de jerarquías de clases con herencia simple**

## 👤 Autor del proyecto
- **Nombre completo:** [Ariel Gustavo Loncon Lefimil]
- **Sección:** [009A]
- **Carrera:** Desarrollo de aplicaciones
- **Sede:** [Online]

---

## 📘 Descripción general del sistema
Este proyecto consiste en el diseño e implementacion de un sistema de gestión administrativo, para la agencia de turismo "Llanquihue Tour", ubicada en la región de Los Lagos. El propósito principal de esta aplicación es automatizar la gestión de datos vinculados a la operación de la agencia, incluyendo guías turísticos, operadores locales y servicios turísticos.

---

## 🛠️ Actualización: Semana 6 - Jerarquías y Herencia
El objetivo de esta semana fue implementar una jerarquía de clases mediante herencia simple para modelar los distintos servicios turísticos de la agencia, permitiendo la reutilización de atributos comunes (nombre, duración) y especializando atributos propios de cada categoría.
### Clases Creadas/Modificadas:
- **Superclase:** `ServicioTuristico`
- **Subclases:** `RutaGastronomica`, `PaseoLacustre`, `ExcursionCultural`
- **Gestion:** Nueva clase en data `GestorServicios` para la instancia de objetos.

---

## 🧱 Estructura general del proyecto
## Características Principales (POO)
* **Encapsulamiento:** Todos los atributos de las clases del dominio son privados (`private`) y cuentan con métodos de acceso públicos (`getters` y `setters`).
* **Composición:** Implementación de relaciones lógicas donde una clase contiene a otra como atributo central (por ejemplo, los datos de una persona).
* **Sobrescritura:** Uso del método `toString()` en todas las entidades para asegurar un formato de salida limpio, legible y estandarizado por consola.
* **Validación de Datos:** Uso de clases especializadas (rut, email) para asegurar que solo información con formato válido ingrese al sistema.
* **Persistencia Básica:** Lectura y procesamiento de archivos .txt mediante gestores dedicados.
* **Herencia:** Extensión de clases base generales para representar de manera eficiente y jerárquica los datos específicos dentro del ecosistema de la agencia de Tours (como el nombre y cantidad de horas).

---

## 📋 Formato de los archivos de entrada
El sistema procesa archivos de texto (.txt) ubicados en la carpeta resources/. Cada línea debe respetar la siguiente estructura, utilizando punto y coma (;) como delimitador:
* tours.txt: id;nombre;tipo;produccion (ej: 1;City Tour;Cultural;15000)
* guias.txt: rut;nombre;email (ej: 12.345.678-9;Juan Perez;juan@email.cl)
* operadores.txt: nombre;area (ej: Transportes Sur;Logística)
* Nota: El sistema valida automáticamente el formato de los datos. Si una línea no cumple con el formato exigido, será descartada y se notificará el error en la consola.

---

## 🔍 Filtros y lógica aplicada
El sistema incorpora filtros funcionales para optimizar la toma de decisiones dentro de la agencia:
* Producción Destacada: Filtra tours cuya producción es superior a $10.000, permitiendo a la agencia identificar sus servicios más rentables.
* Filtrado por Categoría: Permite al usuario segmentar la oferta turística según el tipo (Gastronomía, Cultural, etc.), facilitando la búsqueda rápida de actividades.
* Validación de Integridad: Antes de cargar cualquier objeto, se aplica un filtro de validación mediante try-catch y expresiones regulares, asegurando que solo información coherente y con formato válido (RUT y Email) sea almacenada en las colecciones.

---

## 🚀 Instrucciones de ejecución
Para ejecutar correctamente la aplicación "Llanquihue Tour", asegúrate de seguir estos pasos en tu entorno de desarrollo (IDE como IntelliJ IDEA, NetBeans, etc).
## Requisitos previos:
* Tener instalado Java JDK 8 o superior.
* Para las carpetas del directorio resources/ en la raíz del proyecto, con los archivos tours.txt, guias.txt y operadores.txt si llegan a no estar, el mismo codigo las creara, pero sin datos a mostrar.
## Compilación y ejecución:
* Ubica la clase Main.java dentro del paquete com.LlanquihueTourApp.ui.
* Compila el proyecto para asegurar que todas las dependencias del modelo y utilidades estén vinculadas.
* Ejecuta el método main de la clase Main.
## Interacción con el sistema:
* Una vez iniciado, el programa desplegará el Menú de Consultas en la consola.
* Utiliza las teclas numéricas del 1 al 7 para navegar entre las opciones.
* El sistema solicitará entradas específicas (montos o tipos de tour) para realizar filtrados. Sigue las instrucciones en pantalla para obtener resultados precisos.
* Para finalizar la sesión, selecciona la opción 6 (Salir), lo cual cerrará el flujo del programa y liberará el recurso del Scanner.

---

```plaintext

  📁 resources           #Carpeta que almacena los aerchivos de entrada
    ├── guias.txt
    ├── operadores.txt
    ├── tours.txt
  📁 src/com/LlanquihueTourApp/
    ├── data/             # Gestores de lectura y persistencia de archivos
    │   ├── GestorArchivo.java
    │   ├── GestorGuias.java
    │   ├── GestorOperadores.java
    │   └── GestorDatos.java
    │   └── GestorServicios.java
    ├── model/            # Entidades del dominio
    │   ├── Guia.java
    │   ├── Operadores.java
    │   └── Tours.java
    │   └── ServicioTuristico.java
    │   └── RutaGastronomica.java
    │   └── PaseoLacustre.java
    │   └── ExcursionCultural .java
    ├── ui/               # Interfaz de usuario (consola)
    │   └── Main.java
    └── util/             # Clases de validación y utilidades
        ├── email.java
        └── rut.java
---


**Fecha de entrega:** \[29/06/2026]

---

© Duoc UC | Escuela de Informática y Telecomunicaciones | Actividad Formativa 4: Creación de jerarquías de clases con herencia simple
