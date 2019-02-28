package com.tencent.mm.plugin.wear.model.e;

import com.tencent.mm.R;
import com.tencent.mm.bl.d;
import com.tencent.mm.f.a.tl;
import com.tencent.mm.j.g;
import com.tencent.mm.plugin.wear.model.c.a;
import com.tencent.mm.protocal.c.can;
import com.tencent.mm.protocal.c.cay;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class l extends a {
    public final List<Integer> bPu() {
        List<Integer> arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(11032));
        arrayList.add(Integer.valueOf(11034));
        return arrayList;
    }

    protected final boolean zT(int i) {
        switch (i) {
            case 11032:
                return true;
            default:
                return false;
        }
    }

    protected final byte[] n(int i, byte[] bArr) {
        switch (i) {
            case 11032:
                can can = new can();
                if (g.Af().getInt("WearPayBlock", 0) == 0) {
                    a.ei(13, 0);
                    a.zS(15);
                    b tlVar = new tl();
                    tlVar.fMJ.action = 3;
                    com.tencent.mm.sdk.b.a.xmy.m(tlVar);
                    switch (tlVar.fMK.fML) {
                        case 1:
                            can.wXj = 0;
                            can.xfB = "";
                            can.xgR = new com.tencent.mm.bp.b(tlVar.fMK.fMP);
                            can.xgS = new com.tencent.mm.bp.b(tlVar.fMK.fMQ);
                            can.xgT = tlVar.fMK.fMR;
                            can.xgU = tlVar.fMK.fMS;
                            break;
                        case 2:
                            can.wXj = 196611;
                            can.xfB = ad.getContext().getString(R.l.eWF);
                            break;
                        case 3:
                            can.wXj = 196609;
                            can.xfB = ad.getContext().getString(R.l.eWE);
                            break;
                        case 4:
                            can.wXj = 196610;
                            can.xfB = ad.getContext().getString(R.l.eWI);
                            break;
                        case 5:
                            can.wXj = 196612;
                            can.xfB = ad.getContext().getString(R.l.eWG);
                            break;
                    }
                }
                can.wXj = 16777215;
                can.xfB = ad.getContext().getString(R.l.eWH);
                try {
                    return can.toByteArray();
                } catch (IOException e) {
                    break;
                }
            case 11034:
                cay cay = new cay();
                try {
                    cay.aH(bArr);
                } catch (IOException e2) {
                }
                d.y(ad.getContext(), cay.xgY, cay.xgZ);
                break;
        }
        return new byte[0];
    }

    public final boolean zV(int i) {
        switch (i) {
            case 11032:
                return true;
            default:
                return false;
        }
    }
}
