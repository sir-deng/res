package com.tencent.mm.bx;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.repair.DBDumpUtil;
import com.tencent.wcdb.repair.DBDumpUtil.ExecuteSqlCallback;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public class h implements com.tencent.mm.sdk.e.e {
    String TAG = "MicroMsg.SqliteDB";
    public int field_MARK_CURSOR_CHECK_IGNORE = 1;
    private long kqa = 0;
    private a xJP = null;
    public a xJQ = new a();
    private String xJR = "";
    public e xJS = null;
    public String xJT = "";
    final LinkedList<b> xJU = new LinkedList();
    private ag xJV = null;
    protected f xJn = null;

    public interface a {
        void Di();

        void Dj();

        void Dk();
    }

    public static class b {
        public long lastReportTime;
        public Cursor xJZ;
        public String xKa;
        public long xKb;
        public boolean xKc;
        public String xKd;
        public c xKe;
        public String xrW;
    }

    private static class c extends AssertionError {
        c() {
        }

        c(String str) {
            super(str);
        }
    }

    public interface d {
        String[] wn();
    }

    public interface e {
        void Dl();
    }

    public h(a aVar) {
        this.xJP = aVar;
    }

    protected void finalize() {
        ed(null);
    }

    public void EZ() {
        ed(null);
    }

    public void ed(String str) {
        if (this.xJn != null) {
            if (this.xJP != null) {
                this.xJP.Di();
            }
            x.w(this.TAG, "begin close db, inTrans:%b ticket:%s  thr:%d {%s}", Boolean.valueOf(inTransaction()), Long.toHexString(this.kqa), Long.valueOf(Thread.currentThread().getId()), bi.chl());
            com.tencent.mm.compatible.util.g.a aVar = new com.tencent.mm.compatible.util.g.a();
            if (str != null) {
                this.xJR = str;
            }
            this.xJn.close();
            this.xJn = null;
            x.d(this.TAG, "end close db time:%d", Long.valueOf(aVar.zp()));
        }
    }

    public final boolean chz() {
        return this.xJn == null || !this.xJn.isOpen();
    }

    private void YO(String str) {
        String By = ad.By();
        String packageName = ad.getPackageName();
        x.i(this.TAG, "check process :[%s] [%s] path[%s]", By, packageName, str);
        if (By != null && packageName != null && !packageName.equals(By)) {
            Assert.assertTrue("processName:" + By + "  packagename:" + packageName, false);
        }
    }

    public final boolean b(String str, HashMap<Integer, d> hashMap, boolean z, boolean z2) {
        int lastIndexOf = str.lastIndexOf("/");
        if (lastIndexOf != -1) {
            this.TAG += "." + str.substring(lastIndexOf + 1);
        }
        YO(str);
        if (!this.xJQ.a(str, hashMap, true, z2) || this.xJQ.xJn == null) {
            this.xJn = null;
            this.xJQ = null;
            x.e(this.TAG, "initDB failed.");
            return false;
        }
        this.xJn = this.xJQ.xJn;
        x.i(this.TAG, "SqliteDB db %s", this.xJn);
        return true;
    }

    public final boolean a(String str, String str2, String str3, long j, String str4, HashMap<Integer, d> hashMap, boolean z) {
        int lastIndexOf = str.lastIndexOf("/");
        if (lastIndexOf != -1) {
            this.TAG += "." + str.substring(lastIndexOf + 1);
        }
        YO(str2);
        if (!this.xJQ.a(str, str2, str3, j, str4, hashMap, z) || this.xJQ.xJn == null) {
            this.xJT = this.xJQ.getError();
            this.xJn = null;
            this.xJQ = null;
            x.i(this.TAG, "initDB failed. %s", this.xJT);
            return false;
        }
        this.xJT = this.xJQ.getError();
        this.xJn = this.xJQ.xJn;
        return true;
    }

    public final boolean a(String str, String str2, long j, String str3, HashMap<Integer, d> hashMap) {
        return a(str, str2, "", j, str3, hashMap, true);
    }

    public final boolean isOpen() {
        if (this.xJn != null && this.xJn.isOpen()) {
            return true;
        }
        Assert.assertTrue("DB has been closed :[" + this.xJR + "]", bi.oN(this.xJR));
        return false;
    }

    public final String getKey() {
        if (this.xJQ == null) {
            return null;
        }
        return this.xJQ.aAM;
    }

    public final String getPath() {
        if (isOpen()) {
            return this.xJn.getPath();
        }
        x.e(this.TAG, "DB IS CLOSED ! {%s}", bi.chl());
        return null;
    }

    public static String fg(String str) {
        if (bi.oN(str)) {
            return "";
        }
        return DatabaseUtils.sqlEscapeString(str);
    }

    public final Cursor query(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
        return a(str, strArr, str2, strArr2, str3, str4, str5, 0);
    }

    public final Cursor a(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, int i) {
        if (isOpen()) {
            int cgq;
            boolean z = HardCoderJNI.hcDBEnable;
            int i2 = HardCoderJNI.hcDBDelayQuery;
            int i3 = HardCoderJNI.hcDBCPU;
            int i4 = HardCoderJNI.hcDBIO;
            if (HardCoderJNI.hcDBThr) {
                cgq = g.Dt().cgq();
            } else {
                cgq = 0;
            }
            int startPerformance = HardCoderJNI.startPerformance(z, i2, i3, i4, cgq, HardCoderJNI.hcDBTimeout, HardCoderJNI.SCENE_DB, HardCoderJNI.hcDBActionQuery, this.TAG);
            c.begin();
            Cursor a;
            try {
                a = this.xJn.a(str, strArr, str2, strArr2, str3, str4, str5, i);
                c.a(str, a, this.kqa);
                return a;
            } catch (Exception e) {
                com.tencent.mm.plugin.report.d.pVE.a(181, 10, 1, false);
                x.e(this.TAG, "execSQL Error :" + e.getMessage());
                c.i(e);
                a = d.clB();
                return a;
            } finally {
                HardCoderJNI.stopPerformace(HardCoderJNI.hcDBEnable, startPerformance);
            }
        } else {
            x.e(this.TAG, "DB IS CLOSED ! {%s}", bi.chl());
            return d.clB();
        }
    }

    public final Cursor a(final String str, String[] strArr, int i) {
        int i2 = 0;
        Assert.assertTrue("sql is null ", !bi.oN(str));
        if (isOpen()) {
            boolean z = HardCoderJNI.hcDBEnable;
            int i3 = HardCoderJNI.hcDBDelayQuery;
            int i4 = HardCoderJNI.hcDBCPU;
            int i5 = HardCoderJNI.hcDBIO;
            if (HardCoderJNI.hcDBThr) {
                i2 = g.Dt().cgq();
            }
            int startPerformance = HardCoderJNI.startPerformance(z, i3, i4, i5, i2, HardCoderJNI.hcDBTimeout, HardCoderJNI.SCENE_DB, HardCoderJNI.hcDBActionQuery, this.TAG);
            c.begin();
            final Cursor a;
            try {
                a = this.xJn.a(str, strArr, i);
                if (com.tencent.mm.sdk.a.b.cfv() || com.tencent.mm.sdk.a.b.cfx()) {
                    if (this.xJV == null) {
                        HandlerThread WL = com.tencent.mm.sdk.f.e.WL("CheckCursor");
                        WL.start();
                        this.xJV = new ag(WL.getLooper());
                    }
                    final c cVar = new c();
                    this.xJV.postDelayed(new Runnable() {
                        public final void run() {
                            try {
                                long Wy = bi.Wy();
                                if (a != null && !a.isClosed()) {
                                    int intValue;
                                    String str;
                                    String str2;
                                    HashMap hashMap = new HashMap();
                                    int i = 0;
                                    c cVar = null;
                                    synchronized (h.this.xJU) {
                                        Pair pair;
                                        c cVar2;
                                        Iterator it = h.this.xJU.iterator();
                                        while (it.hasNext()) {
                                            b bVar = (b) it.next();
                                            if (bVar == null || bVar.xJZ == null || bVar.xJZ.isClosed()) {
                                                it.remove();
                                            } else {
                                                Pair pair2;
                                                if ((Wy - bVar.lastReportTime) / 1000 > 100) {
                                                    bVar.lastReportTime = Wy;
                                                    if (!bVar.xKc) {
                                                        x.w(h.this.TAG, "CheckCursorRES time:%d MSG: NOTCLOSE cu:%s caller:%s outCu:%b kw:%s", Long.valueOf(Wy - bVar.xKb), Integer.valueOf(bVar.xJZ.hashCode()), bVar.xKa, Boolean.valueOf(bVar.xKc), bVar.xKd);
                                                    } else if (TextUtils.isEmpty(bVar.xKd)) {
                                                        x.w(h.this.TAG, "CheckCursorRES time:%d MSG: BadOut cu:%s caller:%s outCu:%b kw:%s", Long.valueOf(Wy - bVar.xKb), Integer.valueOf(bVar.xJZ.hashCode()), bVar.xKa, Boolean.valueOf(bVar.xKc), bVar.xKd);
                                                    } else {
                                                        x.w(h.this.TAG, "CheckCursorRES time:%d MSG: Adapter cu:%s caller:%s outCu:%b kw:%s", Long.valueOf(Wy - bVar.xKb), Integer.valueOf(bVar.xJZ.hashCode()), bVar.xKa, Boolean.valueOf(bVar.xKc), bVar.xKd);
                                                    }
                                                }
                                                pair = (Pair) hashMap.get(bVar.xKa);
                                                if (pair == null) {
                                                    pair = new Pair(Integer.valueOf(Wy - bVar.xKb > 30000 ? 1 : 0), bVar);
                                                    hashMap.put(bVar.xKa, pair);
                                                    pair2 = pair;
                                                } else if (Wy - bVar.xKb > 30000) {
                                                    Pair pair3 = new Pair(Integer.valueOf(((Integer) pair.first).intValue() + 1), pair.second);
                                                    hashMap.put(bVar.xKa, pair3);
                                                    pair2 = pair3;
                                                } else {
                                                    pair2 = pair;
                                                }
                                                if (i < ((Integer) pair2.first).intValue()) {
                                                    intValue = ((Integer) pair2.first).intValue();
                                                    cVar2 = ((b) pair2.second).xKe;
                                                } else {
                                                    cVar2 = cVar;
                                                    intValue = i;
                                                }
                                                cVar = cVar2;
                                                i = intValue;
                                            }
                                        }
                                        x.d(h.this.TAG, "CheckCursor: checkAss max:%d list:%d map:%d", Integer.valueOf(i), Integer.valueOf(h.this.xJU.size()), Integer.valueOf(hashMap.size()));
                                        if (i <= (com.tencent.mm.sdk.a.b.cfv() ? 20 : 50)) {
                                            if (h.this.xJU.size() <= (com.tencent.mm.sdk.a.b.cfv() ? 50 : 100)) {
                                            }
                                        }
                                        str = "";
                                        Iterator it2 = hashMap.keySet().iterator();
                                        while (true) {
                                            str2 = str;
                                            if (!it2.hasNext()) {
                                                break;
                                            }
                                            str = (String) it2.next();
                                            pair = (Pair) hashMap.get(str);
                                            str = str2 + str + "," + pair.first + "," + ((b) pair.second).xKc + "," + ((b) pair.second).xKd + ";";
                                        }
                                        if (cVar != null) {
                                            cVar2 = new c(str2);
                                            cVar2.setStackTrace(cVar.getStackTrace());
                                            throw cVar2;
                                        }
                                        throw new AssertionError(str2);
                                    }
                                    long Wy2 = bi.Wy();
                                    b bVar2 = new b();
                                    bVar2.xJZ = a;
                                    bVar2.xrW = str;
                                    bVar2.xKb = Wy;
                                    bVar2.xKa = "";
                                    bVar2.xKc = true;
                                    bVar2.xKe = cVar;
                                    StackTraceElement[] stackTrace = cVar.getStackTrace();
                                    int i2 = 0;
                                    while (true) {
                                        intValue = i2;
                                        if (intValue >= stackTrace.length) {
                                            break;
                                        }
                                        Object obj;
                                        str = stackTrace[intValue].getClassName();
                                        String methodName = stackTrace[intValue].getMethodName();
                                        str2 = str.replace("com.tencent.mm.", "") + ":" + methodName + "(" + stackTrace[intValue].getLineNumber() + ")";
                                        Class cls = Class.forName(str);
                                        try {
                                            obj = cls.getDeclaredField("field_MARK_CURSOR_CHECK_IGNORE") != null ? 1 : null;
                                        } catch (Exception e) {
                                            obj = null;
                                        }
                                        if (obj == null) {
                                            if (!TextUtils.isEmpty(bVar2.xKa)) {
                                                if (!bVar2.xKc) {
                                                    break;
                                                }
                                                str = str2.toLowerCase();
                                                if (str.contains("cursor") || str.contains("adapter")) {
                                                    bVar2.xKd = str2;
                                                }
                                            } else {
                                                bVar2.xKa = str2;
                                                boolean z = false;
                                                for (Method method : cls.getMethods()) {
                                                    if (method.getName().equals(methodName)) {
                                                        z = method.getReturnType().getName().contains(".Cursor");
                                                        if (z) {
                                                            break;
                                                        }
                                                    }
                                                }
                                                bVar2.xKc = z;
                                            }
                                        }
                                        i2 = intValue + 1;
                                    }
                                    if (TextUtils.isEmpty(bVar2.xKa)) {
                                        bVar2.xKa = aj.b(stackTrace);
                                    }
                                    synchronized (h.this.xJU) {
                                        h.this.xJU.add(bVar2);
                                    }
                                    x.d(h.this.TAG, "checkCursor insert [%d,%d] caller:%s outCu:%b kw:%s", Long.valueOf(Wy2 - Wy), Long.valueOf(bi.bA(Wy)), bVar2.xKa, Boolean.valueOf(bVar2.xKc), bVar2.xKd);
                                }
                            } catch (Throwable e2) {
                                x.e(h.this.TAG, "checkCursor table:[%s] e:%s[%s]", str, e2.getMessage(), bi.i(e2));
                            }
                        }
                    }, 500);
                }
                c.a(str, a, this.kqa);
                return a;
            } catch (Exception e) {
                com.tencent.mm.plugin.report.d.pVE.a(181, 10, 1, false);
                x.e(this.TAG, "execSQL Error :" + e.getMessage());
                c.i(e);
                a = d.clB();
                return a;
            } finally {
                HardCoderJNI.stopPerformace(HardCoderJNI.hcDBEnable, startPerformance);
            }
        } else {
            x.e(this.TAG, "DB IS CLOSED ! {%s}", bi.chl());
            return d.clB();
        }
    }

    public final Cursor rawQuery(String str, String[] strArr) {
        return a(str, strArr, 0);
    }

    public final boolean a(String str, String str2, String str3, List<String> list, ExecuteSqlCallback executeSqlCallback) {
        if (isOpen()) {
            return DBDumpUtil.doRecoveryDb(this.xJn.xJx, str, str2, str3, list, null, executeSqlCallback, true);
        }
        x.e(this.TAG, "DB IS CLOSED ! {%s}", bi.chl());
        return false;
    }

    public final long getPageSize() {
        return this.xJn.xJx.getPageSize();
    }

    public final f clJ() {
        return this.xJn;
    }

    public final SQLiteDatabase clK() {
        f fVar = this.xJn;
        return fVar.xJx != null ? fVar.xJx : fVar.xJy;
    }

    public final boolean fD(String str, String str2) {
        Assert.assertTrue("sql is null ", !bi.oN(str2));
        if (isOpen()) {
            int cgq;
            boolean z = HardCoderJNI.hcDBEnable;
            int i = HardCoderJNI.hcDBDelayWrite;
            int i2 = HardCoderJNI.hcDBCPU;
            int i3 = HardCoderJNI.hcDBIO;
            if (HardCoderJNI.hcDBThr) {
                cgq = g.Dt().cgq();
            } else {
                cgq = 0;
            }
            int startPerformance = HardCoderJNI.startPerformance(z, i, i2, i3, cgq, HardCoderJNI.hcDBTimeout, HardCoderJNI.SCENE_DB, HardCoderJNI.hcDBActionWrite, this.TAG);
            c.begin();
            try {
                this.xJn.execSQL(str2);
                c.a(str2, null, this.kqa);
                return true;
            } catch (Exception e) {
                com.tencent.mm.plugin.report.d.pVE.a(181, 11, 1, false);
                String message = e.getMessage();
                x.e(this.TAG, "execSQL Error :" + message);
                if (message != null && message.contains("no such table")) {
                    x.d("MicroMsg.DBInit", "resetIniCache iniFilename:%s", this.xJQ.xJo);
                    com.tencent.mm.loader.stub.b.deleteFile(r1.xJo);
                    if (this.xJS != null) {
                        this.xJS.Dl();
                    }
                    Assert.assertTrue("clean ini cache and reboot", false);
                }
                c.i(e);
                return false;
            } finally {
                HardCoderJNI.stopPerformace(HardCoderJNI.hcDBEnable, startPerformance);
            }
        } else {
            x.e(this.TAG, "DB IS CLOSED ! {%s}", bi.chl());
            return false;
        }
    }

    public final long insert(String str, String str2, ContentValues contentValues) {
        return a(str, str2, contentValues, false);
    }

    public final long a(String str, String str2, ContentValues contentValues, boolean z) {
        int i = 0;
        if (isOpen()) {
            long insert;
            boolean z2 = HardCoderJNI.hcDBEnable;
            int i2 = HardCoderJNI.hcDBDelayWrite;
            int i3 = HardCoderJNI.hcDBCPU;
            int i4 = HardCoderJNI.hcDBIO;
            if (HardCoderJNI.hcDBThr) {
                i = g.Dt().cgq();
            }
            int startPerformance = HardCoderJNI.startPerformance(z2, i2, i3, i4, i, HardCoderJNI.hcDBTimeout, HardCoderJNI.SCENE_DB, HardCoderJNI.hcDBActionWrite, this.TAG);
            c.begin();
            try {
                insert = this.xJn.insert(str, str2, contentValues);
                c.a(str, null, this.kqa);
            } catch (Exception e) {
                com.tencent.mm.plugin.report.d.pVE.a(181, 11, 1, false);
                x.e(this.TAG, "insert Error :" + e.getMessage());
                c.i(e);
                if (!z) {
                    return -1;
                }
                throw e;
            } finally {
                HardCoderJNI.stopPerformace(HardCoderJNI.hcDBEnable, startPerformance);
                return -1;
            }
            return insert;
        }
        x.e(this.TAG, "DB IS CLOSED ! {%s}", bi.chl());
        return -2;
    }

    public final int update(String str, ContentValues contentValues, String str2, String[] strArr) {
        int i = 0;
        if (isOpen()) {
            int update;
            boolean z = HardCoderJNI.hcDBEnable;
            int i2 = HardCoderJNI.hcDBDelayWrite;
            int i3 = HardCoderJNI.hcDBCPU;
            int i4 = HardCoderJNI.hcDBIO;
            if (HardCoderJNI.hcDBThr) {
                i = g.Dt().cgq();
            }
            int startPerformance = HardCoderJNI.startPerformance(z, i2, i3, i4, i, HardCoderJNI.hcDBTimeout, HardCoderJNI.SCENE_DB, HardCoderJNI.hcDBActionWrite, this.TAG);
            c.begin();
            try {
                update = this.xJn.update(str, contentValues, str2, strArr);
                c.a(str, null, this.kqa);
            } catch (Exception e) {
                com.tencent.mm.plugin.report.d.pVE.a(181, 11, 1, false);
                x.e(this.TAG, "update Error :" + e.getMessage());
                c.i(e);
                return -1;
            } finally {
                HardCoderJNI.stopPerformace(HardCoderJNI.hcDBEnable, startPerformance);
                return -1;
            }
            return update;
        }
        x.e(this.TAG, "DB IS CLOSED ! {%s}", bi.chl());
        return -2;
    }

    public final long replace(String str, String str2, ContentValues contentValues) {
        int i = 0;
        if (isOpen()) {
            long replace;
            boolean z = HardCoderJNI.hcDBEnable;
            int i2 = HardCoderJNI.hcDBDelayWrite;
            int i3 = HardCoderJNI.hcDBCPU;
            int i4 = HardCoderJNI.hcDBIO;
            if (HardCoderJNI.hcDBThr) {
                i = g.Dt().cgq();
            }
            int startPerformance = HardCoderJNI.startPerformance(z, i2, i3, i4, i, HardCoderJNI.hcDBTimeout, HardCoderJNI.SCENE_DB, HardCoderJNI.hcDBActionWrite, this.TAG);
            c.begin();
            try {
                replace = this.xJn.replace(str, str2, contentValues);
                c.a(str, null, this.kqa);
            } catch (Exception e) {
                com.tencent.mm.plugin.report.d.pVE.a(181, 11, 1, false);
                x.e(this.TAG, "repalce  Error :" + e.getMessage());
                c.i(e);
                return -1;
            } finally {
                HardCoderJNI.stopPerformace(HardCoderJNI.hcDBEnable, startPerformance);
                return -1;
            }
            return replace;
        }
        x.e(this.TAG, "DB IS CLOSED ! {%s}", bi.chl());
        return -2;
    }

    public final int delete(String str, String str2, String[] strArr) {
        int i = 0;
        if (isOpen()) {
            int delete;
            boolean z = HardCoderJNI.hcDBEnable;
            int i2 = HardCoderJNI.hcDBDelayWrite;
            int i3 = HardCoderJNI.hcDBCPU;
            int i4 = HardCoderJNI.hcDBIO;
            if (HardCoderJNI.hcDBThr) {
                i = g.Dt().cgq();
            }
            int startPerformance = HardCoderJNI.startPerformance(z, i2, i3, i4, i, HardCoderJNI.hcDBTimeout, HardCoderJNI.SCENE_DB, HardCoderJNI.hcDBActionWrite, this.TAG);
            c.begin();
            try {
                delete = this.xJn.delete(str, str2, strArr);
                c.a(str, null, this.kqa);
            } catch (Exception e) {
                com.tencent.mm.plugin.report.d.pVE.a(181, 11, 1, false);
                x.e(this.TAG, "delete Error :" + e.getMessage());
                c.i(e);
                return -1;
            } finally {
                HardCoderJNI.stopPerformace(HardCoderJNI.hcDBEnable, startPerformance);
                return -1;
            }
            return delete;
        }
        x.e(this.TAG, "DB IS CLOSED ! {%s}", bi.chl());
        return -2;
    }

    public final boolean YP(String str) {
        if (isOpen()) {
            try {
                this.xJn.execSQL("DROP TABLE " + str);
            } catch (Exception e) {
                com.tencent.mm.plugin.report.d.pVE.a(181, 11, 1, false);
                x.e(this.TAG, "drop table Error :" + e.getMessage());
                c.i(e);
            }
        } else {
            x.e(this.TAG, "DB IS CLOSED ! {%s}", bi.chl());
        }
        return false;
    }

    public final synchronized long dA(long j) {
        long j2 = -1;
        synchronized (this) {
            x.i(this.TAG, "beginTransaction thr:(%d,%d) ticket:%d db:%b  {%s}", Long.valueOf(j), Long.valueOf(Thread.currentThread().getId()), Long.valueOf(this.kqa), Boolean.valueOf(isOpen()), bi.chl());
            if (!isOpen()) {
                x.e(this.TAG, "DB IS CLOSED ! {%s}", bi.chl());
                j2 = -4;
            } else if (this.kqa > 0) {
                x.e(this.TAG, "ERROR beginTransaction transactionTicket:" + this.kqa);
            } else if (ah.isMainThread() || j != -1) {
                try {
                    c.begin();
                    this.xJn.beginTransaction();
                    c.a("beginTrans", null, 0);
                    this.kqa = bi.Wy() & 2147483647L;
                    this.kqa |= (r2 & 2147483647L) << 32;
                    if (this.xJP != null) {
                        this.xJP.Dj();
                    }
                    j2 = this.kqa;
                } catch (Exception e) {
                    com.tencent.mm.plugin.report.d.pVE.a(181, 8, 1, false);
                    x.e(this.TAG, "beginTransaction Error :" + e.getMessage());
                    c.i(e);
                    j2 = -3;
                }
            } else {
                x.e(this.TAG, "FORBID: beginTrans UNKNOW_THREAD ParamID:%d nowThr:%d", Long.valueOf(j), Long.valueOf(r2));
                j2 = -2;
            }
        }
        return j2;
    }

    public final synchronized int fT(long j) {
        int i = 0;
        synchronized (this) {
            long Wy = bi.Wy();
            x.i(this.TAG, "endTransaction thr:%d ticket:(%d,%d) db:%b  {%s} ", Long.valueOf(Thread.currentThread().getId()), Long.valueOf(j), Long.valueOf(this.kqa), Boolean.valueOf(isOpen()), bi.chl());
            if (!isOpen()) {
                x.e(this.TAG, "DB IS CLOSED ! {%s}", bi.chl());
                i = -4;
            } else if (j != this.kqa) {
                x.e(this.TAG, "ERROR endTransaction ticket:" + j + " transactionTicket:" + this.kqa);
                i = -1;
            } else {
                if (((j >> 32) & 2147483647L) != r4) {
                    x.e(this.TAG, "FORBID: endTrans UNKNOW_THREAD ticket:%s ParamID:%d nowThr:%d", Long.toHexString(j), Long.valueOf((j >> 32) & 2147483647L), Long.valueOf(r4));
                    i = -2;
                } else {
                    try {
                        c.begin();
                        this.xJn.endTransaction();
                        x.i(this.TAG, "endTransaction Succ Time:%d thr:%d ticket:(%d,%d) db:%b  {%s} ", Long.valueOf(bi.bA(Wy)), Long.valueOf(r4), Long.valueOf(j), Long.valueOf(this.kqa), Boolean.valueOf(isOpen()), bi.chl());
                        c.a("endTrans", null, 0);
                        this.kqa = 0;
                        if (this.xJP != null) {
                            this.xJP.Dk();
                        }
                    } catch (Exception e) {
                        x.e(this.TAG, "endTransaction Error :" + e.getMessage());
                        com.tencent.mm.plugin.report.d.pVE.a(181, 9, 1, false);
                        c.i(e);
                        i = -3;
                    }
                }
            }
        }
        return i;
    }

    public final synchronized boolean inTransaction() {
        boolean z = false;
        synchronized (this) {
            if (!isOpen()) {
                x.e(this.TAG, "DB IS CLOSED ! {%s}", bi.chl());
            } else if (this.kqa > 0) {
                z = true;
            }
        }
        return z;
    }
}
