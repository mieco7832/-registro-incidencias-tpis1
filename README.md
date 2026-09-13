# Regtisto de incidencias

Reporta y da seguimiento a problemas de equipos, infraestructura o servicios.

## Herramientas:

- **IDE**: Android Studio (Hedgehog o superior)
- **Lenguaje principal**: Kotlin (v2.0.21)
- **Android Gradle Plugin (AGP)**: v9.3.1
- **Compile SDK**: API 37 (Android 15)
- **Min SDK**: API 24 (Android 7.0 - Nougat)
- **Target SDK**: API 37 (Android 15)
- **Java**: Version 11 (sourceCompatibility y targetCompatibility)
- **UI Framework**: Jetpack Compose (BOM 2024.11.00)
    - `androidx.activity:activity-compose`
    - `androidx.compose.ui:ui`
    - `androidx.compose.ui:ui-tooling-preview`
    - `androidx.compose.material3:material3`
- **Librerías adicionales**:
    - `androidx.core:core-ktx` (v1.10.1)
    - `androidx.appcompat:appcompat` (v1.6.1)
    - `com.google.android.material:material` (v1.10.0)
    - `androidx.compose.runtime:runtime` (v1.12.0)
- **Pruebas (Testing)**: JUnit (v4.13.2), Espresso (v3.5.1), AndroidX JUnit (v1.1.5)
- **Control de versiones**: Git y GitHub

## Estado actual del proyecto

- [x] Configuración inicial del proyecto y estructura de carpetas.
- [x] Archivos de configuración (Gradle) actualizados con las dependencias necesarias.
- [x] Pantalla inicial.
- [x] Componentes para captura de texto `titulo` y `descripcion`.
- [x] Archivo de `String.xml` implementando logica de constantes

## Cómo abrir el proyecto en Android Studio

1. Asegúrate de tener instalado Android Studio y Git.
2. Clona el repositorio desde GitHub:
   ```bash
   git clone https://github.com/mieco7832/registro-incidencias-tpis1.git
   ```
## Autor

- Nombre: Escobar Castillo, Manuel Escobar
- Carnet / ID: 2939532016@mail.utec.edu.sv
- Curso: Técnicas de Producción Industrial de Software I - Ciclo 02-2026
- Universidad: Universidad Tecnológica de El Salvador
