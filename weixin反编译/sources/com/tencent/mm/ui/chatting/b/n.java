package com.tencent.mm.ui.chatting.b;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.provider.Settings.Secure;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.af.y;
import com.tencent.mm.f.b.ak;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.k;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.bio.face.b;
import com.tencent.mm.pluginsdk.ui.chat.AppPanel;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.d;
import com.tencent.mm.pluginsdk.ui.chat.j;
import com.tencent.mm.pluginsdk.ui.chat.m.AnonymousClass6;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.p;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ae;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.bizchat.BizChatAtSomeoneUI;
import com.tencent.mm.ui.chatting.AtSomeoneUI;
import com.tencent.mm.ui.chatting.ChatFooterCustom;
import com.tencent.mm.ui.chatting.b.v.AnonymousClass4;
import com.tencent.mm.ui.chatting.b.v.AnonymousClass5;
import com.tencent.mm.ui.chatting.o;
import com.tencent.mm.ui.chatting.t;
import com.tencent.mm.ui.chatting.v;
import com.tencent.mm.ui.chatting.w;
import com.tencent.mm.ui.u;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.m;
import com.tencent.mm.y.q;
import com.tencent.mm.y.s;
import com.tencent.wcdb.FileUtils;
import java.util.LinkedList;
import java.util.List;

public final class n {
    p fhH;
    protected ChatFooter osJ;
    private final d vwQ = new d() {
        private Animation yIU;
        private Animation yIV;

        public final boolean lu(boolean z) {
            if (this.yIU == null) {
                this.yIU = AnimationUtils.loadAnimation(n.this.fhH.cte().getContext(), R.a.bqo);
                this.yIV = AnimationUtils.loadAnimation(n.this.fhH.cte().getContext(), R.a.bqm);
            }
            if (z) {
                x.i("MicroMsg.ChattingUI.FootMgr", "switchFooterToInput customFooter is %s", n.this.yIL);
                if (n.this.yIL != null) {
                    n.this.yIL.startAnimation(this.yIV);
                }
                n.this.cux();
                n.this.osJ.startAnimation(this.yIU);
                n.this.osJ.postInvalidateDelayed(this.yIU.getDuration());
            } else {
                n.this.fhH.cte().hideVKB();
                n.this.osJ.startAnimation(this.yIV);
                n.this.cuw();
                if (n.this.yIL != null) {
                    n.this.yIL.startAnimation(this.yIU);
                    n.this.yIL.postInvalidateDelayed(this.yIU.getDuration());
                }
            }
            return false;
        }
    };
    public v yEB;
    public u yEG;
    public j yEH;
    public c yEL;
    public i yEt;
    public q yEz;
    private o yIK;
    protected ChatFooterCustom yIL;
    private int yIM = 0;
    private t yIN;
    private w yIO;
    private AnimationSet yIP;
    String yIQ = null;
    private int yIR;
    private int yIS;
    private boolean yIT = false;

    private class a implements TextWatcher {
        private boolean yIX;
        private List<String> yIY;

        private a() {
            this.yIX = false;
            this.yIY = null;
        }

        /* synthetic */ a(n nVar, byte b) {
            this();
        }

        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        private static void b(List<String> list, String[] strArr) {
            for (String str : strArr) {
                if (str.length() > 0 && str.substring(str.length() - 1, str.length()).matches("[_0-9a-zA-Z]$")) {
                    list.add(str);
                }
            }
        }

        private boolean do(String str, int i) {
            if (str == null || i < 0 || str.length() <= i) {
                return false;
            }
            if (i == 0) {
                return true;
            }
            if (!str.substring(i - 1, i).matches("[_0-9a-zA-Z]$")) {
                return true;
            }
            if (this.yIY == null) {
                this.yIY = new LinkedList();
                b(this.yIY, n.this.fhH.cte().getMMResources().getStringArray(R.c.bqU));
                b(this.yIY, n.this.fhH.cte().getMMResources().getStringArray(R.c.bqV));
            }
            String substring = str.substring(0, i);
            for (String endsWith : this.yIY) {
                if (substring.endsWith(endsWith)) {
                    return true;
                }
            }
            return false;
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            String d;
            x.i("MicroMsg.ChattingUI.FootMgr", "[onTextChanged]");
            n.this.yEt.FX(1);
            String valueOf = String.valueOf(charSequence);
            String substring = valueOf.substring(i, i + i3);
            Intent intent;
            if (n.this.fhH.csS() && "@".equals(substring) && !valueOf.equals(n.this.osJ.vwR.vxP) && !n.this.osJ.vwS) {
                n.this.osJ.Tc(valueOf);
                n.this.osJ.CA(i + 1);
                if (do(valueOf, i)) {
                    d = bi.d(m.gl(n.this.fhH.csn()), ",");
                    intent = new Intent();
                    intent.setClass(n.this.fhH.cte().getContext(), AtSomeoneUI.class);
                    intent.putExtra("Block_list", q.FY());
                    intent.putExtra("Chatroom_member_list", d);
                    intent.putExtra("Chat_User", n.this.fhH.csW().field_username);
                    intent.putExtra("Add_address_titile", n.this.fhH.cte().getMMString(R.l.eEY));
                    n.this.fhH.cte().startActivityForResult(intent, b.CTRL_INDEX);
                }
            } else if (n.this.fhH.csU() && "@".equals(substring) && !valueOf.equals(n.this.osJ.vwR.vxP) && !n.this.osJ.vwS) {
                n.this.osJ.Tc(valueOf);
                n.this.osJ.CA(i + 1);
                if (do(valueOf, i)) {
                    d = n.this.fhH.ctc().field_userList;
                    intent = new Intent();
                    intent.setClass(n.this.fhH.cte().getContext(), BizChatAtSomeoneUI.class);
                    intent.putExtra("Block_list", y.Mp().cb(n.this.fhH.csn()));
                    intent.putExtra("Chatroom_member_list", d);
                    intent.putExtra("Chat_User", n.this.fhH.csW().field_username);
                    intent.putExtra("Add_address_titile", n.this.fhH.cte().getMMString(R.l.eEY));
                    intent.putExtra("key_biz_chat_id", n.this.yEL.ctW());
                    n.this.fhH.cte().startActivityForResult(intent, b.CTRL_INDEX);
                }
            } else if (!valueOf.equals(n.this.osJ.vwR.vxP)) {
                n.this.osJ.Tc(valueOf);
            }
            v vVar = n.this.yEB;
            if ((vVar.ott == null || !vVar.ott.isShowing()) && !bi.oN(substring) && p.Vu(substring)) {
                Bitmap d2 = com.tencent.mm.sdk.platformtools.d.d(substring, 300, 300, false);
                if (d2 == null) {
                    x.e("MicroMsg.ChattingUI.SendImgImp", "showAlert fail, bmp is null");
                } else {
                    View imageView = new ImageView(vVar.fhH.cte().getContext());
                    int dimensionPixelSize = vVar.fhH.cte().getMMResources().getDimensionPixelSize(R.f.bvw);
                    imageView.setImageBitmap(d2);
                    imageView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
                    d = Secure.getString(vVar.fhH.cte().getContentResolver(), "default_input_method");
                    boolean z = p.bq(e.d(substring, 0, e.bN(substring))) && (d.contains("com.sohu.inputmethod.sogou") || d.contains("com.tencent.qqpinyin"));
                    vVar.ott = h.a(vVar.fhH.cte().getContext(), vVar.fhH.cte().getMMString(R.l.dTh), imageView, vVar.fhH.cte().getMMString(R.l.dGf), vVar.fhH.cte().getMMString(R.l.dEy), new AnonymousClass4(z, substring), null);
                    vVar.fhH.ctp().postDelayed(new AnonymousClass5(valueOf.substring(0, i)), 10);
                }
            }
            if (!n.this.fhH.csT()) {
                ChatFooter chatFooter = n.this.osJ;
                if (chatFooter.vwO != null && chatFooter.oqb != null) {
                    chatFooter.vwO.vyu = true;
                    com.tencent.mm.pluginsdk.ui.chat.m mVar = chatFooter.vwO;
                    if (!(bi.oN(valueOf) || valueOf.equals(mVar.vyt))) {
                        g.Dt().F(new AnonymousClass6(valueOf));
                    }
                    mVar.vyt = valueOf;
                }
            }
        }
    }

