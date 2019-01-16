
package Substitution;
import java.util.HashMap;
public class Digram {
String s;
   public Digram(String str)
    {
       s=str;
    }
public void digramCount()
{
    String stri=s+"()";
    HashMap h = new HashMap();
for(int i = 0; i<s.length(); i++)
{
    int j=i+1;
    
char c1= s.charAt(i);
char c2 = stri.charAt(j);
//System.out.println(""+c1+""+c2);
String st = Character.toString(c1)+Character.toString(c2);
//System.out.println(st);
if(h.get(st)!= null){
if((c1>=65 && c1<=90) & (c2>=65 && c2<=90))
h.put(st, (Integer)(h.get(st))+1);
    }
 else
{
    if((c1>=65 && c1<=90) & (c2>=65 && c2<=90))
    h.put(st,1);
 }
 }
System.out.println(h.entrySet());
    }
}

