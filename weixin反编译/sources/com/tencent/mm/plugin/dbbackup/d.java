package com.tencent.mm.plugin.dbbackup;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.database.Cursor;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.comm.WakerLock;
import com.tencent.mm.ap.o;
import com.tencent.mm.bx.f;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.FLock;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.t;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.y.ap;
import com.tencent.mm.y.as;
import com.tencent.wcdb.database.SQLiteCipherSpec;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteDirectCursor;
import com.tencent.wcdb.repair.BackupKit;
import com.tencent.wcdb.repair.DBDumpUtil.ExecuteSqlCallback;
import com.tencent.wcdb.repair.RecoverKit;
import com.tencent.wcdb.repair.RepairKit;
import com.tencent.wcdb.repair.RepairKit.MasterInfo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class d implements ap {
    private static final SQLiteCipherSpec lvJ = new SQLiteCipherSpec().setPageSize(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT).setSQLCipherVersion(1);
    private BroadcastReceiver hIq;
    private boolean hIr = false;
    private boolean hIs = true;
    private Runnable hIu;
    private long lvA = 600000;
    private long lvB = 0;
    private int lvC = 10;
    private boolean lvD = false;
    final SimpleDateFormat lvE = new SimpleDateFormat("HH:mm:ss.SSS");
    private String lvF;
    private FLock lvG;
    private com.tencent.mm.sdk.e.j.a lvH;
    private c lvI;
    private volatile BackupKit lvt;
    private volatile RecoverKit lvu;
    private volatile RepairKit lvv;
    private volatile boolean lvw = false;
    private boolean lvx = false;
    private boolean lvy = false;
    private long lvz = 0;

    /* renamed from: com.tencent.mm.plugin.dbbackup.d$5 */
    class AnonymousClass5 implements b {
        final /* synthetic */ b lvK;
        int lwe = 0;
        final /* synthetic */ File lwf;
        final /* synthetic */ WakerLock lwg;

        AnonymousClass5(File file, b bVar, WakerLock wakerLock) {
            this.lwf = file;
            this.lvK = bVar;
            this.lwg = wakerLock;
        }

        public final void oM(int i) {
            while (true) {
                if (this.lwe > 0) {
                    x.i("MicroMsg.SubCoreDBBackup", "Recovery stage %d result: %d", Integer.valueOf(this.lwe), Integer.valueOf(i));
                }
                if (i == 0) {
                    this.lwf.delete();
                    g.pWK.a(181, 29, 1, true);
                    if (this.lvK != null) {
                        this.lvK.oM(i);
                    }
                    this.lwg.unLock();
                    return;
                } else if (i == -2) {
                    this.lwf.delete();
                    g.pWK.a(181, 3, 1, true);
                    if (this.lvK != null) {
                        this.lvK.oM(i);
                    }
                    this.lwg.unLock();
                    return;
                } else {
                    int i2 = this.lwe + 1;
                    this.lwe = i2;
                    switch (i2) {
                        case 1:
                            x.i("MicroMsg.SubCoreDBBackup", "Database recovery stage %d: REPAIR", Integer.valueOf(this.lwe));
                            i = d.this.b(null, (b) this);
                            break;
                        case 2:
                            x.i("MicroMsg.SubCoreDBBackup", "Database recovery stage %d: BACKUP RECOVER", Integer.valueOf(this.lwe));
                            i = d.this.a(null, (b) this);
                            break;
                        case 3:
                            x.i("MicroMsg.SubCoreDBBackup", "Database recovery stage %d: DUMP", Integer.valueOf(this.lwe));
                            i = d.this.a((b) this);
                            break;
                        default:
                            this.lwf.delete();
                            g.pWK.a(181, 30, 1, true);
                            if (this.lvK != null) {
                                this.lvK.oM(i);
                            }
                            this.lwg.unLock();
                            return;
                    }
                    if (i == 0) {
                        return;
                    }
                }
            }
        }
    }

    private static class a extends RuntimeException {
        a(String str) {
            super(str);
        }
    }

    private static long[] yc(String str) {
        Throwable e;
        long j = 0;
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader(str + ".bcur"));
            try {
                long parseLong;
                long parseLong2;
                long parseLong3;
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    parseLong = Long.parseLong(readLine);
                } else {
                    parseLong = 0;
                }
                readLine = bufferedReader.readLine();
                if (readLine != null) {
                    parseLong2 = Long.parseLong(readLine);
                } else {
                    parseLong2 = 0;
                }
                readLine = bufferedReader.readLine();
                if (readLine != null) {
                    parseLong3 = Long.parseLong(readLine);
                } else {
                    parseLong3 = 0;
                }
                readLine = bufferedReader.readLine();
                if (readLine != null) {
                    j = Long.parseLong(readLine);
                }
                long[] jArr = new long[]{parseLong, parseLong2, parseLong3, j};
                try {
                    bufferedReader.close();
                    return jArr;
                } catch (IOException e2) {
                    return jArr;
                }
            } catch (Exception e3) {
                e = e3;
                try {
                    x.printErrStackTrace("MicroMsg.SubCoreDBBackup", e, "Failed to read previous cursor '%s'", str);
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e4) {
                        }
                    }
                    return null;
                } catch (Throwable th) {
                    e = th;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e5) {
                        }
                    }
                    throw e;
                }
            }
        } catch (Exception e6) {
            e = e6;
            bufferedReader = null;
            x.printErrStackTrace("MicroMsg.SubCoreDBBackup", e, "Failed to read previous cursor '%s'", str);
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            return null;
        } catch (Throwable th2) {
            e = th2;
            bufferedReader = null;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            throw e;
        }
    }

    private static boolean a(String str, long[] jArr) {
        Throwable e;
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(str + ".bcur");
            try {
                for (long l : jArr) {
                    fileWriter.write(Long.toString(l) + "\n");
                }
                try {
                    fileWriter.close();
                    return true;
                } catch (IOException e2) {
                    return true;
                }
            } catch (IOException e3) {
                e = e3;
                try {
                    x.printErrStackTrace("MicroMsg.SubCoreDBBackup", e, "Failed to write previous cursor '%s'", str);
                    if (fileWriter != null) {
                        try {
                            fileWriter.close();
                        } catch (IOException e4) {
                        }
                    }
                    return false;
                } catch (Throwable th) {
                    e = th;
                    if (fileWriter != null) {
                        try {
                            fileWriter.close();
                        } catch (IOException e5) {
                        }
                    }
                    throw e;
                }
            }
        } catch (IOException e6) {
            e = e6;
            fileWriter = null;
            x.printErrStackTrace("MicroMsg.SubCoreDBBackup", e, "Failed to write previous cursor '%s'", str);
            if (fileWriter != null) {
                fileWriter.close();
            }
            return false;
        } catch (Throwable th2) {
            e = th2;
            fileWriter = null;
            if (fileWriter != null) {
                fileWriter.close();
            }
            throw e;
        }
    }

    public final boolean a(boolean z, b bVar) {
        if (this.lvw) {
            x.i("MicroMsg.SubCoreDBBackup", "Backup or recover task is in progress, %s canceled", "backup");
            return false;
        }
        long j;
        String[] strArr;
        boolean z2;
        int i;
        final com.tencent.mm.y.c Hm = as.Hm();
        final String CZ = com.tencent.mm.y.c.CZ();
        final SQLiteDatabase clK = com.tencent.mm.y.c.Fc().clK();
        final String str = CZ + ".bak";
        final String str2 = str + ".tmp";
        final String str3 = CZ + ".sm";
        final String str4 = str3 + ".tmp";
        int i2 = 8;
        if (z) {
            if (FileOp.bO(str)) {
                i2 = 24;
                FileOp.x(str, str2);
            } else {
                z = false;
            }
        }
        long j2 = -1;
        long j3 = -1;
        long j4 = -1;
        Cursor rawQueryWithFactory = clK.rawQueryWithFactory(SQLiteDirectCursor.FACTORY, "SELECT max(msgId) FROM message;", null, null);
        if (rawQueryWithFactory.moveToFirst()) {
            j = rawQueryWithFactory.getLong(0);
        } else {
            j = -1;
        }
        rawQueryWithFactory.close();
        rawQueryWithFactory = clK.rawQueryWithFactory(SQLiteDirectCursor.FACTORY, "SELECT max(id) FROM ImgInfo2;", null, null);
        if (rawQueryWithFactory.moveToFirst()) {
            j2 = rawQueryWithFactory.getLong(0);
        }
        rawQueryWithFactory.close();
        rawQueryWithFactory = clK.rawQueryWithFactory(SQLiteDirectCursor.FACTORY, "SELECT max(rowid) FROM videoinfo2;", null, null);
        if (rawQueryWithFactory.moveToFirst()) {
            j3 = rawQueryWithFactory.getLong(0);
        }
        rawQueryWithFactory.close();
        rawQueryWithFactory = clK.rawQueryWithFactory(SQLiteDirectCursor.FACTORY, "SELECT max(rowid) FROM EmojiInfo;", null, null);
        if (rawQueryWithFactory.moveToFirst()) {
            j4 = rawQueryWithFactory.getLong(0);
        }
        rawQueryWithFactory.close();
        final long[] jArr = new long[]{j, j2, j3, j4};
        final long[] yc = z ? yc(CZ) : null;
        if (yc == null || yc.length < 4) {
            strArr = new String[]{"message", "msgId <= " + jArr[0], "ImgInfo2", "id <= " + jArr[1], "videoinfo2", "rowid <= " + jArr[2], "EmojiInfo", "rowid <= " + jArr[3], "conversation", null, "rconversation", null};
        } else {
            strArr = new String[12];
            strArr[0] = "message";
            strArr[1] = String.format("msgId > %d AND msgId <= %d", new Object[]{Long.valueOf(yc[0]), Long.valueOf(jArr[0])});
            strArr[2] = "ImgInfo2";
            strArr[3] = String.format("id > %d AND id <= %d", new Object[]{Long.valueOf(yc[1]), Long.valueOf(jArr[1])});
            strArr[4] = "videoinfo2";
            strArr[5] = String.format("rowid > %d AND rowid <= %d", new Object[]{Long.valueOf(yc[2]), Long.valueOf(jArr[2])});
            strArr[6] = "EmojiInfo";
            strArr[7] = String.format("rowid > %d AND rowid <= %d", new Object[]{Long.valueOf(yc[3]), Long.valueOf(jArr[3])});
            strArr[8] = "conversation";
            strArr[9] = null;
            strArr[10] = "rconversation";
            strArr[11] = null;
        }
        if (yc == null) {
            z2 = false;
        } else {
            z2 = z;
        }
        if (this.lvD) {
            i = i2 | 3;
        } else {
            i = i2;
        }
        final b bVar2 = bVar;
        Runnable anonymousClass1 = new Runnable() {
            public final void run() {
                if (d.this.lvw) {
                    d.this.lvt = null;
                    try {
                        String str;
                        int i;
                        int i2;
                        long nanoTime = System.nanoTime();
                        byte[] t = com.tencent.mm.a.g.t((q.yL() + com.tencent.mm.y.c.Cn()).getBytes());
                        File file = new File(str3);
                        if (!(z2 && file.exists())) {
                            boolean renameTo;
                            boolean save = MasterInfo.save(clK, str4, t);
                            File file2 = new File(str4);
                            if (save) {
                                file.delete();
                                renameTo = file2.renameTo(file);
                            } else {
                                file2.delete();
                                renameTo = save;
                            }
                            long nanoTime2 = System.nanoTime() - nanoTime;
                            str = "MicroMsg.SubCoreDBBackup";
                            String str2 = "Master table backup %s, elapsed %.3f";
                            Object[] objArr = new Object[2];
                            objArr[0] = renameTo ? "SUCCEEDED" : "FAILED";
                            objArr[1] = Float.valueOf(((float) nanoTime2) / 1.0E9f);
                            x.i(str, str2, objArr);
                            g.pWK.a(181, renameTo ? 24 : 25, 1, false);
                        }
                        long length = new File(CZ).length();
                        long length2 = new File(str2).length();
                        String str3 = "MicroMsg.SubCoreDBBackup";
                        String str4 = "Backup started [%s, cursor: %d ~ %d]";
                        Object[] objArr2 = new Object[3];
                        objArr2[0] = z2 ? "incremental" : "new";
                        objArr2[1] = Long.valueOf(yc != null ? yc[0] : 0);
                        objArr2[2] = Long.valueOf(jArr[0]);
                        x.i(str3, str4, objArr2);
                        int i3 = z2 ? CdnLogic.kMediaTypeBeatificFile : 10000;
                        g gVar = g.pWK;
                        Object[] objArr3 = new Object[2];
                        objArr3[0] = Integer.valueOf(i3);
                        objArr3[1] = String.format("%d|%d|%s", new Object[]{Long.valueOf(length), Long.valueOf(length2), d.this.lvE.format(new Date())});
                        gVar.h(11098, objArr3);
                        d.this.lvt = new BackupKit(clK, str2, t, i, strArr);
                        int run = d.this.lvt.run();
                        nanoTime = System.nanoTime() - nanoTime;
                        File file3 = new File(str2);
                        long length3 = file3.length();
                        if (run == 0) {
                            d.a(CZ, jArr);
                            file = new File(str);
                            file.delete();
                            file3.renameTo(file);
                            if (z2) {
                                i = 10012;
                                i2 = 19;
                            } else {
                                i = 10001;
                                i2 = 16;
                            }
                        } else {
                            file3.delete();
                            if (run == 1) {
                                if (z2) {
                                    i = 10013;
                                    i2 = 20;
                                } else {
                                    i = 10002;
                                    i2 = 17;
                                }
                            } else if (z2) {
                                i = 10014;
                                i2 = 21;
                            } else {
                                i = 10003;
                                i2 = 18;
                            }
                        }
                        str = "MicroMsg.SubCoreDBBackup";
                        str3 = "Database %s backup %s, elapsed %.2f seconds.";
                        objArr3 = new Object[3];
                        objArr3[0] = z2 ? "incremental" : "new";
                        String str5 = run == 0 ? "succeeded" : run == 1 ? "canceled" : "failed";
                        objArr3[1] = str5;
                        objArr3[2] = Float.valueOf(((float) nanoTime) / 1.0E9f);
                        x.i(str, str3, objArr3);
                        g.pWK.a(181, (long) i2, 1, false);
                        g gVar2 = g.pWK;
                        Object[] objArr4 = new Object[2];
                        objArr4[0] = Integer.valueOf(i);
                        objArr4[1] = String.format("%d|%d|%d|%d|%d|%s", new Object[]{Long.valueOf(length), Long.valueOf(length2), Long.valueOf(length3), Integer.valueOf(d.this.lvt.statementCount()), Long.valueOf(nanoTime / 1000000), d.this.lvE.format(new Date())});
                        gVar2.h(11098, objArr4);
                        if (bVar2 != null) {
                            bVar2.oM(run);
                        }
                        d.this.lvt.release();
                        d.this.lvt = null;
                        StringBuilder stringBuilder = new StringBuilder();
                        com.tencent.mm.kernel.g.Dr();
                        FileOp.ml(stringBuilder.append(com.tencent.mm.kernel.g.Dq().gRT).append("dbback").toString());
                        str5 = str3;
                        StringBuilder stringBuilder2 = new StringBuilder();
                        com.tencent.mm.kernel.g.Dr();
                        FileOp.x(str5, stringBuilder2.append(com.tencent.mm.kernel.g.Dq().gRT).append("dbback/EnMicroMsg.db.sm").toString());
                        str5 = str;
                        stringBuilder2 = new StringBuilder();
                        com.tencent.mm.kernel.g.Dr();
                        FileOp.x(str5, stringBuilder2.append(com.tencent.mm.kernel.g.Dq().gRT).append("dbback/EnMicroMsg.db.bak").toString());
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.SubCoreDBBackup", e, "Failed to start database backup, path: %s", CZ);
                        if (bVar2 != null) {
                            bVar2.oM(-1);
                        }
                        g.pWK.a(181, z2 ? 18 : 21, 1, false);
                    } finally {
                        if (d.this.lvt != null) {
                            d.this.lvt.release();
                            d.this.lvt = null;
                        }
                        d.this.lvw = false;
                    }
                } else if (bVar2 != null) {
                    bVar2.oM(1);
                }
            }
        };
        this.lvw = true;
        e.post(anonymousClass1, "DB Backup");
        return true;
    }

    public final synchronized boolean aAk() {
        boolean z = false;
        synchronized (this) {
            this.lvw = false;
            if (this.lvt != null) {
                this.lvt.onCancel();
                z = true;
            }
        }
        return z;
    }

    @Deprecated
    public final synchronized int a(String str, b bVar) {
        final com.tencent.mm.y.c Hm = as.Hm();
        final long chh = bi.chh();
        final String str2 = str;
        final b bVar2 = bVar;
        Runnable anonymousClass2 = new Runnable() {
            public final void run() {
                int i;
                Throwable e;
                int i2;
                d.this.lvu = null;
                SQLiteDatabase openDatabase;
                try {
                    com.tencent.mm.y.c.Fh();
                    com.tencent.mm.y.c.Fk();
                    o.PC();
                    com.tencent.mm.modelvideo.o.Ub();
                    long nanoTime = System.nanoTime();
                    byte[] bytes = (q.yL() + com.tencent.mm.y.c.Cn()).getBytes();
                    byte[] t = com.tencent.mm.a.g.t(bytes);
                    byte[] bytes2 = com.tencent.mm.a.g.s(bytes).substring(0, 7).getBytes();
                    int i3 = SQLiteDatabase.CREATE_IF_NECESSARY;
                    if (f.clG()) {
                        i3 = 805306368;
                    }
                    openDatabase = SQLiteDatabase.openDatabase(com.tencent.mm.y.c.Fc().clK().getPath(), bytes2, d.lvJ, null, i3, null, 0);
                    try {
                        String[] strArr;
                        if (str2 != null) {
                            strArr = new String[]{str2};
                        } else {
                            String[] strArr2 = new String[2];
                            strArr2[0] = com.tencent.mm.y.c.CX() + ".bak";
                            StringBuilder stringBuilder = new StringBuilder();
                            com.tencent.mm.kernel.g.Dr();
                            strArr2[1] = stringBuilder.append(com.tencent.mm.kernel.g.Dq().gRT).append("dbback/EnMicroMsg.db.bak").toString();
                            strArr = strArr2;
                        }
                        i = -3;
                        try {
                            String str;
                            int length = strArr.length;
                            i3 = 0;
                            long j = 0;
                            int i4 = -3;
                            while (i3 < length) {
                                try {
                                    str = strArr[i3];
                                    try {
                                        File file = new File(str);
                                        if (file.canRead()) {
                                            j = file.length();
                                            x.i("MicroMsg.SubCoreDBBackup", "[Recover] backupSize: %d, diskFreeSpace: %d", Long.valueOf(j), Long.valueOf(chh));
                                            if (chh >= 10 * j) {
                                                g gVar = g.pWK;
                                                Object[] objArr = new Object[2];
                                                objArr[0] = Integer.valueOf(10004);
                                                objArr[1] = String.format("%d|%d", new Object[]{Long.valueOf(j), Long.valueOf(chh)});
                                                gVar.h(11098, objArr);
                                                d.this.lvu = new RecoverKit(openDatabase, str, t);
                                                break;
                                            }
                                            if (bVar2 != null) {
                                                bVar2.oM(-2);
                                            }
                                            if (d.this.lvu != null) {
                                                d.this.lvu.release();
                                                d.this.lvu = null;
                                            }
                                            if (openDatabase != null) {
                                                openDatabase.close();
                                            }
                                            d.this.lvw = false;
                                            as.Dt().cgr();
                                            return;
                                        }
                                        continue;
                                        i3++;
                                    } catch (Exception e2) {
                                        x.e("MicroMsg.SubCoreDBBackup", "Initialize RecoverKit failed: " + e2.getMessage());
                                        i4 = -1;
                                    }
                                } catch (Throwable e3) {
                                    Throwable th = e3;
                                    i = i4;
                                    e = th;
                                }
                            }
                            if (d.this.lvu == null) {
                                i2 = -3;
                                try {
                                    g.pWK.a(181, 31, 1, true);
                                    throw new RuntimeException();
                                } catch (Exception e4) {
                                    e = e4;
                                    i = i2;
                                    try {
                                        x.printErrStackTrace("MicroMsg.SubCoreDBBackup", e, "Failed to start database recovery", new Object[0]);
                                        if (bVar2 != null) {
                                            bVar2.oM(i);
                                        }
                                        g.pWK.a(181, 23, 1, true);
                                        if (d.this.lvu != null) {
                                            d.this.lvu.release();
                                            d.this.lvu = null;
                                        }
                                        if (openDatabase != null) {
                                            openDatabase.close();
                                        }
                                        d.this.lvw = false;
                                        as.Dt().cgr();
                                    } catch (Throwable th2) {
                                        e = th2;
                                        if (d.this.lvu != null) {
                                            d.this.lvu.release();
                                            d.this.lvu = null;
                                        }
                                        if (openDatabase != null) {
                                            openDatabase.close();
                                        }
                                        d.this.lvw = false;
                                        as.Dt().cgr();
                                        throw e;
                                    }
                                }
                            }
                            i2 = d.this.lvu.run(false);
                            d.aAm();
                            long nanoTime2 = System.nanoTime() - nanoTime;
                            length = d.this.lvu.successCount();
                            int failureCount = d.this.lvu.failureCount();
                            String lastError = d.this.lvu.lastError();
                            d.this.lvu.release();
                            d.this.lvu = null;
                            openDatabase.close();
                            openDatabase = null;
                            str = "MicroMsg.SubCoreDBBackup";
                            String str2 = "Database recover %s, elapsed %.2f seconds. [success: %d, failure: %d]";
                            Object[] objArr2 = new Object[4];
                            String str3 = i2 == 0 ? "succeeded" : i2 == 1 ? "canceled" : "failed";
                            objArr2[0] = str3;
                            objArr2[1] = Float.valueOf(((float) nanoTime2) / 1.0E9f);
                            objArr2[2] = Integer.valueOf(length);
                            objArr2[3] = Integer.valueOf(failureCount);
                            x.i(str, str2, objArr2);
                            if (i2 == 0) {
                                i = 10005;
                                i4 = 22;
                            } else if (i2 == 1) {
                                i = 10006;
                                i4 = -1;
                            } else {
                                i = CdnLogic.kMediaTypeFavoriteBigFile;
                                i4 = 23;
                                g.pWK.c("DBRepair", "Backup recover failed: " + lastError, null);
                            }
                            g gVar2 = g.pWK;
                            objArr2 = new Object[2];
                            objArr2[0] = Integer.valueOf(i);
                            objArr2[1] = String.format("%d|%d|%d|%d", new Object[]{Long.valueOf(j), Long.valueOf(nanoTime2 / 1000000), Integer.valueOf(length), Integer.valueOf(failureCount)});
                            gVar2.h(11098, objArr2);
                            if (i4 >= 0) {
                                g.pWK.a(181, (long) i4, 1, true);
                            }
                            if (bVar2 != null) {
                                bVar2.oM(i2);
                            }
                            if (d.this.lvu != null) {
                                d.this.lvu.release();
                                d.this.lvu = null;
                            }
                            d.this.lvw = false;
                            as.Dt().cgr();
                        } catch (Exception e5) {
                            e = e5;
                            x.printErrStackTrace("MicroMsg.SubCoreDBBackup", e, "Failed to start database recovery", new Object[0]);
                            if (bVar2 != null) {
                                bVar2.oM(i);
                            }
                            g.pWK.a(181, 23, 1, true);
                            if (d.this.lvu != null) {
                                d.this.lvu.release();
                                d.this.lvu = null;
                            }
                            if (openDatabase != null) {
                                openDatabase.close();
                            }
                            d.this.lvw = false;
                            as.Dt().cgr();
                        }
                    } catch (Exception e6) {
                        e = e6;
                        i = -1;
                        x.printErrStackTrace("MicroMsg.SubCoreDBBackup", e, "Failed to start database recovery", new Object[0]);
                        if (bVar2 != null) {
                            bVar2.oM(i);
                        }
                        g.pWK.a(181, 23, 1, true);
                        if (d.this.lvu != null) {
                            d.this.lvu.release();
                            d.this.lvu = null;
                        }
                        if (openDatabase != null) {
                            openDatabase.close();
                        }
                        d.this.lvw = false;
                        as.Dt().cgr();
                    }
                } catch (Exception e7) {
                    e = e7;
                    openDatabase = null;
                    i = -1;
                    x.printErrStackTrace("MicroMsg.SubCoreDBBackup", e, "Failed to start database recovery", new Object[0]);
                    if (bVar2 != null) {
                        bVar2.oM(i);
                    }
                    g.pWK.a(181, 23, 1, true);
                    if (d.this.lvu != null) {
                        d.this.lvu.release();
                        d.this.lvu = null;
                    }
                    if (openDatabase != null) {
                        openDatabase.close();
                    }
                    d.this.lvw = false;
                    as.Dt().cgr();
                } catch (Throwable th3) {
                    e = th3;
                    openDatabase = null;
                    if (d.this.lvu != null) {
                        d.this.lvu.release();
                        d.this.lvu = null;
                    }
                    if (openDatabase != null) {
                        openDatabase.close();
                    }
                    d.this.lvw = false;
                    as.Dt().cgr();
                    throw e;
                }
            }
        };
        this.lvw = true;
        as.Dt().tT();
        as.Dt().J(anonymousClass2);
        return 0;
    }

    @Deprecated
    public final synchronized int b(String str, final b bVar) {
        int i = 0;
        synchronized (this) {
            final com.tencent.mm.y.c Hm = as.Hm();
            if (str == null) {
                str = com.tencent.mm.y.c.CX();
            }
            long chh = bi.chh();
            File file = str == null ? null : new File(str);
            if (file == null || !file.canRead()) {
                i = -3;
            } else {
                x.i("MicroMsg.SubCoreDBBackup", "[Repair] inFileSize: %d, diskFreeSpace: %d", Long.valueOf(file.length()), Long.valueOf(chh));
                if (((float) chh) < ((float) file.length()) * 1.5f) {
                    i = -2;
                } else {
                    Runnable anonymousClass3 = new Runnable() {
                        final String[] lvZ = new String[]{"message", "ImgInfo2", "videoinfo2", "EmojiInfo", "conversation", "rconversation"};

                        /* JADX WARNING: inconsistent code. */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public final void run() {
                            /*
                            r14 = this;
                            r0 = com.tencent.mm.plugin.dbbackup.d.this;
                            r1 = 0;
                            r0.lvv = r1;
                            r8 = 0;
                            r7 = 0;
                            com.tencent.mm.y.c.Fh();	 Catch:{ Exception -> 0x02c4, all -> 0x0283 }
                            com.tencent.mm.y.c.Fk();	 Catch:{ Exception -> 0x02c4, all -> 0x0283 }
                            com.tencent.mm.ap.o.PC();	 Catch:{ Exception -> 0x02c4, all -> 0x0283 }
                            com.tencent.mm.modelvideo.o.Ub();	 Catch:{ Exception -> 0x02c4, all -> 0x0283 }
                            r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x02c4, all -> 0x0283 }
                            r0.<init>();	 Catch:{ Exception -> 0x02c4, all -> 0x0283 }
                            r1 = com.tencent.mm.compatible.e.q.yL();	 Catch:{ Exception -> 0x02c4, all -> 0x0283 }
                            r0 = r0.append(r1);	 Catch:{ Exception -> 0x02c4, all -> 0x0283 }
                            r1 = com.tencent.mm.y.c.Cn();	 Catch:{ Exception -> 0x02c4, all -> 0x0283 }
                            r0 = r0.append(r1);	 Catch:{ Exception -> 0x02c4, all -> 0x0283 }
                            r0 = r0.toString();	 Catch:{ Exception -> 0x02c4, all -> 0x0283 }
                            r0 = r0.getBytes();	 Catch:{ Exception -> 0x02c4, all -> 0x0283 }
                            r9 = com.tencent.mm.a.g.t(r0);	 Catch:{ Exception -> 0x02c4, all -> 0x0283 }
                            r0 = com.tencent.mm.a.g.s(r0);	 Catch:{ Exception -> 0x02c4, all -> 0x0283 }
                            r1 = 0;
                            r2 = 7;
                            r0 = r0.substring(r1, r2);	 Catch:{ Exception -> 0x02c4, all -> 0x0283 }
                            r1 = r0.getBytes();	 Catch:{ Exception -> 0x02c4, all -> 0x0283 }
                            r4 = 268435456; // 0x10000000 float:2.5243549E-29 double:1.32624737E-315;
                            r0 = com.tencent.mm.bx.f.clG();	 Catch:{ Exception -> 0x02c4, all -> 0x0283 }
                            if (r0 == 0) goto L_0x004d;
                        L_0x004b:
                            r4 = 805306368; // 0x30000000 float:4.656613E-10 double:3.97874211E-315;
                        L_0x004d:
                            r0 = com.tencent.mm.y.c.Fc();	 Catch:{ Exception -> 0x02c4, all -> 0x0283 }
                            r0 = r0.clK();	 Catch:{ Exception -> 0x02c4, all -> 0x0283 }
                            r0 = r0.getPath();	 Catch:{ Exception -> 0x02c4, all -> 0x0283 }
                            r2 = com.tencent.mm.plugin.dbbackup.d.lvJ;	 Catch:{ Exception -> 0x02c4, all -> 0x0283 }
                            r3 = 0;
                            r5 = 0;
                            r6 = 0;
                            r11 = com.tencent.wcdb.database.SQLiteDatabase.openDatabase(r0, r1, r2, r3, r4, r5, r6);	 Catch:{ Exception -> 0x02c4, all -> 0x0283 }
                            r12 = java.lang.System.nanoTime();	 Catch:{ Exception -> 0x02c9, all -> 0x02b4 }
                            r0 = 2;
                            r4 = new java.lang.String[r0];	 Catch:{ Exception -> 0x02c9, all -> 0x02b4 }
                            r0 = 0;
                            r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x02c9, all -> 0x02b4 }
                            r2.<init>();	 Catch:{ Exception -> 0x02c9, all -> 0x02b4 }
                            r3 = r13;	 Catch:{ Exception -> 0x02c9, all -> 0x02b4 }
                            r2 = r2.append(r3);	 Catch:{ Exception -> 0x02c9, all -> 0x02b4 }
                            r3 = ".sm";
                            r2 = r2.append(r3);	 Catch:{ Exception -> 0x02c9, all -> 0x02b4 }
                            r2 = r2.toString();	 Catch:{ Exception -> 0x02c9, all -> 0x02b4 }
                            r4[r0] = r2;	 Catch:{ Exception -> 0x02c9, all -> 0x02b4 }
                            r0 = 1;
                            r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x02c9, all -> 0x02b4 }
                            r2.<init>();	 Catch:{ Exception -> 0x02c9, all -> 0x02b4 }
                            com.tencent.mm.kernel.g.Dr();	 Catch:{ Exception -> 0x02c9, all -> 0x02b4 }
                            r3 = com.tencent.mm.kernel.g.Dq();	 Catch:{ Exception -> 0x02c9, all -> 0x02b4 }
                            r3 = r3.gRT;	 Catch:{ Exception -> 0x02c9, all -> 0x02b4 }
                            r2 = r2.append(r3);	 Catch:{ Exception -> 0x02c9, all -> 0x02b4 }
                            r3 = "dbback/EnMicroMsg.db.sm";
                            r2 = r2.append(r3);	 Catch:{ Exception -> 0x02c9, all -> 0x02b4 }
                            r2 = r2.toString();	 Catch:{ Exception -> 0x02c9, all -> 0x02b4 }
                            r4[r0] = r2;	 Catch:{ Exception -> 0x02c9, all -> 0x02b4 }
                            r0 = 0;
                            r3 = r0;
                            r2 = r8;
                        L_0x00a7:
                            r0 = 2;
                            if (r3 >= r0) goto L_0x00c8;
                        L_0x00aa:
                            r0 = r4[r3];	 Catch:{ Exception -> 0x01d3, all -> 0x02b7 }
                            r5 = r14.lvZ;	 Catch:{ Exception -> 0x019a, all -> 0x02b7 }
                            r2 = com.tencent.wcdb.repair.RepairKit.MasterInfo.load(r0, r9, r5);	 Catch:{ Exception -> 0x019a, all -> 0x02b7 }
                            r5 = "MicroMsg.SubCoreDBBackup";
                            r6 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x019a, all -> 0x02b7 }
                            r7 = "Loaded saved master: ";
                            r6.<init>(r7);	 Catch:{ Exception -> 0x019a, all -> 0x02b7 }
                            r0 = r6.append(r0);	 Catch:{ Exception -> 0x019a, all -> 0x02b7 }
                            r0 = r0.toString();	 Catch:{ Exception -> 0x019a, all -> 0x02b7 }
                            com.tencent.mm.sdk.platformtools.x.i(r5, r0);	 Catch:{ Exception -> 0x019a, all -> 0x02b7 }
                        L_0x00c8:
                            if (r2 != 0) goto L_0x01ba;
                        L_0x00ca:
                            r0 = r14.lvZ;	 Catch:{ Exception -> 0x01d3, all -> 0x02b7 }
                            r2 = com.tencent.wcdb.repair.RepairKit.MasterInfo.make(r0);	 Catch:{ Exception -> 0x01d3, all -> 0x02b7 }
                            r0 = "MicroMsg.SubCoreDBBackup";
                            r3 = "Saved master not available.";
                            com.tencent.mm.sdk.platformtools.x.w(r0, r3);	 Catch:{ Exception -> 0x01d3, all -> 0x02b7 }
                            r3 = com.tencent.mm.plugin.report.service.g.pWK;	 Catch:{ Exception -> 0x01d3, all -> 0x02b7 }
                            r4 = 181; // 0xb5 float:2.54E-43 double:8.94E-322;
                            r6 = 32;
                            r8 = 1;
                            r10 = 1;
                            r3.a(r4, r6, r8, r10);	 Catch:{ Exception -> 0x01d3, all -> 0x02b7 }
                        L_0x00e5:
                            r0 = com.tencent.mm.plugin.dbbackup.d.this;	 Catch:{ Exception -> 0x01d3, all -> 0x02b7 }
                            r3 = new com.tencent.wcdb.repair.RepairKit;	 Catch:{ Exception -> 0x01d3, all -> 0x02b7 }
                            r4 = r13;	 Catch:{ Exception -> 0x01d3, all -> 0x02b7 }
                            r5 = com.tencent.mm.plugin.dbbackup.d.lvJ;	 Catch:{ Exception -> 0x01d3, all -> 0x02b7 }
                            r3.<init>(r4, r1, r5, r2);	 Catch:{ Exception -> 0x01d3, all -> 0x02b7 }
                            r0.lvv = r3;	 Catch:{ Exception -> 0x01d3, all -> 0x02b7 }
                            r0 = com.tencent.mm.plugin.dbbackup.d.this;	 Catch:{ Exception -> 0x01d3, all -> 0x02b7 }
                            r0 = r0.lvv;	 Catch:{ Exception -> 0x01d3, all -> 0x02b7 }
                            r1 = 1;
                            r0 = r0.output(r11, r1);	 Catch:{ Exception -> 0x01d3, all -> 0x02b7 }
                            if (r0 != 0) goto L_0x0249;
                        L_0x0102:
                            r0 = 1;
                            r1 = r0;
                        L_0x0104:
                            r0 = com.tencent.mm.plugin.dbbackup.d.this;	 Catch:{ Exception -> 0x01d3, all -> 0x02b7 }
                            r0 = r0.lvv;	 Catch:{ Exception -> 0x01d3, all -> 0x02b7 }
                            r0 = r0.isHeaderCorrupted();	 Catch:{ Exception -> 0x01d3, all -> 0x02b7 }
                            if (r0 == 0) goto L_0x011c;
                        L_0x0110:
                            r0 = com.tencent.mm.plugin.dbbackup.d.this;	 Catch:{ Exception -> 0x01d3, all -> 0x02b7 }
                            r0 = r0.lvv;	 Catch:{ Exception -> 0x01d3, all -> 0x02b7 }
                            r0 = r0.isDataCorrupted();	 Catch:{ Exception -> 0x01d3, all -> 0x02b7 }
                            if (r0 != 0) goto L_0x024d;
                        L_0x011c:
                            r0 = 1;
                        L_0x011d:
                            r1 = r1 & r0;
                            r11.close();	 Catch:{ Exception -> 0x01d3, all -> 0x02b7 }
                            r9 = 0;
                            r2.release();	 Catch:{ Exception -> 0x02ce, all -> 0x02ba }
                            r10 = 0;
                            r0 = com.tencent.mm.plugin.dbbackup.d.this;	 Catch:{ Exception -> 0x0280, all -> 0x02be }
                            r0 = r0.lvv;	 Catch:{ Exception -> 0x0280, all -> 0x02be }
                            r0.release();	 Catch:{ Exception -> 0x0280, all -> 0x02be }
                            r0 = com.tencent.mm.plugin.dbbackup.d.this;	 Catch:{ Exception -> 0x0280, all -> 0x02be }
                            r2 = 0;
                            r0.lvv = r2;	 Catch:{ Exception -> 0x0280, all -> 0x02be }
                            com.tencent.mm.plugin.dbbackup.d.aAm();	 Catch:{ Exception -> 0x0280, all -> 0x02be }
                            r2 = java.lang.System.nanoTime();	 Catch:{ Exception -> 0x0280, all -> 0x02be }
                            r2 = r2 - r12;
                            r4 = "MicroMsg.SubCoreDBBackup";
                            r5 = "DB repair %s, elapsed %.2f seconds.";
                            r0 = 2;
                            r6 = new java.lang.Object[r0];	 Catch:{ Exception -> 0x0280, all -> 0x02be }
                            r7 = 0;
                            if (r1 == 0) goto L_0x0250;
                        L_0x0149:
                            r0 = "succeeded";
                        L_0x014c:
                            r6[r7] = r0;	 Catch:{ Exception -> 0x0280, all -> 0x02be }
                            r0 = 1;
                            r2 = (float) r2;	 Catch:{ Exception -> 0x0280, all -> 0x02be }
                            r3 = 1315859240; // 0x4e6e6b28 float:1.0E9 double:6.50120845E-315;
                            r2 = r2 / r3;
                            r2 = java.lang.Float.valueOf(r2);	 Catch:{ Exception -> 0x0280, all -> 0x02be }
                            r6[r0] = r2;	 Catch:{ Exception -> 0x0280, all -> 0x02be }
                            com.tencent.mm.sdk.platformtools.x.i(r4, r5, r6);	 Catch:{ Exception -> 0x0280, all -> 0x02be }
                            if (r1 == 0) goto L_0x0255;
                        L_0x015f:
                            r0 = 26;
                            r1 = r14;	 Catch:{ Exception -> 0x0280, all -> 0x02be }
                            if (r1 == 0) goto L_0x016b;
                        L_0x0165:
                            r1 = r14;	 Catch:{ Exception -> 0x0280, all -> 0x02be }
                            r2 = 0;
                            r1.oM(r2);	 Catch:{ Exception -> 0x0280, all -> 0x02be }
                        L_0x016b:
                            r1 = com.tencent.mm.plugin.report.service.g.pWK;	 Catch:{ Exception -> 0x0280, all -> 0x02be }
                            r2 = 181; // 0xb5 float:2.54E-43 double:8.94E-322;
                            r4 = (long) r0;	 Catch:{ Exception -> 0x0280, all -> 0x02be }
                            r6 = 1;
                            r8 = 1;
                            r1.a(r2, r4, r6, r8);	 Catch:{ Exception -> 0x0280, all -> 0x02be }
                            r0 = com.tencent.mm.plugin.dbbackup.d.this;
                            r0 = r0.lvv;
                            if (r0 == 0) goto L_0x018d;
                        L_0x017e:
                            r0 = com.tencent.mm.plugin.dbbackup.d.this;
                            r0 = r0.lvv;
                            r0.release();
                            r0 = com.tencent.mm.plugin.dbbackup.d.this;
                            r1 = 0;
                            r0.lvv = r1;
                        L_0x018d:
                            r0 = com.tencent.mm.plugin.dbbackup.d.this;
                            r0.lvw = false;
                            r0 = com.tencent.mm.y.as.Dt();
                            r0.cgr();
                        L_0x0199:
                            return;
                        L_0x019a:
                            r0 = move-exception;
                            r5 = "MicroMsg.SubCoreDBBackup";
                            r6 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x01d3, all -> 0x02b7 }
                            r7 = "Failed to load saved master: ";
                            r6.<init>(r7);	 Catch:{ Exception -> 0x01d3, all -> 0x02b7 }
                            r0 = r0.getMessage();	 Catch:{ Exception -> 0x01d3, all -> 0x02b7 }
                            r0 = r6.append(r0);	 Catch:{ Exception -> 0x01d3, all -> 0x02b7 }
                            r0 = r0.toString();	 Catch:{ Exception -> 0x01d3, all -> 0x02b7 }
                            com.tencent.mm.sdk.platformtools.x.e(r5, r0);	 Catch:{ Exception -> 0x01d3, all -> 0x02b7 }
                            r0 = r3 + 1;
                            r3 = r0;
                            goto L_0x00a7;
                        L_0x01ba:
                            if (r3 <= 0) goto L_0x00e5;
                        L_0x01bc:
                            r0 = "MicroMsg.SubCoreDBBackup";
                            r3 = "Use backup saved master.";
                            com.tencent.mm.sdk.platformtools.x.i(r0, r3);	 Catch:{ Exception -> 0x01d3, all -> 0x02b7 }
                            r3 = com.tencent.mm.plugin.report.service.g.pWK;	 Catch:{ Exception -> 0x01d3, all -> 0x02b7 }
                            r4 = 181; // 0xb5 float:2.54E-43 double:8.94E-322;
                            r6 = 33;
                            r8 = 1;
                            r10 = 1;
                            r3.a(r4, r6, r8, r10);	 Catch:{ Exception -> 0x01d3, all -> 0x02b7 }
                            goto L_0x00e5;
                        L_0x01d3:
                            r0 = move-exception;
                            r9 = r11;
                            r10 = r2;
                        L_0x01d6:
                            r1 = "MicroMsg.SubCoreDBBackup";
                            r2 = "Failed to repair database '%s'";
                            r3 = 1;
                            r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x02c1 }
                            r4 = 0;
                            r5 = r13;	 Catch:{ all -> 0x02c1 }
                            r3[r4] = r5;	 Catch:{ all -> 0x02c1 }
                            com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r1, r0, r2, r3);	 Catch:{ all -> 0x02c1 }
                            r0 = r14;	 Catch:{ all -> 0x02c1 }
                            if (r0 == 0) goto L_0x01f1;
                        L_0x01eb:
                            r0 = r14;	 Catch:{ all -> 0x02c1 }
                            r1 = -1;
                            r0.oM(r1);	 Catch:{ all -> 0x02c1 }
                        L_0x01f1:
                            r0 = com.tencent.mm.plugin.report.service.g.pWK;	 Catch:{ all -> 0x02c1 }
                            r1 = "DBRepair";
                            r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x02c1 }
                            r3 = "Repair failed: ";
                            r2.<init>(r3);	 Catch:{ all -> 0x02c1 }
                            r3 = com.tencent.wcdb.repair.RepairKit.lastError();	 Catch:{ all -> 0x02c1 }
                            r2 = r2.append(r3);	 Catch:{ all -> 0x02c1 }
                            r2 = r2.toString();	 Catch:{ all -> 0x02c1 }
                            r3 = 0;
                            r0.c(r1, r2, r3);	 Catch:{ all -> 0x02c1 }
                            r1 = com.tencent.mm.plugin.report.service.g.pWK;	 Catch:{ all -> 0x02c1 }
                            r2 = 181; // 0xb5 float:2.54E-43 double:8.94E-322;
                            r4 = 27;
                            r6 = 1;
                            r8 = 1;
                            r1.a(r2, r4, r6, r8);	 Catch:{ all -> 0x02c1 }
                            r0 = com.tencent.mm.plugin.dbbackup.d.this;
                            r0 = r0.lvv;
                            if (r0 == 0) goto L_0x0231;
                        L_0x0222:
                            r0 = com.tencent.mm.plugin.dbbackup.d.this;
                            r0 = r0.lvv;
                            r0.release();
                            r0 = com.tencent.mm.plugin.dbbackup.d.this;
                            r1 = 0;
                            r0.lvv = r1;
                        L_0x0231:
                            if (r9 == 0) goto L_0x0236;
                        L_0x0233:
                            r9.close();
                        L_0x0236:
                            if (r10 == 0) goto L_0x023b;
                        L_0x0238:
                            r10.release();
                        L_0x023b:
                            r0 = com.tencent.mm.plugin.dbbackup.d.this;
                            r0.lvw = false;
                            r0 = com.tencent.mm.y.as.Dt();
                            r0.cgr();
                            goto L_0x0199;
                        L_0x0249:
                            r0 = 0;
                            r1 = r0;
                            goto L_0x0104;
                        L_0x024d:
                            r0 = 0;
                            goto L_0x011d;
                        L_0x0250:
                            r0 = "failed";
                            goto L_0x014c;
                        L_0x0255:
                            r0 = 27;
                            r1 = r14;	 Catch:{ Exception -> 0x0280, all -> 0x02be }
                            if (r1 == 0) goto L_0x0261;
                        L_0x025b:
                            r1 = r14;	 Catch:{ Exception -> 0x0280, all -> 0x02be }
                            r2 = -1;
                            r1.oM(r2);	 Catch:{ Exception -> 0x0280, all -> 0x02be }
                        L_0x0261:
                            r1 = com.tencent.mm.plugin.report.service.g.pWK;	 Catch:{ Exception -> 0x0280, all -> 0x02be }
                            r2 = "DBRepair";
                            r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0280, all -> 0x02be }
                            r4 = "Repair failed: ";
                            r3.<init>(r4);	 Catch:{ Exception -> 0x0280, all -> 0x02be }
                            r4 = com.tencent.wcdb.repair.RepairKit.lastError();	 Catch:{ Exception -> 0x0280, all -> 0x02be }
                            r3 = r3.append(r4);	 Catch:{ Exception -> 0x0280, all -> 0x02be }
                            r3 = r3.toString();	 Catch:{ Exception -> 0x0280, all -> 0x02be }
                            r4 = 0;
                            r1.c(r2, r3, r4);	 Catch:{ Exception -> 0x0280, all -> 0x02be }
                            goto L_0x016b;
                        L_0x0280:
                            r0 = move-exception;
                            goto L_0x01d6;
                        L_0x0283:
                            r0 = move-exception;
                            r11 = r7;
                            r10 = r8;
                        L_0x0286:
                            r1 = com.tencent.mm.plugin.dbbackup.d.this;
                            r1 = r1.lvv;
                            if (r1 == 0) goto L_0x029d;
                        L_0x028e:
                            r1 = com.tencent.mm.plugin.dbbackup.d.this;
                            r1 = r1.lvv;
                            r1.release();
                            r1 = com.tencent.mm.plugin.dbbackup.d.this;
                            r2 = 0;
                            r1.lvv = r2;
                        L_0x029d:
                            if (r11 == 0) goto L_0x02a2;
                        L_0x029f:
                            r11.close();
                        L_0x02a2:
                            if (r10 == 0) goto L_0x02a7;
                        L_0x02a4:
                            r10.release();
                        L_0x02a7:
                            r1 = com.tencent.mm.plugin.dbbackup.d.this;
                            r1.lvw = false;
                            r1 = com.tencent.mm.y.as.Dt();
                            r1.cgr();
                            throw r0;
                        L_0x02b4:
                            r0 = move-exception;
                            r10 = r8;
                            goto L_0x0286;
                        L_0x02b7:
                            r0 = move-exception;
                            r10 = r2;
                            goto L_0x0286;
                        L_0x02ba:
                            r0 = move-exception;
                            r11 = r9;
                            r10 = r2;
                            goto L_0x0286;
                        L_0x02be:
                            r0 = move-exception;
                            r11 = r9;
                            goto L_0x0286;
                        L_0x02c1:
                            r0 = move-exception;
                            r11 = r9;
                            goto L_0x0286;
                        L_0x02c4:
                            r0 = move-exception;
                            r9 = r7;
                            r10 = r8;
                            goto L_0x01d6;
                        L_0x02c9:
                            r0 = move-exception;
                            r9 = r11;
                            r10 = r8;
                            goto L_0x01d6;
                        L_0x02ce:
                            r0 = move-exception;
                            r10 = r2;
                            goto L_0x01d6;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.dbbackup.d.3.run():void");
                        }
                    };
                    this.lvw = true;
                    as.Dt().tT();
                    as.Dt().J(anonymousClass3);
                }
            }
        }
        return i;
    }

    @Deprecated
    public final int a(final b bVar) {
        as.Hm();
        String CX = com.tencent.mm.y.c.CX();
        if (CX == null || CX.isEmpty()) {
            return -3;
        }
        final File file = new File(CX);
        if (!file.canRead()) {
            return -3;
        }
        StringBuilder append = new StringBuilder().append(q.yL());
        as.Hm();
        final String substring = com.tencent.mm.a.g.s(append.append(com.tencent.mm.y.c.Cn()).toString().getBytes()).substring(0, 7);
        x.i("MicroMsg.SubCoreDBBackup", "db recover needSize : %d blockSize:%d", Long.valueOf(file.length() * 2), Long.valueOf(bi.chh()));
        if (bi.chh() < file.length() * 2) {
            return -2;
        }
        as.Dt().tT();
        as.Dt().J(new Runnable() {
            public final void run() {
                int i;
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                }
                as.Hm();
                String FI = com.tencent.mm.y.c.FI();
                String str = FI + file.getName().replace(".db", "temp.db");
                x.i("MicroMsg.SubCoreDBBackup", "temp db path is %s", str);
                file.renameTo(new File(str));
                String str2 = FI + "sqlTemp.sql";
                List asList = Arrays.asList(new String[]{"getcontactinfo", "contact", "contact_ext", "ContactCmdBuf", "rcontact", "img_flag", "userinfo"});
                final int[] iArr = new int[1];
                long currentTimeMillis = System.currentTimeMillis();
                as.Hm();
                boolean a = com.tencent.mm.y.c.Fc().a(str, substring, str2, asList, new ExecuteSqlCallback() {
                    public final String preExecute(String str) {
                        int[] iArr = iArr;
                        iArr[0] = iArr[0] + 1;
                        return null;
                    }
                });
                if (a) {
                    as.Hm();
                    com.tencent.mm.y.c.Fh().aZS();
                    as.Hm();
                    com.tencent.mm.y.c.Fk().cjr();
                    as.Hm();
                    com.tencent.mm.y.c.Fh().aZU();
                    as.Hm();
                    com.tencent.mm.y.c.Fh().aZT();
                    i = 12;
                } else {
                    i = 15;
                }
                g.pWK.a(181, (long) i, 1, true);
                x.i("MicroMsg.SubCoreDBBackup", "execute %d sql and last %d", Integer.valueOf(iArr[0]), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                g gVar = g.pWK;
                Object[] objArr = new Object[3];
                objArr[0] = Integer.valueOf(a ? 1 : 0);
                objArr[1] = iArr;
                objArr[2] = Long.valueOf(r2);
                gVar.h(11224, objArr);
                as.Dt().cgr();
                if (bVar != null) {
                    bVar.oM(a ? 0 : -1);
                }
            }
        });
        return 0;
    }

    public final HashMap<Integer, com.tencent.mm.bx.h.d> Bu() {
        return null;
    }

    public final void ge(int i) {
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void bs(boolean r12) {
        /*
        r11 = this;
        r10 = 3;
        r9 = 2;
        r2 = 0;
        r1 = 1;
        r8 = 0;
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r3 = com.tencent.mm.kernel.g.Dq();
        r3 = r3.cachePath;
        r0 = r0.append(r3);
        r3 = "account.lck";
        r0 = r0.append(r3);
        r4 = r0.toString();
        r11.lvF = r4;
        r0 = new com.tencent.mm.sdk.platformtools.FLock;	 Catch:{ a -> 0x0345, Exception -> 0x0342, all -> 0x0334 }
        r0.<init>(r4);	 Catch:{ a -> 0x0345, Exception -> 0x0342, all -> 0x0334 }
        r11.lvG = r0;	 Catch:{ a -> 0x0345, Exception -> 0x0342, all -> 0x0334 }
        r0 = r11.lvG;	 Catch:{ a -> 0x0345, Exception -> 0x0342, all -> 0x0334 }
        r0 = r0.cfG();	 Catch:{ a -> 0x0345, Exception -> 0x0342, all -> 0x0334 }
        if (r0 == 0) goto L_0x0216;
    L_0x0030:
        r0 = new java.io.FileWriter;	 Catch:{ a -> 0x0345, Exception -> 0x0342, all -> 0x0334 }
        r0.<init>(r4);	 Catch:{ a -> 0x0345, Exception -> 0x0342, all -> 0x0334 }
        r3 = android.os.Process.myPid();	 Catch:{ a -> 0x0345, Exception -> 0x0342, all -> 0x0334 }
        r3 = java.lang.Integer.toString(r3);	 Catch:{ a -> 0x0345, Exception -> 0x0342, all -> 0x0334 }
        r0.write(r3);	 Catch:{ a -> 0x0345, Exception -> 0x0342, all -> 0x0334 }
        r0.close();	 Catch:{ a -> 0x0345, Exception -> 0x0342, all -> 0x0334 }
        r0 = "MicroMsg.DuplicateDetect";
        r3 = "No account multiple instances detected.";
        com.tencent.mm.sdk.platformtools.x.i(r0, r3);	 Catch:{ a -> 0x0345, Exception -> 0x0342, all -> 0x0334 }
        r3 = r2;
    L_0x004d:
        if (r3 == 0) goto L_0x0052;
    L_0x004f:
        r3.close();	 Catch:{ IOException -> 0x032f }
    L_0x0052:
        com.tencent.mm.y.as.Hm();
        r0 = com.tencent.mm.y.c.Db();
        r3 = com.tencent.mm.y.c.Fc();
        r3 = r3.clK();
        r4 = 237569; // 0x3a001 float:3.32905E-40 double:1.173747E-318;
        r4 = r0.DF(r4);
        r11.lvB = r4;
        r4 = 237570; // 0x3a002 float:3.32906E-40 double:1.17375E-318;
        r5 = 10;
        r4 = r0.getInt(r4, r5);
        r11.lvC = r4;
        r4 = 237571; // 0x3a003 float:3.32908E-40 double:1.173757E-318;
        r0 = r0.getInt(r4, r8);
        if (r0 == 0) goto L_0x0308;
    L_0x007e:
        r0 = r1;
    L_0x007f:
        r11.lvD = r0;
        r4 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r0 = new android.content.IntentFilter;
        r5 = "android.intent.action.BATTERY_CHANGED";
        r0.<init>(r5);
        r0 = r4.registerReceiver(r2, r0);
        if (r0 == 0) goto L_0x030e;
    L_0x0093:
        r2 = "status";
        r5 = -1;
        r0 = r0.getIntExtra(r2, r5);
        if (r0 == r9) goto L_0x00a0;
    L_0x009d:
        r2 = 5;
        if (r0 != r2) goto L_0x030b;
    L_0x00a0:
        r0 = r1;
    L_0x00a1:
        r11.hIr = r0;
    L_0x00a3:
        r0 = "power";
        r0 = r4.getSystemService(r0);
        r0 = (android.os.PowerManager) r0;
        r0 = r0.isScreenOn();
        r11.hIs = r0;
        r0 = new com.tencent.mm.plugin.dbbackup.d$7;
        r0.<init>();
        r11.lvH = r0;
        r0 = com.tencent.mm.y.c.c.IL();
        r2 = r11.lvH;
        r0.c(r2);
        aAl();
        r0 = new com.tencent.mm.plugin.dbbackup.d$8;
        r0.<init>();
        r11.lvI = r0;
        r0 = com.tencent.mm.sdk.b.a.xmy;
        r2 = r11.lvI;
        r0.b(r2);
        r0 = new com.tencent.mm.plugin.dbbackup.d$9;
        r0.<init>();
        r11.hIq = r0;
        r0 = new android.content.IntentFilter;
        r0.<init>();
        r2 = "android.intent.action.SCREEN_ON";
        r0.addAction(r2);
        r2 = "android.intent.action.SCREEN_OFF";
        r0.addAction(r2);
        r2 = "android.intent.action.ACTION_POWER_CONNECTED";
        r0.addAction(r2);
        r2 = "android.intent.action.ACTION_POWER_DISCONNECTED";
        r0.addAction(r2);
        r2 = r11.hIq;
        r4.registerReceiver(r2, r0);
        r0 = new com.tencent.mm.plugin.dbbackup.c;
        r0.<init>(r11);
        r2 = 9;
        r2 = new java.lang.String[r2];
        r4 = "//recover-old";
        r2[r8] = r4;
        r4 = "//recover";
        r2[r1] = r4;
        r4 = "//post-recover";
        r2[r9] = r4;
        r4 = "//backupdb";
        r2[r10] = r4;
        r4 = 4;
        r5 = "//recoverdb";
        r2[r4] = r5;
        r4 = 5;
        r5 = "//repairdb";
        r2[r4] = r5;
        r4 = 6;
        r5 = "//corruptdb";
        r2[r4] = r5;
        r4 = 7;
        r5 = "//iotracedb";
        r2[r4] = r5;
        r4 = 8;
        r5 = "//recover-status";
        r2[r4] = r5;
        com.tencent.mm.pluginsdk.cmd.b.a(r0, r2);
        r2 = "MicroMsg.SubCoreDBBackup";
        r4 = "Auto database backup %s. Device status:%s interactive,%s charging.";
        r5 = new java.lang.Object[r10];
        r0 = r11.lvy;
        if (r0 == 0) goto L_0x0312;
    L_0x0147:
        r0 = "enabled";
    L_0x014a:
        r5[r8] = r0;
        r0 = r11.hIs;
        if (r0 == 0) goto L_0x0317;
    L_0x0150:
        r0 = "";
    L_0x0153:
        r5[r1] = r0;
        r0 = r11.hIr;
        if (r0 == 0) goto L_0x031c;
    L_0x0159:
        r0 = "";
    L_0x015c:
        r5[r9] = r0;
        com.tencent.mm.sdk.platformtools.x.i(r2, r4, r5);
        r0 = r3.getPath();
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r0 = r2.append(r0);
        r2 = ".sm";
        r0 = r0.append(r2);
        r0 = r0.toString();
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r2 = r2.append(r0);
        r4 = ".tmp";
        r2 = r2.append(r4);
        r2 = r2.toString();
        r4 = new java.io.File;
        r4.<init>(r0);
        r0 = r4.isFile();
        if (r0 != 0) goto L_0x0202;
    L_0x0198:
        r6 = java.lang.System.nanoTime();
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r5 = com.tencent.mm.compatible.e.q.yL();
        r0 = r0.append(r5);
        com.tencent.mm.y.as.Hm();
        r5 = com.tencent.mm.y.c.Cn();
        r0 = r0.append(r5);
        r0 = r0.toString();
        r0 = r0.getBytes();
        r0 = com.tencent.mm.a.g.t(r0);
        r0 = com.tencent.wcdb.repair.RepairKit.MasterInfo.save(r3, r2, r0);
        r3 = new java.io.File;
        r3.<init>(r2);
        if (r0 == 0) goto L_0x0321;
    L_0x01cb:
        r4.delete();
        r0 = r3.renameTo(r4);
    L_0x01d2:
        r2 = java.lang.System.nanoTime();
        r4 = r2 - r6;
        r3 = "MicroMsg.SubCoreDBBackup";
        r6 = "Master table backup %s, elapsed %.3f";
        r7 = new java.lang.Object[r9];
        if (r0 == 0) goto L_0x0326;
    L_0x01e2:
        r2 = "SUCCEEDED";
    L_0x01e5:
        r7[r8] = r2;
        r2 = (float) r4;
        r4 = 1315859240; // 0x4e6e6b28 float:1.0E9 double:6.50120845E-315;
        r2 = r2 / r4;
        r2 = java.lang.Float.valueOf(r2);
        r7[r1] = r2;
        com.tencent.mm.sdk.platformtools.x.i(r3, r6, r7);
        r1 = com.tencent.mm.plugin.report.service.g.pWK;
        r2 = 181; // 0xb5 float:2.54E-43 double:8.94E-322;
        if (r0 == 0) goto L_0x032b;
    L_0x01fb:
        r4 = 24;
    L_0x01fd:
        r6 = 1;
        r1.a(r2, r4, r6, r8);
    L_0x0202:
        r0 = com.tencent.mm.y.c.FI();
        r1 = com.tencent.mm.y.as.Dt();
        r2 = new com.tencent.mm.plugin.dbbackup.d$6;
        r2.<init>(r0);
        r4 = 60000; // 0xea60 float:8.4078E-41 double:2.9644E-319;
        r1.g(r2, r4);
        return;
    L_0x0216:
        r3 = new java.io.BufferedReader;	 Catch:{ a -> 0x0345, Exception -> 0x0342, all -> 0x0334 }
        r0 = new java.io.FileReader;	 Catch:{ a -> 0x0345, Exception -> 0x0342, all -> 0x0334 }
        r0.<init>(r4);	 Catch:{ a -> 0x0345, Exception -> 0x0342, all -> 0x0334 }
        r3.<init>(r0);	 Catch:{ a -> 0x0345, Exception -> 0x0342, all -> 0x0334 }
        r0 = r3.readLine();	 Catch:{ a -> 0x0349, Exception -> 0x02cf, all -> 0x0336 }
        if (r0 != 0) goto L_0x02bb;
    L_0x0226:
        r0 = r8;
    L_0x0227:
        r3.close();	 Catch:{ a -> 0x0349, Exception -> 0x02cf, all -> 0x0336 }
        if (r0 == 0) goto L_0x034d;
    L_0x022c:
        r3 = android.os.Process.myPid();	 Catch:{ a -> 0x0345, Exception -> 0x0342, all -> 0x0334 }
        if (r0 == r3) goto L_0x034d;
    L_0x0232:
        r5 = new java.io.File;	 Catch:{ a -> 0x0345, Exception -> 0x0342, all -> 0x0334 }
        r3 = new java.lang.StringBuilder;	 Catch:{ a -> 0x0345, Exception -> 0x0342, all -> 0x0334 }
        r6 = "/proc/";
        r3.<init>(r6);	 Catch:{ a -> 0x0345, Exception -> 0x0342, all -> 0x0334 }
        r3 = r3.append(r0);	 Catch:{ a -> 0x0345, Exception -> 0x0342, all -> 0x0334 }
        r6 = "/status";
        r3 = r3.append(r6);	 Catch:{ a -> 0x0345, Exception -> 0x0342, all -> 0x0334 }
        r3 = r3.toString();	 Catch:{ a -> 0x0345, Exception -> 0x0342, all -> 0x0334 }
        r5.<init>(r3);	 Catch:{ a -> 0x0345, Exception -> 0x0342, all -> 0x0334 }
        r3 = r5.isFile();	 Catch:{ a -> 0x0345, Exception -> 0x0342, all -> 0x0334 }
        if (r3 == 0) goto L_0x034d;
    L_0x0254:
        r3 = r5.canRead();	 Catch:{ a -> 0x0345, Exception -> 0x0342, all -> 0x0334 }
        if (r3 == 0) goto L_0x034d;
    L_0x025a:
        r3 = new java.io.BufferedReader;	 Catch:{ a -> 0x0345, Exception -> 0x0342, all -> 0x0334 }
        r6 = new java.io.FileReader;	 Catch:{ a -> 0x0345, Exception -> 0x0342, all -> 0x0334 }
        r6.<init>(r5);	 Catch:{ a -> 0x0345, Exception -> 0x0342, all -> 0x0334 }
        r3.<init>(r6);	 Catch:{ a -> 0x0345, Exception -> 0x0342, all -> 0x0334 }
    L_0x0264:
        r5 = r3.readLine();	 Catch:{ all -> 0x02ab }
        if (r5 == 0) goto L_0x02c1;
    L_0x026a:
        r6 = "State:";
        r6 = r5.startsWith(r6);	 Catch:{ all -> 0x02ab }
        if (r6 == 0) goto L_0x0264;
    L_0x0273:
        r6 = ": \\t";
        r5 = r5.split(r6);	 Catch:{ all -> 0x02ab }
        r6 = r5.length;	 Catch:{ all -> 0x02ab }
        if (r6 <= r1) goto L_0x02c1;
    L_0x027d:
        r6 = 1;
        r6 = r5[r6];	 Catch:{ all -> 0x02ab }
        r7 = "S";
        r6 = r6.equals(r7);	 Catch:{ all -> 0x02ab }
        if (r6 != 0) goto L_0x0295;
    L_0x0289:
        r6 = 1;
        r5 = r5[r6];	 Catch:{ all -> 0x02ab }
        r6 = "R";
        r5 = r5.equals(r6);	 Catch:{ all -> 0x02ab }
        if (r5 == 0) goto L_0x02c1;
    L_0x0295:
        r5 = new com.tencent.mm.plugin.dbbackup.d$a;	 Catch:{ all -> 0x02ab }
        r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x02ab }
        r7 = "Multiple instances of WeChat with same account detected. Last PID: ";
        r6.<init>(r7);	 Catch:{ all -> 0x02ab }
        r0 = r6.append(r0);	 Catch:{ all -> 0x02ab }
        r0 = r0.toString();	 Catch:{ all -> 0x02ab }
        r5.<init>(r0);	 Catch:{ all -> 0x02ab }
        throw r5;	 Catch:{ all -> 0x02ab }
    L_0x02ab:
        r0 = move-exception;
        r3.close();	 Catch:{ a -> 0x02b0, Exception -> 0x02cf, all -> 0x033a }
        throw r0;	 Catch:{ a -> 0x02b0, Exception -> 0x02cf, all -> 0x033a }
    L_0x02b0:
        r0 = move-exception;
        r1 = r3;
    L_0x02b2:
        throw r0;	 Catch:{ all -> 0x02b3 }
    L_0x02b3:
        r0 = move-exception;
        r2 = r1;
    L_0x02b5:
        if (r2 == 0) goto L_0x02ba;
    L_0x02b7:
        r2.close();	 Catch:{ IOException -> 0x0332 }
    L_0x02ba:
        throw r0;
    L_0x02bb:
        r0 = com.tencent.mm.sdk.platformtools.bi.Wo(r0);	 Catch:{ a -> 0x0349, Exception -> 0x02cf, all -> 0x0336 }
        goto L_0x0227;
    L_0x02c1:
        r3.close();	 Catch:{ a -> 0x02b0, Exception -> 0x02cf, all -> 0x033a }
    L_0x02c4:
        r0 = "MicroMsg.DuplicateDetect";
        r5 = "Account reentrant within same process detected.";
        com.tencent.mm.sdk.platformtools.x.i(r0, r5);	 Catch:{ a -> 0x02b0, Exception -> 0x02cf, all -> 0x033a }
        goto L_0x004d;
    L_0x02cf:
        r0 = move-exception;
    L_0x02d0:
        r5 = "MicroMsg.DuplicateDetect";
        r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x033e }
        r7 = "Failed to initialize lock file: ";
        r6.<init>(r7);	 Catch:{ all -> 0x033e }
        r4 = r6.append(r4);	 Catch:{ all -> 0x033e }
        r4 = r4.toString();	 Catch:{ all -> 0x033e }
        r6 = 0;
        r6 = new java.lang.Object[r6];	 Catch:{ all -> 0x033e }
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r5, r0, r4, r6);	 Catch:{ all -> 0x033e }
        r0 = r11.lvG;	 Catch:{ all -> 0x033e }
        r0.unlock();	 Catch:{ all -> 0x033e }
        r0 = 0;
        r11.lvG = r0;	 Catch:{ all -> 0x033e }
        r0 = new java.io.File;	 Catch:{ all -> 0x033e }
        r4 = r11.lvF;	 Catch:{ all -> 0x033e }
        r0.<init>(r4);	 Catch:{ all -> 0x033e }
        r0.delete();	 Catch:{ all -> 0x033e }
        r0 = 0;
        r11.lvF = r0;	 Catch:{ all -> 0x033e }
        if (r3 == 0) goto L_0x0052;
    L_0x0300:
        r3.close();	 Catch:{ IOException -> 0x0305 }
        goto L_0x0052;
    L_0x0305:
        r0 = move-exception;
        goto L_0x0052;
    L_0x0308:
        r0 = r8;
        goto L_0x007f;
    L_0x030b:
        r0 = r8;
        goto L_0x00a1;
    L_0x030e:
        r11.hIr = r8;
        goto L_0x00a3;
    L_0x0312:
        r0 = "disabled";
        goto L_0x014a;
    L_0x0317:
        r0 = " not";
        goto L_0x0153;
    L_0x031c:
        r0 = " not";
        goto L_0x015c;
    L_0x0321:
        r3.delete();
        goto L_0x01d2;
    L_0x0326:
        r2 = "FAILED";
        goto L_0x01e5;
    L_0x032b:
        r4 = 25;
        goto L_0x01fd;
    L_0x032f:
        r0 = move-exception;
        goto L_0x0052;
    L_0x0332:
        r1 = move-exception;
        goto L_0x02ba;
    L_0x0334:
        r0 = move-exception;
        goto L_0x02b5;
    L_0x0336:
        r0 = move-exception;
        r2 = r3;
        goto L_0x02b5;
    L_0x033a:
        r0 = move-exception;
        r2 = r3;
        goto L_0x02b5;
    L_0x033e:
        r0 = move-exception;
        r2 = r3;
        goto L_0x02b5;
    L_0x0342:
        r0 = move-exception;
        r3 = r2;
        goto L_0x02d0;
    L_0x0345:
        r0 = move-exception;
        r1 = r2;
        goto L_0x02b2;
    L_0x0349:
        r0 = move-exception;
        r1 = r3;
        goto L_0x02b2;
    L_0x034d:
        r3 = r2;
        goto L_0x02c4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.dbbackup.d.bs(boolean):void");
    }

    public final void bt(boolean z) {
    }

    public final void onAccountRelease() {
        aAk();
        this.lvx = false;
        if (this.hIu != null) {
            as.Dt().cgs().removeCallbacks(this.hIu);
            this.hIu = null;
        }
        if (this.lvI != null) {
            com.tencent.mm.sdk.b.a.xmy.c(this.lvI);
            this.lvI = null;
        }
        if (this.hIq != null) {
            ad.getContext().unregisterReceiver(this.hIq);
            this.hIq = null;
        }
        b.D("//recover-old", "//recover", "//post-recover", "//backupdb", "//recoverdb", "//repairdb", "//corruptdb", "//iotracedb", "//recover-status");
        if (this.lvG != null && this.lvF != null && this.lvF.length() > 0) {
            this.lvG.unlock();
            this.lvG = null;
            new File(this.lvF).delete();
            this.lvF = null;
            x.i("MicroMsg.DuplicateDetect", "Instance exited.");
        }
    }

    private static void aAl() {
        com.tencent.mm.storage.c fp = com.tencent.mm.y.c.c.IL().fp("100274");
        if (fp.isValid()) {
            Map civ = fp.civ();
            Map hashMap = new HashMap();
            hashMap.put("flags", Integer.valueOf(bi.getInt((String) civ.get("flags"), 0)));
            hashMap.put("acp", Integer.valueOf(bi.getInt((String) civ.get("acp"), 100)));
            f.aw(hashMap);
        }
    }

    static void aAm() {
        com.tencent.mm.plugin.messenger.foundation.a.a.c Fh = com.tencent.mm.y.c.Fh();
        Fh.aZS();
        Fh.aZU();
        Fh.aZT();
        com.tencent.mm.y.c.Fk().cjr();
        o.PC().Pm();
        t Db = com.tencent.mm.y.c.Db();
        Db.a(com.tencent.mm.storage.w.a.USERINFO_EMOJI_NEW_EMOJI_INT, Integer.valueOf(0));
        Db.a(com.tencent.mm.storage.w.a.USERINFO_EMOJI_NEW_PANEL_INT, Integer.valueOf(0));
        Db.a(com.tencent.mm.storage.w.a.USERINFO_EMOJI_NEW_SUGGEST_INT, Integer.valueOf(0));
    }

    public static void cu(Context context) {
        MMAppMgr.b(context, true);
    }

    public static void aAn() {
        MMAppMgr.md(true);
    }
}
