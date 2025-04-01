package mylittlemozart.factory;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;

public interface MidiEventFactory {
	//Makes methods for Concrete factories to implement
	MidiEvent createNoteOn(int tick, int note, int velocity, int channel) throws InvalidMidiDataException; 
	MidiEvent createNoteOff(int tick, int note, int channel) throws InvalidMidiDataException;
}
