
package stringtest;

public class StringTest {


public static void main(String[] args) {


String s1 = "DIMPLE";

String s2 = "Dimple";

String s3 = "DIMPLE";

System.out.println(s1);

// compare 2 string

System.out.println("s1.equals(s2) =>> " + s1.equals(s2)); // 
if (s1.equals(s2))
{
System.out.println(" s1 and s2 are equal");
}

// Compare and ignore case 

System.out.println("s1.equalsIgnoreCase(s2) =>> " +s1.equalsIgnoreCase(s2));


// Replace some part of string with another string

String s4 =  "I am a software engineer";
// s4.replace("old value to be changed", "new value");
s4 = s4.replace("engineer", "developer").replace("am", "amm"); // when this stmt. execute it will be looks like in memory -> I am a software developer

System.out.println("New value : " + s4);


String s5 = "abc xyz qsdsh xyz  abc xyz";

// replace all zyz with qwer

s5= s5.replaceAll("xyz", "qwer");
System.out.println("S5 after change" + s5);

// contains -> it checks partial string in a given string line

if (s5.contains("dsh"))
{
System.out.println("Found dsh in string");
}

// charAt , indexOf, isEmpty(), subString, toLowerCase, toUppercase

// get SubString from given string line 

String s6 = "My name is Dimple";

s6= s6.substring(0, 3); // 0,1,2

System.out.println(s6);



}

}