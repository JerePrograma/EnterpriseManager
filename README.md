````markdown
# Enterprise Manager

Enterprise Manager es una plataforma monolítica modular para gestionar usuarios, roles, productos, categorías, clientes, órdenes e inventario. Incluye:

- API RESTful con autenticación JWT  
- Backend en Spring Boot (Java 17+)  
- Frontend en React con TypeScript  
- Persistencia JPA (Postgres/MySQL)  
- Despliegue vía Docker Compose o JAR standalone

---

## 📑 Índice

- [Arquitectura](ARQUITECTURA.MD)  
- [Planificación](PLANIFICACION.MD)  
- [Modelo de datos](ENTIDADES.MD)  
- [Especificación de la API](API_SPEC.MD)  
- [Vistas Frontend](FRONTEND.MD)  
- [Despliegue](DEPLOYMENT.MD)  
- [Instalación](#instalación)  
- [Uso](#uso)  
- [Contribuciones](#contribuciones)  
- [Licencia](#licencia)  

---

## 🏗 Arquitectura

Consulta [ARQUITECTURA.MD](ARQUITECTURA.MD) para:

- Visión general  
- Parent POM y módulos  
- Estructura de carpetas  
- Dependencias clave  

---

## 📅 Planificación

En [PLANIFICACION.MD](PLANIFICACION.MD) encontrarás:

- Alcance del MVP  
- Módulos y entidades prioritarias  
- Cronograma de 3 días  
- Endpoints y flujos de trabajo  

---

## 📋 Modelo de datos

Revisa [ENTIDADES.MD](ENTIDADES.MD) para la descripción completa de cada entidad de dominio y sus atributos (incluyendo `createdAt` y `updatedAt`).

---

## 🔌 Especificación de la API

Todos los endpoints y contratos JSON normalizados están en [API_SPEC.MD](API_SPEC.MD).

---

## 🎨 Vistas Frontend

Las rutas y componentes React definidos se documentan en [FRONTEND.MD](FRONTEND.MD).

---

## 🚀 Despliegue

Guías paso a paso para desarrollo local, Docker y producción en [DEPLOYMENT.MD](DEPLOYMENT.MD).

---

## 💻 Instalación

### Prerrequisitos

- Java 21+  
- Maven 3.6+  
- Node.js 18+ y npm  
- (Opcional) Docker y Docker Compose  

### Clonar y levantar backend

```bash
git clone git@github.com:tu-org/enterprise-manager.git
cd enterprise-manager
mvn clean install
mvn spring-boot:run -Dspring-boot.run.profiles=dev
````

### Levantar frontend

```bash
cd frontend
npm install
npm run dev
```

---

## 🔧 Uso

* Backend: `http://localhost:8080`
* Frontend: `http://localhost:3000`

---

## 🤝 Contribuciones

1. Haz fork del repositorio
2. Crea tu rama: `git checkout -b feature/mi-feature`
3. Realiza tus cambios y commitea: `git commit -m "Añade mi feature"`
4. Envía un pull request

---

## 📄 Licencia

Este proyecto está bajo licencia MIT. Véase [LICENSE](LICENSE).

---

## 📬 Contacto

Para dudas o sugerencias, escríbenos a `equipo@tu-organizacion.com`.

```
```
