package com.tencent.mm.plugin.remittance.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.bl.d;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.m;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.contact.q;
import com.tencent.mm.ui.contact.s;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

@a(19)
public class SelectRemittanceContactUI extends MMBaseSelectContactUI {
    private int fromScene;
    private List<String> koG;
    private View oqo;
    private List<String> pUs;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    protected final void Xc() {
        super.Xc();
        this.fromScene = getIntent().getIntExtra("key_from_scene", 0);
        String stringExtra = getIntent().getStringExtra("recent_remittance_contact_list");
        x.v("MicroMsg.SelectRemittanceContactUI", "recent list:" + stringExtra);
        this.pUs = new ArrayList();
        if (!bi.oN(stringExtra)) {
            this.pUs = bi.F(stringExtra.split(","));
        }
        Collection hashSet = new HashSet();
        hashSet.addAll(s.cwZ());
        hashSet.addAll(s.cxa());
        String stringExtra2 = getIntent().getStringExtra("Select_block_List");
        if (!bi.oN(stringExtra2)) {
            hashSet.addAll(bi.F(stringExtra2.split(",")));
        }
        this.koG = new ArrayList();
        this.koG.addAll(hashSet);
    }

    protected final o Xg() {
        return new c(this, this.pUs, this.koG, this.fromScene);
    }

    protected final m Xh() {
        return new q(this, this.koG, false, this.scene);
    }

    public final int[] aYB() {
        if (this.fromScene == 1) {
            return new int[]{WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT, 131075};
        }
        return new int[]{WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT};
    }

    public final void jd(int i) {
        int p;
        if (i < this.pxs.getHeaderViewsCount()) {
            x.i("MicroMsg.SelectRemittanceContactUI", "Click HeaderView position=%d", Integer.valueOf(i));
            x.i("MicroMsg.SelectRemittanceContactUI", "doCallSelectContactUI");
            Intent intent = new Intent();
            if (this.fromScene == 1) {
                intent.putExtra("list_attr", s.p(s.zcy, 16384, 64, Downloads.RECV_BUFFER_SIZE, 262144));
                intent.putExtra("min_limit_num", 1);
                intent.putExtra("block_contact", getIntent().getStringExtra("Select_block_List"));
                intent.putExtra("titile", getString(i.vdf));
            } else {
                p = s.p(16, 1, 2, 4, 16384);
                intent.putExtra("list_type", 0);
                intent.putExtra("list_attr", p);
                intent.putExtra("titile", getString(i.uUM));
                intent.putExtra("sub_title", getString(i.vdZ));
            }
            d.a((Context) this, ".ui.contact.SelectContactUI", intent, 1);
            overridePendingTransition(com.tencent.mm.plugin.wxpay.a.a.bqo, com.tencent.mm.plugin.wxpay.a.a.bqa);
            return;
        }
        com.tencent.mm.ui.contact.a.a aVar = (com.tencent.mm.ui.contact.a.a) this.pxs.getAdapter().getItem(i);
        if (aVar != null) {
            ag agVar = aVar.jQP;
            if (agVar != null) {
                x.i("MicroMsg.SelectRemittanceContactUI", "doClickUser=%s", agVar.field_username);
                Intent intent2 = new Intent();
                intent2.putExtra("Select_Conv_User", r0);
                setResult(-1, intent2);
                finish();
                aWY();
                if (cwP() instanceof c) {
                    int i2;
                    p = i - this.pxs.getHeaderViewsCount();
                    c cVar = (c) cwP();
                    x.d("MicroMsg.RecentConversationAdapter", "pos: %s", Integer.valueOf(p));
                    if (cVar.pUq >= 0) {
                        if (cVar.pUr < 0) {
                            i2 = 1;
                        } else if (p > cVar.pUq && p < cVar.pUr) {
                            i2 = 1;
                        }
                        if (i2 != 0) {
                            g.pWK.h(13721, Integer.valueOf(6), Integer.valueOf(1));
                        }
                    }
                    i2 = 0;
                    if (i2 != 0) {
                        g.pWK.h(13721, Integer.valueOf(6), Integer.valueOf(1));
                    }
                }
            }
        }
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

    protected final boolean Xd() {
        return false;
    }

    protected final boolean Xe() {
        return false;
    }

    protected final String Xf() {
        if (this.fromScene == 1) {
            return getString(i.vde);
        }
        return getString(i.uUN);
    }

    protected final void a(ListView listView, int i) {
        super.a(listView, i);
        if (this.oqo == null) {
            View inflate = View.inflate(this, com.tencent.mm.plugin.wxpay.a.g.uKI, null);
            this.oqo = inflate.findViewById(f.content);
            TextView textView = (TextView) inflate.findViewById(f.cSc);
            if (this.fromScene == 1) {
                textView.setText(i.vdc);
            } else {
                textView.setText(i.uUw);
            }
            listView.addHeaderView(inflate);
        }
        this.oqo.setVisibility(i);
    }

    protected final void aYC() {
        super.aYC();
        aWY();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 4) {
            aYC();
        }
        return super.onKeyUp(i, keyEvent);
    }
}
