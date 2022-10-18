package org.hbahuguna.petstore.test;

import io.restassured.response.Response;
import org.hbahuguna.petstore.data.model.Error;
import org.junit.Test;

import static com.shazam.shazamcrest.matcher.Matchers.sameBeanAs;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hbahuguna.petstore.data.beans.ExpectedPetBeans.dog3;

public class GetByPetIdTest extends PetRestAssuredtTestBase{
    @Test
    public void testExistingPetId(){
        assertThat(getByPetId(6L), sameBeanAs(dog3()));
    }

    @Test
    public void testNonExistingPetId(){
        Response response = getResponseByPetId(199929L, 404);
        assertThat(response.as(Error.class), sameBeanAs(Error.builder().build()));
    }

    @Test
    public void testInvalidPetId(){
        Response response = getResponseByPetId("invlaid", 404);
        assertThat(response.as(Error.class), sameBeanAs(Error.builder()
                .message("java.lang.NumberFormatException: For input string: \"invlaid\"")
                .type("unknown")
                .code(404)
                .build()));
    }
}
