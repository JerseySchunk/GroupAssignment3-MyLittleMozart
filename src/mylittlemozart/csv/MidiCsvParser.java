package mylittlemozart.csv;

import java.io.*;
import java.util.*;

public class MidiCsvParser {
    public static List<MidiEventData> parseCsv(String filePath) throws IOException {
        List<MidiEventData> events = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
               
            }
        }
        return events;
    }
}
