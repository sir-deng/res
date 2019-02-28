package com.tencent.mm.plugin.order.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.order.c.c;
import com.tencent.mm.plugin.order.model.MallOrderDetailObject;
import com.tencent.mm.plugin.order.model.MallTransactionObject;
import com.tencent.mm.plugin.order.model.ProductSectionItem;
import com.tencent.mm.plugin.order.model.ProductSectionItem.Skus;
import com.tencent.mm.plugin.order.model.j;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.smtt.sdk.WebView;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class MallOrderDetailInfoUI extends WalletBaseUI implements com.tencent.mm.platformtools.j.a {
    private ListView Fv;
    private OnClickListener iqi = new OnClickListener() {
        public final void onClick(View view) {
            if (view.getId() == f.uyL) {
                if (MallOrderDetailInfoUI.this.pgM.pfC != null) {
                    c.at(MallOrderDetailInfoUI.this, MallOrderDetailInfoUI.this.pgM.pfC.nkN);
                    c.a(Boolean.valueOf(MallOrderDetailInfoUI.this.phG), MallOrderDetailInfoUI.this.pgM.fwG, MallOrderDetailInfoUI.this.lnQ, MallOrderDetailInfoUI.this.pgM.pfC.pfK, "");
                }
            } else if (view.getId() == f.uyZ || view.getId() == f.uyY) {
                if (MallOrderDetailInfoUI.this.pgM.pfD != null && MallOrderDetailInfoUI.this.pgM.pfD.size() > 0) {
                    boolean z;
                    if (TextUtils.isEmpty(((ProductSectionItem) MallOrderDetailInfoUI.this.pgM.pfD.get(0)).jumpUrl)) {
                        z = false;
                    } else {
                        z = c.at(MallOrderDetailInfoUI.this, ((ProductSectionItem) MallOrderDetailInfoUI.this.pgM.pfD.get(0)).jumpUrl);
                    }
                    if (!z) {
                        c.au(MallOrderDetailInfoUI.this, ((ProductSectionItem) MallOrderDetailInfoUI.this.pgM.pfD.get(0)).phu);
                    }
                    c.a(Boolean.valueOf(MallOrderDetailInfoUI.this.phG), MallOrderDetailInfoUI.this.pgM.fwG, MallOrderDetailInfoUI.this.lnQ, ((ProductSectionItem) MallOrderDetailInfoUI.this.pgM.pfD.get(0)).name, "");
                }
            } else if (view.getId() == f.uyX) {
                Bundle bundle = MallOrderDetailInfoUI.this.vf;
                bundle.putParcelableArrayList("order_product_list", MallOrderDetailInfoUI.this.pgM.pfD);
                bundle.putInt("key_enter_id", 0);
                bundle.putString("key_trans_id", MallOrderDetailInfoUI.this.lnQ);
                bundle.putString("appname", MallOrderDetailInfoUI.this.pgM.fwG);
                com.tencent.mm.wallet_core.a.j(MallOrderDetailInfoUI.this, new Bundle());
                c.a(Boolean.valueOf(MallOrderDetailInfoUI.this.phG), MallOrderDetailInfoUI.this.pgM.fwG, MallOrderDetailInfoUI.this.lnQ, MallOrderDetailInfoUI.this.getResources().getString(i.uRS), "");
            } else if (view.getId() == f.uzg) {
                String string = MallOrderDetailInfoUI.this.vf.getString("key_trans_id");
                Bundle bundle2 = MallOrderDetailInfoUI.this.vf;
                bundle2.putString("key_trans_id", string);
                bundle2.putInt("key_enter_id", 1);
                if (MallOrderDetailInfoUI.this.pgM != null) {
                    bundle2.putParcelable("transaction_data", MallOrderDetailInfoUI.this.pgM.pfB);
                }
                com.tencent.mm.wallet_core.a.j(MallOrderDetailInfoUI.this, bundle2);
                c.a(Boolean.valueOf(MallOrderDetailInfoUI.this.phG), MallOrderDetailInfoUI.this.pgM.fwG, MallOrderDetailInfoUI.this.lnQ, MallOrderDetailInfoUI.this.getResources().getString(i.uRR), "");
            } else if (view.getId() == f.uyH) {
                h.a((Context) MallOrderDetailInfoUI.this, "商家已退全款，总价125元，包含商品价格115元，邮费10元，请确认是否同意通过该处理结果。", MallOrderDetailInfoUI.this.getString(i.uRK), MallOrderDetailInfoUI.this.getString(i.uRT), MallOrderDetailInfoUI.this.getString(i.uRU), new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                }, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
            } else if (view.getId() == f.urr) {
                if (MallOrderDetailInfoUI.this.pgM != null && MallOrderDetailInfoUI.this.pgM.pfI != null) {
                    MallOrderDetailInfoUI.this.phx = MallOrderDetailInfoUI.this.pgM.pfI;
                    MallOrderDetailInfoUI.c(MallOrderDetailInfoUI.this);
                    c.a(Boolean.valueOf(MallOrderDetailInfoUI.this.phG), MallOrderDetailInfoUI.this.pgM.fwG, MallOrderDetailInfoUI.this.lnQ, MallOrderDetailInfoUI.this.getResources().getString(i.uRQ), "");
                }
            } else if (view.getId() == f.uHn) {
                e.T(MallOrderDetailInfoUI.this, MallOrderDetailInfoUI.this.pgM.fwG);
                c.a(Boolean.valueOf(MallOrderDetailInfoUI.this.phG), MallOrderDetailInfoUI.this.pgM.fwG, MallOrderDetailInfoUI.this.lnQ, MallOrderDetailInfoUI.this.getResources().getString(i.uRW), "");
            }
        }
    };
    private String lnQ = "";
    private HashMap<String, View> pds = new HashMap();
    private List<com.tencent.mm.plugin.order.model.MallOrderDetailObject.a> pfE = new ArrayList();
    protected MallOrderDetailObject pgM = null;
    private View phA;
    private View phB;
    private View phC;
    private View phD;
    private View phE;
    private View phF;
    private boolean phG = false;
    private boolean phH = false;
    private int phI = 0;
    private CheckedTextView phJ;
    private CheckedTextView phK;
    OnClickListener phL = new OnClickListener() {
        public final void onClick(View view) {
            if (MallOrderDetailInfoUI.this.phJ != null && MallOrderDetailInfoUI.this.phK != null) {
                if (view.getId() == f.uyD) {
                    MallOrderDetailInfoUI.this.phJ.setSelected(true);
                    MallOrderDetailInfoUI.this.phK.setSelected(false);
                    MallOrderDetailInfoUI.this.phI = 100;
                    return;
                }
                MallOrderDetailInfoUI.this.phJ.setSelected(false);
                MallOrderDetailInfoUI.this.phK.setSelected(true);
                MallOrderDetailInfoUI.this.phI = -100;
            }
        }
    };
    String phx;
    private a phy;
    private View phz;

    private class a extends BaseAdapter {
        private a() {
        }

        /* synthetic */ a(MallOrderDetailInfoUI mallOrderDetailInfoUI, byte b) {
            this();
        }

        public final /* synthetic */ Object getItem(int i) {
            return uP(i);
        }

        public final int getCount() {
            return MallOrderDetailInfoUI.this.pfE.size();
        }

        private com.tencent.mm.plugin.order.model.MallOrderDetailObject.a uP(int i) {
            return (com.tencent.mm.plugin.order.model.MallOrderDetailObject.a) MallOrderDetailInfoUI.this.pfE.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            com.tencent.mm.plugin.order.model.MallOrderDetailObject.a uP = uP(i);
            View findViewById;
            switch (uP.type) {
                case 1:
                    view = View.inflate(MallOrderDetailInfoUI.this, g.uJt, null);
                    findViewById = view.findViewById(f.uyB);
                    MallOrderDetailInfoUI.this.phJ = (CheckedTextView) view.findViewById(f.uyD);
                    MallOrderDetailInfoUI.this.phK = (CheckedTextView) view.findViewById(f.uyA);
                    MallOrderDetailInfoUI.this.phJ.setOnClickListener(MallOrderDetailInfoUI.this.phL);
                    MallOrderDetailInfoUI.this.phK.setOnClickListener(MallOrderDetailInfoUI.this.phL);
                    if (i + 1 < getCount()) {
                        MallOrderDetailInfoUI.a(findViewById, uP(i + 1));
                        break;
                    }
                    break;
                case 2:
                    view = View.inflate(MallOrderDetailInfoUI.this, g.uJs, null);
                    TextView textView = (TextView) view.findViewById(f.uyA);
                    findViewById = view.findViewById(f.uyB);
                    if (bi.getInt(uP.value, 0) >= 0) {
                        textView.setText(i.uRM);
                        textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, com.tencent.mm.plugin.wxpay.a.h.uNd, 0);
                    } else {
                        textView.setText(i.uRL);
                        textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, com.tencent.mm.plugin.wxpay.a.h.uNb, 0);
                    }
                    if (i + 1 < getCount()) {
                        MallOrderDetailInfoUI.a(findViewById, uP(i + 1));
                        break;
                    }
                    break;
                default:
                    b bVar;
                    if (view == null) {
                        view = View.inflate(MallOrderDetailInfoUI.this, g.uJr, null);
                        b bVar2 = new b(MallOrderDetailInfoUI.this, (byte) 0);
                        bVar2.laB = (TextView) view.findViewById(f.uyF);
                        bVar2.lbE = (TextView) view.findViewById(f.uyE);
                        bVar2.lbF = (TextView) view.findViewById(f.uyC);
                        bVar2.kvL = view.findViewById(f.uyB);
                        view.setTag(bVar2);
                        bVar = bVar2;
                    } else {
                        bVar = (b) view.getTag();
                    }
                    bVar.laB.setText(uP.name);
                    if (TextUtils.isEmpty(uP.value)) {
                        bVar.lbE.setVisibility(4);
                    } else {
                        bVar.lbE.setVisibility(0);
                        bVar.lbE.setText(uP.value);
                    }
                    if (uP.kPM) {
                        bVar.lbF.setVisibility(0);
                    } else {
                        bVar.lbF.setVisibility(8);
                    }
                    if (i + 1 < getCount()) {
                        MallOrderDetailInfoUI.a(bVar.kvL, uP(i + 1));
                        break;
                    }
                    break;
            }
            return view;
        }

        public final int getItemViewType(int i) {
            return uP(i).type;
        }

        public final int getViewTypeCount() {
            return 3;
        }
    }

    private class b {
        View kvL;
        TextView laB;
        TextView lbE;
        TextView lbF;

        private b() {
        }

        /* synthetic */ b(MallOrderDetailInfoUI mallOrderDetailInfoUI, byte b) {
            this();
        }
    }

    static /* synthetic */ void c(MallOrderDetailInfoUI mallOrderDetailInfoUI) {
        if (!TextUtils.isEmpty(mallOrderDetailInfoUI.phx)) {
            Intent intent = new Intent("android.intent.action.DIAL", Uri.parse(new StringBuilder(WebView.SCHEME_TEL).append(mallOrderDetailInfoUI.phx).toString()));
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            mallOrderDetailInfoUI.startActivity(intent);
        }
    }

    static /* synthetic */ void d(MallOrderDetailInfoUI mallOrderDetailInfoUI) {
        Context context = mallOrderDetailInfoUI;
        h.a(context, "", new String[]{mallOrderDetailInfoUI.getString(i.uRV)}, "", false, new h.c() {
            public final void jo(int i) {
                switch (i) {
                    case 0:
                        c.as(MallOrderDetailInfoUI.this, MallOrderDetailInfoUI.this.pgM.pfH);
                        return;
                    default:
                        return;
                }
            }
        });
    }

    protected final int getLayoutId() {
        return g.uJz;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.tencent.mm.wallet_core.c ag = com.tencent.mm.wallet_core.a.ag(this);
        if (ag != null && (ag instanceof com.tencent.mm.plugin.order.a.a)) {
            String string = this.vf.getString("key_trans_id");
            this.lnQ = string;
            if (string != null) {
                com.tencent.mm.plugin.order.a.b.biZ();
                if (!com.tencent.mm.plugin.order.a.b.bjc().HP(string)) {
                    this.phG = false;
                    l(new com.tencent.mm.plugin.order.model.h(string));
                }
            }
            com.tencent.mm.plugin.order.a.b.biZ();
            if (com.tencent.mm.plugin.order.a.b.bjc().HP(string)) {
                MallOrderDetailObject mallOrderDetailObject;
                this.phG = true;
                com.tencent.mm.plugin.order.a.b.biZ();
                com.tencent.mm.plugin.order.model.c bjc = com.tencent.mm.plugin.order.a.b.bjc();
                if (TextUtils.isEmpty(string)) {
                    mallOrderDetailObject = null;
                } else {
                    x.v("MicroMsg.MallPayMsgManager", "getMallOrderDetailObjectByMsgId msgId:" + string);
                    mallOrderDetailObject = com.tencent.mm.plugin.order.model.c.a(bjc.HQ(string));
                }
                this.pgM = mallOrderDetailObject;
                if (this.pgM == null) {
                    bjm();
                }
            } else {
                x.w("MicroMsg.MallOrderDetailInfoUI", "mOrders info is Illegal!");
                bjm();
            }
        }
        initView();
    }

    protected final void initView() {
        if (this.phG) {
            com.tencent.mm.plugin.order.a.b.biZ();
            j HQ = com.tencent.mm.plugin.order.a.b.bjc().HQ(this.lnQ);
            int intValue = (HQ == null || TextUtils.isEmpty(HQ.phi) || !c.xv(HQ.phi)) ? -1 : Integer.valueOf(HQ.phi).intValue();
            if (intValue == 2) {
                setMMTitle(i.uRN);
            } else if (intValue == 1) {
                setMMTitle(i.uRO);
            }
        } else {
            setMMTitle(i.uRP);
        }
        this.phz = findViewById(f.uyL);
        this.phA = findViewById(f.uyK);
        this.phE = findViewById(f.uyZ);
        this.phF = findViewById(f.uyX);
        this.phD = findViewById(f.uyY);
        this.phB = findViewById(f.uzg);
        this.phC = findViewById(f.uzf);
        this.phz.setOnClickListener(this.iqi);
        this.phF.setOnClickListener(this.iqi);
        this.phE.setOnClickListener(this.iqi);
        this.phD.setOnClickListener(this.iqi);
        this.phB.setOnClickListener(this.iqi);
        findViewById(f.uyH).setOnClickListener(this.iqi);
        findViewById(f.urr).setOnClickListener(this.iqi);
        findViewById(f.uHn).setOnClickListener(this.iqi);
        this.Fv = (ListView) findViewById(f.uyG);
        this.phy = new a();
        this.Fv.setAdapter(this.phy);
        this.phy.notifyDataSetChanged();
        this.Fv.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.tencent.mm.plugin.order.model.MallOrderDetailObject.a aVar = (com.tencent.mm.plugin.order.model.MallOrderDetailObject.a) MallOrderDetailInfoUI.this.pfE.get(i);
                if (!TextUtils.isEmpty(aVar.jumpUrl)) {
                    c.at(MallOrderDetailInfoUI.this, aVar.jumpUrl);
                }
                c.a(Boolean.valueOf(MallOrderDetailInfoUI.this.phG), MallOrderDetailInfoUI.this.pgM.fwG, MallOrderDetailInfoUI.this.lnQ, aVar.name, "");
            }
        });
        bjk();
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        if (com.tencent.mm.wallet_core.a.ag(this) instanceof com.tencent.mm.plugin.order.a.a) {
            com.tencent.mm.wallet_core.a.ad(this);
        }
        return true;
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (i != 0 || i2 != 0) {
            return false;
        }
        if (kVar instanceof com.tencent.mm.plugin.order.model.h) {
            MallOrderDetailObject mallOrderDetailObject = ((com.tencent.mm.plugin.order.model.h) kVar).pgM;
            x.d("MicroMsg.MallOrderDetailInfoUI", "tempObject:" + mallOrderDetailObject);
            if (mallOrderDetailObject != null) {
                this.pgM = mallOrderDetailObject;
                bjk();
            }
        }
        return true;
    }

    private void bjk() {
        if (this.pgM != null) {
            com.tencent.mm.platformtools.j.a((com.tencent.mm.platformtools.j.a) this);
            this.pds.clear();
            com.tencent.mm.plugin.order.model.MallOrderDetailObject.b bVar = this.pgM.pfC;
            if (bVar != null) {
                CharSequence charSequence;
                String str = bVar.pfK;
                if (TextUtils.isEmpty(bVar.pfL)) {
                    Object charSequence2 = str;
                } else {
                    charSequence2 = str + "：" + bVar.pfL;
                }
                if (this.phG) {
                    this.phz.setVisibility(8);
                    this.phA.setVisibility(0);
                    ((TextView) this.phA.findViewById(f.uyN)).setText(charSequence2);
                    ((TextView) this.phA.findViewById(f.uyM)).setText(e.gT(this.pgM.pfJ));
                    if (TextUtils.isEmpty(bVar.thumbUrl) || !e.abj(bVar.thumbUrl)) {
                        c((ImageView) this.phA.findViewById(f.uyW));
                    } else {
                        m((ImageView) this.phA.findViewById(f.uyW), bVar.thumbUrl);
                    }
                } else {
                    this.phA.setVisibility(8);
                    this.phz.setVisibility(0);
                    ((TextView) this.phz.findViewById(f.uyN)).setText(charSequence2);
                    ((TextView) this.phz.findViewById(f.uyM)).setText(e.gT(this.pgM.pfJ));
                    if (TextUtils.isEmpty(bVar.thumbUrl) || !e.abj(bVar.thumbUrl)) {
                        c((ImageView) this.phz.findViewById(f.uyW));
                    } else {
                        m((ImageView) this.phz.findViewById(f.uyW), bVar.thumbUrl);
                    }
                }
            } else {
                this.phz.setVisibility(8);
                this.phA.setVisibility(8);
            }
            List list = this.pgM.pfD;
            if (list == null || list.size() == 0) {
                this.phD.setVisibility(8);
                this.phE.setVisibility(8);
                this.phF.setVisibility(8);
            } else if (list.size() == 1) {
                this.phF.setVisibility(8);
                ProductSectionItem productSectionItem = (ProductSectionItem) list.get(0);
                if (TextUtils.isEmpty(productSectionItem.iconUrl)) {
                    this.phE.setVisibility(8);
                    this.phD.setVisibility(0);
                    ((TextView) this.phD.findViewById(f.urN)).setText(productSectionItem.name);
                    if (TextUtils.isEmpty(productSectionItem.jumpUrl)) {
                        Rect rect = new Rect();
                        rect.set(this.phD.findViewById(f.urM).getPaddingLeft(), this.phD.findViewById(f.urM).getPaddingTop(), this.phD.findViewById(f.urM).getPaddingRight(), this.phD.findViewById(f.urM).getPaddingBottom());
                        this.phD.findViewById(f.urM).setBackgroundResource(com.tencent.mm.plugin.wxpay.a.e.bDq);
                        this.phD.findViewById(f.urM).setPadding(rect.left, rect.top, rect.right, rect.bottom);
                    } else {
                        ((TextView) this.phD.findViewById(f.urN)).setTextColor(getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.uhC));
                    }
                } else {
                    this.phD.setVisibility(8);
                    this.phE.setVisibility(0);
                    ((TextView) this.phE.findViewById(f.urN)).setText(productSectionItem.name);
                    ((TextView) this.phE.findViewById(f.urP)).setText(productSectionItem.pht);
                    ((TextView) this.phE.findViewById(f.urL)).setText("+" + productSectionItem.count);
                    ((TextView) this.phE.findViewById(f.urK)).setText(Skus.bm(productSectionItem.phs));
                    if (!TextUtils.isEmpty(productSectionItem.iconUrl)) {
                        m((ImageView) this.phE.findViewById(f.urO), productSectionItem.iconUrl);
                    }
                }
            } else {
                this.phD.setVisibility(8);
                this.phE.setVisibility(8);
                this.phF.setVisibility(0);
                if (list.size() == 2) {
                    a(this.phF.findViewById(f.uza), (ProductSectionItem) list.get(0));
                    a(this.phF.findViewById(f.uzb), (ProductSectionItem) list.get(1));
                    this.phF.findViewById(f.uzc).setVisibility(8);
                    this.phF.findViewById(f.uzd).setVisibility(8);
                } else if (list.size() == 3) {
                    a(this.phF.findViewById(f.uza), (ProductSectionItem) list.get(0));
                    a(this.phF.findViewById(f.uzb), (ProductSectionItem) list.get(1));
                    a(this.phF.findViewById(f.uzc), (ProductSectionItem) list.get(2));
                    this.phF.findViewById(f.uzd).setVisibility(8);
                } else if (list.size() >= 4) {
                    a(this.phF.findViewById(f.uza), (ProductSectionItem) list.get(0));
                    a(this.phF.findViewById(f.uzb), (ProductSectionItem) list.get(1));
                    a(this.phF.findViewById(f.uzc), (ProductSectionItem) list.get(2));
                    a(this.phF.findViewById(f.uzd), (ProductSectionItem) list.get(3));
                }
            }
            MallTransactionObject mallTransactionObject = this.pgM.pfB;
            if (mallTransactionObject != null) {
                this.phB.setVisibility(0);
                ((TextView) findViewById(f.uzh)).setText(e.d(mallTransactionObject.loS, mallTransactionObject.pgf));
                if (!(this.pgM == null || this.pgM.pfE == null || this.pgM.pfE.size() <= 0)) {
                    a(this.phC, (com.tencent.mm.plugin.order.model.MallOrderDetailObject.a) this.pgM.pfE.get(0));
                }
            } else {
                this.phB.setVisibility(8);
            }
            Collection collection = this.pgM.pfE;
            if (collection != null) {
                this.pfE.addAll(collection);
                this.phy.notifyDataSetChanged();
            }
            findViewById(f.uwM).setVisibility(0);
            TextView textView;
            if (this.pgM != null && TextUtils.isEmpty(this.pgM.pfI) && TextUtils.isEmpty(this.pgM.fwG)) {
                findViewById(f.uwM).setVisibility(8);
            } else if (this.pgM != null && !TextUtils.isEmpty(this.pgM.pfI) && TextUtils.isEmpty(this.pgM.fwG)) {
                findViewById(f.uHn).setVisibility(8);
                findViewById(f.uHm).setVisibility(8);
                textView = (TextView) findViewById(f.urr);
                textView.setVisibility(0);
                textView.setGravity(3);
            } else if (!(this.pgM == null || !TextUtils.isEmpty(this.pgM.pfI) || TextUtils.isEmpty(this.pgM.fwG))) {
                findViewById(f.urr).setVisibility(8);
                findViewById(f.uHm).setVisibility(8);
                textView = (TextView) findViewById(f.uHn);
                textView.setVisibility(0);
                textView.setGravity(3);
            }
            if (this.pgM != null && !TextUtils.isEmpty(this.pgM.pfH)) {
                addIconOptionMenu(0, com.tencent.mm.plugin.wxpay.a.e.bDJ, new OnMenuItemClickListener() {
                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        MallOrderDetailInfoUI.d(MallOrderDetailInfoUI.this);
                        return true;
                    }
                });
            }
        }
    }

    private void a(View view, ProductSectionItem productSectionItem) {
        if (view != null && productSectionItem != null) {
            view.setVisibility(0);
            TextView textView = (TextView) view.findViewById(f.urN);
            if (textView != null) {
                textView.setText(productSectionItem.name);
            }
            if (!TextUtils.isEmpty(productSectionItem.iconUrl)) {
                m((ImageView) view.findViewById(f.urO), productSectionItem.iconUrl);
            }
        }
    }

    private void m(ImageView imageView, String str) {
        if (imageView != null && !TextUtils.isEmpty(str) && e.abj(str)) {
            imageView.setImageBitmap(com.tencent.mm.platformtools.j.a(new com.tencent.mm.plugin.order.c.b(str)));
            this.pds.put(str, imageView);
        }
    }

    private static void a(View view, com.tencent.mm.plugin.order.model.MallOrderDetailObject.a aVar) {
        if (aVar != null) {
            Rect rect = new Rect();
            rect.left = view.getPaddingLeft();
            rect.right = view.getPaddingRight();
            rect.top = view.getPaddingTop();
            rect.bottom = view.getPaddingBottom();
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (aVar == null || !aVar.kPM) {
                view.setBackgroundResource(com.tencent.mm.plugin.wxpay.a.e.bDq);
            } else {
                view.setBackgroundResource(com.tencent.mm.plugin.wxpay.a.e.bDK);
            }
            view.setLayoutParams(layoutParams);
            view.setPadding(rect.left, rect.top, rect.right, rect.bottom);
        }
    }

    public final void l(String str, Bitmap bitmap) {
        ImageView imageView = (ImageView) this.pds.get(str);
        if (imageView != null) {
            imageView.setImageBitmap(bitmap);
        }
    }

    private void c(ImageView imageView) {
        Bitmap decodeResource = com.tencent.mm.compatible.g.a.decodeResource(getResources(), com.tencent.mm.plugin.wxpay.a.h.uNe);
        if (decodeResource != null) {
            imageView.setImageBitmap(d.a(decodeResource, false, 96.0f));
        }
    }

    private void bjl() {
        if (!this.phH && this.phI != 0) {
            com.tencent.mm.kernel.g.Dr();
            com.tencent.mm.kernel.g.Dp().gRu.a(new com.tencent.mm.plugin.order.model.f(this.lnQ, "", this.phI), 0);
            this.phH = true;
        }
    }

    public void finish() {
        bjl();
        super.finish();
    }

    public void onDestroy() {
        bjl();
        super.onDestroy();
    }

    public final void uO(int i) {
        finish();
    }

    private void bjm() {
        h.a(this.mController.xRr, i.uZS, 0, new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                MallOrderDetailInfoUI.this.finish();
            }
        });
    }
}
