package ba.sec.app.secApp.rest;

import java.security.MessageDigest;
import java.util.Random;

public class BasicService {
	
	private static final Random R = new Random();
	private static final String SHA_256 = "SHA-256";
	private static final String  SALT = "$1001#._-*";

	public static String hashPassword(String password) throws Exception
	{		
		Random randomGenerator = BasicService.R;
		double randomDouble = randomGenerator.nextDouble();
		MessageDigest digest256 = MessageDigest.getInstance(SHA_256);
		byte[] hash256 = digest256.digest((randomDouble + SALT).getBytes());
		String h256 = BasicService.getHex(hash256);
		String px = (new StringBuilder()).append(h256.substring(0, 32)).append( password.substring(0, 32))
				.append(h256.substring(32, 64)).append( password.substring(32, 64)).toString();
		
		return px;
	}
	
	public static String getHex(byte[] b) throws Exception {
		String result = "";
		for (int i = 0; i < b.length; i++) {
			result += Integer.toString((b[i] & 0xff) + 0x100, 16).substring(1);
		}
		return result;
	}

}
