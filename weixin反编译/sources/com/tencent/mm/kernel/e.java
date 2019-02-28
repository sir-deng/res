package com.tencent.mm.kernel;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Environment;
import android.os.StatFs;
import com.tencent.mm.a.g;
import com.tencent.mm.a.o;
import com.tencent.mm.bx.f;
import com.tencent.mm.bx.h;
import com.tencent.mm.bx.h.d;
import com.tencent.mm.compatible.e.l;
import com.tencent.mm.loader.stub.BaseBuildInfo;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.s;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.w;
import com.tencent.mm.y.bz;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import junit.framework.Assert;

public final class e {
    private static HashMap<Integer, d> gyG;
    public String cachePath;
    public final s gRO = CV();
    private com.tencent.mm.kernel.api.e gRP;
    public b gRQ = new b();
    b gRR = new b();
    public String gRS;
    public String gRT;
    public h gRU = null;
    public h gRV = null;
    public t gRW;
    be gRX;
    bi gRY;
    ConcurrentHashMap<Integer, String> gRZ;
    boolean gSa = false;
    bz gSb;
    ConcurrentHashMap<String, SharedPreferences> gSc = new ConcurrentHashMap();
    private long gSd = 0;
    private ag gSe = null;
    private volatile Boolean gSf = null;
    private a gSg = new a();
    private long gSh = 0;

    private class a implements Runnable {
        private a() {
        }

        /* synthetic */ a(e eVar, byte b) {
            this();
        }

        public final void run() {
            e.this.Dd();
        }
    }

    public static class c {
        public boolean gSl = false;
        public int gSm = 0;
    }

    static class b extends com.tencent.mm.cc.a<com.tencent.mm.bx.h.a> implements com.tencent.mm.bx.h.a {
        b() {
        }

        public final void Di() {
            a(new com.tencent.mm.cc.a.a<com.tencent.mm.bx.h.a>() {
                public final /* synthetic */ void az(Object obj) {
                    ((com.tencent.mm.bx.h.a) obj).Di();
                }
            });
        }

        public final void Dj() {
            a(new com.tencent.mm.cc.a.a<com.tencent.mm.bx.h.a>() {
                public final /* synthetic */ void az(Object obj) {
                    ((com.tencent.mm.bx.h.a) obj).Dj();
                }
            });
        }

        public final void Dk() {
            a(new com.tencent.mm.cc.a.a<com.tencent.mm.bx.h.a>() {
                public final /* synthetic */ void az(Object obj) {
                    ((com.tencent.mm.bx.h.a) obj).Dk();
                }
            });
        }
    }

    public e(com.tencent.mm.kernel.api.e eVar) {
        a.gQV.a(this.gRO);
        String str = w.hbv + "alphahold.ini";
        x.i("MMKernel.CoreStorage", "initialize dkalpha client:%x  isapha:%b %s", Integer.valueOf(com.tencent.mm.protocal.d.vHl), Boolean.valueOf(com.tencent.mm.protocal.d.vHo), str);
        if (com.tencent.mm.protocal.d.vHo || com.tencent.mm.protocal.d.vHp) {
            String value = com.tencent.mm.sdk.e.a.getValue(str, "noneedhold");
            int i = com.tencent.mm.protocal.d.vHl;
            try {
                i = Integer.decode(BaseBuildInfo.CLIENT_VERSION).intValue();
            } catch (Throwable th) {
            }
            if (!String.valueOf(i).equals(value)) {
                x.w("MMKernel.CoreStorage", "dkalpha version need  reset to DefaultAccount , hold it! client:%x  isapha:%b", Integer.valueOf(i), Boolean.valueOf(com.tencent.mm.protocal.d.vHo));
                a.Cr();
                com.tencent.mm.sdk.e.a.ah(str, "noneedhold", String.valueOf(i));
            }
        } else {
            com.tencent.mm.loader.stub.b.deleteFile(str);
        }
        this.gRS = Da();
        this.gRP = eVar;
    }

