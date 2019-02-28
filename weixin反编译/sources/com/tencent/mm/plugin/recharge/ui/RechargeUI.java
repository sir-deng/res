package com.tencent.mm.plugin.recharge.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.Contacts;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.a.tb;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.plugin.recharge.model.MallRechargeProduct;
import com.tencent.mm.plugin.recharge.ui.MallEditText.b;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.MallNews;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.c.adp;
import com.tencent.mm.protocal.c.wj;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.ListViewInScrollView;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.y.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RechargeUI extends MMActivity implements e, com.tencent.mm.platformtools.j.a, b {
    protected Dialog ion = null;
    private Button lXK = null;
    private MallFunction pIM = null;
    private TextView pJc = null;
    private TextView pJd = null;
    private TextView pJe = null;
    private TextView pJf = null;
    private FrameLayout pJg = null;
    private ImageView pJh = null;
    private ImageView pJi = null;
    private LinearLayout pJj = null;
    private a pJk = null;
    private a pJl = null;
    private MallEditText pJm;
    private TextView pJn;
    private int pJo;
    private MallRechargeProduct pJp = null;
    private String pJq = null;
    private MallNews pJr = null;
    private boolean pJs = false;
    private boolean pJt = true;
    private Map<String, Integer> pJu = new HashMap();
    private String pJv;
    public String pJw;
    private String pJx;
    public String pJy;
    private boolean plo = false;
    private c plr = new c<tb>() {
        {
            this.xmG = tb.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            tb tbVar = (tb) bVar;
            if (tbVar instanceof tb) {
                if (tbVar.fMn.result != -1) {
                    x.i("MicroMsg.MallRechargeUI", "MallRecharge pay result : cancel");
                } else if (!RechargeUI.this.plo) {
                    x.i("MicroMsg.MallRechargeUI", "MallRecharge pay result : ok");
                    com.tencent.mm.plugin.recharge.a.a.bmX().a(RechargeUI.this.pJm.bnc());
                    RechargeUI.this.finish();
                    RechargeUI.this.plo = true;
                }
                return true;
            }
            x.f("MicroMsg.MallRechargeUI", "mismatched event");
            return false;
        }
    };

    private class a extends BaseAdapter {
        private List<MallRechargeProduct> pHE;

        private a() {
            this.pHE = null;
        }

        /* synthetic */ a(RechargeUI rechargeUI, byte b) {
            this();
        }

        public final /* synthetic */ Object getItem(int i) {
            return vG(i);
        }

        public final void by(List<MallRechargeProduct> list) {
            this.pHE = list;
            notifyDataSetChanged();
        }

        public final void vF(int i) {
            for (int i2 = 0; i2 < this.pHE.size(); i2++) {
                ((MallRechargeProduct) this.pHE.get(i2)).isDefault = false;
            }
            ((MallRechargeProduct) this.pHE.get(i)).isDefault = true;
        }

        public final int getCount() {
            return this.pHE == null ? 0 : this.pHE.size();
        }

        public final MallRechargeProduct vG(int i) {
            return (MallRechargeProduct) this.pHE.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final boolean isEnabled(int i) {
            if (vG(i).isValid()) {
                return super.isEnabled(i);
            }
            return false;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            CheckedTextView checkedTextView = (CheckedTextView) View.inflate(RechargeUI.this, g.uKv, null);
            MallRechargeProduct vG = vG(i);
            checkedTextView.setText(vG.lKx);
            checkedTextView.setEnabled(vG.isValid());
            if (vG.isDefault) {
                checkedTextView.setChecked(true);
            } else {
                checkedTextView.setChecked(false);
            }
            return checkedTextView;
        }
    }

    static /* synthetic */ boolean c(RechargeUI rechargeUI) {
        if (rechargeUI.pJm.bnc().fqY != 0) {
            return true;
        }
        Context context = rechargeUI;
        h.a(context, rechargeUI.getString(i.uSs, new Object[]{rechargeUI.pJm.getText().toString()}), "", rechargeUI.getString(i.dHo), rechargeUI.getString(i.dGc), new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                RechargeUI.this.n(new com.tencent.mm.plugin.recharge.model.g(RechargeUI.this.pJp, RechargeUI.this.bni()));
            }
        }, null);
        return false;
    }

    protected /* synthetic */ Dialog onCreateDialog(int i) {
        switch (i) {
            case 1:
                final int color = getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.uig);
                final int color2 = getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.buj);
                View inflate = getLayoutInflater().inflate(g.uKu, null);
                final TextView textView = (TextView) inflate.findViewById(f.uBs);
                final ListViewInScrollView listViewInScrollView = (ListViewInScrollView) inflate.findViewById(f.uBw);
                final ListViewInScrollView listViewInScrollView2 = (ListViewInScrollView) inflate.findViewById(f.uBA);
                final TextView textView2 = (TextView) inflate.findViewById(f.uBt);
                final View findViewById = inflate.findViewById(f.uBv);
                final TextView textView3 = (TextView) inflate.findViewById(f.uBx);
                final View findViewById2 = inflate.findViewById(f.uBz);
                RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(f.uBI);
                LayoutParams layoutParams = (LayoutParams) relativeLayout.getLayoutParams();
                layoutParams.height = (getResources().getDimensionPixelSize(d.uii) * this.pJo) + 4;
                relativeLayout.setLayoutParams(layoutParams);
                listViewInScrollView.setAdapter(this.pJk);
                listViewInScrollView.setOnItemClickListener(new OnItemClickListener() {
                    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                        RechargeUI.this.dismissDialog(1);
                        x.d("MicroMsg.MallRechargeUI", "onItemClick : " + i);
                        x.d("MicroMsg.MallRechargeUI", "checkProduct: " + RechargeUI.this.pJp);
                        RechargeUI.this.pJp = RechargeUI.this.pJk.vG(i);
                        RechargeUI.this.pJk.vF(i);
                        RechargeUI.this.pJk.notifyDataSetChanged();
                        x.d("MicroMsg.MallRechargeUI", "checkProduct: " + RechargeUI.this.pJp);
                        RechargeUI.this.av();
                    }
                });
                listViewInScrollView2.setAdapter(this.pJl);
                listViewInScrollView2.setOnItemClickListener(new OnItemClickListener() {
                    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                        RechargeUI.this.dismissDialog(1);
                        x.d("MicroMsg.MallRechargeUI", "onItemClick : " + i);
                        RechargeUI.this.pJp = RechargeUI.this.pJl.vG(i);
                        RechargeUI.this.pJl.vF(i);
                        RechargeUI.this.pJl.notifyDataSetChanged();
                        RechargeUI.this.pJu.remove(RechargeUI.p(RechargeUI.this.pJp.pHA, RechargeUI.this.pJp.frQ, RechargeUI.this.bnj()));
                        RechargeUI.this.XT();
                        RechargeUI.this.av();
                    }
                });
                inflate.findViewById(f.uBu).setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        findViewById.setVisibility(0);
                        textView2.setTextColor(color2);
                        listViewInScrollView.setVisibility(0);
                        findViewById2.setVisibility(8);
                        textView3.setTextColor(color);
                        listViewInScrollView2.setVisibility(8);
                        if (RechargeUI.this.pJk.getCount() == 0) {
                            textView.setVisibility(0);
                        } else {
                            textView.setVisibility(8);
                        }
                    }
                });
                final View view = findViewById2;
                final TextView textView4 = textView3;
                final int i2 = color2;
                final ListViewInScrollView listViewInScrollView3 = listViewInScrollView2;
                final View view2 = findViewById;
                final TextView textView5 = textView2;
                final int i3 = color;
                final ListViewInScrollView listViewInScrollView4 = listViewInScrollView;
                final TextView textView6 = textView;
                inflate.findViewById(f.uBy).setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        view.setVisibility(0);
                        textView4.setTextColor(i2);
                        listViewInScrollView3.setVisibility(0);
                        view2.setVisibility(8);
                        textView5.setTextColor(i3);
                        listViewInScrollView4.setVisibility(8);
                        if (RechargeUI.this.pJl.getCount() == 0) {
                            textView6.setVisibility(0);
                        } else {
                            textView6.setVisibility(8);
                        }
                    }
                });
                if (this.pJk.getCount() == 0) {
                    textView.setVisibility(0);
                } else {
                    textView.setVisibility(8);
                }
                com.tencent.mm.ui.base.i.a aVar = new com.tencent.mm.ui.base.i.a(this);
                aVar.Zm(null);
                aVar.dk(inflate);
                aVar.d(null);
                return aVar.ale();
            default:
                return h.b(this, getString(i.uSx), "", true);
        }
    }

    protected final int getLayoutId() {
        return g.uKx;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        this.pIM = (MallFunction) intent.getParcelableExtra("key_func_info");
        List parcelableArrayListExtra = intent.getParcelableArrayListExtra("key_product_list");
        this.pJt = !intent.getBooleanExtra("key_is_hide_progress", false);
        if (this.pIM == null) {
            x.e("MicroMsg.MallRechargeUI", "function info is null");
            u.makeText(this, "function info is null", 1).show();
            return;
        }
        if (parcelableArrayListExtra == null) {
            x.d("MicroMsg.MallRechargeUI", "function info : " + this.pIM.fJD);
            n(new com.tencent.mm.plugin.recharge.model.e(this.pIM.pHt));
        } else {
            this.pJp = a.bw(parcelableArrayListExtra);
        }
        x.i("MicroMsg.MallRechargeUI", "onCreate()");
        this.pJr = com.tencent.mm.plugin.wallet_core.model.mall.c.bMQ().NG(this.pIM.pHt);
        initView();
    }

    protected final void initView() {
        setMMTitle(this.pIM.fJD);
        x.v("MicroMsg.MallRechargeUI", "initView");
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                RechargeUI.this.aWY();
                RechargeUI.this.finish();
                return true;
            }
        });
        this.pJc = (TextView) findViewById(f.uwX);
        this.pJd = (TextView) findViewById(f.uxS);
        this.pJe = (TextView) findViewById(f.uxU);
        this.lXK = (Button) findViewById(f.cAl);
        this.pJj = (LinearLayout) findViewById(f.uwA);
        this.pJf = (TextView) findViewById(f.uxT);
        this.pJf.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("rawUrl", RechargeUI.this.pJx);
                com.tencent.mm.bl.d.b(RechargeUI.this, "webview", ".ui.tools.WebViewUI", intent);
            }
        });
        this.lXK.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (RechargeUI.this.XT() && RechargeUI.c(RechargeUI.this)) {
                    RechargeUI.this.n(new com.tencent.mm.plugin.recharge.model.g(RechargeUI.this.pJp, RechargeUI.this.bni()));
                }
            }
        });
        this.pJm = (MallEditText) findViewById(f.uwD);
        this.pJm.ipm.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (RechargeUI.this.pJm.pHZ) {
                    RechargeUI.this.pJm.b(null);
                    return;
                }
                RechargeUI.this.startActivityForResult(new Intent("android.intent.action.PICK", Contacts.CONTENT_URI), 1);
            }
        });
        this.pJn = (TextView) findViewById(f.uxc);
        List parcelableArrayListExtra = getIntent().getParcelableArrayListExtra("key_product_list");
        List c = c(0, parcelableArrayListExtra);
        List c2 = c(2, parcelableArrayListExtra);
        this.pJo = c.size() > c2.size() ? c.size() : c2.size();
        this.pJk = new a();
        this.pJk.by(c);
        this.pJl = new a();
        this.pJl.by(c2);
        this.pJj.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if ((RechargeUI.this.pJk != null && RechargeUI.this.pJk.getCount() > 0) || (RechargeUI.this.pJl != null && RechargeUI.this.pJl.getCount() > 0)) {
                    RechargeUI.this.showDialog(1);
                }
            }
        });
        this.pJg = (FrameLayout) findViewById(f.uxP);
        this.pJh = (ImageView) findViewById(f.uxR);
        this.pJi = (ImageView) findViewById(f.uxQ);
        this.pJi.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                com.tencent.mm.plugin.wallet_core.model.mall.c bMQ = com.tencent.mm.plugin.wallet_core.model.mall.c.bMQ();
                String str = RechargeUI.this.pIM.pHt;
                x.d("MicroMsg.MallNewsManager", "removeNewsInIndexUI : " + str);
                if (!bi.oN(str) && bMQ.sWU.containsKey(str)) {
                    MallNews mallNews = (MallNews) bMQ.sWU.get(str);
                    if ("1".equals(mallNews.sWI)) {
                        mallNews.sWI = "2";
                        bMQ.bjN();
                    }
                }
                RechargeUI.this.pJg.setVisibility(8);
            }
        });
        this.pJg.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (!bi.oN(RechargeUI.this.pIM.sWC.sWM)) {
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", RechargeUI.this.pIM.sWC.sWM);
                    intent.putExtra("geta8key_username", q.FY());
                    com.tencent.mm.bl.d.b(RechargeUI.this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
                }
            }
        });
        this.pJm.pHX = this;
        this.pJm.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                RechargeUI.this.pJm.pHY.findFocus();
                if (RechargeUI.this.pJm.bnc().fqY == 2) {
                    RechargeUI.this.pJm.b(null);
                }
                if (bi.oN(RechargeUI.this.pJm.getText().toString())) {
                    RechargeUI.this.pJm.pHY.showDropDown();
                }
                RechargeUI.this.showVKB();
            }
        });
        bnd();
        j.a((com.tencent.mm.platformtools.j.a) this);
        av();
    }

    private void av() {
        x.d("MicroMsg.MallRechargeUI", "mCheckedProduct " + this.pJp);
        if (this.pJp != null) {
            CharSequence string;
            this.pJn.setText(this.pJp.lKx);
            TextView textView = this.pJe;
            MallRechargeProduct mallRechargeProduct = this.pJp;
            if (!mallRechargeProduct.isValid()) {
                string = getString(i.uSw);
            } else if (mallRechargeProduct.pHv != mallRechargeProduct.pHw || (bnk() && this.pJp.pHB)) {
                string = "";
            } else {
                string = String.format(getString(i.uSy), new Object[]{Float.valueOf(mallRechargeProduct.pHv)});
            }
            textView.setText(string);
        }
        if (this.pJr != null && this.pIM.sWC != null && this.pJr.equals(this.pIM.sWC) && !"1".equals(this.pJr.sWI)) {
            this.pJg.setVisibility(8);
            x.d("MicroMsg.MallRechargeUI", "dismiss banner!, news->" + this.pJr.toString());
        } else if (this.pIM.sWC == null || bi.oN(this.pIM.sWC.sWN)) {
            this.pJg.setVisibility(8);
            x.d("MicroMsg.MallRechargeUI", "dismiss banner!");
        } else {
            this.pJq = this.pIM.sWC.sWN;
            this.pJh.setImageBitmap(j.a(new com.tencent.mm.plugin.recharge.b.a(this.pJq)));
            this.pJg.setVisibility(0);
            x.d("MicroMsg.MallRechargeUI", "Show banner!");
        }
        this.pJd.setVisibility(4);
        if (!XT()) {
            this.pJc.setText("");
        } else if (!(this.pJp == null || bnk())) {
            this.pJc.setText(this.pJp.pHu);
            this.pJc.setTextColor(getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.bsO));
        }
        String string2 = getString(i.uSq);
        if (!TextUtils.isEmpty(this.pJw)) {
            string2 = this.pJw;
        }
        if (!bi.oN(this.pJv)) {
            addTextOptionMenu(0, string2, new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", RechargeUI.this.pJv);
                    com.tencent.mm.bl.d.b(RechargeUI.this, "webview", ".ui.tools.WebViewUI", intent);
                    return true;
                }
            });
        }
        if (bi.oN(this.pJx)) {
            this.pJf.setVisibility(8);
        } else {
            this.pJf.setVisibility(0);
        }
        if (!TextUtils.isEmpty(this.pJy)) {
            this.pJf.setText(this.pJy);
        }
    }

    private static List<MallRechargeProduct> c(int i, List<MallRechargeProduct> list) {
        List<MallRechargeProduct> arrayList = new ArrayList();
        if (list != null) {
            boolean z = false;
            for (int i2 = 0; i2 < list.size(); i2++) {
                MallRechargeProduct mallRechargeProduct = (MallRechargeProduct) list.get(i2);
                if (mallRechargeProduct.pHA == i) {
                    arrayList.add(mallRechargeProduct);
                    if (mallRechargeProduct.isDefault) {
                        if (z) {
                            mallRechargeProduct.isDefault = false;
                        }
                        z = true;
                    }
                }
            }
            if (!z && arrayList.size() > 0) {
                ((MallRechargeProduct) arrayList.get(0)).isDefault = true;
            }
        }
        return arrayList;
    }

    private void n(final k kVar) {
        if (kVar.getType() == 497 || kVar.getType() == 1555) {
            com.tencent.mm.kernel.g.Dr();
            com.tencent.mm.kernel.g.Dp().gRu.a(kVar, 0);
        } else if (this.pJt) {
            if (this.ion == null || !(this.ion == null || this.ion.isShowing())) {
                this.ion = com.tencent.mm.wallet_core.ui.g.a(this.mController.xRr, true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        com.tencent.mm.kernel.g.Dr();
                        com.tencent.mm.kernel.g.Dp().gRu.c(kVar);
                    }
                });
            }
            com.tencent.mm.kernel.g.Dr();
            com.tencent.mm.kernel.g.Dp().gRu.a(kVar, 0);
        } else {
            com.tencent.mm.kernel.g.Dr();
            com.tencent.mm.kernel.g.Dp().gRu.a(kVar, 0);
        }
    }

    private boolean XT() {
        boolean z;
        MallEditText mallEditText = this.pJm;
        if (mallEditText.getVisibility() == 0) {
            if (bi.oN(mallEditText.getText())) {
                x.d("MicroMsg.MallEditText", "View:" + mallEditText.ipo + ", editType:" + mallEditText.ipp + " checkInputValid : empty ");
                z = false;
            } else if (!mallEditText.ipt) {
                x.d("MicroMsg.MallEditText", "View:" + mallEditText.ipo + ", editType:" + mallEditText.ipp + " checkInputValid : illegal ");
                z = false;
            }
            if (z) {
                z = false;
            } else {
                z = true;
            }
            if (z || this.pJp == null || !this.pJp.isValid()) {
                if (!(this.pJs || z || this.pJp == null)) {
                    this.pJp.isValid();
                }
                this.lXK.setEnabled(false);
                this.lXK.setClickable(false);
                x.d("MicroMsg.MallRechargeUI", "checkInfo : false");
                return false;
            }
            if (bnk() && this.pJp.pHB) {
                n(new com.tencent.mm.plugin.recharge.model.d(this.pJp.pHA, this.pIM.pHt, this.pJp.frQ, this.pJp.appId, bni(), bnj()));
            }
            aWY();
            this.lXK.setEnabled(true);
            this.lXK.setClickable(true);
            x.d("MicroMsg.MallRechargeUI", "checkInfo : true");
            return true;
        }
        z = true;
        if (z) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
        }
        this.pJp.isValid();
        this.lXK.setEnabled(false);
        this.lXK.setClickable(false);
        x.d("MicroMsg.MallRechargeUI", "checkInfo : false");
        return false;
    }

    private String bni() {
        return "mobile=" + com.tencent.mm.plugin.recharge.model.b.II(this.pJm.getText());
    }

    private String bnj() {
        return com.tencent.mm.plugin.recharge.model.b.II(this.pJm.getText());
    }

    private static String p(int i, String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(i);
        stringBuilder.append("-");
        stringBuilder.append(str);
        stringBuilder.append("-");
        stringBuilder.append(str2);
        return stringBuilder.toString();
    }

    private boolean bnk() {
        return !this.pJu.containsKey(p(this.pJp.pHA, this.pJp.frQ, bnj()));
    }

    public final void hB(boolean z) {
        if (!z) {
            this.pJu.clear();
            this.pJc.setText("");
            this.pJd.setVisibility(4);
        }
        XT();
    }

    public final void bnd() {
        if (bi.oN(this.pJm.getText()) || this.pJm.XX()) {
            this.pJm.vC(com.tencent.mm.plugin.wxpay.a.e.ukc);
        } else {
            this.pJm.vC(com.tencent.mm.plugin.wxpay.a.e.bDp);
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.d("MicroMsg.MallRechargeUI", "onSceneEnd errType = " + i + ", errCode = " + i2);
        if (!(this.ion == null || !this.ion.isShowing() || kVar.getType() == 497)) {
            this.ion.dismiss();
            this.ion = null;
        }
        if (i == 0 && i2 == 0) {
            if (kVar instanceof com.tencent.mm.plugin.recharge.model.e) {
                com.tencent.mm.plugin.recharge.model.e eVar = (com.tencent.mm.plugin.recharge.model.e) kVar;
                List list = eVar.pHG;
                if (list != null) {
                    this.pJp = a.bw(list);
                    x.d("MicroMsg.MallRechargeUI", "mCheckedProduct again" + this.pJp);
                }
                this.pJv = eVar.pHH;
                this.pJw = eVar.pHI;
                this.pJx = eVar.pHJ;
                this.pJy = eVar.pHK;
                x.d("MicroMsg.MallRechargeUI", "mProductList " + list);
                av();
                List c = c(0, list);
                List c2 = c(2, list);
                this.pJo = c.size() > c2.size() ? c.size() : c2.size();
                this.pJk.by(c);
                this.pJl.by(c2);
            } else if (kVar instanceof com.tencent.mm.plugin.recharge.model.d) {
                x.d("MicroMsg.MallRechargeUI", "checkProduct: " + this.pJp);
                com.tencent.mm.plugin.recharge.model.d dVar = (com.tencent.mm.plugin.recharge.model.d) kVar;
                if (!(this.pJp == null || this.pJp.frQ == null || dVar.pHD == null || ((!this.pJp.frQ.equals(dVar.pHD.frQ) || !bnj().equals(dVar.int)) && dVar.pHA == 2))) {
                    MallRechargeProduct.a(dVar.pHD, this.pJp);
                    this.pJp.isDefault = true;
                    this.pJu.put(p(dVar.pHA, dVar.pHD.frQ, dVar.int), Integer.valueOf(1));
                    av();
                    this.pJd.setText(str);
                    this.pJd.setVisibility(0);
                    this.pJd.setTextColor(getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.uhh));
                }
                if (dVar.pHA == 2) {
                    if (this.pJp == null || !this.pJp.frQ.equals(dVar.pHF) || !bnj().equals(dVar.int)) {
                        this.lXK.setEnabled(true);
                        this.lXK.setClickable(true);
                        this.pJd.setText(null);
                    } else if (((adp) dVar.gLB.hnR.hnY).wnz == 0 && this.pJp.frQ.equals(dVar.pHD.frQ)) {
                        n(new com.tencent.mm.plugin.recharge.model.c(this.pJp.pHt, bnj(), this.pJp.lKx, this.pJp.appId, bni()));
                    } else {
                        this.lXK.setEnabled(false);
                        this.lXK.setClickable(false);
                        this.pJd.setText(((adp) dVar.gLB.hnR.hnY).wnA);
                        this.pJd.setVisibility(0);
                        this.pJd.setTextColor(getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.btC));
                    }
                }
                bx(dVar.pHE);
                x.d("MicroMsg.MallRechargeUI", "NetSceneGetLatestPayProductInfo  mCheckedProduct " + this.pJp);
            } else if (kVar instanceof com.tencent.mm.plugin.recharge.model.g) {
                PayInfo payInfo = ((com.tencent.mm.plugin.recharge.model.g) kVar).pHW;
                payInfo.fDQ = 6;
                payInfo.vGi = 100;
                com.tencent.mm.pluginsdk.wallet.h.a((Context) this, payInfo, 2);
                com.tencent.mm.sdk.b.a.xmy.b(this.plr);
            } else if (kVar instanceof com.tencent.mm.plugin.recharge.model.c) {
                com.tencent.mm.plugin.recharge.model.c cVar = (com.tencent.mm.plugin.recharge.model.c) kVar;
                if (this.pJp == null || !this.pJp.lKx.equals(cVar.lKx) || !bnj().equals(cVar.fBa)) {
                    this.lXK.setEnabled(true);
                    this.lXK.setClickable(true);
                    this.pJd.setText(null);
                } else if (((wj) cVar.gLB.hnR.hnY).wnz != 0) {
                    this.lXK.setEnabled(false);
                    this.lXK.setClickable(false);
                    this.pJd.setText(((wj) cVar.gLB.hnR.hnY).wnA);
                    this.pJd.setVisibility(0);
                    this.pJd.setTextColor(getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.btC));
                }
            }
        } else if (!(kVar instanceof com.tencent.mm.plugin.recharge.model.c)) {
            if (kVar instanceof com.tencent.mm.plugin.recharge.model.d) {
                if (i2 == 100) {
                    this.lXK.setEnabled(true);
                    this.lXK.setClickable(true);
                } else {
                    this.lXK.setEnabled(false);
                    this.lXK.setClickable(false);
                }
                bx(((com.tencent.mm.plugin.recharge.model.d) kVar).pHE);
                this.pJd.setText(str);
                this.pJd.setVisibility(0);
                this.pJd.setTextColor(getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.btC));
                this.pJc.setText(((com.tencent.mm.plugin.recharge.model.d) kVar).pHu);
                this.pJc.setTextColor(getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.btC));
                return;
            }
            if (bi.oN(str)) {
                str = getString(i.vdG);
            }
            h.a((Context) this, str, null, false, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
        }
    }

    protected void onResume() {
        super.onResume();
        com.tencent.mm.kernel.g.Dr();
        com.tencent.mm.kernel.g.Dp().gRu.a(496, (e) this);
        com.tencent.mm.kernel.g.Dr();
        com.tencent.mm.kernel.g.Dp().gRu.a(497, (e) this);
        com.tencent.mm.kernel.g.Dr();
        com.tencent.mm.kernel.g.Dp().gRu.a(498, (e) this);
        com.tencent.mm.kernel.g.Dr();
        com.tencent.mm.kernel.g.Dp().gRu.a(1555, (e) this);
    }

    protected void onPause() {
        super.onPause();
        com.tencent.mm.kernel.g.Dr();
        com.tencent.mm.kernel.g.Dp().gRu.b(496, (e) this);
        com.tencent.mm.kernel.g.Dr();
        com.tencent.mm.kernel.g.Dp().gRu.b(497, (e) this);
        com.tencent.mm.kernel.g.Dr();
        com.tencent.mm.kernel.g.Dp().gRu.b(498, (e) this);
        com.tencent.mm.kernel.g.Dr();
        com.tencent.mm.kernel.g.Dp().gRu.b(1555, (e) this);
    }

    private void bx(List<MallRechargeProduct> list) {
        if (list != null) {
            List arrayList = new ArrayList();
            int i = 0;
            for (int i2 = 0; i2 < list.size(); i2++) {
                MallRechargeProduct mallRechargeProduct = (MallRechargeProduct) list.get(i2);
                if (mallRechargeProduct.pHA == 2) {
                    if (this.pJp != null && mallRechargeProduct.frQ.equals(this.pJp.frQ)) {
                        mallRechargeProduct.isDefault = true;
                        i = true;
                    }
                    arrayList.add(mallRechargeProduct);
                }
            }
            if (i == 0 && arrayList.size() > 0) {
                ((MallRechargeProduct) arrayList.get(0)).isDefault = true;
            }
            this.pJl.by(arrayList);
            return;
        }
        this.pJl.by(new ArrayList());
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        String str = null;
        switch (i) {
            case 1:
                if (i2 == -1) {
                    Uri data = intent.getData();
                    if (data != null) {
                        if (com.tencent.mm.pluginsdk.g.a.aZ(this, "android.permission.READ_CONTACTS")) {
                            String str2;
                            Cursor query = getContentResolver().query(data, null, null, null, null);
                            if (query != null && query.getCount() > 0) {
                                query.moveToFirst();
                                int columnIndex = query.getColumnIndex("has_phone_number");
                                if (columnIndex <= 0 || query.getInt(columnIndex) > 0) {
                                    Cursor query2 = getContentResolver().query(Phone.CONTENT_URI, null, "contact_id = " + query.getString(query.getColumnIndex("_id")), null, null);
                                    if (query2.moveToFirst()) {
                                        str2 = null;
                                        while (!query2.isAfterLast()) {
                                            columnIndex = query2.getColumnIndex("data1");
                                            int columnIndex2 = query2.getColumnIndex(SlookAirButtonFrequentContactAdapter.DISPLAY_NAME);
                                            String string = query2.getString(columnIndex);
                                            str = query2.getString(columnIndex2);
                                            x.d("MicroMsg.MallRechargeUI", "username : " + str);
                                            if (string != null) {
                                                x.d("MicroMsg.MallRechargeUI", "phoneNumber : " + string);
                                                string = com.tencent.mm.plugin.recharge.model.b.II(string);
                                                x.d("MicroMsg.MallRechargeUI", "phoneNumber : " + string);
                                                if (!PhoneNumberUtils.isGlobalPhoneNumber(string)) {
                                                    string = str2;
                                                }
                                                x.d("MicroMsg.MallRechargeUI", "phoneResult : " + string);
                                            } else {
                                                string = str2;
                                            }
                                            query2.moveToNext();
                                            str2 = string;
                                        }
                                    } else {
                                        str2 = null;
                                    }
                                    if (!query2.isClosed()) {
                                        query2.close();
                                    }
                                    if (!(query == null || query.isClosed())) {
                                        query.close();
                                    }
                                    if (PhoneNumberUtils.isGlobalPhoneNumber(str2)) {
                                        this.pJu.clear();
                                        this.pJm.b(new com.tencent.mm.plugin.recharge.model.a(str2, str, 1));
                                        this.pJc.setText("");
                                        this.pJd.setVisibility(4);
                                        XT();
                                        break;
                                    }
                                    showDialog(2);
                                    break;
                                }
                            }
                            str2 = null;
                            query.close();
                            if (PhoneNumberUtils.isGlobalPhoneNumber(str2)) {
                                this.pJu.clear();
                                this.pJm.b(new com.tencent.mm.plugin.recharge.model.a(str2, str, 1));
                                this.pJc.setText("");
                                this.pJd.setVisibility(4);
                                XT();
                            } else {
                                showDialog(2);
                            }
                            break;
                        }
                        x.e("MicroMsg.MallRechargeUI", "no contact permission");
                        return;
                    }
                    x.e("MicroMsg.MallRechargeUI", "uri == null");
                    return;
                }
                break;
            case 2:
                if (i2 == -1) {
                    if (!this.plo) {
                        x.i("MicroMsg.MallRechargeUI", "MallRecharge pay result : ok");
                        com.tencent.mm.plugin.recharge.a.a.bmX().a(this.pJm.bnc());
                        finish();
                        this.plo = true;
                        break;
                    }
                }
                x.i("MicroMsg.MallRechargeUI", "MallRecharge pay result : cancel");
                break;
                break;
        }
        super.onActivityResult(i, i2, intent);
    }

    public void onDestroy() {
        com.tencent.mm.sdk.b.a.xmy.c(this.plr);
        super.onDestroy();
    }

    public final void l(String str, final Bitmap bitmap) {
        if (this.pJq != null && str.equals(this.pJq)) {
            this.pJh.post(new Runnable() {
                public final void run() {
                    RechargeUI.this.pJh.setImageBitmap(bitmap);
                }
            });
        }
    }

    public final void showVKB() {
        x.d("MicroMsg.MallRechargeUI", "showVKB");
        this.pJm.vC(com.tencent.mm.plugin.wxpay.a.e.bDp);
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager != null) {
            View currentFocus = getCurrentFocus();
            if (currentFocus != null && currentFocus.getWindowToken() != null) {
                inputMethodManager.showSoftInput(currentFocus, 2);
            }
        }
    }

    public final void aWY() {
        x.d("MicroMsg.MallRechargeUI", "hideVKB");
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager != null) {
            View currentFocus = getCurrentFocus();
            if (currentFocus != null) {
                IBinder windowToken = currentFocus.getWindowToken();
                if (windowToken != null) {
                    inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
                }
            }
        }
    }
}
