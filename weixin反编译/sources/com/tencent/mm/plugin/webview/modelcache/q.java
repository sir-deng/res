package com.tencent.mm.plugin.webview.modelcache;

import android.os.Build.VERSION;
import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import android.os.Process;
import android.util.SparseArray;
import com.tencent.mm.f.a.lw;
import com.tencent.mm.f.a.tr;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.webview.modelcache.downloaderimpl.f;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class q {
    private volatile ah hoG;
    private final Object jXz;
    public final c tAn;
    public final c tAo;
    private volatile i tAp;
    final SparseArray<l> tAq;
    public final c tAr;
    final e tAs;
    public final byte[] tAt;
    public final SparseArray<Set<Object>> tAu;

    /* renamed from: com.tencent.mm.plugin.webview.modelcache.q$5 */
    class AnonymousClass5 implements Runnable {
        final /* synthetic */ List tAB;

        public AnonymousClass5(List list) {
            this.tAB = list;
        }

        public final void run() {
            for (String str : this.tAB) {
                x.i("MicroMsg.WebViewCacheWorkerManager", "triggerMainDocumentURLUpdate requestURL = %s", str);
                if (!bi.oN(str)) {
                    int AD;
                    if (str.startsWith("http://")) {
                        AD = com.tencent.mm.plugin.webview.modelcache.b.a.AD(0);
                    } else if (str.startsWith("https://")) {
                        AD = com.tencent.mm.plugin.webview.modelcache.b.a.AE(com.tencent.mm.plugin.webview.modelcache.b.a.AD(0));
                    } else {
                        x.i("MicroMsg.WebViewCacheWorkerManager", "triggerMainDocumentURLUpdate, unsupported scheme, url = %s", str);
                    }
                    String Pf = p.Pf(str);
                    k bRZ = k.bRZ();
                    List n = !bRZ.jbr ? null : bi.oN(Pf) ? null : bRZ.n(String.format("select * from %s where %s=? and %s=?", new Object[]{"WebViewResourceCache", "urlMd5Hashcode", "protocol"}), String.valueOf(ac.VF(Pf).hashCode()), String.valueOf(AD));
                    if (bi.cC(n)) {
                        x.i("MicroMsg.WebViewCacheWorkerManager", "triggerMainDocumentURLUpdate, not cached requestURL = %s, parsed mainURL = %s, protocol = %s", str, Pf, com.tencent.mm.plugin.webview.modelcache.b.a.toString(AD));
                    } else {
                        String Pf2 = p.Pf(str);
                        if (!bi.oN(Pf2)) {
                            Object obj;
                            long Wx = bi.Wx();
                            for (f fVar : n) {
                                if (Wx - fVar.field_createTime > 60 && Pf2.equals(fVar.field_version)) {
                                    obj = 1;
                                    break;
                                }
                            }
                            obj = null;
                            if (obj == null) {
                                x.i("MicroMsg.WebViewCacheWorkerManager", "triggerMainDocumentURLUpdate, createTime not exceed 1min, no need to update this mainDocument, url = %s", str);
                            } else {
                                byte[] Ph = p.Ph(str);
                                if (bi.by(Ph)) {
                                    x.i("MicroMsg.WebViewCacheWorkerManager", "triggerMainDocumentURLUpdate, get empty bytes from requestURL = %s", str);
                                } else {
                                    k bRZ2 = k.bRZ();
                                    List n2 = !bRZ2.jbr ? null : bi.oN(Pf) ? null : bRZ2.n(String.format("select * from %s where %s=? and %s", new Object[]{"WebViewResourceCache", "urlMd5Hashcode", k.AG(AD)}), String.valueOf(ac.VF(Pf).hashCode()));
                                    if (bi.cC(n2)) {
                                        x.e("MicroMsg.WebViewCacheWorkerManager", "batchUpdateContent with bytes, get empty list ");
                                    } else {
                                        String bv = ac.bv(Ph);
                                        for (f fVar2 : n2) {
                                            x.d("MicroMsg.WebViewCacheWorkerManager", "batchUpdateContent with bytes, cacheRes = %s", fVar2);
                                            if (!bi.oN(fVar2.field_localPath)) {
                                                if (bv.equals(fVar2.field_contentMd5)) {
                                                    x.i("MicroMsg.WebViewCacheWorkerManager", "batchUpdateContent with bytes, cache not updated");
                                                } else {
                                                    a Pb = a.Pb(fVar2.field_appId);
                                                    if (Pb != null) {
                                                        String str2 = fVar2.field_localPath;
                                                        if (!(bi.oN(str2) || bi.by(Ph))) {
                                                            if ((FileOp.j(str2, Ph) == 0 ? 1 : null) != null && str2.startsWith(Pb.path)) {
                                                                b.a(Pb.tzP, Pb.appId, (long) Ph.length);
                                                            }
                                                        }
                                                        fVar2.field_contentMd5 = bv;
                                                        k.bRZ().b(fVar2);
                                                        x.i("MicroMsg.WebViewCacheWorkerManager", "batchUpdateContent with bytes, updated cacheRes = %s", fVar2);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private static final class a {
        private static final q tAC = new q();
    }

    /* synthetic */ q(byte b) {
        this();
    }

    private q() {
        this.tAn = new c<tr>() {
            {
                this.xmG = tr.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(b bVar) {
                tr trVar = (tr) bVar;
                if (trVar != null) {
                    final f fVar = new f(trVar.fNb.url, trVar.fNb.filePath, trVar.fNb.version, trVar.fNb.appId, trVar.fNb.fNc, trVar.fNb.fNd, trVar.fNb.fNe, trVar.fNb.aBD, trVar.fNb.fNf, trVar.fNb.exception);
                    q.this.Dt().F(new Runnable() {
                        /* JADX WARNING: inconsistent code. */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public final void run() {
                            /*
                            r14 = this;
                            r8 = r1;
                            if (r8 != 0) goto L_0x0005;
                        L_0x0004:
                            return;
                        L_0x0005:
                            r0 = r8.appId;
                            r0 = com.tencent.mm.sdk.platformtools.bi.oN(r0);
                            if (r0 != 0) goto L_0x001d;
                        L_0x000d:
                            r0 = r8.fNc;
                            r0 = com.tencent.mm.sdk.platformtools.bi.oN(r0);
                            if (r0 != 0) goto L_0x001d;
                        L_0x0015:
                            r0 = r8.filePath;
                            r0 = com.tencent.mm.sdk.platformtools.bi.oN(r0);
                            if (r0 == 0) goto L_0x002d;
                        L_0x001d:
                            r0 = "MicroMsg.WebViewCacheDownloadResponseLogic";
                            r1 = "onResponse, invalid response = %s";
                            r2 = 1;
                            r2 = new java.lang.Object[r2];
                            r3 = 0;
                            r2[r3] = r8;
                            com.tencent.mm.sdk.platformtools.x.i(r0, r1, r2);
                            goto L_0x0004;
                        L_0x002d:
                            r0 = "MicroMsg.WebViewCacheDownloadResponseLogic";
                            r1 = "onResponse, response = %s";
                            r2 = 1;
                            r2 = new java.lang.Object[r2];
                            r3 = 0;
                            r2[r3] = r8;
                            com.tencent.mm.sdk.platformtools.x.i(r0, r1, r2);
                            r0 = com.tencent.mm.plugin.webview.modelcache.q.a.tAC;
                            r0 = r0.tAs;
                            r1 = r8.url;
                            r2 = r8.appId;
                            r3 = r8.fNc;
                            r4 = r8.fNd;
                            r9 = r0.n(r1, r2, r3, r4);
                            r0 = r8.exception;
                            if (r0 == 0) goto L_0x00f9;
                        L_0x0052:
                            r1 = "MicroMsg.WebViewCacheDownloadResponseLogic";
                            r2 = "onResponse, response.exception = %s";
                            r3 = 1;
                            r3 = new java.lang.Object[r3];
                            r4 = 0;
                            r3[r4] = r0;
                            com.tencent.mm.sdk.platformtools.x.i(r1, r2, r3);
                            r1 = com.tencent.mm.sdk.platformtools.bi.cC(r9);
                            if (r1 != 0) goto L_0x00ef;
                        L_0x0067:
                            r1 = r0 instanceof java.net.SocketTimeoutException;
                            if (r1 == 0) goto L_0x00ae;
                        L_0x006b:
                            r0 = "timeout";
                            r7 = r0;
                        L_0x006f:
                            r10 = r9.iterator();
                        L_0x0073:
                            r0 = r10.hasNext();
                            if (r0 == 0) goto L_0x00ef;
                        L_0x0079:
                            r0 = r10.next();
                            r1 = r0;
                            r1 = (com.tencent.mm.plugin.webview.modelcache.e.c) r1;
                            r0 = r1.tzY;
                            r2 = com.tencent.mm.plugin.webview.ui.tools.jsapi.h.Bw(r0);
                            r3 = r1.tzZ;
                            r0 = r8.fNe;
                            r4 = 3;
                            if (r0 != r4) goto L_0x00d7;
                        L_0x008d:
                            r0 = "publicCache";
                        L_0x0090:
                            r2.z(r3, r0, r7);
                            r0 = r8.fNe;
                            r2 = 1;
                            if (r0 != r2) goto L_0x00db;
                        L_0x0098:
                            r0 = com.tencent.mm.plugin.webview.modelcache.q.a.tAC;
                            r0 = r0.tAs;
                            r1 = r1.tzY;
                            r2 = r8.appId;
                            r3 = r8.fNc;
                            r4 = r8.fNd;
                            r5 = r8.fNe;
                            r6 = r8.url;
                            r0.a(r1, r2, r3, r4, r5, r6);
                            goto L_0x0073;
                        L_0x00ae:
                            r1 = r0 instanceof com.tencent.mm.pluginsdk.i.a.c.d;
                            if (r1 == 0) goto L_0x00b7;
                        L_0x00b2:
                            r0 = "not support redirect resource";
                            r7 = r0;
                            goto L_0x006f;
                        L_0x00b7:
                            r1 = r0 instanceof com.tencent.mm.pluginsdk.i.a.c.g;
                            if (r1 == 0) goto L_0x00c0;
                        L_0x00bb:
                            r0 = "not support 0kb resource";
                            r7 = r0;
                            goto L_0x006f;
                        L_0x00c0:
                            r0 = r0 instanceof com.tencent.mm.pluginsdk.i.a.c.a;
                            if (r0 == 0) goto L_0x00d2;
                        L_0x00c4:
                            r0 = r8.fNf;
                            r2 = 5242880; // 0x500000 float:7.34684E-39 double:2.590327E-317;
                            r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
                            if (r0 < 0) goto L_0x00d2;
                        L_0x00cd:
                            r0 = "exceed cache threshold";
                            r7 = r0;
                            goto L_0x006f;
                        L_0x00d2:
                            r0 = "batch download fail";
                            r7 = r0;
                            goto L_0x006f;
                        L_0x00d7:
                            r0 = "cache";
                            goto L_0x0090;
                        L_0x00db:
                            r0 = com.tencent.mm.plugin.webview.modelcache.q.a.tAC;
                            r0 = r0.tAs;
                            r1 = r1.tzY;
                            r2 = r8.appId;
                            r3 = r8.fNc;
                            r4 = r8.fNd;
                            r5 = r8.fNe;
                            r0.b(r1, r2, r3, r4, r5);
                            goto L_0x0073;
                        L_0x00ef:
                            r0 = 1;
                        L_0x00f0:
                            if (r0 == 0) goto L_0x00fb;
                        L_0x00f2:
                            r0 = 7;
                            com.tencent.mm.plugin.webview.modelcache.m.fj(r0);
                            goto L_0x0004;
                        L_0x00f9:
                            r0 = 0;
                            goto L_0x00f0;
                        L_0x00fb:
                            r0 = r8.filePath;
                            r0 = com.tencent.mm.a.e.bN(r0);
                            if (r0 != 0) goto L_0x015d;
                        L_0x0103:
                            r0 = "MicroMsg.WebViewCacheDownloadResponseLogic";
                            r1 = "onResponse, readFileLength = 0, return";
                            com.tencent.mm.sdk.platformtools.x.i(r0, r1);
                            r0 = com.tencent.mm.sdk.platformtools.bi.cC(r9);
                            if (r0 != 0) goto L_0x0153;
                        L_0x0112:
                            r7 = r9.iterator();
                        L_0x0116:
                            r0 = r7.hasNext();
                            if (r0 == 0) goto L_0x0153;
                        L_0x011c:
                            r0 = r7.next();
                            r1 = r0;
                            r1 = (com.tencent.mm.plugin.webview.modelcache.e.c) r1;
                            r0 = r1.tzY;
                            r2 = com.tencent.mm.plugin.webview.ui.tools.jsapi.h.Bw(r0);
                            r3 = r1.tzZ;
                            r0 = r8.fNe;
                            r4 = 3;
                            if (r0 != r4) goto L_0x014f;
                        L_0x0130:
                            r0 = "publicCache";
                        L_0x0133:
                            r4 = "batch download fail";
                            r2.z(r3, r0, r4);
                            r0 = com.tencent.mm.plugin.webview.modelcache.q.a.tAC;
                            r0 = r0.tAs;
                            r1 = r1.tzY;
                            r2 = r8.appId;
                            r3 = r8.fNc;
                            r4 = r8.fNd;
                            r5 = r8.fNe;
                            r6 = r8.url;
                            r0.a(r1, r2, r3, r4, r5, r6);
                            goto L_0x0116;
                        L_0x014f:
                            r0 = "cache";
                            goto L_0x0133;
                        L_0x0153:
                            r0 = 0;
                        L_0x0154:
                            if (r0 != 0) goto L_0x036c;
                        L_0x0156:
                            r0 = 8;
                            com.tencent.mm.plugin.webview.modelcache.m.fj(r0);
                            goto L_0x0004;
                        L_0x015d:
                            r0 = r8.url;
                            r4 = com.tencent.mm.plugin.webview.modelcache.p.Pf(r0);
                            r6 = com.tencent.mm.plugin.webview.modelcache.q.a.tAC;
                            r1 = r8.appId;
                            r2 = r8.fNc;
                            r3 = r8.fNe;
                            r5 = r8.fNd;
                            r0 = com.tencent.mm.sdk.platformtools.bi.oN(r1);
                            if (r0 != 0) goto L_0x0181;
                        L_0x0175:
                            r0 = com.tencent.mm.sdk.platformtools.bi.oN(r2);
                            if (r0 != 0) goto L_0x0181;
                        L_0x017b:
                            r0 = com.tencent.mm.sdk.platformtools.bi.oN(r4);
                            if (r0 == 0) goto L_0x01fe;
                        L_0x0181:
                            r0 = "MicroMsg.WebViewCacheWorkerManager";
                            r3 = "getWebViewCacheWriter, invalid params | appId = %s, domain = %s, mainURL = %s";
                            r5 = 3;
                            r5 = new java.lang.Object[r5];
                            r6 = 0;
                            r5[r6] = r1;
                            r1 = 1;
                            r5[r1] = r2;
                            r1 = 2;
                            r5[r1] = r4;
                            com.tencent.mm.sdk.platformtools.x.e(r0, r3, r5);
                            r0 = 0;
                            r3 = r0;
                        L_0x0198:
                            r0 = 0;
                            if (r3 == 0) goto L_0x01b4;
                        L_0x019b:
                            r0 = r8.filePath;
                            r4 = r8.version;
                            r5 = r8.aBD;
                            r1 = com.tencent.mm.sdk.platformtools.bi.oN(r0);
                            if (r1 == 0) goto L_0x0233;
                        L_0x01a7:
                            r0 = "MicroMsg.WebViewCacheResWriter";
                            r1 = "writeRes with filePath, filePath is null or nil";
                            com.tencent.mm.sdk.platformtools.x.e(r0, r1);
                            r0 = -1;
                        L_0x01b1:
                            if (r0 != 0) goto L_0x0349;
                        L_0x01b3:
                            r0 = 1;
                        L_0x01b4:
                            if (r0 != 0) goto L_0x0369;
                        L_0x01b6:
                            r0 = com.tencent.mm.sdk.platformtools.bi.cC(r9);
                            if (r0 != 0) goto L_0x0366;
                        L_0x01bc:
                            r7 = r9.iterator();
                        L_0x01c0:
                            r0 = r7.hasNext();
                            if (r0 == 0) goto L_0x0366;
                        L_0x01c6:
                            r0 = r7.next();
                            r1 = r0;
                            r1 = (com.tencent.mm.plugin.webview.modelcache.e.c) r1;
                            r0 = r1.tzY;
                            r2 = com.tencent.mm.plugin.webview.ui.tools.jsapi.h.Bw(r0);
                            r3 = r1.tzZ;
                            r0 = r8.fNe;
                            r4 = 3;
                            if (r0 != r4) goto L_0x034c;
                        L_0x01da:
                            r0 = "publicCache";
                        L_0x01dd:
                            r4 = "batch save fail";
                            r2.z(r3, r0, r4);
                            r0 = r8.fNe;
                            r2 = 1;
                            if (r0 != r2) goto L_0x0351;
                        L_0x01e8:
                            r0 = com.tencent.mm.plugin.webview.modelcache.q.a.tAC;
                            r0 = r0.tAs;
                            r1 = r1.tzY;
                            r2 = r8.appId;
                            r3 = r8.fNc;
                            r4 = r8.fNd;
                            r5 = r8.fNe;
                            r6 = r8.url;
                            r0.a(r1, r2, r3, r4, r5, r6);
                            goto L_0x01c0;
                        L_0x01fe:
                            r0 = "%s_%s_%s_%s";
                            r7 = 4;
                            r7 = new java.lang.Object[r7];
                            r10 = 0;
                            r7[r10] = r1;
                            r10 = 1;
                            r7[r10] = r2;
                            r10 = 2;
                            r11 = java.lang.Integer.valueOf(r3);
                            r7[r10] = r11;
                            r10 = 3;
                            r7[r10] = r4;
                            r0 = java.lang.String.format(r0, r7);
                            r7 = r0.hashCode();
                            r0 = r6.tAq;
                            r0 = r0.get(r7);
                            r0 = (com.tencent.mm.plugin.webview.modelcache.l) r0;
                            if (r0 != 0) goto L_0x0230;
                        L_0x0226:
                            r0 = new com.tencent.mm.plugin.webview.modelcache.l;
                            r0.<init>(r1, r2, r3, r4, r5);
                            r1 = r6.tAq;
                            r1.put(r7, r0);
                        L_0x0230:
                            r3 = r0;
                            goto L_0x0198;
                        L_0x0233:
                            r1 = com.tencent.mm.a.e.bO(r0);
                            if (r1 != 0) goto L_0x0245;
                        L_0x0239:
                            r0 = "MicroMsg.WebViewCacheResWriter";
                            r1 = "writeRes with filePath, file not exists";
                            com.tencent.mm.sdk.platformtools.x.e(r0, r1);
                            r0 = -1;
                            goto L_0x01b1;
                        L_0x0245:
                            r1 = com.tencent.mm.a.e.bN(r0);
                            if (r1 > 0) goto L_0x0257;
                        L_0x024b:
                            r0 = "MicroMsg.WebViewCacheResWriter";
                            r1 = "writeRes with filePath, file size = 0kb";
                            com.tencent.mm.sdk.platformtools.x.i(r0, r1);
                            r0 = 6;
                            goto L_0x01b1;
                        L_0x0257:
                            r1 = com.tencent.mm.sdk.platformtools.bi.oN(r4);
                            if (r1 == 0) goto L_0x0269;
                        L_0x025d:
                            r0 = "MicroMsg.WebViewCacheResWriter";
                            r1 = "writeRes with filePath, resVersion is null or nil, return";
                            com.tencent.mm.sdk.platformtools.x.e(r0, r1);
                            r0 = -1;
                            goto L_0x01b1;
                        L_0x0269:
                            r1 = r3.tAe;
                            if (r1 != 0) goto L_0x0279;
                        L_0x026d:
                            r0 = "MicroMsg.WebViewCacheResWriter";
                            r1 = "writeRes with filePath, appIdDir is null, return";
                            com.tencent.mm.sdk.platformtools.x.e(r0, r1);
                            r0 = -1;
                            goto L_0x01b1;
                        L_0x0279:
                            r2 = r3.tAe;
                            r6 = r3.fCV;
                            r1 = com.tencent.mm.sdk.platformtools.bi.oN(r0);
                            if (r1 != 0) goto L_0x0289;
                        L_0x0283:
                            r1 = com.tencent.mm.sdk.platformtools.bi.oN(r6);
                            if (r1 == 0) goto L_0x02c4;
                        L_0x0289:
                            r0 = 0;
                        L_0x028b:
                            r6 = com.tencent.mm.plugin.webview.modelcache.k.bRZ();
                            r7 = r3.appId;
                            r10 = r3.fNc;
                            r11 = r3.fNe;
                            r12 = r3.tAd;
                            r13 = r3.fNd;
                            r2 = r6.jbr;
                            if (r2 == 0) goto L_0x031c;
                        L_0x029d:
                            r2 = com.tencent.mm.sdk.platformtools.bi.oN(r7);
                            if (r2 != 0) goto L_0x02b5;
                        L_0x02a3:
                            r2 = com.tencent.mm.sdk.platformtools.bi.oN(r10);
                            if (r2 != 0) goto L_0x02b5;
                        L_0x02a9:
                            r2 = com.tencent.mm.sdk.platformtools.bi.oN(r12);
                            if (r2 != 0) goto L_0x02b5;
                        L_0x02af:
                            r2 = com.tencent.mm.sdk.platformtools.bi.oN(r13);
                            if (r2 == 0) goto L_0x02de;
                        L_0x02b5:
                            r2 = 0;
                        L_0x02b6:
                            if (r2 != 0) goto L_0x031e;
                        L_0x02b8:
                            r0 = "MicroMsg.WebViewCacheResWriter";
                            r1 = "writeRes with filePath, no db record stored";
                            com.tencent.mm.sdk.platformtools.x.e(r0, r1);
                            r0 = -1;
                            goto L_0x01b1;
                        L_0x02c4:
                            r0 = com.tencent.mm.modelsfs.FileOp.x(r0, r6);
                            r10 = 0;
                            r7 = (r0 > r10 ? 1 : (r0 == r10 ? 0 : -1));
                            if (r7 <= 0) goto L_0x028b;
                        L_0x02ce:
                            r7 = r2.path;
                            r6 = r6.startsWith(r7);
                            if (r6 == 0) goto L_0x028b;
                        L_0x02d6:
                            r6 = r2.tzP;
                            r2 = r2.appId;
                            com.tencent.mm.plugin.webview.modelcache.a.b.a(r6, r2, r0);
                            goto L_0x028b;
                        L_0x02de:
                            r2 = new com.tencent.mm.plugin.webview.modelcache.f;
                            r2.<init>();
                            r2.field_appId = r7;
                            r2.field_domain = r10;
                            r2.field_cacheType = r11;
                            r7 = com.tencent.mm.sdk.platformtools.ac.VF(r12);
                            r7 = r7.hashCode();
                            r2.field_urlMd5Hashcode = r7;
                            r2.field_packageId = r13;
                            r7 = 5;
                            r7 = new java.lang.String[r7];
                            r10 = 0;
                            r11 = "appId";
                            r7[r10] = r11;
                            r10 = 1;
                            r11 = "domain";
                            r7[r10] = r11;
                            r10 = 2;
                            r11 = "cacheType";
                            r7[r10] = r11;
                            r10 = 3;
                            r11 = "urlMd5Hashcode";
                            r7[r10] = r11;
                            r10 = 4;
                            r11 = "packageId";
                            r7[r10] = r11;
                            r6 = r6.b(r2, r7);
                            if (r6 != 0) goto L_0x02b6;
                        L_0x031c:
                            r2 = 0;
                            goto L_0x02b6;
                        L_0x031e:
                            r3 = r3.fCV;
                            r2.field_localPath = r3;
                            r2.field_version = r4;
                            r2.field_contentType = r5;
                            r3 = r2.field_localPath;
                            r3 = com.tencent.mm.plugin.webview.modelcache.p.Pi(r3);
                            r2.field_contentMd5 = r3;
                            r2.field_contentLength = r0;
                            r0 = com.tencent.mm.plugin.webview.modelcache.k.bRZ();
                            r0.b(r2);
                            r0 = "MicroMsg.WebViewCacheResWriter";
                            r1 = "writeRes with filePath, updated record = %s";
                            r3 = 1;
                            r3 = new java.lang.Object[r3];
                            r4 = 0;
                            r3[r4] = r2;
                            com.tencent.mm.sdk.platformtools.x.i(r0, r1, r3);
                            r0 = 0;
                            goto L_0x01b1;
                        L_0x0349:
                            r0 = 0;
                            goto L_0x01b4;
                        L_0x034c:
                            r0 = "cache";
                            goto L_0x01dd;
                        L_0x0351:
                            r0 = com.tencent.mm.plugin.webview.modelcache.q.a.tAC;
                            r0 = r0.tAs;
                            r1 = r1.tzY;
                            r2 = r8.appId;
                            r3 = r8.fNc;
                            r4 = r8.fNd;
                            r5 = r8.fNe;
                            r0.b(r1, r2, r3, r4, r5);
                            goto L_0x01c0;
                        L_0x0366:
                            r0 = 0;
                            goto L_0x0154;
                        L_0x0369:
                            r0 = 1;
                            goto L_0x0154;
                        L_0x036c:
                            r0 = r8.fNe;
                            r1 = 1;
                            if (r0 != r1) goto L_0x03af;
                        L_0x0371:
                            r0 = com.tencent.mm.sdk.platformtools.bi.cC(r9);
                            if (r0 != 0) goto L_0x0004;
                        L_0x0377:
                            r7 = r9.iterator();
                        L_0x037b:
                            r0 = r7.hasNext();
                            if (r0 == 0) goto L_0x0004;
                        L_0x0381:
                            r0 = r7.next();
                            r1 = r0;
                            r1 = (com.tencent.mm.plugin.webview.modelcache.e.c) r1;
                            r0 = r1.tzY;
                            r0 = com.tencent.mm.plugin.webview.ui.tools.jsapi.h.Bw(r0);
                            r2 = r1.tzZ;
                            r3 = "cache";
                            r4 = "ok";
                            r0.z(r2, r3, r4);
                            r0 = com.tencent.mm.plugin.webview.modelcache.q.a.tAC;
                            r0 = r0.tAs;
                            r1 = r1.tzY;
                            r2 = r8.appId;
                            r3 = r8.fNc;
                            r4 = r8.fNd;
                            r5 = r8.fNe;
                            r6 = r8.url;
                            r0.a(r1, r2, r3, r4, r5, r6);
                            goto L_0x037b;
                        L_0x03af:
                            r0 = com.tencent.mm.plugin.webview.modelcache.k.bRZ();
                            r1 = r8.appId;
                            r2 = r8.fNc;
                            r3 = r8.fNd;
                            r4 = r0.jbr;
                            if (r4 != 0) goto L_0x0419;
                        L_0x03bd:
                            r0 = 0;
                        L_0x03be:
                            r1 = com.tencent.mm.sdk.platformtools.bi.cC(r0);
                            if (r1 != 0) goto L_0x0004;
                        L_0x03c4:
                            r2 = 1;
                            r3 = r0.iterator();
                        L_0x03c9:
                            r0 = r3.hasNext();
                            if (r0 == 0) goto L_0x0496;
                        L_0x03cf:
                            r0 = r3.next();
                            r0 = (com.tencent.mm.plugin.webview.modelcache.f) r0;
                            if (r0 != 0) goto L_0x0461;
                        L_0x03d7:
                            r1 = 0;
                        L_0x03d8:
                            if (r1 != 0) goto L_0x03c9;
                        L_0x03da:
                            r0 = 0;
                        L_0x03db:
                            if (r0 == 0) goto L_0x0004;
                        L_0x03dd:
                            r0 = com.tencent.mm.sdk.platformtools.bi.cC(r9);
                            if (r0 != 0) goto L_0x0004;
                        L_0x03e3:
                            r6 = r9.iterator();
                        L_0x03e7:
                            r0 = r6.hasNext();
                            if (r0 == 0) goto L_0x0004;
                        L_0x03ed:
                            r0 = r6.next();
                            r1 = r0;
                            r1 = (com.tencent.mm.plugin.webview.modelcache.e.c) r1;
                            r0 = r1.tzY;
                            r0 = com.tencent.mm.plugin.webview.ui.tools.jsapi.h.Bw(r0);
                            r2 = r1.tzZ;
                            r3 = "cache";
                            r4 = "ok";
                            r0.z(r2, r3, r4);
                            r0 = com.tencent.mm.plugin.webview.modelcache.q.a.tAC;
                            r0 = r0.tAs;
                            r1 = r1.tzY;
                            r2 = r8.appId;
                            r3 = r8.fNc;
                            r4 = r8.fNd;
                            r5 = r8.fNe;
                            r0.b(r1, r2, r3, r4, r5);
                            goto L_0x03e7;
                        L_0x0419:
                            r4 = com.tencent.mm.sdk.platformtools.bi.oN(r1);
                            if (r4 != 0) goto L_0x042b;
                        L_0x041f:
                            r4 = com.tencent.mm.sdk.platformtools.bi.oN(r2);
                            if (r4 != 0) goto L_0x042b;
                        L_0x0425:
                            r4 = com.tencent.mm.sdk.platformtools.bi.oN(r3);
                            if (r4 == 0) goto L_0x042d;
                        L_0x042b:
                            r0 = 0;
                            goto L_0x03be;
                        L_0x042d:
                            r4 = "select * from %s where %s=? and %s=? and %s=?";
                            r5 = 4;
                            r5 = new java.lang.Object[r5];
                            r6 = 0;
                            r7 = "WebViewResourceCache";
                            r5[r6] = r7;
                            r6 = 1;
                            r7 = "appId";
                            r5[r6] = r7;
                            r6 = 2;
                            r7 = "domain";
                            r5[r6] = r7;
                            r6 = 3;
                            r7 = "packageId";
                            r5[r6] = r7;
                            r4 = java.lang.String.format(r4, r5);
                            r5 = 3;
                            r5 = new java.lang.String[r5];
                            r6 = 0;
                            r5[r6] = r1;
                            r1 = 1;
                            r5[r1] = r2;
                            r1 = 2;
                            r5[r1] = r3;
                            r0 = r0.n(r4, r5);
                            goto L_0x03be;
                        L_0x0461:
                            r1 = r0.field_contentMd5;
                            r1 = com.tencent.mm.sdk.platformtools.bi.oN(r1);
                            if (r1 != 0) goto L_0x0494;
                        L_0x0469:
                            r1 = r0.field_localPath;
                            r1 = com.tencent.mm.plugin.webview.modelcache.p.Pi(r1);
                            r1 = com.tencent.mm.sdk.platformtools.bi.oM(r1);
                            r4 = r0.field_contentMd5;
                            r1 = r1.equals(r4);
                            if (r1 == 0) goto L_0x0494;
                        L_0x047b:
                            r1 = 1;
                        L_0x047c:
                            r4 = "MicroMsg.WebViewCacheUtils";
                            r5 = "isCacheResValid, cacheRes = %s, ret = %b";
                            r6 = 2;
                            r6 = new java.lang.Object[r6];
                            r7 = 0;
                            r6[r7] = r0;
                            r0 = 1;
                            r7 = java.lang.Boolean.valueOf(r1);
                            r6[r0] = r7;
                            com.tencent.mm.sdk.platformtools.x.d(r4, r5, r6);
                            goto L_0x03d8;
                        L_0x0494:
                            r1 = 0;
                            goto L_0x047c;
                        L_0x0496:
                            r0 = r2;
                            goto L_0x03db;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.modelcache.q.1.1.run():void");
                        }
                    });
                }
                return false;
            }
        };
        this.tAo = new c<lw>() {
            {
                this.xmG = lw.class.getName().hashCode();
            }

            public final /* bridge */ /* synthetic */ boolean a(b bVar) {
                return false;
            }
        };
        this.tAq = new SparseArray();
        this.tAr = new c();
        this.tAs = new e();
        this.jXz = new Object();
        this.tAt = new byte[0];
        this.tAu = new SparseArray();
    }

    public final void release(boolean z) {
        for (int i = 0; i < this.tAq.size(); i++) {
            this.tAq.valueAt(i);
        }
        this.tAq.clear();
        a.clearCache();
        if (this.hoG != null) {
            synchronized (this.jXz) {
                if (this.hoG == null) {
                } else if (z) {
                    this.hoG.oFY.quit();
                } else {
                    final ah ahVar = this.hoG;
                    this.hoG.F(new Runnable() {
                        public final void run() {
                            Looper.myQueue().addIdleHandler(new IdleHandler() {
                                public final boolean queueIdle() {
                                    if (VERSION.SDK_INT >= 18) {
                                        ahVar.oFY.getLooper().quitSafely();
                                    } else {
                                        ahVar.oFY.getLooper().quit();
                                    }
                                    return false;
                                }
                            });
                        }
                    });
                    this.hoG = null;
                }
            }
        }
    }

    public final ah Dt() {
        if (this.hoG == null) {
            synchronized (this.jXz) {
                if (this.hoG == null) {
                    this.hoG = new ah("WebViewCacheWorkerManager#WorkerThread") {
                        public final int F(final Runnable runnable) {
                            return super.F(new Runnable() {
                                public final void run() {
                                    if ((Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId() ? 1 : null) == null && Process.getThreadPriority(Process.myTid()) != 10) {
                                        Process.setThreadPriority(10);
                                    }
                                    if (runnable != null) {
                                        runnable.run();
                                    }
                                }
                            });
                        }
                    };
                }
            }
        }
        return this.hoG;
    }

    public final void AI(int i) {
        if (as.Hp()) {
            try {
                Set set;
                a.tAC.tAs.AF(i);
                synchronized (this.tAt) {
                    set = (Set) this.tAu.get(i);
                }
                if (set == null) {
                    return;
                }
                if (set.size() > 0) {
                    Iterator it = set.iterator();
                    while (it.hasNext()) {
                        it.next();
                        if (this.tAp == null) {
                            this.tAp = new i();
                        }
                        i iVar = this.tAp;
                    }
                }
            } catch (Exception e) {
                x.e("MicroMsg.WebViewCacheWorkerManager", "onWebViewUIDestroy, accHasReady, but occurred exception = %s", e);
            }
        }
    }
}
