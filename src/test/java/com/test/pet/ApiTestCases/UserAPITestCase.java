package com.test.pet.ApiTestCases;

import dataCreationFromModel.UserDataCreator;
import dataModel.UserP;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import utils.Properties;

import java.util.List;

import static io.restassured.RestAssured.given;

public class UserAPITestCase extends BaseTest {
	
    private String username = "";

    @Test(priority = 0)
    public void createListOfUser() {

        UserDataCreator us = new UserDataCreator();
        List<UserP> listOfUser = us.createUser(1);
        username = listOfUser.get(0).getUsername();
        Response response = given()
                .filter(new RequestLoggingFilter(captor))
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .log()
                .all()
                .body(listOfUser) //passing obj in request body
                .post(Properties.createMultipleUserEndPoint);
        response.prettyPrint();

        response.then().statusCode(200);

        writeRequestAndResponseInReport(writer.toString(), response.prettyPrint());
    }

    @Test(dependsOnMethods = "createListOfUser", priority = 1)
    public void getUserDetail() {
        System.out.println(username);
        Response response = given()
                .filter(new RequestLoggingFilter(captor))
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .log()
                .all()
                .get(String.format("/user/%s", username));
        response.prettyPrint();

        response.then().statusCode(200);
        writeRequestAndResponseInReport(writer.toString(), response.prettyPrint());
    }

}