
/**
 * Write a description of class CaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.io.*;

public class CaesarCipher {
    public String encrypt (String input, int key){
        StringBuilder encrypted = new StringBuilder (input);
        String alphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedAlphabet=alphabet.substring(key)+alphabet.substring(0,key);
        
        for (int i=0;i<input.length();i++){
            char currentCharM=Character.toUpperCase(encrypted.charAt(i));
            int idx=alphabet.indexOf(currentCharM);
            if (idx!=-1){
                encrypted.setCharAt(i,shiftedAlphabet.charAt(idx));         
            }
          
        }
        
        return encrypted.toString();
            
    }
    
    public String encryptTwoKeys(String input,int key1,int key2){
        StringBuilder encrypted = new StringBuilder (input);
        String alphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedAlphabet1=alphabet.substring(key1)+alphabet.substring(0,key1);
        String shiftedAlphabet2=alphabet.substring(key2)+alphabet.substring(0,key2);
        for (int i=0;i<input.length();i++){
            char currentCharM=Character.toUpperCase(encrypted.charAt(i));
            int idx=alphabet.indexOf(currentCharM);
            if (idx!=-1){
                if (((i+1)%2)!=0){
                encrypted.setCharAt(i,shiftedAlphabet1.charAt(idx)); } 
                else {
                encrypted.setCharAt(i,shiftedAlphabet2.charAt(idx));
                }
            }
        }
        return encrypted.toString();
    }
    
    public void testTwoKeys(){
        
        String newPhrase=encryptTwoKeys("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!",8,21);
        System.out.println(newPhrase);
    }
    
    public void testCaesar(){
        int key=15;
        //FileResource fr=new FileResource();
        //String message=fr.asString();
        System.out.println("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!");
        System.out.println(encrypt("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!",key));
    }
    
}
