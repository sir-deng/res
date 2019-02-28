package com.tencent.smtt.sdk;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.mm.plugin.appbrand.jsapi.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.contact.a;
import com.tencent.mm.plugin.appbrand.jsapi.share.i;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.f;
import com.tencent.smtt.utils.u;
import dalvik.system.DexClassLoader;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;
import java.util.Properties;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class t {
    private static t AgT = null;
    private static final Lock AgY = new ReentrantLock();
    private static final Lock AgZ = new ReentrantLock();
    private static FileLock Ahb = null;
    public static ThreadLocal<Integer> Ahc = new ThreadLocal<Integer>() {
        public final /* synthetic */ Object initialValue() {
            return Integer.valueOf(0);
        }
    };
    private static Handler Ahd = null;
    private static final Long[][] Ahe;
    static boolean Ahf = false;
    private static boolean Ahg = false;
    private int AgU = 0;
    private FileLock AgV;
    private FileOutputStream AgW;
    private boolean AgX = false;
    private boolean Aha = false;

    static {
        r0 = new Long[7][];
        r0[0] = new Long[]{Long.valueOf(25413), Long.valueOf(11460320)};
        r0[1] = new Long[]{Long.valueOf(25436), Long.valueOf(12009376)};
        r0[2] = new Long[]{Long.valueOf(25437), Long.valueOf(11489180)};
        r0[3] = new Long[]{Long.valueOf(25438), Long.valueOf(11489180)};
        r0[4] = new Long[]{Long.valueOf(25439), Long.valueOf(12013472)};
        r0[5] = new Long[]{Long.valueOf(25440), Long.valueOf(11489180)};
        r0[6] = new Long[]{Long.valueOf(25442), Long.valueOf(11489180)};
        Ahe = r0;
    }

    private t() {
        if (Ahd == null) {
            Ahd = new Handler(r.cFx().getLooper()) {
                public final void handleMessage(Message message) {
                    QbSdk.setTBSInstallingStatus(true);
                    Object[] objArr;
                    switch (message.what) {
                        case 1:
                            TbsLog.i("TbsInstaller", "TbsInstaller--handleMessage--MSG_INSTALL_TBS_CORE");
                            objArr = (Object[]) message.obj;
                            t.this.u((Context) objArr[0], (String) objArr[1], ((Integer) objArr[2]).intValue());
                            break;
                        case 2:
                            TbsLog.i("TbsInstaller", "TbsInstaller--handleMessage--MSG_COPY_TBS_CORE");
                            objArr = (Object[]) message.obj;
                            t.a(t.this, (Context) objArr[0], (Context) objArr[1], ((Integer) objArr[2]).intValue());
                            break;
                        case 3:
                            TbsLog.i("TbsInstaller", "TbsInstaller--handleMessage--MSG_INSTALL_TBS_CORE_EX");
                            objArr = (Object[]) message.obj;
                            t.this.f((Context) objArr[0], (Bundle) objArr[1]);
                            break;
                    }
                    QbSdk.setTBSInstallingStatus(false);
                    super.handleMessage(message);
                }
            };
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(com.tencent.smtt.sdk.t r12, android.content.Context r13, android.content.Context r14, int r15) {
        /*
        r3 = 1;
        r4 = 0;
        r0 = com.tencent.smtt.sdk.o.gI(r13);
        r1 = -524; // 0xfffffffffffffdf4 float:NaN double:NaN;
        r0.In(r1);
        r0 = r12.gQ(r14);
        if (r0 != 0) goto L_0x0065;
    L_0x0011:
        r0 = "TbsInstaller";
        r1 = new java.lang.StringBuilder;
        r2 = "TbsInstaller-copyTbsCoreInThread start!  tbsCoreTargetVer is ";
        r1.<init>(r2);
        r1 = r1.append(r15);
        r1 = r1.toString();
        com.tencent.smtt.utils.TbsLog.i(r0, r1);
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 11;
        if (r0 < r1) goto L_0x0066;
    L_0x002d:
        r0 = "tbs_preloadx5_check_cfg_file";
        r1 = 4;
        r0 = r14.getSharedPreferences(r0, r1);
    L_0x0035:
        r1 = "tbs_precheck_disable_version";
        r2 = -1;
        r0 = r0.getInt(r1, r2);
        if (r0 != r15) goto L_0x006e;
    L_0x003f:
        r0 = "TbsInstaller";
        r1 = new java.lang.StringBuilder;
        r2 = "TbsInstaller-copyTbsCoreInThread -- version:";
        r1.<init>(r2);
        r1 = r1.append(r15);
        r2 = " is disabled by preload_x5_check!";
        r1 = r1.append(r2);
        r1 = r1.toString();
        com.tencent.smtt.utils.TbsLog.e(r0, r1);
        r0 = com.tencent.smtt.sdk.o.gI(r13);
        r1 = -525; // 0xfffffffffffffdf3 float:NaN double:NaN;
        r0.In(r1);
    L_0x0065:
        return;
    L_0x0066:
        r0 = "tbs_preloadx5_check_cfg_file";
        r0 = r14.getSharedPreferences(r0, r4);
        goto L_0x0035;
    L_0x006e:
        r0 = r12.ho(r14);
        if (r0 != 0) goto L_0x007e;
    L_0x0074:
        r0 = com.tencent.smtt.sdk.o.gI(r13);
        r1 = -526; // 0xfffffffffffffdf2 float:NaN double:NaN;
        r0.In(r1);
        goto L_0x0065;
    L_0x007e:
        r0 = AgZ;
        r0 = r0.tryLock();
        r1 = "TbsInstaller";
        r2 = new java.lang.StringBuilder;
        r5 = "TbsInstaller-copyTbsCoreInThread #1 locked is ";
        r2.<init>(r5);
        r2 = r2.append(r0);
        r2 = r2.toString();
        com.tencent.smtt.utils.TbsLog.i(r1, r2);
        if (r0 == 0) goto L_0x05ae;
    L_0x009c:
        r0 = AgY;
        r0.lock();
        r0 = com.tencent.smtt.sdk.n.gH(r14);	 Catch:{ Exception -> 0x03d9 }
        r1 = "copy_core_ver";
        r1 = r0.abQ(r1);	 Catch:{ Exception -> 0x03d9 }
        r0 = com.tencent.smtt.sdk.n.gH(r14);	 Catch:{ Exception -> 0x03d9 }
        r2 = "copy_status";
        r0 = r0.abP(r2);	 Catch:{ Exception -> 0x03d9 }
        if (r1 != r15) goto L_0x00d7;
    L_0x00b9:
        r0 = com.tencent.smtt.sdk.QbSdk.Afr;	 Catch:{ Exception -> 0x03d9 }
        r1 = 220; // 0xdc float:3.08E-43 double:1.087E-321;
        r0.lR(r1);	 Catch:{ Exception -> 0x03d9 }
        r0 = com.tencent.smtt.sdk.o.gI(r13);	 Catch:{ Exception -> 0x03d9 }
        r1 = -528; // 0xfffffffffffffdf0 float:NaN double:NaN;
        r0.In(r1);	 Catch:{ Exception -> 0x03d9 }
        r0 = AgY;
        r0.unlock();
        r0 = AgZ;
        r0.unlock();
    L_0x00d3:
        r12.cFB();
        goto L_0x0065;
    L_0x00d7:
        r2 = r12.ha(r14);	 Catch:{ Exception -> 0x03d9 }
        r5 = "TbsInstaller";
        r6 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x03d9 }
        r7 = "TbsInstaller-copyTbsCoreInThread tbsCoreInstalledVer=";
        r6.<init>(r7);	 Catch:{ Exception -> 0x03d9 }
        r6 = r6.append(r2);	 Catch:{ Exception -> 0x03d9 }
        r6 = r6.toString();	 Catch:{ Exception -> 0x03d9 }
        com.tencent.smtt.utils.TbsLog.i(r5, r6);	 Catch:{ Exception -> 0x03d9 }
        if (r2 != r15) goto L_0x0124;
    L_0x00f3:
        r0 = com.tencent.smtt.sdk.QbSdk.Afr;	 Catch:{ Exception -> 0x03d9 }
        r1 = 220; // 0xdc float:3.08E-43 double:1.087E-321;
        r0.lR(r1);	 Catch:{ Exception -> 0x03d9 }
        r0 = com.tencent.smtt.sdk.o.gI(r13);	 Catch:{ Exception -> 0x03d9 }
        r1 = -528; // 0xfffffffffffffdf0 float:NaN double:NaN;
        r0.In(r1);	 Catch:{ Exception -> 0x03d9 }
        r0 = "TbsInstaller";
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x03d9 }
        r3 = "TbsInstaller-copyTbsCoreInThread return have same version is ";
        r1.<init>(r3);	 Catch:{ Exception -> 0x03d9 }
        r1 = r1.append(r2);	 Catch:{ Exception -> 0x03d9 }
        r1 = r1.toString();	 Catch:{ Exception -> 0x03d9 }
        com.tencent.smtt.utils.TbsLog.i(r0, r1);	 Catch:{ Exception -> 0x03d9 }
        r0 = AgY;
        r0.unlock();
        r0 = AgZ;
        r0.unlock();
        goto L_0x00d3;
    L_0x0124:
        r5 = com.tencent.smtt.sdk.n.gH(r14);	 Catch:{ Exception -> 0x03d9 }
        r6 = "install_core_ver";
        r5 = r5.abQ(r6);	 Catch:{ Exception -> 0x03d9 }
        if (r5 <= 0) goto L_0x0133;
    L_0x0131:
        if (r15 > r5) goto L_0x0137;
    L_0x0133:
        if (r1 <= 0) goto L_0x013a;
    L_0x0135:
        if (r15 <= r1) goto L_0x013a;
    L_0x0137:
        hg(r14);	 Catch:{ Exception -> 0x03d9 }
    L_0x013a:
        r1 = 3;
        if (r0 != r1) goto L_0x0154;
    L_0x013d:
        if (r2 <= 0) goto L_0x0154;
    L_0x013f:
        if (r15 > r2) goto L_0x0146;
    L_0x0141:
        r1 = 88888888; // 0x54c5638 float:9.60787E-36 double:4.3916946E-316;
        if (r15 != r1) goto L_0x0154;
    L_0x0146:
        r0 = -1;
        hg(r14);	 Catch:{ Exception -> 0x03d9 }
        r1 = "TbsInstaller";
        r2 = "TbsInstaller-copyTbsCoreInThread -- update TBS.....";
        r5 = 1;
        com.tencent.smtt.utils.TbsLog.i(r1, r2, r5);	 Catch:{ Exception -> 0x03d9 }
    L_0x0154:
        r1 = com.tencent.smtt.utils.f.hU(r14);	 Catch:{ Exception -> 0x03d9 }
        if (r1 != 0) goto L_0x019f;
    L_0x015a:
        r0 = com.tencent.smtt.utils.u.cGA();	 Catch:{ Exception -> 0x03d9 }
        r2 = com.tencent.smtt.sdk.o.gI(r14);	 Catch:{ Exception -> 0x03d9 }
        r2 = r2.cFe();	 Catch:{ Exception -> 0x03d9 }
        r4 = com.tencent.smtt.sdk.o.gI(r13);	 Catch:{ Exception -> 0x03d9 }
        r5 = -529; // 0xfffffffffffffdef float:NaN double:NaN;
        r4.In(r5);	 Catch:{ Exception -> 0x03d9 }
        r4 = com.tencent.smtt.sdk.v.hp(r14);	 Catch:{ Exception -> 0x03d9 }
        r5 = 210; // 0xd2 float:2.94E-43 double:1.04E-321;
        r6 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x03d9 }
        r7 = "rom is not enough when copying tbs core! curAvailROM=";
        r6.<init>(r7);	 Catch:{ Exception -> 0x03d9 }
        r0 = r6.append(r0);	 Catch:{ Exception -> 0x03d9 }
        r1 = ",minReqRom=";
        r0 = r0.append(r1);	 Catch:{ Exception -> 0x03d9 }
        r0 = r0.append(r2);	 Catch:{ Exception -> 0x03d9 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x03d9 }
        r4.bi(r5, r0);	 Catch:{ Exception -> 0x03d9 }
        r0 = AgY;
        r0.unlock();
        r0 = AgZ;
        r0.unlock();
        goto L_0x00d3;
    L_0x019f:
        if (r0 <= 0) goto L_0x01e3;
    L_0x01a1:
        r1 = com.tencent.smtt.sdk.x.hs(r14);	 Catch:{ Exception -> 0x03d9 }
        if (r1 != 0) goto L_0x01bd;
    L_0x01a7:
        r1 = com.tencent.smtt.sdk.o.gI(r14);	 Catch:{ Exception -> 0x03d9 }
        r1 = r1.Agy;	 Catch:{ Exception -> 0x03d9 }
        r2 = "tbs_downloaddecouplecore";
        r5 = 0;
        r1 = r1.getInt(r2, r5);	 Catch:{ Exception -> 0x03d9 }
        if (r1 != r3) goto L_0x01bd;
    L_0x01b7:
        r1 = gZ(r14);	 Catch:{ Exception -> 0x03d9 }
        if (r15 != r1) goto L_0x01e3;
    L_0x01bd:
        r0 = "TbsInstaller";
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x03d9 }
        r2 = "TbsInstaller-copyTbsCoreInThread return have copied is ";
        r1.<init>(r2);	 Catch:{ Exception -> 0x03d9 }
        r2 = gZ(r14);	 Catch:{ Exception -> 0x03d9 }
        r1 = r1.append(r2);	 Catch:{ Exception -> 0x03d9 }
        r1 = r1.toString();	 Catch:{ Exception -> 0x03d9 }
        com.tencent.smtt.utils.TbsLog.i(r0, r1);	 Catch:{ Exception -> 0x03d9 }
        r0 = AgY;
        r0.unlock();
        r0 = AgZ;
        r0.unlock();
        goto L_0x00d3;
    L_0x01e3:
        if (r0 != 0) goto L_0x0221;
    L_0x01e5:
        r0 = com.tencent.smtt.sdk.n.gH(r14);	 Catch:{ Exception -> 0x03d9 }
        r1 = "copy_retry_num";
        r0 = r0.abQ(r1);	 Catch:{ Exception -> 0x03d9 }
        r1 = 10;
        if (r0 <= r1) goto L_0x0215;
    L_0x01f4:
        r0 = com.tencent.smtt.sdk.v.hp(r14);	 Catch:{ Exception -> 0x03d9 }
        r1 = 211; // 0xd3 float:2.96E-43 double:1.042E-321;
        r2 = "exceed copy retry num!";
        r0.bi(r1, r2);	 Catch:{ Exception -> 0x03d9 }
        r0 = com.tencent.smtt.sdk.o.gI(r13);	 Catch:{ Exception -> 0x03d9 }
        r1 = -530; // 0xfffffffffffffdee float:NaN double:NaN;
        r0.In(r1);	 Catch:{ Exception -> 0x03d9 }
        r0 = AgY;
        r0.unlock();
        r0 = AgZ;
        r0.unlock();
        goto L_0x00d3;
    L_0x0215:
        r1 = com.tencent.smtt.sdk.n.gH(r14);	 Catch:{ Exception -> 0x03d9 }
        r2 = "copy_retry_num";
        r0 = r0 + 1;
        r1.dK(r2, r0);	 Catch:{ Exception -> 0x03d9 }
    L_0x0221:
        r1 = hi(r13);	 Catch:{ Exception -> 0x03d9 }
        r0 = com.tencent.smtt.sdk.x.hs(r14);	 Catch:{ Exception -> 0x03d9 }
        if (r0 != 0) goto L_0x02e1;
    L_0x022b:
        r0 = com.tencent.smtt.sdk.o.gI(r14);	 Catch:{ Exception -> 0x03d9 }
        r0 = r0.Agy;	 Catch:{ Exception -> 0x03d9 }
        r2 = "tbs_downloaddecouplecore";
        r5 = 0;
        r0 = r0.getInt(r2, r5);	 Catch:{ Exception -> 0x03d9 }
        if (r0 != r3) goto L_0x02da;
    L_0x023b:
        r0 = hh(r14);	 Catch:{ Exception -> 0x03d9 }
        r5 = r0;
    L_0x0240:
        if (r1 == 0) goto L_0x057e;
    L_0x0242:
        if (r5 == 0) goto L_0x057e;
    L_0x0244:
        r0 = com.tencent.smtt.sdk.n.gH(r14);	 Catch:{ Exception -> 0x03d9 }
        r2 = 0;
        r0.fH(r15, r2);	 Catch:{ Exception -> 0x03d9 }
        r0 = new com.tencent.smtt.utils.s;	 Catch:{ Exception -> 0x03d9 }
        r0.<init>();	 Catch:{ Exception -> 0x03d9 }
        r2 = new com.tencent.smtt.utils.s$b;	 Catch:{ Exception -> 0x03d9 }
        r2.<init>(r1);	 Catch:{ Exception -> 0x03d9 }
        r0.AkD = r2;	 Catch:{ Exception -> 0x03d9 }
        r6 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x03d9 }
        r2 = com.tencent.smtt.sdk.o.gI(r13);	 Catch:{ Exception -> 0x03d9 }
        r8 = -551; // 0xfffffffffffffdd9 float:NaN double:NaN;
        r2.In(r8);	 Catch:{ Exception -> 0x03d9 }
        r2 = com.tencent.smtt.utils.f.j(r1, r5);	 Catch:{ Exception -> 0x03d9 }
        r8 = com.tencent.smtt.sdk.o.gI(r14);	 Catch:{ Exception -> 0x03d9 }
        r8 = r8.Agy;	 Catch:{ Exception -> 0x03d9 }
        r9 = "tbs_downloaddecouplecore";
        r10 = 0;
        r8 = r8.getInt(r9, r10);	 Catch:{ Exception -> 0x03d9 }
        if (r8 != r3) goto L_0x027c;
    L_0x0279:
        com.tencent.smtt.sdk.x.hr(r14);	 Catch:{ Exception -> 0x03d9 }
    L_0x027c:
        r8 = "TbsInstaller";
        r9 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x03d9 }
        r10 = "TbsInstaller-copyTbsCoreInThread time=";
        r9.<init>(r10);	 Catch:{ Exception -> 0x03d9 }
        r10 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x03d9 }
        r6 = r10 - r6;
        r6 = r9.append(r6);	 Catch:{ Exception -> 0x03d9 }
        r6 = r6.toString();	 Catch:{ Exception -> 0x03d9 }
        com.tencent.smtt.utils.TbsLog.i(r8, r6);	 Catch:{ Exception -> 0x03d9 }
        if (r2 == 0) goto L_0x0553;
    L_0x029a:
        r2 = new com.tencent.smtt.utils.s$b;	 Catch:{ Exception -> 0x03d9 }
        r2.<init>(r1);	 Catch:{ Exception -> 0x03d9 }
        r0.AkE = r2;	 Catch:{ Exception -> 0x03d9 }
        r1 = r0.AkE;	 Catch:{ Exception -> 0x03d9 }
        if (r1 == 0) goto L_0x02a9;
    L_0x02a5:
        r1 = r0.AkD;	 Catch:{ Exception -> 0x03d9 }
        if (r1 != 0) goto L_0x02e8;
    L_0x02a9:
        r0 = r4;
    L_0x02aa:
        if (r0 != 0) goto L_0x0308;
    L_0x02ac:
        r0 = "TbsInstaller";
        r1 = "TbsInstaller-copyTbsCoreInThread copy-verify fail!";
        com.tencent.smtt.utils.TbsLog.i(r0, r1);	 Catch:{ Exception -> 0x03d9 }
        r0 = 1;
        com.tencent.smtt.utils.f.e(r5, r0);	 Catch:{ Exception -> 0x03d9 }
        r0 = com.tencent.smtt.sdk.v.hp(r14);	 Catch:{ Exception -> 0x03d9 }
        r1 = 213; // 0xd5 float:2.98E-43 double:1.05E-321;
        r2 = "TbsCopy-Verify fail after copying tbs core!";
        r0.bi(r1, r2);	 Catch:{ Exception -> 0x03d9 }
        r0 = com.tencent.smtt.sdk.o.gI(r13);	 Catch:{ Exception -> 0x03d9 }
        r1 = -531; // 0xfffffffffffffded float:NaN double:NaN;
        r0.In(r1);	 Catch:{ Exception -> 0x03d9 }
        r0 = AgY;
        r0.unlock();
        r0 = AgZ;
        r0.unlock();
        goto L_0x00d3;
    L_0x02da:
        r0 = hn(r14);	 Catch:{ Exception -> 0x03d9 }
        r5 = r0;
        goto L_0x0240;
    L_0x02e1:
        r0 = hn(r14);	 Catch:{ Exception -> 0x03d9 }
        r5 = r0;
        goto L_0x0240;
    L_0x02e8:
        r1 = r0.AkE;	 Catch:{ Exception -> 0x03d9 }
        r1 = r1.iHS;	 Catch:{ Exception -> 0x03d9 }
        r1 = r1.size();	 Catch:{ Exception -> 0x03d9 }
        r2 = r0.AkD;	 Catch:{ Exception -> 0x03d9 }
        r2 = r2.iHS;	 Catch:{ Exception -> 0x03d9 }
        r2 = r2.size();	 Catch:{ Exception -> 0x03d9 }
        if (r1 != r2) goto L_0x0306;
    L_0x02fa:
        r1 = r0.AkD;	 Catch:{ Exception -> 0x03d9 }
        r0 = r0.AkE;	 Catch:{ Exception -> 0x03d9 }
        r0 = com.tencent.smtt.utils.s.a(r1, r0);	 Catch:{ Exception -> 0x03d9 }
        if (r0 == 0) goto L_0x0306;
    L_0x0304:
        r0 = r3;
        goto L_0x02aa;
    L_0x0306:
        r0 = r4;
        goto L_0x02aa;
    L_0x0308:
        r2 = 0;
        r1 = 0;
        r6 = new java.io.File;	 Catch:{ Exception -> 0x03c6, all -> 0x03d2 }
        r0 = "1";
        r6.<init>(r5, r0);	 Catch:{ Exception -> 0x03c6, all -> 0x03d2 }
        r0 = new java.util.Properties;	 Catch:{ Exception -> 0x03c6, all -> 0x03d2 }
        r0.<init>();	 Catch:{ Exception -> 0x03c6, all -> 0x03d2 }
        r1 = r6.exists();	 Catch:{ Exception -> 0x05c9, all -> 0x03d2 }
        if (r1 == 0) goto L_0x03c2;
    L_0x031d:
        r7 = new java.io.FileInputStream;	 Catch:{ Exception -> 0x05c9, all -> 0x03d2 }
        r7.<init>(r6);	 Catch:{ Exception -> 0x05c9, all -> 0x03d2 }
        r1 = new java.io.BufferedInputStream;	 Catch:{ Exception -> 0x05c9, all -> 0x03d2 }
        r1.<init>(r7);	 Catch:{ Exception -> 0x05c9, all -> 0x03d2 }
        r0.load(r1);	 Catch:{ Exception -> 0x05cd, all -> 0x05c5 }
        r2 = r3;
    L_0x032b:
        if (r1 == 0) goto L_0x0330;
    L_0x032d:
        r1.close();	 Catch:{ IOException -> 0x05c2 }
    L_0x0330:
        r1 = r0;
    L_0x0331:
        if (r2 == 0) goto L_0x042d;
    L_0x0333:
        r6 = r5.listFiles();	 Catch:{ Exception -> 0x03d9 }
        r0 = com.tencent.smtt.sdk.o.gI(r13);	 Catch:{ Exception -> 0x03d9 }
        r7 = -552; // 0xfffffffffffffdd8 float:NaN double:NaN;
        r0.In(r7);	 Catch:{ Exception -> 0x03d9 }
        r0 = r4;
    L_0x0341:
        r7 = r6.length;	 Catch:{ Exception -> 0x03d9 }
        if (r0 >= r7) goto L_0x042d;
    L_0x0344:
        r7 = r6[r0];	 Catch:{ Exception -> 0x03d9 }
        r8 = "1";
        r9 = r7.getName();	 Catch:{ Exception -> 0x03d9 }
        r8 = r8.equals(r9);	 Catch:{ Exception -> 0x03d9 }
        if (r8 != 0) goto L_0x03bf;
    L_0x0353:
        r8 = r7.getName();	 Catch:{ Exception -> 0x03d9 }
        r9 = ".dex";
        r8 = r8.endsWith(r9);	 Catch:{ Exception -> 0x03d9 }
        if (r8 != 0) goto L_0x03bf;
    L_0x0360:
        r8 = "tbs.conf";
        r9 = r7.getName();	 Catch:{ Exception -> 0x03d9 }
        r8 = r8.equals(r9);	 Catch:{ Exception -> 0x03d9 }
        if (r8 != 0) goto L_0x03bf;
    L_0x036d:
        r8 = r7.isDirectory();	 Catch:{ Exception -> 0x03d9 }
        if (r8 != 0) goto L_0x03bf;
    L_0x0373:
        r8 = r7.getName();	 Catch:{ Exception -> 0x03d9 }
        r9 = ".prof";
        r8 = r8.endsWith(r9);	 Catch:{ Exception -> 0x03d9 }
        if (r8 != 0) goto L_0x03bf;
    L_0x0380:
        r8 = com.tencent.smtt.utils.a.Q(r7);	 Catch:{ Exception -> 0x03d9 }
        r9 = r7.getName();	 Catch:{ Exception -> 0x03d9 }
        r10 = "";
        r9 = r1.getProperty(r9, r10);	 Catch:{ Exception -> 0x03d9 }
        r10 = "";
        r10 = r9.equals(r10);	 Catch:{ Exception -> 0x03d9 }
        if (r10 != 0) goto L_0x03fc;
    L_0x0398:
        r10 = r8.equals(r9);	 Catch:{ Exception -> 0x03d9 }
        if (r10 == 0) goto L_0x03fc;
    L_0x039e:
        r8 = "TbsInstaller";
        r9 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x03d9 }
        r10 = "md5_check_success for (";
        r9.<init>(r10);	 Catch:{ Exception -> 0x03d9 }
        r7 = r7.getName();	 Catch:{ Exception -> 0x03d9 }
        r7 = r9.append(r7);	 Catch:{ Exception -> 0x03d9 }
        r9 = ")";
        r7 = r7.append(r9);	 Catch:{ Exception -> 0x03d9 }
        r7 = r7.toString();	 Catch:{ Exception -> 0x03d9 }
        com.tencent.smtt.utils.TbsLog.i(r8, r7);	 Catch:{ Exception -> 0x03d9 }
    L_0x03bf:
        r0 = r0 + 1;
        goto L_0x0341;
    L_0x03c2:
        r1 = r2;
        r2 = r4;
        goto L_0x032b;
    L_0x03c6:
        r0 = move-exception;
        r0 = r1;
        r1 = r2;
    L_0x03c9:
        if (r1 == 0) goto L_0x03ce;
    L_0x03cb:
        r1.close();	 Catch:{ IOException -> 0x05bc }
    L_0x03ce:
        r1 = r0;
        r2 = r3;
        goto L_0x0331;
    L_0x03d2:
        r0 = move-exception;
    L_0x03d3:
        if (r2 == 0) goto L_0x03d8;
    L_0x03d5:
        r2.close();	 Catch:{ IOException -> 0x05bf }
    L_0x03d8:
        throw r0;	 Catch:{ Exception -> 0x03d9 }
    L_0x03d9:
        r0 = move-exception;
        r1 = com.tencent.smtt.sdk.v.hp(r14);	 Catch:{ all -> 0x051f }
        r2 = 215; // 0xd7 float:3.01E-43 double:1.06E-321;
        r0 = r0.toString();	 Catch:{ all -> 0x051f }
        r1.bi(r2, r0);	 Catch:{ all -> 0x051f }
        r0 = com.tencent.smtt.sdk.o.gI(r13);	 Catch:{ all -> 0x051f }
        r1 = -537; // 0xfffffffffffffde7 float:NaN double:NaN;
        r0.In(r1);	 Catch:{ all -> 0x051f }
        r0 = AgY;
        r0.unlock();
        r0 = AgZ;
        r0.unlock();
        goto L_0x00d3;
    L_0x03fc:
        r0 = "TbsInstaller";
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x03d9 }
        r3 = "md5_check_failure for (";
        r1.<init>(r3);	 Catch:{ Exception -> 0x03d9 }
        r3 = r7.getName();	 Catch:{ Exception -> 0x03d9 }
        r1 = r1.append(r3);	 Catch:{ Exception -> 0x03d9 }
        r3 = ") targetMd5:";
        r1 = r1.append(r3);	 Catch:{ Exception -> 0x03d9 }
        r1 = r1.append(r9);	 Catch:{ Exception -> 0x03d9 }
        r3 = ", realMd5:";
        r1 = r1.append(r3);	 Catch:{ Exception -> 0x03d9 }
        r1 = r1.append(r8);	 Catch:{ Exception -> 0x03d9 }
        r1 = r1.toString();	 Catch:{ Exception -> 0x03d9 }
        com.tencent.smtt.utils.TbsLog.e(r0, r1);	 Catch:{ Exception -> 0x03d9 }
        r3 = r4;
    L_0x042d:
        r0 = "TbsInstaller";
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x03d9 }
        r4 = "copyTbsCoreInThread - md5_check_success:";
        r1.<init>(r4);	 Catch:{ Exception -> 0x03d9 }
        r1 = r1.append(r3);	 Catch:{ Exception -> 0x03d9 }
        r1 = r1.toString();	 Catch:{ Exception -> 0x03d9 }
        com.tencent.smtt.utils.TbsLog.i(r0, r1);	 Catch:{ Exception -> 0x03d9 }
        if (r2 == 0) goto L_0x0475;
    L_0x0445:
        if (r3 != 0) goto L_0x0475;
    L_0x0447:
        r0 = "TbsInstaller";
        r1 = "copyTbsCoreInThread - md5 incorrect -> delete destTmpDir!";
        com.tencent.smtt.utils.TbsLog.e(r0, r1);	 Catch:{ Exception -> 0x03d9 }
        r0 = 1;
        com.tencent.smtt.utils.f.e(r5, r0);	 Catch:{ Exception -> 0x03d9 }
        r0 = com.tencent.smtt.sdk.v.hp(r14);	 Catch:{ Exception -> 0x03d9 }
        r1 = 213; // 0xd5 float:2.98E-43 double:1.05E-321;
        r2 = "TbsCopy-Verify md5 fail after copying tbs core!";
        r0.bi(r1, r2);	 Catch:{ Exception -> 0x03d9 }
        r0 = com.tencent.smtt.sdk.o.gI(r13);	 Catch:{ Exception -> 0x03d9 }
        r1 = -532; // 0xfffffffffffffdec float:NaN double:NaN;
        r0.In(r1);	 Catch:{ Exception -> 0x03d9 }
        r0 = AgY;
        r0.unlock();
        r0 = AgZ;
        r0.unlock();
        goto L_0x00d3;
    L_0x0475:
        r0 = "TbsInstaller";
        r1 = "TbsInstaller-copyTbsCoreInThread success!";
        com.tencent.smtt.utils.TbsLog.i(r0, r1);	 Catch:{ Exception -> 0x03d9 }
        r0 = 1;
        y(r14, r0);	 Catch:{ Exception -> 0x03d9 }
        r1 = com.tencent.smtt.sdk.l.gF(r13);	 Catch:{ Exception -> 0x03d9 }
        if (r1 == 0) goto L_0x049f;
    L_0x0488:
        r0 = r1.exists();	 Catch:{ Exception -> 0x03d9 }
        if (r0 == 0) goto L_0x049f;
    L_0x048e:
        r2 = new java.io.File;	 Catch:{ Exception -> 0x03d9 }
        r0 = com.tencent.smtt.sdk.p.gM(r14);	 Catch:{ Exception -> 0x03d9 }
        if (r0 == 0) goto L_0x050e;
    L_0x0496:
        r0 = "x5.oversea.tbs.org";
    L_0x0499:
        r2.<init>(r1, r0);	 Catch:{ Exception -> 0x03d9 }
        com.tencent.smtt.sdk.l.a(r2, r14);	 Catch:{ Exception -> 0x03d9 }
    L_0x049f:
        r0 = com.tencent.smtt.sdk.n.gH(r14);	 Catch:{ Exception -> 0x03d9 }
        r1 = 1;
        r0.fH(r15, r1);	 Catch:{ Exception -> 0x03d9 }
        r0 = r12.Aha;	 Catch:{ Exception -> 0x03d9 }
        if (r0 == 0) goto L_0x0512;
    L_0x04ab:
        r0 = com.tencent.smtt.sdk.v.hp(r14);	 Catch:{ Exception -> 0x03d9 }
        r1 = 220; // 0xdc float:3.08E-43 double:1.087E-321;
        r2 = "continueInstallWithout core success";
        r0.bi(r1, r2);	 Catch:{ Exception -> 0x03d9 }
    L_0x04b7:
        r0 = com.tencent.smtt.sdk.o.gI(r13);	 Catch:{ Exception -> 0x03d9 }
        r1 = -533; // 0xfffffffffffffdeb float:NaN double:NaN;
        r0.In(r1);	 Catch:{ Exception -> 0x03d9 }
        r0 = "TbsInstaller";
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x03d9 }
        r2 = "TbsInstaller-copyTbsCoreInThread success -- version:";
        r1.<init>(r2);	 Catch:{ Exception -> 0x03d9 }
        r1 = r1.append(r15);	 Catch:{ Exception -> 0x03d9 }
        r1 = r1.toString();	 Catch:{ Exception -> 0x03d9 }
        com.tencent.smtt.utils.TbsLog.i(r0, r1);	 Catch:{ Exception -> 0x03d9 }
        r0 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Exception -> 0x03d9 }
        r1 = 11;
        if (r0 < r1) goto L_0x052e;
    L_0x04dc:
        r0 = "tbs_preloadx5_check_cfg_file";
        r1 = 4;
        r0 = r14.getSharedPreferences(r0, r1);	 Catch:{ Exception -> 0x03d9 }
    L_0x04e4:
        r0 = r0.edit();	 Catch:{ Throwable -> 0x0537 }
        r1 = "tbs_preload_x5_counter";
        r2 = 0;
        r0.putInt(r1, r2);	 Catch:{ Throwable -> 0x0537 }
        r1 = "tbs_preload_x5_recorder";
        r2 = 0;
        r0.putInt(r1, r2);	 Catch:{ Throwable -> 0x0537 }
        r1 = "tbs_preload_x5_version";
        r0.putInt(r1, r15);	 Catch:{ Throwable -> 0x0537 }
        r0.commit();	 Catch:{ Throwable -> 0x0537 }
    L_0x04ff:
        com.tencent.smtt.utils.u.id(r14);	 Catch:{ Exception -> 0x03d9 }
    L_0x0502:
        r0 = AgY;
        r0.unlock();
        r0 = AgZ;
        r0.unlock();
        goto L_0x00d3;
    L_0x050e:
        r0 = "x5.tbs.org";
        goto L_0x0499;
    L_0x0512:
        r0 = com.tencent.smtt.sdk.v.hp(r14);	 Catch:{ Exception -> 0x03d9 }
        r1 = 220; // 0xdc float:3.08E-43 double:1.087E-321;
        r2 = "success";
        r0.bi(r1, r2);	 Catch:{ Exception -> 0x03d9 }
        goto L_0x04b7;
    L_0x051f:
        r0 = move-exception;
        r1 = AgY;
        r1.unlock();
        r1 = AgZ;
        r1.unlock();
        r12.cFB();
        throw r0;
    L_0x052e:
        r0 = "tbs_preloadx5_check_cfg_file";
        r1 = 0;
        r0 = r14.getSharedPreferences(r0, r1);	 Catch:{ Exception -> 0x03d9 }
        goto L_0x04e4;
    L_0x0537:
        r0 = move-exception;
        r1 = "TbsInstaller";
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x03d9 }
        r3 = "Init tbs_preload_x5_counter#2 exception:";
        r2.<init>(r3);	 Catch:{ Exception -> 0x03d9 }
        r0 = android.util.Log.getStackTraceString(r0);	 Catch:{ Exception -> 0x03d9 }
        r0 = r2.append(r0);	 Catch:{ Exception -> 0x03d9 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x03d9 }
        com.tencent.smtt.utils.TbsLog.e(r1, r0);	 Catch:{ Exception -> 0x03d9 }
        goto L_0x04ff;
    L_0x0553:
        r0 = "TbsInstaller";
        r1 = "TbsInstaller-copyTbsCoreInThread fail!";
        com.tencent.smtt.utils.TbsLog.i(r0, r1);	 Catch:{ Exception -> 0x03d9 }
        r0 = com.tencent.smtt.sdk.n.gH(r14);	 Catch:{ Exception -> 0x03d9 }
        r1 = 2;
        r0.fH(r15, r1);	 Catch:{ Exception -> 0x03d9 }
        r0 = 0;
        com.tencent.smtt.utils.f.e(r5, r0);	 Catch:{ Exception -> 0x03d9 }
        r0 = com.tencent.smtt.sdk.o.gI(r13);	 Catch:{ Exception -> 0x03d9 }
        r1 = -534; // 0xfffffffffffffdea float:NaN double:NaN;
        r0.In(r1);	 Catch:{ Exception -> 0x03d9 }
        r0 = com.tencent.smtt.sdk.v.hp(r14);	 Catch:{ Exception -> 0x03d9 }
        r1 = 212; // 0xd4 float:2.97E-43 double:1.047E-321;
        r2 = "copy fail!";
        r0.bi(r1, r2);	 Catch:{ Exception -> 0x03d9 }
        goto L_0x0502;
    L_0x057e:
        if (r1 != 0) goto L_0x0595;
    L_0x0580:
        r0 = com.tencent.smtt.sdk.v.hp(r14);	 Catch:{ Exception -> 0x03d9 }
        r1 = 213; // 0xd5 float:2.98E-43 double:1.05E-321;
        r2 = "src-dir is null when copying tbs core!";
        r0.bi(r1, r2);	 Catch:{ Exception -> 0x03d9 }
        r0 = com.tencent.smtt.sdk.o.gI(r13);	 Catch:{ Exception -> 0x03d9 }
        r1 = -535; // 0xfffffffffffffde9 float:NaN double:NaN;
        r0.In(r1);	 Catch:{ Exception -> 0x03d9 }
    L_0x0595:
        if (r5 != 0) goto L_0x0502;
    L_0x0597:
        r0 = com.tencent.smtt.sdk.v.hp(r14);	 Catch:{ Exception -> 0x03d9 }
        r1 = 214; // 0xd6 float:3.0E-43 double:1.057E-321;
        r2 = "dst-dir is null when copying tbs core!";
        r0.bi(r1, r2);	 Catch:{ Exception -> 0x03d9 }
        r0 = com.tencent.smtt.sdk.o.gI(r13);	 Catch:{ Exception -> 0x03d9 }
        r1 = -536; // 0xfffffffffffffde8 float:NaN double:NaN;
        r0.In(r1);	 Catch:{ Exception -> 0x03d9 }
        goto L_0x0502;
    L_0x05ae:
        r12.cFB();
        r0 = com.tencent.smtt.sdk.o.gI(r13);
        r1 = -538; // 0xfffffffffffffde6 float:NaN double:NaN;
        r0.In(r1);
        goto L_0x0065;
    L_0x05bc:
        r1 = move-exception;
        goto L_0x03ce;
    L_0x05bf:
        r1 = move-exception;
        goto L_0x03d8;
    L_0x05c2:
        r1 = move-exception;
        goto L_0x0330;
    L_0x05c5:
        r0 = move-exception;
        r2 = r1;
        goto L_0x03d3;
    L_0x05c9:
        r1 = move-exception;
        r1 = r2;
        goto L_0x03c9;
    L_0x05cd:
        r2 = move-exception;
        goto L_0x03c9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.t.a(com.tencent.smtt.sdk.t, android.content.Context, android.content.Context, int):void");
    }

    private synchronized boolean a(final Context context, Context context2) {
        TbsLog.i("TbsInstaller", "TbsInstaller--quickDexOptForThirdPartyApp");
        if (!Ahg) {
            Ahg = true;
            new Thread(null) {
                public final void run() {
                    TbsLog.i("TbsInstaller", "TbsInstaller--quickDexOptForThirdPartyApp thread start");
                    try {
                        File file = null == null ? new File(x.cFJ()) : t.hi(null);
                        File hi = t.hi(context);
                        int i = VERSION.SDK_INT;
                        if (i != 19 && i < 21) {
                            f.a(file, hi, new FileFilter() {
                                public final boolean accept(File file) {
                                    return file.getName().endsWith(".dex");
                                }
                            });
                        }
                        f.a(file, hi, new FileFilter() {
                            public final boolean accept(File file) {
                                return file.getName().endsWith("tbs.conf");
                            }
                        });
                        TbsLog.i("TbsInstaller", "TbsInstaller--quickDexOptForThirdPartyApp thread done");
                    } catch (Exception e) {
                    }
                }
            }.start();
        }
        return true;
    }

    private boolean a(Context context, File file) {
        try {
            File[] listFiles = file.listFiles(new FileFilter() {
                public final boolean accept(File file) {
                    return file.getName().endsWith(".jar");
                }
            });
            int length = listFiles.length;
            if (VERSION.SDK_INT < 16 && context.getPackageName() != null && context.getPackageName().equalsIgnoreCase("com.tencent.tbs")) {
                try {
                    Thread.sleep(5000);
                } catch (Exception e) {
                }
            }
            ClassLoader classLoader = context.getClassLoader();
            for (int i = 0; i < length; i++) {
                TbsLog.i("TbsInstaller", "jarFile: " + listFiles[i].getAbsolutePath());
                DexClassLoader dexClassLoader = new DexClassLoader(listFiles[i].getAbsolutePath(), file.getAbsolutePath(), null, classLoader);
            }
            return true;
        } catch (Exception e2) {
            v.hp(context).bi(c.CTRL_INDEX, e2.toString());
            TbsLog.i("TbsInstaller", "TbsInstaller-doTbsDexOpt done");
            return false;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean a(android.content.Context r9, java.io.File r10, boolean r11) {
        /*
        r2 = 1;
        r0 = 0;
        r1 = "TbsInstaller";
        r3 = "TbsInstaller-unzipTbs start";
        com.tencent.smtt.utils.TbsLog.i(r1, r3);
        r1 = com.tencent.smtt.utils.f.U(r10);
        if (r1 != 0) goto L_0x0027;
    L_0x0011:
        r1 = com.tencent.smtt.sdk.v.hp(r9);
        r2 = 204; // 0xcc float:2.86E-43 double:1.01E-321;
        r3 = "apk is invalid!";
        r1.bi(r2, r3);
        r1 = com.tencent.smtt.sdk.o.gI(r9);
        r2 = -520; // 0xfffffffffffffdf8 float:NaN double:NaN;
        r1.In(r2);
    L_0x0026:
        return r0;
    L_0x0027:
        r1 = "tbs";
        r3 = 0;
        r3 = r9.getDir(r1, r3);	 Catch:{ Throwable -> 0x007a }
        if (r11 == 0) goto L_0x0071;
    L_0x0031:
        r1 = new java.io.File;	 Catch:{ Throwable -> 0x007a }
        r4 = "core_share_decouple";
        r1.<init>(r3, r4);	 Catch:{ Throwable -> 0x007a }
    L_0x0039:
        r3 = r1.exists();	 Catch:{ Throwable -> 0x007a }
        if (r3 == 0) goto L_0x0052;
    L_0x003f:
        r3 = com.tencent.smtt.sdk.o.gI(r9);	 Catch:{ Throwable -> 0x007a }
        r3 = r3.Agy;	 Catch:{ Throwable -> 0x007a }
        r4 = "tbs_downloaddecouplecore";
        r5 = 0;
        r3 = r3.getInt(r4, r5);	 Catch:{ Throwable -> 0x007a }
        if (r3 == r2) goto L_0x0052;
    L_0x004f:
        com.tencent.smtt.utils.f.T(r1);	 Catch:{ Throwable -> 0x007a }
    L_0x0052:
        if (r11 == 0) goto L_0x0096;
    L_0x0054:
        r1 = hm(r9);
        r4 = r1;
    L_0x0059:
        if (r4 != 0) goto L_0x009c;
    L_0x005b:
        r1 = com.tencent.smtt.sdk.v.hp(r9);
        r2 = 205; // 0xcd float:2.87E-43 double:1.013E-321;
        r3 = "tmp unzip dir is null!";
        r1.bi(r2, r3);
        r1 = com.tencent.smtt.sdk.o.gI(r9);
        r2 = -521; // 0xfffffffffffffdf7 float:NaN double:NaN;
        r1.In(r2);
        goto L_0x0026;
    L_0x0071:
        r1 = new java.io.File;	 Catch:{ Throwable -> 0x007a }
        r4 = "core_unzip_tmp";
        r1.<init>(r3, r4);	 Catch:{ Throwable -> 0x007a }
        goto L_0x0039;
    L_0x007a:
        r1 = move-exception;
        r3 = "TbsInstaller";
        r4 = new java.lang.StringBuilder;
        r5 = "TbsInstaller-unzipTbs -- delete unzip folder if exists exception";
        r4.<init>(r5);
        r1 = android.util.Log.getStackTraceString(r1);
        r1 = r4.append(r1);
        r1 = r1.toString();
        com.tencent.smtt.utils.TbsLog.e(r3, r1);
        goto L_0x0052;
    L_0x0096:
        r1 = hl(r9);
        r4 = r1;
        goto L_0x0059;
    L_0x009c:
        com.tencent.smtt.utils.f.S(r4);	 Catch:{ IOException -> 0x0125, Exception -> 0x016d }
        if (r11 == 0) goto L_0x00a5;
    L_0x00a1:
        r1 = 1;
        com.tencent.smtt.utils.f.e(r4, r1);	 Catch:{ IOException -> 0x0125, Exception -> 0x016d }
    L_0x00a5:
        r1 = com.tencent.smtt.utils.f.i(r10, r4);	 Catch:{ IOException -> 0x0125, Exception -> 0x016d }
        if (r11 == 0) goto L_0x00dc;
    L_0x00ab:
        r5 = r4.list();	 Catch:{ IOException -> 0x0125, Exception -> 0x016d }
        r3 = r0;
    L_0x00b0:
        r6 = r5.length;	 Catch:{ IOException -> 0x0125, Exception -> 0x016d }
        if (r3 >= r6) goto L_0x00cd;
    L_0x00b3:
        r6 = new java.io.File;	 Catch:{ IOException -> 0x0125, Exception -> 0x016d }
        r7 = r5[r3];	 Catch:{ IOException -> 0x0125, Exception -> 0x016d }
        r6.<init>(r4, r7);	 Catch:{ IOException -> 0x0125, Exception -> 0x016d }
        r7 = r6.getName();	 Catch:{ IOException -> 0x0125, Exception -> 0x016d }
        r8 = ".dex";
        r7 = r7.endsWith(r8);	 Catch:{ IOException -> 0x0125, Exception -> 0x016d }
        if (r7 == 0) goto L_0x00ca;
    L_0x00c7:
        r6.delete();	 Catch:{ IOException -> 0x0125, Exception -> 0x016d }
    L_0x00ca:
        r3 = r3 + 1;
        goto L_0x00b0;
    L_0x00cd:
        r3 = hk(r9);	 Catch:{ Exception -> 0x01f3, IOException -> 0x0125 }
        r5 = new java.io.File;	 Catch:{ Exception -> 0x01f3, IOException -> 0x0125 }
        r6 = "x5.tbs";
        r5.<init>(r3, r6);	 Catch:{ Exception -> 0x01f3, IOException -> 0x0125 }
        r5.delete();	 Catch:{ Exception -> 0x01f3, IOException -> 0x0125 }
    L_0x00dc:
        if (r1 != 0) goto L_0x0110;
    L_0x00de:
        com.tencent.smtt.utils.f.T(r4);	 Catch:{ IOException -> 0x0125, Exception -> 0x016d }
        r3 = com.tencent.smtt.sdk.o.gI(r9);	 Catch:{ IOException -> 0x0125, Exception -> 0x016d }
        r5 = -522; // 0xfffffffffffffdf6 float:NaN double:NaN;
        r3.In(r5);	 Catch:{ IOException -> 0x0125, Exception -> 0x016d }
        r3 = "TbsInstaller";
        r5 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0125, Exception -> 0x016d }
        r6 = "copyFileIfChanged -- delete tmpTbsCoreUnzipDir#1! exist:";
        r5.<init>(r6);	 Catch:{ IOException -> 0x0125, Exception -> 0x016d }
        r6 = r4.exists();	 Catch:{ IOException -> 0x0125, Exception -> 0x016d }
        r5 = r5.append(r6);	 Catch:{ IOException -> 0x0125, Exception -> 0x016d }
        r5 = r5.toString();	 Catch:{ IOException -> 0x0125, Exception -> 0x016d }
        com.tencent.smtt.utils.TbsLog.e(r3, r5);	 Catch:{ IOException -> 0x0125, Exception -> 0x016d }
    L_0x0104:
        r0 = "TbsInstaller";
        r2 = "TbsInstaller-unzipTbs done";
        com.tencent.smtt.utils.TbsLog.i(r0, r2);
        r0 = r1;
        goto L_0x0026;
    L_0x0110:
        r3 = 1;
        y(r9, r3);	 Catch:{ IOException -> 0x0125, Exception -> 0x016d }
        if (r11 == 0) goto L_0x0104;
    L_0x0116:
        r3 = hh(r9);	 Catch:{ IOException -> 0x0125, Exception -> 0x016d }
        r5 = 1;
        com.tencent.smtt.utils.f.e(r3, r5);	 Catch:{ IOException -> 0x0125, Exception -> 0x016d }
        r4.renameTo(r3);	 Catch:{ IOException -> 0x0125, Exception -> 0x016d }
        com.tencent.smtt.sdk.x.hr(r9);	 Catch:{ IOException -> 0x0125, Exception -> 0x016d }
        goto L_0x0104;
    L_0x0125:
        r1 = move-exception;
        r3 = com.tencent.smtt.sdk.o.gI(r9);	 Catch:{ all -> 0x01b0 }
        r5 = -523; // 0xfffffffffffffdf5 float:NaN double:NaN;
        r3.In(r5);	 Catch:{ all -> 0x01b0 }
        r3 = com.tencent.smtt.sdk.v.hp(r9);	 Catch:{ all -> 0x01b0 }
        r5 = 206; // 0xce float:2.89E-43 double:1.02E-321;
        r3.c(r5, r1);	 Catch:{ all -> 0x01b0 }
        if (r4 == 0) goto L_0x01f8;
    L_0x013a:
        r1 = r4.exists();	 Catch:{ all -> 0x01b0 }
        if (r1 == 0) goto L_0x01f8;
    L_0x0140:
        r1 = r2;
    L_0x0141:
        if (r1 == 0) goto L_0x0162;
    L_0x0143:
        if (r4 == 0) goto L_0x0162;
    L_0x0145:
        com.tencent.smtt.utils.f.T(r4);	 Catch:{ Throwable -> 0x01bb }
        r1 = "TbsInstaller";
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x01bb }
        r3 = "copyFileIfChanged -- delete tmpTbsCoreUnzipDir#2! exist:";
        r2.<init>(r3);	 Catch:{ Throwable -> 0x01bb }
        r3 = r4.exists();	 Catch:{ Throwable -> 0x01bb }
        r2 = r2.append(r3);	 Catch:{ Throwable -> 0x01bb }
        r2 = r2.toString();	 Catch:{ Throwable -> 0x01bb }
        com.tencent.smtt.utils.TbsLog.e(r1, r2);	 Catch:{ Throwable -> 0x01bb }
    L_0x0162:
        r1 = "TbsInstaller";
        r2 = "TbsInstaller-unzipTbs done";
    L_0x0168:
        com.tencent.smtt.utils.TbsLog.i(r1, r2);
        goto L_0x0026;
    L_0x016d:
        r1 = move-exception;
        r3 = com.tencent.smtt.sdk.o.gI(r9);	 Catch:{ all -> 0x01b0 }
        r5 = -523; // 0xfffffffffffffdf5 float:NaN double:NaN;
        r3.In(r5);	 Catch:{ all -> 0x01b0 }
        r3 = com.tencent.smtt.sdk.v.hp(r9);	 Catch:{ all -> 0x01b0 }
        r5 = 207; // 0xcf float:2.9E-43 double:1.023E-321;
        r3.c(r5, r1);	 Catch:{ all -> 0x01b0 }
        if (r4 == 0) goto L_0x01f6;
    L_0x0182:
        r1 = r4.exists();	 Catch:{ all -> 0x01b0 }
        if (r1 == 0) goto L_0x01f6;
    L_0x0188:
        if (r2 == 0) goto L_0x01a9;
    L_0x018a:
        if (r4 == 0) goto L_0x01a9;
    L_0x018c:
        com.tencent.smtt.utils.f.T(r4);	 Catch:{ Throwable -> 0x01d7 }
        r1 = "TbsInstaller";
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x01d7 }
        r3 = "copyFileIfChanged -- delete tmpTbsCoreUnzipDir#2! exist:";
        r2.<init>(r3);	 Catch:{ Throwable -> 0x01d7 }
        r3 = r4.exists();	 Catch:{ Throwable -> 0x01d7 }
        r2 = r2.append(r3);	 Catch:{ Throwable -> 0x01d7 }
        r2 = r2.toString();	 Catch:{ Throwable -> 0x01d7 }
        com.tencent.smtt.utils.TbsLog.e(r1, r2);	 Catch:{ Throwable -> 0x01d7 }
    L_0x01a9:
        r1 = "TbsInstaller";
        r2 = "TbsInstaller-unzipTbs done";
        goto L_0x0168;
    L_0x01b0:
        r0 = move-exception;
        r1 = "TbsInstaller";
        r2 = "TbsInstaller-unzipTbs done";
        com.tencent.smtt.utils.TbsLog.i(r1, r2);
        throw r0;
    L_0x01bb:
        r1 = move-exception;
        r2 = "TbsInstaller";
        r3 = new java.lang.StringBuilder;
        r4 = "copyFileIfChanged -- delete tmpTbsCoreUnzipDir#2! exception:";
        r3.<init>(r4);
        r1 = android.util.Log.getStackTraceString(r1);
        r1 = r3.append(r1);
        r1 = r1.toString();
        com.tencent.smtt.utils.TbsLog.e(r2, r1);
        goto L_0x0162;
    L_0x01d7:
        r1 = move-exception;
        r2 = "TbsInstaller";
        r3 = new java.lang.StringBuilder;
        r4 = "copyFileIfChanged -- delete tmpTbsCoreUnzipDir#2! exception:";
        r3.<init>(r4);
        r1 = android.util.Log.getStackTraceString(r1);
        r1 = r3.append(r1);
        r1 = r1.toString();
        com.tencent.smtt.utils.TbsLog.e(r2, r1);
        goto L_0x01a9;
    L_0x01f3:
        r3 = move-exception;
        goto L_0x00dc;
    L_0x01f6:
        r2 = r0;
        goto L_0x0188;
    L_0x01f8:
        r1 = r0;
        goto L_0x0141;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.t.a(android.content.Context, java.io.File, boolean):boolean");
    }

    static int abS(String str) {
        BufferedInputStream bufferedInputStream;
        Throwable th;
        int i = 0;
        if (str != null) {
            BufferedInputStream bufferedInputStream2 = null;
            try {
                File file = new File(new File(str), "tbs.conf");
                if (file.exists()) {
                    Properties properties = new Properties();
                    bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                    try {
                        properties.load(bufferedInputStream);
                        bufferedInputStream.close();
                        String property = properties.getProperty("tbs_core_version");
                        if (property != null) {
                            i = Integer.parseInt(property);
                            if (bufferedInputStream != null) {
                                bufferedInputStream.close();
                            }
                        } else if (bufferedInputStream != null) {
                            bufferedInputStream.close();
                        }
                    } catch (Exception e) {
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedInputStream2 = bufferedInputStream;
                        if (bufferedInputStream2 != null) {
                            try {
                                bufferedInputStream2.close();
                            } catch (IOException e2) {
                            }
                        }
                        throw th;
                    }
                } else if (bufferedInputStream2 != null) {
                    try {
                        bufferedInputStream2.close();
                    } catch (IOException e3) {
                    }
                }
            } catch (Exception e4) {
                bufferedInputStream = bufferedInputStream2;
            } catch (Throwable th3) {
                th = th3;
                if (bufferedInputStream2 != null) {
                    bufferedInputStream2.close();
                }
                throw th;
            }
        }
        return i;
        if (bufferedInputStream != null) {
            bufferedInputStream.close();
        }
        return i;
    }

    private Context aq(Context context, int i) {
        TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreHostContext tbsCoreTargetVer=" + i);
        if (i <= 0) {
            return null;
        }
        String[] cFK = x.cFK();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= 4) {
                return null;
            }
            if (!context.getPackageName().equalsIgnoreCase(cFK[i3]) && bJ(context, cFK[i3])) {
                Context bK = bK(context, cFK[i3]);
                if (bK == null) {
                    continue;
                } else if (gU(bK)) {
                    int ha = ha(bK);
                    TbsLog.i("TbsInstaller", "TbsInstaller-getTbsCoreHostContext hostTbsCoreVer=" + ha);
                    if (ha != 0 && ha == i) {
                        TbsLog.i("TbsInstaller", "TbsInstaller-getTbsCoreHostContext targetApp=" + cFK[i3]);
                        return bK;
                    }
                } else {
                    TbsLog.e("TbsInstaller", "TbsInstaller--getTbsCoreHostContext " + cFK[i3] + " illegal signature go on next");
                }
            }
            i2 = i3 + 1;
        }
    }

    private boolean b(Context context, File file) {
        try {
            File file2 = new File(file, "tbs_sdk_extension_dex.jar");
            File file3 = new File(file, "tbs_sdk_extension_dex.dex");
            DexClassLoader dexClassLoader = new DexClassLoader(file2.getAbsolutePath(), file.getAbsolutePath(), null, context.getClassLoader());
            Object abL = g.abL(file3.getAbsolutePath());
            if (TextUtils.isEmpty(abL)) {
                v.hp(context).bi(a.CTRL_INDEX, "can not find oat command");
                return false;
            }
            for (File file4 : file.listFiles(new FileFilter() {
                public final boolean accept(File file) {
                    return file.getName().endsWith(".jar");
                }
            })) {
                String substring = file4.getName().substring(0, file4.getName().length() - 4);
                StringBuilder append = new StringBuilder("/system/bin/dex2oat ").append(abL.replaceAll("tbs_sdk_extension_dex", substring)).append(" --dex-location=");
                cFy();
                Runtime.getRuntime().exec(append.append(hi(context)).append(File.separator).append(substring).append(".jar").toString()).waitFor();
            }
            return true;
        } catch (Throwable e) {
            v.hp(context).c(a.CTRL_INDEX, e);
            return false;
        }
    }

    private static boolean bI(Context context, String str) {
        File file = new File(context.getDir("tbs", 0), str);
        return file.exists() && new File(file, "tbs.conf").exists();
    }

    private static boolean bJ(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 0);
        } catch (NameNotFoundException e) {
            packageInfo = null;
        }
        return packageInfo != null;
    }

    private static Context bK(Context context, String str) {
        try {
            return context.createPackageContext(str, 2);
        } catch (Exception e) {
            return null;
        }
    }

    private static void cFA() {
        boolean z = true;
        try {
            z = o.cFb().cFh();
        } catch (Throwable th) {
        }
        if (z && Ahb != null) {
            f.a(Ahb);
        }
    }

    private synchronized void cFB() {
        int i = this.AgU;
        this.AgU = i - 1;
        if (i > 1 || !this.AgX) {
            TbsLog.i("TbsInstaller", "releaseTbsInstallingFileLock with skip");
        } else {
            TbsLog.i("TbsInstaller", "releaseTbsInstallingFileLock without skip");
            f.a(this.AgV, this.AgW);
            this.AgX = false;
        }
    }

    static synchronized t cFy() {
        t tVar;
        synchronized (t.class) {
            if (AgT == null) {
                synchronized (t.class) {
                    if (AgT == null) {
                        AgT = new t();
                    }
                }
            }
            tVar = AgT;
        }
        return tVar;
    }

    private synchronized boolean cFz() {
        return false;
    }

    public static void gP(Context context) {
        if (!gR(context)) {
            if (bI(context, "core_unzip_tmp")) {
                m.cEY().a(context, 417, new Throwable("TMP_TBS_UNZIP_FOLDER_NAME"));
                TbsLog.e("TbsInstaller", "TbsInstaller-UploadIfTempCoreExistConfError INFO_TEMP_CORE_EXIST_CONF_ERROR TMP_TBS_UNZIP_FOLDER_NAME");
            } else if (bI(context, "core_share_backup_tmp")) {
                m.cEY().a(context, 417, new Throwable("TMP_BACKUP_TBSCORE_FOLDER_NAME"));
                TbsLog.e("TbsInstaller", "TbsInstaller-UploadIfTempCoreExistConfError INFO_TEMP_CORE_EXIST_CONF_ERROR TMP_BACKUP_TBSCORE_FOLDER_NAME");
            } else if (bI(context, "core_copy_tmp")) {
                m.cEY().a(context, 417, new Throwable("TMP_TBS_COPY_FOLDER_NAME"));
                TbsLog.e("TbsInstaller", "TbsInstaller-UploadIfTempCoreExistConfError INFO_TEMP_CORE_EXIST_CONF_ERROR TMP_TBS_COPY_FOLDER_NAME");
            }
        }
    }

    private static boolean gR(Context context) {
        if (context == null) {
            return true;
        }
        try {
            return new File(context.getDir("tbs", 0), "tmp_folder_core_to_read.conf").exists();
        } catch (Exception e) {
            return true;
        }
    }

    public static boolean gS(Context context) {
        try {
            File file = new File(f.ar(context, 4), "x5.tbs.decouple");
            cFy();
            File hm = hm(context);
            f.S(hm);
            f.e(hm, true);
            f.i(file, hm);
            String[] list = hm.list();
            for (String file2 : list) {
                File file3 = new File(hm, file2);
                if (file3.getName().endsWith(".dex")) {
                    file3.delete();
                }
            }
            cFy();
            y(context, true);
            file = hh(context);
            f.e(file, true);
            hm.renameTo(file);
            x.hr(context);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean gT(Context context) {
        boolean z = false;
        TbsLog.i("TbsInstaller", new StringBuilder("TbsInstaller-doTbsDexOpt start - dirMode: 0").toString());
        try {
            if (o.gI(context).Agy.getInt("tbs_downloaddecouplecore", 0) == 1) {
                return true;
            }
            boolean z2;
            boolean z3;
            File hl = hl(context);
            try {
                String property = System.getProperty("java.vm.version");
                z2 = property != null && property.startsWith("2");
                z3 = z2;
            } catch (Throwable th) {
                v.hp(context).c(a.CTRL_INDEX, th);
                z3 = false;
            }
            z2 = VERSION.SDK_INT == 23;
            boolean z4 = o.gI(context).Agy.getBoolean("tbs_stop_preoat", false);
            if (z3 && z2 && !z4) {
                z = true;
            }
            return (z && b(context, hl)) ? true : a(context, hl);
        } catch (Exception e) {
            v.hp(context).bi(c.CTRL_INDEX, e.toString());
            TbsLog.i("TbsInstaller", "TbsInstaller-doTbsDexOpt done");
            return true;
        }
    }

    static boolean gU(Context context) {
        if (x.cFJ() != null) {
            return true;
        }
        try {
            Signature signature = context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0];
            return context.getPackageName().equals("com.tencent.mtt") ? signature.toCharsString().equals("3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a") : context.getPackageName().equals("com.tencent.mm") ? signature.toCharsString().equals("308202eb30820254a00302010202044d36f7a4300d06092a864886f70d01010505003081b9310b300906035504061302383631123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e31353033060355040a132c54656e63656e7420546563686e6f6c6f6779285368656e7a68656e2920436f6d70616e79204c696d69746564313a3038060355040b133154656e63656e74204775616e677a686f7520526573656172636820616e6420446576656c6f706d656e742043656e7465723110300e0603550403130754656e63656e74301e170d3131303131393134333933325a170d3431303131313134333933325a3081b9310b300906035504061302383631123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e31353033060355040a132c54656e63656e7420546563686e6f6c6f6779285368656e7a68656e2920436f6d70616e79204c696d69746564313a3038060355040b133154656e63656e74204775616e677a686f7520526573656172636820616e6420446576656c6f706d656e742043656e7465723110300e0603550403130754656e63656e7430819f300d06092a864886f70d010101050003818d0030818902818100c05f34b231b083fb1323670bfbe7bdab40c0c0a6efc87ef2072a1ff0d60cc67c8edb0d0847f210bea6cbfaa241be70c86daf56be08b723c859e52428a064555d80db448cdcacc1aea2501eba06f8bad12a4fa49d85cacd7abeb68945a5cb5e061629b52e3254c373550ee4e40cb7c8ae6f7a8151ccd8df582d446f39ae0c5e930203010001300d06092a864886f70d0101050500038181009c8d9d7f2f908c42081b4c764c377109a8b2c70582422125ce545842d5f520aea69550b6bd8bfd94e987b75a3077eb04ad341f481aac266e89d3864456e69fba13df018acdc168b9a19dfd7ad9d9cc6f6ace57c746515f71234df3a053e33ba93ece5cd0fc15f3e389a3f365588a9fcb439e069d3629cd7732a13fff7b891499") : context.getPackageName().equals("com.tencent.mobileqq") ? signature.toCharsString().equals("30820253308201bca00302010202044bbb0361300d06092a864886f70d0101050500306d310e300c060355040613054368696e61310f300d06035504080c06e58c97e4baac310f300d06035504070c06e58c97e4baac310f300d060355040a0c06e885bee8aeaf311b3019060355040b0c12e697a0e7babfe4b89ae58aa1e7b3bbe7bb9f310b30090603550403130251513020170d3130303430363039343831375a180f32323834303132303039343831375a306d310e300c060355040613054368696e61310f300d06035504080c06e58c97e4baac310f300d06035504070c06e58c97e4baac310f300d060355040a0c06e885bee8aeaf311b3019060355040b0c12e697a0e7babfe4b89ae58aa1e7b3bbe7bb9f310b300906035504031302515130819f300d06092a864886f70d010101050003818d0030818902818100a15e9756216f694c5915e0b529095254367c4e64faeff07ae13488d946615a58ddc31a415f717d019edc6d30b9603d3e2a7b3de0ab7e0cf52dfee39373bc472fa997027d798d59f81d525a69ecf156e885fd1e2790924386b2230cc90e3b7adc95603ddcf4c40bdc72f22db0f216a99c371d3bf89cba6578c60699e8a0d536950203010001300d06092a864886f70d01010505000381810094a9b80e80691645dd42d6611775a855f71bcd4d77cb60a8e29404035a5e00b21bcc5d4a562482126bd91b6b0e50709377ceb9ef8c2efd12cc8b16afd9a159f350bb270b14204ff065d843832720702e28b41491fbc3a205f5f2f42526d67f17614d8a974de6487b2c866efede3b4e49a0f916baa3c1336fd2ee1b1629652049") : context.getPackageName().equals("com.tencent.tbs") ? signature.toCharsString().equals("3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a") : context.getPackageName().equals("com.qzone") ? signature.toCharsString().equals("308202ad30820216a00302010202044c26cea2300d06092a864886f70d010105050030819a310b3009060355040613023836311530130603550408130c4265696a696e672043697479311530130603550407130c4265696a696e67204369747931263024060355040a131d515a6f6e65205465616d206f662054656e63656e7420436f6d70616e7931183016060355040b130f54656e63656e7420436f6d70616e79311b301906035504031312416e64726f696420515a6f6e65205465616d301e170d3130303632373034303830325a170d3335303632313034303830325a30819a310b3009060355040613023836311530130603550408130c4265696a696e672043697479311530130603550407130c4265696a696e67204369747931263024060355040a131d515a6f6e65205465616d206f662054656e63656e7420436f6d70616e7931183016060355040b130f54656e63656e7420436f6d70616e79311b301906035504031312416e64726f696420515a6f6e65205465616d30819f300d06092a864886f70d010101050003818d003081890281810082d6aca037a9843fbbe88b6dd19f36e9c24ce174c1b398f3a529e2a7fe02de99c27539602c026edf96ad8d43df32a85458bca1e6fbf11958658a7d6751a1d9b782bf43a8c19bd1c06bdbfd94c0516326ae3cf638ac42bb470580e340c46e6f306a772c1ef98f10a559edf867f3f31fe492808776b7bd953b2cba2d2b2d66a44f0203010001300d06092a864886f70d0101050500038181006003b04a8a8c5be9650f350cda6896e57dd13e6e83e7f891fc70f6a3c2eaf75cfa4fc998365deabbd1b9092159edf4b90df5702a0d101f8840b5d4586eb92a1c3cd19d95fbc1c2ac956309eda8eef3944baf08c4a49d3b9b3ffb06bc13dab94ecb5b8eb74e8789aa0ba21cb567f538bbc59c2a11e6919924a24272eb79251677") : !context.getPackageName().equals("com.tencent.qqpimsecure") || signature.toCharsString().equals("30820239308201a2a00302010202044c96f48f300d06092a864886f70d01010505003060310b300906035504061302434e310b300906035504081302474431123010060355040713094775616e677a686f753110300e060355040a130754656e63656e74310b3009060355040b130233473111300f0603550403130857696c736f6e57753020170d3130303932303035343334335a180f32303635303632333035343334335a3060310b300906035504061302434e310b300906035504081302474431123010060355040713094775616e677a686f753110300e060355040a130754656e63656e74310b3009060355040b130233473111300f0603550403130857696c736f6e577530819f300d06092a864886f70d010101050003818d0030818902818100b56e79dbb1185a79e52d792bb3d0bb3da8010d9b87da92ec69f7dc5ad66ab6bfdff2a6a1ed285dd2358f28b72a468be7c10a2ce30c4c27323ed4edcc936080e5bedc2cbbca0b7e879c08a631182793f44bb3ea284179b263410c298e5f6831032c9702ba4a74e2ccfc9ef857f12201451602fc8e774ac59d6398511586c83d1d0203010001300d06092a864886f70d0101050500038181002475615bb65b8d8786b890535802948840387d06b1692ff3ea47ef4c435719ba1865b81e6bfa6293ce31747c3cd6b34595b485cc1563fd90107ba5845c28b95c79138f0dec288940395bc10f92f2b69d8dc410999deb38900974ce9984b678030edfba8816582f56160d87e38641288d8588d2a31e20b89f223d788dd35cc9c8");
        } catch (Exception e) {
            TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTbsCore getPackageInfo fail");
            return false;
        }
    }

    private static boolean gV(Context context) {
        boolean cFh;
        try {
            cFh = o.cFb().cFh();
        } catch (Throwable th) {
            cFh = true;
        }
        if (cFh) {
            Ahb = f.hW(context);
        } else {
            Ahb = af.cFZ().hE(context);
        }
        return Ahb != null;
    }

    private void gW(Context context) {
        TbsLog.i("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromUnzip");
        if (gV(context)) {
            try {
                hd(context);
                TbsLog.i("TbsInstaller", "TbsInstaller--renameShareDir");
                File hl = hl(context);
                File hi = hi(context);
                if (!(hl == null || hi == null)) {
                    hl.renameTo(hi);
                    y(context, false);
                }
                if (!x.hs(context)) {
                    x.hq(context);
                }
                n.gH(context).dK("dexopt_retry_num", 0);
                n.gH(context).dK("unzip_retry_num", 0);
                n.gH(context).dK("unlzma_status", 0);
                n.gH(context).dK("incrupdate_retry_num", 0);
                n.gH(context).fI(0, 3);
                n.gH(context).gc("install_apk_path", "");
                n.gH(context).dK("incrupdate_status", -1);
                if (!x.hs(context)) {
                    int i = o.gI(context).Agy.getInt("tbs_decouplecoreversion", 0);
                    if (i > 0) {
                        cFy();
                        if (i != gZ(context) && i == cFy().ha(context)) {
                            he(context);
                        }
                    }
                    StringBuilder append = new StringBuilder("TbsInstaller--generateNewTbsCoreFromUnzip #1 deCoupleCoreVersion is ").append(i).append(" getTbsCoreShareDecoupleCoreVersion is ");
                    cFy();
                    TbsLog.i("TbsInstaller", append.append(gZ(context)).append(" getTbsCoreInstalledVerInNolock is ").append(cFy().ha(context)).toString());
                }
                if (x.hs(context)) {
                    x.c(context, hc(context), true);
                }
                Ahc.set(Integer.valueOf(0));
            } catch (Throwable th) {
                v.hp(context).bi(219, "exception when renameing from unzip:" + th.toString());
                TbsLog.e("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromUnzip Exception", true);
            }
            cFA();
            return;
        }
        TbsLog.i("TbsInstaller", "get rename fileLock#4 ## failed!");
    }

    private void gX(Context context) {
        TbsLog.i("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromCopy");
        if (gV(context)) {
            try {
                hd(context);
                TbsLog.i("TbsInstaller", "TbsInstaller--renameTbsCoreCopyDir");
                File hn = hn(context);
                File hi = hi(context);
                if (!(hn == null || hi == null)) {
                    hn.renameTo(hi);
                    y(context, false);
                }
                x.hq(context);
                n.gH(context).fH(0, 3);
                if (!x.hs(context)) {
                    int i = o.gI(context).Agy.getInt("tbs_decouplecoreversion", 0);
                    if (i > 0) {
                        cFy();
                        if (i != gZ(context) && i == cFy().ha(context)) {
                            he(context);
                        }
                    }
                    StringBuilder append = new StringBuilder("TbsInstaller--generateNewTbsCoreFromCopy #1 deCoupleCoreVersion is ").append(i).append(" getTbsCoreShareDecoupleCoreVersion is ");
                    cFy();
                    TbsLog.i("TbsInstaller", append.append(gZ(context)).append(" getTbsCoreInstalledVerInNolock is ").append(cFy().ha(context)).toString());
                }
                Ahc.set(Integer.valueOf(0));
            } catch (Exception e) {
                v.hp(context).bi(219, "exception when renameing from copy:" + e.toString());
            }
            cFA();
            return;
        }
        TbsLog.i("TbsInstaller", "get rename fileLock#4 ## failed!");
    }

    static int gY(Context context) {
        BufferedInputStream bufferedInputStream;
        Throwable th;
        int i = 0;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            File hl = hl(context);
            TbsLog.i("TbsInstaller", "TbsInstaller--getTmpTbsCoreVersionUnzipDir  tbsShareDir is " + hl);
            File file = new File(hl, "tbs.conf");
            if (file.exists()) {
                Properties properties = new Properties();
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                try {
                    properties.load(bufferedInputStream);
                    bufferedInputStream.close();
                    String property = properties.getProperty("tbs_core_version");
                    if (property == null) {
                        if (bufferedInputStream != null) {
                            bufferedInputStream.close();
                        }
                        return i;
                    }
                    i = Integer.parseInt(property);
                    if (bufferedInputStream != null) {
                        bufferedInputStream.close();
                    }
                    return i;
                } catch (Exception e) {
                } catch (Throwable th2) {
                    th = th2;
                    bufferedInputStream2 = bufferedInputStream;
                    if (bufferedInputStream2 != null) {
                        try {
                            bufferedInputStream2.close();
                        } catch (IOException e2) {
                        }
                    }
                    throw th;
                }
            }
            if (bufferedInputStream2 != null) {
                try {
                    bufferedInputStream2.close();
                } catch (IOException e3) {
                }
            }
            return i;
        } catch (Exception e4) {
            bufferedInputStream = bufferedInputStream2;
        } catch (Throwable th3) {
            th = th3;
            if (bufferedInputStream2 != null) {
                bufferedInputStream2.close();
            }
            throw th;
        }
        if (bufferedInputStream != null) {
            bufferedInputStream.close();
        }
        return i;
    }

    static int gZ(Context context) {
        BufferedInputStream bufferedInputStream;
        Throwable th;
        int i = 0;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            File file = new File(hh(context), "tbs.conf");
            if (file.exists()) {
                Properties properties = new Properties();
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                try {
                    properties.load(bufferedInputStream);
                    bufferedInputStream.close();
                    String property = properties.getProperty("tbs_core_version");
                    if (property == null) {
                        if (bufferedInputStream != null) {
                            bufferedInputStream.close();
                        }
                        return i;
                    }
                    i = Integer.parseInt(property);
                    if (bufferedInputStream != null) {
                        bufferedInputStream.close();
                    }
                    return i;
                } catch (Exception e) {
                } catch (Throwable th2) {
                    th = th2;
                    bufferedInputStream2 = bufferedInputStream;
                    if (bufferedInputStream2 != null) {
                        try {
                            bufferedInputStream2.close();
                        } catch (IOException e2) {
                        }
                    }
                    throw th;
                }
            }
            if (bufferedInputStream2 != null) {
                try {
                    bufferedInputStream2.close();
                } catch (IOException e3) {
                }
            }
            return i;
        } catch (Exception e4) {
            bufferedInputStream = bufferedInputStream2;
        } catch (Throwable th3) {
            th = th3;
            if (bufferedInputStream2 != null) {
                bufferedInputStream2.close();
            }
            throw th;
        }
        if (bufferedInputStream != null) {
            bufferedInputStream.close();
        }
        return i;
    }

    private void hd(Context context) {
        TbsLog.i("TbsInstaller", "TbsInstaller--deleteOldCore");
        f.e(hi(context), false);
    }

    private static void hf(Context context) {
        TbsLog.i("TbsInstaller", "TbsInstaller--clearNewTbsCore");
        File hl = hl(context);
        if (hl != null) {
            f.e(hl, false);
        }
        n.gH(context).fI(0, 5);
        n.gH(context).dK("incrupdate_status", -1);
        QbSdk.bG(context, "TbsInstaller::clearNewTbsCore forceSysWebViewInner!");
    }

    static void hg(Context context) {
        TbsLog.i("TbsInstaller", "TbsInstaller--cleanStatusAndTmpDir");
        n.gH(context).dK("dexopt_retry_num", 0);
        n.gH(context).dK("unzip_retry_num", 0);
        n.gH(context).dK("unlzma_status", 0);
        n.gH(context).dK("incrupdate_retry_num", 0);
        if (o.gI(context).Agy.getInt("tbs_downloaddecouplecore", 0) != 1) {
            n.gH(context).fI(0, -1);
            n.gH(context).gc("install_apk_path", "");
            n.gH(context).dK("copy_retry_num", 0);
            n.gH(context).dK("incrupdate_status", -1);
            n.gH(context).fH(0, -1);
            f.e(hl(context), true);
            f.e(hn(context), true);
        }
    }

    static File hh(Context context) {
        File file = new File(context.getDir("tbs", 0), "core_share_decouple");
        return (file.isDirectory() || file.mkdir()) ? file : null;
    }

    static File hi(Context context) {
        File file = new File(context.getDir("tbs", 0), "core_share");
        return (file.isDirectory() || file.mkdir()) ? file : null;
    }

    static File hj(Context context) {
        File file = new File(context.getDir("tbs", 0), "share");
        return (file.isDirectory() || file.mkdir()) ? file : null;
    }

    static File hk(Context context) {
        File file = new File(context.getDir("tbs", 0), "core_private");
        return (file.isDirectory() || file.mkdir()) ? file : null;
    }

    static File hl(Context context) {
        File file = new File(context.getDir("tbs", 0), "core_unzip_tmp");
        return (file.isDirectory() || file.mkdir()) ? file : null;
    }

    private static File hm(Context context) {
        File file = new File(context.getDir("tbs", 0), "core_unzip_tmp_decouple");
        return (file.isDirectory() || file.mkdir()) ? file : null;
    }

    private static File hn(Context context) {
        File file = new File(context.getDir("tbs", 0), "core_copy_tmp");
        return (file.isDirectory() || file.mkdir()) ? file : null;
    }

    private synchronized boolean ho(Context context) {
        boolean z = true;
        synchronized (this) {
            this.AgU++;
            if (this.AgX) {
                TbsLog.i("TbsInstaller", "getTbsInstallingFileLock success,is cached= true");
            } else {
                this.AgW = f.c(context, true, "tbslock.txt");
                if (this.AgW != null) {
                    this.AgV = f.a(this.AgW);
                    if (this.AgV == null) {
                        z = false;
                    } else {
                        TbsLog.i("TbsInstaller", "getTbsInstallingFileLock success,is cached= false");
                        this.AgX = true;
                    }
                } else {
                    z = false;
                }
            }
        }
        return z;
    }

    static void t(Context context, String str, int i) {
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCore tbsApkPath=" + str);
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCore tbsCoreTargetVer=" + i);
        TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessName=" + context.getApplicationInfo().processName);
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCore currentProcessId=" + Process.myPid());
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCore currentThreadName=" + Thread.currentThread().getName());
        Object obj = new Object[]{context, str, Integer.valueOf(i)};
        Message message = new Message();
        message.what = 1;
        message.obj = obj;
        Ahd.sendMessage(message);
    }

    @TargetApi(11)
    private void u(Context context, String str, int i) {
        BufferedOutputStream bufferedOutputStream;
        BufferedInputStream bufferedInputStream;
        Throwable th;
        Throwable th2;
        o.gI(context).In(-501);
        if (gQ(context)) {
            TbsLog.i("TbsInstaller", "isTbsLocalInstalled --> no installation!", true);
            o.gI(context).In(-502);
            return;
        }
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread tbsApkPath=" + str);
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread tbsCoreTargetVer=" + i);
        TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessName=" + context.getApplicationInfo().processName);
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread currentProcessId=" + Process.myPid());
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread currentThreadName=" + Thread.currentThread().getName());
        if ((VERSION.SDK_INT >= 11 ? context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4) : context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 0)).getInt("tbs_precheck_disable_version", -1) == i) {
            TbsLog.e("TbsInstaller", "TbsInstaller-installTbsCoreInThread -- version:" + i + " is disabled by preload_x5_check!");
            o.gI(context).In(-503);
        } else if (!f.hU(context)) {
            long cGA = u.cGA();
            long cFe = o.gI(context).cFe();
            o.gI(context).In(-504);
            v.hp(context).bi(i.CTRL_INDEX, "rom is not enough when installing tbs core! curAvailROM=" + cGA + ",minReqRom=" + cFe);
        } else if (ho(context)) {
            boolean tryLock = AgZ.tryLock();
            TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread locked =" + tryLock);
            if (tryLock) {
                o.gI(context).In(-507);
                AgY.lock();
                try {
                    Object obj;
                    int i2;
                    int abQ = n.gH(context).abQ("copy_core_ver");
                    int abQ2 = n.gH(context).abQ("install_core_ver");
                    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread tbsCoreCopyVer =" + abQ);
                    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread tbsCoreInstallVer =" + abQ2);
                    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread tbsCoreTargetVer =" + i);
                    if ((abQ2 > 0 && i > abQ2) || (abQ > 0 && i > abQ)) {
                        hg(context);
                    }
                    abQ2 = n.gH(context).abP("install_status");
                    int ha = ha(context);
                    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread installStatus1=" + abQ2);
                    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread tbsCoreInstalledVer=" + ha);
                    if (abQ2 < 0 || abQ2 >= 2) {
                        if (abQ2 == 3 && ha > 0 && (i > ha || i == 88888888)) {
                            abQ2 = -1;
                            hg(context);
                            TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread -- update TBS.....", true);
                        }
                        obj = null;
                        i2 = abQ2;
                    } else {
                        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread -- retry.....", true);
                        obj = 1;
                        i2 = abQ2;
                    }
                    o.gI(context).In(-508);
                    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread installStatus2=" + i2);
                    abQ = 0;
                    if (i2 <= 0) {
                        String stringValue;
                        TbsLog.i("TbsInstaller", "STEP 2/2 begin installation.....", true);
                        o.gI(context).In(-509);
                        if (obj != null) {
                            abQ = n.gH(context).abQ("unzip_retry_num");
                            if (abQ > 10) {
                                v.hp(context).bi(201, "exceed unzip retry num!");
                                hf(context);
                                o.gI(context).In(-510);
                                AgY.unlock();
                                AgZ.unlock();
                                cFB();
                                return;
                            }
                            n.gH(context).dK("unzip_retry_num", abQ + 1);
                        }
                        if (str == null) {
                            stringValue = n.gH(context).getStringValue("install_apk_path");
                            if (stringValue == null) {
                                v.hp(context).bi(202, "apk path is null!");
                                o.gI(context).In(-511);
                                AgY.unlock();
                                AgZ.unlock();
                                cFB();
                                return;
                            }
                        }
                        stringValue = str;
                        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread apkPath =" + stringValue);
                        PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(stringValue, 0);
                        ha = packageArchiveInfo != null ? packageArchiveInfo.versionCode : 0;
                        if (ha == 0) {
                            o.gI(context).In(-512);
                            v.hp(context).bi(203, "apk version is 0!");
                            AgY.unlock();
                            AgZ.unlock();
                            cFB();
                            return;
                        }
                        n.gH(context).gc("install_apk_path", stringValue);
                        n.gH(context).fI(ha, 0);
                        o.gI(context).In(-548);
                        if (o.gI(context).Agy.getInt("tbs_downloaddecouplecore", 0) == 1) {
                            if (!a(context, new File(stringValue), true)) {
                                v.hp(context).a(207, "unzipTbsApk failed", v.a.TYPE_INSTALL_DECOUPLE);
                                AgY.unlock();
                                AgZ.unlock();
                                cFB();
                                return;
                            }
                        } else if (!a(context, new File(stringValue), false)) {
                            v.hp(context).bi(207, "unzipTbsApk failed");
                            AgY.unlock();
                            AgZ.unlock();
                            cFB();
                            return;
                        }
                        if (obj != null) {
                            abQ = n.gH(context).abP("unlzma_status");
                            if (abQ > 5) {
                                v.hp(context).bi(223, "exceed unlzma retry num!");
                                o.gI(context).In(-553);
                                hf(context);
                                l.gG(context);
                                o.gI(context).Agx.put("tbs_needdownload", Boolean.valueOf(true));
                                o.gI(context).Agx.put("request_full_package", Boolean.valueOf(true));
                                o.gI(context).commit();
                                AgY.unlock();
                                AgZ.unlock();
                                cFB();
                                return;
                            }
                            n.gH(context).dK("unlzma_status", abQ + 1);
                        }
                        TbsLog.i("TbsInstaller", "unlzma begin");
                        int i3 = o.cFb().Agy.getInt("tbs_responsecode", 0);
                        if (ha(context) != 0) {
                            Object b = QbSdk.b(context, "can_unlzma", null);
                            tryLock = (b == null || !(b instanceof Boolean)) ? false : ((Boolean) b).booleanValue();
                            if (tryLock) {
                                Bundle bundle = new Bundle();
                                bundle.putInt("responseCode", i3);
                                if (o.gI(context).Agy.getInt("tbs_downloaddecouplecore", 0) == 1) {
                                    bundle.putString("unzip_temp_path", hh(context).getAbsolutePath());
                                } else {
                                    bundle.putString("unzip_temp_path", hl(context).getAbsolutePath());
                                }
                                b = QbSdk.b(context, "unlzma", bundle);
                                if (b == null) {
                                    TbsLog.i("TbsInstaller", "unlzma return null");
                                    v.hp(context).bi(222, "unlzma is null");
                                    b = null;
                                } else if (b instanceof Boolean) {
                                    if (((Boolean) b).booleanValue()) {
                                        b = 1;
                                        TbsLog.i("TbsInstaller", "unlzma success");
                                    } else {
                                        TbsLog.i("TbsInstaller", "unlzma return false");
                                        v.hp(context).bi(222, "unlzma return false");
                                        b = null;
                                    }
                                } else if (b instanceof Bundle) {
                                    b = 1;
                                } else {
                                    if (b instanceof Throwable) {
                                        TbsLog.i("TbsInstaller", "unlzma failure because Throwable" + Log.getStackTraceString((Throwable) b));
                                        v.hp(context).c(222, (Throwable) b);
                                    }
                                    b = null;
                                }
                                if (b == null) {
                                    AgY.unlock();
                                    AgZ.unlock();
                                    cFB();
                                    return;
                                }
                            }
                        }
                        TbsLog.i("TbsInstaller", "unlzma finished");
                        n.gH(context).fI(ha, 1);
                        abQ = ha;
                    } else if (o.gI(context).Agy.getInt("tbs_downloaddecouplecore", 0) == 1) {
                        String stringValue2;
                        if (str == null) {
                            stringValue2 = n.gH(context).getStringValue("install_apk_path");
                            if (stringValue2 == null) {
                                v.hp(context).bi(202, "apk path is null!");
                                o.gI(context).In(-511);
                                AgY.unlock();
                                AgZ.unlock();
                                cFB();
                                return;
                            }
                        }
                        stringValue2 = str;
                        a(context, new File(stringValue2), true);
                    }
                    if (i2 < 2) {
                        if (obj != null) {
                            abQ2 = n.gH(context).abQ("dexopt_retry_num");
                            if (abQ2 > 10) {
                                v.hp(context).bi(com.tencent.mm.plugin.appbrand.jsapi.a.f.CTRL_INDEX, "exceed dexopt retry num!");
                                o.gI(context).In(-514);
                                hf(context);
                                AgY.unlock();
                                AgZ.unlock();
                                cFB();
                                return;
                            }
                            n.gH(context).dK("dexopt_retry_num", abQ2 + 1);
                        }
                        o.gI(context).In(-549);
                        if (gT(context)) {
                            n.gH(context).fI(abQ, 2);
                            TbsLog.i("TbsInstaller", "STEP 2/2 installation completed! you can restart!", true);
                            TbsLog.i("TbsInstaller", "STEP 2/2 installation completed! you can restart! version:" + i);
                            o.gI(context).In(-516);
                            Editor edit = (VERSION.SDK_INT >= 11 ? context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4) : context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 0)).edit();
                            edit.putInt("tbs_preload_x5_counter", 0);
                            edit.putInt("tbs_preload_x5_recorder", 0);
                            edit.putInt("tbs_preload_x5_version", i);
                            edit.commit();
                            o.gI(context).In(-517);
                            if (i == 88888888) {
                                new File(str).delete();
                                TbsLog.i("TbsInstaller", "Local tbs apk(" + str + ") is deleted!", true);
                                File file = new File(context.getDir("tbs", 0), "core_unzip_tmp");
                                if (file.canRead()) {
                                    File file2 = new File(file, "tbs.conf");
                                    Properties properties = new Properties();
                                    BufferedOutputStream bufferedOutputStream2 = null;
                                    BufferedInputStream bufferedInputStream2;
                                    try {
                                        bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file2));
                                        try {
                                            properties.load(bufferedInputStream2);
                                            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
                                        } catch (Throwable th3) {
                                            th = th3;
                                            if (bufferedOutputStream2 != null) {
                                                try {
                                                    bufferedOutputStream2.close();
                                                } catch (IOException e) {
                                                }
                                            }
                                            if (bufferedInputStream2 != null) {
                                                try {
                                                    bufferedInputStream2.close();
                                                } catch (IOException e2) {
                                                }
                                            }
                                            throw th;
                                        }
                                        try {
                                            properties.setProperty("tbs_local_installation", "true");
                                            properties.store(bufferedOutputStream, null);
                                            TbsLog.i("TbsInstaller", "TBS_LOCAL_INSTALLATION is set!", true);
                                            try {
                                                bufferedOutputStream.close();
                                            } catch (IOException e3) {
                                            }
                                            try {
                                                bufferedInputStream2.close();
                                            } catch (IOException e4) {
                                            }
                                        } catch (Throwable th4) {
                                            th2 = th4;
                                            bufferedOutputStream2 = bufferedOutputStream;
                                            th = th2;
                                            if (bufferedOutputStream2 != null) {
                                                bufferedOutputStream2.close();
                                            }
                                            if (bufferedInputStream2 != null) {
                                                bufferedInputStream2.close();
                                            }
                                            throw th;
                                        }
                                    } catch (Throwable th5) {
                                        th2 = th5;
                                        bufferedInputStream2 = null;
                                        th = th2;
                                        if (bufferedOutputStream2 != null) {
                                            bufferedOutputStream2.close();
                                        }
                                        if (bufferedInputStream2 != null) {
                                            bufferedInputStream2.close();
                                        }
                                        throw th;
                                    }
                                }
                            }
                            if (this.Aha) {
                                if (n.gH(context).abP("incrupdate_status") != 1) {
                                }
                                v.hp(context).bi(n.gH(context).abP("incrupdate_status") != 1 ? 221 : 200, "continueInstallWithout core success");
                            } else {
                                if (n.gH(context).abP("incrupdate_status") != 1) {
                                }
                                v.hp(context).bi(n.gH(context).abP("incrupdate_status") != 1 ? 221 : 200, "success");
                            }
                        } else {
                            o.gI(context).In(-515);
                            AgY.unlock();
                            AgZ.unlock();
                            cFB();
                            return;
                        }
                    } else if (i2 == 2) {
                        QbSdk.Afr.lR(200);
                    }
                } catch (Throwable th6) {
                    AgY.unlock();
                    AgZ.unlock();
                    cFB();
                }
                AgY.unlock();
                AgZ.unlock();
                cFB();
                return;
            }
            o.gI(context).In(-519);
            cFB();
        } else {
            o.gI(context).In(-505);
        }
    }

    private synchronized boolean u(Context context, boolean z) {
        Throwable th;
        boolean z2 = false;
        boolean z3 = true;
        synchronized (this) {
            TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromCopy");
            try {
                if (ho(context)) {
                    boolean tryLock = AgY.tryLock();
                    TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromCopy Locked =" + tryLock);
                    if (tryLock) {
                        int abP = n.gH(context).abP("copy_status");
                        int b = b(false, context);
                        TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromCopy copyStatus =" + abP);
                        TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromCopy tbsCoreInstalledVer =" + b);
                        if (abP == 1) {
                            if (b == 0) {
                                TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromCopy tbsCoreInstalledVer = 0", true);
                                gX(context);
                            } else if (z) {
                                TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromCopy tbsCoreInstalledVer != 0", true);
                                gX(context);
                            }
                            AgY.unlock();
                            z2 = z3;
                        }
                        z3 = false;
                        try {
                            AgY.unlock();
                            z2 = z3;
                        } catch (Throwable th2) {
                            Throwable th3 = th2;
                            z2 = z3;
                            th = th3;
                            v.hp(context).bi(bp.CTRL_INDEX, th.toString());
                            QbSdk.bG(context, "TbsInstaller::enableTbsCoreFromCopy exception:" + Log.getStackTraceString(th));
                            return z2;
                        }
                    }
                    cFB();
                }
            } catch (Throwable th4) {
                th = th4;
            }
        }
        return z2;
    }

    private synchronized boolean v(Context context, boolean z) {
        Object e;
        boolean z2 = true;
        boolean z3 = false;
        synchronized (this) {
            TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromUnzip canRenameTmpDir =" + z);
            try {
                if (ho(context)) {
                    boolean tryLock = AgY.tryLock();
                    TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromUnzip locked=" + tryLock);
                    if (tryLock) {
                        int abP = n.gH(context).abP("install_status");
                        TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromUnzip installStatus=" + abP);
                        int b = b(false, context);
                        if (abP == 2) {
                            if (b == 0) {
                                TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromUnzip tbsCoreInstalledVer = 0", false);
                                gW(context);
                            } else if (z) {
                                TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromUnzip tbsCoreInstalledVer != 0", false);
                                gW(context);
                            }
                            AgY.unlock();
                            z3 = z2;
                        }
                        z2 = false;
                        try {
                            AgY.unlock();
                            z3 = z2;
                        } catch (Exception e2) {
                            Exception exception = e2;
                            z3 = z2;
                            Exception e3 = exception;
                            QbSdk.bG(context, "TbsInstaller::enableTbsCoreFromUnzip Exception: " + e3);
                            return z3;
                        }
                    }
                    cFB();
                }
            } catch (Exception e4) {
                e3 = e4;
            } catch (Throwable th) {
                AgY.unlock();
            }
        }
        return z3;
    }

    static void y(Context context, boolean z) {
        if (context == null) {
            v.hp(context).bi(225, "setTmpFolderCoreToRead context is null");
            return;
        }
        try {
            File file = new File(context.getDir("tbs", 0), "tmp_folder_core_to_read.conf");
            if (!z) {
                f.T(file);
            } else if (!file.exists()) {
                file.createNewFile();
            }
        } catch (Exception e) {
            v.hp(context).bi(225, "setTmpFolderCoreToRead Exception message is " + e.getMessage() + " Exception cause is " + e.getCause());
        }
    }

    final boolean ap(Context context, int i) {
        if (p.gM(context)) {
            return false;
        }
        TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTbsCore targetTbsCoreVer=" + i);
        TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessName=" + context.getApplicationInfo().processName);
        TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTbsCore currentProcessId=" + Process.myPid());
        TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTbsCore currentThreadName=" + Thread.currentThread().getName());
        if (aq(context, i) != null) {
            Object obj = new Object[]{aq(context, i), context, Integer.valueOf(i)};
            Message message = new Message();
            message.what = 2;
            message.obj = obj;
            Ahd.sendMessage(message);
            return true;
        }
        TbsLog.i("TbsInstaller", "TbsInstaller--installLocalTbsCore copy from null");
        return false;
    }

    public final int b(boolean z, Context context) {
        if (z || ((Integer) Ahc.get()).intValue() <= 0) {
            Ahc.set(Integer.valueOf(ha(context)));
        }
        return ((Integer) Ahc.get()).intValue();
    }

    public final String bL(Context context, String str) {
        BufferedInputStream bufferedInputStream;
        Throwable th;
        String str2 = null;
        if (!TextUtils.isEmpty(str)) {
            bufferedInputStream = null;
            try {
                File file = new File(hi(context), "tbs.conf");
                if (file.exists()) {
                    Properties properties = new Properties();
                    bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                    try {
                        properties.load(bufferedInputStream);
                        bufferedInputStream.close();
                        str2 = properties.getProperty(str);
                        if (bufferedInputStream != null) {
                            bufferedInputStream.close();
                        }
                    } catch (Exception e) {
                    } catch (Throwable th2) {
                        th = th2;
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (IOException e2) {
                            }
                        }
                        throw th;
                    }
                } else if (str2 != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e3) {
                    }
                }
            } catch (Exception e4) {
                bufferedInputStream = str2;
            } catch (Throwable th3) {
                Throwable th4 = th3;
                bufferedInputStream = str2;
                th = th4;
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                throw th;
            }
        }
        return str2;
        if (bufferedInputStream != null) {
            bufferedInputStream.close();
        }
        return str2;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    final void f(android.content.Context r11, android.os.Bundle r12) {
        /*
        r10 = this;
        r9 = 217; // 0xd9 float:3.04E-43 double:1.07E-321;
        r8 = -546; // 0xfffffffffffffdde float:NaN double:NaN;
        r2 = 2;
        r3 = 1;
        r5 = 0;
        r0 = r10.gQ(r11);
        if (r0 == 0) goto L_0x0017;
    L_0x000d:
        r0 = com.tencent.smtt.sdk.o.gI(r11);
        r1 = -539; // 0xfffffffffffffde5 float:NaN double:NaN;
        r0.In(r1);
    L_0x0016:
        return;
    L_0x0017:
        r0 = "TbsInstaller";
        r1 = "TbsInstaller-installLocalTesCoreExInThread";
        com.tencent.smtt.utils.TbsLog.i(r0, r1);
        if (r12 == 0) goto L_0x0016;
    L_0x0022:
        if (r11 == 0) goto L_0x0016;
    L_0x0024:
        r0 = com.tencent.smtt.utils.f.hU(r11);
        if (r0 != 0) goto L_0x0064;
    L_0x002a:
        r0 = com.tencent.smtt.utils.u.cGA();
        r2 = com.tencent.smtt.sdk.o.gI(r11);
        r2 = r2.cFe();
        r4 = com.tencent.smtt.sdk.v.hp(r11);
        r5 = 210; // 0xd2 float:2.94E-43 double:1.04E-321;
        r6 = new java.lang.StringBuilder;
        r7 = "rom is not enough when patching tbs core! curAvailROM=";
        r6.<init>(r7);
        r0 = r6.append(r0);
        r1 = ",minReqRom=";
        r0 = r0.append(r1);
        r0 = r0.append(r2);
        r0 = r0.toString();
        r4.bi(r5, r0);
        r0 = com.tencent.smtt.sdk.o.gI(r11);
        r1 = -540; // 0xfffffffffffffde4 float:NaN double:NaN;
        r0.In(r1);
        goto L_0x0016;
    L_0x0064:
        r0 = r10.ho(r11);
        if (r0 != 0) goto L_0x0074;
    L_0x006a:
        r0 = com.tencent.smtt.sdk.o.gI(r11);
        r1 = -541; // 0xfffffffffffffde3 float:NaN double:NaN;
        r0.In(r1);
        goto L_0x0016;
    L_0x0074:
        r0 = AgZ;
        r0 = r0.tryLock();
        r1 = "TbsInstaller";
        r4 = new java.lang.StringBuilder;
        r6 = "TbsInstaller-installLocalTesCoreExInThread locked=";
        r4.<init>(r6);
        r4 = r4.append(r0);
        r4 = r4.toString();
        com.tencent.smtt.utils.TbsLog.i(r1, r4);
        if (r0 == 0) goto L_0x02ca;
    L_0x0092:
        r1 = 0;
        r0 = 1;
        com.tencent.smtt.sdk.QbSdk.setTBSInstallingStatus(r0);	 Catch:{ Exception -> 0x01f9, all -> 0x0272 }
        r0 = r10.ha(r11);	 Catch:{ Exception -> 0x01f9, all -> 0x0272 }
        if (r0 <= 0) goto L_0x00aa;
    L_0x009d:
        r0 = com.tencent.smtt.sdk.n.gH(r11);	 Catch:{ Exception -> 0x01f9, all -> 0x0272 }
        r4 = "incrupdate_status";
        r0 = r0.abP(r4);	 Catch:{ Exception -> 0x01f9, all -> 0x0272 }
        if (r0 != r3) goto L_0x00c4;
    L_0x00aa:
        r0 = 0;
        com.tencent.smtt.sdk.QbSdk.setTBSInstallingStatus(r0);	 Catch:{ Exception -> 0x01f9, all -> 0x0272 }
        r0 = AgZ;
        r0.unlock();
        r10.cFB();
        r0 = "TbsInstaller";
        r1 = "TbsInstaller-installLocalTesCoreExInThread PATCH_NONEEDPATCH";
        com.tencent.smtt.utils.TbsLog.i(r0, r1);
    L_0x00bf:
        com.tencent.smtt.sdk.QbSdk.setTBSInstallingStatus(r5);
        goto L_0x0016;
    L_0x00c4:
        r0 = com.tencent.smtt.sdk.o.gI(r11);	 Catch:{ Exception -> 0x01f9, all -> 0x0272 }
        r0 = r0.Agy;	 Catch:{ Exception -> 0x01f9, all -> 0x0272 }
        r4 = "tbs_responsecode";
        r6 = 0;
        r4 = r0.getInt(r4, r6);	 Catch:{ Exception -> 0x01f9, all -> 0x0272 }
        if (r4 == r3) goto L_0x00d9;
    L_0x00d4:
        if (r4 == r2) goto L_0x00d9;
    L_0x00d6:
        r0 = 4;
        if (r4 != r0) goto L_0x016b;
    L_0x00d9:
        r0 = r3;
    L_0x00da:
        if (r0 != 0) goto L_0x037a;
    L_0x00dc:
        if (r4 == 0) goto L_0x037a;
    L_0x00de:
        r0 = com.tencent.smtt.sdk.n.gH(r11);	 Catch:{ Exception -> 0x01f9, all -> 0x0272 }
        r4 = "incrupdate_retry_num";
        r0 = r0.abQ(r4);	 Catch:{ Exception -> 0x01f9, all -> 0x0272 }
        r4 = 5;
        if (r0 <= r4) goto L_0x016e;
    L_0x00ec:
        r0 = "TbsInstaller";
        r4 = "TbsInstaller-installLocalTesCoreExInThread exceed incrupdate num";
        com.tencent.smtt.utils.TbsLog.i(r0, r4);	 Catch:{ Exception -> 0x01f9, all -> 0x0272 }
        r0 = "old_apk_location";
        r0 = r12.getString(r0);	 Catch:{ Exception -> 0x01f9, all -> 0x0272 }
        r4 = "new_apk_location";
        r4 = r12.getString(r4);	 Catch:{ Exception -> 0x01f9, all -> 0x0272 }
        r6 = "diff_file_location";
        r6 = r12.getString(r6);	 Catch:{ Exception -> 0x01f9, all -> 0x0272 }
        r7 = android.text.TextUtils.isEmpty(r0);	 Catch:{ Exception -> 0x01f9, all -> 0x0272 }
        if (r7 != 0) goto L_0x0118;
    L_0x0110:
        r7 = new java.io.File;	 Catch:{ Exception -> 0x01f9, all -> 0x0272 }
        r7.<init>(r0);	 Catch:{ Exception -> 0x01f9, all -> 0x0272 }
        com.tencent.smtt.utils.f.T(r7);	 Catch:{ Exception -> 0x01f9, all -> 0x0272 }
    L_0x0118:
        r0 = android.text.TextUtils.isEmpty(r4);	 Catch:{ Exception -> 0x01f9, all -> 0x0272 }
        if (r0 != 0) goto L_0x0126;
    L_0x011e:
        r0 = new java.io.File;	 Catch:{ Exception -> 0x01f9, all -> 0x0272 }
        r0.<init>(r4);	 Catch:{ Exception -> 0x01f9, all -> 0x0272 }
        com.tencent.smtt.utils.f.T(r0);	 Catch:{ Exception -> 0x01f9, all -> 0x0272 }
    L_0x0126:
        r0 = android.text.TextUtils.isEmpty(r6);	 Catch:{ Exception -> 0x01f9, all -> 0x0272 }
        if (r0 != 0) goto L_0x0134;
    L_0x012c:
        r0 = new java.io.File;	 Catch:{ Exception -> 0x01f9, all -> 0x0272 }
        r0.<init>(r6);	 Catch:{ Exception -> 0x01f9, all -> 0x0272 }
        com.tencent.smtt.utils.f.T(r0);	 Catch:{ Exception -> 0x01f9, all -> 0x0272 }
    L_0x0134:
        r0 = com.tencent.smtt.sdk.o.gI(r11);	 Catch:{ Exception -> 0x01f9, all -> 0x0272 }
        r0 = r0.Agx;	 Catch:{ Exception -> 0x01f9, all -> 0x0272 }
        r4 = "tbs_needdownload";
        r6 = 1;
        r6 = java.lang.Boolean.valueOf(r6);	 Catch:{ Exception -> 0x01f9, all -> 0x0272 }
        r0.put(r4, r6);	 Catch:{ Exception -> 0x01f9, all -> 0x0272 }
        r0 = com.tencent.smtt.sdk.o.gI(r11);	 Catch:{ Exception -> 0x01f9, all -> 0x0272 }
        r0.commit();	 Catch:{ Exception -> 0x01f9, all -> 0x0272 }
        r0 = com.tencent.smtt.sdk.v.hp(r11);	 Catch:{ Exception -> 0x01f9, all -> 0x0272 }
        r4 = 224; // 0xe0 float:3.14E-43 double:1.107E-321;
        r6 = "incrUpdate exceed retry max num";
        r0.bi(r4, r6);	 Catch:{ Exception -> 0x01f9, all -> 0x0272 }
        r0 = AgZ;
        r0.unlock();
        r10.cFB();
        r0 = "TbsInstaller";
        r1 = "TbsInstaller-installLocalTesCoreExInThread PATCH_NONEEDPATCH";
        com.tencent.smtt.utils.TbsLog.i(r0, r1);
        goto L_0x00bf;
    L_0x016b:
        r0 = r5;
        goto L_0x00da;
    L_0x016e:
        r4 = com.tencent.smtt.sdk.n.gH(r11);	 Catch:{ Exception -> 0x01f9, all -> 0x0272 }
        r6 = "incrupdate_retry_num";
        r0 = r0 + 1;
        r4.dK(r6, r0);	 Catch:{ Exception -> 0x01f9, all -> 0x0272 }
        r0 = hk(r11);	 Catch:{ Exception -> 0x01f9, all -> 0x0272 }
        if (r0 == 0) goto L_0x037a;
    L_0x0180:
        r4 = new java.io.File;	 Catch:{ Exception -> 0x01f9, all -> 0x0272 }
        r6 = "x5.tbs";
        r4.<init>(r0, r6);	 Catch:{ Exception -> 0x01f9, all -> 0x0272 }
        r0 = r4.exists();	 Catch:{ Exception -> 0x01f9, all -> 0x0272 }
        if (r0 == 0) goto L_0x037a;
    L_0x018e:
        r0 = com.tencent.smtt.sdk.o.gI(r11);	 Catch:{ Exception -> 0x01f9, all -> 0x0272 }
        r4 = -550; // 0xfffffffffffffdda float:NaN double:NaN;
        r0.In(r4);	 Catch:{ Exception -> 0x01f9, all -> 0x0272 }
        r1 = com.tencent.smtt.sdk.QbSdk.e(r11, r12);	 Catch:{ Exception -> 0x01f9, all -> 0x0272 }
        if (r1 != 0) goto L_0x01f1;
    L_0x019d:
        r0 = r3;
    L_0x019e:
        r4 = AgZ;
        r4.unlock();
        r10.cFB();
        if (r0 != 0) goto L_0x0323;
    L_0x01a8:
        r0 = "TbsInstaller";
        r2 = "TbsInstaller-installLocalTesCoreExInThread PATCH_SUCCESS";
        com.tencent.smtt.utils.TbsLog.i(r0, r2);
        r0 = com.tencent.smtt.sdk.n.gH(r11);
        r2 = "incrupdate_retry_num";
        r0.dK(r2, r5);
        r0 = com.tencent.smtt.sdk.o.gI(r11);
        r2 = -544; // 0xfffffffffffffde0 float:NaN double:NaN;
        r0.In(r2);
        r0 = com.tencent.smtt.sdk.n.gH(r11);
        r2 = -1;
        r0.fI(r5, r2);
        r0 = com.tencent.smtt.sdk.n.gH(r11);
        r2 = "incrupdate_status";
        r0.dK(r2, r3);
        r0 = "apk_path";
        r0 = r1.getString(r0);
        r2 = new java.io.File;
        r2.<init>(r0);
        com.tencent.smtt.sdk.l.a(r2, r11);
        r2 = "tbs_core_ver";
        r1 = r1.getInt(r2);
        r10.u(r11, r0, r1);
        goto L_0x00bf;
    L_0x01f1:
        r0 = "patch_result";
        r0 = r1.getInt(r0);	 Catch:{ Exception -> 0x01f9 }
        goto L_0x019e;
    L_0x01f9:
        r0 = move-exception;
        r4 = "TbsInstaller";
        r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0370 }
        r7 = "installLocalTbsCoreExInThread exception:";
        r6.<init>(r7);	 Catch:{ all -> 0x0370 }
        r7 = android.util.Log.getStackTraceString(r0);	 Catch:{ all -> 0x0370 }
        r6 = r6.append(r7);	 Catch:{ all -> 0x0370 }
        r6 = r6.toString();	 Catch:{ all -> 0x0370 }
        com.tencent.smtt.utils.TbsLog.i(r4, r6);	 Catch:{ all -> 0x0370 }
        r4 = com.tencent.smtt.sdk.o.gI(r11);	 Catch:{ all -> 0x0375 }
        r6 = -543; // 0xfffffffffffffde1 float:NaN double:NaN;
        r4.In(r6);	 Catch:{ all -> 0x0375 }
        r4 = com.tencent.smtt.sdk.v.hp(r11);	 Catch:{ all -> 0x0375 }
        r6 = 218; // 0xda float:3.05E-43 double:1.077E-321;
        r0 = r0.toString();	 Catch:{ all -> 0x0375 }
        r4.bi(r6, r0);	 Catch:{ all -> 0x0375 }
        r0 = AgZ;
        r0.unlock();
        r10.cFB();
        r0 = com.tencent.smtt.sdk.o.gI(r11);
        r0.In(r8);
        r0 = "TbsInstaller";
        r1 = "TbsInstaller-installLocalTesCoreExInThread PATCH_FAIL";
        com.tencent.smtt.utils.TbsLog.i(r0, r1);
        r0 = com.tencent.smtt.sdk.o.gI(r11);
        r0 = r0.Agx;
        r1 = "tbs_needdownload";
        r2 = java.lang.Boolean.valueOf(r3);
        r0.put(r1, r2);
        r0 = com.tencent.smtt.sdk.o.gI(r11);
        r0.commit();
        r0 = com.tencent.smtt.sdk.v.hp(r11);
        r1 = new java.lang.StringBuilder;
        r2 = "incrUpdate fail! patch ret=";
        r1.<init>(r2);
        r1 = r1.append(r3);
        r1 = r1.toString();
        r0.bi(r9, r1);
        goto L_0x00bf;
    L_0x0272:
        r0 = move-exception;
        r4 = r1;
        r1 = r2;
    L_0x0275:
        r6 = AgZ;
        r6.unlock();
        r10.cFB();
        if (r1 != 0) goto L_0x02d8;
    L_0x027f:
        r1 = "TbsInstaller";
        r2 = "TbsInstaller-installLocalTesCoreExInThread PATCH_SUCCESS";
        com.tencent.smtt.utils.TbsLog.i(r1, r2);
        r1 = com.tencent.smtt.sdk.n.gH(r11);
        r2 = "incrupdate_retry_num";
        r1.dK(r2, r5);
        r1 = com.tencent.smtt.sdk.o.gI(r11);
        r2 = -544; // 0xfffffffffffffde0 float:NaN double:NaN;
        r1.In(r2);
        r1 = com.tencent.smtt.sdk.n.gH(r11);
        r2 = -1;
        r1.fI(r5, r2);
        r1 = com.tencent.smtt.sdk.n.gH(r11);
        r2 = "incrupdate_status";
        r1.dK(r2, r3);
        r1 = "apk_path";
        r1 = r4.getString(r1);
        r2 = new java.io.File;
        r2.<init>(r1);
        com.tencent.smtt.sdk.l.a(r2, r11);
        r2 = "tbs_core_ver";
        r2 = r4.getInt(r2);
        r10.u(r11, r1, r2);
    L_0x02c6:
        com.tencent.smtt.sdk.QbSdk.setTBSInstallingStatus(r5);
        throw r0;
    L_0x02ca:
        r0 = com.tencent.smtt.sdk.o.gI(r11);
        r1 = -547; // 0xfffffffffffffddd float:NaN double:NaN;
        r0.In(r1);
        r10.cFB();
        goto L_0x0016;
    L_0x02d8:
        if (r1 != r2) goto L_0x02e4;
    L_0x02da:
        r1 = "TbsInstaller";
        r2 = "TbsInstaller-installLocalTesCoreExInThread PATCH_NONEEDPATCH";
        com.tencent.smtt.utils.TbsLog.i(r1, r2);
        goto L_0x02c6;
    L_0x02e4:
        r2 = com.tencent.smtt.sdk.o.gI(r11);
        r2.In(r8);
        r2 = "TbsInstaller";
        r4 = "TbsInstaller-installLocalTesCoreExInThread PATCH_FAIL";
        com.tencent.smtt.utils.TbsLog.i(r2, r4);
        r2 = com.tencent.smtt.sdk.o.gI(r11);
        r2 = r2.Agx;
        r4 = "tbs_needdownload";
        r3 = java.lang.Boolean.valueOf(r3);
        r2.put(r4, r3);
        r2 = com.tencent.smtt.sdk.o.gI(r11);
        r2.commit();
        r2 = com.tencent.smtt.sdk.v.hp(r11);
        r3 = new java.lang.StringBuilder;
        r4 = "incrUpdate fail! patch ret=";
        r3.<init>(r4);
        r1 = r3.append(r1);
        r1 = r1.toString();
        r2.bi(r9, r1);
        goto L_0x02c6;
    L_0x0323:
        if (r0 != r2) goto L_0x0330;
    L_0x0325:
        r0 = "TbsInstaller";
        r1 = "TbsInstaller-installLocalTesCoreExInThread PATCH_NONEEDPATCH";
        com.tencent.smtt.utils.TbsLog.i(r0, r1);
        goto L_0x00bf;
    L_0x0330:
        r1 = com.tencent.smtt.sdk.o.gI(r11);
        r1.In(r8);
        r1 = "TbsInstaller";
        r2 = "TbsInstaller-installLocalTesCoreExInThread PATCH_FAIL";
        com.tencent.smtt.utils.TbsLog.i(r1, r2);
        r1 = com.tencent.smtt.sdk.o.gI(r11);
        r1 = r1.Agx;
        r2 = "tbs_needdownload";
        r3 = java.lang.Boolean.valueOf(r3);
        r1.put(r2, r3);
        r1 = com.tencent.smtt.sdk.o.gI(r11);
        r1.commit();
        r1 = com.tencent.smtt.sdk.v.hp(r11);
        r2 = new java.lang.StringBuilder;
        r3 = "incrUpdate fail! patch ret=";
        r2.<init>(r3);
        r0 = r2.append(r0);
        r0 = r0.toString();
        r1.bi(r9, r0);
        goto L_0x00bf;
    L_0x0370:
        r0 = move-exception;
        r4 = r1;
        r1 = r2;
        goto L_0x0275;
    L_0x0375:
        r0 = move-exception;
        r4 = r1;
        r1 = r3;
        goto L_0x0275;
    L_0x037a:
        r0 = r2;
        goto L_0x019e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.t.f(android.content.Context, android.os.Bundle):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    final boolean gQ(android.content.Context r11) {
        /*
        r10 = this;
        r1 = 1;
        r2 = 0;
        r0 = hi(r11);
        r5 = new java.io.File;
        r3 = "tbs.conf";
        r5.<init>(r0, r3);
        r0 = r5.exists();
        if (r0 != 0) goto L_0x0015;
    L_0x0014:
        return r2;
    L_0x0015:
        r4 = new java.util.Properties;
        r4.<init>();
        r0 = 0;
        r6 = new java.io.FileInputStream;	 Catch:{ Throwable -> 0x007b, all -> 0x0086 }
        r6.<init>(r5);	 Catch:{ Throwable -> 0x007b, all -> 0x0086 }
        r3 = new java.io.BufferedInputStream;	 Catch:{ Throwable -> 0x007b, all -> 0x0086 }
        r3.<init>(r6);	 Catch:{ Throwable -> 0x007b, all -> 0x0086 }
        r4.load(r3);	 Catch:{ Throwable -> 0x0095, all -> 0x0093 }
        r0 = "tbs_local_installation";
        r6 = "false";
        r0 = r4.getProperty(r0, r6);	 Catch:{ Throwable -> 0x0095, all -> 0x0093 }
        r0 = java.lang.Boolean.valueOf(r0);	 Catch:{ Throwable -> 0x0095, all -> 0x0093 }
        r4 = r0.booleanValue();	 Catch:{ Throwable -> 0x0095, all -> 0x0093 }
        if (r4 == 0) goto L_0x009d;
    L_0x003c:
        r6 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x0099, all -> 0x0093 }
        r8 = r5.lastModified();	 Catch:{ Throwable -> 0x0099, all -> 0x0093 }
        r6 = r6 - r8;
        r8 = 259200000; // 0xf731400 float:1.1984677E-29 double:1.280618154E-315;
        r0 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r0 <= 0) goto L_0x0077;
    L_0x004c:
        r0 = r1;
    L_0x004d:
        r5 = "TbsInstaller";
        r6 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0099, all -> 0x0093 }
        r7 = "TBS_LOCAL_INSTALLATION is:";
        r6.<init>(r7);	 Catch:{ Throwable -> 0x0099, all -> 0x0093 }
        r6 = r6.append(r4);	 Catch:{ Throwable -> 0x0099, all -> 0x0093 }
        r7 = " expired=";
        r6 = r6.append(r7);	 Catch:{ Throwable -> 0x0099, all -> 0x0093 }
        r6 = r6.append(r0);	 Catch:{ Throwable -> 0x0099, all -> 0x0093 }
        r6 = r6.toString();	 Catch:{ Throwable -> 0x0099, all -> 0x0093 }
        com.tencent.smtt.utils.TbsLog.i(r5, r6);	 Catch:{ Throwable -> 0x0099, all -> 0x0093 }
        if (r0 != 0) goto L_0x0079;
    L_0x0070:
        r0 = r4 & r1;
        r3.close();	 Catch:{ IOException -> 0x008f }
    L_0x0075:
        r2 = r0;
        goto L_0x0014;
    L_0x0077:
        r0 = r2;
        goto L_0x004d;
    L_0x0079:
        r1 = r2;
        goto L_0x0070;
    L_0x007b:
        r1 = move-exception;
        r1 = r0;
        r0 = r2;
    L_0x007e:
        if (r1 == 0) goto L_0x0075;
    L_0x0080:
        r1.close();	 Catch:{ IOException -> 0x0084 }
        goto L_0x0075;
    L_0x0084:
        r1 = move-exception;
        goto L_0x0075;
    L_0x0086:
        r1 = move-exception;
        r3 = r0;
        r0 = r1;
    L_0x0089:
        if (r3 == 0) goto L_0x008e;
    L_0x008b:
        r3.close();	 Catch:{ IOException -> 0x0091 }
    L_0x008e:
        throw r0;
    L_0x008f:
        r1 = move-exception;
        goto L_0x0075;
    L_0x0091:
        r1 = move-exception;
        goto L_0x008e;
    L_0x0093:
        r0 = move-exception;
        goto L_0x0089;
    L_0x0095:
        r0 = move-exception;
        r1 = r3;
        r0 = r2;
        goto L_0x007e;
    L_0x0099:
        r0 = move-exception;
        r1 = r3;
        r0 = r4;
        goto L_0x007e;
    L_0x009d:
        r0 = r2;
        goto L_0x004d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.t.gQ(android.content.Context):boolean");
    }

    final int ha(Context context) {
        BufferedInputStream bufferedInputStream;
        String property;
        String str;
        Exception e;
        Throwable th;
        int i = 0;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            File file = new File(hi(context), "tbs.conf");
            if (file.exists()) {
                Properties properties = new Properties();
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                try {
                    properties.load(bufferedInputStream);
                    bufferedInputStream.close();
                    property = properties.getProperty("tbs_core_version");
                    if (property == null) {
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (IOException e2) {
                                str = "TbsInstaller";
                                property = "TbsInstaller--getTbsCoreInstalledVerInNolock IOException=" + e2.toString();
                            }
                        }
                        return i;
                    }
                    i = Integer.parseInt(property);
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e22) {
                            str = "TbsInstaller";
                            property = "TbsInstaller--getTbsCoreInstalledVerInNolock IOException=" + e22.toString();
                        }
                    }
                    return i;
                } catch (Exception e3) {
                    e = e3;
                }
            } else {
                if (bufferedInputStream2 != null) {
                    try {
                        bufferedInputStream2.close();
                    } catch (IOException e222) {
                        str = "TbsInstaller";
                        property = "TbsInstaller--getTbsCoreInstalledVerInNolock IOException=" + e222.toString();
                        TbsLog.i(str, property);
                        return i;
                    }
                }
                return i;
            }
        } catch (Exception e4) {
            e = e4;
            bufferedInputStream = bufferedInputStream2;
        } catch (Throwable th2) {
            th = th2;
            bufferedInputStream = bufferedInputStream2;
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (IOException e2222) {
                    TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerInNolock IOException=" + e2222.toString());
                }
            }
            throw th;
        }
        try {
            TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerInNolock Exception=" + e.toString());
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (IOException e22222) {
                    str = "TbsInstaller";
                    property = "TbsInstaller--getTbsCoreInstalledVerInNolock IOException=" + e22222.toString();
                }
            }
            return i;
        } catch (Throwable th3) {
            th = th3;
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            throw th;
        }
    }

    final boolean hb(Context context) {
        return new File(hi(context), "tbs.conf").exists();
    }

    final int hc(Context context) {
        BufferedInputStream bufferedInputStream;
        Exception e;
        Throwable th;
        if (!ho(context)) {
            return -1;
        }
        boolean tryLock = AgY.tryLock();
        TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVer locked=" + tryLock);
        if (tryLock) {
            BufferedInputStream bufferedInputStream2 = null;
            try {
                File file = new File(hi(context), "tbs.conf");
                if (file.exists()) {
                    Properties properties = new Properties();
                    bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                    try {
                        properties.load(bufferedInputStream);
                        bufferedInputStream.close();
                        String property = properties.getProperty("tbs_core_version");
                        if (property == null) {
                            if (bufferedInputStream != null) {
                                try {
                                    bufferedInputStream.close();
                                } catch (IOException e2) {
                                    TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVer IOException=" + e2.toString());
                                }
                            }
                            AgY.unlock();
                            cFB();
                            return 0;
                        }
                        Ahc.set(Integer.valueOf(Integer.parseInt(property)));
                        int intValue = ((Integer) Ahc.get()).intValue();
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (IOException e3) {
                                TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVer IOException=" + e3.toString());
                            }
                        }
                        AgY.unlock();
                        cFB();
                        return intValue;
                    } catch (Exception e4) {
                        e = e4;
                    }
                } else {
                    if (bufferedInputStream2 != null) {
                        try {
                            bufferedInputStream2.close();
                        } catch (IOException e22) {
                            TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVer IOException=" + e22.toString());
                        }
                    }
                    AgY.unlock();
                    cFB();
                    return 0;
                }
            } catch (Exception e5) {
                e = e5;
                bufferedInputStream = bufferedInputStream2;
            } catch (Throwable th2) {
                th = th2;
                bufferedInputStream = bufferedInputStream2;
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e32) {
                        TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVer IOException=" + e32.toString());
                    }
                }
                AgY.unlock();
                cFB();
                throw th;
            }
        }
        cFB();
        return 0;
        try {
            TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVer Exception=" + e.toString());
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (IOException e222) {
                    TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVer IOException=" + e222.toString());
                }
            }
            AgY.unlock();
            cFB();
            return 0;
        } catch (Throwable th3) {
            th = th3;
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            AgY.unlock();
            cFB();
            throw th;
        }
        AgY.unlock();
        cFB();
        return 0;
    }

    public final boolean he(Context context) {
        TbsLog.i("TbsInstaller", "TbsInstaller--coreShareCopyToDecouple #0");
        File hi = hi(context);
        File hh = hh(context);
        try {
            f.e(hh, true);
            f.a(hi, hh, new FileFilter() {
                public final boolean accept(File file) {
                    return !file.getName().endsWith(".dex");
                }
            });
            x.hr(context);
            TbsLog.i("TbsInstaller", "TbsInstaller--coreShareCopyToDecouple success!!!");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    final void w(Context context, boolean z) {
        boolean z2 = false;
        if (z) {
            this.Aha = true;
        }
        TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessName=" + context.getApplicationInfo().processName);
        TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessId=" + Process.myPid());
        StringBuilder stringBuilder = new StringBuilder("TbsInstaller-continueInstallTbsCore currentThreadName=");
        int name = Thread.currentThread().getName();
        String stringBuilder2 = stringBuilder.append(name).toString();
        TbsLog.i("TbsInstaller", stringBuilder2);
        if (ho(context)) {
            int abP;
            int abQ;
            int tryLock = AgY.tryLock();
            if (tryLock != 0) {
                try {
                    abP = n.gH(context).abP("install_status");
                    name = n.gH(context).abQ("install_core_ver");
                    stringBuilder2 = n.gH(context).getStringValue("install_apk_path");
                    abQ = n.gH(context).abQ("copy_core_ver");
                    tryLock = n.gH(context).abP("copy_status");
                } finally {
                    z2 = AgY;
                    z2.unlock();
                }
            } else {
                tryLock = -1;
                stringBuilder2 = null;
                name = 0;
                abP = -1;
                abQ = 0;
            }
            cFB();
            TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore installStatus=" + abP);
            TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore tbsCoreInstallVer=" + name);
            TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore tbsApkPath=" + stringBuilder2);
            TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore tbsCoreCopyVer=" + abQ);
            TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore copyStatus=" + tryLock);
            if (x.hs(context)) {
                abQ = x.cFP();
                TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreForThirdPartyApp");
                if (abQ > 0) {
                    int ha = ha(context);
                    if (ha == abQ) {
                        return;
                    }
                    if (x.cFJ() != null) {
                        TbsLog.i("TbsInstaller", "TbsInstaller--quickDexOptForThirdPartyApp hostContext != null");
                        a(context, null);
                        return;
                    } else if (ha <= 0) {
                        TbsLog.i("TbsInstaller", "TbsInstaller--installTbsCoreForThirdPartyApp hostContext == null");
                        QbSdk.bG(context, "TbsInstaller::installTbsCoreForThirdPartyApp forceSysWebViewInner #2");
                        return;
                    } else {
                        return;
                    }
                }
                return;
            }
            int i = o.gI(context).Agy.getInt("tbs_responsecode", z2);
            boolean z3 = (i == 1 || i == 2 || i == 4) ? true : z2;
            if (!(z3 || i == 0)) {
                new Bundle().putInt("operation", 10001);
                if (context != null) {
                    Object obj = new Object[]{context, r4};
                    Message message = new Message();
                    message.what = 3;
                    message.obj = obj;
                    Ahd.sendMessage(message);
                }
            }
            if (abP >= 0 && abP < 2) {
                t(context, stringBuilder2, name);
            }
            if (tryLock == 0) {
                ap(context, abQ);
            }
        }
    }

    final void x(Context context, boolean z) {
        if (!QbSdk.AeW) {
            if (VERSION.SDK_INT < 8) {
                TbsLog.e("TbsInstaller", "android version < 2.1 no need install X5 core", true);
                return;
            }
            try {
                if (!x.hs(context)) {
                    File hm = hm(context);
                    if (hm != null && hm.exists()) {
                        f.e(hm, false);
                        new File(hk(context), "x5.tbs").delete();
                    }
                }
            } catch (Throwable th) {
            }
            if (!gR(context)) {
                return;
            }
            if (bI(context, "core_unzip_tmp") && v(context, z)) {
                TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreIfNeeded, enableTbsCoreFromUnzip!!", true);
                return;
            }
            if (bI(context, "core_share_backup_tmp")) {
                cFz();
            }
            if (bI(context, "core_copy_tmp") && u(context, z)) {
                TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreIfNeeded, enableTbsCoreFromCopy!!", true);
            } else {
                TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreIfNeeded, error !!", true);
            }
        }
    }
}
