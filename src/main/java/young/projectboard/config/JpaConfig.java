package young.projectboard.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

@EnableJpaAuditing
@Configuration
public class JpaConfig { // Spring Boot에 DB와 JPA 사용할수있도록 의존성 추가
    @Bean
    public AuditorAware<String> auditorAware(){
        return () -> Optional.of("young"); // jpa auditing 할때마다 사람이름은 임의로 young으로 들어가게됨.
    }
}
