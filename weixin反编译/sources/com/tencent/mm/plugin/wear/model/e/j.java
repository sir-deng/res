package com.tencent.mm.plugin.wear.model.e;

import com.tencent.mm.bp.b;
import com.tencent.mm.f.b.cg;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.plugin.wear.model.c.a;
import com.tencent.mm.plugin.wear.model.h;
import com.tencent.mm.protocal.c.cag;
import com.tencent.mm.protocal.c.cah;
import com.tencent.mm.protocal.c.cal;
import com.tencent.mm.protocal.c.cam;
import com.tencent.mm.protocal.c.cao;
import com.tencent.mm.protocal.c.cap;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class j extends a {
    public String tpt = "";

    public final List<Integer> bPu() {
        List<Integer> arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(11019));
        arrayList.add(Integer.valueOf(11020));
        arrayList.add(Integer.valueOf(11021));
        arrayList.add(Integer.valueOf(11031));
        return arrayList;
    }

    protected final byte[] n(int i, byte[] bArr) {
        boolean z = true;
        switch (i) {
            case 11019:
                List K;
                boolean z2;
                cag cag = new cag();
                try {
                    cag.aH(bArr);
                } catch (IOException e) {
                }
                cah cah = new cah();
                cah.xgK = cag.xgK;
                if (cah.xgK) {
                    as.Hm();
                    K = c.Fh().K(cag.vPp, cag.wMR);
                } else {
                    as.Hm();
                    K = c.Fh().J(cag.vPp, cag.wMR);
                }
                int i2 = 0;
                while (i2 < 10 && i2 < K.size()) {
                    cah.wvm.add(h.W((au) K.get(i2)));
                    i2++;
                }
                if (K.size() > 10) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                cah.xgs = z2;
                try {
                    return cah.toByteArray();
                } catch (Throwable e2) {
                    x.printErrStackTrace("MicroMsg.Wear.HttpMessageServer", e2, "", new Object[0]);
                    break;
                }
            case 11020:
                a.ei(9, 0);
                a.zS(8);
                cal cal = new cal();
                try {
                    cal.aH(bArr);
                    this.tpt = cal.vPp;
                    cam cam = new cam();
                    as.Hm();
                    List J = c.Fh().J(cal.vPp, cal.wMR);
                    int i3 = 0;
                    while (i3 < 10 && i3 < J.size()) {
                        cam.wvm.add(h.W((au) J.get(i3)));
                        i3++;
                    }
                    if (J.size() <= 10) {
                        z = false;
                    }
                    cam.xgs = z;
                    try {
                        return cam.toByteArray();
                    } catch (Throwable e22) {
                        x.printErrStackTrace("MicroMsg.Wear.HttpMessageServer", e22, "", new Object[0]);
                        break;
                    }
                } catch (IOException e3) {
                    return null;
                }
                break;
            case 11021:
                this.tpt = "";
                break;
            case 11031:
                a.ei(12, 0);
                a.zS(14);
                cao cao = new cao();
                try {
                    cao.aH(bArr);
                } catch (IOException e4) {
                }
                as.Hm();
                cg dI = c.Fh().dI(cao.xgC);
                cap cap = new cap();
                String fullPath = q.getFullPath(dI.field_imgPath);
                cap.xgV = o.e(fullPath, 0, true);
                cap.xgC = cao.xgC;
                cap.vPr = new b(FileOp.d(fullPath, 0, -1));
                q.E(dI);
                try {
                    return cap.toByteArray();
                } catch (IOException e5) {
                    return null;
                }
        }
        return null;
    }

    protected final boolean zU(int i) {
        switch (i) {
            case 11021:
            case 11031:
                return false;
            default:
                return true;
        }
    }

    protected final boolean zT(int i) {
        switch (i) {
            case 11021:
            case 11031:
                return false;
            default:
                return true;
        }
    }
}
