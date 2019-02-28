package com.tencent.mm.plugin.sns.model;

import android.os.Message;
import com.tencent.mm.ad.b;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.a.qc;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.appbrand.jsapi.bio.face.JsApiCheckIsSupportFaceDetect;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.g.c;
import com.tencent.mm.plugin.sns.storage.j;
import com.tencent.mm.protocal.ad;
import com.tencent.mm.protocal.c.ako;
import com.tencent.mm.protocal.c.bes;
import com.tencent.mm.protocal.c.bko;
import com.tencent.mm.protocal.c.bkp;
import com.tencent.mm.protocal.c.blf;
import com.tencent.mm.protocal.c.blx;
import com.tencent.mm.protocal.c.bly;
import com.tencent.mm.protocal.c.ot;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.an;
import com.tencent.mm.y.q;
import java.util.LinkedList;
import java.util.List;
import org.xwalk.core.R;

public final class t extends k implements com.tencent.mm.network.k {
    private static List<an> raq = new LinkedList();
    private static c ras;
    private static boolean rat = true;
    private String gAM = "";
    b gLB;
    e gLE;
    private a rar = new a();

    class a {
        LinkedList<ot> mwu;
        ag mwv = new ag() {
            public final void handleMessage(Message message) {
                if (a.this.mwu == null || a.this.mwu.isEmpty()) {
                    k kVar = t.this;
                    bly bly = (bly) kVar.gLB.hnR.hnY;
                    blx blx = (blx) kVar.gLB.hnQ.hnY;
                    byte[] g = ad.g(blx.vYE.wRm.toByteArray(), bly.vYE.wRm.toByteArray());
                    if (g != null && g.length > 0) {
                        g.Dr();
                        g.Dq().Db().set(8195, bi.bA(g));
                    }
                    blx.vYE.bl(g);
                    if ((bly.vWu & blx.vYD) == 0) {
                        kVar.gLE.a(0, 0, "", kVar);
                        return;
                    } else {
                        kVar.a(kVar.hok, kVar.gLE);
                        return;
                    }
                }
                final ot otVar = (ot) a.this.mwu.getFirst();
                x.d("MicroMsg.NetSceneNewSyncAlbum", "cmdId = " + otVar.wet);
                a.this.mwu.removeFirst();
                switch (otVar.wet) {
                    case R.styleable.AppCompatTheme_actionDropDownStyle /*45*/:
                        ae.bvP().post(new Runnable() {
                            public final void run() {
                                if (!t.this.a(otVar, a.this.mwv)) {
                                    a.this.mwv.sendEmptyMessage(0);
                                }
                            }
                        });
                        return;
                    case 46:
                        ae.bvP().post(new Runnable() {
                            public final void run() {
                                if (!t.this.b(otVar, a.this.mwv)) {
                                    a.this.mwv.sendEmptyMessage(0);
                                }
                            }
                        });
                        return;
                    default:
                        return;
                }
            }
        };

        a() {
        }
    }

    public t() {
        com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
        aVar.hnT = new blx();
        aVar.hnU = new bly();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnssync";
        aVar.hnS = JsApiCheckIsSupportFaceDetect.CTRL_INDEX;
        aVar.hnV = 102;
        aVar.hnW = 1000000102;
        this.gLB = aVar.Kf();
        ((blx) this.gLB.hnQ.hnY).vYD = 256;
        this.gAM = q.FY();
        if (rat) {
            long currentTimeMillis = System.currentTimeMillis();
            StringBuilder stringBuilder = new StringBuilder();
            g.Dr();
            String stringBuilder2 = stringBuilder.append(g.Dq().cachePath).append("ad_1100007").toString();
            x.i("MicroMsg.NetSceneNewSyncAlbum", "filepath to list  " + stringBuilder2);
            byte[] d = FileOp.d(stringBuilder2, 0, -1);
            if (d != null) {
                try {
                    ras = (c) new c().aH(d);
                    x.i("MicroMsg.NetSceneNewSyncAlbum", "fileToList " + (System.currentTimeMillis() - currentTimeMillis));
                    if (ras == null) {
                        x.i("MicroMsg.NetSceneNewSyncAlbum", "igNoreAbTestId parser error");
                    } else {
                        x.i("MicroMsg.NetSceneNewSyncAlbum", "igNoreAbTestId size " + ras.rgM.size());
                    }
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", e, "", new Object[0]);
                    FileOp.deleteFile(stringBuilder2);
                }
            }
            rat = false;
        }
    }

