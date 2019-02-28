package com.tencent.mm.plugin.wear.model.e;

import com.tencent.liteav.network.TXCStreamUploader;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.protocal.c.bzx;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class h extends a {
    public final List<Integer> bPu() {
        List<Integer> arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(CdnLogic.kMediaTypeExposeImage));
        arrayList.add(Integer.valueOf(TXCStreamUploader.TXE_UPLOAD_INFO_NET_BUSY));
        arrayList.add(Integer.valueOf(11035));
        return arrayList;
    }

    public final boolean bPv() {
        return false;
    }

    protected final byte[] n(int i, byte[] bArr) {
        int i2 = 0;
        String str;
        String str2;
        if (i == CdnLogic.kMediaTypeExposeImage) {
            str = new String(bArr);
            str2 = "";
            try {
                str2 = FileOp.bT(str);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.Wear.HttpLogServer", e, "handleData", new Object[0]);
            }
            String[] split = str2.split("​​");
            List arrayList = new ArrayList();
            for (int i3 = 0; i3 < split.length; i3++) {
                arrayList.add(split[i3]);
                if (i3 % 50 == 9) {
                    g.pWK.k("WearCrash", arrayList);
                    arrayList.clear();
                }
            }
            if (arrayList.size() > 0) {
                g.pWK.k("WearCrash", arrayList);
                arrayList.clear();
            }
            new File(str).delete();
        } else if (i == TXCStreamUploader.TXE_UPLOAD_INFO_NET_BUSY) {
            str = new String(bArr);
            str2 = "";
            try {
                str2 = FileOp.bT(str);
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.Wear.HttpLogServer", e2, "handleData", new Object[0]);
            }
            String[] split2 = str2.split("​​");
            int length = split2.length;
            while (i2 < length) {
                x.i("MicroMsg.Wear.LOG", split2[i2]);
                i2++;
            }
            new File(str).delete();
        } else if (i == 11035) {
            bzx bzx = new bzx();
            try {
                bzx.aH(bArr);
            } catch (IOException e3) {
            }
            if (a.bPh().tok.toC.tps != null) {
                x.v("MicroMsg.Wear.HttpLogServer", "report kv id=%d %s %s %s %s data=%s", Integer.valueOf(bzx.npU), a.bPh().tok.toC.tps.kyL, a.bPh().tok.toC.tps.xgu, Integer.valueOf(a.bPh().tok.toC.tps.vOK), a.bPh().tok.toC.tps.xgv, bzx.xde);
                g.pWK.h(bzx.npU, r2.kyL, r2.xgu, Integer.valueOf(r2.vOK), r2.xgv, bzx.xde);
            }
        }
        return null;
    }
}
