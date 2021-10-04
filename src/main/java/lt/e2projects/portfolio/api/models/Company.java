package lt.e2projects.portfolio.api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.cloud.firestore.annotation.Exclude;
import io.netty.util.internal.StringUtil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Company implements FirebaseObject {

    @NotNull
    private String name;
    @NotNull
    private String url;

    @Override
    public Map<String, Object> getValuesMap() {
        var valuesMap = new HashMap<String, Object>();
        if (!StringUtil.isNullOrEmpty(name)) {
            valuesMap.put("name", name);
        }
        if (!StringUtil.isNullOrEmpty(url)) {
            valuesMap.put("url", url);
        }
        return valuesMap;
    }

}
