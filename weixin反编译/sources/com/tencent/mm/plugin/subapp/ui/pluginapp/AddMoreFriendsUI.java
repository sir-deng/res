package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.content.ComponentName;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.bb.b;
import com.tencent.mm.bl.d;
import com.tencent.mm.modelfriend.m;
import com.tencent.mm.o.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceInfoCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.bindmobile.BindMContactIntroUI;
import com.tencent.mm.ui.bindmobile.MobileFriendUI;
import com.tencent.mm.ui.e.h;
import com.tencent.mm.ui.u;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.q;
import java.util.Map;

public class AddMoreFriendsUI extends MMPreference {
    private f inW;
    private final int sen = 4;
    private final int seo = 9;

    public final int XK() {
        return R.o.fbt;
    }

    public final int getForceOrientation() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    public void onResume() {
        CharSequence string;
        super.onResume();
        if (d.Pu("brandservice")) {
            this.inW.bl("find_friends_by_web", false);
        } else {
            this.inW.bl("find_friends_by_web", true);
        }
        this.inW.notifyDataSetChanged();
        AddFriendSearchPreference addFriendSearchPreference = (AddFriendSearchPreference) this.inW.Zu("find_friends_by_input");
        addFriendSearchPreference.see = getString(R.l.dXw);
        addFriendSearchPreference.seg = new OnClickListener() {
            public final void onClick(View view) {
                d.b(AddMoreFriendsUI.this, "search", ".ui.FTSAddFriendUI", new Intent().putExtra("Search_Scene", 2).putExtra(u.FLAG_OVERRIDE_ENTER_ANIMATION, 0).putExtra(u.FLAG_OVERRIDE_EXIT_ANIMATION, 0));
            }
        };
        PreferenceInfoCategory preferenceInfoCategory = (PreferenceInfoCategory) this.inW.Zu("find_friends_info");
        String FY = q.FY();
        String FZ = q.FZ();
        as.Hm();
        String VQ = ap.VQ((String) c.Db().get(6, null));
        if (!bi.oN(FZ)) {
            string = getString(R.l.ehL, new Object[]{FZ});
        } else if (!x.Xi(FY)) {
            string = getString(R.l.ehL, new Object[]{FY});
        } else if (bi.oN(VQ)) {
            string = getString(R.l.ehN);
        } else {
            string = getString(R.l.ehM, new Object[]{ap.VP(VQ)});
        }
        preferenceInfoCategory.setTitle(string);
        preferenceInfoCategory.xRX = R.g.bDf;
        OnClickListener anonymousClass3 = new OnClickListener() {
            public final void onClick(View view) {
                g.pWK.h(11264, Integer.valueOf(1));
                Intent intent = new Intent();
                intent.setClassName(AddMoreFriendsUI.this, "com.tencent.mm.plugin.setting.ui.setting.SelfQRCodeUI");
                AddMoreFriendsUI.this.mController.xRr.startActivity(intent);
            }
        };
        preferenceInfoCategory.ysy = anonymousClass3;
        preferenceInfoCategory.ysz = anonymousClass3;
        ((AddFriendItemPreference) this.inW.Zu("find_friends_create_pwdgroup")).qno = 8;
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(h.xMS, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
        intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
        sendBroadcast(intent);
        if (this.yrJ != null) {
            Preference Zu = this.yrJ.Zu("find_friends_by_web");
            if (Zu != null) {
                Zu.setEnabled(true);
            }
        }
    }

    public void onPause() {
        super.onPause();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public final boolean a(f fVar, Preference preference) {
        Intent intent;
        if ("find_friends_by_qrcode".equals(preference.idX)) {
            intent = new Intent();
            intent.putExtra("BaseScanUI_select_scan_mode", 1);
            intent.putExtra("GetFriendQRCodeUI.INTENT_FROM_ACTIVITY", 0);
            intent.setFlags(65536);
            g.pWK.h(11265, Integer.valueOf(1));
            if (!(a.aV(this) || com.tencent.mm.at.a.Qq())) {
                d.b(this, "scanner", ".ui.BaseScanUI", intent);
            }
            return true;
        } else if ("find_friends_by_other_way".equals(preference.idX)) {
            if (m.NT() != m.a.SUCC) {
                intent = new Intent(this, BindMContactIntroUI.class);
                intent.putExtra("key_upload_scene", 6);
                MMWizardActivity.A(this, intent);
                return true;
            }
            startActivity(new Intent(this, MobileFriendUI.class));
            return true;
        } else if ("find_friends_by_web".equals(preference.idX)) {
            if (com.tencent.mm.plugin.aj.a.g.Ae(0)) {
                Intent QT = b.QT();
                QT.putExtra("KRightBtn", true);
                QT.putExtra("ftsneedkeyboard", true);
                QT.putExtra("key_load_js_without_delay", true);
                QT.putExtra("ftsType", 1);
                QT.putExtra("ftsbizscene", 9);
                Map b = b.b(9, true, 0);
                String zZ = com.tencent.mm.plugin.aj.a.g.zZ(bi.Wo((String) b.get("scene")));
                b.put("sessionId", zZ);
                b.put("subSessionId", zZ);
                QT.putExtra("sessionId", zZ);
                QT.putExtra("subSessionId", zZ);
                QT.putExtra("rawUrl", b.r(b));
                d.b(this, "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", QT);
                preference.setEnabled(false);
            } else {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.AddMoreFriendsUI", "fts h5 template not avail");
            }
            return true;
        } else if ("find_friends_by_radar".equals(preference.idX)) {
            d.y(this, "radar", ".ui.RadarSearchUI");
            return true;
        } else if ("find_friends_create_pwdgroup".equals(preference.idX)) {
            g.pWK.h(11140, Integer.valueOf(1));
            d.y(this, "pwdgroup", ".ui.FacingCreateChatRoomAllInOneUI");
            return true;
        } else if (!"find_friends_by_invite".equals(preference.idX)) {
            return false;
        } else {
            int intExtra = getIntent().getIntExtra("invite_friend_scene", 4);
            g.pWK.h(14034, Integer.valueOf(intExtra));
            Intent intent2 = new Intent(this, InviteFriendsBy3rdUI.class);
            intent2.putExtra("Invite_friends", intExtra);
            startActivity(intent2);
            return true;
        }
    }

    protected final void initView() {
        setMMTitle(R.l.dCG);
        this.inW = this.yrJ;
        Preference addFriendItemPreference = new AddFriendItemPreference(this.mController.xRr);
        addFriendItemPreference.setKey("find_friends_by_invite");
        addFriendItemPreference.setTitle(R.l.ehE);
        int i = R.k.dvq;
        addFriendItemPreference.Kw = i;
        Drawable drawable = addFriendItemPreference.mContext.getResources().getDrawable(i);
        if ((drawable == null && addFriendItemPreference.jY != null) || !(drawable == null || addFriendItemPreference.jY == drawable)) {
            addFriendItemPreference.jY = drawable;
            addFriendItemPreference.notifyChanged();
        }
        addFriendItemPreference.setSummary(R.l.ehF);
        if ((bi.getInt(com.tencent.mm.j.g.Af().getValue("InviteFriendsControlFlags"), 0) & 4) > 0) {
            this.inW.a(addFriendItemPreference, 4);
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AddMoreFriendsUI.this.finish();
                return true;
            }
        });
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return super.onKeyDown(i, keyEvent);
    }
}
