package cz.pavelstibal.messaging.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "service-bus")
@Data
public class ServiceBusProperties {
    private String url;
    private String username;
    private String password;
}
