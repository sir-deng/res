package com.tencent.mm.plugin.report.service;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.os.Process;
import com.tencent.mars.BaseEvent;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.kernel.k;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.ArrayList;
import java.util.Iterator;

public class KVCommCrossProcessReceiver extends BroadcastReceiver {
    private static String className = "";
    private static Object lock = new Object();
    private static ag pWj;
    private static int pWk = 10000;
    private static volatile long pWl = 10000;
    private static volatile int pWm = -1;
    private static BroadCastData pWn = new BroadCastData();

    static /* synthetic */ void a(KVCommCrossProcessReceiver kVCommCrossProcessReceiver, Intent intent) {
        try {
            switch (t.a(intent, Columns.TYPE, 0)) {
                case 1:
                    Bundle bundleExtra = intent.getBundleExtra("INTENT_IDKEYGROUP");
                    if (bundleExtra != null) {
                        BroadCastData broadCastData = (BroadCastData) bundleExtra.getParcelable("BUNDLE_IDKEYGROUP");
                        ArrayList arrayList = broadCastData.pWc;
                        ArrayList arrayList2 = broadCastData.pWb;
                        x.i("MicroMsg.ReportManagerKvCheck", "KVBroadCast onReceive kvdata lenght: %d, idkey data lenght:%d,group lenght:%d", Integer.valueOf(broadCastData.pWa.size()), Integer.valueOf(arrayList2.size()), Integer.valueOf(arrayList.size()));
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            GroupIDKeyDataInfo groupIDKeyDataInfo = (GroupIDKeyDataInfo) it.next();
                            d.b(groupIDKeyDataInfo.pWd, groupIDKeyDataInfo.pWe);
                        }
                        Iterator it2 = arrayList2.iterator();
                        while (it2.hasNext()) {
                            StIDKeyDataInfo stIDKeyDataInfo = (StIDKeyDataInfo) it2.next();
                            d.b(stIDKeyDataInfo.pXa, stIDKeyDataInfo.key, stIDKeyDataInfo.value, stIDKeyDataInfo.pWe);
                        }
                        it = r7.iterator();
                        while (it.hasNext()) {
                            KVReportDataInfo kVReportDataInfo = (KVReportDataInfo) it.next();
                            d.a(kVReportDataInfo.pWw, kVReportDataInfo.value, kVReportDataInfo.pWx, kVReportDataInfo.pWe);
                        }
                        break;
                    }
                    break;
                case 2:
                    x.i("MicroMsg.ReportManagerKvCheck", "KVBroadCast onReceive TYPE_ONCRASHOREXCEPTION");
                    BaseEvent.onSingalCrash(0);
                    break;
            }
            if (k.aY(ad.getContext())) {
                new ag(Looper.myLooper()).postDelayed(new Runnable() {
                    public final void run() {
                        if (k.aY(ad.getContext())) {
                            x.e("MicroMsg.ReportManagerKvCheck", "KVCommCrossProcessReceiver shut_down_weixin need to kill process");
                            x.cfY();
                            BaseEvent.onSingalCrash(0);
                            Process.killProcess(Process.myPid());
                        }
                    }
                }, 5000);
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.ReportManagerKvCheck", e, "", new Object[0]);
        }
    }

    static {
        HandlerThread WL = e.WL("kv_report");
        WL.start();
        pWj = new ag(WL.getLooper()) {
            public final void handleMessage(Message message) {
                super.handleMessage(message);
                if (message.what == 1) {
                    KVCommCrossProcessReceiver.boN();
                }
            }
        };
    }

    public void onReceive(Context context, final Intent intent) {
        if (intent == null) {
            x.e("MicroMsg.ReportManagerKvCheck", "onReceive intent == null");
        } else {
            pWj.post(new Runnable() {
                public final void run() {
                    x.i("MicroMsg.ReportManagerKvCheck", "summeranrt true report runnable run tid:%d", Long.valueOf(Thread.currentThread().getId()));
                    KVCommCrossProcessReceiver.a(KVCommCrossProcessReceiver.this, intent);
                }
            });
        }
    }

    public static void boL() {
        if (100 >= 0) {
            pWl = 100;
        }
    }

    public static void boM() {
        pWm = 1000;
    }

