package mylittlemozart.pitch;
/**
 * PitchStrategy is an interface that defines a strategy for modifying the pitch of a MIDI note.
 * Allows for different ways to alter note pitch. Such as raising or lowering it by a number.
 */
public interface PitchStrategy {	
	int modifPitch(int note);
}
