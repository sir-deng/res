package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.bl.d;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.kernel.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.wxpay.a.a;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.o;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.q;
import com.tencent.mm.ui.contact.s;
import com.tencent.mm.ui.contact.w;
import com.tencent.mm.y.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class SelectLuckyMoneyContactUI extends MMBaseSelectContactUI {
    private List<String> koG;
    private View oqo;

    protected final void Xc() {
        super.Xc();
        Collection hashSet = new HashSet();
        hashSet.addAll(s.cwZ());
        hashSet.addAll(s.cxa());
        String stringExtra = getIntent().getStringExtra("Select_block_List");
        if (!bi.oN(stringExtra)) {
            hashSet.addAll(bi.F(stringExtra.split(",")));
        }
        this.koG = new ArrayList();
        this.koG.addAll(hashSet);
    }

    public final void jd(int i) {
        if (i < this.pxs.getHeaderViewsCount()) {
            x.i("MicroMsg.SelectRemittanceContactUI", "Click HeaderView position=%d", Integer.valueOf(i));
            x.i("MicroMsg.SelectRemittanceContactUI", "doCallSelectContactUI");
            int intExtra = getIntent().getIntExtra("key_friends_num", 0);
            Intent intent = new Intent();
            int p = s.p(16, 1, 2, 4, 16384, 64, 65536, WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
            intent.putExtra("list_type", 0);
            intent.putExtra("list_attr", p);
            intent.putExtra("max_limit_num", intExtra);
            intent.putExtra("titile", getString(i.uRm, new Object[]{Integer.valueOf(intExtra)}));
            intent.putExtra("sub_title", getString(i.veX));
            d.a((Context) this, ".ui.contact.SelectContactUI", intent, 1);
            overridePendingTransition(a.bqo, a.bqa);
            return;
        }
        com.tencent.mm.ui.contact.a.a aVar = (com.tencent.mm.ui.contact.a.a) this.pxs.getAdapter().getItem(i);
        if (aVar != null) {
            ag agVar = aVar.jQP;
            if (agVar != null) {
                String str = agVar.field_username;
                x.i("MicroMsg.SelectRemittanceContactUI", "doClickUser=%s", str);
                final Intent intent2 = new Intent();
                intent2.putExtra("Select_Conv_User", str);
                String str2 = null;
                if (com.tencent.mm.y.s.eX(str)) {
                    str2 = getString(i.vdb, new Object[]{Integer.valueOf(m.gn(str))});
                }
                ((com.tencent.mm.pluginsdk.i) g.h(com.tencent.mm.pluginsdk.i.class)).a(this.mController, str, getString(i.eES), str, str2, getString(i.dGL), new o.a() {
                    public final void a(boolean z, String str, int i) {
                        if (z) {
                            SelectLuckyMoneyContactUI.this.setResult(-1, intent2);
                            SelectLuckyMoneyContactUI.this.finish();
                        }
                    }
                });
            }
        }
    }

    protected final boolean Xd() {
        return false;
    }

    protected final boolean Xe() {
        return false;
    }

    protected final String Xf() {
        return getString(i.uRn);
    }

    protected final com.tencent.mm.ui.contact.o Xg() {
        return new w(this, this.koG);
    }

    protected final com.tencent.mm.ui.contact.m Xh() {
        return new q(this, this.koG, false, this.scene);
    }

    public final int[] aYB() {
        return new int[]{WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT};
    }

    protected final void a(ListView listView, int i) {
        super.a(listView, i);
        if (this.oqo == null) {
            View inflate = View.inflate(this, com.tencent.mm.plugin.wxpay.a.g.uKI, null);
            this.oqo = inflate.findViewById(f.content);
            ((TextView) inflate.findViewById(f.cSc)).setText(i.uQJ);
            listView.addHeaderView(inflate);
        }
        this.oqo.setVisibility(i);
    }

    protected final void aYC() {
        super.aYC();
        aWY();
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 4) {
            aYC();
        }
        return super.onKeyUp(i, keyEvent);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (intent != null) {
            x.i("MicroMsg.SelectRemittanceContactUI", "onActivityResult, requestCode = " + i + ", resultCode = " + i2 + ", data = " + intent.toString());
        } else {
            x.i("MicroMsg.SelectRemittanceContactUI", "onActivityResult, requestCode = " + i + ", resultCode = " + i2 + ", data = null");
        }
        if (i != 1) {
            x.e("MicroMsg.SelectRemittanceContactUI", "onActivityResult, unknown requestCode = " + i);
        } else if (i2 == -1) {
            x.i("MicroMsg.SelectRemittanceContactUI", "getIntent = " + getIntent());
            setResult(-1, intent);
            finish();
        }
    }
}
