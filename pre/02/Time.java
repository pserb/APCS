public class Time {
    public static void main(String[] args) {
        float hour = 20;
        float minute = 46;
        float seconds = 43;

        float totalSeconds = secondsSinceMidnight(hour, minute, seconds);
        System.out.println(totalSeconds);
    }

    public static float secondsSinceMidnight(float hour, float minute, float seconds) {
        return (hour*60*60) + (minute*60) + (seconds);
    }
}