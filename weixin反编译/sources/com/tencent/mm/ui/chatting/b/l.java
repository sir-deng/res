package com.tencent.mm.ui.chatting.b;

import android.graphics.BitmapFactory.Options;
import com.tencent.mm.a.e;
import com.tencent.mm.f.a.na;
import com.tencent.mm.f.a.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.opensdk.modelmsg.WXEmojiObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.p;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.chatting.af;
import com.tencent.mm.ui.chatting.v;
import com.tencent.mm.y.as;
import java.util.ArrayList;

public final class l {
    public p fhH;
    public c yIE = new c<q>() {
        {
            this.xmG = q.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            final q qVar = (q) bVar;
            if (l.this.fhH.ctm() != null) {
                if (qVar.foq.status == 1) {
                    if (l.this.fhH.ctg() != null) {
                        l.this.fhH.ctg().post(new Runnable() {
                            public final void run() {
                                l.this.fhH.cpZ();
                            }
                        });
                    }
                } else if (l.this.fhH.ctg() != null) {
                    l.this.fhH.ctg().post(new Runnable() {
                        public final void run() {
                            com.tencent.mm.ui.chatting.q.ag(qVar.foq.for, qVar.foq.fos, qVar.foq.status);
                        }
                    });
                }
            }
            return false;
        }
    };
    public c yIF = new c<na>() {
        {
            this.xmG = na.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            if (!(l.this.fhH.ctg() == null || l.this.fhH.ctp() == null)) {
                l.this.fhH.ctg().post(new Runnable() {
                    public final void run() {
                        x.i("MicroMsg.ChattingUI.EmojImpl", "reflesh smiley panel.");
                        l.this.fhH.ctp().ccz();
                    }
                });
            }
            return false;
        }
    };

    public l(p pVar) {
        this.fhH = pVar;
    }

    public final boolean a(String str, String str2, ArrayList<String> arrayList, int i, int i2) {
        long bN = (long) e.bN(str2);
        if (p.Vw(str2) && this.fhH.ctp() != null && this.fhH.ctp().vqk != null && (this.fhH.ctp().vqk instanceof v)) {
            Object obj = null;
            Options options = new Options();
            options.inJustDecodeBounds = true;
            d.decodeFile(str2, options);
            if (options.outHeight > com.tencent.mm.j.b.zL() || options.outWidth > com.tencent.mm.j.b.zL()) {
                obj = 1;
            }
            if (com.tencent.mm.storage.x.fX(str)) {
                x.i("MicroMsg.ChattingUI.EmojImpl", "tummy, add gif msg filePath");
                arrayList.add(str2);
                return true;
            } else if (bN <= ((long) i) && obj == null) {
                EmojiInfo yI;
                EmojiInfo yI2 = ((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().yI(com.tencent.mm.a.g.bV(str2));
                if (yI2 == null) {
                    com.tencent.mm.pluginsdk.b.d emojiMgr = ((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr();
                    this.fhH.cte().getContext();
                    yI = ((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().yI(emojiMgr.yJ(str2));
                } else {
                    yI = yI2;
                }
                if (yI != null) {
                    ((v) this.fhH.ctp().vqk).l(yI);
                    com.tencent.mm.plugin.report.service.g.pWK.h(13459, Long.valueOf(bN), Integer.valueOf(0), yI.Nx(), Integer.valueOf(0));
                } else {
                    x.w("MicroMsg.ChattingUI.EmojImpl", "emoji is null");
                }
                x.i("MicroMsg.ChattingUI.EmojImpl", "cpan send custom emoji.");
                return true;
            } else if (bN > ((long) i2) || obj != null) {
                x.i("MicroMsg.ChattingUI.EmojImpl", "cpan emoji is too large, ignore.filePath:%s", str2);
            } else {
                String a = ((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().a(this.fhH.cte().getContext(), new WXMediaMessage(new WXEmojiObject(str2)), null);
                if (a != null) {
                    ((v) this.fhH.ctp().vqk).m(((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().yI(a));
                }
                com.tencent.mm.plugin.report.service.g.pWK.h(13459, Long.valueOf(bN), Integer.valueOf(0), a, Integer.valueOf(0));
                x.i("MicroMsg.ChattingUI.EmojImpl", "cpan send app emoji msg.");
                return true;
            }
        }
        return false;
    }

    public final boolean aN(au auVar) {
        if (auVar.cjY()) {
            as.Hm();
            if (com.tencent.mm.y.c.isSDCardAvailable()) {
                x.d("MicroMsg.ChattingUI.EmojImpl", "resendEmoji");
                if (!this.fhH.csW().field_username.equals("medianote")) {
                    as.Hm();
                    com.tencent.mm.y.c.Fe().b(new com.tencent.mm.ax.e(auVar.field_talker, auVar.field_msgSvrId));
                }
                af.aF(auVar);
                return true;
            }
            u.fJ(this.fhH.cte().getContext());
            return true;
        } else if (!auVar.cjZ()) {
            return false;
        } else {
            x.d("MicroMsg.ChattingUI.EmojImpl", "resendAppMsgEmoji");
            if (!this.fhH.csW().field_username.equals("medianote")) {
                as.Hm();
                com.tencent.mm.y.c.Fe().b(new com.tencent.mm.ax.e(auVar.field_talker, auVar.field_msgSvrId));
            }
            af.aG(auVar);
            this.fhH.mT(true);
            return true;
        }
    }
}
