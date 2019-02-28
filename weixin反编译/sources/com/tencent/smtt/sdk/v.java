package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.g;
import com.tencent.smtt.utils.p;
import com.tencent.smtt.utils.q;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.json.JSONArray;

class v {
    private static v Ahn;
    private Handler Aho = null;
    boolean Ahp = false;
    private Context mContext;

    public enum a {
        TYPE_DOWNLOAD(0),
        TYPE_INSTALL(1),
        TYPE_LOAD(2),
        TYPE_DOWNLOAD_DECOUPLE(3),
        TYPE_INSTALL_DECOUPLE(4),
        TYPE_COOKIE_DB_SWITCH(5);
        
        int value;

        private a(int i) {
            this.value = i;
        }
    }

    public static class b implements Cloneable {
        String AhA;
        int AhB;
        int AhC;
        int AhD;
        int AhE;
        String AhF;
        int AhG;
        int AhH;
        long AhI;
        long AhJ;
        int AhK;
        private String AhL;
        private String AhM;
        long AhN;
        long Ahy;
        String Ahz;
        int mErrorCode;

        private b() {
            cES();
        }

        /* synthetic */ b(byte b) {
            this();
        }

        public final void abU(String str) {
            setErrorCode(108);
            this.AhL = str;
        }

        public final void abV(String str) {
            if (str != null) {
                if (str.length() > WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
                    str = str.substring(0, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
                }
                this.AhM = str;
            }
        }

        public final void cES() {
            this.Ahy = 0;
            this.Ahz = null;
            this.AhA = null;
            this.AhB = 0;
            this.AhC = 0;
            this.AhD = 0;
            this.AhE = 2;
            this.AhF = "unknown";
            this.AhG = 0;
            this.AhH = 2;
            this.AhI = 0;
            this.AhJ = 0;
            this.AhK = 1;
            this.mErrorCode = 0;
            this.AhL = null;
            this.AhM = null;
            this.AhN = 0;
        }

        protected final Object clone() {
            try {
                return super.clone();
            } catch (CloneNotSupportedException e) {
                return this;
            }
        }

        public final void m(Throwable th) {
            if (th == null) {
                this.AhM = "";
                return;
            }
            String stackTraceString = Log.getStackTraceString(th);
            if (stackTraceString.length() > WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
                stackTraceString = stackTraceString.substring(0, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            }
            this.AhM = stackTraceString;
        }

        public final void setErrorCode(int i) {
            if (!(i == 100 || i == 110 || i == 120 || i == 111 || i >= 400)) {
                TbsLog.i("TbsDownload", "error occured, errorCode:" + i, true);
            }
            if (i == 111) {
                TbsLog.i("TbsDownload", "you are not in wifi, downloading stoped", true);
            }
            this.mErrorCode = i;
        }
    }

    private static class c {
        private final String AhO;
        private final String AhP;

        public c(String str, String str2) {
            this.AhO = str;
            this.AhP = str2;
        }

        public final void cFI() {
            ZipOutputStream zipOutputStream;
            BufferedInputStream bufferedInputStream;
            RandomAccessFile randomAccessFile;
            int parseInt;
            int read;
            Throwable th;
            BufferedInputStream bufferedInputStream2;
            Throwable th2;
            ZipOutputStream zipOutputStream2;
            FileOutputStream fileOutputStream;
            RandomAccessFile randomAccessFile2 = null;
            FileOutputStream fileOutputStream2;
            try {
                fileOutputStream2 = new FileOutputStream(this.AhP);
                try {
                    zipOutputStream = new ZipOutputStream(new BufferedOutputStream(fileOutputStream2));
                    try {
                        byte[] bArr = new byte[2048];
                        String str = this.AhO;
                        FileInputStream fileInputStream;
                        try {
                            fileInputStream = new FileInputStream(str);
                            try {
                                bufferedInputStream = new BufferedInputStream(fileInputStream, 2048);
                            } catch (Exception e) {
                                bufferedInputStream = null;
                                if (bufferedInputStream != null) {
                                    try {
                                        bufferedInputStream.close();
                                    } catch (IOException e2) {
                                    }
                                }
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (IOException e3) {
                                    }
                                }
                                randomAccessFile = new RandomAccessFile(new File(this.AhP), "rw");
                                parseInt = Integer.parseInt("00001000", 2);
                                randomAccessFile.seek(7);
                                read = randomAccessFile.read();
                                if ((read & parseInt) > 0) {
                                    randomAccessFile.seek(7);
                                    randomAccessFile.write(((parseInt ^ -1) & 255) & read);
                                }
                                try {
                                    randomAccessFile.close();
                                } catch (IOException e4) {
                                }
                                zipOutputStream.close();
                                fileOutputStream2.close();
                            } catch (Throwable th3) {
                                th = th3;
                                if (bufferedInputStream2 != null) {
                                    try {
                                        bufferedInputStream2.close();
                                    } catch (IOException e5) {
                                    }
                                }
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (IOException e6) {
                                    }
                                }
                                throw th;
                            }
                            try {
                                zipOutputStream.putNextEntry(new ZipEntry(str.substring(str.lastIndexOf("/") + 1)));
                                while (true) {
                                    int read2 = bufferedInputStream.read(bArr, 0, 2048);
                                    if (read2 == -1) {
                                        break;
                                    }
                                    zipOutputStream.write(bArr, 0, read2);
                                }
                                zipOutputStream.flush();
                                zipOutputStream.closeEntry();
                                try {
                                    bufferedInputStream.close();
                                } catch (IOException e7) {
                                }
                                try {
                                    fileInputStream.close();
                                } catch (IOException e8) {
                                }
                            } catch (Exception e9) {
                                if (bufferedInputStream != null) {
                                    bufferedInputStream.close();
                                }
                                if (fileInputStream != null) {
                                    fileInputStream.close();
                                }
                                randomAccessFile = new RandomAccessFile(new File(this.AhP), "rw");
                                parseInt = Integer.parseInt("00001000", 2);
                                randomAccessFile.seek(7);
                                read = randomAccessFile.read();
                                if ((read & parseInt) > 0) {
                                    randomAccessFile.seek(7);
                                    randomAccessFile.write(((parseInt ^ -1) & 255) & read);
                                }
                                randomAccessFile.close();
                                zipOutputStream.close();
                                fileOutputStream2.close();
                            } catch (Throwable th4) {
                                th2 = th4;
                                bufferedInputStream2 = bufferedInputStream;
                                th = th2;
                                if (bufferedInputStream2 != null) {
                                    bufferedInputStream2.close();
                                }
                                if (fileInputStream != null) {
                                    fileInputStream.close();
                                }
                                throw th;
                            }
                        } catch (Exception e10) {
                            bufferedInputStream = null;
                            fileInputStream = null;
                            if (bufferedInputStream != null) {
                                bufferedInputStream.close();
                            }
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            randomAccessFile = new RandomAccessFile(new File(this.AhP), "rw");
                            parseInt = Integer.parseInt("00001000", 2);
                            randomAccessFile.seek(7);
                            read = randomAccessFile.read();
                            if ((read & parseInt) > 0) {
                                randomAccessFile.seek(7);
                                randomAccessFile.write(((parseInt ^ -1) & 255) & read);
                            }
                            randomAccessFile.close();
                            zipOutputStream.close();
                            fileOutputStream2.close();
                        } catch (Throwable th5) {
                            th = th5;
                            fileInputStream = null;
                            if (bufferedInputStream2 != null) {
                                bufferedInputStream2.close();
                            }
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            throw th;
                        }
                        try {
                            randomAccessFile = new RandomAccessFile(new File(this.AhP), "rw");
                            try {
                                parseInt = Integer.parseInt("00001000", 2);
                                randomAccessFile.seek(7);
                                read = randomAccessFile.read();
                                if ((read & parseInt) > 0) {
                                    randomAccessFile.seek(7);
                                    randomAccessFile.write(((parseInt ^ -1) & 255) & read);
                                }
                                randomAccessFile.close();
                            } catch (Exception e11) {
                                randomAccessFile2 = randomAccessFile;
                                if (randomAccessFile2 != null) {
                                    try {
                                        randomAccessFile2.close();
                                    } catch (IOException e12) {
                                    }
                                }
                                zipOutputStream.close();
                                fileOutputStream2.close();
                            } catch (Throwable th42) {
                                th2 = th42;
                                randomAccessFile2 = randomAccessFile;
                                th = th2;
                                if (randomAccessFile2 != null) {
                                    try {
                                        randomAccessFile2.close();
                                    } catch (IOException e13) {
                                    }
                                }
                                throw th;
                            }
                        } catch (Exception e14) {
                            if (randomAccessFile2 != null) {
                                randomAccessFile2.close();
                            }
                            zipOutputStream.close();
                            fileOutputStream2.close();
                        } catch (Throwable th6) {
                            th = th6;
                            if (randomAccessFile2 != null) {
                                randomAccessFile2.close();
                            }
                            throw th;
                        }
                        try {
                            zipOutputStream.close();
                        } catch (IOException e15) {
                        }
                        try {
                            fileOutputStream2.close();
                        } catch (IOException e16) {
                        }
                    } catch (Exception e17) {
                        zipOutputStream2 = zipOutputStream;
                        fileOutputStream = fileOutputStream2;
                    } catch (Throwable th7) {
                        th = th7;
                        if (zipOutputStream != null) {
                            try {
                                zipOutputStream.close();
                            } catch (IOException e18) {
                            }
                        }
                        if (fileOutputStream2 != null) {
                            try {
                                fileOutputStream2.close();
                            } catch (IOException e19) {
                            }
                        }
                        throw th;
                    }
                } catch (Exception e20) {
                    fileOutputStream = fileOutputStream2;
                    if (zipOutputStream2 != null) {
                        try {
                            zipOutputStream2.close();
                        } catch (IOException e21) {
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e22) {
                        }
                    }
                } catch (Throwable th8) {
                    th = th8;
                    zipOutputStream = null;
                    if (zipOutputStream != null) {
                        zipOutputStream.close();
                    }
                    if (fileOutputStream2 != null) {
                        fileOutputStream2.close();
                    }
                    throw th;
                }
            } catch (Exception e23) {
                fileOutputStream = null;
                if (zipOutputStream2 != null) {
                    zipOutputStream2.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (Throwable th9) {
                th = th9;
                zipOutputStream = null;
                fileOutputStream2 = null;
                if (zipOutputStream != null) {
                    zipOutputStream.close();
                }
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
                throw th;
            }
        }
    }

    private v(Context context) {
        this.mContext = context.getApplicationContext();
        HandlerThread handlerThread = new HandlerThread("TbsLogReportThread");
        handlerThread.start();
        this.Aho = new Handler(handlerThread.getLooper()) {
            public final void handleMessage(Message message) {
                if (message.what == 600) {
                    if (message.obj instanceof b) {
                        b bVar = (b) message.obj;
                        v.a(v.this, message.arg1, bVar);
                    }
                } else if (message.what == 601) {
                    v.this.cFG();
                }
            }
        };
    }

    private static String Ir(int i) {
        return i + "|";
    }

    private void a(int i, b bVar, a aVar) {
        bVar.setErrorCode(i);
        bVar.Ahy = System.currentTimeMillis();
        QbSdk.Afr.lR(i);
        a(aVar, bVar);
    }

    static /* synthetic */ void a(v vVar, int i, b bVar) {
        String str;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Ir(i));
        stringBuilder.append(abT(com.tencent.smtt.utils.c.ab(vVar.mContext)));
        stringBuilder.append(abT(p.hY(vVar.mContext)));
        stringBuilder.append(Ir(t.cFy().hc(vVar.mContext)));
        String str2 = Build.MODEL;
        try {
            str = new String(str2.getBytes("UTF-8"), "ISO8859-1");
        } catch (Exception e) {
            str = str2;
        }
        stringBuilder.append(abT(str));
        str = vVar.mContext.getPackageName();
        stringBuilder.append(abT(str));
        if ("com.tencent.mm".equals(str)) {
            stringBuilder.append(abT(com.tencent.smtt.utils.c.bO(vVar.mContext, "com.tencent.mm.BuildInfo.CLIENT_VERSION")));
        } else {
            stringBuilder.append(Ir(com.tencent.smtt.utils.c.getAppVersionCode(vVar.mContext)));
        }
        stringBuilder.append(abT(bq(bVar.Ahy)));
        stringBuilder.append(abT(bVar.Ahz));
        stringBuilder.append(abT(bVar.AhA));
        stringBuilder.append(Ir(bVar.AhB));
        stringBuilder.append(Ir(bVar.AhC));
        stringBuilder.append(Ir(bVar.AhD));
        stringBuilder.append(Ir(bVar.AhE));
        stringBuilder.append(abT(bVar.AhF));
        stringBuilder.append(Ir(bVar.AhG));
        stringBuilder.append(Ir(bVar.AhH));
        stringBuilder.append(gx(bVar.AhN));
        stringBuilder.append(gx(bVar.AhI));
        stringBuilder.append(gx(bVar.AhJ));
        stringBuilder.append(Ir(bVar.AhK));
        stringBuilder.append(Ir(bVar.mErrorCode));
        stringBuilder.append(abT(bVar.AhL));
        stringBuilder.append(abT(bVar.AhM));
        stringBuilder.append(Ir(o.gI(vVar.mContext).Agy.getInt("tbs_download_version", 0)));
        stringBuilder.append(abT(com.tencent.smtt.utils.c.hR(vVar.mContext)));
        stringBuilder.append(abT("3.6.0.1140_43603"));
        stringBuilder.append(false);
        SharedPreferences cFH = vVar.cFH();
        JSONArray cFE = vVar.cFE();
        JSONArray jSONArray = new JSONArray();
        if (jSONArray.length() >= 5) {
            for (int i2 = 4; i2 > 0; i2--) {
                try {
                    jSONArray.put(cFE.get(jSONArray.length() - i2));
                } catch (Exception e2) {
                    TbsLog.e("upload", "JSONArray transform error!");
                }
            }
        } else {
            jSONArray = cFE;
        }
        jSONArray.put(stringBuilder.toString());
        Editor edit = cFH.edit();
        edit.putString("tbs_download_upload", jSONArray.toString());
        edit.commit();
        if (vVar.Ahp || i != a.TYPE_LOAD.value) {
            vVar.cFG();
        }
    }

