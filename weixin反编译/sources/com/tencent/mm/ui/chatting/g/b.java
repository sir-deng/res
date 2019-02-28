package com.tencent.mm.ui.chatting.g;

import android.content.Context;
import android.content.Intent;
import android.text.SpannableStringBuilder;
import android.view.View;
import com.tencent.mm.bl.d;
import com.tencent.mm.plugin.messenger.a.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import java.util.Map;

public final class b extends a {
    public b(com.tencent.mm.ui.chatting.g.a.b bVar) {
        super(bVar);
    }

    final String cwj() {
        return "link_profile";
    }

    final CharSequence a(Map<String, String> map, String str, final WeakReference<Context> weakReference) {
        CharSequence spannableStringBuilder = new SpannableStringBuilder();
        CharSequence aD = bi.aD((String) map.get(str + ".separator"), "、");
        int i = 0;
        while (true) {
            String str2 = str + ".memberlist.member" + (i != 0 ? Integer.valueOf(i) : "");
            if (map.get(str2) == null) {
                return spannableStringBuilder;
            }
            if (i != 0) {
                spannableStringBuilder.append(aD);
            }
            final String str3 = (String) map.get(str2 + ".username");
            CharSequence charSequence = (String) map.get(str2 + ".nickname");
            if (bi.oN(str3) || bi.oN(charSequence)) {
                x.w("MicroMsg.SysMsgHandlerProfile", "hy: can not resolve username or nickname");
            } else {
                CharSequence a = i.a(ad.getContext(), charSequence);
                a.setSpan(new a() {
                    public final void bJ(View view) {
                        if (weakReference != null && weakReference.get() != null) {
                            Context context = (Context) weakReference.get();
                            String str = str3;
                            if (context != null && !bi.oN(str)) {
                                g.pWK.h(14516, Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
                                Intent putExtra = new Intent().putExtra("Contact_User", str);
                                putExtra.putExtra("Contact_Scene", 14);
                                d.b(context, "profile", ".ui.ContactInfoUI", putExtra);
                            }
                        }
                    }
                }, 0, charSequence.length(), 33);
                spannableStringBuilder.append(a);
            }
            i++;
        }
    }
}
