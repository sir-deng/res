package com.tencent.mm.ui.chatting.viewitems;

import android.graphics.Bitmap;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ap.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.pluginsdk.ui.emoji.RTChattingEmojiView;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.y.as;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public final class h {

    public static class a extends com.tencent.mm.ui.chatting.r.d {
        a(com.tencent.mm.ui.chatting.ChattingUI.a aVar) {
            super(aVar);
        }

        public final void a(View view, com.tencent.mm.ui.chatting.ChattingUI.a aVar, au auVar) {
            ar arVar = (ar) view.getTag();
            as.Hm();
            if (com.tencent.mm.y.c.isSDCardAvailable()) {
                ((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().a(this.yyH.getContext(), arVar.fFE);
                com.tencent.mm.plugin.report.service.g.pWK.h(11592, Integer.valueOf(0));
            }
        }
    }

    public static final class b extends com.tencent.mm.ui.chatting.viewitems.b.a {
        public static Map<String, WeakReference<b>> yTa = new HashMap();
        ProgressBar pyj;
        ImageView yRZ;
        RTChattingEmojiView ySV;
        ImageView ySW;
        ProgressBar ySX;
        ImageView ySY;
        TextView ySZ;

        public final com.tencent.mm.ui.chatting.viewitems.b.a q(View view, boolean z) {
            super.ds(view);
            this.ljv = (TextView) view.findViewById(R.h.bVh);
            this.ySV = (RTChattingEmojiView) view.findViewById(R.h.bTK);
            this.mXO = (CheckBox) view.findViewById(R.h.bTE);
            this.kbO = view.findViewById(R.h.bUE);
            this.ySX = (ProgressBar) view.findViewById(R.h.bTS);
            this.ySY = (ImageView) view.findViewById(R.h.bVe);
            this.ySZ = (TextView) view.findViewById(R.h.bVb);
            if (!z) {
                this.pyj = (ProgressBar) view.findViewById(R.h.cUg);
                this.yRo = (ImageView) view.findViewById(R.h.bVd);
                this.yRZ = (ImageView) view.findViewById(R.h.bVf);
            }
            if (this.ySW != null) {
                ((ViewGroup) this.ySW.getParent()).setBackgroundDrawable(null);
            }
            this.qng = (TextView) view.findViewById(R.h.bVm);
            return this;
        }

        public static void j(String str, int i, int i2) {
            if (yTa.containsKey(str)) {
                b bVar = (b) ((WeakReference) yTa.get(str)).get();
                if (bVar != null) {
                    switch (i2) {
                        case 0:
                            bVar.ySX.setVisibility(0);
                            bVar.ySZ.setVisibility(8);
                            bVar.ySY.setVisibility(8);
                            bVar.ySX.setProgress(0);
                            return;
                        case 1:
                            bVar.ySX.setVisibility(8);
                            bVar.ySZ.setVisibility(8);
                            bVar.ySY.setVisibility(8);
                            return;
                        case 2:
                            bVar.ySX.setVisibility(8);
                            bVar.ySZ.setVisibility(8);
                            bVar.ySY.setVisibility(0);
                            bVar.ySX.setProgress(i);
                            bVar.ySY.setImageResource(R.g.bBR);
                            return;
                        default:
                            return;
                    }
                }
                return;
            }
            x.i("AppMsgEmojiItemHolder", "no contain attchid:%s");
        }
    }

    public static class c extends b {
        protected a yTb;
        private com.tencent.mm.ui.chatting.ChattingUI.a yyH;

        private a y(com.tencent.mm.ui.chatting.ChattingUI.a aVar) {
            if (this.yTb == null) {
                this.yTb = new a(aVar);
            }
            return this.yTb;
        }

        public final boolean aXP() {
            return false;
        }

        public final boolean ak(int i, boolean z) {
            if (z || i != 1048625) {
                return false;
            }
            return true;
        }

        public final View a(LayoutInflater layoutInflater, View view) {
            if (view != null && view.getTag() != null) {
                return view;
            }
            view = new p(layoutInflater, R.i.dds);
            view.setTag(new b().q(view, true));
            return view;
        }

        public final void a(com.tencent.mm.ui.chatting.viewitems.b.a aVar, int i, com.tencent.mm.ui.chatting.ChattingUI.a aVar2, au auVar, String str) {
            com.tencent.mm.x.g.a I;
            EmojiInfo emojiInfo;
            this.yyH = aVar2;
            aVar2.yEx.aT(auVar);
            b bVar = (b) aVar;
            String str2 = auVar.field_content;
            if (str2 != null) {
                I = com.tencent.mm.x.g.a.I(str2, auVar.field_reserved);
            } else {
                I = null;
            }
            if (I == null || I.hcO == null) {
                emojiInfo = null;
            } else {
                emojiInfo = ((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().yI(I.hcO);
            }
            if (emojiInfo == null || !emojiInfo.clh()) {
                Bitmap u;
                String B = o.PC().B(auVar.field_imgPath, true);
                Bitmap lC = o.PG().lC(B);
                if (lC == null || lC.isRecycled()) {
                    lC = com.tencent.mm.sdk.platformtools.d.decodeFile(B, null);
                    o.PG().i(B, lC);
                }
                if (emojiInfo == null) {
                    bVar.ySY.setVisibility(0);
                    bVar.ySX.setVisibility(8);
                    bVar.ySZ.setText(t.by(I == null ? 0 : (long) I.hcM));
                    bVar.ySZ.setVisibility(0);
                    bVar.ySY.setImageResource(R.g.bBQ);
                } else {
                    bVar.ySX.setVisibility(0);
                    bVar.ySZ.setVisibility(8);
                    bVar.ySY.setVisibility(8);
                    bVar.ySX.setProgress(0);
                    bVar.ySZ.setVisibility(8);
                }
                if (!(I == null || bi.oN(I.hcO))) {
                    b.yTa.put(I.hcO, new WeakReference(bVar));
                }
                if (lC == null || lC.isRecycled()) {
                    u = com.tencent.mm.sdk.platformtools.d.u(this.yyH.getResources().getDrawable(R.g.byZ));
                } else {
                    u = lC;
                }
                bVar.ySV.setImageBitmap(u);
            } else {
                bVar.ySV.a(emojiInfo, auVar.field_msgId);
                bVar.ySY.setVisibility(8);
                bVar.ySX.setVisibility(8);
                bVar.ySZ.setVisibility(8);
                bVar.ySY.setVisibility(8);
                if (!(I == null || bi.oN(I.hcO))) {
                    b.yTa.remove(I.hcO);
                }
                b.a(auVar, emojiInfo);
            }
            bVar.ySV.setTag(new ar(auVar, aVar2.yxU, i, str, (byte) 0));
            bVar.ySV.setOnClickListener(y(aVar2));
            bVar.ySV.setOnLongClickListener(s(aVar2));
            bVar.ySV.setOnTouchListener(aVar2.yAM.yBC);
            bVar.ySY.setOnClickListener(y(aVar2));
            bVar.ySY.setOnLongClickListener(s(aVar2));
            bVar.ySY.setTag(bVar.ySV.getTag());
        }

        protected final boolean r(com.tencent.mm.ui.chatting.ChattingUI.a aVar) {
            return aVar.yxU;
        }

        public final boolean a(ContextMenu contextMenu, View view, au auVar) {
            com.tencent.mm.x.g.a aVar;
            int i = ((ar) view.getTag()).position;
            aj XW = aj.XW(auVar.field_content);
            com.tencent.mm.x.g.a I = com.tencent.mm.x.g.a.I(auVar.field_content, auVar.field_reserved);
            if (I == null) {
                I = new com.tencent.mm.x.g.a();
                I.hcO = XW.frM;
                aVar = I;
            } else {
                aVar = I;
            }
            if (!(t.oN(aVar.hcO) || aVar.hcO.equals("-1"))) {
                EmojiInfo yI = ((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().yI(aVar.hcO);
                if (yI != null) {
                    if (!(yI.field_catalog == EmojiInfo.xIN || yI.clk())) {
                        contextMenu.add(i, 104, 0, view.getContext().getString(R.l.dSc));
                    }
                    if (yI != null) {
                        com.tencent.mm.plugin.report.service.g.pWK.h(12789, Integer.valueOf(0), yI.Nx(), Integer.valueOf(0), yI.field_designerID, yI.field_groupId, "", "", "", "", yI.field_activityid);
                    }
                    boolean clh = yI.clh();
                    if (yI.field_catalog == EmojiInfo.xIN || bi.oN(yI.field_groupId) || (!bi.oN(yI.field_groupId) && ((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().yL(yI.field_groupId))) {
                        if (clh) {
                            contextMenu.add(i, 113, 0, R.l.eEP);
                        } else {
                            x.i("MicroMsg.ChattingItemAppMsgEmojiFrom", "emoji file no exist. cannot save or resend.");
                        }
                    }
                }
            }
            if (!this.yyH.ctJ()) {
                contextMenu.add(i, 100, 0, view.getContext().getString(R.l.dRQ));
            }
            return true;
        }

        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.ChattingUI.a aVar, au auVar) {
            return false;
        }

        public final boolean b(View view, com.tencent.mm.ui.chatting.ChattingUI.a aVar, au auVar) {
            return false;
        }
    }

    public static class d extends b {
        protected a yTb;
        private com.tencent.mm.ui.chatting.ChattingUI.a yyH;

        public final boolean aXP() {
            return true;
        }

        public final boolean ak(int i, boolean z) {
            if (z && i == 1048625) {
                return true;
            }
            return false;
        }

        public final View a(LayoutInflater layoutInflater, View view) {
            if (view != null && view.getTag() != null) {
                return view;
            }
            view = new p(layoutInflater, R.i.ddX);
            view.setTag(new b().q(view, false));
            return view;
        }

        public final void a(com.tencent.mm.ui.chatting.viewitems.b.a aVar, int i, com.tencent.mm.ui.chatting.ChattingUI.a aVar2, au auVar, String str) {
            this.yyH = aVar2;
            aVar2.yEx.aT(auVar);
            aVar = (b) aVar;
            if (auVar != null) {
                EmojiInfo emojiInfo;
                com.tencent.mm.x.g.a aVar3;
                EmojiInfo emojiInfo2;
                RTChattingEmojiView rTChattingEmojiView;
                String str2 = auVar.field_content;
                aj XW = aj.XW(auVar.field_content);
                if (XW.hXo) {
                    emojiInfo = null;
                    aVar3 = null;
                } else {
                    if (str2 != null) {
                        aVar3 = com.tencent.mm.x.g.a.I(str2, auVar.field_reserved);
                    } else {
                        aVar3 = null;
                    }
                    emojiInfo = aVar3 != null ? ((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().yI(aVar3.hcO) : null;
                }
                if (XW.frM == null || XW.frM.equals("-1") || emojiInfo != null) {
                    emojiInfo2 = emojiInfo;
                } else {
                    emojiInfo2 = ((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().yI(XW.frM);
                }
                if (emojiInfo2 == null || !emojiInfo2.clh()) {
                    long j;
                    String B = o.PC().B(auVar.field_imgPath, true);
                    Bitmap lC = o.PG().lC(B);
                    if (lC == null || lC.isRecycled()) {
                        lC = com.tencent.mm.sdk.platformtools.d.decodeFile(B, null);
                        o.PG().i(B, lC);
                    }
                    aVar.pyj.setVisibility(8);
                    aVar.ySY.setVisibility(0);
                    aVar.ySX.setVisibility(8);
                    TextView textView = aVar.ySZ;
                    if (aVar3 == null) {
                        j = 0;
                    } else {
                        j = (long) aVar3.hcM;
                    }
                    textView.setText(t.by(j));
                    aVar.ySZ.setVisibility(0);
                    aVar.ySY.setImageResource(R.g.bBQ);
                    if (lC == null || lC.isRecycled()) {
                        lC = com.tencent.mm.sdk.platformtools.d.u(this.yyH.getResources().getDrawable(R.g.byZ));
                    }
                    aVar.ySV.setImageBitmap(lC);
                    if (!(aVar3 == null || bi.oN(aVar3.hcO))) {
                        b.yTa.put(aVar3.hcO, new WeakReference(aVar));
                    }
                } else {
                    int i2;
                    aVar.ySV.a(emojiInfo2, auVar.field_msgId);
                    rTChattingEmojiView = aVar.ySV;
                    if (rTChattingEmojiView.vzy != null) {
                        rTChattingEmojiView.vzy.resume();
                    }
                    boolean z = auVar.field_status != 1;
                    ProgressBar progressBar = aVar.pyj;
                    if (z) {
                        i2 = 4;
                    } else {
                        i2 = 0;
                    }
                    progressBar.setVisibility(i2);
                    b.a(auVar, emojiInfo2);
                }
                if (b.cwm()) {
                    if (auVar != null && auVar.field_status == 2 && b.a(aVar2.yAM, auVar.field_msgId)) {
                        if (aVar.yRZ != null) {
                            aVar.yRZ.setVisibility(0);
                        }
                    } else if (aVar.yRZ != null) {
                        aVar.yRZ.setVisibility(8);
                    }
                }
                aVar.ySV.setTag(new ar(auVar, aVar2.yxU, i, aVar2.yAM.hnt, (byte) 0));
                rTChattingEmojiView = aVar.ySV;
                if (this.yTb == null) {
                    this.yTb = new a(aVar2);
                }
                rTChattingEmojiView.setOnClickListener(this.yTb);
                aVar.ySV.setOnLongClickListener(s(aVar2));
                aVar.ySV.setOnTouchListener(aVar2.yAM.yBC);
                a(i, aVar, auVar, aVar2.yAM.hnt, aVar2.yxU, aVar2);
            }
        }

        public final boolean a(ContextMenu contextMenu, View view, au auVar) {
            as.Hm();
            if (com.tencent.mm.y.c.isSDCardAvailable()) {
                com.tencent.mm.x.g.a aVar;
                int i = ((ar) view.getTag()).position;
                aj XW = aj.XW(auVar.field_content);
                com.tencent.mm.x.g.a I = com.tencent.mm.x.g.a.I(auVar.field_content, auVar.field_reserved);
                if (I == null) {
                    I = new com.tencent.mm.x.g.a();
                    I.hcO = XW.frM;
                    aVar = I;
                } else {
                    aVar = I;
                }
                if (!(t.oN(aVar.hcO) || aVar.hcO.equals("-1"))) {
                    EmojiInfo yI = ((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().yI(aVar.hcO);
                    if (yI != null) {
                        if (!(yI.field_catalog == EmojiInfo.xIN || yI.clk())) {
                            contextMenu.add(i, 104, 0, view.getContext().getString(R.l.dSc));
                        }
                        com.tencent.mm.plugin.report.service.g.pWK.h(12789, Integer.valueOf(0), yI.Nx(), Integer.valueOf(0), yI.field_designerID, yI.field_groupId, "", "", "", "", yI.field_activityid);
                        boolean clh = yI.clh();
                        if (yI.field_catalog == EmojiInfo.xIN || bi.oN(yI.field_groupId) || (!bi.oN(yI.field_groupId) && ((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().yL(yI.field_groupId))) {
                            if (clh) {
                                contextMenu.add(i, 113, 0, R.l.eEP);
                            } else {
                                x.i("MicroMsg.ChattingItemAppMsgEmojiTo", "emoji file no exist. cannot save or resend.");
                            }
                        }
                    } else {
                        x.i("MicroMsg.ChattingItemAppMsgEmojiTo", "emoji is null. app content md5 is :%s", aVar.hcO);
                    }
                }
                if (auVar.field_status == 5) {
                    contextMenu.add(i, 103, 0, view.getContext().getString(R.l.dST));
                }
                if (!auVar.cjK() && auVar.cjZ() && ((auVar.field_status == 2 || auVar.gkH == 1) && b.a(auVar, this.yyH) && b.ZX(auVar.field_talker))) {
                    contextMenu.add(i, 123, 0, view.getContext().getString(R.l.dSb));
                }
                if (!this.yyH.ctJ()) {
                    contextMenu.add(i, 100, 0, view.getContext().getString(R.l.dRQ));
                }
            }
            return true;
        }

        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.ChattingUI.a aVar, au auVar) {
            return false;
        }

        public final boolean b(View view, com.tencent.mm.ui.chatting.ChattingUI.a aVar, au auVar) {
            return false;
        }
    }
}
