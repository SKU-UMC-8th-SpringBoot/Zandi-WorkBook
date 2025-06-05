package umc.spring.config.properties;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@ConfigurationProperties("jwt.token")
public class JwtProperties {
    private String secretKey = "";
    private Expiration expiration;

    @Getter
    @Setter
    public static class Expiration{
        private Long access = 3600000L;
        // TODO : refreshToken
    }
    @PostConstruct
    public void debug() {
        System.out.println("🔥 [DEBUG] secretKey: " + secretKey);
        System.out.println("🔥 [DEBUG] expiration: " + expiration);
        System.out.println("🔥 [DEBUG] expiration.access: " + (expiration != null ? expiration.getAccess() : "null"));
    }

}
