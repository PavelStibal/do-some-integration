package cz.pavelstibal.messaging.config;

import lombok.RequiredArgsConstructor;
import org.apache.camel.component.amqp.AMQPComponent;
import org.apache.qpid.jms.JmsConnectionFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;

@Configuration
@EnableJms
@RequiredArgsConstructor
@EnableConfigurationProperties({ServiceBusProperties.class})
public class JmsCommonConfiguration {

    @Bean
    public AMQPComponent amqpComponent(ServiceBusProperties serviceBusProperties) {
        return new AMQPComponent(jmsConnectionFactory(serviceBusProperties));
    }

    @Bean
    public JmsConnectionFactory jmsConnectionFactory(ServiceBusProperties serviceBusProperties) {
        final JmsConnectionFactory factory = new JmsConnectionFactory();
        factory.setRemoteURI(serviceBusProperties.getUrl());
        factory.setUsername(serviceBusProperties.getUsername());
        factory.setPassword(serviceBusProperties.getPassword());
        return factory;
    }

}
