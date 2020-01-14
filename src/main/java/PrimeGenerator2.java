/**
 * @author wusd
 * @date 2020/1/14 0:31
 */
public class PrimeGenerator2 {
    private static boolean[] f;
    private static int[] result;

    public static int[] generatePrimes(int maxValue) {
        if (maxValue < 2) {
            return new int[0];
        } else {
            initializeArrayOfIntegers(maxValue);
            sieve();
            loadPrimes();
            return result;
        }
    }

    public static void initializeArrayOfIntegers(int maxValue) {
        f = new boolean[maxValue + 1];
        int i;
        for (i = 0; i < f.length; i++) {
            f[i] = true;
        }
        f[0] = f[1] = false;
    }

    public static void sieve() {
        int i;
        int j;
        for (i = 2; i < Math.sqrt(f.length) + 1; i++) {
            if (f[i]) {
                for (j = 2 * i; j < f.length; j += i) {
                    f[j] = false;
                }
            }
        }

    }

    public static void loadPrimes() {
        int i;
        int j;
        int count = 0;
        for (i = 0; i < f.length; i++) {
            if (f[i]) count++;
        }
        result = new int[count];
        for (i = 0, j = 0; i < f.length; i++) {
            if (f[i]) result[j++] = i;
        }

    }
}
