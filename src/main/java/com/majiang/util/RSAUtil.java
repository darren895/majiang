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
			BASE64Decoder decoder = new BASE64Decoder();
			byte[] byteKey = decoder.decodeBuffer(PRI_KEY);
			PrivateKey privateKey = keyFactory.generatePrivate(new X509EncodedKeySpec(byteKey));
			Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            byte[] result = cipher.doFinal(data.getBytes("UTF-8"));
            return new String(result);
		} catch (Exception e) {
			return null;
		}
	}
	
	public static MobileUser encryptToken(String token){
		ObjectInputStream ois = null;
		try {
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			BASE64Decoder decoder = new BASE64Decoder();
			byte[] byteKey = decoder.decodeBuffer(PRI_KEY);
			PrivateKey privateKey = keyFactory.generatePrivate(new X509EncodedKeySpec(byteKey));
			Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            byte[] result = cipher.doFinal(token.getBytes("UTF-8"));
            ois = new ObjectInputStream(new ByteArrayInputStream(result));
            MobileUser mobileUser = (MobileUser) ois.readObject();
            return mobileUser;
		} catch (Exception e) {
			return null;
		}finally {
			if(ois != null){
				try {
					ois.close();
				} catch (IOException e) {

				}
			}
		}
	}
}
