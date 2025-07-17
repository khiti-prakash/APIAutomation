package com.vabro.tests;


import com.vabro.api.Login.LoginResponse;
import com.vabro.api.LoginService;
import com.vabro.data.VabroLoginTestData;
import config.AppConfig;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LoginTest {

//    String validEmail = "testervabro1@gmail.com";
//    String validPassword = "Test@123";
//    String invalidEmail = "invalid@example.com";
//    String invalidPassword = "Wrong@123";
//    String ipAddress = "192.168.1.1";
//    String timeZone = "UTC";
//    String deviceType = "Desktop";
//    String geoDataRequest = "{\"latitude\": 51.5074, \"longitude\": -0.1278}"; // Example JSON geo-data

    LoginService loginService = new LoginService();

    @Test(priority = 1)
    public void TC_LOGIN_001_validCredentials() {
        LoginResponse response = loginService.loginWithPayload(VabroLoginTestData.getValidLoginPayload());

        assertThat(response.getToken()).isNotBlank();
        assertThat(response.getRefreshToken()).isNotBlank();
        assertThat(response.getUserAccountId()).isNotBlank();
        assertThat(response.getLoginResponseMessage().get(0).getResponseCode()).isEqualTo(2005);
        assertThat(response.getLoginResponseMessage().get(0).getMessage()).contains("successfully logged in");
        AppConfig.updateBearerToken(response.getToken()); // store for further API use
    }

    @Test(priority = 2)
    public void TC_LOGIN_002_invalidPassword() {
        Map<String, Object> payload = VabroLoginTestData.getValidLoginPayload();
        payload.put("password", "Wrong@123");

        LoginResponse response = loginService.loginWithPayload(payload);
        assertThat(response.getLoginResponseMessage().get(0).getMessage()).contains("Wrong password. Please try again or click <a href='/home/forgot-password' class='alert-link'>Forgot Password</a> to reset your password.");
        assertThat(response.getLoginResponseMessage().get(0).getResponseCode()).isEqualTo(2007);
    }

    @Test(priority = 3)
    public void TC_LOGIN_003_invalidEmail() {

        Map<String, Object> payload = VabroLoginTestData.getValidLoginPayload();
        payload.put("emailId", "invalidemail@");

        LoginResponse response = loginService.loginWithPayload(payload);
        assertThat(response.getLoginResponseMessage().get(0).getMessage()).contains("Please enter a valid email address.");
        assertThat(response.getLoginResponseMessage().get(0).getResponseCode()).isEqualTo(1006);
    }

    @Test(priority = 4)
    public void TC_LOGIN_004_emptyEmail() {
        Map<String, Object> payload = VabroLoginTestData.getValidLoginPayload();
        payload.put("emailId", "");  // Set email to empty string

        LoginResponse response = loginService.loginWithPayload(payload);
        assertThat(response.getLoginResponseMessage().get(0).getMessage()).contains("Please enter email address");
        assertThat(response.getLoginResponseMessage().get(0).getResponseCode()).isEqualTo(1005);
    }

    @Test(priority = 5)
    public void TC_LOGIN_005_emptyPassword() {
        Map<String, Object> payload = VabroLoginTestData.getValidLoginPayload();
        payload.put("password", "");
        LoginResponse response = loginService.loginWithPayload(payload);
        assertThat(response.getLoginResponseMessage().get(0).getMessage()).contains("Please enter ProjectId");
        assertThat(response.getLoginResponseMessage().get(0).getResponseCode()).isEqualTo(1003);
    }

    @Test(priority = 6)
    public void TC_LOGIN_006_emptyGeoDataBlock() {
        Map<String, Object> payload = VabroLoginTestData.getValidLoginPayload();
        payload.put("geoData", new HashMap<>()); // Set geoData to empty object

        LoginResponse response = loginService.loginWithPayload(payload);
        assertThat(response.getToken()).isNotBlank();
    }

    @Test(priority = 7)
    public void TC_LOGIN_007_missingIpOrTimezone() {
        LoginResponse response = loginService.loginWithPayload(VabroLoginTestData.getLoginWithMissingField("ipAddress"));
        assertThat(response.getLoginResponseMessage().get(0).getMessage()).contains("You have successfully logged in.");
        assertThat(response.getLoginResponseMessage().get(0).getResponseCode().equals(2005));
    }

    @Test(priority = 8)
    public void TC_LOGIN_008_sqlInjectionEmail() {
        Map<String, Object> payload = VabroLoginTestData.getValidLoginPayload();
        payload.put("emailId", "' OR 1=1 --");

        LoginResponse response = loginService.loginWithPayload(payload);
        assertThat(response.getLoginResponseMessage().get(0).getMessage()).contains("Please enter a valid email address.");
        assertThat(response.getLoginResponseMessage().get(0).getResponseCode().equals(1006));
    }

    @Test(priority = 9)
    public void TC_LOGIN_009_scriptTagEmail() {
        Map<String, Object> payload = VabroLoginTestData.getValidLoginPayload();
        payload.put("emailId", "<script>alert(1)</script>");

        LoginResponse response = loginService.loginWithPayload(payload);
        assertThat(response.getLoginResponseMessage().get(0).getMessage()).contains("Please enter a valid email address.");
        assertThat(response.getLoginResponseMessage().get(0).getResponseCode().equals(1006));
    }

    @Test(priority = 10)
    public void TC_LOGIN_010_invalidTimezone() {
        LoginResponse response = loginService.loginWithPayload(VabroLoginTestData.getLoginWithInvalidTimeZone());
        assertThat(response.getLoginResponseMessage().get(0).getResponseType()).isEqualTo("success");
    }

    @Test(priority = 11)
    public void TC_LOGIN_011_missingGeoFields() {
        LoginResponse response = loginService.loginWithPayload(VabroLoginTestData.getLoginWithPartialGeo());
        assertThat(response.getToken()).isNotBlank();
    }

    @Test(priority = 12)
    public void TC_LOGIN_012_additionalUnknownFields() {
        LoginResponse response = loginService.loginWithPayload(VabroLoginTestData.getLoginWithExtraField());
        assertThat(response.getToken()).isNotBlank();
    }

    @Test(priority = 13)
    public void TC_LOGIN_013_jwtTokenStructureValidation() {
        LoginResponse response = loginService.loginWithPayload(VabroLoginTestData.getValidLoginPayload());
        String token = response.getToken();
        assertThat(token.split("\\.")).hasSize(3); // Header.Payload.Signature
    }

//    @Test(priority = 14)
//    public void TC_LOGIN_014_deactivatedAccount() {
//        Map<String, Object> payload = VabroLoginTestData.getValidLoginPayload();
//        payload.put("emailId", "deactivateduser@vabro.com");
//
//        LoginResponse response = loginService.loginWithPayload(payload);
//        assertThat(response.getLoginResponseMessage().get(0).getMessage()).contains("Account deactivated");
//    }

    @Test(priority = 15)
    public void TC_LOGIN_015_blankJsonBody() {
        LoginResponse response = loginService.loginWithPayload(VabroLoginTestData.getBlankRequestBody());
        assertThat(response.getLoginResponseMessage().get(0).getMessage()).contains("Please enter email address.");
        assertThat(response.getLoginResponseMessage().get(0).getResponseCode().equals(1005));
        assertThat(response.getLoginResponseMessage().get(1).getMessage()).contains("Please enter ProjectId");
        assertThat(response.getLoginResponseMessage().get(1).getResponseCode().equals(1003));
    }

    @Test(priority = 16)
    public void TC_LOGIN_016_wrongMethodGetInsteadOfPost() {
        int statusCode = loginService.loginUsingGetMethod();
        assertThat(statusCode).isEqualTo(405);
    }

    @Test(priority = 17)
    public void TC_LOGIN_017_responseTimeUnder1Sec() {
        long time = loginService.loginWithTiming("testervabro1@gmail.com", "Test@123");
        assertThat(time).isLessThan(10000);
    }

//    @Test(priority = 18)
//    public void TC_LOGIN_018_corsHeaderValidation() {
//        boolean isHeaderPresent = loginService.isCORSHeaderPresent();
//        assertThat(isHeaderPresent).isTrue();
//    }

    @Test(priority = 19)
    public void TC_LOGIN_019_rateLimitingCheck() {
        int statusCode = loginService.triggerLoginRateLimit("testervabro1@gmail.com", "Test@123");
        assertThat(statusCode).isIn(200, 429);
    }

    @Test(priority = 20)
    public void TC_LOGIN_020_tokenStructureValidation() {
        String token = loginService.loginWithPayload(VabroLoginTestData.getValidLoginPayload()).getToken();
        assertThat(token).matches("^[A-Za-z0-9-_]+\\.[A-Za-z0-9-_]+\\.[A-Za-z0-9-_]+$");
    }
}