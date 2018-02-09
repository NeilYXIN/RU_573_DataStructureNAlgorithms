import java.util.Random;

public class DataGenerator {
    public int[] generate() {
        int[] data = new int[8192];
        Random random = new Random();

        int[] source = new int[] { 1, 11, 111, 1111 };
        int[] count = new int[] { 0, 0, 0, 0 };
        int[] countMax = new int[] { 1024, 2048, 4096, 1024 };
        for(int i = 0; i < 8192; i++) {
            int temp = random.nextInt(4);
            while(count[temp] >= countMax[temp])
            {
                temp = random.nextInt(4);
            }
            count[temp]++;
            data[i] = source[temp];

        }

        random.nextInt(4);

        // Unit Test
        /*
        DataGeneratorTest dgt = new DataGeneratorTest();
        dgt.dataGeneratorTest(data);
        */

        return data;
    }
}