    private static String abT(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        if (str == null) {
            str = "";
        }
        return stringBuilder.append(str).append("|").toString();
    }

    static /* synthetic */ void b(v vVar) {
        Editor edit = vVar.cFH().edit();
        edit.remove("tbs_download_upload");
        edit.commit();
    }

    private static String bq(long j) {
        String str = null;
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date(j));
        } catch (Exception e) {
            return str;
        }
    }

    public static b cFC() {
        return new b();
    }

    private JSONArray cFE() {
        String string = cFH().getString("tbs_download_upload", null);
        if (string == null) {
            return new JSONArray();
        }
        try {
            JSONArray jSONArray = new JSONArray(string);
            if (jSONArray.length() <= 5) {
                return jSONArray;
            }
            JSONArray jSONArray2 = new JSONArray();
            int length = jSONArray.length() - 1;
            if (length <= jSONArray.length() - 5) {
                return jSONArray;
            }
            jSONArray2.put(jSONArray.get(length));
            return jSONArray2;
        } catch (Exception e) {
            return new JSONArray();
        }
    }

    private void cFG() {
        TbsLog.i("TbsDownload", "[TbsApkDownloadStat.reportDownloadStat]");
        JSONArray cFE = cFE();
        if (cFE.length() == 0) {
            TbsLog.i("TbsDownload", "[TbsApkDownloadStat.reportDownloadStat] no data");
            return;
        }
        TbsLog.i("TbsDownload", "[TbsApkDownloadStat.reportDownloadStat] jsonArray:" + cFE);
        try {
            TbsLog.i("TbsDownload", "[TbsApkDownloadStat.reportDownloadStat] response:" + g.a(q.ib(this.mContext).Aku, cFE.toString().getBytes(ProtocolPackage.ServerEncoding), new com.tencent.smtt.utils.g.a() {
                public final void Iq(int i) {
                    TbsLog.i("TbsDownload", "[TbsApkDownloadStat.reportDownloadStat] onHttpResponseCode:" + i);
                    if (i < 300) {
                        v.b(v.this);
                    }
                }
            }, true) + " testcase: -1");
        } catch (Throwable th) {
        }
    }

    private static String gx(long j) {
        return j + "|";
    }

    public static v hp(Context context) {
        if (Ahn == null) {
            synchronized (v.class) {
                if (Ahn == null) {
                    Ahn = new v(context);
                }
            }
        }
        return Ahn;
    }

    public final void a(int i, String str, a aVar) {
        if (!(i == 200 || i == 220 || i == 221)) {
            TbsLog.i("TbsDownload", "error occured in installation, errorCode:" + i, true);
        }
        b cFC = cFC();
        cFC.abV(str);
        a(i, cFC, aVar);
    }

    public final void a(a aVar, b bVar) {
        try {
            b bVar2 = (b) bVar.clone();
            Message obtainMessage = this.Aho.obtainMessage();
            obtainMessage.what = 600;
            obtainMessage.arg1 = aVar.value;
            obtainMessage.obj = bVar2;
            this.Aho.sendMessage(obtainMessage);
        } catch (Throwable th) {
            TbsLog.w("upload", "[TbsLogReport.eventReport] error, message=" + th.getMessage());
        }
    }

    public final void bi(int i, String str) {
        a(i, str, a.TYPE_INSTALL);
    }

    public final void bj(int i, String str) {
        b cFC = cFC();
        cFC.setErrorCode(i);
        cFC.Ahy = System.currentTimeMillis();
        cFC.abV(str);
        a(a.TYPE_LOAD, cFC);
    }

    public final void c(int i, Throwable th) {
        b cFC = cFC();
        cFC.m(th);
        a(i, cFC, a.TYPE_INSTALL);
    }

    public final void cFD() {
        this.Aho.sendEmptyMessage(601);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void cFF() {
        /*
        r11 = this;
        r10 = 0;
        r2 = 0;
        r0 = r11.mContext;
        r0 = com.tencent.smtt.utils.b.hN(r0);
        r1 = 3;
        if (r0 == r1) goto L_0x000c;
    L_0x000b:
        return;
    L_0x000c:
        r3 = com.tencent.smtt.utils.TbsLog.getTbsLogFilePath();
        if (r3 == 0) goto L_0x000b;
    L_0x0012:
        com.tencent.smtt.utils.j.cGn();
        r5 = com.tencent.smtt.utils.j.cGo();
        r0 = r11.mContext;
        r0 = com.tencent.smtt.utils.c.ab(r0);
        r1 = r11.mContext;
        r4 = com.tencent.smtt.utils.c.hR(r1);
        r1 = r0.getBytes();
        r0 = r4.getBytes();
        r4 = com.tencent.smtt.utils.j.cGn();	 Catch:{ Exception -> 0x0168 }
        r1 = r4.bN(r1);	 Catch:{ Exception -> 0x0168 }
        r4 = com.tencent.smtt.utils.j.cGn();	 Catch:{ Exception -> 0x0168 }
        r0 = r4.bN(r0);	 Catch:{ Exception -> 0x0168 }
    L_0x003d:
        r1 = com.tencent.smtt.utils.j.bytesToHex(r1);
        r0 = com.tencent.smtt.utils.j.bytesToHex(r0);
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r6 = r11.mContext;
        r6 = com.tencent.smtt.utils.q.ib(r6);
        r6 = r6.Akw;
        r4 = r4.append(r6);
        r1 = r4.append(r1);
        r4 = "&aid=";
        r1 = r1.append(r4);
        r0 = r1.append(r0);
        r6 = r0.toString();
        r7 = new java.util.HashMap;
        r7.<init>();
        r0 = "Content-Type";
        r1 = "application/octet-stream";
        r7.put(r0, r1);
        r0 = "Charset";
        r1 = "UTF-8";
        r7.put(r0, r1);
        r0 = "QUA2";
        r1 = r11.mContext;
        r1 = com.tencent.smtt.utils.p.hY(r1);
        r7.put(r0, r1);
        r0 = new java.io.File;	 Catch:{ Exception -> 0x0156, all -> 0x012f }
        r1 = com.tencent.smtt.utils.f.AjM;	 Catch:{ Exception -> 0x0156, all -> 0x012f }
        r0.<init>(r1);	 Catch:{ Exception -> 0x0156, all -> 0x012f }
        r0 = new com.tencent.smtt.sdk.v$c;	 Catch:{ Exception -> 0x0156, all -> 0x012f }
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0156, all -> 0x012f }
        r1.<init>();	 Catch:{ Exception -> 0x0156, all -> 0x012f }
        r4 = com.tencent.smtt.utils.f.AjM;	 Catch:{ Exception -> 0x0156, all -> 0x012f }
        r1 = r1.append(r4);	 Catch:{ Exception -> 0x0156, all -> 0x012f }
        r4 = "/tbslog_temp.zip";
        r1 = r1.append(r4);	 Catch:{ Exception -> 0x0156, all -> 0x012f }
        r1 = r1.toString();	 Catch:{ Exception -> 0x0156, all -> 0x012f }
        r0.<init>(r3, r1);	 Catch:{ Exception -> 0x0156, all -> 0x012f }
        r0.cFI();	 Catch:{ Exception -> 0x0156, all -> 0x012f }
        r3 = new java.io.File;	 Catch:{ Exception -> 0x0156, all -> 0x012f }
        r0 = com.tencent.smtt.utils.f.AjM;	 Catch:{ Exception -> 0x0156, all -> 0x012f }
        r1 = "tbslog_temp.zip";
        r3.<init>(r0, r1);	 Catch:{ Exception -> 0x0156, all -> 0x012f }
        r4 = new java.io.FileInputStream;	 Catch:{ Exception -> 0x015c, all -> 0x014e }
        r4.<init>(r3);	 Catch:{ Exception -> 0x015c, all -> 0x014e }
        r0 = 8192; // 0x2000 float:1.14794E-41 double:4.0474E-320;
        r0 = new byte[r0];	 Catch:{ Exception -> 0x0162, all -> 0x0151 }
        r1 = new java.io.ByteArrayOutputStream;	 Catch:{ Exception -> 0x0162, all -> 0x0151 }
        r1.<init>();	 Catch:{ Exception -> 0x0162, all -> 0x0151 }
    L_0x00c9:
        r8 = r4.read(r0);	 Catch:{ Exception -> 0x00d5, all -> 0x0153 }
        r9 = -1;
        if (r8 == r9) goto L_0x0116;
    L_0x00d0:
        r9 = 0;
        r1.write(r0, r9, r8);	 Catch:{ Exception -> 0x00d5, all -> 0x0153 }
        goto L_0x00c9;
    L_0x00d5:
        r0 = move-exception;
        r0 = r1;
        r1 = r3;
        r3 = r4;
    L_0x00d9:
        if (r3 == 0) goto L_0x00de;
    L_0x00db:
        r3.close();	 Catch:{ Exception -> 0x0146 }
    L_0x00de:
        if (r0 == 0) goto L_0x00e3;
    L_0x00e0:
        r0.close();	 Catch:{ Exception -> 0x0148 }
    L_0x00e3:
        if (r1 == 0) goto L_0x016b;
    L_0x00e5:
        r1.delete();
        r0 = r2;
    L_0x00e9:
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r1 = r1.append(r6);
        r2 = "&ek=";
        r1 = r1.append(r2);
        r1 = r1.append(r5);
        r1 = r1.toString();
        r2 = new com.tencent.smtt.sdk.v$2;
        r2.<init>();
        if (r0 == 0) goto L_0x000b;
    L_0x0108:
        r1 = com.tencent.smtt.utils.g.s(r1, r7);
        if (r1 == 0) goto L_0x000b;
    L_0x010e:
        com.tencent.smtt.utils.g.a(r1, r0);
        com.tencent.smtt.utils.g.a(r1, r2, r10);
        goto L_0x000b;
    L_0x0116:
        r1.flush();	 Catch:{ Exception -> 0x00d5, all -> 0x0153 }
        r0 = com.tencent.smtt.utils.j.cGn();	 Catch:{ Exception -> 0x00d5, all -> 0x0153 }
        r8 = r1.toByteArray();	 Catch:{ Exception -> 0x00d5, all -> 0x0153 }
        r0 = r0.bN(r8);	 Catch:{ Exception -> 0x00d5, all -> 0x0153 }
        r4.close();	 Catch:{ Exception -> 0x0142 }
    L_0x0128:
        r1.close();	 Catch:{ Exception -> 0x0144 }
    L_0x012b:
        r3.delete();
        goto L_0x00e9;
    L_0x012f:
        r0 = move-exception;
        r3 = r2;
        r4 = r2;
    L_0x0132:
        if (r4 == 0) goto L_0x0137;
    L_0x0134:
        r4.close();	 Catch:{ Exception -> 0x014a }
    L_0x0137:
        if (r2 == 0) goto L_0x013c;
    L_0x0139:
        r2.close();	 Catch:{ Exception -> 0x014c }
    L_0x013c:
        if (r3 == 0) goto L_0x0141;
    L_0x013e:
        r3.delete();
    L_0x0141:
        throw r0;
    L_0x0142:
        r2 = move-exception;
        goto L_0x0128;
    L_0x0144:
        r1 = move-exception;
        goto L_0x012b;
    L_0x0146:
        r3 = move-exception;
        goto L_0x00de;
    L_0x0148:
        r0 = move-exception;
        goto L_0x00e3;
    L_0x014a:
        r1 = move-exception;
        goto L_0x0137;
    L_0x014c:
        r1 = move-exception;
        goto L_0x013c;
    L_0x014e:
        r0 = move-exception;
        r4 = r2;
        goto L_0x0132;
    L_0x0151:
        r0 = move-exception;
        goto L_0x0132;
    L_0x0153:
        r0 = move-exception;
        r2 = r1;
        goto L_0x0132;
    L_0x0156:
        r0 = move-exception;
        r0 = r2;
        r1 = r2;
        r3 = r2;
        goto L_0x00d9;
    L_0x015c:
        r0 = move-exception;
        r0 = r2;
        r1 = r3;
        r3 = r2;
        goto L_0x00d9;
    L_0x0162:
        r0 = move-exception;
        r0 = r2;
        r1 = r3;
        r3 = r4;
        goto L_0x00d9;
    L_0x0168:
        r4 = move-exception;
        goto L_0x003d;
    L_0x016b:
        r0 = r2;
        goto L_0x00e9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.v.cFF():void");
    }

    final SharedPreferences cFH() {
        return this.mContext.getSharedPreferences("tbs_download_stat", 4);
    }
}
