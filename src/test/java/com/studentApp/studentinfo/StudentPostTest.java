package com.studentApp.studentinfo;


import com.studentApp.model.StudentPojo;
import com.studentApp.testbase.TestBase;
import com.studentApp.utils.TestUtils;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;


public class StudentPostTest extends TestBase {

    @Test
    public void createStudent() {
        List<String> list = new ArrayList<>();
        list.add("Selenium");
        list.add("Java");

        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setFirstName(TestUtils.getRandomText());
        studentPojo.setLastName(TestUtils.getRandomText());
        studentPojo.setEmail(TestUtils.getRandomText()+"@gmail.com");
        studentPojo.setProgramme("Automation Testing");
        studentPojo.setCourses(list);

        Response response = given()
                .contentType(ContentType.JSON)
                .body(studentPojo)
                .when()
                .post();
        response.then().statusCode(201);
        response.prettyPrint();
    }
}
