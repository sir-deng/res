package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.af.y;
import com.tencent.mm.f.a.cq;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.f.b.cg;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.viewitems.ar;
import com.tencent.mm.ui.widget.MMNeatTextView;
import com.tencent.mm.ui.widget.MMTextView;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bb;
import com.tencent.mm.y.q;
import com.tencent.mm.y.s;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import java.util.Map;

public final class r {

    public static class g extends d {
        public g(com.tencent.mm.ui.chatting.ChattingUI.a aVar) {
            super(aVar);
        }

        public final void a(View view, com.tencent.mm.ui.chatting.ChattingUI.a aVar, au auVar) {
            ar arVar = (ar) view.getTag();
            Intent intent = new Intent();
            intent.putExtra("geta8key_username", aVar.csn());
            intent.putExtra("rawUrl", arVar.gkB);
            com.tencent.mm.bl.d.b(aVar.getContext(), "webview", ".ui.tools.WebViewUI", intent);
        }
    }

    public static class h extends d {
        public h(com.tencent.mm.ui.chatting.ChattingUI.a aVar) {
            super(aVar);
        }

        public final void a(View view, com.tencent.mm.ui.chatting.ChattingUI.a aVar, au auVar) {
            ar arVar = (ar) view.getTag();
            int i = arVar.designerUIN;
            String str = arVar.designerName;
            String str2 = arVar.designerRediretctUrl;
            if (i != 0) {
                Intent intent = new Intent();
                intent.putExtra("geta8key_username", aVar.csn());
                intent.putExtra("rawUrl", arVar.gkB);
                intent.putExtra(OpenSDKTool4Assistant.EXTRA_UIN, i);
                intent.putExtra("name", str);
                intent.putExtra("rediret_url", str2);
                intent.putExtra("extra_scence", 22);
                com.tencent.mm.bl.d.b(aVar.getContext(), "emoji", ".ui.v2.EmojiStoreV2DesignerUI", intent);
            }
        }
    }

    public static class i extends d {
        public i(com.tencent.mm.ui.chatting.ChattingUI.a aVar) {
            super(aVar);
        }

        public final void a(View view, com.tencent.mm.ui.chatting.ChattingUI.a aVar, au auVar) {
            ar arVar = (ar) view.getTag();
            int i = arVar.tid;
            String str = arVar.heX;
            String str2 = arVar.desc;
            String str3 = arVar.iconUrl;
            String str4 = arVar.secondUrl;
            int i2 = arVar.pageType;
            if (i != 0) {
                Intent intent = new Intent();
                intent.putExtra("geta8key_username", aVar.csn());
                intent.putExtra("rawUrl", arVar.gkB);
                intent.putExtra("set_id", i);
                intent.putExtra("set_title", str);
                intent.putExtra("set_iconURL", str3);
                intent.putExtra("set_desc", str2);
                intent.putExtra("headurl", str4);
                intent.putExtra("pageType", i2);
                com.tencent.mm.bl.d.b(aVar.getContext(), "emoji", ".ui.v2.EmojiStoreV2SingleProductUI", intent);
                return;
            }
            x.i("MicroMsg.DesignerClickListener", "topic id is zero.");
        }
    }

    public static class j extends d {
        public j(com.tencent.mm.ui.chatting.ChattingUI.a aVar) {
            super(aVar);
        }

