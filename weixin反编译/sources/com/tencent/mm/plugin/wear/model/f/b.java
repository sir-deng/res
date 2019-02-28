package com.tencent.mm.plugin.wear.model.f;

import com.tencent.mm.R;
import com.tencent.mm.plugin.wear.model.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.au;
import com.tencent.mm.y.bb;
import com.tencent.mm.y.s;

public abstract class b extends c {
    protected final String c(String str, au auVar) {
        if (s.eX(str)) {
            String d = d(str, auVar);
            return String.format(ad.getContext().getString(R.l.ezd), new Object[]{h.Or(d), Character.valueOf(8203), h.W(auVar).noL});
        }
        return String.format(ad.getContext().getString(R.l.eze), new Object[]{h.W(auVar).noL});
    }

    protected static String d(String str, au auVar) {
        if (!s.eX(str)) {
            return str;
        }
        int hR = bb.hR(auVar.field_content);
        if (hR == -1) {
            return str;
        }
        String trim = auVar.field_content.substring(0, hR).trim();
        if (trim == null || trim.length() <= 0) {
            return str;
        }
        return trim;
    }
}
