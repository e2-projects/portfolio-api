package lt.e2projects.portfolio.api.models.tabs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lt.e2projects.portfolio.api.commons.AppUtils;
import lt.e2projects.portfolio.api.models.Company;
import lt.e2projects.portfolio.api.models.FirebaseObject;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HomeTabData implements FirebaseObject {

    @NotNull
    private String fullName;
    @NotNull
    private String position;
    @NotNull
    private String address;
    @NotNull
    private String description;
    @NotNull
    private Company company;

    @Override
    public Map<String, Object> getValuesMap() {
        var valuesMap = new HashMap<String, Object>();
        if (AppUtils.isNotNullOrEmpty(fullName)) {
            valuesMap.put("fullName", fullName);
        }
        if (AppUtils.isNotNullOrEmpty(position)) {
            valuesMap.put("position", position);
        }
        if (AppUtils.isNotNullOrEmpty(address)) {
            valuesMap.put("address", address);
        }
        if (AppUtils.isNotNullOrEmpty(description)) {
            valuesMap.put("description", description);
        }
        if (company != null && (AppUtils.isNotNullOrEmpty(company.getName()) || AppUtils.isNotNullOrEmpty(company.getUrl()))) {
            var companyValues = company.getValuesMap();
            if (!companyValues.isEmpty()) {
                valuesMap.put("company", companyValues);
            }
        }
        return valuesMap;
    }
}
