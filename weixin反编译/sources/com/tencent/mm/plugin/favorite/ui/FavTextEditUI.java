package com.tencent.mm.plugin.favorite.ui;

import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.favorite.a.r;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.ash;
import com.tencent.mm.protocal.c.ask;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.tools.MMTextInputUI;
import com.tencent.mm.y.as;
import java.util.LinkedList;

public class FavTextEditUI extends MMTextInputUI {
    protected final int getLayoutId() {
        return R.i.dhz;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(R.l.efm);
    }

    protected final void y(CharSequence charSequence) {
        if (charSequence == null || bi.oN(charSequence.toString())) {
            x.w("MicroMsg.FavTextEditUI", "text is null");
            return;
        }
        int intExtra = getIntent().getIntExtra("key_fav_item_id", -1);
        String charSequence2 = charSequence.toString();
        if (intExtra <= 0) {
            x.w("MicroMsg.Fav.ModFavItemLogic", "modEditText favid:%d", Integer.valueOf(intExtra));
            return;
        }
        LinkedList linkedList = new LinkedList();
        ash ash = new ash();
        ash.wGK = 4;
        ash.wGL = 0;
        linkedList.add(ash);
        LinkedList linkedList2 = new LinkedList();
        ask ask = new ask();
        ask.noE = "favitem.desc";
        ask.pWq = bi.aD(charSequence2, "");
        linkedList2.add(ask);
        ask = new ask();
        ask.noE = "favitem.edittime";
        ask.pWq = String.valueOf(bi.Wx());
        linkedList2.add(ask);
        f dd = h.getFavItemInfoStorage().dd((long) intExtra);
        if (dd != null) {
            dd.field_edittime = bi.Wx();
            dd.field_favProto.fC(dd.field_edittime);
            dd.field_favProto.UM(bi.aD(charSequence2, ""));
            h.getFavItemInfoStorage().a(dd, "localId");
        }
        as.CN().a(new r(intExtra, linkedList, linkedList2), 0);
        g.pWK.h(10874, Integer.valueOf(1));
    }
}
