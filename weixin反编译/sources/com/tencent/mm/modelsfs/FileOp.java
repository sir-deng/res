package com.tencent.mm.modelsfs;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mm.a.g;
import com.tencent.mm.modelsfs.SFSContext.Builder;
import com.tencent.mm.modelsfs.SFSContext.FileEntry;
import com.tencent.mm.modelsfs.SFSContext.Statistics;
import com.tencent.mm.opensdk.constants.ConstantsAPI.WXApp;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public final class FileOp {
    private static ReentrantReadWriteLock hNP = new ReentrantReadWriteLock();
    private static TreeMap<String, SFSContextRec> hNQ = new TreeMap();
    private static File hNR;
    private static String hNS = "";
    private static final EnumSet<com.tencent.mm.modelsfs.g.a> hNT = EnumSet.of(com.tencent.mm.modelsfs.g.a.PATHNAME, com.tencent.mm.modelsfs.g.a.PERIOD);

    static class SFSContextRec implements Parcelable {
        public static final Creator<SFSContextRec> CREATOR = new Creator<SFSContextRec>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SFSContextRec(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SFSContextRec[i];
            }
        };
        String hNW;
        String[] hNX;
        boolean hNY;
        boolean hNZ;
        SFSContext hOa;
        Builder hOb;

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.hNW);
            parcel.writeStringArray(this.hNX);
            parcel.writeByte((byte) (this.hNY ? 1 : 0));
            parcel.writeParcelable(this.hOb, i);
        }

        SFSContextRec(Parcel parcel) {
            boolean z;
            this.hNW = parcel.readString();
            this.hNX = parcel.createStringArray();
            if (parcel.readByte() != (byte) 0) {
                z = true;
            } else {
                z = false;
            }
            this.hNY = z;
            this.hOa = null;
            this.hNZ = false;
            this.hOb = (Builder) parcel.readParcelable(Builder.class.getClassLoader());
        }
    }

    class a {
        File hNU;
        File[] hNV = null;
        int pos = 0;

        a(File file) {
            this.hNU = file;
        }
    }

    public static void init(boolean z) {
        Context context = ad.getContext();
        hNR = new File(context.getFilesDir(), "fileop_mapping");
        hNS = ax.VT(com.tencent.mm.loader.stub.a.bnD);
        if (z) {
            hNR.delete();
            return;
        }
        x.i("MicroMsg.FileOp", "Initializing FileOp mapping slave.");
        if (hNR.exists()) {
            byte[] d = d(hNR.getAbsolutePath(), 0, -1);
            if (d != null) {
                Parcel obtain = Parcel.obtain();
                obtain.unmarshall(d, 0, d.length);
                obtain.setDataPosition(0);
                Bundle readBundle = obtain.readBundle(SFSContextRec.class.getClassLoader());
                obtain.recycle();
                hNP.writeLock().lock();
                for (String str : readBundle.keySet()) {
                    SFSContextRec sFSContextRec = (SFSContextRec) hNQ.put(str, (SFSContextRec) readBundle.getParcelable(str));
                    if (!(sFSContextRec == null || sFSContextRec.hOa == null)) {
                        sFSContextRec.hOa.release();
                    }
                    x.i("MicroMsg.FileOp", "Load mapping from file: " + str);
                }
                hNP.writeLock().unlock();
            }
        }
        BroadcastReceiver anonymousClass1 = new BroadcastReceiver() {
            public final void onReceive(Context context, Intent intent) {
                SFSContextRec sFSContextRec;
                if (intent.getAction().equals("com.tencent.mm.FileOp.registerSFS")) {
                    byte[] byteArrayExtra = intent.getByteArrayExtra("rec");
                    if (byteArrayExtra != null) {
                        Parcel obtain = Parcel.obtain();
                        obtain.unmarshall(byteArrayExtra, 0, byteArrayExtra.length);
                        obtain.setDataPosition(0);
                        sFSContextRec = (SFSContextRec) SFSContextRec.CREATOR.createFromParcel(obtain);
                        if (sFSContextRec != null) {
                            String str = sFSContextRec.hNW;
                            FileOp.hNP.writeLock().lock();
                            sFSContextRec = (SFSContextRec) FileOp.hNQ.put(str, sFSContextRec);
                            FileOp.hNP.writeLock().unlock();
                            if (!(sFSContextRec == null || sFSContextRec.hOa == null)) {
                                sFSContextRec.hOa.release();
                            }
                            x.i("MicroMsg.FileOp", "Load mapping from broadcast: " + str);
                            obtain.recycle();
                        }
                    }
                } else if (intent.getAction().equals("com.tencent.mm.FileOp.unregisterSFS")) {
                    String stringExtra = intent.getStringExtra("prefix");
                    FileOp.hNP.writeLock().lock();
                    sFSContextRec = (SFSContextRec) FileOp.hNQ.remove(stringExtra);
                    FileOp.hNP.writeLock().unlock();
                    if (!(sFSContextRec == null || sFSContextRec.hOa == null)) {
                        sFSContextRec.hOa.release();
                    }
                    x.i("MicroMsg.FileOp", "Unload mapping from broadcast: " + stringExtra);
                } else if (intent.getAction().equals("com.tencent.mm.FileOp.clearSFS")) {
                    FileOp.hNP.writeLock().lock();
                    for (SFSContextRec sFSContextRec2 : FileOp.hNQ.values()) {
                        if (!(sFSContextRec2 == null || sFSContextRec2.hOa == null)) {
                            sFSContextRec2.hOa.release();
                        }
                    }
                    FileOp.hNQ.clear();
                    FileOp.hNP.writeLock().unlock();
                    x.i("MicroMsg.FileOp", "Clear mapping from broadcast.");
                }
            }
        };
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.mm.FileOp.registerSFS");
        intentFilter.addAction("com.tencent.mm.FileOp.unregisterSFS");
        intentFilter.addAction("com.tencent.mm.FileOp.clearSFS");
        context.registerReceiver(anonymousClass1, intentFilter, WXApp.WXAPP_BROADCAST_PERMISSION, null);
    }

    private static void RC() {
        Bundle bundle = new Bundle();
        hNP.readLock().lock();
        for (SFSContextRec sFSContextRec : hNQ.values()) {
            bundle.putParcelable(sFSContextRec.hNW, sFSContextRec);
        }
        hNP.readLock().unlock();
        Parcel obtain = Parcel.obtain();
        bundle.writeToParcel(obtain, 0);
        String absolutePath = hNR.getAbsolutePath();
        byte[] marshall = obtain.marshall();
        b(absolutePath, marshall, marshall.length);
        obtain.recycle();
    }

    public static void a(String str, String[] strArr, Builder builder) {
        SFSContextRec sFSContextRec = null;
        if (builder == null) {
            mb(str);
        } else if (hNS.toLowerCase().contains("fat")) {
            x.i("MicroMsg.FileOp", "SFS enabled on file system '%s'", hNS);
            if (new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/tencent/MicroMsg/disable-sfs").exists()) {
                x.i("MicroMsg.FileOp", "SFS disabled.");
                return;
            }
            if (builder != null) {
                String[] strArr2;
                SFSContextRec sFSContextRec2 = new SFSContextRec();
                sFSContextRec2.hNW = str;
                if (strArr == null || strArr.length == 0) {
                    strArr2 = null;
                } else {
                    strArr2 = (String[]) Arrays.copyOf(strArr, strArr.length);
                }
                sFSContextRec2.hNX = strArr2;
                sFSContextRec2.hNY = false;
                sFSContextRec2.hOa = null;
                sFSContextRec2.hOb = builder;
                sFSContextRec = sFSContextRec2;
            }
            hNP.writeLock().lock();
            SFSContextRec sFSContextRec3 = (SFSContextRec) hNQ.put(str, sFSContextRec);
            hNP.writeLock().unlock();
            if (!(sFSContextRec3 == null || sFSContextRec3.hOa == null)) {
                sFSContextRec3.hOa.release();
            }
            Parcel obtain = Parcel.obtain();
            sFSContextRec.writeToParcel(obtain, 0);
            byte[] marshall = obtain.marshall();
            obtain.recycle();
            Context context = ad.getContext();
            context.sendBroadcast(new Intent("com.tencent.mm.FileOp.registerSFS").putExtra("rec", marshall).setPackage(context.getPackageName()), WXApp.WXAPP_BROADCAST_PERMISSION);
            RC();
            x.i("MicroMsg.FileOp", "Register SFS for prefix: " + str);
        } else {
            x.i("MicroMsg.FileOp", "SFS disabled on file system '%s'", hNS);
        }
    }

    public static void mb(String str) {
        hNP.writeLock().lock();
        SFSContextRec sFSContextRec = (SFSContextRec) hNQ.remove(str);
        hNP.writeLock().unlock();
        if (!(sFSContextRec == null || sFSContextRec.hOa == null)) {
            sFSContextRec.hOa.release();
        }
        Context context = ad.getContext();
        context.sendBroadcast(new Intent("com.tencent.mm.FileOp.unregisterSFS").putExtra("prefix", str).setPackage(context.getPackageName()), WXApp.WXAPP_BROADCAST_PERMISSION);
        RC();
        x.i("MicroMsg.FileOp", "Unregister SFS for prefix: " + str);
    }

    public static Map<String, Statistics> RD() {
        hNP.readLock().lock();
        Map treeMap = new TreeMap();
        for (SFSContextRec sFSContextRec : hNQ.values()) {
            if (!(sFSContextRec == null || sFSContextRec.hNZ)) {
                if (sFSContextRec.hOa == null) {
                    synchronized (sFSContextRec) {
                        if (sFSContextRec.hOa == null) {
                            try {
                                sFSContextRec.hOa = sFSContextRec.hOb.create();
                            } catch (Exception e) {
                                x.e("MicroMsg.FileOp", "Failed to create SFSContext for prefix '%s': %s", sFSContextRec.hNW, e.getMessage());
                                sFSContextRec.hNZ = true;
                            }
                        }
                    }
                }
                SFSContext sFSContext = sFSContextRec.hOa;
                if (sFSContext.mNativePtr == 0) {
                    throw new IllegalArgumentException("Reuse already released SFSContext.");
                }
                treeMap.put(sFSContextRec.hOb.mName, SFSContext.nativeStatistics(sFSContext.mNativePtr));
            }
        }
        hNP.readLock().unlock();
        return treeMap;
    }

    private static boolean a(String str, SFSContextRec sFSContextRec) {
        if (sFSContextRec.hNX == null) {
            return false;
        }
        String substring = str.substring(sFSContextRec.hNW.length());
        int lastIndexOf = substring.lastIndexOf(47);
        if (lastIndexOf == -1) {
            return false;
        }
        String substring2 = substring.substring(lastIndexOf + 1);
        if (substring2.length() == 0) {
            return false;
        }
        for (String a : sFSContextRec.hNX) {
            if (g.a(a, 0, substring2, 0, hNT)) {
                return true;
            }
        }
        return false;
    }

    private static boolean mc(String str) {
        boolean z;
        hNP.readLock().lock();
        Entry floorEntry = hNQ.floorEntry(str);
        if (floorEntry != null && str.startsWith((String) floorEntry.getKey())) {
            SFSContextRec sFSContextRec = (SFSContextRec) floorEntry.getValue();
            if (!(sFSContextRec.hNZ || sFSContextRec.hNX != null || sFSContextRec.hNY)) {
                z = false;
                hNP.readLock().unlock();
                return z;
            }
        }
        z = true;
        hNP.readLock().unlock();
        return z;
    }

    private static boolean md(String str) {
        boolean z;
        hNP.readLock().lock();
        Entry floorEntry = hNQ.floorEntry(str);
        if (floorEntry != null && str.startsWith((String) floorEntry.getKey())) {
            SFSContextRec sFSContextRec = (SFSContextRec) floorEntry.getValue();
            if (!(sFSContextRec.hNZ || a(str, sFSContextRec))) {
                z = false;
                hNP.readLock().unlock();
                return z;
            }
        }
        z = true;
        hNP.readLock().unlock();
        return z;
    }

    private static SFSContextRec me(String str) {
        hNP.readLock().lock();
        Entry floorEntry = hNQ.floorEntry(str);
        if (floorEntry == null) {
            return null;
        }
        SFSContextRec sFSContextRec;
        if (str.startsWith((String) floorEntry.getKey())) {
            sFSContextRec = (SFSContextRec) floorEntry.getValue();
            if (a(str, sFSContextRec)) {
                sFSContextRec = null;
            }
        } else {
            sFSContextRec = null;
        }
        if (sFSContextRec == null || sFSContextRec.hNZ) {
            return null;
        }
        if (sFSContextRec.hOa != null) {
            return sFSContextRec;
        }
        synchronized (sFSContextRec) {
            if (sFSContextRec.hOa == null) {
                try {
                    sFSContextRec.hOa = sFSContextRec.hOb.create();
                } catch (Exception e) {
                    x.e("MicroMsg.FileOp", "Failed to create SFSContext for prefix '%s': %s", sFSContextRec.hNW, e.getMessage());
                    sFSContextRec.hNZ = true;
                    return null;
                }
            }
        }
        return sFSContextRec;
    }

    public static java.io.InputStream openRead(java.lang.String r7) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Exception block dominator not found, method:com.tencent.mm.modelsfs.FileOp.openRead(java.lang.String):java.io.InputStream, dom blocks: [B:7:0x0017, B:21:0x0062]
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:89)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:32)
	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
	at java.lang.Iterable.forEach(Iterable.java:75)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:286)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:201)
