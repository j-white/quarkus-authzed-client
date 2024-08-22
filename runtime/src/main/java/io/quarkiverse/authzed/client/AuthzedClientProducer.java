package io.quarkiverse.authzed.client;

import jakarta.annotation.PreDestroy;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Singleton;

import io.quarkiverse.authzed.runtime.config.AuthzedConfig;
import io.quarkus.arc.DefaultBean;
import io.quarkus.tls.TlsConfigurationRegistry;

@ApplicationScoped
public class AuthzedClientProducer {

    private AuthzedClient client;

    @DefaultBean
    @Singleton
    @Produces
    public AuthzedClient create(AuthzedConfig config, TlsConfigurationRegistry tlsRegistry) {
        client = new AuthzedClient(config, tlsRegistry);
        return client;
    }

    @PreDestroy
    public void destroy() {
        if (client != null) {
            try {
                client.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
