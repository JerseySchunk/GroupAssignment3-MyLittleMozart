package mylittlemozart.csv;

import java.io.*;
import java.util.*;

import javax.sound.midi.ShortMessage;

/**
 * Parses a CSV file containing MIDI event data and converts it into a list of MidiEventData objects.
 */
public class MidiCsvParser {
    /**
     * Parses a CSV file and converts it into a list of MidiEventData objects.
     * 
     * @param filePath Path to CSV file.
     * @return List of parsed MidiEventData objects.
     * @throws IOException If an error occurs while reading file.
     */
    public static List<MidiEventData> parseCsv(String filePath) throws IOException {
        List<MidiEventData> events = new ArrayList<>(); // Stores parsed MIDI events
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) { // Opens file for reading
            String line;
            while ((line = br.readLine()) != null) { // Reads each line from file
                String[] values = line.split(","); // Splits line into components
                
                if (values.length == 6) { // Ensures correct number of values
                    try {
                        int startEndTick = Integer.parseInt(values[0].trim()); // Parses start/end tick
                        String noteOnOffStr = values[1].trim(); // Gets note on/off type
                        int channel = Integer.parseInt(values[2].trim()); // Parses MIDI channel
                        int note = Integer.parseInt(values[3].trim()); // Parses MIDI note number
                        int velocity = Integer.parseInt(values[4].trim()); // Parses velocity
                        int instrument = Integer.parseInt(values[5].trim()); // Parses instrument number
                        
                        int noteOnOff; // Stores MIDI message type
                        
                        if (noteOnOffStr.equalsIgnoreCase("Note_on_c")) {
                            noteOnOff = ShortMessage.NOTE_ON; // Assigns NOTE_ON value
                        } else if (noteOnOffStr.equalsIgnoreCase("Note_off_c")) {
                            noteOnOff = ShortMessage.NOTE_OFF; // Assigns NOTE_OFF value
                        } else {
                            System.out.println("Skipping line with unknown note type: " + line); // Skips unknown types
                            continue;
                        }
                        
                        // Adds parsed event to list
                        events.add(new MidiEventData(startEndTick, velocity, note, channel, instrument, noteOnOff));
                    } catch (NumberFormatException e) {
                        System.out.println("Skipping invalid line: " + line); // Handles number format errors
                    }
                }
            }
        }
        return events; // Returns parsed MIDI events
    }
}
