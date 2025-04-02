package mylittlemozart.instrument;

import javax.sound.midi.*;

/**
 * Strategy to apply the AcousticGrandPiano to a given MIDI channel.
 * This strategy sends a PROGRAM_CHANGE message at the beginning of a track.
 */

public class AcousticGrandPianoStrategy implements InstrumentStrategy {
	
	/**
     * Creates a PROGRAM_CHANGE MIDI message to assign a new instrument to the given channel.
     * Uses MIDI instrument number 0, which represents an Acoustic Grand Piano.
     * The message is wrapped in a MidiEvent scheduled at tick 0, ensuring it takes effect immediately.
 	 * Adds this event to the track so the channel plays using a piano sound.
	 * 
	 * @param track   The MIDI track to modify.
	 * @param channel The channel number to apply the instrument to.
	 */
	@Override
	public void applyInstrument(Track track, int channel) {
		try {
			ShortMessage instrumentChange = new ShortMessage();
			instrumentChange.setMessage(ShortMessage.PROGRAM_CHANGE, channel, 0, 0);
			track.add(new MidiEvent(instrumentChange, 0));
		}catch (InvalidMidiDataException e) {
			e.printStackTrace();
		}
	}

}
