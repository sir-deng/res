package com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.c;
import com.tencent.mm.plugin.backup.bakoldlogic.c.f;
import com.tencent.mm.plugin.backup.f.b;
import com.tencent.mm.protocal.c.abk;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140422", reviewer = 20, vComment = {EType.SERVICESCHECK})
public class BakOldUSBService extends Service implements e {
    private boolean ktR = false;
    private int kvV = -1;

    public IBinder onBind(Intent intent) {
        x.i("MicroMsg.BakOldUSBService", "onBind()");
        return null;
    }

    public void onCreate() {
        x.i("MicroMsg.BakOldUSBService", "onCreate()");
        super.onCreate();
        as.CN().a(595, (e) this);
        b.a(1, (e) this);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        int i3 = 1;
        x.i("MicroMsg.BakOldUSBService", "onStartCommand() scene：%d", Integer.valueOf(this.kvV));
        if (intent == null) {
            x.w("MicroMsg.BakOldUSBService", "onStartCommand intent is null");
        } else {
            String stringExtra = intent.getStringExtra(SlookSmartClipMetaTag.TAG_TYPE_URL);
            if (bi.oN(stringExtra)) {
                x.e("MicroMsg.BakOldUSBService", "onStartCommand url is null");
                stopSelf();
            } else {
                this.ktR = intent.getBooleanExtra("isFromWifi", false);
                x.i("MicroMsg.BakOldUSBService", "Broadcast url:%s, isFromWifi:%b", stringExtra, Boolean.valueOf(this.ktR));
                a.aqS().aqU().HZ();
                c aqU = a.aqS().aqU();
                if (this.ktR) {
                    i3 = 2;
                }
                aqU.kwn = i3;
                if (as.Ho()) {
                    as.CN().a(new f(stringExtra), 0);
                } else {
                    x.e("MicroMsg.BakOldUSBService", "onStartCommand not in Login state");
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
        x.i("MicroMsg.BakOldUSBService", "onDestroy thread:" + Thread.currentThread().getName());
    }

    private boolean aqQ() {
        return this.kvV == 0 || this.kvV == 1;
    }

    public final void a(int i, int i2, String str, k kVar) {
        String str2 = "MicroMsg.BakOldUSBService";
        String str3 = "summerbak onSceneEnd [%d, %d, %s] [%s] backupScene[%d]";
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = str;
        objArr[3] = kVar == null ? "" : kVar.getClass().getSimpleName();
        objArr[4] = Integer.valueOf(this.kvV);
        x.i(str2, str3, objArr);
        if (kVar instanceof b) {
            x.d("MicroMsg.BakOldUSBService", "summerback BackupBaseScene type[%d], backupScene[%d]", Integer.valueOf(kVar.getType()), Integer.valueOf(this.kvV));
            if (kVar.getType() == 1 && i == 0 && i2 == 0) {
                boolean z;
                Intent className = new Intent().setClassName(this, "com.tencent.mm.ui.LauncherUI");
                className.addFlags(335544320);
                className.putExtra("nofification_type", "back_to_pcmgr_notification");
                str3 = "newPCBackup";
                if (aqQ()) {
                    z = false;
                } else {
                    z = true;
                }
                className.putExtra(str3, z);
                startActivity(className);
            }
            stopSelf();
        } else if (!(kVar instanceof f)) {
        } else {
            if (i == 0 && i2 == 0) {
                abk arl = ((f) kVar).arl();
                a.aqS().kon = arl.ID;
                a.aqS().koo = arl.vQP;
                a.aqS().kop = arl.vQQ;
                this.kvV = arl.sfa;
                x.d("MicroMsg.BakOldUSBService", "summerbak getconnetinfo type: %d, scene: %d isFromWifi:%b", Integer.valueOf(arl.kzz), Integer.valueOf(arl.sfa), Boolean.valueOf(this.ktR));
                if (!this.ktR && arl.kzz == 1) {
                    x.e("MicroMsg.BakOldUSBService", "broast from usb but type is wifi, url may be fake!!!!");
                    stopSelf();
                    return;
                } else if (aqQ()) {
                    a.aqS().aqT().bO(arl.vQH, arl.vQI);
                    b.a(a.aqS().aqT());
                    b.a(a.aqS().aqV());
                    b.mS(1);
                    a.aqS().aqV().b(arl.kzz, arl.vQG);
                    return;
                } else {
                    x.d("MicroMsg.BakOldUSBService", "summerbak onSceneEnd need todo for new scene:% ", Integer.valueOf(this.kvV));
                    return;
                }
            }
            a.aqS().aqU().kwo = 2;
            a.aqS().aqU().HZ();
            if (i == 4 && i2 == -2011) {
                x.i("MicroMsg.BakOldUSBService", "getConnect info: INVALID URL");
            } else {
                x.i("MicroMsg.BakOldUSBService", "getConnect info other error");
            }
            a.aqS().aqT();
            com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e.arc();
            stopSelf();
        }
    }

    public boolean stopService(Intent intent) {
        x.i("MicroMsg.BakOldUSBService", "stopService.");
        return super.stopService(intent);
    }
}
