package mylittlemozart.factory;

public class StandardMidiEventFactoryAbstract implements MidiEventFactoryAbstract{
	public MidiEventFactory createFactory() {
		return new StandardMidiEventFactory();
	}
}
