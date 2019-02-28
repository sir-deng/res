package com.tencent.mm.plugin.wallet_core.model;

import android.util.Base64;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import java.security.Key;
import java.security.PublicKey;
import javax.crypto.Cipher;

public final class l {
    static l sTn;
    private PublicKey sTo = null;

    public final String aT(byte[] bArr) {
        try {
            this.sTo = com.tencent.mm.a.l.k(ad.getContext(), "lbs_rsa_public_key.pem");
            x.i("MicroMsg.LocationEncrypt", "getPemPublickKeyFromAsset23 done2");
            Key key = this.sTo;
            Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            instance.init(1, key);
            return new String(Base64.encode(instance.doFinal(bArr), 0));
        } catch (Exception e) {
            x.e("MicroMsg.LocationEncrypt", "encry publicKey error %s", e.getMessage());
            return "";
        }
    }
}
