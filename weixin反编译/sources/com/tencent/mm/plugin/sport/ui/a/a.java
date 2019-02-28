package com.tencent.mm.plugin.sport.ui.a;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.af.y;
import com.tencent.mm.f.a.ot;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.exdevice.ui.ExdeviceRankDataSourceUI;
import com.tencent.mm.plugin.sport.b.d;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.q;
import com.tencent.mm.y.s;
import com.tencent.mm.y.t;
import java.util.LinkedList;
import java.util.List;

public final class a implements e, com.tencent.mm.pluginsdk.c.a {
    Context context;
    private f inW;
    x jQP;
    private r jQQ;
    private CheckBoxPreference saV;
    private CheckBoxPreference saW;

    public a(Context context) {
        this.context = context;
    }

    public final boolean a(f fVar, x xVar, boolean z, int i) {
        this.inW = fVar;
        this.jQP = xVar;
        fVar.addPreferencesFromResource(R.o.fbT);
        this.saV = (CheckBoxPreference) fVar.Zu("contact_info_top_sport");
        this.saW = (CheckBoxPreference) fVar.Zu("contact_info_not_disturb");
        asy();
        return true;
    }

    public final boolean asz() {
        return true;
    }

    public final boolean ww(String str) {
        Intent intent;
        if ("contact_info_record_data".equals(str)) {
            this.context.startActivity(new Intent(this.context, ExdeviceRankDataSourceUI.class));
        } else if ("contact_info_top_sport".equals(str)) {
            if (this.saV.isChecked()) {
                d.qq(20);
                s.r(this.jQP.field_username, true);
            } else {
                d.qq(21);
                s.s(this.jQP.field_username, true);
            }
        } else if ("contact_info_not_disturb".equals(str)) {
            if (this.saW.isChecked()) {
                d.qq(22);
                s.n(this.jQP);
            } else {
                d.qq(23);
                s.o(this.jQP);
            }
        } else if ("contact_info_go_to_sport".equals(str)) {
            intent = new Intent();
            intent.putExtra("Chat_User", this.jQP.field_username);
            intent.putExtra("finish_direct", true);
            com.tencent.mm.bl.d.a(this.context, ".ui.chatting.ChattingUI", intent);
            d.qq(19);
        } else if ("contact_info_go_to_my_profile".equals(str)) {
            String FY = q.FY();
            if (bi.oN(FY)) {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.Sport.ContactWidgetSport", "Get username from UserInfo return null or nil.");
            } else {
                Intent intent2 = new Intent();
                intent2.putExtra("username", FY);
                com.tencent.mm.bl.d.b(this.context, "exdevice", ".ui.ExdeviceProfileUI", intent2);
                d.qq(3);
            }
        } else if ("contact_info_invite_friend".equals(str)) {
            intent = new Intent();
            intent.putExtra("Select_Talker_Name", this.jQP.field_username);
            intent.putExtra("Select_block_List", this.jQP.field_username);
            intent.putExtra("Select_Conv_Type", 3);
            intent.putExtra("Select_Send_Card", true);
            intent.putExtra("mutil_select_is_ret", true);
            com.tencent.mm.bl.d.a(this.context, ".ui.transmit.SelectConversationUI", intent, 1);
            d.qq(4);
        } else if ("contact_info_common_problem".equals(str)) {
            intent = new Intent();
            intent.putExtra("KPublisherId", "custom_menu");
            intent.putExtra("pre_username", this.jQP.field_username);
            intent.putExtra("prePublishId", "custom_menu");
            intent.putExtra("preUsername", this.jQP.field_username);
            intent.putExtra("preChatName", this.jQP.field_username);
            intent.putExtra("preChatTYPE", t.N(this.jQP.field_username, this.jQP.field_username));
            intent.putExtra("rawUrl", "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=wechat_movement_faq/index");
            intent.putExtra("geta8key_username", this.jQP.field_username);
            intent.putExtra("from_scence", 1);
            com.tencent.mm.bl.d.b(this.context, "webview", ".ui.tools.WebViewUI", intent);
            d.qq(5);
        } else if ("contact_info_privacy_and_notification".equals(str)) {
            com.tencent.mm.bl.d.y(this.context, "exdevice", ".ui.ExdeviceSettingUI");
        } else if ("contact_info_sport_install".equals(str)) {
            d.qq(13);
            Context context = this.context;
            this.context.getString(R.l.dGZ);
            this.jQQ = h.a(context, this.context.getString(R.l.eMO), true, null);
            this.jQQ.show();
            as.CN().a(30, (e) this);
            List linkedList = new LinkedList();
            linkedList.add("gh_43f2581f6fd6");
            List linkedList2 = new LinkedList();
            linkedList2.add(Integer.valueOf(1));
            as.CN().a(new o(1, linkedList, linkedList2, "", ""), 0);
        } else if ("contact_info_sport_uninstall".equals(str)) {
            d.qq(14);
            h.a(this.context, this.context.getString(R.l.eMR), "", this.context.getString(R.l.dEz), this.context.getString(R.l.dEy), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    ((com.tencent.mm.pluginsdk.h) g.h(com.tencent.mm.pluginsdk.h.class)).a(com.tencent.mm.af.f.jV(a.this.jQP.field_username), (Activity) a.this.context, a.this.jQP);
                    a.this.asy();
                }
            }, null);
        } else if ("contact_info_clear_data".equals(str)) {
            h.a(this.context, this.context.getString(R.l.dUR), "", this.context.getString(R.l.dEz), this.context.getString(R.l.dEy), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    d.qq(25);
                    as.Hm();
                    c.Fh().Fj("gh_43f2581f6fd6");
                }
            }, null);
        }
        return false;
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            switch (i) {
                case 1:
                    if (intent != null) {
                        List<String> F = bi.F(intent.getStringExtra("received_card_name").split(","));
                        String stringExtra = intent.getStringExtra("custom_send_text");
                        for (String str : F) {
                            com.tencent.mm.plugin.messenger.a.f.aZN().l("gh_43f2581f6fd6", str, s.eX(str));
                            if (!bi.oN(stringExtra)) {
                                b otVar = new ot();
                                otVar.fHD.fHE = str;
                                otVar.fHD.content = stringExtra;
                                otVar.fHD.type = s.hs(str);
                                otVar.fHD.flags = 0;
                                com.tencent.mm.sdk.b.a.xmy.m(otVar);
                            }
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    final void asy() {
        HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.inW.Zu("contact_info_header_helper");
        helperHeaderPreference.af(this.jQP.field_username, this.jQP.AX(), this.context.getString(R.l.dXm));
        if (com.tencent.mm.k.a.ga(this.jQP.field_type)) {
            helperHeaderPreference.nP(1);
            this.inW.bl("contact_info_sport_install", true);
            this.inW.bl("contact_info_sport_uninstall", false);
            this.inW.bl("contact_info_go_to_sport", false);
            this.inW.bl("contact_info_go_to_my_profile", false);
            this.inW.bl("contact_info_invite_friend", false);
            this.inW.bl("contact_info_common_problem", false);
            this.inW.bl("contact_info_record_data", false);
            this.inW.bl("contact_info_privacy_and_notification", false);
            this.inW.bl("contact_info_top_sport", false);
            this.inW.bl("contact_info_not_disturb", false);
            as.Hm();
            if (c.Fk().XM(this.jQP.field_username)) {
                this.saV.tYU = true;
            } else {
                this.saV.tYU = false;
            }
            if (this.jQP.AP()) {
                this.saW.tYU = true;
                return;
            } else {
                this.saW.tYU = false;
                return;
            }
        }
        helperHeaderPreference.nP(0);
        this.inW.bl("contact_info_sport_install", false);
        this.inW.bl("contact_info_sport_uninstall", true);
        this.inW.bl("contact_info_go_to_sport", true);
        this.inW.bl("contact_info_go_to_my_profile", true);
        this.inW.bl("contact_info_invite_friend", true);
        this.inW.bl("contact_info_common_problem", true);
        this.inW.bl("contact_info_record_data", true);
        this.inW.bl("contact_info_privacy_and_notification", true);
        this.inW.bl("contact_info_top_sport", true);
        this.inW.bl("contact_info_not_disturb", true);
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar instanceof o) {
            as.CN().b(30, (e) this);
            if (i == 0 && i2 == 0) {
                String bZf = ((o) kVar).bZf();
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Sport.ContactWidgetSport", "bind fitness contact %s success", bZf);
                as.Hm();
                ag Xv = c.Ff().Xv("gh_43f2581f6fd6");
                if (Xv == null || bi.oN(bZf)) {
                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.Sport.ContactWidgetSport", "respUsername == " + bZf + ", contact = " + Xv);
                } else {
                    com.tencent.mm.af.d jV;
                    if (s.gG(Xv.field_username)) {
                        String oM = bi.oM(Xv.field_username);
                        jV = com.tencent.mm.af.f.jV(oM);
                        if (jV != null) {
                            jV.field_username = bZf;
                        }
                        y.Ml().jO(oM);
                        Xv.di(oM);
                    } else {
                        jV = null;
                    }
                    Xv.setUsername(bZf);
                    if (((int) Xv.gKO) == 0) {
                        as.Hm();
                        c.Ff().T(Xv);
                    }
                    if (((int) Xv.gKO) <= 0) {
                        com.tencent.mm.sdk.platformtools.x.e("MicroMsg.Sport.ContactWidgetSport", "addContact : insert contact failed");
                    } else {
                        s.p(Xv);
                        as.Hm();
                        ag Xv2 = c.Ff().Xv(Xv.field_username);
                        if (jV != null) {
                            y.Ml().d(jV);
                        } else {
                            jV = com.tencent.mm.af.f.jV(Xv2.field_username);
                            if (jV == null || jV.Le()) {
                                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.Sport.ContactWidgetSport", "shouldUpdate");
                                com.tencent.mm.y.ak.a.hhv.Q(Xv2.field_username, "");
                                com.tencent.mm.ac.b.ja(Xv2.field_username);
                            } else if (Xv2.ciQ()) {
                                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.Sport.ContactWidgetSport", "update contact, last check time=%d", Integer.valueOf(Xv2.fXr));
                                com.tencent.mm.y.ak.a.hhv.Q(Xv2.field_username, "");
                                com.tencent.mm.ac.b.ja(Xv2.field_username);
                            }
                        }
                    }
                }
                y.Ml().e(y.Ml().jN(Xv.field_username));
                as.Hm();
                c.Db().set(327825, Boolean.valueOf(true));
                com.tencent.mm.plugin.x.a.bfS();
                com.tencent.mm.av.d.a(com.tencent.mm.av.b.hJT, 1, com.tencent.mm.av.b.hJP, "", null);
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.NewTipsManager", "dancy register local newtips, tipsId:%s, tipsVersion:%s, key:%s", Integer.valueOf(r0), Integer.valueOf(1), "");
            } else {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.Sport.ContactWidgetSport", "errType %d | errCode %d | errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                if (i == 4 && i2 == -24 && !bi.oN(str)) {
                    Toast.makeText(ad.getContext(), str, 1).show();
                }
            }
            if (this.jQQ != null) {
                this.jQQ.dismiss();
            }
            asy();
        }
    }
}
