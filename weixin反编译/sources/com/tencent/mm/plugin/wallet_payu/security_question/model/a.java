package com.tencent.mm.plugin.wallet_payu.security_question.model;

import android.os.Bundle;
import com.tencent.mm.ad.k;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

public final class a extends g {
    private Bundle mym;

    public a(MMActivity mMActivity, i iVar, Bundle bundle) {
        super(mMActivity, iVar);
        this.mym = bundle;
    }

    public final boolean p(Object... objArr) {
        this.zRf.a(new c(this.mym.getString("payu_reference")), true);
        return true;
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if ((kVar instanceof c) && i == 0 && i2 == 0) {
            c cVar = (c) kVar;
            this.mym.putParcelable("key_security_question", new PayUSecurityQuestion(cVar.id, cVar.tkk));
            return false;
        } else if (!(kVar instanceof b)) {
            return false;
        } else {
            b bVar = (b) kVar;
            if (i != 0 || i2 != 0 || !bVar.mkY) {
                return false;
            }
            this.mym.putString("payu_reference", bVar.tkj);
            com.tencent.mm.wallet_core.a.j(this.zRe, this.mym);
            return true;
        }
    }

    public final boolean k(Object... objArr) {
        PayUSecurityQuestion payUSecurityQuestion = (PayUSecurityQuestion) this.mym.getParcelable("key_security_question");
        String string = this.mym.getString("key_question_answer");
        this.zRf.a(new b(this.mym.getString("payu_reference"), payUSecurityQuestion.id, string), true);
        return false;
    }
}
