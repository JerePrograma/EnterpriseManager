```markdown
# Guía de Despliegue

Este documento explica cómo desplegar la aplicación en distintos entornos.

---

## 1. Requisitos Previos

- Java 21+ y Maven instalado  
- Docker y Docker Compose (opcional)  
- Variables de entorno:
  - `SPRING_PROFILES_ACTIVE` (`dev` | `prod`)
  - `DB_URL`, `DB_USER`, `DB_PASSWORD`
  - `JWT_SECRET`, `JWT_EXPIRATION_MS`

---

## 2. Entorno de Desarrollo Local

1. Clonar repositorio:
   ```bash
   git clone https://github.com/JerePrograma/EnterpriseManager
   cd enterprise-manager
   ```

2. Crear fichero `src/main/resources/application-dev.yml` con credenciales locales.
3. Ejecutar con Maven:

   ```bash
   mvn clean spring-boot:run \
     -Dspring-boot.run.profiles=dev
   ```
4. Acceder en `http://localhost:8080`.

---

## 3. Con Docker

1. Construir imagen:

   ```bash
   docker build -t enterprise-manager:latest .
   ```
2. Definir entorno en `.env`:

   ```
   SPRING_PROFILES_ACTIVE=prod
   DB_URL=jdbc:mysql://mysql:3306/enterprise
   DB_USER=root
   DB_PASSWORD=secret
   JWT_SECRET=tu-secreto
   ```
3. Levantar contenedores:

   ```bash
   docker-compose up -d
   ```
4. Logs:

   ```bash
   docker-compose logs -f app
   ```

---

## 4. Producción

1. Configurar servidor (Ubuntu/Docker):

   * Instalar Docker y Nginx.
   * Clonar repositorio y variables en `/etc/enterprise/`.
2. Nginx:

   ```nginx
   server {
     listen 80;
     server_name jereprograma.com/api;

     location / {
       proxy_pass http://localhost:8080;
       proxy_set_header Host $host;
       proxy_set_header X-Real-IP $remote_addr;
     }
   }
   ```
3. Iniciar como servicio systemd o con Docker Compose.
4. Habilitar `HTTPS` con Let’s Encrypt:

   ```bash
   certbot --nginx -d jereprograma.com/api
   ```

````