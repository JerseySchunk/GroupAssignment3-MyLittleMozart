package mylittlemozart.pitch;

/**
 * A pitch strategy that lowers the pitch of a MIDI note by 2 semitones.
 */

public class LowerPitchStrategy implements PitchStrategy {
	/**
	 * Subtracts 2 to the provided MIDI note value to raise its pitch.
	 * 
	 * @param note The original MIDI note value.
	 * @return The raised MIDI note value.
	 */
	@Override
	public int modifyPitch(int note) {
		return note - 2;
	}
}
