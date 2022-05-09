
/**
 * Write a description of class Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.io.*;
import edu.duke.*;
import java.util.*;

public class Tester {
    public void testCaesar (){
        FileResource fr=new FileResource();
        String text=fr.asString();
        CaesarCipher cc=new CaesarCipher(8);
        System.out.println(text);
        System.out.println("--------------------------------");
        String encrypted=cc.encrypt(text);
        System.out.println(encrypted);
        System.out.println("--------------------------------");
        System.out.println(cc.decrypt(encrypted));
        System.out.println("--------------------------------");
        
    }
    
    public void testCaesarCracker(){
        FileResource fr=new FileResource();
        String text=fr.asString();
        System.out.println(text);
        CaesarCracker cr=new CaesarCracker();
        System.out.println(cr.decrypt(text));
        FileResource fr2=new FileResource();
        String text2=fr2.asString();
        System.out.println(text2);
        CaesarCracker cr2=new CaesarCracker('a');
        System.out.println(cr2.decrypt(text2));
    }
    
    public void testVigenere(){
         FileResource fr=new FileResource();
         String text=fr.asString();
         int[] key={17, 14, 12, 4};
         VigenereCipher vc=new VigenereCipher(key);
        System.out.println(text);
        System.out.println("--------------------------------");
        String encrypted=vc.encrypt(text);
        System.out.println(encrypted);
        System.out.println("--------------------------------");
        System.out.println(vc.decrypt(encrypted));
        System.out.println("--------------------------------");
         
    }
    
    public void testVigenereBreaker(){
        String text="abcdefghijklm";
        VigenereBreaker vb=new VigenereBreaker();
        System.out.println(vb.sliceString(text,0,3));
        System.out.println(vb.sliceString(text,1,3));
        System.out.println(vb.sliceString(text,2,3));
        System.out.println(vb.sliceString(text,4,5));
    }
    
    public void testtryKey(){
        FileResource fr=new FileResource();
        String text=fr.asString();
        VigenereBreaker vb=new VigenereBreaker();
        int[] keys=vb.tryKeyLength(text,4,'e');
        for (int i=0;i<keys.length;i++){
            System.out.print(" "+keys[i]);
        }
    }
    
    public void testermostCommonCharIn(){
       FileResource fr=new FileResource();
       VigenereBreaker vb=new VigenereBreaker();
       HashSet<String> dictionary=vb.readDictionary(fr);
       System.out.println("El caracter más usado es: "+vb.mostCommonCharIn(dictionary));
    }
}
