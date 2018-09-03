package org.rsystems.util;

public class CommonUtility {
	String encryptionKey = "ATTMNPSi";

	/**
	 * Returns album name without '~' string from end.
	 * 
	 * @param actualAlbumName
	 * @return
	 */
	public String getVirtualAlbumName(String actualAlbumName) {
		String albumName = actualAlbumName.substring(0, actualAlbumName.lastIndexOf("~"));
		return albumName;
	}

	/**
	 * This method decrypts the content
	 * 
	 * @param encryptedContent
	 * @return
	 */
	public String decrypt(String encryptedContent) {
		StringBuffer decrypted = new StringBuffer();
		for (int i = 0; i < encryptedContent.length(); i += 2) {
			int j = i / 2 + 1;
			int hexVal = Integer.parseInt(encryptedContent.substring(i, Math.min(i + 2, encryptedContent.length())),
					16);
			int encryptionKeyIndex = (j % encryptionKey.length()
					- encryptionKey.length() * ((j % encryptionKey.length()) == 0 ? -1 : 0)) - 1;
			char decryptedChar = encryptionKey.substring(encryptionKeyIndex, encryptionKeyIndex + 1).charAt(0);
			int decryptedAsc = (int) decryptedChar;
			char decryptedXorChar = (char) (hexVal ^ decryptedAsc);
			decrypted.append(decryptedXorChar);
		}
		return decrypted.toString();
	}

	/**
	 * This methods encrypts the content
	 * 
	 * @param plainContent
	 * @return
	 */
	public String encrypt(String plainContent) {
		StringBuffer encrypted = new StringBuffer();

		for (int i = 1; i <= plainContent.length(); i++) {
			int hexVal = (int) plainContent.charAt(i - 1);
			int encryptionKeyIndex = (i % encryptionKey.length()
					- encryptionKey.length() * ((i % encryptionKey.length()) == 0 ? -1 : 0)) - 1;
			char decryptedChar = encryptionKey.substring(encryptionKeyIndex, encryptionKeyIndex + 1).charAt(0);
			int decryptedAsc = (int) decryptedChar;
			char decryptedXorChar = (char) (hexVal ^ decryptedAsc);
			String decryptedXorCharHexValue = StrPadLeft(Integer.toHexString(decryptedXorChar), 2, "0");
			encrypted.append(decryptedXorCharHexValue);
		}
		return encrypted.toString();
	}

	/**
	 * 
	 * @param hexValue
	 * @param count
	 * @param value
	 * @return
	 */

	private String StrPadLeft(String hexValue, int count, String value) {
		StringBuffer returnStr = new StringBuffer();
		if (hexValue.length() >= count) {
			returnStr.append(hexValue);
		} else {
			int ii = count - hexValue.length();
			for (int i = 0; i < ii; i++) {
				returnStr.append(value);
			}
			returnStr.append(hexValue);
		}

		return returnStr.toString();
	}
}
