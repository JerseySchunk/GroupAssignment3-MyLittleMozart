package mylittlemozart.instrument;

import javax.sound.midi.*;

public class AcousticGrandPianoStrategy implements InstrumentStrategy {
	
	
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
