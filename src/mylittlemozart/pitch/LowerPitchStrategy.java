package mylittlemozart.pitch;

/**
 * A pitch strategy that lowers the pitch of a MIDI note by 2 semitones.
 */

public class LowerPitchStrategy implements PitchStrategy {
	@Override
	public int modifyPitch(int note) {
		return note - 2;
	}
}
