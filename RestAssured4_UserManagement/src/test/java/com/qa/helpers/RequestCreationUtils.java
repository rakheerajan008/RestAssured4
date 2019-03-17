package com.qa.helpers;

import java.util.HashMap;

import com.qa.utils.CommonUtils;
import com.qa.utils.ExcelUtil;

import org.json.JSONObject;

public class RequestCreationUtils
{
	public static String getResource(String TCName) {
		try {
			int rowNum = ExcelUtil.findRow(TCName);
			int colNum = ExcelUtil.findcolumn("Resource");
			String resourcePath = ExcelUtil.getCellData(rowNum, colNum);
			return resourcePath;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public static HashMap<String, Object> getPayload(String TCName) {
		try {
			int rowNum = ExcelUtil.findRow(TCName);
			int colNum = ExcelUtil.findcolumn("Payload");
			JSONObject jsonObj = new JSONObject(ExcelUtil.getCellData(rowNum, colNum));
			HashMap<String, Object> Payload = CommonUtils.jsonToMap(jsonObj.toString());
			return Payload;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static HashMap<String, Object> getHeaderParams(String TCName) {
		try {
			int rowNum = ExcelUtil.findRow(TCName);
			int colNum = ExcelUtil.findcolumn("HeaderParams");
			JSONObject jsonObj = new JSONObject(ExcelUtil.getCellData(rowNum, colNum));
			HashMap<String, Object> headerParams = CommonUtils.jsonToMap(jsonObj.toString());
			return headerParams;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static HashMap<String, Object> getQueryParams(String TCName) {
		try {
			int rowNum = ExcelUtil.findRow(TCName);
			int colNum = ExcelUtil.findcolumn("QueryParams");
			JSONObject jsonObj = new JSONObject(ExcelUtil.getCellData(rowNum, colNum));
			HashMap<String, Object> QueryParams = CommonUtils.jsonToMap(jsonObj.toString());
			return QueryParams;	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
