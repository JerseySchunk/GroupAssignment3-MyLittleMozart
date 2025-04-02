package mylittlemozart.csv;
import java.io.*;
import java.util.*;

/**
 * A parser for reading MIDI event data from a CSV file.
 */
public class MidiCsvParser {

    /**
     * Parses a CSV file containing MIDI event data and returns a list of MidiEventData objects.
     *
     * @param filePath The path to the CSV file.
     * @return A list of parsed MidiEventData objects.
     * @throws IOException If an error occurs while reading the file.
     */
    public static List<MidiEventData> parseCsv(String filePath) throws IOException {
        List<MidiEventData> events = new ArrayList<>(); // Stores parsed MIDI event data

        // Open the file for reading
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            // Read each line from the CSV file
            while ((line = br.readLine()) != null) {
                String[] values = line.split(","); // Split the line by commas

                // Ensure the line contains exactly 6 values before processing
                if (values.length == 6) {
                    try {
                        // Convert each value to an integer after trimming spaces
                        int startEndTick = Integer.parseInt(values[0].trim());
                        int velocity = Integer.parseInt(values[1].trim());
                        int note = Integer.parseInt(values[2].trim());
                        int channel = Integer.parseInt(values[3].trim());
                        int instrument = Integer.parseInt(values[4].trim());
                        int noteOnOff = Integer.parseInt(values[5].trim());

                        // Create a MidiEventData object and add it to the list
                        events.add(new MidiEventData(startEndTick, velocity, note, channel, instrument, noteOnOff));
                    } catch (NumberFormatException e) {
                        // If a value cannot be converted to an integer, print a warning and skip the line
                        System.out.println("Skipping invalid line: " + line);
                    }
                }
            }
        }
        return events; // Return the list of parsed MIDI events
    }
}