import java.util.ArrayList;

public class GCD {

    public static void main( String args[] ) {

        String inputData = "203 302 123 332 122 124 10 20 13 14";

        String[] numbersStringArray = inputData.split(" ");

        long[] numbersArray = new long[numbersStringArray.length];

        for(int i = 0; i < numbersStringArray.length; i++) {
            try {
                numbersArray[i] = Long.valueOf(numbersStringArray[i]);
            } catch (NumberFormatException e) {
                //println("holy, it's not a number!");
            }
        }

        long greatest = Long.MIN_VALUE;
        long lowest = Long.MAX_VALUE;

        ArrayList<Long> foundedGcds = new ArrayList<Long>();

        for(int i = 0; i < numbersArray.length; i += 2) {
            if (i == numbersArray.length - 1) break;
            foundedGcds.add(gcd(numbersArray[i], numbersArray[i + 1]));
        }

        for(long gcd : foundedGcds) {
            if (gcd > greatest) {
                greatest = gcd;
            }

            if (lowest > gcd) {
                lowest = gcd;
            }
        }

        println("Max: " + greatest);
        println("Min: " + lowest);
    }

    public static long gcd( long a, long b ) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static void println( Object object ) {
        System.out.println(object);
    }
}
