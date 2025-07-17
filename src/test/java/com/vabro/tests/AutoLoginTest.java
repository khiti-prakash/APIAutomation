package com.vabro.tests;

import com.vabro.api.AutoLogin.AutoLoginResponse;
import com.vabro.api.AutoLoginService;
import com.vabro.data.VabroAutoLoginTestData;
import config.AppConfig;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AutoLoginTest {
    //
    AutoLoginService service = new AutoLoginService();

    @Test(priority = 1)
    public void TC_AUTOLOGIN_001_validPayload() {
        AutoLoginResponse response = service.autoLoginWithPayload(VabroAutoLoginTestData.getValidAutoLoginPayload());

        assertThat(response.token).isNotBlank();
        assertThat(response.refreshToken).isNotBlank();
        assertThat(response.userAccountId).isNotBlank();
        assertThat(response.responseMessages.get(0).responseCode).isEqualTo(2005);
        assertThat(response.responseMessages.get(0).message.toLowerCase()).contains("success");
    }

    @Test(priority = 2)
    public void TC_AUTOLOGIN_002_missingToken() {
        AutoLoginResponse response = service.autoLoginWithPayload(VabroAutoLoginTestData.getPayloadWithMissingField("token"));
        assertThat(response.responseMessages.get(0).message.toLowerCase()).contains("wrong password. please try again or click <a href='/home/forgot-password' class='alert-link'>forgot password</a> to reset your password.");
    }

    @Test(priority = 3)
    public void TC_AUTOLOGIN_003_blankToken() {
        AutoLoginResponse response = service.autoLoginWithPayload(VabroAutoLoginTestData.getPayloadWithBlankToken());
        assertThat(response.responseMessages.get(0).message.toLowerCase()).contains("wrong password. please try again or click <a href='/home/forgot-password' class='alert-link'>forgot password</a> to reset your password.");
    }

    @Test(priority = 4)
    public void TC_AUTOLOGIN_004_invalidToken() {
        AutoLoginResponse response = service.autoLoginWithPayload(VabroAutoLoginTestData.getPayloadWithInvalidToken());
        assertThat(response.responseMessages.get(0).message.toLowerCase()).contains("wrong password. please try again or click <a href='/home/forgot-password' class='alert-link'>forgot password</a> to reset your password.");
    }

    @Test(priority = 5)
    public void TC_AUTOLOGIN_005_extraFields() {
        AutoLoginResponse response = service.autoLoginWithPayload(VabroAutoLoginTestData.getPayloadWithExtraFields());
        assertThat(response.token).isNotBlank();
    }

    @Test(priority = 6)
    public void TC_AUTOLOGIN_006_emptyBody() {
        AutoLoginResponse response = service.autoLoginWithPayload(VabroAutoLoginTestData.getEmptyRequestBody());
        assertThat(response.responseMessages.get(0).message.toLowerCase()).contains("wrong password. please try again or click <a href='/home/forgot-password' class='alert-link'>forgot password</a> to reset your password.");
    }
}

