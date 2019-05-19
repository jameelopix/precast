package aicoder.temp;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.vme.precast.domain.AccountDetails;

//import com.experian.domain.Project;

public class AppMain {

    Class entity = AccountDetails.class;
    String entityName = entity.getSimpleName();

    Map<String, String> variableNameMap = new HashMap<>();
    String lowerCase = "_lowerCase";
    String upperCase = "_upperCase";
    String camelCase = "_camelCase";

    String repoFile_suffix = "Repo";
    String componentFile_suffix = "Component";
    String componentImplFile_suffix = "ComponentImpl";
    String serviceFile_suffix = "Service";
    String serviceRequestFile_suffix = "ServiceRequest";
    String serviceResponseFile_suffix = "ServiceResponse";
    String validatorFile_suffix = "Validator";
    String dtoFile_suffix = "DTO";
    String searchDtoFile_suffix = "SearchDTO";
    String validatorImplFile_suffix = "ValidatorImpl";
    String genericConvertorFile_suffix = "GenericConvertor";
    String controllerFile_suffix = "Controller";
    String clientModelFile_suffix = "ClientModel";
    String configFile_suffix = "_config";
    String flowFile_suffix = "_flow";

    String JAVA = ".java";
    String XML = ".xml";

    String projectBaseFolder = "D:\\final\\vme\\";

    String webappFolder = "precast-webapp\\";
    String repositoryFolder = "precast-repository\\";
    String serviceFolder = "precast-service\\";
    String apiFolder = "precast-service-api\\";
    String implFolder = "precast-service-impl\\";

    String javaSrcFolder = "src\\main\\java\\";
    String javaResourcesFolder = "src\\main\\resources\\";

    String packagePrefixFolder = "com\\vme\\precast\\";

    String packageSuffixFolder_repository = "repository\\";
    String packageSuffixFolder_api = "api\\";
    String packageSuffixFolder_impl = "impl\\";
    String packageSuffixFolder_webapp = "controller\\";

    String separator = "\\";

    String folder_controller = null;
    String folder_api = null;
    String folder_impl = null;
    String folder_repository = null;
    String folder_config = null;
    String folder_process = null;

    String file_controller = null;
    String file_clientmodel = null;
    String file_component = null;
    String file_componentimpl = null;
    String file_validator = null;
    String file_validatorimpl = null;
    String file_service = null;
    String file_dto = null;
    String file_servicerequest = null;
    String file_serviceresponse = null;
    String file_config = null;
    String file_createxml = null;
    String file_updatexml = null;
    String file_deletexml = null;
    String file_getxml = null;

    private void populateValue() {
        this.populateVariableMap("entityName", entityName);
        this.populateVariableMap("dto", entityName + "DTO");
        this.populateVariableMap("repo", entityName + "Repo");
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
        this.populateVariableMap("conversionUtility", "ConversionUtility");
//        ConversionUtility
    }

    private void populateFolderName() {
        folder_controller = projectBaseFolder + webappFolder + javaSrcFolder + packagePrefixFolder
                + variableNameMap.get("entityName_lowerCase") + separator + packageSuffixFolder_webapp;

        folder_api = projectBaseFolder + serviceFolder + apiFolder + javaSrcFolder + packagePrefixFolder
                + variableNameMap.get("entityName_lowerCase") + separator + packageSuffixFolder_api;

        folder_impl = projectBaseFolder + serviceFolder + implFolder + javaSrcFolder + packagePrefixFolder
                + variableNameMap.get("entityName_lowerCase") + separator + packageSuffixFolder_impl;

        folder_config = projectBaseFolder + serviceFolder + implFolder + javaResourcesFolder + packagePrefixFolder
                + variableNameMap.get("entityName_lowerCase") + separator;

        folder_process = projectBaseFolder + serviceFolder + implFolder + javaResourcesFolder + packagePrefixFolder
                + variableNameMap.get("entityName_lowerCase") + separator + "process\\";

        folder_repository = projectBaseFolder + repositoryFolder + javaSrcFolder + packagePrefixFolder
                + packageSuffixFolder_repository;
    }

    public AppMain() {
        this.populateValue();
        this.populateFolderName();

//        for (String key : variableNameMap.keySet()) {
//            System.out.println(key + "    :    " + variableNameMap.get(key));
//        }

        List<String> repoCode = this.templateBuilder(Arrays.asList(repoTemplate), variableNameMap);

        List<String> componentCode = this.templateBuilder(Arrays.asList(componentTemplate), variableNameMap);
        List<String> serviceCode = this.templateBuilder(Arrays.asList(serviceTemplate), variableNameMap);
        List<String> serviceRequestCode = this.templateBuilder(Arrays.asList(serviceRequestTemplate), variableNameMap);
        List<String> serviceResponseCode = this.templateBuilder(Arrays.asList(serviceResponseTemplate),
                variableNameMap);
        List<String> validatorCode = this.templateBuilder(Arrays.asList(validatorTemplate), variableNameMap);
        List<String> dtoCode = constructDtoCode();
        List<String> searchDtoCode = constructSearchDtoCode();

        List<String> genericConvertorcode = constructGenericConvertor();
        List<String> componentImplCode = constructComponentImplCode();
        List<String> validatorImplCode = constructValidatorImplCode();

        List<String> controllerCode = this.templateBuilder(Arrays.asList(controllerTemplate), variableNameMap);
        List<String> clientModelCode = this.templateBuilder(Arrays.asList(clientModelTemplate), variableNameMap);

        List<String> configXmlcode = this.templateBuilder(Arrays.asList(configXmlTemplate), variableNameMap);
        List<String> createXmlcode = this.templateBuilder(Arrays.asList(createXml), variableNameMap);
        List<String> updatexmlcode = this.templateBuilder(Arrays.asList(updatexml), variableNameMap);
        List<String> deletexmlcode = this.templateBuilder(Arrays.asList(deletexml), variableNameMap);
        List<String> getxmlcode = this.templateBuilder(Arrays.asList(getxml), variableNameMap);

        saveFile(repoCode, folder_repository, entityName + repoFile_suffix + JAVA);

        saveFile(componentCode, folder_api, entityName + componentFile_suffix + JAVA);
        saveFile(serviceCode, folder_api, entityName + serviceFile_suffix + JAVA);
        saveFile(serviceRequestCode, folder_api, entityName + serviceRequestFile_suffix + JAVA);
        saveFile(serviceResponseCode, folder_api, entityName + serviceResponseFile_suffix + JAVA);
        saveFile(validatorCode, folder_api, entityName + validatorFile_suffix + JAVA);
        saveFile(dtoCode, folder_api, entityName + dtoFile_suffix + JAVA);
        saveFile(searchDtoCode, folder_api, entityName + searchDtoFile_suffix + JAVA);

        saveFile(genericConvertorcode, folder_impl, entityName + genericConvertorFile_suffix + JAVA);
        saveFile(componentImplCode, folder_impl, entityName + componentImplFile_suffix + JAVA);
        saveFile(validatorImplCode, folder_impl, entityName + validatorImplFile_suffix + JAVA);

        saveFile(controllerCode, folder_controller, entityName + controllerFile_suffix + JAVA);
        saveFile(clientModelCode, folder_controller, entityName + clientModelFile_suffix + JAVA);

        saveFile(configXmlcode, folder_config, entityName.toLowerCase() + configFile_suffix + XML);
        saveFile(createXmlcode, folder_process, "create" + entityName.toLowerCase() + flowFile_suffix + XML);
        saveFile(updatexmlcode, folder_process, "update" + entityName.toLowerCase() + flowFile_suffix + XML);
        saveFile(deletexmlcode, folder_process, "delete" + entityName.toLowerCase() + flowFile_suffix + XML);
        saveFile(getxmlcode, folder_process, "get" + entityName.toLowerCase() + "s" + flowFile_suffix + XML);
    }

