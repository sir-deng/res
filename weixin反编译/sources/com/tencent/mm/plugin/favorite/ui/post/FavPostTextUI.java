package com.tencent.mm.plugin.favorite.ui.post;

import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.favorite.a.c;
import com.tencent.mm.plugin.favorite.b.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.tools.MMTextInputUI;

public class FavPostTextUI extends MMTextInputUI {
    protected final int getLayoutId() {
        return R.i.dhz;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(R.l.egn);
    }

    protected final void y(CharSequence charSequence) {
        if (charSequence == null || bi.oN(charSequence.toString())) {
            x.w("MicroMsg.MMTextInputUI", "text is null");
            return;
        }
        String charSequence2 = charSequence.toString();
        if (bi.oN(charSequence2) || charSequence2.trim().length() == 0) {
            x.e("MicroMsg.FavPostLogic", "postText text null");
            return;
        }
        f fVar = new f();
        fVar.field_type = 1;
        fVar.field_sourceType = 6;
        fVar.field_favProto.UM(charSequence2);
        c.j(fVar);
        a.B(fVar);
        g.pWK.h(10648, Integer.valueOf(0), Integer.valueOf(0));
    }
}
