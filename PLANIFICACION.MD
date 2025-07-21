## 1. Alcance del MVP

- **Objetivo**: Funcionalidad mínima útil que permita gestionar clientes, productos e “órdenes de venta” con stock básico.  
- **Excluye** por ahora: contabilidad avanzada, facturas legales, control financiero detallado, reportes complejos.

---

## 2. Módulos y entidades esenciales

| Módulo                   | Entidad principal | Otras entidades      |
| ------------------------ | ----------------- | -------------------- |
| 1. Seguridad             | User, Role        | –                    |
| 2. Catálogo de Productos | Product           | Category             |
| 3. Gestión de Clientes   | Customer          | ContactInfo          |
| 4. Ventas                | Order, OrderItem  | –                    |
| 5. Inventario            | InventoryRecord   | Warehouse (opcional) |

---

## 3. CRUD y endpoints prioritarios

### 3.1. Seguridad

- **User**  
  - `GET    /api/users`  
  - `GET    /api/users/{id}`  
  - `POST   /api/users`  
  - `PUT    /api/users/{id}`  
  - `DELETE /api/users/{id}`  

- **Role** (solo lectura inicialmente)  
  - `GET /api/roles`  

### 3.2. Catálogo de Productos

- **Product**  
  - Listar:     `GET    /api/products`  
  - Detalle:    `GET    /api/products/{id}`  
  - Crear:      `POST   /api/products`  
  - Actualizar: `PUT    /api/products/{id}`  
  - Eliminar:   `DELETE /api/products/{id}`  

- **Category** (opcional)  
  - CRUD básico si da tiempo  

### 3.3. Gestión de Clientes

- **Customer**  
  - `GET    /api/customers`  
  - `GET    /api/customers/{id}`  
  - `POST   /api/customers`  
  - `PUT    /api/customers/{id}`  
  - `DELETE /api/customers/{id}`  

### 3.4. Ventas

- **Order**  
  - `GET  /api/orders`  
  - `GET  /api/orders/{id}`  
  - `POST /api/orders`   _(incluye lista de OrderItem)_  
  - (Opcional) `PUT    /api/orders/{id}`  

- **OrderItem**  
  - Se maneja anidado dentro de la petición de Order  

### 3.5. Inventario

- **InventoryRecord**  
  - `GET  /api/inventory`  
  - `POST /api/inventory`  _(registro de entrada/salida)_  

---

## 4. Funciones de máxima prioridad

1. **Autenticación básica** (JWT) + gestión de usuarios/roles  
2. CRUD de **productos** y **clientes**  
3. Creación de **órdenes de venta** con validación de stock  
4. Registro simple de **movimientos de inventario**  
5. Estructura MVC + repositorios JPA + servicios + controladores REST  
6. Mapeo DTO ⇄ entidad y validación con Bean Validation  

---

## 5. Arquitectura y planificación de clases

```plaintext
┌───────────────────┐        ┌───────────────────┐
│  Controller       │──→uses │  Service          │
└───────────────────┘        └───────────────────┘
         │                           │
        maps                       uses
         ↓                           ↓
┌───────────────────┐        ┌───────────────────┐
│      DTOs         │        │ Repository (JPA) │
└───────────────────┘        └───────────────────┘
         ↑
        maps
         │
┌───────────────────┐
│     Entity        │
└───────────────────┘
```