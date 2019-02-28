package com.tencent.mm.modelstat;

import android.os.Looper;
import com.tencent.mars.xlog.LogLogic;
import com.tencent.mars.xlog.Xlog;
import com.tencent.mm.ad.d;
import com.tencent.mm.ad.d.b;
import com.tencent.mm.bz.c;
import com.tencent.mm.f.a.ig;
import com.tencent.mm.f.a.sk;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.a.b.a;
import com.tencent.mm.platformtools.q;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.w;
import java.io.File;
import java.util.Map;

public final class l extends a implements d {
    public static long a(File file, long j) {
        long j2;
        Throwable e;
        try {
            File[] listFiles = file.listFiles();
            j2 = 0;
            int i = 0;
            while (i < listFiles.length) {
                try {
                    long a;
                    if (listFiles[i].isDirectory()) {
                        a = a(listFiles[i], j);
                    } else {
                        if (listFiles[i].length() > j) {
                            x.i("MicroMsg.NetStatMsgExtension", "getFolderSize filesize:%s [%s]", Long.valueOf(listFiles[i].length()), listFiles[i].getPath());
                        }
                        a = listFiles[i].length();
                    }
                    j2 += a;
                    i++;
                } catch (Exception e2) {
                    e = e2;
                }
            }
        } catch (Throwable e3) {
            Throwable th = e3;
            j2 = 0;
            e = th;
            x.e("MicroMsg.NetStatMsgExtension", "getFolderSize :%s", bi.i(e));
            return j2;
        }
        return j2;
    }

    public final b b(d.a aVar) {
        if (g.Do().CF()) {
            String str = aVar.hoa.vNO.wRo;
            x.d("MicroMsg.NetStatMsgExtension", "onPreAddMessage %s", str);
            if (!bi.oN(str)) {
                x.i("MicroMsg.NetStatMsgExtension", "get ipxx cmd=%s", str);
                Map y = bj.y(str, "cmd");
                if (y != null) {
                    int i = bi.getInt((String) y.get(".cmd.trace.$code"), -1);
                    if (i <= 0) {
                        int i2 = bi.getInt((String) y.get(".cmd.hprof.$type"), -1);
                        if (i2 > 0) {
                            x.d("MicroMsg.NetStatMsgExtension", "hprof type: %d", Integer.valueOf(i2));
                            c.DZ(i2);
                        } else {
                            if ("android".equalsIgnoreCase((String) y.get(".cmd.hotpatch.$os"))) {
                                com.tencent.mm.sdk.b.b igVar = new ig();
                                igVar.fzy.fzz = (String) y.get(".cmd.hotpatch.xml.$url");
                                igVar.fzy.fzA = (String) y.get(".cmd.hotpatch.xml.$signature");
                                igVar.fzy.fzB = (String) y.get(".cmd.hotpatch.$url");
                                igVar.fzy.fzC = (String) y.get(".cmd.hotpatch.$signature");
                                com.tencent.mm.sdk.b.a.xmy.a(igVar, Looper.myLooper());
                            } else {
                                String str2;
                                i2 = bi.getInt((String) y.get(".cmd.clearfile.$fb"), -1);
                                final long j;
                                if (i2 == 1) {
                                    j = (long) bi.getInt((String) y.get(".cmd.clearfile.$ps"), 1048576);
                                    g.Dt().F(new Runnable() {
                                        public final void run() {
                                            long Wy = bi.Wy();
                                            long a = l.a(new File(g.Dq().cachePath), j);
                                            x.i("MicroMsg.NetStatMsgExtension", "clearfile %s [%s]", Long.valueOf(a), g.Dq().cachePath);
                                            a = l.a(new File(g.Dq().gRS), j);
                                            x.i("MicroMsg.NetStatMsgExtension", "clearfile %s [%s]", Long.valueOf(a), g.Dq().gRS);
                                            a = l.a(new File(g.Dq().gRS), j);
                                            x.i("MicroMsg.NetStatMsgExtension", "clearfile %s [%s]", Long.valueOf(a), g.Dq().gRS);
                                            a = l.a(new File(g.Dq().gRT), j);
                                            x.i("MicroMsg.NetStatMsgExtension", "clearfile %s [%s]", Long.valueOf(a), g.Dq().gRT);
                                            a = l.a(new File(w.hbv), j);
                                            x.i("MicroMsg.NetStatMsgExtension", "clearfile %s [%s]", Long.valueOf(a), w.hbv);
                                            x.i("MicroMsg.NetStatMsgExtension", "clearfile finish %s", Long.valueOf(bi.Wy() - Wy));
                                        }
                                    });
                                } else if (i2 == 2) {
                                    str2 = (String) y.get(".cmd.clearfile.$pd");
                                    File file = new File(str2);
                                    String str3 = "MicroMsg.NetStatMsgExtension";
                                    String str4 = "clearfile delete :[%s] length:%s";
                                    Object[] objArr = new Object[2];
                                    objArr[0] = str2;
                                    objArr[1] = Long.valueOf(file.exists() ? file.length() : -1);
                                    x.i(str3, str4, objArr);
                                    com.tencent.mm.loader.stub.b.deleteFile(str2);
                                    file = new File(str2);
                                    String str5 = "MicroMsg.NetStatMsgExtension";
                                    String str6 = "clearfile delete finish :[%s] length:%s";
                                    Object[] objArr2 = new Object[2];
                                    objArr2[0] = str2;
                                    if (file.exists()) {
                                        j = file.length();
                                    } else {
                                        j = -1;
                                    }
                                    objArr2[1] = Long.valueOf(j);
                                    x.i(str5, str6, objArr2);
                                } else if (i2 == 3) {
                                    x.i("MicroMsg.NetStatMsgExtension", "running  clearfile start:" + g.Dq().CY() + ".tem");
                                    com.tencent.mm.loader.stub.b.deleteFile(g.Dq().CY() + ".tem");
                                    com.tencent.mm.loader.stub.b.deleteFile(g.Dq().CZ() + ".tem");
                                    x.i("MicroMsg.NetStatMsgExtension", "running  clearfile end:" + g.Dq().CY() + ".tem");
                                }
                                final int i3 = bi.getInt((String) y.get(".cmd.updzh.$pt"), -1);
                                str2 = (String) y.get(".cmd.updzh.$pd");
                                x.d("MicroMsg.NetStatMsgExtension", "StackReportUploader pt:%d pd:%s", Integer.valueOf(i3), str2);
                                if (i3 > 0 && !bi.oN(str2)) {
                                    g.Dt().F(new Runnable() {
                                        public final void run() {
                                            switch (i3) {
                                                case 1:
                                                    q.a(g.Dq().gRT + str2, com.tencent.mm.y.q.FY(), false, true);
                                                    return;
                                                case 2:
                                                    q.a(g.Dq().cachePath + str2, com.tencent.mm.y.q.FY(), false, true);
                                                    return;
                                                case 3:
                                                    q.a(str2, com.tencent.mm.y.q.FY(), false, true);
                                                    return;
                                                default:
                                                    return;
                                            }
                                        }

                                        public final String toString() {
                                            return super.toString() + "|onPreAddMessage";
                                        }
                                    });
                                }
                            }
                        }
                    } else if (i == 6) {
                        com.tencent.mm.sdk.b.a.xmy.m(new sk());
                    } else {
                        com.tencent.mm.bz.d.cmf().c(new com.tencent.mm.bz.d.a((String) y.get(".cmd.trace.$class"), i, bi.getInt((String) y.get(".cmd.trace.$size"), 0), bi.getInt((String) y.get(".cmd.trace.$type"), 0)));
                    }
                }
                x.cfX();
                g.CN().hoF.jt(str);
                try {
                    Thread.sleep(50, 0);
                } catch (Exception e) {
                }
                LogLogic.initIPxxLogInfo();
                MMProtocalJni.setProtocalJniLogLevel(new Xlog().getLogLevel());
            }
        } else {
            x.e("MicroMsg.NetStatMsgExtension", "skip ipxx stat while account not set");
        }
        return null;
    }

