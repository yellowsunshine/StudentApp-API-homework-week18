package com.studentApp.studentinfo;


import com.studentApp.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;


public class StudentGetTest extends TestBase {

    @Test
    public void getAllStudentsInfo() {
        Response response = given()
                .when()
                .get("/list");//only endpoint needed after extending TestBase
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void getSingleStudentInfo() {
        //WITHOUT PARAMETER
        /*Response response = given()
                .when()
                .get("/3");//only endpoint needed after extending TestBase
        response.then().statusCode(200);
        response.prettyPrint();*/

        //WITH PATH PARAMETER
        Response response = given()
                .pathParam("id", 3)//first parameter is String to give variable name, second is the value
                .when()
                .get("/{id}");//with path parameters
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void searchStudentWithParameter() {
        //WITH QUERY PARAMATERS
        /*Response response = given()
                .queryParam("programme", "Financial Analysis")
                .queryParam("limit", 2)
                .when()
                .get("/3");
        response.then().statusCode(200);
        response.prettyPrint();*/

        HashMap<String, Object> qParams = new HashMap<>();
        qParams.put("programme", "Financial Analysis");
        qParams.put("limit", 2);

        Response response = given()
                //.queryParam("programme", "Financial Analysis")
                //.queryParam("limit", 2)
                .queryParams(qParams)//choose params plural!
                .when()
                .get("/3");
        response.then().statusCode(200);
        response.prettyPrint();

    }




}
