package reusableComponents;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;

public class TestDataProvider {

    @DataProvider(name = "loginData")
    public Object[][] getLogInData(Method method) {
        String sheetName = "Login_crede";
        String columnName = getLoginDataColumnName(method.getName());
        return new Object[][] { { sheetName, columnName, ReadExcelData.getDataFromExcel(sheetName, columnName) } };
    }

    @DataProvider(name = "Consumerdata")
    public Object[][] getConsumerData(Method method) {
        String sheetName = "Consumer_data";
        String columnName = getConsumerDataColumnName(method.getName());
        return new Object[][] { { sheetName, columnName, ReadExcelData.getDataFromExcel(sheetName, columnName) } };
    }
    @DataProvider(name = "EnrollData")
    public Object[][] getEnrollData(Method method) {
        String sheetName = "Validation_Data";
        String columnName = getEnrollDataColumnName(method.getName());
        return new Object[][] { { sheetName, columnName, ReadExcelData.getDataFromExcel(sheetName, columnName) } };
    }

    private String getLoginDataColumnName(String testName) {
        Map<String, String> testNameToColumnMap = new HashMap<>();
        testNameToColumnMap.put("Test_ErrorForInValidEmail", "Data_4");
        testNameToColumnMap.put("Test_ErrorForIncompletePin", "Data_3");
        testNameToColumnMap.put("Test_ErrorforIncorrectPin", "Data_2");
        testNameToColumnMap.put("Test_UnMaskedPin", "Data_6");
        testNameToColumnMap.put("Test_MaskedPin", "Data_6");
        testNameToColumnMap.put("Test_ErrorforEmailDoesNotExist", "Data_1");

        return testNameToColumnMap.getOrDefault(testName, "Default_Column");
    }
    private String getConsumerDataColumnName(String testName) {
        Map<String, String> testNameToColumnMap = new HashMap<>();
        testNameToColumnMap.put("Test_UserAbleToSelectDOBAbove18YearsAge", "Consumer_Validdetails");
        testNameToColumnMap.put("Test_ErrorMessageForEmailAlreadyExist", "Consumer_details_EmailAredayExist");
        testNameToColumnMap.put("Test_ErrorMessageForInvalidPin", "Consumer_details_InvalidPIN");
        testNameToColumnMap.put("Test_ErrorMessageForInvalidDominName", "Consumer_details_InvalidDomine");
        testNameToColumnMap.put("Test_ErrorMessageForInvalidPhone", "Consumer_details_InvalidPhone");
        testNameToColumnMap.put("Test_SubmitButton", "Consumer_Validdetails");
        
        return testNameToColumnMap.getOrDefault(testName, "Default_Column");
    }

    private String getEnrollDataColumnName(String testName) {
        Map<String, String> testNameToColumnMap = new HashMap<>();
        testNameToColumnMap.put("Test_FirstNamedWithValidInput", "Valid_FirstOrLastName");
        testNameToColumnMap.put("Test_LastNamedWithValidInput", "Valid_FirstOrLastName");
        testNameToColumnMap.put("Test_FirstNameWithInvalidInput", "InValid_FirstOrLastName");
        testNameToColumnMap.put("Test_LastNameWithInvalidInput", "InValid_FirstOrLastName");
        testNameToColumnMap.put("Test_EmailValidationWithInValidInput", "InValid_Email");
        testNameToColumnMap.put("Test_EmailValidationWithValidInput", "Valid_Email");
        testNameToColumnMap.put("Test_PhoneNumberValidationWithInValidInput", "Valid_PhoneNumber");
        testNameToColumnMap.put("Test_PhoneNumberValidationWithValidInput", "InValid_PhoneNumber");
        testNameToColumnMap.put("Test_CityNameValidationWithValidInput", "Valid_Cityname");
        testNameToColumnMap.put("Test_CityNameValidationWithInValidInput", "InValid_Cityname");
        testNameToColumnMap.put("Test_AddressValidationWithValidInput", "Valid_Address");
        testNameToColumnMap.put("Test_AddressValidationWithInValidInput", "InValid_Address");
        testNameToColumnMap.put("Test_ZipCodeValidationWithValidInputData", "Valid_ZipCode");
        testNameToColumnMap.put("Test_ZipCodeValidationWithInCompleteInputData", "InValid_ZipCode");
        testNameToColumnMap.put("Test_DLNumbereValidationWithValidInputData", "Valid_DlNumber");
        testNameToColumnMap.put("Test_DLNumbereeValidationWithInCompleteInputData", "InValid_DlNumber");
        testNameToColumnMap.put("Test_PINValidationWithValidInputData", "Valid_PIN");
        testNameToColumnMap.put("Test_PINValidationWithInCompleteInputData", "InValid_PIN");
        testNameToColumnMap.put("Test_MaskedPin", "Valid_PIN");
        testNameToColumnMap.put("Test_UnMaskedPin", "Valid_PIN");
        testNameToColumnMap.put("Test_UserAbleToSelectDOBAbove18YearsAge", "Valid_PIN");

        return testNameToColumnMap.getOrDefault(testName, "Default_Column");
    }
}
