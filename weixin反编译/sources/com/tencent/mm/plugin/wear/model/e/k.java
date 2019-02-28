package com.tencent.mm.plugin.wear.model.e;

import com.tencent.liteav.network.TXCStreamUploader;
import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.protocal.c.cak;
import com.tencent.mm.storage.x;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.s;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public final class k extends a {
    public final List<Integer> bPu() {
        List<Integer> arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(TXCStreamUploader.TXE_UPLOAD_ERROR_ALLADDRESS_FAILED));
        arrayList.add(Integer.valueOf(11010));
        return arrayList;
    }

    protected final byte[] n(int i, byte[] bArr) {
        switch (i) {
            case 11010:
                cak cak = new cak();
                try {
                    cak.aH(bArr);
                } catch (IOException e) {
                }
                a.bPh().tom.cw(cak.xgB, cak.xgN);
                break;
            case TXCStreamUploader.TXE_UPLOAD_ERROR_ALLADDRESS_FAILED /*11011*/:
                String str;
                String str2 = "";
                try {
                    str = new String(bArr, "utf8");
                } catch (UnsupportedEncodingException e2) {
                    str = str2;
                }
                as.Hm();
                x Xv = c.Ff().Xv(str);
                if (s.eX(str)) {
                    as.Hm();
                    Xv = c.Ff().Xv(str);
                    Xv.eH(0);
                    as.Hm();
                    c.Ff().a(str, Xv);
                    as.Hm();
                    c.Fe().b(new com.tencent.mm.ax.k(str, 0));
                } else {
                    s.n(Xv);
                }
                com.tencent.mm.plugin.wear.model.c.a.ei(4, 0);
                break;
        }
        return null;
    }
}
