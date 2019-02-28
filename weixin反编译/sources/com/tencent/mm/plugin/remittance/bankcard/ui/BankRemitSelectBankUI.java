package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.remittance.bankcard.a.h;
import com.tencent.mm.plugin.remittance.bankcard.model.BankcardElemParcel;
import com.tencent.mm.plugin.remittance.bankcard.model.b;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.fd;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.sortview.d;
import com.tencent.mm.wallet_core.c.g.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BankRemitSelectBankUI extends BankRemitBaseUI {
    private BankRemitSortView pPp;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(i.uOv);
        jl(1399);
        initView();
        x.i("MicroMsg.BankRemitSelectBankUI", "do fetch data");
        k hVar = new h();
        hVar.k(this);
        l(hVar);
    }

    protected final void initView() {
        this.pPp = (BankRemitSortView) findViewById(f.unm);
        this.pPp.XC = new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                fd fdVar = (fd) ((d) adapterView.getAdapter().getItem(i)).data;
                if (fdVar != null) {
                    Parcelable bankcardElemParcel = new BankcardElemParcel(fdVar);
                    Intent intent = new Intent();
                    intent.putExtra("key_bank_card_elem_parcel", bankcardElemParcel);
                    BankRemitSelectBankUI.this.setResult(-1, intent);
                    BankRemitSelectBankUI.this.finish();
                    return;
                }
                x.w("MicroMsg.BankRemitSelectBankUI", "bankcardelem is null, : %s", Integer.valueOf(i));
            }
        };
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (kVar instanceof h) {
            final h hVar = (h) kVar;
            hVar.a(new a() {
                public final void f(int i, int i2, String str, k kVar) {
                    List arrayList = new ArrayList();
                    List<fd> list = hVar.pMS.wpR;
                    List<fd> list2 = hVar.pMS.wpQ;
                    Comparator bVar = new b();
                    if (!(list == null || list.isEmpty())) {
                        x.i("MicroMsg.BankRemitSelectBankUI", "freq card count: %s", Integer.valueOf(list2.size()));
                        for (fd fdVar : list) {
                            d dVar = new d();
                            dVar.ysR = "☆";
                            dVar.data = fdVar;
                            arrayList.add(dVar);
                        }
                    }
                    if (!(list2 == null || list2.isEmpty())) {
                        x.i("MicroMsg.BankRemitSelectBankUI", "card count: %s", Integer.valueOf(list2.size()));
                        Collections.sort(list2, bVar);
                        for (fd fdVar2 : list2) {
                            if (!bi.oN(fdVar2.nHt)) {
                                String str2;
                                if (bi.oN(fdVar2.vRE)) {
                                    str2 = com.tencent.mm.plugin.remittance.bankcard.model.a.IS(fdVar2.nHt);
                                } else {
                                    x.i("MicroMsg.BankRemitSelectBankUI", "use sort pingyin: %s", fdVar2.vRE);
                                    str2 = fdVar2.vRE.toUpperCase().charAt(0);
                                }
                                d dVar2 = new d();
                                dVar2.ysR = str2;
                                dVar2.data = fdVar2;
                                arrayList.add(dVar2);
                            }
                        }
                    }
                    BankRemitSelectBankUI.this.pPp.dd(arrayList);
                }
            }).b(new a() {
                public final void f(int i, int i2, String str, k kVar) {
                    x.e("MicroMsg.BankRemitSelectBankUI", "response error: %s, %s", Integer.valueOf(hVar.pMS.lot), hVar.pMS.lou);
                    if (!bi.oN(hVar.pMS.lou)) {
                        Toast.makeText(BankRemitSelectBankUI.this, hVar.pMS.lou, 1).show();
                    }
                }
            }).c(new a() {
                public final void f(int i, int i2, String str, k kVar) {
                    x.e("MicroMsg.BankRemitSelectBankUI", "net error: %s", hVar);
                }
            });
        }
        return false;
    }

    protected final int getLayoutId() {
        return g.uHI;
    }

    public void onDestroy() {
        super.onDestroy();
        jm(1399);
    }
}
