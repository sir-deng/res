package com.tencent.mm.plugin.nfc;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Intent;
import android.nfc.NfcAdapter;
import android.nfc.cardemulation.CardEmulation;
import android.nfc.cardemulation.HostApduService;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Base64;
import com.tencent.mm.f.a.ib;
import com.tencent.mm.f.a.id;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

@TargetApi(19)
public class HCEService extends HostApduService {
    private static long mStartTime = -1;
    private static final byte[] oXh = new byte[]{(byte) 0, (byte) 0};
    private String mAppId = null;
    private ArrayList<String> oXa;
    private boolean oXb = false;
    private boolean oXc = true;
    private boolean oXd = false;
    private boolean oXe = false;
    private com.tencent.mm.plugin.nfc.b.a oXf = new a();
    private com.tencent.mm.plugin.nfc.b.b oXg = new b();
    private c<ib> oXi = new c<ib>() {
        {
            this.xmG = ib.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            ib ibVar = (ib) bVar;
            x.i("MicroMsg.HCEService", "alvinluo HCELifeCycle listener callback, type: %d", Integer.valueOf(ibVar.fzt.type));
            switch (ibVar.fzt.type) {
                case 13:
                    HCEService.this.bfW();
                    HCEService.this.stopSelf();
                    break;
                case 21:
                    if (HCEService.this.oXg != null) {
                        HCEService.this.oXg.onCreate();
                        break;
                    }
                    break;
                case 22:
                    if (HCEService.this.oXg != null) {
                        HCEService.this.oXg.onResume();
                        break;
                    }
                    break;
                case 23:
                    if (HCEService.this.oXg != null) {
                        HCEService.this.oXg.onPause();
                        break;
                    }
                    break;
                case 24:
                    if (HCEService.this.oXg != null) {
                        HCEService.this.oXg.onDestroy();
                        break;
                    }
                    break;
                case 32:
                    if (HCEService.this.oXf != null) {
                        HCEService.this.oXf.dJ(ibVar.fzt.appId, ibVar.fzt.extras.getString("key_apdu_command"));
                        break;
                    }
                    break;
            }
            return false;
        }
    };

    private class b implements com.tencent.mm.plugin.nfc.b.b {
        private b() {
        }

        /* synthetic */ b(HCEService hCEService, byte b) {
            this();
        }

        public final void onCreate() {
            x.i("MicroMsg.HCEService", "alvinluo HCELifeCycle AppBrandUI onCreate");
        }

        public final void onResume() {
            x.i("MicroMsg.HCEService", "alvinluo HCELifeCycle AppBrandUI onResume");
            if (HCEService.this.oXb) {
                HCEService.this.bfV();
                HCEService.this.oXb = false;
            }
        }

        public final void onPause() {
            x.i("MicroMsg.HCEService", "alvinluo HCELifeCycle AppBrandUI onPause");
            HCEService.this.bfW();
            HCEService.this.oXb = true;
        }

        public final void onDestroy() {
            x.i("MicroMsg.HCEService", "alvinluo HCELifeCycle AppBrandUI onDestroy");
        }
    }

    private class a implements com.tencent.mm.plugin.nfc.b.a {
        private a() {
        }

        /* synthetic */ a(HCEService hCEService, byte b) {
            this();
        }

        public final void dI(String str, String str2) {
            x.i("MicroMsg.HCEService", "alvinluo HCECOMMAND send to AppBrand, appId: %s, command: %s", str, str2);
            if (bi.oN(str) || bi.oN(str2)) {
                x.e("MicroMsg.HCEService", "alvinluo HCECOMMAND invalid appId or command when send request command to AppBrand");
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("key_apdu_command", str2);
            HCEService.d(str, 31, bundle);
            HCEService.this.oXc = true;
            if (!HCEService.this.oXd) {
                HCEService.this.oXd = true;
                HCEService.this.oXe = false;
                HCEService.mStartTime = System.currentTimeMillis();
                g.Dt().g(new Runnable() {
                    public final void run() {
                        x.i("MicroMsg.HCEService", "alvinluo HCEService timer check, timeLimit: %d, hasCommandNotResponded: %b", Integer.valueOf(1500), Boolean.valueOf(HCEService.this.oXc));
                        HCEService.this.oXe = true;
                        HCEService.this.e(HCEService.oXh, true);
                    }
                }, 1500);
            } else if (HCEService.this.oXe) {
                x.w("MicroMsg.HCEService", "alvinluo HCECOMMAND TimeExceeded, just return default command");
                HCEService.this.e(HCEService.oXh, true);
                HCEService.this.oXe = false;
            }
        }

        public final void dJ(String str, String str2) {
            if (HCEService.this.mAppId == null || !HCEService.this.mAppId.equals(str) || bi.oN(str2)) {
                x.e("MicroMsg.HCEService", "alvinluo HCECOMMAND not the same appId, or invalid response command, mAppId: %s, appId: %s, responseCommand: %s", HCEService.this.mAppId, str, str2);
                return;
            }
            x.i("MicroMsg.HCEService", "alvinluo HCECOMMAND response from AppBrand, appId: %s, command in base64: %s, send to system: %s, hasCommandNotResponded: %b", str, str2, b.aF(Base64.decode(str2, 2)), Boolean.valueOf(HCEService.this.oXc));
            HCEService.this.e(r0, false);
        }
    }

