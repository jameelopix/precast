package aicoder.temp;

public enum FileType {

    DTO("DTO", "api"), REPO("Repo", "repository"), COMPONENT("Component", "api");

    String fileSuffix;
    String packageSuffix;

    private FileType(String fileSuffix, String packageSuffix) {
        this.fileSuffix = fileSuffix;
        this.packageSuffix = packageSuffix;
    }

    public FileType get() {
        return this;
    }
}