package util;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class ReadJson {

    public JSONObject readJson() {
        try {
            String pathJson = "src/test/resources/data/shipping_address.json";
            JSONParser parser = new JSONParser();
            FileReader fileReader = new FileReader(pathJson);
            Object obj = parser.parse(fileReader);
            return (JSONObject) obj;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
