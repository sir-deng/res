package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.mm.R;
import com.tencent.mm.af.f;
import com.tencent.mm.bl.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ae;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.bizchat.BizChatConversationUI;
import com.tencent.mm.y.ak.a;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.q;
import com.tencent.mm.y.r;
import com.tencent.mm.y.s;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import junit.framework.Assert;

public final class e implements OnItemClickListener {
    private Activity activity;
    private ListView zeU;
    private g zfz;

    public e(g gVar, ListView listView, Activity activity) {
        this.zfz = gVar;
        this.zeU = listView;
        this.activity = activity;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        boolean z = false;
        if (i >= this.zeU.getHeaderViewsCount()) {
            int headerViewsCount = i - this.zeU.getHeaderViewsCount();
            ae aeVar = (ae) this.zfz.DV(headerViewsCount);
            if (aeVar == null) {
                x.e("MicroMsg.ConversationClickListener", "null user at position = " + headerViewsCount);
                return;
            }
            boolean z2;
            if (aeVar.gd(16777216)) {
                aeVar.Bb();
                as.Hm();
                c.Fk().a(aeVar, aeVar.field_username);
            }
            if (s.gN(aeVar.field_username)) {
                if (q.Gq()) {
                    d.y(this.activity, "tmessage", ".ui.TConversationUI");
                    z2 = false;
                } else {
                    d.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", aeVar.field_username));
                    z2 = false;
                }
            } else if (s.gO(aeVar.field_username)) {
                if (q.Gp()) {
                    d.y(this.activity, "bottle", ".ui.BottleConversationUI");
                    z2 = false;
                } else {
                    d.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", aeVar.field_username));
                    z2 = false;
                }
            } else if (s.gT(aeVar.field_username)) {
                MMAppMgr.cancelNotification(aeVar.field_username);
                d.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", aeVar.field_username));
                z2 = false;
            } else {
                Intent intent;
                if (s.gL(aeVar.field_username)) {
                    g.Dr();
                    if (bi.e((Integer) g.Dq().Db().get(17, null)) == 1) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (!z2) {
                        d.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", aeVar.field_username));
                        z2 = false;
                    }
                } else if (s.gY(aeVar.field_username)) {
                    if (q.Gv()) {
                        intent = new Intent();
                        intent.addFlags(67108864);
                        intent.putExtra(Columns.TYPE, 20);
                        d.b(this.activity, "readerapp", ".ui.ReaderAppUI", intent);
                        z2 = false;
                    } else {
                        d.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", aeVar.field_username));
                        z2 = false;
                    }
                } else if (s.hf(aeVar.field_username)) {
                    if (q.Gw()) {
                        intent = new Intent();
                        intent.addFlags(67108864);
                        intent.putExtra(Columns.TYPE, 11);
                        d.b(this.activity, "readerapp", ".ui.ReaderAppUI", intent);
                        z2 = false;
                    } else {
                        d.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", aeVar.field_username));
                        z2 = false;
                    }
                } else if (s.gQ(aeVar.field_username)) {
                    d.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", aeVar.field_username));
                    z2 = false;
                } else if (s.gR(aeVar.field_username)) {
                    if (q.Gy()) {
                        d.b(this.activity, "masssend", ".ui.MassSendHistoryUI", new Intent().addFlags(67108864));
                        z2 = false;
                    } else {
                        d.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", aeVar.field_username));
                        z2 = false;
                    }
                } else if (s.he(aeVar.field_username)) {
                    if (a.hhy != null) {
                        a.hhy.hO(aeVar.field_username);
                    }
                    z2 = true;
                } else if (s.hg(aeVar.field_username)) {
                    this.activity.startActivity(new Intent(this.activity, BizConversationUI.class));
                    z2 = false;
                } else if (s.gI(aeVar.field_username) && f.ka(aeVar.field_username)) {
                    if (s.gH(aeVar.field_username)) {
                        intent = new Intent(this.activity, EnterpriseConversationUI.class);
                        intent.putExtra("enterprise_biz_name", aeVar.field_username);
                        intent.putExtra("enterprise_biz_display_name", r.gw(aeVar.field_username));
                        intent.putExtra("enterprise_from_scene", 1);
                        this.activity.startActivity(intent);
                        z2 = false;
                    } else {
                        h.bu(this.activity, this.activity.getString(R.l.ecj));
                        return;
                    }
                } else if (s.gI(aeVar.field_username) && f.eG(aeVar.field_username)) {
                    if (s.gH(aeVar.field_username)) {
                        intent = new Intent(this.activity, BizChatConversationUI.class);
                        intent.putExtra("Contact_User", aeVar.field_username);
                        intent.putExtra("biz_chat_from_scene", 1);
                        intent.addFlags(67108864);
                        this.activity.startActivity(intent);
                        z2 = false;
                    } else {
                        h.bu(this.activity, this.activity.getString(R.l.ecj));
                        return;
                    }
                } else if (s.hp(aeVar.field_username)) {
                    intent = new Intent();
                    intent.setClassName(this.activity, "com.tencent.mm.ui.conversation.AppBrandServiceConversationUI");
                    intent.putExtra("Contact_User", aeVar.field_username);
                    intent.putExtra("app_brand_conversation_from_scene", 1);
                    intent.addFlags(67108864);
                    this.activity.startActivity(intent);
                    z2 = false;
                }
                z2 = true;
            }
            if (z2) {
                com.tencent.mm.plugin.report.service.f.vR(9);
                LauncherUI launcherUI = (LauncherUI) this.activity;
                String str = "Launcher should not be empty.";
                if (launcherUI != null) {
                    z = true;
                }
                Assert.assertTrue(str, z);
                launcherUI.startChatting(aeVar.field_username, null, true);
            }
        }
    }
}
