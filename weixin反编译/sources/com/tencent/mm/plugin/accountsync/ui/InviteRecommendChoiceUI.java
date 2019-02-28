package com.tencent.mm.plugin.accountsync.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.friend.RecommendFriendUI;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.q;

public class InviteRecommendChoiceUI extends MMPreference {
    private f inW;

    protected final boolean XJ() {
        return false;
    }

    public final int XK() {
        return R.o.fce;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.idX;
        Intent intent;
        if (str.equals("settings_invite_qq_friends")) {
            intent = new Intent(this, RecommendFriendUI.class);
            intent.putExtra("recommend_type", Integer.toString(0));
            startActivity(intent);
        } else if (str.equals("settings_recommend_by_mail")) {
            intent = new Intent(this, RecommendFriendUI.class);
            intent.putExtra("recommend_type", Integer.toString(2));
            startActivity(intent);
        } else if (str.equals("settings_recommend_by_mb")) {
            intent = new Intent(this, RecommendFriendUI.class);
            intent.putExtra("recommend_type", Integer.toString(1));
            startActivity(intent);
        } else if (str.equals("settings_invite_mobile_friends")) {
            intent = new Intent("android.intent.action.VIEW");
            int i = R.l.eqg;
            Object[] objArr = new Object[1];
            as.Hm();
            objArr[0] = c.Db().get(2, null);
            intent.putExtra("sms_body", getString(i, objArr));
            intent.setType("vnd.android-dir/mms-sms");
            if (bi.k(this, intent)) {
                startActivity(intent);
            } else {
                Toast.makeText(this, R.l.eJJ, 1).show();
            }
        } else if (str.equals("settings_invite_facebook_friends")) {
            startActivity(new Intent(this, InviteFacebookFriendsUI.class));
        }
        return false;
    }

    protected final void initView() {
        setMMTitle(R.l.eKa);
        this.inW = this.yrJ;
        this.inW.c((IconPreference) this.inW.Zu("settings_invite_facebook_friends"));
        IconPreference iconPreference = (IconPreference) this.inW.Zu("settings_invite_qq_friends");
        if (q.FX() == 0) {
            this.inW.c(iconPreference);
        }
        iconPreference = (IconPreference) this.inW.Zu("settings_recommend_by_mail");
        if (q.FX() == 0) {
            this.inW.c(iconPreference);
        }
        iconPreference = (IconPreference) this.inW.Zu("settings_recommend_by_mb");
        as.Hm();
        if (c.Fn().FE("@t.qq.com") == null) {
            this.inW.c(iconPreference);
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                InviteRecommendChoiceUI.this.aWY();
                InviteRecommendChoiceUI.this.finish();
                return true;
            }
        });
    }
}
