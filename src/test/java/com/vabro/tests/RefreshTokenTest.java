package com.vabro.tests;

import com.vabro.api.RefreshToken.RefreshTokenResponse;
import com.vabro.api.RefreshTokenService;
import com.vabro.data.VabroRefreshTokenTestData;
import com.vabro.tests.ReusableAPI.BaseTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import config.AppConfig;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RefreshTokenTest extends BaseTest {

    RefreshTokenService service = new RefreshTokenService();

    @Test(priority = 1)
    public void TC_REFRESHTOKEN_001_validToken() {
        String refreshToken = AppConfig.getRefreshToken(); // from login
        RefreshTokenResponse response = service.refreshWithPayload(VabroRefreshTokenTestData.getValidRefreshPayload(refreshToken));

        assertThat(response.getToken()).isNotBlank();
        assertThat(response.getRefreshToken()).isNotBlank();
        assertThat(response.getUserAccountId()).isNotBlank();

    }

    @Test(priority = 2)
    public void TC_REFRESHTOKEN_002_missingRefreshToken() {
        RefreshTokenResponse response = service.refreshWithPayload(VabroRefreshTokenTestData.getMissingFieldPayload("refreshToken"));
        assertThat(response.getResponseMessages().get(0).getMessage().toLowerCase()).contains("Internal error.");
        assertThat(response.getResponseMessages().get(0).getResponseCode()).isEqualTo(1101);
        assertThat(response.getResponseMessages().get(0).getResponseType()).isEqualTo("error");

    }

    @Test(priority = 3)
    public void TC_REFRESHTOKEN_003_blankPayload() {
        int status = service.getStatusCode(VabroRefreshTokenTestData.getBlankPayload());
        assertThat(status).isEqualTo(400);
    }

    @Test(priority = 4)
    public void TC_REFRESHTOKEN_004_invalidTokenFormat() {
        Map<String, Object> payload = VabroRefreshTokenTestData.getValidRefreshPayload("invalid-token-123");
        RefreshTokenResponse response = service.refreshWithPayload(payload);
        assertThat(response.getResponseMessages().get(0).getMessage().toLowerCase()).contains("Invalid refresh token");
    }
}