    private List<String> constructDtoCode() {
        List<String> code = this.templateBuilder(Arrays.asList(dtoHeaderTemplate), variableNameMap);

        for (Field field : entity.getDeclaredFields()) {
            if (!"serialVersionUID".equals(field.getName())) {
                StringBuilder sb = new StringBuilder("private ");
                sb.append(field.getType().getSimpleName());
                sb.append(" ");
                sb.append(getFirstCharLower(field.getName()));
                sb.append(";");
                sb.append(System.lineSeparator());
                code.add(sb.toString());
            }
        }
        code.add(footerTemplate);
        return code;
    }

    private List<String> constructSearchDtoCode() {
        List<String> code = this.templateBuilder(Arrays.asList(searchDtoHeaderTemplate), variableNameMap);

        for (Field field : entity.getDeclaredFields()) {
            if (!"serialVersionUID".equals(field.getName())) {
                StringBuilder sb = new StringBuilder("private List<");
                sb.append(field.getType().getSimpleName());
                sb.append("> ");
                sb.append(getFirstCharLower(field.getName()));
                sb.append("List;");
                sb.append(System.lineSeparator());
                code.add(sb.toString());
            }
        }
        code.add("\r\n");

        for (Field field : entity.getDeclaredFields()) {
            if (!"serialVersionUID".equals(field.getName())) {
                StringBuilder sb = new StringBuilder("public static String ");
                sb.append(field.getName().toUpperCase());
                sb.append(" = \"");
                sb.append(field.getName());
                sb.append("\";");
                sb.append(System.lineSeparator());
                code.add(sb.toString());
            }
        }
        code.add("\r\n");
        code.add(footerTemplate);
        return code;
    }

    private List<String> constructValidatorImplCode() {
        List<String> code = this.templateBuilder(Arrays.asList(validatorImplTemplate), variableNameMap);
        return code;
    }

    private List<String> constructComponentImplCode() {
        List<String> code = this.templateBuilder(Arrays.asList(componentImplTemplate), variableNameMap);
        return code;
    }

