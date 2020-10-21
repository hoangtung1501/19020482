
package A;
import sun.security.krb5.SCDynamicStoreConfig;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DictionaryCommandLine extends DictionaryManagement {

    public String[] dictionarySearcher(String tmp) throws IOException {

        String s = "";
        for(int i=0;i<Tu_dien.size();i++) {
            String a = Tu_dien.get(i).word_target;
            int t=0;

            if(a.length()>=tmp.length()) {
                for(int j=0;j<tmp.length();j++) {
                    if(Character.toUpperCase(tmp.charAt(j)) ==Character.toUpperCase(a.charAt(j)))
                    { t++;} else {
                        break;
                    }
                }
                if(t==tmp.length()) {
                    s=s+a+"\t";
                }
            }


        }

        String []s1=s.split("\t");
        return s1;

    }


}
