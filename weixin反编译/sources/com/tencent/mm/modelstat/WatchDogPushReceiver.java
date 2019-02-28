package com.tencent.mm.modelstat;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.network.a.a.a;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.text.SimpleDateFormat;
import java.util.Date;
import junit.framework.Assert;

public class WatchDogPushReceiver extends BroadcastReceiver {
    private static String className = "";

    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            x.e("MicroMsg.WatchDogPushReceiver", "onReceive intent == null");
            return;
        }
        int intExtra = intent.getIntExtra(Columns.TYPE, 0);
        x.d("MicroMsg.WatchDogPushReceiver", "onReceive type:" + intExtra);
        if (intExtra == 1) {
            a aVar = new a();
            aVar.rtType = (long) intent.getIntExtra("rtType", 0);
            aVar.beginTime = intent.getLongExtra("beginTime", 0);
            aVar.endTime = intent.getLongExtra("endTime", 0);
            boolean booleanExtra = intent.getBooleanExtra("isSend", false);
            if (booleanExtra) {
                aVar.idh = intent.getLongExtra("dataLen", 0);
            } else {
                aVar.idi = intent.getLongExtra("dataLen", 0);
            }
            aVar.hTo = intent.getLongExtra("cost", 0);
            aVar.idj = intent.getLongExtra("doSceneCount", 0);
            x.d("MicroMsg.WatchDogPushReceiver", "onRecv: rtType:" + aVar.rtType + " isSend:" + booleanExtra + " tx:" + aVar.idh + " rx:" + aVar.idi + " begin:" + aVar.beginTime + " end:" + aVar.endTime);
            if (aVar.idj == 0 || aVar.rtType == 0 || aVar.beginTime == 0 || aVar.endTime == 0 || aVar.endTime - aVar.beginTime <= 0) {
                x.w("MicroMsg.WatchDogPushReceiver", "onRecv: count:" + aVar.idj + " rtType:" + aVar.rtType + " begin:" + aVar.beginTime + " end:" + aVar.endTime);
            }
        } else if (intExtra != 2 && intExtra != 3 && intExtra != 4) {
            if (intExtra == 5 && b.cfx()) {
                if (intent.getIntExtra("jni", 1) == 1) {
                    Assert.assertTrue("test errlog push " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), false);
                } else {
                    MMProtocalJni.setClientPackVersion(-1);
                }
            } else if (intExtra == 6) {
                x.cfX();
            }
        }
    }

    private static String getClassName() {
        if (bi.oN(className)) {
            className = ad.getPackageName() + ".modelstat.WatchDogPushReceiver";
        }
        return className;
    }

    public static void a(h hVar) {
        Intent intent = new Intent();
        intent.setAction("com.tencent.mm.WatchDogPushReceiver");
        intent.setComponent(new ComponentName(ad.getPackageName(), getClassName()));
        intent.putExtra(Columns.TYPE, 1);
        intent.putExtra("rtType", hVar.rtType);
        intent.putExtra("beginTime", hVar.beginTime);
        intent.putExtra("endTime", hVar.endTime);
        intent.putExtra("rtType", hVar.rtType);
        intent.putExtra("dataLen", hVar.hTm);
        intent.putExtra("isSend", hVar.fMC);
        intent.putExtra("cost", hVar.hTo);
        intent.putExtra("doSceneCount", hVar.hTn);
        ad.getContext().sendBroadcast(intent);
    }

    public static void To() {
        Intent intent = new Intent();
        intent.setAction("com.tencent.mm.WatchDogPushReceiver");
        intent.setComponent(new ComponentName(ad.getPackageName(), getClassName()));
        intent.putExtra(Columns.TYPE, 3);
        ad.getContext().sendBroadcast(intent);
    }

    public static void iI(int i) {
        if (b.cfx()) {
            Intent intent = new Intent();
            intent.setAction("com.tencent.mm.WatchDogPushReceiver");
            intent.setComponent(new ComponentName(ad.getPackageName(), getClassName()));
            intent.putExtra(Columns.TYPE, 5);
            intent.putExtra("jni", i);
            ad.getContext().sendBroadcast(intent);
        }
    }

    public static void Tp() {
        if (b.cfx()) {
            Intent intent = new Intent();
            intent.setAction("com.tencent.mm.WatchDogPushReceiver");
            intent.setComponent(new ComponentName(ad.getPackageName(), getClassName()));
            intent.putExtra(Columns.TYPE, 7);
            ad.getContext().sendBroadcast(intent);
        }
    }
}
