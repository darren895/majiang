package com.majiang.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Date;

public class SHAUtil {
	
	public static void main(String[] args) {
		System.out.println(shaEncode("00112233-4455-6677-8899-AABBCCDDEEFF"+1463037615108l+"bf615cf6bcbeb947365e90eafa3960152ad21dea"));
	}
	
	public static String shaEncode(String resource) {
		try {
			MessageDigest sha = MessageDigest.getInstance("SHA");
			byte[] resByte = resource.getBytes();
			byte[] shaByte = sha.digest(resByte);
			return byte2HexString(shaByte);
		} catch (NoSuchAlgorithmException e) {
			return null; 
		}
	}
	
	public static byte[] hexStr2Bytes(String s){
		if ((s == null) || (s.length() % 2 != 0)) {
            return new byte[0];
        }

        byte[] dest = new byte[s.length() / 2];

        for (int i = 0; i < dest.length; i++) {
            String val = s.substring(2 * i, 2 * i + 2);
            dest[i] = (byte) Integer.parseInt(val, 16);
        }
        return dest;
	}
	
    public static String byte2HexString(byte[] bytearr) {
        if (bytearr == null) {
            return "null";
        }
        StringBuffer sb = new StringBuffer();

        for (int k = 0; k < bytearr.length; k++) {
            if ((bytearr[k] & 0xFF) < 16) {
                sb.append("0");
            }
            sb.append(Integer.toString(bytearr[k] & 0xFF, 16));
        }
        return sb.toString();
    }
}
