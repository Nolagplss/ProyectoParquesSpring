# 🌿 Parque CRUD – Kotlin + Spring Boot

![Platform](https://img.shields.io/badge/platform-Android%20%7C%20Backend-blue)
![Tech](https://img.shields.io/badge/made_with-Kotlin%20%7C%20Jetpack%20Compose%20%7C%20Spring%20Boot-brightgreen)
![Status](https://img.shields.io/badge/status-Proyecto%20de%20prueba-lightgrey)

Aplicación móvil de prueba desarrollada en **Kotlin** usando **Jetpack Compose**, con un backend hecho en **Spring Boot**.

El objetivo del proyecto era practicar tanto la arquitectura cliente como servidor, integrando una app móvil con un backend propio basado en REST.  
Aunque la app no está visualmente pulida, demuestra el uso de patrones modernos, persistencia local y conexión cliente-servidor.

---

## 🛠️ Tecnologías utilizadas

### 🧩 Frontend (Android)
- Kotlin
- Jetpack Compose
- MVVM + ViewModel + UiState
- Room (almacenamiento local)
- Retrofit (comunicación con la API REST)
- Coroutines y Flow

### 🖥️ Backend
- Java + Spring Boot
- CRUD RESTful simple (sin validaciones ni autenticación)

---

## ✨ Funcionalidades

### 📱 App móvil
- Crear, editar y eliminar **parques**.
- Crear, editar y eliminar **especies**.
- Asignar especies a parques.
- Persistencia local de los parques creados por el usuario usando **Room**.
- Uso de `ViewModel`, `UiState` y arquitectura limpia para mantener separación de responsabilidades.

### 🌐 Backend (API Spring Boot)
- Endpoints REST para manejar parques y especies.
- CRUD básico para ambas entidades.
- Relación parque ↔ especies (muchos-a-muchos o uno-a-muchos, según implementación).
- No incluye autenticación ni validaciones: fue creado como backend de prueba.

---

## ⚠️ Notas

- El diseño visual de la app no fue el objetivo del proyecto.
- El enfoque principal estuvo en practicar arquitectura, integración API y persistencia.
- En el futuro podría añadirse validación de entradas, login, y mejoras visuales.

---

## 🚀 Instrucciones para ejecutar el proyecto

1. **Iniciar la base de datos**  
   Asegúrate de tener la base de datos configurada y en funcionamiento antes de iniciar el backend.  
   Si estás usando una base en memoria o embebida (como H2), este paso puede no ser necesario.

2. **Importar y ejecutar el backend (Spring Boot)**  
   - Abre el proyecto backend en tu IDE (por ejemplo, IntelliJ o Eclipse).  
   - Ejecuta la aplicación Spring Boot (`ParqueApplication.kt` o clase principal con `@SpringBootApplication`).  
   - El backend correrá por defecto en: `http://localhost:8080/`

3. **Importar y configurar la app Android (Kotlin)**  
   - Abre el proyecto Android en Android Studio.  
   - En el archivo `ContenedorAppParques.kt`, modifica la propiedad `baseUrl` para que apunte a tu IP local (la de tu PC donde corre el backend).  

---

## 👨‍💻 Autoría

Este proyecto fue desarrollado por mí como práctica para consolidar conocimientos en desarrollo móvil con Kotlin + Compose y desarrollo de APIs REST con Spring Boot.
