import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class palindrome extends PApplet {

public void setup()
{
  String lines[] = loadStrings("palindromes.txt");
  println("there are " + lines.length + " lines");
  for (int i=0; i < lines.length; i++) 
  {
    if(palindrome(noSpaces(toLower(noPun(lines[i]))))==true)
    {
      println(lines[i] + " IS a palidrome.");
    }
    else
    {
      println(lines[i] + " is NOT a palidrome.");
    }
  }
}
public String noPun(String stanza)
{
  String temp = "";
  String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
  for(int i=0; i<stanza.length(); i++)
  {
    for(int a=0; a<alphabet.length(); a++)
    {
      if(stanza.substring(i, i+1).equals(alphabet.substring(a, a+1)) == true)
      {
        temp = temp + stanza.substring(i, i+1);
      }
    }
  }
  return temp;
}
public String toLower(String phrase)
{
  return phrase.toLowerCase();
}
public String noSpaces(String sWord)
{
  String temp = "";
  for(int i=0; i<sWord.length(); i++)
  {
     if(sWord.substring(i, i+1).equals(" ") == false)
     {
        temp = temp + sWord.substring(i, i+1);
     }
  }
  return temp;
}
public boolean palindrome(String word)
{
  String temp = "";
  for(int i = word.length()-1; i>=0; i--) //reverses word
  {
    temp = temp + word.substring(i, i+1);
  }
  if(temp.equals(word))
  {
    return true;
  }
  return false;
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "palindrome" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
