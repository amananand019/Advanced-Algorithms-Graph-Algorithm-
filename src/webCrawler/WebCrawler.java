package webCrawler;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebCrawler {
    private Queue<String> queue;
    private List<String> discoveredWebsiteList;

    public WebCrawler(){
        this.queue = new LinkedList<>();
        this.discoveredWebsiteList = new ArrayList<>();

    }

    public void discoverWeb(String root){
        this.queue.add(root);
        this.discoveredWebsiteList.add(root);

        while (!queue.isEmpty()){
            String v = this.queue.remove();
            String rawhtml = readURL(v);

            String regEx = "http://(\\w+\\.)*(\\w+)";
            Pattern pattern = Pattern.compile(regEx);
            Matcher matcher = pattern.matcher(rawhtml);

            while(matcher.find()){
                String actualURL = matcher.group();

                if(!discoveredWebsiteList.contains(actualURL)){
                    discoveredWebsiteList.add(actualURL);
                    System.out.println("Website has been found with URLs "+actualURL);
                    queue.add(actualURL);
                }
            }
        }
    }

    private String readURL(String v) {
        String rawhtml = "";
        try{
            URL url = new URL(v);
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

            String inputLine = "";
            while ((inputLine = in.readLine()) != null){
                rawhtml += inputLine;
            }
            in.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return rawhtml;
    }
}
