package com.tencent.mm.plugin.wallet.balance.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
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
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;
import java.util.Iterator;

public class WalletSelectBankcardModeUI extends WalletBaseUI {
    private int kKY = 0;
    private ArrayList<a> mData = new ArrayList();
    private ListView phN;
    private int sFD = -1;
    private ArrayList<Bankcard> sFo;
    private Bankcard sFp;
    private String sFq;
    private int sFz = 0;
    private TextView sGp;
    private b sGq;

    @SuppressLint({"ViewHolder"})
    class b extends BaseAdapter {
        public final /* synthetic */ Object getItem(int i) {
            return (a) WalletSelectBankcardModeUI.this.mData.get(i);
        }

        b() {
        }

        public final int getCount() {
            return WalletSelectBankcardModeUI.this.mData.size();
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            View inflate = View.inflate(WalletSelectBankcardModeUI.this, g.uMp, null);
            a aVar = (a) WalletSelectBankcardModeUI.this.mData.get(i);
            TextView textView = (TextView) inflate.findViewById(f.ulU);
            ImageView imageView = (ImageView) inflate.findViewById(f.uCR);
            ((TextView) inflate.findViewById(f.ulV)).setText(aVar.title);
            if (TextUtils.isEmpty(aVar.kTd)) {
                textView.setVisibility(8);
            } else {
                textView.setVisibility(0);
                textView.setText(aVar.kTd);
            }
            if (WalletSelectBankcardModeUI.this.sFD == i) {
                imageView.setImageResource(h.dAC);
            } else {
                imageView.setImageResource(h.dAB);
            }
            return inflate;
        }
    }

    private static class a {
        public String kTd;
        public String title;

        private a() {
            this.title = "";
            this.kTd = "";
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        return false;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setResult(0);
        this.kKY = getIntent().getIntExtra("key_scene_select_bankcard_mode_ui", 0);
        this.sFD = getIntent().getIntExtra("key_select_index", -1);
        x.i("MicroMsg.WalletSelectBankcardModeUI", "onCreate() mFromScene is " + this.kKY);
        initView();
    }

    protected final void initView() {
        setMMTitle(i.uWf);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                WalletSelectBankcardModeUI.this.setResult(0);
                WalletSelectBankcardModeUI.this.finish();
                return true;
            }
        });
        this.sGp = (TextView) findViewById(f.uGG);
        if (this.kKY == 0) {
            this.sGp.setText(i.vdi);
        } else if (this.kKY == 1) {
            this.sGp.setText(i.vdj);
        }
        this.phN = (ListView) findViewById(f.uEA);
        this.sGq = new b();
        this.phN.setAdapter(this.sGq);
        this.phN.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                WalletSelectBankcardModeUI.this.sFD = i;
                WalletSelectBankcardModeUI.this.sGq.notifyDataSetChanged();
                Intent intent = new Intent();
                intent.putExtra("key_select_index", i);
                WalletSelectBankcardModeUI.this.setResult(-1, intent);
                x.i("MicroMsg.WalletSelectBankcardModeUI", "onItemClick pos is " + i);
                WalletSelectBankcardModeUI.this.finish();
            }
        });
        this.mData.clear();
        this.sFq = getString(i.uWa);
        if (this.kKY == 0) {
            p.bKx();
            ag bKy = p.bKy();
            this.sFo = bKy.bML();
            this.sFp = bKy.a(this.sFo, null, false, true);
            if (bKy.sWm != null) {
                this.sFz = bKy.sWm.sFz;
                x.e("MicroMsg.WalletSelectBankcardModeUI", "is_show_charge is " + this.sFz);
            } else {
                this.sFz = 0;
                x.e("MicroMsg.WalletSelectBankcardModeUI", "userInfo.getBalanceFetchInfo() is null");
            }
            if (this.sFo == null || this.sFo.size() <= 0) {
                x.i("MicroMsg.WalletSelectBankcardModeUI", "hy: no bankcard show new only");
            } else {
                x.i("MicroMsg.WalletSelectBankcardModeUI", "mBankcardList size is " + this.sFo.size());
                Iterator it = this.sFo.iterator();
                int i = 0;
                while (it.hasNext()) {
                    Bankcard bankcard = (Bankcard) it.next();
                    a aVar = new a();
                    aVar.title = bankcard.field_desc;
                    if (bankcard.field_fetch_charge_rate <= 0.0d || this.sFz != 1) {
                        x.i("MicroMsg.WalletSelectBankcardModeUI", "the bank " + bankcard.field_desc + " field_fetch_charge_rate is " + bankcard.field_fetch_charge_rate + " is_show_charge is " + this.sFz);
                    } else if (TextUtils.isEmpty(bankcard.field_fetch_charge_info)) {
                        aVar.kTd = getString(i.uVy) + (bankcard.field_fetch_charge_rate * 100.0d) + "%";
                    } else {
                        aVar.kTd = bankcard.field_fetch_charge_info;
                    }
                    this.mData.add(aVar);
                    if (this.sFD == -1 && this.sFp != null && this.sFp.equals(bankcard)) {
                        this.sFD = i;
                    }
                    i++;
                }
                if (this.sFD == -1 && this.sFp == null) {
                    this.sFD = i;
                }
            }
            a aVar2 = new a();
            aVar2.title = this.sFq;
            aVar2.kTd = "";
            this.mData.add(aVar2);
        }
        this.sGq.notifyDataSetChanged();
    }

    protected final int getLayoutId() {
        return g.uMo;
    }

    public final boolean aYP() {
        return false;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 4) {
            setResult(0);
            finish();
        }
        return super.onKeyUp(i, keyEvent);
    }

    protected final int getForceOrientation() {
        return 1;
    }
}
