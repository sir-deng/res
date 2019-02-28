package com.tencent.mm.ui.bizchat;

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
import android.widget.Toast;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.af.a.c;
import com.tencent.mm.af.a.d.a;
import com.tencent.mm.af.a.d.a.b;
import com.tencent.mm.af.a.j;
import com.tencent.mm.af.a.u;
import com.tencent.mm.af.n;
import com.tencent.mm.af.y;
import com.tencent.mm.ap.o;
import com.tencent.mm.f.a.se;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.d;
import com.tencent.mm.pluginsdk.ui.preference.SignaturePreference;
import com.tencent.mm.protocal.c.hp;
import com.tencent.mm.protocal.c.hr;
import com.tencent.mm.protocal.c.hs;
import com.tencent.mm.protocal.c.ps;
import com.tencent.mm.protocal.c.pt;
import com.tencent.mm.protocal.c.ws;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bb;
import com.tencent.mm.y.i;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class BizChatroomInfoUI extends MMPreference implements e, n {
    private static boolean lfU = false;
    private int fromScene;
    private SharedPreferences hbz = null;
    private ProgressDialog inI = null;
    private f inW;
    private boolean isDeleteCancel = false;
    private long kMn;
    private String kMt;
    private boolean kYN;
    private boolean lfB = false;
    private int lfC;
    private d lfI = new d(new OnScrollListener() {
        public final void onScrollStateChanged(AbsListView absListView, int i) {
            o.PG().bp(i);
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    });
    boolean lfJ = false;
    private SignaturePreference lfo;
    private ContactListExpandPreference lfs;
    private CheckBoxPreference lft;
    private CheckBoxPreference lfu;
    private CheckBoxPreference lfv;
    private j poq = null;
    private c yvJ = null;
    private a ywo = new a() {
        public final void a(b bVar) {
            if (bVar != null && bVar.hsA != null && bVar.hsp == BizChatroomInfoUI.this.kMn && bVar.hsz != a.a.hsw) {
                x.i("MicroMsg.BizChatroomInfoUI", "bizChatExtension bizChat change");
                BizChatroomInfoUI.this.yvJ = y.Mn().ag(BizChatroomInfoUI.this.kMn);
                BizChatroomInfoUI.this.crE();
            }
        }
    };
    private String yxl;
    private boolean yxm = false;
    private boolean yxn;
    private boolean yxo;
    private int yxp;
    private j yxq = null;

    static /* synthetic */ void a(BizChatroomInfoUI bizChatroomInfoUI, int i) {
        boolean z = true;
        j FF = bizChatroomInfoUI.FF(i);
        if (FF == null) {
            String str = "MicroMsg.BizChatroomInfoUI";
            String str2 = "onItemNormalClick userInfo == null:%s";
            Object[] objArr = new Object[1];
            if (FF != null) {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            x.w(str, str2, objArr);
            return;
        }
        x.i("MicroMsg.BizChatroomInfoUI", "onItemNormalClick field_userId:%s", FF.field_userId);
        String str3 = FF.field_userId;
        hs hsVar = new hs();
        hr hrVar = new hr();
        hrVar.vUi = str3;
        hsVar.vUj.add(hrVar);
        bizChatroomInfoUI.a(null, hsVar);
    }

    static /* synthetic */ boolean a(BizChatroomInfoUI bizChatroomInfoUI, String str, CharSequence charSequence) {
        String trim = charSequence == null ? "" : charSequence.toString().trim();
        if (trim.equals(str)) {
            x.d("MicroMsg.BizChatroomInfoUI", "same room name return");
            return true;
        } else if (trim.length() == 0) {
            h.bu(bizChatroomInfoUI.mController.xRr, bizChatroomInfoUI.getString(R.l.eFi));
            return false;
        } else {
            com.tencent.mm.sdk.b.a.xmy.m(new se());
            bizChatroomInfoUI.yxl = bizChatroomInfoUI.yvJ.field_chatName;
            bizChatroomInfoUI.yxp = bizChatroomInfoUI.yvJ.field_bitFlag;
            bizChatroomInfoUI.yvJ.field_chatName = trim;
            y.Mn().b(bizChatroomInfoUI.yvJ);
            hp hpVar = new hp();
            hpVar.vUb = bizChatroomInfoUI.yvJ.field_bizChatServId;
            hpVar.name = trim;
            hpVar.vUd = bizChatroomInfoUI.yxp;
            y.Mr();
            com.tencent.mm.af.a.h.a(bizChatroomInfoUI.yvJ.field_brandUserName, hpVar, (n) bizChatroomInfoUI);
            bizChatroomInfoUI.ayp();
            bizChatroomInfoUI.inW.notifyDataSetChanged();
            return true;
        }
    }

    static /* synthetic */ void c(BizChatroomInfoUI bizChatroomInfoUI) {
        Intent intent = new Intent();
        if (bizChatroomInfoUI.yxm) {
            if (bi.oN(bizChatroomInfoUI.yvJ.field_addMemberUrl)) {
                x.w("MicroMsg.BizChatroomInfoUI", "dealAddMemberBtn: addMemberUrl is null");
                Toast.makeText(bizChatroomInfoUI, bizChatroomInfoUI.getString(R.l.dMA), 0).show();
                return;
            }
            intent.putExtra("rawUrl", bizChatroomInfoUI.yvJ.field_addMemberUrl);
        } else if (bizChatroomInfoUI.poq == null || bi.oN(bizChatroomInfoUI.poq.field_addMemberUrl)) {
            x.w("MicroMsg.BizChatroomInfoUI", "dealAddMemberBtn: addMemberUrl is null");
            Toast.makeText(bizChatroomInfoUI, bizChatroomInfoUI.getString(R.l.dMA), 0).show();
            return;
        } else {
            intent.putExtra("rawUrl", bizChatroomInfoUI.poq.field_addMemberUrl);
        }
        intent.putExtra("useJs", true);
        com.tencent.mm.bl.d.b(bizChatroomInfoUI.mController.xRr, "webview", ".ui.tools.WebViewUI", intent, 1);
    }

    static /* synthetic */ void d(BizChatroomInfoUI bizChatroomInfoUI) {
        x.i("MicroMsg.BizChatroomInfoUI", "deleteChatroom");
        y.Mr();
        g.Dp().gRu.a(new u(bizChatroomInfoUI.kMt, bizChatroomInfoUI.yvJ.field_bizChatServId), 0);
        bizChatroomInfoUI.isDeleteCancel = false;
        bizChatroomInfoUI.getString(R.l.dGZ);
        final ProgressDialog a = h.a((Context) bizChatroomInfoUI, bizChatroomInfoUI.getString(R.l.dHn), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                BizChatroomInfoUI.this.isDeleteCancel = true;
            }
        });
        i.a(bizChatroomInfoUI.kMt, bizChatroomInfoUI.kMn, new bb.a() {
            public final boolean HH() {
                return BizChatroomInfoUI.this.isDeleteCancel;
            }

            public final void HG() {
                if (a != null) {
                    y.Mo().aU(BizChatroomInfoUI.this.kMn);
                    y.Mn().aU(BizChatroomInfoUI.this.kMn);
                    a.dismiss();
                }
            }
        });
        Intent intent = new Intent();
        intent.addFlags(67108864);
        intent.putExtra("Contact_User", bizChatroomInfoUI.kMt);
        com.tencent.mm.bl.d.b(bizChatroomInfoUI.mController.xRr, "brandservice", ".ui.BizChatConversationUI", intent);
        bizChatroomInfoUI.finish();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        y.Mn().a(this.ywo, Looper.getMainLooper());
        this.fromScene = getIntent().getIntExtra("key_biz_chat_info_from_scene", -1);
        this.kMt = getIntent().getStringExtra("Chat_User");
        this.kMn = getIntent().getLongExtra("key_biz_chat_id", -1);
        this.yvJ = y.Mn().ag(this.kMn);
        this.yxl = this.yvJ.field_chatName;
        this.yxm = com.tencent.mm.af.a.e.kq(this.yvJ.field_bizChatServId);
        if (!this.yxm) {
            this.poq = y.Mp().ca(this.yvJ.field_bizChatServId);
        }
        this.yxq = y.Mp().kA(this.kMt);
        initView();
        if (this.yvJ != null && this.yvJ.field_bizChatServId != null && this.kMt != null) {
            if (this.yvJ.Mz()) {
                y.Mr();
                com.tencent.mm.af.a.h.ak(this.yvJ.field_bizChatServId, this.kMt);
                return;
            }
            y.Mr();
            com.tencent.mm.af.a.h.a(this.yvJ.field_bizChatServId, this.kMt, (n) this);
        }
    }

    public void onResume() {
        ayp();
        updateTitle();
        ayn();
        bke();
        crD();
        ayl();
        this.inW.notifyDataSetChanged();
        super.onResume();
        if (!this.lfJ) {
            String stringExtra = getIntent().getStringExtra("need_matte_high_light_item");
            if (!bi.oN(stringExtra)) {
                final int Zw = this.inW.Zw(stringExtra);
                setSelection(Zw - 3);
                new ag().postDelayed(new Runnable() {
                    public final void run() {
                        View a = ((com.tencent.mm.ui.base.preference.a) BizChatroomInfoUI.this.inW).a(Zw, BizChatroomInfoUI.this.nQn);
                        if (a != null) {
                            com.tencent.mm.ui.g.a.b(BizChatroomInfoUI.this.mController.xRr, a);
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
        com.tencent.mm.ui.g.a.dismiss();
        y.Mn().a(this.ywo);
        super.onDestroy();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 1:
                    boolean ZF;
                    Bundle bundleExtra = intent.getBundleExtra("result_data");
                    if (bundleExtra != null) {
                        x.i("MicroMsg.BizChatroomInfoUI", "bundle != null");
                        String string = bundleExtra.getString("enterprise_members");
                        x.i("MicroMsg.BizChatroomInfoUI", "enterprise_members:%s", string);
                        if (this.yxm) {
                            ZF = ZF(string);
                        } else {
                            ws wsVar = new ws();
                            c cVar = new c();
                            cVar.field_addMemberUrl = this.yxq != null ? this.yxq.field_addMemberUrl : null;
                            cVar.field_brandUserName = this.kMt;
                            if (com.tencent.mm.af.a.e.a(cVar, string, this.poq.field_userId, wsVar)) {
                                y.Mr();
                                final com.tencent.mm.af.a.n a = com.tencent.mm.af.a.h.a(this.kMt, wsVar, (n) this);
                                getString(R.l.dGZ);
                                this.inI = h.a((Context) this, getString(R.l.dCP), true, new OnCancelListener() {
                                    public final void onCancel(DialogInterface dialogInterface) {
                                        as.CN().c(a);
                                    }
                                });
                                ZF = true;
                            } else {
                                ZF = false;
                            }
                        }
                    } else {
                        ZF = false;
                    }
                    if (!ZF) {
                        Toast.makeText(this, getString(R.l.eFf), 0).show();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private boolean ZF(String str) {
        if (str != null) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                hs hsVar = new hs();
                for (int i = 0; i < jSONArray.length(); i++) {
                    j jVar;
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    String string = jSONObject.getString(SlookAirButtonFrequentContactAdapter.ID);
                    j ca = y.Mp().ca(string);
                    if (ca == null) {
                        ca = new j();
                        ca.field_userId = string;
                        jVar = ca;
                    } else {
                        jVar = ca;
                    }
                    jVar.field_userName = jSONObject.getString("nick_name");
                    jVar.field_brandUserName = this.kMt;
                    jVar.field_headImageUrl = jSONObject.getString("head_img_url");
                    jVar.field_profileUrl = jSONObject.getString("profile_url");
                    jVar.field_UserVersion = jSONObject.getInt("ver");
                    jVar.field_addMemberUrl = this.yxq != null ? this.yxq.field_addMemberUrl : null;
                    if (!y.Mp().b(jVar)) {
                        y.Mp().a(jVar);
                    }
                    hr hrVar = new hr();
                    hrVar.vUi = jVar.field_userId;
                    hsVar.vUj.add(hrVar);
                }
                a(hsVar, null);
                return true;
            } catch (Throwable e) {
                x.i("MicroMsg.BizChatroomInfoUI", "parse memberJson Exception:%s", e.getMessage());
                x.printErrStackTrace("MicroMsg.BizChatroomInfoUI", e, "", new Object[0]);
            }
        }
        return false;
    }

    private void a(hs hsVar, hs hsVar2) {
        x.i("MicroMsg.BizChatroomInfoUI", "updateBizChatMemberList()");
        String string = hsVar == null ? getString(R.l.eFl) : getString(R.l.dCP);
        y.Mr();
        final com.tencent.mm.af.a.x a = com.tencent.mm.af.a.h.a(this.yvJ.field_brandUserName, this.yvJ.field_bizChatServId, hsVar, hsVar2, this);
        getString(R.l.dGZ);
        this.inI = h.a((Context) this, string, true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                as.CN().c(a);
            }
        });
    }

    public final int XK() {
        return R.o.fby;
    }

    protected final void initView() {
        this.inW = this.yrJ;
        String str = this.yvJ.field_ownerUserId;
        this.lfC = this.yvJ.My().size();
        if (bi.oN(str)) {
            this.lfB = false;
        } else {
            this.lfB = str.equals(y.Mp().cb(this.kMt));
        }
        x.d("MicroMsg.BizChatroomInfoUI", "initBaseChatRoomView()");
        this.lfs = (ContactListExpandPreference) this.inW.Zu("roominfo_contact_anchor");
        this.lfs.a(this.inW, this.lfs.idX);
        this.lfo = (SignaturePreference) this.inW.Zu("room_name");
        this.lft = (CheckBoxPreference) this.inW.Zu("room_notify_new_msg");
        this.lfv = (CheckBoxPreference) this.inW.Zu("room_placed_to_the_top");
        this.lfu = (CheckBoxPreference) this.inW.Zu("room_save_to_contact");
        ContactListExpandPreference contactListExpandPreference = this.lfs;
        boolean z = this.yxm;
        if (contactListExpandPreference.vuT != null) {
            contactListExpandPreference.vuT.vuf.vuu = z;
        }
        contactListExpandPreference = this.lfs;
        z = this.lfB;
        if (contactListExpandPreference.vuT != null) {
            contactListExpandPreference.vuT.vuf.vut = z;
        }
        if (this.lfB) {
            this.lfs.lh(true).li(true);
        } else {
            this.lfs.lh(true).li(false);
        }
        this.lfs.SY(this.yvJ.field_ownerUserId);
        this.lfs.cbK();
        this.lfs.cbN();
        if (!this.yxm) {
            this.inW.bl("room_save_to_contact", true);
            this.inW.bl("room_name", true);
            this.inW.bl("room_del_quit", true);
        }
        crD();
        bke();
        ayn();
        if (this.lfs != null) {
            this.nQn.setOnScrollListener(this.lfI);
            this.lfs.a(this.lfI);
            this.lfs.a(new ContactListExpandPreference.a() {
                public final void ov(int i) {
                    BizChatroomInfoUI.a(BizChatroomInfoUI.this, i);
                }

                public final void ow(int i) {
                    boolean z = true;
                    j FF = BizChatroomInfoUI.this.FF(i);
                    if (FF == null || bi.oN(FF.field_profileUrl)) {
                        String str = "MicroMsg.BizChatroomInfoUI";
                        String str2 = "onItemNormalClick userInfo == null:%s";
                        Object[] objArr = new Object[1];
                        if (FF != null) {
                            z = false;
                        }
                        objArr[0] = Boolean.valueOf(z);
                        x.w(str, str2, objArr);
                        return;
                    }
                    x.i("MicroMsg.BizChatroomInfoUI", "onItemNormalClick Url:%s", FF.field_profileUrl);
                    y.Mr();
                    com.tencent.mm.af.a.h.a(FF.field_userId, FF.field_brandUserName, BizChatroomInfoUI.this);
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", FF.field_profileUrl);
                    intent.putExtra("useJs", true);
                    com.tencent.mm.bl.d.b(BizChatroomInfoUI.this.mController.xRr, "webview", ".ui.tools.WebViewUI", intent);
                }

                public final void ayt() {
                    if (BizChatroomInfoUI.this.lfs != null) {
                        BizChatroomInfoUI.this.lfs.cbL();
                    }
                }

                public final void ox(int i) {
                    BizChatroomInfoUI.c(BizChatroomInfoUI.this);
                }
            });
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                BizChatroomInfoUI.this.finish();
                return true;
            }
        });
    }

    public final boolean a(f fVar, Preference preference) {
        boolean z = true;
        String str = preference.idX;
        if (str.equals("room_name")) {
            String str2 = "";
            if (ayq()) {
                str2 = this.yvJ.field_chatName;
            }
            h.a(this.mController.xRr, getString(R.l.eFZ), str2, "", 32, new h.b() {
                public final boolean v(CharSequence charSequence) {
                    return BizChatroomInfoUI.a(BizChatroomInfoUI.this, str2, charSequence);
                }
            });
        } else if (str.equals("room_notify_new_msg")) {
            this.kYN = !this.kYN;
            x(this.kYN, 1);
            ayn();
        } else if (str.equals("room_placed_to_the_top")) {
            if (this.yxo) {
                z = false;
            }
            this.yxo = z;
            x(this.yxo, 16);
            if (this.yxo) {
                y.Mo().aX(this.yvJ.field_bizChatLocalId);
            } else {
                y.Mo().aY(this.yvJ.field_bizChatLocalId);
            }
        } else if (str.equals("room_del_quit")) {
            x.d("MicroMsg.BizChatroomInfoUI", " quit " + this.kMn);
            h.a(this.mController.xRr, getString(R.l.dYA), "", new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    BizChatroomInfoUI.d(BizChatroomInfoUI.this);
                }
            }, null);
        } else if (str.equals("room_save_to_contact")) {
            if (this.yxn) {
                z = false;
            }
            this.yxn = z;
            x(this.yxn, 8);
            crD();
        }
        return false;
    }

    private void x(boolean z, int i) {
        this.yxp = this.yvJ.field_bitFlag;
        this.yxl = this.yvJ.field_chatName;
        if (this.yxm) {
            c cVar;
            if (z) {
                cVar = this.yvJ;
                cVar.field_bitFlag |= i;
            } else {
                cVar = this.yvJ;
                cVar.field_bitFlag &= i ^ -1;
            }
            x.i("MicroMsg.BizChatroomInfoUI", "dealSetMute:bitFlag %s", Integer.valueOf(this.yvJ.field_bitFlag));
            y.Mn().b(this.yvJ);
        } else {
            j jVar;
            if (z) {
                jVar = this.poq;
                jVar.field_bitFlag |= i;
            } else {
                jVar = this.poq;
                jVar.field_bitFlag &= i ^ -1;
            }
            y.Mp().b(this.poq);
            this.yvJ.field_bitFlag = this.poq.field_bitFlag;
            y.Mn().b(this.yvJ);
        }
        hp hpVar = new hp();
        hpVar.vUb = this.yvJ.field_bizChatServId;
        hpVar.vUd = this.yvJ.field_bitFlag;
        y.Mr();
        com.tencent.mm.af.a.h.a(this.yvJ.field_brandUserName, hpVar, (n) this);
    }

    public final j FF(int i) {
        if (this.lfs.getItem(i) instanceof j) {
            return (j) this.lfs.getItem(i);
        }
        return null;
    }

    private void ayl() {
        if (this.lfs != null) {
            List ba;
            if (this.yxm) {
                ba = com.tencent.mm.af.a.e.ba(this.kMn);
            } else {
                ba = new LinkedList();
                ba.add(this.yvJ.field_bizChatServId);
            }
            if (ba != null) {
                this.lfC = ba.size();
            } else {
                this.lfC = 0;
            }
            if (this.lfC <= 1) {
                this.lfs.lh(true).li(false);
            } else {
                this.lfs.lh(true).li(this.lfB);
            }
            this.lfs.n(this.kMt, ba);
        }
    }

    private void crD() {
        x.d("MicroMsg.BizChatroomInfoUI", "updateSaveToContact()");
        if (this.hbz == null) {
            this.hbz = getSharedPreferences(getPackageName() + "_preferences", 0);
        }
        if (this.yxm) {
            this.yxn = this.yvJ.hr(8);
            this.yxp = this.yvJ.field_bitFlag;
        } else {
            this.yxn = this.poq.hr(8);
            this.yxp = this.poq.field_bitFlag;
        }
        if (this.yxn) {
            if (this.lfu != null) {
                this.hbz.edit().putBoolean("room_save_to_contact", true).commit();
            }
        } else if (this.lfu != null) {
            this.hbz.edit().putBoolean("room_save_to_contact", false).commit();
        }
        this.inW.notifyDataSetChanged();
    }

    private void bke() {
        x.d("MicroMsg.BizChatroomInfoUI", "updatePlaceTop()");
        if (this.hbz == null) {
            this.hbz = getSharedPreferences(getPackageName() + "_preferences", 0);
        }
        if (this.yxm) {
            this.yxo = this.yvJ.hr(16);
            this.yxp = this.yvJ.field_bitFlag;
        } else {
            this.yxo = this.poq.hr(16);
            this.yxp = this.poq.field_bitFlag;
        }
        if (this.lfv != null) {
            this.hbz.edit().putBoolean("room_placed_to_the_top", this.yxo).commit();
        }
        this.inW.notifyDataSetChanged();
    }

    private void ayn() {
        if (this.hbz == null) {
            this.hbz = getSharedPreferences(getPackageName() + "_preferences", 0);
        }
        if (this.yxm) {
            this.kYN = this.yvJ.hr(1);
            this.yxp = this.yvJ.field_bitFlag;
        } else {
            this.kYN = this.poq.hr(1);
            this.yxp = this.poq.field_bitFlag;
        }
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

    private void ayp() {
        if (this.lfo == null) {
            return;
        }
        if (ayq()) {
            CharSequence charSequence = this.yvJ.field_chatName;
            if (charSequence != null && charSequence.length() > 50) {
                charSequence = charSequence.substring(0, 32);
            }
            x.i("MicroMsg.BizChatroomInfoUI", "updateRoomName chatName:%s", charSequence);
            SignaturePreference signaturePreference = this.lfo;
            if (charSequence == null || charSequence.length() <= 0) {
                charSequence = getString(R.l.eNn);
            }
            signaturePreference.setSummary(com.tencent.mm.pluginsdk.ui.d.i.a((Context) this, charSequence));
            return;
        }
        this.lfo.setSummary(getString(R.l.eFJ));
    }

    private void updateTitle() {
        if (this.yxm) {
            this.lfC = com.tencent.mm.af.a.e.aZ(this.kMn);
            if (this.lfC != 0) {
                setMMTitle(getString(R.l.eiH, new Object[]{getString(R.l.eGM), Integer.valueOf(this.lfC)}));
                return;
            }
        }
        setMMTitle(getString(R.l.eGM));
    }

    private boolean ayq() {
        if (bi.oN(this.yxm ? this.yvJ.field_chatName : this.poq.field_userName)) {
            return false;
        }
        return true;
    }

    public final void a(int i, k kVar) {
        if (this.inI != null) {
            this.inI.dismiss();
            this.inI = null;
        }
        if (kVar.getType() == 1355) {
            pt MF = ((com.tencent.mm.af.a.n) kVar).MF();
            ps MG = ((com.tencent.mm.af.a.n) kVar).MG();
            c ko = y.Mn().ko(MF.wfx.wnN.vUb);
            Intent intent;
            if (ko == null) {
                Toast.makeText(ad.getContext(), getString(R.l.eFf), 0).show();
            } else if (this.fromScene == 2) {
                intent = new Intent();
                intent.addFlags(67108864);
                intent.putExtra("biz_chat_need_to_jump_to_chatting_ui", true);
                intent.putExtra("Contact_User", MG.vUh);
                intent.putExtra("biz_chat_chat_id", ko.field_bizChatLocalId);
                com.tencent.mm.bl.d.a((Context) this, ".ui.bizchat.BizChatConversationUI", intent);
            } else {
                intent = new Intent();
                intent.addFlags(67108864);
                intent.putExtra("Chat_User", MG.vUh);
                intent.putExtra("key_biz_chat_id", ko.field_bizChatLocalId);
                intent.putExtra("finish_direct", true);
                intent.putExtra("key_need_send_video", false);
                intent.putExtra("key_is_biz_chat", true);
                com.tencent.mm.plugin.chatroom.a.ihN.e(intent, (Context) this);
            }
        } else if (kVar.getType() == 1356) {
            if (i != 0) {
                crF();
            }
        } else if (kVar.getType() == 1353 && i >= 0 && this.poq != null) {
            this.poq = y.Mp().ca(this.poq.field_userId);
            crE();
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar == null) {
            x.e("MicroMsg.BizChatroomInfoUI", "onSceneEnd: [%d], [%d], [%s], scene is null", Integer.valueOf(i), Integer.valueOf(i2), str);
            return;
        }
        x.i("MicroMsg.BizChatroomInfoUI", "onSceneEnd: [%d], [%d], [%s], sceneType[%d]", Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(kVar.getType()));
        this.lfC = com.tencent.mm.af.a.e.aZ(this.kMn);
        x.d("MicroMsg.BizChatroomInfoUI", "now is " + this.lfC);
        if (this.inI != null) {
            this.inI.dismiss();
        }
        com.tencent.mm.g.a eC = com.tencent.mm.g.a.eC(str);
        if (eC != null) {
            eC.a(this, null, null);
        } else if (i == 0 && i2 == 0) {
            kVar.getType();
        } else {
            x.w("MicroMsg.BizChatroomInfoUI", "willen onSceneEnd err:Network not ok");
            crF();
        }
    }

    private void crE() {
        if (this.lfs != null) {
            ayp();
            updateTitle();
            ayn();
            ayl();
            crD();
            bke();
            this.lfs.notifyChanged();
        }
        this.inW.notifyDataSetChanged();
    }

    private void crF() {
        x.i("MicroMsg.BizChatroomInfoUI", "dealModChatNameFail reset bizChatName");
        this.yvJ.field_chatName = this.yxl;
        this.yvJ.field_bitFlag = this.yxp;
        this.kYN = this.yvJ.hr(1);
        this.yxn = this.yvJ.hr(8);
        this.yxo = this.yvJ.hr(16);
        y.Mn().b(this.yvJ);
        if (this.yxo) {
            y.Mo().aX(this.yvJ.field_bizChatLocalId);
        } else if (!this.yxo) {
            y.Mo().aY(this.yvJ.field_bizChatLocalId);
        }
        this.hbz.edit().putBoolean("room_placed_to_the_top", y.Mo().aW(this.yvJ.field_bizChatLocalId)).commit();
        ayp();
        ayn();
        bke();
        crD();
        Toast.makeText(this, getString(R.l.eFg), 0).show();
    }

    public final com.tencent.mm.ui.base.preference.h a(SharedPreferences sharedPreferences) {
        return new com.tencent.mm.ui.base.preference.a(this, sharedPreferences);
    }
}
