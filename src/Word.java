public class Word {
    String word_target;
    String word_explain;

    public void setWord_explain(String word_explain) {
        this.word_explain = word_explain;
    }

    public String getWord_explain() {
        return word_explain;
    }

    public void setWord_target(String word_target) {
        this.word_target = word_target;
    }

    public String getWord_target() {
        return word_target;
    }
    public Word(String t_anh, String t_viet) {
        word_target = t_anh;
        word_explain = t_viet;
    }
    public Word() {

    }
}
