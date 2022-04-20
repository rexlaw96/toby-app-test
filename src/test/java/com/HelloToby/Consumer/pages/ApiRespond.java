package com.HelloToby.Consumer.pages;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public class ApiRespond {
    private static final RequestSpecification request = RestAssured.given();
    private JSONObject JSONObject;
    private Object String;
    private Response getPackageResponse;


        public Response sendApiRequest(JSONObject JSONObject, String String) {
            RestAssured.baseURI = "http://47.89.50.192:8888/api";
            getPackageResponse = request.body(JSONObject).post(String);
            return getPackageResponse;
        }

        public JSONArray getApiRespondQuestions(){
            JSONObject result = this.parseResult();
            JSONObject getRespondData = result.getJSONObject("data");
            System.out.println(getRespondData);
            return getRespondData.getJSONArray("questions");
        }

        public JSONObject parseResult() {
            Object postResult = getPackageResponse.asString();
            return JSON.parseObject((java.lang.String) postResult);
        }

//        public JSONObject getAnswerValue() {
//            Map<String, Object> apiQuestions = (Map<String, Object>) getApiRespondQuestions();;
//            String getQuestionNumber = (String) apiQuestions.get("questionNumber");
//            JSONArray apiPossibleValue = (JSONArray) apiQuestions.get("possibleValues");
//            Object apiValue = (Object) apiPossibleValue.get("value");
//        }
    }

