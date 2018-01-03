package com.example.student.personalfinancetracker;

import android.content.Context;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;

/**
 * Created by student on 3/1/2018.
 */

public class IOHelper {
    public static void writeToFile(Context context, JSONObject json){
        try{
            Writer output = null;
            File file = new File(context.getFilesDir(), "data.json");
            output = new BufferedWriter(new FileWriter(file));
            output.write(json.toString());
            output.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public static JSONObject readFromFile(Context context){
        File file = new File(context.getFilesDir() + "/data.json");
        StringBuilder text = new StringBuilder();
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(file));
            String line;

            while ((line = br.readLine()) != null) {
                text.append(line);
                text.append('\n');
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { br.close(); } catch (Exception e) { }
        }

        JSONObject json =  new JSONObject();
        try {
            json = new JSONObject(text.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return json;
    }
}

