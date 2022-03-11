public class Node {

  private Object CAR;
  private Node CDR;

  public Node() {

  }

  public Object getCAR() {
    return CAR;
  }
  public Node getCDR() {
    return CDR;
  }

  public void setCAR(Object x) {
    CAR = x;
  }
  public void setCDR(Node x) {
    CDR = x;
  }
  
}
