package com.tencent.mm.plugin.appbrand.report;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Pair;
import com.tencent.mm.ad.k;
import com.tencent.mm.ad.u;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.protocal.c.bdl;
import com.tencent.mm.protocal.c.ccl;
import com.tencent.mm.protocal.c.ccm;
import com.tencent.mm.protocal.c.ccq;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;

public final class AppBrandIDKeyBatchReport {
    private static volatile IDKeyBatchReportTask jMA;

    private static final class a {
        private static final byte[] jMB = new byte[0];

        static /* synthetic */ void b(ccq ccq) {
            synchronized (jMB) {
                AppBrandIDKeyBatchReport.akn().jMG = ccq;
                AppBrandIDKeyBatchReport.akn().jMC = 3;
                AppBrandMainProcessService.a(AppBrandIDKeyBatchReport.akn());
            }
        }
    }

    private static final class IDKeyBatchReportTask extends MainProcessTask {
        public static final Creator<IDKeyBatchReportTask> CREATOR = new Creator<IDKeyBatchReportTask>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new IDKeyBatchReportTask(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new IDKeyBatchReportTask[i];
            }
        };
        public int jMC;
        int jMD;
        public String jME;
        public int jMF;
        ccq jMG;

        IDKeyBatchReportTask() {
        }

        IDKeyBatchReportTask(Parcel parcel) {
            f(parcel);
        }

        public final void YA() {
            if (1 == this.jMC) {
                if (!bi.oN(this.jME)) {
                    Pair v = ((com.tencent.mm.plugin.appbrand.appcache.b.d.b) e.u(com.tencent.mm.plugin.appbrand.appcache.b.d.b.class)).v(this.jME, 5, this.jMF);
                    if (((Boolean) v.first).booleanValue()) {
                        x.i("MicroMsg.AppBrandIDKeyBatchReport", "report blocked by appid(%s) scene(%d) ", this.jME, Integer.valueOf(this.jMF));
                        int i = com.tencent.mm.plugin.appbrand.appcache.b.c.a.iJQ;
                        com.tencent.mm.plugin.appbrand.appcache.b.c.a.o((long) ((Integer) v.second).intValue(), 167);
                        return;
                    }
                }
                b.hf(0);
                b.uk();
            } else if (2 == this.jMC) {
                b.akq();
            } else if (3 == this.jMC) {
                b.c(this.jMG);
            }
        }

