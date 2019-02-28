package com.tencent.mm.ai;

import android.os.Process;
import com.tencent.mm.ai.c.d;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.bv;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public final class a {
    private static boolean ahf = false;
    private static final c hwb = new c();
    private static boolean hwc = true;
    private static long hwd = 0;
    private static long hwe = 0;
    private static Thread thread = null;

    public static class a implements Comparable<a> {
        public long endTime = 0;
        public long hwf = 0;
        public int hwg = 0;
        public boolean hwh = true;
        public boolean hwi = false;
        public int hwj = 0;
        public long hwk = 0;
        public long hwl = 0;
        public long hwm = 0;
        public int pid = 0;
        public long startTime = 0;
        public int type = 0;

        public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
            a aVar = (a) obj;
            return (this.hwf == 0 || aVar.hwf == 0) ? (int) (this.startTime - aVar.startTime) : (int) (this.hwf - aVar.hwf);
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            switch (this.type) {
                case 0:
                    stringBuilder.append(String.format("server time:%s,local start time:%s,local end time:%s,[mm] pid:%s,normal execute:%s", new Object[]{a.bd(this.hwf), a.bd(this.startTime), a.bd(this.endTime), Integer.valueOf(this.pid), Boolean.valueOf(this.hwh)}));
                    break;
                case 1:
                    stringBuilder.append(String.format("server time:%s,local start time:%s,local end time:%s,[push] pid:%s,network:%s,normal execute:%s", new Object[]{a.bd(this.hwf), a.bd(this.startTime), a.bd(this.endTime), Integer.valueOf(this.pid), Integer.valueOf(this.hwg), Boolean.valueOf(this.hwh)}));
                    break;
                case 2:
                    stringBuilder.append(String.format("server time:%s,local start time:%s,local end time:%s,send broadcast type(push):%s", new Object[]{a.bd(this.hwf), a.bd(this.startTime), a.bd(this.endTime), Integer.valueOf(this.hwj)}));
                    break;
                case 3:
                    stringBuilder.append(String.format("server time:%s,local start time:%s,local end time:%s,receive broadcast type(mm):%s", new Object[]{a.bd(this.hwf), a.bd(this.startTime), a.bd(this.endTime), Integer.valueOf(this.hwj)}));
                    break;
                case 4:
                    stringBuilder.append(String.format("server time:%s,local start time:%s,local end time:%s,delayed msg pid:%s, msg server time:%s,interval time:%s, msg server id:%s", new Object[]{a.bd(this.hwf), a.bd(this.startTime), a.bd(this.endTime), Integer.valueOf(this.pid), a.bd(this.hwk), Long.valueOf(this.hwl), Long.valueOf(this.hwm)}));
                    break;
            }
            stringBuilder.append("\n");
            return stringBuilder.toString();
        }
    }

    public static final void bM(boolean z) {
        boolean z2 = !ad.getContext().getSharedPreferences("system_config_prefs", 4).getBoolean("msg_delay_close_detect", false);
        hwc = z2;
        if (z2) {
            ahf = z;
            if (z) {
                x.i("MicroMsg.ActiveDetector", "[oneliang]active, time%s, pid:%s", Long.valueOf(System.currentTimeMillis()), Integer.valueOf(Process.myPid()));
                if (thread != null) {
                    thread.interrupt();
                }
                thread = null;
                hwb.clear();
                hwd = bv.Ik();
                return;
            }
            x.i("MicroMsg.ActiveDetector", "[oneliang]unactive, time%s, pid:%s", Long.valueOf(System.currentTimeMillis()), Integer.valueOf(Process.myPid()));
            if (thread == null) {
                Thread b = e.b(hwb, "ProcessDetector_" + Process.myPid());
                thread = b;
                b.start();
                hwb.hwv = true;
            }
            hwe = bv.Ik();
        }
    }

    public static boolean bc(long j) {
        if (hwd <= 0 || hwe <= 0 || j <= 0) {
            return false;
        }
        if (hwd >= hwe) {
            if (j < hwd) {
                return false;
            }
            return true;
        } else if (j >= hwe) {
            return false;
        } else {
            return true;
        }
    }

    public static void hA(int i) {
        if (hwc && !ahf) {
            c cVar = hwb;
            cVar.hwp.hwx.add(new a(bv.Ik(), System.currentTimeMillis(), i));
        }
    }

    public static void hB(int i) {
        if (hwc && !ahf) {
            c cVar = hwb;
            cVar.hwp.hwy.add(new a(bv.Ik(), System.currentTimeMillis(), i));
        }
    }

    public static void a(long j, long j2, long j3, long j4, long j5) {
        if (hwc) {
            c cVar = hwb;
            x.i("MicroMsg.ActiveDetector.ProcessDetector", "[oneliang]delayed msg[%s]", new c(Process.myPid(), j, j2, j3, j4, j5).toString());
            cVar.hwp.hwz.add(r0);
        }
    }

    public static void hC(int i) {
        hwb.hwn = i;
    }

    public static List<a> Nl() {
        if (!ad.cgj()) {
            return null;
        }
        b bVar;
        b bVar2;
        a a;
        String str = hwb.hwt;
        String str2 = str + "/mm";
        String str3 = str + "/push";
        try {
            bVar = (b) b.h(new FileInputStream(str2));
        } catch (Exception e) {
            x.e("MicroMsg.ActiveDetector", "%s,read exception:" + e.getMessage(), str2);
            bVar = null;
        }
        try {
            bVar2 = (b) b.h(new FileInputStream(str3));
        } catch (Exception e2) {
            x.e("MicroMsg.ActiveDetector", "%s,read exception:" + e2.getMessage(), str3);
            bVar2 = null;
        }
        List<a> arrayList = new ArrayList();
        if (bVar != null) {
            for (d a2 : bVar.hww) {
                a = a(a2, 0);
                if (a != null) {
                    arrayList.add(a);
                }
            }
            for (a a3 : bVar.hwy) {
                a = a(a3, 3);
                if (a != null) {
                    arrayList.add(a);
                }
            }
            for (c cVar : bVar.hwz) {
                Object obj;
                if (cVar == null) {
                    obj = null;
                } else {
                    a aVar = new a();
                    aVar.pid = cVar.pid;
                    aVar.hwf = cVar.hwf;
                    aVar.startTime = cVar.hwA;
                    aVar.endTime = cVar.hwA;
                    aVar.type = 4;
                    aVar.hwk = cVar.hwk;
                    aVar.hwl = cVar.hwl;
                    aVar.hwm = cVar.hwm;
                    a = aVar;
                }
                if (obj != null) {
                    arrayList.add(obj);
                }
            }
        }
        if (bVar2 != null) {
            for (d a22 : bVar2.hww) {
                a = a(a22, 1);
                if (a != null) {
                    arrayList.add(a);
                }
            }
            for (a a32 : bVar2.hwx) {
                a = a(a32, 2);
                if (a != null) {
                    arrayList.add(a);
                }
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    static String bd(long j) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date(j));
    }

    private static a a(d dVar, int i) {
        if (dVar == null) {
            return null;
        }
        a aVar = new a();
        aVar.hwf = dVar.hwB;
        aVar.startTime = dVar.startTime;
        aVar.endTime = dVar.endTime;
        aVar.type = i;
        aVar.pid = dVar.pid;
        aVar.hwh = dVar.hwh;
        if (i != 1) {
            return aVar;
        }
        aVar.hwg = dVar.hwg;
        aVar.hwi = dVar.hwi;
        return aVar;
    }

    private static a a(a aVar, int i) {
        if (aVar == null) {
            return null;
        }
        a aVar2 = new a();
        aVar2.hwf = aVar.hwf;
        aVar2.startTime = aVar.time;
        aVar2.endTime = aVar.time;
        aVar2.type = i;
        aVar2.hwj = aVar.type;
        return aVar2;
    }
}