    protected final int Bo() {
        return 10;
    }

    protected final int a(com.tencent.mm.network.q qVar) {
        return b.hoz;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        g.Dr();
        byte[] Wj = bi.Wj(bi.oM((String) g.Dq().Db().get(8195, null)));
        bes bes = new bes();
        bes.bl(Wj);
        ((blx) this.gLB.hnQ.hnY).vYE = bes;
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public static void ey(long j) {
        if (ras == null) {
            ras = new c();
        }
        ras.rgM.add(Long.valueOf(j));
    }

    public static void ez(long j) {
        if (ras != null) {
            ras.rgM.remove(Long.valueOf(j));
        }
    }

    public static boolean eA(long j) {
        if (ras != null && ras.rgM.contains(Long.valueOf(j))) {
            return true;
        }
        return false;
    }

    public static void bvA() {
        if (ras != null) {
            long currentTimeMillis = System.currentTimeMillis();
            StringBuilder stringBuilder = new StringBuilder();
            g.Dr();
            String stringBuilder2 = stringBuilder.append(g.Dq().cachePath).append("ad_1100007").toString();
            x.i("MicroMsg.NetSceneNewSyncAlbum", "listToFile to list  " + stringBuilder2);
            try {
                byte[] toByteArray = ras.toByteArray();
                com.tencent.mm.a.e.b(stringBuilder2, toByteArray, toByteArray.length);
                x.i("MicroMsg.NetSceneNewSyncAlbum", "listTofile " + (System.currentTimeMillis() - currentTimeMillis) + " igNoreAbTestId " + ras.rgM.size());
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", e, "listToFile failed: " + stringBuilder2, new Object[0]);
            }
        }
    }

    public final boolean Kj() {
        return true;
    }

    public final int getType() {
        return JsApiCheckIsSupportFaceDetect.CTRL_INDEX;
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneNewSyncAlbum", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        if (i2 == 0 && i3 == 0) {
            bly bly = (bly) ((b) qVar).hnR.hnY;
            LinkedList linkedList = bly.vYH.kyB;
            if (linkedList == null || linkedList.size() <= 0) {
                if (!(bly.vYE == null || bly.vYE.wRm == null)) {
                    byte[] g = ad.g(((blx) ((b) qVar).hnQ.hnY).vYE.wRm.toByteArray(), bly.vYE.wRm.toByteArray());
                    if (g != null && g.length > 0) {
                        g.Dr();
                        g.Dq().Db().set(8195, bi.bA(g));
                    }
                }
                this.gLE.a(i2, i3, str, this);
                return;
            }
            x.d("MicroMsg.NetSceneNewSyncAlbum", "cmlList size:" + linkedList.size());
            a aVar = this.rar;
            aVar.mwu = linkedList;
            aVar.mwv.sendEmptyMessage(0);
            return;
        }
        this.gLE.a(i2, i3, str, this);
    }