        public final void a(View view, com.tencent.mm.ui.chatting.ChattingUI.a aVar, au auVar) {
            ar arVar = (ar) view.getTag();
            Object obj = arVar.frQ;
            if (TextUtils.isEmpty(obj)) {
                obj = ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().yN(arVar.gkB);
            }
            if (TextUtils.isEmpty(obj)) {
                Intent intent = new Intent();
                intent.putExtra("geta8key_username", aVar.csn());
                intent.putExtra("rawUrl", arVar.gkB);
                com.tencent.mm.bl.d.b(aVar.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                return;
            }
            Intent intent2 = new Intent();
            intent2.putExtra("extra_id", obj);
            intent2.putExtra("extra_name", arVar.title);
            if (arVar.yXx) {
                intent2.putExtra("download_entrance_scene", 20);
                intent2.putExtra("preceding_scence", 3);
                intent2.putExtra("reward_tip", true);
                com.tencent.mm.plugin.report.service.g.pWK.h(12953, Integer.valueOf(1), obj);
            } else if (arVar.yXy) {
                intent2.putExtra("download_entrance_scene", 25);
                intent2.putExtra("preceding_scence", 9);
                intent2.putExtra("reward_tip", true);
            } else {
                intent2.putExtra("download_entrance_scene", 22);
                intent2.putExtra("preceding_scence", 122);
                com.tencent.mm.plugin.report.service.g.pWK.h(10993, Integer.valueOf(2), obj);
            }
            com.tencent.mm.bl.d.b(aVar.getContext(), "emoji", ".ui.EmojiStoreDetailUI", intent2);
        }
    }

    public static class k extends d {
        public k(com.tencent.mm.ui.chatting.ChattingUI.a aVar) {
            super(aVar);
        }

        public final void a(View view, com.tencent.mm.ui.chatting.ChattingUI.a aVar, au auVar) {
            ar arVar = (ar) view.getTag();
            int i = arVar.tid;
            String str = arVar.heX;
            String str2 = arVar.desc;
            String str3 = arVar.iconUrl;
            String str4 = arVar.secondUrl;
            if (i != 0) {
                Intent intent = new Intent();
                intent.putExtra("geta8key_username", aVar.csn());
                intent.putExtra("rawUrl", arVar.gkB);
                intent.putExtra("topic_id", i);
                intent.putExtra("topic_name", str);
                intent.putExtra("topic_desc", str2);
                intent.putExtra("topic_icon_url", str3);
                intent.putExtra("topic_ad_url", str4);
                intent.putExtra("extra_scence", 22);
                com.tencent.mm.bl.d.b(aVar.getContext(), "emoji", ".ui.EmojiStoreTopicUI", intent);
                return;
            }
            x.i("MicroMsg.DesignerClickListener", "topic id is zero.");
        }
    }

    public static class o extends d {
        public o(com.tencent.mm.ui.chatting.ChattingUI.a aVar) {
            super(aVar);
        }

