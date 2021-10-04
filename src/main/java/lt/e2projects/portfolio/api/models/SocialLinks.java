package lt.e2projects.portfolio.api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.cloud.firestore.annotation.Exclude;
import com.google.cloud.firestore.annotation.IgnoreExtraProperties;
import io.netty.util.internal.StringUtil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @Override
    public Map<String, Object> getValuesMap() {
        var valuesMap = new HashMap<String, Object>();
        if (!StringUtil.isNullOrEmpty(linkedinUrl)) {
            valuesMap.put("linkedinUrl", linkedinUrl);
        }
        if (!StringUtil.isNullOrEmpty(facebookUrl)) {
            valuesMap.put("facebookUrl", facebookUrl);
        }
        if (!StringUtil.isNullOrEmpty(overflowUrl)) {
            valuesMap.put("overflowUrl", overflowUrl);
        }
        if (!StringUtil.isNullOrEmpty(githubUrl)) {
            valuesMap.put("githubUrl", githubUrl);
        }
        return valuesMap;
    }
}
