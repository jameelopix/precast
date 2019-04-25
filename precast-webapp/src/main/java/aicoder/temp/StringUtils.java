package aicoder.temp;

public class StringUtils {
    public String getFirstCharUpper(String string) {
        return string.substring(0, 1).toUpperCase() + string.substring(1);
    }

    public String getFirstCharLower(String string) {
        return string.substring(0, 1).toLowerCase() + string.substring(1);
    }

    public String getLowerCase(String string) {
        return string.toLowerCase();
    }
}