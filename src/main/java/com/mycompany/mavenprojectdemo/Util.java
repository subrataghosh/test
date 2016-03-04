/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenprojectdemo;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author bilesh
 */
public class Util {

    public static void print(String message) {
        System.out.println(message);
    }

    public static void printJson(String json) {
        JSONParser parser = new JSONParser();

        try {
            JSONObject obj = (JSONObject) parser.parse(json);

            printJsonObject(obj);
        } catch (ParseException pe) {

            System.out.println("Position: " + pe.getPosition());
            System.out.println(pe);
        }
    }

    private static void printJsonObject(JSONObject jsonObj) {
        for (Object key : jsonObj.keySet()) {
            //based on you key types
            String keyStr = (String) key;
            Object keyvalue = jsonObj.get(keyStr);

            //Print key and value
            System.out.println(keyStr + " = " + keyvalue);

            //for nested objects iteration if required
            if (keyvalue instanceof JSONObject) {
                printJsonObject((JSONObject) keyvalue);
            }
        }
    }
}
