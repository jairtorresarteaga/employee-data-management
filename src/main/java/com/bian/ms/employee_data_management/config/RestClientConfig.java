package com.bian.ms.employee_data_management.config;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManagerBuilder;
import org.apache.hc.client5.http.ssl.SSLConnectionSocketFactoryBuilder;
import org.apache.hc.core5.ssl.SSLContextBuilder;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.apache.hc.client5.http.ssl.TrustAllStrategy;


import javax.net.ssl.SSLContext;
import java.util.Collections;
@Configuration
public class RestClientConfig {
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) throws Exception {
        // Configurar SSL para confiar en todos los certificados
        SSLContext sslContext = SSLContextBuilder.create()
                .loadTrustMaterial(TrustAllStrategy.INSTANCE)
                .build();

        // Configurar SSLConnectionSocketFactory con el contexto SSL personalizado
        var sslSocketFactory = SSLConnectionSocketFactoryBuilder.create()
                .setSslContext(sslContext)
                .build();

        // Configurar PoolingHttpClientConnectionManagerBuilder para usar el SSLConnectionSocketFactory
        var connectionManager = PoolingHttpClientConnectionManagerBuilder.create()
                .setSSLSocketFactory(sslSocketFactory)
                .build();

        // Configurar HttpClient para usar el connectionManager
        var httpClient = HttpClients.custom()
                .setConnectionManager(connectionManager)
                .build();

        var requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);

        // Agregar un interceptor para configurar las cabeceras por defecto
        ClientHttpRequestInterceptor interceptor = (request, body, execution) -> {
            request.getHeaders().setContentType(MediaType.APPLICATION_JSON);
            request.getHeaders().setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
            return execution.execute(request, body);
        };
        // Construir y devolver un RestTemplate con el interceptor personalizado y la configuración SSL
        return builder
                .requestFactory(() -> requestFactory)
                .additionalInterceptors(interceptor)
                .build();
    }
}


