package com.tencent.mm.ap;

import android.graphics.Bitmap;
import android.os.HandlerThread;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.y.q;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class n {
    private static n hDJ;
    ConcurrentHashMap<Long, d> hDH = new ConcurrentHashMap();
    public c hDI = new c();
    public ConcurrentHashMap<Long, e> hDK = new ConcurrentHashMap();
    private ArrayList<Long> hDL = new ArrayList();
    ArrayList<e> hDM = new ArrayList();

    public static class a {
        static ag fcV;
        private ReentrantLock fcT = new ReentrantLock();
        private Condition fcU = this.fcT.newCondition();
        int hBE;
        a hDN;

        public static class a {
            String hBL;
            PString hDQ;
            PString hDR;
            PString hDS;
            PString hDT;
        }

        public static a a(final e eVar) {
            synchronized (a.class) {
                if (fcV == null) {
                    HandlerThread handlerThread = new HandlerThread("big file gen Worker");
                    handlerThread.start();
                    fcV = new ag(handlerThread.getLooper());
                }
            }
            a aVar = new a();
            eVar.hEh = aVar;
            fcV.post(new Runnable() {
                public final void run() {
                    Long valueOf = Long.valueOf(System.currentTimeMillis());
                    a aVar = new a();
                    aVar.hDQ = new PString();
                    aVar.hDR = new PString();
                    aVar.hDS = new PString();
                    aVar.hDT = new PString();
                    aVar.hBL = o.PC().a(eVar.hDY, FileOp.mo(eVar.hDY), eVar.hBE, true, aVar.hDQ, aVar.hDR, aVar.hDS, aVar.hDT, eVar.hEa, eVar.hEf);
                    a.this.fcT.lock();
                    try {
                        a.this.hDN = aVar;
                        a.this.fcU.signal();
                        x.i("MicroMsg.SendImgSpeeder", "notify big file gen prepared %s last %d", eVar.hDY, Long.valueOf(System.currentTimeMillis() - valueOf.longValue()));
                    } finally {
                        a.this.fcT.unlock();
                    }
                }
            });
            aVar.hBE = eVar.hBE;
            return aVar;
        }

        public final a Pv() {
            this.fcT.lock();
            while (this.hDN == null) {
                try {
                    x.i("MicroMsg.SendImgSpeeder", "getResult await");
                    this.fcU.await();
                } catch (Exception e) {
                } finally {
                    this.fcT.unlock();
                }
            }
            return this.hDN;
        }
    }

    public static class c {
        public LinkedList<b> hDW = new LinkedList();
        public LinkedList<b> hDX = new LinkedList();

        public final synchronized void Pw() {
            int i = 0;
            synchronized (this) {
                int size = this.hDW.size();
                if (size <= 0) {
                    int i2 = 5 - size;
                    for (size = 0; size < i2; size++) {
                        this.hDW.add(lu(null));
                    }
                    x.i("MicroMsg.SendImgSpeeder", "add big File pool added size %d , all size %d", Integer.valueOf(i2), Integer.valueOf(this.hDW.size()));
                    Px();
                }
                size = this.hDX.size();
                if (size <= 0) {
                    size = 5 - size;
                    while (i < size) {
                        this.hDX.add(lv(null));
                        i++;
                    }
                    Py();
                    x.i("MicroMsg.SendImgSpeeder", "add big thumb pool added size %d , all size %d", Integer.valueOf(size), Integer.valueOf(this.hDX.size()));
                }
            }
        }

        public static b lu(String str) {
            b bVar = new b();
            if (bi.oN(str)) {
                bVar.hDV = g.Pn();
            } else {
                bVar.hDV = str;
            }
            String a = o.PC().a(bVar.hDV, "", ".jpg", false);
            if (!lw(a)) {
                return null;
            }
            bVar.hDU = new com.tencent.mm.a.b(a);
            return bVar;
        }

        public static b lv(String str) {
            b bVar = new b();
            if (bi.oN(str)) {
                bVar.hDV = g.Pn();
            } else {
                bVar.hDV = str;
            }
            String a = o.PC().a("THUMBNAIL_DIRPATH://th_" + bVar.hDV, "th_", "", false);
            if (!lw(a)) {
                return null;
            }
            bVar.hDU = new com.tencent.mm.a.b(a);
            return bVar;
        }

        private static boolean lw(String str) {
            if (FileOp.mi(str) <= 0) {
                return true;
            }
            x.e("MicroMsg.SendImgSpeeder", "file has exist %s", str);
            return false;
        }

        public final synchronized b ia(int i) {
            b bVar = null;
            synchronized (this) {
                if (i == 1) {
                    if (this.hDW.size() > 0) {
                        bVar = (b) this.hDW.remove();
                        Px();
                    } else {
                        bVar = lu(null);
                    }
                } else if (i == 2) {
                    if (this.hDX.size() > 0) {
                        bVar = (b) this.hDX.remove();
                        Py();
                    } else {
                        bVar = lv(null);
                    }
                }
                Pw();
            }
            return bVar;
        }

        private synchronized void Px() {
            int i = 0;
            synchronized (this) {
                StringBuilder stringBuilder = new StringBuilder();
                while (true) {
                    int i2 = i;
                    if (i2 < this.hDW.size()) {
                        stringBuilder.append(((b) this.hDW.get(i2)).hDV);
                        if (i2 != this.hDW.size() - 1) {
                            stringBuilder.append("-");
                        }
                        i = i2 + 1;
                    } else {
                        x.d("MicroMsg.SendImgSpeeder", "sync big des to file %s ", stringBuilder.toString());
                        g.Dq().Db().set(348176, stringBuilder.toString());
                    }
                }
            }
        }

        private synchronized void Py() {
            int i = 0;
            synchronized (this) {
                StringBuilder stringBuilder = new StringBuilder();
                while (true) {
                    int i2 = i;
                    if (i2 < this.hDX.size()) {
                        stringBuilder.append(((b) this.hDX.get(i2)).hDV);
                        if (i2 != this.hDX.size() - 1) {
                            stringBuilder.append("-");
                        }
                        i = i2 + 1;
                    } else {
                        x.d("MicroMsg.SendImgSpeeder", "sync thumb des to file %s ", stringBuilder.toString());
                        g.Dq().Db().set(348177, stringBuilder.toString());
                    }
                }
            }
        }
    }

    public static class d {
        public long fAH;
        public long oJ;
    }

    public static class e {
        int cPf;
        long frh;
        int fzM;
        int hBE;
        public String hDY;
        String hDZ;
        String hEa;
        long hEb;
        PString hEc;
        PInt hEd;
        PInt hEe;
        com.tencent.mm.a.b hEf;
        com.tencent.mm.a.b hEg;
        a hEh;
        public String toUserName;
    }

    private static class b {
        com.tencent.mm.a.b hDU;
        String hDV;

        private b() {
        }

        /* synthetic */ b(byte b) {
            this();
        }
    }

    public static n Pt() {
        if (hDJ == null) {
            synchronized (n.class) {
                if (hDJ == null) {
                    hDJ = new n();
                }
            }
        }
        return hDJ;
    }

    public final ArrayList<Integer> ls(String str) {
        Collection<e> values = this.hDK.values();
        for (e eVar : values) {
            PString pString = new PString();
            PInt pInt = new PInt();
            PInt pInt2 = new PInt();
            eVar.hEb = o.PC().a(eVar.hDY, eVar.hBE, eVar.cPf, eVar.fzM, pString, pInt, pInt2, eVar.hDZ, eVar.hEa, eVar.frh, eVar.hEf, eVar.hEg, eVar.hEh);
            au dI = ((h) g.h(h.class)).aZO().dI(eVar.frh);
            if (bi.oN(dI.field_imgPath)) {
                dI.dV(pString.value);
                dI.fd(pInt.value);
                dI.fe(pInt2.value);
                ((h) g.h(h.class)).aZO().a(eVar.frh, dI);
            }
        }
        if (!bi.oN(str)) {
            for (e eVar2 : values) {
                if (!str.equals(eVar2.toUserName)) {
                    this.hDK.remove(Long.valueOf(eVar2.frh));
                    this.hDL.remove(Long.valueOf(eVar2.frh));
                    x.e("MicroMsg.SendImgSpeeder", "fatal!! Send user mis-match, want:%s, fact:%s", str, eVar2.toUserName);
                }
            }
        }
        ArrayList<Integer> arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.hDL.size()) {
                arrayList.add(Integer.valueOf((int) ((e) this.hDK.get(this.hDL.get(i2))).hEb));
                i = i2 + 1;
            } else {
                this.hDK.clear();
                this.hDL.clear();
                x.i("MicroMsg.SendImgSpeeder", "syncImgData, id size %d", Integer.valueOf(arrayList.size()));
                return arrayList;
            }
        }
    }

    public final boolean bl(long j) {
        return this.hDH.containsKey(Long.valueOf(j));
    }

    public final d bm(long j) {
        return (d) this.hDH.get(Long.valueOf(j));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.util.ArrayList<java.lang.String> r15, boolean r16, int r17, int r18, java.lang.String r19, int r20) {
        /*
        r14 = this;
        r2 = "MicroMsg.SendImgSpeeder";
        r3 = "summersafecdn sendThumbImg fileSize:%d, compressImg[%b], source[%d], user:%s";
        r4 = 4;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = r15.size();
        r6 = java.lang.Integer.valueOf(r6);
        r4[r5] = r6;
        r5 = 1;
        r6 = java.lang.Boolean.valueOf(r16);
        r4[r5] = r6;
        r5 = 2;
        r6 = java.lang.Integer.valueOf(r17);
        r4[r5] = r6;
        r5 = 3;
        r4[r5] = r19;
        com.tencent.mm.sdk.platformtools.x.i(r2, r3, r4);
        r2 = r14.hDM;
        r3 = r2.iterator();
    L_0x002e:
        r2 = r3.hasNext();
        if (r2 == 0) goto L_0x0075;
    L_0x0034:
        r2 = r3.next();
        r2 = (com.tencent.mm.ap.n.e) r2;
        r4 = r2.hDY;
        r4 = r15.contains(r4);
        if (r4 == 0) goto L_0x0064;
    L_0x0042:
        r4 = r2.toUserName;
        r4 = com.tencent.mm.sdk.platformtools.bi.oN(r4);
        if (r4 != 0) goto L_0x0054;
    L_0x004a:
        r4 = r2.toUserName;
        r0 = r19;
        r4 = r4.equalsIgnoreCase(r0);
        if (r4 == 0) goto L_0x0064;
    L_0x0054:
        r4 = com.tencent.mm.sdk.platformtools.bi.oN(r19);
        if (r4 != 0) goto L_0x0068;
    L_0x005a:
        r4 = r2.toUserName;
        r0 = r19;
        r4 = r0.equalsIgnoreCase(r4);
        if (r4 != 0) goto L_0x0068;
    L_0x0064:
        r3.remove();
        goto L_0x002e;
    L_0x0068:
        r4 = r2.hDY;
        r0 = r19;
        r1 = r16;
        r4 = b(r4, r0, r1);
        r2.hBE = r4;
        goto L_0x002e;
    L_0x0075:
        r3 = new java.util.ArrayList;
        r3.<init>();
        r2 = r15.size();
        r4 = 9;
        if (r2 != r4) goto L_0x00b2;
    L_0x0082:
        r2 = 18;
        com.tencent.mm.plugin.report.service.f.vR(r2);
    L_0x0087:
        r4 = r15.iterator();
    L_0x008b:
        r2 = r4.hasNext();
        if (r2 == 0) goto L_0x0117;
    L_0x0091:
        r2 = r4.next();
        r2 = (java.lang.String) r2;
        if (r2 == 0) goto L_0x00a8;
    L_0x0099:
        r5 = "";
        r5 = r2.equals(r5);
        if (r5 != 0) goto L_0x00a8;
    L_0x00a2:
        r5 = com.tencent.mm.a.e.bO(r2);
        if (r5 != 0) goto L_0x00eb;
    L_0x00a8:
        r2 = "MicroMsg.SendImgSpeeder";
        r5 = " doSendImage : filePath is null or empty";
        com.tencent.mm.sdk.platformtools.x.d(r2, r5);
        goto L_0x008b;
    L_0x00b2:
        r2 = r15.size();
        r4 = 1;
        if (r2 != r4) goto L_0x00e5;
    L_0x00b9:
        r2 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r2 = com.tencent.mm.sdk.platformtools.ao.isWifi(r2);
        r4 = 25;
        com.tencent.mm.plugin.report.service.f.vR(r4);
        if (r2 == 0) goto L_0x0087;
    L_0x00c8:
        r2 = 0;
        r2 = r15.get(r2);
        r2 = (java.lang.String) r2;
        r0 = r19;
        r1 = r16;
        r2 = com.tencent.mm.y.q.a(r2, r0, r1);
        if (r2 == 0) goto L_0x00df;
    L_0x00d9:
        r2 = 23;
        com.tencent.mm.plugin.report.service.f.vR(r2);
        goto L_0x0087;
    L_0x00df:
        r2 = 21;
        com.tencent.mm.plugin.report.service.f.vR(r2);
        goto L_0x0087;
    L_0x00e5:
        r2 = 24;
        com.tencent.mm.plugin.report.service.f.vR(r2);
        goto L_0x0087;
    L_0x00eb:
        r5 = com.tencent.mm.sdk.platformtools.p.Vw(r2);
        if (r5 == 0) goto L_0x010c;
    L_0x00f1:
        r5 = "MicroMsg.SendImgSpeeder";
        r6 = "[cpan] is gif coutinue. did not add filePath:%s filesize:%d";
        r7 = 2;
        r7 = new java.lang.Object[r7];
        r8 = 0;
        r7[r8] = r2;
        r8 = 1;
        r2 = com.tencent.mm.a.e.bN(r2);
        r2 = java.lang.Integer.valueOf(r2);
        r7[r8] = r2;
        com.tencent.mm.sdk.platformtools.x.i(r5, r6, r7);
        goto L_0x008b;
    L_0x010c:
        r5 = r14.lt(r2);
        if (r5 != 0) goto L_0x008b;
    L_0x0112:
        r3.add(r2);
        goto L_0x008b;
    L_0x0117:
        r9 = r3.iterator();
    L_0x011b:
        r2 = r9.hasNext();
        if (r2 == 0) goto L_0x0136;
    L_0x0121:
        r5 = r9.next();
        r5 = (java.lang.String) r5;
        r2 = r14;
        r3 = r17;
        r4 = r18;
        r6 = r19;
        r7 = r16;
        r8 = r20;
        r2.a(r3, r4, r5, r6, r7, r8);
        goto L_0x011b;
    L_0x0136:
        r6 = new java.util.ArrayList;
        r6.<init>();
        r2 = com.tencent.mm.kernel.g.Dq();
        r2 = r2.gRU;
        r3 = java.lang.Thread.currentThread();
        r4 = r3.getId();
        r8 = r2.dA(r4);
        r2 = com.tencent.mm.plugin.messenger.foundation.a.h.class;
        r2 = com.tencent.mm.kernel.g.h(r2);
        r2 = (com.tencent.mm.plugin.messenger.foundation.a.h) r2;
        r2 = r2.aZO();
        r3 = "SendImgSpeeder";
        r2.EZ(r3);
        r3 = 1;
        r2 = 0;
        r5 = r2;
    L_0x0162:
        r2 = r14.hDM;
        r2 = r2.size();
        if (r5 >= r2) goto L_0x0219;
    L_0x016a:
        r2 = r14.hDM;
        r2 = r2.get(r5);
        r2 = (com.tencent.mm.ap.n.e) r2;
        r4 = r2.hDY;
        r4 = com.tencent.mm.sdk.platformtools.p.Vw(r4);
        if (r4 == 0) goto L_0x0189;
    L_0x017a:
        r2 = "MicroMsg.SendImgSpeeder";
        r4 = "[cpan] is gif coutinue. did not add to msg table";
        com.tencent.mm.sdk.platformtools.x.i(r2, r4);
        r2 = r3;
    L_0x0184:
        r3 = r5 + 1;
        r5 = r3;
        r3 = r2;
        goto L_0x0162;
    L_0x0189:
        r4 = 0;
        r7 = new com.tencent.mm.storage.au;
        r7.<init>();
        r3 = com.tencent.mm.y.s.ht(r19);
        r7.setType(r3);
        r0 = r19;
        r7.dU(r0);
        r3 = 1;
        r7.eS(r3);
        r3 = 1;
        r7.eR(r3);
        r3 = r2.hEc;
        r3 = r3.value;
        r7.dV(r3);
        r3 = r2.hEd;
        r3 = r3.value;
        r7.fd(r3);
        r3 = r2.hEe;
        r3 = r3.value;
        r7.fe(r3);
        r3 = com.tencent.mm.y.bd.HJ();
        if (r3 == 0) goto L_0x01c6;
    L_0x01be:
        r10 = r7.gkD;
        r10 = r3.equals(r10);
        if (r10 == 0) goto L_0x01cc;
    L_0x01c6:
        if (r3 != 0) goto L_0x01cf;
    L_0x01c8:
        r10 = r7.gkD;
        if (r10 == 0) goto L_0x01cf;
    L_0x01cc:
        r7.ea(r3);
    L_0x01cf:
        r3 = com.tencent.mm.i.a.a.xK();
        r3.b(r7);
        r3 = r7.field_talker;
        r10 = com.tencent.mm.y.bb.hU(r3);
        r7.aq(r10);
        r6.add(r7);
        r3 = com.tencent.mm.plugin.messenger.foundation.a.h.class;
        r3 = com.tencent.mm.kernel.g.h(r3);
        r3 = (com.tencent.mm.plugin.messenger.foundation.a.h) r3;
        r3 = r3.aZO();
        r10 = r3.Q(r7);
        r12 = 0;
        r3 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1));
        if (r3 < 0) goto L_0x0217;
    L_0x01f8:
        r3 = 1;
    L_0x01f9:
        junit.framework.Assert.assertTrue(r3);
        r2.frh = r10;
        r3 = r14.hDK;
        r10 = r2.frh;
        r7 = java.lang.Long.valueOf(r10);
        r3.put(r7, r2);
        r3 = r14.hDL;
        r10 = r2.frh;
        r2 = java.lang.Long.valueOf(r10);
        r3.add(r2);
        r2 = r4;
        goto L_0x0184;
    L_0x0217:
        r3 = 0;
        goto L_0x01f9;
    L_0x0219:
        r2 = r14.hDM;
        r2.clear();
        r4 = 0;
        r2 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1));
        if (r2 <= 0) goto L_0x022d;
    L_0x0224:
        r2 = com.tencent.mm.kernel.g.Dq();
        r2 = r2.gRU;
        r2.fT(r8);
    L_0x022d:
        if (r3 == 0) goto L_0x0241;
    L_0x022f:
        r2 = com.tencent.mm.plugin.messenger.foundation.a.h.class;
        r2 = com.tencent.mm.kernel.g.h(r2);
        r2 = (com.tencent.mm.plugin.messenger.foundation.a.h) r2;
        r2 = r2.aZO();
        r3 = "SendImgSpeeder";
        r2.Fa(r3);
    L_0x0241:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ap.n.a(java.util.ArrayList, boolean, int, int, java.lang.String, int):void");
    }

    private boolean lt(String str) {
        Iterator it = this.hDM.iterator();
        while (it.hasNext()) {
            if (((e) it.next()).hDY.equals(str)) {
                return true;
            }
        }
        return false;
    }

    private boolean Pu() {
        if (this.hDM.size() <= 0 || com.tencent.mm.plugin.report.service.f.a.boU().pWG > 2) {
            return true;
        }
        x.i("MicroMsg.SendImgSpeeder", "cpu core is low ,do not use multi mode");
        return false;
    }

    public final void a(int i, int i2, String str, String str2, boolean z, int i3) {
        if (!lt(str)) {
            com.tencent.mm.a.b bVar;
            com.tencent.mm.a.b bVar2;
            String str3;
            String str4;
            int b = b(str, str2, z);
            PString pString = new PString();
            PInt pInt = new PInt();
            PInt pInt2 = new PInt();
            if (Pu()) {
                b ia = this.hDI.ia(1);
                b ia2 = this.hDI.ia(2);
                com.tencent.mm.a.b bVar3 = ia.hDU;
                bVar = ia2.hDU;
                bVar2 = bVar3;
                str3 = ia2.hDV;
                str4 = ia.hDV;
            } else {
                bVar = null;
                bVar2 = null;
                str3 = null;
                str4 = null;
            }
            g PC = o.PC();
            if (FileOp.bO(str)) {
                String str5 = "THUMBNAIL_DIRPATH://th_" + (bi.oN(str3) ? g.Pn() : str3);
                String a = PC.a(str5, "th_", "", false);
                pString.value = str5;
                long Wz = bi.Wz();
                Bitmap a2 = PC.a(str, b, i2, pInt, pInt2, false, null, null);
                str5 = (String) PC.hCi.get(str);
                Object obj = str5 != null ? (Bitmap) PC.hCh.get(str5) : null;
                if (obj == null || obj.isRecycled()) {
                    obj = PC.a(str, true, com.tencent.mm.bu.a.getDensity(ad.getContext()), false, false, true, i3, true, a2);
                    PC.hCi.put(str, a);
                }
                if (obj != null) {
                    PC.hCh.l(a, obj);
                }
                x.i("MicroMsg.ImgInfoStorage", "test decode thumb img:%d", Long.valueOf(bi.bB(Wz)));
            } else {
                x.e("MicroMsg.ImgInfoStorage", "file not exit:%s", str);
            }
            e eVar = new e();
            eVar.hDY = str;
            eVar.hBE = b;
            eVar.cPf = i;
            eVar.fzM = i2;
            eVar.hDZ = str3;
            eVar.hEc = pString;
            eVar.hEe = pInt2;
            eVar.hEd = pInt;
            eVar.hEa = str4;
            eVar.hEg = bVar;
            eVar.hEf = bVar2;
            if (hDJ.Pu()) {
                a.a(eVar);
            }
            eVar.toUserName = str2;
            this.hDM.add(eVar);
            x.i("MicroMsg.SendImgSpeeder", "summersafecdn img path %s has prebuild, user:%s", str, str2);
        }
    }

    private static int b(String str, String str2, boolean z) {
        return q.a(str, str2, z) ? 1 : 0;
    }
}