    private void saveFile1(List<String> code, String dirPath, String fileName) {
        dirPath = "C:\\myGithub\\precast\\precast-webapp\\src\\main\\java\\aicoder\\temp\\dummy\\";
        System.out.println(dirPath + fileName);

        StringBuilder finalString = new StringBuilder();
        for (String string : code) {
            finalString.append(string);
        }

        File directory = new File(String.valueOf(dirPath));
        try {
            if (!directory.exists()) {
                directory.mkdir();
            }
            File file = new File(String.valueOf(dirPath + fileName));
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(finalString.toString());
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveFile(List<String> code, String dirPath, String fileName) {
        StringBuilder finalString = new StringBuilder();
        for (String string : code) {
            finalString.append(string);
        }

        try {
            String path[] = dirPath.split("\\\\");
            String baseDirPath = "";
            for (String string : path) {
                baseDirPath += string + "\\";
                File directory = new File(String.valueOf(baseDirPath));
                if (!directory.exists()) {
                    Path dir = Paths.get(directory.toURI());
                    System.out.println(Files.createDirectory(dir));
                }
            }

            File file = new File(String.valueOf(dirPath + fileName));
//            if (!file.exists()) {
//                Path fileuri = Paths.get(file.toURI());
//                System.out.println(Files.createFile(fileuri));
//            }

            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(finalString.toString());
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<String> constructGenericConvertor() {
        List<String> code = this.templateBuilder(Arrays.asList(genericConvertorTemplate), variableNameMap);

        for (Field field : entity.getDeclaredFields()) {
            if (!"serialVersionUID".equals(field.getName())) {
                StringBuilder sb = new StringBuilder("target.set");
                sb.append(getFirstCharUpper(field.getName()));
                sb.append("(source.get");
                sb.append(getFirstCharUpper(field.getName()));
                sb.append("());");
                sb.append(System.lineSeparator());
                code.add(sb.toString());
            }
        }
        return code;
    }

    private StringBuilder constructSearchDTO(Class entity, Map<String, String> variableNameMap) {
        StringBuilder builder = new StringBuilder();

        List<String> dtoHeaderLines = this.templateBuilder(Arrays.asList(searchDtoHeaderTemplate), variableNameMap);
        for (String dtoHeaderLine : dtoHeaderLines) {
            builder.append(dtoHeaderLine);
        }
        builder.append("\n");

        for (Field field : entity.getDeclaredFields()) {
            builder.append("private");
            if (Modifier.isStatic(field.getModifiers())) {
                builder.append(" ");
                builder.append("static");
            }
            if (Modifier.isFinal(field.getModifiers())) {
                builder.append(" ");
                builder.append("final");
            }
            builder.append(" ");
            builder.append(field.getType().getSimpleName());
            builder.append(" ");
            builder.append(field.getName());
            if ("serialVersionUID".equals(field.getName())) {
                builder.append(" = 1L");
            }
            builder.append(";");
            builder.append("\n");
        }
        builder.append("\n");

        for (Field field : entity.getDeclaredFields()) {
            if (!"serialVersionUID".equals(field.getName())) {
                StringBuilder sb = new StringBuilder("public static String ");
                sb.append(field.getName().toUpperCase());
                sb.append(" = \"");
                sb.append(field.getName());
                sb.append("\";\n");
                builder.append(sb.toString());
            }
        }

        for (Field field : entity.getDeclaredFields()) {
            if (!"serialVersionUID".equals(field.getName())) {
                Map<String, String> fieldMap = new HashMap<>();
                fieldMap.put("fieldName", getFirstCharUpper(field.getName()));
                fieldMap.put("fieldName_camelCase", field.getName());
                fieldMap.put("type", field.getType().getSimpleName());

                List<String> getterCode = this.templateBuilder(Arrays.asList(getterTemplate), fieldMap);
                List<String> setterCode = this.templateBuilder(Arrays.asList(setterTemplate), fieldMap);
                for (String string : getterCode) {
                    builder.append(string);
                    builder.append("\n");
                }
                for (String string : setterCode) {
                    builder.append(string);
                    builder.append("\n");
                }

            }
        }
        builder.append(footerTemplate);
        return builder;
    }

    private StringBuilder constructDTO(Class entity, Map<String, String> variableNameMap) {
        StringBuilder builder = new StringBuilder();

        List<String> dtoHeaderLines = this.templateBuilder(Arrays.asList(dtoHeaderTemplate), variableNameMap);
        for (String dtoHeaderLine : dtoHeaderLines) {
            builder.append(dtoHeaderLine);
        }
        builder.append("\n");

        for (Field field : entity.getDeclaredFields()) {
            builder.append("private");
            if (Modifier.isStatic(field.getModifiers())) {
                builder.append(" ");
                builder.append("static");
            }
            if (Modifier.isFinal(field.getModifiers())) {
                builder.append(" ");
                builder.append("final");
            }
            builder.append(" ");
            builder.append(field.getType().getSimpleName());
            builder.append(" ");
            builder.append(field.getName());
            if ("serialVersionUID".equals(field.getName())) {
                builder.append(" = 1L");
            }
            builder.append(";");
            builder.append("\n");
        }
        builder.append("\n");
        for (Field field : entity.getDeclaredFields()) {
            if (!"serialVersionUID".equals(field.getName())) {
                Map<String, String> fieldMap = new HashMap<>();
                fieldMap.put("fieldName", getFirstCharUpper(field.getName()));
                fieldMap.put("fieldName_camelCase", field.getName());
                fieldMap.put("type", field.getType().getSimpleName());

                List<String> getterCode = this.templateBuilder(Arrays.asList(getterTemplate), fieldMap);
                List<String> setterCode = this.templateBuilder(Arrays.asList(setterTemplate), fieldMap);
                for (String string : getterCode) {
                    builder.append(string);
                    builder.append("\n");
                }
                for (String string : setterCode) {
                    builder.append(string);
                    builder.append("\n");
                }

            }
        }
        builder.append(footerTemplate);
        return builder;
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

    public static void main(String[] args) {
//        String word = "refer";
//
//        StringBuilder sb = new StringBuilder();
//        for (int i = word.length() - 1; i >= 0; i--) {
//            sb.append(word.charAt(i));
//        }
//        String reverse = sb.toString();
//
//        System.out.println(word.toLowerCase().equals(reverse.toLowerCase()));

        new AppMain();
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

    private static String serviceRequestTemplate = "package com.vme.precast.{{entityName_lowerCase}}.api;\r\n" + "\r\n"
            + "import coliseum.service.BaseServiceRequest;\r\n" + "\r\n"
            + "public class {{serviceRequest}} extends BaseServiceRequest {\r\n" + "\r\n"
            + " private static final long serialVersionUID = 1L;\r\n" + "\r\n"
            + " private {{dto}} {{dto_camelCase}};\r\n" + "\r\n" + " private {{searchDTO}} {{searchDTO_camelCase}};\r\n"
            + "\r\n" + " public {{dto}} get{{dto}}() {\r\n" + " return {{dto_camelCase}};\r\n" + " }\r\n" + "\r\n"
            + " public void set{{dto}}({{dto}} {{dto_camelCase}}) {\r\n"
            + " this.{{dto_camelCase}} = {{dto_camelCase}};\r\n" + " }\r\n" + "\r\n"
            + " public {{searchDTO}} get{{searchDTO}}() {\r\n" + " return {{searchDTO_camelCase}};\r\n" + " }\r\n"
            + "\r\n" + " public void set{{searchDTO}}({{searchDTO}} {{searchDTO_camelCase}}) {\r\n"
            + " this.{{searchDTO_camelCase}} = {{searchDTO_camelCase}};\r\n" + " }\r\n" + "}\r\n" + "";

    private static String serviceResponseTemplate = "package com.vme.precast.{{entityName_lowerCase}}.api;\r\n" + "\r\n"
            + "import java.util.List;\r\n" + "\r\n" + "import coliseum.service.BaseServiceResponse;\r\n" + "\r\n"
            + "public class {{serviceResponse}} extends BaseServiceResponse {\r\n" + "\r\n"
            + " private static final long serialVersionUID = 1L;\r\n" + "\r\n"
            + " private List<{{dto}}> {{dto_camelCase}}List;\r\n" + "\r\n"
            + " public List<{{dto}}> get{{dto}}List() {\r\n" + " return {{dto_camelCase}}List;\r\n" + " }\r\n" + "\r\n"
            + " public void set{{dto}}List(List<{{dto}}> {{dto_camelCase}}List) {\r\n"
            + " this.{{dto_camelCase}}List = {{dto_camelCase}}List;\r\n" + " }\r\n" + "}";

    private static String serviceTemplate = "package com.vme.precast.{{entityName_lowerCase}}.api;\r\n" + "\r\n"
            + "import coliseum.service.BaseService;\r\n" + "import coliseum.service.FlowDescriptor;\r\n" + "\r\n"
            + "public interface {{service}} extends BaseService {\r\n" + "\r\n"
            + " @FlowDescriptor(flow = \"create{{entityName_lowerCase}}\", request = \"{{serviceRequest_camelCase}}\", response = \"{{serviceResponse_camelCase}}\")\r\n"
            + " public {{serviceResponse}} create{{entityName}}({{serviceRequest}} {{serviceRequest_camelCase}});\r\n"
            + "\r\n"
            + " @FlowDescriptor(flow = \"get{{entityName_lowerCase}}s\", request = \"{{serviceRequest_camelCase}}\", response = \"{{serviceResponse_camelCase}}\")\r\n"
            + " public {{serviceResponse}} get{{entityName}}s({{serviceRequest}} {{serviceRequest_camelCase}});\r\n"
            + "\r\n"
            + " @FlowDescriptor(flow = \"update{{entityName_lowerCase}}\", request = \"{{serviceRequest_camelCase}}\", response = \"{{serviceResponse_camelCase}}\")\r\n"
            + " public {{serviceResponse}} update{{entityName}}({{serviceRequest}} {{serviceRequest_camelCase}});\r\n"
            + "\r\n"
            + " @FlowDescriptor(flow = \"delete{{entityName_lowerCase}}\", request = \"{{serviceRequest_camelCase}}\", response = \"{{serviceResponse_camelCase}}\")\r\n"
            + " public {{serviceResponse}} delete{{entityName}}({{serviceRequest}} {{serviceRequest_camelCase}});\r\n"
            + "}";

    private static String validatorTemplate = "package com.vme.precast.{{entityName_lowerCase}}.api;\r\n" + "\r\n"
            + "import coliseum.service.ColiseumInterface;\r\n" + "import coliseum.service.ErrorDTO;\r\n" + "\r\n"
            + "public interface {{validator}} extends ColiseumInterface {\r\n" + "\r\n"
            + " public ErrorDTO check{{entityName}}Duplicate({{serviceRequest}} {{serviceRequest_camelCase}});\r\n"
            + "}\r\n" + "";

    private static String repoTemplate = "package com.vme.precast.repository;\r\n" + "\r\n"
            + "import org.springframework.stereotype.Repository;\r\n" + "\r\n"
            + "import com.vme.precast.domain.{{entityName}};\r\n" + "\r\n" + "import coliseum.jpa.repo.BaseRepo;\r\n"
            + "\r\n" + "@Repository\r\n"
            + "public interface {{entityName}}Repo extends BaseRepo<{{entityName}}, Long> {\r\n" + "}\r\n" + "";

    private static String componentTemplate = "package com.vme.precast.{{entityName_lowerCase}}.api;\r\n" + "\r\n"
            + "import coliseum.service.ColiseumInterface;\r\n" + "\r\n"
            + "public interface {{component}} extends ColiseumInterface {\r\n" + "\r\n"
            + " public {{serviceResponse}} create{{entityName}}({{serviceRequest}} {{serviceRequest_camelCase}});\r\n"
            + "\r\n"
            + " public {{serviceResponse}} get{{entityName}}s({{serviceRequest}} {{serviceRequest_camelCase}});\r\n"
            + "\r\n"
            + " public {{serviceResponse}} update{{entityName}}({{serviceRequest}} {{serviceRequest_camelCase}});\r\n"
            + "\r\n"
            + " public {{serviceResponse}} delete{{entityName}}({{serviceRequest}} {{serviceRequest_camelCase}});\r\n"
            + "}\r\n" + "";

    private static String validatorImplTemplate = "package com.vme.precast.{{entityName_lowerCase}}.impl;\r\n" + "\r\n"
            + "import org.springframework.beans.factory.annotation.Autowired;\r\n" + "\r\n"
            + "import com.vme.precast.{{entityName_lowerCase}}.api.{{serviceRequest}};\r\n"
            + "import com.vme.precast.{{entityName_lowerCase}}.api.{{entityName}}Validator;\r\n"
            + "import com.vme.precast.repository.{{repo}};\r\n" + "\r\n" + "import coliseum.service.ErrorDTO;\r\n"
            + "\r\n" + "public class {{entityName}}ValidatorImpl implements {{entityName}}Validator {\r\n"
            + " @Autowired\r\n" + " {{repo}} {{repo_camelCase}};\r\n" + "\r\n" + " @Override\r\n"
            + " public ErrorDTO check{{entityName}}Duplicate({{serviceRequest}} {{serviceRequest_camelCase}}) {\r\n"
            + " return null;\r\n" + " }\r\n" + "}";

    private static String componentImplTemplate = "package com.vme.precast.{{entityName_lowerCase}}.impl;\r\n" + "\r\n"
            + "import java.util.ArrayList;\r\n" + "import java.util.List;\r\n" + "\r\n"
            + "import org.apache.commons.collections4.CollectionUtils;\r\n"
            + "import org.springframework.beans.factory.annotation.Autowired;\r\n" + "\r\n"
            + "import com.vme.precast.domain.{{entityName}};\r\n"
            + "import com.vme.precast.repository.{{entityName}}Repo;\r\n"
            + "import com.vme.precast.{{entityName_lowerCase}}.api.{{entityName}}Component;\r\n"
            + "import com.vme.precast.{{entityName_lowerCase}}.api.{{dto}};\r\n"
            + "import com.vme.precast.{{entityName_lowerCase}}.api.{{entityName}}SearchDTO;\r\n"
            + "import com.vme.precast.{{entityName_lowerCase}}.api.{{serviceRequest}};\r\n"
            + "import com.vme.precast.{{entityName_lowerCase}}.api.{{serviceResponse}};\r\n" + "\r\n"
            + "import coliseum.jpa.Filter;\r\n" + "import coliseum.jpa.SearchObject;\r\n"
            + "import coliseum.service.ConversionUtility;\r\n" + "import coliseum.service.FilterUtils;\r\n" + "\r\n"
            + "public class {{entityName}}ComponentImpl implements {{entityName}}Component {\r\n" + " @Autowired\r\n"
            + " {{entityName}}Repo {{repo_camelCase}};\r\n" + "\r\n" + " @Autowired\r\n"
            + " {{conversionUtility}} {{conversionUtility_camelCase}};\r\n" + "\r\n" + " @Override\r\n"
            + " public {{serviceResponse}} create{{entityName}}({{serviceRequest}} {{serviceRequest_camelCase}}) {\r\n"
            + " {{dto}} {{dto_camelCase}} = {{serviceRequest_camelCase}}.get{{dto}}();\r\n"
            + " {{entityName}} {{entityName_lowerCase}} = ({{entityName}}) {{conversionUtility_camelCase}}.convert({{dto_camelCase}}, {{dto}}.class, {{entityName}}.class);\r\n"
            + " {{repo_camelCase}}.save({{entityName_lowerCase}});\r\n" + " return null;\r\n" + " }\r\n" + "\r\n"
            + " @Override\r\n"
            + " public {{serviceResponse}} get{{entityName}}s({{serviceRequest}} {{serviceRequest_camelCase}}) {\r\n"
            + " List<{{entityName}}> {{entityName_camelCase}}List = new ArrayList<>();\r\n"
            + " List<Filter> filters = new ArrayList<>();\r\n" + " SearchObject searchObject = new SearchObject();\r\n"
            + "\r\n"
            + " {{entityName}}SearchDTO {{entityName_camelCase}}SearchDTO = {{serviceRequest_camelCase}}.get{{entityName}}SearchDTO();\r\n"
            + " if ({{entityName_camelCase}}SearchDTO != null) {\r\n"
            + " List<Long> ids = {{entityName_camelCase}}SearchDTO.getIds();\r\n"
            + " List<String> nameList = {{entityName_camelCase}}SearchDTO.getNameList();\r\n"
            + " List<Long> addressIdList = {{entityName_camelCase}}SearchDTO.getAddressIdList();\r\n" + "\r\n"
            + " FilterUtils.createEqualFilter(filters, {{entityName}}SearchDTO.ID, ids);\r\n"
            + " FilterUtils.createEqualFilter(filters, {{entityName}}SearchDTO.NAME, nameList);\r\n"
            + " FilterUtils.createEqualFilter(filters, {{entityName}}SearchDTO.ADDRESS_ID, addressIdList);\r\n" + "\r\n"
            + " if (CollectionUtils.isNotEmpty(filters)) {\r\n" + " searchObject.setFilters(filters);\r\n" + " }\r\n"
            + " }\r\n" + " searchObject.setPageIndex({{serviceRequest_camelCase}}.getPageIndex());\r\n"
            + " searchObject.setRecordstoFetch({{serviceRequest_camelCase}}.getRecordstoFetch());\r\n"
            + " {{entityName_camelCase}}List = {{repo_camelCase}}.search(searchObject);\r\n" + "\r\n"
            + " List<{{dto}}> {{entityName_camelCase}}DTOList = new ArrayList<>();\r\n"
            + " for ({{entityName}} target : {{entityName_camelCase}}List) {\r\n"
            + " {{entityName_camelCase}}DTOList.add(({{dto}}) {{conversionUtility_camelCase}}.convert(target, {{entityName}}.class, {{dto}}.class));\r\n"
            + " }\r\n" + " {{serviceResponse}} {{entityName_camelCase}}ServiceResponse = new {{serviceResponse}}();\r\n"
            + " {{entityName_camelCase}}ServiceResponse.set{{dto}}List({{entityName_camelCase}}DTOList);\r\n"
            + " return {{entityName_camelCase}}ServiceResponse;\r\n" + " }\r\n" + "\r\n" + " @Override\r\n"
            + " public {{serviceResponse}} update{{entityName}}({{serviceRequest}} {{serviceRequest_camelCase}}) {\r\n"
            + " {{dto}} source = {{serviceRequest_camelCase}}.get{{dto}}();\r\n" + "\r\n"
            + " {{entityName}} target = {{repo_camelCase}}.findById(source.getId()).get();\r\n"
            + " target.setName(source.getName());\r\n" + "\r\n" + " {{repo_camelCase}}.save(target);\r\n"
            + " return null;\r\n" + " }\r\n" + "\r\n" + " @Override\r\n"
            + " public {{serviceResponse}} delete{{entityName}}({{serviceRequest}} {{serviceRequest_camelCase}}) {\r\n"
            + " {{dto}} {{dto_camelCase}} = {{serviceRequest_camelCase}}.get{{dto}}();\r\n"
            + " {{repo_camelCase}}.deleteById({{dto_camelCase}}.getId());\r\n" + " return null;\r\n" + " }\r\n" + "}";

    private static String setterTemplate = "public void set{{fieldName}}({{type}} {{fieldName_camelCase}}) {\r\n"
            + " this.{{fieldName_camelCase}} = {{fieldName_camelCase}};\r\n" + "}\r\n" + "";

    private static String getterTemplate = "public {{type}} get{{fieldName}}() {\r\n"
            + " return {{fieldName_camelCase}};\r\n" + "}\r\n";

    private static String dtoHeaderTemplate = "package com.vme.precast.{{entityName_lowerCase}}.api;\r\n" + "\r\n"
            + "import coliseum.service.BaseDTO;\r\n" + "\r\n" + "public class {{dto}} extends BaseDTO {\r\n" + "\r\n"
            + "\r\n" + "    private static final long serialVersionUID = 1L;";

    private static String searchDtoHeaderTemplate = "package com.vme.precast.{{entityName_lowerCase}}.api;\r\n" + "\r\n"
            + "import java.util.List;\r\n" + "\r\n" + "import coliseum.service.BaseSearchDTO;\r\n" + "\r\n"
            + "public class {{searchDTO}} extends BaseSearchDTO {\r\n" + "\r\n" + "\r\n"
            + "    private static final long serialVersionUID = 1L;";

    private static String footerTemplate = "}";

    private static String searchDTO_ConstantTemplate = "}";

    private static String genericConvertorTemplate = "package com.vme.precast.{{entityName_lowerCase}}.impl;\r\n"
            + "\r\n" + "import java.util.HashSet;\r\n" + "import java.util.Set;\r\n" + "\r\n"
            + "import org.springframework.core.convert.TypeDescriptor;\r\n"
            + "import org.springframework.core.convert.converter.GenericConverter;\r\n" + "\r\n"
            + "import com.vme.precast.domain.{{entityName}};\r\n"
            + "import com.vme.precast.{{entityName_lowerCase}}.api.{{dto}};\r\n" + "\r\n"
            + "public class {{entityName}}GenericConvertor implements GenericConverter {\r\n" + "\r\n"
            + " @Override\r\n" + " public Set<ConvertiblePair> getConvertibleTypes() {\r\n"
            + " Set<ConvertiblePair> convertiblePairs = new HashSet<>();\r\n"
            + " convertiblePairs.add(new ConvertiblePair({{entityName}}.class, {{dto}}.class));\r\n"
            + " convertiblePairs.add(new ConvertiblePair({{dto}}.class, {{entityName}}.class));\r\n"
            + " return convertiblePairs;\r\n" + " }\r\n" + "\r\n" + " @Override\r\n"
            + " public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {\r\n"
            + " Object target = null;\r\n"
            + " if (sourceType.getType() == {{entityName}}.class && targetType.getType() == {{dto}}.class) {\r\n"
            + " target = this.convertTo{{dto}}(({{entityName}}) source);\r\n" + " }\r\n"
            + " if (sourceType.getType() == {{dto}}.class && targetType.getType() == {{entityName}}.class) {\r\n"
            + " target = this.convertTo{{entityName}}(({{dto}}) source);\r\n" + " }\r\n" + " return target;\r\n"
            + " }\r\n" + "\r\n" + " private Object convertTo{{entityName}}({{dto}} source) {\r\n"
            + " {{entityName}} target = new {{entityName}}();\r\n" + " \r\n" + " return target;\r\n" + " }\r\n" + "\r\n"
            + " private Object convertTo{{dto}}({{entityName}} source) {\r\n" + " {{dto}} target = new {{dto}}();\r\n"
            + " \r\n" + " return target;\r\n" + " }\r\n" + "}\r\n" + "";

    private static String genericSetterTemplate = "target.setId(source.getId());";

    private static String configXmlTemplate = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n"
            + "<beans xmlns=\"http://www.springframework.org/schema/beans\"\r\n"
            + " xmlns:p=\"http://www.springframework.org/schema/p\"\r\n"
            + " xmlns:tx=\"http://www.springframework.org/schema/tx\"\r\n"
            + " xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\r\n"
            + " xmlns:context=\"http://www.springframework.org/schema/context\"\r\n"
            + " xmlns:util=\"http://www.springframework.org/schema/util\"\r\n"
            + " xmlns:mvc=\"http://www.springframework.org/schema/mvc\"\r\n"
            + " xmlns:jpa=\"http://www.springframework.org/schema/data/jpa\"\r\n"
            + " xsi:schemaLocation=\"http://www.springframework.org/schema/mvc http://www.springframework.org/schema/mvc/spring-mvc.xsd\r\n"
            + " http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd\r\n"
            + " http://www.springframework.org/schema/tx http://www.springframework.org/schema/tx/spring-tx.xsd\r\n"
            + " http://www.springframework.org/schema/util http://www.springframework.org/schema/util/spring-util.xsd\r\n"
            + " http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd\">\r\n"
            + "\r\n" + " <bean id=\"{{component_camelCase}}\"\r\n"
            + " class=\"com.vme.precast.{{entityName_lowerCase}}.impl.{{componentImpl}}\" />\r\n" + "\r\n"
            + " <bean id=\"{{genericConvertor_camelCase}}\"\r\n"
            + " class=\"com.vme.precast.{{entityName_lowerCase}}.impl.{{genericConvertor}}\" />\r\n" + "\r\n"
            + " <bean id=\"{{validator_camelCase}}\"\r\n"
            + " class=\"com.vme.precast.{{entityName_lowerCase}}.impl.{{validatorImpl}}\" />\r\n" + "\r\n"
            + " <bean id=\"{{service_camelCase}}\" factory-method=\"create\"\r\n"
            + " factory-bean=\"baseServiceImpl\">\r\n" + " <constructor-arg type=\"\"\r\n"
            + " value=\"com.vme.precast.{{entityName_lowerCase}}.api.{{service}}\"></constructor-arg>\r\n"
            + " </bean>\r\n" + "</beans>";

    private static String createXml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n"
            + "<flow xmlns=\"http://www.springframework.org/schema/webflow\"\r\n"
            + " xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\r\n"
            + " xsi:schemaLocation=\"http://www.springframework.org/schema/webflow http://www.springframework.org/schema/webflow/spring-webflow.xsd\">\r\n"
            + "\r\n" + " <input name=\"{{serviceRequest_camelCase}}\" required=\"true\" />\r\n" + "\r\n"
            + " <action-state id=\"validate\">\r\n" + " <evaluate\r\n"
            + " expression=\"{{validator_camelCase}}.check{{entityName}}Duplicate({{serviceRequest_camelCase}})\" />\r\n"
            + " <evaluate expression=\"endValidation\">\r\n"
            + " <attribute name=\"name\" value=\"endValidation\"></attribute>\r\n" + " </evaluate>\r\n"
            + " <transition on=\"endValidation.success\" to=\"create{{entityName}}\" />\r\n" + " </action-state>\r\n"
            + "\r\n" + " <action-state id=\"create{{entityName}}\">\r\n" + " <evaluate\r\n"
            + " expression=\"{{component_camelCase}}.create{{entityName}}({{serviceRequest_camelCase}})\"\r\n"
            + " result=\"flowScope.{{serviceResponse_camelCase}}\" />\r\n" + " <transition to=\"exit\" />\r\n"
            + " </action-state>\r\n" + "\r\n" + " <end-state id=\"exit\">\r\n"
            + " <output name=\"{{serviceResponse_camelCase}}\" />\r\n" + " </end-state>\r\n" + "</flow>";

    private static String updatexml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n"
            + "<flow xmlns=\"http://www.springframework.org/schema/webflow\"\r\n"
            + " xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\r\n"
            + " xsi:schemaLocation=\"http://www.springframework.org/schema/webflow http://www.springframework.org/schema/webflow/spring-webflow.xsd\">\r\n"
            + "\r\n" + " <input name=\"{{serviceRequest_camelCase}}\" required=\"true\" />\r\n" + "\r\n"
            + " <action-state id=\"validate\">\r\n" + " <evaluate\r\n"
            + " expression=\"{{validator_camelCase}}.check{{entityName}}Duplicate({{serviceRequest_camelCase}})\" />\r\n"
            + " <evaluate expression=\"endValidation\">\r\n"
            + " <attribute name=\"name\" value=\"endValidation\"></attribute>\r\n" + " </evaluate>\r\n"
            + " <transition on=\"endValidation.success\" to=\"update{{entityName}}\" />\r\n" + " </action-state>\r\n"
            + "\r\n" + " <action-state id=\"update{{entityName}}\">\r\n" + " <evaluate\r\n"
            + " expression=\"{{component_camelCase}}.update{{entityName}}({{serviceRequest_camelCase}})\"\r\n"
            + " result=\"flowScope.{{serviceResponse_camelCase}}\" />\r\n" + " <transition to=\"exit\" />\r\n"
            + " </action-state>\r\n" + "\r\n" + " <end-state id=\"exit\">\r\n"
            + " <output name=\"{{serviceResponse_camelCase}}\" />\r\n" + " </end-state>\r\n" + "</flow>";

    private static String getxml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n"
            + "<flow xmlns=\"http://www.springframework.org/schema/webflow\"\r\n"
            + " xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\r\n"
            + " xsi:schemaLocation=\"http://www.springframework.org/schema/webflow http://www.springframework.org/schema/webflow/spring-webflow.xsd\">\r\n"
            + "\r\n" + " <input name=\"{{serviceRequest_camelCase}}\" required=\"true\" />\r\n" + "\r\n"
            + " <action-state id=\"get{{entityName}}s\">\r\n" + " <evaluate\r\n"
            + " expression=\"{{component_camelCase}}.get{{entityName}}s({{serviceRequest_camelCase}})\"\r\n"
            + " result=\"flowScope.{{serviceResponse_camelCase}}\" />\r\n" + " <transition to=\"exit\" />\r\n"
            + " </action-state>\r\n" + "\r\n" + " <end-state id=\"exit\">\r\n"
            + " <output name=\"{{serviceResponse_camelCase}}\" />\r\n" + " </end-state>\r\n" + "</flow>";

    private static String deletexml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n"
            + "<flow xmlns=\"http://www.springframework.org/schema/webflow\"\r\n"
            + " xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\r\n"
            + " xsi:schemaLocation=\"http://www.springframework.org/schema/webflow http://www.springframework.org/schema/webflow/spring-webflow.xsd\">\r\n"
            + "\r\n" + " <input name=\"{{serviceRequest_camelCase}}\" required=\"true\" />\r\n" + "\r\n"
            + " <action-state id=\"delete{{entityName}}\">\r\n" + " <evaluate\r\n"
            + " expression=\"{{component_camelCase}}.delete{{entityName}}({{serviceRequest_camelCase}})\"\r\n"
            + " result=\"flowScope.{{serviceResponse_camelCase}}\" />\r\n" + " <transition to=\"exit\" />\r\n"
            + " </action-state>\r\n" + "\r\n" + " <end-state id=\"exit\">\r\n"
            + " <output name=\"{{serviceResponse_camelCase}}\" />\r\n" + " </end-state>\r\n" + "</flow>";

    private static String clientModelTemplate = "package com.vme.precast.{{entityName_lowerCase}}.controller;\r\n"
            + "\r\n" + "import java.util.List;\r\n" + "\r\n"
            + "import com.vme.precast.{{entityName_lowerCase}}.api.{{dto}};\r\n"
            + "import com.vme.precast.{{entityName_lowerCase}}.api.{{searchDTO}};\r\n" + "\r\n"
            + "import coliseum.web.BaseClientModel;\r\n" + "\r\n"
            + "public class {{clientModel}} extends BaseClientModel {\r\n" + "\r\n"
            + " private static final long serialVersionUID = 1L;\r\n" + "\r\n"
            + " private {{dto}} {{dto_camelCase}};\r\n" + "\r\n" + " private {{searchDTO}} {{searchDTO_camelCase}};\r\n"
            + "\r\n" + " private List<{{dto}}> {{dto_camelCase}}List;\r\n" + "\r\n"
            + " public {{dto}} get{{dto}}() {\r\n" + " return {{dto_camelCase}};\r\n" + " }\r\n" + "\r\n"
            + " public void set{{dto}}({{dto}} {{dto_camelCase}}) {\r\n"
            + " this.{{dto_camelCase}} = {{dto_camelCase}};\r\n" + " }\r\n" + "\r\n"
            + " public List<{{dto}}> get{{dto}}List() {\r\n" + " return {{dto_camelCase}}List;\r\n" + " }\r\n" + "\r\n"
            + " public void set{{dto}}List(List<{{dto}}> {{dto_camelCase}}List) {\r\n"
            + " this.{{dto_camelCase}}List = {{dto_camelCase}}List;\r\n" + " }\r\n" + "\r\n"
            + " public {{searchDTO}} get{{searchDTO}}() {\r\n" + " return {{searchDTO_camelCase}};\r\n" + " }\r\n"
            + "\r\n" + " public void set{{searchDTO}}({{searchDTO}} {{searchDTO_camelCase}}) {\r\n"
            + " this.{{searchDTO_camelCase}} = {{searchDTO_camelCase}};\r\n" + " }\r\n" + "\r\n" + "}";

    private static String controllerTemplate = "package com.vme.precast.{{entityName_lowerCase}}.controller;\r\n"
            + "\r\n" + "import javax.validation.Valid;\r\n" + "\r\n"
            + "import org.springframework.beans.factory.annotation.Autowired;\r\n"
            + "import org.springframework.stereotype.Controller;\r\n"
            + "import org.springframework.web.bind.annotation.RequestBody;\r\n"
            + "import org.springframework.web.bind.annotation.RequestMapping;\r\n"
            + "import org.springframework.web.bind.annotation.RequestMethod;\r\n"
            + "import org.springframework.web.bind.annotation.ResponseBody;\r\n" + "\r\n"
            + "import com.vme.precast.{{entityName_lowerCase}}.api.{{dto}};\r\n"
            + "import com.vme.precast.{{entityName_lowerCase}}.api.{{service}};\r\n"
            + "import com.vme.precast.{{entityName_lowerCase}}.api.{{serviceRequest}};\r\n"
            + "import com.vme.precast.{{entityName_lowerCase}}.api.{{entityName}}ServiceResponse;\r\n" + "\r\n"
            + "@Controller\r\n" + "public class {{entityName}}Controller {\r\n" + "\r\n" + "    @Autowired\r\n"
            + "    {{service}} {{service_camelCase}};\r\n" + "\r\n"
            + "    @RequestMapping(value = \"delete{{entityName}}\", method = RequestMethod.POST)\r\n"
            + "    @ResponseBody\r\n"
            + "    public {{clientModel}} delete{{entityName}}(@RequestBody {{clientModel}} {{clientModel_camelCase}}) {\r\n"
            + "        {{serviceRequest}} {{serviceRequest_camelCase}} = new {{serviceRequest}}();\r\n"
            + "        for (Long id : {{clientModel_camelCase}}.getIdsToDelete()) {\r\n"
            + "            {{dto}} {{dto_camelCase}} = new {{dto}}();\r\n"
            + "            {{dto_camelCase}}.setId(id);\r\n"
            + "            {{serviceRequest_camelCase}}.set{{entityName}}DTO({{dto_camelCase}});\r\n"
            + "            {{service_camelCase}}.delete{{entityName}}({{serviceRequest_camelCase}});\r\n"
            + "        }\r\n" + "        return null;\r\n" + "    }\r\n" + "\r\n"
            + "    @RequestMapping(value = \"create{{entityName}}\", method = RequestMethod.POST)\r\n"
            + "    @ResponseBody\r\n"
            + "    public {{clientModel}} create{{entityName}}(@Valid @RequestBody {{clientModel}} {{clientModel_camelCase}}) {\r\n"
            + "        return this.constructClientModel({{service_camelCase}}.create{{entityName}}(this.constructServiceRequest({{clientModel_camelCase}})));\r\n"
            + "    }\r\n" + "\r\n"
            + "    @RequestMapping(value = \"update{{entityName}}\", method = RequestMethod.POST)\r\n"
            + "    @ResponseBody\r\n"
            + "    public {{clientModel}} update{{entityName}}(@Valid @RequestBody {{clientModel}} {{clientModel_camelCase}}) {\r\n"
            + "        return this.constructClientModel({{service_camelCase}}.update{{entityName}}(this.constructServiceRequest({{clientModel_camelCase}})));\r\n"
            + "    }\r\n" + "\r\n"
            + "    @RequestMapping(value = \"get{{entityName}}\", method = RequestMethod.POST)\r\n"
            + "    @ResponseBody\r\n"
            + "    public {{clientModel}} get{{entityName}}(@RequestBody {{clientModel}} {{clientModel_camelCase}}) {\r\n"
            + "        return this.constructClientModel({{service_camelCase}}.get{{entityName}}s(this.constructServiceRequest({{clientModel_camelCase}})));\r\n"
            + "    }\r\n" + "\r\n"
            + "    private {{clientModel}} constructClientModel({{entityName}}ServiceResponse {{serviceResponse_camelCase}}) {\r\n"
            + "        {{clientModel}} {{clientModel_camelCase}} = null;\r\n"
            + "        if ({{serviceResponse_camelCase}} != null) {\r\n"
            + "            {{clientModel_camelCase}} = new {{clientModel}}();\r\n"
            + "            {{clientModel_camelCase}}.set{{entityName}}DTOList({{serviceResponse_camelCase}}.get{{entityName}}DTOList());\r\n"
            + "            {{clientModel_camelCase}}.setTotalRecords({{serviceResponse_camelCase}}.getTotalRecords());\r\n"
            + "        }\r\n" + "        return {{clientModel_camelCase}};\r\n" + "    }\r\n" + "\r\n"
            + "    private {{serviceRequest}} constructServiceRequest({{clientModel}} {{clientModel_camelCase}}) {\r\n"
            + "        {{serviceRequest}} {{serviceRequest_camelCase}} = new {{serviceRequest}}();\r\n"
            + "        {{serviceRequest_camelCase}}.set{{entityName}}DTO({{clientModel_camelCase}}.get{{entityName}}DTO());\r\n"
            + "        {{serviceRequest_camelCase}}.set{{entityName}}SearchDTO({{clientModel_camelCase}}.get{{entityName}}SearchDTO());\r\n"
            + "        {{serviceRequest_camelCase}}.setRecordstoFetch({{clientModel_camelCase}}.getRecordstoFetch());\r\n"
            + "        {{serviceRequest_camelCase}}.setPageIndex({{clientModel_camelCase}}.getPageIndex());\r\n"
            + "        return {{serviceRequest_camelCase}};\r\n" + "    }\r\n" + "}";
}