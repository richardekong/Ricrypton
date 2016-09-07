/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.adminstrator.ricrypton;


/**
 *
 * @author Richard
 */

public class DecodeMorseCode 
{
  //An array to hold space and morse code characters equivalent(alphabets, numbers and some special characters)
  private static String [] Morse={" ", ".-..-.", "-.-.--", ".-...", ".----.", "...-..-", ".-.-.", "-.--.", 
                                   "-.--.-", ".-.-.-", "-..-.", "--..--", "-....-", "...--", "..---", ".----", "-----",
                                   "--...", "-....", ".....", "....-", "-.-.-.", "---...", "----.", "---..", "..--..", "-...-",
                                   "-..", ".", "..-.", "--.", ".--.-.", ".-", "-...", "-.-.", ".-..", "--", "-.", "---", "....",
                                   "..", ".---", "-.-", "..-", "-", ".--", "...-", "--.-", ".--.", "...", ".-.", "..--.-", "-.--",
                                   "-..-", "--.."};
  //An array containing english alphabets, arabic numerals and special characters
  private static String [] Eng={"|","\"","!","&","'", "$", "+", "(", ")", ".", "/", ",","-", "3", "2", "1", "0", "7", "6", "5", "4", ";", ":", "9", "8", "?", "=", "D", "E", "F", "G", "@", "A", "B", "C", "L", "M", "N", "O", "H", "I", "J", "K", "U", "T", "W", "V", "Q", "P", "S", "R", "_", "Y", "X", "Z"};
  
 
 

/**
   * Algorithm for decode method
   * 1. create variable to hold the morse code value to be translated
   * 2. create variable space, decodedValue and final decoded Value
   * 3. split morse code in to an array of words with the '|' delimetre
   * 4. loop through each word in the array of words
   * 5. within the loop: 
   *                    i.  split each word into an array of characters with the space character delimeter  
   *                    ii. check if character is empty, continue the loop even if it's empty
   *                    iii.loops through the array containing morse code values, and decode every '.' to 'E's and '-' to 'T's
   *                              within the current loop, if the character equals items in array1, concatinate character's english equivalent to decoded value
   * 6. replace all '|' characters within decoded value with a space character
   * 7. loop through the decoded items:
   *            i.if they contain any combination of 'E's and 'T's:
   *                        concatinate representative character equivalent to finalDecodedValue
   *            else:
   *                   concatinate the item within the decoded array to finalDecodedValue
   * 8. return the value of finalDecodedValue in sentence case                   
   
  **/  
 public String decode (String MorseCode)
 {
     
     String space=" ";
     String decodedValue="";
     String finalDecodedValue="";
     String exp="";
     String [] words=MorseCode.split("|");//splits morse code in to an array of words with the '|' delimetre
     
     for (String word:words)//loops through each word in the array of words
     {
         
         String [] Characters=word.split("");//split each word into an array of characters
         for (String character:Characters)//loops through each character in word
         {
             
             if (character.isEmpty())//checks if character is empty, continue the loop even if it's empty 
             {
                 continue;
             }
             
             for (int i=0; i<Morse.length;i++)//loops through the array containing morse code values, and decode every '.' to 'E's and '-' to 'T's
             {
                 if (character.equals(Morse[i]))//if the character equals items in Morse, concatinate character's english equivalent to decoded value
                       decodedValue+=Eng[i];
             }
            }
     }
      decodedValue=decodedValue.replace("|", " ");//replace all '|' characters within decoded value with a space character
      
      String [] decoded=decodedValue.split(" "); //split decoded value into an array of decoded strings with the space character delimeter
      
      for (int k=0;k<decoded.length;k++)//loop through the decoded items within the decode array
      {
          System.out.println(decoded[k]);
          //Note that combinations of 'E's('.') and 'T's ('-') represents a particular english letter, arabic numeral or special character 
          //Alphabet decoding
          if (decoded[k].equals(""))
          {
              decoded[k]=space;
              finalDecodedValue+=decoded[k];
          }
          else if (decoded[k].equalsIgnoreCase("ET"))
          {
              decoded[k]="A";
              finalDecodedValue+=decoded[k];
          }
          else if(decoded[k].equalsIgnoreCase("TEEE"))
          {
              decoded[k]="B";
              finalDecodedValue+=decoded[k];
          }
          else if(decoded[k].equalsIgnoreCase("TETE"))
          {
              decoded[k]="C";
              finalDecodedValue+=decoded[k];
          }
          else if(decoded[k].equalsIgnoreCase("TEE"))
          {
              decoded[k]="D";
              finalDecodedValue+=decoded[k];
          }
          else if(decoded[k].equalsIgnoreCase("E"))
          {
              decoded[k]="E";
              finalDecodedValue+=decoded[k];
          }
          else if(decoded[k].equalsIgnoreCase("EETE"))
          {
              decoded[k]="F";
              finalDecodedValue+=decoded[k];
          }
          else if(decoded[k].equalsIgnoreCase("TTE"))
          {
              decoded[k]="G";
              finalDecodedValue+=decoded[k];
          }
          else if(decoded[k].equalsIgnoreCase("EEEE"))
          {
              decoded[k]="H";
              finalDecodedValue+=decoded[k];
          }
          else if(decoded[k].equalsIgnoreCase("EE"))
          {
              decoded[k]="I";
              finalDecodedValue+=decoded[k];
          }
          else if(decoded[k].equalsIgnoreCase("ETTT"))
          {
              decoded[k]="J";
              finalDecodedValue+=decoded[k];
          }
          else if(decoded[k].equalsIgnoreCase("TET"))
          {
              decoded[k]="K";
              finalDecodedValue+=decoded[k];
          }
          else if(decoded[k].equalsIgnoreCase("ETEE"))
          {
              decoded[k]="L";
              finalDecodedValue+=decoded[k];
          }
          else if(decoded[k].equalsIgnoreCase("TT"))
          {
              decoded[k]="M";
              finalDecodedValue+=decoded[k];
          }
          else if(decoded[k].equalsIgnoreCase("TE"))
          {
              decoded[k]="N";
              finalDecodedValue+=decoded[k];
          }
          else if(decoded[k].equalsIgnoreCase("TTT"))
          {
              decoded[k]="O";
              finalDecodedValue+=decoded[k];
          }
          else if(decoded[k].equalsIgnoreCase("ETTE"))
          {
              decoded[k]="P";
              finalDecodedValue+=decoded[k];
          }
          else if(decoded[k].equalsIgnoreCase("TTET"))
          {
              decoded[k]="Q";
              finalDecodedValue+=decoded[k];
          }
          else if(decoded[k].equalsIgnoreCase("ETE"))
          {
              decoded[k]="R";
              finalDecodedValue+=decoded[k];
          }
          else if(decoded[k].equalsIgnoreCase("EEE"))
          {
              decoded[k]="S";
              finalDecodedValue+=decoded[k];
          }
          else if(decoded[k].equalsIgnoreCase("T"))
          {
              decoded[k]="T";
              finalDecodedValue+=decoded[k];
          }
          else if(decoded[k].equalsIgnoreCase("EET"))
          {
              decoded[k]="U";
              finalDecodedValue+=decoded[k];
          }
          else if(decoded[k].equalsIgnoreCase("EEET"))
          {
              decoded[k]="V";
              finalDecodedValue+=decoded[k];
          }
          else if(decoded[k].equalsIgnoreCase("ETT"))
          {
              decoded[k]="W";
              finalDecodedValue+=decoded[k];
          }
          else if(decoded[k].equalsIgnoreCase("TEET"))
          {
              decoded[k]="X";
              finalDecodedValue+=decoded[k];
          }
          else if(decoded[k].equalsIgnoreCase("TETT"))
          {
              decoded[k]="Y";
              finalDecodedValue+=decoded[k];
          }
          else if(decoded[k].equalsIgnoreCase("TTEE"))
          {
              decoded[k]="Z";
              finalDecodedValue+=decoded[k];
          }
          //Number decoding
          else if(decoded[k].equalsIgnoreCase("ETTTT"))
          {
              decoded[k]="1";
              finalDecodedValue+=decoded[k];
          }
          else if(decoded[k].equalsIgnoreCase("EETTT"))
          {
              decoded[k]="2";
              finalDecodedValue+=decoded[k];
          }
          else if(decoded[k].equalsIgnoreCase("EEETT"))
          {
              decoded[k]="3";
              finalDecodedValue+=decoded[k];
          }
          else if(decoded[k].equalsIgnoreCase("EEEET"))
          {
              decoded[k]="4";
              finalDecodedValue+=decoded[k];
          }
          else if(decoded[k].equalsIgnoreCase("EEEEE"))
          {
              decoded[k]="5";
              finalDecodedValue+=decoded[k];
          }
          else if(decoded[k].equalsIgnoreCase("TEEEE"))
          {
              decoded[k]="6";
              finalDecodedValue+=decoded[k];
          }
          else if(decoded[k].equalsIgnoreCase("TTEEE"))
          {
              decoded[k]="7";
              finalDecodedValue+=decoded[k];
          }
          else if(decoded[k].equalsIgnoreCase("TTTEE"))
          {
              decoded[k]="8";
              finalDecodedValue+=decoded[k];
          }
          else if(decoded[k].equalsIgnoreCase("TTTTE"))
          {
              decoded[k]="9";
              finalDecodedValue+=decoded[k];
          }
          else if(decoded[k].equalsIgnoreCase("TTTTT"))
          {
              decoded[k]="0";
              finalDecodedValue+=decoded[k];
          }
          //Special character
          else if(decoded[k].equalsIgnoreCase("ETETET"))
          {
              decoded[k]=".";
              finalDecodedValue+=decoded[k];
          }
          else if(decoded[k].equalsIgnoreCase("TTEETT"))
          {
              decoded[k]=",";
              finalDecodedValue+=decoded[k];
          }
          else if(decoded[k].equalsIgnoreCase("EETTEE"))
          {
              decoded[k]="?";
              finalDecodedValue+=decoded[k];
          }
          else if(decoded[k].equalsIgnoreCase("ETTTTE"))
          {
              decoded[k]="'";
              finalDecodedValue+=decoded[k];
          }
          else if(decoded[k].equalsIgnoreCase("TETETT"))
          {
              decoded[k]="!";
              finalDecodedValue+=decoded[k];
          }
          else if(decoded[k].equalsIgnoreCase("TEETE"))
          {
              decoded[k]="/";
              finalDecodedValue+=decoded[k];
          }
          else if(decoded[k].equalsIgnoreCase("TETTE"))
          {
              decoded[k]="(";
              finalDecodedValue+=decoded[k];
          }
          else if(decoded[k].equalsIgnoreCase("TETTET"))
          {
              decoded[k]=")";
              finalDecodedValue+=decoded[k];
          }
          else if(decoded[k].equalsIgnoreCase("ETEEE"))
          {
              decoded[k]="&";
              finalDecodedValue+=decoded[k];
          }
          else if(decoded[k].equalsIgnoreCase("TTTEEE"))
          {
              decoded[k]=":";
              finalDecodedValue+=decoded[k];
          }
          else if(decoded[k].equalsIgnoreCase("TETETE"))
          {
              decoded[k]=";";
              finalDecodedValue+=decoded[k];
          }
          else if(decoded[k].equalsIgnoreCase("TEEET"))
          {
              decoded[k]="=";
              finalDecodedValue+=decoded[k];
          }
          else if(decoded[k].equalsIgnoreCase("ETETE"))
          {
              decoded[k]="+";
              finalDecodedValue+=decoded[k];
          }
          else if(decoded[k].equalsIgnoreCase("TEEEET"))
          {
              decoded[k]="-";
              finalDecodedValue+=decoded[k];
          }
          else if(decoded[k].equalsIgnoreCase("EETTET"))
          {
              decoded[k]="_";
              finalDecodedValue+=decoded[k];
          }
          else if(decoded[k].equalsIgnoreCase("ETEETE"))
          {
              decoded[k]="\\";
              finalDecodedValue+=decoded[k];
          }
          else if(decoded[k].equalsIgnoreCase("EEETEET"))
          {
              decoded[k]="$";
              finalDecodedValue+=decoded[k];
          }
          else if(decoded[k].equalsIgnoreCase("ETTETE"))
          {
              decoded[k]="@";
              finalDecodedValue+=decoded[k];
          }
          else 
          {
              
              finalDecodedValue+=decoded[k]; 
          }
      }
      
      return (setToSentenceCase(finalDecodedValue));
     }
 /**
  * 
  * @param exp1
  * @return 
  * Algorithm for setToSentenceCase
  * 1.define method setSentenceCase and set exp1 as method parameter
  * 2.within the method declare variables exp2, dot and space.
  * 3.if exp1 contains a fullstop:
  *     replace them with commas
  *     split exp1 into an array of setences
  *     loop through these sentences:
  *         remove all spaces at both the beginning and trailing portions of the sentence
  *         set the case of the first character of each sentence to uppercase and concatinate the lowercase version of the remaining substring and concatinate the resulting expression to exp2
  *  but if exp1 contains no fullstop, it implies it is not a sentence so:
  *     return back the initial expression
  */
 public static String setToSentenceCase(String exp1)
 {
        String exp2="",dot=".",newLine="\n";
        
        if (exp1.contains(dot))
        {
        
        exp1=exp1.replace(dot, "\n");
        String [] sentences=exp1.split("\n");
        for (int i=0;i<sentences.length;i++)
        {
            sentences[i]=sentences[i].trim();
            exp2+=(""+sentences[i].charAt(0)).toUpperCase()
            +sentences[i].substring(1,sentences[i].length()).
            toLowerCase()+dot+newLine;
            
        }
        
        }
        else
        {
            return exp1;
        }
        return exp2;
     
 }
}