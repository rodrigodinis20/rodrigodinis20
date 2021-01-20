class NotString {

public static void main(String[] args) {

    notString("semicolon");
    notString("not semicolon");

    //receive command line argument if available
    if(args.length>0){
      notString(args[0]);
    }

}

private static void notString(String str) {
    if(str.substring(0, 4).equals("not ")) {
     System.out.println(str);
    }
    else{
     System.out.println("not " + str);
    // print result here
    }
}
}
