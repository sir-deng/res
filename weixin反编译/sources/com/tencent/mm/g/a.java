package com.tencent.mm.g;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.comm.a.h;
import com.tencent.mm.sdk.platformtools.bi;

public final class a {
    public String desc;
    public String fpg;
    private c gCG;
    public int showType;
    public String url;

    public static a eC(String str) {
        c eE = c.eE(str);
        if (eE == null) {
            return null;
        }
        a aVar = new a();
        aVar.gCG = eE;
        aVar.url = eE.url;
        aVar.desc = eE.desc;
        aVar.showType = eE.showType;
        aVar.fpg = eE.fpg;
        return aVar;
    }

    public final boolean a(Context context, OnClickListener onClickListener, OnClickListener onClickListener2) {
        if (this.showType == 3 || this.showType == 4) {
            String str = this.gCG.gCS;
            String str2 = this.gCG.gCT;
            if (bi.oN(str) && bi.oN(str2)) {
                str = context.getString(this.showType == 3 ? h.dHo : h.dGf);
                str2 = context.getString(this.showType == 3 ? h.dGc : h.dEy);
            }
            if (bi.oN(str) || bi.oN(str2)) {
                String str3 = this.desc;
                String str4 = this.fpg;
                if (!bi.oN(str)) {
                    str2 = str;
                }
                if (!bi.oN(str)) {
                    onClickListener2 = onClickListener;
                }
                com.tencent.mm.ui.base.h.a(context, str3, str4, str2, onClickListener2);
            } else {
                com.tencent.mm.ui.base.h.a(context, this.desc, this.fpg, str, str2, onClickListener, onClickListener2);
            }
            return true;
        } else if (this.showType == 1) {
            com.tencent.mm.ui.base.h.b(context, this.desc, this.fpg, true);
            return true;
        } else if (this.showType != 5) {
            return false;
        } else {
            com.tencent.mm.ui.base.h.b(context, this.desc, this.fpg, true);
            return true;
        }
    }
}
