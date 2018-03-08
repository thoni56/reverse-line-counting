package se.codersdojo.linecounter;

import java.io.BufferedReader;
import java.io.StringReader;

import java.io.IOException;

public class LineCounter {

    private boolean flag = false;

    public int countLines(String theCode) throws IOException {
        BufferedReader in = new BufferedReader(new StringReader(theCode));
        String str;
        int i = 0;
        while ((str = in.readLine()) != null){
            str = str.trim();
            String str1 = str;
            str1 = str1.trim();
            String str2;
            if (!flag){
                String str3 = null;
                if (str1.indexOf('"') > -1){
                    if (str1.substring(str1.indexOf('"')+1).indexOf('"') > -1){
                        str3 = str1.substring(0, str1.indexOf('"')) + str1.substring(str1.substring(str1.indexOf('"')+1).indexOf('"')+1);
                    }
                    else{
                        str3 = str1;
                    }
                }
                else{
                    str3 = str1;
                }
                str1 = str3;
                if (str1.indexOf("/*") > -1){
                    flag = true;
                    if (str1.indexOf("*/") > -1){
                        flag = false;
                        str2 = str1.substring(0,str1.indexOf("/*")) + str1.substring(str1.indexOf("*/")+2);
                    }else{
                        str2 = str1.substring(0,str1.indexOf("/*"));
                    }
                }else{
                    str2 =  str1;
                }
            }else{
                if (str1.indexOf("*/") > -1){
                    flag = false;
                    str2 = str1.substring(str1.indexOf("*/")+2);
                }else{
                    str2 = "";
                }
            }
            str = str2;

            str = str.trim();
            str = (str.startsWith("//")) ? "" : str;
            str = str.trim();
            if (str.length() > 0)
                i ++;
        }
        flag = false;
        return i;
    }

}
