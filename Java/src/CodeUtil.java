import java.util.Date;


public class CodeUtil {
	static String TAG = "";

    @SuppressWarnings("deprecation")
    public static String generateWatchCheckCode() {
        Log.d(TAG, "generateWatchCheckCode");
        Date date = new Date(System.currentTimeMillis());
        int hours = date.getHours();
        int minutes = date.getMinutes();
        int seconds = date.getSeconds();
        Log.d(TAG, "hours = " + hours + ", minutes = " + minutes + ", seconds = " + seconds);
        int i2 = hours ^ seconds;
        int i3 = minutes ^ seconds;
        Log.d(TAG, "xorH = " + i2 + ", xorM = " + i3 + ", xorS = " + (seconds ^ (i2 + i3)));
        String str = String.format("%02d", Integer.valueOf(i2)) + String.format("%02d", Integer.valueOf(i3)) + String.valueOf(seconds ^ (i2 + i3));
        Log.d(TAG, "generateWatchCheckCode = " + str);
        return str;
    }

    public static String decodeWatchCheckCode(String str) {
        int i;
        int i2;
        int i3;
        Log.d(TAG, "decodeWatchCheckCode = " + str);
        if (str == null || str.length() < 5) {
            Log.d(TAG, "Invalid code");
            return null;
        }
        String substring = str.substring(0, 2);
        String substring2 = str.substring(2, 4);
        String substring3 = str.substring(4, str.length());
        Log.d(TAG, "strH = " + substring + ", strM = " + substring2 + ", strS = " + substring3);
        try {
            i = Integer.valueOf(substring).intValue();
        } catch (NumberFormatException e) {
            e.printStackTrace();
            i = 0;
        }
        try {
            i2 = Integer.valueOf(substring2).intValue();
        } catch (NumberFormatException e2) {
            e2.printStackTrace();
            i2 = 0;
        }
        try {
            i3 = Integer.valueOf(substring3).intValue();
        } catch (NumberFormatException e3) {
            e3.printStackTrace();
            i3 = 0;
        }
        int i5 = i3 ^ (i + i2);
        int i6 = i ^ i5;
        Log.d(TAG, "hours = " + i6 + ", minutes = " + (i2 ^ i5) + ", seconds = " + i5);
        return String.format("%02d", Integer.valueOf(i6)) + String.format("%02d", Integer.valueOf(i2 ^ i5)) + String.valueOf(i5);
    }

    public static String generateToolsCheckCode(String str) {
        int i;
        int i2;
        int i3;
        Log.d(TAG, "generateToolsCheckCode key = " + str);
        if (str == null || str.length() < 5) {
            Log.d(TAG, "Invalid key");
            return null;
        }
        String substring = str.substring(0, 2);
        String substring2 = str.substring(2, 4);
        String substring3 = str.substring(4, str.length());
        Log.d(TAG, "strH = " + substring + ", strM = " + substring2 + ", strS = " + substring3);
        try {
            i = Integer.valueOf(substring).intValue();
        } catch (NumberFormatException e) {
            e.printStackTrace();
            i = 0;
        }
        try {
            i2 = Integer.valueOf(substring2).intValue();
        } catch (NumberFormatException e2) {
            e2.printStackTrace();
            i2 = 0;
        }
        try {
            i3 = Integer.valueOf(substring3).intValue();
        } catch (NumberFormatException e3) {
            e3.printStackTrace();
            i3 = 0;
        }
        Log.d(TAG, "hours = " + i + ", minutes = " + i2 + ", seconds = " + i3);
        int i5 = i2 ^ i;
        int i6 = i3 ^ i;
        Log.d(TAG, "xorH = " + (i ^ (i5 + i6)) + ", xorM = " + i5 + ", xorS = " + i6);
        String str2 = String.format("%02d", Integer.valueOf(i5)) + String.format("%02d", Integer.valueOf(i6)) + String.valueOf(i ^ (i5 + i6));
        Log.d(TAG, "generateToolsCheckCode = " + str2);
        return str2;
    }

    public static String decodeToolsCheckCode(String str) {
        int i;
        int i2;
        int i3;
        Log.d(TAG, "decodeToolsCheckCode = " + str);
        if (str == null || str.length() < 5) {
            Log.d(TAG, "Invalid code");
            return null;
        }
        String substring = str.substring(0, 2);
        String substring2 = str.substring(2, 4);
        String substring3 = str.substring(4, str.length());
        Log.d(TAG, "strH = " + substring3 + ", strM = " + substring + ", strS = " + substring2);
        try {
            i = Integer.valueOf(substring3).intValue();
        } catch (NumberFormatException e) {
            e.printStackTrace();
            i = 0;
        }
        try {
            i2 = Integer.valueOf(substring).intValue();
        } catch (NumberFormatException e2) {
            e2.printStackTrace();
            i2 = 0;
        }
        try {
            i3 = Integer.valueOf(substring2).intValue();
        } catch (NumberFormatException e3) {
            e3.printStackTrace();
            i3 = 0;
        }
        int i6 = i ^ (i2 + i3);
        Log.d(TAG, "hours = " + i6 + ", minutes = " + (i2 ^ i6) + ", seconds = " + (i3 ^ i6));
        return String.format("%02d", Integer.valueOf(i6)) + String.format("%02d", Integer.valueOf(i2 ^ i6)) + String.valueOf(i3 ^ i6);
    }


}
