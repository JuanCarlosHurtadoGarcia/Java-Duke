
/**
 * Write a description of class DNAHash here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import edu.duke.*;

public class DNAHash {
    private HashMap<String,Integer> myMap;
    
    
    public DNAHash(){
        myMap=new HashMap<String,Integer>();
    }
    
    public void buildCodonMap(int start,String dna){
        
        for (int i=start;i<dna.length()-3;i=i+3){
            String codon=dna.substring(i,i+3);
            if (!myMap.containsKey(codon)){
                myMap.put(codon,1);
            }
            else{
                int ocurrencies=myMap.get(codon);
                myMap.put(codon,ocurrencies+1);
            }
            //System.out.println(codon);
        }
    }
    
    public String getMostCommonCodon(){
        int maxValue=0;
        String maxCodon="";
        for (String s : myMap.keySet()){
            if (myMap.get(s)>maxValue){
                maxValue=myMap.get(s);
                maxCodon=s;
            }
        }
        return maxCodon;
    }
    
    
    public void printCodonCounts(int start,int end){
        int codons=0;
        for (String s : myMap.keySet()){
         int value=myMap.get(s);   
         
         if (value>= start && value<=end){
             System.out.println(s+" : "+value);
             codons++;
         }
        }
        System.out.println("El total de codons diferentes es: "+codons);
    }
    
    public void tester(){
        FileResource fr=new FileResource();
        String dna=fr.asString().toUpperCase();
        System.out.println(dna);
        
        /*for (int i=0;i<=2;i++){
            myMap.clear();
            buildCodonMap (i,dna);
            printCodonCounts(1,5);
            String common=getMostCommonCodon();
            System.out.println("El mas común es: "+common);
            System.out.println("");
        }*/
        myMap.clear();
        buildCodonMap (0,dna);
        printCodonCounts(1,99);
    }
}
