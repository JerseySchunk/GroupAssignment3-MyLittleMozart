package mylittlemozart.instrument;

import javax.sound.midi.*;

public class ElectricBassGuitarStrategy implements InstrumentStrategy{
	/**
	 * Creates a new MIDI message of type 'PROGRAM_CHANGE' which tells the MIDI system to change the instrument for a channel.
	 * Sets the instrument on the given channel to instrument number 33 which corresponds to ElectricBass
	 * Wraps the message in a MidiEvent with a timestamp of 0 which means it happens at the start of the track
	 * Adds the event to the MIDI Track so that when the MIDI plays, channel 'channel' will sound like a bass
	 * 
	 * @param track   The MIDI track to modify.
	 * @param channel The channel number to apply the instrument to.
	 */
	@Override
	public void applyInstrument(Track track, int channel) {
		try {
			ShortMessage instrumentChange = new ShortMessage();
			instrumentChange.setMessage(ShortMessage.PROGRAM_CHANGE, channel, 33, 0);;
			track.add(new MidiEvent(instrumentChange, 0));
		}catch (InvalidMidiDataException e) {
			e.printStackTrace();
		}
	}
}