        public final void f(Parcel parcel) {
            this.jMC = parcel.readInt();
            this.jMD = parcel.readInt();
            this.jME = parcel.readString();
            this.jMF = parcel.readInt();
            if (3 == this.jMC) {
                try {
                    this.jMG = new ccq();
                    this.jMG.aH(parcel.createByteArray());
                } catch (Exception e) {
                    x.e("MicroMsg.AppBrandIDKeyBatchReport", "parse WxaAppRecord from parcel, e = %s", e);
                    this.jMG = null;
                }
            }
        }

        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.jMC);
            parcel.writeInt(this.jMD);
            parcel.writeString(this.jME);
            parcel.writeInt(this.jMF);
            if (3 == this.jMC) {
                try {
                    parcel.writeByteArray(this.jMG.toByteArray());
                } catch (Exception e) {
                    x.e("MicroMsg.AppBrandIDKeyBatchReport", "write WxaAppRecord to parcel, e = %s", e);
                }
            }
        }
    }

    private static final class b {
        private static final ReentrantReadWriteLock jMH = new ReentrantReadWriteLock();
        private static volatile al jMI = null;
        private static volatile int jMJ;
        private static volatile al jlj = null;

        static /* synthetic */ void c(final ccq ccq) {
            if (ccq != null) {
                c.Dt().F(new Runnable() {
                    public final void run() {
                        b.d(ccq);
                    }
                });
            }
        }

        static /* synthetic */ void d(ccq ccq) {
            jMH.writeLock().lock();
            try {
                byte[] toByteArray = ccq.toByteArray();
                File file = new File(AppBrandIDKeyBatchReport.ako());
                if (!file.exists()) {
                    file.mkdir();
                }
                file = new File((AppBrandIDKeyBatchReport.ako() + "WxaAppRecord"));
                if (!file.exists()) {
                    file.createNewFile();
                }
                int length = toByteArray.length;
                OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                new DataOutputStream(byteArrayOutputStream).writeInt(length);
                com.tencent.mm.a.e.d((AppBrandIDKeyBatchReport.ako() + "WxaAppRecord"), byteArrayOutputStream.toByteArray());
                com.tencent.mm.a.e.d((AppBrandIDKeyBatchReport.ako() + "WxaAppRecord"), toByteArray);
            } catch (Throwable e) {
                x.e("MicroMsg.AppBrandIDKeyBatchReport", "appendToFile exception:%s", e.getMessage());
                x.printErrStackTrace("MicroMsg.AppBrandIDKeyBatchReport", e, "", new Object[0]);
            } finally {
                jMH.writeLock().unlock();
            }
        }

        static /* synthetic */ void hf(int i) {
            int i2 = 60000;
            if (i > 0) {
                i2 = 60000 * i;
            }
            akq();
            al alVar = new al(new com.tencent.mm.sdk.platformtools.al.a() {
                public final boolean uG() {
                    x.d("MicroMsg.AppBrandIDKeyBatchReport", "startReport run in TimerTask!");
                    b.uk();
                    return true;
                }
            }, true);
            jlj = alVar;
            long j = (long) i2;
            alVar.K(j, j);
        }

        static /* synthetic */ void uk() {
            boolean z;
            final LinkedList akr = akr();
            if (bi.cC(akr)) {
                z = false;
            } else {
                com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
                aVar.hnT = new ccl();
                aVar.hnU = new ccm();
                aVar.uri = "/cgi-bin/mmbiz-bin/wxausrevent/wxaappidkeybatchreport";
                aVar.hnS = HardCoderJNI.FUNC_RESET_SCREEN_RESOLUTION;
                aVar.hnV = 0;
                aVar.hnW = 0;
                com.tencent.mm.ad.b Kf = aVar.Kf();
                bdl bdl = new bdl();
                bdl.kzl = Build.MANUFACTURER;
                bdl.wQa = 2;
                bdl.vUW = d.vHf;
                bdl.vUX = d.vHe;
                bdl.qDJ = ad.getResources().getDisplayMetrics().widthPixels;
                bdl.wQb = ad.getResources().getDisplayMetrics().heightPixels;
                bdl.vUY = d.vHh;
                bdl.vUZ = d.vHi;
                bdl.wQc = ad.getResources().getConfiguration().locale.getLanguage();
                ((ccl) Kf.hnQ.hnY).xic = bdl;
                ((ccl) Kf.hnQ.hnY).xib = akr;
                u.a(Kf, new com.tencent.mm.ad.u.a() {
                    public final int a(int i, int i2, String str, com.tencent.mm.ad.b bVar, k kVar) {
                        if (i == 0 && i2 == 0) {
                            b.jMJ = ((ccm) bVar.hnR.hnY).xid;
                            b.hf(b.jMJ);
                        } else {
                            Iterator it = akr.iterator();
                            while (it.hasNext()) {
                                b.d((ccq) it.next());
                            }
                        }
                        return 0;
                    }
                }, true);
                z = true;
            }
            if (z) {
                int i = jMJ;
                i = i <= 0 ? 300000 : (i + 5) * 60000;
                if (jMI != null) {
                    jMI.TN();
                    jMI = null;
                }
                al alVar = new al(new com.tencent.mm.sdk.platformtools.al.a() {
                    public final boolean uG() {
                        b.akq();
                        x.d("MicroMsg.AppBrandIDKeyBatchReport", "on timer expired in monitor timer!");
                        return true;
                    }
                }, false);
                jMI = alVar;
                long j = (long) i;
                alVar.K(j, j);
            }
        }

        private static void akq() {
            if (jlj != null) {
                jlj.TN();
                jlj = null;
            }
        }

        private static LinkedList<ccq> akr() {
            ReadLock readLock = null;
            int i = 0;
            jMH.readLock().lock();
            try {
                File file = new File((AppBrandIDKeyBatchReport.ako() + "WxaAppRecord"));
                if (file.exists()) {
                    LinkedList<ccq> linkedList = new LinkedList();
                    long length = file.length();
                    while (true) {
                        int i2 = i;
                        byte[] d = com.tencent.mm.a.e.d((AppBrandIDKeyBatchReport.ako() + "WxaAppRecord"), i2, 4);
                        if (d != null) {
                            int readInt = new DataInputStream(new ByteArrayInputStream(d)).readInt();
                            d = com.tencent.mm.a.e.d((AppBrandIDKeyBatchReport.ako() + "WxaAppRecord"), i2 + 4, readInt);
                            if (bi.by(d)) {
                                break;
                            }
                            linkedList.add((ccq) new ccq().aH(d));
                            i = (readInt + 4) + i2;
                            if (((long) i) >= length) {
                                break;
                            }
                        } else {
                            x.e("MicroMsg.AppBrandIDKeyBatchReport", "preData is null!");
                            jMH.readLock().unlock();
                            aks();
                            return null;
                        }
                    }
                    jMH.readLock().unlock();
                    aks();
                    return linkedList;
                }
                x.d("MicroMsg.AppBrandIDKeyBatchReport", "reportFile not exist!");
                return readLock;
            } catch (Throwable e) {
                x.e("MicroMsg.AppBrandIDKeyBatchReport", "read file error %s", e.getMessage());
                x.printErrStackTrace("MicroMsg.AppBrandIDKeyBatchReport", e, "readReportData()", new Object[0]);
                return readLock;
            } finally {
                readLock = jMH.readLock();
                readLock.unlock();
                aks();
            }
        }

        private static void aks() {
            jMH.writeLock().lock();
            try {
                com.tencent.mm.loader.stub.b.deleteFile((AppBrandIDKeyBatchReport.ako() + "WxaAppRecord"));
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.AppBrandIDKeyBatchReport", e, "removeFile()", new Object[0]);
            }
            jMH.writeLock().unlock();
        }
    }

    public static IDKeyBatchReportTask akn() {
        if (jMA == null) {
            jMA = new IDKeyBatchReportTask();
        }
        return jMA;
    }

    static String ako() {
        if (g.Do().CF()) {
            String str = g.Dq().cachePath;
            if (!str.endsWith("/")) {
                str = str + "/";
            }
            str = str + "appbrand/report/";
            i.QZ(str);
            return str;
        }
        throw new com.tencent.mm.y.b();
    }

    public static void a(ccq ccq) {
        if (ad.cgj()) {
            b.c(ccq);
        } else {
            a.b(ccq);
        }
    }
}
