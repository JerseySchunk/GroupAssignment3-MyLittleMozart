package mylittlemozart;

import mylittlemozart.csv.MidiEventData;
import mylittlemozart.csv.MidiCsvParser;

import mylittlemozart.factory.*;
import mylittlemozart.instrument.*;
import mylittlemozart.pitch.*;

import javax.sound.midi.*;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		try {
			// Reads a CSV file from the path "files/mystery_song.csv"
			// Parses each line of that file and creates a list of MidiEventData objects from those lines
			// Stores the objects in a List called midiEvents
			List<MidiEventData> midiEvents = MidiCsvParser.parseCsv("filex/myster_song.csv");
			
			
			//Creates a new MIDI sequence object and creates a new track inside of the sequence
			Sequence sequence = new Sequence(Sequence.PPQ, 384);
			Track track = sequence.createTrack();
			
			//Chooses how notes will behave by selecting a correct factory
			//The selected factory will create MIDI events in the music sequence
			MidiEventFactoryAbstract factoryAbstract = new StandardMidiEventFactoryAbstract();
			MidiEventFactory factory = factoryAbstract.createFactory();
			
			//Applies AcousticGrandPiano to channel 0 of the track.
			//Ensures notes played are of the AcousticGrandPiano
			InstrumentStrategy instrumentStrategy = new AcousticGrandPianoStrategy();
			instrumentStrategy.applyInstrument(track, 0);
			
			
		}

	}

}
