package com.tencent.mm.plugin.secinforeport;

import android.content.Context;
import android.util.Base64;
import com.tencent.c.a.b;
import com.tencent.c.e.a.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.ad.u;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.normsg.a.d;
import com.tencent.mm.protocal.c.bdj;
import com.tencent.mm.protocal.c.bdk;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

enum c implements com.tencent.mm.plugin.secinforeport.a.c {
    ;

    static final class a {
        private static final Map<Integer, Long> qle = null;

        static {
            qle = new HashMap();
        }

        private static synchronized void kt() {
            Exception e;
            Throwable th;
            synchronized (a.class) {
                DataInputStream dataInputStream;
                try {
                    dataInputStream = new DataInputStream(new FileInputStream(new File(g.Dq().cachePath, d.oXY.Hl("!#?'8/f((6(1$\u001f2*>(s826"))));
                    try {
                        if (dataInputStream.readShort() != (short) -774) {
                            throw new IllegalStateException("bad magic.");
                        }
                        dataInputStream.readShort();
                        int readInt = dataInputStream.readInt();
                        if (readInt < 0) {
                            throw new IllegalStateException("bad pair count.");
                        }
                        for (int i = 0; i < readInt; i++) {
                            qle.put(Integer.valueOf(dataInputStream.readInt()), Long.valueOf(dataInputStream.readLong()));
                        }
                        x.i("MicroMsg.SecInfoReporterImpl", "normsg stat load done.");
                        try {
                            dataInputStream.close();
                        } catch (Exception e2) {
                        }
                    } catch (Exception e3) {
                        e = e3;
                    }
                } catch (Exception e4) {
                    e = e4;
                    dataInputStream = null;
                    try {
                        x.e("MicroMsg.SecInfoReporterImpl", "normsg stat load failed, use default.", e);
                        if (dataInputStream != null) {
                            try {
                                dataInputStream.close();
                            } catch (Exception e5) {
                            }
                        }
                        return;
                    } catch (Throwable th2) {
                        th = th2;
                        if (dataInputStream != null) {
                            try {
                                dataInputStream.close();
                            } catch (Exception e6) {
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    dataInputStream = null;
                    if (dataInputStream != null) {
                        dataInputStream.close();
                    }
                    throw th;
                }
            }
            return;
        }

        private static synchronized void save() {
            Throwable th;
            synchronized (a.class) {
                File file = new File(g.Dq().cachePath, d.oXY.Hl("!#?'8/f((6(1$\u001f2*>(s826"));
                if (!file.exists()) {
                    file.getParentFile().mkdirs();
                }
                DataOutputStream dataOutputStream = null;
                DataOutputStream dataOutputStream2;
                try {
                    dataOutputStream2 = new DataOutputStream(new FileOutputStream(file));
                    try {
                        dataOutputStream2.writeShort(-774);
                        dataOutputStream2.writeShort(1);
                        dataOutputStream2.writeInt(qle.size());
                        for (Entry entry : qle.entrySet()) {
                            dataOutputStream2.writeInt(((Integer) entry.getKey()).intValue());
                            dataOutputStream2.writeLong(((Long) entry.getValue()).longValue());
                        }
                        x.i("MicroMsg.SecInfoReporterImpl", "normsg stat save done.");
                        try {
                            dataOutputStream2.close();
                        } catch (Exception e) {
                        }
                    } catch (Exception e2) {
                        dataOutputStream = dataOutputStream2;
                        try {
                            x.e("MicroMsg.SecInfoReporterImpl", "normsg stat save failed.");
                            if (dataOutputStream != null) {
                                try {
                                    dataOutputStream.close();
                                } catch (Exception e3) {
                                }
                            }
                            return;
                        } catch (Throwable th2) {
                            dataOutputStream2 = dataOutputStream;
                            th = th2;
                            if (dataOutputStream2 != null) {
                                try {
                                    dataOutputStream2.close();
                                } catch (Exception e4) {
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        if (dataOutputStream2 != null) {
                            dataOutputStream2.close();
                        }
                        throw th;
                    }
                } catch (Exception e5) {
                    x.e("MicroMsg.SecInfoReporterImpl", "normsg stat save failed.");
                    if (dataOutputStream != null) {
                        dataOutputStream.close();
                    }
                    return;
                } catch (Throwable th22) {
                    dataOutputStream2 = null;
                    th = th22;
                    if (dataOutputStream2 != null) {
                        dataOutputStream2.close();
                    }
                    throw th;
                }
            }
            return;
        }

        static synchronized boolean G(int i, long j) {
            boolean z;
            synchronized (a.class) {
                if (j < 0) {
                    x.w("MicroMsg.SecInfoReporterImpl", "bad interval: %s", Long.valueOf(j));
                    z = false;
                } else {
                    if (!qle.containsKey(Integer.valueOf(i))) {
                        kt();
                    }
                    Long l = (Long) qle.get(Integer.valueOf(i));
                    long currentTimeMillis = System.currentTimeMillis();
                    if (l == null || currentTimeMillis < l.longValue()) {
                        qle.put(Integer.valueOf(i), Long.valueOf(0));
                        save();
                        z = false;
                    } else if (currentTimeMillis - l.longValue() > j) {
                        qle.put(Integer.valueOf(i), Long.valueOf(currentTimeMillis));
                        save();
                        z = true;
                    } else {
                        z = false;
                    }
                }
            }
            return z;
        }
    }

    private c(String str) {
    }

    public final boolean G(int i, long j) {
        return a.G(i, j);
    }

    public final void JC(String str) {
        int nextInt = new Random().nextInt();
        int length = str.length();
        int i = (length / 1000) + (length % 1000 > 0 ? 1 : 0);
        int i2 = 0;
        int i3 = 0;
        while (i2 < str.length()) {
            int min = Math.min(1000, length - i2);
            com.tencent.mm.plugin.report.d.pVE.a(13690, nextInt + "," + i + "," + i3 + ",0,0" + ",," + str.substring(i2, i2 + min), false, true);
            i2 += min;
            i3++;
        }
        x.d("MicroMsg.SecInfoReporterImpl", "kvreport: ctxId: %d, dataLen: %d, pkgCount: %d", Integer.valueOf(nextInt), Integer.valueOf(length), Integer.valueOf(i));
    }

    public final void ca(String str, int i) {
        aH(i, str);
    }

    public final void JD(String str) {
        aH(Integer.MIN_VALUE, str);
    }

    public final void bqZ() {
        e.cEr().vp();
        Context context = ad.getContext();
        e.cEr().a(context, q.yL(), new com.tencent.c.a.d.AnonymousClass1(new b() {
            public final boolean m(int i, byte[] bArr) {
                if (i == 0) {
                    String encodeToString = Base64.encodeToString(bArr, 2);
                    Object[][] objArr = new Object[1][];
                    objArr[0] = new Object[]{"\u001e<:& *\u001e&3\u0005!3'\u0007%(?ol", encodeToString};
                    c.this.aH(0, d.oXY.a(objArr));
                    return true;
                }
                x.w("MicroMsg.SecInfoReporterImpl", "TuringService recvReqData failed, code: " + i);
                return false;
            }
        }, new com.tencent.c.b.c(context)));
    }

    private void aH(final int i, String str) {
        com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
        aVar.uri = d.oXY.Hl("Q\u001e\u001b\u0012W\u001b\u0011\u0019Y\u0018\u001d\u0010\u0000\u001e\u001d\u001c\t@\u000e\u0002\u0004F\u001a\u0002\u0016\n\u0016\u0017\u0001\r\t:0)?3?:3");
        aVar.hnS = 771;
        aVar.hnT = new bdj();
        aVar.hnU = new bdk();
        com.tencent.mm.ad.b Kf = aVar.Kf();
        bdj bdj = (bdj) Kf.hnQ.hnY;
        bdj.wPZ = i;
        bdj.wPY = str;
        com.tencent.mm.plugin.report.d.pVE.a(416, 0, 1, false);
        u.a(Kf, new com.tencent.mm.ad.u.a() {
            public final int a(int i, int i2, String str, com.tencent.mm.ad.b bVar, k kVar) {
                if (i == 0 && i2 == 0) {
                    x.d("MicroMsg.SecInfoReporterImpl", "cgireport succ, ctx: %d", Integer.valueOf(i));
                    com.tencent.mm.plugin.report.d.pVE.a(416, 1, 1, false);
                } else {
                    x.d("MicroMsg.SecInfoReporterImpl", "cgireport failed, ctx: %d, err: %d:%d %s", Integer.valueOf(i), Integer.valueOf(i), Integer.valueOf(i2), str);
                    com.tencent.mm.plugin.report.d.pVE.a(416, 2, 1, false);
                }
                return 0;
            }
        }, false);
    }
}
