package eu.jaimefreire.fix;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.*;

/**
 * Created by jaimefreire on 28/07/2016.
 */
public class StrongPass {

    static final StringBuffer chars= new StringBuffer();

    static {
        final Charset charset = Charset.forName("UTF-8");
        for (int i = 0; i < 255; i++) {
            ByteBuffer bb = ByteBuffer.allocate(4);
            bb.putInt(i);
            chars.append(new String(bb.array(), charset).trim());
        }

    }

    public static boolean isAsciiPrintable(char ch) {
        return ch >= 32 && ch < 127;
    }

    public static String generatePassword() {

        //String[] symbols = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};
        int length = 30;
        Random random = null;    // as of JDK 8, this should return the strongest algorithm available to the JVM
        try {
            random = SecureRandom.getInstanceStrong();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        StringBuilder sb = new StringBuilder(length);
        char[] charArray = chars.toString().toCharArray();

        while(sb.length()<length)

        {
            int indexRandom = random.nextInt(charArray.length);
            if (StrongPass.isAsciiPrintable(charArray[indexRandom]))
                sb.append(charArray[indexRandom]);
        }

        String password = sb.toString();
//        String cleanPwd  = password.replaceAll("\\p{C}", "?");;
        System.out.println("Pwd: " + password);

        return password;

    }
}