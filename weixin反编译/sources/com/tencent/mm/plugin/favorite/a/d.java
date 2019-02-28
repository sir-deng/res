package com.tencent.mm.plugin.favorite.a;

import com.tencent.mm.a.e;
import com.tencent.mm.j.g;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.fav.a.n;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.protocal.c.uz;
import com.tencent.mm.protocal.c.vm;
import com.tencent.mm.protocal.c.vt;
import com.tencent.mm.protocal.c.vw;
import com.tencent.mm.protocal.c.wc;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.Iterator;

public final class d implements n {
    public boolean mvk = true;

    public final boolean e(f fVar) {
        if (fVar == null) {
            return true;
        }
        if (j.w(fVar)) {
            return true;
        }
        f dc = h.getFavItemInfoStorage().dc(fVar.field_localId);
        uz p;
        vm vmVar;
        switch (fVar.field_type) {
            case 1:
                return bi.oN(fVar.field_favProto.desc);
            case 2:
            case 8:
                return !new File(j.h(j.p(fVar))).exists();
            case 3:
                if (this.mvk) {
                    return true;
                }
                return false;
            case 4:
                p = j.p(fVar);
                if (new File(j.h(p)).exists()) {
                    return false;
                }
                return bi.oN(p.wjU);
            case 5:
                vt vtVar = fVar.field_favProto.wlW;
                wc wcVar = fVar.field_favProto.wlf;
                String str = null;
                if (wcVar != null) {
                    str = wcVar.wmD;
                }
                if (vtVar != null && bi.oN(r0)) {
                    str = vtVar.hPT;
                }
                return bi.oN(str);
            case 6:
                return fVar.field_favProto.wld == null;
            case 7:
                p = j.p(fVar);
                return bi.oN(p.wjU) && bi.oN(p.wjW) && bi.oN(p.wjY) && bi.oN(p.wjY);
            case 10:
                vmVar = fVar.field_favProto.wlh;
                return vmVar == null || bi.oN(vmVar.info);
            case 11:
                vmVar = fVar.field_favProto.wlh;
                return vmVar == null || bi.oN(vmVar.info);
            case 14:
            case 18:
                if (fVar.field_id <= 0 && dc != null) {
                    return true;
                }
                if (fVar.field_type == 18 && (fVar.field_favProto == null || fVar.field_favProto.wlY.size() <= 1)) {
                    return true;
                }
                if (fVar.field_type == 18 && (bi.oN(((uz) fVar.field_favProto.wlY.get(0)).wjN) || bi.oN(((uz) fVar.field_favProto.wlY.get(0)).wjP))) {
                    return true;
                }
                Iterator it = fVar.field_favProto.wlY.iterator();
                while (it.hasNext()) {
                    p = (uz) it.next();
                    if ((p.bjS == 2 || p.bjS == 8 || p.bjS == 15 || p.bjS == 4) && !e.bO(j.h(p))) {
                        return true;
                    }
                }
                return false;
            case 15:
                vw vwVar = fVar.field_favProto.wlj;
                return vwVar == null || bi.oN(vwVar.info);
            case 16:
                if (bi.Wo(g.Af().getValue("SIGHTCannotTransmitForFav")) != 0) {
                    x.w("MicroMsg.FavSendFilter", "can not retransmit short video");
                    return true;
                }
                p = j.p(fVar);
                File file = new File(j.h(p));
                x.v("MicroMsg.FavSendFilter", "type size, favid %d, localid %d, path %s, exist %B", Integer.valueOf(fVar.field_id), Long.valueOf(fVar.field_localId), file.getAbsolutePath(), Boolean.valueOf(file.exists()));
                if (!file.exists()) {
                    return true;
                }
                if (Math.abs(p.wki - file.length()) <= 16) {
                    return false;
                }
                String i = com.tencent.mm.a.g.i(file);
                x.w("MicroMsg.FavSendFilter", "it can not retransmit short video because of file was replaced. file[%d, %s], data[%d, %s]", Long.valueOf(r2), i, Long.valueOf(r4), p.wke);
                return true;
            default:
                return false;
        }
    }

    public static boolean c(uz uzVar) {
        if (uzVar == null) {
            return true;
        }
        switch (uzVar.bjS) {
            case 2:
            case 8:
                if (new File(j.h(uzVar)).exists()) {
                    return false;
                }
                return true;
            case 3:
                return true;
            case 4:
                if (new File(j.h(uzVar)).exists()) {
                    return false;
                }
                return bi.oN(uzVar.wjU);
            case 7:
                if (bi.oN(uzVar.wjU) && bi.oN(uzVar.wjW) && bi.oN(uzVar.wjY) && bi.oN(uzVar.wjY)) {
                    return true;
                }
                return false;
            case 15:
                if (bi.Wo(g.Af().getValue("SIGHTCannotTransmitForFav")) != 0) {
                    x.w("MicroMsg.FavSendFilter", "can not retransmit short video");
                    return true;
                } else if (new File(j.h(uzVar)).exists()) {
                    return false;
                } else {
                    return true;
                }
            default:
                return false;
        }
    }

    public static boolean k(f fVar) {
        if (fVar == null) {
            return false;
        }
        if (fVar.field_itemStatus > 0 && !j.u(fVar)) {
            return false;
        }
        f dc = h.getFavItemInfoStorage().dc(fVar.field_localId);
        File file = new File(j.h(j.p(fVar)));
        switch (fVar.field_type) {
            case 2:
            case 8:
                if (!file.exists()) {
                    return true;
                }
                break;
            case 4:
                if (bi.oN(j.p(fVar).wjU) && !file.exists()) {
                    return true;
                }
            case 14:
            case 18:
                if (fVar.field_id > 0 || dc == null) {
                    if (fVar.field_favProto != null && fVar.field_favProto.wlY.size() > 1) {
                        Iterator it = fVar.field_favProto.wlY.iterator();
                        while (it.hasNext()) {
                            uz uzVar = (uz) it.next();
                            if (!bi.oN(uzVar.wjN) && !bi.oN(uzVar.wjP) && !e.bO(j.h(uzVar))) {
                                return true;
                            }
                        }
                        break;
                    }
                    return false;
                }
                return false;
                break;
            case 16:
                if (bi.Wo(g.Af().getValue("SIGHTCannotTransmitForFav")) != 0) {
                    x.w("MicroMsg.FavSendFilter", "can not retransmit short video");
                    return false;
                } else if (!file.exists()) {
                    return true;
                }
                break;
        }
        return false;
    }
}
