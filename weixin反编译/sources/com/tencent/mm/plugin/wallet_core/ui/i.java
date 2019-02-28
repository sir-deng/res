package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.wallet.a.e;
import com.tencent.mm.plugin.wallet.a.h;
import com.tencent.mm.plugin.wallet.a.q;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.m;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MaxListView;
import com.tencent.mm.ui.base.k;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public final class i extends k {
    private LayoutInflater DF;
    private View kTo;
    private a sLI;
    private MaxListView sZK = ((MaxListView) this.kTo.findViewById(f.uFu));
    private TextView sZL = ((TextView) this.kTo.findViewById(f.uFs));
    private a sZM = new a();
    private b sZN;

    class a extends BaseAdapter {
        int sZP = -1;
        List<q> sZQ = new LinkedList();
        h sZR = null;
        m<String> sZS = new m<String>() {
            public final String a(Vector<com.tencent.mm.plugin.wallet_core.model.m.b> vector, int i) {
                if (vector == null) {
                    x.w("MicroMsg.WalletFavorDialog", "func[getComposedKey] keyList null");
                    return "";
                }
                StringBuilder stringBuilder = new StringBuilder();
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= vector.size()) {
                        break;
                    }
                    i2 = ((com.tencent.mm.plugin.wallet_core.model.m.b) vector.get(i3)).sTz;
                    if (i3 == i || i2 == com.tencent.mm.plugin.wallet_core.model.m.a.sTv) {
                        stringBuilder.append(((String) ((com.tencent.mm.plugin.wallet_core.model.m.b) vector.get(i3)).sTy) + "-");
                    }
                    i2 = i3 + 1;
                }
                if (stringBuilder.length() == 0) {
                    return "0";
                }
                if (stringBuilder.length() > 1) {
                    stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                }
                return stringBuilder.toString();
            }
        };

        public final int getCount() {
            return this.sZQ.size();
        }

        public final Object getItem(int i) {
            return this.sZQ.get(i);
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            c cVar;
            e eVar;
            CharSequence charSequence;
            CharSequence charSequence2;
            if (view == null) {
                view = i.this.DF.inflate(g.uLs, viewGroup, false);
                c cVar2 = new c();
                cVar2.sZU = view.findViewById(f.uFh);
                cVar2.jOY = (TextView) view.findViewById(f.uFg);
                cVar2.kVZ = (TextView) view.findViewById(f.uFf);
                cVar2.lpZ = (TextView) view.findViewById(f.uFe);
                cVar2.sZW = (CheckBox) view.findViewById(f.uFd);
                cVar2.sZV = (ImageView) view.findViewById(f.uFc);
                view.setTag(cVar2);
                cVar = cVar2;
            } else {
                cVar = (c) view.getTag();
            }
            q qVar = (q) getItem(i);
            if (i != this.sZP || this.sZP <= 0) {
                cVar.sZU.setVisibility(8);
                cVar.sZV.setVisibility(0);
            } else {
                cVar.sZU.setVisibility(0);
                cVar.sZV.setVisibility(8);
            }
            if (bi.oN(qVar.sKh)) {
                cVar.jOY.setVisibility(8);
            } else {
                cVar.jOY.setText(qVar.sKh);
                cVar.jOY.setVisibility(0);
            }
            String str = qVar.sJo;
            if (!(this.sZR == null || this.sZR.sJK == null)) {
                List list = this.sZR.sJK;
                for (int i2 = 0; i2 < list.size(); i2++) {
                    if (str.equals(((e) list.get(i2)).sJo)) {
                        eVar = (e) list.get(i2);
                        break;
                    }
                }
            }
            eVar = null;
            String str2 = qVar.sJp;
            String str3 = qVar.sJq;
            if (eVar != null) {
                charSequence = eVar.sJp;
                charSequence2 = eVar.sJq;
            } else {
                Object charSequence22 = str3;
                Object charSequence3 = str2;
            }
            if (bi.oN(charSequence3)) {
                cVar.kVZ.setVisibility(8);
            } else {
                cVar.kVZ.setText(charSequence3);
                cVar.kVZ.setVisibility(0);
            }
            if (bi.oN(charSequence22)) {
                cVar.lpZ.setVisibility(8);
            } else {
                cVar.lpZ.setText(charSequence22);
                cVar.lpZ.setVisibility(0);
            }
            int i3 = ((com.tencent.mm.plugin.wallet_core.model.m.b) this.sZS.sTr.get(i)).sTz;
            if (i3 == com.tencent.mm.plugin.wallet_core.model.m.a.sTu) {
                cVar.sZW.setChecked(false);
                cVar.sZW.setEnabled(false);
            } else {
                cVar.sZW.setEnabled(true);
                if (i3 == com.tencent.mm.plugin.wallet_core.model.m.a.sTv) {
                    cVar.sZW.setChecked(true);
                } else {
                    cVar.sZW.setChecked(false);
                }
            }
            return view;
        }
    }

    public interface b {
        void a(FavorPayInfo favorPayInfo);
    }

    static final class c {
        TextView jOY;
        TextView kVZ;
        TextView lpZ;
        View sZU;
        ImageView sZV;
        CheckBox sZW;

        c() {
        }
    }

    private i(Context context) {
        super(context, j.vfj);
        this.DF = LayoutInflater.from(context);
        this.kTo = LayoutInflater.from(context).inflate(g.uLv, null);
        this.sZK.setAdapter(this.sZM);
        this.kTo.findViewById(f.uFt).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                i.this.bNn();
                i.this.dismiss();
            }
        });
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(this.kTo);
    }

    public final void dismiss() {
        try {
            super.dismiss();
        } catch (Exception e) {
            x.e("MicroMsg.WalletFavorDialog", "dismiss exception, e = " + e.getMessage());
        }
    }

    public static i a(Context context, Orders orders, String str, b bVar) {
        Dialog iVar = new i(context);
        iVar.setOnCancelListener(null);
        iVar.setCancelable(true);
        iVar.sLI = b.sXj.a(orders);
        if (iVar.sLI == null) {
            x.w("MicroMsg.WalletFavorDialog", "mFavorLogicHelper null & dismiss");
            iVar.dismiss();
        } else {
            int i;
            Object obj;
            a aVar = iVar.sZM;
            com.tencent.mm.plugin.wallet.a.f fVar = aVar.sZO.sLI.sXd;
            String NR = aVar.sZO.sLI.NR(str);
            aVar.sZQ = aVar.sZO.sLI.bNa();
            aVar.sZR = aVar.sZO.sLI.NN(NR);
            aVar.sZP = -1;
            int i2 = 0;
            while (true) {
                i = i2;
                if (i >= aVar.sZQ.size()) {
                    break;
                }
                if ((((q) aVar.sZQ.get(i)).sKl != 0 ? 1 : null) != null) {
                    aVar.sZP = i;
                    break;
                }
                i2 = i + 1;
            }
            List linkedList = new LinkedList();
            if (aVar.sZQ != null) {
                i2 = 0;
                while (true) {
                    i = i2;
                    if (i >= aVar.sZQ.size()) {
                        break;
                    }
                    linkedList.add(((q) aVar.sZQ.get(i)).sJo);
                    i2 = i + 1;
                }
                List linkedList2 = new LinkedList();
                if (fVar != null && fVar.sJv != null) {
                    i2 = 0;
                    while (true) {
                        i = i2;
                        if (i >= fVar.sJv.size()) {
                            break;
                        }
                        String str2 = ((q) fVar.sJv.get(i)).sJo;
                        if (!linkedList.contains(str2)) {
                            linkedList2.add(str2);
                        }
                        i2 = i + 1;
                    }
                }
                List linkedList3 = new LinkedList();
                if (fVar == null || fVar.sJw == null || fVar.sJw.sJG == null) {
                    x.w("MicroMsg.WalletFavorDialog", "func[setCouponInfo] favorInfo.favorComposeList or favorInfo.favorComposeList.favorComposeInfo null");
                    obj = null;
                } else {
                    List list = fVar.sJw.sJG;
                    i2 = 0;
                    while (true) {
                        i = i2;
                        if (i >= list.size()) {
                            break;
                        }
                        String str3 = ((h) list.get(i)).sJI;
                        i2 = 0;
                        while (true) {
                            int i3 = i2;
                            if (i3 >= linkedList2.size()) {
                                obj = null;
                                break;
                            } else if (str3.contains((CharSequence) linkedList2.get(i3))) {
                                obj = 1;
                                break;
                            } else {
                                i2 = i3 + 1;
                            }
                        }
                        if (obj == null) {
                            linkedList3.add(str3);
                        }
                        i2 = i + 1;
                    }
                    List linkedList4 = new LinkedList();
                    if (!(bi.oN(NR) || NR.equals("0"))) {
                        String[] split = NR.split("-");
                        if (split != null) {
                            for (Object add : split) {
                                linkedList4.add(add);
                            }
                        } else {
                            x.w("MicroMsg.WalletFavorDialog", "func[setCouponInfo] preKeyArr null");
                            obj = null;
                        }
                    }
                    aVar.sZS.d(linkedList, linkedList4, linkedList3);
                    obj = 1;
                }
            } else {
                x.w("MicroMsg.WalletFavorDialog", "func[setCouponInfo] mFavorList null");
                obj = null;
            }
            if (obj == null) {
                x.w("MicroMsg.WalletFavorDialog", "initFavorInfo failed & dismiss");
                iVar.dismiss();
            } else {
                iVar.sZL.setText(com.tencent.mm.plugin.wxpay.a.i.uYe);
                iVar.sZK.setOnItemClickListener(new OnItemClickListener() {
                    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                        a b = i.this.sZM;
                        m mVar = b.sZS;
                        if (i < mVar.sTr.size()) {
                            int i2 = ((com.tencent.mm.plugin.wallet_core.model.m.b) mVar.sTr.get(i)).sTz;
                            int i3 = com.tencent.mm.plugin.wallet_core.model.m.a.sTv;
                            switch (com.tencent.mm.plugin.wallet_core.model.m.AnonymousClass1.sTt[i2 - 1]) {
                                case 1:
                                    mVar.ed(i, com.tencent.mm.plugin.wallet_core.model.m.a.sTv);
                                    break;
                                case 2:
                                    mVar.ed(i, com.tencent.mm.plugin.wallet_core.model.m.a.sTw);
                                    break;
                            }
                            mVar.bLV();
                        }
                        b.notifyDataSetChanged();
                    }
                });
            }
        }
        iVar.sZN = bVar;
        iVar.show();
        com.tencent.mm.ui.base.h.a(context, iVar);
        return iVar;
    }

    public final void setCancelable(boolean z) {
        super.setCancelable(z);
        setCanceledOnTouchOutside(z);
    }

    private void bNn() {
        x.d("MicroMsg.WalletFavorDialog", "On selection done");
        if (this.sZM != null) {
            m mVar = this.sZM.sZS;
            this.sZN.a(this.sLI.NQ(mVar.a(mVar.sTr, -1)));
        }
    }

    public final boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 4) {
            bNn();
        }
        return super.onKeyUp(i, keyEvent);
    }
}
