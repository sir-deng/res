package com.tencent.mm.plugin.chatroom.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.ax.p;
import com.tencent.mm.f.a.hb;
import com.tencent.mm.f.a.ka;
import com.tencent.mm.f.a.ll;
import com.tencent.mm.f.a.oz;
import com.tencent.mm.f.a.rk;
import com.tencent.mm.f.a.se;
import com.tencent.mm.plugin.appbrand.ui.widget.AppBrandLoadIconPreference;
import com.tencent.mm.plugin.report.kvdata.IMBehavior;
import com.tencent.mm.plugin.report.kvdata.IMBehaviorChattingOP;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.q.l;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.applet.h;
import com.tencent.mm.pluginsdk.ui.applet.i;
import com.tencent.mm.pluginsdk.ui.d;
import com.tencent.mm.pluginsdk.ui.preference.RoomCardPreference;
import com.tencent.mm.pluginsdk.ui.preference.SignaturePreference;
import com.tencent.mm.protocal.c.aba;
import com.tencent.mm.protocal.c.aox;
import com.tencent.mm.protocal.c.ary;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.bf;
import com.tencent.mm.storage.q;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.NormalIconPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bb;
import com.tencent.mm.y.m;
import com.tencent.mm.y.s;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class ChatroomInfoUI extends MMPreference implements e, l, com.tencent.mm.sdk.e.j.a, b {
    private static boolean lfU = false;
    private boolean fAu;
    private ag handler = new ag(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            ChatroomInfoUI.a(ChatroomInfoUI.this);
        }
    };
    private SharedPreferences hbz = null;
    private String iTE;
    private ProgressDialog inI = null;
    private f inW;
    private r ioc = null;
    private boolean isDeleteCancel = false;
    private x jQP;
    private boolean kYN;
    private boolean lfA;
    private boolean lfB = false;
    private int lfC;
    private boolean lfD = false;
    private q lfE = null;
    private int lfF = -1;
    private boolean lfG = true;
    private boolean lfH = false;
    private d lfI = new d(new OnScrollListener() {
        public final void onScrollStateChanged(AbsListView absListView, int i) {
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    });
    boolean lfJ = false;
    private c lfK = new c<hb>() {
        {
            this.xmG = hb.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            if (((hb) bVar) instanceof hb) {
                ChatroomInfoUI.this.ayf();
            }
            return false;
        }
    };
    int lfL = -1;
    private boolean lfM = false;
    private com.tencent.mm.plugin.messenger.foundation.a.a.e.a lfN;
    int lfO;
    String lfP;
    private c lfQ = new c<ll>() {
        {
            this.xmG = ll.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            ll llVar = (ll) bVar;
            CharSequence charSequence = llVar.fDF.fDH;
            int i = llVar.fDF.ret;
            if (i == 0 || charSequence == null) {
                if (i == 0 && ChatroomInfoUI.this.lfM) {
                    if (ChatroomInfoUI.this.lfO == 27) {
                        com.tencent.mm.sdk.b.a.xmy.m(new se());
                        ChatroomInfoUI.this.jQP.dc(ChatroomInfoUI.this.lfP);
                        as.Hm();
                        com.tencent.mm.y.c.Ff().R(ChatroomInfoUI.this.jQP);
                        ChatroomInfoUI.this.ayp();
                    } else if (ChatroomInfoUI.this.lfO == 48 && ChatroomInfoUI.this.lfE != null) {
                        ChatroomInfoUI.this.lfE.field_chatroomname = ChatroomInfoUI.this.iTE;
                        ChatroomInfoUI.this.lfE.field_selfDisplayName = ChatroomInfoUI.this.lfT;
                        as.Hm();
                        com.tencent.mm.y.c.Fo().c(ChatroomInfoUI.this.lfE, new String[0]);
                        ChatroomInfoUI.this.aym();
                    }
                }
            } else if (ChatroomInfoUI.this.lfN != null && ChatroomInfoUI.this.lfO == 27) {
                as.Hm();
                com.tencent.mm.y.c.Fe().c(ChatroomInfoUI.this.lfN);
            } else if (ChatroomInfoUI.this.lfS != null && ChatroomInfoUI.this.lfO == 48) {
                as.Hm();
                com.tencent.mm.y.c.Fe().c(ChatroomInfoUI.this.lfS);
                Toast.makeText(ChatroomInfoUI.this.mController.xRr, charSequence, 1).show();
            }
            if (ChatroomInfoUI.this.ioc != null) {
                ChatroomInfoUI.this.ioc.dismiss();
            }
            return false;
        }
    };
    private String lfR = "";
    private com.tencent.mm.plugin.messenger.foundation.a.a.e.a lfS;
    private String lfT;
    private String lfV = null;
    private com.tencent.mm.pluginsdk.d.b lfW = new com.tencent.mm.pluginsdk.d.b() {
        public final void a(int i, int i2, String str, com.tencent.mm.sdk.b.b bVar) {
            if (bVar instanceof ka) {
                ka kaVar = (ka) bVar;
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChatroomInfoUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
                if (ChatroomInfoUI.this.inI != null) {
                    ChatroomInfoUI.this.inI.dismiss();
                }
                if (i == 0 && i2 == 0) {
                    if (i == 0 && i2 == 0 && ChatroomInfoUI.this.lfs != null) {
                        ArrayList as = ChatroomInfoUI.as(kaVar.fCg.fBS);
                        ContactListExpandPreference m = ChatroomInfoUI.this.lfs;
                        if (m.vuT != null) {
                            h hVar = m.vuT.vuf;
                            hVar.ac(as);
                            hVar.notifyChanged();
                        }
                        if (ChatroomInfoUI.this.inW != null) {
                            ChatroomInfoUI.this.inW.notifyDataSetChanged();
                        }
                        ChatroomInfoUI.this.setMMTitle(ChatroomInfoUI.this.getResources().getQuantityString(R.j.duT, as.size(), new Object[]{Integer.valueOf(as.size())}));
                    }
                    ChatroomInfoUI.this.updateTitle();
                } else if (i2 == -21) {
                    com.tencent.mm.ui.base.h.a(ChatroomInfoUI.this, ChatroomInfoUI.this.getString(R.l.eFM), ChatroomInfoUI.this.getString(R.l.dGZ), new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            ChatroomInfoUI.this.finish();
                        }
                    });
                } else {
                    com.tencent.mm.ui.base.h.b(ChatroomInfoUI.this, ChatroomInfoUI.this.getString(R.l.eFO), ChatroomInfoUI.this.getString(R.l.dGZ), true);
                }
            }
        }
    };
    private boolean lfm;
    private RoomCardPreference lfn;
    private SignaturePreference lfo;
    private Preference lfp;
    private NormalIconPreference lfq;
    private NormalIconPreference lfr;
    private ContactListExpandPreference lfs;
    private CheckBoxPreference lft;
    private CheckBoxPreference lfu;
    private CheckBoxPreference lfv;
    private SignaturePreference lfw;
    private CheckBoxPreference lfx;
    private AppBrandLoadIconPreference lfy;
    private boolean lfz;

    static class a implements OnCancelListener {
        a() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            ChatroomInfoUI.lfU = true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.chatroom.ui.ChatroomInfoUI$17 */
    class AnonymousClass17 implements OnClickListener {
        final /* synthetic */ ProgressDialog lga;
        final /* synthetic */ boolean lgc = true;

        AnonymousClass17(ProgressDialog progressDialog, boolean z) {
            this.lga = progressDialog;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            g.pWK.h(14553, Integer.valueOf(4), Integer.valueOf(3), ChatroomInfoUI.this.iTE);
            this.lga.show();
            ChatroomInfoUI.this.isDeleteCancel = false;
            ChatroomInfoUI.this.el(this.lgc);
        }
    }

    static /* synthetic */ void a(ka kaVar) {
        kaVar.fCf.fBE = true;
        com.tencent.mm.sdk.b.a.xmy.m(kaVar);
    }

    static /* synthetic */ void a(ChatroomInfoUI chatroomInfoUI) {
        chatroomInfoUI.updateTitle();
        as.Hm();
        String hJ = com.tencent.mm.y.c.Fo().hJ(chatroomInfoUI.iTE);
        if (chatroomInfoUI.lfV != null && !chatroomInfoUI.lfV.equals(hJ)) {
            chatroomInfoUI.ayr();
        }
    }

    static /* synthetic */ void a(ChatroomInfoUI chatroomInfoUI, String str) {
        g.pWK.a(219, 4, 1, true);
        chatroomInfoUI.lfT = str;
        String FY = com.tencent.mm.y.q.FY();
        com.tencent.mm.bp.a ary = new ary();
        ary.wfN = chatroomInfoUI.iTE;
        ary.kyG = FY;
        ary.wbX = bi.oM(str);
        chatroomInfoUI.lfS = new com.tencent.mm.plugin.messenger.foundation.a.a.e.a(48, ary);
        chatroomInfoUI.lfO = 48;
        Context context = chatroomInfoUI.mController.xRr;
        chatroomInfoUI.getString(R.l.dGZ);
        chatroomInfoUI.ioc = com.tencent.mm.ui.base.h.a(context, chatroomInfoUI.getString(R.l.dUO), false, null);
        chatroomInfoUI.lfM = true;
        as.Hm();
        com.tencent.mm.y.c.Fe().b(chatroomInfoUI.lfS);
    }

    static /* synthetic */ boolean a(ChatroomInfoUI chatroomInfoUI, int i, int i2, String str) {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChatroomInfoUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChatroomInfoUI", "pre is " + chatroomInfoUI.lfC);
        chatroomInfoUI.lfC = m.gn(chatroomInfoUI.iTE);
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChatroomInfoUI", "now is " + chatroomInfoUI.lfC);
        if (chatroomInfoUI.inI != null) {
            chatroomInfoUI.inI.dismiss();
        }
        com.tencent.mm.g.a eC = com.tencent.mm.g.a.eC(str);
        if (eC == null) {
            return false;
        }
        eC.a(chatroomInfoUI, null, null);
        return true;
    }

    static /* synthetic */ void y(ChatroomInfoUI chatroomInfoUI) {
        g.pWK.h(14553, Integer.valueOf(4), Integer.valueOf(2), chatroomInfoUI.iTE);
        as.Hm();
        long j = com.tencent.mm.y.c.Fh().Fc(chatroomInfoUI.iTE).field_msgSvrId;
        as.Hm();
        com.tencent.mm.y.c.Fe().b(new com.tencent.mm.ax.d(chatroomInfoUI.iTE, j));
        chatroomInfoUI.isDeleteCancel = false;
        chatroomInfoUI.getString(R.l.dGZ);
        ProgressDialog a = com.tencent.mm.ui.base.h.a((Context) chatroomInfoUI, chatroomInfoUI.getString(R.l.dHn), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                ChatroomInfoUI.this.isDeleteCancel = true;
            }
        });
        if (bi.oN(!chatroomInfoUI.isDeleteCancel ? com.tencent.mm.pluginsdk.wallet.e.TE(chatroomInfoUI.jQP.field_username) : null)) {
            chatroomInfoUI.el(true);
            return;
        }
        a.dismiss();
        Object[] objArr = new Object[]{r0};
        com.tencent.mm.ui.base.h.a(chatroomInfoUI, false, chatroomInfoUI.getString(R.l.eWw, objArr), null, chatroomInfoUI.getString(R.l.enQ), chatroomInfoUI.getString(R.l.eFm), new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                g.pWK.h(14553, Integer.valueOf(4), Integer.valueOf(4), ChatroomInfoUI.this.iTE);
                ChatroomInfoUI.this.isDeleteCancel = true;
                if (ChatroomInfoUI.this.lfH) {
                    ChatroomInfoUI.this.finish();
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra("Chat_User", ChatroomInfoUI.this.jQP.field_username);
                intent.addFlags(67108864);
                com.tencent.mm.bl.d.a(ChatroomInfoUI.this, ".ui.chatting.ChattingUI", intent);
            }
        }, new AnonymousClass17(a, true), -1, R.e.brm);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        as.CN().a(223, (e) this);
        as.CN().a(179, (e) this);
        as.CN().a(480, (e) this);
        as.CN().a(610, (e) this);
        com.tencent.mm.pluginsdk.d.b.a(ka.class.getName(), this.lfW);
        this.lfK.cfB().a(this);
        this.lfQ.cfB().a(this);
        as.Hm();
        com.tencent.mm.y.c.Ff().a(this);
        as.Hm();
        com.tencent.mm.y.c.Fo().c(this);
        if (com.tencent.mm.pluginsdk.q.a.viX != null) {
            com.tencent.mm.pluginsdk.q.a.viX.a(this);
        }
        this.iTE = getIntent().getStringExtra("RoomInfo_Id");
        as.Hm();
        this.jQP = com.tencent.mm.y.c.Ff().Xv(this.iTE);
        this.lfG = true;
        this.fAu = getIntent().getBooleanExtra("Is_Chatroom", true);
        this.lfm = getIntent().getBooleanExtra("Is_Lbsroom", false);
        this.lfH = getIntent().getBooleanExtra("fromChatting", false);
        this.lfR = getPackageName() + "_preferences";
        if (this.fAu) {
            as.Hm();
            this.lfE = com.tencent.mm.y.c.Fo().hG(this.iTE);
        }
        initView();
        if (this.fAu) {
            final com.tencent.mm.y.ak.b.a anonymousClass22 = new com.tencent.mm.y.ak.b.a() {
                public final void v(final String str, boolean z) {
                    if (z && ChatroomInfoUI.this.iTE.equals(str)) {
                        as.Dt().F(new Runnable() {
                            public final void run() {
                                as.Hm();
                                com.tencent.mm.y.c.Fo().l(str, System.currentTimeMillis());
                            }

                            public final String toString() {
                                return super.toString() + "|getContactCallBack";
                            }
                        });
                    }
                }
            };
            if (this.lfE == null) {
                com.tencent.mm.y.ak.a.hhv.a(this.iTE, "", anonymousClass22);
            } else if (System.currentTimeMillis() - this.lfE.field_modifytime >= 86400000) {
                as.Dt().F(new Runnable() {
                    public final void run() {
                        com.tencent.mm.y.ak.a.hhv.a(ChatroomInfoUI.this.lfE.field_chatroomname, "", anonymousClass22);
                    }

                    public final String toString() {
                        return super.toString() + "|getContactCallBack2";
                    }
                });
            }
        }
    }

    private void ayf() {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChatroomInfoUI", "[doChatroomDetailCgi] :%s", this.iTE);
        new com.tencent.mm.plugin.chatroom.d.c(this.iTE).Kb().c((com.tencent.mm.vending.e.b) this).g(new com.tencent.mm.vending.c.a<com.tencent.mm.ad.a.a<aba>, com.tencent.mm.ad.a.a<aba>>() {
            public final /* synthetic */ Object call(Object obj) {
                com.tencent.mm.ad.a.a aVar = (com.tencent.mm.ad.a.a) obj;
                if (ChatroomInfoUI.a(ChatroomInfoUI.this, aVar.errType, aVar.errCode, aVar.foE)) {
                    return null;
                }
                int i = aVar.errType;
                int i2 = aVar.errCode;
                if (i != 0 || i2 != 0) {
                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ChatroomInfoUI", "[doChatroomDetailCgi] roomId:%s", ChatroomInfoUI.this.iTE);
                    return null;
                } else if (i != 0 || i2 != 0) {
                    return aVar;
                } else {
                    String str = ((aba) aVar.fKE).wqJ;
                    int i3 = ((aba) aVar.fKE).wqK;
                    long j = (long) ((aba) aVar.fKE).wqM;
                    String str2 = ((aba) aVar.fKE).wqL;
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChatroomInfoUI", "dz[onSceneEnd : get announcement successfully!] roomId:%s newVersion:%s AnnouncementPublishTime:%s", ChatroomInfoUI.this.iTE, Integer.valueOf(i3), Long.valueOf(j));
                    m.a(ChatroomInfoUI.this.iTE, bi.oM(str), str2, j, i3);
                    return aVar;
                }
            }
        }).i(new com.tencent.mm.vending.c.a<Void, com.tencent.mm.ad.a.a<aba>>() {
            public final /* synthetic */ Object call(Object obj) {
                com.tencent.mm.ad.a.a aVar = (com.tencent.mm.ad.a.a) obj;
                if (aVar == null) {
                    return zLb;
                }
                int i = aVar.errType;
                int i2 = aVar.errCode;
                if (i == 0 && i2 == 0) {
                    if (ChatroomInfoUI.this.lfE != null) {
                        ChatroomInfoUI.this.lfC = ChatroomInfoUI.this.lfE.My().size();
                    }
                    if ((!ChatroomInfoUI.this.lfB && ChatroomInfoUI.this.lfC >= h.vuo) || (ChatroomInfoUI.this.lfB && ChatroomInfoUI.this.lfC >= h.vuo - 1)) {
                        ChatroomInfoUI.this.inW.bl("see_room_member", false);
                        ChatroomInfoUI.this.lfp.setTitle(ChatroomInfoUI.this.getString(R.l.eJs));
                    }
                }
                ChatroomInfoUI.this.ayo();
                ChatroomInfoUI.this.ayp();
                ChatroomInfoUI.this.updateTitle();
                return zLb;
            }
        });
    }

    public void onResume() {
        boolean E;
        String stringExtra;
        super.onResume();
        as.CN().a(120, (e) this);
        this.inW.notifyDataSetChanged();
        if (this.lfE != null) {
            com.tencent.mm.h.a.a.a ciJ = this.lfE.ciJ();
            if (ciJ != null) {
                E = m.E(this.lfE.field_chatroomname, ciJ.gDs);
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChatroomInfoUI", "roomId:%s newVer:%s localVer:%s owner:%s", this.lfE.field_chatroomname, Integer.valueOf(ciJ.gDs), Integer.valueOf(this.lfE.field_chatroomVersion), this.lfE.field_roomowner);
                if (m.gg(this.iTE) || E) {
                    ayf();
                }
                ayo();
                updateTitle();
                ayn();
                if (this.fAu) {
                    ayp();
                    aym();
                }
                if (this.lfG) {
                    ayl();
                    this.lfG = false;
                }
                stringExtra = getIntent().getStringExtra("need_matte_high_light_item");
                if (!this.lfJ) {
                    if (!bi.oN(stringExtra)) {
                        xI(stringExtra);
                    }
                    this.lfJ = true;
                }
                if (!bi.oN(stringExtra) && stringExtra.equals("room_notify_new_notice") && !this.lfJ) {
                    xI("room_card");
                    this.lfJ = true;
                    return;
                }
                return;
            }
        }
        E = false;
        ayf();
        ayo();
        updateTitle();
        ayn();
        if (this.fAu) {
            ayp();
            aym();
        }
        if (this.lfG) {
            ayl();
            this.lfG = false;
        }
        stringExtra = getIntent().getStringExtra("need_matte_high_light_item");
        if (this.lfJ) {
            if (bi.oN(stringExtra)) {
                xI(stringExtra);
            }
            this.lfJ = true;
        }
        if (!bi.oN(stringExtra)) {
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.lfs.notifyChanged();
    }

    private void xI(String str) {
        final int Zw = this.inW.Zw(str);
        this.nQn.smoothScrollToPosition(Zw);
        new ag().postDelayed(new Runnable() {
            public final void run() {
                View a = ((com.tencent.mm.ui.base.preference.a) ChatroomInfoUI.this.inW).a(Zw, ChatroomInfoUI.this.nQn);
                if (a != null) {
                    com.tencent.mm.ui.g.a.b(ChatroomInfoUI.this.mController.xRr, a);
                }
            }
        }, 10);
    }

    public void onPause() {
        super.onPause();
        as.CN().b(120, (e) this);
        if (this.lfD && this.fAu && this.lfE != null) {
            m.a(this.iTE, this.lfE, this.lfz);
        }
    }

    public void onDestroy() {
        if (com.tencent.mm.pluginsdk.q.a.viX != null) {
            com.tencent.mm.pluginsdk.q.a.viX.a(this);
        }
        com.tencent.mm.ui.g.a.dismiss();
        as.CN().b(223, (e) this);
        as.CN().b(179, (e) this);
        as.CN().b(480, (e) this);
        as.CN().b(610, (e) this);
        com.tencent.mm.sdk.b.a.xmy.c(this.lfQ);
        com.tencent.mm.sdk.b.a.xmy.c(this.lfK);
        com.tencent.mm.pluginsdk.d.b.b(ka.class.getName(), this.lfW);
        if (as.Hp()) {
            as.Hm();
            com.tencent.mm.y.c.Ff().b(this);
            as.Hm();
            com.tencent.mm.y.c.Fo().j(this);
        }
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
        final String stringExtra;
        switch (i) {
            case 1:
                if (intent != null) {
                    stringExtra = intent.getStringExtra("Select_Contact");
                    as.Hm();
                    q hG = com.tencent.mm.y.c.Fo().hG(this.iTE);
                    if (hG == null) {
                        return;
                    }
                    if (hG.ciG() != 2 || this.lfB) {
                        p(stringExtra, null, R.l.dCP);
                        return;
                    } else {
                        com.tencent.mm.pluginsdk.ui.applet.e.b(this.mController, getString(R.l.eEO), getString(R.l.eCz), getString(R.l.dGL), new com.tencent.mm.pluginsdk.ui.applet.o.a() {
                            public final void a(boolean z, String str, int i) {
                                if (z) {
                                    ChatroomInfoUI.this.p(stringExtra, str, R.l.eqm);
                                }
                            }
                        });
                        return;
                    }
                }
                return;
            case 2:
                if (i2 == -1) {
                    finish();
                    return;
                }
                return;
            case 4:
                if (i2 == -1) {
                    stringExtra = intent.getStringExtra("room_name");
                    if (!bi.oN(stringExtra)) {
                        com.tencent.mm.sdk.b.a.xmy.m(new se());
                        this.jQP.dc(stringExtra);
                        as.Hm();
                        com.tencent.mm.y.c.Ff().R(this.jQP);
                        ayp();
                        return;
                    }
                    return;
                }
                return;
            case 5:
                if (i2 == 0) {
                    this.lfL = -1;
                    return;
                }
                return;
            case 7:
                if (intent != null) {
                    stringExtra = intent.getStringExtra("Select_Contact");
                    if (stringExtra != null && !stringExtra.equals("")) {
                        final k gVar = new com.tencent.mm.plugin.chatroom.d.g(this.iTE, bi.F(stringExtra.split(",")));
                        getString(R.l.dGZ);
                        this.inI = com.tencent.mm.ui.base.h.a((Context) this, getString(R.l.eFl), true, new OnCancelListener() {
                            public final void onCancel(DialogInterface dialogInterface) {
                                as.CN().c(gVar);
                            }
                        });
                        as.CN().a(gVar, 0);
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final int XK() {
        return R.o.fco;
    }

    protected final void initView() {
        this.inW = this.yrJ;
        String str;
        if (this.fAu) {
            com.tencent.mm.f.b.ag Xv;
            q hG;
            if (this.lfC == 0) {
                setMMTitle(getString(R.l.eGM));
            } else {
                if (this.lfE != null) {
                    this.lfC = this.lfE.My().size();
                }
                setMMTitle(getString(R.l.eiH, new Object[]{getString(R.l.eGM), Integer.valueOf(this.lfC)}));
            }
            str = null;
            if (this.lfE != null) {
                str = this.lfE.field_roomowner;
                this.lfC = this.lfE.My().size();
            }
            if (bi.oN(str)) {
                this.lfA = false;
                this.lfB = false;
            } else {
                this.lfA = true;
                this.lfB = str.equals(com.tencent.mm.y.q.FY());
            }
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChatroomInfoUI", "initBaseChatRoomView()");
            this.lfs = (ContactListExpandPreference) this.inW.Zu("roominfo_contact_anchor");
            this.lfs.a(this.inW, this.lfs.idX);
            this.lfr = (NormalIconPreference) this.inW.Zu("del_selector_btn");
            this.lfq = (NormalIconPreference) this.inW.Zu("add_selector_btn");
            this.lfo = (SignaturePreference) this.inW.Zu("room_name");
            this.lfn = (RoomCardPreference) this.inW.Zu("room_card");
            this.lfp = this.inW.Zu("see_room_member");
            this.lft = (CheckBoxPreference) this.inW.Zu("room_notify_new_msg");
            this.lfu = (CheckBoxPreference) this.inW.Zu("room_save_to_contact");
            this.lfv = (CheckBoxPreference) this.inW.Zu("room_placed_to_the_top");
            this.lfw = (SignaturePreference) this.inW.Zu("room_nickname");
            this.lfs.lh(true).li(true).cbM();
            if (!this.lfB) {
                this.inW.bl("del_selector_btn", true);
            } else if (m.gn(this.iTE) > 2) {
                this.inW.bl("manage_room", false);
                if (this.lfE != null) {
                    this.lfs.SY(this.lfE.field_roomowner);
                    if (!bi.oN(this.lfE.field_roomowner)) {
                        this.lfs.vuT.vuf.vuJ = true;
                    }
                }
                this.lfs.cbK();
                this.lfs.cbN();
                this.inW.bl("add_selector_btn", true);
                this.inW.bl("del_selector_btn", true);
                this.inW.bl("room_name", false);
                this.inW.bl("room_qr_code", false);
                this.inW.bl("chatroom_info_chexboxes", true);
                this.inW.bl("room_card", false);
                this.inW.bl("room_upgrade_entry", true);
                if ((!this.lfB || this.lfC < h.vuo) && (!this.lfB || this.lfC < h.vuo - 1)) {
                    this.inW.bl("see_room_member", true);
                } else {
                    this.inW.bl("see_room_member", false);
                    this.lfp.setTitle(getString(R.l.eJs, new Object[]{Integer.valueOf(this.lfC)}));
                }
                this.lfy = (AppBrandLoadIconPreference) this.inW.Zu("chat_room_app_brand");
                this.lfy.jXh = this.iTE;
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChatroomInfoUI", "updatePlaceTop()");
                if (this.hbz == null) {
                    this.hbz = getSharedPreferences(getPackageName() + "_preferences", 0);
                }
                if (this.lfv != null) {
                    if (this.jQP == null) {
                        as.Hm();
                        this.hbz.edit().putBoolean("room_placed_to_the_top", com.tencent.mm.y.c.Fk().XM(this.jQP.field_username)).commit();
                    } else {
                        this.hbz.edit().putBoolean("room_placed_to_the_top", false).commit();
                    }
                }
                this.inW.notifyDataSetChanged();
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChatroomInfoUI", "updateSaveToContact()");
                if (this.hbz == null) {
                    this.hbz = getSharedPreferences(getPackageName() + "_preferences", 0);
                }
                if (this.lfu != null) {
                    as.Hm();
                    Xv = com.tencent.mm.y.c.Ff().Xv(this.iTE);
                    if (Xv != null) {
                        com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ChatroomInfoUI", "contact == null !!!");
                        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChatroomInfoUI", "updateDisplayNickname()");
                        if (this.hbz == null) {
                            this.hbz = getSharedPreferences(getPackageName() + "_preferences", 0);
                        }
                        as.Hm();
                        hG = com.tencent.mm.y.c.Fo().hG(this.iTE);
                        if (hG != null) {
                            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ChatroomInfoUI", "members == null !!!");
                        } else {
                            this.lfz = hG.ciI();
                            this.lfx = (CheckBoxPreference) this.inW.Zu("room_msg_show_username");
                            if (this.lfx != null) {
                                this.hbz.edit().putBoolean("room_msg_show_username", this.lfz).commit();
                            }
                            this.inW.notifyDataSetChanged();
                        }
                        as.Hm();
                        this.lfF = com.tencent.mm.y.c.Fh().Fv(this.iTE);
                    } else {
                        this.hbz.edit().putBoolean("room_save_to_contact", com.tencent.mm.k.a.ga(Xv.field_type)).commit();
                    }
                }
                this.inW.notifyDataSetChanged();
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChatroomInfoUI", "updateDisplayNickname()");
                if (this.hbz == null) {
                    this.hbz = getSharedPreferences(getPackageName() + "_preferences", 0);
                }
                as.Hm();
                hG = com.tencent.mm.y.c.Fo().hG(this.iTE);
                if (hG != null) {
                    this.lfz = hG.ciI();
                    this.lfx = (CheckBoxPreference) this.inW.Zu("room_msg_show_username");
                    if (this.lfx != null) {
                        this.hbz.edit().putBoolean("room_msg_show_username", this.lfz).commit();
                    }
                    this.inW.notifyDataSetChanged();
                } else {
                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ChatroomInfoUI", "members == null !!!");
                }
                as.Hm();
                this.lfF = com.tencent.mm.y.c.Fh().Fv(this.iTE);
            }
            this.inW.bl("manage_room", true);
            if (this.lfE != null) {
                this.lfs.SY(this.lfE.field_roomowner);
                if (bi.oN(this.lfE.field_roomowner)) {
                    this.lfs.vuT.vuf.vuJ = true;
                }
            }
            this.lfs.cbK();
            this.lfs.cbN();
            this.inW.bl("add_selector_btn", true);
            this.inW.bl("del_selector_btn", true);
            this.inW.bl("room_name", false);
            this.inW.bl("room_qr_code", false);
            this.inW.bl("chatroom_info_chexboxes", true);
            this.inW.bl("room_card", false);
            this.inW.bl("room_upgrade_entry", true);
            if (this.lfB) {
            }
            this.inW.bl("see_room_member", true);
            this.lfy = (AppBrandLoadIconPreference) this.inW.Zu("chat_room_app_brand");
            this.lfy.jXh = this.iTE;
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChatroomInfoUI", "updatePlaceTop()");
            if (this.hbz == null) {
                this.hbz = getSharedPreferences(getPackageName() + "_preferences", 0);
            }
            if (this.lfv != null) {
                if (this.jQP == null) {
                    this.hbz.edit().putBoolean("room_placed_to_the_top", false).commit();
                } else {
                    as.Hm();
                    this.hbz.edit().putBoolean("room_placed_to_the_top", com.tencent.mm.y.c.Fk().XM(this.jQP.field_username)).commit();
                }
            }
            this.inW.notifyDataSetChanged();
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChatroomInfoUI", "updateSaveToContact()");
            if (this.hbz == null) {
                this.hbz = getSharedPreferences(getPackageName() + "_preferences", 0);
            }
            if (this.lfu != null) {
                as.Hm();
                Xv = com.tencent.mm.y.c.Ff().Xv(this.iTE);
                if (Xv != null) {
                    this.hbz.edit().putBoolean("room_save_to_contact", com.tencent.mm.k.a.ga(Xv.field_type)).commit();
                } else {
                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ChatroomInfoUI", "contact == null !!!");
                    com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChatroomInfoUI", "updateDisplayNickname()");
                    if (this.hbz == null) {
                        this.hbz = getSharedPreferences(getPackageName() + "_preferences", 0);
                    }
                    as.Hm();
                    hG = com.tencent.mm.y.c.Fo().hG(this.iTE);
                    if (hG != null) {
                        com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ChatroomInfoUI", "members == null !!!");
                    } else {
                        this.lfz = hG.ciI();
                        this.lfx = (CheckBoxPreference) this.inW.Zu("room_msg_show_username");
                        if (this.lfx != null) {
                            this.hbz.edit().putBoolean("room_msg_show_username", this.lfz).commit();
                        }
                        this.inW.notifyDataSetChanged();
                    }
                    as.Hm();
                    this.lfF = com.tencent.mm.y.c.Fh().Fv(this.iTE);
                }
            }
            this.inW.notifyDataSetChanged();
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChatroomInfoUI", "updateDisplayNickname()");
            if (this.hbz == null) {
                this.hbz = getSharedPreferences(getPackageName() + "_preferences", 0);
            }
            as.Hm();
            hG = com.tencent.mm.y.c.Fo().hG(this.iTE);
            if (hG != null) {
                this.lfz = hG.ciI();
                this.lfx = (CheckBoxPreference) this.inW.Zu("room_msg_show_username");
                if (this.lfx != null) {
                    this.hbz.edit().putBoolean("room_msg_show_username", this.lfz).commit();
                }
                this.inW.notifyDataSetChanged();
            } else {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ChatroomInfoUI", "members == null !!!");
            }
            as.Hm();
            this.lfF = com.tencent.mm.y.c.Fh().Fv(this.iTE);
        } else if (this.lfm) {
            this.lfB = false;
            setMMTitle(getString(R.l.eFP));
            this.lfs = (ContactListExpandPreference) this.inW.Zu("roominfo_contact_anchor");
            this.lfs.a(this.inW, this.lfs.idX);
            this.lfs.lh(false).li(false);
            this.lfs.a(new i.b() {
                public final boolean ou(int i) {
                    return true;
                }
            });
            this.inW.removeAll();
            this.inW.a(new PreferenceCategory(this));
            this.inW.a(this.lfs);
            str = this.iTE;
            final com.tencent.mm.sdk.b.b kaVar = new ka();
            kaVar.fCf.fAi = str;
            com.tencent.mm.sdk.b.a.xmy.m(kaVar);
            getString(R.l.dGZ);
            this.inI = com.tencent.mm.ui.base.h.a((Context) this, getString(R.l.eFN), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    ChatroomInfoUI.a(kaVar);
                }
            });
            this.inW.notifyDataSetChanged();
        }
        if (this.lfs != null) {
            if (!this.fAu && this.lfm) {
                this.lfs.ad(new ArrayList());
            }
            this.nQn.setOnScrollListener(this.lfI);
            this.lfs.a(this.lfI);
            this.lfs.a(new i.b() {
                public final boolean ou(int i) {
                    return true;
                }
            });
            ContactListExpandPreference contactListExpandPreference = this.lfs;
            View.OnClickListener anonymousClass3 = new View.OnClickListener() {
                public final void onClick(View view) {
                }
            };
            if (contactListExpandPreference.vuT != null) {
                contactListExpandPreference.vuT.pMx = anonymousClass3;
            }
            this.lfs.a(new com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a() {
                public final void ov(int i) {
                    ChatroomInfoUI.this.ayi();
                }

                public final void ow(int i) {
                    String Ct = ChatroomInfoUI.this.lfs.Ct(i);
                    String oM = bi.oM(ChatroomInfoUI.this.lfs.Cv(i));
                    if (bi.oN(oM)) {
                        as.Hm();
                        bf FF = com.tencent.mm.y.c.Fg().FF(Ct);
                        if (!(FF == null || bi.oN(FF.field_encryptUsername))) {
                            oM = FF.field_conRemark;
                        }
                    }
                    if (!bi.oN(Ct)) {
                        Intent intent = new Intent();
                        intent.putExtra("Contact_User", Ct);
                        intent.putExtra("Contact_RemarkName", oM);
                        if (ChatroomInfoUI.this.fAu && ChatroomInfoUI.this.lfE != null) {
                            intent.putExtra("Contact_RoomNickname", ChatroomInfoUI.this.lfE.gw(Ct));
                        }
                        intent.putExtra("Contact_Nick", bi.oM(ChatroomInfoUI.this.lfs.Cu(i)));
                        intent.putExtra("Contact_RoomMember", true);
                        intent.putExtra("room_name", ChatroomInfoUI.this.jQP.field_username);
                        as.Hm();
                        com.tencent.mm.f.b.ag Xv = com.tencent.mm.y.c.Ff().Xv(Ct);
                        if (Xv != null && ((int) Xv.gKO) > 0 && com.tencent.mm.k.a.ga(Xv.field_type)) {
                            com.tencent.mm.sdk.b.b ozVar = new oz();
                            ozVar.fHJ.intent = intent;
                            ozVar.fHJ.username = Ct;
                            com.tencent.mm.sdk.b.a.xmy.m(ozVar);
                        }
                        if (ChatroomInfoUI.this.fAu) {
                            g.pWK.a(219, 9, 1, true);
                            if (Xv != null && Xv.ciN()) {
                                g.pWK.k(10298, Xv.field_username + ",14");
                            }
                            intent.putExtra("Contact_Scene", 14);
                        } else if (ChatroomInfoUI.this.lfm) {
                            intent.putExtra("Contact_Scene", 44);
                            if (!com.tencent.mm.y.q.gt(Xv.field_username)) {
                                intent.putExtra("Contact_IsLBSFriend", true);
                            }
                        }
                        intent.putExtra("Is_RoomOwner", ChatroomInfoUI.this.lfB);
                        intent.putExtra("Contact_ChatRoomId", ChatroomInfoUI.this.iTE);
                        com.tencent.mm.plugin.chatroom.a.ihN.d(intent, ChatroomInfoUI.this);
                    }
                }

                public final void ayt() {
                    if (ChatroomInfoUI.this.lfs != null) {
                        ChatroomInfoUI.this.lfs.cbL();
                    }
                }

                public final void ox(int i) {
                    ChatroomInfoUI.this.ayh();
                }
            });
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                ChatroomInfoUI.this.finish();
                return true;
            }
        });
    }

    public final boolean a(f fVar, Preference preference) {
        int i = 1;
        String str = preference.idX;
        int i2;
        Intent intent;
        Intent intent2;
        com.tencent.mm.modelstat.b bVar;
        String str2;
        if (str.equals("room_name")) {
            str = com.tencent.mm.j.g.Af().getValue("ChatRoomOwnerModTopic");
            if (bi.oN(str)) {
                i2 = 0;
            } else {
                i2 = bi.Wo(str);
            }
            if (bi.oN(this.lfE.field_roomowner) || i2 <= 0 || this.lfB || i2 >= this.lfC) {
                str = "";
                if (ayq()) {
                    str = this.jQP.AX();
                }
                intent = new Intent();
                intent.setClass(this, ModRemarkRoomNameUI.class);
                intent.putExtra("room_name", str);
                intent.putExtra("RoomInfo_Id", this.iTE);
                startActivityForResult(intent, 4);
                g.pWK.a(219, 3, 1, true);
            } else {
                com.tencent.mm.ui.base.h.a((Context) this, getString(R.l.eGt, new Object[]{ayj()}), null, getString(R.l.dFD), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
            }
        } else if (str.equals("room_upgrade_entry")) {
            cq(this);
        } else if (str.equals("room_qr_code")) {
            g.pWK.a(219, 5, 1, true);
            intent2 = new Intent();
            intent2.putExtra("from_userName", this.iTE);
            com.tencent.mm.bl.d.b(this, "setting", ".ui.setting.SelfQRCodeUI", intent2);
        } else if (str.equals("room_card")) {
            if (!bi.oN(m.gp(this.iTE)) || this.lfB) {
                intent2 = new Intent();
                intent2.setClass(this, RoomCardUI.class);
                intent2.putExtra("RoomInfo_Id", this.iTE);
                intent2.putExtra("room_name", this.lfn.iZk.toString());
                this.lfC = m.gl(this.iTE).size();
                intent2.putExtra("room_member_count", this.lfC);
                intent2.putExtra("room_owner_name", ayj());
                intent2.putExtra("room_notice", m.gp(this.iTE));
                intent2.putExtra("room_notice_publish_time", m.gr(this.iTE));
                intent2.putExtra("room_notice_editor", m.gq(this.iTE));
                intent2.putExtra("Is_RoomOwner", this.lfB);
                startActivityForResult(intent2, 6);
            } else {
                com.tencent.mm.ui.base.h.a((Context) this, getString(R.l.eFd), null, getString(R.l.eFe), null, null, null);
            }
        } else if (str.equals("room_notify_new_msg")) {
            this.kYN = !this.kYN;
            if (this.fAu) {
                i2 = this.kYN ? 0 : 1;
                as.Hm();
                com.tencent.mm.y.c.Fe().b(new com.tencent.mm.ax.k(this.iTE, i2));
                as.Hm();
                this.jQP = com.tencent.mm.y.c.Ff().Xv(this.iTE);
                this.jQP.eH(i2);
                as.Hm();
                com.tencent.mm.y.c.Ff().a(this.iTE, this.jQP);
            }
            bVar = com.tencent.mm.modelstat.b.hRo;
            str2 = this.iTE;
            boolean z = this.kYN;
            if (bVar.SU() && bVar.ch(str2)) {
                IMBehavior iMBehavior = new IMBehavior();
                iMBehavior.opType = 1;
                iMBehavior.chattingOp = new IMBehaviorChattingOP();
                IMBehaviorChattingOP iMBehaviorChattingOP = iMBehavior.chattingOp;
                if (!z) {
                    i = 2;
                }
                iMBehaviorChattingOP.changeNotifyStatus = i;
                synchronized (bVar.lock) {
                    bVar.hRn.oplist_.add(iMBehavior);
                }
            }
            ayn();
        } else if (str.equals("room_save_to_contact")) {
            if (this.hbz == null) {
                this.hbz = getSharedPreferences(getPackageName() + "_preferences", 0);
            }
            as.Hm();
            com.tencent.mm.f.b.ag Xv = com.tencent.mm.y.c.Ff().Xv(this.iTE);
            if (Xv != null) {
                boolean ga = com.tencent.mm.k.a.ga(Xv.field_type);
                this.hbz.edit().putBoolean("room_save_to_contact", !ga).commit();
                if (ga) {
                    Xv.Ao();
                    s.t(Xv);
                    com.tencent.mm.ui.base.h.bu(this, getString(R.l.eGe));
                    com.tencent.mm.modelstat.b.hRo.J(this.iTE, false);
                } else {
                    s.q(Xv);
                    com.tencent.mm.ui.base.h.bu(this, getString(R.l.eGm));
                    com.tencent.mm.modelstat.b.hRo.J(this.iTE, true);
                }
                this.inW.notifyDataSetChanged();
            }
        } else if (str.equals("room_placed_to_the_top")) {
            SharedPreferences sharedPreferences = getSharedPreferences(this.lfR, 0);
            if (this.jQP != null) {
                as.Hm();
                if (com.tencent.mm.y.c.Fk().XM(this.jQP.field_username)) {
                    s.s(this.jQP.field_username, true);
                    com.tencent.mm.modelstat.b.hRo.c(false, this.iTE, false);
                } else {
                    s.r(this.jQP.field_username, true);
                    com.tencent.mm.modelstat.b.hRo.c(false, this.iTE, true);
                }
                as.Hm();
                sharedPreferences.edit().putBoolean("room_placed_to_the_top", com.tencent.mm.y.c.Fk().XM(this.jQP.field_username)).commit();
            }
        } else if (str.equals("room_nickname")) {
            str2 = ayg();
            if (bi.oN(str2)) {
                str2 = com.tencent.mm.y.q.Ga();
            }
            com.tencent.mm.ui.base.h.a(this.mController.xRr, getString(R.l.eFY), str2, getString(R.l.eFE), 32, new com.tencent.mm.ui.base.h.b() {
                public final boolean v(CharSequence charSequence) {
                    String charSequence2 = charSequence == null ? "" : charSequence.toString();
                    String zP = com.tencent.mm.j.b.zP();
                    if (bi.oN(zP) || !charSequence2.matches(".*[" + zP + "].*")) {
                        if (!(charSequence2 == null || charSequence2.equals(str2))) {
                            ChatroomInfoUI.a(ChatroomInfoUI.this, charSequence2);
                        }
                        return true;
                    }
                    com.tencent.mm.ui.base.h.bu(ChatroomInfoUI.this.mController.xRr, ChatroomInfoUI.this.getString(R.l.epR, new Object[]{zP}));
                    return false;
                }
            });
        } else if (str.equals("room_msg_show_username")) {
            getSharedPreferences(this.lfR, 0).edit().putBoolean("room_msg_show_username", !this.lfz).commit();
            this.lfz = !this.lfz;
            this.lfD = true;
        } else if (str.equals("room_set_chatting_background")) {
            intent2 = new Intent();
            intent2.putExtra("isApplyToAll", false);
            intent2.putExtra("username", this.jQP.field_username);
            com.tencent.mm.bl.d.b(this, "setting", ".ui.setting.SettingsChattingBackgroundUI", intent2, 2);
        } else if (str.equals("room_search_chatting_content")) {
            intent2 = new Intent();
            intent2.putExtra("detail_username", this.iTE);
            com.tencent.mm.bl.d.b(this, "search", ".ui.FTSChattingConvUI", intent2);
            if (this.lfE == null || this.lfE.My() == null) {
                i2 = 0;
            } else {
                i2 = this.lfE.My().size();
            }
            g.pWK.h(14569, Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i2), Integer.valueOf(1));
        } else if (str.equals("room_clear_chatting_history")) {
            com.tencent.mm.ui.base.h.a(this.mController.xRr, getString(R.l.eiM), "", getString(R.l.dEz), getString(R.l.dEy), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    String str;
                    g.pWK.h(14553, Integer.valueOf(3), Integer.valueOf(2), ChatroomInfoUI.this.iTE);
                    ChatroomInfoUI.lfU = false;
                    Context context = ChatroomInfoUI.this;
                    ChatroomInfoUI.this.getString(R.l.dGZ);
                    final ProgressDialog a = com.tencent.mm.ui.base.h.a(context, ChatroomInfoUI.this.getString(R.l.dHn), true, new a());
                    if (com.tencent.mm.y.l.gc(ChatroomInfoUI.this.jQP.field_username)) {
                        com.tencent.mm.plugin.chatroom.a.ihO.cB(ChatroomInfoUI.this.jQP.field_username);
                    }
                    if (ChatroomInfoUI.lfU) {
                        str = null;
                    } else {
                        str = com.tencent.mm.pluginsdk.wallet.e.TE(ChatroomInfoUI.this.jQP.field_username);
                    }
                    if (bi.oN(str)) {
                        bb.a(ChatroomInfoUI.this.jQP.field_username, new com.tencent.mm.y.bb.a(a) {
                            public final boolean HH() {
                                return ChatroomInfoUI.lfU;
                            }

                            public final void HG() {
                                if (r3 != null) {
                                    r3.dismiss();
                                }
                            }
                        });
                        return;
                    }
                    a.dismiss();
                    com.tencent.mm.ui.base.h.a(ChatroomInfoUI.this, false, ChatroomInfoUI.this.getString(R.l.eWv, new Object[]{str}), null, ChatroomInfoUI.this.getString(R.l.enQ), ChatroomInfoUI.this.getString(R.l.dUc), new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            g.pWK.h(14553, Integer.valueOf(3), Integer.valueOf(4), ChatroomInfoUI.this.iTE);
                            ChatroomInfoUI.this.isDeleteCancel = true;
                            if (ChatroomInfoUI.this.lfH) {
                                ChatroomInfoUI.this.finish();
                                return;
                            }
                            Intent intent = new Intent();
                            intent.putExtra("Chat_User", ChatroomInfoUI.this.jQP.field_username);
                            intent.addFlags(67108864);
                            com.tencent.mm.bl.d.a(ChatroomInfoUI.this, ".ui.chatting.ChattingUI", intent);
                        }
                    }, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            g.pWK.h(14553, Integer.valueOf(3), Integer.valueOf(3), ChatroomInfoUI.this.iTE);
                            a.show();
                            ChatroomInfoUI.this.isDeleteCancel = false;
                            bb.a(ChatroomInfoUI.this.jQP.field_username, /* anonymous class already generated */);
                        }
                    }, -1, R.e.brm);
                }
            }, null, R.e.brm);
        } else if (str.equals("room_report_it")) {
            intent2 = new Intent();
            intent2.putExtra("k_username", this.iTE);
            intent2.putExtra("showShare", false);
            intent2.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(36)}));
            com.tencent.mm.bl.d.b(this, "webview", ".ui.tools.WebViewUI", intent2);
            bVar = com.tencent.mm.modelstat.b.hRo;
            String str3 = this.iTE;
            if (bVar.SU() && bVar.ch(str3)) {
                IMBehavior iMBehavior2 = new IMBehavior();
                iMBehavior2.opType = 1;
                iMBehavior2.chattingOp = new IMBehaviorChattingOP();
                iMBehavior2.chattingOp.expose = 1;
                synchronized (bVar.lock) {
                    bVar.hRn.oplist_.add(iMBehavior2);
                }
            }
        } else if (str.equals("room_del_quit")) {
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChatroomInfoUI", " quit " + this.iTE);
            com.tencent.mm.sdk.b.b rkVar = new rk();
            rkVar.fJX.fJZ = true;
            com.tencent.mm.sdk.b.a.xmy.m(rkVar);
            final boolean z2 = !bi.oN(this.iTE) && this.iTE.equals(rkVar.fJY.fKb);
            if (z2) {
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChatroomInfoUI", " quit talkroom" + this.iTE);
            } else if (this.lfB && this.lfE.My().size() > 2) {
                com.tencent.mm.ui.base.h.a((Context) this, "", new String[]{getString(R.l.eGc)}, getString(R.l.dEy), new com.tencent.mm.ui.base.h.c() {
                    public final void jo(int i) {
                        switch (i) {
                            case 0:
                                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChatroomInfoUI", "dz[dealQuitChatRoom owner click room_owner_delete_direct]");
                                ChatroomInfoUI.y(ChatroomInfoUI.this);
                                if (com.tencent.mm.pluginsdk.q.a.vjf != null) {
                                    com.tencent.mm.pluginsdk.q.a.vjf.FX(ChatroomInfoUI.this.iTE);
                                    return;
                                }
                                return;
                            default:
                                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChatroomInfoUI", "dz[dealQuitChatRoom owner click cancel]");
                                return;
                        }
                    }
                });
            }
            com.tencent.mm.ui.base.h.a(this.mController.xRr, getString(R.l.dYA), "", getString(R.l.dGf), getString(R.l.dEy), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    if (ChatroomInfoUI.this.iTE == null || ChatroomInfoUI.this.iTE.length() <= 0) {
                        com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ChatroomInfoUI", "quitChatRoom : invalid args");
                        return;
                    }
                    if (z2) {
                        com.tencent.mm.sdk.b.b rkVar = new rk();
                        rkVar.fJX.fKa = true;
                        com.tencent.mm.sdk.b.a.xmy.m(rkVar);
                    }
                    as.Hm();
                    if (com.tencent.mm.y.c.Ff().Xx(ChatroomInfoUI.this.iTE)) {
                        ChatroomInfoUI.y(ChatroomInfoUI.this);
                        if (com.tencent.mm.pluginsdk.q.a.vjf != null) {
                            com.tencent.mm.pluginsdk.q.a.vjf.FX(ChatroomInfoUI.this.iTE);
                            return;
                        }
                        return;
                    }
                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ChatroomInfoUI", "quitChatRoom : room[" + ChatroomInfoUI.this.iTE + "] is not exist");
                }
            }, null, R.e.brm);
        } else if (str.equals("add_selector_btn")) {
            ayh();
        } else if (str.equals("del_selector_btn")) {
            ayi();
        } else if (str.equals("see_room_member")) {
            intent = new Intent();
            intent.setClass(this.mController.xRr, SeeRoomMemberUI.class);
            intent.putExtra("Block_list", com.tencent.mm.y.q.FY());
            List gl = m.gl(this.iTE);
            if (gl != null) {
                this.lfC = gl.size();
            }
            intent.putExtra("Chatroom_member_list", bi.d(gl, ","));
            intent.putExtra("RoomInfo_Id", this.iTE);
            intent.putExtra("room_owner_name", this.lfE.field_roomowner);
            intent.putExtra("Is_RoomOwner", this.lfB);
            intent.putExtra("room_member_count", this.lfC);
            intent.putExtra("Add_address_titile", getString(R.l.eGp));
            if (this.fAu) {
                intent.putExtra("Contact_Scene", 14);
            } else if (this.lfm) {
                intent.putExtra("Contact_Scene", 44);
                if (!com.tencent.mm.y.q.gt(this.jQP.field_username)) {
                    intent.putExtra("Contact_IsLBSFriend", true);
                }
            }
            str2 = "offset";
            View childAt = this.nQn.getChildAt(0);
            intent.putExtra(str2, childAt == null ? 0 : -childAt.getTop());
            intent.putExtra("first_pos", this.nQn.getFirstVisiblePosition());
            intent.putExtra("room_name", this.jQP.field_username);
            startActivityForResult(intent, 5);
            this.lfL = 5;
        } else if (str.equals("manage_room")) {
            intent2 = new Intent();
            intent2.setClass(this.mController.xRr, ManageChatroomUI.class);
            intent2.putExtra("RoomInfo_Id", this.iTE);
            intent2.putExtra("room_owner_name", this.lfE.field_roomowner);
            startActivity(intent2);
        } else if (str.equals("chat_room_app_brand")) {
            intent2 = new Intent();
            intent2.putExtra("Chat_User", this.iTE);
            com.tencent.mm.bl.d.a((Context) this, ".ui.chatting.gallery.AppBrandHistoryListUI", intent2);
            g.pWK.a(219, 25, 1, true);
        }
        return false;
    }

    private String ayg() {
        if (this.lfE == null) {
            return "";
        }
        return this.lfE.field_selfDisplayName;
    }

    private void el(boolean z) {
        if (com.tencent.mm.y.l.gc(this.iTE)) {
            com.tencent.mm.plugin.chatroom.a.ihO.cB(this.iTE);
        }
        bb.a(this.iTE, new com.tencent.mm.y.bb.a() {
            public final boolean HH() {
                return ChatroomInfoUI.this.isDeleteCancel;
            }

            public final void HG() {
                if (ChatroomInfoUI.this.inI != null) {
                    ChatroomInfoUI.this.inI.dismiss();
                }
            }
        });
        as.Hm();
        com.tencent.mm.y.c.Fe().b(new com.tencent.mm.ax.b(this.iTE));
        as.Hm();
        com.tencent.mm.y.c.Fk().XE(this.iTE);
        as.Hm();
        com.tencent.mm.y.c.Fe().b(new com.tencent.mm.ax.c(this.iTE));
        if (z) {
            as.Hm();
            com.tencent.mm.plugin.messenger.foundation.a.a.d Fe = com.tencent.mm.y.c.Fe();
            as.Hm();
            Fe.b(new p((String) com.tencent.mm.y.c.Db().get(2, null), this.iTE));
        }
        m.gj(this.iTE);
        if (!z) {
            this.handler.post(new Runnable() {
                public final void run() {
                    com.tencent.mm.plugin.chatroom.a.ihO.ep(7);
                }
            });
        }
        Intent intent = new Intent();
        intent.addFlags(67108864);
        com.tencent.mm.plugin.chatroom.a.ihN.s(intent, this.mController.xRr);
        finish();
    }

    private void ayh() {
        List gl;
        if (this.fAu) {
            g.pWK.a(219, 7, 1, true);
            gl = m.gl(this.iTE);
            String d = bi.d(gl, ",");
            if (gl != null) {
                this.lfC = gl.size();
            }
            Intent intent = new Intent();
            intent.putExtra("titile", getString(R.l.dDz));
            intent.putExtra("list_type", 1);
            intent.putExtra("list_attr", com.tencent.mm.ui.contact.s.zcz);
            intent.putExtra("always_select_contact", d);
            intent.putExtra("scene", 3);
            com.tencent.mm.bl.d.a((Context) this, ".ui.contact.SelectContactUI", intent, 1);
            return;
        }
        g.pWK.k(10170, "1");
        gl = new LinkedList();
        gl.add(this.iTE);
        gl.add(com.tencent.mm.y.q.FY());
        String d2 = bi.d(gl, ",");
        Intent intent2 = new Intent();
        intent2.putExtra("titile", getString(R.l.dDy));
        intent2.putExtra("list_type", 0);
        intent2.putExtra("list_attr", com.tencent.mm.ui.contact.s.zcA);
        intent2.putExtra("always_select_contact", d2);
        com.tencent.mm.bl.d.a((Context) this, ".ui.contact.SelectContactUI", intent2);
    }

    private void ayi() {
        g.pWK.a(219, 8, 1, true);
        List gl = m.gl(this.iTE);
        String d = bi.d(gl, ",");
        this.lfC = gl.size();
        Intent intent = new Intent();
        intent.putExtra("RoomInfo_Id", this.iTE);
        intent.putExtra("Is_Chatroom", true);
        intent.putExtra("Chatroom_member_list", d);
        intent.putExtra("room_member_count", this.lfC);
        intent.putExtra("Is_RoomOwner", this.lfB);
        intent.putExtra("list_attr", com.tencent.mm.ui.contact.s.zcz);
        intent.putExtra("room_name", this.jQP.field_username);
        intent.putExtra("room_owner_name", this.lfE.field_roomowner);
        intent.setClass(this, SelectDelRoomMemberUI.class);
        startActivityForResult(intent, 7);
    }

    private void p(String str, String str2, int i) {
        if (s.gz(str)) {
            boolean z;
            if (bi.oM(com.tencent.mm.y.q.FY()).equals(str)) {
                z = true;
            } else {
                List<String> gl = m.gl(this.iTE);
                if (gl == null) {
                    z = false;
                } else {
                    z = false;
                    for (String equals : gl) {
                        boolean z2;
                        if (equals.equals(str)) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        z = z2;
                    }
                }
            }
            if (z) {
                com.tencent.mm.ui.base.h.b(this, getString(R.l.dCL), getString(R.l.dGZ), true);
                return;
            }
            List F = bi.F(str.split(","));
            if (F != null) {
                final k dVar = new com.tencent.mm.plugin.chatroom.d.d(this.iTE, F, str2);
                getString(R.l.dGZ);
                this.inI = com.tencent.mm.ui.base.h.a((Context) this, getString(i), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        as.CN().c(dVar);
                    }
                });
                as.CN().a(dVar, 0);
                return;
            }
            return;
        }
        com.tencent.mm.ui.base.h.b(this, getString(R.l.eFU), getString(R.l.dGZ), true);
    }

    private void a(int i, com.tencent.mm.plugin.chatroom.d.d dVar) {
        String str = "";
        String str2 = "";
        String string = ad.getContext().getString(R.l.dQK);
        final List list = dVar.leX;
        final List list2 = dVar.leZ;
        final List list3 = dVar.fBO;
        if (i != -2012 || ((list == null || list.isEmpty()) && (list2 == null || list2.isEmpty()))) {
            boolean z;
            as.Hm();
            q hH = com.tencent.mm.y.c.Fo().hH(this.iTE);
            if (i == -116 && ayk() && !bi.oN(hH.field_roomowner)) {
                str = getString(R.l.eFR);
                str2 = getString(R.l.eFQ);
                z = true;
            } else {
                z = false;
            }
            if (i == -23) {
                str = getString(R.l.eFX);
                str2 = getString(R.l.eFW);
            }
            if (i == -109) {
                str = getString(R.l.eFT);
                str2 = getString(R.l.eFS);
            }
            if (i == -122) {
                str = getString(R.l.eFX);
                str2 = getString(R.l.eFV, new Object[]{ayj(), Integer.valueOf(hH.ciH())});
            }
            list = dVar.leY;
            if (list3 == null || list3.size() <= 0 || (list3.size() != dVar.fAL && (list == null || list.size() <= 0 || dVar.fAL != list3.size() + list.size()))) {
                String str3;
                list = dVar.leY;
                if (list != null && list.size() > 0) {
                    str2 = str2 + getString(R.l.eiS, new Object[]{bi.d(at(list), string)});
                }
                list = dVar.fBN;
                if (list == null || list.size() <= 0) {
                    str3 = str;
                    str = str2;
                } else {
                    str = getString(R.l.dCJ);
                    Object[] objArr = new Object[]{bi.d(at(list), string)};
                    str3 = str;
                    str = str2 + getString(R.l.ejc, objArr);
                }
                List<String> list4 = dVar.fBL;
                if (list4 != null && list4.size() > 0) {
                    boolean z2;
                    for (String str22 : list4) {
                        if (x.Xg(str22)) {
                            str3 = getString(R.l.esV);
                            str = getString(R.l.fXC);
                            z2 = true;
                            break;
                        }
                    }
                    z2 = false;
                    if (!z2) {
                        str3 = getString(R.l.dCJ);
                        str = str + getString(R.l.eiV, new Object[]{bi.d(at(list4), string)});
                    }
                }
                Collection collection = dVar.leZ;
                List list42 = new ArrayList();
                if (!(list3 == null || list3.isEmpty())) {
                    list42.addAll(list3);
                }
                if (collection != null && collection.size() > 0) {
                    list42.addAll(collection);
                }
                if (i != -2028) {
                    d(dVar.chatroomName, list3);
                }
                str22 = str + getString(R.l.eiG, new Object[]{bi.d(at(list42), string)});
                if (list3 != null && list3.isEmpty()) {
                    str22 = null;
                }
                if (str22 != null && str22.length() > 0) {
                    if (z) {
                        com.tencent.mm.ui.base.h.a((Context) this, str22, str3, new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                ChatroomInfoUI chatroomInfoUI = ChatroomInfoUI.this;
                                Context context = ChatroomInfoUI.this;
                                ChatroomInfoUI.this.iTE;
                                chatroomInfoUI.cq(context);
                            }
                        }, null);
                        return;
                    } else {
                        com.tencent.mm.ui.base.h.b(this, str22, str3, true);
                        return;
                    }
                }
                return;
            }
            List linkedList = new LinkedList();
            for (int i2 = 0; i2 < list3.size(); i2++) {
                linkedList.add(list3.get(i2));
            }
            str22 = "";
            String string2 = ad.getContext().getString(R.l.dQK);
            if (!(list == null || list.isEmpty())) {
                str22 = getString(R.l.eiF, new Object[]{bi.d(at(list), string2)}) + "\n";
            }
            if (!linkedList.isEmpty()) {
                str22 = str22 + getString(R.l.eiG, new Object[]{bi.d(at(linkedList), string2)});
            }
            com.tencent.mm.ui.base.h.a((Context) this, str22, "", getString(R.l.eiA), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    ChatroomInfoUI.this.ayr();
                }
            });
            d(dVar.chatroomName, linkedList);
            return;
        }
        string = getString(R.l.dCK);
        String string3 = getString(R.l.epS);
        String string4 = getString(R.l.dEy);
        final com.tencent.mm.plugin.chatroom.d.d dVar2 = dVar;
        AnonymousClass21 anonymousClass21 = new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                ChatroomInfoUI.this.d(dVar2.chatroomName, list3);
                List arrayList = new ArrayList();
                arrayList.addAll(list);
                arrayList.addAll(list2);
                final k kVar = new com.tencent.mm.plugin.chatroom.d.k(ChatroomInfoUI.this.iTE, arrayList);
                as.CN().a(kVar, 0);
                ChatroomInfoUI chatroomInfoUI = ChatroomInfoUI.this;
                Context context = ChatroomInfoUI.this;
                ChatroomInfoUI.this.getString(R.l.dGZ);
                chatroomInfoUI.inI = com.tencent.mm.ui.base.h.a(context, ChatroomInfoUI.this.getString(R.l.eFL), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        as.CN().c(kVar);
                    }
                });
            }
        };
        com.tencent.mm.ui.base.h.a((Context) this, string, null, string3, string4, (OnClickListener) anonymousClass21, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
    }

    private String ayj() {
        String str;
        String str2 = null;
        as.Hm();
        com.tencent.mm.f.b.ag Xv = com.tencent.mm.y.c.Ff().Xv(this.lfE.field_roomowner);
        if (Xv == null || ((int) Xv.gKO) <= 0) {
            str = null;
        } else {
            str = Xv.field_conRemark;
        }
        if (bi.oN(str)) {
            str = this.lfE.field_roomowner;
            if (this.lfE != null) {
                str2 = this.lfE.gw(str);
            }
        } else {
            str2 = str;
        }
        if (bi.oN(str2) && Xv != null && ((int) Xv.gKO) > 0) {
            str2 = Xv.AW();
        }
        if (bi.oN(str2)) {
            return this.lfE.field_roomowner;
        }
        return str2;
    }

    private static boolean ayk() {
        return bi.getInt(com.tencent.mm.j.g.Af().getValue("ChatroomGlobalSwitch"), 1) == 1;
    }

    private void cq(Context context) {
        if (context != null && ayk()) {
            Intent intent = new Intent();
            intent.putExtra("rawUrl", getString(R.l.dQG, new Object[]{w.cfV()}));
            intent.putExtra("geta8key_username", com.tencent.mm.y.q.FY());
            intent.putExtra("showShare", false);
            com.tencent.mm.bl.d.b(this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
        }
    }

    private void d(String str, List<String> list) {
        if (list != null && list.size() > 0) {
            List linkedList = new LinkedList();
            for (int i = 0; i < list.size(); i++) {
                linkedList.add(list.get(i));
            }
            com.tencent.mm.y.l.a(str, linkedList, getString(R.l.dQJ), true, "weixin://findfriend/verifycontact/" + str + "/");
        }
    }

    private void updateTitle() {
        if (this.fAu) {
            this.lfC = m.gn(this.iTE);
            if (this.lfC == 0) {
                setMMTitle(getString(R.l.eGM));
                return;
            }
            setMMTitle(getString(R.l.eiH, new Object[]{getString(R.l.eGM), Integer.valueOf(this.lfC)}));
        }
    }

    private void ayl() {
        if (this.lfs == null) {
            return;
        }
        List gl;
        if (this.fAu) {
            as.Hm();
            this.lfV = com.tencent.mm.y.c.Fo().hJ(this.iTE);
            gl = m.gl(this.iTE);
            if (gl != null) {
                this.lfC = gl.size();
            } else {
                this.lfC = 0;
            }
            if (this.lfC > h.vuo + 1 && gl != null) {
                gl = gl.subList(0, h.vuo + 1);
                if (!(this.lfE == null || gl.contains(this.lfE.field_roomowner))) {
                    gl.add(0, this.lfE.field_roomowner);
                }
            }
            if (this.lfC <= 1) {
                this.inW.bl("del_selector_btn", true);
                this.lfs.lh(true).li(false).cbM();
            } else {
                this.lfs.lh(true).li(this.lfB).cbM();
            }
            this.lfs.n(this.iTE, gl);
            return;
        }
        gl = new LinkedList();
        gl.add(this.iTE);
        this.lfs.n(this.iTE, gl);
    }

    private void aym() {
        if (this.jQP != null) {
            CharSequence ayg = ayg();
            if (bi.oN(ayg)) {
                ayg = com.tencent.mm.y.q.Ga();
            }
            if (bi.oN(ayg)) {
                this.lfw.setSummary((CharSequence) "");
            } else {
                SignaturePreference signaturePreference = this.lfw;
                if (ayg.length() <= 0) {
                    ayg = getString(R.l.eNn);
                }
                signaturePreference.setSummary(com.tencent.mm.pluginsdk.ui.d.i.a((Context) this, ayg));
            }
            if (this.inW != null) {
                this.inW.notifyDataSetChanged();
            }
        }
    }

    private void ayn() {
        if (this.hbz == null) {
            this.hbz = getSharedPreferences(getPackageName() + "_preferences", 0);
        }
        if (this.fAu) {
            this.kYN = this.jQP.fXi == 0;
        } else if (!this.lfm) {
            this.kYN = this.jQP.AP();
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

    private void ayo() {
        if (this.jQP != null && this.lfn != null) {
            CharSequence gp = m.gp(this.iTE);
            if (gp == null || gp.length() <= 0) {
                this.lfn.fpU = false;
            } else {
                this.lfn.fpU = true;
                this.lfn.vAM = com.tencent.mm.pluginsdk.ui.d.i.a((Context) this, gp);
            }
            as.Hm();
            this.jQP = com.tencent.mm.y.c.Ff().Xv(this.iTE);
            if (ayq()) {
                gp = this.jQP.AX();
                RoomCardPreference roomCardPreference = this.lfn;
                if (gp.length() <= 0) {
                    gp = getString(R.l.eNn);
                }
                roomCardPreference.iZk = com.tencent.mm.pluginsdk.ui.d.i.a((Context) this, gp);
            } else {
                this.lfn.iZk = getString(R.l.eFJ);
            }
            this.inW.notifyDataSetChanged();
        }
    }

    private void ayp() {
        if (this.jQP != null && this.lfo != null) {
            as.Hm();
            this.jQP = com.tencent.mm.y.c.Ff().Xv(this.iTE);
            if (ayq()) {
                CharSequence AX = this.jQP.AX();
                SignaturePreference signaturePreference = this.lfo;
                if (AX.length() <= 0) {
                    AX = getString(R.l.eNn);
                }
                signaturePreference.setSummary(com.tencent.mm.pluginsdk.ui.d.i.a((Context) this, AX));
                if (this.inW != null) {
                    this.inW.notifyDataSetChanged();
                    return;
                }
                return;
            }
            this.lfo.setSummary(getString(R.l.eFJ));
        }
    }

    private boolean ayq() {
        String str = this.jQP.field_nickname;
        return !bi.oN(str) && str.length() <= 50;
    }

    public static ArrayList<x> as(List<aox> list) {
        ArrayList<x> arrayList = new ArrayList();
        if (list == null) {
            return arrayList;
        }
        for (aox aox : list) {
            x xVar = new x();
            xVar.setUsername(aox.kyG);
            xVar.dc(aox.kzN);
            arrayList.add(xVar);
        }
        return arrayList;
    }

    private static List<String> at(List<String> list) {
        List<String> linkedList = new LinkedList();
        if (!as.Hp()) {
            return linkedList;
        }
        if (list == null) {
            return linkedList;
        }
        for (Object obj : list) {
            Object obj2;
            as.Hm();
            com.tencent.mm.k.a Xv = com.tencent.mm.y.c.Ff().Xv(obj2);
            if (!(Xv == null || ((int) Xv.gKO) == 0)) {
                obj2 = Xv.AX();
            }
            linkedList.add(obj2);
        }
        return linkedList;
    }

    public final void a(int i, int i2, String str, k kVar) {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChatroomInfoUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChatroomInfoUI", "pre is " + this.lfC);
        this.lfC = m.gn(this.iTE);
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChatroomInfoUI", "now is " + this.lfC);
        if (this.inI != null) {
            this.inI.dismiss();
        }
        com.tencent.mm.g.a eC = com.tencent.mm.g.a.eC(str);
        if (eC != null) {
            eC.a(this, null, null);
        } else if (i == 0 && i2 == 0) {
            if (i == 0 && i2 == 0) {
                switch (kVar.getType()) {
                    case 120:
                        a(i2, (com.tencent.mm.plugin.chatroom.d.d) kVar);
                        ayr();
                        break;
                    case 179:
                        ayr();
                        break;
                    case 610:
                        if (this.lfL != 5) {
                            com.tencent.mm.ui.base.h.b(this, getString(R.l.eqe), null, true);
                            break;
                        }
                        break;
                }
                if (this.lfE != null) {
                    this.lfC = this.lfE.My().size();
                }
                if ((!this.lfB && this.lfC >= h.vuo) || (this.lfB && this.lfC >= h.vuo - 1)) {
                    this.inW.bl("see_room_member", false);
                    this.lfp.setTitle(getString(R.l.eJs));
                }
            }
            updateTitle();
        } else {
            if (kVar.getType() == 120 && this.lfL != 5) {
                a(i2, (com.tencent.mm.plugin.chatroom.d.d) kVar);
                ayr();
            }
            if (kVar.getType() == 179 && this.lfL != 5 && i2 == -66) {
                com.tencent.mm.ui.base.h.b(this, getString(R.l.dYB), getString(R.l.dGZ), true);
                ayr();
            }
            if (kVar.getType() == 610 && this.lfL != 5) {
                com.tencent.mm.ui.base.h.b(this, getString(R.l.eqd), getString(R.l.dGZ), true);
            }
        }
    }

    private void ayr() {
        if (this.lfs != null) {
            if (this.fAu) {
                ayl();
            } else if (!this.lfm) {
                List linkedList = new LinkedList();
                linkedList.add(this.iTE);
                this.lfs.n(this.iTE, linkedList);
            }
            this.lfs.notifyChanged();
        }
        if (!this.lfB || m.gn(this.iTE) <= 2) {
            this.inW.bl("manage_room", true);
        } else {
            this.inW.bl("manage_room", false);
        }
        if ((this.lfB || this.lfC < h.vuo) && (!this.lfB || this.lfC < h.vuo - 1)) {
            this.inW.bl("see_room_member", true);
        } else {
            this.inW.bl("see_room_member", false);
            this.lfp.setTitle(getString(R.l.eJs, new Object[]{Integer.valueOf(this.lfC)}));
        }
        this.inW.notifyDataSetChanged();
    }

    public final void a(int i, com.tencent.mm.sdk.e.m mVar, Object obj) {
        if (obj == null || !(obj instanceof String)) {
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChatroomInfoUI", "onNotifyChange obj not String event:%d stg:%s obj:%s", Integer.valueOf(i), mVar, obj);
            return;
        }
        a((String) obj, null);
    }

    public final void a(String str, com.tencent.mm.sdk.e.l lVar) {
        if (!bi.oN(str)) {
            if (str.endsWith("@chatroom")) {
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChatroomInfoUI", "event:" + str);
                if (this.fAu && str.equals(this.iTE)) {
                    as.Dt().F(new Runnable() {
                        public final void run() {
                            ChatroomInfoUI chatroomInfoUI = ChatroomInfoUI.this;
                            as.Hm();
                            chatroomInfoUI.lfE = com.tencent.mm.y.c.Fo().hG(ChatroomInfoUI.this.iTE);
                            if (ChatroomInfoUI.this.lfE == null) {
                                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ChatroomInfoUI", "member is null");
                            } else if (bi.oN(ChatroomInfoUI.this.lfE.field_roomowner)) {
                                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ChatroomInfoUI", "roomowner is null");
                            } else {
                                ChatroomInfoUI.this.handler.sendEmptyMessage(0);
                                ChatroomInfoUI.this.lfB = ChatroomInfoUI.this.lfE.field_roomowner.equals(com.tencent.mm.y.q.FY());
                                ChatroomInfoUI.this.lfs.SY(ChatroomInfoUI.this.lfE.field_roomowner);
                            }
                        }

                        public final String toString() {
                            return super.toString() + "|onNotifyChange";
                        }
                    });
                }
                ayr();
                return;
            }
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChatroomInfoUI", "event:" + str + " cancel");
        }
    }

    public final void G(String str, String str2, String str3) {
        if (str.equals(this.iTE) && this.lfs != null) {
            this.lfs.notifyChanged();
        }
    }

    public final com.tencent.mm.ui.base.preference.h a(SharedPreferences sharedPreferences) {
        return new com.tencent.mm.ui.base.preference.a(this, sharedPreferences);
    }
}
