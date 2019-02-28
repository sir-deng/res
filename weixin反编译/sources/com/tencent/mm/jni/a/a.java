package com.tencent.mm.jni.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.util.SparseArray;
import com.tencent.mars.comm.WakerLock;
import com.tencent.mm.f.a.nl;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.opensdk.constants.ConstantsAPI.WXApp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.Externalizable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicInteger;

public final class a {
    private static SparseArray<b> gPQ = new SparseArray();
    private static final byte[] gPR = new byte[0];
    private static ag mHandler = new ag(Looper.getMainLooper());

    private static class a implements Runnable {
        private WakerLock gPS = null;

        public a(WakerLock wakerLock) {
            this.gPS = wakerLock;
        }

        public final void run() {
            synchronized (a.gPR) {
                b bVar = (b) a.gPQ.get(this.gPS.hashCode());
                if (bVar != null) {
                    String str = "MicroMsg.WakeLockManager";
                    String str2 = "wakerlock held too long: [%d,%d] @[%s] force to unlock it. state: %s";
                    Object[] objArr = new Object[4];
                    objArr[0] = Integer.valueOf(this.gPS.hashCode());
                    objArr[1] = Integer.valueOf(this.gPS.innerWakeLockHashCode());
                    objArr[2] = this.gPS.getCreatePosStackLine();
                    Collection<a> values = bVar.gPV.values();
                    StringBuilder stringBuilder = new StringBuilder();
                    Object obj = 1;
                    for (a aVar : values) {
                        if (obj != null) {
                            obj = null;
                        } else {
                            stringBuilder.append(',');
                        }
                        if (aVar.gPX != 0) {
                            stringBuilder.append('{').append(aVar.gPW).append(',').append(SystemClock.elapsedRealtime() - aVar.gPX).append('}');
                        }
                    }
                    if (stringBuilder.length() == 0) {
                        stringBuilder.append("<empty>");
                    }
                    objArr[3] = stringBuilder.toString();
                    x.w(str, str2, objArr);
                } else {
                    x.w("MicroMsg.WakeLockManager", "wakerlock held too long: [%d,%d] @[%s] force to unlock it. state: %s", Integer.valueOf(this.gPS.hashCode()), Integer.valueOf(this.gPS.innerWakeLockHashCode()), this.gPS.getCreatePosStackLine(), "#lost-trace-state#");
                }
                this.gPS.unLock();
            }
        }
    }

    private static class b {
        volatile boolean gPT = false;
        a gPU = null;
        Map<String, a> gPV = new HashMap();

        private static class a {
            public String gPW = null;
            public long gPX = 0;

            public a(String str, long j) {
                this.gPW = str;
                this.gPX = j;
            }
        }

        public b(WakerLock wakerLock) {
            this.gPU = new a(wakerLock);
        }
    }

    private static class c {
        private static long fgW = 0;
        private static int gPY = 0;
        private static long gPZ = 0;
        private static HashMap<String, a> gQa = null;
        private static final byte[] gQb = new byte[0];
        private static BroadcastReceiver gQc = null;

        private static class a implements Externalizable {
            public String gPW;
            public String gQd;
            public String gQe;
            public boolean gQf;
            public int gQg;
            public int gQh;
            public long gQi;
            public long gQj;
            public AtomicInteger gQk;

            private a() {
                this.gQd = "";
                this.gPW = "";
                this.gQe = "";
                this.gQf = false;
                this.gQg = 0;
                this.gQh = 0;
                this.gQi = 0;
                this.gQj = 0;
                this.gQk = new AtomicInteger(0);
            }

            /* synthetic */ a(byte b) {
                this();
            }

            public final void readExternal(ObjectInput objectInput) {
                synchronized (c.gQb) {
                    this.gQd = objectInput.readUTF();
                    this.gPW = objectInput.readUTF();
                    this.gQg = objectInput.readInt();
                    this.gQh = objectInput.readInt();
                    this.gQi = objectInput.readLong();
                    this.gQe = "";
                    this.gQf = false;
                    this.gQj = 0;
                    this.gQk = new AtomicInteger(0);
                }
            }

