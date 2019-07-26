package aicoder.temp;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.vme.precast.domain.LabourWorkEntry;

//import com.experian.domain.Project;

public class UIGenerator {

    Class entity = LabourWorkEntry.class;
    String entityName = entity.getSimpleName().replace("DTO", "");

    String projectBaseFolder = "c:\\finaltemp\\";

    Map<String, String> variableNameMap = new HashMap<>();
    String lowerCase = "_lowerCase";
    String upperCase = "_upperCase";
    String camelCase = "_camelCase";

    private void populateValue() {
        this.populateVariableMap("entityName", entityName);
        this.populateVariableMap("dto", entityName + "DTO");
    }

    public void populateVariableMap(String variable, String value) {
        variableNameMap.put(variable, value);
        variableNameMap.put(variable + lowerCase, value.toLowerCase());
        variableNameMap.put(variable + camelCase, getFirstCharLower(value));
    }

    public String getFirstCharUpper(String string) {
        return string.substring(0, 1).toUpperCase() + string.substring(1);
    }

    public String getFirstCharLower(String string) {
        return string.substring(0, 1).toLowerCase() + string.substring(1);
    }

    public String getLowerCase(String string) {
        return string.toLowerCase();
    }

    public UIGenerator() {
        this.populateValue();

        List<String> serviceCode = this.templateBuilder(this.readTemplateFile("UI_service_template.txt"),
                variableNameMap);
        List<String> compHtmlCode = this.templateBuilder(this.readTemplateFile("UI_component_html_template.txt"),
                variableNameMap);
        List<String> compTsCode = this.templateBuilder(this.readTemplateFile("UI_component_ts_template.txt"),
                variableNameMap);

        for (String string : serviceCode) {
            System.out.println(string);
        }
        System.out.println("--------------------------------------------------------------------------------");
        for (String string : compHtmlCode) {
            System.out.println(string);
        }
        System.out.println("--------------------------------------------------------------------------------");
        for (String string : compTsCode) {
            System.out.println(string);
        }
        System.out.println("--------------------------------------------------------------------------------");
    }

    private List<String> readTemplateFile(String fileName) {
        List<String> lines = new ArrayList<>();

        try {
            Path path = Paths.get(this.getClass().getClassLoader().getResource(fileName).toURI());
            lines = Files.readAllLines(path);
// Files.write(path, "jameel".getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lines;
    }

    public List<String> templateBuilder(List<String> templateLines, Map<String, String> valueMap) {
        List<String> output = new ArrayList<>();

        for (String templateLine : templateLines) {
            int startIndex = 0;
            int endIndex = 0;

            do {
// System.out.println("startIndex:" + startIndex);
                startIndex = templateLine.indexOf("{{", startIndex);
                if (startIndex != -1) {
                    endIndex = templateLine.indexOf("}}", startIndex);
                    String fieldName = templateLine.substring(startIndex + 2, endIndex).trim();
                    String pattern = templateLine.substring(startIndex, endIndex + 2);
                    String value = valueMap.get(fieldName);
                    if (value != null) {
                        templateLine = templateLine.replace(pattern, value);
// move start index to value length
                        startIndex += value.length();
                    } else {
// move start index to pattern length {{ fieldname }}
                        startIndex += pattern.length();
                    }
                }
            } while (startIndex != -1);
            output.add(templateLine);
// System.out.println(templateLine);
// System.out.println("-------------------");
        }
        return output;
    }

    public static void main(String[] args) {
// System.out.println("UIGenerator.main()");
        new UIGenerator();

//        Class cls = Element.class;
//        for (Field field : cls.getDeclaredFields()) {
//            System.out.println(field.getName());
//        }

    }
}