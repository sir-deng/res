package com.tencent.mm.plugin.order.ui;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.ad.k;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.plugin.order.c.c;
import com.tencent.mm.plugin.order.model.ProductSectionItem;
import com.tencent.mm.plugin.order.model.ProductSectionItem.Skus;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class MallOrderProductListUI extends WalletBaseUI {
    private String hea = "";
    private List<ProductSectionItem> jTb = new ArrayList();
    private BaseAdapter kUZ;
    private String lnQ = "";
    private ListView phN;

    private class a extends BaseAdapter {
        private a() {
        }

        /* synthetic */ a(MallOrderProductListUI mallOrderProductListUI, byte b) {
            this();
        }

        public final /* synthetic */ Object getItem(int i) {
            return uQ(i);
        }

        public final int getCount() {
            return MallOrderProductListUI.this.jTb.size();
        }

        private ProductSectionItem uQ(int i) {
            return (ProductSectionItem) MallOrderProductListUI.this.jTb.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            com.tencent.mm.platformtools.j.a aVar;
            if (view == null) {
                view = View.inflate(MallOrderProductListUI.this, g.uJG, null);
                b bVar = new b(MallOrderProductListUI.this, (byte) 0);
                bVar.lay = (ImageView) view.findViewById(f.urO);
                bVar.phP = (TextView) view.findViewById(f.urN);
                bVar.phQ = (TextView) view.findViewById(f.urK);
                bVar.phR = (TextView) view.findViewById(f.urP);
                bVar.phS = (TextView) view.findViewById(f.urL);
                bVar.phT = (TextView) view.findViewById(f.urQ);
                view.setTag(bVar);
                aVar = bVar;
            } else {
                b aVar2 = (b) view.getTag();
            }
            ProductSectionItem uQ = uQ(i);
            aVar2.kPA = uQ.iconUrl;
            if (TextUtils.isEmpty(aVar2.kPA) || !e.abj(aVar2.kPA)) {
                aVar2.lay.setImageResource(h.uNc);
            } else {
                aVar2.lay.setImageBitmap(j.a(new com.tencent.mm.plugin.order.c.b(aVar2.kPA)));
            }
            aVar2.phP.setText(uQ.name);
            aVar2.phQ.setText(Skus.bm(uQ.phs));
            aVar2.phR.setText(uQ.pht);
            aVar2.phS.setText("+" + uQ.count);
            j.a(aVar2);
            aVar2.phT.setVisibility(8);
            return view;
        }
    }

    private class b implements com.tencent.mm.platformtools.j.a {
        String kPA;
        ImageView lay;
        TextView phP;
        TextView phQ;
        TextView phR;
        TextView phS;
        TextView phT;

        private b() {
        }

        /* synthetic */ b(MallOrderProductListUI mallOrderProductListUI, byte b) {
            this();
        }

        public final void l(String str, final Bitmap bitmap) {
            if (str != null && str.equals(this.kPA)) {
                this.lay.post(new Runnable() {
                    public final void run() {
                        b.this.lay.setImageBitmap(bitmap);
                    }
                });
            }
        }
    }

    static /* synthetic */ void a(MallOrderProductListUI mallOrderProductListUI, ProductSectionItem productSectionItem) {
        if (!c.at(mallOrderProductListUI, productSectionItem.jumpUrl)) {
            c.au(mallOrderProductListUI, productSectionItem.phu);
        }
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        return false;
    }

    protected final int getLayoutId() {
        return g.uJF;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        uV(0);
        initView();
    }

    @Deprecated
    protected final void initView() {
        setMMTitle(i.uRS);
        Bundle bundle = this.vf;
        Collection parcelableArrayList = bundle.getParcelableArrayList("order_product_list");
        if (parcelableArrayList != null && parcelableArrayList.size() > 0) {
            this.jTb.clear();
            this.jTb.addAll(parcelableArrayList);
        }
        this.lnQ = bundle.getString("key_trans_id");
        this.hea = bundle.getString("appname");
        this.phN = (ListView) findViewById(f.uze);
        this.kUZ = new a();
        this.phN.setAdapter(this.kUZ);
        this.kUZ.notifyDataSetChanged();
        this.phN.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                ProductSectionItem productSectionItem = (ProductSectionItem) MallOrderProductListUI.this.jTb.get(i);
                if (productSectionItem != null) {
                    MallOrderProductListUI.a(MallOrderProductListUI.this, productSectionItem);
                    c.a(Boolean.valueOf(false), MallOrderProductListUI.this.hea, MallOrderProductListUI.this.lnQ, productSectionItem.name, productSectionItem.phu);
                }
            }
        });
    }

    public void onDestroy() {
        super.onDestroy();
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
}
