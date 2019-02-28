package com.tencent.mm.plugin.wear.model.e;

import android.database.Cursor;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.plugin.wear.model.c.a;
import com.tencent.mm.protocal.c.bzn;
import com.tencent.mm.protocal.c.bzt;
import com.tencent.mm.protocal.c.bzu;
import com.tencent.mm.protocal.c.caq;
import com.tencent.mm.protocal.c.car;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.contact.s;
import com.tencent.mm.y.as;
import com.tencent.mm.y.r;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class c extends a {
    public final List<Integer> bPu() {
        List<Integer> arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(11008));
        arrayList.add(Integer.valueOf(11009));
        return arrayList;
    }

    protected final byte[] n(int i, byte[] bArr) {
        int i2 = 5;
        if (i == 11008) {
            a.zS(6);
            caq caq = new caq();
            try {
                caq.aH(bArr);
                List linkedList = new LinkedList();
                linkedList.addAll(s.cwZ());
                linkedList.addAll(s.cxa());
                as.Hm();
                Cursor j = com.tencent.mm.y.c.Fk().j(linkedList, caq.vUN);
                if (caq.vUN != 0) {
                    i2 = 20;
                }
                car car = new car();
                car.vUN = caq.vUN;
                while (j != null && j.moveToNext()) {
                    String string = j.getString(j.getColumnIndex("username"));
                    as.Hm();
                    ag Xv = com.tencent.mm.y.c.Ff().Xv(string);
                    car.vUN++;
                    if (!(Xv.ciN() || Xv.AM())) {
                        bzn bzn = new bzn();
                        bzn.kzN = r.c(Xv);
                        bzn.kyG = Xv.field_username;
                        car.wrq.add(bzn);
                        if (car.wrq.size() >= i2) {
                            car.xgs = j.moveToNext();
                            break;
                        }
                    }
                }
                x.d("MicroMsg.Wear.HttpContactServer", "request offset: %d | return offset: %d | return size: %d", Integer.valueOf(caq.vUN), Integer.valueOf(car.vUN), Integer.valueOf(car.wrq.size()));
                if (j != null) {
                    j.close();
                }
                try {
                    return car.toByteArray();
                } catch (IOException e) {
                    return null;
                }
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.Wear.HttpContactServer", e2, "", new Object[0]);
                return null;
            }
        } else if (i != 11009) {
            return null;
        } else {
            a.zS(7);
            bzt bzt = new bzt();
            try {
                bzt.aH(bArr);
                bzu bzu = new bzu();
                as.Hm();
                Cursor cS = com.tencent.mm.y.c.Ff().cS(null);
                int i3 = bzt.vUN;
                while (cS != null && cS.moveToNext()) {
                    if (i3 > 0) {
                        i3--;
                    } else {
                        String string2 = cS.getString(0);
                        as.Hm();
                        ag Xv2 = com.tencent.mm.y.c.Ff().Xv(string2);
                        bzn bzn2 = new bzn();
                        bzn2.kzN = r.c(Xv2);
                        bzn2.kyG = Xv2.field_username;
                        bzu.wrq.add(bzn2);
                        if (bzu.wrq.size() >= 5) {
                            bzu.xgs = cS.moveToNext();
                            break;
                        }
                    }
                }
                if (cS != null) {
                    cS.close();
                }
                bzu.vUN = bzt.vUN + bzu.wrq.size();
                try {
                    return bzu.toByteArray();
                } catch (Throwable e22) {
                    x.printErrStackTrace("MicroMsg.Wear.HttpContactServer", e22, "", new Object[0]);
                    return null;
                }
            } catch (Throwable e222) {
                x.printErrStackTrace("MicroMsg.Wear.HttpContactServer", e222, "", new Object[0]);
                return null;
            }
        }
    }

    protected final boolean zU(int i) {
        if (i == 11008 || i == 11009) {
            return true;
        }
        return super.zU(i);
    }

    protected final boolean zT(int i) {
        if (i == 11008 || i == 11009) {
            return true;
        }
        return super.zT(i);
    }
}
