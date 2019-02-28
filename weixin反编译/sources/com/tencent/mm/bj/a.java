package com.tencent.mm.bj;

import android.content.Context;
import com.tencent.mm.be.l;
import com.tencent.mm.bl.d;
import com.tencent.mm.j.g;
import com.tencent.mm.sdk.platformtools.bi;

public final class a {
    public static boolean bYH() {
        Object value = g.Af().getValue("EnableStrangerChat");
        String str = "1";
        if (bi.oN(value)) {
            value = "0";
        }
        return str.equals(value);
    }

    public static void dW(Context context) {
        if (bYH() || l.TF().Tx() <= 0) {
            d.y(context, "nearby", ".ui.NearbyFriendsUI");
        } else {
            d.y(context, "nearby", ".ui.NearbyFriendShowSayHiUI");
        }
    }
}
