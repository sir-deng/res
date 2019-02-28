package com.tencent.mm.plugin.report.service;

import com.tencent.mars.smc.IDKey;
import com.tencent.mars.smc.SmcLogic;
import com.tencent.mm.plugin.report.b.a;
import com.tencent.mm.protocal.c.akq;
import com.tencent.mm.protocal.c.atb;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class d {
    private static Map<Long, Long> pWs;
    private static a pWt = new a();
    private static int pWu = -1;
    private static boolean pWv = false;

    public static void a(long j, String str, boolean z, boolean z2) {
        if (z2) {
            try {
                SmcLogic.writeImportKvData(j, str, z);
                return;
            } catch (Throwable e) {
                x.e("MicroMsg.KVEasyReport", "localReport :%s", bi.i(e));
                return;
            }
        }
        try {
            SmcLogic.writeKvData(j, str, z);
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.KVEasyReport", e2, "", new Object[0]);
            if (com.tencent.mm.compatible.util.d.fO(20)) {
                SmcLogic.writeKvData(j, str, z);
            }
        }
    }

    public static void a(long j, byte[] bArr, boolean z, boolean z2) {
        if (z2) {
            try {
                SmcLogic.writeImportKvPbData(j, bArr, z);
                return;
            } catch (Throwable e) {
                x.e("MicroMsg.KVEasyReport", "localReport :%s", bi.i(e));
                return;
            }
        }
        SmcLogic.writeKvPbData(j, bArr, z);
    }

    public static void b(long j, long j2, long j3, boolean z) {
        long j4 = j2;
        long j5 = j;
        do {
            int i;
            String str = "MicroMsg.KVEasyReport";
            String str2 = "SmcLogic.reportIDKey class loader %s, %s ";
            Object[] objArr = new Object[2];
            if (d.class.getClassLoader() == null) {
                i = -1;
            } else {
                i = d.class.getClassLoader().hashCode();
            }
            objArr[0] = Integer.valueOf(i);
            if (Thread.currentThread().getContextClassLoader() == null) {
                i = -1;
            } else {
                i = Thread.currentThread().getContextClassLoader().hashCode();
            }
            objArr[1] = Integer.valueOf(i);
            x.i(str, str2, objArr);
            try {
                SmcLogic.reportIDKey(j5, j4, j3, z);
            } catch (Throwable th) {
                x.printErrStackTrace("MicroMsg.KVEasyReport", th, "", new Object[0]);
                if (com.tencent.mm.compatible.util.d.fO(20)) {
                    SmcLogic.reportIDKey(j5, j4, j3, z);
                }
            }
            if (pWv) {
                if (pWs == null) {
                    boR();
                }
                j5 = bi.a((Long) pWs.get(Long.valueOf(j5)), 0);
            } else {
                return;
            }
        } while (j5 > 0);
    }

    public static void b(ArrayList<IDKey> arrayList, boolean z) {
        if (arrayList != null) {
            try {
                SmcLogic.reportListIDKey((IDKey[]) arrayList.toArray(new IDKey[arrayList.size()]), z);
            } catch (Throwable th) {
                x.printErrStackTrace("MicroMsg.KVEasyReport", th, "", new Object[0]);
                if (com.tencent.mm.compatible.util.d.fO(20)) {
                    SmcLogic.reportListIDKey((IDKey[]) arrayList.toArray(new IDKey[arrayList.size()]), z);
                }
            }
        }
    }

    public static void hI(boolean z) {
        x.i("MicroMsg.KVEasyReport", "summerhv setHeavyUser [%b %b], stack[%s]", Boolean.valueOf(pWv), Boolean.valueOf(z), bi.chl());
        pWv = z;
    }

    public static synchronized void boR() {
        synchronized (d.class) {
            if (pWs == null) {
                pWs = new HashMap(20);
            }
            akq boJ = a.boJ();
            if (!(boJ == null || boJ.wyx == pWu)) {
                pWu = boJ.wyx;
                pWs.clear();
                LinkedList linkedList = boJ.wyy;
                if (linkedList != null) {
                    Iterator it = linkedList.iterator();
                    while (it.hasNext()) {
                        atb atb = (atb) it.next();
                        pWs.put(new Long((long) atb.wHp), new Long((long) atb.wHq));
                    }
                }
            }
            x.i("MicroMsg.KVEasyReport", "summerhv reloadHeavyUserIDMap heavyUserIDMap[%d][%d][%s], stack[%s]", Integer.valueOf(pWu), Integer.valueOf(pWs.size()), pWs, bi.chl());
        }
    }
}
