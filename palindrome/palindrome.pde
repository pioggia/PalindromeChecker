public void setup()
{
  String lines[] = loadStrings("palindromes.txt");
  println("there are " + lines.length + " lines");
  for (int i=0; i < lines.length; i++) 
  {
    if(palindrome(lines[i])==true)
    {
      println(lines[i] + " IS a palidrome.");
    }
    else
    {
      println(lines[i] + " is NOT a palidrome.");
    }
  }
}
public boolean palindrome(String word)
{
  String temp = "";
  String pun = " !,'";
  for(int i=0; i<word.length()-1; i++)
  {
    for( int a=0; a<pun.length(); a++)
    {
      if(word.substring(i, i+1).equals(pun.substring(a, a+1)))
      {
        temp = temp + word.substring(i, i+1);
      }
    }
  }
  for(int i=0; i<temp.length()/2; i++)
  {
    if(!(temp.substring(i, i+1).equals(temp.substring(temp.length()-1-i, (temp.length()-1-i)+1))) == true)
    {
      return false;
    }
  }
  return true;
}


