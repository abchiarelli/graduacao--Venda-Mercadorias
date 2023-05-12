/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package apoio;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author artur
 */
public class VerificaDados {
    
    public boolean nome(String nome) {
        String regex = "^[[a-zA-Z]\\s]+$";
        
        return verificaString(regex, nome);
    }
    
    public boolean email(String email) {
        String regex = "\\w+@[a-z0-9]+[.][a-z]{2,3}";
                
        return verificaString(regex, email);
    }
    
    private boolean verificaString(String regex, String termo) {
        Pattern patter = Pattern.compile(regex);
        Matcher matcher = patter.matcher(termo);
        
        return matcher.matches();
    }
}
