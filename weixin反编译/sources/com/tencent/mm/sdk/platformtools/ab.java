package com.tencent.mm.sdk.platformtools;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import junit.framework.Assert;

public final class ab {
    public static b gzz;
    private static int xnB;
    public static Map<Integer, ab> xnD = new HashMap();
    private static boolean xnF = false;
    public static boolean xnG;
    public long hlm = 0;
    private final boolean hmg;
    public long sAT = 0;
    public final int xnC;
    private final a xnE;

    public interface a {
        boolean uG();
    }

    public interface b {
        void cancel();

        void prepare();
    }

    public static void a(b bVar) {
        xnF = true;
        gzz = bVar;
    }

    protected final void finalize() {
        TN();
        super.finalize();
    }

    public ab(a aVar) {
        Assert.assertTrue("bumper not initialized", xnF);
        this.xnE = aVar;
        this.hmg = true;
        if (xnB >= 8192) {
            xnB = 0;
        }
        int i = xnB + 1;
        xnB = i;
        this.xnC = i;
    }

    public static long cga() {
        xnG = false;
        List linkedList = new LinkedList();
        Set<Integer> hashSet = new HashSet();
        hashSet.addAll(xnD.keySet());
        long j = Long.MAX_VALUE;
        for (Integer num : hashSet) {
            ab abVar = (ab) xnD.get(num);
            if (abVar != null) {
                long bB = bi.bB(abVar.hlm);
                if (bB < 0) {
                    bB = 0;
                }
                if (bB > abVar.sAT) {
                    if (abVar.xnE.uG() && abVar.hmg) {
                        j = abVar.sAT;
                    } else {
                        linkedList.add(num);
                    }
                    abVar.hlm = bi.Wz();
                } else if (abVar.sAT - bB < j) {
                    j = abVar.sAT - bB;
                }
            }
            j = j;
        }
        for (int i = 0; i < linkedList.size(); i++) {
            xnD.remove(linkedList.get(i));
        }
        if (!(xnG || j != Long.MAX_VALUE || gzz == null)) {
            gzz.cancel();
            x.v("MicroMsg.MAlarmHandler", "cancel bumper for no more handler");
        }
        return j;
    }

    public final void TN() {
        xnD.remove(Integer.valueOf(this.xnC));
    }

    public static boolean fH(long j) {
        long j2;
        x.d("MicroMsg.MAlarmHandler", "check need prepare: check=" + j);
        long j3 = Long.MAX_VALUE;
        Iterator it = xnD.entrySet().iterator();
        while (true) {
            j2 = j3;
            if (!it.hasNext()) {
                break;
            }
            ab abVar = (ab) ((Entry) it.next()).getValue();
            if (abVar != null) {
                long bB = bi.bB(abVar.hlm);
                if (bB < 0) {
                    bB = 0;
                }
                if (bB > abVar.sAT) {
                    j3 = abVar.sAT;
                } else if (abVar.sAT - bB < j2) {
                    j2 = abVar.sAT - bB;
                }
            }
            j3 = j2;
        }
        return j2 > j;
    }
}
