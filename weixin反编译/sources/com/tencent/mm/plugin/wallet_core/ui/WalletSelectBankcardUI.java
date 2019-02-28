package com.tencent.mm.plugin.wallet_core.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MaxListView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import java.util.List;

@com.tencent.mm.ui.base.a(19)
public class WalletSelectBankcardUI extends WalletBaseUI {
    private int itU = 0;
    private TextView lqb;
    private String tcA = null;
    private List<Bankcard> tcB = null;
    private TextView tcv;
    private MaxListView tcw;
    private a tcx = null;
    private String tcy = null;
    private boolean tcz = true;

    private class a extends BaseAdapter {

        class a {
            TextView tcF;

            a() {
            }
        }

        private a() {
        }

        /* synthetic */ a(WalletSelectBankcardUI walletSelectBankcardUI, byte b) {
            this();
        }

        public final int getCount() {
            return WalletSelectBankcardUI.this.tcz ? WalletSelectBankcardUI.this.tcB == null ? 1 : WalletSelectBankcardUI.this.tcB.size() + 1 : WalletSelectBankcardUI.this.tcB == null ? 0 : WalletSelectBankcardUI.this.tcB.size();
        }

        public final Object getItem(int i) {
            if (WalletSelectBankcardUI.this.tcB == null || WalletSelectBankcardUI.this.tcB.size() <= i) {
                return null;
            }
            return WalletSelectBankcardUI.this.tcB.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            Bankcard bankcard = (Bankcard) getItem(i);
            if (view == null) {
                view = LayoutInflater.from(WalletSelectBankcardUI.this).inflate(g.uMq, viewGroup, false);
                a aVar2 = new a();
                aVar2.tcF = (TextView) view.findViewById(f.ulF);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            if (bankcard != null) {
                aVar.tcF.setText(bankcard.field_desc);
            } else {
                aVar.tcF.setText(i.vda);
            }
            return view;
        }
    }

    static /* synthetic */ void a(WalletSelectBankcardUI walletSelectBankcardUI, Bankcard bankcard) {
        walletSelectBankcardUI.vf.putParcelable("key_bankcard", bankcard);
        walletSelectBankcardUI.cCU().k(new Object[0]);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(i.uWf);
        this.itU = this.vf.getInt("key_scene", 0);
        this.tcy = this.vf.getString("key_top_tips");
        this.tcz = this.vf.getBoolean("key_is_show_new_bankcard", true);
        this.tcA = this.vf.getString("bottom_tips");
        this.tcB = this.vf.getParcelableArrayList("key_showing_bankcards");
        if (this.tcB == null) {
            this.tcB = o.bMc().bMJ();
        }
        this.tcv = (TextView) findViewById(f.uDI);
        this.tcw = (MaxListView) findViewById(f.ulQ);
        this.lqb = (TextView) findViewById(f.umq);
        if (bi.oN(this.tcy)) {
            this.tcv.setVisibility(8);
        } else {
            this.tcv.setVisibility(0);
            this.tcv.setText(this.tcy);
        }
        if (bi.oN(this.tcA)) {
            this.lqb.setVisibility(8);
        } else {
            this.lqb.setVisibility(0);
            this.lqb.setText(this.tcA);
        }
        if (this.itU == 0) {
            this.lqb.setVisibility(0);
            g gVar = new g(this);
            gVar.sZF = new com.tencent.mm.plugin.wallet_core.ui.g.a() {
                public final void onClick(View view) {
                    x.i("MicroMsg.WalletSelectBankcardUI", "hy: user clicked the phone.go to dial");
                    e.by(WalletSelectBankcardUI.this, WalletSelectBankcardUI.this.getString(i.uWi));
                }
            };
            String string = getString(i.vcU);
            CharSequence spannableString = new SpannableString(string);
            spannableString.setSpan(gVar, string.length() - 14, string.length(), 33);
            this.lqb.setText(spannableString);
            this.lqb.setMovementMethod(LinkMovementMethod.getInstance());
        }
        this.tcx = new a();
        this.tcw.setAdapter(this.tcx);
        this.tcw.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                final Bankcard bankcard = (Bankcard) adapterView.getItemAtPosition(i);
                if (bankcard != null) {
                    h.a(WalletSelectBankcardUI.this, true, WalletSelectBankcardUI.this.getString(i.vcW, new Object[]{bankcard.field_desc, bankcard.field_mobile}), WalletSelectBankcardUI.this.getString(i.vcY), WalletSelectBankcardUI.this.getString(i.vcV), WalletSelectBankcardUI.this.getString(i.vcX), new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            WalletSelectBankcardUI.this.vf.putBoolean("key_balance_change_phone_need_confirm_phone", false);
                            WalletSelectBankcardUI.a(WalletSelectBankcardUI.this, bankcard);
                            com.tencent.mm.plugin.report.service.g.pWK.h(11977, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0));
                        }
                    }, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            WalletSelectBankcardUI.this.vf.putBoolean("key_balance_change_phone_need_confirm_phone", true);
                            WalletSelectBankcardUI.a(WalletSelectBankcardUI.this, bankcard);
                        }
                    });
                    return;
                }
                WalletSelectBankcardUI.this.vf.putBoolean("key_balance_change_phone_need_confirm_phone", false);
                WalletSelectBankcardUI.a(WalletSelectBankcardUI.this, null);
            }
        });
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        return false;
    }

    protected final int getLayoutId() {
        return g.uMr;
    }

    protected final boolean bKK() {
        return true;
    }
}