            public final void writeExternal(ObjectOutput objectOutput) {
                synchronized (c.gQb) {
                    objectOutput.writeUTF(this.gQd);
                    objectOutput.writeUTF(this.gPW);
                    objectOutput.writeInt(this.gQg);
                    objectOutput.writeInt(this.gQh);
                    objectOutput.writeLong(this.gQi);
                }
            }
        }

        public static void BY() {
            ObjectInputStream objectInputStream;
            IntentFilter intentFilter;
            Throwable th;
            ObjectInputStream objectInputStream2 = null;
            if (gPY == 0) {
                gPY = Process.myPid();
                gQc = new BroadcastReceiver() {
                    public final void onReceive(Context context, Intent intent) {
                        String action = intent.getAction();
                        if (!bi.oN(action)) {
                            int intExtra = intent.getIntExtra("pid", 0);
                            if (intExtra != 0) {
                                String stringExtra = intent.getStringExtra("processName");
                                if (!bi.oN(stringExtra) && stringExtra.equals(bi.r(ad.getContext(), intExtra))) {
                                    String stringExtra2 = intent.getStringExtra("traceMsg");
                                    long longExtra = intent.getLongExtra("tick", 0);
                                    if ("com.tencent.mm.ACTION.note_tracemsg_lock".equals(action)) {
                                        c.b(stringExtra, stringExtra2, longExtra);
                                    } else if ("com.tencent.mm.ACTION.note_tracemsg_unlock".equals(action)) {
                                        c.c(stringExtra, stringExtra2, longExtra);
                                    }
                                }
                            }
                        }
                    }
                };
                synchronized (gQb) {
                    try {
                        ObjectInputStream objectInputStream3 = new ObjectInputStream(new FileInputStream(new File(ad.getContext().getCacheDir(), "wakelock/wakelock_stats.bin")));
                        try {
                            fgW = objectInputStream3.readLong();
                            gQa = (HashMap) objectInputStream3.readObject();
                            try {
                                objectInputStream3.close();
                            } catch (Exception e) {
                            }
                        } catch (Exception e2) {
                            objectInputStream = objectInputStream3;
                            try {
                                x.e("MicroMsg.WakeLockStatsManager", "failed to load stats from storage, use default value for last stats info.");
                                fgW = SystemClock.elapsedRealtime();
                                gQa = new HashMap();
                                if (objectInputStream != null) {
                                    try {
                                        objectInputStream.close();
                                    } catch (Exception e3) {
                                    }
                                }
                                intentFilter = new IntentFilter();
                                intentFilter.addAction("com.tencent.mm.ACTION.note_tracemsg_lock");
                                intentFilter.addAction("com.tencent.mm.ACTION.note_tracemsg_unlock");
                                ad.getContext().registerReceiver(gQc, intentFilter, WXApp.WXAPP_BROADCAST_PERMISSION, null);
                                x.i("MicroMsg.WakeLockStatsManager", "WakeLockStatsManager is attached to process [%s]", ad.By());
                            } catch (Throwable th2) {
                                objectInputStream2 = objectInputStream;
                                th = th2;
                                if (objectInputStream2 != null) {
                                    try {
                                        objectInputStream2.close();
                                    } catch (Exception e4) {
                                    }
                                }
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            objectInputStream2 = objectInputStream3;
                            if (objectInputStream2 != null) {
                                objectInputStream2.close();
                            }
                            throw th;
                        }
                    } catch (Exception e5) {
                        objectInputStream = null;
                        x.e("MicroMsg.WakeLockStatsManager", "failed to load stats from storage, use default value for last stats info.");
                        fgW = SystemClock.elapsedRealtime();
                        gQa = new HashMap();
                        if (objectInputStream != null) {
                            objectInputStream.close();
                        }
                        intentFilter = new IntentFilter();
                        intentFilter.addAction("com.tencent.mm.ACTION.note_tracemsg_lock");
                        intentFilter.addAction("com.tencent.mm.ACTION.note_tracemsg_unlock");
                        ad.getContext().registerReceiver(gQc, intentFilter, WXApp.WXAPP_BROADCAST_PERMISSION, null);
                        x.i("MicroMsg.WakeLockStatsManager", "WakeLockStatsManager is attached to process [%s]", ad.By());
                    } catch (Throwable th4) {
                        th = th4;
                        if (objectInputStream2 != null) {
                            objectInputStream2.close();
                        }
                        throw th;
                    }
                }
                intentFilter = new IntentFilter();
                intentFilter.addAction("com.tencent.mm.ACTION.note_tracemsg_lock");
                intentFilter.addAction("com.tencent.mm.ACTION.note_tracemsg_unlock");
                ad.getContext().registerReceiver(gQc, intentFilter, WXApp.WXAPP_BROADCAST_PERMISSION, null);
                x.i("MicroMsg.WakeLockStatsManager", "WakeLockStatsManager is attached to process [%s]", ad.By());
            }
        }

        public static void detach() {
            if (gPY > 0) {
                ad.getContext().unregisterReceiver(gQc);
                Ca();
                gPY = 0;
                x.i("MicroMsg.WakeLockStatsManager", "WakeLockStatsManager is detached from process [%s]", ad.By());
            }
        }

        public static void fq(String str) {
            m(str, true);
        }

        public static void fr(String str) {
            m(str, false);
        }

        private static void m(String str, boolean z) {
            int myPid = Process.myPid();
            String By = ad.By();
            Intent intent;
            if (myPid == gPY) {
                if (z) {
                    b(By, str, SystemClock.elapsedRealtime());
                } else {
                    c(By, str, SystemClock.elapsedRealtime());
                }
            } else if (z) {
                intent = new Intent("com.tencent.mm.ACTION.note_tracemsg_lock");
                intent.putExtra("pid", myPid);
                intent.putExtra("processName", By);
                intent.putExtra("traceMsg", str);
                intent.putExtra("tick", SystemClock.elapsedRealtime());
                ad.getContext().sendBroadcast(intent, WXApp.WXAPP_BROADCAST_PERMISSION);
            } else {
                intent = new Intent("com.tencent.mm.ACTION.note_tracemsg_unlock");
                intent.putExtra("pid", myPid);
                intent.putExtra("processName", By);
                intent.putExtra("traceMsg", str);
                intent.putExtra("tick", SystemClock.elapsedRealtime());
                ad.getContext().sendBroadcast(intent, WXApp.WXAPP_BROADCAST_PERMISSION);
            }
        }

        private static void b(String str, String str2, long j) {
            String str3 = str + "_" + str2;
            synchronized (gQb) {
                a aVar = (a) gQa.get(str3);
                if (aVar == null) {
                    aVar = new a();
                    aVar.gQd = str;
                    aVar.gPW = str2;
                    aVar.gQi = 0;
                    aVar.gQg = 0;
                    aVar.gQh = 0;
                    gQa.put(str3, aVar);
                }
                if (aVar.gQk.getAndIncrement() == 0) {
                    aVar.gQj = j;
                    aVar.gQe = ao.getNetTypeString(ad.getContext());
                    aVar.gQf = com.tencent.mm.sdk.a.b.foreground;
                }
            }
        }

        private static void c(String str, String str2, long j) {
            long j2;
            String str3 = str + "_" + str2;
            long j3 = 0;
            synchronized (gQb) {
                a aVar = (a) gQa.get(str3);
                if (aVar != null && aVar.gQk.get() > 0) {
                    aVar.gQg++;
                    if (aVar.gQk.decrementAndGet() == 0) {
                        j3 = j - aVar.gQj;
                        aVar.gQi += j3;
                        aVar.gQh++;
                    }
                }
                j2 = j3;
            }
            BZ();
            j3 = SystemClock.elapsedRealtime();
            if (j2 >= 14000 || j3 - gPZ >= 3600000) {
                x.d("MicroMsg.WakeLockStatsManager", "saveStatsToStorage triggered.");
                Ca();
                gPZ = j3;
            }
        }

        private static void BZ() {
            synchronized (gQb) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (elapsedRealtime - fgW >= 21600000) {
                    if (!gQa.isEmpty()) {
                        StringBuilder stringBuilder = new StringBuilder();
                        for (Entry value : gQa.entrySet()) {
                            a aVar = (a) value.getValue();
                            if (aVar.gQh > 0) {
                                stringBuilder.setLength(0);
                                stringBuilder.append(aVar.gQd).append(',').append(aVar.gPW.replace(",", "##")).append(',').append(aVar.gQh).append(',').append(aVar.gQg).append(',').append(aVar.gQi).append(',').append(aVar.gQf ? 1 : 0).append(',').append(aVar.gQe);
                                String stringBuilder2 = stringBuilder.toString();
                                com.tencent.mm.sdk.b.b nlVar = new nl();
                                nlVar.fGn.fGo = stringBuilder2;
                                com.tencent.mm.sdk.b.a.xmy.m(nlVar);
                                x.d("MicroMsg.WakeLockStatsManager", "kvstat-str: %s", stringBuilder.toString());
                            }
                        }
                        gQa.clear();
                    }
                    fgW = elapsedRealtime;
                }
            }
        }