*/
        /*
        if (r7 == 0) goto L_0x0008;
    L_0x0002:
        r0 = r7.length();
        if (r0 != 0) goto L_0x0011;
    L_0x0008:
        r0 = new java.io.FileNotFoundException;
        r1 = "path == null";
        r0.<init>(r1);
        throw r0;
    L_0x0011:
        r1 = me(r7);
        if (r1 != 0) goto L_0x0062;
    L_0x0017:
        r0 = com.tencent.mm.modelsfs.f.mp(r7);	 Catch:{ all -> 0x0057 }
        if (r0 == 0) goto L_0x0051;	 Catch:{ all -> 0x0057 }
    L_0x001d:
        r2 = com.tencent.mm.modelsfs.f.mr(r7);	 Catch:{ all -> 0x0057 }
        r4 = com.tencent.mm.modelsfs.f.mq(r7);	 Catch:{ all -> 0x0057 }
        r0 = new com.tencent.mm.modelsfs.b;	 Catch:{ all -> 0x0057 }
        r0.<init>(r4, r2);	 Catch:{ all -> 0x0057 }
    L_0x002a:
        r2 = hNP;
        r2 = r2.readLock();
        r2.unlock();
        r2 = "MicroMsg.FileOp";
        r3 = "openRead: %s [%s, %s]";
        r4 = 3;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r4[r5] = r7;
        r5 = 1;
        r6 = "ok";
        r4[r5] = r6;
        r5 = 2;
        if (r1 != 0) goto L_0x007f;
    L_0x0048:
        r1 = "regular";
    L_0x004b:
        r4[r5] = r1;
        com.tencent.mm.sdk.platformtools.x.d(r2, r3, r4);
        return r0;
    L_0x0051:
        r0 = new java.io.FileInputStream;	 Catch:{ all -> 0x0057 }
        r0.<init>(r7);	 Catch:{ all -> 0x0057 }
        goto L_0x002a;
    L_0x0057:
        r0 = move-exception;
        r1 = hNP;
        r1 = r1.readLock();
        r1.unlock();
        throw r0;
    L_0x0062:
        r0 = r1.hNW;	 Catch:{ FileNotFoundException -> 0x0073 }
        r0 = r0.length();	 Catch:{ FileNotFoundException -> 0x0073 }
        r0 = r7.substring(r0);	 Catch:{ FileNotFoundException -> 0x0073 }
        r2 = r1.hOa;	 Catch:{ FileNotFoundException -> 0x0073 }
        r0 = r2.openRead(r0);	 Catch:{ FileNotFoundException -> 0x0073 }
        goto L_0x002a;
    L_0x0073:
        r0 = move-exception;
        r2 = r1.hNY;	 Catch:{ all -> 0x0057 }
        if (r2 != 0) goto L_0x0079;	 Catch:{ all -> 0x0057 }
    L_0x0078:
        throw r0;	 Catch:{ all -> 0x0057 }
    L_0x0079:
        r0 = new java.io.FileInputStream;	 Catch:{ all -> 0x0057 }
        r0.<init>(r7);	 Catch:{ all -> 0x0057 }
        goto L_0x002a;
    L_0x007f:
        r1 = "SFS";
        goto L_0x004b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelsfs.FileOp.openRead(java.lang.String):java.io.InputStream");
    }

    public static OutputStream iH(String str) {
        return mf(str);
    }

    public static OutputStream mf(String str) {
        if (str == null || str.length() == 0) {
            throw new FileNotFoundException("path == null");
        }
        String str2 = "";
        if (f.mp(str)) {
            str2 = f.ms(str);
            str = f.mq(str);
        }
        return as(str, str2);
    }

    private static OutputStream as(String str, String str2) {
        if (str == null || str.length() == 0) {
            throw new FileNotFoundException("path == null");
        }
        OutputStream fileOutputStream;
        SFSContextRec me = me(str);
        if (me == null) {
            try {
                if (TextUtils.isEmpty(str2)) {
                    fileOutputStream = new FileOutputStream(str);
                } else {
                    fileOutputStream = new c(str, str2);
                }
            } catch (Throwable th) {
                hNP.readLock().unlock();
            }
        } else {
            fileOutputStream = me.hOa.au(str.substring(me.hNW.length()), str2);
        }
        hNP.readLock().unlock();
        String str3 = "MicroMsg.FileOp";
        String str4 = "openWrite: %s [%s, %s]";
        Object[] objArr = new Object[3];
        objArr[0] = str;
        objArr[1] = "ok";
        objArr[2] = me == null ? "regular" : "SFS";
        x.d(str3, str4, objArr);
        return fileOutputStream;
    }

    public static boolean mg(String str) {
        InputStream openRead;
        IOException e;
        InputStream inputStream;
        Throwable th;
        OutputStream outputStream = null;
        if (str == null || str.length() == 0) {
            return false;
        }
        SFSContextRec me = me(str);
        if (me == null) {
            hNP.readLock().unlock();
            return true;
        }
        try {
            OutputStream fileOutputStream;
            openRead = me.hOa.openRead(str.substring(me.hNW.length()));
            try {
                String parent = new File(str).getParent();
                if (!bi.oN(parent)) {
                    new File(parent).mkdirs();
                }
                fileOutputStream = new FileOutputStream(str);
            } catch (IOException e2) {
                e = e2;
                inputStream = openRead;
                try {
                    x.e("MicroMsg.FileOp", "Failed export '%s' to native: %s", str, e.getMessage());
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e3) {
                        }
                    }
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e4) {
                        }
                    }
                    hNP.readLock().unlock();
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    openRead = inputStream;
                    if (openRead != null) {
                        try {
                            openRead.close();
                        } catch (IOException e5) {
                        }
                    }
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e6) {
                        }
                    }
                    hNP.readLock().unlock();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                if (openRead != null) {
                    openRead.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
                hNP.readLock().unlock();
                throw th;
            }
            try {
                byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                while (true) {
                    int read = openRead.read(bArr);
                    if (read != -1) {
                        fileOutputStream.write(bArr, 0, read);
                    } else {
                        try {
                            break;
                        } catch (IOException e7) {
                        }
                    }
                }
                openRead.close();
                try {
                    fileOutputStream.close();
                } catch (IOException e8) {
                }
                hNP.readLock().unlock();
                return true;
            } catch (IOException e9) {
                e = e9;
                outputStream = fileOutputStream;
                inputStream = openRead;
                x.e("MicroMsg.FileOp", "Failed export '%s' to native: %s", str, e.getMessage());
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
                hNP.readLock().unlock();
                return false;
            } catch (Throwable th4) {
                th = th4;
                outputStream = fileOutputStream;
                if (openRead != null) {
                    openRead.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
                hNP.readLock().unlock();
                throw th;
            }
        } catch (IOException e10) {
            e = e10;
            inputStream = null;
        } catch (Throwable th5) {
            th = th5;
            openRead = null;
            if (openRead != null) {
                openRead.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
            hNP.readLock().unlock();
            throw th;
        }
    }

    public static boolean mh(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        return new File(str).delete();
    }

    public static long mi(String str) {
        long j = 0;
        if (str != null) {
            String str2;
            SFSContextRec me = me(str);
            String mq;
            if (me != null) {
                FileEntry mu = me.hOa.mu(str.substring(me.hNW.length()));
                if (mu != null) {
                    j = mu.size;
                } else if (me.hNY) {
                    if (f.mp(str)) {
                        mq = f.mq(str);
                    } else {
                        mq = str;
                    }
                    j = new File(mq).length();
                }
            } else {
                if (f.mp(str)) {
                    mq = f.mq(str);
                } else {
                    mq = str;
                }
                j = new File(mq).length();
            }
            hNP.readLock().unlock();
            String str3 = "MicroMsg.FileOp";
            String str4 = "readFileLength: %s [%d, %s]";
            Object[] objArr = new Object[3];
            objArr[0] = str;
            objArr[1] = Long.valueOf(j);
            if (me == null) {
                str2 = "regular";
            } else {
                str2 = "SFS";
            }
            objArr[2] = str2;
            x.d(str3, str4, objArr);
        }
        return j;
    }

    public static long mj(String str) {
        long j = 0;
        if (!(str == null || str.length() == 0)) {
            String str2;
            SFSContextRec me = me(str);
            if (me != null) {
                FileEntry mu = me.hOa.mu(str.substring(me.hNW.length()));
                if (mu != null) {
                    j = mu.timestamp * 1000;
                } else if (me.hNY) {
                    j = new File(str).lastModified();
                }
            } else {
                j = new File(str).lastModified();
            }
            hNP.readLock().unlock();
            String str3 = "MicroMsg.FileOp";
            String str4 = "getFileTime: %s [%d, %s]";
            Object[] objArr = new Object[3];
            objArr[0] = str;
            objArr[1] = Long.valueOf(j);
            if (me == null) {
                str2 = "regular";
            } else {
                str2 = "SFS";
            }
            objArr[2] = str2;
            x.d(str3, str4, objArr);
        }
        return j;
    }

    public static byte[] d(String str, int i, int i2) {
        IOException e;
        Throwable th;
        if (str == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i2 < 0 ? 2048 : i2);
        InputStream openRead;
        try {
            openRead = openRead(str);
            if (i > 0) {
                try {
                    openRead.skip((long) i);
                } catch (IOException e2) {
                    e = e2;
                    try {
                        x.w("MicroMsg.FileOp", "readFromFile failed: " + str + ", " + e.getMessage());
                        if (openRead != null) {
                            try {
                                openRead.close();
                            } catch (IOException e3) {
                            }
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        if (openRead != null) {
                            try {
                                openRead.close();
                            } catch (IOException e4) {
                            }
                        }
                        throw th;
                    }
                }
            }
            byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
            if (i2 < 0) {
                i2 = Integer.MAX_VALUE;
            }
            while (true) {
                int read = openRead.read(bArr, 0, Math.min(i2, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT));
                if (read != -1 && i2 > 0) {
                    byteArrayOutputStream.write(bArr, 0, read);
                    i2 -= read;
                } else if (openRead != null) {
                    try {
                        openRead.close();
                    } catch (IOException e5) {
                    }
                }
            }
            if (openRead != null) {
                openRead.close();
            }
            bArr = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (IOException e6) {
            }
            x.d("MicroMsg.FileOp", "readFromFile: %s [%d]", str, Integer.valueOf(bArr.length));
            return bArr;
        } catch (IOException e7) {
            e = e7;
            openRead = null;
        } catch (Throwable th3) {
            th = th3;
            openRead = null;
            if (openRead != null) {
                openRead.close();
            }
            throw th;
        }
    }

    public static String bT(String str) {
        IOException e;
        Throwable th;
        StringBuilder stringBuilder = new StringBuilder();
        InputStreamReader inputStreamReader;
        try {
            inputStreamReader = new InputStreamReader(openRead(str));
            try {
                char[] cArr = new char[WXMediaMessage.TITLE_LENGTH_LIMIT];
                while (true) {
                    int read = inputStreamReader.read(cArr);
                    if (read != -1) {
                        stringBuilder.append(cArr, 0, read);
                    } else {
                        try {
                            break;
                        } catch (IOException e2) {
                        }
                    }
                }
                inputStreamReader.close();
                return stringBuilder.toString();
            } catch (IOException e3) {
                e = e3;
                try {
                    x.e("MicroMsg.FileOp", "readFileAsString(\"%s\" failed: %s", str, e.getMessage());
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                    if (inputStreamReader != null) {
                        try {
                            inputStreamReader.close();
                        } catch (IOException e4) {
                        }
                    }
                    throw th;
                }
            }
        } catch (IOException e5) {
            e = e5;
            inputStreamReader = null;
            x.e("MicroMsg.FileOp", "readFileAsString(\"%s\" failed: %s", str, e.getMessage());
            throw e;
        } catch (Throwable th3) {
            th = th3;
            inputStreamReader = null;
            if (inputStreamReader != null) {
                inputStreamReader.close();
            }
            throw th;
        }
    }

    public static int j(String str, byte[] bArr) {
        return b(str, bArr, bArr.length);
    }

    public static int b(String str, byte[] bArr, int i) {
        if (bArr == null) {
            return -2;
        }
        if (bArr.length < i + 0) {
            return -3;
        }
        OutputStream outputStream = null;
        try {
            outputStream = mf(str);
            outputStream.write(bArr, 0, i);
            if (outputStream == null) {
                return 0;
            }
            try {
                outputStream.close();
                return 0;
            } catch (IOException e) {
                return 0;
            }
        } catch (IOException e2) {
            x.e("MicroMsg.FileOp", "writeFile '%s' Failed: %s", str, e2.getMessage());
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e3) {
                }
            }
            return -1;
        } catch (Throwable th) {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e4) {
                }
            }
        }
    }

    public static String mk(String str) {
        return new File(f.mq(str)).getParentFile().getAbsolutePath();
    }

    public static boolean ml(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        String mq = f.mq(str);
        if (!mc(mq)) {
            return true;
        }
        File file = new File(mq);
        if (file.exists() && file.isDirectory()) {
            return true;
        }
        return file.mkdirs();
    }

    public static long x(String str, String str2) {
        InputStream openRead;
        IOException e;
        InputStream inputStream;
        Throwable th;
        OutputStream outputStream = null;
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0) {
            return -1;
        }
        try {
            OutputStream mf;
            openRead = openRead(str);
            try {
                mf = mf(str2);
            } catch (IOException e2) {
                e = e2;
                inputStream = openRead;
                try {
                    x.e("MicroMsg.FileOp", "copyFile '%s' -> '%s' failed: %s", str, str2, e.getMessage());
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e3) {
                        }
                    }
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e4) {
                        }
                    }
                    return -1;
                } catch (Throwable th2) {
                    th = th2;
                    openRead = inputStream;
                    if (openRead != null) {
                        try {
                            openRead.close();
                        } catch (IOException e5) {
                        }
                    }
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e6) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                if (openRead != null) {
                    openRead.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
                throw th;
            }
            try {
                byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                long j = 0;
                while (true) {
                    int read = openRead.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    mf.write(bArr, 0, read);
                    j += (long) read;
                }
                x.d("MicroMsg.FileOp", "copyFile: %s -> %s", str, str2);
                if (openRead != null) {
                    try {
                        openRead.close();
                    } catch (IOException e7) {
                    }
                }
                if (mf == null) {
                    return j;
                }
                try {
                    mf.close();
                    return j;
                } catch (IOException e8) {
                    return j;
                }
            } catch (IOException e9) {
                e = e9;
                outputStream = mf;
                inputStream = openRead;
                x.e("MicroMsg.FileOp", "copyFile '%s' -> '%s' failed: %s", str, str2, e.getMessage());
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
                return -1;
            } catch (Throwable th4) {
                th = th4;
                outputStream = mf;
                if (openRead != null) {
                    openRead.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
                throw th;
            }
        } catch (IOException e10) {
            e = e10;
            inputStream = null;
        } catch (Throwable th5) {
            th = th5;
            openRead = null;
            if (openRead != null) {
                openRead.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
            throw th;
        }
    }

    public static boolean bO(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        boolean nativeExists;
        String str2;
        SFSContextRec me = me(str);
        if (me != null) {
            SFSContext sFSContext = me.hOa;
            String substring = str.substring(me.hNW.length());
            if (sFSContext.mNativePtr == 0) {
                throw new IllegalArgumentException("Reuse already released SFSContext.");
            }
            if (f.mp(substring)) {
                f.mr(substring);
                substring = f.mq(substring);
            }
            nativeExists = SFSContext.nativeExists(sFSContext.mNativePtr, substring);
            if (!nativeExists && me.hNY) {
                nativeExists = new File(str).exists();
            }
        } else {
            nativeExists = new File(str).exists();
        }
        hNP.readLock().unlock();
        String str3 = "MicroMsg.FileOp";
        String str4 = "fileExists: %s [%b, %s]";
        Object[] objArr = new Object[3];
        objArr[0] = str;
        objArr[1] = Boolean.valueOf(nativeExists);
        if (me == null) {
            str2 = "regular";
        } else {
            str2 = "SFS";
        }
        objArr[2] = str2;
        x.d(str3, str4, objArr);
        return nativeExists;
    }

    public static boolean deleteFile(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        boolean iI;
        String str2;
        SFSContextRec me = me(str);
        String mq;
        if (me != null) {
            iI = me.hOa.iI(str.substring(me.hNW.length()));
            if (!iI && me.hNY) {
                if (f.mp(str)) {
                    mq = f.mq(str);
                } else {
                    mq = str;
                }
                iI = new File(mq).delete();
            }
        } else {
            if (f.mp(str)) {
                mq = f.mq(str);
            } else {
                mq = str;
            }
            iI = new File(mq).delete();
        }
        hNP.readLock().unlock();
        String str3 = "MicroMsg.FileOp";
        String str4 = "deleteFile: %s [%b, %s]";
        Object[] objArr = new Object[3];
        objArr[0] = str;
        objArr[1] = Boolean.valueOf(iI);
        if (me == null) {
            str2 = "regular";
        } else {
            str2 = "SFS";
        }
        objArr[2] = str2;
        x.d(str3, str4, objArr);
        return iI;
    }

    public static boolean g(String str, String str2, String str3) {
        return at(str + str2, str + str3);
    }

    public static boolean at(String str, String str2) {
        if (str == null || str2 == null || str.length() == 0 || str2.length() == 0) {
            return false;
        }
        if (md(str) && md(str2)) {
            if (f.mp(str)) {
                str = f.mq(str);
            }
            if (f.mp(str2)) {
                str2 = f.mq(str2);
            }
            if (new File(str).renameTo(new File(str2))) {
                return true;
            }
        }
        if (x(str, str2) < 0) {
            return false;
        }
        deleteFile(str);
        return true;
    }

    public static List<FileEntry> F(String str, boolean z) {
        if (str == null || str.length() == 0) {
            return Collections.emptyList();
        }
        List<FileEntry> arrayList;
        SFSContextRec me = me(str);
        if (me != null) {
            str = str.substring(me.hNW.length());
            if (!str.endsWith("/")) {
                str = str + "/";
            }
            try {
                List<FileEntry> mt = me.hOa.mt(str);
                arrayList = new ArrayList();
                for (FileEntry fileEntry : mt) {
                    if (fileEntry.name.substring(str.length()).indexOf(47) == -1) {
                        arrayList.add(fileEntry);
                    }
                }
                for (FileEntry fileEntry2 : arrayList) {
                    fileEntry2.name = me.hNW + fileEntry2.name;
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.FileOp", e, "listFiles failed with SFS: " + str, new Object[0]);
                arrayList = new ArrayList();
            }
        } else {
            arrayList = new ArrayList();
        }
        if (me == null || me.hNX != null || me.hNY) {
            ArrayDeque arrayDeque = new ArrayDeque();
            arrayDeque.add(new File(str));
            do {
                File[] listFiles = ((File) arrayDeque.pop()).listFiles();
                if (listFiles != null) {
                    for (File file : listFiles) {
                        if (file.isFile()) {
                            FileEntry fileEntry3 = new FileEntry();
                            fileEntry3.name = file.getAbsolutePath();
                            if (z) {
                                fileEntry3.size = file.length();
                                fileEntry3.timestamp = file.lastModified();
                            }
                            arrayList.add(fileEntry3);
                        } else {
                            file.isDirectory();
                        }
                    }
                }
            } while (!arrayDeque.isEmpty());
            hNP.readLock().unlock();
            x.d("MicroMsg.FileOp", "listFiles: %s [%d]", str, Integer.valueOf(arrayList.size()));
            return arrayList;
        }
        hNP.readLock().unlock();
        x.d("MicroMsg.FileOp", "listFiles: %s [%d]", str, Integer.valueOf(arrayList.size()));
        return arrayList;
    }

    public static boolean G(String str, boolean z) {
        if (str == null || str.length() == 0) {
            return false;
        }
        boolean z2;
        SFSContextRec me = me(str);
        if (me != null) {
            try {
                if (str.equals(me.hNW)) {
                    SFSContext sFSContext = me.hOa;
                    if (sFSContext.mNativePtr == 0) {
                        throw new IllegalArgumentException("Reuse already released SFSContext.");
                    } else if (SFSContext.nativeClear(sFSContext.mNativePtr) != 0) {
                        throw new IOException(SFSContext.nativeErrorMessage());
                    }
                }
                for (FileEntry fileEntry : me.hOa.mt(str.substring(me.hNW.length()))) {
                    me.hOa.iI(fileEntry.name);
                }
                z2 = true;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.FileOp", e, "deleteDirIncludedFiles failed: " + str, new Object[0]);
                z2 = false;
            }
        } else {
            File file = new File(str);
            ArrayDeque arrayDeque = new ArrayDeque();
            arrayDeque.add(new a(file));
            do {
                a aVar = (a) arrayDeque.getLast();
                if (aVar.hNV == null) {
                    aVar.hNV = aVar.hNU.listFiles();
                }
                if (aVar.hNV != null) {
                    File[] fileArr = aVar.hNV;
                    for (int i = aVar.pos; i < fileArr.length; i++) {
                        File file2 = fileArr[i];
                        if (file2.isFile()) {
                            file2.delete();
                        } else if (file2.isDirectory()) {
                            aVar.pos = i;
                            arrayDeque.add(new a(file2));
                            break;
                        }
                    }
                    if (!z) {
                        aVar.hNU.delete();
                    }
                    arrayDeque.removeLast();
                } else if (!z) {
                    aVar.hNU.delete();
                }
            } while (!arrayDeque.isEmpty());
            z2 = true;
        }
        hNP.readLock().unlock();
        return z2;
    }

    public static boolean mm(String str) {
        boolean z = false;
        if (str == null || str.length() == 0) {
            return z;
        }
        if (!bO(str)) {
            try {
                try {
                    mf(str).close();
                } catch (IOException e) {
                }
            } catch (IOException e2) {
                x.e("MicroMsg.FileOp", "createNewFile '%s' failed: %s", str, e2.getMessage());
                return z;
            }
        }
        return true;
    }

    public static void mn(String str) {
        if (str != null && str.length() != 0 && mc(str)) {
            try {
                new File(str, ".nomedia").createNewFile();
            } catch (IOException e) {
                x.e("MicroMsg.FileOp", "markNoMedia '%s' failed: %s", str, e.getMessage());
            }
        }
    }

    public static String mo(String str) {
        if (!bO(str)) {
            return null;
        }
        return g.s((str + "-" + mi(str)).getBytes());
    }
}
