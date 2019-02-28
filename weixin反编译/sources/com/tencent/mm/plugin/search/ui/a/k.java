package com.tencent.mm.plugin.search.ui.a;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.af.d;
import com.tencent.mm.af.f;
import com.tencent.mm.f.b.cg;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.d.e;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.search.ui.FTSConvMessageUI;
import com.tencent.mm.pluginsdk.h.n;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bb;
import com.tencent.mm.y.c;
import com.tencent.mm.y.r;
import com.tencent.mm.y.s;

public class k extends com.tencent.mm.plugin.fts.d.a.b {
    public j iZi;
    public CharSequence ikG;
    public CharSequence ikH;
    public CharSequence qkA;
    private b qkB = new b();
    a qkC = new a();
    public int qkz;
    public String username;

    public class b extends com.tencent.mm.plugin.fts.d.a.b.b {
        public b() {
            super();
        }

        public View a(Context context, ViewGroup viewGroup) {
            View inflate = LayoutInflater.from(context).inflate(R.i.djm, viewGroup, false);
            a aVar = k.this.qkC;
            aVar.ikK = (ImageView) inflate.findViewById(R.h.bLM);
            aVar.kHt = (TextView) inflate.findViewById(R.h.cAs);
            aVar.lju = (TextView) inflate.findViewById(R.h.cxM);
            aVar.ljv = (TextView) inflate.findViewById(R.h.cRz);
            aVar.contentView = inflate.findViewById(R.h.cJR);
            inflate.setTag(aVar);
            return inflate;
        }

        public void a(Context context, com.tencent.mm.plugin.fts.d.a.b.a aVar, com.tencent.mm.plugin.fts.d.a.b bVar, Object... objArr) {
            k kVar = (k) bVar;
            a aVar2 = (a) aVar;
            cm(aVar2.contentView);
            com.tencent.mm.pluginsdk.ui.a.b.a(aVar2.ikK, kVar.username);
            e.a(kVar.ikG, aVar2.kHt);
            e.a(kVar.ikH, aVar2.lju);
            e.a(kVar.qkA, aVar2.ljv);
        }

        public boolean a(Context context, com.tencent.mm.plugin.fts.d.a.b bVar) {
            String str = null;
            k kVar = (k) bVar;
            Intent intent;
            d jV;
            Intent intent2;
            if (k.this.qkz < 2) {
                if (f.ka(kVar.username)) {
                    com.tencent.mm.plugin.search.a.ihN.d(new Intent().putExtra("Contact_User", kVar.username), context);
                } else if (f.eG(kVar.username)) {
                    intent = new Intent();
                    intent.putExtra("Contact_User", kVar.username);
                    intent.addFlags(67108864);
                    intent.putExtra("biz_chat_from_scene", 5);
                    com.tencent.mm.bl.d.a(context, ".ui.bizchat.BizChatConversationUI", intent);
                } else if (f.kb(kVar.username)) {
                    jV = f.jV(kVar.username);
                    if (jV != null) {
                        str = jV.Lo();
                    }
                    if (str == null) {
                        str = "";
                    }
                    intent2 = new Intent();
                    intent2.putExtra("rawUrl", str);
                    intent2.putExtra("useJs", true);
                    intent2.putExtra("srcUsername", kVar.username);
                    intent2.putExtra("bizofstartfrom", "enterpriseHomeSubBrand");
                    intent2.addFlags(67108864);
                    com.tencent.mm.bl.d.b(context, "webview", ".ui.tools.WebViewUI", intent2);
                } else {
                    com.tencent.mm.plugin.search.a.ihN.e(new Intent().putExtra("Chat_User", kVar.username).putExtra("finish_direct", true).putExtra("from_global_search", true).putExtra("msg_local_id", kVar.iZi.mRQ).putExtra("highlight_keyword_list", bi.F(k.this.mRM.mRn)), context);
                }
            } else if (f.eG(kVar.username)) {
                intent = new Intent();
                intent.putExtra("Contact_User", kVar.username);
                intent.addFlags(67108864);
                intent.putExtra("biz_chat_from_scene", 5);
                com.tencent.mm.bl.d.a(context, ".ui.bizchat.BizChatConversationUI", intent);
            } else if (f.kb(kVar.username)) {
                jV = f.jV(kVar.username);
                if (jV != null) {
                    str = jV.Lo();
                }
                if (str == null) {
                    str = "";
                }
                intent2 = new Intent();
                intent2.putExtra("rawUrl", str);
                intent2.putExtra("useJs", true);
                intent2.putExtra("srcUsername", kVar.username);
                intent2.putExtra("bizofstartfrom", "enterpriseHomeSubBrand");
                intent2.addFlags(67108864);
                com.tencent.mm.bl.d.b(context, "webview", ".ui.tools.WebViewUI", intent2);
            } else {
                context.startActivity(new Intent(context, FTSConvMessageUI.class).putExtra("Search_Scene", k.this.mUl).putExtra("key_conv", kVar.username).putExtra("key_query", kVar.mRM.mRl).putExtra("key_count", kVar.qkz));
            }
            return true;
        }
    }

    public class a extends com.tencent.mm.plugin.fts.d.a.b.a {
        public View contentView;
        public ImageView ikK;
        public TextView kHt;
        public TextView lju;
        public TextView ljv;

        public a() {
            super();
        }
    }

    public k(int i) {
        super(6, i);
    }

