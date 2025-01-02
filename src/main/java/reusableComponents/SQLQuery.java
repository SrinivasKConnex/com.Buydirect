package reusableComponents;

import testBase.TestBase;

public class SQLQuery extends TestBase {
	
	String partnerId=partnerid;
	public static String getPartnerImageQuery(int partnerId) {
        return "SELECT Partner_Image_URL FROM [dbo].[Partner_Image] WHERE Partner_ID = " 
                + partnerId + " AND Partner_Image_Types_ID = 1";
    }

    public static String getTenderNameQuery(int partnerId) {
        return "SELECT Tender_Name_Header FROM [dbo].[Partner_BuyDirect_Settings] WHERE Partner_ID = " 
                + partnerId;
    }

    public static String getPartnerContactInfoQuery(int partnerId) {
        return "SELECT Product_Name, Partner_Contact_Number " +
               "FROM [dbo].[Partner_BuyDirect_Settings] AS ps " +
               "INNER JOIN [dbo].[Partner_Profile] AS pp " +
               "ON pp.Partner_ID = ps.Partner_ID " +
               "WHERE ps.Partner_ID = " + partnerId;
    }

    // Example query with placeholder for parameter
    public static String getDynamicQuery(String tableName, String columnName, String partnerId) {
        return String.format("SELECT %s FROM [dbo].[%s] WHERE Partner_ID = %d", 
                             columnName, tableName, partnerId);
    }

	public static String getSuccessMessage() {

		String value = "SELECT Congratulations_Message FROM [dbo].[Partner_BuyDirect_Settings] WHERE Partner_ID ="
				+ partnerid;
		return value;

	}
	public static String getConsumerEnrollmentStatusQuery(String email) {

		String value = "select Registration,PII_Complete,BA_Recieved,Consumer_ID from  [dbo].[Consumer_Enrollment_States] where Consumer_ID in (Select Consumer_ID from [dbo].[Consumer] where Consumer_Email ='"+email+"')";
		return value;

	}
	public static String getConsumer_legacy_ID(String email) {

		String value = "select Consumer_Legacy_ID from  [dbo].[Consumer] where Consumer_Email ='"+email+"'";
		return value;

	}
	public static String getNotificationInsertDataQuery(String consumerlegacyID) {

		String value = "select CategoryID from  [dbo].[NM_Notification] where ConsumerID in (Select Consumer_Legacy_ID from [dbo].[Consumer] where Consumer_Legacy_ID ="+consumerlegacyID+" and TypeID=1 and CategoryID=2)";
		return value;

	}
    
    
    // Update queries can also be parameterized
    public static String updatePlasticStatus(int partnerId, int status) {
        return "UPDATE [dbo].[Partner_BuyDirect_Settings] SET Is_Plastics_Page_Displayed = " + status 
               + " WHERE Partner_ID = " + partnerId;
    }

    // Example for parameterized method to avoid code duplication
    public static String getQueryWithCondition(String tableName, String columnName, String condition) {
        return String.format("SELECT %s FROM [dbo].[%s] WHERE %s", columnName, tableName, condition);
    }
	public static String logo_Query = "select Partner_Image_URL from [dbo].[Partner_Image] where Partner_ID="
			+ partnerid + " and Partner_Image_Types_ID=1";

	public static String Tender_name_Query = "select Tender_Name_Header from [dbo].[Partner_BuyDirect_Settings] where partner_id="
			+ partnerid;

	public static String Get_Partner_namephonenumber_query = "select Product_Name,partner_contact_number  from"
			+ "  Partner_BuyDirect_Settings as ps inner JOIN partner_profile as pp on pp.partner_id=ps.partner_id where ps.partner_id="
			+ partnerid;

	public static String Get_Partner_phone_number_query = "	Select Partner_Contact_Number from [dbo].[Partner_Profile] where partner_id="
			+ partnerid;
	public static String dl_status = "select IsDLRequired  from Partner_BuyDirect_Settings where partner_id="
			+ partnerid;

	public static String plastic_status = "select Is_Plastics_Page_Displayed  from Partner_BuyDirect_Settings where partner_id="
			+ partnerid;

	public static String bank_intro_pageOption = "select Is_Banking_Intro_Page_Displayed from partner_buydirect_settings where partner_id="
			+ partnerid;

	public static String Update_plastic_statustoTwo = "update [dbo].[Partner_BuyDirect_Settings] set Is_Plastics_Page_Displayed=2 where partner_id="
			+ partnerid;
	public static String Update_BankIntroPage_statustoOne = "update [dbo].[Partner_BuyDirect_Settings] set Is_Banking_Intro_Page_Displayed=1 where partner_id="
			+ partnerid;
	public static String Update_BankIntroPage_statusZero = "update [dbo].[Partner_BuyDirect_Settings] set Is_Banking_Intro_Page_Displayed=0 where partner_id="
			+ partnerid;

