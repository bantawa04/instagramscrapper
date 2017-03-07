
package edu.lfa.instagramscrapper.grabber;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Grabber {
    public static String grab(String path) throws IOException
    {
        URL url = new URL(path);
        URLConnection conn = url.openConnection();
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line ="";
        StringBuilder box = new StringBuilder();
        
        while((line = reader.readLine()) != null){
            box.append(line+"\r\n");
        }
        return box.toString();
    }
    
    public static void downloadImage(String path, String filename)throws IOException
    {
        URL url = new URL(path);
        URLConnection conn = url.openConnection();    
        
        InputStream is = conn.getInputStream();
        FileOutputStream os = new FileOutputStream(filename);
        
        byte[] data = new byte[1024*5];
        int i =0;
        while((i = is.read(data))!= -1){
            os.write(data, 0, i);
        }

    }
}
