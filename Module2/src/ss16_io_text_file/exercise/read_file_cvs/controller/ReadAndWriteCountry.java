package ss16_io_text_file.exercise.read_file_cvs.controller;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteCountry {
    public List<Country> readCountryFile() throws Exception {
        File file = new File("src/ss16_io_text_file/exercise/read_file_cvs/data/country.csv");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<Country> countryList = new ArrayList<>();
        String line;
        String[] info;
        Country country;
        while ((line = bufferedReader.readLine()) != null) {
            info = line.split(",");
            country = new Country(Integer.parseInt(info[0]), info[1], info[2]);
            countryList.add(country);
        }
        bufferedReader.close();
        for (Country i : countryList) {
            System.out.println(i.getNameCountry());

        }
        return countryList;
    }
    public void writeCountry(List<Country> countryList) throws Exception {
        File file = new File("src/ss16_io_text_file/exercise/read_file_cvs/data/out_put_country.csv");
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        for (Country i : countryList) {
            bufferedWriter.write(i.toString());
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
    }
}
