package com.tencent.mm.plugin.dbbackup.a;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.SystemClock;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.report.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.DatabaseUtils;
import com.tencent.wcdb.database.SQLiteCipherSpec;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteDirectCursor;
import com.tencent.wcdb.database.SQLiteDoneException;
import com.tencent.wcdb.database.SQLiteStatement;
import com.tencent.wcdb.repair.RecoverKit;
import com.tencent.wcdb.repair.RepairKit;
import com.tencent.wcdb.repair.RepairKit.Callback;
import com.tencent.wcdb.repair.RepairKit.MasterInfo;
import com.tencent.wcdb.support.CancellationSignal;
import com.tencent.wcdb.support.OperationCanceledException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public final class a extends AsyncTask<Void, Integer, Integer> {
    private static final String[] CONFLICT_VALUES = new String[]{"", " OR ROLLBACK", " OR ABORT", " OR FAIL", " OR IGNORE", " OR REPLACE"};
    private static final SQLiteCipherSpec lwj = new SQLiteCipherSpec().setPageSize(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT).setSQLCipherVersion(1);
    private SQLiteDatabase lwk;
    private String lwl;
    private String lwm;
    private String lwn;
    private String lwo;
    private List<String> lwp;
    private List<String> lwq;
    private byte[] lwr;
    private byte[] lws;
    private boolean lwt;
    private b lwu;
    private boolean lwv;
    private int lww;
    private long lwx;
    private long lwy;
    public final CancellationSignal mCancellationSignal;

    private interface c {
        boolean a(Cursor cursor, SQLiteStatement sQLiteStatement);
    }

    public static class a {
        public String lwl;
        public String lwm;
        public String lwn;
        public String lwo;
        public List<String> lwp = new ArrayList();
        public List<String> lwq = new ArrayList();
        public byte[] lwr;
        public byte[] lws;
        public boolean lwt;
        public b lwu;

        public final a ye(String str) {
            this.lwp.add(str);
            return this;
        }

        public final a yf(String str) {
            this.lwq.add(str);
            return this;
        }
    }

    public interface b {
        void I(int i, int i2, int i3);

        void aAi();

        void afW();

        void onSuccess();

        void r(long j, long j2);
    }

    public /* synthetic */ a(byte b) {
        this();
    }

    protected final /* synthetic */ Object doInBackground(Object[] objArr) {
        return aAq();
    }

    protected final /* synthetic */ void onPostExecute(Object obj) {
        Integer num = (Integer) obj;
        if (this.lwu != null) {
            switch (num.intValue()) {
                case -2:
                    this.lwu.r(this.lwy, this.lwx);
                    return;
                case 0:
                    this.lwu.onSuccess();
                    return;
                case 1:
                    this.lwu.aAi();
                    return;
                default:
                    this.lwu.afW();
                    return;
            }
        }
    }

    protected final /* synthetic */ void onProgressUpdate(Object[] objArr) {
        int i = 0;
        Integer[] numArr = (Integer[]) objArr;
        if (this.lwu != null) {
            int intValue = numArr.length > 0 ? numArr[0].intValue() : 0;
            int intValue2 = numArr.length >= 2 ? numArr[1].intValue() : 0;
            if (numArr.length >= 3) {
                i = numArr[2].intValue();
            }
            this.lwu.I(intValue, intValue2, i);
        }
    }

    private a() {
        this.mCancellationSignal = new CancellationSignal();
    }

    private Integer aAq() {
        Integer valueOf;
        long uptimeMillis;
        int aAs;
        Throwable th;
        oN(54);
        int i = -1;
        WakeLock newWakeLock = ((PowerManager) ad.getContext().getSystemService("power")).newWakeLock(1, "DBRecovery");
        long uptimeMillis2 = SystemClock.uptimeMillis();
        newWakeLock.acquire(1800000);
        try {
            publishProgress(new Integer[]{Integer.valueOf(1)});
            i = aAr();
            if (i != 0) {
                valueOf = Integer.valueOf(i);
                switch (i) {
                    case -2:
                        oN(58);
                        break;
                    case 0:
                        uptimeMillis = SystemClock.uptimeMillis() - uptimeMillis2;
                        oN(55);
                        d.pVE.a(181, 60, (uptimeMillis / 1000) + 1, true);
                        break;
                    case 1:
                        oN(56);
                        break;
                    default:
                        oN(57);
                        break;
                }
                newWakeLock.release();
            } else {
                aAs = aAs();
                try {
                    publishProgress(new Integer[]{Integer.valueOf(2)});
                    i = aAt();
                    if (i == 1) {
                        valueOf = Integer.valueOf(i);
                        switch (i) {
                            case -2:
                                oN(58);
                                break;
                            case 0:
                                uptimeMillis = SystemClock.uptimeMillis() - uptimeMillis2;
                                oN(55);
                                d.pVE.a(181, 60, (uptimeMillis / 1000) + 1, true);
                                break;
                            case 1:
                                oN(56);
                                break;
                            default:
                                oN(57);
                                break;
                        }
                        newWakeLock.release();
                    } else {
                        if (i == -1) {
                            publishProgress(new Integer[]{Integer.valueOf(4)});
                            aAs = aAu();
                        } else {
                            aAs = i;
                        }
                        if (aAs == 0) {
                            publishProgress(new Integer[]{Integer.valueOf(5)});
                            i = aAv();
                        } else {
                            i = aAs;
                        }
                        if (i != 0) {
                            if (!this.lwt) {
                                valueOf = Integer.valueOf(i);
                                switch (i) {
                                    case -2:
                                        oN(58);
                                        break;
                                    case 0:
                                        uptimeMillis = SystemClock.uptimeMillis() - uptimeMillis2;
                                        oN(55);
                                        d.pVE.a(181, 60, (uptimeMillis / 1000) + 1, true);
                                        break;
                                    case 1:
                                        oN(56);
                                        break;
                                    default:
                                        oN(57);
                                        break;
                                }
                                newWakeLock.release();
                            }
                        }
                        publishProgress(new Integer[]{Integer.valueOf(6)});
                        i = es(true);
                        valueOf = Integer.valueOf(i);
                        switch (i) {
                            case -2:
                                oN(58);
                                break;
                            case 0:
                                uptimeMillis = SystemClock.uptimeMillis() - uptimeMillis2;
                                oN(55);
                                d.pVE.a(181, 60, (uptimeMillis / 1000) + 1, true);
                                break;
                            case 1:
                                oN(56);
                                break;
                            default:
                                oN(57);
                                break;
                        }
                        newWakeLock.release();
                    }
                } catch (OperationCanceledException e) {
                } catch (Exception e2) {
                    i = aAs;
                    try {
                        es(false);
                        i = -1;
                        valueOf = Integer.valueOf(-1);
                        oN(57);
                        newWakeLock.release();
                        return valueOf;
                    } catch (Throwable th2) {
                        th = th2;
                        switch (i) {
                            case -2:
                                oN(58);
                                break;
                            case 0:
                                uptimeMillis = SystemClock.uptimeMillis() - uptimeMillis2;
                                oN(55);
                                d.pVE.a(181, 60, (uptimeMillis / 1000) + 1, true);
                                break;
                            case 1:
                                oN(56);
                                break;
                            default:
                                oN(57);
                                break;
                        }
                        newWakeLock.release();
                        throw th;
                    }
                }
            }
        } catch (OperationCanceledException e3) {
            aAs = i;
        } catch (Exception e4) {
            es(false);
            i = -1;
            valueOf = Integer.valueOf(-1);
            oN(57);
            newWakeLock.release();
            return valueOf;
        }
        return valueOf;
        try {
            x.i("MicroMsg.DBRecoveryTask", "Recovery cancelled.");
            es(false);
            try {
                valueOf = Integer.valueOf(1);
                oN(56);
                newWakeLock.release();
                return valueOf;
            } catch (Throwable th3) {
                th = th3;
                i = 1;
                switch (i) {
                    case -2:
                        oN(58);
                        break;
                    case 0:
                        uptimeMillis = SystemClock.uptimeMillis() - uptimeMillis2;
                        oN(55);
                        d.pVE.a(181, 60, (uptimeMillis / 1000) + 1, true);
                        break;
                    case 1:
                        oN(56);
                        break;
                    default:
                        oN(57);
                        break;
                }
                newWakeLock.release();
                throw th;
            }
        } catch (Throwable th4) {
            Throwable th5 = th4;
            i = aAs;
            th = th5;
            switch (i) {
                case -2:
                    oN(58);
                    break;
                case 0:
                    uptimeMillis = SystemClock.uptimeMillis() - uptimeMillis2;
                    oN(55);
                    d.pVE.a(181, 60, (uptimeMillis / 1000) + 1, true);
                    break;
                case 1:
                    oN(56);
                    break;
                default:
                    oN(57);
                    break;
            }
            newWakeLock.release();
            throw th;
        }
    }

    private int aAr() {
        long j = 0;
        x.i("MicroMsg.DBRecoveryTask", "Load and check database statistics.");
        if (this.lwl == null || this.lwl.isEmpty()) {
            return -1;
        }
        long j2;
        this.lwv = false;
        this.lww = 300000;
        if (this.lwo != null) {
            try {
                JSONObject jSONObject = new JSONObject(FileOp.bT(this.lwo));
                this.lww = jSONObject.getInt("message");
                this.lwv = true;
                j2 = jSONObject.getLong("dbSize");
            } catch (FileNotFoundException e) {
                x.i("MicroMsg.DBRecoveryTask", "Statistics file not found: " + this.lwo);
                j2 = 0;
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.DBRecoveryTask", e2, "Cannot read statistics from file.", new Object[0]);
            }
            if (this.lwn != null) {
                j = FileOp.mi(this.lwn);
            }
            this.lwx = Math.max(j2, j);
            this.lwx += Math.max(this.lwx / 10, 67108864);
            this.lwy = yd(this.lwl);
            if (this.lwx <= this.lwy) {
                x.e("MicroMsg.DBRecoveryTask", "Space not enough for recovery (%d required, %d available)", Long.valueOf(this.lwx), Long.valueOf(this.lwy));
                return -2;
            }
            x.i("MicroMsg.DBRecoveryTask", "Statistics check OK, required space: %d, available space %d, message count: %d", Long.valueOf(this.lwx), Long.valueOf(this.lwy), Integer.valueOf(this.lww));
            return 0;
        }
        j2 = 0;
        if (this.lwn != null) {
            j = FileOp.mi(this.lwn);
        }
        this.lwx = Math.max(j2, j);
        this.lwx += Math.max(this.lwx / 10, 67108864);
        this.lwy = yd(this.lwl);
        if (this.lwx <= this.lwy) {
            x.i("MicroMsg.DBRecoveryTask", "Statistics check OK, required space: %d, available space %d, message count: %d", Long.valueOf(this.lwx), Long.valueOf(this.lwy), Integer.valueOf(this.lww));
            return 0;
        }
        x.e("MicroMsg.DBRecoveryTask", "Space not enough for recovery (%d required, %d available)", Long.valueOf(this.lwx), Long.valueOf(this.lwy));
        return -2;
    }

    private int aAs() {
        if (this.lwk != null) {
            if (this.lwk.isOpen()) {
                this.lwk.close();
            }
            this.lwk = null;
        }
        this.mCancellationSignal.throwIfCanceled();
        String str = this.lwl + '-' + bi.Dz(6);
        x.i("MicroMsg.DBRecoveryTask", "Open target database: " + str);
        try {
            this.lwk = SQLiteDatabase.openOrCreateDatabase(str, this.lws, lwj, null, null, 1);
            DatabaseUtils.stringForQuery(this.lwk, "PRAGMA journal_mode=OFF;", null);
            this.lwk.execSQL("PRAGMA synchronous=OFF;");
            return 0;
        } catch (Throwable e) {
            x.e("MicroMsg.DBRecoveryTask", "Cannot open target database '%s': %s", str, e.getMessage());
            a(1, "Cannot open target database", e);
            throw e;
        }
    }

    private int es(boolean z) {
        x.i("MicroMsg.DBRecoveryTask", "Close and rename target database: " + this.lwl);
        if (this.lwk == null) {
            return -1;
        }
        File file = new File(this.lwk.getPath());
        if (this.lwk.isOpen()) {
            this.lwk.close();
        }
        if (!z) {
            x.i("MicroMsg.DBRecoveryTask", "Delete temporary database file %s", file);
            file.delete();
        } else if (!file.renameTo(new File(this.lwl))) {
            x.e("MicroMsg.DBRecoveryTask", "Cannot rename %s to %s", file, this.lwl);
            return -1;
        }
        return 0;
    }

    private int aAt() {
        MasterInfo masterInfo;
        boolean z;
        OperationCanceledException e;
        Throwable e2;
        RepairKit repairKit = null;
        this.mCancellationSignal.throwIfCanceled();
        String[] strArr = new String[]{"message", "ImgInfo2", "videoinfo2", "EmojiInfo", "rconversation"};
        MasterInfo masterInfo2 = null;
        for (String str : this.lwp) {
            try {
                masterInfo2 = MasterInfo.load(str, this.lwr, strArr);
                x.i("MicroMsg.DBRecoveryTask", "Loaded saved master: " + str);
                masterInfo = masterInfo2;
                break;
            } catch (Exception e3) {
                Exception exception = e3;
                masterInfo = masterInfo2;
                x.e("MicroMsg.DBRecoveryTask", "Failed to load saved master: " + exception.getMessage());
                masterInfo2 = masterInfo;
            }
        }
        masterInfo = masterInfo2;
        if (masterInfo == null) {
            masterInfo = MasterInfo.make(strArr);
            x.w("MicroMsg.DBRecoveryTask", "Saved master not available.");
            z = false;
        } else {
            x.i("MicroMsg.DBRecoveryTask", "Use backup saved master.");
            z = true;
        }
        final int[] iArr = new int[]{0};
        RepairKit repairKit2;
        try {
            x.i("MicroMsg.DBRecoveryTask", "Begin repair: " + this.lwn);
            repairKit2 = new RepairKit(this.lwn, this.lws, lwj, masterInfo);
            try {
                repairKit2.setCallback(new Callback() {
                    private boolean lwA = false;
                    private int lwz = 0;
                    private int sm = 0;

                    public final int onProgress(String str, int i, Cursor cursor) {
                        if (this.lwz == 0) {
                            if (str.equalsIgnoreCase("message")) {
                                this.lwz = i;
                            }
                            return 0;
                        } else if (this.lwz != i) {
                            if (!this.lwA) {
                                this.lwA = true;
                                a.this.publishProgress(new Integer[]{Integer.valueOf(3)});
                            }
                            return 0;
                        }
                        int i2 = this.sm;
                        this.sm = i2 + 1;
                        if (i2 % 1000 == 0) {
                            a.this.publishProgress(new Integer[]{Integer.valueOf(2), Integer.valueOf(this.sm - 1), Integer.valueOf(a.this.lww)});
                        }
                        int[] iArr = iArr;
                        iArr[0] = iArr[0] + 1;
                        return 0;
                    }
                });
                int output = repairKit2.output(this.lwk, 0, this.mCancellationSignal);
                if (output == 0) {
                    if (repairKit2.isHeaderCorrupted() && repairKit2.isDataCorrupted()) {
                        throw new RuntimeException("No data is successfully recovered.");
                    }
                    x.i("MicroMsg.DBRecoveryTask", "Repair succeeded.");
                } else if (output == 1) {
                    x.i("MicroMsg.DBRecoveryTask", "Repair cancelled.");
                    this.mCancellationSignal.throwIfCanceled();
                } else {
                    throw new RuntimeException("Repair failed.");
                }
                if (this.lwv && ((float) iArr[0]) / ((float) this.lww) <= 1.5f) {
                    d.pVE.a(181, 181, 62, 63, this.lww, iArr[0], true);
                }
                repairKit2.release();
                return output;
            } catch (OperationCanceledException e4) {
                e = e4;
                repairKit = repairKit2;
            } catch (RuntimeException e5) {
                e2 = e5;
                try {
                    x.e("MicroMsg.DBRecoveryTask", "Failed to repair database: " + e2.getMessage());
                    a(2, "Failed to repair database => sm: " + z, e2);
                    if (repairKit2 != null) {
                        repairKit2.release();
                    }
                    return -1;
                } catch (Throwable th) {
                    e2 = th;
                    if (repairKit2 != null) {
                        repairKit2.release();
                    }
                    throw e2;
                }
            }
        } catch (OperationCanceledException e6) {
            e = e6;
            try {
                throw e;
            } catch (Throwable th2) {
                e2 = th2;
                repairKit2 = repairKit;
            }
        } catch (RuntimeException e7) {
            e2 = e7;
            repairKit2 = null;
            x.e("MicroMsg.DBRecoveryTask", "Failed to repair database: " + e2.getMessage());
            a(2, "Failed to repair database => sm: " + z, e2);
            if (repairKit2 != null) {
                repairKit2.release();
            }
            return -1;
        } catch (Throwable th3) {
            e2 = th3;
            repairKit2 = null;
            if (repairKit2 != null) {
                repairKit2.release();
            }
            throw e2;
        }
    }

    private int aAu() {
        Exception exception;
        RecoverKit recoverKit;
        this.mCancellationSignal.throwIfCanceled();
        x.i("MicroMsg.DBRecoveryTask", "Begin backup recovery.");
        RecoverKit recoverKit2 = null;
        for (String str : this.lwq) {
            try {
                RecoverKit recoverKit3 = new RecoverKit(this.lwk, str, this.lwr);
                try {
                    x.i("MicroMsg.DBRecoveryTask", "Loaded backup data: " + str);
                    recoverKit2 = recoverKit3;
                } catch (Exception e) {
                    exception = e;
                    recoverKit = recoverKit3;
                    x.e("MicroMsg.DBRecoveryTask", "Load backup data failed: " + exception.getMessage());
                    recoverKit2 = recoverKit;
                }
            } catch (Exception e2) {
                Exception exception2 = e2;
                recoverKit = recoverKit2;
                exception = exception2;
                x.e("MicroMsg.DBRecoveryTask", "Load backup data failed: " + exception.getMessage());
                recoverKit2 = recoverKit;
            }
        }
        if (recoverKit2 == null) {
            return -1;
        }
        try {
            int run = recoverKit2.run(false, this.mCancellationSignal);
            if (run == 0) {
                x.i("MicroMsg.DBRecoveryTask", "Backup recovery succeeded.");
            } else if (run == 1) {
                x.i("MicroMsg.DBRecoveryTask", "Backup recovery cancelled.");
                this.mCancellationSignal.throwIfCanceled();
            } else {
                x.e("MicroMsg.DBRecoveryTask", "Backup recovery failed.");
            }
            recoverKit2.release();
            return run;
        } catch (OperationCanceledException e3) {
            throw e3;
        } catch (Throwable e4) {
            x.e("MicroMsg.DBRecoveryTask", "Failed to repair database: " + e4.getMessage());
            a(4, "Failed to recover backup database", e4);
            recoverKit2.release();
            return -1;
        } catch (Throwable th) {
            recoverKit2.release();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int aAv() {
        /*
        r12 = this;
        r8 = 0;
        r7 = 0;
        r0 = r12.lwm;
        if (r0 == 0) goto L_0x000e;
    L_0x0006:
        r0 = r12.lwm;
        r0 = r0.isEmpty();
        if (r0 == 0) goto L_0x0010;
    L_0x000e:
        r0 = r7;
    L_0x000f:
        return r0;
    L_0x0010:
        r0 = "MicroMsg.DBRecoveryTask";
        r1 = "Begin merging old database.";
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);
        r0 = r12.lwk;	 Catch:{ OperationCanceledException -> 0x0214, Exception -> 0x0242, all -> 0x0294 }
        r1 = "SELECT count(*) FROM message;";
        r2 = 0;
        r0 = com.tencent.wcdb.DatabaseUtils.longForQuery(r0, r1, r2);	 Catch:{ OperationCanceledException -> 0x0214, Exception -> 0x0242, all -> 0x0294 }
        r0 = (int) r0;	 Catch:{ OperationCanceledException -> 0x0214, Exception -> 0x0242, all -> 0x0294 }
        r1 = 1;
        r9 = new long[r1];	 Catch:{ OperationCanceledException -> 0x0214, Exception -> 0x0242, all -> 0x0294 }
        r1 = 0;
        r2 = r12.lwk;	 Catch:{ OperationCanceledException -> 0x0214, Exception -> 0x0242, all -> 0x0294 }
        r3 = "SELECT max(msgId) FROM message;";
        r4 = 0;
        r2 = com.tencent.wcdb.DatabaseUtils.longForQuery(r2, r3, r4);	 Catch:{ OperationCanceledException -> 0x0214, Exception -> 0x0242, all -> 0x0294 }
        r4 = 1;
        r2 = r2 + r4;
        r9[r1] = r2;	 Catch:{ OperationCanceledException -> 0x0214, Exception -> 0x0242, all -> 0x0294 }
        r1 = 0;
        r2 = r9[r1];	 Catch:{ OperationCanceledException -> 0x0214, Exception -> 0x0242, all -> 0x0294 }
        r4 = 1000000; // 0xf4240 float:1.401298E-39 double:4.940656E-318;
        r1 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r1 <= 0) goto L_0x0051;
    L_0x0041:
        r1 = 0;
        r2 = r9[r1];	 Catch:{ OperationCanceledException -> 0x0214, Exception -> 0x0242, all -> 0x0294 }
        r4 = 10000000; // 0x989680 float:1.4012985E-38 double:4.9406565E-317;
        r1 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r1 > 0) goto L_0x0051;
    L_0x004b:
        r1 = 0;
        r2 = 10000001; // 0x989681 float:1.4012986E-38 double:4.940657E-317;
        r9[r1] = r2;	 Catch:{ OperationCanceledException -> 0x0214, Exception -> 0x0242, all -> 0x0294 }
    L_0x0051:
        r10 = new java.util.HashMap;	 Catch:{ OperationCanceledException -> 0x0214, Exception -> 0x0242, all -> 0x0294 }
        r1 = r0 / 2;
        r0 = r0 + r1;
        r1 = 10240; // 0x2800 float:1.4349E-41 double:5.059E-320;
        r0 = java.lang.Math.max(r0, r1);	 Catch:{ OperationCanceledException -> 0x0214, Exception -> 0x0242, all -> 0x0294 }
        r10.<init>(r0);	 Catch:{ OperationCanceledException -> 0x0214, Exception -> 0x0242, all -> 0x0294 }
        r5 = new com.tencent.mm.plugin.dbbackup.a.a$2;	 Catch:{ OperationCanceledException -> 0x0214, Exception -> 0x0242, all -> 0x0294 }
        r5.<init>();	 Catch:{ OperationCanceledException -> 0x0214, Exception -> 0x0242, all -> 0x0294 }
        r0 = r12.lwm;	 Catch:{ OperationCanceledException -> 0x0214, Exception -> 0x0242, all -> 0x0294 }
        r1 = r12.lws;	 Catch:{ OperationCanceledException -> 0x0214, Exception -> 0x0242, all -> 0x0294 }
        r2 = lwj;	 Catch:{ OperationCanceledException -> 0x0214, Exception -> 0x0242, all -> 0x0294 }
        r3 = 0;
        r4 = 1;
        r6 = 1;
        r1 = com.tencent.wcdb.database.SQLiteDatabase.openDatabase(r0, r1, r2, r3, r4, r5, r6);	 Catch:{ OperationCanceledException -> 0x0214, Exception -> 0x0242, all -> 0x0294 }
        r2 = "userinfo";
        r3 = 0;
        r4 = 0;
        r5 = 0;
        r6 = 0;
        r0 = r12;
        r0.a(r1, r2, r3, r4, r5, r6);	 Catch:{ OperationCanceledException -> 0x02a1, Exception -> 0x029c }
        r0 = r12.lwk;	 Catch:{ OperationCanceledException -> 0x02a1, Exception -> 0x029c }
        r0.beginTransaction();	 Catch:{ OperationCanceledException -> 0x02a1, Exception -> 0x029c }
        r0 = 3;
        r0 = new java.lang.Object[r0];	 Catch:{ OperationCanceledException -> 0x02a1, Exception -> 0x029c }
        r2 = 0;
        r3 = 8197; // 0x2005 float:1.1486E-41 double:4.05E-320;
        r3 = java.lang.Integer.valueOf(r3);	 Catch:{ OperationCanceledException -> 0x02a1, Exception -> 0x029c }
        r0[r2] = r3;	 Catch:{ OperationCanceledException -> 0x02a1, Exception -> 0x029c }
        r2 = 1;
        r3 = 3;
        r3 = java.lang.Integer.valueOf(r3);	 Catch:{ OperationCanceledException -> 0x02a1, Exception -> 0x029c }
        r0[r2] = r3;	 Catch:{ OperationCanceledException -> 0x02a1, Exception -> 0x029c }
        r2 = 2;
        r3 = "";
        r0[r2] = r3;	 Catch:{ OperationCanceledException -> 0x02a1, Exception -> 0x029c }
        r2 = r12.lwk;	 Catch:{ OperationCanceledException -> 0x02a1, Exception -> 0x029c }
        r3 = "INSERT OR REPLACE INTO userinfo (id,type,value) VALUES (?,?,?)";
        r2.execSQL(r3, r0);	 Catch:{ OperationCanceledException -> 0x02a1, Exception -> 0x029c }
        r2 = 0;
        r3 = 15;
        r3 = java.lang.Integer.valueOf(r3);	 Catch:{ OperationCanceledException -> 0x02a1, Exception -> 0x029c }
        r0[r2] = r3;	 Catch:{ OperationCanceledException -> 0x02a1, Exception -> 0x029c }
        r2 = 1;
        r3 = 1;
        r3 = java.lang.Integer.valueOf(r3);	 Catch:{ OperationCanceledException -> 0x02a1, Exception -> 0x029c }
        r0[r2] = r3;	 Catch:{ OperationCanceledException -> 0x02a1, Exception -> 0x029c }
        r2 = 2;
        r3 = "0";
        r0[r2] = r3;	 Catch:{ OperationCanceledException -> 0x02a1, Exception -> 0x029c }
        r2 = r12.lwk;	 Catch:{ OperationCanceledException -> 0x02a1, Exception -> 0x029c }
        r3 = "INSERT OR REPLACE INTO userinfo (id,type,value) VALUES (?,?,?)";
        r2.execSQL(r3, r0);	 Catch:{ OperationCanceledException -> 0x02a1, Exception -> 0x029c }
        r2 = 0;
        r3 = 89;
        r3 = java.lang.Integer.valueOf(r3);	 Catch:{ OperationCanceledException -> 0x02a1, Exception -> 0x029c }
        r0[r2] = r3;	 Catch:{ OperationCanceledException -> 0x02a1, Exception -> 0x029c }
        r2 = 1;
        r3 = 1;
        r3 = java.lang.Integer.valueOf(r3);	 Catch:{ OperationCanceledException -> 0x02a1, Exception -> 0x029c }
        r0[r2] = r3;	 Catch:{ OperationCanceledException -> 0x02a1, Exception -> 0x029c }
        r2 = 2;
        r3 = "1";
        r0[r2] = r3;	 Catch:{ OperationCanceledException -> 0x02a1, Exception -> 0x029c }
        r2 = r12.lwk;	 Catch:{ OperationCanceledException -> 0x02a1, Exception -> 0x029c }
        r3 = "INSERT OR REPLACE INTO userinfo (id,type,value) VALUES (?,?,?)";
        r2.execSQL(r3, r0);	 Catch:{ OperationCanceledException -> 0x02a1, Exception -> 0x029c }
        r2 = com.tencent.wcdb.database.SQLiteDirectCursor.FACTORY;	 Catch:{ OperationCanceledException -> 0x02a1, Exception -> 0x029c }
        r3 = "SELECT id,type,value FROM userinfo WHERE id=?";
        r4 = 1;
        r4 = new java.lang.String[r4];	 Catch:{ OperationCanceledException -> 0x02a1, Exception -> 0x029c }
        r5 = 0;
        r6 = "2";
        r4[r5] = r6;	 Catch:{ OperationCanceledException -> 0x02a1, Exception -> 0x029c }
        r5 = "userinfo";
        r2 = r1.rawQueryWithFactory(r2, r3, r4, r5);	 Catch:{ OperationCanceledException -> 0x02a1, Exception -> 0x029c }
        r3 = r2.moveToFirst();	 Catch:{ OperationCanceledException -> 0x02a7, Exception -> 0x029e, all -> 0x0299 }
        if (r3 == 0) goto L_0x0124;
    L_0x00fc:
        r3 = 0;
        r4 = 0;
        r4 = r2.getInt(r4);	 Catch:{ OperationCanceledException -> 0x02a7, Exception -> 0x029e, all -> 0x0299 }
        r4 = java.lang.Integer.valueOf(r4);	 Catch:{ OperationCanceledException -> 0x02a7, Exception -> 0x029e, all -> 0x0299 }
        r0[r3] = r4;	 Catch:{ OperationCanceledException -> 0x02a7, Exception -> 0x029e, all -> 0x0299 }
        r3 = 1;
        r4 = 1;
        r4 = r2.getInt(r4);	 Catch:{ OperationCanceledException -> 0x02a7, Exception -> 0x029e, all -> 0x0299 }
        r4 = java.lang.Integer.valueOf(r4);	 Catch:{ OperationCanceledException -> 0x02a7, Exception -> 0x029e, all -> 0x0299 }
        r0[r3] = r4;	 Catch:{ OperationCanceledException -> 0x02a7, Exception -> 0x029e, all -> 0x0299 }
        r3 = 2;
        r4 = 2;
        r4 = r2.getString(r4);	 Catch:{ OperationCanceledException -> 0x02a7, Exception -> 0x029e, all -> 0x0299 }
        r0[r3] = r4;	 Catch:{ OperationCanceledException -> 0x02a7, Exception -> 0x029e, all -> 0x0299 }
        r3 = r12.lwk;	 Catch:{ OperationCanceledException -> 0x02a7, Exception -> 0x029e, all -> 0x0299 }
        r4 = "INSERT OR REPLACE INTO userinfo (id,type,value) VALUES (?,?,?)";
        r3.execSQL(r4, r0);	 Catch:{ OperationCanceledException -> 0x02a7, Exception -> 0x029e, all -> 0x0299 }
    L_0x0124:
        r2.close();	 Catch:{ OperationCanceledException -> 0x02a7, Exception -> 0x029e, all -> 0x0299 }
        r3 = com.tencent.wcdb.database.SQLiteDirectCursor.FACTORY;	 Catch:{ OperationCanceledException -> 0x02a7, Exception -> 0x029e, all -> 0x0299 }
        r4 = "SELECT id,type,value FROM userinfo WHERE id=?";
        r5 = 1;
        r5 = new java.lang.String[r5];	 Catch:{ OperationCanceledException -> 0x02a7, Exception -> 0x029e, all -> 0x0299 }
        r6 = 0;
        r8 = "9";
        r5[r6] = r8;	 Catch:{ OperationCanceledException -> 0x02a7, Exception -> 0x029e, all -> 0x0299 }
        r6 = "userinfo";
        r2 = r1.rawQueryWithFactory(r3, r4, r5, r6);	 Catch:{ OperationCanceledException -> 0x02a7, Exception -> 0x029e, all -> 0x0299 }
        r3 = r2.moveToFirst();	 Catch:{ OperationCanceledException -> 0x02a7, Exception -> 0x029e, all -> 0x0299 }
        if (r3 == 0) goto L_0x016a;
    L_0x0142:
        r3 = 0;
        r4 = 0;
        r4 = r2.getInt(r4);	 Catch:{ OperationCanceledException -> 0x02a7, Exception -> 0x029e, all -> 0x0299 }
        r4 = java.lang.Integer.valueOf(r4);	 Catch:{ OperationCanceledException -> 0x02a7, Exception -> 0x029e, all -> 0x0299 }
        r0[r3] = r4;	 Catch:{ OperationCanceledException -> 0x02a7, Exception -> 0x029e, all -> 0x0299 }
        r3 = 1;
        r4 = 1;
        r4 = r2.getInt(r4);	 Catch:{ OperationCanceledException -> 0x02a7, Exception -> 0x029e, all -> 0x0299 }
        r4 = java.lang.Integer.valueOf(r4);	 Catch:{ OperationCanceledException -> 0x02a7, Exception -> 0x029e, all -> 0x0299 }
        r0[r3] = r4;	 Catch:{ OperationCanceledException -> 0x02a7, Exception -> 0x029e, all -> 0x0299 }
        r3 = 2;
        r4 = 2;
        r4 = r2.getString(r4);	 Catch:{ OperationCanceledException -> 0x02a7, Exception -> 0x029e, all -> 0x0299 }
        r0[r3] = r4;	 Catch:{ OperationCanceledException -> 0x02a7, Exception -> 0x029e, all -> 0x0299 }
        r3 = r12.lwk;	 Catch:{ OperationCanceledException -> 0x02a7, Exception -> 0x029e, all -> 0x0299 }
        r4 = "INSERT OR REPLACE INTO userinfo (id,type,value) VALUES (?,?,?)";
        r3.execSQL(r4, r0);	 Catch:{ OperationCanceledException -> 0x02a7, Exception -> 0x029e, all -> 0x0299 }
    L_0x016a:
        r2.close();	 Catch:{ OperationCanceledException -> 0x02a7, Exception -> 0x029e, all -> 0x0299 }
        r0 = r12.lwk;	 Catch:{ OperationCanceledException -> 0x02a7, Exception -> 0x029e, all -> 0x0299 }
        r0.setTransactionSuccessful();	 Catch:{ OperationCanceledException -> 0x02a7, Exception -> 0x029e, all -> 0x0299 }
        r0 = r12.lwk;	 Catch:{ OperationCanceledException -> 0x02a7, Exception -> 0x029e, all -> 0x0299 }
        r0.endTransaction();	 Catch:{ OperationCanceledException -> 0x02a7, Exception -> 0x029e, all -> 0x0299 }
        r0 = com.tencent.wcdb.database.SQLiteDirectCursor.FACTORY;	 Catch:{ OperationCanceledException -> 0x02a7, Exception -> 0x029e, all -> 0x0299 }
        r3 = "SELECT * FROM message LIMIT 0;";
        r4 = 0;
        r5 = "message";
        r8 = r1.rawQueryWithFactory(r0, r3, r4, r5);	 Catch:{ OperationCanceledException -> 0x02a7, Exception -> 0x029e, all -> 0x0299 }
        r0 = "msgId";
        r0 = r8.getColumnIndexOrThrow(r0);	 Catch:{ OperationCanceledException -> 0x02ac, Exception -> 0x029c }
        r8.close();	 Catch:{ OperationCanceledException -> 0x02ac, Exception -> 0x029c }
        r2 = "message";
        r3 = 4;
        r4 = 1;
        r5 = 5;
        r6 = new com.tencent.mm.plugin.dbbackup.a.a$3;	 Catch:{ OperationCanceledException -> 0x02ac, Exception -> 0x029c }
        r6.<init>(r0, r9, r10);	 Catch:{ OperationCanceledException -> 0x02ac, Exception -> 0x029c }
        r0 = r12;
        r0.a(r1, r2, r3, r4, r5, r6);	 Catch:{ OperationCanceledException -> 0x02ac, Exception -> 0x029c }
        r2 = "rconversation";
        r3 = 5;
        r4 = 1;
        r5 = 0;
        r6 = 0;
        r0 = r12;
        r0.a(r1, r2, r3, r4, r5, r6);	 Catch:{ OperationCanceledException -> 0x02ac, Exception -> 0x029c }
        r0 = com.tencent.wcdb.database.SQLiteDirectCursor.FACTORY;	 Catch:{ OperationCanceledException -> 0x02ac, Exception -> 0x029c }
        r2 = "SELECT * FROM ImgInfo2 LIMIT 0;";
        r3 = 0;
        r4 = "ImgInfo2";
        r8 = r1.rawQueryWithFactory(r0, r2, r3, r4);	 Catch:{ OperationCanceledException -> 0x02ac, Exception -> 0x029c }
        r0 = "msglocalid";
        r0 = r8.getColumnIndexOrThrow(r0);	 Catch:{ OperationCanceledException -> 0x02ac, Exception -> 0x029c }
        r8.close();	 Catch:{ OperationCanceledException -> 0x02ac, Exception -> 0x029c }
        r2 = "ImgInfo2";
        r3 = 4;
        r4 = 1;
        r5 = 0;
        r6 = new com.tencent.mm.plugin.dbbackup.a.a$4;	 Catch:{ OperationCanceledException -> 0x02ac, Exception -> 0x029c }
        r6.<init>(r0, r10);	 Catch:{ OperationCanceledException -> 0x02ac, Exception -> 0x029c }
        r0 = r12;
        r0.a(r1, r2, r3, r4, r5, r6);	 Catch:{ OperationCanceledException -> 0x02ac, Exception -> 0x029c }
        r0 = com.tencent.wcdb.database.SQLiteDirectCursor.FACTORY;	 Catch:{ OperationCanceledException -> 0x02ac, Exception -> 0x029c }
        r2 = "SELECT * FROM videoinfo2 LIMIT 0;";
        r3 = 0;
        r4 = "videoinfo2";
        r8 = r1.rawQueryWithFactory(r0, r2, r3, r4);	 Catch:{ OperationCanceledException -> 0x02ac, Exception -> 0x029c }
        r0 = "msglocalid";
        r0 = r8.getColumnIndexOrThrow(r0);	 Catch:{ OperationCanceledException -> 0x02ac, Exception -> 0x029c }
        r8.close();	 Catch:{ OperationCanceledException -> 0x02ac, Exception -> 0x029c }
        r2 = "videoinfo2";
        r3 = 4;
        r4 = 1;
        r5 = 0;
        r6 = new com.tencent.mm.plugin.dbbackup.a.a$5;	 Catch:{ OperationCanceledException -> 0x02ac, Exception -> 0x029c }
        r6.<init>(r0, r10);	 Catch:{ OperationCanceledException -> 0x02ac, Exception -> 0x029c }
        r0 = r12;
        r0.a(r1, r2, r3, r4, r5, r6);	 Catch:{ OperationCanceledException -> 0x02ac, Exception -> 0x029c }
        if (r8 == 0) goto L_0x01ff;
    L_0x01f6:
        r0 = r8.isClosed();
        if (r0 != 0) goto L_0x01ff;
    L_0x01fc:
        r8.close();
    L_0x01ff:
        r0 = r12.lwk;
        r0 = r0.inTransaction();
        if (r0 == 0) goto L_0x020c;
    L_0x0207:
        r0 = r12.lwk;
        r0.endTransaction();
    L_0x020c:
        if (r1 == 0) goto L_0x0211;
    L_0x020e:
        r1.close();
    L_0x0211:
        r0 = r7;
        goto L_0x000f;
    L_0x0214:
        r0 = move-exception;
        r1 = r8;
    L_0x0216:
        r2 = "MicroMsg.DBRecoveryTask";
        r3 = "Message migration cancelled.";
        com.tencent.mm.sdk.platformtools.x.i(r2, r3);	 Catch:{ all -> 0x0220 }
        throw r0;	 Catch:{ all -> 0x0220 }
    L_0x0220:
        r0 = move-exception;
        r11 = r1;
        r1 = r8;
        r8 = r11;
    L_0x0224:
        if (r8 == 0) goto L_0x022f;
    L_0x0226:
        r2 = r8.isClosed();
        if (r2 != 0) goto L_0x022f;
    L_0x022c:
        r8.close();
    L_0x022f:
        r2 = r12.lwk;
        r2 = r2.inTransaction();
        if (r2 == 0) goto L_0x023c;
    L_0x0237:
        r2 = r12.lwk;
        r2.endTransaction();
    L_0x023c:
        if (r1 == 0) goto L_0x0241;
    L_0x023e:
        r1.close();
    L_0x0241:
        throw r0;
    L_0x0242:
        r0 = move-exception;
        r1 = r8;
    L_0x0244:
        r2 = "MicroMsg.DBRecoveryTask";
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0297 }
        r4 = "Message migration failed: ";
        r3.<init>(r4);	 Catch:{ all -> 0x0297 }
        r4 = r0.getMessage();	 Catch:{ all -> 0x0297 }
        r3 = r3.append(r4);	 Catch:{ all -> 0x0297 }
        r3 = r3.toString();	 Catch:{ all -> 0x0297 }
        com.tencent.mm.sdk.platformtools.x.e(r2, r3);	 Catch:{ all -> 0x0297 }
        r2 = 5;
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0297 }
        r4 = "Message migration failed, ignorable: ";
        r3.<init>(r4);	 Catch:{ all -> 0x0297 }
        r4 = r12.lwt;	 Catch:{ all -> 0x0297 }
        r3 = r3.append(r4);	 Catch:{ all -> 0x0297 }
        r3 = r3.toString();	 Catch:{ all -> 0x0297 }
        a(r2, r3, r0);	 Catch:{ all -> 0x0297 }
        if (r8 == 0) goto L_0x027f;
    L_0x0276:
        r0 = r8.isClosed();
        if (r0 != 0) goto L_0x027f;
    L_0x027c:
        r8.close();
    L_0x027f:
        r0 = r12.lwk;
        r0 = r0.inTransaction();
        if (r0 == 0) goto L_0x028c;
    L_0x0287:
        r0 = r12.lwk;
        r0.endTransaction();
    L_0x028c:
        if (r1 == 0) goto L_0x0291;
    L_0x028e:
        r1.close();
    L_0x0291:
        r0 = -1;
        goto L_0x000f;
    L_0x0294:
        r0 = move-exception;
        r1 = r8;
        goto L_0x0224;
    L_0x0297:
        r0 = move-exception;
        goto L_0x0224;
    L_0x0299:
        r0 = move-exception;
        r8 = r2;
        goto L_0x0224;
    L_0x029c:
        r0 = move-exception;
        goto L_0x0244;
    L_0x029e:
        r0 = move-exception;
        r8 = r2;
        goto L_0x0244;
    L_0x02a1:
        r0 = move-exception;
        r11 = r8;
        r8 = r1;
        r1 = r11;
        goto L_0x0216;
    L_0x02a7:
        r0 = move-exception;
        r8 = r1;
        r1 = r2;
        goto L_0x0216;
    L_0x02ac:
        r0 = move-exception;
        r11 = r8;
        r8 = r1;
        r1 = r11;
        goto L_0x0216;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.dbbackup.a.a.aAv():int");
    }

    private int a(SQLiteDatabase sQLiteDatabase, String str, int i, boolean z, int i2, c cVar) {
        Throwable th;
        Cursor rawQueryWithFactory;
        SQLiteStatement compileStatement;
        try {
            String stringForQuery = DatabaseUtils.stringForQuery(sQLiteDatabase, "SELECT sql FROM sqlite_master WHERE name = ?", new String[]{str});
            if (stringForQuery == null || stringForQuery.isEmpty()) {
                throw new SQLiteDoneException();
            }
            this.lwk.execSQL(stringForQuery.replaceFirst("(?i)^CREATE TABLE (?!IF NOT EXISTS )", "CREATE TABLE IF NOT EXISTS "), null, this.mCancellationSignal);
            if (z) {
                int longForQuery = (int) DatabaseUtils.longForQuery(sQLiteDatabase, "SELECT count(*) FROM " + str, null);
                rawQueryWithFactory = sQLiteDatabase.rawQueryWithFactory(SQLiteDirectCursor.FACTORY, "SELECT * FROM " + str, null, str, this.mCancellationSignal);
                try {
                    int i3;
                    int i4;
                    String[] columnNames = rawQueryWithFactory.getColumnNames();
                    StringBuilder stringBuilder = new StringBuilder(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
                    stringBuilder.append("INSERT").append(CONFLICT_VALUES[i]).append(" INTO ").append(str).append(" (");
                    for (String append : columnNames) {
                        stringBuilder.append(append).append(',');
                    }
                    stringBuilder.setCharAt(stringBuilder.length() - 1, ')');
                    stringBuilder.append(" VALUES (");
                    for (i3 = 0; i3 < columnNames.length; i3++) {
                        stringBuilder.append("?,");
                    }
                    stringBuilder.setCharAt(stringBuilder.length() - 1, ')');
                    compileStatement = this.lwk.compileStatement(stringBuilder.toString());
                    i3 = 0;
                    try {
                        this.lwk.beginTransaction();
                        while (rawQueryWithFactory.moveToNext()) {
                            if (i3 % WXMediaMessage.DESCRIPTION_LENGTH_LIMIT == 0 && i2 != 0) {
                                publishProgress(new Integer[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(longForQuery)});
                            }
                            compileStatement.clearBindings();
                            for (i4 = 0; i4 < columnNames.length; i4++) {
                                switch (rawQueryWithFactory.getType(i4)) {
                                    case 0:
                                        compileStatement.bindNull(i4 + 1);
                                        break;
                                    case 1:
                                        compileStatement.bindLong(i4 + 1, rawQueryWithFactory.getLong(i4));
                                        break;
                                    case 2:
                                        compileStatement.bindDouble(i4 + 1, rawQueryWithFactory.getDouble(i4));
                                        break;
                                    case 3:
                                        compileStatement.bindString(i4 + 1, rawQueryWithFactory.getString(i4));
                                        break;
                                    case 4:
                                        compileStatement.bindBlob(i4 + 1, rawQueryWithFactory.getBlob(i4));
                                        break;
                                    default:
                                        break;
                                }
                            }
                            if (cVar != null) {
                                cVar.a(rawQueryWithFactory, compileStatement);
                            }
                            compileStatement.executeInsert(this.mCancellationSignal);
                            i3++;
                        }
                        this.lwk.setTransactionSuccessful();
                        if (!(rawQueryWithFactory == null || rawQueryWithFactory.isClosed())) {
                            rawQueryWithFactory.close();
                        }
                        if (this.lwk.inTransaction()) {
                            this.lwk.endTransaction();
                        }
                        if (compileStatement == null) {
                            return i3;
                        }
                        compileStatement.close();
                        return i3;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    compileStatement = null;
                    if (!(rawQueryWithFactory == null || rawQueryWithFactory.isClosed())) {
                        rawQueryWithFactory.close();
                    }
                    if (this.lwk.inTransaction()) {
                        this.lwk.endTransaction();
                    }
                    if (compileStatement != null) {
                        compileStatement.close();
                    }
                    throw th;
                }
            }
            if (this.lwk.inTransaction()) {
                this.lwk.endTransaction();
            }
            return 0;
        } catch (SQLiteDoneException e) {
            x.e("MicroMsg.DBRecoveryTask", "There is no table named '%s' to copy.", str);
            if (this.lwk.inTransaction()) {
                this.lwk.endTransaction();
            }
            return -1;
        } catch (Throwable th4) {
            th = th4;
            compileStatement = null;
            rawQueryWithFactory = null;
        }
    }

    private static long yd(String str) {
        File file = new File(str);
        do {
            long usableSpace = file.getUsableSpace();
            if (usableSpace > 0) {
                return usableSpace;
            }
            file = file.getParentFile();
        } while (file != null);
        return 0;
    }

    private static void oN(int i) {
        d.pVE.a(181, (long) i, 1, true);
    }

    @SuppressLint({"DefaultLocale"})
    private static void a(int i, String str, Throwable th) {
        d.pVE.c("DBRepairNew", String.format("[Stage: %d] %s%s", new Object[]{Integer.valueOf(i), str, "\n" + bi.i(th)}), null);
    }
}
