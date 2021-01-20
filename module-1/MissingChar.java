class MissingChar {

  public static void main(String[] args) {

    missingChar("Robocop", 3);

    //receive command line argument if available
    if(args.length>=2){
      missingChar(args[0], Integer.parseInt(args[1]));
    }
  }

  private static void missingChar(String str, int n) {
    String antes = str.substring(0, n);
    String depois = str.substring(n + 1);
    str = antes + depois;
    System.out.println(str);
    // print result here

  }
}
