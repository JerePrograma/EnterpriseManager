# Especificación de Endpoints y Vistas Frontend

Este documento define los **endpoints** de la API con sus respectivos ejemplos de JSON y las **vistas básicas** que tendrá el frontend.

---

## Índice

1. [Seguridad (Auth)](#seguridad-auth)
2. [Usuarios (User)](#usuarios-user)
3. [Roles (Role)](#roles-role)
4. [Productos (Product)](#productos-product)
5. [Categorías (Category)](#categorías-category)
6. [Clientes (Customer)](#clientes-customer)
7. [Órdenes (Order)](#órdenes-order)
8. [Inventario (InventoryRecord)](#inventario-inventoryrecord)
9. [Vistas Frontend](#vistas-frontend)

---

## Seguridad (Auth)

| Método | Endpoint        | Descripción                      |
| ------ | --------------- | -------------------------------- |
| POST   | `/api/auth/login`    | Autenticación, devuelve JWT token |
| POST   | `/api/auth/register` | Registro de usuario              |

### Login

- **Request**:
  ```json
  {
    "username": "user@example.com",
    "password": "P4ssw0rd!"
  }
  ```

- **Response** (200):
  ```json
  {
    "token": "eyJhbGci...",
    "expiresIn": 3600
  }
  ```

---

## Usuarios (User)

| Método | Endpoint              | Descripción            |
| ------ | --------------------- | ---------------------- |
| GET    | `/api/users`          | Listar todos los users |
| GET    | `/api/users/{id}`     | Obtener user por ID    |
| POST   | `/api/users`          | Crear nuevo user       |
| PUT    | `/api/users/{id}`     | Actualizar user        |
| DELETE | `/api/users/{id}`     | Eliminar user          |

### Crear Usuario

- **Request**:
  ```json
  {
    "username": "jane.doe@example.com",
    "password": "S3cr3t!",
    "email": "jane.doe@example.com",
    "roles": ["USER"]
  }
  ```

- **Response** (201):
  ```json
  {
    "id": 42,
    "username": "jane.doe@example.com",
    "email": "jane.doe@example.com",
    "roles": ["USER"]
  }
  ```

---

## Roles (Role)

| Método | Endpoint          | Descripción          |
| ------ | ----------------- | -------------------- |
| GET    | `/api/roles`      | Listar todos roles   |

- **Response** (200):
  ```json
  [
    { "id": 1, "name": "ADMIN" },
    { "id": 2, "name": "USER" }
  ]
  ```

---

## Productos (Product)

| Método | Endpoint               | Descripción                |
| ------ | ---------------------- | -------------------------- |
| GET    | `/api/products`        | Listar productos           |
| GET    | `/api/products/{id}`   | Obtener producto por ID    |
| POST   | `/api/products`        | Crear producto             |
| PUT    | `/api/products/{id}`   | Actualizar producto        |
| DELETE | `/api/products/{id}`   | Eliminar producto          |

### Crear Producto

- **Request**:
  ```json
  {
    "name": "Camiseta Basic",
    "price": 19.99,
    "description": "Algodón 100%",
    "categoryId": 3
  }
  ```

- **Response** (201):
  ```json
  {
    "id": 101,
    "name": "Camiseta Basic",
    "price": 19.99,
    "description": "Algodón 100%",
    "category": { "id": 3, "name": "Ropa" }
  }
  ```

---

## Categorías (Category)

| Método | Endpoint                 | Descripción               |
| ------ | ------------------------ | ------------------------- |
| GET    | `/api/categories`        | Listar categorías         |
| POST   | `/api/categories`        | Crear categoría (opcional)|
| PUT    | `/api/categories/{id}`   | Actualizar categoría      |
| DELETE | `/api/categories/{id}`   | Eliminar categoría        |

---

## Clientes (Customer)

| Método | Endpoint                | Descripción                |
| ------ | ----------------------- | -------------------------- |
| GET    | `/api/customers`        | Listar clientes            |
| GET    | `/api/customers/{id}`   | Obtener cliente por ID     |
| POST   | `/api/customers`        | Crear cliente              |
| PUT    | `/api/customers/{id}`   | Actualizar cliente         |
| DELETE | `/api/customers/{id}`   | Eliminar cliente           |

### Crear Cliente

- **Request**:
  ```json
  {
    "firstName": "Carlos",
    "lastName": "Pérez",
    "email": "c.perez@example.com",
    "contactInfo": {
      "phone": "+54 9 11 1234 5678",
      "address": "Calle Falsa 123"
    }
  }
  ```

- **Response** (201):
  ```json
  {
    "id": 58,
    "firstName": "Carlos",
    "lastName": "Pérez",
    "email": "c.perez@example.com",
    "contactInfo": {
      "phone": "+54 9 11 1234 5678",
      "address": "Calle Falsa 123"
    }
  }
  ```

---

## Órdenes (Order)

| Método | Endpoint               | Descripción                              |
| ------ | ---------------------- | ---------------------------------------- |
| GET    | `/api/orders`          | Listar órdenes                          |
| GET    | `/api/orders/{id}`     | Obtener orden por ID                    |
| POST   | `/api/orders`          | Crear orden (con items)                 |
| PUT    | `/api/orders/{id}`     | Actualizar orden (opcional)             |
| DELETE | `/api/orders/{id}`     | Cancelar orden (cambio de estado)       |

### Crear Orden

- **Request**:
  ```json
  {
    "customerId": 58,
    "items": [
      { "productId": 101, "quantity": 2 },
      { "productId": 115, "quantity": 1 }
    ]
  }
  ```

- **Response** (201):
  ```json
  {
    "id": 230,
    "customer": { "id": 58, "firstName": "Carlos", "lastName": "Pérez" },
    "items": [
      { "product": { "id": 101, "name": "Camiseta Basic" }, "quantity": 2 },
      { "product": { "id": 115, "name": "Pantalón Denim" }, "quantity": 1 }
    ],
    "total": 59.97,
    "createdAt": "2025-07-21T12:34:56"
  }
  ```

---

## Inventario (InventoryRecord)

| Método | Endpoint                | Descripción                           |
| ------ | ----------------------- | ------------------------------------- |
| GET    | `/api/inventory`        | Listar movimientos de inventario     |
| POST   | `/api/inventory`        | Registrar entrada/salida             |

### Registrar Movimiento

- **Request**:
  ```json
  {
    "productId": 101,
    "type": "IN",      // IN o OUT
    "quantity": 50,
    "warehouse": "Principal"
  }
  ```

- **Response** (201):
  ```json
  {
    "id": 402,
    "product": { "id": 101, "name": "Camiseta Basic" },
    "type": "IN",
    "quantity": 50,
    "warehouse": "Principal",
    "timestamp": "2025-07-21T12:45:00"
  }
  ```

---

## Vistas Frontend

1. **Login**: formulario de usuario/clave.
2. **Dashboard**: panel con métricas básicas (total clientes, órdenes hoy).
3. **Gestión de Usuarios**: listado, creación, edición y eliminación.
4. **Gestión de Productos**: catálogo con búsqueda, CRUD.
5. **Gestión de Clientes**: tabla con información y formulario CRUD.
6. **Órdenes**: listado de órdenes, detalle de orden, creación de nueva.
7. **Inventario**: vista de movimientos, formulario para registrar IN/OUT.
8. **Roles (opcional)**: listado de roles y asignación a usuarios.

Cada vista debe consumir los endpoints correspondientes y mostrar:
- **Tablas** para listados.
- **Formularios modales** para creación/edición.
- **Componentes de notificación** para éxito/error.
- **Validaciones** de campos (requerido, formato, rangos).
