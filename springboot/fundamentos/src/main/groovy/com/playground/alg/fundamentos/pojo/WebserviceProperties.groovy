package com.playground.alg.fundamentos.pojo

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties(prefix = "webapp")
class WebserviceProperties {
    String username
    String apiKey
    String secret
    String url
    
    @Override
    String toString() {
        return "WebserviceProperties{ " +
            "username='${username}', " +
            "apiKey='${apiKey}', " +
            "secret='${secret}', " +
            "url='${url}' }"
    }
}
