import java.util.Scanner;

public class DictionaryManagement extends Dictionary {
    public void insertFromCommandline() {

        Scanner scanner = new Scanner(System.in);
        int n =  scanner.nextInt();
        String s = scanner.nextLine();
        for (int i = 0; i < n; i++) {
            Word a = new Word();
            a.word_target = scanner.nextLine();
            a.word_explain = scanner.nextLine();
            Tu_dien.add(a);

        }
    }




}
