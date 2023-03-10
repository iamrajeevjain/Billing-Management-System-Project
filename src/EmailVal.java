/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author HP
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailVal {
    
    private  static String regex="^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";;
    
        public static boolean isValidEmail(String email) {

       

            Pattern pattern = Pattern.compile(regex);
             Matcher matcher = pattern.matcher(email);
               return matcher.matches();

 
  

   
    }
    
}
