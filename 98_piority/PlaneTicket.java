import java.util.ArrayList;

public class PlaneTicket implements Comparable<PlaneTicket> {

    private static final ArrayList<String> seatClassPriority = new ArrayList<>();

    private String name;
    private String seatClass;
    private int priority;

    public PlaneTicket(String name, String seatClass) {

        seatClassPriority.add("first");
        seatClassPriority.add("business");
        seatClassPriority.add("economy");

        this.name = name;
        this.seatClass = seatClass;

        this.priority = seatClassPriority.indexOf(seatClass.trim().toLowerCase());
    }

    public int compareTo(PlaneTicket o) {
        return this.priority - o.priority; 
    }

    public String toString() {
        return name + "'s " + seatClass + " class ticket";
    }
    
}