        public final void a(View view, com.tencent.mm.ui.chatting.ChattingUI.a aVar, au auVar) {
            ar arVar = (ar) view.getTag();
            x.d("MicroMsg.WebViewClickListener", "edw timestamp, onClick = " + System.currentTimeMillis());
            if (!e.a(arVar.fMx, aVar.getContext(), null, aVar.csn())) {
                String str = arVar.userName;
                String str2 = arVar.yXw;
                if (str != null && !str.equals("")) {
                    int i;
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", str);
                    intent.putExtra("shortUrl", str);
                    intent.putExtra("webpageTitle", str2);
                    Bundle bundle = new Bundle();
                    if (auVar != null) {
                        if (auVar.cjR()) {
                            Map y = bj.y(auVar.field_content, "msg");
                            if (y != null) {
                                com.tencent.mm.ui.chatting.viewitems.q.b ay = com.tencent.mm.ui.chatting.viewitems.q.b.ay(y);
                                if (!t.oN(ay.hdN)) {
                                    intent.putExtra("KTemplateId", ay.hdN);
                                    x.d("MicroMsg.WebViewClickListener", "report template msg click action, templateId(%s). srcUsername(%s)", ay.hdN, arVar.fHu);
                                    com.tencent.mm.plugin.report.service.g.pWK.h(11608, ay.hdN, arVar.fHu, Integer.valueOf(0));
                                }
                            }
                        }
                        as.Hm();
                        ag Xv = com.tencent.mm.y.c.Ff().Xv(auVar.field_talker);
                        if (Xv == null || !Xv.ciN()) {
                            i = 0;
                        } else {
                            i = 4;
                            x.d("MicroMsg.WebViewClickListener", "hakon click biz msg %s", Xv.field_username);
                        }
                        intent.putExtra("msg_id", auVar.field_msgId);
                        intent.putExtra("KPublisherId", "msg_" + Long.toString(auVar.field_msgSvrId));
                        intent.putExtra("pre_username", auVar.field_talker);
                        intent.putExtra("prePublishId", "msg_" + Long.toString(auVar.field_msgSvrId));
                        intent.putExtra("preUsername", com.tencent.mm.ui.chatting.viewitems.b.a(auVar, arVar.yxU, aVar.yEL.vus));
                        intent.putExtra("preChatName", aVar.csn());
                        intent.putExtra("preChatTYPE", com.tencent.mm.y.t.N(com.tencent.mm.ui.chatting.viewitems.b.a(auVar, arVar.yxU, aVar.yEL.vus), aVar.csn()));
                        intent.putExtra("preMsgIndex", arVar.tzE);
                        Bundle bundle2 = arVar.yXC;
                        if (bundle2 != null) {
                            intent.putExtras(bundle2);
                        }
                    } else {
                        i = 0;
                    }
                    bundle.putInt("snsWebSource", i);
                    intent.putExtra("jsapiargs", bundle);
                    intent.putExtra("geta8key_username", aVar.csn());
                    if (!t.oN(arVar.fHu)) {
                        intent.putExtra("srcUsername", arVar.fHu);
                        intent.putExtra("srcDisplayname", arVar.fHv);
                        intent.putExtra("mode", 1);
                    }
                    intent.putExtra("message_id", arVar.tzD);
                    intent.putExtra("message_index", arVar.tzE);
                    intent.putExtra("from_scence", 1);
                    com.tencent.mm.bl.d.b(aVar.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                    if (!t.oN(aVar.csn())) {
                        as.Hm();
                        if (com.tencent.mm.y.c.Ff().Xv(aVar.csn()).fXs == 1) {
                            as.Hm();
                            com.tencent.mm.y.c.Fk().XJ(aVar.csn());
                        }
                    }
                }
            }
        }
    }

    public static class a extends b {
        public a(com.tencent.mm.ui.chatting.ChattingUI.a aVar) {
            super(aVar);
        }

        public final void a(Intent intent, ar arVar) {
            if (!t.oN(arVar.yXz)) {
                intent.putExtra("Contact_BIZ_KF_WORKER_ID", arVar.yXz);
            }
        }
    }

    public static class c implements OnLongClickListener {
        private com.tencent.mm.ui.chatting.ChattingUI.a yyH;

        public c(com.tencent.mm.ui.chatting.ChattingUI.a aVar) {
            this.yyH = aVar;
        }

