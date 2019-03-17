package com.qa.tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.sql.SQLException;


import com.qa.base.BaseApi;
import com.qa.helpers.RequestCreationUtils;
import com.qa.utils.ExcelUtil;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class UserManagement extends BaseApi
{
	@BeforeSuite
	private void checkLogin() throws Exception {
		System.out.println("Before Suite");
		ExcelUtil.setExcelFile(System.getProperty("user.dir") +"\\src\\main\\Resources\\com\\qa\\TestData\\TestData.xlsx", "UserManagement");
	}
	@BeforeTest
	public void getdata() {
		try {
			RestAssured.baseURI = "http://localhost:3000";
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 1)
	public void getAllAutomotiveUsers() {
		try {
			System.out.println("Query Parameters ::");
			System.out.println(RequestCreationUtils.getQueryParams("GetAutomotiveUsers").toString());
			System.out.println("------------------------");
			System.out.println("Resource ::");
			System.out.println(RequestCreationUtils.getResource("GetAutomotiveUsers"));
			System.out.println("------------------------");
			Response usersListResponse = getRequest(RequestCreationUtils.getQueryParams("GetAutomotiveUsers"),RequestCreationUtils.getResource("GetAutomotiveUsers"));
			String usersListResponseString = usersListResponse.asString();
			System.out.println(usersListResponseString);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test(priority = 2)
	public void addNewAutomotiveUser() {
		try {
			System.out.println("Payload ::");
			System.out.println(RequestCreationUtils.getPayload("AddNewUser").toString());
			System.out.println("------------------------");
			System.out.println("Headers ::");
			System.out.println(RequestCreationUtils.getHeaderParams("AddNewUser").toString());
			System.out.println("------------------------");
			System.out.println("Resource ::");
			System.out.println(RequestCreationUtils.getResource("AddNewUser"));
			System.out.println("------------------------");
			Response addUserResponse = postRequest(RequestCreationUtils.getPayload("AddNewUser"), RequestCreationUtils.getHeaderParams("AddNewUser"),RequestCreationUtils.getResource("AddNewUser"));
			String addUserResponseString = addUserResponse.asString();
			System.out.println(addUserResponseString);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterTest
	public void clearRequest() {
		System.out.println("After Test");
	}

	@AfterSuite
	public void dbdisconnect() throws SQLException {
		System.out.println("After Suite");
	}

}