    public void a(Context context, com.tencent.mm.plugin.fts.d.a.b.a aVar, Object... objArr) {
        a aVar2 = (a) aVar;
        this.username = this.iZi.mRd;
        this.ikG = i.d(context, r.gw(this.username), aVar2.kHt.getTextSize());
        if (this.iZi.userData instanceof Integer) {
            this.qkz = ((Integer) this.iZi.userData).intValue();
        }
        if (this.qkz < 2) {
            CharSequence charSequence = "";
            String str = "";
            as.Hm();
            cg dI = c.Fh().dI(this.iZi.mRQ);
            com.tencent.mm.x.g.a fV;
            com.tencent.mm.x.g.a fV2;
            switch (this.iZi.mRc) {
                case 41:
                    str = dI.field_content;
                    if (s.eX(this.username)) {
                        str = bb.hT(str);
                        break;
                    }
                    break;
                case org.xwalk.core.R.styleable.AppCompatTheme_dialogTheme /*42*/:
                    fV = com.tencent.mm.x.g.a.fV(dI.field_content);
                    if (fV != null) {
                        str = fV.title;
                    }
                    charSequence = context.getString(R.l.ekQ);
                    break;
                case org.xwalk.core.R.styleable.AppCompatTheme_dialogPreferredPadding /*43*/:
                    fV = com.tencent.mm.x.g.a.fV(dI.field_content);
                    if (fV != null) {
                        str = fV.title;
                    }
                    charSequence = context.getString(R.l.ekR);
                    break;
                case org.xwalk.core.R.styleable.AppCompatTheme_listDividerAlertDialog /*44*/:
                    fV2 = com.tencent.mm.x.g.a.fV(dI.field_content);
                    if (fV2 != null) {
                        charSequence = fV2.title + ": ";
                        str = fV2.description;
                        break;
                    }
                    break;
                case org.xwalk.core.R.styleable.AppCompatTheme_actionDropDownStyle /*45*/:
                    fV2 = com.tencent.mm.x.g.a.fV(dI.field_content);
                    if (fV2 != null) {
                        str = bi.aD(fV2.title, "") + ": " + bi.aD(fV2.description, "");
                        break;
                    }
                    break;
                case 46:
                case 47:
                    com.tencent.mm.x.g.a fV3 = com.tencent.mm.x.g.a.fV(dI.field_content);
                    if (dI.field_isSend != 1) {
                        str = bi.aD(fV3.hep, "") + ": " + bi.aD(fV3.hel, "");
                        break;
                    } else {
                        str = bi.aD(fV3.hep, "") + ": " + bi.aD(fV3.hem, "");
                        break;
                    }
                case org.xwalk.core.R.styleable.AppCompatTheme_homeAsUpIndicator /*48*/:
                    fV = com.tencent.mm.x.g.a.fV(dI.field_content);
                    if (fV != null) {
                        str = fV.title;
                    }
                    charSequence = context.getString(R.l.ekP);
                    break;
                case org.xwalk.core.R.styleable.AppCompatTheme_actionButtonStyle /*49*/:
                    fV = com.tencent.mm.x.g.a.fV(dI.field_content);
                    if (fV != null) {
                        str = fV.description;
                    }
                    charSequence = context.getString(R.l.ekT);
                    break;
                case 50:
                    String hT;
                    str = dI.field_content;
                    if (s.eX(this.username)) {
                        hT = bb.hT(str);
                    } else {
                        hT = str;
                    }
                    com.tencent.mm.storage.au.b Fr = ((h) g.h(h.class)).aZO().Fr(hT);
                    if (Fr.ckw()) {
                        hT = Fr.nYL;
                    }
                    String str2 = hT;
                    Object charSequence2 = context.getString(R.l.ekS);
                    str = str2;
                    break;
            }
            this.ikH = i.d(context, bi.aD(str, "").replace(10, ' '), (float) com.tencent.mm.plugin.fts.d.d.b.mUu);
            if (bi.N(charSequence2)) {
                this.ikH = com.tencent.mm.plugin.fts.d.f.a(com.tencent.mm.plugin.fts.d.b.a.a(this.ikH, this.mRM, (float) com.tencent.mm.plugin.fts.d.f.a.mUz, com.tencent.mm.plugin.fts.d.d.b.mUv)).mVW;
            } else {
                this.ikH = com.tencent.mm.plugin.fts.d.f.a(com.tencent.mm.plugin.fts.d.b.a.a(this.ikH, this.mRM, ((float) com.tencent.mm.plugin.fts.d.f.a.mUz) - com.tencent.mm.plugin.fts.d.d.b.mUv.measureText(charSequence2.toString()), com.tencent.mm.plugin.fts.d.d.b.mUv)).mVW;
                this.ikH = TextUtils.concat(new CharSequence[]{charSequence2, this.ikH});
            }
            this.qkA = n.c(context, this.iZi.timestamp, true);
            return;
        }
        this.ikH = context.getResources().getString(R.l.eJi, new Object[]{Integer.valueOf(this.qkz)});
    }

    public com.tencent.mm.plugin.fts.d.a.b.b adG() {
        return this.qkB;
    }

    protected final com.tencent.mm.plugin.fts.d.a.b.a adH() {
        return this.qkC;
    }

    public final int adJ() {
        return this.iZi.mRZ;
    }

    public int aOh() {
        if (this.qkz < 2) {
            return 0;
        }
        return 1;
    }
}
