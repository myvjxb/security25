package bilodid.security25.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.mongodb.config.EnableMongoAuditing;


/*
@author   машуля
@project   security25
@class  AuditionConfig
@version  1.0.0
@since 29.11.2025 - 23.55
*/

@EnableMongoAuditing
@Configuration
public class AuditionConfig {
    @Bean
    public AuditorAware<String> auditorProvider() {
        return new AuditorAwareImpl();
    }

}
