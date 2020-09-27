import java.io.IOException;

public class DictionaryCommandLine extends DictionaryManagement {
    public void showAllWords() {
        System.out.println("No  |English\t\t\t|Vietnamese");
        int n = Tu_dien.size();
        for (int i=0 ;i<n ;i++)
        {
            System.out.printf("%d\t| %-10s\t\t| %-10s\n",i+1,Tu_dien.get(i).word_target,Tu_dien.get(i).word_explain);
        }
    }
    public void dictionaryBasic() {
        insertFromCommandline();
        showAllWords();
    }
    public static void main (String[] args) {
        DictionaryCommandLine a = new DictionaryCommandLine();
        a.dictionaryBasic();
    }
}
