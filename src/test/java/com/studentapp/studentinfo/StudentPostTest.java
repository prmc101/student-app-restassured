package com.studentapp.studentinfo;

import com.studentapp.model.StudentPojo;
import com.studentapp.testbase.TestBase;
import com.studentapp.utils.TestUtils;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

/*
 *  Created by Jay
 */
public class StudentPostTest extends TestBase {

    @Test
    public void createStudent() {
        String email = TestUtils.getRandomValue() +  "Prime@gmail.com";

        List<String> courseList = new ArrayList<>();
        courseList.add("Java");
        courseList.add("Rest Assured");

        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setFirstName("Prime");
        studentPojo.setLastName("Testing");
        studentPojo.setEmail(email);
        studentPojo.setProgramme("Automation Testing");
        studentPojo.setCourses(courseList);

        Response response = given()
                .header("Content-Type", "application/json")
                .when()
                .body(studentPojo)
                .post();
        response.prettyPrint();
        response.then().statusCode(201);
    }
}
