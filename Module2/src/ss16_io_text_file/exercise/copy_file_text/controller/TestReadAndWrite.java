package ss16_io_text_file.exercise.copy_file_text.controller;

import java.util.List;

public class TestReadAndWrite {
    public static void main(String[] args) {
        ReadAndWrite newfile = new ReadAndWrite();
        List<String> newlist = newfile.readFile("src/ss16_io_text_file/exercise/copy_file_text/data/source_file.csv");
        int count = newfile.countString(newlist);
        newfile.write("src/ss16_io_text_file/exercise/copy_file_text/data/target_file.csv", count);
    }
}