        public final boolean onLongClick(View view) {
            if (this.yyH.yFg) {
                ar arVar = (ar) view.getTag();
                int selectionStart = this.yyH.yEM.ctp().oqa.getSelectionStart();
                if (!arVar.userName.equals(q.FY())) {
                    if (this.yyH.yEM.ctp().vsr) {
                        x.i("MicroMsg.ChattingListAvatarListener", "ChatFooter VoiceInputPanel Show NOW!!!");
                    } else if (s.eX(this.yyH.csn()) || this.yyH.yEL.yHs) {
                        String gw;
                        com.tencent.mm.plugin.report.service.g.pWK.h(10976, Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0));
                        as.Hm();
                        com.tencent.mm.storage.q hG = com.tencent.mm.y.c.Fo().hG(arVar.chatroomName);
                        if (this.yyH.yEL.yHs) {
                            gw = this.yyH.gw(arVar.userName);
                        } else {
                            gw = AtSomeoneUI.a(hG, arVar.userName);
                            if (t.oN(gw)) {
                                gw = com.tencent.mm.y.r.gu(arVar.userName);
                            }
                        }
                        StringBuffer stringBuffer = new StringBuffer(this.yyH.yEM.ctp().ccf());
                        stringBuffer.insert(selectionStart, "@" + gw + 8197);
                        this.yyH.yEM.ctp().p(stringBuffer.toString(), (selectionStart + gw.length()) + 2, true);
                        this.yyH.yEM.ctp().ae(arVar.chatroomName, arVar.userName, gw);
                        this.yyH.yFg = false;
                        this.yyH.yEM.ctp().ab(1, true);
                        view.postDelayed(new Runnable() {
                            public final void run() {
                                c.this.yyH.yFg = true;
                            }
                        }, 2000);
                    } else if (s.gH(this.yyH.csn()) && !this.yyH.csn().contains("@")) {
                        String gu;
                        com.tencent.mm.plugin.report.service.g.pWK.h(10976, Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(1));
                        if (!this.yyH.yEL.vus || this.yyH.yEL.yHs) {
                            gu = com.tencent.mm.y.r.gu(arVar.userName);
                        } else {
                            gu = this.yyH.gw(arVar.userName);
                        }
                        StringBuffer stringBuffer2 = new StringBuffer(this.yyH.yEM.ctp().ccf());
                        stringBuffer2.insert(selectionStart, gu);
                        this.yyH.yEM.ctp().p(stringBuffer2.toString(), gu.length() + selectionStart, true);
                        this.yyH.yFg = false;
                        this.yyH.yEM.ctp().ab(1, true);
                        view.postDelayed(new Runnable() {
                            public final void run() {
                                c.this.yyH.yFg = true;
                            }
                        }, 2000);
                    }
                }
            } else {
                x.w("MicroMsg.ChattingListAvatarListener", "ChattingUI disable Touch NOW!!!");
            }
            return true;
        }
    }

    public static class e implements com.tencent.mm.ui.widget.MMTextView.b {
        com.tencent.mm.sdk.platformtools.ag handler = new com.tencent.mm.sdk.platformtools.ag() {
            public final void handleMessage(Message message) {
                View view = (View) message.obj;
                if (e.this.tCC != view.getScrollY()) {
                    e.this.sft = true;
                    e.this.handler.sendMessageDelayed(e.this.handler.obtainMessage(0, view), 5);
                    e.this.tCC = view.getScrollY();
                    return;
                }
                e.this.sft = false;
            }
        };
        private com.tencent.mm.ui.base.q iqe = null;
        private ScrollView jmE = null;
        private long pFa = 0;
        boolean sft = false;
        private boolean sfu = false;
        int tCC = 0;
        private OnTouchListener xVS = null;
        private MMTextView yCn = null;
        private TextView yCo = null;
        private final int yCp = 3;
        private int yCq = 0;
        private int yCr = 0;
        private com.tencent.mm.ui.chatting.ChattingUI.a yyH = null;

        public e(com.tencent.mm.ui.chatting.ChattingUI.a aVar) {
            this.yyH = aVar;
        }

        public final boolean do(View view) {
            if (view.getTag() instanceof ar) {
                ar arVar = (ar) view.getTag();
                if (!((!(view instanceof TextView) && !(view instanceof MMNeatTextView)) || arVar.fFE == null || this.yyH == null)) {
                    CharSequence charSequence = "";
                    if (view instanceof TextView) {
                        charSequence = ((TextView) view).getText();
                    } else if (view instanceof MMNeatTextView) {
                        charSequence = ((MMNeatTextView) view).mText;
                    }
                    Context context = this.yyH.getContext();
                    Intent intent = new Intent(context, TextPreviewUI.class);
                    intent.putExtra("key_chat_text", charSequence);
                    context.startActivity(intent);
                    com.tencent.mm.ui.base.b.fG(context);
                    return true;
                }
            }
            return false;
        }
    }

    public static class l extends d {
        public l(com.tencent.mm.ui.chatting.ChattingUI.a aVar) {
            super(aVar);
        }

