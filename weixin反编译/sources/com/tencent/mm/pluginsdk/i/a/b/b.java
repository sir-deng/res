package com.tencent.mm.pluginsdk.i.a.b;

import android.os.Looper;
import com.tencent.mm.f.a.bc;
import com.tencent.mm.f.a.be;
import com.tencent.mm.f.a.lw;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.pluginsdk.i.a.d.d;
import com.tencent.mm.pluginsdk.i.a.d.g;
import com.tencent.mm.pluginsdk.i.a.d.h;
import com.tencent.mm.pluginsdk.i.a.d.k;
import com.tencent.mm.pluginsdk.i.a.d.l;
import com.tencent.mm.pluginsdk.i.a.d.o;
import com.tencent.mm.pluginsdk.i.a.d.q;
import com.tencent.mm.protocal.c.bed;
import com.tencent.mm.protocal.c.bjz;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.ar;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

public final class b {
    private final d tAG;
    private final Set<b> vmW;
    private final k vmX;

    private static final class c {
        private static final b vnr = new b();
    }

    /* renamed from: com.tencent.mm.pluginsdk.i.a.b.b$8 */
    class AnonymousClass8 implements Runnable {
        final /* synthetic */ String ieY;
        final /* synthetic */ int vmY;
        final /* synthetic */ int vmZ;
        final /* synthetic */ int vnm;
        final /* synthetic */ boolean vnn;

        AnonymousClass8(int i, int i2, String str, int i3, boolean z) {
            this.vmY = i;
            this.vmZ = i2;
            this.ieY = str;
            this.vnm = i3;
            this.vnn = z;
        }

        public final void run() {
            com.tencent.mm.sdk.b.b bcVar = new bc();
            bcVar.fqf.fqg = this.vmY;
            bcVar.fqf.fqh = this.vmZ;
            bcVar.fqf.filePath = this.ieY;
            bcVar.fqf.fqi = this.vnm;
            bcVar.fqf.fqj = this.vnn;
            com.tencent.mm.sdk.b.a.xmy.m(bcVar);
        }
    }

    public static final class a implements g {
        private final com.tencent.mm.y.bt.a tAf = new com.tencent.mm.y.bt.a() {
            public final void a(com.tencent.mm.ad.d.a aVar) {
                String a = n.a(aVar.hoa.vNO);
                if (bi.oN(a)) {
                    x.w("MicroMsg.ResDownloader.CheckResUpdateHelper", "msg content is null");
                } else {
                    e.ba(a, true);
                }
            }
        };
        private final com.tencent.mm.sdk.b.c vno = new com.tencent.mm.sdk.b.c<lw>() {
            {
                this.xmG = lw.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                if (com.tencent.mm.kernel.g.Do().CF()) {
                    com.tencent.mm.kernel.g.Do();
                    if (!com.tencent.mm.kernel.a.Cz()) {
                        long Wx = bi.Wx();
                        long a = bi.a((Long) com.tencent.mm.kernel.g.Dq().Db().get(com.tencent.mm.storage.w.a.USERINFO_RES_DOWNLOADER_CHECK_RES_UPDATE_INTERVAL_LONG, null), 0);
                        if (a != 0 && a < Wx) {
                            p.arC();
                        }
                    }
                }
                return false;
            }
        };
        private final h vnp = new h();

        public final void bSf() {
            com.tencent.mm.sdk.b.a.xmy.b(this.vno);
            ((com.tencent.mm.plugin.messenger.foundation.a.n) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.messenger.foundation.a.n.class)).getSysCmdMsgExtension().a("resourcemgr", this.tAf, true);
            com.tencent.mm.kernel.g.Dt().g(new Runnable() {
                public final void run() {
                    p.arC();
                }
            }, 10000);
        }

