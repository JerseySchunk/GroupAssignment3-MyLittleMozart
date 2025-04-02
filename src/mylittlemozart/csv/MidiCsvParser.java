package mylittlemozart.csv;

import java.io.*;
import java.util.*;

import javax.sound.midi.ShortMessage;

public class MidiCsvParser {
    public static List<MidiEventData> parseCsv(String filePath) throws IOException {
        List<MidiEventData> events = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length == 6) {
                    try {
                    	int startEndTick = Integer.parseInt(values[0].trim());
                    	String noteOnOffStr = values[1].trim();
                    	int channel = Integer.parseInt(values[2].trim());
                    	int note = Integer.parseInt(values[3].trim());
                    	int velocity = Integer.parseInt(values[4].trim());
                    	int instrument = Integer.parseInt(values[5].trim());
                    	
                    	int noteOnOff;
                    	
                    	if(noteOnOffStr.equalsIgnoreCase("Note_on_c")) {
                    		noteOnOff = ShortMessage.NOTE_ON;
                    	}else if (noteOnOffStr.equalsIgnoreCase("Note_off_c")) {
                    		noteOnOff = ShortMessage.NOTE_OFF;
                    	}else {
                    		System.out.println("Skipping line with unknown note type: " + line);
                    		continue;
                    	}
                    	
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