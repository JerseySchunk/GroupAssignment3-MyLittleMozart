package mylittlemozart.factory;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;
/**
 * Is a concrete implementation of MidiEventFactory and implements the NoteOn and NoteOff Method.
 * Adds a tick variable to increase the tick rate by 80
 */
public class LegatoMidiEventFactory implements MidiEventFactory {

	//variable to increase tick by 80
	private static final int duration = 80;
	//Has MidiEvent for creating a note with noise and no noise
	@Override
	public MidiEvent createNoteOn(int tick, int note, int velocity, int channel) throws InvalidMidiDataException {
		ShortMessage on = new ShortMessage();
		on.setMessage(ShortMessage.NOTE_ON, channel, note, velocity);
		return new MidiEvent(on, tick);
	}
	
	@Override
	public MidiEvent createNoteOff(int tick, int note, int channel) throws InvalidMidiDataException {
		ShortMessage off = new ShortMessage();
		off.setMessage(ShortMessage.NOTE_OFF, channel, note);
		return new MidiEvent(off, tick + duration);
	}
	
}
