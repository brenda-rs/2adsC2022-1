package br.com.sptech.eagle.back;

import java.io.IOException;
import org.jfree.data.json.impl.JSONObject;

/**
 *
 * @author gustavo.caxile
 */
public class TesteSlack {
 
    public static void main(String[] args) throws IOException, InterruptedException{
        
        JSONObject json = new JSONObject();
        
        json.put("text", "Fácil né? :shrug:");
        
        Slack.sendMessage(json);
    }
}
