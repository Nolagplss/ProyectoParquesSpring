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

## 👨‍💻 Autoría

Este proyecto fue desarrollado por mí como práctica para consolidar conocimientos en desarrollo móvil con Kotlin + Compose y desarrollo de APIs REST con Spring Boot.


