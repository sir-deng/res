package com.tencent.mm.plugin.emoji.e;

import com.tencent.mm.ap.a.a.c;
import com.tencent.mm.ap.a.a.c.a;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;

public final class f {
    private static final c lBt;

    public static c cn(String str, String str2) {
        return b(str, str2, new Object[0]);
    }

    public static c b(String str, String str2, Object... objArr) {
        as.Hm();
        String H = EmojiLogic.H(com.tencent.mm.y.c.Fw(), str, str2);
        if (bi.oN(H)) {
            x.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
            return null;
        }
        a aVar = new a();
        aVar.hFj = true;
        aVar.hFl = true;
        aVar.hFn = H;
        aVar.hFO = objArr;
        return aVar.PQ();
    }

    public static c q(String str, String str2, int i) {
        as.Hm();
        String H = EmojiLogic.H(com.tencent.mm.y.c.Fw(), str, str2);
        if (bi.oN(H)) {
            x.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
            return null;
        }
        a aVar = new a();
        aVar.hFj = true;
        aVar.hFl = true;
        aVar.hFn = H;
        aVar.hFs = i;
        aVar.hFr = i;
        return aVar.PQ();
    }

    public static c aBA() {
        a aVar = new a();
        aVar.hFj = true;
        aVar.hFl = false;
        aVar.hFq = 3;
        return aVar.PQ();
    }

    public static c c(String str, String str2, Object... objArr) {
        as.Hm();
        String FJ = com.tencent.mm.y.c.FJ();
        as.Hm();
        String H = EmojiLogic.H(com.tencent.mm.y.c.Fw(), str, str2);
        if (bi.oN(H)) {
            x.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
            return null;
        }
        a aVar = new a();
        aVar.hFj = true;
        aVar.hFl = true;
        aVar.hFn = H;
        aVar.hFo = FJ;
        aVar.hFO = objArr;
        return aVar.PQ();
    }

    static {
        a aVar = new a();
        aVar.hFj = true;
        aVar.hFq = 1;
        aVar.hFI = false;
        lBt = aVar.PQ();
    }

    public static c h(String str, Object... objArr) {
        if (bi.oN(str)) {
            x.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
            return null;
        }
        a aVar = new a();
        aVar.hFl = true;
        aVar.hFn = str;
        aVar.hFO = objArr;
        return aVar.PQ();
    }

    public static c i(String str, Object... objArr) {
        if (bi.oN(str)) {
            x.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
            return null;
        }
        a aVar = new a();
        aVar.hFl = true;
        aVar.hFn = str;
        aVar.hFM = false;
        aVar.hFO = objArr;
        return aVar.PQ();
    }

    public static c a(String str, int i, Object... objArr) {
        if (bi.oN(str)) {
            x.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
            return null;
        }
        a aVar = new a();
        aVar.hFl = true;
        aVar.hFn = str;
        aVar.hFs = i;
        aVar.hFr = i;
        aVar.hFO = objArr;
        return aVar.PQ();
    }

    public static c co(String str, String str2) {
        as.Hm();
        String H = EmojiLogic.H(com.tencent.mm.y.c.Fw(), str, str2);
        if (bi.oN(H)) {
            x.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
            return null;
        }
        a aVar = new a();
        aVar.hFj = true;
        aVar.hFl = true;
        aVar.hFn = H;
        aVar.hFJ = true;
        return aVar.PQ();
    }

    public static c cp(String str, String str2) {
        as.Hm();
        String H = EmojiLogic.H(com.tencent.mm.y.c.Fw(), str, str2);
        if (bi.oN(H)) {
            x.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
            return null;
        }
        a aVar = new a();
        aVar.hFj = true;
        aVar.hFl = true;
        aVar.hFn = H;
        aVar.hFJ = false;
        return aVar.PQ();
    }

    public static c g(String str, String str2, Object... objArr) {
        as.Hm();
        String H = EmojiLogic.H(com.tencent.mm.y.c.Fw(), str, str2);
        if (bi.oN(H)) {
            x.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
            return null;
        }
        a aVar = new a();
        aVar.hFj = false;
        aVar.hFl = true;
        aVar.hFn = H;
        aVar.hFO = objArr;
        return aVar.PQ();
    }

    public static c h(String str, String str2, Object... objArr) {
        as.Hm();
        String H = EmojiLogic.H(com.tencent.mm.y.c.Fw(), str, str2);
        if (bi.oN(H)) {
            x.w("MicroMsg.emoji.EmojiImageLoaderManager", "get emoji loader options failed. path is null.");
            return null;
        }
        a aVar = new a();
        aVar.hFj = true;
        aVar.hFl = true;
        aVar.hFn = H;
        aVar.hFO = objArr;
        return aVar.PQ();
    }
}
