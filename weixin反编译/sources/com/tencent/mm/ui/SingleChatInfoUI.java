package com.tencent.mm.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.appbrand.ui.widget.AppBrandLoadIconPreference;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.q.l;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.d;
import com.tencent.mm.pluginsdk.wallet.e;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.storage.bf;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.contact.SelectContactUI;
import com.tencent.mm.ui.contact.s;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bb;
import com.tencent.mm.y.c;
import com.tencent.mm.y.q;
import java.util.LinkedList;
import java.util.List;

public class SingleChatInfoUI extends MMPreference implements l {
    private static boolean isDeleteCancel = false;
    private ag handler = new ag(Looper.getMainLooper());
    private SharedPreferences hbz = null;
    private f inW;
    private x jQP;
    private boolean kYN;
    private int lfF = -1;
    private boolean lfH = false;
    private d lfI = new d(new OnScrollListener() {
        public final void onScrollStateChanged(AbsListView absListView, int i) {
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    });
    boolean lfJ = false;
    private String lfR = "";
    private ContactListExpandPreference lfs;
    private CheckBoxPreference lft;
    private CheckBoxPreference lfv;
    private AppBrandLoadIconPreference lfy;
    private String talker;

    private static class a implements OnCancelListener {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final void onCancel(DialogInterface dialogInterface) {
            SingleChatInfoUI.isDeleteCancel = true;
        }
    }

    static /* synthetic */ void c(SingleChatInfoUI singleChatInfoUI) {
        g.pWK.k(10170, "1");
        List linkedList = new LinkedList();
        linkedList.add(singleChatInfoUI.talker);
        linkedList.add(q.FY());
        String d = t.d(linkedList, ",");
        Intent intent = new Intent();
        intent.setClass(singleChatInfoUI, SelectContactUI.class);
        intent.putExtra("titile", singleChatInfoUI.getString(R.l.dDy));
        intent.putExtra("list_type", 0);
        intent.putExtra("list_attr", s.zcA);
        intent.putExtra("always_select_contact", d);
        intent.putExtra("scene", 2);
        singleChatInfoUI.startActivity(intent);
    }

    static /* synthetic */ void g(SingleChatInfoUI singleChatInfoUI) {
        g.pWK.h(14553, Integer.valueOf(6), Integer.valueOf(2), singleChatInfoUI.talker);
        isDeleteCancel = false;
        singleChatInfoUI.getString(R.l.dGZ);
        final ProgressDialog a = h.a((Context) singleChatInfoUI, singleChatInfoUI.getString(R.l.dHn), true, new a());
        if (t.oN(!isDeleteCancel ? e.TE(singleChatInfoUI.jQP.field_username) : null)) {
            singleChatInfoUI.a(a);
            return;
        }
        a.dismiss();
        Object[] objArr = new Object[]{r0};
        h.a(singleChatInfoUI, false, singleChatInfoUI.getString(R.l.eWv, objArr), null, singleChatInfoUI.getString(R.l.enQ), singleChatInfoUI.getString(R.l.dUc), new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                g.pWK.h(14553, Integer.valueOf(6), Integer.valueOf(4), SingleChatInfoUI.this.talker);
                SingleChatInfoUI.isDeleteCancel = true;
                if (SingleChatInfoUI.this.lfH) {
                    SingleChatInfoUI.this.finish();
                    return;
                }
                LauncherUI cnu = LauncherUI.cnu();
                if (cnu != null) {
                    cnu.startChatting(SingleChatInfoUI.this.jQP.field_username, null, true);
                }
            }
        }, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                g.pWK.h(14553, Integer.valueOf(6), Integer.valueOf(3), SingleChatInfoUI.this.talker);
                a.show();
                SingleChatInfoUI.isDeleteCancel = false;
                SingleChatInfoUI.this.a(a);
            }
        }, -1, R.e.brm);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (com.tencent.mm.pluginsdk.q.a.viX != null) {
            com.tencent.mm.pluginsdk.q.a.viX.a(this);
        }
        this.talker = getIntent().getStringExtra("Single_Chat_Talker");
        this.lfH = getIntent().getBooleanExtra("fromChatting", false);
        as.Hm();
        this.jQP = c.Ff().Xv(this.talker);
        this.lfR = getPackageName() + "_preferences";
        initView();
    }

    public void onResume() {
        ayn();
        if (this.lfs != null) {
            List linkedList = new LinkedList();
            linkedList.add(this.talker);
            this.lfs.n(this.talker, linkedList);
        }
        this.inW.notifyDataSetChanged();
        super.onResume();
        if (!this.lfJ) {
            String stringExtra = getIntent().getStringExtra("need_matte_high_light_item");
            if (!t.oN(stringExtra)) {
                final int Zw = this.inW.Zw(stringExtra);
                setSelection(Zw - 3);
                new ag().postDelayed(new Runnable() {
                    public final void run() {
                        View a = ((com.tencent.mm.ui.base.preference.a) SingleChatInfoUI.this.inW).a(Zw, SingleChatInfoUI.this.nQn);
                        if (a != null) {
                            com.tencent.mm.ui.g.a.b(SingleChatInfoUI.this.mController.xRr, a);
                        }
                    }
                }, 10);
            }
            this.lfJ = true;
        }
    }

    public void onPause() {
        super.onPause();
    }

    public void onDestroy() {
        com.tencent.mm.ui.g.a.dismiss();
        if (com.tencent.mm.pluginsdk.q.a.viX != null) {
            com.tencent.mm.pluginsdk.q.a.viX.b(this);
        }
        if (this.lfy != null) {
            AppBrandLoadIconPreference.onDestroy();
        }
        super.onDestroy();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 2:
                    if (i2 == -1) {
                        finish();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public final int XK() {
        return R.o.fcp;
    }

    protected final void initView() {
        this.inW = this.yrJ;
        setMMTitle(getString(R.l.eGM));
        this.lfs = (ContactListExpandPreference) this.inW.Zu("roominfo_contact_anchor");
        this.lfs.a(this.inW, this.lfs.idX);
        this.lfs.lh(true).li(false);
        if (this.jQP != null && this.jQP.field_deleteFlag == 1) {
            this.lfs.lh(false);
        }
        if (this.jQP != null && x.Xg(this.jQP.field_username)) {
            this.lfs.lh(false);
        }
        this.lft = (CheckBoxPreference) this.inW.Zu("room_notify_new_msg");
        this.lfv = (CheckBoxPreference) this.inW.Zu("room_placed_to_the_top");
        if (this.hbz == null) {
            this.hbz = getSharedPreferences(getPackageName() + "_preferences", 0);
        }
        if (this.jQP != null) {
            as.Hm();
            this.hbz.edit().putBoolean("room_placed_to_the_top", c.Fk().XM(this.jQP.field_username)).commit();
            this.kYN = this.jQP.AP();
            this.hbz.edit().putBoolean("room_notify_new_msg", this.kYN).commit();
        } else {
            this.hbz.edit().putBoolean("room_notify_new_msg", false).commit();
            this.kYN = false;
        }
        as.Hm();
        this.lfF = c.Fh().Fv(this.talker);
        this.lfy = (AppBrandLoadIconPreference) this.inW.Zu("chat_app_brand");
        this.lfy.jXh = this.talker;
        if (this.jQP != null && x.Xg(this.jQP.field_username)) {
            this.inW.c(this.lfy);
        }
        this.inW.notifyDataSetChanged();
        if (this.lfs != null) {
            List linkedList = new LinkedList();
            linkedList.add(this.talker);
            this.lfs.n(this.talker, linkedList);
            this.nQn.setOnScrollListener(this.lfI);
            this.lfs.a(this.lfI);
            this.lfs.a(new com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a() {
                public final void ov(int i) {
                }

                public final void ow(int i) {
                    String Ct = SingleChatInfoUI.this.lfs.Ct(i);
                    String oM = t.oM(SingleChatInfoUI.this.lfs.Cv(i));
                    if (t.oN(oM)) {
                        as.Hm();
                        bf FF = c.Fg().FF(Ct);
                        if (!(FF == null || t.oN(FF.field_encryptUsername))) {
                            oM = FF.field_conRemark;
                        }
                    }
                    if (!t.oN(Ct)) {
                        Intent intent = new Intent();
                        intent.putExtra("Contact_User", Ct);
                        intent.putExtra("Contact_RemarkName", oM);
                        intent.putExtra("Contact_Nick", t.oM(SingleChatInfoUI.this.lfs.Cu(i)));
                        intent.putExtra("Contact_RoomMember", true);
                        as.Hm();
                        com.tencent.mm.f.b.ag Xv = c.Ff().Xv(Ct);
                        if (Xv != null && ((int) Xv.gKO) > 0 && com.tencent.mm.k.a.ga(Xv.field_type)) {
                            com.tencent.mm.ui.contact.e.a(intent, Ct);
                        }
                        intent.putExtra("Kdel_from", 0);
                        com.tencent.mm.bl.d.b(SingleChatInfoUI.this, "profile", ".ui.ContactInfoUI", intent, 0);
                    }
                }

                public final void ayt() {
                    if (SingleChatInfoUI.this.lfs != null) {
                        SingleChatInfoUI.this.lfs.cbL();
                    }
                }

                public final void ox(int i) {
                    SingleChatInfoUI.c(SingleChatInfoUI.this);
                }
            });
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                SingleChatInfoUI.this.finish();
                return true;
            }
        });
    }

    public final boolean a(f fVar, Preference preference) {
        boolean z = true;
        String str = preference.idX;
        Intent intent;
        if (str.equals("room_notify_new_msg")) {
            if (this.kYN) {
                z = false;
            }
            this.kYN = z;
            if (this.kYN) {
                com.tencent.mm.y.s.n(this.jQP);
            } else {
                com.tencent.mm.y.s.o(this.jQP);
            }
            as.Hm();
            this.jQP = c.Ff().Xv(this.talker);
            if (this.hbz == null) {
                this.hbz = getSharedPreferences(getPackageName() + "_preferences", 0);
            }
            this.hbz.edit().putBoolean("room_notify_new_msg", this.kYN).commit();
            ayn();
        } else if (str.equals("room_placed_to_the_top")) {
            SharedPreferences sharedPreferences = getSharedPreferences(this.lfR, 0);
            if (this.jQP != null) {
                as.Hm();
                if (c.Fk().XM(this.jQP.field_username)) {
                    com.tencent.mm.y.s.s(this.jQP.field_username, true);
                } else {
                    com.tencent.mm.y.s.r(this.jQP.field_username, true);
                }
                as.Hm();
                sharedPreferences.edit().putBoolean("room_placed_to_the_top", c.Fk().XM(this.jQP.field_username)).commit();
            }
        } else if (str.equals("room_set_chatting_background")) {
            intent = new Intent();
            intent.putExtra("isApplyToAll", false);
            intent.putExtra("username", this.jQP.field_username);
            com.tencent.mm.bl.d.b(this, "setting", ".ui.setting.SettingsChattingBackgroundUI", intent, 2);
        } else if (str.equals("room_search_chatting_content")) {
            intent = new Intent();
            intent.putExtra("detail_username", this.talker);
            com.tencent.mm.bl.d.b(this, "search", ".ui.FTSChattingConvUI", intent);
            g.pWK.h(14569, Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
        } else if (str.equals("room_clear_chatting_history")) {
            h.a(this.mController.xRr, getString(R.l.eiL, new Object[]{this.jQP.AX()}), "", getString(R.l.dEz), getString(R.l.dEy), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    SingleChatInfoUI.g(SingleChatInfoUI.this);
                }
            }, null, R.e.brm);
        } else if (str.equals("room_expose")) {
            intent = new Intent();
            intent.putExtra("k_username", this.talker);
            intent.putExtra("showShare", false);
            intent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(39)}));
            com.tencent.mm.bl.d.b(this, "webview", ".ui.tools.WebViewUI", intent);
        } else if (str.equals("chat_app_brand")) {
            intent = new Intent();
            intent.putExtra("Chat_User", this.talker);
            com.tencent.mm.bl.d.a((Context) this, ".ui.chatting.gallery.AppBrandHistoryListUI", intent);
            g.pWK.a(219, 25, 1, true);
        }
        return false;
    }

    private void a(final ProgressDialog progressDialog) {
        bb.a(this.jQP.field_username, new com.tencent.mm.y.bb.a() {
            public final boolean HH() {
                return SingleChatInfoUI.isDeleteCancel;
            }

            public final void HG() {
                if (progressDialog != null) {
                    progressDialog.dismiss();
                }
            }
        });
        this.handler.post(new Runnable() {
            public final void run() {
                com.tencent.mm.modelmulti.q.Qj().ig(7);
            }
        });
    }

    private void ayn() {
        if (this.hbz == null) {
            this.hbz = getSharedPreferences(getPackageName() + "_preferences", 0);
        }
        this.kYN = this.jQP.AP();
        if (this.kYN) {
            setTitleMuteIconVisibility(0);
            if (this.lft != null) {
                this.hbz.edit().putBoolean("room_notify_new_msg", true).commit();
            }
        } else {
            setTitleMuteIconVisibility(8);
            if (this.lft != null) {
                this.hbz.edit().putBoolean("room_notify_new_msg", false).commit();
            }
        }
        this.inW.notifyDataSetChanged();
    }

    public final void G(String str, String str2, String str3) {
        if (str.equals(this.talker) && this.lfs != null) {
            this.lfs.notifyChanged();
        }
    }

    public final com.tencent.mm.ui.base.preference.h a(SharedPreferences sharedPreferences) {
        return new com.tencent.mm.ui.base.preference.a(this, sharedPreferences);
    }
}
