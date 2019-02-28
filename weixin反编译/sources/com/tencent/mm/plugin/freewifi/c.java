package com.tencent.mm.plugin.freewifi;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.net.wifi.SupplicantState;
import android.net.wifi.WifiManager;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class c {
    public Activity activity;
    public WifiManager bni;
    public boolean connected = false;
    public Condition fcU;
    public long hoU;
    public Lock mHC;
    public BroadcastReceiver mHF;
    public boolean mHJ = false;
    public String mHK;
    public String ssid;

    public interface a {
        void onSuccess();

        void qi(int i);
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.c$1 */
    class AnonymousClass1 implements a {
        final /* synthetic */ a mHL;

        public AnonymousClass1(a aVar) {
            this.mHL = aVar;
        }

        public final void onSuccess() {
            x.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "sessionKey=%s, step=%d, desc=Connect ssid succeeded. ", m.D(c.this.activity.getIntent()), Integer.valueOf(m.E(c.this.activity.getIntent())));
            this.mHL.onSuccess();
        }

        public final void qi(int i) {
            x.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "sessionKey=%s, step=%d, desc=Connect ssid failed. errorcode=%d", m.D(c.this.activity.getIntent()), Integer.valueOf(m.E(c.this.activity.getIntent())), Integer.valueOf(i));
            this.mHL.qi(i);
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.c$2 */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] mHN = new int[SupplicantState.values().length];

        static {
            try {
                mHN[SupplicantState.ASSOCIATED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                mHN[SupplicantState.ASSOCIATING.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                mHN[SupplicantState.AUTHENTICATING.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                mHN[SupplicantState.COMPLETED.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                mHN[SupplicantState.DISCONNECTED.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                mHN[SupplicantState.DORMANT.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                mHN[SupplicantState.FOUR_WAY_HANDSHAKE.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                mHN[SupplicantState.GROUP_HANDSHAKE.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                mHN[SupplicantState.INACTIVE.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                mHN[SupplicantState.INTERFACE_DISABLED.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                mHN[SupplicantState.INVALID.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
            try {
                mHN[SupplicantState.SCANNING.ordinal()] = 12;
            } catch (NoSuchFieldError e12) {
            }
            try {
                mHN[SupplicantState.UNINITIALIZED.ordinal()] = 13;
            } catch (NoSuchFieldError e13) {
            }
        }
    }

    public c(String str, Activity activity, String str2) {
        this.activity = activity;
        this.hoU = 30000;
        this.ssid = str;
        this.mHK = str2;
        this.mHC = new ReentrantLock();
        this.fcU = this.mHC.newCondition();
        this.bni = (WifiManager) ad.getContext().getSystemService("wifi");
    }

    public final void aLz() {
        try {
            this.activity.unregisterReceiver(this.mHF);
        } catch (IllegalArgumentException e) {
        }
    }
}