    public final boolean a(ot otVar, final ag agVar) {
        try {
            final blf blf = (blf) new blf().aH(otVar.weu.wRm.toByteArray());
            String str = new String(blf.wUN.wRm.toByteArray());
            boolean z = str.indexOf("<contentStyle><![CDATA[1]]></contentStyle>") >= 0 || str.indexOf("<contentStyle>1</contentStyle>") >= 0;
            x.i("MicroMsg.NetSceneNewSyncAlbum", "snsSync " + blf.vWS + " " + i.er(blf.vWS) + " isPhoto " + z);
            if (z) {
                String er = i.er(blf.vWS);
                com.tencent.mm.plugin.sns.storage.k LV = ae.bwj().LV(blf.vPp);
                if (bi.oN(LV.field_newerIds)) {
                    ae.bwj().et(blf.vPp, er);
                } else {
                    String[] split = LV.field_newerIds.split(",");
                    z = true;
                    for (Object equals : split) {
                        if (er.equals(equals)) {
                            z = false;
                        }
                    }
                    int i = 0;
                    String str2 = er;
                    while (i < 2 && i < split.length && z) {
                        str2 = str2 + "," + split[i];
                        i++;
                    }
                    x.d("MicroMsg.NetSceneNewSyncAlbum", "snsync newerIds " + blf.vWS + " S: " + er + " list " + LV.field_newerIds + " newer " + str2);
                    if (z) {
                        ae.bwj().et(blf.vPp, str2);
                    }
                }
            }
            if (ae.bwf().eM(blf.vWS)) {
                x.i("MicroMsg.NetSceneNewSyncAlbum", "this item has in your sns pass it");
                return false;
            }
            com.tencent.mm.sdk.b.a.xmy.m(new qc());
            ae.aOA().post(new Runnable() {
                public final void run() {
                    if (!blf.vPp.equals(t.this.gAM)) {
                        g.Dr();
                        if (g.Do().CF()) {
                            g.Dr();
                            String str = (String) g.Dq().Db().get(68377, null);
                            g.Dr();
                            if (!(bi.a((Integer) g.Dq().Db().get(68400, null), 0) == blf.pgR && (bi.oN(str) || str.equals(blf.vPp)))) {
                                g.Dr();
                                g.Dq().Db().set(68377, blf.vPp);
                                g.Dr();
                                g.Dq().Db().set(68400, Integer.valueOf(blf.pgR));
                                g.Dr();
                                g.Dq().Db().set(68418, i.er(blf.vWS));
                            }
                            for (an Ha : t.raq) {
                                Ha.Ha();
                            }
                        } else {
                            x.e("MicroMsg.NetSceneNewSyncAlbum", "mmcore has not set uin!!");
                            return;
                        }
                    }
                    agVar.sendEmptyMessage(0);
                }
            });
            return true;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", e, "", new Object[0]);
            return false;
        }
    }

    public final boolean b(ot otVar, final ag agVar) {
        try {
            boolean z;
            bkp bkp = (bkp) new bkp().aH(otVar.weu.wRm.toByteArray());
            long j = bkp.vWS;
            long j2 = bkp.wUt;
            final bko bko = bkp.wUu;
            String str = bkp.vNF;
            if (str == null) {
                str = "";
            }
            x.i("MicroMsg.NetSceneNewSyncAlbum", "process action " + bko.kzz + " " + j + " " + str);
            com.tencent.mm.sdk.e.c c;
            boolean a;
            j bwk;
            String str2;
            switch (bko.kzz) {
                case 9:
                    c = ae.bwk().c(j, (long) bko.wUn, bko.kzz);
                    if (c != null) {
                        c.byJ();
                        a = ae.bwk().a(c.xrR, c);
                        ai.b(j, bkp);
                        x.i("MicroMsg.NetSceneNewSyncAlbum", " setdel flag  " + a);
                        break;
                    }
                    break;
                case 10:
                    c = ae.bwk().c(j, bko.wUq, bko.kzz);
                    if (c != null) {
                        c.byJ();
                        a = ae.bwk().a(c.xrR, c);
                        ai.b(j, bkp);
                        x.i("MicroMsg.NetSceneNewSyncAlbum", " setdel ad flag  " + a);
                        break;
                    }
                    break;
                case 11:
                    bwk = ae.bwk();
                    str2 = " update SnsComment set commentflag = commentflag | 2 where snsID = " + j;
                    x.i("MicroMsg.SnsCommentStorage", "set sns del " + str2);
                    x.i("MicroMsg.NetSceneNewSyncAlbum", "processSnsDelAction " + bwk.hiZ.fD("SnsComment", str2));
                    break;
                case 12:
                    bwk = ae.bwk();
                    str2 = " update SnsComment set commentflag = commentflag | 2 where snsID = " + j + " and talker = " + bi.oL(bko.wNo);
                    x.i("MicroMsg.SnsCommentStorage", "set sns del  by username " + str2);
                    x.i("MicroMsg.NetSceneNewSyncAlbum", "processSnsDelAction " + bwk.hiZ.fD("SnsComment", str2));
                    break;
                case 13:
                    b(bkp, bko, j, j2, str);
                    break;
                case 14:
                    c(bkp, bko, j, j2, str);
                    break;
                default:
                    a(bkp, bko, j, j2, str);
                    break;
            }
            if ((bko.wUs & 2) == 0) {
                z = true;
            } else {
                z = false;
            }
            ae.aOA().post(new Runnable() {
                public final void run() {
                    if (z) {
                        for (an anVar : t.raq) {
                            x.i("MicroMsg.NetSceneNewSyncAlbum", "notify list ");
                            anVar.GZ();
                        }
                    }
                    agVar.sendEmptyMessage(0);
                }
            });
            return true;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", e, "", new Object[0]);
            return false;
        }
    }

