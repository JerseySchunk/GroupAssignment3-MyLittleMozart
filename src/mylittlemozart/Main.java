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
			List<MidiEventData> midiEvents = MidiCsvParser.parseCsv("filex/mystery_song.csv");
			
			
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
			
			//reusing instrumentStrategy variable to assign TrumpetStrategy
			//Applies trumpetStrategy to channel 1 on the track
			//All notes played on channel 1 will be trumpet
			instrumentStrategy = new TrumpetStrategy();
			instrumentStrategy.applyInstrument(track, 1);
			
			//Sets up pitch strategy to raise the notes pitch by 2 semitones
			PitchStrategy pitchStrategy = new HigherPitchStrategy();
			
			//Loop through every MIDI event in the list midiEvents that was parsed from CSV file
			//Apply pitch strategy to the note
			//Checks the event type to see if the note should be played or stopped
			//Uses the factory to create MIDI NoteOn or NoteOff event with the correct timing and adds the event to the track
			for (MidiEventData event : midiEvents) {
				int modifiedNote = pitchStrategy.modifyPitch(event.getNote());
				
				if(event.getNoteOnOff() == ShortMessage.NOTE_ON) {
					track.add(factory.createNoteOn(event.getStartEndTick(), modifiedNote, event.getVelocity(), event.getChannel()));
				}else {
					track.add(factory.createNoteOff(event.getStartEndTick(), modifiedNote, event.getChannel()));
				}
			}
			//Gets a MIDI sequencer
			//Opens the sequencer so it is ready to use
			//Loads custom sequence
			//Starts playing the MIDI sequence
			Sequencer sequencer = MidiSystem.getSequencer();
			sequencer.open();
			sequencer.setSequence(sequence);
			sequencer.start();
			
			//Keeps the program alive in a loop while the sequence is playing.
			//Checks every 100ms if the song is still going
			while(sequencer.isRunning()) {
				Thread.sleep(100);
			}
			
			Thread.sleep(500);
			sequencer.close();
				
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
