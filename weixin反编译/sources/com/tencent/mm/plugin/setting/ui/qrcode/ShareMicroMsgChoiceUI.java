package com.tencent.mm.plugin.setting.ui.qrcode;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.bu.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.q;

public class ShareMicroMsgChoiceUI extends MMPreference {
    private f inW;

    protected final boolean XJ() {
        return false;
    }

    public final int getLayoutId() {
        return R.i.dsJ;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    public final int XK() {
        return R.o.fcO;
    }

    protected final void initView() {
        setMMTitle(R.l.eKl);
        this.inW = this.yrJ;
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                ShareMicroMsgChoiceUI.this.aWY();
                ShareMicroMsgChoiceUI.this.finish();
                return true;
            }
        });
        ((IconPreference) this.inW.Zu("share_micromsg_to_sina")).drawable = a.b(this, R.g.bGe);
        as.Hm();
        c.Fn().FE("@t.qq.com");
        as.Hm();
        IconPreference iconPreference = (IconPreference) this.inW.Zu("share_micromsg_qzone");
        if ((bi.e((Integer) c.Db().get(9, null)) != 0 ? 1 : null) == null) {
            this.inW.c(iconPreference);
        } else {
            iconPreference.drawable = a.b(this, R.g.bFI);
        }
        iconPreference = (IconPreference) this.inW.Zu("share_micromsg_to_fuckbook");
        if (q.Gx()) {
            iconPreference.drawable = a.b(this, R.g.bGd);
        } else {
            this.inW.c(iconPreference);
        }
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.idX;
        Intent intent;
        if (str.equals("share_micromsg_qzone")) {
            as.Hm();
            if (bi.e((Integer) c.Db().get(9, null)) != 0) {
                intent = new Intent(this, ShowQRCodeStep1UI.class);
                intent.putExtra("show_to", 2);
                startActivity(intent);
            } else {
                h.h(this, R.l.eJV, R.l.dGZ);
            }
        } else if (str.equals("share_micromsg_to_sina")) {
            intent = new Intent(this, ShowQRCodeStep1UI.class);
            intent.putExtra("show_to", 3);
            startActivity(intent);
        } else if (str.equals("share_micromsg_to_fuckbook")) {
            intent = new Intent(this, ShowQRCodeStep1UI.class);
            intent.putExtra("show_to", 4);
            startActivity(intent);
        }
        return false;
    }
}
