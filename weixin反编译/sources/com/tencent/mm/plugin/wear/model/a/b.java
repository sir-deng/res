package com.tencent.mm.plugin.wear.model.a;

import android.net.Uri;
import com.google.android.gms.common.api.c;
import com.google.android.gms.wearable.Asset;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.util.HashSet;

public interface b {

    public static class a {
        public int code;
        public String foE;

        a() {
            this.code = 0;
        }

        a(byte b) {
            this.code = 0;
            this.code = WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT;
        }
    }

    byte[] a(Asset asset);

    void bPp();

    c bPq();

    HashSet<String> bPr();

    boolean bPs();

    void bPt();

    void finish();

    boolean h(Uri uri);

    boolean isAvailable();

    a s(String str, byte[] bArr);

    a t(String str, byte[] bArr);
}
