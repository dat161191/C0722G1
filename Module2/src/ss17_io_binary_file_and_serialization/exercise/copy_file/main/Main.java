package ss17_io_binary_file_and_serialization.exercise.copy_file.main;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String linkInput = "src/ss17_io_binary_file_and_serialization/exercise/copy_file/data/input.csv";
        String linkCoppy = "src/ss17_io_binary_file_and_serialization/exercise/copy_file/data/copy_input.csv";
        List<String> strings = new ArrayList<>();
        strings.add("Hello");
        strings.add("World");
        strings.add("Alo ola alolo");
        writeFile(strings, linkInput);
        readFile(strings, linkInput);
        try {
            FileInputStream input = new FileInputStream("src/ss17_io_binary_file_and_serialization/exercise/copy_file/data/input.csv");
            FileOutputStream coppy = new FileOutputStream("src/ss17_io_binary_file_and_serialization/exercise/copy_file/data/copy_input.csv");
            byte[] bytes = new byte[200];
            int length;
            int count = 0;

            while ((length = input.read(bytes)) > 0) {
                coppy.write(bytes, 0, length);
                count += length;
            }
//            while ((length = input.read()) != -1) {
//                System.out.println((char)length);
//            }
            System.out.println("Tệp có số bytes là: " + count);
            readFile(strings, linkCoppy);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeFile(List<String> strings, String link) {
        File file = new File(link);
        try {
            FileOutputStream outPut = new FileOutputStream(file);
            ObjectOutputStream oBoutPut = new ObjectOutputStream(outPut);
            oBoutPut.writeObject(strings);
            oBoutPut.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFile(List<String> strings, String link) {
        File file = new File(link);
        try {
            FileInputStream inPut = new FileInputStream(file);
            ObjectInputStream oBinput = new ObjectInputStream(inPut);
            strings = (List<String>) oBinput.readObject();
            for (String i : strings) {
                System.out.println(i);
            }
            oBinput.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}
