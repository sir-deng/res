package com.tencent.mm.plugin.brandservice.a;

import android.content.Context;
import android.os.Looper;
import android.text.SpannableString;
import android.text.Spanned;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.af.d;
import com.tencent.mm.bb.b;
import com.tencent.mm.protocal.c.pz;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.List;

public final class a {
    private static ag hcb = new ag(Looper.getMainLooper());

    public static class a {
        public String iconUrl;
        public ImageView ikK;
        public String username;
    }

    public static d a(d dVar, pz pzVar) {
        if (pzVar != null) {
            dVar.field_brandFlag = pzVar.hxs;
            dVar.field_brandIconURL = pzVar.hxv;
            dVar.field_brandInfo = pzVar.hxu;
            dVar.field_extInfo = pzVar.hxt;
        }
        return dVar;
    }

    public static Spanned b(Context context, String str, List<String> list) {
        if (bi.oN(str)) {
            return null;
        }
        if (context == null || list == null) {
            return new SpannableString(str);
        }
        return b.a((CharSequence) str, (List) list);
    }

    public static boolean b(TextView textView, CharSequence charSequence) {
        if (textView == null) {
            return false;
        }
        if (charSequence == null || charSequence.length() == 0) {
            textView.setVisibility(8);
            return false;
        }
        textView.setVisibility(0);
        textView.setText(charSequence);
        return true;
    }
}
