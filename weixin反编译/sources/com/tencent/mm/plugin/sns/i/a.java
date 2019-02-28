package com.tencent.mm.plugin.sns.i;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.f.a.cg;
import com.tencent.mm.f.a.fw;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sight.base.d;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.ai;
import com.tencent.mm.plugin.sns.model.am;
import com.tencent.mm.plugin.sns.model.ap;
import com.tencent.mm.plugin.sns.storage.b;
import com.tencent.mm.plugin.sns.storage.h;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.bpb;
import com.tencent.mm.protocal.c.uz;
import com.tencent.mm.protocal.c.vc;
import com.tencent.mm.protocal.c.vn;
import com.tencent.mm.protocal.c.vt;
import com.tencent.mm.protocal.c.wc;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.q;
import java.util.LinkedList;
import java.util.Map;

public final class a {
    public static boolean a(cg cgVar, m mVar) {
        if (mVar == null) {
            x.w("MicroMsg.Sns.GetFavDataSource", "fill sight favorite event fail, event is null or tlObj is null");
            cgVar.frk.frq = j.efu;
            return false;
        }
        vn vnVar = new vn();
        vt vtVar = new vt();
        bpb byF = mVar.byF();
        are are = (are) byF.wYj.wfh.get(0);
        if (mVar.xD(32) && byF.wYj.wfg == 15) {
            byF.wYo.hff = mVar.byD().rfQ;
            byF.wYo.hfg = byF.nMq;
        }
        String er = i.er(mVar.field_snsId);
        er = String.format("%s#%s", new Object[]{er, are.nMq});
        vtVar.UN(mVar.field_userName);
        vtVar.UO(q.FY());
        vtVar.Dl(2);
        vtVar.fD(bi.Wy());
        vtVar.US(mVar.byG());
        vtVar.UP(er);
        vnVar.a(vtVar);
        uz uzVar = new uz();
        uzVar.Un(er);
        String r = am.r(ae.getAccSnsPath(), are.nMq);
        String j = i.j(are);
        String e = i.e(are);
        if (bi.oN(ap.a(mVar.bza(), are))) {
            x.w("MicroMsg.Sns.GetFavDataSource", "this sight had no download finish, can not favorite.");
            cgVar.frk.frq = j.qPz;
            return false;
        } else if (FileOp.bO(r + j)) {
            int i;
            int i2;
            if (!FileOp.bO(r + e)) {
                int i3 = 320;
                i = 240;
                if (are.wES != null && are.wES.wFG > 0.0f && are.wES.wFF > 0.0f) {
                    i3 = (int) are.wES.wFF;
                    i = (int) are.wES.wFG;
                }
                Bitmap U = d.U(r + j, i3, i);
                if (U == null) {
                    x.i("MicroMsg.Sns.GetFavDataSource", "fav error on get thumb:" + FileOp.bO(r + e));
                    cgVar.frk.frq = j.qPz;
                    return false;
                }
                try {
                    com.tencent.mm.sdk.platformtools.d.a(U, 60, CompressFormat.JPEG, r + e, true);
                } catch (Throwable e2) {
                    x.printErrStackTrace("MicroMsg.Sns.GetFavDataSource", e2, "save bmp error %s", e2.getMessage());
                    x.i("MicroMsg.Sns.GetFavDataSource", "fav error on save thumb:" + FileOp.bO(r + e));
                    cgVar.frk.frq = j.qPz;
                    return false;
                }
            }
            uzVar.Uj(r + j);
            uzVar.Uk(r + e);
            uzVar.TV(bi.oN(are.wFa) ? byF.wYg : are.wFa);
            uzVar.Uu(byF.rRR);
            if (!bi.oN(byF.rRR)) {
                Map y = bj.y(byF.rRR, "adxml");
                if (y.size() > 0) {
                    uzVar.TV(bi.aD((String) y.get(".adxml.adCanvasInfo.shareTitle"), ""));
                    uzVar.TW(bi.aD((String) y.get(".adxml.adCanvasInfo.shareDesc"), ""));
                }
            }
            if (mVar.xD(32)) {
                b byB = mVar.byB();
                vc vcVar = new vc();
                vcVar.hfb = bi.oN(are.wFa) ? byF.wYg : are.wFa;
                vcVar.wlG = are.rTh;
                vcVar.heZ = are.wEW;
                vcVar.hff = byF.wYo.hff;
                vcVar.hfg = byF.wYo.hfg;
                if (bi.oN(vcVar.hfg)) {
                    vcVar.hfg = byF.nMq;
                }
                vcVar.hfe = bi.oN(are.wEZ) ? are.wEP : are.wEZ;
                if (byB != null && byB.rkG == 0) {
                    vcVar.hfd = byB.rkI;
                    vcVar.hfc = byB.rkH;
                }
                uzVar.a(vcVar);
                i = 15;
                i2 = 16;
            } else {
                i2 = 4;
                i = 4;
            }
            uzVar.Dc(i);
            com.tencent.mm.plugin.sight.base.a JX = d.JX(uzVar.wkl);
            if (JX != null) {
                uzVar.Db(JX.btk());
            } else {
                uzVar.Db(1);
            }
            LinkedList linkedList = new LinkedList();
            linkedList.add(uzVar);
            vnVar.aw(linkedList);
            cgVar.frk.frm = vnVar;
            cgVar.frk.type = i2;
            a(uzVar, mVar);
            x.i("MicroMsg.Sns.GetFavDataSource", "fill event Info sight dataType %d eventType %d", Integer.valueOf(i), Integer.valueOf(i2));
            return true;
        } else {
            x.i("MicroMsg.Sns.GetFavDataSource", "fav error sight: " + FileOp.bO(r + j) + " thumb:" + FileOp.bO(r + e));
            cgVar.frk.frq = j.qPz;
            return false;
        }
    }

