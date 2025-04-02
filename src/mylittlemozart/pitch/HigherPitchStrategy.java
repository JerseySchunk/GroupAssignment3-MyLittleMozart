package mylittlemozart.pitch;

/**
 * A pitch strategy that raises the pitch of a MIDI note by 2 semitones.
 */

public class HigherPitchStrategy implements PitchStrategy {
	/**
	 * Adds 2 to the given MIDI note value to raise pitch
	 * 
	 * @param note The original MIDI note value.
	 * @return The raised MIDI note value.
	 */
	@Override
	public int modifyPitch(int note) {
		return note + 2;
	}
}
