# Lista herramientas para micro-benchmark

1. ApacheBench
2. SIEGE
3. Gobench
4. Apache JMeter
5. wrk
6. HTTPLoad
7. Curl-loader
8. httperf
9. Tsung

## Pruebas

- Velocidad en las pruebas
- Medir el tiempo de ejecución
- Medir el tiempo del Primer Request
- Concurrencia - Solicitudes por segundo
- Memoria usada

## Funcionalidad (endpoints)

- GET / => Listado de personajes de comics en JSON.
- POST /greeting/{name} => Guardar un saludo en la base de datos
- GET /weather => Consumir un API de clima para obtener los datos de 100 ciudades.
- DELETE / => Eliminar 10000 registros de la base de datos.
- Se usa un contenedor con una base de datos en mysql.
- Cada aplicación se despliega en un contenedor.

## Enlaces

- [Apache benchmark](https://httpd.apache.org/docs/2.4/programs/ab.html)
- [Load testing tools](https://geekflare.com/essential-tools-to-perform-stress-test-online/)
- [Website load speed](https://geekflare.com/test-your-website-load-time/)
- [Bench web server performance](https://geekflare.com/web-performance-benchmark/#ApacheBench)
- https://www.toptal.com/nodejs/por-que-demonios-usaria-node-js-un-tutorial-caso-por-caso
- https://blog.logrocket.com/forget-express-js-opt-for-these-alternatives-instead/