package bilodid.security25.config;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;
import java.util.OptionalInt;

/*
@author   машуля
@project   security25
@class  AuditorAwareImpl
@version  1.0.0
@since 29.11.2025 - 23.56
*/
public class AuditorAwareImpl implements AuditorAware<String> {


    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of(System.getProperty("user.name"));
    }
}