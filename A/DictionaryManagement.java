package A;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
public class DictionaryManagement  extends Dictionary{


    public  void insertFromFile() throws IOException{

        Scanner sc = new Scanner(Paths.get("dictionaries.txt"), "UTF-8");
        while(sc.hasNextLine()){
            String s="";
            int t=0;
            while(sc.hasNextLine() && t!=20) {
                String a=sc.nextLine();
                if(a.equals("")){
                   t++;
                }
                s= s + a + "\n" ;
           }
            String [] b = s.split("@");
            for(int i=0;i<b.length;i++) {
                Word tu = new Word();
                String [] tmp= b[i].split("/");
                if(tmp.length==3) {
                    tu.word_target = tmp[0];
                    tu.word_explain = "/" +tmp[1] +"/" +"\n" +tmp[2];
                    Tu_dien.add(tu);}
            }}
        sc.close();

    }
  
}
