package de.canitzp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import org.apache.commons.io.FileUtils;
import sun.misc.IOUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;

public class SteamStore{

    public static String countryCode = Locale.getDefault().getCountry();
    
    public static void main(String[] args){
        int testId = 457140;
        SteamEntry entry = getEntryFromId(testId);
        System.out.println(entry);
    }
    
    public static SteamEntry getEntryFromId(int appId){
        String link = String.format("https://store.steampowered.com/api/appdetails?appids=%s&cc=%s", appId, countryCode);
        try{
            Gson g = new GsonBuilder().setPrettyPrinting().create();
            return g.fromJson(readUrl(link), SteamEntry.class);
        }catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }
    
    private static String readUrl(String urlString) throws IOException{
        BufferedReader reader = null;
        try{
            URL url = new URL(urlString);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuilder buffer = new StringBuilder();
            int read;
            char[] chars = new char[1024];
            while((read = reader.read(chars)) != -1)
                buffer.append(chars, 0, read);
            String s = buffer.toString();
            int index = s.lastIndexOf("\":{\"success\":true,\"data\":");
            return s.substring(index + 25, s.length() - 2);
        }finally{
            if(reader != null)
                reader.close();
        }
    }
    
}
