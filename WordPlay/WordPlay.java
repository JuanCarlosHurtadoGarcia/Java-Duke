
/**
 * Write a description of class WordPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.io.*;

public class WordPlay {

    public boolean isVowel (char x){
        String vowels="aAeEiIoOuU";
        int id=vowels.indexOf(x);
        if (id==-1){
            return false;}
        else {
                return true;
        }
        
    }
    
    public String replaceVowels (String phrase, char ch){
        StringBuilder newPhrase=new StringBuilder(phrase);
        for (int i=0;i<phrase.length();i++){
            char current=newPhrase.charAt(i);
            if (isVowel(current)){
                newPhrase.setCharAt(i,ch);
            }
        }
        
        return newPhrase.toString();
    }
    
    public String emphasize (String phrase, char ch){
        StringBuilder newPhrase=new StringBuilder(phrase);
        char chM=Character.toLowerCase(ch);
        for (int i=0;i<phrase.length();i++){
            char currentM=Character.toLowerCase(newPhrase.charAt(i));
            if (currentM==chM){
                if ((i+1)%2!=0){
                    newPhrase.setCharAt(i,'*');
                }
                else{
                    newPhrase.setCharAt(i,'+');
                }
            }
            
        }
        
        return newPhrase.toString();
    }
    
    public void testEmphasize(){
        String phrase="Mary Bella Abracadabra";
        System.out.println(phrase);
        System.out.println(emphasize(phrase,'a'));
    }
    
    public void testIsVowel (){
        System.out.println(isVowel('b'));
    }
    
    public void testReplaceVowels (){
        System.out.println(replaceVowels("Hola mUndO",'*'));
    }
}