    public n(p pVar) {
        this.fhH = pVar;
    }

    public final ChatFooter ctp() {
        return this.osJ;
    }

    public final ChatFooterCustom ctq() {
        return this.yIL;
    }

    public final void crK() {
        boolean z = false;
        as.Hm();
        ak XF = c.Fk().XF(this.fhH.csW().field_username);
        if (XF != null) {
            this.yIM = XF.field_chatmode;
        }
        x.d("MicroMsg.ChattingUI.FootMgr", "dkcm init old:%d   ", Integer.valueOf(this.yIM));
        String csY = this.fhH.csY();
        if (this.osJ == null) {
            this.osJ = (ChatFooter) this.fhH.cte().findViewById(R.h.cyL);
        }
        this.osJ.CH(R.h.bTC);
        x.i("MicroMsg.ChattingUI.FootMgr", "resetFooter customFooter is %s", this.yIL);
        if (this.yIL != null) {
            this.yIL.bBI();
            this.yIL.vwQ = null;
            this.yIL.yzv = null;
            this.osJ.a(null);
            this.yIL.crZ();
        }
        cuy();
        ChatFooter chatFooter = this.osJ;
        if (chatFooter.vwG != null) {
            chatFooter.vwG.setVisibility(0);
        }
        int i;
        if (this.yEG.yJp || this.yEG.yAH) {
            cuy();
        } else if (s.gL(csY)) {
            cuy();
            g.a(this.fhH.cte(), R.h.cyK);
            boolean z2 = this.yIL == null;
            this.yIL = (ChatFooterCustom) this.fhH.cte().findViewById(R.h.cyM);
            if (z2) {
                this.yIL.k((ViewGroup) this.fhH.cte().findViewById(R.h.bTG));
            }
            this.yIN = new t(this.yIL);
            t tVar = this.yIN;
            z2 = f.fei == 1;
            tVar.yCJ.findViewById(R.h.bUd).setVisibility(8);
            tVar.lNK = (LinearLayout) tVar.yCJ.findViewById(R.h.bTZ);
            tVar.yCJ.findViewById(R.h.bTY).setVisibility(8);
            tVar.lNK.setWeightSum(z2 ? 1.0f : 2.0f);
            tVar.yCK = (FrameLayout) tVar.lNK.getChildAt(0);
            tVar.yCK.setVisibility(0);
            tVar.yCK.setOnClickListener(tVar.yCT);
            ((TextView) tVar.yCK.getChildAt(0).findViewById(R.h.bUb)).setText(R.l.dQq);
            tVar.yCK.getChildAt(0).findViewById(R.h.bUa).setVisibility(8);
            tVar.yCK.getChildAt(1).setVisibility(8);
            if (z2) {
                for (i = 1; i < 6; i++) {
                    tVar.lNK.getChildAt(i).setVisibility(8);
                }
            } else {
                tVar.yCL = (FrameLayout) tVar.lNK.getChildAt(1);
                tVar.yCL.setVisibility(0);
                tVar.yCL.setOnClickListener(tVar.yCU);
                tVar.yCM = (TextView) tVar.yCL.getChildAt(0).findViewById(R.h.bUb);
                tVar.yCN = (ImageView) tVar.yCL.getChildAt(0).findViewById(R.h.bUa);
                tVar.yCN.setVisibility(0);
                tVar.csJ();
                as.Hm();
                tVar.yCP = ((Integer) c.Db().get(com.tencent.mm.storage.w.a.USERINFO_QQMAIL_UNREAD_COUNT_INT, Integer.valueOf(-1))).intValue();
                if (tVar.yCP >= 0) {
                    tVar.csL();
                } else {
                    tVar.yCM.setText(R.l.dQD);
                }
                tVar.yCL.getChildAt(1).setVisibility(8);
                for (i = 2; i < 6; i++) {
                    tVar.lNK.getChildAt(i).setVisibility(8);
                }
                tVar.yCS = com.tencent.mm.j.g.Ag().getMailAppEnterUlAndroid();
                if (bi.oN(tVar.yCS)) {
                    tVar.yCS = "qqmail://folderlist?app=weixin&action=list&uin=$uin$";
                }
                as.Hm();
                tVar.yCS = tVar.yCS.replace("$uin$", new com.tencent.mm.a.o(bi.e((Integer) c.Db().get(9, null))).toString());
                tVar.pzZ = com.tencent.mm.j.g.Ag().zV();
                tVar.yCQ = true;
            }
            cuw();
        } else {
            this.yIN = null;
            if (s.gE(csY)) {
                cuy();
                g.a(this.fhH.cte(), R.h.cyK);
                if (this.yIL == null) {
                    z = true;
                }
                this.yIL = (ChatFooterCustom) this.fhH.cte().findViewById(R.h.cyM);
                if (z) {
                    this.yIL.k((ViewGroup) this.fhH.cte().findViewById(R.h.bTG));
                }
                this.yIO = new w(this.yIL);
                this.yIO.cqc();
                cuw();
            } else {
                this.yIO = null;
                if (!(s.gM(csY) || s.gE(csY) || s.gL(csY))) {
                    s.GK();
                    if (!s.hl(csY)) {
                        boolean z3;
                        AppPanel appPanel;
                        q qVar;
                        ChatFooter ctp;
                        cux();
                        X(this.fhH.csW());
                        cuC();
                        this.osJ.Tf(csY);
                        this.osJ.cbZ();
                        if (this.fhH.cto() != null && this.fhH.cto().yBT) {
                            x.w("MicroMsg.ChattingUI.FootMgr", "match shake, in show mode, do not open short video recode view");
                            z3 = false;
                        } else if (this.yEG.yJp || this.yEG.yAH) {
                            x.w("MicroMsg.ChattingUI.FootMgr", "match shake, in search mode, do not open short video recode view");
                            z3 = false;
                        } else if (com.tencent.mm.storage.x.Xf(this.fhH.csW().field_username) || com.tencent.mm.storage.x.gB(this.fhH.csW().field_username)) {
                            x.w("MicroMsg.ChattingUI.FootMgr", "match shake, but is Qcontact or Bcontact");
                            z3 = false;
                        } else {
                            z3 = !s.hq(this.fhH.csW().field_username);
                        }
                        if (!z3) {
                            this.osJ.ccj();
                        }
                        if (this.fhH.csT()) {
                            com.tencent.mm.af.d jV = com.tencent.mm.af.f.jV(this.fhH.csn());
                            if (jV == null || jV.field_enterpriseFather == null) {
                                z3 = false;
                            } else {
                                Cursor jP = y.Ml().jP(jV.field_enterpriseFather);
                                z3 = jP != null && jP.getCount() > 0;
                                if (jP != null) {
                                    jP.close();
                                }
                            }
                            if (z3) {
                                AppPanel appPanel2 = this.osJ.vwD;
                                appPanel2.vvH.vwx.value = true;
                                appPanel2.cbR();
                            }
                        }
                        if (!this.fhH.csS()) {
                            this.osJ.ccw();
                        }
                        if (!(this.fhH.csW() == null || com.tencent.mm.k.a.ga(this.fhH.csW().field_type) || s.eX(this.fhH.csW().field_username))) {
                            this.osJ.ccp();
                        }
                        if (com.tencent.mm.storage.x.gB(csY)) {
                            this.osJ.ccl();
                            this.osJ.ccs();
                            this.osJ.cct();
                            this.osJ.cck();
                            this.osJ.ccm();
                            this.osJ.ccr();
                            this.osJ.cco();
                            this.osJ.ccp();
                            this.osJ.ccq();
                            this.osJ.ccx();
                        }
                        if (com.tencent.mm.storage.x.Xf(csY)) {
                            this.osJ.ccl();
                            this.osJ.ccs();
                            this.osJ.cct();
                            this.osJ.cck();
                            this.osJ.ccm();
                            this.osJ.ccr();
                            this.osJ.cco();
                            this.osJ.ccp();
                            this.osJ.ccq();
                            this.osJ.ccx();
                        }
                        if (com.tencent.mm.storage.x.Xd(csY)) {
                            this.osJ.ccl();
                            this.osJ.ccs();
                            this.osJ.cct();
                            this.osJ.cck();
                            this.osJ.cch();
                            this.osJ.ccm();
                            this.osJ.ccr();
                            this.osJ.cco();
                            this.osJ.ccp();
                            this.osJ.ccq();
                            this.osJ.ccx();
                        }
                        if (s.gX(csY)) {
                            this.osJ.ccl();
                            this.osJ.ccs();
                            this.osJ.cct();
                            this.osJ.ccm();
                            this.osJ.ccr();
                            this.osJ.cco();
                            this.osJ.ccp();
                            this.osJ.ccq();
                            this.osJ.ccx();
                        }
                        if (s.gU(csY)) {
                            this.osJ.ccl();
                            this.osJ.cco();
                            this.osJ.ccr();
                            this.osJ.ccx();
                        }
                        as.Hm();
                        com.tencent.mm.storage.x Xv = c.Ff().Xv(csY);
                        if (Xv != null && Xv.ciN()) {
                            this.osJ.ccl();
                            this.osJ.cco();
                            this.osJ.cck();
                            this.osJ.ccr();
                        }
                        if (this.fhH.csS()) {
                            if (com.tencent.mm.j.g.Af().getInt("MultitalkBlockCaller", 0) == 0) {
                                this.osJ.lq(false);
                                if (this.fhH.csS() || this.fhH.csV()) {
                                    this.osJ.cco();
                                    this.osJ.ccq();
                                }
                                com.tencent.mm.bl.d.cdJ();
                                if (this.fhH.csV()) {
                                    this.osJ.ccr();
                                }
                                if (this.fhH.csn().equals(q.FY())) {
                                    this.osJ.ccr();
                                    this.osJ.cco();
                                    this.osJ.ccp();
                                    this.osJ.ccq();
                                }
                                if (this.fhH.csT()) {
                                    this.osJ.ccl();
                                    this.osJ.cct();
                                    this.osJ.cck();
                                    this.osJ.ccr();
                                    this.osJ.cco();
                                    this.osJ.ccp();
                                    this.osJ.ccq();
                                    this.osJ.ccj();
                                    this.osJ.ccn();
                                    this.osJ.cci();
                                    this.osJ.ccv();
                                    this.osJ.tk();
                                }
                                this.osJ.B(null);
                                if (com.tencent.mm.storage.x.Xg(this.fhH.csW().field_username)) {
                                    i = ((com.tencent.mm.openim.a.b) g.h(com.tencent.mm.openim.a.b.class)).oy(this.fhH.csW().field_openImAppid);
                                    x.i("MicroMsg.ChattingUI.FootMgr", "openim showFlag:%d", Integer.valueOf(i));
                                    if ((i & 1) == 0) {
                                        this.osJ.cch();
                                    }
                                    if ((i & 2) == 0) {
                                        this.osJ.cci();
                                    }
                                    if ((i & 4) == 0) {
                                        appPanel = this.osJ.vwD;
                                        appPanel.vvH.vwe.value = false;
                                        appPanel.cbR();
                                    }
                                    if ((i & 8) == 0) {
                                        this.osJ.cck();
                                    }
                                    if ((i & 16) == 0) {
                                        this.osJ.ccs();
                                    }
                                    if ((i & 32) == 0) {
                                        this.osJ.ccl();
                                    }
                                    if ((i & 64) == 0) {
                                        this.osJ.ccx();
                                    }
                                    if ((i & FileUtils.S_IWUSR) == 0) {
                                        this.osJ.ccm();
                                    }
                                    if ((i & 256) == 0) {
                                        this.osJ.cco();
                                    }
                                    if ((i & WXMediaMessage.TITLE_LENGTH_LIMIT) == 0) {
                                        this.osJ.ccp();
                                        this.osJ.ccq();
                                    }
                                    if ((i & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) == 0) {
                                        this.osJ.vwD.vvS = true;
                                    }
                                    this.osJ.B(((com.tencent.mm.openim.a.b) g.h(com.tencent.mm.openim.a.b.class)).i(this.fhH.csW().field_openImAppid, "openim_function_tip", com.tencent.mm.openim.a.b.a.idv));
                                }
                                this.osJ.lp(com.tencent.mm.bl.d.cdJ());
                                chatFooter = this.osJ;
                                com.tencent.mm.bl.d.cdJ();
                                if (com.tencent.mm.aq.b.PV()) {
                                    z = true;
                                }
                                chatFooter.lr(z);
                                this.osJ.ccr();
                                this.fhH.ctG();
                                qVar = this.yEz;
                                if (qVar.fhH.csZ()) {
                                    qVar.fhH.ctp().vwT = true;
                                    ctp = qVar.fhH.ctp();
                                    if (ctp.vwJ != null) {
                                        ctp.vwJ.setVisibility(8);
                                    }
                                    chatFooter = qVar.fhH.ctp();
                                    if (chatFooter.vwG != null) {
                                        chatFooter.vwG.setVisibility(8);
                                    }
                                }
                            }
                        }
                        this.osJ.lq(true);
                        this.osJ.cco();
                        this.osJ.ccq();
                        com.tencent.mm.bl.d.cdJ();
                        if (this.fhH.csV()) {
                            this.osJ.ccr();
                        }
                        if (this.fhH.csn().equals(q.FY())) {
                            this.osJ.ccr();
                            this.osJ.cco();
                            this.osJ.ccp();
                            this.osJ.ccq();
                        }
                        if (this.fhH.csT()) {
                            this.osJ.ccl();
                            this.osJ.cct();
                            this.osJ.cck();
                            this.osJ.ccr();
                            this.osJ.cco();
                            this.osJ.ccp();
                            this.osJ.ccq();
                            this.osJ.ccj();
                            this.osJ.ccn();
                            this.osJ.cci();
                            this.osJ.ccv();
                            this.osJ.tk();
                        }
                        this.osJ.B(null);
                        if (com.tencent.mm.storage.x.Xg(this.fhH.csW().field_username)) {
                            i = ((com.tencent.mm.openim.a.b) g.h(com.tencent.mm.openim.a.b.class)).oy(this.fhH.csW().field_openImAppid);
                            x.i("MicroMsg.ChattingUI.FootMgr", "openim showFlag:%d", Integer.valueOf(i));
                            if ((i & 1) == 0) {
                                this.osJ.cch();
                            }
                            if ((i & 2) == 0) {
                                this.osJ.cci();
                            }
                            if ((i & 4) == 0) {
                                appPanel = this.osJ.vwD;
                                appPanel.vvH.vwe.value = false;
                                appPanel.cbR();
                            }
                            if ((i & 8) == 0) {
                                this.osJ.cck();
                            }
                            if ((i & 16) == 0) {
                                this.osJ.ccs();
                            }
                            if ((i & 32) == 0) {
                                this.osJ.ccl();
                            }
                            if ((i & 64) == 0) {
                                this.osJ.ccx();
                            }
                            if ((i & FileUtils.S_IWUSR) == 0) {
                                this.osJ.ccm();
                            }
                            if ((i & 256) == 0) {
                                this.osJ.cco();
                            }
                            if ((i & WXMediaMessage.TITLE_LENGTH_LIMIT) == 0) {
                                this.osJ.ccp();
                                this.osJ.ccq();
                            }
                            if ((i & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) == 0) {
                                this.osJ.vwD.vvS = true;
                            }
                            this.osJ.B(((com.tencent.mm.openim.a.b) g.h(com.tencent.mm.openim.a.b.class)).i(this.fhH.csW().field_openImAppid, "openim_function_tip", com.tencent.mm.openim.a.b.a.idv));
                        }
                        this.osJ.lp(com.tencent.mm.bl.d.cdJ());
                        chatFooter = this.osJ;
                        com.tencent.mm.bl.d.cdJ();
                        if (com.tencent.mm.aq.b.PV()) {
                            z = true;
                        }
                        chatFooter.lr(z);
                        this.osJ.ccr();
                        this.fhH.ctG();
                        qVar = this.yEz;
                        if (qVar.fhH.csZ()) {
                            qVar.fhH.ctp().vwT = true;
                            ctp = qVar.fhH.ctp();
                            if (ctp.vwJ != null) {
                                ctp.vwJ.setVisibility(8);
                            }
                            chatFooter = qVar.fhH.ctp();
                            if (chatFooter.vwG != null) {
                                chatFooter.vwG.setVisibility(8);
                            }
                        }
                    }
                }
                cuy();
            }
        }
        cut();
        cuA();
        this.yIK = new o(this.fhH.ctl(), this.fhH.ctm(), this.fhH, this.osJ, this.fhH.csY());
        this.yIK.yAT = this.fhH.cte().getBooleanExtra("key_need_send_video", true).booleanValue();
        this.osJ.vwP = this.yIK;
        j vVar = new v(this.fhH.cte().getContext(), this.fhH.csW(), this.fhH.csY());
        this.osJ.b((com.tencent.mm.pluginsdk.ui.chat.f) vVar);
        this.osJ.a(vVar);
        cuC();
        this.osJ.ccu();
        cuA();
        X(this.fhH.csW());
    }