    public void onCreate() {
        super.onCreate();
        x.i("MicroMsg.HCEService", "alvinluo HCEService onCreate");
        if (!com.tencent.mm.sdk.b.a.xmy.d(this.oXi)) {
            com.tencent.mm.sdk.b.a.xmy.a(this.oXi);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        x.i("MicroMsg.HCEService", "alvinluo HCEService onDestroy");
        bfW();
        if (com.tencent.mm.sdk.b.a.xmy.d(this.oXi)) {
            com.tencent.mm.sdk.b.a.xmy.c(this.oXi);
        }
    }

    @TargetApi(21)
    private void bfV() {
        if (this.oXa == null) {
            x.e("MicroMsg.HCEService", "alvinluo mAidList is null, fail to register");
            return;
        }
        NfcAdapter defaultAdapter = NfcAdapter.getDefaultAdapter(this);
        if (defaultAdapter == null) {
            x.e("MicroMsg.HCEService", "alvinluo NfcAdapter is null when register aids");
        } else if (VERSION.SDK_INT < 21) {
            x.e("MicroMsg.HCEService", "alvinluo android version: %d is not satisfied when register aids", Integer.valueOf(VERSION.SDK_INT));
        } else {
            CardEmulation instance = CardEmulation.getInstance(defaultAdapter);
            if (instance != null) {
                try {
                    ComponentName componentName = new ComponentName(this, HCEService.class);
                    x.i("MicroMsg.HCEService", "alvinluo register aids result: %b", Boolean.valueOf(instance.registerAidsForService(componentName, "payment", this.oXa)));
                    if (instance.registerAidsForService(componentName, "payment", this.oXa)) {
                        hd(true);
                        List aidsForService = instance.getAidsForService(componentName, "payment");
                        if (aidsForService != null && aidsForService.size() > 0) {
                            for (int i = 0; i < aidsForService.size(); i++) {
                                x.e("MicroMsg.HCEService", "dynamicAIDList aid=" + ((String) aidsForService.get(i)));
                            }
                            return;
                        }
                        return;
                    }
                    hd(false);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.HCEService", e, "alvinluo HCEService register aid exception", new Object[0]);
                    hd(false);
                }
            }
        }
    }

    private void hd(boolean z) {
        Bundle bundle = new Bundle();
        if (z) {
            bundle.putInt("errCode", 0);
            bundle.putString("errMsg", "");
        } else {
            bundle.putInt("errCode", 13006);
            bundle.putString("errMsg", "register aids failed");
        }
        d(this.mAppId, 12, bundle);
    }

    private static void d(String str, int i, Bundle bundle) {
        com.tencent.mm.sdk.b.b idVar = new id();
        idVar.fzv.appId = str;
        idVar.fzv.type = i;
        idVar.fzv.extras = bundle;
        com.tencent.mm.sdk.b.a.xmy.m(idVar);
    }

    @TargetApi(21)
    private void bfW() {
        NfcAdapter defaultAdapter = NfcAdapter.getDefaultAdapter(this);
        if (defaultAdapter != null && VERSION.SDK_INT >= 21) {
            CardEmulation instance = CardEmulation.getInstance(defaultAdapter);
            if (instance != null) {
                ComponentName componentName = new ComponentName(this, HCEService.class);
                x.i("MicroMsg.HCEService", "alvinluo HCEService unregister aids");
                instance.removeAidsForService(componentName, "payment");
            }
        }
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        x.i("MicroMsg.HCEService", "alvinluo HCEService onStartCommand");
        long currentTimeMillis = System.currentTimeMillis();
        x.i("MicroMsg.HCEService", "alvinluo HCEService onStartCommand start: %d", Long.valueOf(currentTimeMillis));
        if (intent == null) {
            return super.onStartCommand(intent, i, i2);
        }
        this.mAppId = intent.getStringExtra("key_appid");
        this.oXa = intent.getStringArrayListExtra("key_aid_list");
        bfV();
        this.oXb = false;
        long currentTimeMillis2 = System.currentTimeMillis();
        x.i("MicroMsg.HCEService", "alvinluo HCEService onStartCommand end: %d, total: %d", Long.valueOf(currentTimeMillis2), Long.valueOf(currentTimeMillis2 - currentTimeMillis));
        return super.onStartCommand(intent, i, i2);
    }

    public byte[] processCommandApdu(byte[] bArr, Bundle bundle) {
        x.i("MicroMsg.HCEService", "alvinluo HCECOMMAND processCommandApdu, received command from system: %s", b.aF(bArr));
        if (this.oXf != null) {
            this.oXf.dI(this.mAppId, new String(Base64.encode(bArr, 2)));
        }
        return null;
    }

    public void onDeactivated(int i) {
        x.i("MicroMsg.HCEService", "alvinluo HCEService onDeactivated reason: %d", Integer.valueOf(i));
        this.oXd = false;
        this.oXe = false;
        Bundle bundle = new Bundle();
        bundle.putInt("key_on_deactivated_reason", i);
        d(this.mAppId, 41, bundle);
    }

    private synchronized void e(byte[] bArr, boolean z) {
        x.i("MicroMsg.HCEService", "alvinluo HCECOMMAND sendResponseCommandToSystem isDefaultCommand: %b, hasCommandNotResponded: %b", Boolean.valueOf(z), Boolean.valueOf(this.oXc));
        if (this.oXc) {
            this.oXc = false;
            long currentTimeMillis = System.currentTimeMillis();
            x.i("MicroMsg.HCEService", "alvinluo HCECOMMAND send response command time: %d, cost: %d", Long.valueOf(currentTimeMillis), Long.valueOf(currentTimeMillis - mStartTime));
            sendResponseApdu(bArr);
            if (z) {
                x.i("MicroMsg.HCEReportManager", "alvinluo reportHCEtimeExceeded appId: %s", this.mAppId);
                com.tencent.mm.plugin.report.service.g.pWK.k(14838, r0);
            }
        }
    }
}