    private static void boN() {
        Parcelable broadCastData;
        synchronized (lock) {
            broadCastData = new BroadCastData(pWn);
            BroadCastData broadCastData2 = pWn;
            broadCastData2.pWa.clear();
            broadCastData2.pWb.clear();
            broadCastData2.pWc.clear();
        }
        ArrayList arrayList = broadCastData.pWc;
        ArrayList arrayList2 = broadCastData.pWb;
        ArrayList arrayList3 = broadCastData.pWa;
        if (k.aY(ad.getContext()) || !ad.cgn()) {
            x.i("MicroMsg.ReportManagerKvCheck", "sendKVBroadcast shut_down_weixin, no need to notify worker");
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                GroupIDKeyDataInfo groupIDKeyDataInfo = (GroupIDKeyDataInfo) it.next();
                e.c(groupIDKeyDataInfo.pWd, groupIDKeyDataInfo.pWe);
            }
            it = arrayList2.iterator();
            while (it.hasNext()) {
                StIDKeyDataInfo stIDKeyDataInfo = (StIDKeyDataInfo) it.next();
                e.d((int) stIDKeyDataInfo.pXa, (int) stIDKeyDataInfo.key, (int) stIDKeyDataInfo.value, stIDKeyDataInfo.pWe);
            }
            it = arrayList3.iterator();
            while (it.hasNext()) {
                KVReportDataInfo kVReportDataInfo = (KVReportDataInfo) it.next();
                e.b((int) kVReportDataInfo.pWw, kVReportDataInfo.value, kVReportDataInfo.pWx, kVReportDataInfo.pWe);
            }
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver");
        intent.setComponent(new ComponentName(ad.getPackageName(), getClassName()));
        intent.putExtra(Columns.TYPE, 1);
        Bundle bundle = new Bundle();
        bundle.putParcelable("BUNDLE_IDKEYGROUP", broadCastData);
        intent.putExtra("INTENT_IDKEYGROUP", bundle);
        x.d("MicroMsg.ReportManagerKvCheck", "try sendBroadcast kvdata lenght: %d, idkey data lenght:%d,group lenght:%d", Integer.valueOf(arrayList3.size()), Integer.valueOf(arrayList2.size()), Integer.valueOf(arrayList.size()));
        try {
            ad.getContext().sendBroadcast(intent);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.ReportManagerKvCheck", e, "sendBroadcastMessageDirectly", new Object[0]);
        }
    }

    private static String getClassName() {
        if (bi.oN(className)) {
            className = ad.getPackageName() + ".plugin.report.service.KVCommCrossProcessReceiver";
        }
        return className;
    }

    public static void a(KVReportDataInfo kVReportDataInfo) {
        x.d("MicroMsg.ReportManagerKvCheck", "receive kv logid:%d, isImportant: %b,isReportNow: %b", Long.valueOf(kVReportDataInfo.pWw), Boolean.valueOf(kVReportDataInfo.pWe), Boolean.valueOf(kVReportDataInfo.pWx));
        synchronized (lock) {
            pWn.pWa.add(kVReportDataInfo);
        }
        if (pWl == 0) {
            boN();
        } else if (!pWj.hasMessages(1)) {
            pWj.sendEmptyMessageDelayed(1, pWl);
        }
    }

    public static void a(StIDKeyDataInfo stIDKeyDataInfo) {
        x.d("MicroMsg.ReportManagerKvCheck", "receive id ID:%d, key:%d,value:%d, isImportant:%b", Long.valueOf(stIDKeyDataInfo.pXa), Long.valueOf(stIDKeyDataInfo.key), Long.valueOf(stIDKeyDataInfo.value), Boolean.valueOf(stIDKeyDataInfo.pWe));
        synchronized (lock) {
            pWn.pWb.add(stIDKeyDataInfo);
        }
        if (pWl == 0 || boO()) {
            boN();
        } else if (!pWj.hasMessages(1)) {
            pWj.sendEmptyMessageDelayed(1, pWl);
        }
    }

    public static void M(ArrayList<IDKey> arrayList) {
        x.d("MicroMsg.ReportManagerKvCheck", "receive group id size:%d, isImportant:%b", Integer.valueOf(arrayList.size()), Boolean.valueOf(false));
        synchronized (lock) {
            BroadCastData broadCastData = pWn;
            broadCastData.pWc.add(new GroupIDKeyDataInfo(arrayList, false));
        }
        if (pWl == 0 || boO()) {
            boN();
        } else if (!pWj.hasMessages(1)) {
            pWj.sendEmptyMessageDelayed(1, pWl);
        }
    }

    private static boolean boO() {
        if (pWm <= 0 || pWn == null) {
            return false;
        }
        try {
            if ((pWn.pWb.size() + pWn.pWc.size()) + pWn.pWa.size() >= pWm) {
                return true;
            }
            return false;
        } catch (Exception e) {
            x.e("MicroMsg.ReportManagerKvCheck", "checkExceedCacheItemCountLimit e = %s", e);
            return false;
        }
    }

    public static void boP() {
        if (k.aY(ad.getContext()) || !ad.cgn()) {
            x.w("MicroMsg.ReportManagerKvCheck", "sendOnCrashOrExceptionBroadCast shut_down_weixin, NO MM Process , return.");
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver");
        intent.setComponent(new ComponentName(ad.getPackageName(), getClassName()));
        intent.putExtra(Columns.TYPE, 2);
        ad.getContext().sendBroadcast(intent);
    }

    public static void boQ() {
        if (pWj != null) {
            pWj.removeMessages(1);
            pWj.handleMessage(pWj.obtainMessage(1));
        }
    }
}
