package com.tencent.mm.plugin.search.ui.a;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.af.d;
import com.tencent.mm.af.f;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.search.ui.FTSConvTalkerMessageUI;
import com.tencent.mm.plugin.search.ui.a.k.b;
import com.tencent.mm.sdk.platformtools.bi;

public final class n extends k {
    public j qjU;
    private a qkK = new a();
    public int showType;

    public class a extends b {
        public a() {
            super();
        }

        public final View a(Context context, ViewGroup viewGroup) {
            View inflate = LayoutInflater.from(context).inflate(R.i.djm, viewGroup, false);
            com.tencent.mm.plugin.search.ui.a.k.a aVar = n.this.qkC;
            aVar.ikK = (ImageView) inflate.findViewById(R.h.bLM);
            aVar.kHt = (TextView) inflate.findViewById(R.h.cAs);
            aVar.lju = (TextView) inflate.findViewById(R.h.cxM);
            aVar.contentView = inflate.findViewById(R.h.cJR);
            aVar.ljv = (TextView) inflate.findViewById(R.h.cRz);
            aVar.ikK.getLayoutParams().width = com.tencent.mm.bu.a.aa(context, R.f.bvQ);
            aVar.ikK.getLayoutParams().height = com.tencent.mm.bu.a.aa(context, R.f.bvQ);
            inflate.setTag(aVar);
            return inflate;
        }

        public final boolean a(Context context, com.tencent.mm.plugin.fts.d.a.b bVar) {
            String str = null;
            k kVar = (k) bVar;
            String str2 = kVar.iZi.mRd;
            Intent intent;
            d jV;
            Intent intent2;
            if (n.this.qkz <= 1) {
                if (f.ka(str2)) {
                    com.tencent.mm.plugin.search.a.ihN.d(new Intent().putExtra("Contact_User", str2), context);
                } else if (f.eG(str2)) {
                    intent = new Intent();
                    intent.putExtra("Contact_User", str2);
                    intent.addFlags(67108864);
                    intent.putExtra("biz_chat_from_scene", 5);
                    com.tencent.mm.bl.d.a(context, ".ui.bizchat.BizChatConversationUI", intent);
                } else if (f.kb(str2)) {
                    jV = f.jV(str2);
                    if (jV != null) {
                        str = jV.Lo();
                    }
                    if (str == null) {
                        str = "";
                    }
                    intent2 = new Intent();
                    intent2.putExtra("rawUrl", str);
                    intent2.putExtra("useJs", true);
                    intent2.putExtra("srcUsername", str2);
                    intent2.putExtra("bizofstartfrom", "enterpriseHomeSubBrand");
                    intent2.addFlags(67108864);
                    com.tencent.mm.bl.d.b(context, "webview", ".ui.tools.WebViewUI", intent2);
                } else {
                    com.tencent.mm.plugin.search.a.ihN.e(new Intent().putExtra("Chat_User", str2).putExtra("finish_direct", true).putExtra("from_global_search", true).putExtra("msg_local_id", kVar.iZi.mRQ).putExtra("highlight_keyword_list", bi.F(n.this.mRM.mRn)), context);
                }
            } else if (f.eG(str2)) {
                intent = new Intent();
                intent.putExtra("Contact_User", str2);
                intent.addFlags(67108864);
                intent.putExtra("biz_chat_from_scene", 5);
                com.tencent.mm.bl.d.a(context, ".ui.bizchat.BizChatConversationUI", intent);
            } else if (f.kb(str2)) {
                jV = f.jV(str2);
                if (jV != null) {
                    str = jV.Lo();
                }
                if (str == null) {
                    str = "";
                }
                intent2 = new Intent();
                intent2.putExtra("rawUrl", str);
                intent2.putExtra("useJs", true);
                intent2.putExtra("srcUsername", str2);
                intent2.putExtra("bizofstartfrom", "enterpriseHomeSubBrand");
                intent2.addFlags(67108864);
                com.tencent.mm.bl.d.b(context, "webview", ".ui.tools.WebViewUI", intent2);
            } else {
                context.startActivity(new Intent(context, FTSConvTalkerMessageUI.class).putExtra("Search_Scene", n.this.mUl).putExtra("key_talker_query", n.this.qjU.mRM.mRl).putExtra("key_talker", n.this.qjU.mRd).putExtra("key_conv", kVar.username).putExtra("key_query", kVar.mRM.mRl).putExtra("detail_type", n.this.showType));
            }
            return true;
        }
    }

    public n(int i) {
        super(i);
    }

    public final com.tencent.mm.plugin.fts.d.a.b.b adG() {
        return this.qkK;
    }

    public final int aOh() {
        if (this.qkz < 2) {
            return 0;
        }
        return 2;
    }
}
