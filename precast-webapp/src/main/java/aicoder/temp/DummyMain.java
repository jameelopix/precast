package aicoder.temp;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;

import com.vme.precast.domain.Vendor;

//import com.experian.domain.Project;

public class DummyMain {

    Class entity = Vendor.class;
    String entityName = entity.getSimpleName();

    Map<String, String> variableNameMap = new HashMap<>();
    String lowerCase = "_lowerCase";
    String upperCase = "_upperCase";
    String camelCase = "_camelCase";

    private void populateValue() {
        this.populateVariableMap("entityName", entityName);
        this.populateVariableMap("dto", entityName + "DTO");
        this.populateVariableMap("searchDTO", entityName + "SearchDTO");
        this.populateVariableMap("serviceRequest", entityName + "ServiceRequest");
        this.populateVariableMap("serviceResponse", entityName + "ServiceResponse");
        this.populateVariableMap("service", entityName + "Service");
        this.populateVariableMap("component", entityName + "Component");
        this.populateVariableMap("componentImpl", entityName + "ComponentImpl");
        this.populateVariableMap("genericConvertor", entityName + "GenericConvertor");
        this.populateVariableMap("validator", entityName + "Validator");
        this.populateVariableMap("validatorImpl", entityName + "ValidatorImpl");
        this.populateVariableMap("controller", entityName + "Controller");
        this.populateVariableMap("clientModel", entityName + "ClientModel");
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

    public DummyMain() {
        this.populateValue();

        List<String> templateLines = getTemplateCode("controllerTemplate.txt");
        List<String> codeLines = this.templateBuilder(templateLines, variableNameMap);

        for (String string : codeLines) {
            System.out.println(string);
        }
    }

    public List<String> templateBuilder(List<String> templateLines, Map<String, String> valueMap) {
        List<String> output = new ArrayList<>();

        for (String templateLine : templateLines) {
            int startIndex = 0;
            int endIndex = 0;

            do {
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

    private List<String> getTemplateCode(String fileName) {
        List<String> codeLines = new ArrayList<String>();

        Scanner scanner;
        try {
            File file = new File(getClass().getClassLoader().getResource(fileName).getFile());
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                codeLines.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return codeLines;
    }

    private List<String> getTemplateCode1(String fileName) {
        List<String> codeLines = new ArrayList<String>();
        File file = new File(getClass().getClassLoader().getResource(fileName).getFile());
        Path dir = Paths.get(file.toURI());

        Consumer consumer = new Consumer() {

            @Override
            public void accept(Object t) {
                codeLines.add(t.toString());
            }
        };
        try {
            Files.lines(dir).forEach(consumer);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return codeLines;
    }

    public static void main(String[] args) {
        new DummyMain();
    }
}