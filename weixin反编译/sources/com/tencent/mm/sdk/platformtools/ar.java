package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import java.util.LinkedList;
import java.util.List;

public final class ar {
    static boolean fLn;
    private PhoneStateListener xpA;
    List<a> xpB = new LinkedList();
    private TelephonyManager xpz;

    public interface a {
        void fj(int i);
    }

    public final void a(a aVar) {
        this.xpB.add(aVar);
    }

    public final void cgF() {
        this.xpB.clear();
    }

    public static boolean ve() {
        x.i("MicroMsg.PhoneStatusWatcher", "alvinluo isCalling: %b", Boolean.valueOf(fLn));
        return fLn;
    }

    public final void eW(Context context) {
        x.i("MicroMsg.PhoneStatusWatcher", "alvinluo PhoneStatusWatcher begin");
        if (this.xpz == null) {
            this.xpz = (TelephonyManager) context.getSystemService("phone");
        }
        if (this.xpA == null) {
            this.xpA = new PhoneStateListener() {
                public final void onCallStateChanged(int i, String str) {
                    x.i("MicroMsg.PhoneStatusWatcher", "alvinluo onCallStateChanged state: %d, incomingNumber: %s", Integer.valueOf(i), str);
                    if (ar.this.xpB.size() > 0) {
                        for (a fj : (a[]) ar.this.xpB.toArray(new a[ar.this.xpB.size()])) {
                            fj.fj(i);
                        }
                    }
                    super.onCallStateChanged(i, str);
                    switch (i) {
                        case 0:
                            ar.fLn = false;
                            return;
                        case 1:
                        case 2:
                            ar.fLn = true;
                            return;
                        default:
                            return;
                    }
                }
            };
        }
        this.xpz.listen(this.xpA, 32);
    }

    public final void end() {
        x.i("MicroMsg.PhoneStatusWatcher", "alvinluo PhoneStatusWatcher end");
        if (this.xpz != null) {
            this.xpz.listen(this.xpA, 0);
            this.xpA = null;
        }
    }
}
