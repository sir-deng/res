package com.tencent.mm.plugin.profile.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.modelappbrand.a.f;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.plugin.appbrand.n.d;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.q.g;
import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.MMActivity;
import java.util.LinkedList;
import java.util.List;

public final class BizBindWxaInfoUI extends MMActivity {
    private TextView pmR;
    private ListView pmS;
    private String pmT;
    private String pmU;

    private static class a extends BaseAdapter {
        private LayoutInflater DF;
        private List<WxaEntryInfo> jTb = new LinkedList();

        private static class a {
            TextView ikn;
            View iln;
            ImageView jTd;

            private a() {
            }

            /* synthetic */ a(byte b) {
                this();
            }
        }

        public final /* synthetic */ Object getItem(int i) {
            return lU(i);
        }

        public a(LayoutInflater layoutInflater, List<WxaEntryInfo> list) {
            this.DF = layoutInflater;
            if (list != null) {
                this.jTb.addAll(list);
            }
        }

        public final int getCount() {
            return this.jTb.size();
        }

        private WxaEntryInfo lU(int i) {
            return (WxaEntryInfo) this.jTb.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            if (view == null) {
                view = this.DF.inflate(h.izt, viewGroup, false);
                a aVar2 = new a();
                aVar2.jTd = (ImageView) view.findViewById(g.icon);
                aVar2.ikn = (TextView) view.findViewById(g.iyA);
                aVar2.iln = view.findViewById(g.divider);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            WxaEntryInfo lU = lU(i);
            b.Jp().a(aVar.jTd, lU.iconUrl, com.tencent.mm.modelappbrand.a.a.Jo(), f.hmb);
            aVar.ikn.setText(bi.oM(lU.title));
            if (this.jTb != null) {
                int i2;
                View view2 = aVar.iln;
                if (this.jTb.size() - 1 == i) {
                    i2 = 8;
                } else {
                    i2 = 0;
                }
                view2.setVisibility(i2);
            }
            return view;
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent() == null) {
            finish();
            return;
        }
        this.pmT = getIntent().getStringExtra("extra_username");
        this.pmU = getIntent().getStringExtra("extra_appid");
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                BizBindWxaInfoUI.this.finish();
                return false;
            }
        });
        setMMTitle(j.iEs);
        List parcelableArrayListExtra = getIntent().getParcelableArrayListExtra("extra_wxa_entry_info_list");
        View inflate = getLayoutInflater().inflate(h.iAc, null);
        this.pmR = (TextView) inflate.findViewById(g.cSo);
        TextView textView = this.pmR;
        int i = j.iEr;
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(parcelableArrayListExtra != null ? parcelableArrayListExtra.size() : 0);
        textView.setText(getString(i, objArr));
        this.pmS = (ListView) findViewById(g.iyf);
        this.pmS.addHeaderView(inflate);
        this.pmS.setAdapter(new a(getLayoutInflater(), parcelableArrayListExtra));
        this.pmS.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                WxaEntryInfo wxaEntryInfo = (WxaEntryInfo) adapterView.getAdapter().getItem(i);
                if (wxaEntryInfo != null) {
                    AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                    appBrandStatObject.scene = 1020;
                    appBrandStatObject.foi = BizBindWxaInfoUI.this.pmT;
                    ((d) com.tencent.mm.kernel.g.h(d.class)).a(BizBindWxaInfoUI.this, wxaEntryInfo.username, null, 0, 0, null, appBrandStatObject, BizBindWxaInfoUI.this.pmU);
                }
            }
        });
        this.mController.contentView.setBackgroundResource(q.d.btQ);
    }

    protected final int getLayoutId() {
        return h.iAd;
    }
}
