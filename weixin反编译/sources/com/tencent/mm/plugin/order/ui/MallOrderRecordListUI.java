package com.tencent.mm.plugin.order.ui;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.StrikethroughSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.a.sv;
import com.tencent.mm.plugin.appbrand.jsapi.bb;
import com.tencent.mm.plugin.appbrand.jsapi.bf;
import com.tencent.mm.plugin.order.model.d;
import com.tencent.mm.plugin.order.model.i;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMLoadMoreListView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MallOrderRecordListUI extends WalletBaseUI {
    public boolean acS = false;
    public MMLoadMoreListView ljm;
    public int mCount = 0;
    public Dialog mFC = null;
    public ag mHandler = null;
    public boolean omh = true;
    public a phV = null;
    public List<i> phW = new ArrayList();
    protected String phX = null;
    public boolean phY = false;
    protected Map<String, String> phZ = new HashMap();
    public int wn = 0;

    protected class a extends BaseAdapter {
        protected a() {
        }

        public final /* synthetic */ Object getItem(int i) {
            return uS(i);
        }

        public final int getCount() {
            return MallOrderRecordListUI.this.phW.size();
        }

        private i uS(int i) {
            return (i) MallOrderRecordListUI.this.phW.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            Object obj;
            String dl;
            int obj2;
            if (view == null) {
                view = View.inflate(MallOrderRecordListUI.this, g.uJD, null);
                bVar = new b(MallOrderRecordListUI.this, (byte) 0);
                bVar.pic = (TextView) view.findViewById(f.uyV);
                bVar.pif = (TextView) view.findViewById(f.uyU);
                bVar.pie = (TextView) view.findViewById(f.uyT);
                bVar.pig = (TextView) view.findViewById(f.uyR);
                bVar.pii = view.findViewById(f.uyO);
                bVar.pij = (TextView) view.findViewById(f.uyQ);
                bVar.pik = (TextView) view.findViewById(f.uyP);
                bVar.pih = (TextView) view.findViewById(f.uyS);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            i uS = uS(i);
            if (i == 0) {
                i uS2 = uS(0);
                GregorianCalendar gregorianCalendar = new GregorianCalendar();
                gregorianCalendar.setTimeInMillis(((long) uS2.pgR) * 1000);
                obj2 = 1;
                dl = MallOrderRecordListUI.dk(gregorianCalendar.get(1), gregorianCalendar.get(2) + 1);
            } else {
                i uS3 = uS(i);
                i uS4 = uS(i - 1);
                if (uS3.pgR > 0 && uS4.pgR > 0) {
                    GregorianCalendar gregorianCalendar2 = new GregorianCalendar();
                    gregorianCalendar2.setTimeInMillis(((long) uS4.pgR) * 1000);
                    GregorianCalendar gregorianCalendar3 = new GregorianCalendar();
                    gregorianCalendar3.setTimeInMillis(((long) uS3.pgR) * 1000);
                    if (!(gregorianCalendar2.get(1) == gregorianCalendar3.get(1) && gregorianCalendar2.get(2) == gregorianCalendar3.get(2))) {
                        obj2 = 1;
                        dl = MallOrderRecordListUI.dk(gregorianCalendar3.get(1), gregorianCalendar3.get(2) + 1);
                    }
                }
                obj2 = null;
                dl = null;
            }
            if (obj2 != null) {
                bVar.pij.setText(new SimpleDateFormat(MallOrderRecordListUI.this.getString(com.tencent.mm.plugin.wxpay.a.i.ejH, new Object[]{""})).format(new Date(((long) uS(i).pgR) * 1000)));
                if (!(bi.oN(dl) || bi.oN((String) MallOrderRecordListUI.this.phZ.get(dl)))) {
                    bVar.pik.setText((CharSequence) MallOrderRecordListUI.this.phZ.get(dl));
                }
                bVar.pii.setVisibility(0);
            } else {
                bVar.pii.setVisibility(8);
            }
            bVar.pic.setText(uS.pgQ);
            bVar.pie.setText(uS.pgS);
            obj2 = MallOrderRecordListUI.this.mController.xRr.getResources().getColor(c.uhB);
            if (!bi.oN(uS.phe)) {
                try {
                    obj2 = Color.parseColor(uS.phe);
                } catch (Exception e) {
                    x.w("MicroMsg.WalletOrderListUI", "Parse color exp. colortext=" + bi.oM(uS.phe));
                }
            }
            bVar.pie.setTextColor(obj2);
            bVar.pif.setText(MallOrderRecordListUI.this.uR(uS.pgR));
            obj2 = MallOrderRecordListUI.this.mController.xRr.getResources().getColor(c.uhC);
            if (!bi.oN(uS.phf)) {
                try {
                    obj2 = Color.parseColor(uS.phf);
                } catch (Exception e2) {
                    x.w("MicroMsg.WalletOrderListUI", "Parse color exp. colortext=" + bi.oM(uS.phf));
                }
            }
            if (uS.pgP != uS.phg) {
                Object d = e.d(uS.pgP / 100.0d, uS.pgU);
                CharSequence spannableString = new SpannableString(d);
                spannableString.setSpan(new StrikethroughSpan(), 0, d.length(), 33);
                bVar.pig.setText(spannableString);
            } else {
                bVar.pig.setText("");
            }
            bVar.pih.setTextColor(obj2);
            bVar.pih.setText(e.d(uS.phg / 100.0d, uS.pgU));
            return view;
        }
    }

    private class b {
        TextView pic;
        TextView pie;
        TextView pif;
        TextView pig;
        TextView pih;
        View pii;
        TextView pij;
        TextView pik;

        private b() {
        }

        /* synthetic */ b(MallOrderRecordListUI mallOrderRecordListUI, byte b) {
            this();
        }
    }

    protected final int getLayoutId() {
        return g.uJC;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mHandler = new ag();
        bjn();
        initView();
        this.wn = 0;
        this.phX = null;
    }

    public void bjn() {
        jl(bb.CTRL_INDEX);
        jl(bf.CTRL_INDEX);
    }

    public void bjo() {
        jm(bb.CTRL_INDEX);
        jm(bf.CTRL_INDEX);
    }

    public void onResume() {
        super.onResume();
        if (this.phV != null) {
            this.phV.notifyDataSetChanged();
        }
    }

    public void dN(String str, String str2) {
        l(new com.tencent.mm.plugin.order.model.g(str, str2, 1));
    }

    public void bjp() {
        l(new com.tencent.mm.plugin.order.model.e(this.wn, this.phX));
    }

    protected final void initView() {
        if (com.tencent.mm.wallet_core.a.ag(this) instanceof com.tencent.mm.plugin.order.a.a) {
            this.acS = true;
            bjp();
        }
        setMMTitle(com.tencent.mm.plugin.wxpay.a.i.uRG);
        this.ljm = (MMLoadMoreListView) findViewById(f.uwT);
        this.phV = new a();
        this.ljm.setAdapter(this.phV);
        this.ljm.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                Activity activity = MallOrderRecordListUI.this;
                if (i < activity.phW.size()) {
                    i iVar = (i) activity.phW.get(i);
                    if (iVar != null) {
                        Bundle bundle = activity.vf;
                        bundle.putString("key_trans_id", iVar.pgO);
                        bundle.putInt("key_pay_type", iVar.pgW);
                        bundle.putString("bill_id", iVar.phh);
                        com.tencent.mm.wallet_core.a.j(activity, bundle);
                    }
                }
                e.HX(26);
            }
        });
        this.ljm.setOnItemLongClickListener(new OnItemLongClickListener() {
            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, final int i, long j) {
                if (i < MallOrderRecordListUI.this.phW.size()) {
                    h.a(MallOrderRecordListUI.this, MallOrderRecordListUI.this.getResources().getString(com.tencent.mm.plugin.wxpay.a.i.vat), null, MallOrderRecordListUI.this.getResources().getString(com.tencent.mm.plugin.wxpay.a.i.dEH), new h.c() {
                        public final void jo(int i) {
                            switch (i) {
                                case 0:
                                    i iVar = (i) MallOrderRecordListUI.this.phW.get(i);
                                    if (iVar != null) {
                                        MallOrderRecordListUI.this.dN(iVar.pgO, iVar.phh);
                                        return;
                                    }
                                    return;
                                default:
                                    return;
                            }
                        }
                    });
                }
                return true;
            }
        });
        this.ljm.ykC = new com.tencent.mm.ui.base.MMLoadMoreListView.a() {
            public final void ayD() {
                if (!MallOrderRecordListUI.this.acS) {
                    MallOrderRecordListUI.this.acS = true;
                    MallOrderRecordListUI mallOrderRecordListUI = MallOrderRecordListUI.this;
                    mallOrderRecordListUI.wn += 10;
                    MallOrderRecordListUI.this.bjp();
                }
            }
        };
        final com.tencent.mm.sdk.b.b svVar = new sv();
        svVar.fLv.fLx = "6";
        svVar.frD = new Runnable() {
            public final void run() {
                if (bi.oN(svVar.fLw.fLy)) {
                    x.i("MicroMsg.WalletOrderListUI", "no bulletin data");
                } else {
                    e.a((TextView) MallOrderRecordListUI.this.findViewById(f.ulY), svVar.fLw.fLy, svVar.fLw.content, svVar.fLw.url);
                }
            }
        };
        com.tencent.mm.sdk.b.a.xmy.m(svVar);
        com.tencent.mm.plugin.order.a.b.biZ().asP();
        this.phV.notifyDataSetChanged();
        com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.pWK;
        Object[] objArr = new Object[1];
        com.tencent.mm.plugin.order.a.b.biZ();
        objArr[0] = Integer.valueOf(com.tencent.mm.plugin.order.a.b.bjc().bjh());
        gVar.h(11036, objArr);
    }

    public final void bn(List<i> list) {
        if (list != null && list.size() != 0) {
            if (this.phW == null) {
                this.phW = new ArrayList();
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    i iVar = (i) list.get(i2);
                    if (!HS(iVar.pgO)) {
                        this.phW.add(iVar);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private boolean HS(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (int i = 0; i < this.phW.size(); i++) {
            i iVar = (i) this.phW.get(i);
            if (iVar != null && str.equals(iVar.pgO)) {
                return true;
            }
        }
        return false;
    }

    public void onDestroy() {
        bjo();
        super.onDestroy();
    }

    public String uR(int i) {
        return e.HW(i);
    }

    public final void bo(List<d> list) {
        if (list != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    d dVar = (d) list.get(i2);
                    if (dVar != null) {
                        this.phZ.put(dk(dVar.year, dVar.month), dVar.pgI);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private static String dk(int i, int i2) {
        return i + "-" + i2;
    }

    public boolean d(int i, int i2, String str, k kVar) {
        if (kVar instanceof com.tencent.mm.plugin.order.model.e) {
            if (this.mFC != null) {
                this.mFC.dismiss();
                this.mFC = null;
            }
            com.tencent.mm.plugin.order.model.e eVar = (com.tencent.mm.plugin.order.model.e) kVar;
            this.phX = eVar.pgL;
            bn(eVar.pgJ);
            bo(eVar.pgK);
            this.mCount = this.phW.size();
            this.omh = eVar.lon > this.mCount;
            this.phV.notifyDataSetChanged();
            x.d("MicroMsg.WalletOrderListUI", "orders list count: " + this.mCount);
            x.d("MicroMsg.WalletOrderListUI", "orders list total record: " + eVar.lon);
            x.d("MicroMsg.WalletOrderListUI", "orders list has more: " + this.omh);
            this.mHandler.post(new Runnable() {
                public final void run() {
                    if (MallOrderRecordListUI.this.omh) {
                        x.v("MicroMsg.WalletOrderListUI", "has more");
                        if (!MallOrderRecordListUI.this.phY) {
                            MallOrderRecordListUI.this.ljm.cqd();
                            MallOrderRecordListUI.this.ljm.setAdapter(MallOrderRecordListUI.this.phV);
                            MallOrderRecordListUI.this.phY = true;
                        }
                    } else {
                        x.v("MicroMsg.WalletOrderListUI", "no more! dismiss footer view!");
                        MallOrderRecordListUI.this.ljm.cqe();
                    }
                    MallOrderRecordListUI.this.phV.notifyDataSetChanged();
                }
            });
            this.acS = false;
        } else if (kVar instanceof com.tencent.mm.plugin.order.model.g) {
            if (this.mFC != null) {
                this.mFC.dismiss();
                this.mFC = null;
            }
            com.tencent.mm.plugin.order.model.g gVar = (com.tencent.mm.plugin.order.model.g) kVar;
            if (gVar.bji() == 2) {
                if (this.phW != null) {
                    this.phW.clear();
                }
                this.mCount = 0;
                this.omh = false;
                this.ljm.cqe();
            } else {
                String bjj = gVar.bjj();
                x.d("MicroMsg.WalletOrderListUI", "delete transId:" + bjj);
                if (!bi.oN(bjj)) {
                    for (i iVar : this.phW) {
                        if (bjj.equals(iVar.pgO)) {
                            this.phW.remove(iVar);
                            this.mCount = this.phW.size();
                            break;
                        }
                    }
                }
            }
            this.mHandler.post(new Runnable() {
                public final void run() {
                    MallOrderRecordListUI.this.phV.notifyDataSetChanged();
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
