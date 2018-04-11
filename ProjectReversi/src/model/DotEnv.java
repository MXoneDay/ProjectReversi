package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class DotEnv {
    Map<String, String> values = new HashMap<String, String>();
    BufferedReader env;

    {
        try {
            env = new BufferedReader(new FileReader(".env"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public DotEnv() throws IOException {

        for (String line = env.readLine(); line != null; line = env.readLine()) {
            String key = line.split("=")[0];
            String value = line.split("=")[1];

            values.put(key, value);
        }
    }

    public String get(String key){
        return values.get(key);
    }

}
