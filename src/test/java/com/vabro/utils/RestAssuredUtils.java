package com.vabro.utils;

import io.restassured.RestAssured;
import io.restassured.config.DecoderConfig;

public class RestAssuredUtils {

    public static void configureRestAssured() {
        RestAssured.config = RestAssured.config()
                .decoderConfig(DecoderConfig.decoderConfig().noContentDecoders());
    }
}

