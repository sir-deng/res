package com.tencent.liteav.basic.e;

import java.io.ByteArrayOutputStream;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import javax.crypto.Cipher;

public final class a {
    private static String a = "RSA";

    public static byte[] a(byte[] bArr, PrivateKey privateKey) {
        Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        instance.init(2, privateKey);
        int i = 0;
        int length = bArr.length;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int i2 = i;
            byte[] doFinal;
            if (length - i2 > 0) {
                if (length - i2 >= instance.getBlockSize()) {
                    doFinal = instance.doFinal(bArr, i2, instance.getBlockSize());
                } else {
                    doFinal = instance.doFinal(bArr, i2, length - i2);
                }
                byteArrayOutputStream.write(doFinal);
                i = instance.getBlockSize() + i2;
            } else {
                doFinal = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return doFinal;
            }
        }
    }

    public static PrivateKey a(byte[] bArr) {
        return KeyFactory.getInstance(a).generatePrivate(new PKCS8EncodedKeySpec(bArr));
    }
}
