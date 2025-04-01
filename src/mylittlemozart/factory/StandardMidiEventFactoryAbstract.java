package mylittlemozart.factory;

public class StandardMidiEventFactoryAbstract implements MidiEventFactoryAbstract{
	public MidiEventFactory createFactory() {
		//Returns a new instance of Standard Midi event factory
		return new StandardMidiEventFactory();
	}
}
