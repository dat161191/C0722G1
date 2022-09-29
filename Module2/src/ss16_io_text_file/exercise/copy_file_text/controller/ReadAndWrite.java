package ss16_io_text_file.exercise.copy_file_text.controller;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWrite {
    public List<String> readFile(String filePath) {
        List<String> list = new ArrayList<>();
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                throw new Exception();
            }
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                list.add(line);
            }
            bufferedReader.close();
        } catch (Exception e) {
            System.out.println("File này có lỗi!không đọc được");
        }
        return list;
    }

    public void write(String filePath, int count) {
        try {
            FileWriter fileWriter = new FileWriter(filePath, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("Số chữ trong chuỗi là " + count);
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int countString(List<String> list) {
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            count++;
        }
        return count;
    }
}
