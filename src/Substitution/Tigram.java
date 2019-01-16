
package Substitution;
import java.util.HashMap;
public class Tigram {
String s;
   public Tigram(String str)
    {
       s=str;
    }
public void tigramCount()
{
    String str1=s+"()";
    String str2=s+"())";
    HashMap h = new HashMap();
for(int i = 0; i<s.length(); i++)
{
    int j=i+1;
    int k=i+2;
char c1= s.charAt(i);
char c2 = str1.charAt(j);
char c3 = str2.charAt(k);
//System.out.println(""+c1+""+c2);
String st = Character.toString(c1)+Character.toString(c2)+Character.toString(c3);
//System.out.println(st);
if(h.get(st)!= null){
if((c1>=65 && c1<=90) & (c2>=65 && c2<=90) & (c3>=65 && c3<=90))
h.put(st, (Integer)(h.get(st))+1);
    }
 else
{
    if((c1>=65 && c1<=90) & (c2>=65 && c2<=90) & (c3>=65 && c3<=90))
    h.put(st,1);
 }
 }
System.out.println(h.entrySet());
    }
}

