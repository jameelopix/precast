package aicoder.temp;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.vme.precast.domain.Vendor;

//import com.experian.domain.Project;

public class DummyMain {
    private static final String REPO = "Repo";
    FileUtils fileUtils = new FileUtils();
    StringUtils stringUtils = new StringUtils();

    private static final String CLIENT_MODEL = "ClientModel";
    private static final String CONTROLLER = "Controller";
    private static final String VALIDATOR_IMPL = "ValidatorImpl";
    private static final String VALIDATOR = "Validator";
    private static final String GENERIC_CONVERTOR = "GenericConvertor";
    private static final String COMPONENT_IMPL = "ComponentImpl";
    private static final String COMPONENT = "Component";
    private static final String SERVICE = "Service";
    private static final String SERVICE_RESPONSE = "ServiceResponse";
    private static final String SERVICE_REQUEST = "ServiceRequest";
    private static final String SEARCH_DTO = "SearchDTO";
    private static final String DTO = "DTO";

    Class entity = Vendor.class;
    String entityName = entity.getSimpleName();

    Map<String, String> variableNameMap = new HashMap<>();
    String lowerCase = "_lowerCase";
    String upperCase = "_upperCase";
    String camelCase = "_camelCase";

    private void populateValue() {
        this.populateVariableMap("entityName", entityName);
        this.populateVariableMap("repo", entityName + REPO);
        this.populateVariableMap("dto", entityName + DTO);
        this.populateVariableMap("searchDTO", entityName + SEARCH_DTO);
        this.populateVariableMap("serviceRequest", entityName + SERVICE_REQUEST);
        this.populateVariableMap("serviceResponse", entityName + SERVICE_RESPONSE);
        this.populateVariableMap("service", entityName + SERVICE);
        this.populateVariableMap("component", entityName + COMPONENT);
        this.populateVariableMap("componentImpl", entityName + COMPONENT_IMPL);
        this.populateVariableMap("genericConvertor", entityName + GENERIC_CONVERTOR);
        this.populateVariableMap("validator", entityName + VALIDATOR);
        this.populateVariableMap("validatorImpl", entityName + VALIDATOR_IMPL);
        this.populateVariableMap("controller", entityName + CONTROLLER);
        this.populateVariableMap("clientModel", entityName + CLIENT_MODEL);
    }

    public void populateVariableMap(String variable, String value) {
        variableNameMap.put(variable, value);
        variableNameMap.put(variable + lowerCase, value.toLowerCase());
        variableNameMap.put(variable + camelCase, stringUtils.getFirstCharLower(value));
    }

    private void saveFile(List<String> code, String dirPath, String fileName) {
        StringBuilder finalString = new StringBuilder();
        for (String string : code) {
            finalString.append(string);
        }

        try {
            fileUtils.createDirectory(dirPath);

            File file = fileUtils.createFile(dirPath, fileName);

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(finalString.toString());
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public DummyMain() {
        this.populateValue();

        List<String> templateLines = getTemplateCode("controllerTemplate.txt");
        List<String> codeLines = this.templateBuilder(templateLines, variableNameMap);
// saveFile(codeLines, folder_controller, entityName + controllerFile_suffix +
// JAVA);

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

//    private List<String> getTemplateCode1(String fileName) {
//        List<String> codeLines = new ArrayList<String>();
//        File file = new File(getClass().getClassLoader().getResource(fileName).getFile());
//        Path dir = Paths.get(file.toURI());
//
//        Consumer consumer = new Consumer() {
//
//            @Override
//            public void accept(Object t) {
//                codeLines.add(t.toString());
//            }
//        };
//        try {
//            Files.lines(dir).forEach(consumer);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return codeLines;
//    }

    public static void main(String[] args) {
        new DummyMain();
    }
}