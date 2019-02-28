package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.ad.e;
import com.tencent.mm.plugin.backup.bakoldlogic.c.f;
import com.tencent.mm.plugin.backup.f.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140422", reviewer = 20, vComment = {EType.SERVICESCHECK})
public class BakchatPcUsbService extends Service implements e {
    private boolean ktR = false;

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        x.i("MicroMsg.BakchatPcUsbService", "onCreate()");
        super.onCreate();
        as.CN().a(595, (e) this);
        b.a(1, (e) this);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        int i3 = 1;
        x.i("MicroMsg.BakchatPcUsbService", "onStartCommand()");
        if (intent == null) {
            x.w("MicroMsg.BakchatPcUsbService", "onStartCommand intent is null");
        } else {
            String stringExtra = intent.getStringExtra(SlookSmartClipMetaTag.TAG_TYPE_URL);
            if (bi.oN(stringExtra)) {
                x.e("MicroMsg.BakchatPcUsbService", "onStartCommand url is null");
                stopSelf();
            } else {
                this.ktR = intent.getBooleanExtra("isFromWifi", false);
                x.i("MicroMsg.BakchatPcUsbService", "Broadcast url:%s, isFromWifi:%b", stringExtra, Boolean.valueOf(this.ktR));
                a.aqS().aqU().HZ();
                c aqU = a.aqS().aqU();
                if (this.ktR) {
                    i3 = 2;
                }
                aqU.kwn = i3;
                if (as.Ho()) {
                    as.CN().a(new f(stringExtra), 0);
                } else {
                    x.e("MicroMsg.BakchatPcUsbService", "onStartCommand not in Login state");
                    Intent className = new Intent().setClassName(this, "com.tencent.mm.ui.LauncherUI");
                    className.addFlags(335544320);
                    className.putExtra("nofification_type", "back_to_pcmgr_notification");
                    startActivity(className);
                }
            }
        }
        return 2;
    }

    public void onDestroy() {
        as.CN().b(595, (e) this);
        b.b(1, this);
        super.onDestroy();
        x.i("MicroMsg.BakchatPcUsbService", "onDestroy" + Thread.currentThread().getName());
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int r6, int r7, java.lang.String r8, com.tencent.mm.ad.k r9) {
        /*
        r5 = this;
        r4 = 1;
        r0 = r9 instanceof com.tencent.mm.plugin.backup.f.b;
        if (r0 == 0) goto L_0x0030;
    L_0x0005:
        r0 = r9.getType();
        if (r0 != r4) goto L_0x002c;
    L_0x000b:
        if (r6 != 0) goto L_0x002c;
    L_0x000d:
        if (r7 != 0) goto L_0x002c;
    L_0x000f:
        r0 = new android.content.Intent;
        r0.<init>();
        r1 = "com.tencent.mm.ui.LauncherUI";
        r0 = r0.setClassName(r5, r1);
        r1 = 335544320; // 0x14000000 float:6.4623485E-27 double:1.65780921E-315;
        r0.addFlags(r1);
        r1 = "nofification_type";
        r2 = "back_to_pcmgr_notification";
        r0.putExtra(r1, r2);
        r5.startActivity(r0);
    L_0x002c:
        r5.stopSelf();
    L_0x002f:
        return;
    L_0x0030:
        r0 = r9 instanceof com.tencent.mm.plugin.backup.bakoldlogic.c.f;
        if (r0 == 0) goto L_0x002f;
    L_0x0034:
        if (r6 != 0) goto L_0x00bc;
    L_0x0036:
        if (r7 != 0) goto L_0x00bc;
    L_0x0038:
        r9 = (com.tencent.mm.plugin.backup.bakoldlogic.c.f) r9;
        r0 = r9.arl();
        r1 = r5.ktR;
        if (r1 == 0) goto L_0x0056;
    L_0x0042:
        r1 = "MicroMsg.BakchatPcUsbService";
        r2 = "from wifi, reconnect";
        com.tencent.mm.sdk.platformtools.x.i(r1, r2);
        r1 = com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.aqS();
        r1 = r1.aqV();
        r1.aqW();
    L_0x0056:
        r1 = r5.ktR;
        if (r1 != 0) goto L_0x006b;
    L_0x005a:
        r1 = r0.kzz;
        if (r1 != r4) goto L_0x006b;
    L_0x005e:
        r0 = "MicroMsg.BakchatPcUsbService";
        r1 = "broast from usb but type is wifi, url may be fake!!!!";
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);
        r5.stopSelf();
        goto L_0x002f;
    L_0x006b:
        r1 = com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.aqS();
        r2 = r0.ID;
        r1.kon = r2;
        r1 = com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.aqS();
        r2 = r0.vQP;
        r1.koo = r2;
        r1 = com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.aqS();
        r2 = r0.vQQ;
        r1.kop = r2;
        r1 = com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.aqS();
        r1 = r1.aqT();
        r2 = r0.vQH;
        r3 = r0.vQI;
        r1.bO(r2, r3);
        r1 = com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.aqS();
        r1 = r1.aqT();
        com.tencent.mm.plugin.backup.f.b.a(r1);
        r1 = com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.aqS();
        r1 = r1.aqV();
        com.tencent.mm.plugin.backup.f.b.a(r1);
        com.tencent.mm.plugin.backup.f.b.mS(r4);
        r1 = com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.aqS();
        r1 = r1.aqV();
        r2 = r0.kzz;
        r0 = r0.vQG;
        r1.b(r2, r0);
        goto L_0x002f;
    L_0x00bc:
        r0 = com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.aqS();
        r0 = r0.aqU();
        r1 = 2;
        r0.kwo = r1;
        r0 = com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.aqS();
        r0 = r0.aqU();
        r0.HZ();
        r0 = 4;
        if (r6 != r0) goto L_0x00f5;
    L_0x00d5:
        r0 = -2011; // 0xfffffffffffff825 float:NaN double:NaN;
        if (r7 != r0) goto L_0x00f5;
    L_0x00d9:
        r0 = "MicroMsg.BakchatPcUsbService";
        r1 = "getConnect info: INVALID URL";
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);
        r0 = r5.ktR;
        if (r0 == 0) goto L_0x00e6;
    L_0x00e6:
        r0 = com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.aqS();
        r0.aqT();
        com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e.arc();
        r5.stopSelf();
        goto L_0x002f;
    L_0x00f5:
        r0 = "MicroMsg.BakchatPcUsbService";
        r1 = "getConnect info other error";
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);
        goto L_0x00e6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.BakchatPcUsbService.a(int, int, java.lang.String, com.tencent.mm.ad.k):void");
    }
}
