package hello;
public class Words {

    private final String word;
    private final boolean palingdrome;
    private final boolean anagramOfPalingdrome;
    public Words( String word,boolean palingdrome,boolean anagramOfPalingdrome) {
        this.word = word;
        this.palingdrome = palingdrome;
        this.anagramOfPalingdrome = anagramOfPalingdrome;
    }
	public String getWord() {
		return word;
	}
	public boolean getPalingdrome() {
		return palingdrome;
	}
	public boolean getAnagramOfPalingdrome() {
		return anagramOfPalingdrome;
	}

    
}