package com.tencent.mm.plugin.emoji.sync.a;

import android.graphics.Bitmap;
import android.util.Base64;
import com.tencent.mm.ap.a.d.b;
import com.tencent.mm.f.a.cr;
import com.tencent.mm.plugin.emoji.c;
import com.tencent.mm.plugin.emoji.e.f;
import com.tencent.mm.plugin.emoji.e.n;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.emoji.sync.d;
import com.tencent.mm.plugin.emoji.sync.e;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.y.as;
import java.io.File;
import java.security.Key;
import java.util.Arrays;
import java.util.LinkedList;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class a extends d {
    private EmojiInfo kvY;
    private String lEE;
    private String lEF;
    private String lEi;
    private e lFJ;
    private String lFK;
    private String lFL;
    private String lFM;
    private String lFN;
    private String lFO;
    private com.tencent.mm.plugin.emoji.d.a lFP;
    private com.tencent.mm.ap.a.b.a lFQ;

    public a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        if (bi.oN(str)) {
            x.e("MicroMsg.BKGLoader.EmojiDownloadTask", "[cpan] can not create task md5 is null.");
        }
        this.lFK = str;
        this.lFL = str2;
        this.lFM = str3;
        this.lEE = str4;
        this.lFN = str5;
        this.lFO = str6;
        this.lEi = str7;
        this.lEF = str8;
        this.kvY = i.aCl().lCw.YB(this.lFK);
        if (this.kvY == null) {
            this.kvY = new EmojiInfo();
            this.kvY.field_md5 = this.lFK;
            this.kvY.field_cdnUrl = this.lFL;
            this.kvY.field_thumbUrl = this.lFM;
            this.kvY.field_designerID = this.lEE;
            this.kvY.field_encrypturl = this.lFN;
            this.kvY.field_aeskey = this.lFO;
            this.kvY.field_groupId = this.lEi;
        }
        if (bi.oN(this.lFL)) {
            this.lFL = this.kvY.field_cdnUrl;
        } else {
            this.kvY.field_cdnUrl = this.lFL;
        }
        if (bi.oN(this.lFN)) {
            this.lFN = this.kvY.field_encrypturl;
            this.lFO = this.kvY.field_aeskey;
        } else {
            this.kvY.field_encrypturl = this.lFN;
            this.kvY.field_aeskey = this.lFO;
        }
        if (!bi.oN(this.lEE)) {
            this.kvY.field_designerID = this.lEE;
        }
        if (!bi.oN(this.lEi)) {
            this.kvY.field_groupId = this.lEi;
        }
        if (!bi.oN(this.lFM)) {
            this.kvY.field_thumbUrl = this.lFM;
        }
        if (!bi.oN(this.lEF)) {
            this.kvY.field_activityid = this.lEF;
        }
        this.lFP = new com.tencent.mm.plugin.emoji.d.a();
        this.lFQ = new com.tencent.mm.ap.a.b.a();
    }

    public final void run() {
        String str;
        if (this.lFJ != null) {
            this.lFJ.zi(this.lFK);
        } else {
            x.w("MicroMsg.BKGLoader.EmojiDownloadTask", "call back is null.");
        }
        x.i("MicroMsg.BKGLoader.EmojiDownloadTask", "emoji md5:%s cndUrl:%s thumbUrl:%s field_designerID:%s field_encrypturl:%s field_groupId:%s", this.kvY.Nx(), this.kvY.field_cdnUrl, this.kvY.field_thumbUrl, this.kvY.field_designerID, this.kvY.field_encrypturl, this.kvY.field_groupId);
        if (bi.oN(this.lFL) && bi.oN(this.lFN)) {
            g.pWK.a(164, 10, 1, false);
            LinkedList linkedList = new LinkedList();
            linkedList.add(this.lFK);
            as.CN().a(new com.tencent.mm.plugin.emoji.f.e(linkedList), 0);
            aCM();
        } else {
            boolean z;
            String str2 = this.lFL;
            if (bi.oN(this.lFN) || bi.oN(this.lFO)) {
                str = str2;
                z = false;
            } else {
                str = this.lFN;
                z = true;
            }
            long currentTimeMillis = System.currentTimeMillis();
            b lD = this.lFP.lD(str);
            if (lD == null || bi.by(lD.data)) {
                x.d("MicroMsg.BKGLoader.EmojiDownloadTask", "get image data suuse time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                aCM();
            } else {
                x.d("MicroMsg.BKGLoader.EmojiDownloadTask", "get image data use time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                byte[] bArr = lD.data;
                if (z) {
                    try {
                        byte[] bArr2 = lD.data;
                        byte[] decode = Base64.decode(Base64.encodeToString(bi.Wj(this.lFO), 0).getBytes(), 0);
                        Key secretKeySpec = new SecretKeySpec(decode, "AES");
                        Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
                        instance.init(2, secretKeySpec, new IvParameterSpec(Arrays.copyOf(decode, decode.length)));
                        bArr = instance.doFinal(bArr2);
                    } catch (Throwable e) {
                        x.w("MicroMsg.BKGLoader.EmojiDownloadTask", "encrypt file failed. %s", bi.i(e));
                    }
                }
                Bitmap decodeByteArray = com.tencent.mm.sdk.platformtools.d.decodeByteArray(bArr, 10, 10);
                boolean a = this.lFQ.a(str, bArr, f.h(this.kvY.clq(), new Object[0]));
                File file = new File(this.kvY.clq());
                if (decodeByteArray != null && a && file.exists()) {
                    str = com.tencent.mm.a.g.i(file);
                    if (bi.oN(str) || !str.equalsIgnoreCase(this.kvY.Nx())) {
                        if (file.exists()) {
                            file.delete();
                        }
                        aCM();
                        if (z) {
                            c.cn(8);
                            c.a(this.lFK, 3, 0, 1, this.lEi, 1, this.lEE);
                        } else {
                            c.cn(5);
                            c.a(this.lFK, 2, 0, 1, this.lEi, 1, this.lEE);
                        }
                    } else {
                        this.kvY.field_size = bArr.length;
                        this.kvY.field_state = EmojiInfo.xIV;
                        this.kvY.field_temp = 0;
                        this.kvY.field_catalog = EmojiInfo.xIN;
                        this.kvY.field_type = EmojiLogic.al(bArr);
                        int clx = i.aCl().lCw.clx();
                        this.kvY.field_idx = clx < n.aBU() ? n.aBU() : clx + 1;
                        i.aCl().lCw.p(this.kvY);
                        com.tencent.mm.storage.emotion.a aVar = i.aCl().lCx;
                        if (!com.tencent.mm.storage.emotion.a.ckW()) {
                            i.aCl().lCx.ckX();
                        }
                        com.tencent.mm.sdk.b.b crVar = new cr();
                        crVar.frL.frM = this.lFK;
                        crVar.frL.fql = 0;
                        crVar.frL.success = true;
                        com.tencent.mm.sdk.b.a.xmy.m(crVar);
                        if (z) {
                            c.cn(7);
                            c.cn(4);
                            c.a(this.lFK, 3, 0, 0, this.lEi, 0, this.lEE);
                        } else {
                            c.cn(2);
                            c.cn(4);
                            c.a(this.lFK, 2, 0, 0, this.lEi, 1, this.lEE);
                        }
                        com.tencent.mm.plugin.emoji.e.e.aBy().c(this.kvY, true);
                    }
                } else {
                    aCM();
                    if (z) {
                        c.cn(8);
                        c.a(this.lFK, 3, 0, 1, this.lEi, 1, this.lEE);
                    } else {
                        c.cn(3);
                        c.a(this.lFK, 2, 1, 1, this.lEi, 1, this.lEE);
                    }
                }
            }
        }
        if (!bi.oN(this.kvY.field_thumbUrl)) {
            b lD2 = this.lFP.lD(this.kvY.field_thumbUrl);
            if (lD2 != null) {
                com.tencent.mm.ap.a.b.a aVar2 = this.lFQ;
                str = this.kvY.field_thumbUrl;
                byte[] bArr3 = lD2.data;
                String str3 = this.kvY.field_thumbUrl;
                aVar2.a(str, bArr3, f.h(this.kvY.clq() + "_cover", new Object[0]));
            }
        }
    }

    private void aCM() {
        x.i("MicroMsg.BKGLoader.EmojiDownloadTask", "disable to download emoji when cdn download failed.");
        com.tencent.mm.sdk.b.b crVar = new cr();
        crVar.frL.frM = this.lFK;
        crVar.frL.fql = 0;
        crVar.frL.success = false;
        com.tencent.mm.sdk.b.a.xmy.m(crVar);
        if (this.kvY != null) {
            x.i("MicroMsg.BKGLoader.EmojiDownloadTask", "[cpan] this emoji is broken. md5 is:%s", this.kvY.Nx());
            this.kvY.field_state = EmojiInfo.xIW;
            this.kvY.field_catalog = EmojiInfo.xIH;
            i.aCl().lCw.p(this.kvY);
        }
    }

    public final String getKey() {
        return this.lFK;
    }

    public final void a(e eVar) {
        this.lFJ = eVar;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof a)) {
            a aVar = (a) obj;
            if (!(bi.oN(this.lFK) || bi.oN(aVar.lFK) || !this.lFK.equals(aVar.lFK))) {
                return true;
            }
        }
        return false;
    }

    public final void cancel() {
    }
}
