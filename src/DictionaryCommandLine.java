import sun.security.krb5.SCDynamicStoreConfig;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DictionaryCommandLine extends DictionaryManagement {
    public void showAllWords() {
        System.out.println("No  |English\t\t\t\t|Vietnamese");
        int n = Tu_dien.size();
        for (int i=0 ;i<n ;i++)
        {
            System.out.printf("%d\t|%-10s\t\t\t\t|%-10s\n",i+1,Tu_dien.get(i).word_target,Tu_dien.get(i).word_explain);
        }
    }
    public void dictionaryBasic() throws IOException {
        insertFromCommandline();

        showAllWords();
    }
    public void dictionaryAdvanced() throws IOException {
        insertFromFile();
        showAllWords();
        System.out.println("Ban co the tra cuu trong tu dien:");
        System.out.println("1:Tim kiem \t 2:Them \t 3:Xoa");
        System.out.println("4:Sua \t 5:In \t 6:Thoat");
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0 && t <=6) {
            if(t==1) {
                dictionarySearcher();
                System.out.println("Ban muon tra cuu them:");
                t = sc.nextInt();
            } else if(t==2) {
                dictionaryAdd();
                System.out.println("Ban muon tra cuu them:");
                t = sc.nextInt();
            } else if(t==3) {
                dictionaryRemove();
                System.out.println("Ban muon tra cuu them:");
                t = sc.nextInt();
            } else if(t==4){
                dictinaryChange();
                System.out.println("Ban muon tra cuu them:");
                t = sc.nextInt();
            } else if(t==5){
                showAllWords();
                System.out.println("Ban muon tra cuu them:");
                t = sc.nextInt();

            } else {
                dictionaryExportToFile();
                return;
            }
        }
    }

    public void dictionarySearcher() {
        System.out.println("Ban hay nhap tu tim kiem:");
        Scanner sc = new Scanner(System.in);
        String tmp = sc.nextLine();
        ArrayList<Word> Tu_tim_kiem = new ArrayList<>();
        for(int i=0;i<Tu_dien.size();i++) {
            String a = Tu_dien.get(i).word_target;
            int t=0;
            for(int j=0;j<tmp.length();j++)
            {
                if(Character.toUpperCase(tmp.charAt(j)) == Character.toUpperCase(a.charAt(j))) {
                    t++;
                }
            }
            if(t == tmp.length()) {
                Word s = new Word(Tu_dien.get(i).word_target,Tu_dien.get(i).word_explain);
                Tu_tim_kiem.add(s);
            }
        }
        if(Tu_tim_kiem.size() == 0) {
            System.out.println("Tu ban tim kiem khong co trong danh sach:");
        } else {
            System.out.println("Cac tu co the ma ban dang tim:");
            for(int i=0;i<Tu_tim_kiem.size();i++) {
                System.out.printf("%d\t| %-10s\t\t| %-10s\n",i+1,Tu_tim_kiem.get(i).word_target,Tu_tim_kiem.get(i).word_explain);
            }
        }

    }
    public static void main (String[] args) throws IOException {
        DictionaryCommandLine a = new DictionaryCommandLine();
        a.dictionaryAdvanced();
    }
}