    public static boolean eB(long j) {
        try {
            return a.a(j, null, bi.getInt(com.tencent.mm.j.g.Af().getValue("SnsAdNotifyLimit"), 0), bi.getInt(com.tencent.mm.j.g.Af().getValue("SnsAdNotifyLikeTimeLimit"), 0), bi.getInt(com.tencent.mm.j.g.Af().getValue("SnsAdNotifyCommentTimeLimit"), 0), false);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", e, "", new Object[0]);
            return true;
        }
    }

    private static boolean a(bkp bkp, bko bko, long j, long j2, String str) {
        try {
            boolean a;
            int i = bi.getInt(com.tencent.mm.j.g.Af().getValue("SnsAdNotifyLimit"), 0);
            int i2 = bi.getInt(com.tencent.mm.j.g.Af().getValue("SnsAdNotifyLikeTimeLimit"), 0);
            int i3 = bi.getInt(com.tencent.mm.j.g.Af().getValue("SnsAdNotifyCommentTimeLimit"), 0);
            if ((i > 0 || i2 > 0 || i3 > 0) && (bko.kzz == 8 || bko.kzz == 7)) {
                a = a.a(j, bkp, i, i2, i3, true);
                if (eA(j)) {
                    x.i("MicroMsg.NetSceneNewSyncAlbum", "user open notify off");
                }
                if (!a) {
                    x.i("MicroMsg.NetSceneNewSyncAlbum", "pass the comment clientId " + str + " snsId: " + j + " " + bko.wUq + " " + bko.wUn + " actionLimit:" + i + " actionLikeTimeLimit:" + i2 + " actionCommentTimeLimit:" + i3);
                    if (a.a(j, bkp)) {
                        return false;
                    }
                    x.i("MicroMsg.NetSceneNewSyncAlbum", "pass comment ID  " + bkp.wUu.wUq);
                    return false;
                }
            }
            x.i("MicroMsg.NetSceneNewSyncAlbum", "processNormalAction clientId " + str + " snsId: " + j + " " + bko.wUq + " " + bko.wUn + " actionLimit: " + i);
            if (ae.bwk().a(j, bko.wNo, bko.pgR, str)) {
                return false;
            }
            bko bko2 = bkp.wUv;
            com.tencent.mm.sdk.e.c iVar = new com.tencent.mm.plugin.sns.storage.i();
            iVar.field_snsID = j;
            iVar.field_parentID = j2;
            iVar.field_createTime = bko.pgR;
            iVar.field_talker = bko.wNo;
            iVar.field_type = bko.kzz;
            iVar.field_curActionBuf = bko.toByteArray();
            iVar.field_refActionBuf = bko2.toByteArray();
            iVar.field_clientId = str;
            iVar.field_isSilence = (bko.wUs & 2) == 0 ? 0 : 1;
            if (bko.kzz == 8 || bko.kzz == 7) {
                iVar.field_commentSvrID = bko.wUq;
                if (!a.a(j, bkp)) {
                    x.i("MicroMsg.NetSceneNewSyncAlbum", "pass comment ID " + iVar.field_snsID + " " + iVar.field_commentSvrID);
                    return false;
                }
            }
            iVar.field_commentSvrID = (long) bko.wUn;
            if (!ai.a(j, bkp)) {
                return false;
            }
            ae.bwk().b(iVar);
            j bwk = ae.bwk();
            if ((bko.wUs & 2) != 0) {
                a = true;
            } else {
                a = false;
            }
            bwk.q(j, a);
            return true;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", e, "", new Object[0]);
            return false;
        }
    }

