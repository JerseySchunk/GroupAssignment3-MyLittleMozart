package mylittlemozart.instrument;

import javax.sound.midi.*;

/**
 * Strategy to apply the Trumpet instrument to a given MIDI channel.
 */

public class TrumpetStrategy implements InstrumentStrategy {
	
	/**
	 * Applies the Trumpet instrument to the specified MIDI channel
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
