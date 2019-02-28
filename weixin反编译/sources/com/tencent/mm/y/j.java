package com.tencent.mm.y;

import com.tencent.mm.af.d.b;
import com.tencent.mm.af.d.b.a;
import com.tencent.mm.af.y;
import com.tencent.mm.api.h;
import java.util.ArrayList;

public final class j implements h {
    public final boolean cc(String str) {
        if (y.Ml().jN(str).Le()) {
            return true;
        }
        return false;
    }

    public final ArrayList<String> cd(String str) {
        try {
            b bK = y.Ml().jN(str).bK(false);
            if (bK.hqH == null && bK.hqe != null) {
                bK.hqH = a.jG(bK.hqe.optString("AcctTransferInfo"));
            }
            return bK.hqH.hqJ;
        } catch (Exception e) {
            return new ArrayList();
        }
    }
}
