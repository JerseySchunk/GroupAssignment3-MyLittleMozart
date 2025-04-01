package mylittlemozart.factory;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;

public class StaccatoMidiEventFactory implements MidiEventFactory {

	//variable to decrease tick by 120
	private static final int duration = 120;
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
		return new MidiEvent(off, tick - duration);
	}
	
}



