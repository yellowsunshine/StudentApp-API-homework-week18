package com.studentApp.studentinfo;


import com.studentApp.testbase.TestBase;
import io.restassured.internal.RestAssuredResponseImpl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class StudentGetTest extends TestBase {

    @Test
    public void getAllStudentsInfo() {
        Response response = given()
                .when()
                .get("/list");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void getSingleStudentInfo() {
        //WITHOUT PARAMETER
        Response response = given()
                .when()
                .get("/3");
        response.then().statusCode(200);
        response.prettyPrint();

    }

    @Test
    public void getSingleStudentInfoWithPathParameter() {
        //WITH PATH PARAMETER
        Response response1 = given()
                .pathParam("id", 10)
                .when()
                .get("/{id}");
        response1.then().statusCode(200);
        response1.prettyPrint();
    }

    @Test
    public void searchStudentWithParameter() {
        //WITH QUERY PARAMETERS "programme", "Financial Analysis" & "limit", 2 as map
        HashMap<String, Object> qParams = new HashMap<>();
        qParams.put("programme", "Financial Analysis");
        qParams.put("limit", 2);

        Response response = given()
                .queryParams(qParams)
                .when()
                .get("/list");
        response.then().statusCode(200);
        response.prettyPrint();
    }

}





