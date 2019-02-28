package com.tencent.mm.plugin.emoji.model;

import android.os.Looper;
import com.tencent.mm.a.e;
import com.tencent.mm.f.a.fq;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.emoji.model.d.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.io.File;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class g {
    Set<String> lDs = Collections.synchronizedSet(new HashSet());
    c<fq> lDt = new c<fq>() {
        {
            this.xmG = fq.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            fq fqVar = (fq) bVar;
            EmojiInfo emojiInfo = new EmojiInfo();
            emojiInfo.field_designerID = fqVar.fvQ.fvS;
            emojiInfo.field_name = fqVar.fvQ.name;
            emojiInfo.field_aeskey = fqVar.fvQ.aeskey;
            emojiInfo.field_encrypturl = fqVar.fvQ.fvT;
            emojiInfo.field_thumbUrl = fqVar.fvQ.thumbUrl;
            emojiInfo.field_md5 = fqVar.fvQ.frM;
            emojiInfo.field_groupId = fqVar.fvQ.frQ;
            EmojiInfo YB = i.aCl().lCw.YB(emojiInfo.Nx());
            if (fqVar.fvQ.fql == 3) {
                String clq = emojiInfo.clq();
                if (YB == null || (YB.field_reserved4 & EmojiInfo.xJc) != EmojiInfo.xJc) {
                    fqVar.fvR.path = clq;
                } else {
                    String absolutePath = new File(ad.getContext().getCacheDir(), com.tencent.mm.a.g.s(fqVar.fvQ.frM.getBytes())).getAbsolutePath();
                    if (FileOp.bO(clq) && !FileOp.bO(absolutePath)) {
                        e.d(absolutePath, ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().a(YB));
                    }
                    fqVar.fvR.path = absolutePath;
                }
                x.i("MicroMsg.FTS.FTSEmojiLogic", "gen path: %s", fqVar.fvR.path);
            } else if (fqVar.fvQ.fql == 1) {
                x.i("MicroMsg.FTS.FTSEmojiLogic", "emoji download: %s", emojiInfo.Nx());
                g.this.lDs.add(emojiInfo.Nx());
                i.aCf().g(emojiInfo);
            }
            return false;
        }
    };
    private a lDu = new a() {
        public final void h(EmojiInfo emojiInfo) {
            if (emojiInfo == null || !g.this.lDs.remove(emojiInfo.Nx())) {
                x.i("MicroMsg.FTS.FTSEmojiLogic", "somethings error.");
                return;
            }
            x.i("MicroMsg.FTS.FTSEmojiLogic", "emojiServiceCallback onDownload %s", emojiInfo.Nx());
            b fqVar = new fq();
            fqVar.fvQ.fql = 2;
            fqVar.fvQ.fvS = emojiInfo.field_designerID;
            fqVar.fvQ.name = emojiInfo.field_name;
            fqVar.fvQ.aeskey = emojiInfo.field_aeskey;
            fqVar.fvQ.fvT = emojiInfo.field_encrypturl;
            fqVar.fvQ.thumbUrl = emojiInfo.field_thumbUrl;
            fqVar.fvQ.frM = emojiInfo.field_md5;
            fqVar.fvQ.frQ = emojiInfo.field_groupId;
            String clq = emojiInfo.clq();
            EmojiInfo YB = i.aCl().lCw.YB(emojiInfo.Nx());
            if (YB == null || (YB.field_reserved4 & EmojiInfo.xJc) != EmojiInfo.xJc) {
                fqVar.fvR.path = clq;
            } else {
                String absolutePath = new File(ad.getContext().getExternalCacheDir(), com.tencent.mm.a.g.s(emojiInfo.Nx().getBytes())).getAbsolutePath();
                if (FileOp.bO(clq) && !FileOp.bO(absolutePath)) {
                    e.d(absolutePath, ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().a(YB));
                }
                fqVar.fvR.path = absolutePath;
            }
            com.tencent.mm.sdk.b.a.xmy.a(fqVar, Looper.getMainLooper());
        }
    };

    public g() {
        this.lDt.cfB();
    }
}