        public final void a(View view, com.tencent.mm.ui.chatting.ChattingUI.a aVar, au auVar) {
            com.tencent.mm.ui.base.h.a(aVar.getContext(), aVar.getString(R.l.dZQ), "", aVar.getString(R.l.dZS), aVar.getString(R.l.dZP), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    com.tencent.mm.sdk.b.b cqVar = new cq();
                    cqVar.frJ.frK = true;
                    com.tencent.mm.sdk.b.a.xmy.m(cqVar);
                }
            }, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    com.tencent.mm.sdk.b.b cqVar = new cq();
                    cqVar.frJ.frK = false;
                    com.tencent.mm.sdk.b.a.xmy.m(cqVar);
                }
            });
        }
    }

    public static class n {
        au fFE;
        String hdN;
        String sfb;

        public n(String str, au auVar, String str2) {
            this.hdN = str;
            this.fFE = auVar;
            this.sfb = str2;
        }
    }

    public static class b implements View.OnClickListener {
        private com.tencent.mm.ui.chatting.ChattingUI.a yyH;

        public b(com.tencent.mm.ui.chatting.ChattingUI.a aVar) {
            this.yyH = aVar;
        }

        public void onClick(View view) {
            boolean z = false;
            ar arVar = (ar) view.getTag();
            String str = arVar.userName;
            if (str != null && !str.equals("")) {
                Intent intent;
                if (this.yyH.vwT) {
                    Context context = this.yyH.getContext();
                    intent = new Intent();
                    intent.putExtra("Contact_User", str);
                    intent.putExtra("Contact_Encryptusername", true);
                    intent.putExtra("Contact_IsLBSFriend", true);
                    intent.putExtra("Contact_IsLbsChattingProfile", true);
                    com.tencent.mm.bl.d.b(context, "profile", ".ui.ContactInfoUI", intent);
                } else if (this.yyH.yEL.vus) {
                    com.tencent.mm.af.a.j kn = this.yyH.yEL.yvJ.kn(str);
                    if (kn == null) {
                        return;
                    }
                    if (kn == null || t.oN(kn.field_profileUrl)) {
                        str = "MicroMsg.ChattingListAvatarListener";
                        String str2 = "onClick userInfo == null:%s";
                        Object[] objArr = new Object[1];
                        objArr[0] = Boolean.valueOf(kn == null);
                        x.w(str, str2, objArr);
                        return;
                    }
                    x.i("MicroMsg.ChattingListAvatarListener", "onClick Url:%s", kn.field_profileUrl);
                    y.Mr().aj(kn.field_userId, kn.field_brandUserName);
                    intent = new Intent();
                    intent.putExtra("rawUrl", kn.field_profileUrl);
                    intent.putExtra("useJs", true);
                    com.tencent.mm.bl.d.b(this.yyH.thisActivity(), "webview", ".ui.tools.WebViewUI", intent);
                } else {
                    Intent intent2 = new Intent();
                    intent2.putExtra("Contact_User", str);
                    a(intent2, arVar);
                    as.Hm();
                    ag Xv = com.tencent.mm.y.c.Ff().Xv(str);
                    if (Xv != null && ((int) Xv.gKO) > 0 && com.tencent.mm.k.a.ga(Xv.field_type)) {
                        com.tencent.mm.ui.contact.e.a(intent2, str);
                    }
                    if (s.eX(this.yyH.fBc.field_username)) {
                        as.Hm();
                        com.tencent.mm.storage.q hH = com.tencent.mm.y.c.Fo().hH(this.yyH.fBc.field_username);
                        intent2.putExtra("Contact_RoomNickname", hH.gw(str));
                        intent2.putExtra("Contact_Scene", 14);
                        intent2.putExtra("Contact_ChatRoomId", this.yyH.fBc.field_username);
                        intent2.putExtra("room_name", this.yyH.fBc.field_username);
                        if (hH.field_roomowner != null) {
                            z = hH.field_roomowner.equals(q.FY());
                        }
                        intent2.putExtra("Is_RoomOwner", z);
                    }
                    if (arVar.fFE != null) {
                        switch (arVar.fFE.getType()) {
                            case 55:
                            case 57:
                                intent2.putExtra("Contact_Scene", 34);
                                intent2.putExtra("Contact_IsLBSFriend", true);
                                break;
                        }
                    }
                    com.tencent.mm.bl.d.b(this.yyH.getContext(), "profile", ".ui.ContactInfoUI", intent2, com.tencent.mm.plugin.appbrand.jsapi.bio.face.c.CTRL_INDEX);
                }
            }
        }

        public void a(Intent intent, ar arVar) {
        }
    }

    public static abstract class d implements View.OnClickListener {
        public com.tencent.mm.ui.chatting.ChattingUI.a yyH;

        public abstract void a(View view, com.tencent.mm.ui.chatting.ChattingUI.a aVar, au auVar);

        public d(com.tencent.mm.ui.chatting.ChattingUI.a aVar) {
            this.yyH = aVar;
        }

        public final void onClick(View view) {
            au auVar = ((ar) view.getTag()).fFE;
            if (auVar != null) {
                a(view, this.yyH, auVar);
            }
        }
    }

    static class f implements OnTouchListener {
        private int[] yCt = new int[2];

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.yCt[0] = (int) motionEvent.getRawX();
                    this.yCt[1] = (int) motionEvent.getRawY();
                    view.setTag(R.h.cSM, this.yCt);
                    break;
            }
            return false;
        }
    }

    public static class m extends d {
        public m(com.tencent.mm.ui.chatting.ChattingUI.a aVar) {
            super(aVar);
        }

        public final void a(View view, com.tencent.mm.ui.chatting.ChattingUI.a aVar, au auVar) {
            final cg cgVar = ((ar) view.getTag()).fFE;
            if (cgVar == null) {
                return;
            }
            if (cgVar == null || cgVar.gkC != 80) {
                com.tencent.mm.ui.base.h.a(this.yyH.getContext(), this.yyH.getString(R.l.dSS), "", this.yyH.getString(R.l.dGG), this.yyH.getString(R.l.dEy), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        boolean z = true;
                        if (cgVar.aNJ()) {
                            com.tencent.mm.pluginsdk.model.app.l.aa(cgVar);
                            bb.aL(cgVar.field_msgId);
                            m.this.yyH.mT(true);
                            return;
                        }
                        cgVar.ckj();
                        as.Hm();
                        com.tencent.mm.y.c.Fh().a(cgVar.field_msgId, cgVar);
                        if (!m.this.yyH.yyW.aP(cgVar) && !m.this.yyH.yEB.aP(cgVar) && !m.this.yyH.yEy.aN(cgVar)) {
                            if (cgVar.cjV()) {
                                m.this.yyH.yEJ.aH(cgVar);
                            } else if (!m.this.yyH.yEF.aP(cgVar)) {
                                com.tencent.mm.ui.chatting.b.d dVar = m.this.yyH.yEE;
                                cg cgVar = cgVar;
                                if (cgVar.cjU()) {
                                    if (!dVar.fhH.csW().field_username.equals("medianote")) {
                                        as.Hm();
                                        com.tencent.mm.y.c.Fe().b(new com.tencent.mm.ax.e(cgVar.field_talker, cgVar.field_msgSvrId));
                                    }
                                    af.aJ(cgVar);
                                    dVar.fhH.mT(true);
                                } else {
                                    z = false;
                                }
                                if (!z) {
                                    x.e("MicroMsg.DesignerClickListener", "uknown msg type");
                                }
                            }
                        }
                    }
                }, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                return;
            }
            x.w("MicroMsg.DesignerClickListener", "[dealClickStateBtn] %s", cgVar.field_imgPath);
            com.tencent.mm.ui.base.h.b(this.yyH.getContext(), this.yyH.getContext().getString(R.l.elM), this.yyH.getContext().getString(R.l.cSb), true);
        }
    }
}
