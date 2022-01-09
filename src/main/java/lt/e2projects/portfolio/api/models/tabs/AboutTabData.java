package lt.e2projects.portfolio.api.models.tabs;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.cloud.firestore.annotation.DocumentId;
import com.google.cloud.firestore.annotation.Exclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lt.e2projects.portfolio.api.models.FirebaseObject;

import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AboutTabData implements FirebaseObject {

    @DocumentId
    @JsonIgnore
    private String id;

    private String title;

    @NotNull
    private String content;

    @Exclude
    @JsonIgnore
    @Override
    public Map<String, Object> valuesMap() {
        return Collections.emptyMap();
    }
}
