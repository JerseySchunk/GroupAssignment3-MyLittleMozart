package mylittlemozart.instrument;

import javax.sound.midi.*;

/**
 * Strategy to apply the Trumpet instrument to a given MIDI channel.
 */

public class TrumpetStrategy implements InstrumentStrategy {
	
	/**
	 * Creates a PROGRAM_CHANGE MIDI message to update the instrument for the specified channel.
	 * Sets the instrument to MIDI number 56, which corresponds to a Trumpet.
 	 * Wraps this message in a MidiEvent with a tick value of 0, meaning it takes effect at the start of the track.
 	 * Adds the event to the track so that the selected channel plays using a trumpet sound.
 	 * 
	 * @param track   The MIDI track to modify.
	 * @param channel The channel number to apply the instrument to.
	 */
	
	@Override
	public void applyInstrument(Track track, int channel) {
		try {
			ShortMessage instrumentChange = new ShortMessage();
			instrumentChange.setMessage(ShortMessage.PROGRAM_CHANGE, channel, 56, 0);
			track.add(new MidiEvent(instrumentChange, 0));
		}catch (InvalidMidiDataException e) {
			e.printStackTrace();
		}
	}
}
