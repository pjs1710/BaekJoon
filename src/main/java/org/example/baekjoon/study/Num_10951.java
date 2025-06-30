package org.example.baekjoon.study;

import java.io.*;

public class Num_10951 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = br.readLine();
        int pos,a,b = 0;

        while(line != null){	// EOF handling
            pos = line.indexOf(" ");
            a = Integer.parseInt(line.substring(0,pos));
            b = Integer.parseInt(line.substring(pos+1));

            bw.write(Integer.toString(a+b));
            bw.newLine();

            line = br.readLine();
        }
        bw.flush();
    }
}
