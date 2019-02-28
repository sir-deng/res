package com.tencent.mm.plugin.sns.ui.widget;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import com.tencent.mm.bu.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.pluginsdk.ui.d.n;
import com.tencent.mm.protocal.c.bku;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.x;

public final class c {
    public static CharSequence a(Context context, bku bku, av avVar, int i, String str) {
        String str2;
        String str3 = "";
        CharSequence a = a(bku);
        CharSequence charSequence = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = i == 21 ? 3 : 2;
        String str4 = bku.noL;
        x xVar = null;
        if (!bi.oN(str)) {
            g.Dr();
            xVar = ((h) g.h(h.class)).Ff().Xt(str);
        }
        CharSequence str22;
        if (bku.wUs == 1) {
            if (xVar != null) {
                if (!(xVar == null || TextUtils.isEmpty(xVar.AX()))) {
                    str = xVar.AX();
                }
                String str5 = a + context.getString(j.qQl);
                int length = str5.length();
                str22 = str5 + str;
                i3 = length;
            } else {
                com.tencent.mm.sdk.platformtools.x.w("SnsCommentUtil", "feedContact null by feedOwnUserName %s", str);
                str = null;
                str22 = a;
            }
        } else if (bi.oN(bku.wUH)) {
            str = null;
            str22 = a;
        } else {
            xVar = ae.bvT().Xu(bku.wUH);
            str22 = xVar == null ? bku.wUH : xVar.AX();
            String str6 = a + context.getString(j.qSc);
            i2 = str6.length();
            str = null;
            String str7 = str22;
            str22 = str6 + str22;
            Object charSequence2 = str7;
        }
        SpannableString a2 = i.a(context, (str3 + str22 + ": ") + str4, a.fromDPToPix(context, (int) (14.0f * a.ev(context))), 2);
        int i5 = i == 21 ? 3 : 2;
        g.Dr();
        ((h) g.h(h.class)).Ff().Xt(bku.vPp);
        Object jVar = new com.tencent.mm.pluginsdk.ui.d.j(a2);
        jVar.a(new n(bku.vPp, avVar.rFO, i5), a, 0, 33);
        if (str != null) {
            jVar.a(new n(bku.wUH, avVar.rFO, i4), (CharSequence) str, i3, 33);
        } else if (charSequence2 != null) {
            jVar.a(new n(bku.wUH, avVar.rFO, i4), charSequence2, i2, 33);
        }
        return jVar;
    }

    public static String a(bku bku) {
        com.tencent.mm.k.a Xu = ae.bvT().Xu(bku.vPp);
        if (Xu != null) {
            return Xu.AX();
        }
        return bku.wDh != null ? bku.wDh : bku.vPp;
    }
}