    public final void bg() {
        if (this.osJ != null) {
            this.osJ.vwP = null;
            this.yIK = null;
            this.osJ.b(null);
            this.osJ.a(null);
        }
        if (this.yIL != null) {
            this.yIL.bBI();
            this.yIL = null;
        }
        cut();
        if (this.yIL != null) {
            this.yIL.crZ();
        }
        i.clearCache();
        if (this.osJ != null) {
            ChatFooter chatFooter = this.osJ;
            if (chatFooter.vwO != null) {
                chatFooter.vwO.vyu = false;
                chatFooter.vwO.hide();
            }
        }
        if (this.fhH.cte().isCurrentActivity && this.osJ != null) {
            this.osJ.destroy();
        }
    }

    private void cut() {
        if (!this.fhH.cte().isCurrentActivity) {
            if (this.fhH.ctn() != null) {
                this.fhH.ctn().mw(true);
            }
            if (this.osJ != null) {
                ChatFooter chatFooter = this.osJ;
                View findViewById = chatFooter.findViewById(R.h.bUH);
                if (findViewById != null) {
                    findViewById.setVisibility(8);
                }
                chatFooter.CF(0);
                chatFooter.mHandler.removeMessages(1002);
                if (chatFooter.vwJ != null) {
                    chatFooter.vwJ.setVisibility(8);
                }
                if (chatFooter.vwK != null) {
                    chatFooter.vwK.setVisibility(8);
                }
                if (chatFooter.vwL != null) {
                    chatFooter.vwL.setVisibility(8);
                }
                if (chatFooter.mEs != null) {
                    chatFooter.mEs.setVisibility(8);
                }
                chatFooter.oqb.setVisibility(8);
                if (chatFooter.mEu != null) {
                    chatFooter.mEu.setVisibility(8);
                }
                if (chatFooter.mEv != null) {
                    chatFooter.mEv.setVisibility(8);
                }
                if (chatFooter.mEt != null) {
                    chatFooter.mEt.setVisibility(8);
                }
                if (chatFooter.vso != null) {
                    chatFooter.vso.setVisibility(8);
                    chatFooter.vsr = false;
                    chatFooter.vso.destroy();
                    if (chatFooter.oqa != null) {
                        chatFooter.oqa.setVisibility(0);
                    }
                }
                if (chatFooter.mEs != null) {
                    chatFooter.mEs.setVisibility(8);
                }
                if (chatFooter.siw != null) {
                    chatFooter.siw.setVisibility(8);
                }
                if (chatFooter.sit != null) {
                    chatFooter.sit.update();
                }
                if (chatFooter.vwE != null) {
                    chatFooter.vwE.setVisibility(8);
                }
                if (chatFooter.vwH != null) {
                    chatFooter.vwH.setVisibility(8);
                }
                chatFooter.vwD = (AppPanel) chatFooter.findViewById(R.h.bSP);
                if (chatFooter.vwD != null) {
                    chatFooter.CE(8);
                    AppPanel appPanel = chatFooter.vwD;
                    if (appPanel.qfg != null) {
                        appPanel.qfg.Fe(0);
                    }
                }
                if (chatFooter.oqc != null) {
                    chatFooter.oqc.destroy();
                    chatFooter.vwH.removeView(chatFooter.oqc);
                    chatFooter.oqc = null;
                }
                chatFooter.ccG();
                ChatFooter chatFooter2 = this.osJ;
                chatFooter2.oqa.setText("");
                chatFooter2.lo(false);
                this.osJ.vwR.vxP = null;
            }
        }
    }

