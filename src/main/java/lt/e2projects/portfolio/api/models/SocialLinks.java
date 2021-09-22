package lt.e2projects.portfolio.api.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SocialLinks {

    private String linkedinUrl;
    private String facebookUrl;
    private String overflowUrl;
    private String githubUrl;

}
