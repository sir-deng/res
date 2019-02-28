package com.tencent.mm.plugin.hce.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.nfc.NfcAdapter;
import android.os.Build.VERSION;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

public final class b {
    @TargetApi(21)
    public static boolean aSY() {
        if (VERSION.SDK_INT >= 21) {
            return ad.getContext().getPackageManager().hasSystemFeature("android.hardware.nfc.hce");
        }
        return false;
    }

    public static boolean aSZ() {
        Context context = ad.getContext();
        if (context.getPackageManager().hasSystemFeature("android.hardware.nfc") && NfcAdapter.getDefaultAdapter(context) != null) {
            return true;
        }
        return false;
    }

    public static boolean aTa() {
        NfcAdapter defaultAdapter = NfcAdapter.getDefaultAdapter(ad.getContext());
        if (defaultAdapter == null) {
            x.i("MicroMsg.HceUtils", "alvinluo no nfc chip !");
            return false;
        } else if (defaultAdapter.isEnabled()) {
            return true;
        } else {
            return false;
        }
    }
}
