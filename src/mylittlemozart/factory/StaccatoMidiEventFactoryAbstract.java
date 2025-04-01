package mylittlemozart.factory;


public class StaccatoMidiEventFactoryAbstract implements MidiEventFactoryAbstract{
	public MidiEventFactory createFactory() {
		//Returns a new instance of Standard Midi event factory
		return new StaccatoMidiEventFactory();
	}
}
