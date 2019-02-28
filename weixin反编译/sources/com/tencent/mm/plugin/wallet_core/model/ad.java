package com.tencent.mm.plugin.wallet_core.model;

import android.text.TextUtils;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Iterator;

public final class ad {
    public ArrayList<Bankcard> sWd = new ArrayList();
    public String sWe;

    public final Bankcard NB(String str) {
        if (this.sWd.size() > 0) {
            Bankcard bankcard;
            Iterator it = this.sWd.iterator();
            while (it.hasNext()) {
                bankcard = (Bankcard) it.next();
                if (bankcard.field_bindSerial.equals(str)) {
                    break;
                }
            }
            bankcard = null;
            if (bankcard == null) {
                x.e("MicroMsg.WalletRepaymentBankcardMgr", "getBankcardBySerialNo return null");
                return bankcard;
            }
            x.i("MicroMsg.WalletRepaymentBankcardMgr", "getBankcardBySerialNo succ");
            return bankcard;
        }
        x.e("MicroMsg.WalletRepaymentBankcardMgr", "repayment bankcard list size is 0");
        return null;
    }

    public final boolean bMn() {
        return this.sWd.size() > 0;
    }

    public final Bankcard bMo() {
        if (!bMn()) {
            x.e("MicroMsg.WalletRepaymentBankcardMgr", "Repayment card list is null");
            return null;
        } else if (!TextUtils.isEmpty(this.sWe)) {
            return NB(this.sWe);
        } else {
            x.i("MicroMsg.WalletRepaymentBankcardMgr", "last_use_card_serialno is empty,return the first one");
            return (Bankcard) this.sWd.get(0);
        }
    }
}
