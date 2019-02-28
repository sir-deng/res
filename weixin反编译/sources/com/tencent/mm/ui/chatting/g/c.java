package com.tencent.mm.ui.chatting.g;

import android.content.Context;
import android.text.SpannableString;
import android.view.View;
import com.tencent.mm.plugin.messenger.a.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.chatting.g.a.b;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.Map;

public final class c extends a {
    public c(b bVar) {
        super(bVar);
    }

    final String cwj() {
        return "link_revoke";
    }

    final CharSequence a(Map<String, String> map, String str, WeakReference<Context> weakReference) {
        String str2 = (String) map.get(str + ".title");
        final LinkedList linkedList = new LinkedList();
        int i = 0;
        while (true) {
            Object obj = str + ".usernamelist.username";
            if (i != 0) {
                obj = obj + i;
            }
            String str3 = (String) map.get(obj);
            if (bi.oN(str3)) {
                CharSequence spannableString = new SpannableString(str2);
                spannableString.setSpan(new a() {
                    public final void bJ(View view) {
                        a aVar = c.this;
                        LinkedList linkedList = linkedList;
                        if (aVar.yQK != null && aVar.yQK.get() != null) {
                            ((b) aVar.yQK.get()).aB(linkedList);
                        }
                    }
                }, 0, str2.length(), 33);
                return spannableString;
            }
            linkedList.add(str3);
            i++;
        }
    }
}
