package lt.e2projects.portfolio.api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.cloud.firestore.annotation.Exclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lt.e2projects.portfolio.api.commons.AppUtils;

import java.util.HashMap;
import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SocialLinks implements FirebaseObject {

    private String linkedinUrl;
    private String facebookUrl;
    private String overflowUrl;
    private String githubUrl;

    @Exclude
    @JsonIgnore
    @Override
    public Map<String, Object> valuesMap() {
        var valuesMap = new HashMap<String, Object>();
        if (AppUtils.isNotNullOrEmpty(linkedinUrl)) {
            valuesMap.put("linkedinUrl", linkedinUrl);
        }
        if (AppUtils.isNotNullOrEmpty(facebookUrl)) {
            valuesMap.put("facebookUrl", facebookUrl);
        }
        if (AppUtils.isNotNullOrEmpty(overflowUrl)) {
            valuesMap.put("overflowUrl", overflowUrl);
        }
        if (AppUtils.isNotNullOrEmpty(githubUrl)) {
            valuesMap.put("githubUrl", githubUrl);
        }
        return valuesMap;
    }
}
