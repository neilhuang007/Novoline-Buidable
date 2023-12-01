package cc.novoline.utils.web;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;

public class JsonObtainer {

    public static JSONObject obtainJson(String url){
        try{
            URL u = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) u.openConnection();
            connection.setRequestMethod("GET");
            connection.addRequestProperty("User-Agent","Mozilla/4.76 (Sk1er-UHCStars V1.0)");
            InputStream is = connection.getInputStream();
            return new JSONObject(IOUtils.toString(is,Charset.defaultCharset()));
        }catch (Exception e){
            e.printStackTrace();
        }
        return new JSONObject().put("succcess",false).put("cause","API_DOWN");
    }

}
