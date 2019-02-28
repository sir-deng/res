package com.tencent.mm.plugin.favorite;

import com.tencent.mm.au.a.a;
import com.tencent.mm.f.a.fw;
import com.tencent.mm.f.a.fw.b;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.favorite.a.d;
import com.tencent.mm.plugin.favorite.a.i;
import com.tencent.mm.plugin.favorite.a.j;
import com.tencent.mm.plugin.favorite.a.r;
import com.tencent.mm.plugin.favorite.a.t;
import com.tencent.mm.plugin.favorite.ui.b.e;
import com.tencent.mm.protocal.c.uz;
import com.tencent.mm.protocal.c.vf;
import com.tencent.mm.protocal.c.vq;
import com.tencent.mm.protocal.c.vt;
import com.tencent.mm.protocal.c.wg;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class g extends c<fw> {
    public g() {
        this.xmG = fw.class.getName().hashCode();
    }

    private static boolean a(fw fwVar) {
        f dc;
        String[] a;
        List arrayList;
        b bVar;
        int intValue;
        f dd;
        switch (fwVar.fwl.type) {
            case 2:
                if (fwVar.fwl.fwn != null) {
                    File file = new File(j.h(fwVar.fwl.fwn));
                    if (file.exists()) {
                        fwVar.fwm.path = file.getAbsolutePath();
                    }
                    file = new File(j.i(fwVar.fwl.fwn));
                    if (file.exists()) {
                        fwVar.fwm.fwx = file.getAbsolutePath();
                        break;
                    }
                }
                break;
            case 4:
                dc = h.getFavItemInfoStorage().dc(fwVar.fwl.frf);
                if (!(dc == null || dc.field_tagProto.wmn == null)) {
                    fwVar.fwm.auX = new ArrayList();
                    fwVar.fwm.auX.addAll(dc.field_tagProto.wmn);
                    break;
                }
            case 6:
                h.getFavItemInfoStorage().c(fwVar.fwl.fwp);
                fwVar.fwm.ret = 0;
                break;
            case 7:
                h.getFavItemInfoStorage().j(fwVar.fwl.fwp);
                fwVar.fwm.ret = 0;
                break;
            case 8:
                fwVar.fwm.fwz = h.getFavItemInfoStorage().aIF();
                fwVar.fwm.ret = 0;
                break;
            case 9:
                dc = h.getFavItemInfoStorage().dc(fwVar.fwl.frf);
                fwVar.fwm.fwy = com.tencent.mm.pluginsdk.model.c.a(dc.field_type, dc.field_favProto, dc.field_tagProto);
                fwVar.fwm.ret = 0;
                break;
            case 10:
                e.a(fwVar.fwl.context, h.getFavItemInfoStorage().dc(fwVar.fwl.frf), fwVar.fwl.fww);
                fwVar.fwm.ret = 0;
                break;
            case 11:
                a = e.a(h.getFavItemInfoStorage().dc(fwVar.fwl.frf), fwVar.fwl.handler);
                fwVar.fwm.fwx = a[0];
                fwVar.fwm.thumbUrl = a[1];
                fwVar.fwm.ret = 0;
                break;
            case 12:
                j.a(fwVar.fwl.frf, fwVar.fwl.fwq);
                break;
            case 13:
                dc = h.getFavItemInfoStorage().dc(fwVar.fwl.frf);
                j.y(dc);
                if (dc == null && fwVar.fwl.frm != null) {
                    dc = j.a(fwVar.fwl.frm);
                }
                com.tencent.mm.plugin.favorite.a.e.a(fwVar.fwl.context, fwVar.fwl.toUser, fwVar.fwl.fwr, dc, fwVar.fwl.fwq);
                break;
            case 14:
                if (!j.e(fwVar.fwl.fwn)) {
                    fwVar.fwm.ret = 0;
                    break;
                }
                fwVar.fwm.ret = 1;
                break;
            case 15:
                j.n(h.getFavItemInfoStorage().dc(fwVar.fwl.frf));
                break;
            case 16:
                j.o(h.getFavItemInfoStorage().dc(fwVar.fwl.frf));
                break;
            case 17:
                fwVar.fwm.ret = j.AJ(fwVar.fwl.fwn.wkc);
                break;
            case 18:
                arrayList = new ArrayList();
                arrayList.add(Integer.valueOf(7));
                List<f> a2 = j.a(null, null, arrayList, null, null, null);
                List arrayList2 = new ArrayList();
                for (f dc2 : a2) {
                    vt vtVar = dc2.field_favProto.wlW;
                    uz p;
                    if (dc2.field_type == 7) {
                        p = j.p(dc2);
                        arrayList2.add(((a) com.tencent.mm.kernel.g.h(a.class)).a(6, null, p.title, p.desc, p.wjU, p.wjY, p.wjW, p.mBr, j.aJn(), b(p), "", vtVar.appId));
                    } else if (dc2.field_type == 14 && dc2.field_favProto.wlY != null) {
                        Iterator it = dc2.field_favProto.wlY.iterator();
                        while (it.hasNext()) {
                            p = (uz) it.next();
                            if (p.bjS == 7) {
                                arrayList2.add(((a) com.tencent.mm.kernel.g.h(a.class)).a(6, null, p.title, p.desc, p.wjU, p.wjY, p.wjW, p.mBr, j.aJn(), b(p), "", vtVar.appId));
                            }
                        }
                    }
                }
                fwVar.fwm.fwA = arrayList2;
                break;
            case 19:
                if (fwVar.fwl.frf != -1) {
                    j.b(fwVar);
                    break;
                }
                com.tencent.mm.plugin.favorite.a.c.a(fwVar.fwl.title, fwVar.fwl.frm.wlY, -1);
                break;
            case 20:
                i.a aJE = t.aJE();
                i aJF = t.aJF();
                t.mwG = aJF;
                aJF.a(aJE);
                t.mwG.mvX = true;
                i iVar = t.mwG;
                if (i.kIB == null) {
                    i.kIB = new SensorController(ad.getContext());
                }
                if (iVar.kIF == null) {
                    iVar.kIF = new az(ad.getContext());
                }
                t aJE2 = t.aJE();
                String str = fwVar.fwl.title;
                int i = fwVar.fwl.fws;
                int i2 = fwVar.fwl.fwt;
                aJE2.path = bi.aD(str, "");
                aJE2.fws = i;
                aJE2.duration = i2;
                break;
            case 21:
                fwVar.fwm.path = com.tencent.mm.plugin.favorite.a.g.v(fwVar.fwl.context, fwVar.fwl.fwt).toString();
                break;
            case 22:
                t.aJE();
                t.aJG().destroy();
                break;
            case 23:
                t.aJE();
                t.aJG().aJj();
                break;
            case 24:
                bVar = fwVar.fwm;
                t.aJE();
                bVar.fwB = t.aJG().J(fwVar.fwl.path, fwVar.fwl.fws, fwVar.fwl.fwt);
                break;
            case 25:
                t.aJE();
                t.aJG().stopPlay();
                break;
            case 26:
                bVar = fwVar.fwm;
                t.aJE();
                bVar.path = t.aJG().path;
                bVar = fwVar.fwm;
                t.aJE();
                bVar.fwB = t.aJG().aJh();
                bVar = fwVar.fwm;
                t.aJE();
                bVar.fwC = t.aJG().aJi();
                bVar = fwVar.fwm;
                t.aJE();
                bVar.fwD = t.aJG().vh();
                bVar = fwVar.fwm;
                t.aJE();
                bVar.fwE = t.aJG().vg();
                break;
            case 27:
                if (fwVar.fwl.fwn != null) {
                    fwVar.fwm.path = new File(j.h(fwVar.fwl.fwn)).getAbsolutePath();
                    fwVar.fwm.fwx = new File(j.i(fwVar.fwl.fwn)).getAbsolutePath();
                    break;
                }
                break;
            case 28:
                dc2 = h.getFavItemInfoStorage().dc(fwVar.fwl.frf);
                if (dc2 != null) {
                    if (!bi.oN(fwVar.fwl.path)) {
                        j.b(dc2, fwVar.fwl.fwn, true);
                        break;
                    }
                    j.a(dc2, fwVar.fwl.fwn, true);
                    break;
                }
                j.a(fwVar.fwl.fwn, fwVar.fwl.fws);
                j.b(fwVar.fwl.fwn, fwVar.fwl.fws);
                break;
            case 30:
                j.d(fwVar);
                break;
            case 31:
                r rVar = (r) fwVar.fwl.frW;
                fwVar.fwm.path = rVar.mwC;
                j.a(rVar);
                break;
            case 32:
                dc2 = h.getFavItemInfoStorage().dc(fwVar.fwl.frf);
                if (dc2 == null && fwVar.fwl.frm != null) {
                    dc2 = j.a(fwVar.fwl.frm);
                }
                fwVar.fwm.ret = new d().e(dc2) ? 1 : 0;
                fwVar.fwm.fwD = d.k(dc2);
                fwVar.fwm.path = "";
                if (dc2 == null) {
                    fwVar.fwm.fwD = true;
                    fwVar.fwm.path = null;
                    break;
                }
                break;
            case 33:
                dc2 = h.getFavItemInfoStorage().dc(fwVar.fwl.frf);
                if (dc2 != null) {
                    dc2.field_favProto.aw(fwVar.fwl.frm.wlY);
                    h.getFavItemInfoStorage().b(dc2, "localId");
                    break;
                }
                break;
            case 34:
                dc2 = h.getFavItemInfoStorage().dc(fwVar.fwl.frf);
                if (dc2 != null && dc2.field_type == 18) {
                    fwVar.fwl.frm = dc2.field_favProto;
                    break;
                }
            case 35:
                j.aJw();
                break;
            case 36:
                fwVar.fwm.ret = j.aJu() ? 1 : 0;
                break;
            case 37:
                j.d(fwVar.fwl.context, fwVar.fwl.desc, fwVar.fwl.title, fwVar.fwl.path);
                break;
            case 38:
                x.i("MicroMsg.Fav.FavoriteOperationListener", "TYPE_NEW_XML_UPLOAD_FAV_ITEM %s", fwVar.fwl.fwu);
                if (!bi.oN(fwVar.fwl.fwu)) {
                    a = fwVar.fwl.fwu.split(";");
                    List<String> linkedList = new LinkedList();
                    linkedList.addAll(Arrays.asList(a));
                    if (linkedList.size() > 0) {
                        arrayList = new ArrayList();
                        for (String valueOf : linkedList) {
                            try {
                                intValue = Integer.valueOf(valueOf).intValue();
                                if (intValue > 0) {
                                    dd = h.getFavItemInfoStorage().dd((long) intValue);
                                    vf vfVar = new vf();
                                    vfVar.vNB = intValue;
                                    if (!(dd == null || bi.oN(dd.field_xml))) {
                                        vfVar.vNI = dd.field_xml;
                                    }
                                    arrayList.add(vfVar);
                                }
                            } catch (Exception e) {
                            }
                        }
                        ((com.tencent.mm.plugin.fav.a.r) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.fav.a.r.class)).checkFavItem(arrayList);
                        x.i("MicroMsg.Fav.FavoriteOperationListener", "do scene NetSceneCheckFavItem");
                        break;
                    }
                }
                break;
            case 39:
                try {
                    x.i("MicroMsg.Fav.FavoriteOperationListener", "TYPE_NEW_XML_RESEND_FAV_ITEM %s %s", fwVar.fwl.fwu, fwVar.fwl.fwv);
                    intValue = bi.getInt(fwVar.fwl.fwu, -1);
                    Collection F = bi.F(fwVar.fwl.fwv.split(";"));
                    HashSet hashSet = new HashSet();
                    hashSet.addAll(F);
                    dd = h.getFavItemInfoStorage().dd((long) intValue);
                    if (dd != null) {
                        vq vqVar = new vq();
                        vqVar.vNB = intValue;
                        Object obj = null;
                        for (uz uzVar : dd.field_favProto.wlY) {
                            wg wgVar;
                            if (hashSet.remove(uzVar.mBr + "#0")) {
                                if (bi.oN(uzVar.wjP)) {
                                    com.tencent.mm.modelcdntran.g.MQ();
                                    uzVar.Ua(com.tencent.mm.modelcdntran.b.MI());
                                    com.tencent.mm.plugin.fav.a.g.pW(2);
                                }
                                if (FileOp.bO(j.h(uzVar))) {
                                    uzVar.Df(1);
                                    j.a(uzVar, dd, 0, false);
                                    com.tencent.mm.plugin.fav.a.g.pW(3);
                                    obj = 1;
                                } else {
                                    com.tencent.mm.plugin.fav.a.g.pW(5);
                                    wgVar = new wg();
                                    wgVar.wck = uzVar.mBr;
                                    wgVar.wcq = 0;
                                    wgVar.kyY = 4;
                                    vqVar.wmb.add(wgVar);
                                }
                            }
                            if (hashSet.remove(uzVar.mBr + "#1")) {
                                if (bi.oN(uzVar.wjP)) {
                                    com.tencent.mm.modelcdntran.g.MQ();
                                    uzVar.Ua(com.tencent.mm.modelcdntran.b.MI());
                                    com.tencent.mm.plugin.fav.a.g.pW(2);
                                }
                                if (FileOp.bO(j.i(uzVar))) {
                                    uzVar.Df(-1);
                                    j.a(uzVar, dd, 0);
                                    com.tencent.mm.plugin.fav.a.g.pW(3);
                                    obj = 1;
                                } else {
                                    com.tencent.mm.plugin.fav.a.g.pW(5);
                                    wgVar = new wg();
                                    wgVar.wck = uzVar.mBr;
                                    wgVar.wcq = 1;
                                    wgVar.kyY = 4;
                                    vqVar.wmb.add(wgVar);
                                }
                            }
                        }
                        if (hashSet.size() > 0) {
                            x.i("MicroMsg.Fav.FavoriteOperationListener", "not found url data item %s", hashSet.toString());
                            com.tencent.mm.plugin.fav.a.g.pX(hashSet.size());
                            Iterator it2 = hashSet.iterator();
                            while (it2.hasNext()) {
                                try {
                                    a = ((String) it2.next()).split("#");
                                    wg wgVar2 = new wg();
                                    wgVar2.wck = a[0];
                                    wgVar2.wcq = Integer.valueOf(a[1]).intValue();
                                    wgVar2.kyY = 3;
                                    vqVar.wmb.add(wgVar2);
                                } catch (Exception e2) {
                                }
                            }
                        }
                        if (vqVar.wmb.size() > 0) {
                            ((com.tencent.mm.plugin.fav.a.r) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.fav.a.r.class)).checkFavItem(vqVar);
                        }
                        if (obj == null) {
                            com.tencent.mm.plugin.fav.a.g.pW(7);
                            x.i("MicroMsg.Fav.FavoriteOperationListener", "do not has upload data item");
                            break;
                        }
                        if (dd.field_type == 18) {
                            dd.field_favProto.Dk(dd.field_favProto.version + 1);
                        }
                        dd.field_itemStatus = 15;
                        h.getFavItemInfoStorage().a(dd, "localId");
                        h.aIY().run();
                        com.tencent.mm.plugin.fav.a.g.pW(6);
                        break;
                    }
                    x.i("MicroMsg.Fav.FavoriteOperationListener", "NotFound %d", Integer.valueOf(intValue));
                    com.tencent.mm.plugin.fav.a.g.pW(8);
                    break;
                } catch (Throwable e3) {
                    x.printErrStackTrace("MicroMsg.Fav.FavoriteOperationListener", e3, "TYPE_NEW_XML_RESEND_FAV_ITEM", new Object[0]);
                    break;
                }
        }
        return false;
    }

    private static String b(uz uzVar) {
        File file = new File(j.i(uzVar));
        if (file.exists()) {
            return file.getAbsolutePath();
        }
        if (uzVar.fra == null) {
            return "";
        }
        file = new File(j.aJl() + com.tencent.mm.a.g.s(uzVar.fra.getBytes()));
        return file.exists() ? file.getAbsolutePath() : "";
    }
}
