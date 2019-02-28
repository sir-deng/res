package com.tencent.mm.plugin.emoji.e;

import com.tencent.mm.jniinterface.AesEcb;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.p;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiInfo;

public class e {
    public static e lBr;
    private String aAM;
    boolean bgH = false;

    public static e aBy() {
        if (lBr == null) {
            synchronized (e.class) {
                lBr = new e();
            }
        }
        return lBr;
    }

    public final String aBz() {
        if (bi.oN(this.aAM)) {
            this.aAM = i.aCl().lCw.getKey();
        }
        return this.aAM;
    }

    public final boolean isEnable() {
        if (bi.oN(aBz())) {
            return false;
        }
        return true;
    }

    public final boolean c(EmojiInfo emojiInfo, boolean z) {
        if (emojiInfo == null) {
            x.w("MicroMsg.emoji.EmojiFileEncryptMgr", "encodeEmojiFile failed. emoji is null.");
            return false;
        } else if (isEnable()) {
            String clq = emojiInfo.clq();
            if (com.tencent.mm.a.e.bO(clq)) {
                boolean z2 = false;
                byte[] d = com.tencent.mm.a.e.d(clq, 0, 10);
                if (d != null) {
                    try {
                        if (d.length >= 10) {
                            z2 = p.br(d);
                        }
                    } catch (Throwable th) {
                        x.printErrStackTrace("MicroMsg.emoji.EmojiFileEncryptMgr", th, "", new Object[0]);
                        z2 = false;
                    }
                }
                if (z || z2) {
                    int i;
                    long currentTimeMillis = System.currentTimeMillis();
                    int bN = com.tencent.mm.a.e.bN(clq);
                    if (bN > 1024) {
                        i = WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
                    } else {
                        i = bN;
                    }
                    Object d2 = com.tencent.mm.a.e.d(clq, 0, bN);
                    byte[] aesCryptEcb = AesEcb.aesCryptEcb(com.tencent.mm.a.e.d(clq, 0, i), aBz().getBytes(), true, false);
                    if (bi.by(aesCryptEcb) || bi.by((byte[]) d2)) {
                        i = -1;
                    } else {
                        System.arraycopy(aesCryptEcb, 0, d2, 0, i);
                        i = com.tencent.mm.a.e.b(clq, d2, d2.length);
                    }
                    if (i == 0) {
                        g.pWK.a(252, 1, System.currentTimeMillis() - currentTimeMillis, false);
                        g.pWK.a(252, 6, 1, false);
                        emojiInfo.field_reserved4 |= EmojiInfo.xJc;
                        emojiInfo.field_size = bN;
                        i.aCl().lCw.q(emojiInfo);
                        x.i("MicroMsg.emoji.EmojiFileEncryptMgr", "encode emoji file length:%d use time:%d", Integer.valueOf(d2.length), Long.valueOf(r8));
                        return true;
                    }
                    x.w("MicroMsg.emoji.EmojiFileEncryptMgr", "encodeEmojiFile failed. write file failed.");
                    g.pWK.a(252, 3, 1, false);
                    return false;
                }
                x.i("MicroMsg.emoji.EmojiFileEncryptMgr", "encodeEmojiFile file had encrypt.");
                return true;
            }
            x.w("MicroMsg.emoji.EmojiFileEncryptMgr", "encodeEmojiFile failed. file not exist. path%s", clq);
            emojiInfo.field_reserved4 = 0;
            i.aCl().lCw.q(emojiInfo);
            return false;
        } else {
            x.i("MicroMsg.emoji.EmojiFileEncryptMgr", "disable encrypt");
            return false;
        }
    }

    public final byte[] a(EmojiInfo emojiInfo) {
        if (emojiInfo == null) {
            x.w("MicroMsg.emoji.EmojiFileEncryptMgr", "decodeEmojiData failed. emoji is null.");
            return null;
        }
        String clq = emojiInfo.clq();
        Object d = com.tencent.mm.a.e.d(clq, 0, com.tencent.mm.a.e.bN(clq));
        if (com.tencent.mm.a.e.bN(clq) <= 0 || d == null || d.length < 10) {
            x.i("MicroMsg.emoji.EmojiFileEncryptMgr", "decode emoji file failed. path is no exist :%s ", clq);
            return null;
        }
        Object obj = new byte[10];
        System.arraycopy(d, 0, obj, 0, 10);
        if ((emojiInfo.field_reserved4 & EmojiInfo.xJc) != EmojiInfo.xJc || p.br(obj)) {
            return d;
        }
        long currentTimeMillis = System.currentTimeMillis();
        int bN = com.tencent.mm.a.e.bN(clq);
        if (bN > WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
            bN = WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
        }
        byte[] d2 = com.tencent.mm.a.e.d(clq, 0, bN);
        byte[] bArr = null;
        if (!bi.oN(aBz())) {
            bArr = AesEcb.aesCryptEcb(d2, aBz().getBytes(), false, false);
        }
        if (bi.by(bArr) || bi.by((byte[]) d)) {
            g.pWK.a(252, 2, 1, false);
            x.i("MicroMsg.emoji.EmojiFileEncryptMgr", "decode emoji file failed. path:%s return original ", clq);
            return d;
        }
        System.arraycopy(bArr, 0, d, 0, bN);
        g.pWK.a(252, 0, System.currentTimeMillis() - currentTimeMillis, false);
        g.pWK.a(252, 5, 1, false);
        x.d("MicroMsg.emoji.EmojiFileEncryptMgr", "decode emoji file length:%d use time:%d", Integer.valueOf(d.length), Long.valueOf(r8));
        return d;
    }

    public final boolean b(EmojiInfo emojiInfo) {
        int i = WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
        if (emojiInfo == null) {
            x.w("MicroMsg.emoji.EmojiFileEncryptMgr", "decodeEmojiData failed. emoji is null.");
            return false;
        }
        boolean z;
        long currentTimeMillis = System.currentTimeMillis();
        String clq = emojiInfo.clq();
        int bN = com.tencent.mm.a.e.bN(clq);
        if (bN <= WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
            i = bN;
        }
        Object d = com.tencent.mm.a.e.d(clq, 0, i);
        if (com.tencent.mm.a.e.bN(clq) > 0 && d != null && d.length >= 10) {
            Object obj = new byte[10];
            System.arraycopy(d, 0, obj, 0, 10);
            if (p.br(obj)) {
                z = true;
            } else if ((emojiInfo.field_reserved4 & EmojiInfo.xJc) == EmojiInfo.xJc) {
                byte[] bArr = null;
                if (!bi.oN(aBz())) {
                    bArr = AesEcb.aesCryptEcb(d, aBz().getBytes(), false, false);
                }
                if (!bi.by(bArr) && p.br(bArr)) {
                    z = true;
                }
            }
            x.d("MicroMsg.emoji.EmojiFileEncryptMgr", "checkout use time:%s result:%b", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Boolean.valueOf(z));
            return z;
        }
        z = false;
        x.d("MicroMsg.emoji.EmojiFileEncryptMgr", "checkout use time:%s result:%b", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Boolean.valueOf(z));
        return z;
    }
}
