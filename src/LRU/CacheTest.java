package LRU;

/**
 * Created by bhakti on 12/1/17.
 */
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.text.NumberFormat;
import java.util.Random;

public class CacheTest {

    private static long lookups;
    private static long hits;
    private static RandomAccessFile in;
    public static final int KEY_LENGTH = Long.SIZE / 8; //8 bytes
    public static final int DATA_LENGTH = 256; //
    private static String fileName ;

    private static MyObject getObject(long index) {
        try {
            in = new RandomAccessFile(fileName, "r");
            in.seek(index * (DATA_LENGTH + KEY_LENGTH + 1));
            long key = in.readLong();
            byte[] buffer = new byte[DATA_LENGTH + 1];
            in.read(buffer);
            MyObject obj = new MyObject(new Long(key), new BigInteger(buffer));
            return obj;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }

    /**
     * @param sampleSize
     * @return
     */
    private static void runRandomTest(Cache<Long, MyObject> myCache, int n, int numTests, long seed) {

        Random randomNumberGenerator;
        if (seed == 0) {
            randomNumberGenerator = new Random();
        } else {
            randomNumberGenerator = new Random(seed);
        }
        MyObject myObject;

        for (int i = 0; i < numTests; i++) {
            long key = (long) (randomNumberGenerator.nextDouble() * n);
            if (myCache.get(key) == null) {
                myObject = getObject(key);
                myCache.put(key,myObject);
            }
        }
        lookups = myCache.getLookups();
        hits = myCache.getHits();
    }

    private static void runHalfNormalTest(Cache<Long, MyObject> myCache, int numTests, int range, long seed) {
        Random randomNumberGenerator;
        if (seed == 0) {
            randomNumberGenerator = new Random();
        } else {
            randomNumberGenerator = new Random(seed);
        }

        MyObject myObject;
        for (int i = 0; i < numTests; i++) {
            long key = Math.abs((long) Math.floor(randomNumberGenerator.nextGaussian() * range));
            if (myCache.get(key) == null) {
                myObject = getObject(key);
                myCache.put((Long) myObject.getKey(), myObject);
            }
        }
        lookups = myCache.getLookups();
        hits = myCache.getHits();
    }


    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        if (args.length < 6) {
            System.err.println("Usage: java CacheTest <maxCacheSize> <keyRange> <data file> <#tests> <standard deviation> <seed>");
            System.exit(1);
        }

        int maxCacheSize = Integer.parseInt(args[0]);
        int keyRange = Integer.parseInt(args[1]);
        fileName = args[2];
        int numTests = Integer.parseInt(args[3]);
        int stdDev = Integer.parseInt(args[4]);
        long seed = Long.parseLong(args[5]);


        Cache<Long, MyObject> myCache = new Cache<Long, MyObject>(maxCacheSize); //fill in args*/
        runRandomTest(myCache, keyRange, numTests, seed);
        NumberFormat fmt = NumberFormat.getPercentInstance();
        System.out.println("CacheTest (Random):  maxCacheSize=" + maxCacheSize +
                " numTests=" + numTests +
                " hit ratio=" + fmt.format(((double) hits) / lookups));

        runHalfNormalTest(myCache, numTests, stdDev, seed);
        System.out.println("CacheTest (Half-Normal):  maxCacheSize=" + maxCacheSize +
                " std deviation = " + stdDev +
                " numTests=" + numTests +
                " hit ratio=" + fmt.format(((double) hits) / lookups));
    }

}

