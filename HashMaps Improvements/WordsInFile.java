
/**
 * Write a description of class WordsInFile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import java.io.*;
import edu.duke.*;


public class WordsInFile {
    private HashMap<String,ArrayList> myMap;

    public WordsInFile(){
        myMap=new HashMap<String,ArrayList>();
    }
    
    private void addWordsFromFile(File f){
            FileResource fr=new FileResource(f);
           for (String word : fr.words()) {
               ArrayList<String> ficheros=new  ArrayList<String>();
               if (!myMap.containsKey(word)){
                   ficheros.add(f.getName());
                   myMap.put(word,ficheros);
                }
                else{
                  ficheros=myMap.get(word);
                  if (!ficheros.contains(f.getName())){
                      ficheros.add(f.getName());
                      myMap.put(word,ficheros);
                  }
                    
                }
           }
        
    }
    
    private void buildWordFileMap (){
        myMap.clear();
        DirectoryResource dr=new DirectoryResource();
        for (File f : dr.selectedFiles()) {
             addWordsFromFile(f);   
         }
    }
    
    public int maxNumber(){
        int maxValue=0;
        for (String s : myMap.keySet()){
            ArrayList<String> element=myMap.get(s);
            if (element.size()>maxValue){
                maxValue=element.size();
            }
        }
        return maxValue;
    }
    
    public ArrayList wordsInNumFiles (int number){
        
        ArrayList<String> selected=new ArrayList<String>();
        for (String word: myMap.keySet()){
            ArrayList<String> element=myMap.get(word);
            if (element.size()==number){
                selected.add(word);
            }
        }
        return selected;
        
    }
    
    public void printFilesIn (String word){
        for (String w: myMap.keySet()){
            if (word.equals(w)){
                ArrayList<String> element=myMap.get(word);
                for (String s: element){
                    System.out.println(s);
                }
            }
        }
    }
    
    public void printMap(){
        for (String w: myMap.keySet()){
            System.out.print(w+" : ");
            ArrayList<String> element=myMap.get(w);
            for (String s: element){
                    System.out.print(s+" ");
            }
            System.out.println();
        }
    }
    
    public void tester(){
        buildWordFileMap();
        System.out.println(myMap.size());
        //printMap();
        /*System.out.println("El maximo número de fichero es: "+maxNumber());
        ArrayList<String> listado=wordsInNumFiles(maxNumber());
        int longitud=listado.size();
        System.out.println("Las palabras que están en ese número máximo son:" +longitud);
        for (String s: listado){
            System.out.println(s);
        }
        ArrayList<String> listado4=wordsInNumFiles(4);
        int tamaño=listado4.size();
        System.out.println("Las palabras que están en 4 son: "+tamaño);
        for (String s: listado4){
            System.out.println(s);
        }*/
        ArrayList<String> listadosad=myMap.get("tree");
        for (String s: listadosad){
            System.out.println(s);
        }
    }
    
}
