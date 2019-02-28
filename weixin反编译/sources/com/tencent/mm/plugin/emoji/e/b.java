package com.tencent.mm.plugin.emoji.e;

import android.content.Context;
import android.database.Cursor;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.bw.e;
import com.tencent.mm.bw.f;
import com.tencent.mm.f.a.at;
import com.tencent.mm.f.a.az;
import com.tencent.mm.f.a.cn;
import com.tencent.mm.f.a.co;
import com.tencent.mm.f.a.cp;
import com.tencent.mm.f.a.cq;
import com.tencent.mm.f.a.hy;
import com.tencent.mm.f.a.ji;
import com.tencent.mm.f.a.mi;
import com.tencent.mm.f.a.na;
import com.tencent.mm.f.a.sj;
import com.tencent.mm.plugin.emoji.c.a;
import com.tencent.mm.plugin.emoji.c.c;
import com.tencent.mm.plugin.emoji.c.d;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.w;
import com.tencent.mm.y.as;
import java.util.ArrayList;
import java.util.Iterator;

public final class b {
    public a lAS = new a();
    public com.tencent.mm.plugin.emoji.c.b lAT = new com.tencent.mm.plugin.emoji.c.b();
    public d lAU = new d();
    public c lAV = new c();
    public com.tencent.mm.sdk.b.c lAW = new com.tencent.mm.sdk.b.c<sj>() {
        {
            this.xmG = sj.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            au auVar = ((sj) bVar).fKW.fou;
            EmojiInfo YB = i.aCl().lCw.YB(auVar.field_imgPath);
            if (YB != null) {
                if (YB.field_type == EmojiInfo.xIO) {
                    Cursor cursor = null;
                    if (EmojiInfo.DN(YB.field_catalog)) {
                        cursor = i.aCl().lCw.DR(YB.field_catalog);
                    } else if (YB.field_catalog == EmojiInfo.xIJ && YB.wl().length() > 0 && EmojiInfo.DN(bi.getInt(YB.wl(), 0))) {
                        cursor = i.aCl().lCw.DR(bi.getInt(YB.wl(), 0));
                    }
                    if (cursor != null) {
                        int eI = bi.eI(cursor.getCount() - 1, 0);
                        YB = new EmojiInfo();
                        cursor.moveToPosition(eI);
                        YB.b(cursor);
                        cursor.close();
                    }
                    auVar.dV(YB.Nx());
                    auVar.fc(0);
                    aj XW = aj.XW(auVar.field_content);
                    XW.hXo = false;
                    auVar.eR(1);
                    auVar.setContent(XW.cjC());
                    as.Hm();
                    com.tencent.mm.y.c.Fh().a(auVar.field_msgId, auVar);
                }
                i.aCh().a(auVar.field_talker, YB, auVar);
            }
            return false;
        }
    };
    public com.tencent.mm.sdk.b.c lAX = new com.tencent.mm.sdk.b.c<ji>() {
        {
            this.xmG = ji.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            ji jiVar = (ji) bVar;
            if (jiVar != null && (jiVar instanceof ji)) {
                x.i("MicroMsg.emoji.EmojiEventMgr", "manualAuthEventListener callback");
                if (jiVar.fAE.foB) {
                    as.Hm();
                    com.tencent.mm.y.c.Db().a(w.a.USERINFO_EMOJI_SYNC_CUSTOM_EMOJI_BATCH_DOWNLOAD_BOOLEAN, Boolean.valueOf(true));
                }
            }
            return false;
        }
    };
    public com.tencent.mm.sdk.b.c lAY = new com.tencent.mm.sdk.b.c<cp>() {
        {
            this.xmG = cp.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            boolean z = true;
            switch (((cp) bVar).frI.state) {
                case 0:
                    d aBx = d.aBx();
                    as.Hm();
                    String Fw = com.tencent.mm.y.c.Fw();
                    aBx.lBo = true;
                    if (bi.oN(Fw)) {
                        x.i("MicroMsg.emoji.EmojiFileCleanTaskManager", "filepath is empty.");
                    } else {
                        as.Hm();
                        x.i("MicroMsg.emoji.EmojiFileCleanTaskManager", "need clean emoji file:%B", Boolean.valueOf(System.currentTimeMillis() - ((Long) com.tencent.mm.y.c.Db().get(w.a.USERINFO_EMOJI_CLEAN_TEMP_FILE_TASK_LONG, Long.valueOf(0))).longValue() >= 86400000));
                        if (System.currentTimeMillis() - ((Long) com.tencent.mm.y.c.Db().get(w.a.USERINFO_EMOJI_CLEAN_TEMP_FILE_TASK_LONG, Long.valueOf(0))).longValue() >= 86400000) {
                            x.i("MicroMsg.emoji.EmojiFileCleanTaskManager", "startClean");
                            as.Dt().F(new com.tencent.mm.plugin.emoji.e.d.AnonymousClass1(Fw));
                        }
                    }
                    e aBy = e.aBy();
                    if (aBy.isEnable()) {
                        if (!aBy.bgH) {
                            aBy.bgH = true;
                            as.Hm();
                            if (System.currentTimeMillis() - ((Long) com.tencent.mm.y.c.Db().get(w.a.USERINFO_EMOJI_ENCODE_EMOJI_FILE_TASK_LONG, Long.valueOf(0))).longValue() < 86400000) {
                                z = false;
                            }
                            if (!z) {
                                x.i("MicroMsg.emoji.EmojiFileEncryptMgr", "need no encrypt.");
                                break;
                            }
                            as.Dt().F(new Runnable() {
                                public final void run() {
                                    ArrayList cly = i.aCl().lCw.cly();
                                    if (cly != null && cly.size() > 0) {
                                        Iterator it = cly.iterator();
                                        while (it.hasNext()) {
                                            EmojiInfo emojiInfo = (EmojiInfo) it.next();
                                            if (e.this.bgH) {
                                                e.this.c(emojiInfo, false);
                                            }
                                        }
                                    }
                                    if (e.this.bgH) {
                                        as.Hm();
                                        com.tencent.mm.y.c.Db().a(w.a.USERINFO_EMOJI_ENCODE_EMOJI_FILE_TASK_LONG, Long.valueOf(System.currentTimeMillis()));
                                    }
                                }
                            });
                            break;
                        }
                        x.d("MicroMsg.emoji.EmojiFileEncryptMgr", "encrypt process file is running.");
                        break;
                    }
                    x.i("MicroMsg.emoji.EmojiFileEncryptMgr", "encrypt is disable.");
                    break;
                case 1:
                    d.aBx().lBo = false;
                    e.aBy().bgH = false;
                    break;
            }
            return false;
        }
    };
    public com.tencent.mm.sdk.b.c lAZ = new com.tencent.mm.sdk.b.c<co>() {
        {
            this.xmG = co.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            co coVar = (co) bVar;
            c aBv = c.aBv();
            if (coVar != null && (coVar instanceof co)) {
                coVar = coVar;
                switch (coVar.frG.scene) {
                    case 0:
                        as.Dt().F(new com.tencent.mm.plugin.emoji.e.c.AnonymousClass1(coVar.frG.frH));
                        break;
                    case 1:
                        Context context = coVar.frG.context;
                        as.Dt().F(new com.tencent.mm.plugin.emoji.e.c.AnonymousClass2(coVar.frG.frH, context));
                        break;
                }
            }
            return false;
        }
    };
    public com.tencent.mm.sdk.b.c lBa = new com.tencent.mm.sdk.b.c<at>() {
        {
            this.xmG = at.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            at atVar = (at) bVar;
            int i = atVar.fpM.type;
            EmojiInfo emojiInfo;
            if (i == 0) {
                emojiInfo = atVar.fpM.fpO;
                if (emojiInfo != null && emojiInfo.clh()) {
                    atVar.fpN.foB = e.aBy().b(emojiInfo);
                    if (!atVar.fpN.foB) {
                        g.pWK.a(252, 8, 1, false);
                    }
                }
            } else if (i == 1) {
                String str = atVar.fpM.fpP;
                if (!bi.oN(str)) {
                    emojiInfo = i.aCl().lCw.YC(str);
                    if (emojiInfo != null && emojiInfo.clh()) {
                        atVar.fpN.foB = e.aBy().b(emojiInfo);
                        if (!atVar.fpN.foB) {
                            g.pWK.a(252, 9, 1, false);
                        }
                    }
                }
            }
            return false;
        }
    };
    public final com.tencent.mm.sdk.b.c lBb = new com.tencent.mm.sdk.b.c<az>() {
        {
            this.xmG = az.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            a aCg = i.aCg();
            x.i("MicroMsg.emoji.EmojiDescNewMgr", "[cpan] language change Current Language:%s LastLanguage:%s", com.tencent.mm.sdk.platformtools.w.cfV().toLowerCase(), aCg.lAJ);
            if (!(bi.oN(aCg.lAJ) || aCg.lAJ.equalsIgnoreCase(r1))) {
                aCg.aBu();
            }
            i.aCl();
            l.lCH = true;
            return false;
        }
    };
    public com.tencent.mm.sdk.b.c lBc = new com.tencent.mm.sdk.b.c<mi>() {
        {
            this.xmG = mi.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            mi miVar = (mi) bVar;
            if (!(miVar == null || !(miVar instanceof mi) || miVar.fEY == null)) {
                String str = miVar.fEY.frQ;
                if (!bi.oN(str) && i.aCl().lCx.Yw(str)) {
                    i.aCg().aBu();
                }
            }
            return false;
        }
    };
    public com.tencent.mm.sdk.b.c lBd = new com.tencent.mm.sdk.b.c<cq>() {
        {
            this.xmG = cq.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            cq cqVar = (cq) bVar;
            if (cqVar != null && (cqVar instanceof cq)) {
                boolean z = cqVar.frJ.frK;
                as.Hm();
                com.tencent.mm.y.c.Db().a(w.a.USERINFO_EMOJI_REWARD_TIP_ENABLE_BOOLEAN, Boolean.valueOf(z));
                i.aCm().lCb = z;
                if (z) {
                    Toast.makeText(ad.getContext(), R.l.dZT, 0).show();
                } else {
                    g.pWK.h(12953, Integer.valueOf(2), "");
                    Toast.makeText(ad.getContext(), R.l.dZR, 0).show();
                }
            }
            return false;
        }
    };
    public com.tencent.mm.sdk.b.c lBe = new com.tencent.mm.sdk.b.c<cn>() {
        {
            this.xmG = cn.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            switch (((cn) bVar).frF.fqh) {
                case 1:
                    f.chQ().chS();
                    e.chP().anS();
                    com.tencent.mm.sdk.b.a.xmy.m(new na());
                    break;
                case 2:
                    e.chP().anS();
                    com.tencent.mm.sdk.b.a.xmy.m(new na());
                    break;
                default:
                    x.i("MicroMsg.emoji.EmojiEventMgr", "unknown event.");
                    break;
            }
            return false;
        }
    };
    public com.tencent.mm.sdk.b.c lBf = new com.tencent.mm.sdk.b.c<hy>() {
        {
            this.xmG = hy.class.getName().hashCode();
        }

        public final /* bridge */ /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            switch (((hy) bVar).fzl.errorCode) {
                case 101:
                    g.pWK.a(401, 3, 1, false);
                    break;
                case 102:
                    g.pWK.a(401, 4, 1, false);
                    break;
                case 104:
                    g.pWK.a(401, 6, 1, false);
                    break;
                case 105:
                    g.pWK.a(401, 7, 1, false);
                    break;
                case 106:
                    g.pWK.a(401, 8, 1, false);
                    break;
                case 107:
                    g.pWK.a(401, 9, 1, false);
                    break;
                case 108:
                    g.pWK.a(401, 10, 1, false);
                    break;
                case 109:
                    g.pWK.a(401, 11, 1, false);
                    break;
                case 110:
                    g.pWK.a(401, 12, 1, false);
                    break;
                case 111:
                    g.pWK.a(401, 13, 1, false);
                    break;
                case MMGIFException.D_GIF_ERR_IMAGE_DEFECT /*112*/:
                    g.pWK.a(401, 14, 1, false);
                    break;
                case 113:
                    g.pWK.a(401, 15, 1, false);
                    break;
            }
            return false;
        }
    };
}
