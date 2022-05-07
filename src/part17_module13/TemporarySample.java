package part17_module13;

import java.util.List;

public class TemporarySample {

    String text;
    List<String> bigWords;

    public TemporarySample(String text, List<String> bigWords) {
        this.text = text;
        this.bigWords = bigWords;
    }

    public String getText() {
        return text;
    }

    public List<String> getBigWords() {
        return bigWords;
    }
}
