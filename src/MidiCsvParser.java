import java.io.*;
import java.util.*;

import mylittlemozart.csv.MidiEventData;

public class MidiCsvParser {
    public static List<MidiEventData> parseCsv(String filePath) throws IOException {
        List<MidiEventData> events = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length == 6) {
                    try {
                        int startEndTick = Integer.parseInt(values[0]);
                        int velocity = Integer.parseInt(values[1]);
                        int note = Integer.parseInt(values[2]);
                        int channel = Integer.parseInt(values[3]);
                        int instrument = Integer.parseInt(values[4]);
                        int noteOnOff = Integer.parseInt(values[5]);

                        events.add(new MidiEventData(startEndTick, velocity, note, channel, instrument, noteOnOff));
                    } catch (NumberFormatException e) {
                        System.out.println("Skipping invalid line: " + line);
                    }
                }
            }
        }
        return events;
    }
}