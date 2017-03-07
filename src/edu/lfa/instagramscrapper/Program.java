
package edu.lfa.instagramscrapper;

import edu.lfa.instagramscrapper.grabber.Grabber;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Program {

    public static void main(String[] args) {
        System.out.println("Instagram Scrapper");
        System.out.println("For educational purpose only:");
        System.out.println("*******************************");
        
        String baseURL = "https://www.instagram.com/";    
        
        Scanner input = new Scanner(System.in);
        System.out.println("Enter username:");
        String username = input.next();
        
        try{
            String box = Grabber.grab(baseURL + username);
            String regex = "https://(.*?).jpg";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(box);
            
            while (matcher.find()){
//                System.out.println(matcher.group(0));
                String imgPath = matcher.group(0);
                String path = (imgPath);
                String[] tokens = path.split("/");
                
                File file = new File("C:\\Users\\bantawa04\\Desktop\\Insta");
                
                if (!file.isDirectory()) {
                    file.mkdir();
                }
                
                File userFile = new File("C:\\Users\\bantawa04\\Desktop\\Insta\\" + username);
                if (!userFile.isDirectory()) {
                    userFile.mkdir();
                }           
                System.out.println("Downloading ==========================>");
                
                Grabber.downloadImage(path, "C:\\Users\\bantawa04\\Desktop\\Insta\\" + username+"\\"+tokens[tokens.length-1]);
            }
            System.out.println("Download complete");
        }catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
        
    }
    
}
