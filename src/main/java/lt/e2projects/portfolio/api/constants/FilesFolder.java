package lt.e2projects.portfolio.api.constants;

public enum FilesFolder {

    PROFILE_PICTURE("profile-pic"),
    CV("cv");

    String value;

    FilesFolder(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
