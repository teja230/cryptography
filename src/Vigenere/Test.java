package Vigenere;

public class Test {
public static void main(String[] args)
{
String str="Tejaisagoodboy";
int n1=2;
int n2=5;
String s1=str.substring(n1, n2);
n1=n2;
n2=n2+3;
String s2=str.substring(n1, n2);
System.out.println(" "+str+" "+s1+" "+s2);
String st="45";
}
}
