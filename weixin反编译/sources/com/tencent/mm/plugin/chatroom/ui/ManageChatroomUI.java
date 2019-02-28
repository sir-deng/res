package com.tencent.mm.plugin.chatroom.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.bp.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.e;
import com.tencent.mm.plugin.messenger.foundation.a.a.e.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.arw;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.q;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.m;

public class ManageChatroomUI extends MMPreference {
    private SharedPreferences hbz = null;
    private f inW;
    CheckBoxPreference lgP;
    private String lgQ;
    private String lgR;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.i("MicroMsg.ManageChatroomUI", "[onCreate]");
        this.lgQ = getIntent().getStringExtra("RoomInfo_Id");
        this.lgR = getIntent().getStringExtra("room_owner_name");
        this.inW = this.yrJ;
        if (this.inW != null) {
            setMMTitle(R.l.euQ);
            this.lgP = (CheckBoxPreference) this.inW.Zu("allow_by_identity");
            this.inW.bl("select_enable_qrcode", true);
            this.inW.bl("select_into_room_type", true);
            setBackBtn(new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    ManageChatroomUI.this.finish();
                    return true;
                }
            });
        }
    }

    protected void onResume() {
        boolean z = false;
        as.Hm();
        q hG = c.Fo().hG(this.lgQ);
        if (hG != null && this.hbz == null) {
            this.hbz = getSharedPreferences(getPackageName() + "_preferences", 0);
            Editor edit = this.hbz.edit();
            String str = "allow_by_identity";
            if (hG.ciG() == 2) {
                z = true;
            }
            edit.putBoolean(str, z).commit();
        }
        super.onResume();
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    public final int XK() {
        return R.o.fch;
    }

    public final boolean a(f fVar, Preference preference) {
        int i = 2;
        String str = preference.idX;
        x.d("MicroMsg.ManageChatroomUI", "[onPreferenceTreeClick] key:%s", str);
        if (str.equals("room_transfer_room_ower")) {
            x.i("MicroMsg.ManageChatroomUI", "[selectNewRoomOwner] roomId:%s", this.lgQ);
            str = bi.d(m.gl(this.lgQ), ",");
            Intent intent = new Intent();
            intent.putExtra("Block_list", com.tencent.mm.y.q.FY());
            intent.putExtra("Chatroom_member_list", str);
            intent.putExtra("frome_scene", 2);
            intent.putExtra("RoomInfo_Id", this.lgQ);
            intent.putExtra("is_show_owner", false);
            intent.putExtra("title", getString(R.l.eGq));
            intent.setClass(this, SelectMemberUI.class);
            startActivity(intent);
        } else if (str.equals("allow_by_identity")) {
            boolean isChecked = this.lgP.isChecked();
            g.pWK.a(219, 22, 1, true);
            x.i("MicroMsg.ManageChatroomUI", "[selectAllowByIdentity] roomId:%s isOpen:%s", this.lgQ, Boolean.valueOf(isChecked));
            a arw = new arw();
            arw.wfN = bi.oM(this.lgQ);
            if (!isChecked) {
                i = 0;
            }
            arw.pWh = i;
            b aVar = new e.a(66, arw);
            as.Hm();
            c.Fe().b(aVar);
        }
        return false;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 1:
                if (intent != null) {
                    x.i("MicroMsg.ManageChatroomUI", "[openVerify] roomId:%s, type:%s", this.lgQ, Integer.valueOf(intent.getIntExtra("into_room_type", -1)));
                    a arw = new arw();
                    arw.wfN = bi.oM(this.lgQ);
                    arw.pWh = r0;
                    b aVar = new e.a(66, arw);
                    as.Hm();
                    c.Fe().b(aVar);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