	public static String Update_plastic_statustoone = "update [dbo].[Partner_BuyDirect_Settings] set Is_Plastics_Page_Displayed=1 where partner_id="
			+ partnerid;
	public static String Update_plastic_statustoZero = "update [dbo].[Partner_BuyDirect_Settings] set Is_Plastics_Page_Displayed=0 where partner_id="
			+ partnerid;

	public static String Welcomebody_Text3_Query = "SELECT  REPLACE(REPLACE(REPLACE(Welcome_Message,'<PartnerName>',Tender_Name_Body), '<PartnerPhone>', Partner_Contact_Number),'|', ' ') AS WelcomeMessage "
			+ "			FROM [dbo].[Partner_BuyDirect_Settings] PBS INNER JOIN [dbo].[Partner_Profile] PP "
			+ "			ON PBS.Partner_ID = PP.Partner_ID WHERE PBS.Partner_ID =" + partnerid;

	public static String Get_Theamcolor = "select Theme_Color from [dbo].[Partner_BuyDirect_Settings] where partner_id="
			+ partnerid;

	public static String Get_WelcomePage_ButtonText = "select Welcome_Screen_Button_Text from [dbo].[Partner_BuyDirect_Settings] where partner_id="
			+ partnerid;

	public static String Get_WelcomePage_SigninText = "select Welcome_Screen_SignInHere_Text from [dbo].[Partner_BuyDirect_Settings] where partner_id="
			+ partnerid;
	public static String Get_TextNotification_Text = "select SMS_Checkbox_text  from [dbo].[Partner_BuyDirect_Settings] where partner_id="
			+ partnerid;
	public static String Get_TermsAndCondition_Text = "select Terms_Checkbox_text  from [dbo].[Partner_BuyDirect_Settings] where partner_id="
			+ partnerid;
	public static String check_EmailAlredayExistStatus = "select Category_ID from [dbo].[Partner_Error_Codes_Category_Message] where   Category_ID=1 and partner_id="
			+ partnerid;

	public static String getEmailAlreadyExistCostomizedErrorMessage = "select Message from [dbo].[Partner_Error_Codes_Category_Message] where   Category_ID=1 and partner_id="
			+ partnerid;

	public static String getEmailAlreadyExistDefaultErrorMessage = "select Message from  [dbo].[Legacy_Error_Codes] where error_code=1345";

	public static String Get_plastic_request_subtitle = "select Plastics_Page_Subtitle from partner_buydirect_settings where partner_id="
			+ partnerid;
	public static String Get_plastic_request_BodyText = " SELECT REPLACE(REPLACE(Plastics_Page_Body, '\\n', ''), '|', '') AS plasticRequestBodyText	FROM [dbo].[Partner_BuyDirect_Settings]  WHERE Partner_ID ="
			+ partnerid;

	public static String check_plastic_indicator_flag = "SELECT cdf.Consumer_CDF_Value FROM [dbo].[Consumer_CDF] AS cdf INNER JOIN [dbo].[Consumer] AS consumer ON consumer.consumer_id = cdf.consumer_id WHERE cdf.Partner_CDF_Definition_ID = 4 AND consumer.partner_id = "
			+ partnerid + " AND consumer.Consumer_Email =";

	public static String get_BankintroPage_BodyText = "	SELECT  REPLACE(Banking_Intro_Page_Body,'<PartnerName>',Tender_Name_Body) AS BankingIntroPageBody FROM [dbo].[Partner_BuyDirect_Settings] PBS INNER JOIN [dbo].[Partner_Profile] PP \r\n"
			+ "ON PBS.Partner_ID = PP.Partner_ID WHERE PBS.Partner_ID =" + partnerid;
	
	public static String get_ErrorPage_Title="select Error_Page_Header from partner_buydirect_settings where partner_id="+partnerid;
	
	public static String get_ErrorPage_BodyText="SELECT  REPLACE(REPLACE(Error_Page_Body,'<PartnerName>',Tender_Name_Body), '<PartnerPhone>', Partner_Contact_Number)  AS Error_Page_Body\r\n"
			+ "FROM [dbo].[Partner_BuyDirect_Settings] PBS INNER JOIN [dbo].[Partner_Profile] PP\r\n"
			+ "ON PBS.Partner_ID = PP.Partner_ID WHERE PBS.Partner_ID ="+partnerid;

	public static String get_PIVData="SELECT requst.Consumer_Request FROM [dbo].[Consumer_Request] AS   requst INNER JOIN [dbo].[Consumer] AS consumer ON consumer.consumer_id = requst.consumer_id  WHERE requst.Consumer_Request_Description_ID = 2 AND consumer.partner_id ="+partnerid+"  AND consumer.Consumer_Email =";

	public static String getBankingRequestBodyTextQuery="SELECT  REPLACE(Banking_Request_Body,'|', '') AS Banking_Request_Body \n"
			+ "		FROM [dbo].[Partner_BuyDirect_Settings]  WHERE Partner_ID ="+partnerid;

	public static String getCDWPendingBodyText="select CDW_Pending_Body from Partner_BuyDirect_Settings where partner_id="+partnerid;

}
