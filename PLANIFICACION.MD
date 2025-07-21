```markdown
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
  - Listar:   `GET    /api/products`  
  - Detalle:  `GET    /api/products/{id}`  
  - Crear:    `POST   /api/products`  
  - Actualizar: `PUT    /api/products/{id}`  
  - Eliminar: `DELETE /api/products/{id}`  

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

* **Entity**: anotada con `@Entity`, corresponde a la tabla.  
* **Repository**: extiende `JpaRepository<Entity, Long>`.  
* **Service**: lógica de negocio, transacciones.  
* **Controller**: expone `@RestController` + rutas.  
* **DTO**: record o clase con campos + validaciones (`@NotNull`, etc.).  
* **Mapper**: uso de MapStruct o métodos estáticos para conversión Entity ⇄ DTO.

---

## 6. Protocolo DTO y ejemplos de API

### 6.1. Product

```java
// DTOs
public record ProductRequestDTO(
    @NotBlank String name,
    @NotNull BigDecimal price,
    String description,
    Long categoryId
) {}

public record ProductResponseDTO(
    Long id,
    String name,
    BigDecimal price,
    String description,
    CategorySummaryDTO category
) {}

// Controller
@RestController
@RequestMapping("/api/products")
public class ProductController {

    @PostMapping
    public ProductResponseDTO create(@RequestBody @Valid ProductRequestDTO dto) { … }

    @GetMapping
    public List<ProductResponseDTO> list() { … }

    @GetMapping("/{id}")
    public ProductResponseDTO get(@PathVariable Long id) { … }

    @PutMapping("/{id}")
    public ProductResponseDTO update(
        @PathVariable Long id,
        @RequestBody @Valid ProductRequestDTO dto
    ) { … }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) { … }
}
```

### 6.2. Order

```java
// DTOs para Order
public record OrderItemDTO(
    @NotNull Long productId,
    @Min(1) Integer quantity
) {}

public record OrderRequestDTO(
    @NotNull Long customerId,
    @NotEmpty List<@Valid OrderItemDTO> items
) {}

public record OrderResponseDTO(
    Long id,
    CustomerSummaryDTO customer,
    List<OrderItemDetailDTO> items,
    BigDecimal total,
    LocalDateTime createdAt
) {}
```

---

## 7. Cronograma de 3 días

| Día   | Tareas clave                                                                               |
| ----- | ------------------------------------------------------------------------------------------ |
| **1** | - Configuración inicial (Spring Boot, seguridad JWT)<br>- Entidades User/Role + CRUD User |
| **2** | - Módulo Product + Category<br>- Módulo Customer<br>- Pruebas con Postman                  |
| **3** | - Módulo Order + OrderItem<br>- Inventario básico<br>- Despliegue (jar o Docker)          |
```
