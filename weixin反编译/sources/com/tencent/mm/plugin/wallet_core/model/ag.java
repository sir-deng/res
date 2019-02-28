package com.tencent.mm.plugin.wallet_core.model;

import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.wallet_core.d.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.e.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ag {
    public int mRetryCount = 0;
    public Bankcard sFY = null;
    ArrayList<Bankcard> sIw = new ArrayList();
    ArrayList<Bankcard> sIx = new ArrayList();
    private ArrayList<Bankcard> sWg = new ArrayList();
    private ArrayList<Bankcard> sWh = new ArrayList();
    public af sWi = null;
    public Bankcard sWj = null;
    ae sWk = null;
    public k sWl = null;
    public b sWm = null;
    private List<c> sWn = new LinkedList();
    public Bankcard sWo = null;
    public long sWp = bi.Wx();
    long sWq = 0;
    public long sWr = -1;
    private String sWs = "";
    public int sWt = 10000;
    public String sWu = "";
    public String sWv = "";

    public ag() {
        bMH();
    }

    public final boolean bMx() {
        return this.sWi == null || (this.sWi != null && this.sWi.bMw());
    }

    public final boolean bMy() {
        if (this.sWi != null) {
            if (this.sWi.field_is_reg == 1) {
                return true;
            }
        }
        return false;
    }

    public final boolean bMv() {
        return this.sWi != null && this.sWi.bMv();
    }

    public final boolean bMz() {
        if (this.sWi != null) {
            if (this.sWi.field_is_reg == 2) {
                return true;
            }
        }
        return false;
    }

    public final boolean bMA() {
        if (this.sWi != null) {
            if (this.sWi.field_is_open_touch == 1) {
                return true;
            }
        }
        return false;
    }

    public final String bMB() {
        if (this.sWi != null) {
            return this.sWi.field_ftf_pay_url;
        }
        return null;
    }

    public final ae bMC() {
        if (this.sWk == null) {
            return new ae();
        }
        return this.sWk;
    }

    public final boolean bMD() {
        return this.sWi != null && this.sWi.field_isDomesticUser;
    }

    public final String azW() {
        if (this.sWi != null) {
            return this.sWi.field_true_name;
        }
        return null;
    }

    public final int bME() {
        if (this.sWi != null) {
            return this.sWi.field_cre_type;
        }
        return 1;
    }

    public final String bMF() {
        g.Dr();
        String str = (String) g.Dq().Db().get(a.USERINFO_WALLET_LQT_ENTRY_WORDING_STRING_SYNC, null);
        if (bi.oN(str)) {
            return this.sWi != null ? this.sWi.field_lct_wording : null;
        } else {
            return str;
        }
    }

    public final String bMG() {
        if (this.sWi != null) {
            return this.sWi.field_lct_url;
        }
        return null;
    }

    public final void bMH() {
        k kVar = null;
        if (g.Do().CF()) {
            Bankcard bankcard;
            this.sWi = o.bLY().bMZ();
            if (this.sWi != null) {
                this.sWk = new ae(this.sWi.field_switchConfig);
            } else {
                this.sWk = new ae();
            }
            c bMa = o.bMa();
            Cursor a = bMa.gLA.a("select * from WalletBankcard where cardType & " + Bankcard.sRe + " != 0 ", null, 2);
            if (a == null) {
                bankcard = null;
            } else {
                if (a.moveToFirst()) {
                    bankcard = new Bankcard();
                    bankcard.b(a);
                } else {
                    bankcard = null;
                }
                a.close();
            }
            this.sFY = bankcard;
            bMa = o.bMa();
            a = bMa.gLA.a("select * from WalletBankcard where cardType & " + Bankcard.sRh + " != 0 ", null, 2);
            if (a == null) {
                bankcard = null;
            } else {
                if (a.moveToFirst()) {
                    bankcard = new Bankcard();
                    bankcard.b(a);
                } else {
                    bankcard = null;
                }
                a.close();
            }
            this.sWo = bankcard;
            e.a("wallet_balance", new b() {
                public final void bO(Object obj) {
                    if (obj == null || !(obj instanceof Double)) {
                        x.i("MicroMsg.WalletUserInfoManger", "hy: no balance info. set to negative");
                        if (ag.this.sFY != null) {
                            ag.this.sFY.sRo = -1.0d;
                            return;
                        }
                        return;
                    }
                    if (((Double) obj).doubleValue() < 0.0d) {
                        x.v("MicroMsg.WalletUserInfoManger", "val is zero %s", bi.chl().toString());
                    }
                    if (ag.this.sFY != null) {
                        ag.this.sFY.sRo = ((Double) obj).doubleValue();
                    }
                }
            });
            this.sIw = o.bMa().bMJ();
            this.sIx = o.bMa().bMX();
            bMa = o.bMa();
            a = bMa.gLA.a("select * from WalletBankcard where cardType & " + Bankcard.sRf + " != 0 ", null, 2);
            if (a == null) {
                bankcard = null;
            } else {
                if (a.moveToNext()) {
                    bankcard = new Bankcard();
                    bankcard.b(a);
                } else {
                    bankcard = null;
                }
                a.close();
            }
            this.sWj = bankcard;
            Cursor a2 = o.bMe().gLA.a("select * from LoanEntryInfo", null, 2);
            if (a2 != null) {
                if (a2.moveToFirst()) {
                    kVar = new k();
                    kVar.b(a2);
                }
                a2.close();
            }
            this.sWl = kVar;
            x.i("MicroMsg.WalletUserInfoManger", "loadDbData!");
            bMO();
            return;
        }
        x.w("MicroMsg.WalletUserInfoManger", "Account Not Ready!");
    }

    public final boolean bMI() {
        if (r.igJ) {
            return true;
        }
        g.Dr();
        int intValue = ((Integer) g.Dq().Db().get(a.USERINFO_WALLET_LQT_OPEN_FLAG_INT_SYNC, Integer.valueOf(-1))).intValue();
        if (intValue != -1) {
            return intValue == 1;
        } else {
            if (this.sWi != null) {
                return this.sWi.field_lqt_state == 1;
            } else {
                return false;
            }
        }
    }

    public final void aJO() {
        if (this.sWi != null) {
            this.sWi.field_is_reg = -1;
            this.sWi = null;
        }
        if (this.sWk != null) {
            this.sWk = null;
        }
        if (this.sFY != null) {
            this.sFY = null;
        }
        if (this.sIw != null) {
            this.sIw.clear();
            this.sIw = null;
        }
        if (this.sIx != null) {
            this.sIx.clear();
            this.sIx = null;
        }
        this.sWq = 0;
        e.a(new e.c("wallet_balance_version", Integer.valueOf(-1)), new e.c("wallet_balance_last_update_time", Integer.valueOf(-1)), new e.c("wallet_balance", Integer.valueOf(-1)));
        this.sWp = bi.Wx();
    }

    public final ArrayList<Bankcard> bMJ() {
        if (this.sIw == null || this.sIw.size() <= 0) {
            this.sIw = o.bMa().bMJ();
        }
        if (this.sIw == null || this.sIw.size() <= 0) {
            return null;
        }
        ArrayList<Bankcard> arrayList = new ArrayList();
        Iterator it = this.sIw.iterator();
        while (it.hasNext()) {
            arrayList.add((Bankcard) it.next());
        }
        return arrayList;
    }

    public final List<c> bMK() {
        if (this.sWn != null) {
            this.sWn.size();
        }
        if (this.sWn == null || this.sWn.size() <= 0) {
            return null;
        }
        return this.sWn;
    }

    public final ArrayList<Bankcard> bML() {
        if (this.sIw == null || this.sIw.size() <= 0) {
            return null;
        }
        ArrayList<Bankcard> arrayList = new ArrayList();
        Iterator it = this.sIw.iterator();
        while (it.hasNext()) {
            Bankcard bankcard = (Bankcard) it.next();
            if (!(bankcard.bLD() || bankcard.bLF())) {
                arrayList.add(bankcard);
            }
        }
        return arrayList;
    }

    public final ArrayList<Bankcard> jG(boolean z) {
        ArrayList<Bankcard> arrayList = new ArrayList();
        if (z) {
            if (!(this.sFY == null || bMv())) {
                arrayList.add(this.sFY);
            }
            if (!(this.sWo == null || bMv())) {
                arrayList.add(this.sWo);
            }
        }
        if (this.sIw != null && this.sIw.size() > 0) {
            Iterator it = this.sIw.iterator();
            while (it.hasNext()) {
                arrayList.add((Bankcard) it.next());
            }
        }
        return arrayList;
    }

    public final ArrayList<Bankcard> jO(boolean z) {
        ArrayList<Bankcard> arrayList = new ArrayList();
        if (z) {
            if (!(this.sFY == null || bMv())) {
                arrayList.add(this.sFY);
            }
            if (!(this.sWo == null || bMv())) {
                arrayList.add(this.sWo);
            }
        }
        Iterator it;
        if (this.sWg != null && this.sIw != null && this.sWg.size() == this.sIw.size() && this.sWg.size() > 0) {
            it = this.sWg.iterator();
            while (it.hasNext()) {
                arrayList.add((Bankcard) it.next());
            }
        } else if (this.sIw != null && this.sIw.size() > 0) {
            it = this.sIw.iterator();
            while (it.hasNext()) {
                arrayList.add((Bankcard) it.next());
            }
        }
        return arrayList;
    }

    public final ArrayList<Bankcard> bMM() {
        ArrayList<Bankcard> arrayList = new ArrayList();
        if (!(this.sFY == null || bMv())) {
            arrayList.add(this.sFY);
        }
        if (!(this.sWh == null || this.sIw == null || this.sWh.size() <= 0)) {
            Iterator it = this.sWh.iterator();
            while (it.hasNext()) {
                Bankcard bankcard = (Bankcard) it.next();
                if (!bankcard.bLF()) {
                    arrayList.add(bankcard);
                }
            }
        }
        return arrayList;
    }

    public final void d(ArrayList<Bankcard> arrayList, ArrayList<Bankcard> arrayList2) {
        if (this.sIw == null || arrayList == null || arrayList2 == null) {
            x.e("MicroMsg.WalletUserInfoManger", "error list, bankcards == null || bankcardsClone == null || virtualBankcardsClone == null");
            return;
        }
        Iterator it;
        arrayList.clear();
        arrayList2.clear();
        if (this.sIw != null) {
            it = this.sIw.iterator();
            while (it.hasNext()) {
                arrayList.add((Bankcard) it.next());
            }
        }
        if (this.sIx != null) {
            it = this.sIx.iterator();
            while (it.hasNext()) {
                Bankcard bankcard = (Bankcard) it.next();
                if (bankcard.field_wxcreditState == 0) {
                    arrayList2.add(bankcard);
                } else {
                    arrayList.add(bankcard);
                }
            }
        }
    }

    public static boolean cg(List<Bankcard> list) {
        if (list.size() == 0) {
            return false;
        }
        g.Dr();
        String str = (String) g.Dq().Db().get(196659, null);
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        String[] split = str.split("&");
        if (split == null || split.length == 0) {
            return true;
        }
        int i = 0;
        for (Object obj : split) {
            if (!TextUtils.isEmpty(obj)) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    Bankcard bankcard = (Bankcard) list.get(i2);
                    if (bankcard != null && obj.equals(bankcard.field_bankcardType)) {
                        i++;
                        break;
                    }
                }
            }
        }
        if (i < list.size()) {
            return true;
        }
        return false;
    }

    public final boolean NC(String str) {
        if (bi.oN(str)) {
            return false;
        }
        Iterator it;
        Bankcard bankcard;
        if (this.sIw != null) {
            it = this.sIw.iterator();
            while (it.hasNext()) {
                bankcard = (Bankcard) it.next();
                if (str.equals(bankcard.field_bankcardType) && bankcard.bLA()) {
                    return false;
                }
            }
        }
        if (this.sIx != null) {
            it = this.sIx.iterator();
            while (it.hasNext()) {
                bankcard = (Bankcard) it.next();
                if (str.equals(bankcard.field_bankcardType) && bankcard.field_bankcardState == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public final void a(af afVar, ArrayList<Bankcard> arrayList, ArrayList<Bankcard> arrayList2, Bankcard bankcard, Bankcard bankcard2, k kVar, b bVar, Bankcard bankcard3, int i, int i2, List<c> list) {
        x.i("MicroMsg.WalletUserInfoManger", "setBankcards scene %d", Integer.valueOf(i2));
        if (i2 == 8) {
            this.sWg = arrayList;
        }
        if (i2 == 24 || i2 == 25) {
            this.sWh = arrayList;
        }
        this.sWn = list;
        this.sWi = afVar;
        this.sIw = arrayList;
        this.sIx = arrayList2;
        this.sFY = bankcard;
        this.sWk = new ae(afVar.field_switchConfig);
        this.sWj = bankcard2;
        this.sWl = kVar;
        this.sWm = bVar;
        this.sWo = bankcard3;
        x.i("MicroMsg.WalletUserInfoManger", "setBankcards()! " + afVar.field_switchConfig);
        bMO();
        if (i < 0) {
            i = 600;
        }
        this.sWp = bi.Wx() + ((long) i);
        this.sWq = bi.Wx() + 600;
        x.i("MicroMsg.WalletUserInfoManger", "hy: cache time: %d, dead time: %d, cacheDeadTime: %s", Integer.valueOf(i), Long.valueOf(this.sWp), Long.valueOf(this.sWq));
        o.bMa().gLA.fD("WalletBankcard", "delete from WalletBankcard");
        if (!(i2 == 24 || i2 == 25 || arrayList == null)) {
            o.bMa().ci(arrayList);
        }
        if (arrayList2 != null) {
            o.bMa().ci(arrayList2);
        }
        if (bankcard != null) {
            o.bMa().e(bankcard);
        }
        if (bankcard2 != null) {
            o.bMa().e(bankcard2);
        }
        if (bankcard3 != null) {
            o.bMa().e(bankcard3);
        }
        o.bLY().gLA.fD("WalletUserInfo", "delete from WalletUserInfo");
        o.bLY().a(afVar);
        o.bMe().gLA.fD("LoanEntryInfo", "delete from LoanEntryInfo");
        if (kVar != null) {
            o.bMe().b((com.tencent.mm.sdk.e.c) kVar);
        }
    }

    public static void ND(String str) {
        if (!bi.oN(str)) {
            g.Dr();
            g.Dq().Db().set(196612, str);
        }
    }

    public final Bankcard a(ArrayList<Bankcard> arrayList, String str, boolean z, boolean z2) {
        return a(arrayList, str, z, z2, false);
    }

    public final Bankcard a(ArrayList<Bankcard> arrayList, String str, boolean z, boolean z2, boolean z3) {
        ArrayList arrayList2;
        if (arrayList2 == null) {
            arrayList2 = this.sIw;
        }
        if (bi.oN(str)) {
            g.Dr();
            str = (String) g.Dq().Db().get(196612, null);
        }
        if (z && this.sFY != null) {
            if (bMz()) {
                return this.sFY;
            }
            if (str != null && str.equals(this.sFY.field_bindSerial)) {
                return this.sFY;
            }
            if (this.sWo != null && this.sWi != null && this.sWi.field_lqt_state == 1 && str != null && str.equals(this.sWo.field_bindSerial)) {
                return this.sWo;
            }
            if (!bMv() && (arrayList2 == null || arrayList2.size() == 0)) {
                return this.sFY;
            }
        }
        if (arrayList2 == null || arrayList2.size() <= 0) {
            x.e("MicroMsg.WalletUserInfoManger", "not found bankcard!");
            return null;
        } else if (arrayList2.size() == 1 && z2) {
            x.e("MicroMsg.WalletUserInfoManger", "only one bankcard!");
            return (Bankcard) arrayList2.get(0);
        } else {
            x.i("MicroMsg.WalletUserInfoManger", "have multiple bankcards!");
            if (!bi.oN(str)) {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    Bankcard bankcard = (Bankcard) it.next();
                    if (bankcard != null && str.equals(bankcard.field_bindSerial)) {
                        if (!z3 || !bankcard.bLF()) {
                            return bankcard;
                        }
                        x.i("MicroMsg.WalletUserInfoManger", "default card is honeypay");
                        if (z && this.sFY != null) {
                            return this.sFY;
                        }
                        Iterator it2 = arrayList2.iterator();
                        while (it2.hasNext()) {
                            bankcard = (Bankcard) it2.next();
                            if (!bankcard.bLF()) {
                                return bankcard;
                            }
                        }
                        continue;
                    }
                }
            }
            return z2 ? (Bankcard) arrayList2.get(0) : null;
        }
    }

    public final String bMN() {
        if (this.sIw == null || this.sIw.size() <= 0) {
            x.e("MicroMsg.WalletUserInfoManger", "not found bankcard!");
            return null;
        }
        Iterator it = this.sIw.iterator();
        if (it.hasNext()) {
            return ((Bankcard) it.next()).field_bindSerial;
        }
        return null;
    }

    private void bMO() {
        x.i("MicroMsg.WalletUserInfoManger", "recordDataState()");
        if (this.sWi == null) {
            x.i("MicroMsg.WalletUserInfoManger", "userInfo == null");
        }
        if (this.sIw == null) {
            x.i("MicroMsg.WalletUserInfoManger", "bankcards == null");
        } else if (this.sIw.size() == 0) {
            x.i("MicroMsg.WalletUserInfoManger", "bankcards.size() == 0");
        } else {
            x.i("MicroMsg.WalletUserInfoManger", "bankcards.size() == " + this.sIw.size());
        }
        if (this.sIx == null) {
            x.i("MicroMsg.WalletUserInfoManger", "virtualBankcards == null");
        } else if (this.sIx.size() == 0) {
            x.i("MicroMsg.WalletUserInfoManger", "virtualBankcards.size() == 0");
        } else {
            x.i("MicroMsg.WalletUserInfoManger", "virtualBankcards.size() == " + this.sIx.size());
        }
        if (this.sFY == null) {
            x.i("MicroMsg.WalletUserInfoManger", "balance == null");
        } else {
            x.i("MicroMsg.WalletUserInfoManger", "balance != null");
        }
        if (this.sWj == null) {
            x.i("MicroMsg.WalletUserInfoManger", "historyBankcard == null");
        } else {
            x.i("MicroMsg.WalletUserInfoManger", "historyBankcard != null");
        }
        if (this.sWl == null) {
            x.i("MicroMsg.WalletUserInfoManger", "mLoanEntryInfo == null");
        } else {
            x.i("MicroMsg.WalletUserInfoManger", "mLoanEntryInfo != null");
        }
    }
}
