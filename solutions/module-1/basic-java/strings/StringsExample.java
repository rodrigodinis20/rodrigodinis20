public class StringsExample {

  public static void main(String[] args) {

    // using literals
    /*String a = "Java";
    String b = "Java";

    System.out.println(a == b); // True, it is the same object, GO WITH THIS ONE

    // using the constructor
    String c = new String("Java");
    String d = new String("Java");

    System.out.println(c == d); // False, they are different objects*/

    // using literals
    /*String a = "Java";
    String b = "Java";

    System.out.println(a.equals(b)); // True, they have the same content

    // using the constructor
    String c = new String("Java");
    String d = new String("Java");

    System.out.println(c.equals(d)); // True, they have the same content*/

    /*String hello = "Hello";
    String world = "World!";

    System.out.println(hello + world);
    System.out.println(hello.concat(world));
    System.out.println("hello".concat(world));*/

    /*String john = "John";
    int johnAge = 21;

    String mary = "Mary";
    int maryAge = 25;

    // print using string format
    String log = "I am %s and I have %d years old."; // %s for string, %d for int and %f for float

    System.out.println(String.format(log, john, johnAge));
    System.out.println(String.format(log, mary, maryAge));*/

    /*int age = 21;

    String str1 = age + "";
    String str2 = String.valueOf(age);
    String str3 = Integer.toString(age);

    System.out.println(str1 + " " + str2 + " " + str3);*/

    String str = "Hello World!";

    // returns the character at the specified index

    /*int index = 12;

    if(index < str.length()) {

      char ch = str.charAt(index);

      System.out.println(ch);
    }*/

    // returns the hello
    /*String hello = str.substring(0, 5);

    // returns the world
    String world = str.substring(6);

    System.out.println(hello + " " + world);*/

    // what to search for, it can be a char or string
    /*String search = "o";

    // check if the string contains the search
    if(str.contains(search)) {
    	System.out.println(search + " exists!");
    }

    // search forward from the beginning
    int index = str.indexOf(search);   // ??
     index = str.indexOf(search, 5);

    // search backwards from the end
    int lastIndex = str.lastIndexOf(search, str.length() - 2);  // ??

    System.out.println("The first " + search + " is at " + index + " and the last one at " + lastIndex);*/

    //String str = "Hello World!";

    // what to replace and for what
    /*String target = "Hello";
    String replacement = "Goodbye";

    // check if the string contains what we want to replace
    	str = str.replace(target, replacement);

    // replace only the first occurrence
    str = str.replaceFirst("o", "U");

    System.out.println(str);*/

    String url = "http://www.academiadecodigo.org";

    String domain = url.substring(url.lastIndexOf("/") + 1);

    String name = url.substring(url.indexOf(".") + 1, url.lastIndexOf("."));

    int academiaEnd = name.lastIndexOf("a");
    int codigoStart = name.lastIndexOf("c");

    String academia = name.substring(0, academiaEnd + 1);
    String de = name.substring(academiaEnd + 1, codigoStart);
    String codigo = name.substring(codigoStart);

    academia = academia.substring(0, 1).toUpperCase() + academia.substring(1);
    codigo = codigo.substring(0, 1).toUpperCase() + codigo.substring(1);

    name = "< " + academia + " " + de + " " + codigo + "_ >";

    System.out.println("I am a Code Cadet at " + name + ", " + domain);

    // declare an array with values
    String[] contacts = { "John", "Mary", "Ze" };

    System.out.println(contacts[0]);

    // absolute value
    int i = -1;
    System.out.println(Math.abs(i));

    // round number
    float f = 10.23f;

    int ceil = (int)Math.ceil(f);
    int floor = (int)Math.floor(f);
    int round = (int)Math.round(f);

    System.out.println(ceil + " " + floor + " " + round);

    // min and max
    int number1 = 10;
    int number2 = 15;

    int min = Math.min(number1, number2);
    int max = Math.max(number1, number2);

    System.out.println(min + " " + max);

    // random
    // 0.0 <= Math.random() < 1.0
    int random = (int)(Math.random() * 10); // random number between 0 - 9

    System.out.println(random);

    str = "AcademiadeCodigo";
    String result = "";
    // Note: the loop increments i by 2
    for (int j=0; j<str.length(); j+=2) {
      result = result + str.charAt(j);
      // Alternately could use str.charAt(i)
    }

    System.out.println(result);

    // current weapon
    // 0 - Sword
    // 1 - Gun
    // 2 - Grenade
    int currentWeapon = 1;

    switch(currentWeapon) {

    	case 0:
    	System.out.println("Attack!");
    	break;

    	case 1:
    	System.out.println("Shoot!");
    	break;

    	case 2:
    	System.out.println("Throw!");
    	break;

    	default:
    	System.out.println("Get a weapon…");
    	break;
    }

    String[] contacts1 = {	"John", "Mary", "Jean", "Paul" };

    for (String contact : contacts1) {

    	// print each contact
    	System.out.println(contact);
    }

    // example
int x = 10;

System.out.println( (x++ % 2 == 0) ? "yes " + x : " no " + x);

x = 10;

System.out.println( (++x % 2 == 0) ? "yes " + x : " no " + x);

    String str1 = "Academia de Codigo";


    String[] words = str1.split(" ", 2);

    System.out.println(words.length + ", " + words[0] + ", " + words[1]);

    String[] droids = { "M-TD", "C3PO", "R2-D2", "RA-7" };

    // we are looking for R2-D2
    for(int k = 0; k < droids.length; k++) {

      if(!droids[k].equals("R2-D2") && !droids[k].equals("C3PO")) {

        // just skip the iteration
    		System.out.println("This is not the droid I'm looking for...");

        continue;
      }

      // do something with the droid
    	System.out.println("Found " + droids[k]);
    }

    for(String droid : droids) {

      System.out.println(droid);
    }
  }
}
