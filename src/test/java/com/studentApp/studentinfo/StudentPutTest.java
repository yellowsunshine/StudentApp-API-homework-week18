package com.studentApp.studentinfo;

import com.studentApp.model.StudentPojo;
import com.studentApp.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;


public class StudentPutTest extends TestBase {

    //Homework
    /*
    Use same pojo, use by creating new object
     */
    @Test
    public void updateStudent() {
    List<String> courseList = new ArrayList<>();
        courseList.add("Java");
        courseList.add("Selenium");

    StudentPojo studentPojo = new StudentPojo();
        studentPojo.setFirstName("Abc");
        studentPojo.setLastName("Testing");
        studentPojo.setEmail("primetesting2@gmail.com");
        studentPojo.setProgramme("Automation Testing");
        studentPojo.setCourses(courseList);

    Response response = given()
            .header("Content-Type", "application/json")
            // .header((ContentType.JSON))
            .body(studentPojo)
            .when()
            .put("/2");//blank as there is no endpoint here
        response.then().statusCode(200);
        response.prettyPrint();

}



}