        public final void onAccountRelease() {
            com.tencent.mm.sdk.b.a.xmy.c(this.vno);
            ((com.tencent.mm.plugin.messenger.foundation.a.n) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.messenger.foundation.a.n.class)).getSysCmdMsgExtension().b("resourcemgr", this.tAf, true);
        }

        public final String aam() {
            return "CheckResUpdate";
        }

        public final com.tencent.mm.pluginsdk.i.a.d.m.a c(k kVar) {
            if (kVar instanceof c) {
                x.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "return CheckResUpdateNetworkRequestHandler");
                return new d((c) kVar);
            }
            x.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "get mismatch NetworkRequest type, return null");
            return null;
        }

        public final h bSg() {
            return this.vnp;
        }
    }

    public interface b {
        boolean bZY();
    }

    /* synthetic */ b(byte b) {
        this();
    }

    final Set<b> bZX() {
        Set<b> newSetFromMap;
        synchronized (this.vmW) {
            newSetFromMap = Collections.newSetFromMap(new android.support.v4.e.a(this.vmW.size()));
            for (b add : this.vmW) {
                newSetFromMap.add(add);
            }
        }
        return newSetFromMap;
    }

    public final void e(int i, int i2, int i3, boolean z) {
        final int i4 = i;
        final int i5 = i2;
        final int i6 = i3;
        final boolean z2 = z;
        a.voG.A(new Runnable() {
            public final void run() {
                q SB = a.voG.SB(i.eB(i4, i5));
                if (SB == null) {
                    return;
                }
                if (-1 == i6 || String.valueOf(i6).equals(SB.field_fileVersion)) {
                    SB.field_needRetry = !z2;
                    a.voG.g(SB);
                }
            }
        });
    }

    public final void ae(int i, int i2, int i3) {
        e(i, i2, i3, true);
    }

    private b() {
        this.vmW = Collections.newSetFromMap(new android.support.v4.e.a(i.vnz.length));
        this.vmX = new k();
        this.tAG = new d() {
            public final void a(String str, l lVar) {
                x.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "networkEventListener.onComplete, urlkey = " + str);
                q SB = a.voG.SB(str);
                if (SB != null) {
                    j.o(SB.field_reportId, 10);
                    j.o(SB.field_reportId, 15);
                    if ((!SB.field_fileCompress || SB.field_fileEncrypt) && SB.field_fileUpdated) {
                        j.a(SB.field_resType, SB.field_subType, SB.field_url, bi.getInt(SB.field_fileVersion, 0), SB.field_maxRetryTimes > SB.field_retryTimes ? com.tencent.mm.pluginsdk.i.a.b.j.a.vnN : com.tencent.mm.pluginsdk.i.a.b.j.a.vnL, true, bi.oM(SB.field_groupId2).equals("NewXml"), false, SB.field_sampleId);
                    }
                    if (SB.field_fileCompress || SB.field_fileEncrypt) {
                        x.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "networkEventListener, addDecryptRequest");
                        b.this.b(SB);
                        return;
                    }
                    com.tencent.mm.sdk.b.b bcVar = new bc();
                    bcVar.fqf.filePath = SB.field_filePath;
                    bcVar.fqf.fqj = SB.field_fileUpdated;
                    bcVar.fqf.fqi = bi.getInt(SB.field_fileVersion, 0);
                    bcVar.fqf.fqg = SB.field_resType;
                    bcVar.fqf.fqh = SB.field_subType;
                    com.tencent.mm.sdk.b.a.xmy.a(bcVar, Looper.getMainLooper());
                    SB.field_fileUpdated = false;
                    a.voG.g(SB);
                }
            }

            public final void b(String str, l lVar) {
                i.Sx(str);
                q SB = a.voG.SB(str);
                if (SB != null) {
                    boolean z = true;
                    if (!(lVar == null || lVar.vox == null)) {
                        if (lVar.vox instanceof com.tencent.mm.pluginsdk.i.a.c.a) {
                            j.o(SB.field_reportId, 7);
                            z = false;
                        } else if (lVar.vox instanceof com.tencent.mm.pluginsdk.i.a.c.c) {
                            j.o(SB.field_reportId, 16);
                            z = false;
                        }
                    }
                    if (z) {
                        j.o(SB.field_reportId, 11);
                    }
                    j.o(SB.field_reportId, 44);
                    j.a(SB.field_resType, SB.field_subType, SB.field_url, bi.getInt(SB.field_fileVersion, 0), com.tencent.mm.pluginsdk.i.a.b.j.a.vnM, false, "NewXml".equalsIgnoreCase(SB.field_groupId2), false, SB.field_sampleId);
                }
            }

            public final void Pj(String str) {
                o cap = a.voG;
                if (!(cap.jbr ? cap.voE.isDownloading(str) : false)) {
                    i.Sx(str);
                }
            }

            public final String aam() {
                return "CheckResUpdate";
            }
        };
        a.voG.a("CheckResUpdate", this.tAG);
    }

    public static void BZ(int i) {
        x.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "doCheck, resType = %d", Integer.valueOf(i));
        com.tencent.mm.kernel.g.Do();
        boolean CE = com.tencent.mm.kernel.a.CE();
        boolean equals = ar.hhz.H("login_user_name", "").equals("");
        if (CE || !equals) {
            com.tencent.mm.kernel.g.Dp().gRu.a(new m(i), 0);
            return;
        }
        x.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "doCheck, not login, skip");
    }

    public static String eA(int i, int i2) {
        q SB = a.voG.SB(i.eB(i, i2));
        if (SB == null) {
            x.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, %d.%d, get null info, return", Integer.valueOf(i), Integer.valueOf(i2));
            return null;
        }
        x.v("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, queried primeInfo { deleted = %b, filepath = %s, md5 = %s, compress = %b, encrypt = %b, originalMd5 = %s }", Boolean.valueOf(SB.field_deleted), SB.field_filePath, SB.field_md5, Boolean.valueOf(SB.field_fileCompress), Boolean.valueOf(SB.field_fileEncrypt), SB.field_originalMd5);
        if (SB.field_fileCompress || SB.field_fileEncrypt) {
            String str;
            if (SB.field_fileCompress) {
                str = SB.field_filePath + ".decompressed";
            } else if (SB.field_fileEncrypt) {
                str = SB.field_filePath + ".decrypted";
            } else {
                str = null;
            }
            if (bi.oN(str)) {
                x.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, %d.%d, need decrypt or decompress, filePath invalid return null ", Integer.valueOf(i), Integer.valueOf(i2));
                return null;
            } else if (bi.oN(SB.field_originalMd5) || !bi.oM(com.tencent.mm.a.g.bV(str)).equals(SB.field_originalMd5)) {
                x.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, %d.%d, need decrypt, return null ", Integer.valueOf(i), Integer.valueOf(i2));
                return null;
            } else {
                x.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, %d.%d, need decrypt or decompress, file valid, ret = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                return str;
            }
        } else if (SB.field_deleted || bi.oN(SB.field_filePath) || !bi.oM(com.tencent.mm.a.g.bV(SB.field_filePath)).equals(SB.field_md5)) {
            x.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, %d.%d, not need decrypt and file invalid, return null", Integer.valueOf(i), Integer.valueOf(i2));
            return null;
        } else {
            x.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, %d.%d, not need decrypt and file valid, return path(%s)", Integer.valueOf(i), Integer.valueOf(i2), SB.field_filePath);
            return SB.field_filePath;
        }
    }

    final void b(q qVar) {
        x.d("MicroMsg.ResDownloader.CheckResUpdateHelper", "addDecryptRequest, urlkey = " + qVar.field_urlKey);
        k kVar = this.vmX;
        if (kVar.Sz(qVar.field_urlKey)) {
            x.i("MicroMsg.ResDownloader.CheckResUpdate.DecryptExecutor", "URLKey(%s) is already decrypting, skip repeated task");
        } else {
            kVar.a(a.a(qVar));
        }
    }

    final void a(int i, bed bed, boolean z) {
        final String eB = i.eB(i, bed.wMK);
        if (bed.wQK == null) {
            x.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "onReceiveDeleteOperation(), resource.Info = null");
            return;
        }
        x.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "receive delete-op, fromNewXml(%b), %d.%d, file version (%d)", Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(bed.wMK), Integer.valueOf(bed.wQK.wQU));
        j.o((long) bed.wQM, 3);
        final int i2 = bed.wQK.wQU;
        final int i3 = bed.wMK;
        final int i4 = bed.wQM;
        final String str = bed.wQN;
        final int i5 = i;
        final boolean z2 = z;
        a.voG.A(new Runnable() {
            public final void run() {
                q SB = a.voG.SB(eB);
                int i = i5;
                int i2 = i3;
                int i3 = i2;
                int i4 = i4;
                String str = str;
                boolean z = z2;
                x.i("MicroMsg.ResDownloader.CheckResUpdate.DoDeleteLogic", "record " + SB);
                x.i("MicroMsg.ResDownloader.CheckResUpdate.DoDeleteLogic", "delete version %d", Integer.valueOf(i3));
                boolean z2 = false;
                if (SB == null) {
                    j.o((long) i4, 47);
                    j.o((long) i4, 22);
                    z2 = true;
                } else if (bi.getInt(SB.field_fileVersion, 0) <= i3) {
                    z2 = true;
                } else {
                    j.o(SB.field_reportId, 47);
                    j.o(SB.field_reportId, 22);
                }
                String eB = i.eB(i, i2);
                String Sw = i.Sw(eB);
                x.i("MicroMsg.ResDownloader.CheckResUpdate.DoDeleteLogic", "doDelete(%b), filePath(%s)", Boolean.valueOf(z2), Sw);
                if (z2) {
                    a.voG.SD(eB);
                    c.vnr.f(i, i2, 2, z);
                    if ((((com.tencent.mm.pluginsdk.i.a.e.a.SF(Sw) & 1) & com.tencent.mm.pluginsdk.i.a.e.a.SF(Sw + ".decompressed")) & com.tencent.mm.pluginsdk.i.a.e.a.SF(Sw + ".decrypted")) != 0) {
                        if (SB != null) {
                            j.o(SB.field_reportId, 21);
                            j.a(SB.field_resType, SB.field_subType, i3, z, SB.field_sampleId);
                        }
                    } else if (SB != null) {
                        j.o(SB.field_reportId, 22);
                        j.o(SB.field_reportId, 47);
                    }
                    if (SB == null) {
                        q qVar = new q();
                        qVar.field_urlKey = eB;
                        qVar.field_resType = i;
                        qVar.field_subType = i2;
                        qVar.field_deleted = true;
                        qVar.field_fileVersion = String.valueOf(i3);
                        qVar.field_reportId = (long) i4;
                        qVar.field_sampleId = str;
                        a.voG.g(qVar);
                        return;
                    }
                    SB.field_deleted = true;
                    SB.field_fileVersion = String.valueOf(i3);
                    a.voG.g(SB);
                }
            }
        });
    }

    final void b(int i, bed bed, boolean z) {
        String eB = i.eB(i, bed.wMK);
        if (bed.wQK == null) {
            x.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "onReceiveCacheOperation(), resource.Info = null, return");
            return;
        }
        String str;
        String str2 = "MicroMsg.ResDownloader.CheckResUpdateHelper";
        String str3 = "receive cache-op, urlKey = %d.%d,  fromNewXml = %b, file version = %d, eccSignatureList.size = %s, reportId = %s, sampleId = %s, url = %s, data = %s";
        Object[] objArr = new Object[9];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(bed.wMK);
        objArr[2] = Boolean.valueOf(z);
        objArr[3] = Integer.valueOf(bed.wQK.wQU);
        if (bed.wQK.wQW == null) {
            str = "null";
        } else {
            str = String.valueOf(bed.wQK.wQW.size());
        }
        objArr[4] = str;
        objArr[5] = Integer.valueOf(bed.wQM);
        objArr[6] = bed.wQN;
        objArr[7] = bed.wQK.nlE;
        objArr[8] = bed.wQK.wgG;
        x.i(str2, str3, objArr);
        if (bed.wQK.wQW != null) {
            Iterator it = bed.wQK.wQW.iterator();
            while (it.hasNext()) {
                bjz bjz = (bjz) it.next();
                x.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "cache-op, sigInfo: version(%d), signature(%s) ", Integer.valueOf(bjz.kzy), bjz.wTT.cec());
            }
        }
        j.fv((long) bed.wQM);
        if (!z) {
            j.o((long) bed.wQM, 1);
        }
        if (bed.vXe != 0 && ((long) bed.vXe) <= bi.Wx()) {
            x.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "recourse(%s) is expired before do download, expireTime = %d, fileVersion = %d", eB, Integer.valueOf(bed.vXe), Integer.valueOf(bed.wQK.wQU));
            j.o((long) bed.wQM, 14);
            j.o((long) bed.wQM, 44);
            j.a(i, bed.wMK, bed.wQK.nlE, bed.wQK.wQU, com.tencent.mm.pluginsdk.i.a.b.j.a.vnP, false, z, false, bed.wQN);
        } else if (bi.oN(bed.wQK.nlE) && bed.wQK.wgG == null) {
            x.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "cache-op, invalid cache operation, url and data is null or nil, skip");
        } else {
            com.tencent.mm.pluginsdk.i.a.d.a.a aVar = new com.tencent.mm.pluginsdk.i.a.b.g.a(bed.wQK.nlE);
            aVar.vmK = eB;
            aVar.fqg = i;
            aVar.fqh = bed.wMK;
            aVar.hSg = (long) bed.vXe;
            aVar.fqi = bed.wQK.wQU;
            aVar.frM = bed.wQK.wgY;
            aVar.vnt = a.Cb(bed.wQK.wQV);
            aVar.vnu = a.Ca(bed.wQK.wQV);
            aVar.vmS = (long) bed.wQM;
            aVar.vmT = bed.wQN;
            aVar.vmU = bed.wQO > 0 ? bed.wQO : 3;
            aVar.vnv = bed.vnv;
            aVar.networkType = bed.wQP;
            aVar.fqn = z;
            if (!bi.cC(bed.wQK.wQW)) {
                aVar.vmP = ((bjz) bed.wQK.wQW.get(0)).wTT.oz;
            }
            if (!(bed.wQL == null || bi.oN(bed.wQL.wQT))) {
                aVar.vmN = bed.wQL.wQT;
                aVar.vmO = bed.wQL.wQS;
            }
            if (bed.wQK.wgG != null && bed.wQK.wgG.oz.length > 0) {
                aVar.vns = bed.wQK.wgG.toByteArray();
            }
            aVar.vmQ = bed.wQK.wQX;
            aVar.fileSize = (long) bed.wQK.wfl;
            aVar.priority = bed.wyO;
            final g gVar = new g(aVar.url, aVar.vmK, aVar.fqi, aVar.networkType, aVar.vmU, aVar.hSg, aVar.frM, aVar.fqg, aVar.fqh, aVar.vmS, aVar.vmT, aVar.vmP, aVar.vmQ, aVar.vnt, aVar.vnu, aVar.vmN, aVar.vmO, aVar.vnv, aVar.vns, aVar.fileSize, aVar.fqn, aVar.fqj, aVar.priority);
            x.d("MicroMsg.ResDownloader.CheckResUpdateHelper", "request (%s)", gVar.toString());
            final String str4 = eB;
            a.voG.A(new Runnable() {
                public final void run() {
                    a.a(a.voG.SB(str4), gVar);
                }
            });
        }
    }

    final void a(int i, bed bed, boolean z, boolean z2) {
        final String eB = i.eB(i, bed.wMK);
        if (bed.wQL == null) {
            x.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "onReceiveDecryptOperation(), resource.Key = null");
        } else if (bi.oN(bed.wQL.wQT)) {
            x.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "encryptKey null, skip");
        } else {
            x.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "receive decrypt-op, fromNewXml(%b), %d.%d, key version (%d)", Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(bed.wMK), Integer.valueOf(bed.wQL.wQS));
            x.d("MicroMsg.ResDownloader.CheckResUpdateHelper", "key (%s)", bed.wQL.wQT);
            j.o((long) bed.wQM, 4);
            final String str = bed.wQK.wQX;
            final String str2 = bed.wQL.wQT;
            final int i2 = bed.wQL.wQS;
            final int i3 = bed.wQM;
            final String str3 = bed.wQN;
            final boolean z3 = z2;
            Runnable anonymousClass6 = new Runnable() {
                public final void run() {
                    q SB = a.voG.SB(eB);
                    String str = str;
                    String str2 = str2;
                    int i = i2;
                    int i2 = i3;
                    String str3 = str3;
                    boolean z = z3;
                    if (SB == null) {
                        SB = new q();
                        SB.field_keyVersion = i;
                        SB.field_encryptKey = str2;
                        SB.field_reportId = (long) i2;
                        SB.field_sampleId = str3;
                        SB.field_originalMd5 = str;
                        a.voG.g(SB);
                        j.o((long) i2, 51);
                        j.o((long) i2, 45);
                    } else if (SB.field_keyVersion < i) {
                        SB.field_keyVersion = i;
                        SB.field_encryptKey = str2;
                        SB.field_reportId = (long) i2;
                        SB.field_sampleId = str3;
                        if (bi.oN(SB.field_originalMd5)) {
                            SB.field_originalMd5 = str;
                        }
                        a.voG.g(SB);
                        b.a(SB, true, z);
                    } else if (z && SB.field_keyVersion == i) {
                        b.a(SB, true, true);
                    }
                }
            };
            if (z2) {
                anonymousClass6.run();
            } else {
                a.voG.A(anonymousClass6);
            }
        }
    }

    final void b(int i, int i2, String str, int i3) {
        final int i4 = i;
        final int i5 = i2;
        final String str2 = str;
        final int i6 = i3;
        a.voG.A(new Runnable() {
            public final void run() {
                b bVar = b.this;
                int i = i4;
                int i2 = i5;
                String str = str2;
                int i3 = i6;
                q SB = a.voG.SB(i.eB(i, i2));
                if (SB != null) {
                    boolean z = SB.field_fileUpdated;
                    SB.field_fileUpdated = false;
                    a.voG.g(SB);
                    if (i3 != bi.getInt(SB.field_fileVersion, 0)) {
                        return;
                    }
                    if (a.voG.handler == null) {
                        x.f("MicroMsg.ResDownloader.CheckResUpdateHelper", "sendEventFileCached: get null eventThread ");
                    } else {
                        a.voG.handler.post(new AnonymousClass8(i, i2, str, i3, z));
                    }
                }
            }
        });
    }

    final void f(int i, int i2, int i3, boolean z) {
        if (a.voG.handler == null) {
            x.f("MicroMsg.ResDownloader.CheckResUpdateHelper", "sendEventPreOperation: get null eventThread ");
            return;
        }
        final int i4 = i3;
        final int i5 = i;
        final int i6 = i2;
        final boolean z2 = z;
        a.voG.handler.post(new Runnable() {
            public final void run() {
                com.tencent.mm.sdk.b.b beVar = new be();
                beVar.fqo.fql = i4;
                beVar.fqo.fqg = i5;
                beVar.fqo.fqh = i6;
                beVar.fqo.fqn = z2;
                com.tencent.mm.sdk.b.a.xmy.m(beVar);
            }
        });
    }
}
