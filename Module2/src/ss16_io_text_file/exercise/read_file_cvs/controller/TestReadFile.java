package ss16_io_text_file.exercise.read_file_cvs.controller;

import java.util.List;

public class TestReadFile {
    public static void main(String[] args) throws Exception {
        ReadAndWriteCountry readAndWriteCountry = new ReadAndWriteCountry();
        List<Country> countryList = readAndWriteCountry.readCountryFile();
        readAndWriteCountry.writeCountry(countryList);
    }
}
