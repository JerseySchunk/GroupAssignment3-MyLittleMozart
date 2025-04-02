package mylittlemozart.instrument;

import javax.sound.midi.Track;

/**
 * InstrumentStrategy interface defines a strategy to assign a MIDI instrument to a channel in a MIDI track.
 */

public interface InstrumentStrategy {
	
	/**
	 * Applies an instrument to a channel in the provided track
	 * 
	 * @param track    The MIDI track to apply the instrument to.
	 * @param channel  The MIDI channel to assign the instrument to.
	 */
void applyInstrument(Track track, int channel);
}