package org.hbahuguna.petstore.config;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.ObjectMapperConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.filter.log.ErrorLoggingFilter;
import io.restassured.filter.log.LogDetail;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.specification.RequestSpecification;

public class PetStoreRestAssuredConfig {
    /*
    This class is a Singleton so that we create only one request spec
    This way we can use this same spec for all tests without any performance overhead
     */

    private static RequestSpecification instance = null;

    private PetStoreRestAssuredConfig(){
        RestAssured.config = RestAssuredConfig.config().objectMapperConfig(new ObjectMapperConfig(ObjectMapperType.GSON));
    }

    public static RequestSpecification getInstance() {
        if(instance == null){
            instance = new PetStoreRestAssuredConfig().setBaseURI();
        }
        return instance;
    }

    private RequestSpecification setBaseURI(){
        RequestSpecBuilder builder = new RequestSpecBuilder().setBaseUri("https://petstore.swagger.io/v2/pet/");
        builder.addFilter(new ErrorLoggingFilter()).log(LogDetail.ALL);
        return builder.build();
    }
}
