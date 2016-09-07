/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.adminstrator.ricrypton;

/**
 *
 * @author Richard
 */
import java.util.HashMap;
public class MorseCode {

    /**
     * @param args the command line arguments
     */
    
    public static final HashMap<String,String> map=new HashMap<>();
  
    //initializing HashMap object
    static
    {
        map.put("A", ".-");     map.put("B", "-...");   map.put("C", "-.-.");   map.put("D", "-..");    map.put("E", ".");
        map.put("F", "..-.");   map.put("G", "--.");    map.put("H", "....");   map.put("I", "..");     map.put("J", ".---");    
        map.put("K", "-.-");    map.put("L", ".-..");   map.put("M", "--");     map.put("N", "-.");     map.put("O", "---");
        map.put("P", ".--.");   map.put("Q","--.-");    map.put("R", ".-.");    map.put("S", "...");    map.put("T", "-");
        map.put("U", "..-");    map.put("V", "...-");   map.put("W", ".--");    map.put("X", "-..-");   map.put("Y", "-.--");
        map.put("Z", "--..");   map.put("1", ".----");  map.put("2", "..---");  map.put("3","...--");     map.put("4", "....-");
        map.put("5", ".....");  map.put("6","-....");   map.put("7","--...");    map.put("8", "---..");    map.put("9", "----.");
        map.put("0", "-----");  map.put(".", ".-.-.-");    map.put(",","--..--");    map.put("?", "..--..");    map.put("'",".----.");
        map.put("!", "-.-.--");    map.put("/", "-..-.");    map.put("(", "-.--.");    map.put(")", "-.--.-");    map.put("&", ".-...");
        map.put(":", "---...");    map.put(";", "-.-.-.");    map.put("=", "-...-");    map.put("+", ".-.-.");    map.put("-", "-....-");
        map.put("_", "..--.-");    map.put("\"", ".-..-.");    map.put("$", "...-..-");    map.put("@",".--.-.");    map.put("", "|");
    }
    
    public String encode(String text)
    {
        String morse = "";

            String modtext = "";
            //join text with comma delimetre
            for (int i = 0; i < text.length(); i++) {
                modtext += text.substring(i, i + 1) + ",";
            }
            modtext = modtext.replaceAll(" ", "");
            //split modtext into an array
            String[] textList = modtext.split(",");
            //iterate throug each figure in textList
            for (String item:textList )
            {

                if (map.get(item.toUpperCase()) == null)
                    morse+=item;
                else
                    morse+=map.get(item.toUpperCase())+" ";

            }





        return morse;
    }

}
