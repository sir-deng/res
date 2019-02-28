package com.tencent.mm.plugin.shake.d.a;

import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.shake.d.b.a;
import com.tencent.mm.protocal.c.ati;
import com.tencent.mm.protocal.c.bjd;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import java.io.File;

public final class i {
    public static String bsQ() {
        if (as.Hp()) {
            StringBuilder stringBuilder = new StringBuilder();
            as.Hm();
            File file = new File(stringBuilder.append(c.FJ()).append("shakemusic/").toString());
            if (!(file.exists() && file.isDirectory())) {
                x.w("MicroMsg.ShakeMusicLogic", "storage dir[%s] not perpare, try to create it", file.getAbsolutePath());
                file.mkdir();
            }
            File file2 = new File(file, ".nomedia");
            if (!file2.exists()) {
                x.w("MicroMsg.ShakeMusicLogic", "no media file[%s] not exists, try to create it", file.getAbsolutePath());
                try {
                    file2.createNewFile();
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.ShakeMusicLogic", e, "", new Object[0]);
                }
            }
            if (file.exists()) {
                return file.getAbsolutePath() + "/";
            }
            x.w("MicroMsg.ShakeMusicLogic", "create storage dir fail");
            return null;
        }
        x.w("MicroMsg.ShakeMusicLogic", "getSaveDirPath: acc stg has not set uin");
        return null;
    }

    public static ati d(byte[] bArr, long j) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        try {
            bjd bjd = (bjd) new bjd().aH(bArr);
            ati ati = new ati();
            ati.wHt = 4;
            ati.wdd = String.valueOf(bjd.wTf);
            ati.wHu = bjd.wHu;
            ati.wHx = n.b(bjd.wug);
            ati.wHy = n.b(bjd.wuh);
            ati.wHD = a.HZ(ati.wHy);
            ati.vSa = bjd.vSa;
            ati.wHC = n.b(bjd.wuf);
            ati.wHv = n.b(bjd.wTg);
            ati.wHw = n.b(bjd.wTh);
            ati.wHB = n.b(bjd.wTk);
            ati.wHz = n.b(bjd.wTi);
            ati.wHA = n.b(bjd.wTj);
            ati.qXq = j;
            return ati;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.ShakeMusicLogic", e, "", new Object[0]);
            x.w("MicroMsg.ShakeMusicLogic", "get music wrapper bytes fail");
            return null;
        }
    }
}
