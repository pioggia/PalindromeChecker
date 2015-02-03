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

public class PalindromeChecker extends PApplet {

public void setup()
{
  String lines[] = loadStrings("palindromes.txt");
  println("there are " + lines.length + " lines");
  for (int i=0; i < lines.length; i++) 
  {
    System.out.println(convert(lines[i]));
    if(palindrome(convert(lines[i]))==true)
    {
      println(lines[i] + " IS a palidrome.");
    }
    else
    {
      println(lines[i] + " is NOT a palidrome.");
    }
  }
}
public String convert(String word)
{
  String temp = "";
  String converted = "";
  String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
  for(int i=0; i<word.length(); i++)
  {
    for(int a=0; a<alphabet.length(); a++)
    {
      if(word.substring(i, i+1).equals(alphabet.substring(a, a+1)) == true)
      {
        temp = temp + word.substring(i, i+1);
      }
    }
  }
  for(int i=0; i<temp.length(); i++)
  {
    for(int c=25; c<alphabet.length()-1; c++)
    {
      if(temp.substring(i, i+1).equals(alphabet.substring(c, c+1)) == true)
      {
        converted = converted + alphabet.substring((alphabet.length()-c)/2, ((alphabet.length()-c)/2)+1);
      }
    }
  }
  return converted;
}
public boolean palindrome(String word)
{
  String two = "";
  for(int i=word.length(); i<0; i--)
  {
    two = two + word.substring(i, i+1);
  }
  if(two.equals(word))
  {
    return true;
  }
  else 
  {
    return false;
  }
}

  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "PalindromeChecker" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
