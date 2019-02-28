package com.tencent.mm.modelmulti;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.os.Build;
import android.os.Debug.MemoryInfo;
import android.os.PowerManager;
import android.os.Process;
import android.os.StatFs;
import com.tencent.mm.a.h;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.a.lw;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.report.kvdata.BDStatusInfo;
import com.tencent.mm.plugin.report.kvdata.HeavyDetailInfo;
import com.tencent.mm.plugin.report.kvdata.SDStatusInfo;
import com.tencent.mm.plugin.report.kvdata.SubDirInfo;
import com.tencent.mm.plugin.report.kvdata.TableInfo;
import com.tencent.mm.plugin.report.kvdata.WeChatSDInfo;
import com.tencent.mm.plugin.report.kvdata.log_14375;
import com.tencent.mm.plugin.report.service.d;
import com.tencent.mm.pluginsdk.f;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.w;
import com.tencent.mm.y.ap;
import com.tencent.mm.y.as;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.wcdb.FileUtils;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class p implements ap {
    private static final long startTime = System.currentTimeMillis();
    private c hIA = new c<lw>() {
        {
            this.xmG = lw.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            as.Dt();
            ah.K(p.this.hIy);
            as.Dt().g(p.this.hIy, 3000);
            return false;
        }
    };
    private al hIB = new al(as.Dt().oFY.getLooper(), new a() {
        public final boolean uG() {
            p.e(p.this);
            return true;
        }
    }, true);
    private long hIf = 1024;
    private long hIg = 10;
    private long hIh = 1800;
    private long hIi = 3000000;
    private long hIj = 15000;
    private long hIk = 100000;
    private long hIl = 10000;
    private long hIm = 1024;
    private long hIn = 1440;
    private long hIo = 20;
    private long hIp = 1440;
    private BroadcastReceiver hIq;
    private boolean hIr = false;
    private boolean hIs = true;
    private long hIt = 0;
    private Runnable hIu;
    private c.a hIv;
    private long hIw = 0;
    private e hIx = new e() {
        public final void a(int i, int i2, String str, k kVar) {
            String str2 = "MicroMsg.SubCoreBaseMonitor";
            String str3 = "summerhv onIDKeyCallback onSceneEnd[%d][%d, %d, %s]";
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(kVar == null ? -1 : kVar.getType());
            objArr[1] = Integer.valueOf(i);
            objArr[2] = Integer.valueOf(i2);
            objArr[3] = str;
            x.i(str2, str3, objArr);
            if (i == 0 && i2 == 0) {
                d.boR();
            }
        }
    };
    private Runnable hIy = new Runnable() {
        public final void run() {
            x.i("MicroMsg.SubCoreBaseMonitor", "summerhv reportAllRunnable run");
            p.b(p.this);
            p.c(p.this);
            p.d(p.this);
            p.e(p.this);
            p.f(p.this);
            as.Dt();
            ah.K(p.this.hIz);
            as.Dt().g(p.this.hIz, 10000);
        }
    };
    private Runnable hIz = new Runnable() {
        public final void run() {
            x.i("MicroMsg.SubCoreBaseMonitor", "summerhv reportHeavyUserRunnable run");
            p.h(p.this);
        }
    };
    private j.a hkl = new j.a() {
        public final void a(String str, l lVar) {
            x.i("MicroMsg.SubCoreBaseMonitor", "summerhv abTestListener onNotifyChange stack[%s]", bi.chl());
            if (str != null && str.length() > 0 && "event_updated".equals(str)) {
                g.Dt().g(new Runnable() {
                    public final void run() {
                        p.this.bR(true);
                        p.Qh();
                    }
                }, 100);
            }
        }
    };

    static /* synthetic */ void Qh() {
        com.tencent.mm.storage.c fp = com.tencent.mm.y.c.c.IL().fp("100282");
        x.i("MicroMsg.SubCoreBaseMonitor", "summerhv reloadHardcoderCfg  abTest[%s][%b][%s]", fp, Boolean.valueOf(fp.isValid()), fp.civ());
        if (fp.isValid()) {
            boolean z;
            x.i("MicroMsg.SubCoreBaseMonitor", "summerhv reloadHardcoderCfg abTest valid!");
            Editor edit = ad.getContext().getSharedPreferences(HardCoderJNI.SETTING_SP_FILE, 0).edit();
            Map civ = fp.civ();
            boolean z2 = bi.getInt((String) civ.get("enable"), HardCoderJNI.hcEnable ? 1 : 0) > 0;
            boolean z3 = z2 && !HardCoderJNI.hcEnable;
            edit.putBoolean(HardCoderJNI.KEY_HC_ENABLE, z2);
            edit.putBoolean(HardCoderJNI.KEY_HC_BG_ENABLE, bi.getInt((String) civ.get("bgenable"), HardCoderJNI.hcBgEnable ? 1 : 0) > 0);
            edit.putBoolean(HardCoderJNI.KEY_HC_DEBUG, bi.getInt((String) civ.get("debug"), HardCoderJNI.hcDebug ? 1 : 0) > 0);
            edit.putBoolean(HardCoderJNI.KEY_HC_SWITCH_ENABLE, bi.getInt((String) civ.get("switch"), HardCoderJNI.hcSwitchEnable ? 1 : 0) > 0);
            edit.putInt(HardCoderJNI.KEY_HC_KV_PER, bi.getInt((String) civ.get("kvper"), HardCoderJNI.hcUinHash));
            edit.putInt(HardCoderJNI.KEY_HC_KV_FT, bi.getInt((String) civ.get("kvft"), HardCoderJNI.hcUinHash));
            g.Dr();
            g.Do();
            edit.putInt(HardCoderJNI.KEY_HC_UIN_HASH, h.aJ(com.tencent.mm.kernel.a.Cn(), 100));
            long j = bi.getLong((String) civ.get("scene"), -1);
            for (Entry entry : HardCoderJNI.flagKeyMap.entrySet()) {
                edit.putBoolean((String) entry.getValue(), (((Long) entry.getKey()).longValue() & j) != 0);
            }
            edit.putInt(HardCoderJNI.KEY_HC_TIMEOUT_MARGIN, bi.getInt((String) civ.get("margin"), HardCoderJNI.hcTimeoutMargin));
            edit.putInt(HardCoderJNI.KEY_HC_RETRY_INTERVAL, bi.getInt((String) civ.get("retryitv"), HardCoderJNI.hcRetryInterval));
            String aD = bi.aD((String) civ.get("model"), "");
            CharSequence charSequence = Build.MODEL;
            if (aD.length() > 0) {
                z3 = aD.contains(charSequence);
                HardCoderJNI.reportIDKey(true, z3 ? 10 : 11, 1, true);
                edit.putBoolean(HardCoderJNI.KEY_HC_ENABLE, z3);
                z = z3 && !HardCoderJNI.hcEnable;
                x.i("MicroMsg.SubCoreBaseMonitor", "summerhv reloadHardcoderCfg check model[%s][%s] enable[%b] init[%b]", charSequence, aD, Boolean.valueOf(z3), Boolean.valueOf(z));
            } else {
                HardCoderJNI.reportIDKey(true, 12, 1, true);
                z = z3;
            }
            edit.apply();
            HardCoderJNI.reloadSPConfig(HardCoderJNI.RELOAD_SCENE_ABTEST);
            x.i("MicroMsg.SubCoreBaseMonitor", "summerhv reloadHardcoderCfg enable[%b] init[%b] bgEnable[%b] debug[%b] uinHash[%d] switch[%b] kv[%b, %b] sceneFlag[%d] margin[%d] retryInterval[%d] model[%s]", Boolean.valueOf(HardCoderJNI.hcEnable), Boolean.valueOf(z), Boolean.valueOf(HardCoderJNI.hcBgEnable), Boolean.valueOf(HardCoderJNI.hcDebug), Integer.valueOf(r5), Boolean.valueOf(HardCoderJNI.hcSwitchEnable), Boolean.valueOf(HardCoderJNI.hcKVPerReport), Boolean.valueOf(HardCoderJNI.hcKVFtReport), Long.valueOf(j), Integer.valueOf(r1), Integer.valueOf(r8), aD);
            if (z) {
                HardCoderJNI.initHardCoder();
                HardCoderJNI.initReporter(new f());
            }
        }
    }

    static /* synthetic */ c.a a(p pVar, c cVar) {
        x.i("MicroMsg.SubCoreBaseMonitor", "summerhv startScan");
        as.Hm();
        if (com.tencent.mm.y.c.isSDCardAvailable()) {
            final File file = new File(com.tencent.mm.compatible.util.e.bnF);
            String Fs;
            if (file.exists() && file.isDirectory()) {
                x.i("MicroMsg.SubCoreBaseMonitor", "summerhv startScan root[%s] exist[%b], diretory[%b]", Fs, Boolean.valueOf(file.exists()), Boolean.valueOf(file.isDirectory()));
                final Map hashMap = new HashMap(26);
                as.Hm();
                Fs = com.tencent.mm.y.c.Fs();
                as.Hm();
                hashMap.put(Fs.substring(0, com.tencent.mm.y.c.Fs().length() - 1), Integer.valueOf(1));
                as.Hm();
                Fs = com.tencent.mm.y.c.Ft();
                as.Hm();
                hashMap.put(Fs.substring(0, com.tencent.mm.y.c.Ft().length() - 1), Integer.valueOf(2));
                as.Hm();
                Fs = com.tencent.mm.y.c.Fp();
                as.Hm();
                hashMap.put(Fs.substring(0, com.tencent.mm.y.c.Fp().length() - 1), Integer.valueOf(3));
                as.Hm();
                Fs = com.tencent.mm.y.c.Fq();
                as.Hm();
                hashMap.put(Fs.substring(0, com.tencent.mm.y.c.Fq().length() - 1), Integer.valueOf(4));
                as.Hm();
                hashMap.put(com.tencent.mm.y.c.FF(), Integer.valueOf(5));
                hashMap.put(com.tencent.mm.plugin.f.a.aoL().substring(0, com.tencent.mm.plugin.f.a.aoL().length() - 1), Integer.valueOf(6));
                as.Hm();
                Fs = com.tencent.mm.y.c.Fw();
                as.Hm();
                hashMap.put(Fs.substring(0, com.tencent.mm.y.c.Fw().length() - 1), Integer.valueOf(7));
                as.Hm();
                Fs = com.tencent.mm.y.c.getAccVideoPath();
                as.Hm();
                hashMap.put(Fs.substring(0, com.tencent.mm.y.c.getAccVideoPath().length() - 1), Integer.valueOf(8));
                as.Hm();
                Fs = com.tencent.mm.y.c.Fz();
                as.Hm();
                hashMap.put(Fs.substring(0, com.tencent.mm.y.c.Fz().length() - 1), Integer.valueOf(9));
                as.Hm();
                Fs = com.tencent.mm.y.c.Fx();
                as.Hm();
                hashMap.put(Fs.substring(0, com.tencent.mm.y.c.Fx().length() - 1), Integer.valueOf(10));
                as.Hm();
                Fs = com.tencent.mm.y.c.FA();
                as.Hm();
                hashMap.put(Fs.substring(0, com.tencent.mm.y.c.FA().length() - 1), Integer.valueOf(11));
                as.Hm();
                Fs = com.tencent.mm.y.c.FB();
                as.Hm();
                hashMap.put(Fs.substring(0, com.tencent.mm.y.c.FB().length() - 1), Integer.valueOf(12));
                as.Hm();
                Fs = com.tencent.mm.y.c.FC();
                as.Hm();
                hashMap.put(Fs.substring(0, com.tencent.mm.y.c.FC().length() - 1), Integer.valueOf(13));
                as.Hm();
                Fs = com.tencent.mm.y.c.FG();
                as.Hm();
                hashMap.put(Fs.substring(0, com.tencent.mm.y.c.FG().length() - 1), Integer.valueOf(14));
                as.Hm();
                Fs = com.tencent.mm.y.c.Fu();
                as.Hm();
                hashMap.put(Fs.substring(0, com.tencent.mm.y.c.Fu().length() - 1), Integer.valueOf(15));
                hashMap.put(com.tencent.mm.bd.b.SJ().substring(0, com.tencent.mm.bd.b.SJ().length() - 1), Integer.valueOf(16));
                as.Hm();
                Fs = com.tencent.mm.y.c.Fv();
                as.Hm();
                hashMap.put(Fs.substring(0, com.tencent.mm.y.c.Fv().length() - 1), Integer.valueOf(17));
                as.Hm();
                Fs = com.tencent.mm.y.c.FE();
                as.Hm();
                hashMap.put(Fs.substring(0, com.tencent.mm.y.c.FE().length() - 1), Integer.valueOf(18));
                as.Hm();
                Fs = com.tencent.mm.y.c.FD();
                as.Hm();
                hashMap.put(Fs.substring(0, com.tencent.mm.y.c.FD().length() - 1), Integer.valueOf(19));
                as.Hm();
                Fs = com.tencent.mm.y.c.getAccSnsPath();
                as.Hm();
                hashMap.put(Fs.substring(0, com.tencent.mm.y.c.getAccSnsPath().length() - 1), Integer.valueOf(20));
                as.Hm();
                Fs = com.tencent.mm.y.c.FH();
                as.Hm();
                hashMap.put(Fs.substring(0, com.tencent.mm.y.c.FH().length() - 1), Integer.valueOf(21));
                as.Hm();
                Fs = com.tencent.mm.y.c.Fr();
                as.Hm();
                hashMap.put(Fs.substring(0, com.tencent.mm.y.c.Fr().length() - 1), Integer.valueOf(22));
                hashMap.put(com.tencent.mm.compatible.util.e.gJl, Integer.valueOf(23));
                hashMap.put(com.tencent.mm.compatible.util.e.gJd.substring(0, com.tencent.mm.compatible.util.e.gJd.length() - 1), Integer.valueOf(24));
                hashMap.put(com.tencent.mm.compatible.util.e.gJh.substring(0, com.tencent.mm.compatible.util.e.gJh.length() - 1), Integer.valueOf(25));
                hashMap.put(com.tencent.mm.compatible.util.e.gJf.substring(0, com.tencent.mm.compatible.util.e.gJf.length() - 1), Integer.valueOf(26));
                final c.a aVar = new c.a(file.getAbsolutePath());
                final c cVar2 = cVar;
                com.tencent.mm.sdk.f.e.post(new Runnable() {
                    final Map<String, Integer> hIP = hashMap;

                    public final void run() {
                        x.i("MicroMsg.SubCoreBaseMonitor", "summerhv true scan start fileScanResult[%s], subDirMap[%d]", aVar, Integer.valueOf(hashMap.size()));
                        long currentTimeMillis = System.currentTimeMillis();
                        p.this.a(file, aVar, null, null, this.hIP, true, 0);
                        if (hashMap.size() > 0) {
                            Iterator it = hashMap.entrySet().iterator();
                            while (it != null && it.hasNext()) {
                                Entry entry = (Entry) it.next();
                                aVar.hGH.add(new c.b((String) entry.getKey(), ((Integer) entry.getValue()).intValue()));
                            }
                        }
                        aVar.hGG = System.currentTimeMillis() - currentTimeMillis;
                        x.i("MicroMsg.SubCoreBaseMonitor", "summerhv true scan end takes[%d], emptySubDir[%d], fileScanResult[%s], tid[%d]", Long.valueOf(aVar.hGG), Integer.valueOf(hashMap.values().size()), aVar, Long.valueOf(Thread.currentThread().getId()));
                        cVar2.a(0, aVar);
                    }
                }, "summerhv_scanFile");
                return aVar;
            }
            x.i("MicroMsg.SubCoreBaseMonitor", "summerhv startScan failed as path not exists[%s]", Fs);
            cVar.a(-1, null);
            return null;
        }
        x.i("MicroMsg.SubCoreBaseMonitor", "summerhv startScan failed as sdcard not available");
        cVar.a(-1, null);
        return null;
    }

    static /* synthetic */ void b(p pVar) {
        as.Hm();
        long longValue = ((Long) com.tencent.mm.y.c.Db().get(w.a.USERINFO_REPORT_SD_STATUS_TIME_LONG, Long.valueOf(0))).longValue();
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - longValue > 259200000 || longValue > currentTimeMillis) {
            as.Hm();
            com.tencent.mm.y.c.Db().a(w.a.USERINFO_REPORT_SD_STATUS_TIME_LONG, Long.valueOf(currentTimeMillis));
            com.tencent.mm.sdk.f.e.post(new Runnable() {
                public final void run() {
                    try {
                        int round;
                        long j;
                        long j2;
                        long j3;
                        long j4;
                        long j5;
                        int i;
                        int i2;
                        File file = new File(w.hbv + "SdcardInfo.cfg");
                        com.tencent.mm.plugin.report.service.g.pWK.a(340, file.exists() ? 10 : 11, 1, true);
                        boolean cgR = ax.cgR();
                        String path = com.tencent.mm.compatible.util.h.getDataDirectory().getPath();
                        String path2 = com.tencent.mm.compatible.util.h.getExternalStorageDirectory().getPath();
                        StatFs statFs = new StatFs(path);
                        long blockSize = (long) statFs.getBlockSize();
                        long blockCount = (long) statFs.getBlockCount();
                        long availableBlocks = (long) statFs.getAvailableBlocks();
                        long j6 = blockSize * blockCount;
                        long j7 = blockSize * availableBlocks;
                        if (blockCount > 0) {
                            round = Math.round((((float) availableBlocks) * 100.0f) / ((float) blockCount));
                        } else {
                            round = -1;
                        }
                        statFs = new StatFs(path2);
                        long blockSize2 = (long) statFs.getBlockSize();
                        long blockCount2 = (long) statFs.getBlockCount();
                        long availableBlocks2 = (long) statFs.getAvailableBlocks();
                        long j8 = blockSize2 * blockCount2;
                        long j9 = blockSize2 * availableBlocks2;
                        int i3 = -1;
                        if (blockCount2 > 0) {
                            i3 = Math.round((((float) availableBlocks2) * 100.0f) / ((float) blockCount2));
                        }
                        boolean equals = com.tencent.mm.compatible.util.e.bnD.equals(path2);
                        if (equals) {
                            j = j9;
                            j2 = j8;
                            j3 = availableBlocks2;
                            j4 = blockCount2;
                            j5 = blockSize2;
                            i = i3;
                        } else {
                            statFs = new StatFs(com.tencent.mm.compatible.util.e.bnD);
                            long blockSize3 = (long) statFs.getBlockSize();
                            long blockCount3 = (long) statFs.getBlockCount();
                            long availableBlocks3 = (long) statFs.getAvailableBlocks();
                            long j10 = blockSize3 * blockCount3;
                            long j11 = blockSize3 * availableBlocks3;
                            if (blockCount3 > 0) {
                                j2 = j10;
                                j3 = availableBlocks3;
                                j4 = blockCount3;
                                j5 = blockSize3;
                                i = Math.round((((float) availableBlocks3) * 100.0f) / ((float) blockCount3));
                                j = j11;
                            } else {
                                j = j11;
                                j2 = j10;
                                j3 = availableBlocks3;
                                j4 = blockCount3;
                                j5 = blockSize3;
                                i = i3;
                            }
                        }
                        String VT = ax.VT(com.tencent.mm.compatible.util.e.bnD);
                        String VT2 = ax.VT(path);
                        String str = "MicroMsg.SubCoreBaseMonitor";
                        String str2 = "summerStorage [%s, %s, %s] [%s] [%b] [%d,%d,%d,%d,%d,%d] [%d,%d,%d,%d,%d,%d] [%b] [%d,%d,%d,%d,%d,%d], [%d][%s]";
                        Object[] objArr = new Object[26];
                        objArr[0] = path;
                        objArr[1] = path2;
                        objArr[2] = com.tencent.mm.compatible.util.e.bnD;
                        objArr[3] = VT;
                        objArr[4] = Boolean.valueOf(cgR);
                        objArr[5] = Long.valueOf(blockSize);
                        objArr[6] = Long.valueOf(blockCount);
                        objArr[7] = Long.valueOf(availableBlocks);
                        objArr[8] = Long.valueOf(j6);
                        objArr[9] = Long.valueOf(j7);
                        objArr[10] = Integer.valueOf(round);
                        objArr[11] = Long.valueOf(blockSize2);
                        objArr[12] = Long.valueOf(blockCount2);
                        objArr[13] = Long.valueOf(availableBlocks2);
                        objArr[14] = Long.valueOf(j8);
                        objArr[15] = Long.valueOf(j9);
                        objArr[16] = Integer.valueOf(i3);
                        objArr[17] = Boolean.valueOf(equals);
                        objArr[18] = Long.valueOf(j5);
                        objArr[19] = Long.valueOf(j4);
                        objArr[20] = Long.valueOf(j3);
                        objArr[21] = Long.valueOf(j2);
                        objArr[22] = Long.valueOf(j);
                        objArr[23] = Integer.valueOf(i);
                        if (file.exists()) {
                            i2 = 1;
                        } else {
                            i2 = 0;
                        }
                        objArr[24] = Integer.valueOf(i2);
                        objArr[25] = VT2;
                        x.i(str, str2, objArr);
                        com.tencent.mm.plugin.report.service.g.pWK.a(340, 0, 1, true);
                        com.tencent.mm.plugin.report.service.g.pWK.a(340, cgR ? 1 : 2, 1, true);
                        com.tencent.mm.plugin.report.service.g.pWK.a(340, equals ? 3 : 4, 1, true);
                        com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.pWK;
                        objArr = new Object[2];
                        objArr[0] = Integer.valueOf(5000);
                        String str3 = "%s;%s;%s;%s;%d;%d;%d;%d;%d;%d;%d;%d;%d;%d;%d;%d;%d;%d;%d;%d;%d;%d;%d;%d;%d;%s";
                        Object[] objArr2 = new Object[26];
                        objArr2[0] = path;
                        objArr2[1] = path2;
                        objArr2[2] = com.tencent.mm.compatible.util.e.bnD;
                        objArr2[3] = VT;
                        objArr2[4] = Integer.valueOf(cgR ? 1 : 0);
                        objArr2[5] = Long.valueOf(blockSize);
                        objArr2[6] = Long.valueOf(blockCount);
                        objArr2[7] = Long.valueOf(availableBlocks);
                        objArr2[8] = Long.valueOf(j6);
                        objArr2[9] = Long.valueOf(j7);
                        objArr2[10] = Integer.valueOf(round);
                        objArr2[11] = Long.valueOf(blockSize2);
                        objArr2[12] = Long.valueOf(blockCount2);
                        objArr2[13] = Long.valueOf(availableBlocks2);
                        objArr2[14] = Long.valueOf(j8);
                        objArr2[15] = Long.valueOf(j9);
                        objArr2[16] = Integer.valueOf(i3);
                        objArr2[17] = Integer.valueOf(equals ? 1 : 0);
                        objArr2[18] = Long.valueOf(j5);
                        objArr2[19] = Long.valueOf(j4);
                        objArr2[20] = Long.valueOf(j3);
                        objArr2[21] = Long.valueOf(j2);
                        objArr2[22] = Long.valueOf(j);
                        objArr2[23] = Integer.valueOf(i);
                        if (file.exists()) {
                            i2 = 1;
                        } else {
                            i2 = 0;
                        }
                        objArr2[24] = Integer.valueOf(i2);
                        objArr2[25] = VT2;
                        objArr[1] = String.format(str3, objArr2);
                        gVar.h(11098, objArr);
                        com.tencent.mm.plugin.report.service.g.pWK.h(11098, Integer.valueOf(5001), path + ";" + VT2);
                        com.tencent.mm.plugin.report.service.g.pWK.h(11098, Integer.valueOf(5002), com.tencent.mm.compatible.util.e.bnD + ";" + VT);
                        gVar = com.tencent.mm.plugin.report.service.g.pWK;
                        objArr = new Object[2];
                        objArr[0] = Integer.valueOf(5003);
                        objArr[1] = Integer.valueOf(file.exists() ? 1 : 0);
                        gVar.h(11098, objArr);
                        gVar = com.tencent.mm.plugin.report.service.g.pWK;
                        objArr = new Object[2];
                        objArr[0] = Integer.valueOf(5004);
                        objArr[1] = Integer.valueOf(cgR ? 1 : 0);
                        gVar.h(11098, objArr);
                        com.tencent.mm.plugin.report.service.g.pWK.a(340, 7, 1, true);
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.SubCoreBaseMonitor", e, "reportSDStatus err!", new Object[0]);
                        com.tencent.mm.plugin.report.service.g.pWK.a(340, 8, 1, true);
                    }
                }
            }, "reportSDStatus");
        }
    }

    static /* synthetic */ void b(p pVar, c.a aVar) {
        c.b bVar;
        String str;
        long j;
        long j2;
        long j3;
        long j4;
        long j5;
        int i;
        com.tencent.mm.bp.a log_14375 = new log_14375();
        log_14375.type_ = 2;
        SDStatusInfo sDStatusInfo = new SDStatusInfo();
        log_14375.sdStatusInfo_ = sDStatusInfo;
        c.c cVar = new c.c("total/temp/acc/");
        Iterator it = aVar.hGI.iterator();
        while (it.hasNext()) {
            c.c cVar2 = (c.c) it.next();
            cVar.hGE += cVar2.hGE;
            cVar.hGF += cVar2.hGF;
            cVar.fxb += cVar2.fxb;
            cVar.hGK += cVar2.hGK;
        }
        x.i("MicroMsg.SubCoreBaseMonitor", "summerhv doReportSDInfo total tempAccDirResult[%d][%s]", Integer.valueOf(aVar.hGI.size()), cVar);
        Collections.sort(aVar.hGH, new Comparator<c.b>() {
            public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                long j = (long) (((c.b) obj).tag - ((c.b) obj2).tag);
                if (j > 0) {
                    return 1;
                }
                return j == 0 ? 0 : -1;
            }
        });
        it = aVar.hGH.iterator();
        while (it.hasNext()) {
            x.d("MicroMsg.SubCoreBaseMonitor", "summerhv doReportSDInfo subDirResult[%s]", (c.b) it.next());
            if (!((c.b) it.next()).hGJ) {
                com.tencent.mm.plugin.report.service.g.pWK.h(13778, Integer.valueOf(6), Integer.valueOf(bVar.tag), Long.valueOf(bVar.fxb));
            }
        }
        String str2 = aVar.fxb + ":" + aVar.hGE + ":" + aVar.hGF + ":" + aVar.fileLenInvalidCount + ":" + aVar.hGH.size() + ":" + aVar.hGG + ":" + aVar.axZ + "|" + aVar.hGI.size() + ":" + cVar.fxb + ":" + cVar.hGE + ":" + cVar.hGF + ":" + cVar.hGK;
        WeChatSDInfo weChatSDInfo = new WeChatSDInfo();
        sDStatusInfo.weChatSDInfo_ = weChatSDInfo;
        weChatSDInfo.totalSize_ = aVar.fxb;
        weChatSDInfo.fileCount_ = aVar.hGF;
        weChatSDInfo.fileLenInvalidCount_ = aVar.fileLenInvalidCount;
        weChatSDInfo.subDirResultsSize_ = aVar.hGH.size();
        weChatSDInfo.totalTime_ = aVar.hGG;
        weChatSDInfo.depth_ = aVar.axZ;
        weChatSDInfo.tempAccTotalSize_ = cVar.fxb;
        weChatSDInfo.tempAccDirResultsSize_ = aVar.hGI.size();
        weChatSDInfo.tempAccDirCount_ = cVar.hGE;
        weChatSDInfo.tempAccFileCount_ = cVar.hGF;
        weChatSDInfo.tempAccFileLenInvalidCount_ = cVar.hGK;
        com.tencent.mm.plugin.report.service.g.pWK.h(13778, Integer.valueOf(6), Integer.valueOf(1000), Long.valueOf(weChatSDInfo.totalSize_));
        LinkedList linkedList = new LinkedList();
        weChatSDInfo.subDirList_ = linkedList;
        it = aVar.hGH.iterator();
        String str3 = str2;
        while (it.hasNext()) {
            bVar = (c.b) it.next();
            str = str3 + "|" + bVar.tag + ":" + bVar.fxb + ":" + bVar.hGE + ":" + bVar.hGF + ":" + bVar.fileLenInvalidCount;
            SubDirInfo subDirInfo = new SubDirInfo();
            linkedList.add(subDirInfo);
            subDirInfo.tag_ = bVar.tag;
            subDirInfo.totalSize_ = bVar.fxb;
            subDirInfo.dirCount_ = bVar.hGE;
            subDirInfo.fileCount_ = bVar.hGF;
            subDirInfo.fileLenInvalidCount = bVar.fileLenInvalidCount;
            str3 = str;
        }
        x.i("MicroMsg.SubCoreBaseMonitor", "summerhv doReportSDInfo wechatResult[%d][%s]", Integer.valueOf(str3.length()), str3);
        String path = com.tencent.mm.compatible.util.h.getExternalStorageDirectory().getPath();
        boolean cgR = ax.cgR();
        String VT = ax.VT(com.tencent.mm.compatible.util.e.bnD);
        StatFs statFs = new StatFs(path);
        long blockSize = (long) statFs.getBlockSize();
        long blockCount = (long) statFs.getBlockCount();
        long availableBlocks = (long) statFs.getAvailableBlocks();
        long j6 = blockSize * blockCount;
        long j7 = blockSize * availableBlocks;
        int round = blockCount > 0 ? Math.round((((float) availableBlocks) * 100.0f) / ((float) blockCount)) : -1;
        boolean equals = com.tencent.mm.compatible.util.e.bnD.equals(path);
        if (equals) {
            j = j7;
            j2 = j6;
            j3 = availableBlocks;
            j4 = blockCount;
            j5 = blockSize;
            i = round;
        } else {
            statFs = new StatFs(com.tencent.mm.compatible.util.e.bnD);
            j2 = (long) statFs.getBlockSize();
            j = (long) statFs.getBlockCount();
            long availableBlocks2 = (long) statFs.getAvailableBlocks();
            long j8 = j2 * j;
            long j9 = j2 * availableBlocks2;
            if (j > 0) {
                j4 = j;
                j5 = j2;
                i = Math.round((((float) availableBlocks2) * 100.0f) / ((float) j));
                j = j9;
                j2 = j8;
                j3 = availableBlocks2;
            } else {
                j3 = availableBlocks2;
                j4 = j;
                j5 = j2;
                i = round;
                j = j9;
                j2 = j8;
            }
        }
        int round2 = Math.round((((float) aVar.fxb) * 100.0f) / ((float) j2));
        sDStatusInfo.weChatPer_ = round2;
        pVar.e(1, aVar.fxb, (pVar.hIf * 1024) * 1024);
        sDStatusInfo.sizeHeavy_ = aVar.fxb > (pVar.hIf * 1024) * 1024 ? 1 : 0;
        pVar.e(2, (long) round2, pVar.hIg);
        sDStatusInfo.ratioHeavy_ = ((long) round2) > pVar.hIg ? 1 : 0;
        str = round2 + ";" + (equals ? 1 : 0) + ";" + (cgR ? 1 : 0) + ";" + j5 + ":" + j4 + ":" + j3 + ":" + j2 + ":" + j + ":" + i + "|" + blockSize + ":" + blockCount + ":" + availableBlocks + ":" + j6 + ":" + j7 + ":" + round + ";" + path + ";" + com.tencent.mm.compatible.util.e.bnD + ";" + VT;
        sDStatusInfo.sBlockSize_ = j5;
        sDStatusInfo.sBlockCount_ = j4;
        sDStatusInfo.sAvailableBlockCount_ = j3;
        sDStatusInfo.sTotalSize_ = j2;
        sDStatusInfo.sAvailableSize_ = j;
        sDStatusInfo.sAvailablePer_ = i;
        sDStatusInfo.eBlockSize_ = blockSize;
        sDStatusInfo.eBlockCount_ = blockCount;
        sDStatusInfo.eAvailableBlockCount_ = availableBlocks;
        sDStatusInfo.eTotalSize_ = j6;
        sDStatusInfo.eAvailableSize_ = j7;
        sDStatusInfo.eAvailablePer_ = round;
        sDStatusInfo.ePath_ = path;
        sDStatusInfo.root_ = com.tencent.mm.compatible.util.e.bnD;
        sDStatusInfo.fSystem_ = VT;
        com.tencent.mm.plugin.report.service.g.pWK.h(13778, Integer.valueOf(2), Integer.valueOf(3), path);
        com.tencent.mm.plugin.report.service.g.pWK.h(13778, Integer.valueOf(2), Integer.valueOf(4), com.tencent.mm.compatible.util.e.bnD);
        com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.pWK;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(2);
        objArr[1] = Integer.valueOf(5);
        objArr[2] = Integer.valueOf(equals ? 1 : 0);
        gVar.h(13778, objArr);
        gVar = com.tencent.mm.plugin.report.service.g.pWK;
        objArr = new Object[3];
        objArr[0] = Integer.valueOf(2);
        objArr[1] = Integer.valueOf(6);
        objArr[2] = Integer.valueOf(cgR ? 1 : 0);
        gVar.h(13778, objArr);
        com.tencent.mm.plugin.report.service.g.pWK.h(13778, Integer.valueOf(2), Integer.valueOf(7), VT);
        com.tencent.mm.plugin.report.service.g.pWK.h(13778, Integer.valueOf(2), Integer.valueOf(8), Long.valueOf(sDStatusInfo.sTotalSize_));
        com.tencent.mm.plugin.report.service.g.pWK.h(13778, Integer.valueOf(2), Integer.valueOf(9), Long.valueOf(sDStatusInfo.sAvailableSize_));
        com.tencent.mm.plugin.report.service.g.pWK.h(13778, Integer.valueOf(2), Integer.valueOf(10), Integer.valueOf(sDStatusInfo.sAvailablePer_));
        com.tencent.mm.plugin.report.service.g.pWK.h(13778, Integer.valueOf(6), Integer.valueOf(1001), Integer.valueOf(round2));
        x.i("MicroMsg.SubCoreBaseMonitor", "summerhv doReportSDInfo phoneResult[%d][%s]", Integer.valueOf(str.length()), str);
        str2 = str3 + ";" + str;
        x.i("MicroMsg.SubCoreBaseMonitor", "summerhv doReportSDInfo totalResult[%d][%s]", Integer.valueOf(str2.length()), str2);
        com.tencent.mm.plugin.report.service.g.pWK.a(418, 5, 1, true);
        com.tencent.mm.plugin.report.service.g.pWK.h(13778, Integer.valueOf(2), Integer.valueOf(1), str2);
        com.tencent.mm.plugin.report.service.g.pWK.c(14375, log_14375);
    }

    static /* synthetic */ void c(p pVar) {
        as.Hm();
        long longValue = ((Long) com.tencent.mm.y.c.Db().get(w.a.USERINFO_WECHAT_DB_REPORT_LAST_TIME_LONG, Long.valueOf(0))).longValue();
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - longValue > pVar.hIp * 60000 || longValue > currentTimeMillis) {
            as.Hm();
            com.tencent.mm.y.c.Db().a(w.a.USERINFO_WECHAT_DB_REPORT_LAST_TIME_LONG, Long.valueOf(currentTimeMillis));
            currentTimeMillis = (pVar.hIh * 1024) * 1024;
            final long j = pVar.hIi;
            final long j2 = (pVar.hIm * 1024) * 1024;
            final long j3 = pVar.hIj;
            final long j4 = pVar.hIk;
            final long j5 = pVar.hIl;
            com.tencent.mm.sdk.f.e.post(new Runnable() {
                public final void run() {
                    try {
                        com.tencent.mm.bp.a log_14375 = new log_14375();
                        log_14375.type_ = 1;
                        BDStatusInfo bDStatusInfo = new BDStatusInfo();
                        log_14375.dbStatusInfo_ = bDStatusInfo;
                        as.Hm();
                        long length = new File(com.tencent.mm.y.c.CZ()).length();
                        bDStatusInfo.mmDBSize_ = length;
                        StringBuilder stringBuilder = new StringBuilder();
                        as.Hm();
                        long length2 = new File(stringBuilder.append(com.tencent.mm.y.c.FI()).append("SnsMicroMsg.db").toString()).length();
                        bDStatusInfo.snsDBSize_ = length2;
                        stringBuilder = new StringBuilder();
                        as.Hm();
                        long length3 = new File(stringBuilder.append(com.tencent.mm.y.c.FI()).append("enFavorite.db").toString()).length();
                        bDStatusInfo.favDBSize_ = length3;
                        p.this.e(4, length, currentTimeMillis);
                        p.this.e(FileUtils.S_IWUSR, length3, j2);
                        String str = length + ";" + length2 + ";" + length3;
                        as.Hm();
                        com.tencent.mm.bx.h Fd = com.tencent.mm.y.c.Fd();
                        if (Fd == null || !Fd.isOpen()) {
                            x.i("MicroMsg.SubCoreBaseMonitor", "summerreportDBInfo db is not open!");
                        } else {
                            long currentTimeMillis = System.currentTimeMillis();
                            ArrayList arrayList = new ArrayList();
                            Cursor a = Fd.a("SELECT name FROM sqlite_master WHERE type='table'", null, 2);
                            if (a != null) {
                                int columnIndex = a.getColumnIndex("name");
                                while (a.moveToNext()) {
                                    arrayList.add(a.getString(columnIndex));
                                }
                                a.close();
                            }
                            String str2 = str + ";" + arrayList.size();
                            bDStatusInfo.mmDBTableCount_ = arrayList.size();
                            LinkedList linkedList = new LinkedList();
                            bDStatusInfo.tableList_ = linkedList;
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                str = (String) it.next();
                                Cursor a2 = Fd.a("select count(*) from " + str, null, 2);
                                length = 0;
                                if (a2 != null) {
                                    if (a2.moveToFirst()) {
                                        length = a2.getLong(0);
                                    }
                                    a2.close();
                                }
                                String str3 = str2 + ";" + str + ":" + length;
                                TableInfo tableInfo = new TableInfo();
                                tableInfo.name_ = str;
                                tableInfo.count_ = length;
                                linkedList.add(tableInfo);
                                if ("message".equals(str)) {
                                    p.this.e(8, length, j);
                                    str2 = str3;
                                } else if ("rconversation".equals(str)) {
                                    p.this.e(16, length, j3);
                                    str2 = str3;
                                } else if ("rcontact".equals(str)) {
                                    p.this.e(32, length, j4);
                                    str2 = str3;
                                } else {
                                    if ("chatroom".equals(str)) {
                                        p.this.e(64, length, j5);
                                    }
                                    str2 = str3;
                                }
                            }
                            x.i("MicroMsg.SubCoreBaseMonitor", "summerreportDBInfo dump all table count %d last %d", Integer.valueOf(arrayList.size()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                            str = str2;
                        }
                        com.tencent.mm.plugin.report.service.g.pWK.h(13778, Integer.valueOf(1), Integer.valueOf(1), str);
                        com.tencent.mm.plugin.report.service.g.pWK.c(14375, log_14375);
                        com.tencent.mm.plugin.report.service.g.pWK.a(418, 3, 1, true);
                        x.i("MicroMsg.SubCoreBaseMonitor", "summerreportDBInfo result[%s]", str);
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.SubCoreBaseMonitor", e, "reportDBInfo err!", new Object[0]);
                        com.tencent.mm.plugin.report.service.g.pWK.a(418, 4, 1, true);
                    }
                }
            }, "reportDBInfo");
        }
    }

    static /* synthetic */ void d(p pVar) {
        as.Hm();
        long longValue = ((Long) com.tencent.mm.y.c.Db().get(w.a.USERINFO_INSTALL_LAST_REPORT_TIME_LONG, Long.valueOf(0))).longValue();
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - longValue > 259200000 || longValue > currentTimeMillis) {
            as.Hm();
            com.tencent.mm.y.c.Db().a(w.a.USERINFO_INSTALL_LAST_REPORT_TIME_LONG, Long.valueOf(currentTimeMillis));
            com.tencent.mm.sdk.f.e.post(new Runnable() {
                public final void run() {
                    try {
                        as.Hm();
                        int intValue = ((Integer) com.tencent.mm.y.c.Db().get(w.a.USERINFO_INSTALL_FIRST_CLIENT_VERSION_INT, Integer.valueOf(0))).intValue();
                        as.Hm();
                        long longValue = ((Long) com.tencent.mm.y.c.Db().get(w.a.USERINFO_INSTALL_FIRST_TIME_LONG, Long.valueOf(0))).longValue();
                        long q = p.q(p.this);
                        Object obj = (intValue <= 0 || com.tencent.mm.protocal.d.vHl == intValue) ? 1 : null;
                        String str = intValue + ";" + com.tencent.mm.protocal.d.vHl + ";" + (obj != null ? 1 : 0) + ";" + new SimpleDateFormat("yyyyMMdd").format(new Date(longValue)) + ";" + q;
                        com.tencent.mm.plugin.report.service.g.pWK.a(418, 1, 1, true);
                        com.tencent.mm.plugin.report.service.g.pWK.h(13778, Integer.valueOf(3), Integer.valueOf(1), str);
                        x.i("MicroMsg.SubCoreBaseMonitor", "summerreportVersion install result[%s]", str);
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.SubCoreBaseMonitor", e, "reportVersion err!", new Object[0]);
                        com.tencent.mm.plugin.report.service.g.pWK.a(418, 2, 1, true);
                    }
                }
            }, "reportVersion");
        }
    }

    static /* synthetic */ void e(p pVar) {
        as.Hm();
        int intValue = ((Integer) com.tencent.mm.y.c.Db().get(w.a.USERINFO_MM_LVFETIME_REPORT_PID_INT, Integer.valueOf(0))).intValue();
        as.Hm();
        long longValue = ((Long) com.tencent.mm.y.c.Db().get(w.a.USERINFO_MM_LVFETIME_REPORT_LIFETIME_LONG, Long.valueOf(0))).longValue();
        as.Hm();
        int intValue2 = ((Integer) com.tencent.mm.y.c.Db().get(w.a.USERINFO_MM_LVFETIME_REPORT_MEMORY_PSS_INT, Integer.valueOf(0))).intValue();
        int myPid = Process.myPid();
        MemoryInfo[] processMemoryInfo = ((ActivityManager) ad.getContext().getSystemService("activity")).getProcessMemoryInfo(new int[]{myPid});
        int totalPss = (processMemoryInfo == null || processMemoryInfo.length <= 0 || processMemoryInfo[0] == null) ? -1 : processMemoryInfo[0].getTotalPss();
        if (intValue == 0) {
            as.Hm();
            com.tencent.mm.y.c.Db().a(w.a.USERINFO_MM_LVFETIME_REPORT_PID_INT, Integer.valueOf(myPid));
            as.Hm();
            com.tencent.mm.y.c.Db().a(w.a.USERINFO_MM_LVFETIME_REPORT_LIFETIME_LONG, Long.valueOf(System.currentTimeMillis() - startTime));
            as.Hm();
            t Db = com.tencent.mm.y.c.Db();
            w.a aVar = w.a.USERINFO_MM_LVFETIME_REPORT_MEMORY_PSS_INT;
            if (totalPss <= 0) {
                totalPss = 0;
            }
            Db.a(aVar, Integer.valueOf(totalPss));
        } else if (intValue != myPid) {
            com.tencent.mm.plugin.report.service.g.pWK.h(13778, Integer.valueOf(5), Integer.valueOf(1), Long.valueOf(longValue));
            com.tencent.mm.plugin.report.service.g.pWK.h(13778, Integer.valueOf(5), Integer.valueOf(2), Integer.valueOf(intValue2));
            as.Hm();
            com.tencent.mm.y.c.Db().a(w.a.USERINFO_MM_LVFETIME_REPORT_PID_INT, Integer.valueOf(myPid));
            long currentTimeMillis = System.currentTimeMillis() - startTime;
            if (totalPss <= 0) {
                totalPss = 0;
            }
            as.Hm();
            com.tencent.mm.y.c.Db().a(w.a.USERINFO_MM_LVFETIME_REPORT_LIFETIME_LONG, Long.valueOf(currentTimeMillis));
            as.Hm();
            com.tencent.mm.y.c.Db().a(w.a.USERINFO_MM_LVFETIME_REPORT_MEMORY_PSS_INT, Integer.valueOf(totalPss));
            x.i("MicroMsg.SubCoreBaseMonitor", "summerhv reportLifeTime lifeTime[%d -> %d]ms,  pss[%d -> %d], pid[%d -> %d]", Long.valueOf(longValue), Long.valueOf(currentTimeMillis), Integer.valueOf(intValue2), Integer.valueOf(totalPss), Integer.valueOf(intValue), Integer.valueOf(myPid));
        } else {
            as.Hm();
            com.tencent.mm.y.c.Db().a(w.a.USERINFO_MM_LVFETIME_REPORT_LIFETIME_LONG, Long.valueOf(System.currentTimeMillis() - startTime));
            if (totalPss > intValue2) {
                as.Hm();
                com.tencent.mm.y.c.Db().a(w.a.USERINFO_MM_LVFETIME_REPORT_MEMORY_PSS_INT, Integer.valueOf(totalPss));
            }
        }
        pVar.hIB.K(180000, 180000);
    }

    static /* synthetic */ void f(p pVar) {
        as.Hm();
        long longValue = ((Long) com.tencent.mm.y.c.Db().get(w.a.USERINFO_REPORT_HARDCODER_TIME_LONG, Long.valueOf(0))).longValue();
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - longValue > 86400000 || longValue > currentTimeMillis) {
            as.Hm();
            com.tencent.mm.y.c.Db().a(w.a.USERINFO_REPORT_HARDCODER_TIME_LONG, Long.valueOf(currentTimeMillis));
            com.tencent.mm.sdk.f.e.post(new Runnable() {
                public final void run() {
                    String str = "MicroMsg.SubCoreBaseMonitor";
                    String str2 = "reportHardCoder tid[%d, %s] running[%b]";
                    Object[] objArr = new Object[3];
                    objArr[0] = Long.valueOf(Thread.currentThread().getId());
                    objArr[1] = Thread.currentThread().getName();
                    boolean z = HardCoderJNI.checkEnv && HardCoderJNI.isRunning() > 0;
                    objArr[2] = Boolean.valueOf(z);
                    x.i(str, str2, objArr);
                    HardCoderJNI.reportIDKey(true, 0, 1, false);
                    HardCoderJNI.readServerAddr(true);
                    int i = (!HardCoderJNI.checkEnv || HardCoderJNI.isRunning() <= 0) ? 5 : 4;
                    HardCoderJNI.reportIDKey(true, i, 1, false);
                    HardCoderJNI.reportIDKey(true, HardCoderJNI.isHCEnable() ? 6 : 7, 1, false);
                }
            }, "reportHardCoder");
        }
    }

    static /* synthetic */ void h(p pVar) {
        if (pVar.hIw != 0) {
            as.Hm();
            long longValue = ((Long) com.tencent.mm.y.c.Db().get(w.a.USERINFO_HEAVY_USER_REPORT_TIME_LONG, Long.valueOf(0))).longValue();
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - longValue > 86400000 || longValue > currentTimeMillis) {
                com.tencent.mm.plugin.report.service.g.pWK.a(509, 17, 1, true);
                as.Hm();
                com.tencent.mm.y.c.Db().a(w.a.USERINFO_HEAVY_USER_REPORT_TIME_LONG, Long.valueOf(currentTimeMillis));
                as.Hm();
                longValue = ((Long) com.tencent.mm.y.c.Db().get(w.a.USERINFO_HEAVY_USER_FLAG_LONG, Long.valueOf(0))).longValue();
                com.tencent.mm.bp.a log_14375 = new log_14375();
                log_14375.type_ = 4;
                HeavyDetailInfo heavyDetailInfo = new HeavyDetailInfo();
                log_14375.heavyDetailInfo_ = heavyDetailInfo;
                heavyDetailInfo.flag_ = longValue;
                String valueOf = String.valueOf(longValue);
                as.Hm();
                long longValue2 = ((Long) com.tencent.mm.y.c.Db().get(w.a.USERINFO_HEAVY_USER_REPORT_TYPE_SD_FILE_SIZE_LONG, Long.valueOf(0))).longValue();
                heavyDetailInfo.sdFileSize_ = longValue2;
                valueOf = valueOf + ";" + longValue2;
                as.Hm();
                longValue2 = ((Long) com.tencent.mm.y.c.Db().get(w.a.USERINFO_HEAVY_USER_REPORT_TYPE_SD_FILE_RATIO_LONG, Long.valueOf(0))).longValue();
                heavyDetailInfo.sdFileRatio_ = longValue2;
                valueOf = valueOf + ";" + longValue2;
                as.Hm();
                longValue2 = ((Long) com.tencent.mm.y.c.Db().get(w.a.USERINFO_HEAVY_USER_REPORT_TYPE_DB_SIZE_LONG, Long.valueOf(0))).longValue();
                heavyDetailInfo.dbSize_ = longValue2;
                valueOf = valueOf + ";" + longValue2;
                as.Hm();
                longValue2 = ((Long) com.tencent.mm.y.c.Db().get(w.a.USERINFO_HEAVY_USER_REPORT_TYPE_DB_MESSAGE_LONG, Long.valueOf(0))).longValue();
                heavyDetailInfo.message_ = longValue2;
                valueOf = valueOf + ";" + longValue2;
                as.Hm();
                longValue2 = ((Long) com.tencent.mm.y.c.Db().get(w.a.USERINFO_HEAVY_USER_REPORT_TYPE_DB_CONVERSATION_LONG, Long.valueOf(0))).longValue();
                heavyDetailInfo.conversation_ = longValue2;
                valueOf = valueOf + ";" + longValue2;
                as.Hm();
                longValue2 = ((Long) com.tencent.mm.y.c.Db().get(w.a.USERINFO_HEAVY_USER_REPORT_TYPE_DB_CONTACT_LONG, Long.valueOf(0))).longValue();
                heavyDetailInfo.contact_ = longValue2;
                valueOf = valueOf + ";" + longValue2;
                as.Hm();
                longValue2 = ((Long) com.tencent.mm.y.c.Db().get(w.a.USERINFO_HEAVY_USER_REPORT_TYPE_DB_CHATROOM_LONG, Long.valueOf(0))).longValue();
                heavyDetailInfo.chatroom_ = longValue2;
                valueOf = valueOf + ";" + longValue2;
                as.Hm();
                longValue2 = ((Long) com.tencent.mm.y.c.Db().get(w.a.USERINFO_HEAVY_USER_REPORT_TYPE_FAV_DB_SIZE_LONG, Long.valueOf(0))).longValue();
                heavyDetailInfo.favDbSize_ = longValue2;
                String str = valueOf + ";" + longValue2;
                ad.getContext().getSharedPreferences("heavyDetailInfo", 0).edit().putLong("sdFileSize", heavyDetailInfo.sdFileSize_).putLong("sdFileRatio", heavyDetailInfo.sdFileRatio_).putLong("dbSize", heavyDetailInfo.dbSize_).putLong("message", heavyDetailInfo.message_).putLong("conversation", heavyDetailInfo.conversation_).putLong("contact", heavyDetailInfo.contact_).putLong("chatroom", heavyDetailInfo.chatroom_).putLong("favDbSize", heavyDetailInfo.favDbSize_).putLong("flag", heavyDetailInfo.flag_).apply();
                try {
                    FileOp.j(g.Dq().cachePath + "heavyDetailInfo", new JSONObject().put("sdFileSize", heavyDetailInfo.sdFileSize_).put("sdFileRatio", heavyDetailInfo.sdFileRatio_).put("dbSize", heavyDetailInfo.dbSize_).put("message", heavyDetailInfo.message_).put("conversation", heavyDetailInfo.conversation_).put("contact", heavyDetailInfo.contact_).put("chatroom", heavyDetailInfo.chatroom_).put("favDbSize", heavyDetailInfo.favDbSize_).put("flag", heavyDetailInfo.flag_).toString().getBytes());
                } catch (JSONException e) {
                    x.e("MicroMsg.SubCoreBaseMonitor", "Failed to write heavyDetailInfo");
                }
                com.tencent.mm.plugin.report.service.g.pWK.h(13778, Integer.valueOf(4), Integer.valueOf(1), str);
                com.tencent.mm.plugin.report.service.g.pWK.c(14375, log_14375);
                x.i("MicroMsg.SubCoreBaseMonitor", "summerhv reportHeavyUser report heavy result[%s]", str);
            }
        }
    }

    static /* synthetic */ long q(p pVar) {
        as.Hm();
        if (com.tencent.mm.y.c.isSDCardAvailable()) {
            File file = new File(com.tencent.mm.compatible.util.e.gJl);
            if (file.exists() && file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles == null || listFiles.length == 0) {
                    x.i("MicroMsg.SubCoreBaseMonitor", "summerreportVersion getOldestXlogDay failed as no files");
                    return 0;
                }
                Arrays.sort(listFiles, new Comparator<File>() {
                    public final /* synthetic */ int compare(Object obj, Object obj2) {
                        long lastModified = ((File) obj).lastModified() - ((File) obj2).lastModified();
                        if (lastModified > 0) {
                            return 1;
                        }
                        return lastModified == 0 ? 0 : -1;
                    }

                    public final boolean equals(Object obj) {
                        return true;
                    }
                });
                long j = 0;
                for (File name : listFiles) {
                    String name2 = name.getName();
                    if (!bi.oN(name2) && name2.endsWith(".xlog")) {
                        j = bi.getLong(name2.substring(name2.length() - 13, name2.length() - 5), 0);
                        if (j > 0) {
                            return j;
                        }
                    }
                }
                return j;
            }
            x.i("MicroMsg.SubCoreBaseMonitor", "summerreportVersion getOldestXlogDay failed as path not exist");
            return 0;
        }
        x.i("MicroMsg.SubCoreBaseMonitor", "summerreportVersion getOldestXlogDay failed as sdcard not available");
        return 0;
    }

    private boolean bR(boolean z) {
        boolean z2;
        com.tencent.mm.storage.c fp = com.tencent.mm.y.c.c.IL().fp("100212");
        x.i("MicroMsg.SubCoreBaseMonitor", "summerhv reloadHeavyUserCfg update[%b] abTest[%s][%b][%s] default[%d, %d, %d, %d, %d, %d, %d, %d, %d, %d, %d]", Boolean.valueOf(z), fp, Boolean.valueOf(fp.isValid()), fp.civ(), Long.valueOf(1024), Long.valueOf(10), Long.valueOf(1800), Long.valueOf(3000000), Long.valueOf(15000), Long.valueOf(15000), Long.valueOf(100000), Long.valueOf(10000), Long.valueOf(1440), Long.valueOf(20), Long.valueOf(1440));
        if (fp.isValid()) {
            x.i("MicroMsg.SubCoreBaseMonitor", "summerhv reloadHeavyUserCfg abTest valid!");
            Map civ = fp.civ();
            long j = bi.getLong((String) civ.get("sdsize"), 1024);
            long j2 = bi.getLong((String) civ.get("sdratio"), 10);
            long j3 = bi.getLong((String) civ.get("dbsize"), 1800);
            long j4 = bi.getLong((String) civ.get("fdbsize"), 1024);
            long j5 = bi.getLong((String) civ.get("msg"), 3000000);
            long j6 = bi.getLong((String) civ.get("conv"), 15000);
            long j7 = bi.getLong((String) civ.get("contact"), 100000);
            long j8 = bi.getLong((String) civ.get("chatroom"), 10000);
            long j9 = bi.getLong((String) civ.get("sditv"), 1440);
            long j10 = bi.getLong((String) civ.get("sdwait"), 20);
            long j11 = bi.getLong((String) civ.get("dbitv"), 1440);
            x.i("MicroMsg.SubCoreBaseMonitor", "summerhv reloadHeavyUserCfg sd[%d, %d] sdr[%d, %d] db[%d, %d] fdbsize[%d, %d] msg[%d, %d] conv[%d, %d] contact[%d, %d] chatroom[%d, %d] sditv[%d, %d] sdwait[%d, %d] dbitv[%d, %d]", Long.valueOf(this.hIf), Long.valueOf(j), Long.valueOf(this.hIg), Long.valueOf(j2), Long.valueOf(this.hIh), Long.valueOf(j3), Long.valueOf(this.hIm), Long.valueOf(j4), Long.valueOf(this.hIi), Long.valueOf(j5), Long.valueOf(this.hIj), Long.valueOf(j6), Long.valueOf(this.hIk), Long.valueOf(j7), Long.valueOf(this.hIl), Long.valueOf(j8), Long.valueOf(this.hIn), Long.valueOf(j9), Long.valueOf(this.hIo), Long.valueOf(j10), Long.valueOf(this.hIp), Long.valueOf(j11));
            if (this.hIf != j) {
                this.hIf = j;
                z2 = true;
            } else {
                z2 = false;
            }
            if (this.hIg != j2) {
                this.hIg = j2;
                z2 = true;
            }
            if (this.hIh != j3) {
                this.hIh = j3;
                z2 = true;
            }
            if (this.hIm != j4) {
                this.hIm = j4;
                z2 = true;
            }
            if (this.hIi != j5) {
                this.hIi = j5;
                z2 = true;
            }
            if (this.hIj != j6) {
                this.hIj = j6;
                z2 = true;
            }
            if (this.hIk != j7) {
                this.hIk = j7;
                z2 = true;
            }
            if (this.hIl != j8) {
                this.hIl = j8;
                z2 = true;
            }
            if (this.hIn != j9) {
                this.hIn = j9;
                z2 = true;
            }
            if (this.hIo != j10) {
                this.hIo = j10;
                z2 = true;
            }
            if (this.hIp != j11) {
                this.hIp = j11;
                z2 = true;
            }
        } else {
            z2 = false;
        }
        if (z2) {
            com.tencent.mm.plugin.report.service.g.pWK.a(509, 0, 1, true);
            if (z) {
                com.tencent.mm.plugin.report.service.g.pWK.a(509, 18, 1, true);
            }
        }
        if (this.hIf <= 0) {
            com.tencent.mm.plugin.report.service.g.pWK.a(509, 30, 1, true);
            this.hIf = 1024;
        }
        if (this.hIg <= 0) {
            com.tencent.mm.plugin.report.service.g.pWK.a(509, 31, 1, true);
            this.hIg = 10;
        }
        if (this.hIh <= 0) {
            com.tencent.mm.plugin.report.service.g.pWK.a(509, 32, 1, true);
            this.hIh = 1800;
        }
        if (this.hIi <= 0) {
            com.tencent.mm.plugin.report.service.g.pWK.a(509, 33, 1, true);
            this.hIi = 3000000;
        }
        if (this.hIj <= 0) {
            com.tencent.mm.plugin.report.service.g.pWK.a(509, 34, 1, true);
            this.hIj = 15000;
        }
        if (this.hIk <= 0) {
            com.tencent.mm.plugin.report.service.g.pWK.a(509, 35, 1, true);
            this.hIk = 100000;
        }
        if (this.hIl <= 0) {
            com.tencent.mm.plugin.report.service.g.pWK.a(509, 36, 1, true);
            this.hIl = 10000;
        }
        if (this.hIn <= 0) {
            com.tencent.mm.plugin.report.service.g.pWK.a(509, 37, 1, true);
            this.hIn = 1440;
        }
        if (this.hIo <= 0) {
            com.tencent.mm.plugin.report.service.g.pWK.a(509, 38, 1, true);
            this.hIo = 20;
        }
        if (this.hIp <= 0) {
            com.tencent.mm.plugin.report.service.g.pWK.a(509, 39, 1, true);
            this.hIp = 1440;
        }
        if (this.hIm <= 0) {
            com.tencent.mm.plugin.report.service.g.pWK.a(509, 40, 1, true);
            this.hIm = 1024;
        }
        return z2;
    }

    public final HashMap<Integer, com.tencent.mm.bx.h.d> Bu() {
        return null;
    }

    public final void ge(int i) {
    }

    public final void bs(boolean z) {
        com.tencent.mm.sdk.b.a.xmy.a(this.hIA);
        com.tencent.mm.y.c.c.IL().c(this.hkl);
        boolean bR = bR(false);
        as.Hm();
        this.hIw = ((Long) com.tencent.mm.y.c.Db().get(w.a.USERINFO_HEAVY_USER_FLAG_LONG, Long.valueOf(0))).longValue();
        d.hI(this.hIw != 0);
        x.i("MicroMsg.SubCoreBaseMonitor", "summerhv onAccountPostReset heavyuser[%d], reloadHeavyUser[%b] abTestListener[%s]", Long.valueOf(this.hIw), Boolean.valueOf(bR), this.hkl);
        SharedPreferences sharedPreferences = ad.getContext().getSharedPreferences(HardCoderJNI.SETTING_SP_FILE, 0);
        g.Dr();
        g.Do();
        if (com.tencent.mm.kernel.a.Cn() != 0) {
            g.Dr();
            g.Do();
            int aJ = h.aJ(com.tencent.mm.kernel.a.Cn(), 100);
            if (aJ != sharedPreferences.getInt(HardCoderJNI.KEY_HC_UIN_HASH, 0)) {
                x.i("MicroMsg.SubCoreBaseMonitor", "summerhv hardcoder uin[%d, %d] reloadSPConfig", Integer.valueOf(r3), Integer.valueOf(aJ));
                sharedPreferences.edit().putInt(HardCoderJNI.KEY_HC_UIN_HASH, aJ).apply();
                HardCoderJNI.reloadSPConfig(HardCoderJNI.RELOAD_SCENE_POST_RESET);
            }
        }
        as.CN().a(989, this.hIx);
        as.CN().a(988, this.hIx);
        as.CN().a(987, this.hIx);
        as.CN().a(986, this.hIx);
        as.Hm();
        this.hIt = ((Long) com.tencent.mm.y.c.Db().get(w.a.USERINFO_WECHAT_FILE_SCAN_LAST_TIME_LONG, Long.valueOf(0))).longValue();
        Context context = ad.getContext();
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver != null) {
            int intExtra = registerReceiver.getIntExtra(DownloadInfo.STATUS, -1);
            boolean z2 = intExtra == 2 || intExtra == 5;
            this.hIr = z2;
        } else {
            this.hIr = false;
        }
        this.hIs = ((PowerManager) context.getSystemService("power")).isScreenOn();
        this.hIq = new BroadcastReceiver() {
            public final void onReceive(Context context, Intent intent) {
                String action = intent.getAction();
                boolean z = true;
                switch (action.hashCode()) {
                    case -2128145023:
                        if (action.equals("android.intent.action.SCREEN_OFF")) {
                            z = true;
                            break;
                        }
                        break;
                    case -1886648615:
                        if (action.equals("android.intent.action.ACTION_POWER_DISCONNECTED")) {
                            z = true;
                            break;
                        }
                        break;
                    case -1454123155:
                        if (action.equals("android.intent.action.SCREEN_ON")) {
                            z = false;
                            break;
                        }
                        break;
                    case 505380757:
                        if (action.equals("android.intent.action.TIME_SET")) {
                            z = true;
                            break;
                        }
                        break;
                    case 1019184907:
                        if (action.equals("android.intent.action.ACTION_POWER_CONNECTED")) {
                            z = true;
                            break;
                        }
                        break;
                    case 1041332296:
                        if (action.equals("android.intent.action.DATE_CHANGED")) {
                            z = true;
                            break;
                        }
                        break;
                }
                switch (z) {
                    case false:
                        p.this.hIs = true;
                        break;
                    case true:
                        p.this.hIs = false;
                        break;
                    case true:
                        p.this.hIr = true;
                        break;
                    case true:
                        p.this.hIr = false;
                        break;
                    case true:
                    case true:
                        x.i("MicroMsg.SubCoreBaseMonitor", "summerhv hardcoder Action time change");
                        HardCoderJNI.reloadSPConfig(HardCoderJNI.RELOAD_SCENE_DAY_RECEIVER);
                        return;
                }
                String str = "MicroMsg.SubCoreBaseMonitor";
                String str2 = "summerhv Action received: %s, interactive: %s, charging: %s, lastScanTime:%d, delayTimerRunnable null[%b]";
                Object[] objArr = new Object[5];
                objArr[0] = action;
                objArr[1] = Boolean.valueOf(p.this.hIs);
                objArr[2] = Boolean.valueOf(p.this.hIr);
                objArr[3] = Long.valueOf(p.this.hIt);
                if (p.this.hIu == null) {
                    z = true;
                } else {
                    z = false;
                }
                objArr[4] = Boolean.valueOf(z);
                x.v(str, str2, objArr);
                if (p.this.hIu == null && p.this.hIr && !p.this.hIs) {
                    if (System.currentTimeMillis() - p.this.hIt < p.this.hIn * 60000) {
                        x.i("MicroMsg.SubCoreBaseMonitor", "summerhv last scan time not matched in [%d]min", Long.valueOf(p.this.hIn));
                        return;
                    }
                    final c anonymousClass1 = new c() {
                        public final void a(int i, c.a aVar) {
                            p.this.hIt = System.currentTimeMillis();
                            x.i("MicroMsg.SubCoreBaseMonitor", "summerhv callback errType[%d] lastScanTime[%d], result[%s][%s]", Integer.valueOf(i), Long.valueOf(p.this.hIt), p.this.hIv, aVar);
                            p.this.hIv = null;
                            if (i == 0 && !aVar.hGJ) {
                                as.Hm();
                                com.tencent.mm.y.c.Db().a(w.a.USERINFO_WECHAT_FILE_SCAN_LAST_TIME_LONG, Long.valueOf(p.this.hIt));
                                as.Hm();
                                com.tencent.mm.y.c.Db().lO(false);
                                try {
                                    p.b(p.this, aVar);
                                } catch (Throwable e) {
                                    x.printErrStackTrace("MicroMsg.SubCoreBaseMonitor", e, "doReportSDInfo err!", new Object[0]);
                                    com.tencent.mm.plugin.report.service.g.pWK.a(418, 6, 1, true);
                                }
                            }
                        }
                    };
                    p.this.hIu = new Runnable() {
                        public final void run() {
                            int i;
                            p.this.hIu = null;
                            List aZQ = ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).FQ().aZQ();
                            if (bi.cC(aZQ)) {
                                x.i("MicroMsg.MsgInfoStorageLogic", "summerdel checkUnfinishedDeleteMsgTask all finished!");
                                i = 0;
                            } else {
                                com.tencent.mm.sdk.f.e.post(new com.tencent.mm.y.bb.AnonymousClass1(aZQ), "checkUnfinishedDeleteMsgTask");
                                i = aZQ.size();
                            }
                            x.i("MicroMsg.SubCoreBaseMonitor", "summerdel checkUnfinishedDeleteMsgTask ret[%s]", Integer.valueOf(i));
                            if (i > 0) {
                                com.tencent.mm.plugin.report.service.g.pWK.a(418, 8, 1, true);
                            }
                            p.this.hIv = p.a(p.this, anonymousClass1);
                            x.i("MicroMsg.SubCoreBaseMonitor", "summerhv auto scan started[%s]", p.this.hIv);
                        }
                    };
                    as.Dt().g(p.this.hIu, p.this.hIo * 60000);
                    x.i("MicroMsg.SubCoreBaseMonitor", "summerhv auto scan post delay[%d]min", Long.valueOf(p.this.hIo));
                } else if (p.this.hIu != null) {
                    as.Dt().cgs().removeCallbacks(p.this.hIu);
                    p.this.hIu = null;
                    x.i("MicroMsg.SubCoreBaseMonitor", "summerhv auto scan remove[%s]", p.this.hIv);
                } else if (p.this.hIv != null) {
                    p.this.hIv.hGJ = true;
                    x.i("MicroMsg.SubCoreBaseMonitor", "summerhv auto scan canceled[%s]", p.this.hIv);
                    p.this.hIv = null;
                }
            }
        };
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        intentFilter.addAction("android.intent.action.TIME_SET");
        intentFilter.addAction("android.intent.action.DATE_CHANGED");
        context.registerReceiver(this.hIq, intentFilter);
        String str = "MicroMsg.SubCoreBaseMonitor";
        String str2 = "summerhv registerReceiver auto scan %s. Device status:%s interactive,%s charging mLastAutoScanTime[%d], mAutoScanInterval[%d], mAutoScanWaitTime[%d].";
        Object[] objArr = new Object[6];
        objArr[0] = this.hIv != null ? "enabled" : "disabled";
        objArr[1] = this.hIs ? "" : " not";
        objArr[2] = this.hIr ? "" : " not";
        objArr[3] = Long.valueOf(this.hIt);
        objArr[4] = Long.valueOf(this.hIn * 60000);
        objArr[5] = Long.valueOf(this.hIo * 60000);
        x.i(str, str2, objArr);
        this.hIB.TN();
    }

    public final void bt(boolean z) {
    }

    public final void onAccountRelease() {
        x.i("MicroMsg.SubCoreBaseMonitor", "summerhv onAccountRelease [%d]", Long.valueOf(startTime), Long.valueOf(System.currentTimeMillis()));
        if (this.hIq != null) {
            ad.getContext().unregisterReceiver(this.hIq);
            x.i("MicroMsg.SubCoreBaseMonitor", "summerhv unregisterReceiver mChargeAndInteractiveReceiver[%s]", this.hIq);
            this.hIq = null;
        }
        if (this.hIu != null) {
            as.Dt().cgs().removeCallbacks(this.hIu);
            this.hIu = null;
            x.i("MicroMsg.SubCoreBaseMonitor", "summerhv unregisterReceiver remove[%s]", this.hIv);
        }
        if (this.hIv != null) {
            this.hIv.hGJ = true;
            x.i("MicroMsg.SubCoreBaseMonitor", "summerhv unregisterReceiver canceled[%s]", this.hIv);
            this.hIv = null;
        }
        as.CN().b(989, this.hIx);
        as.CN().b(988, this.hIx);
        as.CN().b(987, this.hIx);
        as.CN().b(986, this.hIx);
        com.tencent.mm.y.c.c.IL().j(this.hkl);
        com.tencent.mm.sdk.b.a.xmy.c(this.hIA);
    }

    private c.a a(File file, c.a aVar, c.b bVar, c.c cVar, Map<String, Integer> map, boolean z, int i) {
        if (aVar.hGJ) {
            x.i("MicroMsg.SubCoreBaseMonitor", "summclean scanFile been canceled fileResult[%s], subDirResult[%s]", aVar, bVar);
        } else {
            if (aVar.axZ < i) {
                aVar.axZ++;
            }
            if (file.isDirectory()) {
                c.b bVar2;
                String absolutePath = file.getAbsolutePath();
                if (bVar != null || map == null || map.size() <= 0 || map.get(absolutePath) == null) {
                    bVar2 = bVar;
                } else {
                    c.b bVar3 = new c.b(absolutePath, ((Integer) map.get(absolutePath)).intValue());
                    map.remove(absolutePath);
                    aVar.hGH.add(bVar3);
                    x.d("MicroMsg.SubCoreBaseMonitor", "summerhv scanFile start scan subDir[%s], fileResult[%s], newSubDirResult[%s]", absolutePath, aVar, bVar3);
                    bVar2 = bVar3;
                }
                aVar.hGE++;
                if (bVar2 != null) {
                    bVar2.hGE++;
                }
                if (cVar != null) {
                    cVar.hGE++;
                }
                if (i > 15) {
                    x.i("MicroMsg.SubCoreBaseMonitor", "summerhv scanFile been stopped as depth[%d] over limit path[%s], fileResult[%s]", Integer.valueOf(i), file.getAbsolutePath(), aVar);
                } else {
                    String[] list = file.list();
                    if (list != null) {
                        if (!z) {
                            long j = 1;
                            int length = list.length;
                            int i2 = 0;
                            while (true) {
                                int i3 = i2;
                                if (i3 >= length) {
                                    break;
                                }
                                a(new File(file.getAbsolutePath() + File.separator + list[i3]), aVar, bVar2, cVar, map, false, i + 1);
                                if (j == null || aVar.axZ <= 15) {
                                    i2 = j;
                                } else {
                                    j = 7;
                                    com.tencent.mm.plugin.report.service.g.pWK.a(418, 7, 1, true);
                                    com.tencent.mm.plugin.report.service.g.pWK.h(13778, Integer.valueOf(2), Integer.valueOf(2), file.getAbsolutePath() + File.separator + r18);
                                    i2 = 0;
                                }
                                i3++;
                            }
                        } else {
                            c.c cVar2 = cVar;
                            for (String str : list) {
                                if (!bi.oN(str) && Pattern.matches("[a-fA-F0-9]{32}temp[0-9]{13}", str)) {
                                    cVar2 = new c.c(file.getAbsolutePath() + File.separator + str);
                                    aVar.hGI.add(cVar2);
                                }
                                a(new File(file.getAbsolutePath() + File.separator + str), aVar, bVar2, cVar2, map, false, i + 1);
                            }
                        }
                    } else {
                        x.i("MicroMsg.SubCoreBaseMonitor", "summerhv scanFile dir is empty[%s] ret", file.getAbsolutePath());
                    }
                }
            } else {
                aVar.hGF++;
                if (bVar != null) {
                    bVar.hGF++;
                }
                if (cVar != null) {
                    cVar.hGF++;
                }
                if (file.exists()) {
                    long length2 = file.length();
                    if (length2 <= 0 || length2 >= 2147483648L) {
                        aVar.fileLenInvalidCount++;
                        if (bVar != null) {
                            bVar.fileLenInvalidCount++;
                        }
                        if (cVar != null) {
                            cVar.hGK++;
                        }
                    } else {
                        aVar.fxb += length2;
                        if (bVar != null) {
                            bVar.fxb += length2;
                        }
                        if (cVar != null) {
                            cVar.fxb = length2 + cVar.fxb;
                        }
                    }
                } else {
                    x.i("MicroMsg.SubCoreBaseMonitor", "summerhv scanFile file not exist[%s][%d] ret", file.getAbsolutePath(), Long.valueOf(aVar.hGF));
                }
            }
        }
        return aVar;
    }

    private synchronized void e(int i, long j, long j2) {
        long j3;
        boolean z = j > j2;
        if (z) {
            j3 = this.hIw | ((long) i);
        } else {
            j3 = this.hIw & ((long) (i ^ -1));
        }
        x.i("MicroMsg.SubCoreBaseMonitor", "summerhv resetHeavyUser type[%d] value[%d] limit[%d] heavy[%b] mHeavyUser[%d] newHeavyUser[%d] tid[%s]", Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z), Long.valueOf(this.hIw), Long.valueOf(j3), Long.valueOf(Thread.currentThread().getId()));
        if (j3 != this.hIw) {
            if (this.hIw == 0) {
                com.tencent.mm.plugin.report.service.g.pWK.a(509, 1, 1, true);
            }
            if (j3 == 0) {
                com.tencent.mm.plugin.report.service.g.pWK.a(509, 2, 1, true);
            }
        }
        w.a aVar = null;
        w.a aVar2;
        switch (i) {
            case 1:
                aVar2 = w.a.USERINFO_HEAVY_USER_REPORT_TYPE_SD_FILE_SIZE_LONG;
                com.tencent.mm.plugin.report.service.g.pWK.a(509, z ? 3 : 4, 1, true);
                aVar = aVar2;
                break;
            case 2:
                aVar2 = w.a.USERINFO_HEAVY_USER_REPORT_TYPE_SD_FILE_RATIO_LONG;
                com.tencent.mm.plugin.report.service.g.pWK.a(509, z ? 5 : 6, 1, true);
                aVar = aVar2;
                break;
            case 4:
                aVar2 = w.a.USERINFO_HEAVY_USER_REPORT_TYPE_DB_SIZE_LONG;
                com.tencent.mm.plugin.report.service.g.pWK.a(509, z ? 7 : 8, 1, true);
                aVar = aVar2;
                break;
            case 8:
                aVar2 = w.a.USERINFO_HEAVY_USER_REPORT_TYPE_DB_MESSAGE_LONG;
                com.tencent.mm.plugin.report.service.g.pWK.a(509, z ? 9 : 10, 1, true);
                aVar = aVar2;
                break;
            case 16:
                aVar2 = w.a.USERINFO_HEAVY_USER_REPORT_TYPE_DB_CONVERSATION_LONG;
                com.tencent.mm.plugin.report.service.g.pWK.a(509, z ? 11 : 12, 1, true);
                aVar = aVar2;
                break;
            case 32:
                aVar2 = w.a.USERINFO_HEAVY_USER_REPORT_TYPE_DB_CONTACT_LONG;
                com.tencent.mm.plugin.report.service.g.pWK.a(509, z ? 13 : 14, 1, true);
                aVar = aVar2;
                break;
            case 64:
                aVar2 = w.a.USERINFO_HEAVY_USER_REPORT_TYPE_DB_CHATROOM_LONG;
                com.tencent.mm.plugin.report.service.g.pWK.a(509, z ? 15 : 16, 1, true);
                aVar = aVar2;
                break;
            case FileUtils.S_IWUSR /*128*/:
                aVar2 = w.a.USERINFO_HEAVY_USER_REPORT_TYPE_FAV_DB_SIZE_LONG;
                com.tencent.mm.plugin.report.service.g.pWK.a(509, z ? 19 : 20, 1, true);
                aVar = aVar2;
                break;
        }
        this.hIw = j3;
        d.hI(j3 != 0);
        final long j4 = j3;
        final long j5 = j;
        as.Dt().F(new Runnable() {
            public final void run() {
                as.Hm();
                com.tencent.mm.y.c.Db().a(w.a.USERINFO_HEAVY_USER_FLAG_LONG, Long.valueOf(j4));
                if (aVar != null) {
                    as.Hm();
                    com.tencent.mm.y.c.Db().a(aVar, Long.valueOf(j5));
                }
                x.i("MicroMsg.SubCoreBaseMonitor", "summerhv resetHeavyUser heavyUser[%d, %d], fkey[%s], value[%d]", Long.valueOf(j4), Long.valueOf(p.this.hIw), aVar, Long.valueOf(j5));
            }
        });
    }
}
