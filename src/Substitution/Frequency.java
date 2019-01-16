package Substitution;
import java.util.HashMap;
public class Frequency {
    String s;
   public Frequency(String str)
    {
       s=str;
    }
public void frequencyCount()
{
HashMap h = new HashMap();
for(int i = 0; i<s.length(); i++){
char c = s.charAt(i);
if(h.get(c)!= null){
   if(c>=65 && c<=90)
   {
h.put(c, (Integer)(h.get(c))+1);
    }
 }
else{
    if(c>=65 && c<=90)
   {
h.put(c, 1);
    }
    }
 }
System.out.println(h.entrySet());
    Object[][] count = new String[h.size()][2];
    Object[] keys = h.keySet().toArray();
    Object[] values = h.values().toArray();
    for (int row = 0; row < count.length; row++) {
        count[row][0] = keys[row].toString();
        count[row][1] = values[row].toString();
    }
   
    }

}