    public static boolean a(cg cgVar, String str, String str2) {
        if (cgVar == null || !u.Mm(str2) || str == null) {
            x.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or snsId error or url is null");
            if (cgVar != null) {
                cgVar.frk.frq = j.efu;
            }
            return false;
        } else if (ae.bvO()) {
            x.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, sns core is invalid");
            cgVar.frk.frq = j.qPA;
            return false;
        } else {
            m LR = h.LR(str2);
            if (LR == null) {
                x.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo is null");
                cgVar.frk.frq = j.efv;
                return false;
            } else if (LR.byF().wYj != null && LR.byF().wYj.wfg == 26) {
                return a(cgVar, str2);
            } else {
                wc wcVar;
                String str3 = "0";
                are a = ai.a(LR, 0);
                if (a != null) {
                    str3 = a.nMq;
                }
                String er = i.er(LR.field_snsId);
                str3 = String.format("%s#%s", new Object[]{er, str3});
                vn vnVar = new vn();
                vt vtVar = new vt();
                x.i("MicroMsg.Sns.GetFavDataSource", "fav sns url, from %s", LR.field_userName);
                vtVar.UN(LR.field_userName);
                vtVar.UO(q.FY());
                vtVar.Dl(2);
                vtVar.fD(((long) LR.field_createTime) * 1000);
                vtVar.US(LR.byG());
                vtVar.UP(str3);
                vtVar.UU(str);
                uz uzVar = new uz();
                uzVar.Un(str3);
                if (a != null) {
                    str3 = am.r(ae.getAccSnsPath(), a.nMq) + i.e(a);
                    if (FileOp.bO(str3)) {
                        uzVar.Uk(str3);
                    } else {
                        uzVar.lA(true);
                        uzVar.Ue(a.wEP);
                        wcVar = new wc();
                        wcVar.Vd(a.wEP);
                        vnVar.b(wcVar);
                    }
                } else {
                    uzVar.lA(true);
                }
                uzVar.Dc(5);
                bpb byF = LR.byF();
                uzVar.TV(byF.wYj.fpg);
                uzVar.TW(byF.wYj.nkL);
                uzVar.Uu(byF.rRR);
                if (!bi.oN(byF.rRR)) {
                    Map y = bj.y(byF.rRR, "adxml");
                    if (y.size() > 0) {
                        uzVar.TV(bi.aD((String) y.get(".adxml.adCanvasInfo.shareTitle"), ""));
                        uzVar.TW(bi.aD((String) y.get(".adxml.adCanvasInfo.shareDesc"), ""));
                    }
                }
                a(uzVar, byF);
                uzVar.lz(true);
                vnVar.wlY.add(uzVar);
                wcVar = new wc();
                wcVar.Dn(byF.hcR);
                vnVar.b(wcVar);
                vnVar.a(vtVar);
                cgVar.frk.frm = vnVar;
                cgVar.frk.desc = byF.wYj.fpg;
                cgVar.frk.type = 5;
                return true;
            }
        }
    }

    public static boolean a(cg cgVar, String str, CharSequence charSequence) {
        if (u.Mn(str) || charSequence == null) {
            x.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or snsId error or text is null");
            cgVar.frk.frq = j.efu;
            return false;
        } else if (ae.bvO()) {
            x.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, sns core is invalid");
            cgVar.frk.frq = j.qPA;
            return false;
        } else {
            m LR = ae.bwf().LR(str);
            if (LR == null) {
                x.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo is null");
                cgVar.frk.frq = j.efv;
                return false;
            } else if (0 == LR.field_snsId) {
                x.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo.field_snsId is 0");
                cgVar.frk.frq = j.eft;
                return false;
            } else {
                String er = i.er(LR.field_snsId);
                er = String.format("%s#0", new Object[]{er});
                vn vnVar = new vn();
                vt vtVar = new vt();
                x.i("MicroMsg.Sns.GetFavDataSource", "fav sns text, from %s", LR.field_userName);
                vtVar.UN(LR.field_userName);
                vtVar.UO(q.FY());
                vtVar.Dl(2);
                vtVar.fD(((long) LR.field_createTime) * 1000);
                vtVar.US(LR.byG());
                vtVar.UP(er);
                vnVar.a(vtVar);
                cgVar.frk.frm = vnVar;
                cgVar.frk.desc = charSequence.toString();
                cgVar.frk.type = 1;
                return true;
            }
        }
    }

