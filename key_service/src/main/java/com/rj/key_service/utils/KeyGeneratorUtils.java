package com.rj.key_service.utils;

import java.security.*;
import java.util.Base64;

public class KeyGeneratorUtils {

    public static KeyPair generateRSAKeyPair() throws NoSuchAlgorithmException {
        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
        generator.initialize(2048); // Seguridad estándar actual
        return generator.generateKeyPair();
    }

    public static String keyToString(Key key) {
        // Convertimos a Base64 para guardarlo como String en Redis o Archivo
        return Base64.getEncoder().encodeToString(key.getEncoded());
    }
}
