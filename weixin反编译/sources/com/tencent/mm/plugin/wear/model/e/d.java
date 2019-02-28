package com.tencent.mm.plugin.wear.model.e;

import com.tencent.liteav.network.TXCStreamUploader;
import com.tencent.mm.a.e;
import com.tencent.mm.bw.b;
import com.tencent.mm.f.a.tm;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.c;
import com.tencent.mm.plugin.wear.model.c.a;
import com.tencent.mm.protocal.c.bzp;
import com.tencent.mm.protocal.c.bzq;
import com.tencent.mm.protocal.c.bzr;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public final class d extends a {
    public final List<Integer> bPu() {
        List<Integer> arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(TXCStreamUploader.TXE_UPLOAD_INFO_CONNECT_SUCCESS));
        arrayList.add(Integer.valueOf(11004));
        return arrayList;
    }

    protected final byte[] n(int i, byte[] bArr) {
        Throwable e;
        if (i == TXCStreamUploader.TXE_UPLOAD_INFO_CONNECT_SUCCESS) {
            bzp bzp = new bzp();
            try {
                bzp.aH(bArr);
            } catch (IOException e2) {
            }
            if (b.chK().xsQ > bzp.wsk) {
                InputStream open;
                try {
                    open = ad.getContext().getAssets().open("color_emoji");
                    try {
                        byte[] d = com.tencent.mm.loader.stub.b.d(open);
                        e.c(open);
                        return d;
                    } catch (IOException e3) {
                        e = e3;
                        try {
                            x.printErrStackTrace("MicroMsg.Wear.EmojiServer", e, "", new Object[0]);
                            e.c(open);
                            return null;
                        } catch (Throwable th) {
                            e = th;
                            e.c(open);
                            throw e;
                        }
                    }
                } catch (IOException e4) {
                    e = e4;
                    open = null;
                } catch (Throwable th2) {
                    e = th2;
                    open = null;
                    e.c(open);
                    throw e;
                }
            }
        } else if (i == 11004) {
            a.zS(9);
            bzq bzq = new bzq();
            try {
                bzq.aH(bArr);
            } catch (IOException e5) {
            }
            bzr bzr = new bzr();
            if (((c) g.k(c.class)).getEmojiMgr() != null) {
                List<EmojiInfo> yK = ((c) g.k(c.class)).getEmojiMgr().yK(bzq.vWE);
                if (yK != null) {
                    for (EmojiInfo emojiInfo : yK) {
                        if (!bi.oN(emojiInfo.Nx())) {
                            bzr.vQB.add(emojiInfo.Nx());
                        }
                    }
                }
            }
            if (bzr.vQB.size() == 0) {
                com.tencent.mm.sdk.b.b tmVar = new tm();
                String[] strArr = new String[]{bzq.vWE};
                tmVar.fMT.fMU = strArr;
                tmVar.fMT.fql = 1;
                com.tencent.mm.sdk.b.a.xmy.m(tmVar);
            }
            try {
                return bzr.toByteArray();
            } catch (IOException e6) {
            }
        }
        return null;
    }
}
