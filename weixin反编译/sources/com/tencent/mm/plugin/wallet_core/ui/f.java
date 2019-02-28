package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.content.Intent;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.bl.d;
import com.tencent.mm.plugin.wallet.a.k;
import com.tencent.mm.plugin.wallet.a.l;
import com.tencent.mm.plugin.wallet.pay.ui.WalletChangeBankcardUI;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_core.ui.view.FavourLayout;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.y.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class f extends BaseAdapter {
    private Context mContext;
    private Orders pVi = null;
    public ArrayList<Bankcard> sFo;
    private com.tencent.mm.plugin.wallet_core.e.a sHX;
    private int sKR;
    private int sZh = -1;
    public String sZi = "";
    public boolean sZj = true;
    private boolean sZk = false;

    class a {
        public TextView ikn;
        public TextView ppv;
        public FavourLayout sZm;
        public CheckedTextView sZn;
        public ImageView sZo;

        a() {
        }
    }

    public /* synthetic */ Object getItem(int i) {
        return zt(i);
    }

    public f(Context context, ArrayList<Bankcard> arrayList, int i, Orders orders) {
        this.mContext = context;
        this.sFo = arrayList;
        this.sKR = i;
        this.pVi = orders;
        this.sHX = new com.tencent.mm.plugin.wallet_core.e.a();
        this.sHX.b(this.mContext, this.sFo);
        if (orders != null && orders.sUn == 1) {
            this.sZk = true;
        }
    }

    public int getCount() {
        int i = 0;
        if (!this.sZk) {
            if (this.pVi == null || !this.pVi.sUb.equals("CFT")) {
                i = 1;
            }
            return this.sFo != null ? i + this.sFo.size() : i;
        } else if (this.sFo == null) {
            return 0;
        } else {
            return this.sFo.size();
        }
    }

    public Bankcard zt(int i) {
        if (this.sZk) {
            return (Bankcard) this.sFo.get(i);
        }
        int count = getCount();
        if (this.pVi == null || !this.pVi.sUb.equals("CFT")) {
            count--;
        }
        if (i < count) {
            return (Bankcard) this.sFo.get(i);
        }
        return null;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public boolean isEnabled(int i) {
        Bankcard zt = zt(i);
        if (zt == null || zt.a(this.sKR, this.pVi) == 0) {
            return true;
        }
        return false;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = View.inflate(this.mContext, g.uLo, null);
            aVar = new a();
            aVar.ikn = (TextView) view.findViewById(com.tencent.mm.plugin.wxpay.a.f.title);
            aVar.ppv = (TextView) view.findViewById(com.tencent.mm.plugin.wxpay.a.f.summary);
            aVar.sZn = (CheckedTextView) view.findViewById(com.tencent.mm.plugin.wxpay.a.f.gXa);
            aVar.sZo = (ImageView) view.findViewById(com.tencent.mm.plugin.wxpay.a.f.ulz);
            aVar.sZm = (FavourLayout) view.findViewById(com.tencent.mm.plugin.wxpay.a.f.uqR);
            aVar.ppv.setText("");
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.ppv.setTextColor(ad.getResources().getColor(c.bsO));
        aVar.sZm.setVisibility(8);
        Bankcard zt = zt(i);
        LinkedList linkedList;
        if (zt == null) {
            aVar.sZn.setVisibility(4);
            aVar.ppv.setVisibility(8);
            aVar.ikn.setText(i.vaV);
            aVar.sZo.setVisibility(8);
            LinkedList linkedList2 = new LinkedList();
            if (!(this.pVi == null || this.pVi.sUg == null || this.pVi.sUg.sJF == null)) {
                k kVar = this.pVi.sUg.sJF.sJl;
                if (kVar != null) {
                    Iterator it = kVar.sJP.iterator();
                    while (it.hasNext()) {
                        linkedList2.add(((l) it.next()).pPL);
                    }
                    linkedList = linkedList2;
                    if (this.sZj && linkedList.size() > 0) {
                        aVar.sZm.setVisibility(0);
                        aVar.ppv.setVisibility(8);
                        aVar.sZm.ao(linkedList);
                    }
                }
            }
            linkedList = linkedList2;
            aVar.sZm.setVisibility(0);
            aVar.ppv.setVisibility(8);
            aVar.sZm.ao(linkedList);
        } else {
            aVar.sZo.setVisibility(0);
            aVar.sZn.setVisibility(0);
            aVar.ppv.setVisibility(0);
            aVar.ppv.setText("");
            aVar.ikn.setText(zt.field_desc);
            if (zt.bLB()) {
                Bankcard bankcard = o.bMc().sFY;
                if (!bi.oN(bankcard.sRp)) {
                    aVar.ikn.setText(bankcard.sRp);
                } else if (bankcard.sRo >= 0.0d) {
                    aVar.ikn.setText(this.mContext.getString(q.Gl() ? i.uXm : i.uXl, new Object[]{e.u(bankcard.sRo)}));
                } else {
                    aVar.ikn.setText(this.mContext.getText(i.uYw));
                }
            } else if (zt.bLC()) {
                Bankcard bankcard2 = o.bMc().sWo;
                if (!bi.oN(bankcard2.sRp)) {
                    aVar.ikn.setText(bankcard2.sRp);
                } else if (bankcard2.sRo >= 0.0d) {
                    aVar.ikn.setText(this.mContext.getString(i.uYS, new Object[]{e.u(bankcard2.sRo)}));
                } else {
                    aVar.ikn.setText(this.mContext.getText(i.uYw));
                }
            }
            aVar.ppv.setVisibility(0);
            switch (zt.a(this.sKR, this.pVi)) {
                case 1:
                    aVar.ppv.setText(i.vaY);
                    break;
                case 2:
                    aVar.ppv.setText(i.vbe);
                    break;
                case 3:
                    aVar.ppv.setText(i.vbj);
                    break;
                case 4:
                    aVar.ppv.setText(i.vba);
                    break;
                case 5:
                    aVar.ppv.setText(i.vaW);
                    break;
                case 6:
                    aVar.ppv.setText(i.vbc);
                    break;
                case 7:
                    aVar.ppv.setText(i.vbh);
                    break;
                case 8:
                    aVar.ppv.setText(zt.field_forbidWord);
                    break;
                default:
                    if (!bi.oN(zt.field_tips)) {
                        aVar.ppv.setText(zt.field_tips);
                        break;
                    }
                    aVar.ppv.setVisibility(8);
                    break;
            }
            String charSequence = aVar.ppv.getText().toString();
            aVar.ikn.setTextColor(this.mContext.getResources().getColor(c.btv));
            if (this.sZi.equalsIgnoreCase(zt.field_bindSerial)) {
                aVar.sZn.setChecked(true);
                aVar.sZn.setEnabled(true);
            } else if (isEnabled(i)) {
                aVar.sZn.setChecked(false);
                aVar.sZn.setEnabled(true);
            } else {
                aVar.sZn.setEnabled(false);
                aVar.sZn.setChecked(false);
                aVar.ikn.setTextColor(this.mContext.getResources().getColor(c.bsO));
            }
            aVar.sZo.setTag(com.tencent.mm.plugin.wxpay.a.f.uFb, null);
            aVar.sZo.setTag(null);
            aVar.sZo.setImageDrawable(null);
            aVar.ppv.setOnClickListener(null);
            if (zt.bLB()) {
                ImageView imageView = aVar.sZo;
                if (imageView != null) {
                    imageView.setTag(com.tencent.mm.plugin.wxpay.a.f.uFb, null);
                    imageView.setImageResource(com.tencent.mm.plugin.wxpay.a.e.ukf);
                }
            } else if (zt.bLC()) {
                this.sHX.a(zt, aVar.sZo);
            } else if (zt.bLF()) {
                b.a(aVar.sZo, zt.sRA, 0.06f, false);
            } else {
                this.sHX.a(this.mContext, zt, aVar.sZo);
            }
            if (!bi.oN(zt.field_forbid_title) && !bi.oN(zt.field_forbid_url)) {
                charSequence = charSequence + "  ";
                CharSequence spannableString = new SpannableString(charSequence + zt.field_forbid_title);
                aVar.ppv.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        if (view.getTag() instanceof String) {
                            Intent intent = new Intent();
                            x.i("MicroMsg.WalletChangeBankcardAdapter", "go to url %s", (String) view.getTag());
                            intent.putExtra("rawUrl", r0);
                            intent.putExtra("geta8key_username", q.FY());
                            intent.putExtra("pay_channel", 1);
                            d.b(f.this.mContext, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent, WalletChangeBankcardUI.sKP);
                        }
                    }
                });
                spannableString.setSpan(new ForegroundColorSpan(ad.getResources().getColor(c.uhX)), charSequence.length(), charSequence.length() + zt.field_forbid_title.length(), 34);
                aVar.ppv.setText(spannableString);
                aVar.ppv.setTag(zt.field_forbid_url);
            } else if (this.sZj && bi.oN(zt.field_forbidWord) && bi.oN(charSequence)) {
                linkedList = f(zt);
                if (linkedList.size() > 0) {
                    aVar.sZm.setVisibility(0);
                    aVar.ppv.setVisibility(8);
                    aVar.sZm.ao(linkedList);
                }
            }
        }
        return view;
    }

    private LinkedList<String> f(Bankcard bankcard) {
        LinkedList<String> linkedList = new LinkedList();
        if (!(this.pVi == null || this.pVi.sUg == null || this.pVi.sUg.sJF == null)) {
            Iterator it = this.pVi.sUg.sJF.sJk.iterator();
            while (it.hasNext()) {
                com.tencent.mm.plugin.wallet.a.b bVar = (com.tencent.mm.plugin.wallet.a.b) it.next();
                if (bVar.pfg.equals(bankcard.field_bindSerial)) {
                    it = bVar.sJm.iterator();
                    while (it.hasNext()) {
                        linkedList.add(((com.tencent.mm.plugin.wallet.a.c) it.next()).pPL);
                    }
                    return linkedList;
                }
            }
        }
        return linkedList;
    }

    public final void d(ArrayList<Bankcard> arrayList, boolean z) {
        if (arrayList == null) {
            this.sFo = new ArrayList();
        } else {
            this.sFo = arrayList;
        }
        this.sZj = z;
        if (this.sFo.size() > 0) {
            this.sHX.b(this.mContext, this.sFo);
        }
        notifyDataSetChanged();
    }
}
