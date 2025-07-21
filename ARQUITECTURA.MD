## 1. Visión General

- **Enfoque**: Monolito modular bajo un parent POM Maven.
- **Ventajas**: despliegue sencillo (un único artefacto), configuración centralizada, fácil evolución a microservicios.
- **Principios**: Responsabilidad Única, Inversión de Dependencias, capas definidas.

---

## 2. Parent POM (`mvp-backend/pom.xml`)

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
                             http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>

  <groupId>com.example</groupId>
  <artifactId>mvp-backend</artifactId>
  <version>0.1.0</version>
  <packaging>pom</packaging>

  <properties>
    <java.version>17</java.version>
    <spring.boot.version>3.1.0</spring.boot.version>
    <mapstruct.version>1.5.5.Final</mapstruct.version>
  </properties>

  <modules>
    <module>common-lib</module>
    <module>auth-service</module>
    <module>user-service</module>
    <module>product-service</module>
    <module>order-service</module>
    <module>inventory-service</module>
  </modules>

  <dependencyManagement>
    <dependencies>
      <!-- Versiones comunes de dependencias -->
      <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-dependencies</artifactId>
        <version>${spring.boot.version}</version>
        <type>pom</type>
        <scope>import</scope>
      </dependency>
    </dependencies>
  </dependencyManagement>
</project>
```

- Define versiones de Java y dependencias comunes.
- Lista de módulos en orden de compilación.

---

## 3. Módulos y dependencias clave

| Módulo               | Función                                       | Dependencias principales            |
| -------------------- | --------------------------------------------- | ----------------------------------- |
| **common-lib**       | DTOs, excepciones, utilidades compartidas     | Ninguna                             |
| **auth-service**     | Autenticación (JWT), registro de usuarios     | spring-boot-starter-security, common-lib |
| **user-service**     | CRUD de usuarios                              | spring-boot-starter-data-jpa, common-lib |
| **product-service**  | CRUD de productos                             | spring-boot-starter-data-jpa, common-lib |
| **order-service**    | Gestión de órdenes y OrderItem                | spring-boot-starter-data-jpa, common-lib |
| **inventory-service**| Movimientos de inventario                     | spring-boot-starter-data-jpa, common-lib |

Cada `pom.xml` de módulo hereda del parent y añade solo sus dependencias específicas.

---

## 4. Estructura de carpetas

```
mvp-backend/
├── pom.xml                   ← Parent POM
├── common-lib/
│   └── src/main/java/com/example/common/
├── auth-service/
│   └── src/main/java/com/example/auth/
├── user-service/
│   └── src/main/java/com/example/userservice/
├── product-service/
│   └── src/main/java/com/example/productservice/
├── order-service/
│   └── src/main/java/com/example/orderservice/
└── inventory-service/
    └── src/main/java/com/example/inventoryservice/
```

- Cada módulo con su propio `src/` y paquete base.
- `common-lib` disponible para todos.

---

## 5. Configuración de IDE

1. Abrir la carpeta raíz `mvp-backend` como proyecto Maven.
2. El IDE (IntelliJ/Eclipse) detecta el parent POM y todos los submódulos.
3. Los imports de `common-lib` y otras dependencias se resuelven automáticamente.

---

## 6. Despliegue rápido

- **Modo desarrollo**: ejecutar con `mvn spring-boot:run` o desde el IDE.
- **Docker Compose**: define un servicio para la app y la base de datos.
- **Perfiles**: `application-dev.yml` usa H2; `application-prod.yml` usa Postgres/MySQL.

---

## 7. Plan de trabajo (3 días)

| Día | Tareas clave                                                                                          |
| ----| ------------------------------------------------------------------------------------------------------ |
| 1   | - Inicializar parent POM y common-lib<br>- Implementar `auth-service` (login, register, JWT)<br>- Tests y documentación Swagger para Auth |
| 2   | - CRUD `user-service` y `product-service` (entidades, repos, servicios, controladores)<br>- Validaciones y DTOs/mappers<br>- Pruebas unitarias básicas |
| 3   | - CRUD `order-service` y `inventory-service`<br>- Configuración Docker Compose<br>- Despliegue local y pruebas de integración<br>- Ajustes finales y limpieza de código |
