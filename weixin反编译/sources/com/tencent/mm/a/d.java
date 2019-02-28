package com.tencent.mm.a;

import android.util.Base64;
import com.tencent.mm.sdk.platformtools.x;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

public final class d {
    private Cipher fcY;
    private Cipher fcZ;

    public d(String str) {
        try {
            Key generateSecret = SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(str.getBytes("UTF8")));
            AlgorithmParameterSpec ivParameterSpec = new IvParameterSpec("manifest".getBytes("UTF8"));
            this.fcY = Cipher.getInstance("DES/CBC/PKCS5Padding");
            this.fcY.init(1, generateSecret, ivParameterSpec);
            this.fcZ = Cipher.getInstance("DES/CBC/PKCS5Padding");
            this.fcZ.init(2, generateSecret, ivParameterSpec);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.DESUtil", e, "", new Object[0]);
        }
    }

    public final String bM(String str) {
        try {
            return new String(this.fcZ.doFinal(Base64.decode(str, 0)), "UTF8");
        } catch (Exception e) {
            return "[des]" + str + "|" + e.toString();
        }
    }
}
