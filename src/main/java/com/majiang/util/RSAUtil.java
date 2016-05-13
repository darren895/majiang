package com.majiang.util;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

public class RSAUtil {
	
	public static void main(String[] args) throws NoSuchAlgorithmException {
		String s = "123";
		String str = encrypt(s);
		System.out.println(str);
		System.out.println(decrypt(str));
//        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");  
//        // 初始化密钥对生成器，密钥大小为1024位  
//        keyPairGen.initialize(512,new SecureRandom());  
//        // 生成一个密钥对，保存在keyPair中  
//        KeyPair keyPair = keyPairGen.generateKeyPair();  
//  
//        // 得到私钥  
//        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();  
//        System.out.println(byte2HexString(privateKey.getEncoded()));
//        // 得到公钥  
//        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
//        System.out.println(byte2HexString(publicKey.getEncoded()));
	}

	private static final String PRI_KEY = "30820153020100300d06092a864886f70d01010105000482013d30820139020100024100a9d6bd5e97edc1fc7676c0f81cb4423d33cc8670d8fff3d240e2cac3b9d6b0a51a54fb6cf5cb93deb7572c7dd590c22e427ed594f66110db81e6ce71ef1c4177020301000102402bc7dd5d0b111116817b2f57461ef98c495409bc01544988038df2f2ed6ef86dcb396bfd3f3ff38e4165227fe5f75062abb52a39eec52792ac8c1750c8144931022100e1d6c59183349800fc86607387343da1bb38f86b68fe6e90ba3c3828d8c797e5022100c0855fe9a48455447c2e5aeb99334ba222b7d15b3d73445fdf1cb18c58c6e62b02206e43ac86d566d26878e32b287cf4f6ba866cd46dacffbd0010cde2259f6224390220414778443302a41efab48523c9e8b8c69b5b14e4092c228d178c152fef9251cd022065f7181b6e49b85e6699cbc854f9c2010e4a52f983b996fc5e5e6e46ed54d63f";
	
	private static final String PUB_KEY = "305c300d06092a864886f70d0101010500034b003048024100a9d6bd5e97edc1fc7676c0f81cb4423d33cc8670d8fff3d240e2cac3b9d6b0a51a54fb6cf5cb93deb7572c7dd590c22e427ed594f66110db81e6ce71ef1c41770203010001";
	
	public static String encrypt(String data){
		try {
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			
			byte[] byteKey = hexStr2Bytes(PUB_KEY);
			PublicKey publicKey = keyFactory.generatePublic(new X509EncodedKeySpec(byteKey));
			Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
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
			PrivateKey privateKey = keyFactory.generatePrivate(new PKCS8EncodedKeySpec(byteKey));
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
