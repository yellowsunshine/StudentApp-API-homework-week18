package com.studentApp.studentinfo;


import com.studentApp.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;


public class StudentDeleteTest extends TestBase {

    //Homework
    @Test
    public void deleteStudentWithParameter(){
        Response response = given()
                .pathParam("id", 5)//first parameter is String to give variable name, second is the value
                .when()
                .delete("/{id}");//with path parameters
        response.then().statusCode(204);
        response.prettyPrint();
    }



}
