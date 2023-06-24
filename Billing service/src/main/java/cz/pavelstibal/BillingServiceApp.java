package cz.pavelstibal;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Optional;

@SpringBootApplication
@Slf4j
@ImportResource("classpath:camel-config.xml")
public class BillingServiceApp {

    public static void main(final String[] args) {
        final SpringApplication app = new SpringApplication(BillingServiceApp.class);
        final Environment env = app.run(args).getEnvironment();
        logApplicationStartup(env);
    }

    public static void logApplicationStartup(final Environment env) {
        final String protocol = Optional.ofNullable(env.getProperty("server.ssl.key-store")).map(key -> "https").orElse("http");
        final String serverPort = env.getProperty("server.port");
        final String contextPath = Optional.ofNullable(env.getProperty("server.servlet.context-path"))
                .filter(StringUtils::isNotBlank)
                .orElse("/");

        String hostAddress = "localhost";
        try {
            hostAddress = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            log.warn("The host name could not be determined, using `localhost` as fallback");
        }

        log.info("""
                                              
                        ----------------------------------------------------------
                        Application '{}' is running! Access URLs:
                        Local: \t\t{}://localhost:{}{}
                        External: \t{}://{}:{}{}
                        ----------------------------------------------------------""",
                env.getProperty("spring.application.name"),
                protocol,
                serverPort,
                contextPath,
                protocol,
                hostAddress,
                serverPort,
                contextPath);
    }
}
