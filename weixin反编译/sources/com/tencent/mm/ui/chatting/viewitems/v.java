package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.graphics.Color;
import android.text.TextUtils.TruncateAt;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.bl.d;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.x.g;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bb;
import com.tencent.mm.y.c;

public final class v extends b {

    final class a extends com.tencent.mm.ui.chatting.viewitems.b.a {
        protected ImageView hxJ;
        protected NoMeasuredTextView yVp;

        a() {
        }

        public final a dD(View view) {
            super.ds(view);
            this.mXO = (CheckBox) view.findViewById(R.h.bTE);
            this.hxJ = (ImageView) view.findViewById(R.h.csW);
            this.yVp = (NoMeasuredTextView) view.findViewById(R.h.cSa);
            return this;
        }
    }

    public final boolean aXP() {
        return false;
    }

    public final boolean ak(int i, boolean z) {
        if (i == -1879048183) {
            return true;
        }
        return false;
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null) {
            return view;
        }
        view = new p(layoutInflater, R.i.ddL);
        view.setTag(new a().dD(view));
        return view;
    }

    public final void a(com.tencent.mm.ui.chatting.viewitems.b.a aVar, int i, com.tencent.mm.ui.chatting.ChattingUI.a aVar2, au auVar, String str) {
        com.tencent.mm.x.g.a aVar3;
        a aVar4 = (a) aVar;
        g fq = an.bZF().fq(auVar.field_msgId);
        String str2 = auVar.field_content;
        if (fq == null || str2 == null) {
            String str3 = "MicrMsg.ChattingItemHardDeviceMsgLike";
            String str4 = "amessage:%b, %s, %d, %s";
            Object[] objArr = new Object[4];
            objArr[0] = Boolean.valueOf(fq == null);
            objArr[1] = str2;
            objArr[2] = Long.valueOf(auVar.field_msgId);
            objArr[3] = str;
            x.e(str3, str4, objArr);
            aVar3 = null;
        } else {
            aVar3 = com.tencent.mm.x.g.a.I(str2, auVar.field_reserved);
        }
        ar arVar = new ar(auVar, aVar2.yxU, i, null, (byte) 0);
        if (aVar3 != null && (aVar3.showType == 2 || aVar3.hdG == 2 || aVar3.hdG == 4)) {
            b.p(aVar4.hxJ, aVar3.hdK);
            aVar4.yVp.O(aVar2.getResources().getDimension(R.f.bvL));
            aVar4.yVp.setTextColor(Color.parseColor("#BF000000"));
            aVar4.yVp.setEllipsize(TruncateAt.END);
            aVar4.yVp.cqk();
            aVar4.yVp.yoG = true;
            aVar4.yVp.setText(i.a(aVar2.getContext(), aVar3.hdJ));
        }
        aVar.yRn.setOnLongClickListener(s(aVar2));
        aVar.yRn.setOnTouchListener(aVar2.yAM.yBC);
        aVar.yRn.setTag(arVar);
        aVar.yRn.setOnClickListener(t(aVar2));
    }

    public final boolean a(ContextMenu contextMenu, View view, au auVar) {
        contextMenu.add(((ar) view.getTag()).position, 100, 0, view.getContext().getString(R.l.dRS));
        return false;
    }

    public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.ChattingUI.a aVar, au auVar) {
        switch (menuItem.getItemId()) {
            case 100:
                String str = auVar.field_content;
                com.tencent.mm.x.g.a aVar2 = null;
                if (str != null) {
                    aVar2 = com.tencent.mm.x.g.a.fV(str);
                }
                if (aVar2 != null) {
                    l.fr(auVar.field_msgId);
                }
                bb.aL(auVar.field_msgId);
                break;
        }
        return false;
    }

    public final boolean b(View view, com.tencent.mm.ui.chatting.ChattingUI.a aVar, au auVar) {
        x.i("MicrMsg.ChattingItemHardDeviceMsgLike", "hy: user clicked on the like item");
        if (auVar == null) {
            x.i("MicrMsg.ChattingItemHardDeviceMsgLike", "onItemClick, msg is null.");
            return false;
        }
        String str = auVar.field_content;
        com.tencent.mm.x.g.a I = com.tencent.mm.x.g.a.I(str, auVar.field_reserved);
        if (I == null) {
            x.i("MicrMsg.ChattingItemHardDeviceMsgLike", "onItemClick, content is null.");
            return false;
        }
        x.d("MicrMsg.ChattingItemHardDeviceMsgLike", "onItemClick, url is (%s).", I.url);
        if (t.oN(I.url)) {
            as.Hm();
            Intent intent;
            if (c.Ff().Xv(I.hdK).AN()) {
                x.i("MicrMsg.ChattingItemHardDeviceMsgLike", "we run black user");
                return false;
            } else if (I.showType == 2) {
                if (t.oN(I.hds)) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("key_is_latest", true);
                    intent2.putExtra("app_username", I.appName);
                    intent2.putExtra("device_type", I.hdH);
                    intent2.putExtra("locate_to_username", I.hdK);
                    d.b(aVar.getContext(), "exdevice", ".ui.ExdeviceRankInfoUI", intent2);
                } else {
                    intent = new Intent();
                    intent.putExtra("key_rank_info", str);
                    intent.putExtra("key_rank_semi", auVar.field_reserved);
                    intent.putExtra("key_rank_title", I.hdD);
                    intent.putExtra("key_champion_info", I.hdE);
                    intent.putExtra("key_champion_coverimg", I.hdE);
                    intent.putExtra("rank_id", I.hds);
                    intent.putExtra("app_username", I.appName);
                    intent.putExtra("device_type", I.hdH);
                    intent.putExtra("key_champioin_username", I.hdC);
                    intent.putExtra("locate_to_username", I.hdK);
                    d.b(aVar.getContext(), "exdevice", ".ui.ExdeviceRankInfoUI", intent);
                }
                com.tencent.mm.plugin.sport.b.d.qq(30);
                return false;
            } else if (I.showType != 4) {
                return false;
            } else {
                intent = new Intent();
                intent.putExtra("username", I.hdK);
                intent.putExtra("app_username", "gh_43f2581f6fd6");
                d.b(aVar.getContext(), "exdevice", ".ui.ExdeviceProfileUI", intent);
                com.tencent.mm.plugin.sport.b.d.qq(29);
                return false;
            }
        }
        Intent intent3 = new Intent();
        intent3.putExtra("rawUrl", I.url);
        d.b(aVar.getContext(), "webview", ".ui.tools.WebViewUI", intent3);
        return true;
    }
}