    public static boolean a(cg cgVar, m mVar, String str) {
        if (bi.oN(str)) {
            x.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or media id is null");
            cgVar.frk.frq = j.efu;
            return false;
        } else if (mVar == null) {
            x.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo is null");
            cgVar.frk.frq = j.efv;
            return false;
        } else {
            are a = ai.a(mVar, str);
            if (a == null) {
                x.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, mediaObj is null");
                cgVar.frk.frq = j.efv;
                return false;
            }
            String er = i.er(mVar.field_snsId);
            er = String.format("%s#%s", new Object[]{er, str});
            vn vnVar = new vn();
            vt vtVar = new vt();
            uz uzVar = new uz();
            x.i("MicroMsg.Sns.GetFavDataSource", "fav sns image, from %s", mVar.field_userName);
            vtVar.UN(mVar.field_userName);
            vtVar.UO(q.FY());
            vtVar.Dl(2);
            vtVar.fD(((long) mVar.field_createTime) * 1000);
            vtVar.US(mVar.byG());
            vtVar.UP(er);
            uzVar.Un(er);
            uzVar.Uj(am.r(ae.getAccSnsPath(), str) + i.l(a));
            if (mVar.byF() != null) {
                uzVar.Uu(mVar.byF().rRR);
                if (!bi.oN(mVar.byF().rRR)) {
                    Map y = bj.y(mVar.byF().rRR, "adxml");
                    if (y.size() > 0) {
                        uzVar.TV(bi.aD((String) y.get(".adxml.adCanvasInfo.shareTitle"), ""));
                        uzVar.TW(bi.aD((String) y.get(".adxml.adCanvasInfo.shareDesc"), ""));
                    }
                }
            }
            a(uzVar, mVar);
            er = am.r(ae.getAccSnsPath(), a.nMq) + i.e(a);
            if (FileOp.bO(uzVar.wkl) || !mVar.field_userName.endsWith(ae.bvL())) {
                if (FileOp.bO(er)) {
                    uzVar.Uk(er);
                } else {
                    uzVar.lA(true);
                    uzVar.Ue(a.wEP);
                    wc wcVar = new wc();
                    wcVar.Vd(a.wEP);
                    vnVar.b(wcVar);
                }
                uzVar.Dc(2);
                vnVar.wlY.add(uzVar);
                vnVar.a(vtVar);
                cgVar.frk.frm = vnVar;
                cgVar.frk.type = 2;
                return true;
            }
            x.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, mediaObj is null");
            cgVar.frk.frq = j.efv;
            return false;
        }
    }

    private static void a(uz uzVar, bpb bpb) {
        if (uzVar != null && bpb != null && !bi.oN(bpb.rzD)) {
            uzVar.Ut(bpb.rzD);
        }
    }

    public static void a(uz uzVar, m mVar) {
        if (mVar != null) {
            a(uzVar, mVar.byF());
        }
    }

    public static boolean a(cg cgVar, String str) {
        int i = 0;
        if (cgVar == null || !u.Mm(str)) {
            x.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or snsId error or url is null");
            if (cgVar == null) {
                return false;
            }
            cgVar.frk.frq = j.efu;
            return false;
        } else if (ae.bvO()) {
            x.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, sns core is invalid");
            cgVar.frk.frq = j.qPA;
            return false;
        } else {
            m LR = h.LR(str);
            if (LR == null) {
                x.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo is null");
                cgVar.frk.frq = j.efv;
                return false;
            }
            String str2 = "0";
            are a = ai.a(LR, 0);
            if (a != null) {
                str2 = a.nMq;
            }
            str2 = String.format("%s#%s", new Object[]{i.er(LR.field_snsId), str2});
            vt vtVar = new vt();
            bpb byF = LR.byF();
            if (byF == null) {
                x.i("MicroMsg.Sns.GetFavDataSource", "fav NoteLink, tlObj is null , return");
                return false;
            }
            x.i("MicroMsg.Sns.GetFavDataSource", "fav NoteLink, from %s", LR.field_userName);
            vtVar.UN(LR.field_userName);
            vtVar.UO(q.FY());
            vtVar.Dl(2);
            vtVar.fD(((long) LR.field_createTime) * 1000);
            vtVar.US(LR.byG());
            vtVar.UP(str2);
            com.tencent.mm.sdk.b.b fwVar = new fw();
            fwVar.fwl.type = 30;
            fwVar.fwl.fws = 4;
            fwVar.fwl.desc = byF.wYj.wfj;
            com.tencent.mm.sdk.b.a.xmy.m(fwVar);
            fwVar.fwl.frm.a(vtVar);
            cgVar.frk.frm = fwVar.fwl.frm;
            if (cgVar.frk.frm != null) {
                LinkedList linkedList = cgVar.frk.frm.wlY;
                if (linkedList != null) {
                    while (i < linkedList.size()) {
                        uz uzVar = (uz) linkedList.get(i);
                        if (uzVar != null) {
                            uzVar.lz(true);
                            uzVar.lA(true);
                        }
                        i++;
                    }
                }
            }
            cgVar.frk.desc = byF.wYj.fpg;
            cgVar.frk.type = 18;
            return true;
        }
    }
}
