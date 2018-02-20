public class hw2_3 {

    public static void main(String[] args) {
        int data[];
        // generate data separated randomly
        DataGenerator dg = new DataGenerator();
        data = dg.generate();
        int len = data.length;
        int[] count = new int[] { 0, 0, 0, 0 };
        for(int i = 0; i < len; i++)
        {
            switch (data[i])
            {
                default:
                    System.out.println("Data error!");
                    break;
                case 1:
                    count[0]++;
                    break;
                case 11:
                    count[1]++;
                    break;
                case 111:
                    count[2]++;
                    break;
                case 1111:
                    count[3]++;
                    break;
            }
        }

        for(int i = 0; i < count[0]; i++)
        {
            data[i] = 1;
        }

        for(int i = count[0]; i < count[0]  + count[1]; i++)
        {
            data[i] = 11;
        }

        for(int i = count[0] + count[1]; i < count[0] + count[1] + count[2]; i++)
        {
            data[i] = 111;
        }

        for(int i = count[0] + count[1] + count[2]; i < data.length; i++)
        {
            data[i] = 1111;
        }


        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i]);
        }

        // Verify sorted array
        /*
        DataGeneratorTest dgt = new DataGeneratorTest();
        dgt.dataGeneratorTest(data);
        */

    }
}
