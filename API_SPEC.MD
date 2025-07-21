# API Reference

Este documento unifica todos los endpoints de la API REST, con contratos JSON normalizados.

---

## 1. Autenticación

### POST `/api/auth/login`
**Request** (200)  
```json
{
  "username": "string",
  "password": "string"
}
````

**Response** (200 OK)

```json
{
  "accessToken": "string",
  "tokenType": "Bearer"
}
```

---

## 2. Usuarios

### GET `/api/users`

Listar todos los usuarios.

**Response** (200 OK)

```json
[
  {
    "id": 1,
    "username": "jane.doe",
    "email": "jane.doe@example.com",
    "roles": [
      { "id": 2, "name": "ROLE_USER" }
    ],
    "createdAt": "2025-07-20T10:15:30Z",
    "updatedAt": "2025-07-21T14:05:00Z"
  },
  ...
]
```

### GET `/api/users/{id}`

Obtener un usuario por ID.

**Response** (200 OK)

```json
{
  "id": 1,
  "username": "jane.doe",
  "email": "jane.doe@example.com",
  "roles": [
    { "id": 2, "name": "ROLE_USER" }
  ],
  "createdAt": "2025-07-20T10:15:30Z",
  "updatedAt": "2025-07-21T14:05:00Z"
}
```

### POST `/api/users`

Crear un nuevo usuario.

**Request** (201 Created)

```json
{
  "username": "john.smith",
  "password": "Secret123!",
  "email": "john.smith@example.com",
  "roles": [2]
}
```

**Response** (201 Created)

```json
{
  "id": 5,
  "username": "john.smith",
  "email": "john.smith@example.com",
  "roles": [
    { "id": 2, "name": "ROLE_USER" }
  ],
  "createdAt": "2025-07-21T15:00:00Z",
  "updatedAt": "2025-07-21T15:00:00Z"
}
```

### PUT `/api/users/{id}`

Actualizar un usuario existente.

**Request** (200 OK)

```json
{
  "email": "john.new@example.com",
  "roles": [1, 2]
}
```

**Response** (200 OK)

```json
{
  "id": 5,
  "username": "john.smith",
  "email": "john.new@example.com",
  "roles": [
    { "id": 1, "name": "ROLE_ADMIN" },
    { "id": 2, "name": "ROLE_USER" }
  ],
  "createdAt": "2025-07-21T15:00:00Z",
  "updatedAt": "2025-07-21T16:30:00Z"
}
```

### DELETE `/api/users/{id}`

Eliminar un usuario.

**Response** (204 No Content)
*(sin cuerpo)*

---

## 3. Roles

### GET `/api/roles`

Listar todos los roles.

**Response** (200 OK)

```json
[
  { "id": 1, "name": "ROLE_ADMIN" },
  { "id": 2, "name": "ROLE_USER" }
]
```

### GET `/api/roles/{id}`

Obtener un rol por ID.

**Response** (200 OK)

```json
{
  "id": 2,
  "name": "ROLE_USER",
  "description": "Acceso estándar de usuario"
}
```

---

## 4. Productos

### GET `/api/products`

Listar productos.

**Response** (200 OK)

```json
[
  {
    "id": 101,
    "name": "Zapato Deportivo",
    "price": 79.99,
    "description": "Modelo running",
    "category": { "id": 5, "name": "Calzado" },
    "createdAt": "2025-06-01T09:00:00Z",
    "updatedAt": "2025-06-15T11:20:00Z"
  },
  ...
]
```

### GET `/api/products/{id}`

Obtener un producto.

**Response** (200 OK)

```json
{
  "id": 101,
  "name": "Zapato Deportivo",
  "price": 79.99,
  "description": "Modelo running",
  "category": { "id": 5, "name": "Calzado" },
  "createdAt": "2025-06-01T09:00:00Z",
  "updatedAt": "2025-06-15T11:20:00Z"
}
```

### POST `/api/products`

Crear producto.

**Request** (201 Created)

```json
{
  "name": "Remera Casual",
  "price": 19.99,
  "description": "Algodón 100%",
  "categoryId": 8
}
```

**Response** (201 Created)

```json
{
  "id": 110,
  "name": "Remera Casual",
  "price": 19.99,
  "description": "Algodón 100%",
  "category": { "id": 8, "name": "Indumentaria" },
  "createdAt": "2025-07-21T14:50:00Z",
  "updatedAt": "2025-07-21T14:50:00Z"
}
```

### PUT `/api/products/{id}`

Actualizar producto.

**Request** (200 OK)

```json
{
  "price": 17.99
}
```

**Response** (200 OK)

```json
{
  "id": 110,
  "name": "Remera Casual",
  "price": 17.99,
  "description": "Algodón 100%",
  "category": { "id": 8, "name": "Indumentaria" },
  "createdAt": "2025-07-21T14:50:00Z",
  "updatedAt": "2025-07-21T15:10:00Z"
}
```

### DELETE `/api/products/{id}`

Eliminar producto.

**Response** (204 No Content)

---

## 5. Categorías

### GET `/api/categories`

Listar categorías.

**Response** (200 OK)

```json
[
  { "id": 5, "name": "Calzado", "description": "Zapatos y zapatillas", "createdAt":"2025-01-10T08:00:00Z","updatedAt":"2025-05-20T12:00:00Z" },
  ...
]
```

### GET `/api/categories/{id}`

Obtener categoría.

**Response** (200 OK)

```json
{ "id": 5, "name": "Calzado", "description": "Zapatos y zapatillas", "createdAt":"2025-01-10T08:00:00Z","updatedAt":"2025-05-20T12:00:00Z" }
```

### POST `/api/categories`

Crear categoría.

**Request** (201 Created)

```json
{ "name": "Accesorios", "description": "Bolsos, cinturones..." }
```

**Response** (201 Created)

```json
{ "id": 12, "name": "Accesorios", "description": "Bolsos, cinturones...", "createdAt":"2025-07-21T13:00:00Z","updatedAt":"2025-07-21T13:00:00Z" }
```

### PUT `/api/categories/{id}`

Actualizar categoría.

**Request** (200 OK)

```json
{ "description": "Bolsos, cinturones y más" }
```

**Response** (200 OK)

```json
{ "id": 12, "name": "Accesorios", "description": "Bolsos, cinturones y más", "createdAt":"2025-07-21T13:00:00Z","updatedAt":"2025-07-21T13:20:00Z" }
```

### DELETE `/api/categories/{id}`

Eliminar categoría.

**Response** (204 No Content)

---

## 6. Clientes

### GET `/api/customers`

Listar clientes.

**Response** (200 OK)

```json
[
  {
    "id": 30,
    "firstName": "Ana",
    "lastName": "Rodríguez",
    "email": "ana.rodriguez@mail.com",
    "contactInfo": {
      "phone": "+54 9 11 1234 5678",
      "address": "Av. Siempre Viva 742",
      "secondaryPhone": null,
      "city": "Rosario",
      "state": "Santa Fe",
      "zipCode": "2000"
    },
    "createdAt": "2025-02-10T10:00:00Z",
    "updatedAt": "2025-06-05T16:30:00Z"
  },
  ...
]
```

### GET `/api/customers/{id}`

Obtener cliente.

**Response** (200 OK)

```json
{
  "id": 30,
  "firstName": "Ana",
  "lastName": "Rodríguez",
  "email": "ana.rodriguez@mail.com",
  "contactInfo": {
    "phone": "+54 9 11 1234 5678",
    "address": "Av. Siempre Viva 742",
    "secondaryPhone": null,
    "city": "Rosario",
    "state": "Santa Fe",
    "zipCode": "2000"
  },
  "createdAt": "2025-02-10T10:00:00Z",
  "updatedAt": "2025-06-05T16:30:00Z"
}
```

### POST `/api/customers`

Crear cliente.

**Request** (201 Created)

```json
{
  "firstName": "Carlos",
  "lastName": "González",
  "email": "carlos.g@example.com",
  "contactInfo": {
    "phone": "+54 9 11 8765 4321",
    "address": "Calle Falsa 123",
    "city": "Córdoba",
    "state": "Córdoba",
    "zipCode": "5000"
  }
}
```

**Response** (201 Created)

```json
{
  "id": 45,
  "firstName": "Carlos",
  "lastName": "González",
  "email": "carlos.g@example.com",
  "contactInfo": {
    "phone": "+54 9 11 8765 4321",
    "address": "Calle Falsa 123",
    "secondaryPhone": null,
    "city": "Córdoba",
    "state": "Córdoba",
    "zipCode": "5000"
  },
  "createdAt": "2025-07-21T15:10:00Z",
  "updatedAt": "2025-07-21T15:10:00Z"
}
```

### PUT `/api/customers/{id}`

Actualizar cliente.

**Request** (200 OK)

```json
{
  "email": "ana.nueva@mail.com",
  "contactInfo": {
    "secondaryPhone": "+54 9 11 0000 1111"
  }
}
```

**Response** (200 OK)

```json
{
  "id": 30,
  "firstName": "Ana",
  "lastName": "Rodríguez",
  "email": "ana.nueva@mail.com",
  "contactInfo": {
    "phone": "+54 9 11 1234 5678",
    "address": "Av. Siempre Viva 742",
    "secondaryPhone": "+54 9 11 0000 1111",
    "city": "Rosario",
    "state": "Santa Fe",
    "zipCode": "2000"
  },
  "createdAt": "2025-02-10T10:00:00Z",
  "updatedAt": "2025-07-21T15:30:00Z"
}
```

### DELETE `/api/customers/{id}`

Eliminar cliente.

**Response** (204 No Content)

---

## 7. Órdenes

### GET `/api/orders`

Listar órdenes.

**Response** (200 OK)

```json
[
  {
    "id": 200,
    "customer": { "id": 30, "firstName": "Ana", "lastName": "Rodríguez" },
    "items": [
      {
        "id": 500,
        "product": { "id": 101, "name": "Zapato Deportivo" },
        "quantity": 2,
        "unitPrice": 79.99,
        "subTotal": 159.98
      }
    ],
    "total": 159.98,
    "status": "PENDING",
    "createdAt": "2025-07-20T18:45:00Z",
    "updatedAt": "2025-07-20T18:45:00Z"
  },
  ...
]
```

### GET `/api/orders/{id}`

Obtener orden.

**Response** (200 OK)

```json
{
  "id": 200,
  "customer": { "id": 30, "firstName": "Ana", "lastName": "Rodríguez" },
  "items": [ ... ],
  "total": 159.98,
  "status": "PENDING",
  "createdAt": "2025-07-20T18:45:00Z",
  "updatedAt": "2025-07-20T18:45:00Z"
}
```

### POST `/api/orders`

Crear orden.

**Request** (201 Created)

```json
{
  "customerId": 30,
  "items": [
    { "productId": 101, "quantity": 2 }
  ]
}
```

**Response** (201 Created)

```json
{
  "id": 201,
  "customer": { "id": 30, "firstName": "Ana", "lastName": "Rodríguez" },
  "items": [
    {
      "id": 501,
      "product": { "id": 101, "name": "Zapato Deportivo" },
      "quantity": 2,
      "unitPrice": 79.99,
      "subTotal": 159.98
    }
  ],
  "total": 159.98,
  "status": "PENDING",
  "createdAt": "2025-07-21T15:40:00Z",
  "updatedAt": "2025-07-21T15:40:00Z"
}
```

### PUT `/api/orders/{id}`

Actualizar estado de orden.

**Request** (200 OK)

```json
{ "status": "COMPLETED" }
```

**Response** (200 OK)

```json
{
  "id": 201,
  "status": "COMPLETED",
  "updatedAt": "2025-07-21T16:00:00Z"
}
```

### DELETE `/api/orders/{id}`

Eliminar orden.

**Response** (204 No Content)

---

## 8. Inventario

### GET `/api/inventory`

Listar movimientos.

**Response** (200 OK)

```json
[
  {
    "id": 900,
    "product": { "id": 101, "name": "Zapato Deportivo" },
    "type": "IN",
    "quantity": 50,
    "warehouse": { "id": 3, "name": "Central" },
    "timestamp": "2025-07-15T12:00:00Z"
  },
  ...
]
```

### GET `/api/inventory/{id}`

Obtener movimiento.

**Response** (200 OK)

```json
{
  "id": 900,
  "product": { "id": 101, "name": "Zapato Deportivo" },
  "type": "IN",
  "quantity": 50,
  "warehouse": { "id": 3, "name": "Central" },
  "timestamp": "2025-07-15T12:00:00Z"
}
```

### POST `/api/inventory`

Registrar movimiento.

**Request** (201 Created)

```json
{
  "productId": 101,
  "type": "IN",
  "quantity": 50,
  "warehouseId": 3
}
```

**Response** (201 Created)

```json
{
  "id": 901,
  "product": { "id": 101, "name": "Zapato Deportivo" },
  "type": "IN",
  "quantity": 50,
  "warehouse": { "id": 3, "name": "Central" },
  "timestamp": "2025-07-21T15:50:00Z"
}
```

---

## 9. Depósitos (Warehouses)

### GET `/api/warehouses`

Listar depósitos.

**Response** (200 OK)

```json
[
  { "id": 1, "name": "Central", "location": "Av. Principal 100", "capacity": 1000 },
  ...
]
```

### GET `/api/warehouses/{id}`

Obtener depósito.

**Response** (200 OK)

```json
{ "id": 1, "name": "Central", "location": "Av. Principal 100", "capacity": 1000 }
```

### POST `/api/warehouses`

Crear depósito.

**Request** (201 Created)

```json
{ "name": "Secundario", "location": "Calle Secundaria 200", "capacity": 500 }
```

**Response** (201 Created)

```json
{ "id": 4, "name": "Secundario", "location": "Calle Secundaria 200", "capacity": 500 }
```

### PUT `/api/warehouses/{id}`

Actualizar depósito.

**Request** (200 OK)

```json
{ "capacity": 600 }
```

**Response** (200 OK)

```json
{ "id": 4, "name": "Secundario", "location": "Calle Secundaria 200", "capacity": 600 }
```

### DELETE `/api/warehouses/{id}`

Eliminar depósito.

**Response** (204 No Content)