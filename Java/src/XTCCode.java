
public class XTCCode {
	public static void main(String[] args) {
		if (args.length == 1) {
			String code = args[0];
			int len = code.length();
			if (len == 5 || len == 6 || len == 7) {
				System.out.println(genSelftest(code));
			}else if (len == 9 || len == 10 || len == 11) {
				System.out.println(genADB(code));
			}else {
				System.out.println("error: input length is illegal");
			}
		}else {
			printHelp();
		}
	}
	private static void printHelp() {
		System.out.println("XTCCode");
		System.out.println("  usage: xtccode [yourcode]");
	}
	public static String genSelftest(String string) {
		return CodeUtil.generateToolsCheckCode(CodeUtil.decodeWatchCheckCode(string));
	}
	public static String genADB(String string) {
		return ADB_ToolsCode.encode(ADB_WatchCode.decode(string));
	}
}
