class NullPointerExceptionExample {
  public static void main(String[] args) {
    String str = null;

    try {
      if (str != null) {
        int length = str.length();
        System.out.println("Length of String: " + length);
      } else {
        System.out.println("Error: The String is null.");
      }
    } catch (NullPointerException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }
}
