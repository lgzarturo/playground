# Logback

## Configuración

`org.hibernate.level=DEBUG`

### Logback via Slf4j

```xml
<configuration>
    <appender name="STDOUT" class="ch.qos.logback.core.ConsoleAppender">
        <encoder class="ch.qos.logback.classic.encoder.PatternLayoutEncoder">
            <Pattern>
                %d{yyyy-MM-dd HH:mm:ss} [%thread] %-5level %logger{36} - %msg%n
            </Pattern>
        </encoder>
    </appender>
    <logger name="org.hibernate" level="error" additivity="false">
        <appender-ref ref="STDOUT"/>
    </logger>
    <root level="info">
        <appender-ref ref="STDOUT"/>
    </root>
</configuration>
```
