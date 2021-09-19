package lt.e2projects.portfolio.api.configurations;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties("firebase")
class FirebaseConfig {

    private String serviceAccountFile;
    private String databaseUrl;

}
