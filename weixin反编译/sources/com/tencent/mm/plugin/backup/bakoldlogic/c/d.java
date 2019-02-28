package com.tencent.mm.plugin.backup.bakoldlogic.c;

import com.tencent.mm.a.e;
import com.tencent.mm.ad.f;
import com.tencent.mm.jniinterface.AesEcb;
import com.tencent.mm.plugin.backup.bakoldlogic.a.a;
import com.tencent.mm.plugin.backup.f.b;
import com.tencent.mm.plugin.backup.h.ad;
import com.tencent.mm.plugin.backup.h.ae;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

public final class d extends b {
    private static int progress;
    private int hmZ;
    public String id;
    private byte[] key;
    private f kxm = null;
    private ad kxo = new ad();
    private ae kxp = new ae();
    private String kxq;
    private int offset = 0;
    private int start = 0;

    public d(String str, String str2, int i, int i2, f fVar, byte[] bArr) {
        if (i == 1) {
            this.kxq = str + "backupItem/" + a.vT(str2);
        } else {
            this.kxq = str + "backupMeida/" + a.vT(str2);
        }
        this.id = str2;
        this.kxo.kzD = str2;
        this.kxo.kzE = i;
        this.hmZ = i2;
        x.i("MicroMsg.BakSceneRestoreData", "BakSceneRestoreData init, %s, type:%d, totalLen:%d", this.kxo.kzD, Integer.valueOf(this.kxo.kzE), Integer.valueOf(this.hmZ));
        this.kxm = fVar;
        this.key = bArr;
    }

    public final boolean aqx() {
        int i;
        long j = 524288;
        x.i("MicroMsg.BakSceneRestoreData", "doSecne");
        int i2 = this.hmZ;
        if (this.kxo.kzE == 2) {
            if (((long) (this.hmZ - this.offset)) <= 524288) {
                j = (long) (this.hmZ - this.offset);
            }
            i = (int) j;
        } else {
            i = i2;
        }
        this.start = this.offset;
        this.offset = i + this.start;
        this.kxo.kzG = this.start;
        this.kxo.kzH = this.offset;
        this.kxo.kzJ = progress;
        return super.aqx();
    }

    public static void setProgress(int i) {
        x.i("MicroMsg.BakSceneRestoreData", "setProgress %d", Integer.valueOf(i));
        progress = i;
    }

    public final com.tencent.mm.bp.a aqo() {
        return this.kxp;
    }

    public final com.tencent.mm.bp.a aqp() {
        return this.kxo;
    }

    public final void nd(int i) {
        x.i("MicroMsg.BakSceneRestoreData", "onSceneEnd id:%s, type:%d, s:%d, e:%d, status:%d", this.kxp.kzD, Integer.valueOf(this.kxp.kzE), Integer.valueOf(this.kxp.kzG), Integer.valueOf(this.kxp.kzH), Integer.valueOf(this.kxp.kyY));
        if (this.kxp.kyY != 0 && this.kxp.kyY != 10) {
            f(4, this.kxp.kyY, "error");
        } else if (this.kxp.kzG == this.start && this.kxp.kzH == this.offset) {
            byte[] aesCryptEcb;
            this.kxm.a(this.kxo.kzH - this.kxo.kzG, this.hmZ, this);
            byte[] bArr = this.kxp.kyn.oz;
            if (this.key != null) {
                aesCryptEcb = AesEcb.aesCryptEcb(bArr, this.key, false, this.offset == this.hmZ);
            } else {
                aesCryptEcb = bArr;
            }
            String str = this.kxq;
            String str2 = this.id;
            File file = new File(str + str2);
            long length = file.exists() ? file.length() : 0;
            e.a(str, str2, aesCryptEcb);
            File file2 = new File(str + str2);
            if (length == (file2.exists() ? file2.length() : 0)) {
                x.e("MicroMsg.BakSceneRestoreData", "append failed and try again:%s", str + str2);
                e.a(str, str2, aesCryptEcb);
            }
            str = "MicroMsg.BakSceneRestoreData";
            String str3 = "onSceneEnd appendbuf len:%d";
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(aesCryptEcb == null ? 0 : aesCryptEcb.length);
            x.i(str, str3, objArr);
            if (this.offset == this.hmZ) {
                x.i("MicroMsg.BakSceneRestoreData", "recover cmoplete:%s  %d", this.id, Integer.valueOf(this.hmZ));
                f(0, 0, "success");
                return;
            }
            aqx();
        } else {
            x.e("MicroMsg.BakSceneRestoreData", "err local:%d, %d;   server:%d,%d", Integer.valueOf(this.start), Integer.valueOf(this.offset), Integer.valueOf(this.kxp.kzG), Integer.valueOf(this.kxp.kzH));
            f(3, -1, "error");
        }
    }

    public final int getType() {
        return 7;
    }
}
