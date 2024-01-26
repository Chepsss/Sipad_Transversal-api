package it.almaviva.difesa.sipad.shared;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

@Configuration
@EnableJpaAuditing
public class JpaAuditingConfiguration implements AuditorAware<String>{

    @Override
    public Optional<String> getCurrentAuditor() {
      /*  var securityContext = SecurityContextHolder.getContext();
        return Optional.ofNullable(securityContext.getAuthentication()).map(authentication -> {
            if(authentication.getPrincipal() instanceof UserDetails){
                var userDetails = (UserDetails) authentication.getPrincipal();
                return userDetails.getUsername();
            }else if(authentication.getPrincipal() instanceof String){
                return (String) authentication.getPrincipal();
            }
            return "SYSTEM";
        });*/
        return null;
    }
}