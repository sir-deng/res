package com.tencent.mm.ui.chatting.viewitems;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.a.e;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.AppBrandServiceChattingUI;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.chatting.viewitems.b.a;
import com.tencent.mm.y.s;
import java.lang.ref.WeakReference;

final class ae implements a {
    ae() {
    }

    public final void b(a aVar, int i, ChattingUI.a aVar2, au auVar) {
        String str;
        int i2;
        Bundle bundle;
        String csn = aVar2.csn();
        b bVar = (b) aVar;
        Bundle bundle2 = new Bundle();
        bundle2.putString("conv_talker_username", csn);
        if (aVar2 instanceof AppBrandServiceChattingUI.a) {
            str = "scene";
            i2 = 10;
            bundle = bundle2;
        } else if (aVar2.yAR) {
            str = "scene";
            i2 = 2;
            bundle = bundle2;
        } else {
            str = "scene";
            if (s.gI(csn)) {
                i2 = 7;
                bundle = bundle2;
            } else {
                i2 = 1;
                bundle = bundle2;
            }
        }
        bundle.putInt(str, i2);
        bundle2.putLong("msg_id", auVar.field_msgId);
        bundle2.putLong("msg_sever_id", auVar.field_msgSvrId);
        bundle2.putString("send_msg_username", auVar.field_talker);
        e eVar = (e) g.h(e.class);
        long j = auVar.field_msgId;
        CharSequence a = eVar.a(auVar.field_content, bundle2, new WeakReference(aVar2.getContext()), new WeakReference(bVar.yUZ));
        if (a == null || a.length() == 0) {
            bVar.nav.setVisibility(8);
        } else {
            bVar.nav.setVisibility(0);
            bVar.yUZ.setText(a);
            bVar.yUZ.setMovementMethod(av.getInstance());
        }
        bVar.yUZ.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                x.d("MicroMsg.ChattingItemNewXmlSysImpl", "hy: textview clicked");
            }
        });
        bVar.yUZ.invalidate();
    }
}
