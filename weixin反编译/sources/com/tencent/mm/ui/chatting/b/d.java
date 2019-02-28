package com.tencent.mm.ui.chatting.b;

import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.ac.b;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.plugin.messenger.a.f;
import com.tencent.mm.pluginsdk.ui.applet.e.a;
import com.tencent.mm.pluginsdk.ui.applet.o;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.transmit.SelectConversationUI;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.r;
import com.tencent.mm.y.s;

public final class d {
    public p fhH;

    public d(p pVar) {
        this.fhH = pVar;
    }

    public final boolean e(int i, int i2, Intent intent) {
        final String stringExtra;
        String gw;
        final String stringExtra2;
        switch (i) {
            case 223:
                if (i2 == -1 && intent != null) {
                    stringExtra = intent.getStringExtra("be_send_card_name");
                    if (this.fhH.csS() && x.Xg(stringExtra)) {
                        try {
                            h.a(this.fhH.cte().getActivity(), this.fhH.cte().getActivity().getString(R.l.ePx), "", null);
                        } catch (Throwable th) {
                        }
                        return true;
                    }
                    String string;
                    gw = r.gw(stringExtra);
                    stringExtra2 = intent.getStringExtra("received_card_name");
                    final boolean booleanExtra = intent.getBooleanExtra("Is_Chatroom", false);
                    a aVar = new a(this.fhH.cte().getContext());
                    b.a(stringExtra, true, -1);
                    as.Hm();
                    ag Xt = c.Ff().Xt(stringExtra);
                    if (s.gN(Xt.field_verifyFlag)) {
                        string = this.fhH.cte().getResources().getString(R.l.dFz);
                    } else if (x.Xg(stringExtra)) {
                        string = SelectConversationUI.d(ad.getContext(), Xt);
                    } else {
                        string = this.fhH.cte().getResources().getString(R.l.dFA);
                    }
                    aVar.bT(stringExtra2).SU(new StringBuffer(string).append(gw).toString()).f(Boolean.valueOf(true)).Co(R.l.dGL).a(new o.a() {
                        public final void a(boolean z, String str, int i) {
                            d.this.fhH.cte().hideVKB();
                            if (z) {
                                f.aZN().l(stringExtra, stringExtra2, booleanExtra);
                                f.aZN().dq(str, stringExtra2);
                            }
                        }
                    }).pDT.show();
                }
                return true;
            case 224:
                if (i2 == -1 && intent != null) {
                    stringExtra = intent.getStringExtra("be_send_card_name");
                    gw = intent.getStringExtra("received_card_name");
                    stringExtra2 = intent.getStringExtra("custom_send_text");
                    boolean booleanExtra2 = intent.getBooleanExtra("Is_Chatroom", false);
                    Intent intent2 = new Intent(this.fhH.cte().getContext(), ChattingUI.class);
                    intent2.putExtra("Chat_User", gw);
                    intent2.putExtra("send_card_username", stringExtra);
                    intent2.putExtra("send_card_edittext", stringExtra2);
                    intent2.putExtra("Is_Chatroom", booleanExtra2);
                    this.fhH.cte().startActivity(intent2);
                }
                return true;
            default:
                return false;
        }
    }
}