    public final void cub() {
        String str;
        this.yIQ = this.fhH.cte().getStringExtra("smiley_product_id");
        if (this.osJ.ccH()) {
            this.yEt.keepSignalling();
        }
        if (s.gL(this.fhH.csn()) && this.yIN != null && this.yIN.yCQ) {
            this.yIN.csK();
        }
        ChatFooter chatFooter = this.osJ;
        u cte = this.fhH.cte();
        chatFooter.vxe = cte;
        if (!chatFooter.vsr) {
            chatFooter.findViewById(R.h.bTX).setVisibility(0);
        }
        chatFooter.a(cte.getContext(), cte.thisActivity());
        chatFooter.vxJ = true;
        if (!(bi.oN(this.yIQ) || this.osJ == null)) {
            x.d("MicroMsg.ChattingUI.FootMgr", "deal use smiley panel in product: %s", this.yIQ);
            chatFooter = this.osJ;
            str = this.yIQ;
            if (!bi.oN(str)) {
                if (chatFooter.oqc == null) {
                    chatFooter.ccb();
                }
                chatFooter.oqc.cf(str);
            }
            this.osJ.ccd();
        }
        this.fhH.cte().getContext().getIntent().putExtra("smiley_product_id", "");
        this.osJ.Tf(this.fhH.csW().field_username);
        chatFooter = this.osJ;
        str = this.fhH.ctj();
        String csn = this.fhH.csn();
        chatFooter.fAJ = str;
        chatFooter.toUser = csn;
        if (this.fhH.cte().getBooleanExtra("key_show_bottom_app_panel", false).booleanValue()) {
            chatFooter = this.osJ;
            if (chatFooter.vwJ != null) {
                chatFooter.vwJ.performClick();
                x.d("MicroMsg.ChatFooter", "perform click attach bt to show bottom panel");
            }
        }
        if (X(this.fhH.csW())) {
            if (this.osJ != null) {
                as.Hm();
                boolean booleanValue = ((Boolean) c.Db().get(66832, Boolean.valueOf(false))).booleanValue();
                x.d("MicroMsg.ChattingUI.FootMgr", "jacks refresh Footer Plugin Setting , Enable Enter Button: %B", Boolean.valueOf(booleanValue));
                this.osJ.ccI();
                if (booleanValue) {
                    this.osJ.ccy();
                    this.osJ.ccu();
                }
                if (booleanValue) {
                    this.osJ.cci();
                }
                chatFooter = this.osJ;
                if (chatFooter.vwD != null) {
                    chatFooter.vwD.cbQ();
                }
            }
            this.yEH.cup();
            if (this.osJ != null) {
                this.osJ.vwD.refresh();
                this.osJ.addTextChangedListener(new a());
                x.i("MicroMsg.ChattingUI.FootMgr", "addTextChangedListener");
            }
        }
        if (this.yEG.yJp || this.yEG.yAH || ((this.fhH.cto() != null && this.fhH.cto().yBT) || this.fhH.csW() == null || this.fhH.csW().ciN() || s.hn(this.fhH.csW().field_username) || com.tencent.mm.ui.snackbar.a.aHO())) {
            x.i("MicroMsg.ChattingUI.FootMgr", "no call visibleFooter again.");
            return;
        }
        x.i("MicroMsg.ChattingUI.FootMgr", "call visibleFooter again.");
        cux();
    }

