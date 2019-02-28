package com.tencent.mm.ui.chatting.g;

import android.content.Context;
import android.text.SpannableString;
import android.view.View;
import com.tencent.mm.ui.chatting.g.a.a;
import com.tencent.mm.ui.chatting.g.a.b;
import java.lang.ref.WeakReference;
import java.util.Map;

public final class d extends a {
    public d(b bVar) {
        super(bVar);
    }

    final String cwj() {
        return "link_revoke_qrcode";
    }

    final CharSequence a(Map<String, String> map, String str, WeakReference<Context> weakReference) {
        String str2 = (String) map.get(str + ".title");
        final a aVar = new a();
        aVar.username = (String) map.get(str + ".username");
        aVar.hPT = (String) map.get(str + ".qrcode");
        CharSequence spannableString = new SpannableString(str2);
        spannableString.setSpan(new com.tencent.mm.plugin.messenger.a.a() {
            public final void bJ(View view) {
                a aVar = d.this;
                a aVar2 = aVar;
                if (aVar.yQK != null && aVar.yQK.get() != null) {
                    ((b) aVar.yQK.get()).a(view, aVar2);
                }
            }
        }, 0, str2.length(), 33);
        return spannableString;
    }
}
