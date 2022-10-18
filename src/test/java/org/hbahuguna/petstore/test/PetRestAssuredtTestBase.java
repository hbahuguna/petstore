package org.hbahuguna.petstore.test;

import io.restassured.response.Response;
import org.hbahuguna.petstore.config.PetStoreRestAssuredConfig;
import org.hbahuguna.petstore.data.model.PetInfo;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;

public class PetRestAssuredtTestBase {


    public List<PetInfo> findByStatus(String status, int code) {
        return Arrays.asList(getResponseFindByStatus(status, code).getBody().as(PetInfo[].class));
    }

    public Response getResponseFindByStatus(String status, int code) {
        return given().spec(PetStoreRestAssuredConfig.getInstance())
                .urlEncodingEnabled(false)
                .queryParam("status", status)
                .accept("application/json")
                .get("/findByStatus").then().assertThat().statusCode(code)
                .extract().response();
    }

    public PetInfo createMyPet(PetInfo petInfo) {
        return given().spec(PetStoreRestAssuredConfig.getInstance())
                .urlEncodingEnabled(false)
                .body(petInfo)
                .accept("application/json")
                .contentType("application/json")
                .post("/").then().assertThat().statusCode(200)
                .extract().response().as(PetInfo.class);
    }

    public PetInfo getByPetId(Long petId) {
        return getResponseByPetId(petId, 200).as(PetInfo.class);
    }

    public Response getResponseByPetId(Object petId, int code) {
        return given().spec(PetStoreRestAssuredConfig.getInstance())
                .urlEncodingEnabled(false)
                .accept("application/json")
                .get("/" + petId).then().assertThat().statusCode(code)
                .extract().response();
    }
}
