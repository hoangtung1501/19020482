import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class DictionaryManagement extends Dictionary {
    public void insertFromCommandline() {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String s = scanner.nextLine();
        for (int i = 0; i < n; i++) {
            Word a = new Word();
            a.word_target = scanner.nextLine();
            a.word_explain = scanner.nextLine();
            Tu_dien.add(a);

        }
    }
    public void insertFromFile() throws IOException {
            Scanner sc = new Scanner(Paths.get("dictionaries.txt"), "UTF8");
        /*File fileDir = new File("dictionaries.txt");

        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileDir), "UTF8"));*/

            while(sc.hasNextLine()) {
                Word mang = new Word();
                String a = sc.nextLine();
                String[] b= a.split("\t");
                mang.word_target = b[0];
                mang.word_explain = b[1];
                 Tu_dien.add(mang);

            }
            sc.close();

    }
    public void dictionaryLookup() {
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("Tu ban tra cuu la:");
            String tu_can_tra = sc.next();
            if(tu_can_tra.equals("1")) return;
            int i=0;
            int t=0;
            while (i<Tu_dien.size()) {
                if(Tu_dien.get(i).word_target.compareToIgnoreCase(tu_can_tra)==0) {
                    System.out.println("Tu ban tra cuu có trong tu dien la:");
                    System.out.printf("%d\t| %-10s\t\t| %-10s\n",i+1,Tu_dien.get(i).word_target,Tu_dien.get(i).word_explain);
                    break;
                } else {
                    t++;
                }
                i++;

            }
            if(t==Tu_dien.size()) {
                System.out.println("Tu ban tra cuu khong co trong tu dien");
            }

        }
    }

    public void dictionaryAdd() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ban hay nhap tu can them:");
        String t_anh = sc.nextLine();
        String t_viet = sc.nextLine();
        Word a = new Word(t_anh,t_viet);
        Tu_dien.add(a);
    }

    public void dictionaryRemove() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ban hay nhap tu can xoa:");
        String t_anh = sc.nextLine();
        int tmp = 0;
        for(int i=0;i<Tu_dien.size();i++)
        {
            if(Tu_dien.get(i).word_target.equals(t_anh)) {
                Tu_dien.remove(i);
                tmp++;
            }
        }
        if(tmp == 0) {
            System.out.println("Tu ban xoa khong co trong tu dien:");
        }
    }

    public void dictinaryChange() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hay nhap tu ban can thay doi");
        String t_anh = sc.nextLine();
        int tmp = -1;
        for(int i=0;i<Tu_dien.size();i++)
        {
            if(Tu_dien.get(i).word_target.equals(t_anh)) {
                tmp = i;
            }
        }
        if(tmp == -1) {
            System.out.println("Tu ban muon thay doi khong co trong tu dien:");
            return;
        }
        System.out.println("Ban muon sua tu an 1, sua nghia an 2, hay ca hay an 3:");
        int lua_chon = sc.nextInt();
        String a = sc.nextLine();
        if(lua_chon == 1) {
            System.out.println("tu ban muon thay the:");
            a = sc.nextLine();
            Tu_dien.get(tmp).word_target = a;
            System.out.println("Sau khi thay doi:");
            System.out.println(Tu_dien.get(tmp).word_target + "\t" + Tu_dien.get(tmp).word_explain);
        } else if(lua_chon == 2) {
            System.out.println("ban hay nhap nghia can thay the:");
            String b = sc.nextLine();
            Tu_dien.get(tmp).word_explain = b;
            System.out.println("Sau khi thay doi:");
            System.out.println(Tu_dien.get(tmp).word_target + "\t" + Tu_dien.get(tmp).word_explain);
        } else if(lua_chon == 3) {
            System.out.println("ban hay nhap tu va nghia thay the:");
            a = sc.nextLine();
            String b = sc.nextLine();
            Tu_dien.get(tmp).word_target = a;
            Tu_dien.get(tmp).word_explain = b;
            System.out.println("Sau khi thay doi:");
            System.out.println(Tu_dien.get(tmp).word_target + "\t" + Tu_dien.get(tmp).word_explain);
        }
    }

    public void dictionaryExportToFile() throws FileNotFoundException ,
            UnsupportedEncodingException {
         PrintWriter sys = new PrintWriter("files.txt", "UTF-8");
         for (int i=0;i<Tu_dien.size();i++) {
             sys.println(Tu_dien.get(i).word_target + "\t" + Tu_dien.get(i).word_explain);
         }
            sys.close();
    }




}
