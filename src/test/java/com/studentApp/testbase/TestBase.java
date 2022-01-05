package com.studentApp.testbase;

import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestBase {

    @BeforeClass
    public static void inIt(){
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080 ;
        RestAssured.basePath = "/student";
    }
}
