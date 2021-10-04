package lt.e2projects.portfolio.api.configurations;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("swagger")
class SwaggerProperties {

    private String version;
    private String title;
    private String description;

}
