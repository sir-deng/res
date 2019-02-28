package com.tencent.mm.plugin.clean.c;

import android.os.StatFs;
import com.tencent.mm.bx.h.d;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.i.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.ap;
import java.util.HashMap;
import java.util.HashSet;

public final class j implements ap {
    private static j llv;
    public long lkH;
    public long lkI;
    public long lkJ;
    public HashSet<String> lli;
    public HashMap<String, Long> llu;

    public static j azc() {
        if (llv == null) {
            llv = new j();
        }
        return llv;
    }

    private j() {
    }

    public final HashMap<Integer, d> Bu() {
        return null;
    }

    public final void ge(int i) {
        d.ayW();
    }

    public final void bs(boolean z) {
        x.i("MicroMsg.SubCoreClean", "summerclean onAccountPostReset updated[%b]", Boolean.valueOf(z));
        b.atn().onAccountInitialized(null);
    }

    public final void bt(boolean z) {
        x.i("MicroMsg.SubCoreClean", "summerclean onSdcardMount mounted[%b]", Boolean.valueOf(z));
    }

    public final void onAccountRelease() {
        x.i("MicroMsg.SubCoreClean", "summerclean onAccountRelease");
        this.lkH = 0;
        this.lkI = 0;
        this.lkJ = 0;
        if (this.llu != null) {
            this.llu.clear();
        }
        if (this.lli != null) {
            this.lli.clear();
        }
        d.ayW();
        b.atn().onAccountRelease();
    }

    public static long ayJ() {
        long blockSize;
        try {
            StatFs statFs = new StatFs(e.bnD);
            blockSize = ((long) statFs.getBlockSize()) * ((long) statFs.getBlockCount());
        } catch (Exception e) {
            blockSize = 0;
        }
        return blockSize <= 0 ? 1 : blockSize;
    }

    public static long ayK() {
        long blockSize;
        try {
            StatFs statFs = new StatFs(e.bnD);
            blockSize = ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks());
        } catch (Exception e) {
            blockSize = 0;
        }
        return blockSize <= 0 ? 1 : blockSize;
    }
}
