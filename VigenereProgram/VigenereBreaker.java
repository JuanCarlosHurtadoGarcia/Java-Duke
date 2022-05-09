import java.util.*;
import edu.duke.*;
import java.io.*;

public class VigenereBreaker {
    public String sliceString(String message, int whichSlice, int totalSlices) {
        String slice="";
        for (int i=whichSlice;i<message.length();i=i+totalSlices){
          slice=slice+message.charAt(i);     
        }
        
        return slice;
    }

    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
        int[] key = new int[klength];
        for (int i=0;i<klength;i++){
            CaesarCracker cr=new CaesarCracker(mostCommon);
            String slice=sliceString(encrypted,i,klength);
            int indKey=cr.getKey(slice);
            key[i]=indKey;
        }
        
        return key;
    }

    public void breakVigenere () {
        System.out.println("Elige el texto a desencriptar: ");
        FileResource fr=new FileResource();
        String text=fr.asString();
        HashMap <String,HashSet<String>> diccionarios=new HashMap <String,HashSet<String>>();
        //
        String[] languages=new String[]{"danish","dutch","english","french","german","italian","portuguese","spanish"};
        
        for (int i=0;i<languages.length;i++){
            System.out.println("Elegir diccionario de: "+languages[i]);
            FileResource fr2=new FileResource();
            HashSet<String> dictionary=readDictionary(fr2);
            diccionarios.put(languages[i],dictionary);
        }
        
        breakForAllLangs(text,diccionarios);
        //
        //FileResource fr2=new FileResource();
        //HashSet<String> dictionary=readDictionary(fr2);
        //System.out.println(breakForLanguage(text,dictionary));
        //int[] keys=tryKeyLength(text,4,'e');
        //VigenereCipher vc=new VigenereCipher(keys);
        //System.out.println(vc.decrypt(text));
    }
    
    public HashSet<String> readDictionary (FileResource fr){
        HashSet<String> dictionary=new HashSet<String>();
        for (String word : fr.lines()){
            dictionary.add(word.toLowerCase());
        }
        return dictionary;
    }
    
    public int countWords (String message, HashSet<String> dictionary){
        int realWords=0;
        for (String word : message.split("\\W+")){
            if (dictionary.contains(word.toLowerCase())){
                realWords++;
            }
        }
        return realWords;
    }
    
    public char mostCommonCharIn (HashSet<String> dictionary){
        
        int index=0;
        int[] counts = new int[26];
        String alph = "abcdefghijklmnopqrstuvwxyz";
        CaesarCracker cr=new CaesarCracker(); 
          counts=cr.countLetters(String.join(" ",dictionary));     
          index=cr.maxIndex(counts);  
          return alph.charAt(index);
     }
     
     /*public char mostCommonCharIn2 (String text){
        int index=0;
        int[] counts = new int[26];
        String alph = "abcdefghijklmnopqrstuvwxyz";
        CaesarCracker cr=new CaesarCracker();
        counts=cr.countLetters(text);     
          index=cr.maxIndex(counts);  
          return alph.charAt(index);
     }*/
    
     public void breakForAllLangs (String encrypted, HashMap<String,HashSet<String>> languages){
         int maxWords=0;
         String idioma=null;
         String Finaldecrypted=null;
         
         for(String language : languages.keySet()){
           HashSet<String> dictionary=languages.get(language);
           System.out.println("Estamos desencriptando "+language);
           String decrypted=breakForLanguage(encrypted,dictionary);
           System.out.println("Hemos desencriptado "+language);
           int count=countWords(decrypted,dictionary);
           System.out.println("Tenemos en "+language+" un total de palabras de "+count);
           if (count>maxWords){
               idioma=language;
               Finaldecrypted=decrypted;
           }
         }
         
         System.out.println("El idioma usado es: "+idioma);
         System.out.println(Finaldecrypted);

     }
        
    
    
    public String breakForLanguage ( String encrypted, HashSet<String> dictionary){
        String Bestdecrypted="";
        int max=0;
        int ind=0;
        char letter=mostCommonCharIn(dictionary);
        System.out.println("La letra mas común en el diccionario es: "+letter);
        for (int i=1;i<=100;i++){
            int[] keys=tryKeyLength(encrypted,i,letter);
            VigenereCipher vc=new VigenereCipher(keys);
            String decrypted=vc.decrypt(encrypted);
            int count=countWords(decrypted,dictionary);
            
            if (count>max){
                max=count;
                ind=i;
                Bestdecrypted=decrypted;
            }
            
        }
        System.out.println("Real Words: "+max);
        System.out.println("Lenght :"+ind);
        return Bestdecrypted;
    }
}
