//This project is written by Surajit Das and is licensed under Craftsilicon,Nairobi Kenya. The email verifier
//program helps to check the existence of an email id using the Third party API EmailVerfierApp(https://www.emailverifierapi.com/)
//Feel free to use and modify the code and contact @smartsurajit2008@gmail.com


package javaapplication2;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class JavaApplication2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ProtocolException, MalformedURLException, IOException {
        // TODO code application logic here
    Scanner input = new Scanner(System.in);
    
    
    System.out.println("Enter the email id to validate");
    String emailValidate = input.nextLine();
    //String emailValidate = "surajit.das26@craftsilicon.com";
    String apiKey = "PeMUCuqgFxBV6QwfHn8vAzKhapdJk3yL";
    String serviceUri = "https://emailverifierapi.com/v2/";
    String post_data = "apiKey=" + apiKey + "&email=" + emailValidate;
    
   //sending a POSTrequest
   URL obj = new URL(serviceUri);
   HttpURLConnection con = (HttpURLConnection) obj.openConnection();
   con.setRequestMethod("POST");
   con.setDoOutput(true);

   
   byte[] b = post_data.getBytes(StandardCharsets.US_ASCII);
  con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
  con.setRequestProperty("Content-Length",Integer.toString(b.length));
        try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
            wr.write(b, 0, b.length);
        }
  
  
        StringBuilder response;
        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()))) {
            String inputLine;
            response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
        }

		//print result
		System.out.println(response.toString());

        
        
        
        
        
    }
    
}
