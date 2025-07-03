
public class ADB_ToolsCode {
	private static final boolean DEBUG = false;
    private static final String TAG = "ToolsCheckCode";

    public static String encode(String str) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        if (DEBUG) {
            Log.d(TAG, "encode key : " + str);
        }
        if (str == null || str.length() < 9) {
//            Log.e(TAG, "encode fail : Invalid key");
            return null;
        }
        String substring = str.substring(0, 2);
        String substring2 = str.substring(2, 4);
        String substring3 = str.substring(4, 6);
        String substring4 = str.substring(6, 8);
        String substring5 = str.substring(8, str.length());
        if (DEBUG) {
//            Log.d(TAG, "type " + substring + ", " + substring2 + " day " + substring3 + SettingsStringUtil.DELIMITER + substring4 + SettingsStringUtil.DELIMITER + substring5);
        }
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
        try {
            i4 = Integer.valueOf(substring4).intValue();
        } catch (NumberFormatException e4) {
            e4.printStackTrace();
            i4 = 0;
        }
        try {
            i5 = Integer.valueOf(substring5).intValue();
        } catch (NumberFormatException e5) {
            e5.printStackTrace();
            i5 = 0;
        }
        int i6 = i4 ^ i3;
        int i7 = i5 ^ i3;
        int i8 = i3 ^ (i6 + i7);
        int i9 = i ^ i7;
        int i10 = i2 ^ i7;
        String str2 = String.format("%02d", Integer.valueOf(i9)) + String.format("%02d", Integer.valueOf(i10)) + String.format("%02d", Integer.valueOf(i6)) + String.format("%02d", Integer.valueOf(i7)) + String.valueOf(i8);
        if (DEBUG) {
//            Log.d(TAG, "xor type " + i9 + ", " + i10 + " day " + i8 + SettingsStringUtil.DELIMITER + i6 + SettingsStringUtil.DELIMITER + i7);
            Log.d(TAG, "encode = " + str2);
        }
        return str2;
    }

    public static String decode(String str) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        if (DEBUG) {
            Log.d(TAG, "decode code = " + str);
        }
        if (str == null || str.length() < 9) {
//            Log.e(TAG, "decode fail : Invalid code");
            return null;
        }
        String substring = str.substring(0, 2);
        String substring2 = str.substring(2, 4);
        String substring3 = str.substring(4, 6);
        String substring4 = str.substring(6, 8);
        String substring5 = str.substring(8, str.length());
        if (DEBUG) {
//            Log.d(TAG, "xor type " + substring + ", " + substring2 + " day " + substring5 + SettingsStringUtil.DELIMITER + substring5 + SettingsStringUtil.DELIMITER + substring4);
        }
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
            i3 = Integer.valueOf(substring5).intValue();
        } catch (NumberFormatException e3) {
            e3.printStackTrace();
            i3 = 0;
        }
        try {
            i4 = Integer.valueOf(substring3).intValue();
        } catch (NumberFormatException e4) {
            e4.printStackTrace();
            i4 = 0;
        }
        try {
            i5 = Integer.valueOf(substring4).intValue();
        } catch (NumberFormatException e5) {
            e5.printStackTrace();
            i5 = 0;
        }
        int i6 = i3 ^ (i4 + i5);
        int i7 = i4 ^ i6;
        int i8 = i5 ^ i6;
        int i9 = i ^ i5;
        int i10 = i2 ^ i5;
        String str2 = String.format("%02d", Integer.valueOf(i9)) + String.format("%02d", Integer.valueOf(i10)) + String.format("%02d", Integer.valueOf(i6)) + String.format("%02d", Integer.valueOf(i7)) + String.valueOf(i8);
        if (DEBUG) {
//            Log.d(TAG, "type " + i9 + ", " + i10 + " day " + i6 + SettingsStringUtil.DELIMITER + i7 + SettingsStringUtil.DELIMITER + i8);
            Log.d(TAG, "decode key = " + str2);
        }
        return str2;
    }

}
