package com.studentApp.studentinfo;


import com.studentApp.model.StudentPojo;
import com.studentApp.testbase.TestBase;
import com.studentApp.utils.TestUtils;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;


public class StudentPatchTest extends TestBase {

    @Test
    public void updateStudentWithPatch(){

        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setEmail(TestUtils.getRandomText()+"@gmail.com");

        Response response = given()
                .header("Content-Type", "application/json")
                .pathParam("id", 10)
                .body(studentPojo)
                .when()
                .patch("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();


    }
}
