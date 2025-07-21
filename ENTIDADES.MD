# Entidades de Dominio

## 1. Seguridad

### User
- **id**: Identificador único  
- **username**: Nombre de usuario (único)  
- **password**: Contraseña encriptada  
- **email**: Correo electrónico  
- **roles**: Lista de Roles asignados  
- **createdAt**: Fecha de creación del registro  
- **updatedAt**: Fecha de última modificación  

### Role
- **id**: Identificador único  
- **name**: Nombre del rol (p. ej. `ADMIN`, `USER`)  
- **description** (opcional): Breve descripción de permisos  

---

## 2. Catálogo de Productos

### Product
- **id**: Identificador único  
- **name**: Nombre del producto  
- **price**: Precio unitario  
- **description** (opcional): Descripción del producto  
- **category**: Referencia a **Category**  
- **createdAt**: Fecha de alta  
- **updatedAt**: Fecha de última modificación  

### Category
- **id**: Identificador único  
- **name**: Nombre de la categoría  
- **description** (opcional): Descripción de la categoría  
- **createdAt**: Fecha de alta  
- **updatedAt**: Fecha de última modificación  

---

## 3. Gestión de Clientes

### Customer
- **id**: Identificador único  
- **firstName**: Nombre  
- **lastName**: Apellido  
- **email**: Correo electrónico  
- **contactInfo**: Referencia a **ContactInfo**  
- **createdAt**: Fecha de alta  
- **updatedAt**: Fecha de última modificación  

### ContactInfo
- **phone**: Teléfono principal  
- **address**: Dirección completa  
- **secondaryPhone** (opcional): Segundo teléfono  
- **city** (opcional)  
- **state** (opcional)  
- **zipCode** (opcional)  

---

## 4. Ventas

### Order
- **id**: Identificador único  
- **customer**: Referencia a **Customer**  
- **items**: Lista de **OrderItem**  
- **total**: Importe total de la orden  
- **status**: Estado de la orden (p. ej. `PENDING`, `COMPLETED`, `CANCELLED`)  
- **createdAt**: Fecha de creación  
- **updatedAt**: Fecha de última modificación  

### OrderItem
- **id**: Identificador único  
- **order**: Referencia a **Order**  
- **product**: Referencia a **Product**  
- **quantity**: Cantidad solicitada  
- **unitPrice**: Precio unitario al momento de la venta  
- **subTotal**: `quantity * unitPrice`  

---

## 5. Inventario

### InventoryRecord
- **id**: Identificador único  
- **product**: Referencia a **Product**  
- **type**: `IN` (entrada) o `OUT` (salida)  
- **quantity**: Cantidad movida  
- **warehouse**: Referencia a **Warehouse** (opcional)  
- **timestamp**: Fecha y hora del movimiento  

### Warehouse
- **id**: Identificador único  
- **name**: Nombre del depósito  
- **location** (opcional): Ubicación física  
- **capacity** (opcional): Capacidad máxima  