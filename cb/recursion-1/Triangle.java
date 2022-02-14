public class Triangle {
  public static int triangle(int rows) {
    if (rows == 0) return 0;
    return rows + triangle(rows-1);
  }
  public static void main(String[] args) {
    System.out.println(triangle(0));
    System.out.println(triangle(1));
    System.out.println(triangle(2));
  }
}
