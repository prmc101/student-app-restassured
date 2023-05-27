package com.studentapp.studentinfo;

import com.studentapp.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

/*
 *  Created by Jay
 */
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
        Response response = given()
                .pathParam("id", 5)
                .when()
                .get("/{id}");
        response.prettyPrint();
    }

    @Test
    public void searchStudentWithParameter() {
        Map<String, Object> qParams = new HashMap<>();
        qParams.put("programme", "Disaster Management");
        qParams.put("limit", 2);

        Response response = given()
                /*.queryParam("programme", "Disaster Management")
                .queryParam("limit", 2)*/
                .queryParams(qParams)
                .when()
                .get("/list");
        response.prettyPrint();
    }

}
