package aicoder.temp;

import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.vme.precast.domain.Element;

//import com.experian.domain.Project;

public class UIGenerator2 {

    Class entity = Element.class;
    String entityName = entity.getSimpleName().replace("DTO", "");

    public UIGenerator2() {
        this.populateValue();

        populateSearchBlock(entity);
        populateInputBlock(entity);

        List<String> finalCode = this.templateBuilder(this.readTemplateFile("UI_screen_template.txt"), variableNameMap);
        for (String string : finalCode) {
            System.out.println(string);
        }
//        System.out.println("--------------------------------------------------------------------------------");
    }

    private void populateSearchBlock(Class cls) {
        populateSearchInputCode(cls);

        StringBuilder searchCodeBuilder = new StringBuilder();

        List<String> searchBlock = this.templateBuilder(this.readTemplateFile("UI_search_section_template.txt"),
                variableNameMap);

        for (String string : searchBlock) {
            searchCodeBuilder.append(string);
        }

        this.populateVariableMap("searchBlock", searchCodeBuilder.toString());
    }

    private void populateInputBlock(Class cls) {
        populateInputCode(cls);

        StringBuilder searchCodeBuilder = new StringBuilder();

        List<String> searchBlock = this.templateBuilder(this.readTemplateFile("UI_input_section_template.txt"),
                variableNameMap);

        for (String string : searchBlock) {
            searchCodeBuilder.append(string);
        }

        this.populateVariableMap("inputBlock", searchCodeBuilder.toString());
    }

    private void populateInputCode(Class cls) {
        StringBuilder searchCodeBuilder = new StringBuilder();
        for (Field field : cls.getDeclaredFields()) {
            if ("serialVersionUID".equalsIgnoreCase(field.getName())) {
                continue;
            }
            if ("id".equalsIgnoreCase(field.getName())) {
                continue;
            }
            List<String> searchCode = null;
            if (this.isWrapperObject(field)) {
                this.populateVariableMap("fieldName", field.getName());
                searchCode = this.templateBuilder(this.readTemplateFile("UI_input_template.txt"), variableNameMap);
            } else {
                this.populateVariableMap("fieldName", field.getType().getSimpleName());
                searchCode = this.templateBuilder(this.readTemplateFile("UI_dropdown_template.txt"), variableNameMap);
            }
            for (String string : searchCode) {
                searchCodeBuilder.append(string);
            }
        }
        this.populateVariableMap("inputParts", searchCodeBuilder.toString());
    }

    private void populateSearchInputCode(Class cls) {
        StringBuilder searchCodeBuilder = new StringBuilder();
        for (Field field : cls.getDeclaredFields()) {
            if ("serialVersionUID".equalsIgnoreCase(field.getName())) {
                continue;
            }
            if (!this.isWrapperObject(field)) {
                this.populateVariableMap("fieldName", field.getType().getSimpleName());

                List<String> searchCode = this.templateBuilder(this.readTemplateFile("UI_search_input_template.txt"),
                        variableNameMap);

                for (String string : searchCode) {
                    searchCodeBuilder.append(string);
                }

            }
        }
        this.populateVariableMap("searchParts", searchCodeBuilder.toString());
    }

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

    private boolean isWrapperObject(Field field) {
        switch (field.getType().getSimpleName()) {
        case "String":
            return true;
        case "Long":
            return true;
        default:
            break;
        }
        return false;
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
        new UIGenerator2();

    }

}