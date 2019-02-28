package com.tencent.mm.plugin.clean.b;

import com.tencent.mm.a.e;
import com.tencent.mm.plugin.clean.c.j;
import com.tencent.mm.plugin.i.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public final class a implements Runnable {
    private static final Long lkF = Long.valueOf(604800000);
    private static final Long lkG = Long.valueOf(7776000000L);
    private boolean isStop;
    private long lkH;
    private long lkI;
    private long lkJ;
    private long lkK;
    private HashMap<String, Long> lkL;
    private HashSet<String> lkM;
    private c lkN;

    public a(c cVar) {
        this.isStop = false;
        this.isStop = false;
        this.lkN = cVar;
        this.lkL = new HashMap();
        this.lkM = new HashSet();
    }

    public final void stop() {
        this.isStop = true;
        this.lkN = null;
    }

    private String atu() {
        return hashCode();
    }

    public final void run() {
        long Wz = bi.Wz();
        if (this.isStop) {
            x.i("MicroMsg.CleanCalcLogic", "%s start run but stop", atu());
            return;
        }
        String str;
        long xQ;
        List arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        a(arrayList, hashSet);
        int size = arrayList.size();
        int i = 0;
        while (!this.isStop && i < size) {
            str = (String) arrayList.get(i);
            if (!bi.oN(str)) {
                if (str.endsWith(File.separator + "sns" + File.separator)) {
                    xQ = xQ(str);
                } else if (str.endsWith(File.separator + "music")) {
                    xQ = xR(str);
                } else {
                    xQ = xP(str);
                }
                this.lkL.put(str, Long.valueOf(xQ));
                x.d("MicroMsg.CleanCalcLogic", "%s path[%s] size[%d]", atu(), str, Long.valueOf(xQ));
                this.lkH += xQ;
                if (hashSet.contains(str)) {
                    this.lkJ = xQ + this.lkJ;
                }
                int i2 = i + 1;
                if (this.lkN != null) {
                    this.lkN.bK(i2, size);
                }
                i = i2;
            }
        }
        this.lkI = b.atn().ato().atx();
        this.lkH += this.lkI;
        if (this.lkH <= 0) {
            this.lkH = 1;
            g.pWK.a(714, 60, 1, false);
        }
        x.i("MicroMsg.CleanCalcLogic", "%s scan finish cost[%d] micromsg[%d] acc[%d] otherAcc[%d]", atu(), Long.valueOf(bi.bB(Wz)), Long.valueOf(this.lkH), Long.valueOf(this.lkI), Long.valueOf(this.lkJ));
        HashSet hashSet2 = this.lkM;
        if (this.lkN != null) {
            this.lkN.a(this.lkH, this.lkI, this.lkJ, hashSet2, this.lkL);
        }
        j.azc();
        long ayJ = j.ayJ();
        j.azc();
        xQ = j.ayK();
        int i3 = (int) ((this.lkH * 100) / ayJ);
        int i4 = (int) ((this.lkI * 100) / this.lkH);
        size = (int) ((this.lkJ * 100) / this.lkH);
        long j = (this.lkH - this.lkI) - this.lkJ;
        int i5 = (int) ((100 * j) / this.lkH);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.lkK).append(",");
        stringBuffer.append(this.lkH).append(",");
        stringBuffer.append(i3).append(",");
        stringBuffer.append(ayJ - xQ).append(",");
        stringBuffer.append(xQ).append(",");
        stringBuffer.append(ayJ).append(",");
        stringBuffer.append(this.lkI).append(",");
        stringBuffer.append(i4).append(",");
        stringBuffer.append(this.lkJ).append(",");
        stringBuffer.append(size).append(",");
        stringBuffer.append(j).append(",");
        stringBuffer.append(i5);
        x.i("MicroMsg.CleanCalcLogic", "rpt content %s", stringBuffer.toString());
        g.pWK.k(14762, str);
        stop();
    }

    private long xP(String str) {
        File file = new File(str);
        if (file.isDirectory()) {
            String[] list = file.list();
            if (list != null) {
                long j = 0;
                for (String str2 : list) {
                    String str22;
                    StringBuilder append = new StringBuilder().append(str);
                    if (!str.endsWith("/")) {
                        str22 = "/" + str22;
                    }
                    long xP = xP(append.append(str22).toString());
                    if (xP == -1) {
                        return -1;
                    }
                    j += xP;
                }
                return j;
            }
        }
        return file.length();
    }

    private int a(List<String> list, HashSet<String> hashSet) {
        String str = com.tencent.mm.kernel.g.Dq().gRS;
        String str2 = com.tencent.mm.kernel.g.Dq().gRT;
        x.i("MicroMsg.CleanCalcLogic", "%s get MicroMsg path root[%s] acc[%s]", atu(), str, str2);
        int i = 0;
        File file = new File(str);
        if (file.isDirectory()) {
            String[] list2 = file.list();
            if (list2 != null) {
                int length = list2.length;
                int i2 = 0;
                while (i2 < length) {
                    int i3;
                    String str3 = list2[i2];
                    String str4 = str + str3 + "/";
                    x.d("MicroMsg.CleanCalcLogic", "%s sub file path[%s] sub[%s]", atu(), str4, str3);
                    if (!new File(str4).isDirectory()) {
                        list.add(str4);
                        i3 = i + 1;
                    } else if (str3.length() < 32) {
                        list.add(str4);
                        i3 = i + 1;
                    } else if (bi.fA(str2, str4)) {
                        list.add(str2.endsWith("/") ? str2 + "music" : str2 + File.separator + "music");
                        as.Hm();
                        list.add(c.Fw());
                        as.Hm();
                        list.add(c.getAccSnsPath());
                        as.Hm();
                        list.add(c.FD());
                        i3 = i;
                    } else {
                        hashSet.add(str4);
                        list.add(str4);
                        i3 = i + 1;
                        this.lkM.add(str3);
                    }
                    i2++;
                    i = i3;
                }
            }
        }
        return i;
    }

    private long xQ(String str) {
        long j = 0;
        int i = 0;
        File file = new File(str);
        if (file.isDirectory()) {
            String[] list = file.list();
            if (list != null) {
                int length = list.length;
                while (i < length) {
                    i++;
                    j = xQ(str + "/" + list[i]) + j;
                }
                return j;
            }
        } else if (System.currentTimeMillis() - file.lastModified() > lkF.longValue()) {
            x.i("MicroMsg.CleanCalcLogic", "Clean 7 days file in sns rootPath=%s", str);
            long bN = (long) e.bN(str);
            if (!file.delete()) {
                return 0;
            }
            this.lkK += bN;
            return 0;
        }
        return (long) e.bN(str);
    }

    private long xR(String str) {
        long j = 0;
        int i = 0;
        File file = new File(str);
        if (file.isDirectory()) {
            String[] list = file.list();
            if (list != null) {
                int length = list.length;
                while (i < length) {
                    i++;
                    j = xR(str + "/" + list[i]) + j;
                }
                return j;
            }
        } else if (System.currentTimeMillis() - file.lastModified() > lkG.longValue()) {
            x.i("MicroMsg.CleanCalcLogic", "Clean 90 days file in music rootPath=%s", str);
            long bN = (long) e.bN(str);
            if (!file.delete()) {
                return 0;
            }
            this.lkK += bN;
            return 0;
        }
        return (long) e.bN(str);
    }
}
