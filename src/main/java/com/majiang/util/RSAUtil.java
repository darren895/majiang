package com.majiang.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

import com.majiang.entity.MobileUser;

import sun.misc.BASE64Decoder;

public class RSAUtil {

	private static final String PRI_KEY = "";
	
	public static String encrypt(String data){
		try {
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			
			byte[] byteKey = hexStr2Bytes(PRI_KEY);
			PrivateKey privateKey = keyFactory.generatePrivate(new X509EncodedKeySpec(byteKey));
			Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, privateKey);
            byte[] result = cipher.doFinal(data.getBytes("UTF-8"));
            return byte2HexString(result);
		} catch (Exception e) {
			return null;
		}
	}
	
	public static String decrypt(String data){
		try {
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");			
			byte[] byteKey = hexStr2Bytes(PRI_KEY);
			PrivateKey privateKey = keyFactory.generatePrivate(new X509EncodedKeySpec(byteKey));
			Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            byte[] result = cipher.doFinal(hexStr2Bytes(data));
            return new String(result);
		} catch (Exception e) {
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
