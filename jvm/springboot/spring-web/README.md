# Spring Web

Prácticas con spring web desarrolladas en base al libro Spring Boot: Up and Running
                     
## Actuator endpoints

- http://localhost:8080/actuator/configprops, propiedades de configuración.
- http://localhost:8080/actuator/loggers, información sobre los logs de la aplicación.
- http://localhost:8080/actuator/metrics, métricas de la aplicación.
- http://localhost:8080/actuator/metrics/jvm.memory.used, acceder a cada métrica.
- http://localhost:8080/actuator/health, estado de la aplicación.
- http://localhost:8080/actuator/beans

## Common user endpoints 

- http://localhost:8080/actuator/health
- http://localhost:8080/actuator/metrics 
       
## Base de datos con H2
### Ventajas

- Rápida
- Simple
- Baja latencia de IO
- Requiere pocos recursos

### Desventajas

- Los datos solo pueden ser usados por la aplicación
- Perdida de datos.

### Características

- Rápida.
- Creado en java.
- Proyecto open source.
- Se puede usar como Embedded/server.
- Se puede implementa en memoria/disco.
- Seguridad.
- Soporta manejo de transacciones.
- Soporta encriptación.
- Incluye una consola via web.
- Soporta búsquedas de tipo fulltext.
- Búsqueda en la base de datos sin row scan.
- Se pueden crear índices de textos.
- Soporta Apache Lucene.
- H2 es una implementación nativa.

### Limitaciones

- No está claro si es para uso productivo.
- No se ofrece soporte comercial.
                                
## Exportar datos de H2 con CSVWRITE

```sql
CALL CSVWRITE('filename.csv', 'SELECT * FROM table');
```

## Importar datos en H2 con CSVREAD

```sql
INSERT INTO table SELECT * FROM CSVREAD('filename.csv');
```

## Parámetros de url datasource

- IFEXISTS=TRUE: Se conecta a la base de datos siempre y cuando exista.
- TRACE_LEVE_SYSTEM_OUT: Muestra mensaje de log sobre la conexión con la base.
    - 0: Off
    - 1: On
    - 2: Info
    - 3: Debug
    - 4: Trace
- TRACE_LEVEL_FILE: Se genera un archivo (database.trace.db) con el log de la base de datos.
          
### Seguridad
- Database Encryption

```shell
java -cp h2*.jar org.h2.tools.ChangeFileEncryption -dir ~ -db customer -cipher AES -encrypt dbFilePassword
```

application.properties
```properties
spring.datasource.url=jdbc:h2:~/customers;IFEXISTS=TRUE;CIPHER=AES
spring.datasource.password=dbFilePassword Password01
```
