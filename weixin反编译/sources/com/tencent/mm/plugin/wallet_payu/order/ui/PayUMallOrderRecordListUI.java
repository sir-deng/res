package com.tencent.mm.plugin.wallet_payu.order.ui;

import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.order.model.g;
import com.tencent.mm.plugin.order.model.i;
import com.tencent.mm.plugin.order.ui.MallOrderRecordListUI;
import com.tencent.mm.plugin.wallet_payu.order.a.a;
import com.tencent.mm.plugin.wallet_payu.order.a.b;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.protocal.c.axp;
import com.tencent.mm.protocal.c.axz;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.ui.e;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public class PayUMallOrderRecordListUI extends MallOrderRecordListUI {
    protected final void bjn() {
        jl(1519);
        jl(1544);
    }

    protected final void bjo() {
        jm(1519);
        jm(1544);
    }

    protected final void dN(String str, String str2) {
        l(new b(str));
    }

    protected final void bjp() {
        l(new a(this.wn));
    }

    protected final String uR(int i) {
        return e.a(i, new SimpleDateFormat("dd MMMM", Locale.ENGLISH), new SimpleDateFormat("dd MMMM yyyy", Locale.ENGLISH));
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        Iterator it;
        if (kVar instanceof a) {
            if (this.mFC != null) {
                this.mFC.dismiss();
                this.mFC = null;
            }
            a aVar = (a) kVar;
            LinkedList linkedList = ((axp) aVar.gLB.hnR.hnY).wLI;
            List linkedList2 = new LinkedList();
            it = linkedList.iterator();
            while (it.hasNext()) {
                axz axz = (axz) it.next();
                i iVar = new i();
                iVar.noG = axz.noG;
                iVar.pgY = axz.pgY;
                iVar.pgZ = axz.pgZ;
                iVar.pgR = axz.pgR;
                iVar.pgU = axz.pgU;
                iVar.pgQ = axz.pgQ;
                iVar.pgX = "0";
                iVar.pgT = axz.pgT;
                iVar.pgW = axz.pgW;
                iVar.phc = 1;
                iVar.phb = axz.phb;
                iVar.pha = axz.pha;
                iVar.pgV = axz.pgV;
                iVar.pgP = (double) axz.wLB;
                iVar.pgS = axz.pgS;
                iVar.pgO = axz.pgO;
                linkedList2.add(iVar);
            }
            bn(linkedList2);
            bo(null);
            this.mCount = this.phW.size();
            this.omh = aVar.bOj() > this.mCount;
            this.phV.notifyDataSetChanged();
            x.d("MicroMsg.PayUMallOrderRecordListUI", "orders list count: " + this.mCount);
            x.d("MicroMsg.PayUMallOrderRecordListUI", "orders list total record: " + aVar.bOj());
            x.d("MicroMsg.PayUMallOrderRecordListUI", "orders list has more: " + this.omh);
            this.mHandler.post(new Runnable() {
                public final void run() {
                    if (PayUMallOrderRecordListUI.this.omh) {
                        x.v("MicroMsg.PayUMallOrderRecordListUI", "has more");
                        if (!PayUMallOrderRecordListUI.this.phY) {
                            PayUMallOrderRecordListUI.this.ljm.cqd();
                            PayUMallOrderRecordListUI.this.ljm.setAdapter(PayUMallOrderRecordListUI.this.phV);
                            PayUMallOrderRecordListUI.this.phY = true;
                        }
                    } else {
                        x.v("MicroMsg.PayUMallOrderRecordListUI", "no more! dismiss footer view!");
                        PayUMallOrderRecordListUI.this.ljm.cqe();
                    }
                    PayUMallOrderRecordListUI.this.phV.notifyDataSetChanged();
                }
            });
            this.acS = false;
        } else if (kVar instanceof g) {
            if (this.mFC != null) {
                this.mFC.dismiss();
                this.mFC = null;
            }
            g gVar = (g) kVar;
            if (gVar.bji() == 2) {
                if (this.phW != null) {
                    this.phW.clear();
                }
                this.mCount = 0;
                this.omh = false;
                this.ljm.cqe();
            } else {
                String bjj = gVar.bjj();
                x.d("MicroMsg.PayUMallOrderRecordListUI", "delete transId:" + bjj);
                if (!bi.oN(bjj)) {
                    for (i iVar2 : this.phW) {
                        if (bjj.equals(iVar2.pgO)) {
                            this.phW.remove(iVar2);
                            this.mCount = this.phW.size();
                            break;
                        }
                    }
                }
            }
            this.mHandler.post(new Runnable() {
                public final void run() {
                    PayUMallOrderRecordListUI.this.phV.notifyDataSetChanged();
                }
            });
        }
        if (this.mCount > 0 || this.phW.size() != 0) {
            showOptionMenu(true);
            findViewById(f.uqw).setVisibility(8);
        } else {
            showOptionMenu(false);
            findViewById(f.uqw).setVisibility(0);
        }
        return true;
    }
}