    public final void cuu() {
        if (this.osJ != null) {
            ChatFooter chatFooter = this.osJ;
            if (chatFooter.vxk != null) {
                chatFooter.oqa.removeTextChangedListener(chatFooter.vxk);
                chatFooter.vxk = null;
            }
            x.i("MicroMsg.ChattingUI.FootMgr", "removeTextChangeListener");
            this.osJ.onPause();
            if (g.Do().CF()) {
                as.Hm();
                c.Db().set(18, Integer.valueOf(this.osJ.vwW));
                x.d("MicroMsg.ChattingUI.FootMgr", "dkcm old:%d footer:%d ", Integer.valueOf(this.yIM), Integer.valueOf(this.osJ.vwW));
                if (this.yIM != this.osJ.vwW) {
                    this.yIM = this.osJ.vwW;
                    as.Hm();
                    ae XF = c.Fk().XF(this.fhH.csn());
                    if (XF != null && this.fhH.csn().equals(XF.field_username)) {
                        XF.eQ(this.yIM);
                        as.Hm();
                        c.Fk().a(XF, this.fhH.csn());
                    }
                }
                this.osJ.aKv();
                return;
            }
            x.w("MicroMsg.ChattingUI.FootMgr", "account not ready");
        }
    }

    public final boolean e(int i, Intent intent) {
        if (!(i == com.tencent.mm.plugin.appbrand.jsapi.media.e.CTRL_INDEX || this.yIL == null)) {
            this.yIL.j(i, intent);
        }
        switch (i) {
            case 202:
                if (intent == null) {
                    x.e("MicroMsg.ChattingUI.FootMgr", "CONTEXT_MENU_WECHAT_GALLERY_IMAGE intent == null");
                    return true;
                }
                int intExtra = intent.getIntExtra("Chat_Mode", 1);
                if (this.osJ == null) {
                    return true;
                }
                this.osJ.ab(intExtra, true);
                return true;
            default:
                return false;
        }
    }

