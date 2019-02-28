package com.tencent.mm.y.d;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Process;
import android.os.StatFs;
import android.preference.PreferenceManager;
import android.util.Base64;
import com.tencent.mm.a.o;
import com.tencent.mm.ay.m;
import com.tencent.mm.ay.r;
import com.tencent.mm.bx.h;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.ar;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public final class b implements a {
    private static final String ffG;
    private static final String ffH;
    private static b hkM;
    public static final String hkN = (e.bnD + "/tencent/MicroMsg/SQLTrace/");
    public static List<String> hkW = Arrays.asList(new String[]{"FTS5IndexMicroMsg.db"});
    long[] ffK = new long[]{0, 0, 0};
    private SharedPreferences hbz = ad.cgg();
    public long hkO;
    public long hkP;
    public long hkQ;
    public long hkR;
    long hkS;
    private long hkT;
    private long hkU;
    private long hkV;
    private long hks = 0;
    public volatile boolean hkt = false;

    /* renamed from: com.tencent.mm.y.d.b$3 */
    class AnonymousClass3 implements Runnable {
        final /* synthetic */ String hkY;

        public AnonymousClass3(String str) {
            this.hkY = str;
        }

        public final void run() {
            Throwable e;
            b bVar = b.this;
            String str = b.hkN + "MMSQL.trace";
            String str2 = this.hkY + "\n";
            if (f.zl()) {
                File file;
                try {
                    file = new File(b.hkN);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    bVar.a(new File(b.hkN, "MMSQL.trace"), false);
                } catch (Exception e2) {
                    x.e("MicroMsg.SQLTraceManager", "init dir fail");
                }
                file = new File(str);
                if (file.length() > bVar.hkS) {
                    x.e("MicroMsg.SQLTraceManager", "log file invaild foramt,recreate");
                    bVar.a(file, true);
                }
                RandomAccessFile randomAccessFile;
                try {
                    randomAccessFile = new RandomAccessFile(str, "rw");
                    try {
                        randomAccessFile.seek(randomAccessFile.length());
                        randomAccessFile.write(com.tencent.mm.bz.e.bB(str2.getBytes()));
                        try {
                            randomAccessFile.close();
                        } catch (Throwable e3) {
                            x.printErrStackTrace("MicroMsg.SQLTraceManager", e3, "appendToFile fail with exception", new Object[0]);
                        }
                    } catch (IOException e4) {
                        e3 = e4;
                        try {
                            x.printErrStackTrace("MicroMsg.SQLTraceManager", e3, "appendToFile fail with exception", new Object[0]);
                            if (randomAccessFile != null) {
                                try {
                                    randomAccessFile.close();
                                } catch (Throwable e32) {
                                    x.printErrStackTrace("MicroMsg.SQLTraceManager", e32, "appendToFile fail with exception", new Object[0]);
                                }
                            }
                            bVar.l(new File(b.hkN + "MMSQL.trace"));
                            return;
                        } catch (Throwable th) {
                            e32 = th;
                            if (randomAccessFile != null) {
                                try {
                                    randomAccessFile.close();
                                } catch (Throwable e5) {
                                    x.printErrStackTrace("MicroMsg.SQLTraceManager", e5, "appendToFile fail with exception", new Object[0]);
                                }
                            }
                            throw e32;
                        }
                    }
                } catch (IOException e6) {
                    e32 = e6;
                    randomAccessFile = null;
                    x.printErrStackTrace("MicroMsg.SQLTraceManager", e32, "appendToFile fail with exception", new Object[0]);
                    if (randomAccessFile != null) {
                        randomAccessFile.close();
                    }
                    bVar.l(new File(b.hkN + "MMSQL.trace"));
                    return;
                } catch (Throwable th2) {
                    e32 = th2;
                    randomAccessFile = null;
                    if (randomAccessFile != null) {
                        randomAccessFile.close();
                    }
                    throw e32;
                }
                bVar.l(new File(b.hkN + "MMSQL.trace"));
                return;
            }
            x.i("MicroMsg.SQLTraceManager", "sdcard is not  Available,appendToFile fail ");
        }
    }

    static {
        String yM = q.yM();
        ffG = yM;
        ffH = o.getString(yM.hashCode());
    }

    public static b IV() {
        if (hkM == null) {
            hkM = new b();
        }
        return hkM;
    }

    public b() {
        IW();
    }

    private void IW() {
        this.hkO = this.hbz.getLong("sql_trace_main_thread_select_interval_time", 300);
        this.hkP = this.hbz.getLong("sql_trace_main_thread_update_interval_time", 500);
        this.hkQ = this.hbz.getLong("sql_trace_child_thread_interval_time", 1500);
        long bd = bd(ad.getContext());
        if (bd > 0) {
            this.hkO += bd;
            this.hkP += bd;
            this.hkQ += bd;
            x.i("MicroMsg.SQLTraceManager", "auto adapte Time %d", Long.valueOf(bd));
        }
        this.hkR = this.hbz.getLong("sql_trace_child_transaction_interval_time", 5000);
        this.hkV = this.hbz.getLong("sql_trace_file_full_size", 30720);
        this.hkS = this.hbz.getLong("sql_trace_log_file_max_size", 35840);
        this.hkT = this.hbz.getLong("sql_trace_upload_file_min_size", 10240);
        this.hkU = this.hbz.getLong("sql_upload_time_interval", 21600000);
        l(new File(hkN, "MMSQL.trace"));
        x.i("MicroMsg.SQLTraceManager", "update arg %d %d %d %d %d %d %d %d", Long.valueOf(this.hkO), Long.valueOf(this.hkP), Long.valueOf(this.hkQ), Long.valueOf(this.hkR), Long.valueOf(this.hkV), Long.valueOf(this.hkS), Long.valueOf(this.hkT), Long.valueOf(this.hkU));
    }

    public static void setup() {
        if (ad.xnM) {
            x.i("MicroMsg.SQLTraceManager", "trace setup delete old file ret: " + com.tencent.mm.loader.stub.b.deleteFile(hkN + "MMSQL.trace"));
        }
    }

    void l(File file) {
        boolean z = true;
        if (file.exists()) {
            this.hkt = file.length() > this.hkV;
            if (this.hkt) {
                long bc = bc(ad.getContext());
                String str = "MicroMsg.SQLTraceManager";
                String str2 = "has mark lastFullTime %b";
                Object[] objArr = new Object[1];
                if (bc == 0) {
                    z = false;
                }
                objArr[0] = Boolean.valueOf(z);
                x.i(str, str2, objArr);
                if (bc == 0) {
                    d(ad.getContext(), System.currentTimeMillis());
                    return;
                }
                return;
            }
            return;
        }
        this.hkt = false;
    }

    public static String is(String str) {
        FileInputStream fileInputStream;
        Throwable e;
        FileInputStream fileInputStream2;
        try {
            fileInputStream2 = new FileInputStream(new File(str));
            try {
                byte[] bArr = new byte[fileInputStream2.available()];
                fileInputStream2.read(bArr);
                String str2 = new String(com.tencent.mm.bz.e.bB(bArr));
                try {
                    fileInputStream2.close();
                    return str2;
                } catch (Throwable e2) {
                    x.printErrStackTrace("MicroMsg.SQLTraceManager", e2, "", new Object[0]);
                    return str2;
                }
            } catch (IOException e3) {
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable e4) {
                        x.printErrStackTrace("MicroMsg.SQLTraceManager", e4, "", new Object[0]);
                    }
                }
                return null;
            } catch (Throwable th) {
                e4 = th;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (Throwable e22) {
                        x.printErrStackTrace("MicroMsg.SQLTraceManager", e22, "", new Object[0]);
                    }
                }
                throw e4;
            }
        } catch (IOException e5) {
            fileInputStream = null;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            return null;
        } catch (Throwable th2) {
            e4 = th2;
            fileInputStream2 = null;
            if (fileInputStream2 != null) {
                fileInputStream2.close();
            }
            throw e4;
        }
    }

    private static long a(String str, h hVar) {
        Cursor a = hVar.a("select count(*) from " + str, null, 2);
        long j = 0;
        if (a.moveToFirst()) {
            j = a.getLong(0);
        }
        a.close();
        return j;
    }

    private String IP() {
        String format;
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        printStream.println("#client.version=" + d.vHl);
        printStream.println("#accinfo.revision=" + com.tencent.mm.sdk.platformtools.e.REV);
        printStream.println("#accinfo.uin=" + ar.hhz.H("last_login_uin", ffH));
        printStream.println("#accinfo.dev=" + ffG);
        printStream.println("#accinfo.build=" + com.tencent.mm.sdk.platformtools.e.TIME + ":" + com.tencent.mm.sdk.platformtools.e.HOSTNAME + ":" + com.tencent.mm.sdk.platformtools.f.fei);
        String str = "";
        try {
            StatFs statFs = new StatFs(com.tencent.mm.compatible.util.h.getDataDirectory().getPath());
            StatFs statFs2 = new StatFs(e.bnD);
            format = String.format("%dMB %s:%d:%d:%d %s:%d:%d:%d", new Object[]{Integer.valueOf(((ActivityManager) ad.getContext().getSystemService("activity")).getMemoryClass()), r4.getAbsolutePath(), Integer.valueOf(statFs.getBlockSize()), Integer.valueOf(statFs.getBlockCount()), Integer.valueOf(statFs.getAvailableBlocks()), e.bnD, Integer.valueOf(statFs2.getBlockSize()), Integer.valueOf(statFs2.getBlockCount()), Integer.valueOf(statFs2.getAvailableBlocks())});
        } catch (Exception e) {
            x.e("MicroMsg.SQLTraceManager", "check data size failed :%s", e.getMessage());
            format = str;
        }
        printStream.println("#accinfo.data=" + format);
        Date date = new Date();
        printStream.println("#accinfo.uploadTime=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.getDefault()).format(date));
        long bd = bd(ad.getContext());
        if (bd > 0) {
            printStream.println("#logfile.autoAdapteTime :" + bd);
        }
        if (bc(ad.getContext()) != 0) {
            long bc = bc(ad.getContext()) - bb(ad.getContext());
            printStream.println("#logfile.fulllast :" + bc);
            if (bc > 0 && bc < 28800000) {
                PreferenceManager.getDefaultSharedPreferences(ad.getContext()).edit().putLong("sql_trace_log_autoAdaptaTime", bd + 100).commit();
                x.i("MicroMsg.SQLTraceManager", "auto Adapte Time to %d", Long.valueOf(bd));
                IW();
            }
        } else {
            printStream.println("#logfile.fullTimelast :" + (System.currentTimeMillis() - bb(ad.getContext())));
        }
        m[] in = r.QO().in(21);
        if (in == null || in.length == 0 || in[0] == null) {
            printStream.println("#traceconfig hardcode");
        } else {
            printStream.println("#traceconfig id=" + in[0].id + " version=" + in[0].version);
        }
        if (this.ffK[1] != -1) {
            printStream.println("#wxpackage :cache size=" + this.ffK[0] + " data size= " + this.ffK[1] + " code size =" + this.ffK[2]);
        }
        StringBuilder stringBuilder = new StringBuilder("#dbsize : EnMicroMsg.db size=");
        as.Hm();
        printStream.println(stringBuilder.append(new File(c.CZ()).length()).toString());
        stringBuilder = new StringBuilder("#dbsize : SnsMicroMsg.db size=");
        StringBuilder stringBuilder2 = new StringBuilder();
        as.Hm();
        printStream.println(stringBuilder.append(new File(stringBuilder2.append(c.FI()).append("SnsMicroMsg.db").toString()).length()).toString());
        as.Hm();
        a(c.Fd(), printStream, Arrays.asList(new String[]{"message", "rconversation", "rcontact", "ImgInfo2", "BizInfo", "img_flag", "fmessage_conversation", "AppInfo", "AppMessage", "EmojiInfo", "EmojiGroupInfo", "bottleconversation", "bottlemessage", "chatroom", "rbottleconversation", "userinfo"}));
        printStream.println("#sql.content:");
        format = byteArrayOutputStream.toString();
        try {
            byteArrayOutputStream.close();
        } catch (Exception e2) {
        }
        return format;
    }

    private static void a(h hVar, PrintStream printStream, List<String> list) {
        if (hVar == null || !hVar.isOpen()) {
            x.i("MicroMsg.SQLTraceManager", "db is not open!");
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (list == null || list.size() <= 0) {
            Cursor a = hVar.a("select name from sqlite_master where type='table' ", null, 2);
            while (a.moveToNext()) {
                String string = a.getString(0);
                printStream.println("#table : " + string + " count=" + a(string, hVar));
            }
            a.close();
        } else {
            for (String str : list) {
                printStream.println("#table : " + str + " count=" + a(str, hVar));
            }
        }
        x.i("MicroMsg.SQLTraceManager", "dump all table count last %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
    }

    public static void a(String str, String str2, StringBuilder stringBuilder) {
        stringBuilder.append(str).append(":").append(str2).append(" ");
    }

    public final void iu(String str) {
        if (str == null) {
            str = "";
        }
        Intent intent = new Intent();
        intent.setClassName(ad.getPackageName(), "com.tencent.mm.sandbox.monitor.ExceptionMonitorService");
        intent.setAction("uncatch_exception");
        intent.putExtra("exceptionPid", Process.myPid());
        String str2 = "userName";
        String H = ar.hhz.H("login_weixin_username", "");
        if (bi.oN(H)) {
            H = ar.hhz.H("login_user_name", "never_login_crash");
        }
        intent.putExtra(str2, H);
        intent.putExtra("tag", "SqlTrace");
        intent.putExtra("exceptionMsg", Base64.encodeToString((IP() + str).getBytes(), 2));
        ad.getContext().startService(intent);
    }

    void a(File file, boolean z) {
        x.i("MicroMsg.SQLTraceManager", "build log file ,needRecreate %b", Boolean.valueOf(z));
        if (file.exists()) {
            if (z) {
                file.delete();
            }
            l(file);
        }
        try {
            file.createNewFile();
            Context context = ad.getContext();
            PreferenceManager.getDefaultSharedPreferences(context).edit().putLong("sql_trace_log_file_create_time", System.currentTimeMillis()).commit();
            d(ad.getContext(), 0);
        } catch (IOException e) {
            x.e("MicroMsg.SQLTraceManager", "recreate log file fail");
        }
        l(file);
    }

    public static void c(Context context, long j) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putLong("sql_report_lastUploadTime", j).commit();
    }

    public static long ba(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getLong("sql_report_lastUploadTime", 0);
    }

    private static long bb(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getLong("sql_trace_log_file_create_time", 0);
    }

    private static void d(Context context, long j) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putLong("sql_trace_log_file_full_time", j).commit();
    }

    private static long bc(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getLong("sql_trace_log_file_full_time", 0);
    }

    private static long bd(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getLong("sql_trace_log_autoAdaptaTime", 0);
    }

    public final void IQ() {
        x.i("MicroMsg.SQLTraceManager", "updateIntervalArg ");
        IW();
    }
}
