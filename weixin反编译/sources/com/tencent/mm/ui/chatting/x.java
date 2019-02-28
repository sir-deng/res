package com.tencent.mm.ui.chatting;

import android.os.Bundle;
import android.os.Looper;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.b.p;
import com.tencent.mm.y.am;
import com.tencent.mm.y.s;
import java.util.ArrayList;
import java.util.List;

public final class x implements am {
    public p fhH;
    public z yFH = new z();

    public x(p pVar) {
        this.fhH = pVar;
    }

    public final void a(au auVar) {
        if (this.fhH == null) {
            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ChattingUIKeywordChecker", "chatting ui is null.");
            return;
        }
        this.fhH.crM();
        if (auVar.field_talker.equals(this.fhH.csn()) && auVar.cjV()) {
            aB(auVar);
        }
    }

    public final void y(List<au> list) {
        if (this.fhH == null) {
            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ChattingUIKeywordChecker", "chatting ui is null.");
        } else if (!s.eX(this.fhH.csn())) {
            List arrayList = new ArrayList();
            for (au auVar : list) {
                if (auVar.field_talker.equals(this.fhH.csn()) && auVar.cjV()) {
                    arrayList.add(auVar);
                }
            }
            dm(arrayList);
        }
    }

    public final void aB(au auVar) {
        if (auVar != null) {
            List arrayList = new ArrayList();
            arrayList.add(auVar);
            dm(arrayList);
        }
    }

    private void dm(List<au> list) {
        if (this.yFH != null && this.fhH != null) {
            this.yFH.a(this.fhH.cte().thisActivity(), list);
        }
    }

    public final Looper getLooper() {
        return Looper.getMainLooper();
    }

    public final void a(int i, String str, String str2, String str3, String str4, Bundle bundle) {
    }
}
