package com.qa.base;

import java.util.HashMap;
import static io.restassured.RestAssured.given;
import io.restassured.response.Response;

public class BaseApi
{
		public Response getRequest(HashMap<String, Object> queryParams, String resource) {
			Response usersListResponse = given()
					.queryParams(queryParams)
					.when()
					.get(resource)
					.then()
					.assertThat()
					.statusCode(200)
					.extract()
					.response();
			return(usersListResponse);
		}
		public Response getRequest(HashMap<String, Object> queryParams, HashMap<String, Object> headerParams , String resource) {
			Response usersListResponse = given()
					.queryParams(queryParams)
					.headers(headerParams)
					.when()
					.get(resource)
					.then()
					.assertThat()
					.statusCode(200)
					.extract()
					.response();
			return(usersListResponse);
		}
		public Response postRequest(HashMap<String, Object> payload, HashMap<String, Object> headerParams, String resource) {
			Response usersListResponse =
					given()
					.headers(headerParams)
					.body(payload)
					.when().
					post(resource)
					.then()
					.assertThat()
					.statusCode(201)
					.extract()
					.response();
			return(usersListResponse);
		}

	}


 
