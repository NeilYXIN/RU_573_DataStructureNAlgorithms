import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class DataGenerator {
    public void generate(int size) throws IOException {
        int[] data = new int[size];
        for(int i = 0; i < size; i++) {
            data[i] = i + 1;
        }

        Random random = new Random();

        for(int i = 0; i < size; i++) {
            int temp = random.nextInt(i + 1);
            swap(data, i, temp);
        }

        writeFile(data);

    }

    private void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    private void writeFile(int[] data) throws IOException {
        FileWriter fw = null;
        try {
            fw = new FileWriter("hw2_5_cutoff.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i: data){
            try {
                fw.write(String.valueOf(i));
                fw.write("\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        fw.flush();
        fw.close();
    }


}
