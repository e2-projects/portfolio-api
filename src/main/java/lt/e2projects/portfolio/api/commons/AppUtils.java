package lt.e2projects.portfolio.api.commons;

import java.util.List;

public final class AppUtils {

    private AppUtils() { }

    public static boolean isNullOrEmpty(Object object) {
        if (object == null) {
            return true;
        } else if (object instanceof String) {
            return ((String) object).isBlank();
        } else if (object instanceof List) {
            return ((List<?>) object).isEmpty();
        }
        return false;
    }

    public static boolean isNotNullOrEmpty(Object object) {
        return !isNullOrEmpty(object);
    }

}