    private static boolean b(bkp bkp, bko bko, long j, long j2, String str) {
        try {
            x.i("MicroMsg.NetSceneNewSyncAlbum", "processHbAction clientId " + str + " snsId: " + j + " " + bko.wUq + " " + bko.wUn);
            if (com.tencent.mm.plugin.sns.lucky.a.g.buZ()) {
                if (ae.bwk().a(j, bko.wNo, bko.pgR, str)) {
                    return false;
                }
                bko bko2 = bkp.wUv;
                com.tencent.mm.sdk.e.c iVar = new com.tencent.mm.plugin.sns.storage.i();
                iVar.field_snsID = j;
                iVar.field_parentID = j2;
                iVar.field_createTime = bko.pgR;
                iVar.field_talker = bko.wNo;
                iVar.field_type = bko.kzz;
                iVar.field_curActionBuf = bko.toByteArray();
                iVar.field_refActionBuf = bko2.toByteArray();
                iVar.field_clientId = str;
                iVar.field_commentSvrID = (long) bko.wUn;
                x.i("MicroMsg.NetSceneNewSyncAlbum", "curAction.HBBuffer " + bko.wUr);
                ai.c(j, bkp);
                Hb();
                ae.bwk().b(iVar);
                return true;
            }
            x.i("MicroMsg.NetSceneNewSyncAlbum", "passed because close lucky");
            return false;
        } catch (Throwable e) {
            x.e("MicroMsg.NetSceneNewSyncAlbum", "error processHbAction " + e.getMessage());
            x.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", e, "", new Object[0]);
            return false;
        }
    }

    private static boolean c(bkp bkp, bko bko, long j, long j2, String str) {
        try {
            x.i("MicroMsg.NetSceneNewSyncAlbum", "processGrabHbAction clientId " + str + " snsId: " + j + " " + bko.wUq + " " + bko.wUn);
            if (ae.bwk().a(j, bko.wNo, bko.pgR, str)) {
                return false;
            }
            bko bko2 = bkp.wUv;
            com.tencent.mm.sdk.e.c iVar = new com.tencent.mm.plugin.sns.storage.i();
            iVar.field_snsID = j;
            iVar.field_parentID = j2;
            iVar.field_createTime = bko.pgR;
            iVar.field_talker = bko.wNo;
            iVar.field_type = bko.kzz;
            iVar.field_curActionBuf = bko.toByteArray();
            iVar.field_refActionBuf = bko2.toByteArray();
            iVar.field_clientId = str;
            iVar.field_commentSvrID = (long) bko.wUn;
            ako ako = new ako();
            x.i("MicroMsg.NetSceneNewSyncAlbum", "curAction.HBBuffer " + bko.wUr);
            ako.aH(n.a(bko.wUr));
            x.i("MicroMsg.NetSceneNewSyncAlbum", "hbbuffer  " + ako.fMM);
            ae.bwk().b(iVar);
            return true;
        } catch (Throwable e) {
            x.e("MicroMsg.NetSceneNewSyncAlbum", "error processHbAction " + e.getMessage());
            x.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", e, "", new Object[0]);
            return false;
        }
    }

    public static void bvB() {
        for (an anVar : raq) {
            if (anVar != null) {
                anVar.Hc();
            }
        }
    }

    private static void Hb() {
        for (an anVar : raq) {
            if (anVar != null) {
                anVar.Hb();
            }
        }
    }

    public static void a(an anVar) {
        if (!raq.contains(anVar)) {
            raq.add(anVar);
        }
    }

    public static void b(an anVar) {
        raq.remove(anVar);
    }
}