        private static void Ca() {
            Throwable e;
            synchronized (gQb) {
                ObjectOutputStream objectOutputStream = null;
                try {
                    File file = new File(ad.getContext().getCacheDir(), "wakelock");
                    if (FileOp.ml(file.getAbsolutePath())) {
                        ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(new FileOutputStream(new File(file, "wakelock_stats.bin")));
                        try {
                            objectOutputStream2.writeLong(fgW);
                            objectOutputStream2.writeObject(gQa);
                            try {
                                objectOutputStream2.close();
                            } catch (Exception e2) {
                            }
                        } catch (IOException e3) {
                            e = e3;
                            objectOutputStream = objectOutputStream2;
                            try {
                                x.printErrStackTrace("MicroMsg.WakeLockStatsManager", e, "failed to save stats to storage.", new Object[0]);
                                if (objectOutputStream != null) {
                                    try {
                                        objectOutputStream.close();
                                    } catch (Exception e4) {
                                    }
                                }
                            } catch (Throwable th) {
                                e = th;
                                if (objectOutputStream != null) {
                                    try {
                                        objectOutputStream.close();
                                    } catch (Exception e5) {
                                    }
                                }
                                throw e;
                            }
                        } catch (Throwable th2) {
                            e = th2;
                            objectOutputStream = objectOutputStream2;
                            if (objectOutputStream != null) {
                                objectOutputStream.close();
                            }
                            throw e;
                        }
                    } else {
                        throw new IOException("failed to call FileOp.mkdirs(" + file.getAbsolutePath() + ")");
                    }
                } catch (IOException e6) {
                    e = e6;
                    x.printErrStackTrace("MicroMsg.WakeLockStatsManager", e, "failed to save stats to storage.", new Object[0]);
                    if (objectOutputStream != null) {
                        objectOutputStream.close();
                    }
                }
            }
        }
    }

    public static void BU() {
        c.BY();
    }

    public static void BV() {
        c.detach();
    }

    public static void a(WakerLock wakerLock, String str) {
        synchronized (gPR) {
            b bVar = (b) gPQ.get(wakerLock.hashCode());
            if (bVar == null) {
                bVar = new b(wakerLock);
                gPQ.put(wakerLock.hashCode(), bVar);
            }
            if (!bVar.gPV.containsKey(str)) {
                bVar.gPV.put(str, new a(str, SystemClock.elapsedRealtime()));
            }
            c.fq(str);
            ag agVar = mHandler;
            if (!bVar.gPT) {
                bVar.gPT = true;
                agVar.postDelayed(bVar.gPU, 60000);
            }
        }
    }

    public static void c(WakerLock wakerLock) {
        synchronized (gPR) {
            b bVar = (b) gPQ.get(wakerLock.hashCode());
            if (bVar != null) {
                ag agVar = mHandler;
                if (bVar.gPT) {
                    bVar.gPT = false;
                    agVar.removeCallbacks(bVar.gPU);
                }
                for (a aVar : bVar.gPV.values()) {
                    c.fr(aVar.gPW);
                }
                bVar.gPV.clear();
            }
        }
    }
}