    private static s CV() {
        x.i("MMKernel.CoreStorage", "initialize packageInfo:%s version:%x", com.tencent.mm.sdk.platformtools.e.atw(), Integer.valueOf(com.tencent.mm.protocal.d.vHl));
        File file = new File(w.hbv);
        if (!file.exists()) {
            file.mkdirs();
        }
        s sVar = new s(w.hbv + "systemInfo.cfg");
        String str = (String) sVar.get(258);
        if (str != null) {
            l.yu().set(258, str);
        }
        try {
            StatFs statFs = new StatFs(com.tencent.mm.compatible.util.h.getDataDirectory().getPath());
            x.i("MMKernel.CoreStorage", "CheckData path[%s] blocksize:%d blockcount:%d availcount:%d", r0.getAbsolutePath(), Integer.valueOf(statFs.getBlockSize()), Integer.valueOf(statFs.getBlockCount()), Integer.valueOf(statFs.getAvailableBlocks()));
        } catch (Exception e) {
            x.e("MMKernel.CoreStorage", "check data size failed :%s", e.getMessage());
        }
        return sVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(com.tencent.mm.y.ag r15) {
        /*
        r14 = this;
        r12 = 0;
        r2 = 1;
        r1 = 0;
        if (r15 != 0) goto L_0x0010;
    L_0x0006:
        r0 = "MMKernel.CoreStorage";
        r2 = "tryDataTransfer, dataTransferFactory is null";
        com.tencent.mm.sdk.platformtools.x.e(r0, r2);
    L_0x000f:
        return r1;
    L_0x0010:
        r0 = r14.gRW;
        r3 = 14;
        r4 = 0;
        r0 = r0.get(r3, r4);
        r0 = (java.lang.Integer) r0;
        r3 = com.tencent.mm.sdk.platformtools.bi.e(r0);
        r0 = com.tencent.mm.protocal.d.vHl;
        r4 = "MMKernel.CoreStorage";
        r5 = new java.lang.StringBuilder;
        r6 = "tryDataTransfer, sVer = ";
        r5.<init>(r6);
        r5 = r5.append(r3);
        r6 = ", cVer = ";
        r5 = r5.append(r6);
        r5 = r5.append(r0);
        r5 = r5.toString();
        com.tencent.mm.sdk.platformtools.x.d(r4, r5);
        r4 = r15.getDataTransferList();
        if (r4 != 0) goto L_0x0052;
    L_0x0048:
        r0 = "MMKernel.CoreStorage";
        r2 = "tryDataTransfer, dataTransferList is null";
        com.tencent.mm.sdk.platformtools.x.e(r0, r2);
        goto L_0x000f;
    L_0x0052:
        r5 = com.tencent.mm.platformtools.r.ifF;
        if (r5 <= 0) goto L_0x0110;
    L_0x0056:
        r5 = com.tencent.mm.platformtools.r.ifG;
        if (r5 <= 0) goto L_0x0110;
    L_0x005a:
        r0 = "MMKernel.CoreStorage";
        r5 = "tryDataTransfer, force data transfer";
        com.tencent.mm.sdk.platformtools.x.w(r0, r5);
    L_0x0063:
        r0 = "MMKernel.CoreStorage";
        r5 = new java.lang.StringBuilder;
        r6 = "tryDataTransfer dataTransferList size = ";
        r5.<init>(r6);
        r6 = r4.size();
        r5 = r5.append(r6);
        r5 = r5.toString();
        com.tencent.mm.sdk.platformtools.x.d(r0, r5);
        r0 = "MMKernel.CoreStorage";
        r5 = new java.lang.StringBuilder;
        r6 = "tryDataTransfer, threadId = ";
        r5.<init>(r6);
        r6 = java.lang.Thread.currentThread();
        r6 = r6.getId();
        r5 = r5.append(r6);
        r6 = ", name = ";
        r5 = r5.append(r6);
        r6 = java.lang.Thread.currentThread();
        r6 = r6.getName();
        r5 = r5.append(r6);
        r5 = r5.toString();
        com.tencent.mm.sdk.platformtools.x.d(r0, r5);
        r0 = r14.gRU;
        r5 = java.lang.Thread.currentThread();
        r6 = r5.getId();
        r6 = r0.dA(r6);
        r4 = r4.iterator();	 Catch:{ Throwable -> 0x0103 }
    L_0x00c0:
        r0 = r4.hasNext();	 Catch:{ Throwable -> 0x0103 }
        if (r0 == 0) goto L_0x0166;
    L_0x00c6:
        r0 = r4.next();	 Catch:{ Throwable -> 0x0103 }
        r0 = (com.tencent.mm.y.af) r0;	 Catch:{ Throwable -> 0x0103 }
        r8 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x0103 }
        r0.transfer(r3);	 Catch:{ Throwable -> 0x0103 }
        r10 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x0103 }
        r8 = r10 - r8;
        r0.hhu = r8;	 Catch:{ Throwable -> 0x0103 }
        r5 = "MicroMsg.DataTransferBase";
        r8 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0103 }
        r9 = "doTransfer, timeConsumed = ";
        r8.<init>(r9);	 Catch:{ Throwable -> 0x0103 }
        r10 = r0.hhu;	 Catch:{ Throwable -> 0x0103 }
        r8 = r8.append(r10);	 Catch:{ Throwable -> 0x0103 }
        r9 = ", tag = ";
        r8 = r8.append(r9);	 Catch:{ Throwable -> 0x0103 }
        r0 = r0.getTag();	 Catch:{ Throwable -> 0x0103 }
        r0 = r8.append(r0);	 Catch:{ Throwable -> 0x0103 }
        r0 = r0.toString();	 Catch:{ Throwable -> 0x0103 }
        com.tencent.mm.sdk.platformtools.x.d(r5, r0);	 Catch:{ Throwable -> 0x0103 }
        goto L_0x00c0;
    L_0x0103:
        r0 = move-exception;
        throw r0;	 Catch:{ all -> 0x0105 }
    L_0x0105:
        r0 = move-exception;
        r1 = (r6 > r12 ? 1 : (r6 == r12 ? 0 : -1));
        if (r1 <= 0) goto L_0x010f;
    L_0x010a:
        r1 = r14.gRU;
        r1.fT(r6);
    L_0x010f:
        throw r0;
    L_0x0110:
        if (r3 != r0) goto L_0x0135;
    L_0x0112:
        r2 = "MMKernel.CoreStorage";
        r4 = new java.lang.StringBuilder;
        r5 = "tryDataTransfer, no need to transfer, sVer = ";
        r4.<init>(r5);
        r3 = r4.append(r3);
        r4 = ", cVer = ";
        r3 = r3.append(r4);
        r0 = r3.append(r0);
        r0 = r0.toString();
        com.tencent.mm.sdk.platformtools.x.i(r2, r0);
        goto L_0x000f;
    L_0x0135:
        r5 = r4.iterator();
        r0 = r1;
    L_0x013a:
        r6 = r5.hasNext();
        if (r6 == 0) goto L_0x014c;
    L_0x0140:
        r0 = r5.next();
        r0 = (com.tencent.mm.y.af) r0;
        r0 = r0.gO(r3);
        if (r0 == 0) goto L_0x013a;
    L_0x014c:
        r5 = "MMKernel.CoreStorage";
        r6 = new java.lang.StringBuilder;
        r7 = "tryDataTransfer, needTransfer = ";
        r6.<init>(r7);
        r6 = r6.append(r0);
        r6 = r6.toString();
        com.tencent.mm.sdk.platformtools.x.d(r5, r6);
        if (r0 != 0) goto L_0x0063;
    L_0x0164:
        goto L_0x000f;
    L_0x0166:
        r0 = com.tencent.mm.platformtools.r.ifF;	 Catch:{ Throwable -> 0x0103 }
        if (r0 == 0) goto L_0x0190;
    L_0x016a:
        r0 = com.tencent.mm.platformtools.r.ifG;	 Catch:{ Throwable -> 0x0103 }
        if (r0 == 0) goto L_0x0190;
    L_0x016e:
        r0 = com.tencent.mm.platformtools.r.ifF;	 Catch:{ Throwable -> 0x0103 }
        if (r1 >= r0) goto L_0x0190;
    L_0x0172:
        r0 = com.tencent.mm.platformtools.r.ifG;	 Catch:{ InterruptedException -> 0x017b }
        r4 = (long) r0;	 Catch:{ InterruptedException -> 0x017b }
        java.lang.Thread.sleep(r4);	 Catch:{ InterruptedException -> 0x017b }
    L_0x0178:
        r1 = r1 + 1;
        goto L_0x016e;
    L_0x017b:
        r0 = move-exception;
        r3 = "MMKernel.CoreStorage";
        r4 = "exception:%s";
        r5 = 1;
        r5 = new java.lang.Object[r5];	 Catch:{ Throwable -> 0x0103 }
        r8 = 0;
        r0 = com.tencent.mm.sdk.platformtools.bi.i(r0);	 Catch:{ Throwable -> 0x0103 }
        r5[r8] = r0;	 Catch:{ Throwable -> 0x0103 }
        com.tencent.mm.sdk.platformtools.x.e(r3, r4, r5);	 Catch:{ Throwable -> 0x0103 }
        goto L_0x0178;
    L_0x0190:
        r0 = (r6 > r12 ? 1 : (r6 == r12 ? 0 : -1));
        if (r0 <= 0) goto L_0x0199;
    L_0x0194:
        r0 = r14.gRU;
        r0.fT(r6);
    L_0x0199:
        r1 = r2;
        goto L_0x000f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.kernel.e.a(com.tencent.mm.y.ag):boolean");
    }

    final void CW() {
        com.tencent.mm.kernel.a.c.DA().fP(this.gRT);
        File file = new File(this.gRT + ".nomedia");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Throwable e) {
                x.e("MMKernel.CoreStorage", "exception:%s", com.tencent.mm.sdk.platformtools.bi.i(e));
            }
        }
    }

    final void fM(String str) {
        File file = new File(str + "-recovery");
        if (file.isFile()) {
            x.i("MMKernel.CoreStorage", "Recovery database found, replace original one.");
            new File(str + ".ini").delete();
            File file2 = new File(str);
            file2.delete();
            if (!file.renameTo(file2)) {
                x.e("MMKernel.CoreStorage", "Rename database file failed!");
            }
        }
        final String name = file.getName();
        File[] listFiles = file.getParentFile().listFiles(new FilenameFilter() {
            public final boolean accept(File file, String str) {
                return str.startsWith(name) && !str.equals(name);
            }
        });
        if (listFiles != null) {
            for (File file3 : listFiles) {
                x.i("MMKernel.CoreStorage", "Delete temporary recovery database file: " + file3.getName());
                file3.delete();
            }
        }
    }

    public final boolean a(f fVar, HashMap<Integer, d> hashMap) {
        String str = "MMKernel.CoreStorage";
        String str2 = "createtables %d %s";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(hashMap == null ? -1 : hashMap.size());
        objArr[1] = Boolean.valueOf(false);
        x.i(str, str2, objArr);
        com.tencent.mm.compatible.util.g.a aVar = new com.tencent.mm.compatible.util.g.a();
        if (hashMap != null && hashMap.size() > 0) {
            int i = 0;
            for (Entry entry : hashMap.entrySet()) {
                int intValue;
                Integer num = (Integer) entry.getKey();
                d dVar = (d) entry.getValue();
                str = null;
                if (!this.gSa) {
                    StringBuilder stringBuilder = new StringBuilder();
                    for (String hashCode : dVar.wn()) {
                        stringBuilder.append(hashCode.hashCode());
                    }
                    String s = g.s(stringBuilder.toString().getBytes());
                    if (this.gRZ != null) {
                        str = (String) this.gRZ.get(num);
                        x.d("MMKernel.CoreStorage", "Create tables on %s(%s) compare with %s, using table versions", num, str, s);
                        if (str == null || !s.equals(str)) {
                            str = s;
                        }
                    } else {
                        if (this.gRY != null) {
                            bh bhVar = null;
                            Cursor rawQuery = this.gRY.rawQuery("select * from TablesVersion where tableHash = " + num.intValue(), new String[0]);
                            if (rawQuery != null) {
                                if (rawQuery.moveToFirst()) {
                                    bhVar = new bh();
                                    bhVar.b(rawQuery);
                                }
                                rawQuery.close();
                            }
                            Object obj = bhVar == null ? null : bhVar.field_tableSQLMD5;
                            x.d("MMKernel.CoreStorage", "Create tables on %s(%s) compare with %s, using table versions storage", num, obj, s);
                            if (obj != null && s.equals(obj)) {
                            }
                        }
                        str = s;
                    }
                }
                fVar.beginTransaction();
                int i2 = i;
                for (String str3 : dVar.wn()) {
                    try {
                        fVar.execSQL(str3);
                        i2++;
                    } catch (Exception e) {
                        Matcher matcher = com.tencent.mm.bx.a.xJm.matcher(str3);
                        if (matcher == null || !matcher.matches()) {
                            x.w("MMKernel.CoreStorage", "CreateTable failed:[" + str3 + "][" + e.getMessage() + "]");
                        } else {
                            Assert.assertTrue("CreateTable failed:[" + str3 + "][" + e.getMessage() + "]", false);
                        }
                    }
                }
                fVar.endTransaction();
                if (!(this.gSa || this.gRY == null || str == null)) {
                    bi biVar = this.gRY;
                    intValue = num.intValue();
                    Assert.assertTrue(intValue != 0);
                    Assert.assertNotNull(str);
                    bh bhVar2 = new bh();
                    bhVar2.field_tableHash = intValue;
                    bhVar2.field_tableSQLMD5 = str;
                    biVar.hiZ.replace("TablesVersion", "tableHash", bhVar2.vP());
                    if (!(this.gRZ == null || str == null)) {
                        this.gRZ.put(num, str);
                    }
                }
                i = i2;
            }
            x.i("MMKernel.CoreStorage", "createtables end sql:%d trans:%d sqlCount:%d", Long.valueOf(aVar.zp()), Long.valueOf(aVar.zp()), Integer.valueOf(i));
        }
        return true;
    }

    public final String CX() {
        File file = new File(this.cachePath + "/ctest", "EnMicroMsg.db");
        if (file.isFile()) {
            return file.getAbsolutePath();
        }
        file = new File(this.cachePath + "/corrupted", "EnMicroMsg.db");
        if (file.isFile()) {
            return file.getAbsolutePath();
        }
        String[] list = new File(this.cachePath).list(new FilenameFilter() {
            public final boolean accept(File file, String str) {
                return str.startsWith("EnMicroMsg.dberr");
            }
        });
        if (list == null || list.length <= 0) {
            return null;
        }
        String str = list[0];
        for (int i = 1; i < list.length; i++) {
            String str2 = list[i];
            if (str2.compareTo(str) > 0) {
                str = str2;
            }
        }
        return this.cachePath + '/' + str;
    }

    public final void ed(String str) {
        if (this.gRV != null) {
            this.gRV.EZ();
        }
        if (this.gRU != null) {
            this.gRU.ed(str);
        }
        this.gRP.onDataBaseClosed(this.gRU, this.gRV);
        this.gSa = false;
    }

    public final String CY() {
        return this.cachePath + "MicroMsg.db";
    }

    public final String CZ() {
        return this.cachePath + "EnMicroMsg.db";
    }

    public final SharedPreferences fN(String str) {
        g.Dr();
        g.Do();
        int Cn = a.Cn();
        if (Cn == 0) {
            return null;
        }
        if (this.gSc.containsKey(str)) {
            return (SharedPreferences) this.gSc.get(str);
        }
        try {
            String str2 = ad.getContext().getFilesDir().getParent() + "/shared_prefs/";
            String str3 = ad.cgf() + str + Cn + ".xml";
            String str4 = ad.cgf() + str + Cn + ".xml.bak";
            File file = new File(str2 + str3);
            if (file.exists()) {
                file.delete();
            }
            File file2 = new File(str2 + str4);
            if (file2.exists()) {
                file2.delete();
            }
        } catch (Exception e) {
        }
        SharedPreferences sharedPreferences = ad.getContext().getSharedPreferences(ad.cgf() + str + ac.VF(Cn + ac.VF(String.valueOf(Cn / 2))), 0);
        this.gSc.put(str, sharedPreferences);
        return sharedPreferences;
    }

    private static String Da() {
        String str = w.hbv;
        File file = new File(com.tencent.mm.compatible.util.e.bnD);
        x.i("MMKernel.CoreStorage", "summer buildSysPath sysPath[" + str + "] SDCARD_ROOT[" + com.tencent.mm.compatible.util.e.bnD + "] file.exists:" + file.exists() + " CUtil.isSDCardAvail():" + com.tencent.mm.compatible.util.f.zl());
        if (file.exists() && com.tencent.mm.compatible.util.f.zl()) {
            if (bS(com.tencent.mm.compatible.util.e.bnF)) {
                str = com.tencent.mm.compatible.util.e.bnF;
            }
            file = new File(com.tencent.mm.compatible.util.e.gJf);
            if (!file.exists()) {
                file.mkdirs();
            }
            file = new File(com.tencent.mm.compatible.util.e.gJg);
            if (!file.exists()) {
                file.mkdirs();
            }
            file = new File(com.tencent.mm.compatible.util.e.gJh);
            if (!file.exists()) {
                file.mkdirs();
            }
            file = new File(com.tencent.mm.compatible.util.e.gJi);
            if (!file.exists()) {
                file.mkdirs();
            }
            file = new File(com.tencent.mm.compatible.util.e.gJg + ".nomedia");
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (Throwable e) {
                    x.e("MMKernel.CoreStorage", "exception:%s", com.tencent.mm.sdk.platformtools.bi.i(e));
                }
            }
        }
        file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        x.i("MMKernel.CoreStorage", "summer buildSysPath ret sysPath: " + str);
        return str;
    }

    private static final boolean bS(String str) {
        if (com.tencent.mm.sdk.platformtools.bi.oN(str)) {
            x.i("MMKernel.CoreStorage", "forceMkdirs absolutePath isNullOrNil ret false");
            return false;
        }
        File file = new File(str);
        x.i("MMKernel.CoreStorage", "forceMkdirs absolutePath[%s], f.exists[%b], f.isDirectory[%b]", str, Boolean.valueOf(file.exists()), Boolean.valueOf(file.isDirectory()));
        if (file.exists() && file.isDirectory()) {
            x.i("MMKernel.CoreStorage", "forceMkdirs f is dir and exist ret true");
            return true;
        }
        String[] split = str.split("/");
        if (split == null || split.length < 2) {
            x.i("MMKernel.CoreStorage", "forceMkdirs absolutePath arr len illegal ret false");
            return false;
        }
        String str2 = "/";
        x.i("MMKernel.CoreStorage", "forceMkdirs absolutePath arr len: " + split.length);
        for (int i = 0; i < split.length; i++) {
            if (!com.tencent.mm.sdk.platformtools.bi.oN(split[i])) {
                str2 = str2 + "/" + split[i];
                File file2 = new File(str2);
                if (file2.isFile() && !file2.renameTo(new File(str2 + "_mmbak"))) {
                    x.i("MMKernel.CoreStorage", "forceMkdirs renameTo false ret false file[%s]", file2.getName());
                    return false;
                } else if (!(file2.exists() || file2.mkdir())) {
                    x.i("MMKernel.CoreStorage", "forceMkdirs mkdir false ret false file[%s]", file2.getName());
                    return false;
                }
            }
        }
        x.i("MMKernel.CoreStorage", "forceMkdirs false ret true");
        return true;
    }

    public final t Db() {
        g.Dr();
        g.Do().CA();
        return this.gRW;
    }

    public final be Dc() {
        g.Dr();
        g.Do().CA();
        return this.gRX;
    }

    public final void Dd() {
        this.gSf = Boolean.valueOf(isSDCardAvailable());
    }

    public final boolean De() {
        if (this.gSf == null) {
            this.gSf = Boolean.valueOf(isSDCardAvailable());
        } else {
            long currentTimeMillis = System.currentTimeMillis() - this.gSh;
            if (currentTimeMillis <= 0 || currentTimeMillis >= 1000) {
                if (this.gSe == null) {
                    this.gSe = new ag(g.Dt().oFY.getLooper());
                }
                this.gSe.removeCallbacksAndMessages(null);
                this.gSe.postDelayed(this.gSg, 1000);
                this.gSh = System.currentTimeMillis();
            }
        }
        return this.gSf.booleanValue();
    }

    public final boolean isSDCardAvailable() {
        boolean startsWith = this.gRS.startsWith(com.tencent.mm.compatible.util.e.bnD);
        long Wy = com.tencent.mm.sdk.platformtools.bi.Wy();
        long j = Wy - this.gSd;
        if (startsWith) {
            g.Dr();
            if (g.Do().CF() && j > 0 && j < 1000 && new File(this.gRS).exists()) {
                return true;
            }
        }
        this.gSd = Wy;
        boolean zl = com.tencent.mm.compatible.util.f.zl();
        r8 = new Object[6];
        g.Dr();
        g.Do();
        r8[1] = o.getString(a.Cn());
        r8[2] = Long.valueOf(j);
        r8[3] = this.gRS;
        r8[4] = com.tencent.mm.compatible.util.e.bnD;
        r8[5] = Boolean.valueOf(g.Do().CF());
        x.i("MMKernel.CoreStorage", "isSDCardAvail:%b uin:%s toNow:%d sysPath:[%s] sdRoot:[%s], acc init:[%b]", r8);
        if (!zl) {
            return false;
        }
        if (startsWith) {
            return true;
        }
        g.Dr();
        if (!g.Do().CF()) {
            return true;
        }
        x.i("MMKernel.CoreStorage", "summer isSDCardAvailable accHasReady and remount");
        Df();
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void Df() {
        /*
        r7 = this;
        com.tencent.mm.kernel.g.Dr();
        r0 = com.tencent.mm.kernel.g.Do();
        r1 = r0.gQU;
        monitor-enter(r1);
        r0 = Da();	 Catch:{ all -> 0x009c }
        r2 = "MMKernel.CoreStorage";
        r3 = "remount begin uin:%d oldpath:[%s] newPath:[%s] init:[%b]";
        r4 = 4;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x009c }
        r5 = 0;
        r6 = com.tencent.mm.kernel.a.Cn();	 Catch:{ all -> 0x009c }
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ all -> 0x009c }
        r4[r5] = r6;	 Catch:{ all -> 0x009c }
        r5 = 1;
        r6 = r7.gRS;	 Catch:{ all -> 0x009c }
        r4[r5] = r6;	 Catch:{ all -> 0x009c }
        r5 = 2;
        r4[r5] = r0;	 Catch:{ all -> 0x009c }
        r5 = 3;
        r6 = com.tencent.mm.kernel.g.Do();	 Catch:{ all -> 0x009c }
        r6 = r6.CF();	 Catch:{ all -> 0x009c }
        r6 = java.lang.Boolean.valueOf(r6);	 Catch:{ all -> 0x009c }
        r4[r5] = r6;	 Catch:{ all -> 0x009c }
        com.tencent.mm.sdk.platformtools.x.i(r2, r3, r4);	 Catch:{ all -> 0x009c }
        r2 = com.tencent.mm.sdk.platformtools.bi.oN(r0);	 Catch:{ all -> 0x009c }
        if (r2 != 0) goto L_0x0142;
    L_0x0042:
        r2 = r7.gRS;	 Catch:{ all -> 0x009c }
        r2 = r0.equalsIgnoreCase(r2);	 Catch:{ all -> 0x009c }
        if (r2 == 0) goto L_0x00bb;
    L_0x004a:
        r0 = "MMKernel.CoreStorage";
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0080 }
        r3 = "testSdcardWritable done ret:";
        r2.<init>(r3);	 Catch:{ Exception -> 0x0080 }
        r3 = Dg();	 Catch:{ Exception -> 0x0080 }
        r2 = r2.append(r3);	 Catch:{ Exception -> 0x0080 }
        r2 = r2.toString();	 Catch:{ Exception -> 0x0080 }
        com.tencent.mm.sdk.platformtools.x.i(r0, r2);	 Catch:{ Exception -> 0x0080 }
    L_0x0064:
        r0 = "MMKernel.CoreStorage";
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x009f }
        r3 = "testSdcardReadable done ret:";
        r2.<init>(r3);	 Catch:{ Exception -> 0x009f }
        r3 = Dh();	 Catch:{ Exception -> 0x009f }
        r2 = r2.append(r3);	 Catch:{ Exception -> 0x009f }
        r2 = r2.toString();	 Catch:{ Exception -> 0x009f }
        com.tencent.mm.sdk.platformtools.x.i(r0, r2);	 Catch:{ Exception -> 0x009f }
    L_0x007e:
        monitor-exit(r1);	 Catch:{ all -> 0x009c }
    L_0x007f:
        return;
    L_0x0080:
        r0 = move-exception;
        r2 = "MMKernel.CoreStorage";
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x009c }
        r4 = "testSdcardWritable Exception e: ";
        r3.<init>(r4);	 Catch:{ all -> 0x009c }
        r0 = r0.getMessage();	 Catch:{ all -> 0x009c }
        r0 = r3.append(r0);	 Catch:{ all -> 0x009c }
        r0 = r0.toString();	 Catch:{ all -> 0x009c }
        com.tencent.mm.sdk.platformtools.x.w(r2, r0);	 Catch:{ all -> 0x009c }
        goto L_0x0064;
    L_0x009c:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x009c }
        throw r0;
    L_0x009f:
        r0 = move-exception;
        r2 = "MMKernel.CoreStorage";
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x009c }
        r4 = "testSdcardReadable Exception e: ";
        r3.<init>(r4);	 Catch:{ all -> 0x009c }
        r0 = r0.getMessage();	 Catch:{ all -> 0x009c }
        r0 = r3.append(r0);	 Catch:{ all -> 0x009c }
        r0 = r0.toString();	 Catch:{ all -> 0x009c }
        com.tencent.mm.sdk.platformtools.x.w(r2, r0);	 Catch:{ all -> 0x009c }
        goto L_0x007e;
    L_0x00bb:
        r2 = "MMKernel.CoreStorage";
        r3 = "remount resetSysPath sysPath:[%s] newSysPath:[%s] accPath:[%s] cachePath: [%s]";
        r4 = 4;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x009c }
        r5 = 0;
        r6 = r7.gRS;	 Catch:{ all -> 0x009c }
        r4[r5] = r6;	 Catch:{ all -> 0x009c }
        r5 = 1;
        r4[r5] = r0;	 Catch:{ all -> 0x009c }
        r5 = 2;
        r6 = r7.gRT;	 Catch:{ all -> 0x009c }
        r4[r5] = r6;	 Catch:{ all -> 0x009c }
        r5 = 3;
        r6 = r7.cachePath;	 Catch:{ all -> 0x009c }
        r4[r5] = r6;	 Catch:{ all -> 0x009c }
        com.tencent.mm.sdk.platformtools.x.i(r2, r3, r4);	 Catch:{ all -> 0x009c }
        r2 = com.tencent.mm.sdk.platformtools.bi.oN(r0);	 Catch:{ all -> 0x009c }
        if (r2 != 0) goto L_0x0122;
    L_0x00df:
        r7.gRS = r0;	 Catch:{ all -> 0x009c }
        r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x009c }
        r2 = "mm";
        r0.<init>(r2);	 Catch:{ all -> 0x009c }
        com.tencent.mm.kernel.g.Dr();	 Catch:{ all -> 0x009c }
        com.tencent.mm.kernel.g.Do();	 Catch:{ all -> 0x009c }
        r2 = com.tencent.mm.kernel.a.Cn();	 Catch:{ all -> 0x009c }
        r0 = r0.append(r2);	 Catch:{ all -> 0x009c }
        r0 = r0.toString();	 Catch:{ all -> 0x009c }
        r0 = r0.getBytes();	 Catch:{ all -> 0x009c }
        r0 = com.tencent.mm.a.g.s(r0);	 Catch:{ all -> 0x009c }
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x009c }
        r2.<init>();	 Catch:{ all -> 0x009c }
        r3 = r7.gRS;	 Catch:{ all -> 0x009c }
        r2 = r2.append(r3);	 Catch:{ all -> 0x009c }
        r0 = r2.append(r0);	 Catch:{ all -> 0x009c }
        r2 = "/";
        r0 = r0.append(r2);	 Catch:{ all -> 0x009c }
        r0 = r0.toString();	 Catch:{ all -> 0x009c }
        r7.gRT = r0;	 Catch:{ all -> 0x009c }
        r7.CW();	 Catch:{ all -> 0x009c }
    L_0x0122:
        r0 = com.tencent.mm.kernel.a.c.DA();	 Catch:{ all -> 0x009c }
        r0 = r0.gTc;	 Catch:{ all -> 0x009c }
        r0.Dw();	 Catch:{ all -> 0x009c }
        r0 = "MMKernel.CoreStorage";
        r2 = "remout isSDCardAvail :[%b] done";
        r3 = 1;
        r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x009c }
        r4 = 0;
        r5 = com.tencent.mm.compatible.util.f.zl();	 Catch:{ all -> 0x009c }
        r5 = java.lang.Boolean.valueOf(r5);	 Catch:{ all -> 0x009c }
        r3[r4] = r5;	 Catch:{ all -> 0x009c }
        com.tencent.mm.sdk.platformtools.x.i(r0, r2, r3);	 Catch:{ all -> 0x009c }
    L_0x0142:
        monitor-exit(r1);	 Catch:{ all -> 0x009c }
        goto L_0x007f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.kernel.e.Df():void");
    }

    private static boolean Dg() {
        boolean canWrite;
        Exception e;
        Throwable th;
        boolean z = false;
        String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        boolean equalsIgnoreCase = com.tencent.mm.compatible.util.e.bnD.equalsIgnoreCase(absolutePath);
        boolean equals = Environment.getExternalStorageState().equals("mounted");
        try {
            canWrite = new File(Environment.getExternalStorageDirectory().getAbsolutePath()).canWrite();
        } catch (Exception e2) {
            x.w("MMKernel.CoreStorage", "testSdcardWritable 1 e: " + e2.getMessage());
            canWrite = false;
        }
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath(), "test_writable");
        FileOutputStream fileOutputStream;
        try {
            file.createNewFile();
            fileOutputStream = new FileOutputStream(file);
            try {
                fileOutputStream.write("test".getBytes());
                fileOutputStream.flush();
                fileOutputStream.close();
                boolean delete = file.delete();
                try {
                    fileOutputStream.close();
                    z = delete;
                } catch (Throwable e3) {
                    x.e("MMKernel.CoreStorage", "exception:%s", com.tencent.mm.sdk.platformtools.bi.i(e3));
                    z = delete;
                }
            } catch (Exception e4) {
                e = e4;
            }
        } catch (Exception e5) {
            e = e5;
            fileOutputStream = null;
            try {
                x.w("MMKernel.CoreStorage", "testSdcardWritable 2 e: " + e.getMessage());
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Throwable e6) {
                        x.e("MMKernel.CoreStorage", "exception:%s", com.tencent.mm.sdk.platformtools.bi.i(e6));
                    }
                }
                x.i("MMKernel.CoreStorage", "testSdcardWritable primaryExtStg: " + absolutePath + " CConstants.SDCARD_ROOT: " + com.tencent.mm.compatible.util.e.bnD + " isPrimaryExtStg: " + equalsIgnoreCase + " mounted: " + equals + " canWrite: " + canWrite + " canTrueWrite:" + z);
                return z;
            } catch (Throwable th2) {
                th = th2;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Throwable e62) {
                        x.e("MMKernel.CoreStorage", "exception:%s", com.tencent.mm.sdk.platformtools.bi.i(e62));
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw th;
        }
        x.i("MMKernel.CoreStorage", "testSdcardWritable primaryExtStg: " + absolutePath + " CConstants.SDCARD_ROOT: " + com.tencent.mm.compatible.util.e.bnD + " isPrimaryExtStg: " + equalsIgnoreCase + " mounted: " + equals + " canWrite: " + canWrite + " canTrueWrite:" + z);
        return z;
    }

    private static boolean Dh() {
        boolean canRead;
        String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        boolean equalsIgnoreCase = com.tencent.mm.compatible.util.e.bnD.equalsIgnoreCase(absolutePath);
        boolean equals = Environment.getExternalStorageState().equals("mounted");
        try {
            canRead = new File(Environment.getExternalStorageDirectory().getAbsolutePath()).canRead();
        } catch (Exception e) {
            Exception exception = e;
            canRead = false;
            x.w("MMKernel.CoreStorage", "testSdcardReadable 1 e: " + exception.getMessage());
        }
        File file = new File(com.tencent.mm.compatible.util.e.bnF);
        boolean exists = file.exists();
        if (exists) {
            x.i("MMKernel.CoreStorage", "testSdcardReadable testFile isDirectory:" + file.isDirectory() + " isFile:" + file.isFile());
        }
        x.i("MMKernel.CoreStorage", "testSdcardWritable primaryExtStg: " + absolutePath + " CConstants.SDCARD_ROOT: " + com.tencent.mm.compatible.util.e.bnD + " CConstants.DATAROOT_SDCARD_PATH: " + com.tencent.mm.compatible.util.e.bnF + " isPrimaryExtStg: " + equalsIgnoreCase + " mounted: " + equals + " canRead: " + canRead + " canTrueRead:" + exists);
        return exists;
    }

    static {
        HashMap hashMap = new HashMap();
        gyG = hashMap;
        hashMap.put(Integer.valueOf("CONFIG_TABLE".hashCode()), new d() {
            public final String[] wn() {
                return t.gLy;
            }
        });
        gyG.put(Integer.valueOf("TablesVersion".hashCode()), new d() {
            public final String[] wn() {
                return bi.gLy;
            }
        });
    }

    static HashMap<Integer, d> Bu() {
        HashMap<Integer, d> hashMap = new HashMap();
        hashMap.putAll(gyG);
        return hashMap;
    }
}
