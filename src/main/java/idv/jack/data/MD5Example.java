package idv.jack.data;

import java.math.BigInteger;
import java.security.MessageDigest;

public class MD5Example {

    public static void main(String args[]) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] messageDigest = md.digest("column1,column2,column3".getBytes());
        BigInteger number = new BigInteger(1, messageDigest);
        String hashtext = number.toString(16);

        while (hashtext.length() < 32) {
            hashtext = "0" + hashtext;
        }
        System.out.println(hashtext);
    }

}
