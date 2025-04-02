package mylittlemozart.instrument;

import javax.sound.midi.*;

/**
 * Strategy to apply the AcousticGrandPiano to a given MIDI channel.
 * This strategy sends a PROGRAM_CHANGE message at the beginning of a track.
 */

public class AcousticGrandPianoStrategy implements InstrumentStrategy {
	
	/**
	 * Applies AcousticGrandPiano to a specified MIDI channel.
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
