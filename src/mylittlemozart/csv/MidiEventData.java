package mylittlemozart.csv;

/**
 *MIDI event data. timing, velocity, note, channel, instrument, and note on/off state.
 */
public class MidiEventData {
    private int startEndTick; // tick which the event starts/ends
    private int velocity; // velocity of the note
    private int note; //  MIDI note number 
    private int channel; // MIDI channel the event belongs to
    private int instrument; //  instrument associated with the event
    private int noteOnOff; // Indicates whether the note is on or off

    /**
     * Constructs a MidiEventData object with the given parameters.
     * 
     * @param startEndTick tick which the event starts/ends
     * @param velocity velocity of the note
     * @param note MIDI note number 
     * @param channel MIDI channel the event belongs to
     * @param instrument instrument associated with the event
     * @param noteOnOff Indicates whether the note is on or off
     */
    public MidiEventData(int startEndTick, int velocity, int note, int channel, int instrument, int noteOnOff) {
        this.startEndTick = startEndTick;
        this.velocity = velocity;
        this.note = note;
        this.channel = channel;
        this.instrument = instrument;
        this.noteOnOff = noteOnOff;
    }

    /**
     * @return tick at which event starts or ends
     */
    public int getStartEndTick() {
        return startEndTick;
    }

    /**
     * Sets  tick at which event starts or ends.
     * @param startEndTick new tick value
     */
    public void setStartEndTick(int startEndTick) {
        this.startEndTick = startEndTick;
    }

    /**
     * @return velocity of the note
     */
    public int getVelocity() {
        return velocity;
    }

    /**
     * Sets velocity of the note.
     * @param velocity The new velocity value
     */
    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }

    /**
     * @return MIDI note number
     */
    public int getNote() {
        return note;
    }

    /**
     * Sets MIDI note number.
     * @param note new note number
     */
    public void setNote(int note) {
        this.note = note;
    }

    /**
     * @return MIDI channel number
     */
    public int getChannel() {
        return channel;
    }

    /**
     * Sets MIDI channel number.
     * @param channel new channel number
     */
    public void setChannel(int channel) {
        this.channel = channel;
    }

    /**
     * @return instrument number
     */
    public int getInstrument() {
        return instrument;
    }

    /**
     * Sets instrument number.
     * @param instrument new instrument number
     */
    public void setInstrument(int instrument) {
        this.instrument = instrument;
    }

    /**
     * @return 1 if note is on, 0 if note is off
     */
    public int getNoteOnOff() {
        return noteOnOff;
    }

    /**
     * Sets whether note is on or off.
     * @param noteOnOff 1 for note on, 0 for note off
     */
    public void setNoteOnOff(int noteOnOff) {
        this.noteOnOff = noteOnOff;
    }
}
