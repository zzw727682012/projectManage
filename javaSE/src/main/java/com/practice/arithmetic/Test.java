package com.practice.arithmetic;

import java.io.File;
import java.util.*;
import java.util.logging.Logger;


public class Test {
    private static final Logger log = Logger.getLogger(Test.class.getSimpleName());

    public static void main(String[] args) {
        String filePath = "/FTP/GZ/Response/";
        File file = new File(filePath);
        File rf = new File(file.getParent()+"/Received");
        System.out.println(rf.getPath());
    }

    public static void statistics(HashMap<String, String> hashMap) {

        double sum = 0;
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            List<Integer> total = new ArrayList<>();
            String[] strings = entry.getValue().split("\\+");
            for (String s : strings) {
                if (s.trim().length() > 0) {
                    String[] strings1 = s.split("\\-");
                    if (!strings1[0].equals("")) {
                        strings1[0] = "+" + strings1[0];
                    }
                    for (String s1 : strings1) {

                        if (s1.trim().length() > 0) {
                            if (s1.startsWith("+"))
                                total.add(Integer.parseInt(s1.substring(1)));
                            else
                                total.add(-Integer.parseInt(s1));
                        }
                    }
                }
            }
            int d = 0;
            for (Integer s : total) {
                d += s;
            }
            double b = (double) d/2;
            sum += b;
            System.out.println(entry.getKey() + ":" + b);
        }
        System.out.println("总计：" + sum);
    }

    public static void add(HashMap<String, String> hashMap) {
        String[] strings = new String[11];

        strings[10] = "42";
        strings[9] = "+30+48-38-59-40-234-53-26-155-65+77";
        strings[8] = "-49-54+294-80-28+72-55-169";
        strings[7] = "-139-7+80-175+132+34+31-27+8-207-91";
        strings[6] = "-135+29-38+93-52-79-24-33-59-20-85+69-50-183-2+17-31-105+22";
        strings[5] = "63-71-10+200+75+5+63+192-68+107-51-125+82-121+23-82-91-44";
        strings[4] = "+8-4+24+15+32-29-40";
        strings[3] = "-23-43+44+223+33-25+7-37";
        strings[2] = "-158-40-73+98-54-53+4-14";
        strings[1] = "-54+43+41-63+90-58-29-85+33-49-25-237";
        strings[0] = "+65+81-67+87-138+49+17-47+12+45-148-43-99-4-96-68";

        int day = 10;
        for (int i = 0; i < 11; i++) {
            hashMap.put("6月" + day + "日", strings[i]);
            day++;
        }
    }
}