    public final void a(int i, int i2, String str, int i3, String str2, boolean z) {
        final int i4 = i;
        final int i5 = i2;
        final String str3 = str;
        final int i6 = i3;
        final String str4 = str2;
        final boolean z2 = z;
        g.Dt().g(new Runnable() {
            public final void run() {
                l.b(i4, i5, i6, z2);
            }

            public final String toString() {
                return super.toString() + "|report";
            }
        }, 3000);
    }

    public final void j(int i, int i2, int i3, int i4) {
        if (!g.Do().CF()) {
            return;
        }
        if (g.Dr().gSp.gSI) {
            x.i("MicroMsg.NetStatMsgExtension", "reportNetFlow wifi[%d, %d] mobile[%d, %d]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
            if (i <= 0) {
                i = 0;
            }
            if (i2 <= 0) {
                i2 = 0;
            }
            n.B(i, i2, 0);
            if (i3 <= 0) {
                i3 = 0;
            }
            if (i4 <= 0) {
                i4 = 0;
            }
            n.C(i3, i4, 0);
            return;
        }
        x.i("MicroMsg.NetStatMsgExtension", "kernel has not startup");
    }

    public static void b(int i, int i2, int i3, boolean z) {
        if (g.Do().CF()) {
            switch (i) {
                case 4:
                    x.d("MicroMsg.NetStatMsgExtension", "recv bytes flow:" + i3);
                    if (z) {
                        n.B(i3, 0, i2);
                        return;
                    } else {
                        n.C(i3, 0, i2);
                        return;
                    }
                case 5:
                    x.d("MicroMsg.NetStatMsgExtension", "send bytes flow:" + i3);
                    if (z) {
                        n.B(0, i3, i2);
                        return;
                    } else {
                        n.C(0, i3, i2);
                        return;
                    }
                case 8:
                    af.VI("dns_failed_report");
                    return;
                default:
                    return;
            }
        }
    }

    public final void h(au auVar) {
    }
}
