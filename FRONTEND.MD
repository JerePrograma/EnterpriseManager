```markdown
# Vistas y Componentes Frontend

Este documento define las pantallas y componentes básicos de la aplicación web.

---

## 1. Login

- **Ruta**: `/login`  
- **Componentes**:  
  - `LoginForm` (inputs `username`, `password`)  
  - Manejo de errores (`Invalid credentials`)  

---

## 2. Dashboard

- **Ruta**: `/`  
- **Componentes**:  
  - Estadísticas rápidas (usuarios, órdenes, stock)  
  - Barra de navegación lateral  

---

## 3. Gestión de Usuarios

- **Ruta**: `/users`  
- **Componentes**:  
  - `UsersList` (tabla con columnas `username`, `email`, `roles`, acciones)  
  - `UserForm` (modal para crear/editar)  

---

## 4. Roles

- **Ruta**: `/roles`  
- **Componentes**:  
  - `RolesList` (lista simple)  
  - `RoleForm` (crear/editar)  

---

## 5. Productos y Categorías

- **Rutas**:  
  - `/products` → `ProductsList`, `ProductForm`  
  - `/categories` → `CategoriesList`, `CategoryForm`  

---

## 6. Clientes

- **Ruta**: `/customers`  
- **Componentes**:  
  - `CustomersList` (tabla con `firstName`, `lastName`, `email`)  
  - `CustomerForm` (crear/editar, incluye subform para `ContactInfo`)  

---

## 7. Órdenes

- **Ruta**: `/orders`  
- **Componentes**:  
  - `OrdersList` (tabla con `id`, `customer`, `total`, `status`)  
  - `OrderDetail` (vista detalle con lista de `OrderItem`)  

---

## 8. Inventario

- **Ruta**: `/inventory`  
- **Componentes**:  
  - `InventoryList` (movimientos con `product`, `type`, `quantity`, `warehouse`)  
  - `InventoryForm` (registrar `IN`/`OUT`)  

---

## 9. Depósitos

- **Ruta**: `/warehouses`  
- **Componentes**:  
  - `WarehousesList` (tabla con `name`, `location`, `capacity`)  
  - `WarehouseForm` (crear/editar)
````
