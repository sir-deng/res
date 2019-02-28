package com.tencent.mm.view.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.a.e;
import com.tencent.mm.ap.a.c.d;
import com.tencent.mm.ap.a.c.l;
import com.tencent.mm.f.a.co;
import com.tencent.mm.plugin.gif.g;
import com.tencent.mm.plugin.m.a.f;
import com.tencent.mm.plugin.m.a.h;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.v;
import java.util.ArrayList;

public final class c extends a {
    private l hGb = new l() {
        public final Bitmap I(byte[] bArr) {
            return g.aA(bArr);
        }

        public final Bitmap lG(String str) {
            return g.aA(e.d(str, 0, e.bN(str)));
        }
    };
    private d lHD = new d() {
        public final byte[] f(Object... objArr) {
            if (objArr != null && objArr.length > 0) {
                Object obj = objArr[0];
                if (obj != null && (obj instanceof EmojiInfo)) {
                    return ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.emoji.b.c.class)).getProvider().a((EmojiInfo) obj);
                }
            }
            return null;
        }
    };
    ArrayList<EmojiInfo> lJz;
    private com.tencent.mm.ap.a.c.e zNz = new com.tencent.mm.ap.a.c.e() {
        public final void e(Object... objArr) {
            if (objArr != null && objArr.length > 0) {
                Object obj = objArr[0];
                if (obj != null && (obj instanceof EmojiInfo)) {
                    b coVar = new co();
                    coVar.frG.scene = 1;
                    coVar.frG.frH = (EmojiInfo) obj;
                    coVar.frG.context = c.this.mContext;
                    com.tencent.mm.sdk.b.a.xmy.m(coVar);
                }
            }
        }
    };

    class a {
        TextView ikM;
        ImageView jIs;
        TextView zNB;

        public a(View view) {
            this.jIs = (ImageView) view.findViewById(com.tencent.mm.plugin.m.a.e.bLk);
            this.ikM = (TextView) view.findViewById(com.tencent.mm.plugin.m.a.e.lOW);
            this.zNB = (TextView) view.findViewById(com.tencent.mm.plugin.m.a.e.lOX);
            this.zNB.setTextSize(1, 12.0f);
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        return pg(i);
    }

    public c(Context context, com.tencent.mm.view.f.a aVar) {
        super(context, aVar);
    }

    public final int getCount() {
        if (this.zNv != this.zMw - 1) {
            return this.zNu;
        }
        int i = this.kLd - (this.zNv * this.zNu);
        if (i < 0) {
            return 0;
        }
        return i;
    }

    private EmojiInfo pg(int i) {
        int i2 = (this.zNv * this.zNu) + i;
        if (this.zMu == 25 && this.zMD.itU != ChatFooterPanel.vqo) {
            i2--;
        }
        if (this.lJz == null || i2 < 0 || i2 >= this.lJz.size()) {
            return null;
        }
        return (EmojiInfo) this.lJz.get(i2);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null || view.getTag() == null) {
            view = v.fw(this.mContext).inflate(f.lPl, null);
            view.setLayoutParams(new LayoutParams(this.zMD.getColumnWidth(), this.zMD.zPE));
            a aVar2 = new a(view);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        if (this.zMu == 25 && this.zNv == 0 && i == 0 && this.zMD.itU != ChatFooterPanel.vqo) {
            ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.emoji.b.c.class)).getProvider().aBL().a("", aVar.jIs);
            aVar.jIs.setBackgroundResource(com.tencent.mm.plugin.m.a.d.lOM);
            aVar.jIs.setImageResource(com.tencent.mm.plugin.m.a.g.lPq);
            aVar.jIs.setContentDescription(view.getContext().getString(h.eLA));
            int aBH = ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.emoji.b.c.class)).getProvider().aBH();
            com.tencent.mm.bt.a.ceF();
            if (aBH > (((com.tencent.mm.kernel.b.h) com.tencent.mm.kernel.g.Dn().CU()).DZ() ? bi.getInt(com.tencent.mm.j.g.Af().getValue("CustomEmojiMaxSize"), 150) : com.tencent.mm.bt.a.xjI.getInt("EmotionRecommandCount", 3))) {
                aVar.zNB.setVisibility(0);
                aVar.zNB.setText(h.lPx);
            } else {
                aVar.zNB.setVisibility(8);
            }
        } else {
            aVar.zNB.setVisibility(8);
            EmojiInfo pg = pg(i);
            if (pg == null) {
                x.w("MicroMsg.smiley.EmojiSmileyAdapter", "emoji is null.");
                aVar.jIs.setVisibility(8);
                aVar.ikM.setVisibility(8);
                ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.emoji.b.c.class)).getProvider().aBL().a("", aVar.jIs);
            } else {
                aVar.jIs.setVisibility(0);
                CharSequence yF = ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.emoji.b.c.class)).getProvider().yF(pg.Nx());
                if (bi.oN(yF) || this.zMu != 23) {
                    aVar.ikM.setVisibility(8);
                } else {
                    aVar.ikM.setText(yF);
                    aVar.ikM.setVisibility(0);
                }
                aVar.jIs.setBackgroundResource(com.tencent.mm.plugin.m.a.d.bGs);
                String name;
                String replaceAll;
                com.tencent.mm.ap.a.a aBL;
                com.tencent.mm.ap.a.a.c.a aVar3;
                com.tencent.mm.ap.a.a.c PQ;
                if (this.zMu == 25) {
                    if (pg.field_catalog == EmojiGroupInfo.xIF || pg.field_catalog == EmojiInfo.xIM || pg.field_catalog == EmojiInfo.xIL) {
                        name = pg.getName();
                        if (bi.oN(name)) {
                            x.i("MicroMsg.smiley.EmojiSmileyAdapter", "name is null");
                        } else {
                            replaceAll = name.replaceAll(".png", "");
                            aBL = ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.emoji.b.c.class)).getProvider().aBL();
                            ImageView imageView = aVar.jIs;
                            com.tencent.mm.ap.a.a.c.a aVar4 = new com.tencent.mm.ap.a.a.c.a();
                            aVar4.hFq = 3;
                            aVar4.hFE = com.tencent.mm.plugin.m.a.d.bGs;
                            aBL.a(replaceAll, imageView, aVar4.PQ());
                            if (replaceAll.equalsIgnoreCase("dice")) {
                                aVar.jIs.setContentDescription(view.getContext().getString(h.lPv));
                            } else if (replaceAll.equalsIgnoreCase("jsb")) {
                                aVar.jIs.setContentDescription(view.getContext().getString(h.lPw));
                            }
                        }
                    } else {
                        replaceAll = pg.clq();
                        name = replaceAll + "_cover";
                        aVar3 = new com.tencent.mm.ap.a.a.c.a();
                        aVar3.hFq = 1;
                        aVar3.hFE = com.tencent.mm.plugin.m.a.d.bGs;
                        aVar3.hFx = true;
                        aVar3.fwx = name;
                        aVar3.hFn = replaceAll;
                        aVar3.hFy = true;
                        aVar3.hFO = new Object[]{pg};
                        aVar3.hFN = true;
                        PQ = aVar3.PQ();
                        if (((com.tencent.mm.kernel.b.h) com.tencent.mm.kernel.g.Dn().CU()).DZ()) {
                            ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.emoji.b.c.class)).getProvider().aBL().a(replaceAll, aVar.jIs, PQ, this.zNz, this.lHD, this.hGb);
                        } else {
                            ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.emoji.b.c.class)).getProvider().aBL().a(replaceAll, aVar.jIs, PQ, null, this.lHD, this.hGb);
                        }
                    }
                } else if (!pg.field_groupId.equalsIgnoreCase(String.valueOf(EmojiGroupInfo.xIE))) {
                    replaceAll = pg.clq();
                    name = replaceAll + "_cover";
                    aVar3 = new com.tencent.mm.ap.a.a.c.a();
                    aVar3.hFq = 1;
                    aVar3.hFE = com.tencent.mm.plugin.m.a.d.bGs;
                    aVar3.hFx = true;
                    aVar3.fwx = name;
                    aVar3.hFn = replaceAll;
                    aVar3.hFy = true;
                    aVar3.hFO = new Object[]{pg};
                    aVar3.hFN = true;
                    PQ = aVar3.PQ();
                    if (((com.tencent.mm.kernel.b.h) com.tencent.mm.kernel.g.Dn().CU()).DZ()) {
                        ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.emoji.b.c.class)).getProvider().aBL().a(replaceAll, aVar.jIs, PQ, this.zNz, this.lHD, this.hGb);
                    } else {
                        ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.emoji.b.c.class)).getProvider().aBL().a(replaceAll, aVar.jIs, PQ, null, this.lHD, this.hGb);
                    }
                } else if (bi.oN(pg.getName())) {
                    x.i("MicroMsg.smiley.EmojiSmileyAdapter", "name is null");
                } else {
                    replaceAll = (bi.oN(pg.wl()) ? pg.getName() : pg.wl()).replaceAll(".png", "");
                    aBL = ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.emoji.b.c.class)).getProvider().aBL();
                    ImageView imageView2 = aVar.jIs;
                    com.tencent.mm.ap.a.a.c.a aVar5 = new com.tencent.mm.ap.a.a.c.a();
                    aVar5.hFq = 3;
                    aVar5.hFE = com.tencent.mm.plugin.m.a.d.bGs;
                    aBL.a(replaceAll, imageView2, aVar5.PQ());
                }
            }
        }
        return view;
    }
}
