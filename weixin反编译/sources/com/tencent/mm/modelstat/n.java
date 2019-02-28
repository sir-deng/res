package com.tencent.mm.modelstat;

import com.tencent.mm.network.ab;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.g.f;
import com.tencent.mm.plugin.appbrand.jsapi.v;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.wcdb.FileUtils;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteGlobal;

public final class n {
    static {
        bh.reset();
    }

    public static void A(int i, int i2, int i3) {
        if (ab.bC(ad.getContext())) {
            x.i("MicroMsg.NetStatStorageLogic", "dknetflow wifi recv:%d send:%d type:%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(0));
            B(i, i2, 0);
            return;
        }
        x.i("MicroMsg.NetStatStorageLogic", "dknetflow mobile recv:%d send:%d type:%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(0));
        C(i, i2, 0);
    }

    public static void B(int i, int i2, int i3) {
        k kVar = new k();
        kVar.hTA = i;
        kVar.hTM = i2;
        kVar.fEo = 8390656;
        c(kVar);
        a(kVar, i3);
        q.Tn().a(kVar);
    }

    public static void C(int i, int i2, int i3) {
        k kVar = new k();
        kVar.hTz = i;
        kVar.hTL = i2;
        kVar.fEo = 4195328;
        c(kVar);
        a(kVar, i3);
        q.Tn().a(kVar);
    }

    private static void c(k kVar) {
        bh.update();
        kVar.hTB = (int) bh.cgX();
        kVar.hTN = (int) bh.cgW();
        kVar.hTC = (int) bh.cgV();
        kVar.hTO = (int) bh.cgU();
        kVar.hTP = (int) bh.chb();
        kVar.hTR = (int) bh.cha();
        kVar.hTQ = (int) bh.cgZ();
        kVar.hTS = (int) bh.cgY();
        kVar.fEo = (((((((kVar.fEo | 8192) | 33554432) | Downloads.RECV_BUFFER_SIZE) | 16777216) | 134217728) | SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING) | 67108864) | SQLiteDatabase.CREATE_IF_NECESSARY;
    }

    private static void a(k kVar, int i) {
        switch (i) {
            case 109:
            case 123:
                kVar.hTu = kVar.hTz + kVar.hTA;
                kVar.fEo |= 32;
                return;
            case 110:
                kVar.hTG = kVar.hTL + kVar.hTM;
                kVar.fEo |= WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT;
                return;
            case 127:
                kVar.hTI = kVar.hTL + kVar.hTM;
                kVar.fEo |= SQLiteGlobal.journalSizeLimit;
                return;
            case FileUtils.S_IWUSR /*128*/:
                kVar.hTw = kVar.hTz + kVar.hTA;
                kVar.fEo |= FileUtils.S_IWUSR;
                return;
            case 138:
            case v.CTRL_INDEX /*139*/:
                kVar.hTs = kVar.hTz + kVar.hTA;
                kVar.fEo |= 8;
                return;
            case f.CTRL_INDEX /*149*/:
                kVar.hTK = kVar.hTL + kVar.hTM;
                kVar.fEo |= 2097152;
                return;
            case 150:
                kVar.hTy = kVar.hTz + kVar.hTA;
                kVar.fEo |= WXMediaMessage.TITLE_LENGTH_LIMIT;
                return;
            case 522:
                kVar.hTE = kVar.hTL + kVar.hTM;
                kVar.fEo |= WXMediaMessage.THUMB_LENGTH_LIMIT;
                return;
            default:
                return;
        }
    }
}
