
/**
 * Write a description of class CaesarBreakerClass here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.io.*;
import edu.duke.*;

public class CaesarBreakerClass {
     
     public int [] countLetters (String message){
         String alph="abcdefghijklmnopqrstuvwxyz";
         int [] counts=new int [26];
         for (int k=0;k<message.length();k++){
             char ch=Character.toLowerCase(message.charAt(k));
             int dex=alph.indexOf(ch);
             if (dex!=-1){
                 counts[dex]+=1;
             }
          }
          return counts;
     }
     
     public String decrypt (String encrypted){
         CaesarCipher cc=new CaesarCipher();
         int [] freqs= countLetters(encrypted);
         int maxDex= maxIndex (freqs);
         int dkey= maxDex-4;
         if (maxDex<4){
             dkey=26-(4-maxDex);
         }
        
        return cc.encrypt(encrypted,26-dkey);
        
     }
     
     public int maxIndex(int [] vals){
         int maxDex=0;
         for (int k=0;k<vals.length;k++){
             if (vals[k]>vals[maxDex]){
                 maxDex=k;
            }
        }
        return maxDex;
     }
     
      public String halfOfString (String message, int start){
          String half="";
          for (int k=start;k<message.length();k=k+2){
              half=half+message.charAt(k);
          }
          return half;
      }
     
      public int getKey(String s){
          int [] freqs=countLetters(s);
          int maxDex=maxIndex(freqs);
          int dkey= maxDex-4;
         if (maxDex<4){
             dkey=26-(4-maxDex);
         }
         return dkey;
      }
      
      
      public void decryptTwoKeys (String encrypted){
          String s1=halfOfString(encrypted,0);
          String s2=halfOfString(encrypted,1);
          System.out.println(encrypted);
          System.out.println("Key 1: "+getKey(s1));
          System.out.println("Key 2: "+getKey(s2));
          s1=decrypt(s1);
          s2=decrypt(s2);
          String decrypted="";
          int inds1=0;
          int inds2=0;
          for (int k=0;k<(s1.length()+s2.length());k++){
              
                if (((k+1)%2)!=0){
                decrypted=decrypted+(s1.charAt(inds1));
                  inds1++;} 
                else {
                decrypted=decrypted+(s2.charAt(inds2));
                  inds2++;
                } 
          }
          System.out.println(decrypted);
        }
        
      public void testDecryptTwoKeys(){
          String message="Top ncmy qkff vi vguv vbg ycpx";
          int key1=2;
          int key2=20;
          CaesarCipher cc=new CaesarCipher();
          String encrypted2=cc.encryptTwoKeys(message,key1,key2);
          System.out.println(message);
          decryptTwoKeys(encrypted2);
        }
       
       public void testExam2(){
           FileResource fr=new FileResource();
           String message=fr.asString();
           decryptTwoKeys(message);
           
        }
        
        
        
      public void testExam(){
          String encrypted="Top ncmy qkff vi vguv vbg ycpx";
          int key1=2;
          int key2=20;
          String s1=halfOfString(encrypted,0);
          String s2=halfOfString(encrypted,1);
          CaesarCipher cc=new CaesarCipher();
          s1=cc.encrypt(s1,26-key1);
          s2=cc.encrypt(s2,26-key2);
          String decrypted="";
          int inds1=0;
          int inds2=0;
          for (int k=0;k<(s1.length()+s2.length());k++){
              
                if (((k+1)%2)!=0){
                decrypted=decrypted+(s1.charAt(inds1));
                  inds1++;} 
                else {
                decrypted=decrypted+(s2.charAt(inds2));
                  inds2++;
                } 
          }
          System.out.println(decrypted);
        }
      
      public void testHalf(){
          String message="Qbkm Zgis";
          System.out.println(message);
          System.out.println(halfOfString(message,0));
          System.out.println(halfOfString(message,1));
        }
        
     
     public void testDecrypt(){
         String message="Just a test string with lots of eeeeeeeeeeeeeeeees";
         int key=9;
         System.out.println(message);
         CaesarCipher cc=new CaesarCipher();
         String encrypted=cc.encrypt(message,key);
         System.out.println(encrypted);
         System.out.println(decrypt(encrypted));
        
     }
        
     
}
