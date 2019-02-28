package com.tencent.mm.plugin.emoji.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ad.k;
import com.tencent.mm.bl.d;
import com.tencent.mm.plugin.emoji.a.a.a;
import com.tencent.mm.plugin.emoji.f.g;
import com.tencent.mm.plugin.emoji.model.f;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.y.as;
import com.tencent.mm.y.q;
import java.util.ArrayList;

public class EmojiPaidUI extends BaseEmojiStoreUI {
    private g[] lIh;

    protected final int aCZ() {
        return 2;
    }

    protected final int aCX() {
        return 2;
    }

    protected final void initView() {
        setMMTitle(R.l.eak);
        if (q.Gk()) {
            addIconOptionMenu(0, R.g.bDJ, new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    h.a(EmojiPaidUI.this.mController.xRr, null, null, EmojiPaidUI.this.getResources().getString(R.l.ean), false, new c() {
                        public final void jo(int i) {
                            switch (i) {
                                case 0:
                                    Intent intent = new Intent();
                                    intent.putExtra("key_action_type", 200002);
                                    d.b(EmojiPaidUI.this, "wallet_index", ".ui.WalletIapUI", intent, 2001);
                                    x.i("MicroMsg.emoji.EmojiPaidUI", "[showMenuDialog] startActivityForResult ui.WalletIapUI");
                                    EmojiPaidUI.this.aDd();
                                    return;
                                default:
                                    return;
                            }
                        }
                    });
                    return true;
                }
            });
        }
        super.initView();
        this.klX.setVisibility(8);
        this.Fv.setVisibility(8);
    }

    protected final void aCS() {
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.lIh != null && this.lIh.length > 0) {
            for (k c : this.lIh) {
                as.CN().c(c);
            }
        }
    }

    protected final void a(g gVar) {
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        CharSequence stringExtra;
        x.i("MicroMsg.emoji.EmojiPaidUI", "onActivityResult . requestCode:" + i + "  resultCode:" + i2);
        aDe();
        String str = "";
        int intExtra;
        if (intent != null) {
            intExtra = intent.getIntExtra("key_err_code", 0);
            x.w("MicroMsg.emoji.EmojiPaidUI", "errCode:" + intExtra);
            stringExtra = intent.getStringExtra("key_err_msg");
            x.w("MicroMsg.emoji.EmojiPaidUI", "errMsg:" + stringExtra);
        } else {
            Object stringExtra2 = str;
            intExtra = 0;
        }
        if (i2 != -1) {
            Toast.makeText(this, R.l.eao, 0).show();
        } else if (intent == null || intExtra != 0) {
            Toast.makeText(this, stringExtra2, 0).show();
        } else {
            ArrayList stringArrayListExtra = intent.getStringArrayListExtra("key_response_product_ids");
            if (stringArrayListExtra == null || stringArrayListExtra.size() <= 0) {
                Toast.makeText(this, stringExtra2, 0).show();
                return;
            }
            this.lGk = null;
            this.lGh = -1;
            s(false, false);
            as.Hm();
            com.tencent.mm.y.c.Db().set(208900, Boolean.valueOf(true));
            Toast.makeText(this, R.l.eap, 0).show();
        }
    }

    protected final void a(boolean z, f fVar, boolean z2, boolean z3) {
        if (!(fVar == null || !z || this.lDw == null)) {
            this.lDw.b(fVar);
        }
        if (this.lDw == null || fVar == null || fVar.lDm <= 0) {
            this.klX.setVisibility(0);
            this.lGf.setText(R.l.eaj);
            this.Fv.setVisibility(8);
            return;
        }
        this.klX.setVisibility(8);
        this.Fv.setVisibility(0);
    }

    protected final boolean aCU() {
        return false;
    }

    protected final a aCQ() {
        return new com.tencent.mm.plugin.emoji.a.d(this.mController.xRr);
    }

    public final void a(String str, l lVar) {
        if (str != null && str.equals("event_update_group")) {
            aDp();
            ct(131074, 50);
        }
    }

    protected final int aCO() {
        return 10;
    }

    protected final int aCP() {
        return 6;
    }
}
