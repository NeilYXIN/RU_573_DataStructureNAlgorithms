public class DataGeneratorTest {
    public void dataGeneratorTest(int[] data)
    {
        int[] verify = new int[] { 0, 0, 0, 0 };
        for(int i = 0; i < 8192; i++) {
            System.out.println(data[i]);
            switch (data[i]) {
                default:
                    System.out.println("data error!");
                    break;
                case 1:
                    verify[0]++;
                    break;
                case 11:
                    verify[1]++;
                    break;
                case 111:
                    verify[2]++;
                    break;
                case 1111:
                    verify[3]++;
                    break;
            }

        }
        System.out.println("1: " + verify[0]);
        System.out.println("11: " + verify[1]);
        System.out.println("111: " + verify[2]);
        System.out.println("111: " + verify[3]);
    }
}
