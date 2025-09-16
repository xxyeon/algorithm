import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();
        char[] ch = num.toCharArray();
        //최소 M최대한 연결, K단위로 자르기 (K미포함)
        //최대 M최대한 나누기, K단위로 자르기 (K포함)
        int start = 0, end = 0;
        String minNum = "";
        StringBuilder sb = new StringBuilder();
        while(start < ch.length && end < ch.length) {
            if(ch[end] == 'K') {
                if(end > start) {
                    sb.append("1");
                    for(int i=0;i<end-start-1;i++) sb.append("0");
//                    minNum += Math.pow(10, end - start-1); //K 전까지 자르기

                }
                sb.append("5"); //k미포함 -> K한개이면 10^0 * 5
                start = end + 1;
                end = start;
            } else {
                end++;
            }

            if (end == ch.length) {
                if (ch[end-1] == 'M') {
                    sb.append("1");
                    for (int i = 0; i < end - start-1; i++) sb.append("0");

//                    minNum += (int)Math.pow(10, end - start );
                }
            }

        }

        start=0;
        end = 0;
        String maxNum = "";
        StringBuilder maxsb = new StringBuilder();
        while (start < ch.length && end < ch.length) {
            if (ch[end] == 'K') {
                maxsb.append("5");
                for (int i = 0; i < end - start; i++) maxsb.append("0");

//                maxNum += (int)Math.pow(10, end - start) * 5; //K 전까지 자르기
                start = end+1;
                end = start;
            } else {
                end++;
            }
            if (end == ch.length) {
                if(ch[end-1] == 'M') {

                    for(int i=0; i< end - start; i++) {
                        maxsb.append("1");
                    }
                }
            }
        }

        System.out.println(maxsb.toString());
        System.out.println(sb.toString());



    }



}