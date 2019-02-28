package com.tencent.mm.ui;

import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.f.a.ng;
import com.tencent.mm.f.a.rk;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.report.service.f;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.contact.SelectContactUI;
import com.tencent.mm.ui.contact.VoipAddressUI;
import com.tencent.mm.ui.tools.q;
import com.tencent.mm.ui.tools.s;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bj;
import com.tencent.wcdb.database.SQLiteDatabase;

public final class ab extends q {
    private static final int[] xUK = new int[]{2, 1, 4, 10, 3, Integer.MAX_VALUE};
    private LayoutInflater DF;
    private Context mContext;
    private SparseArray<c> xUG;
    private a xUI;
    aa xUJ = null;

    public static class c {
        int fof = 0;
        boolean xUN = false;
        boolean xUO = false;
        d xUP;

        public c(d dVar) {
            this.xUP = dVar;
        }
    }

    public static class d {
        int icon;
        int textColor;
        String xUQ;
        String xUR;
        int xUS;

        public d(int i, String str, String str2, int i2, int i3) {
            this.xUQ = str;
            this.xUR = str2;
            this.icon = i2;
            this.xUS = i;
            this.textColor = i3;
        }
    }

    private class a extends BaseAdapter {
        private a() {
        }

        /* synthetic */ a(ab abVar, byte b) {
            this();
        }

        public final int getCount() {
            return ab.this.xUG.size();
        }

        public final Object getItem(int i) {
            return null;
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            c cVar = (c) ab.this.xUG.get(i);
            View inflate = ab.this.DF.inflate(R.i.don, viewGroup, false);
            TextView textView = (TextView) inflate.findViewById(R.h.title);
            if (!bi.oN(cVar.xUP.xUQ)) {
                textView.setText(cVar.xUP.xUQ);
            }
            if (cVar.xUP.textColor > 0) {
                textView.setTextColor(com.tencent.mm.bu.a.c(ad.getContext(), cVar.xUP.textColor));
            }
            ImageView imageView = (ImageView) inflate.findViewById(R.h.icon);
            if (cVar.xUP.icon > 0) {
                imageView.setVisibility(0);
                imageView.setImageResource(((c) ab.this.xUG.get(i)).xUP.icon);
            } else {
                imageView.setVisibility(8);
            }
            if (!bi.oN(cVar.xUP.xUR)) {
                imageView.setContentDescription(cVar.xUP.xUR);
            }
            View findViewById = inflate.findViewById(R.h.cAh);
            textView = (TextView) inflate.findViewById(R.h.cTS);
            textView.setBackgroundResource(s.ge(ab.this.mContext));
            View findViewById2 = inflate.findViewById(R.h.czr);
            if (cVar.xUN) {
                findViewById.setVisibility(0);
            } else if (cVar.fof > 0) {
                textView.setVisibility(0);
                if (cVar.fof > 99) {
                    textView.setText(R.l.eSf);
                } else {
                    textView.setText(cVar.fof);
                }
            } else if (cVar.xUO) {
                findViewById2.setVisibility(0);
            } else {
                findViewById.setVisibility(8);
                textView.setVisibility(8);
                findViewById2.setVisibility(8);
            }
            if (i == getCount() - 1) {
                inflate.setBackgroundResource(R.g.bGB);
            } else {
                inflate.setBackgroundResource(R.g.bGA);
            }
            return inflate;
        }
    }

    public static class b {
        int hQv;
        int id;
        int order;
        int xUM;

        public b(int i, int i2, int i3) {
            this(i, i2, i3, 0);
        }

        public b(int i, int i2, int i3, int i4) {
            this.id = i;
            this.xUM = i2;
            this.hQv = i3;
            this.order = i4;
        }
    }

    public ab(ActionBarActivity actionBarActivity) {
        super(actionBarActivity);
        this.mContext = actionBarActivity;
        this.DF = LayoutInflater.from(actionBarActivity);
        nD(false);
        this.xUJ = aa.cop();
    }

