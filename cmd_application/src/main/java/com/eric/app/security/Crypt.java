package com.eric.app.security;

import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
public class Crypt 
{
    public  String encrypt(String password) 
    { byte[] encrypted={0};
    String enc="null";
        try 
        {            
            String text = password;
            System.out.println(text);
            String key = "Bar12345Bar12345"; // 128 bit key
            // Create key and cipher
            Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            // encrypt the text
            cipher.init(Cipher.ENCRYPT_MODE, aesKey);
             encrypted = cipher.doFinal(text.getBytes());
             enc=encrypted.toString();
        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
      //  System.out.println(encrypted.toString());
       // System.out.println(encrypted.toString());
		return enc;
    }
    
 /*   public static void main(String[] args){
    	Crypt.encrypt("myPass");
    	Crypt.decrypt(Crypt.encrypt("myPass"));
    }
*/    
    public String decrypt(String encrypt){
    byte[] decrypted={0};
    	String dec=null;
    	//System.out.println(encrypted + "" + encrypted.length);
    	try{
    		String text=encrypt;
    		String key = "Bar12345Bar12345"; // 128 bit key
            Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, aesKey);
            
            decrypted = cipher.doFinal(text.getBytes());
            dec=decrypted.toString();
                    
           
    	}
    	catch(Exception e)
    	{
    		 e.printStackTrace();
    	}
      return dec;
    }
} 