    public final void cuv() {
        try {
            if (this.osJ.ccA()) {
                this.osJ.ccC();
            }
        } catch (Exception e) {
        }
    }

    public final void cuw() {
        x.i("MicroMsg.ChattingUI.FootMgr", "visibleCustomFooter customFooter is %s", this.yIL);
        if (this.yIL != null) {
            this.yIL.setVisibility(0);
            if (this.osJ != null) {
                this.osJ.setVisibility(8);
            }
        }
    }

    public final void cux() {
        if (this.osJ != null) {
            this.osJ.setVisibility(0);
            if (this.yIL != null) {
                this.yIL.setVisibility(8);
            }
        }
    }

    private void cuy() {
        if (this.osJ != null) {
            this.osJ.setVisibility(8);
        }
        if (this.yIL != null) {
            this.yIL.setVisibility(8);
        }
    }

    public final void cuz() {
        this.yIP = new AnimationSet(false);
        Animation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 1.0f, 1, 0.0f);
        Animation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        this.yIP.setInterpolator(new DecelerateInterpolator(1.5f));
        this.yIP.addAnimation(translateAnimation);
        this.yIP.addAnimation(alphaAnimation);
        this.yIP.setDuration(300);
        this.yIP.setFillBefore(true);
        if (this.osJ != null) {
            this.osJ.startAnimation(this.yIP);
        }
    }

    private void cuA() {
        x.i("MicroMsg.ChattingUI.FootMgr", "isTempSession : %s, showType : %d.", Boolean.valueOf(this.fhH.csX()), Integer.valueOf(this.fhH.cte().getIntExtra("key_temp_session_show_type", 0)));
        as.Hm();
        ak XF = c.Fk().XF(this.fhH.csW().field_username);
        if (this.fhH.csX()) {
            as.CN().a(new k(this.fhH.csY(), this.fhH.cte().getIntExtra("key_temp_session_scene", 5), this.fhH.cte().getStringExtra("key_temp_session_from")), 0);
        }
        boolean a;
        if (!this.fhH.csW().ciN() || com.tencent.mm.k.a.ga(this.fhH.csW().field_type)) {
            this.fhH.mO(false);
        } else if (XF == null) {
            if (this.fhH.csX()) {
                ae aeVar = new ae(this.fhH.csW().field_username);
                aeVar.gc(4194304);
                aeVar.cjn();
                as.Hm();
                c.Fk().d(aeVar);
            }
        } else if (XF.gd(4194304)) {
            this.fhH.mO(true);
        } else if (XF.field_conversationTime < y.Mx()) {
            as.Hm();
            a = c.Fk().a(this.fhH.csW().field_username, 4194304, true, XF.field_attrflag);
            x.i("MicroMsg.ChattingUI.FootMgr", "It is a old version temp session, Set attr flag(talker : %s), %s", this.fhH.csW().field_username, Boolean.valueOf(a));
            this.fhH.mO(true);
        } else if (this.fhH.csX()) {
            as.Hm();
            a = c.Fk().a(this.fhH.csW().field_username, 4194304, true, XF.field_attrflag);
            x.i("MicroMsg.ChattingUI.FootMgr", "It is a temp session, Set attr flag(talker : %s), %s", this.fhH.csW().field_username, Boolean.valueOf(a));
        }
        x.d("MicroMsg.ChattingUI.FootMgr", "is temp session : %s.", Boolean.valueOf(this.fhH.csX()));
        if (!this.fhH.csX()) {
            return;
        }
        if (r0 == 1) {
            this.vwQ.lu(true);
        } else {
            this.vwQ.lu(false);
        }
    }

    public final void cuB() {
        x.i("MicroMsg.ChattingUI.FootMgr", "triggerFooter");
        if (this.osJ == null) {
            this.osJ = (ChatFooter) this.fhH.cte().findViewById(R.h.cyL);
        }
        if ((this.fhH.cto() == null || !this.fhH.cto().yBT) && !com.tencent.mm.ui.snackbar.a.aHO()) {
            this.yIT = false;
            if (this.yIR == 8 && this.yIS == 8) {
                cuy();
                return;
            } else if (this.yIR == 0) {
                cux();
                return;
            } else {
                cuw();
                return;
            }
        }
        if (!this.yIT) {
            this.yIR = this.osJ.getVisibility();
        }
        this.osJ.p(0, -1, false);
        if (this.yIL == null) {
            this.yIS = -1;
        } else if (!this.yIT) {
            this.yIS = this.yIL.getVisibility();
        }
        cuy();
        this.yIT = true;
    }

    public final boolean X(com.tencent.mm.storage.x xVar) {
        if (this.yEG.yJp || this.yEG.yAH || (this.fhH.cto() != null && this.fhH.cto().yBT)) {
            cuy();
            return false;
        }
        if (!(xVar == null || !xVar.ciN() || this.fhH.ctb() == null)) {
            com.tencent.mm.af.d.b bK = this.fhH.ctb().bK(false);
            if (bK != null) {
                if (bK.hqe != null) {
                    bK.hqg = "1".equals(bK.hqe.optString("IsHideInputToolbarInMsg"));
                }
                if (bK.hqg) {
                    x.i("MicroMsg.ChattingUI.FootMgr", "bizinfo name=" + xVar.field_username + " is hide tool bar");
                    cuy();
                    return false;
                }
            }
            if (!(bi.oN(xVar.field_username) || bK == null)) {
                int intExtra = this.fhH.cte().getIntExtra("key_temp_session_show_type", 0);
                switch (bK.LC()) {
                    case 2:
                        x.i("MicroMsg.ChattingUI.FootMgr", "bizinfo name=" + xVar.field_username + " is show custom menu");
                        if (this.yIL == null) {
                            g.a(this.fhH.cte(), R.h.cyK);
                            this.yIL = (ChatFooterCustom) this.fhH.cte().findViewById(R.h.cyM);
                            this.yIL.k((ViewGroup) this.fhH.cte().findViewById(R.h.bTG));
                        }
                        com.tencent.mm.af.d.b.c LK = bK.LK();
                        if (LK != null && LK.type == 1) {
                            this.osJ.CF(1);
                            this.osJ.a(this.yEL.yyA);
                            cux();
                            break;
                        }
                        this.osJ.CF(0);
                        try {
                            if (!s.gE(xVar.field_username)) {
                                ChatFooterCustom chatFooterCustom = this.yIL;
                                if (chatFooterCustom.yzt != null) {
                                    chatFooterCustom.yzt.setVisibility(0);
                                }
                                if (chatFooterCustom.yzu != null) {
                                    chatFooterCustom.yzu.csc();
                                }
                                this.yIL.fBc = this.fhH.csW();
                                this.yIL.a(this.fhH.cte(), this.fhH.ctb(), xVar.field_username);
                                this.yIL.vwQ = this.vwQ;
                                this.yIL.yzv = this.yEL.yHw;
                                this.osJ.a(this.vwQ);
                                if (!this.fhH.csX() || intExtra != 1) {
                                    cuw();
                                    break;
                                }
                                cux();
                                break;
                            }
                            this.yIO = new w(this.yIL);
                            this.yIO.cqc();
                            cuw();
                            break;
                        } catch (Throwable e) {
                            if (LK == null || LK.hqO == null || LK.hqO.size() == 0) {
                                cux();
                            } else {
                                this.vwQ.lu(true);
                            }
                            x.printErrStackTrace("MicroMsg.ChattingUI.FootMgr", e, "", new Object[0]);
                            break;
                        }
                        break;
                    default:
                        boolean z;
                        cux();
                        String str = "MicroMsg.ChattingUI.FootMgr";
                        String str2 = "bizinfo name=%s, %b, %d";
                        Object[] objArr = new Object[3];
                        objArr[0] = xVar.field_username;
                        if (bK != null) {
                            z = true;
                        } else {
                            z = false;
                        }
                        objArr[1] = Boolean.valueOf(z);
                        objArr[2] = Integer.valueOf(bK.LC());
                        x.e(str, str2, objArr);
                        break;
                }
            }
        }
        return true;
    }

    public final void cuC() {
        int i;
        String csY = this.fhH.csY();
        if (s.gN(csY) || com.tencent.mm.storage.x.Xd(csY)) {
            i = 1;
        } else if (s.hd(csY)) {
            i = 2;
        } else {
            i = this.fhH.cte().getIntExtra("Chat_Mode", 0);
            x.d("MicroMsg.ChattingUI.FootMgr", "dkcm getChatMode old:%d intent:%d ", Integer.valueOf(this.yIM), Integer.valueOf(i));
            if (this.yIM != 0) {
                i = this.yIM;
            }
            String value = com.tencent.mm.j.g.Af().getValue("DefaultMsgType");
            if (this.yIM == 0 && value != null) {
                x.d("MicroMsg.ChattingUI.FootMgr", "config def chatmode is %s", value);
                i = bi.getInt(com.tencent.mm.j.g.Af().getValue("DefaultMsgType"), 0);
            }
            if (i == 0 && com.tencent.mm.k.a.ga(this.fhH.csW().field_type)) {
                as.Hm();
                i = ((Integer) c.Db().get(18, Integer.valueOf(0))).intValue();
            }
            if (i == 0) {
                i = 1;
            }
            x.d("MicroMsg.ChattingUI.FootMgr", "dkcm getChatMode old:%d intent:%d ", Integer.valueOf(this.yIM), Integer.valueOf(i));
        }
        if (i == 2) {
            x.i("MicroMsg.ChattingUI.FootMgr", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(this.fhH.cte().thisActivity(), "android.permission.RECORD_AUDIO", 80, "", "")), bi.chl(), this.fhH.cte().thisActivity());
            if (com.tencent.mm.pluginsdk.g.a.a(this.fhH.cte().thisActivity(), "android.permission.RECORD_AUDIO", 80, "", "")) {
                this.osJ.ab(i, false);
                return;
            }
            return;
        }
        this.osJ.ab(i, false);
    }

    public final void cuD() {
        x.i("MicroMsg.ChattingUI.FootMgr", "summerper setFooterMode mode[%d], footer[%s], stack[%s]", Integer.valueOf(2), this.osJ, bi.chl());
        if (this.osJ != null) {
            this.osJ.ab(2, true);
        }
    }

    public final void cso() {
        x.i("MicroMsg.ChattingUI.FootMgr", "summerper doOnEnterMultiTalk,footerEventImpl[%s], stack[%s]", this.yIK, bi.chl());
        if (this.yIK != null) {
            this.yIK.cso();
        }
    }

    public final void cuE() {
        int i = 0;
        x.i("MicroMsg.ChattingUI.FootMgr", "summerper doFooterSightRequest,footerEventImpl[%s], stack[%s]", this.yIK, bi.chl());
        if (this.yIK != null) {
            o oVar = this.yIK;
            if (!this.osJ.vwD.vvH.vwu.value) {
                i = 2;
            }
            oVar.FM(i);
        }
    }

    public final void csp() {
        x.i("MicroMsg.ChattingUI.FootMgr", "summerper doOnVoipAudioRequest,footerEventImpl[%s], stack[%s]", this.yIK, bi.chl());
        if (this.yIK != null) {
            this.yIK.csp();
        }
    }

    public final void csq() {
        x.i("MicroMsg.ChattingUI.FootMgr", "summerper doOnVoipRequest,footerEventImpl[%s], stack[%s]", this.yIK, bi.chl());
        if (this.yIK != null) {
            this.yIK.csq();
        }
    }

    public final void bkj() {
        x.i("MicroMsg.ChattingUI.FootMgr", "summerper doVoipMenuVideoSelected,footerEventImpl[%s], stack[%s]", this.yIK, bi.chl());
        if (this.yIK != null) {
            this.yIK.bkj();
        }
    }

    public final void bki() {
        x.i("MicroMsg.ChattingUI.FootMgr", "summerper doVoipMenuAudioSelected,footerEventImpl[%s], stack[%s]", this.yIK, bi.chl());
        if (this.yIK != null) {
            this.yIK.bki();
        }
    }

    public final void csr() {
        x.i("MicroMsg.ChattingUI.FootMgr", "summerper doTalkRoomRequest,footerEventImpl[%s], stack[%s]", this.yIK, bi.chl());
        if (this.yIK != null) {
            this.yIK.csr();
        }
    }

    public final void css() {
        x.i("MicroMsg.ChattingUI.FootMgr", "summerper doImageSelectTakePhotoRequest,footerEventImpl[%s], stack[%s]", this.yIK, bi.chl());
        if (this.yIK != null) {
            this.yIK.css();
        }
    }
}