    public final boolean dN() {
        int i = 0;
        this.xUJ.mf(false);
        if (this.xUJ.xUG.size() != 0) {
            this.xUG = this.xUJ.xUG;
        } else {
            x.d("MicroMsg.PlusSubMenuHelper", "dyna plus config is null, we use default one");
            if (this.xUG != null) {
                this.xUG.clear();
            } else {
                this.xUG = new SparseArray();
            }
            for (int i2 = 0; i2 < xUK.length; i2++) {
                this.xUG.put(i2, new c(Eu(xUK[i2])));
            }
        }
        try {
            as.Hm();
            if (((Boolean) com.tencent.mm.y.c.Db().get(com.tencent.mm.storage.w.a.USERINFO_SUBMENU_SHOW_TIT_BOOLEAN, Boolean.valueOf(false))).booleanValue()) {
                while (i < this.xUG.size() && ((c) this.xUG.get(i)).xUP.xUS != 2147483646) {
                    i++;
                }
                if (i == this.xUG.size()) {
                    this.xUG.put(this.xUG.size(), new c(Eu(2147483646)));
                }
            }
        } catch (Exception e) {
        }
        if (this.xUI != null) {
            this.xUI.notifyDataSetChanged();
        }
        return super.dN();
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        boolean z = true;
        boolean z2 = false;
        if (this.mContext instanceof ActionBarActivity) {
            ((ActionBarActivity) this.mContext).supportInvalidateOptionsMenu();
        }
        int i2 = ((c) this.xUG.get(i)).xUP.xUS;
        g.pWK.h(11104, Integer.valueOf(i2));
        if (com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.appbrand.widget.recentview.d.class) != null) {
            ((com.tencent.mm.plugin.appbrand.widget.recentview.d) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.appbrand.widget.recentview.d.class)).amP();
        }
        Intent intent;
        String str;
        int a;
        Intent intent2;
        bj HX;
        switch (i2) {
            case 1:
                new Intent().putExtra("invite_friend_scene", 2);
                com.tencent.mm.bl.d.b(this.mContext, "subapp", ".ui.pluginapp.AddMoreFriendsUI", new Intent());
                break;
            case 2:
                intent = new Intent(this.mContext, SelectContactUI.class);
                intent.putExtra("titile", this.mContext.getString(R.l.dDy));
                intent.putExtra("list_type", 0);
                intent.putExtra("list_attr", com.tencent.mm.ui.contact.s.p(com.tencent.mm.ui.contact.s.zcA, 256, WXMediaMessage.TITLE_LENGTH_LIMIT));
                intent.putExtra("scene", 7);
                this.mContext.startActivity(intent);
                break;
            case 3:
                intent = new Intent();
                intent.setClassName(this.mContext, "com.tencent.mm.ui.tools.ShareImageRedirectUI");
                this.mContext.startActivity(intent);
                break;
            case 4:
                com.tencent.mm.sdk.b.b rkVar = new rk();
                rkVar.fJX.fJZ = true;
                com.tencent.mm.sdk.b.a.xmy.m(rkVar);
                str = rkVar.fJY.fKb;
                if (!bi.oN(str)) {
                    x.v("MicroMsg.PlusSubMenuHelper", "Talkroom is on: " + str);
                    h.a(this.mContext, this.mContext.getString(R.l.eQN), "", this.mContext.getString(R.l.dGf), this.mContext.getString(R.l.dEy), new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            com.tencent.mm.sdk.b.b rkVar = new rk();
                            rkVar.fJX.fKa = true;
                            com.tencent.mm.sdk.b.a.xmy.m(rkVar);
                            VoipAddressUI.fS(ab.this.mContext);
                            dialogInterface.dismiss();
                        }
                    }, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    break;
                }
                VoipAddressUI.fS(this.mContext);
                break;
            case 5:
                as.Hm();
                if (!com.tencent.mm.y.c.isSDCardAvailable()) {
                    u.fJ(this.mContext);
                    break;
                }
                as.Hm();
                str = (String) com.tencent.mm.y.c.Db().get(2, null);
                Intent intent3 = new Intent();
                intent3.putExtra("sns_userName", str);
                intent3.setFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
                intent3.addFlags(67108864);
                as.Hm();
                a = bi.a((Integer) com.tencent.mm.y.c.Db().get(68389, null), 0);
                as.Hm();
                com.tencent.mm.y.c.Db().set(68389, Integer.valueOf(a + 1));
                com.tencent.mm.bl.d.b(this.mContext, "sns", ".ui.SnsUserUI", intent3);
                break;
            case 6:
                com.tencent.mm.bl.d.y(this.mContext, "favorite", ".ui.FavoriteIndexUI");
                break;
            case 7:
                com.tencent.mm.bl.d.b(this.mContext, "mall", ".ui.MallIndexUI", new Intent());
                break;
            case 8:
                intent = new Intent();
                intent.putExtra("preceding_scence", 2);
                com.tencent.mm.bl.d.b(this.mContext, "emoji", ".ui.v2.EmojiStoreV2UI", intent);
                break;
            case 9:
                com.tencent.mm.bl.d.b(this.mContext, "setting", ".ui.setting.SelfQRCodeUI", new Intent());
                break;
            case 10:
                g.pWK.h(11265, Integer.valueOf(3));
                if (!(com.tencent.mm.o.a.aV(this.mContext) || com.tencent.mm.at.a.Qq())) {
                    com.tencent.mm.bl.d.y(this.mContext, "scanner", ".ui.BaseScanUI");
                    break;
                }
            case 11:
                as.Hm();
                if (!com.tencent.mm.y.c.isSDCardAvailable()) {
                    u.fJ(this.mContext);
                    break;
                }
                f.vR(10);
                as.Hm();
                str = (String) com.tencent.mm.y.c.Db().get(68377, null);
                as.Hm();
                com.tencent.mm.y.c.Db().set(68377, "");
                intent2 = new Intent();
                intent2.putExtra("sns_timeline_NeedFirstLoadint", true);
                boolean z3 = bi.oN(str);
                if (n.qWD == null) {
                    z2 = z3;
                } else if (n.qWD.Tx() <= 0) {
                    z2 = z3;
                }
                intent2.putExtra("sns_resume_state", z2);
                com.tencent.mm.bl.d.b(this.mContext, "sns", ".ui.SnsTimeLineUI", intent2);
                break;
            case 12:
                as.Hm();
                if (!com.tencent.mm.y.c.isSDCardAvailable()) {
                    u.fJ(this.mContext);
                    break;
                }
                com.tencent.mm.bl.d.y(this.mContext, "game", ".ui.GameCenterUI");
                new ag().postDelayed(new Runnable() {
                    public final void run() {
                        Intent intent = new Intent();
                        intent.setComponent(new ComponentName(e.h.xMS, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
                        intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
                        ab.this.mContext.sendBroadcast(intent);
                    }
                }, 100);
                break;
            case 13:
                com.tencent.mm.sdk.b.a.xmy.m(new ng());
                com.tencent.mm.bl.d.y(this.mContext, "shake", ".ui.ShakeReportUI");
                break;
            case 14:
                as.Hm();
                if (!bi.c((Boolean) com.tencent.mm.y.c.Db().get(4103, null))) {
                    com.tencent.mm.bl.d.y(this.mContext, "nearby", ".ui.NearbyFriendsIntroUI");
                    break;
                }
                HX = bj.HX();
                if (HX != null) {
                    String oM = bi.oM(HX.getProvince());
                    a = bi.a(Integer.valueOf(HX.fXa), 0);
                    if (!bi.oN(oM) && a != 0) {
                        as.Hm();
                        Boolean bool = (Boolean) com.tencent.mm.y.c.Db().get(4104, null);
                        if (bool != null && bool.booleanValue()) {
                            View inflate = View.inflate(this.mContext, R.i.dmH, null);
                            final CheckBox checkBox = (CheckBox) inflate.findViewById(R.h.csL);
                            checkBox.setChecked(false);
                            h.a(this.mContext, this.mContext.getString(R.l.dGZ), inflate, new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    if (checkBox != null) {
                                        as.Hm();
                                        com.tencent.mm.y.c.Db().set(4104, Boolean.valueOf(!checkBox.isChecked()));
                                    }
                                    LauncherUI cnu = LauncherUI.cnu();
                                    if (cnu != null) {
                                        cnu.xPu.xOK.YW("tab_find_friend");
                                    }
                                    com.tencent.mm.bj.a.dW(ab.this.mContext);
                                }
                            }, null);
                            break;
                        }
                        LauncherUI cnu = LauncherUI.cnu();
                        if (cnu != null) {
                            cnu.xPu.xOK.YW("tab_find_friend");
                        }
                        com.tencent.mm.bj.a.dW(this.mContext);
                        break;
                    }
                    com.tencent.mm.bl.d.y(this.mContext, "nearby", ".ui.NearbyPersonalInfoUI");
                    break;
                }
                com.tencent.mm.bl.d.y(this.mContext, "nearby", ".ui.NearbyPersonalInfoUI");
                break;
                break;
            case 15:
                HX = bj.HW();
                if (bi.a(Integer.valueOf(HX.fXa), 0) > 0 && !bi.oN(HX.getProvince())) {
                    com.tencent.mm.bl.d.y(this.mContext, "bottle", ".ui.BottleBeachUI");
                    break;
                } else {
                    com.tencent.mm.bl.d.y(this.mContext, "bottle", ".ui.BottleWizardStep1");
                    break;
                }
                break;
            case 16:
                as.Hm();
                if (!com.tencent.mm.y.c.Fa()) {
                    com.tencent.mm.bl.d.y(this.mContext, "webwx", ".ui.WebWeiXinIntroductionUI");
                    break;
                } else {
                    com.tencent.mm.bl.d.y(this.mContext, "webwx", ".ui.WebWXLogoutUI");
                    break;
                }
            case 17:
                if ((com.tencent.mm.y.q.Gj() & 65536) != 0) {
                    z = false;
                }
                if (!z) {
                    com.tencent.mm.bl.d.b(this.mContext, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", "masssendapp"));
                    break;
                } else {
                    com.tencent.mm.bl.d.y(this.mContext, "masssend", ".ui.MassSendHistoryUI");
                    break;
                }
            case 18:
                com.tencent.mm.bl.d.y(this.mContext, "radar", ".ui.RadarSearchUI");
                break;
            case 19:
                com.tencent.mm.bl.d.y(this.mContext, "pwdgroup", ".ui.FacingCreateChatRoomAllInOneUI");
                break;
            case 20:
                Context context = this.mContext;
                intent2 = new Intent();
                intent2.putExtra("key_from_scene", 2);
                com.tencent.mm.bl.d.b(context, "offline", ".ui.WalletOfflineEntranceUI", intent2);
                if (com.tencent.mm.r.c.Bx().aR(262159, 266248)) {
                    com.tencent.mm.r.c.Bx().aS(262159, 266248);
                    g.pWK.h(14396, Integer.valueOf(2));
                    break;
                }
                break;
            case 22:
                com.tencent.mm.pluginsdk.wallet.h.W(this.mContext, 1);
                break;
            case 2147483645:
                intent2 = new Intent();
                as.Hm();
                str = (String) com.tencent.mm.y.c.Db().get(com.tencent.mm.storage.w.a.USERINFO_CROWDTEST_FEEDBACK_LINK_STRING, (Object) "");
                if (!bi.oN(str)) {
                    intent2.putExtra("rawUrl", str);
                    intent2.putExtra("showShare", true);
                    intent2.putExtra("show_bottom", false);
                    com.tencent.mm.bl.d.b(this.mContext, "webview", ".ui.tools.WebViewUI", intent2);
                    break;
                }
                com.tencent.mm.pluginsdk.d.ea(this.mContext);
                break;
            case 2147483646:
                intent = new Intent();
                intent.putExtra("key_from_scene", 2);
                com.tencent.mm.bl.d.b(this.mContext, "offline", ".ui.WalletOfflineEntranceUI", intent);
                break;
            case Integer.MAX_VALUE:
                g.pWK.k(10919, "1-6");
                com.tencent.mm.pluginsdk.d.ea(this.mContext);
                break;
        }
        this.xUJ.Et(i2);
        dismiss();
    }

    public static d Eu(int i) {
        Context context = ad.getContext();
        switch (i) {
            case 1:
                if (HomeUI.xOD.booleanValue()) {
                    return new d(1, context.getString(R.l.eve), "", R.k.dzJ, R.e.buj);
                }
                return new d(1, context.getString(R.l.eve), "", R.k.dzK, 0);
            case 2:
                if (HomeUI.xOE.booleanValue()) {
                    return new d(2, context.getString(R.l.evh), "", R.k.dzS, R.e.buj);
                }
                return new d(2, context.getString(R.l.evh), "", R.k.dzT, 0);
            case 3:
                return new d(3, context.getString(R.l.evi), "", R.k.dxt, 0);
            case 4:
                if (1 == bi.getInt(com.tencent.mm.j.g.Af().getValue("VOIPCallType"), 0)) {
                    return new d(4, context.getString(R.l.evj), "", R.k.dAd, 0);
                }
                return new d(4, context.getString(R.l.evf), "", R.k.dzL, 0);
            case 5:
                return new d(5, context.getString(R.l.eMl), "", R.k.dzY, 0);
            case 6:
                return new d(6, context.getString(R.l.eLZ), "", R.k.dzP, 0);
            case 7:
                return new d(7, context.getString(R.l.eMa), "", R.k.dzN, 0);
            case 8:
                return new d(8, context.getString(R.l.eaw), "", R.k.dzO, 0);
            case 9:
                return new d(9, context.getString(R.l.eMn), "", R.k.dzW, 0);
            case 10:
                return new d(10, context.getString(R.l.ehH), "", R.k.dzZ, 0);
            case 11:
                return new d(11, context.getString(R.l.eQg), "", R.k.dzV, 0);
            case 12:
                return new d(12, context.getString(R.l.ene), "", R.k.dzR, 0);
            case 13:
                return new d(13, context.getString(R.l.eOZ), "", R.k.dAc, 0);
            case 14:
                return new d(14, context.getString(R.l.exE), "", R.k.dzX, 0);
            case 15:
                return new d(15, context.getString(R.l.dMO), "", R.k.dzM, 0);
            case 16:
                return new d(16, context.getString(R.l.eLb), "", R.k.dAe, 0);
            case 17:
                return new d(17, context.getString(R.l.euW), "", R.k.dzU, 0);
            case 18:
                return new d(18, context.getString(R.l.ehI), "", R.k.dAa, 0);
            case 19:
                return new d(19, context.getString(R.l.ehJ), "", R.k.dvc, 0);
            case 20:
                as.Hm();
                if (((Integer) com.tencent.mm.y.c.Db().get(com.tencent.mm.storage.w.a.USERINFO_WALLET_REGION_TYPE_INT_SYNC, Integer.valueOf(0))).intValue() <= 1) {
                    return new d(20, context.getString(R.l.dDx), "", R.k.dAD, 0);
                }
                break;
            case 22:
                as.Hm();
                if (((Integer) com.tencent.mm.y.c.Db().get(com.tencent.mm.storage.w.a.USERINFO_WALLET_REGION_TYPE_INT_SYNC, Integer.valueOf(0))).intValue() == 8) {
                    return new d(22, context.getString(R.l.eBe), "", R.k.dzI, 0);
                }
                break;
            case 2147483645:
                return new d(2147483645, context.getString(R.l.eLv), "", R.k.dzQ, 0);
            case 2147483646:
                return new d(2147483646, "TIT", "", R.k.dzN, 0);
            case Integer.MAX_VALUE:
                return new d(Integer.MAX_VALUE, context.getString(R.l.eLE), "", R.k.dzQ, 0);
        }
        return null;
    }

    protected final BaseAdapter atB() {
        if (this.xUI == null) {
            this.xUI = new a();
        }
        return this.xUI;
    }
}
