package mylittlemozart.factory;

//implements of the abstract factory need to rename because it isn't abstract 
public class LegatoMidiEventFactoryAbstract implements MidiEventFactoryAbstract{
	public MidiEventFactory createFactory() {
		//Returns a new instance of Standard Midi event factory
		return new LegatoMidiEventFactory();
	}
}
