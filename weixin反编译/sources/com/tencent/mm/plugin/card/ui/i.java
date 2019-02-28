package com.tencent.mm.plugin.card.ui;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.a.l.a;
import com.tencent.mm.plugin.card.b.m;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.g;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;

public final class i implements a {
    View kTo;
    boolean kUY = false;
    MMActivity kgL;
    View lah;
    TextView lai;
    ImageView laj;
    View lak;
    TextView lal;
    ImageView lam;

    public i(MMActivity mMActivity, View view) {
        this.kgL = mMActivity;
        this.kTo = view;
    }

    public final void a(g gVar) {
        awK();
    }

    public final void asP() {
    }

    final void awK() {
        if (am.avl().kPr <= 0 || !this.kUY) {
            this.lah.setVisibility(8);
            if (this.lak != null) {
                this.lak.setVisibility(8);
                return;
            }
            return;
        }
        as.Hm();
        String str = (String) c.Db().get(w.a.USERINFO_CARD_MSG_TIPS_TITLE_STRING_SYNC, (Object) "");
        as.Hm();
        String str2 = (String) c.Db().get(w.a.USERINFO_CARD_MSG_TIPS_ICON_URL_STRING_SYNC, (Object) "");
        int dimensionPixelOffset = this.kgL.getResources().getDimensionPixelOffset(R.f.bwp);
        if (TextUtils.isEmpty(str2)) {
            this.laj.setImageResource(R.g.bAt);
        } else {
            m.a(this.laj, str2, dimensionPixelOffset, R.g.bAt, true);
        }
        if (TextUtils.isEmpty(str)) {
            this.lai.setText(this.kgL.getString(R.l.dOB, new Object[]{Integer.valueOf(r2)}));
        } else {
            this.lai.setText(str);
        }
        this.lah.setVisibility(0);
        if (this.lak != null) {
            if (TextUtils.isEmpty(str2)) {
                this.lam.setImageResource(R.g.bAt);
            } else {
                m.a(this.lam, str2, dimensionPixelOffset, R.g.bAt, true);
            }
            if (TextUtils.isEmpty(str)) {
                this.lal.setText(this.kgL.getString(R.l.dOB, new Object[]{Integer.valueOf(r2)}));
            } else {
                this.lal.setText(str);
            }
            this.lak.setVisibility(0);
        }
    }
}
