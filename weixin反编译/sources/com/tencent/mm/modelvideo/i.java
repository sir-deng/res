package com.tencent.mm.modelvideo;

import com.tencent.mm.f.b.cg;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvideo.f.a;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.w;
import com.tencent.mm.y.bb;
import com.tencent.mm.y.bb.b;
import com.tencent.mm.y.m;
import com.tencent.mm.y.s;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class i implements a {
    LinkedList<au> hWp = new LinkedList();
    long hWq = 0;
    private int hWr = 0;
    private int hWs = 0;
    public boolean hWt = false;
    public boolean hWu = false;
    private boolean hWv = false;
    private boolean hWw = false;
    f hWx = null;
    long hWy = 0;

    static /* synthetic */ boolean a(i iVar) {
        long Wz = bi.Wz();
        x.i("MicroMsg.PreloadVideoService", "%d start to delete expired file limit[%d] status[%d] expiredTime[%d] isC2C[%b]", Integer.valueOf(iVar.hashCode()), Integer.valueOf(1), Integer.valueOf(111), Long.valueOf(bi.Wx() - (((long) ((com.tencent.mm.plugin.zero.b.a) g.h(com.tencent.mm.plugin.zero.b.a.class)).Af().getInt("PreLoadVideoExpiredTime", 1)) * 86400)), Boolean.valueOf(true));
        List<r> a = o.Ub().a(111, 1, r0);
        if (a == null || a.isEmpty()) {
            return false;
        }
        int i = 0;
        for (r rVar : a) {
            if (rVar != null) {
                o.Ub();
                String nx = s.nx(rVar.getFileName());
                if (!bi.oN(nx)) {
                    File file = new File(nx);
                    if (file.exists()) {
                        long length = file.length();
                        x.i("MicroMsg.PreloadVideoService", "%s file[%d %d] lastmodifytime[%d] path[%s]", rVar.getFileName(), Long.valueOf(length), Integer.valueOf(rVar.fAP), Long.valueOf(rVar.hXt), nx);
                        if (length > 0 && length <= ((long) rVar.fAP)) {
                            file.delete();
                            i++;
                        }
                    }
                }
                int i2 = i;
                rVar.fAP = 0;
                rVar.fEo = 1;
                t.e(rVar);
                i = i2;
            }
        }
        com.tencent.mm.plugin.report.service.g.pWK.a(354, 144, (long) i, false);
        x.i("MicroMsg.PreloadVideoService", "%d delete expire file size %d delete count %d costTime[%d]", Integer.valueOf(iVar.hashCode()), Integer.valueOf(a.size()), Integer.valueOf(i), Long.valueOf(bi.bB(Wz)));
        return false;
    }

    public final void stopDownload() {
        x.i("MicroMsg.PreloadVideoService", "%d stop download", Integer.valueOf(hashCode()));
        g.Dt().F(new Runnable() {
            public final void run() {
                if (i.this.hWx != null) {
                    i.this.hWx.stop();
                }
                i.this.hWx = null;
            }
        });
    }

    public final void TU() {
        g.Dt().F(new Runnable() {
            public final void run() {
                if (!o.Ug().fmk && i.this.hWx == null && !i.this.hWt && !i.this.hWu) {
                    if (i.this.hWp.isEmpty()) {
                        Object obj;
                        i iVar = i.this;
                        if (bi.bz(iVar.hWy) > 600) {
                            iVar.hWy = bi.Wx();
                            obj = 1;
                        } else {
                            obj = null;
                        }
                        if (obj != null) {
                            i.a(i.this);
                            return;
                        }
                        return;
                    }
                    cg cgVar = null;
                    PBool pBool = new PBool();
                    synchronized (i.this.hWp) {
                        Iterator it = i.this.hWp.iterator();
                        while (it.hasNext()) {
                            Object obj2;
                            cgVar = (au) it.next();
                            i iVar2 = i.this;
                            if (cgVar == null) {
                                pBool.value = true;
                                obj2 = null;
                            } else {
                                r nJ = t.nJ(cgVar.field_imgPath);
                                if (nJ != null && nJ.Uq()) {
                                    x.i("MicroMsg.PreloadVideoService", "%d it finish download all file[%s], needn't preload", Integer.valueOf(iVar2.hashCode()), nJ.getFileName());
                                    Map y = bj.y(nJ.Un(), "msg");
                                    String str = (String) y.get(".msg.videomsg.$newmd5");
                                    String str2 = (String) y.get(".msg.videomsg.$cdnvideourl");
                                    boolean eX = s.eX(nJ.Uk());
                                    iVar2.a(str, eX ? 2 : 1, (long) nJ.hmZ, nJ.Ul(), nJ.Uk(), s.eX(nJ.Uk()) ? m.gn(nJ.Uk()) : 0, str2, "", "");
                                    com.tencent.mm.plugin.report.service.g.pWK.a(354, 146, 1, false);
                                    if (eX) {
                                        com.tencent.mm.plugin.report.service.g.pWK.a(354, 126, 1, false);
                                    } else {
                                        com.tencent.mm.plugin.report.service.g.pWK.a(354, 125, 1, false);
                                    }
                                    pBool.value = true;
                                    obj2 = null;
                                } else if (bi.bA(cgVar.field_createTime) >= 86400000) {
                                    x.i("MicroMsg.PreloadVideoService", "%d more than 1 day don't preload", Integer.valueOf(iVar2.hashCode()));
                                    pBool.value = true;
                                    obj2 = null;
                                } else {
                                    if (iVar2.cb(true)) {
                                        x.i("MicroMsg.PreloadVideoService", "%d check c2c video preload timestamp[%d]", Integer.valueOf(iVar2.hashCode()), Long.valueOf(iVar2.hWq));
                                    } else {
                                        x.i("MicroMsg.PreloadVideoService", "%d check c2c video preload %d %s", Integer.valueOf(iVar2.hashCode()), Long.valueOf(cgVar.field_msgId), cgVar.gkD);
                                        b hW = bb.hW(cgVar.gkD);
                                        if (hW == null) {
                                            pBool.value = true;
                                            obj2 = null;
                                        } else if (hW.hiB <= 0) {
                                            pBool.value = true;
                                            obj2 = null;
                                        } else if (!com.tencent.mm.modelcontrol.b.kN(hW.hiD)) {
                                            int i;
                                            if (ao.isWifi(ad.getContext())) {
                                                i = hW.hiC & 1;
                                            } else if (ao.is4G(ad.getContext())) {
                                                i = hW.hiC & 2;
                                            } else if (ao.is3G(ad.getContext())) {
                                                i = hW.hiC & 4;
                                            } else {
                                                pBool.value = false;
                                                obj2 = null;
                                            }
                                            if (i > 0) {
                                                pBool.value = false;
                                                obj2 = 1;
                                            }
                                        }
                                    }
                                    pBool.value = false;
                                    obj2 = null;
                                }
                            }
                            if (pBool.value) {
                                it.remove();
                            }
                            if (obj2 != null) {
                                break;
                            }
                            cgVar = null;
                        }
                    }
                    if (cgVar != null) {
                        i.this.hWx = new f(cgVar.field_msgId);
                        x.i("MicroMsg.PreloadVideoService", "%s start to preload video[%s]", Integer.valueOf(i.this.hashCode()), i.this.hWx.TT());
                        if (i.this.hWx.a(i.this) < 0) {
                            x.w("MicroMsg.PreloadVideoService", "%s curr preload task do scene error.", Integer.valueOf(i.this.hashCode()));
                            synchronized (i.this.hWp) {
                                Iterator it2 = i.this.hWp.iterator();
                                while (it2.hasNext()) {
                                    au auVar = (au) it2.next();
                                    if (auVar != null && auVar.field_msgId == i.this.hWx.frh) {
                                        x.i("MicroMsg.PreloadVideoService", "%d find msg[%d], remove now", Integer.valueOf(i.this.hashCode()), Long.valueOf(i.this.hWx.frh));
                                        it2.remove();
                                    }
                                }
                            }
                            i.this.hWx = null;
                        }
                    }
                }
            }
        });
    }

    public final void a(final f fVar, boolean z, int i, int i2) {
        if (fVar == null) {
            x.e("MicroMsg.PreloadVideoService", "%d on preload finish but scene is null?", Integer.valueOf(hashCode()));
            return;
        }
        if (this.hWx != fVar) {
            x.w("MicroMsg.PreloadVideoService", "%d on preload finish, but scene callback not same object.", Integer.valueOf(hashCode()));
        }
        x.i("MicroMsg.PreloadVideoService", "%d preload video[%s] finish success[%b] range[%d, %d]", Integer.valueOf(hashCode()), fVar.TT(), Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2));
        g.Dt().F(new Runnable() {
            public final void run() {
                long j = fVar.frh;
                synchronized (i.this.hWp) {
                    Iterator it = i.this.hWp.iterator();
                    while (it.hasNext()) {
                        au auVar = (au) it.next();
                        if (auVar != null && auVar.field_msgId == j) {
                            x.i("MicroMsg.PreloadVideoService", "%d find msg[%d], remove now", Integer.valueOf(i.this.hashCode()), Long.valueOf(j));
                            it.remove();
                        }
                    }
                }
                i.this.ca(true);
                if (i.this.hWx != null) {
                    i.this.hWx.hVY = null;
                }
                i.this.hWx = null;
                i.a(i.this);
                i.this.TU();
            }
        });
    }

    public final void ca(boolean z) {
        if (z) {
            this.hWr = ((Integer) g.Dq().Db().get(w.a.USERINFO_C2C_HAD_PRELOAD_COUNT_INT, Integer.valueOf(0))).intValue();
            this.hWr++;
            g.Dq().Db().a(w.a.USERINFO_C2C_HAD_PRELOAD_COUNT_INT, Integer.valueOf(this.hWr));
            return;
        }
        this.hWs = ((Integer) g.Dq().Db().get(w.a.USERINFO_SNS_HAD_PRELOAD_COUNT_INT, Integer.valueOf(0))).intValue();
        this.hWs++;
        g.Dq().Db().a(w.a.USERINFO_SNS_HAD_PRELOAD_COUNT_INT, Integer.valueOf(this.hWs));
    }

    public final boolean cb(boolean z) {
        int i;
        int i2;
        boolean z2;
        int i3 = 100;
        this.hWq = ((Long) g.Dq().Db().get(w.a.USERINFO_HAD_PRELOAD_TIME_LONG, Long.valueOf(-1))).longValue();
        if (bi.bA(this.hWq) >= 86400000) {
            this.hWq = bi.Wy();
            g.Dq().Db().a(w.a.USERINFO_HAD_PRELOAD_TIME_LONG, Long.valueOf(this.hWq));
            g.Dq().Db().a(w.a.USERINFO_C2C_HAD_PRELOAD_COUNT_INT, Integer.valueOf(0));
            g.Dq().Db().a(w.a.USERINFO_SNS_HAD_PRELOAD_COUNT_INT, Integer.valueOf(0));
            this.hWw = false;
            this.hWv = false;
        }
        this.hWr = ((Integer) g.Dq().Db().get(w.a.USERINFO_C2C_HAD_PRELOAD_COUNT_INT, Integer.valueOf(0))).intValue();
        this.hWs = ((Integer) g.Dq().Db().get(w.a.USERINFO_SNS_HAD_PRELOAD_COUNT_INT, Integer.valueOf(0))).intValue();
        if (z) {
            i = this.hWr;
            i2 = ((com.tencent.mm.plugin.zero.b.a) g.h(com.tencent.mm.plugin.zero.b.a.class)).Af().getInt("C2CMaxPreloadVideo", 100);
        } else {
            i = this.hWs;
            i2 = ((com.tencent.mm.plugin.zero.b.a) g.h(com.tencent.mm.plugin.zero.b.a.class)).Af().getInt("SnsMaxPreloadVideo", 100);
        }
        if (i2 > 0) {
            i3 = i2;
        }
        if (i >= i3) {
            z2 = true;
        } else {
            z2 = false;
        }
        x.i("MicroMsg.PreloadVideoService", "%d check more preload count result[%b] config[%d] hadPreloadCount[%d %d %d] ", Integer.valueOf(hashCode()), Boolean.valueOf(z2), Integer.valueOf(i3), Integer.valueOf(i), Integer.valueOf(this.hWr), Integer.valueOf(this.hWs));
        if (z2) {
            if (z) {
                if (!this.hWv) {
                    this.hWv = true;
                    com.tencent.mm.plugin.report.service.g.pWK.a(354, 127, 1, false);
                }
            } else if (!this.hWw) {
                this.hWw = true;
                com.tencent.mm.plugin.report.service.g.pWK.a(354, 128, 1, false);
            }
        }
        return z2;
    }

    public final void a(String str, int i, long j, String str2, String str3, int i2, String str4, String str5, String str6) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(bi.Wx()).append(",");
        stringBuffer.append(bi.Wx()).append(",");
        stringBuffer.append(0).append(",");
        stringBuffer.append(str).append(",");
        stringBuffer.append(i).append(",");
        stringBuffer.append(0).append(",");
        stringBuffer.append(j).append(",");
        stringBuffer.append(",");
        stringBuffer.append(str2).append(",");
        stringBuffer.append(str3).append(",");
        stringBuffer.append(i2).append(",");
        stringBuffer.append(str4).append(",");
        stringBuffer.append(str5).append(",");
        stringBuffer.append(str6);
        x.d("MicroMsg.PreloadVideoService", "%d rpt content[%s]", Integer.valueOf(hashCode()), stringBuffer.toString());
        com.tencent.mm.plugin.report.service.g.pWK.k(14499, r2);
    }
}
