# retonntdata
repositorio para subir los recursos usados para el reto tecnico de ntt data

En este reto pedia lo siguiente

Cree un diseño de arquitectura para una aplicación nativa de nube
considerando los siguientes componentes:

Frontend: Una aplicación web que los clientes utilizarán para
navegación.

Para esta parte se creo un proyecto en angular, que permite comunicarse con un backend, a traves de APIREST.

Backend: Servicios que se comunican con la base de datos y el
frontend.

Para esta parte se creo un proyecto en spring boot, que permite hacer un almacenamiento hacia una base de datos

Base de datos: Un sistema de gestión de base de datos que
almacene información.

Se hace uso de una base de datos Postgres

Almacenamiento de objetos: Para gestionar imágenes y contenido
estático.

Este caso se uso para alojar los recursos del sitio del frontend.


Diseño:
a. Seleccione un proveedor de servicios de nube (Aws, Azure o GCP) y sustente su selección.

He seleccionado la nube de aws, porque tengo conocimiento sobre esta, en la cual, tengo varios servicios aws, que me permiten realizar la práctica, entre los cuales seleccione los siguientes.

Amazon Simple Storage Service (Amazon S3).- este servicio me permite alojar el sitio estático y los assets del sitio desarrollado en angular, además, de alojar los logs del sitio web.
Amazon CloudFront.- Es un servicio web que agiliza la distribución de contenido web estático y dinámico como archivos .html, .css, .js y archivos de imágenes a los usuarios.
Aurora and RDS.- Este es un servicio que permite crear la base de datos, el cual, crea la base tipo postgres la cual se conecta el backend.
Elastic Container Registry.- este es un servicio en el cual, se puede crear el registry, para nuestras imágenes
se instaló aws cli, para conectar el con docker login.
se crea una IAM, que permite loguearse al registry en ecr, y permite hacer un push.
Elastic Container Service.- este permite crear un cluster de contenedores (similar a docker swarm), en el cual, se tiene que crear una tarea para hacer el despliegue y crear el servicio.


b. Diseñe una arquitectura de nube. Incluya diagramas que
representen la arquitectura y justifique sus decisiones de diseño
(Utilice https://app.diagrams.net/).

https://app.diagrams.net/#G1vkVHZPCeRO0-GRpJ-ukIEUc3ebutv-vd#%7B%22pageId%22%3A%2283CmaSJB3NC0Lcbm4QTh%22%7D

