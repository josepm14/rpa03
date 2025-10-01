# Proyecto Android – josepm_pa3

Aplicación móvil desarrollada en **Java con Android Studio**, que permite guardar y mostrar mensajes utilizando **Firebase Firestore**.

Este proyecto corresponde al **Producto Académico N°3** de la unidad "Desarrollo de Aplicaciones Móviles".

---

## 📱 Funcionalidad

- **Formulario** con los campos:
    - Nombre
    - Correo
    - Mensaje

- **Botón Guardar**  
  Guarda los datos en Firebase Firestore.

- **Botón Mostrar**  
  Muestra los datos guardados en un listado dentro de la aplicación (RecyclerView).

---

## 🛠️ Tecnologías y librerías usadas

- Lenguaje: **Java**
- IDE: **Android Studio**
- Base de datos: **Firebase Firestore**
- Arquitectura: **Fragments + Repository (MVVM simplificado)**
- UI: RecyclerView, Material Components

Dependencias principales (`app/build.gradle.kts`):

```kotlin
implementation(platform("com.google.firebase:firebase-bom:32.7.0"))
implementation("com.google.firebase:firebase-firestore")
implementation("androidx.recyclerview:recyclerview:1.3.1")
implementation("androidx.appcompat:appcompat:1.6.1")
implementation("com.google.android.material:material:1.9.0")
