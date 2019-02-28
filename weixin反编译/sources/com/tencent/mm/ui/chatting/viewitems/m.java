package com.tencent.mm.ui.chatting.viewitems;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ap.o;
import com.tencent.mm.f.a.di;
import com.tencent.mm.f.a.hz;
import com.tencent.mm.f.a.mv;
import com.tencent.mm.f.a.qr;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.e;
import com.tencent.mm.modelappbrand.f;
import com.tencent.mm.modelappbrand.h;
import com.tencent.mm.modelappbrand.q;
import com.tencent.mm.modelappbrand.r;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.jsapi.ar;
import com.tencent.mm.plugin.appbrand.q.k;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.i;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import com.tencent.mm.y.bb;
import com.tencent.mm.y.u;
import com.tencent.wcdb.FileUtils;
import java.lang.ref.WeakReference;

public final class m {

    public static class b extends b implements f {
        private q iYB = new r((f) this);
        private com.tencent.mm.ui.chatting.ChattingUI.a yyH;

        public final boolean aXP() {
            return true;
        }

        public final boolean ak(int i, boolean z) {
            if (z && i == 553648177) {
                return true;
            }
            return false;
        }

        public final View a(LayoutInflater layoutInflater, View view) {
            if (view != null && view.getTag() != null) {
                return view;
            }
            view = new p(layoutInflater, R.i.dec);
            d s = new d().s(view, false);
            View be = ((e) g.h(e.class)).be(view.getContext());
            s.yTw = be;
            s.yTv.addView(be, new LayoutParams(-1, -1));
            view.setTag(s);
            return view;
        }

        public final void a(com.tencent.mm.ui.chatting.viewitems.b.a aVar, int i, com.tencent.mm.ui.chatting.ChattingUI.a aVar2, au auVar, String str) {
            com.tencent.mm.x.g.a I;
            aVar = (d) aVar;
            this.yyH = aVar2;
            aVar2.yEx.aT(auVar);
            String str2 = auVar.field_content;
            aVar2.yEx.aR(auVar);
            if (str2 != null) {
                I = com.tencent.mm.x.g.a.I(str2, auVar.field_reserved);
            } else {
                I = null;
            }
            ar arVar = new ar(auVar, aVar2.yxU, i, null, (byte) 0);
            if (I != null) {
                CharSequence charSequence;
                aVar.yRJ.setVisibility(8);
                aVar.yRI.setVisibility(8);
                aVar.yRF.setVisibility(8);
                aVar.ySh.setVisibility(8);
                WxaAttributes rf = ((com.tencent.mm.plugin.appbrand.n.c) g.h(com.tencent.mm.plugin.appbrand.n.c.class)).rf(I.hfi);
                if (rf != null) {
                    charSequence = rf.field_nickname;
                } else {
                    Object charSequence2 = I.fHv;
                }
                String str3 = rf != null ? rf.field_brandIconURL : I.hfr;
                aVar.ySh.setVisibility(0);
                aVar.ySd.setVisibility(8);
                aVar.ySk.setText(I.title);
                aVar.ySd.setText(I.description);
                aVar.ySf.setText(charSequence2);
                switch (I.hfp) {
                    case 1:
                        aVar.ySg.setText(R.l.dEw);
                        break;
                    case 2:
                        aVar.ySg.setText(R.l.dEv);
                        break;
                    default:
                        aVar.ySg.setText(R.l.dEe);
                        break;
                }
                o.PG().a(str3, aVar.ySe, d.yTu);
                if (b.cwm()) {
                    com.tencent.mm.ui.chatting.q qVar = aVar2.yAM;
                    if (auVar.field_status == 2 && b.a(qVar, auVar.field_msgId)) {
                        if (aVar.yRZ != null) {
                            aVar.yRZ.setVisibility(0);
                        }
                    } else if (aVar.yRZ != null) {
                        aVar.yRZ.setVisibility(8);
                    }
                    if (aVar.pyj != null) {
                        aVar.pyj.setVisibility(8);
                    }
                } else if (aVar.pyj != null) {
                    aVar.pyj.setVisibility(0);
                    if (auVar.field_status >= 2) {
                        aVar.pyj.setVisibility(8);
                    }
                }
                com.tencent.mm.x.a aVar3 = (com.tencent.mm.x.a) I.r(com.tencent.mm.x.a.class);
                Bundle bundle = new Bundle();
                bundle.putString("app_id", I.hfj);
                bundle.putString("msg_id", auVar.field_msgId);
                String str4 = "cache_key";
                if (aVar3 != null) {
                    str3 = aVar3.hcl;
                } else {
                    str3 = null;
                }
                bundle.putString(str4, str3);
                bundle.putString("msg_title", I.title);
                bundle.putString("msg_path", I.hfh);
                bundle.putInt("msg_pkg_type", I.hfp);
                bundle.putInt("pkg_version", I.fJh);
                bundle.putInt("widget_type", 0);
                bundle.putInt("scene", aVar2.yAR ? 1008 : 1007);
                bundle.putInt("view_init_width", d.yTs);
                bundle.putInt("view_init_height", d.yTt);
                aVar.yTw.setTag(aVar);
                ((e) g.h(e.class)).a(k.bj(aVar2), aVar.yTw, bundle, this.iYB);
            }
            aVar.yRn.setTag(arVar);
            aVar.yRn.setOnClickListener(t(aVar2));
            com.tencent.mm.y.u.b t = u.GQ().t(k.bj(aVar2), true);
            c cVar = (c) t.get("listener", null);
            if (cVar == null) {
                cVar = new c();
                t.o("listener", cVar);
            }
            cVar.z(aVar2);
            if (this.vGb) {
                aVar.yRn.setOnLongClickListener(s(aVar2));
            }
            a(i, aVar, auVar, aVar2.yAM.hnt, aVar2.yxU, aVar2);
        }

        public final boolean a(ContextMenu contextMenu, View view, au auVar) {
            int i = ((ar) view.getTag()).position;
            String str = auVar.field_content;
            if (str != null) {
                com.tencent.mm.x.g.a fV = com.tencent.mm.x.g.a.fV(this.yyH.dn(str, auVar.field_isSend));
                if (fV != null) {
                    if (com.tencent.mm.pluginsdk.model.app.g.h(com.tencent.mm.pluginsdk.model.app.g.aZ(fV.appId, false)) && !i.an(auVar)) {
                        contextMenu.add(i, 111, 0, this.yyH.getString(R.l.eEP));
                    }
                    if ((auVar.field_status == 2 || auVar.gkH == 1) && b.a(auVar, this.yyH) && b.ZX(auVar.field_talker)) {
                        contextMenu.add(i, 123, 0, view.getContext().getString(R.l.dSb));
                    }
                    com.tencent.mm.sdk.b.b diVar = new di();
                    diVar.fsL.frh = auVar.field_msgId;
                    com.tencent.mm.sdk.b.a.xmy.m(diVar);
                    if (diVar.fsM.fsk || b.a(this.yyH.getContext(), fV)) {
                        contextMenu.add(i, FileUtils.S_IWUSR, 0, view.getContext().getString(R.l.dRX));
                    }
                    if (!this.yyH.ctJ()) {
                        contextMenu.add(i, 100, 0, this.yyH.getString(R.l.dRS));
                    }
                    h Jd = ((e) g.h(e.class)).Jd();
                    if (Jd.Jf() || Jd.hi(fV.hfp)) {
                        contextMenu.add(i, 132, 0, this.yyH.getString(R.l.dRZ));
                        contextMenu.add(i, 131, 0, this.yyH.getString(R.l.dRY));
                    }
                }
            }
            return true;
        }

        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.ChattingUI.a aVar, au auVar) {
            com.tencent.mm.x.g.a aVar2 = null;
            String str;
            com.tencent.mm.sdk.b.b mvVar;
            switch (menuItem.getItemId()) {
                case 100:
                    str = auVar.field_content;
                    if (str != null) {
                        aVar2 = com.tencent.mm.x.g.a.fV(str);
                    }
                    if (aVar2 != null) {
                        if (19 == aVar2.type) {
                            mvVar = new mv();
                            mvVar.fFz.type = 3;
                            mvVar.fFz.frh = auVar.field_msgId;
                            com.tencent.mm.sdk.b.a.xmy.m(mvVar);
                        }
                        com.tencent.mm.pluginsdk.model.app.f aZ = com.tencent.mm.pluginsdk.model.app.g.aZ(aVar2.appId, false);
                        if (aZ != null && aZ.YI()) {
                            b.a(aVar, aVar2, auVar, aZ);
                        }
                    }
                    bb.aL(auVar.field_msgId);
                    break;
                case 103:
                    String str2 = auVar.field_content;
                    if (str2 != null) {
                        aVar2 = com.tencent.mm.x.g.a.fV(str2);
                        if (aVar2 != null) {
                            switch (aVar2.type) {
                                case 16:
                                    mvVar = new hz();
                                    mvVar.fzm.fzn = aVar2.fzn;
                                    mvVar.fzm.fqB = auVar.field_msgId;
                                    mvVar.fzm.fzo = auVar.field_talker;
                                    com.tencent.mm.sdk.b.a.xmy.m(mvVar);
                                    break;
                            }
                        }
                    }
                    break;
                case 111:
                    b.a(aVar, auVar, a(aVar, auVar));
                    break;
                case 131:
                    ((e) g.h(e.class)).Jd().bf(aVar.getContext());
                    break;
                case 132:
                    str = auVar.field_content;
                    if (str != null) {
                        aVar2 = com.tencent.mm.x.g.a.fV(str);
                    }
                    if (aVar2 != null) {
                        Bundle bundle = new Bundle();
                        bundle.putString("app_id", aVar2.hfj);
                        bundle.putString("msg_id", auVar.field_msgId);
                        bundle.putInt("pkg_type", aVar2.hfp);
                        bundle.putInt("pkg_version", aVar2.hfm);
                        ((e) g.h(e.class)).Jd().b(aVar.getContext(), bundle);
                        break;
                    }
                    break;
            }
            return false;
        }

        public final boolean b(View view, com.tencent.mm.ui.chatting.ChattingUI.a aVar, au auVar) {
            view.getTag();
            String str = auVar.field_content;
            if (str == null) {
                return false;
            }
            com.tencent.mm.x.g.a fV = com.tencent.mm.x.g.a.fV(str);
            if (fV == null) {
                return false;
            }
            com.tencent.mm.pluginsdk.model.app.f aZ = com.tencent.mm.pluginsdk.model.app.g.aZ(fV.appId, true);
            if (!(aZ == null || bi.oN(aZ.field_appId) || !aZ.YI())) {
                b.a(aVar, fV, com.tencent.mm.y.q.FY(), aZ, auVar.field_msgSvrId);
            }
            com.tencent.mm.sdk.b.b qrVar = new qr();
            qrVar.fJd.appId = fV.hfj;
            qrVar.fJd.userName = fV.hfi;
            qrVar.fJd.fJf = fV.hfh;
            qrVar.fJd.fJg = fV.hfp;
            qrVar.fJd.fJi = fV.hfl;
            qrVar.fJd.fJh = fV.hfq;
            qrVar.fJd.fJj = fV.hfp != 0;
            str = fV.hfn;
            StringBuilder stringBuilder;
            if (aVar.yAR) {
                qrVar.fJd.scene = 1008;
                stringBuilder = new StringBuilder(aVar.csn());
                stringBuilder.append(":");
                stringBuilder.append(a(aVar, auVar));
                stringBuilder.append(":");
                stringBuilder.append(str);
                qrVar.fJd.foi = stringBuilder.toString();
            } else {
                qrVar.fJd.scene = 1007;
                stringBuilder = new StringBuilder(a(aVar, auVar));
                stringBuilder.append(":");
                stringBuilder.append(str);
                qrVar.fJd.foi = stringBuilder.toString();
            }
            qrVar.fJd.fJl.hlj = aVar.csn();
            qrVar.fJd.fJl.hlk = fV.hfo;
            com.tencent.mm.sdk.b.a.xmy.m(qrVar);
            return true;
        }

        public final void q(View view, int i) {
            Object tag = view.getTag();
            if (tag instanceof d) {
                x.i("MicroMsg.ChattingItemAppMsgWxaDynamicTo", "onWidgetStateChanged(%s, state : %d)", Integer.valueOf(view.hashCode()), Integer.valueOf(i));
                d dVar = (d) tag;
                switch (i) {
                    case 0:
                        dVar.jVr.setVisibility(0);
                        dVar.jVr.czW();
                        dVar.yTw.setVisibility(4);
                        dVar.tvJ.setVisibility(4);
                        return;
                    case 1:
                        dVar.jVr.ajR();
                        dVar.jVr.setVisibility(4);
                        dVar.yTw.setVisibility(4);
                        dVar.tvJ.setVisibility(0);
                        dVar.tvJ.setImageResource(R.k.dyF);
                        return;
                    case 4:
                        dVar.jVr.ajR();
                        dVar.jVr.setVisibility(4);
                        dVar.yTw.setVisibility(0);
                        dVar.tvJ.setVisibility(4);
                        return;
                    default:
                        dVar.jVr.ajR();
                        dVar.jVr.setVisibility(4);
                        dVar.yTw.setVisibility(4);
                        dVar.tvJ.setVisibility(0);
                        dVar.tvJ.setImageResource(R.k.dvT);
                        return;
                }
            }
        }
    }

    static class c implements com.tencent.mm.ui.chatting.ChattingUI.b {
        private WeakReference<com.tencent.mm.ui.chatting.ChattingUI.a> yTr;

        c() {
        }

        final void z(com.tencent.mm.ui.chatting.ChattingUI.a aVar) {
            this.yTr = new WeakReference(aVar);
            aVar.a((com.tencent.mm.ui.chatting.ChattingUI.b) this);
        }

        public final void ctM() {
            if (this.yTr != null) {
                com.tencent.mm.ui.chatting.ChattingUI.a aVar = (com.tencent.mm.ui.chatting.ChattingUI.a) this.yTr.get();
                if (aVar != null) {
                    ((e) g.h(e.class)).Jc().iy(k.bj(aVar));
                }
            }
        }

        public final void ctN() {
            if (this.yTr != null) {
                com.tencent.mm.ui.chatting.ChattingUI.a aVar = (com.tencent.mm.ui.chatting.ChattingUI.a) this.yTr.get();
                if (aVar != null) {
                    ((e) g.h(e.class)).Jc().iz(k.bj(aVar));
                }
            }
        }

        public final void ctO() {
            x.i("MicroMsg.ChattingLifecycleChangedListener", "onChattingExit, then detach DynamicPageView.");
            if (this.yTr != null) {
                com.tencent.mm.ui.chatting.ChattingUI.a aVar = (com.tencent.mm.ui.chatting.ChattingUI.a) this.yTr.get();
                if (aVar != null) {
                    u.GQ().hB(k.bj(aVar));
                    aVar.b((com.tencent.mm.ui.chatting.ChattingUI.b) this);
                    ((e) g.h(e.class)).iA(k.bj(aVar));
                }
            }
        }
    }

    static class d extends com.tencent.mm.ui.chatting.viewitems.b.a {
        public static final int yTs = com.tencent.mm.bu.a.fromDPToPix(ad.getContext(), 240);
        public static final int yTt = com.tencent.mm.bu.a.fromDPToPix(ad.getContext(), ar.CTRL_INDEX);
        static com.tencent.mm.ap.a.a.c yTu;
        protected ThreeDotsLoadingView jVr;
        protected ImageView tvJ;
        protected ImageView yRF;
        protected ImageView yRI;
        protected ImageView yRJ;
        protected TextView yRL;
        protected ChattingItemFooter yRM;
        protected ImageView yRN;
        protected LinearLayout yRO;
        protected ViewGroup yRP;
        protected TextView yRQ;
        protected LinearLayout yRR;
        ImageView yRZ;
        protected TextView ySd;
        protected ImageView ySe;
        protected TextView ySf;
        protected TextView ySg;
        protected LinearLayout ySh;
        protected TextView ySk;
        protected ViewGroup yTv;
        protected View yTw;

        d() {
        }

        static {
            com.tencent.mm.ap.a.a.c.a aVar = new com.tencent.mm.ap.a.a.c.a();
            aVar.hFA = R.k.dvR;
            aVar.bc(com.tencent.mm.bu.a.fromDPToPix(ad.getContext(), 20), com.tencent.mm.bu.a.fromDPToPix(ad.getContext(), 20)).hFj = true;
            yTu = aVar.PQ();
        }

        public final d s(View view, boolean z) {
            super.ds(view);
            this.yRF = (ImageView) view.findViewById(R.h.bTo);
            this.yRI = (ImageView) this.nav.findViewById(R.h.bTO);
            this.yRJ = (ImageView) this.nav.findViewById(R.h.bVg);
            this.yRL = (TextView) view.findViewById(R.h.bTb);
            this.yRN = (ImageView) view.findViewById(R.h.bTi);
            this.mXO = (CheckBox) view.findViewById(R.h.bTE);
            this.kbO = view.findViewById(R.h.bUE);
            this.qng = (TextView) view.findViewById(R.h.bVm);
            this.yRM = (ChattingItemFooter) view.findViewById(R.h.ciZ);
            this.yRO = (LinearLayout) view.findViewById(R.h.bKE);
            this.yRP = (ViewGroup) view.findViewById(R.h.cug);
            this.yRQ = (TextView) view.findViewById(R.h.cue);
            this.yRR = (LinearLayout) view.findViewById(R.h.bTu);
            this.yRn = view.findViewById(R.h.bTF);
            if (!z) {
                this.yRZ = (ImageView) this.nav.findViewById(R.h.bVf);
                this.pyj = (ProgressBar) this.nav.findViewById(R.h.cUg);
            }
            this.ySh = (LinearLayout) view.findViewById(R.h.bSU);
            this.jVr = (ThreeDotsLoadingView) view.findViewById(R.h.ctI);
            this.tvJ = (ImageView) view.findViewById(R.h.bZu);
            this.ySk = (TextView) view.findViewById(R.h.bSX);
            this.ySd = (TextView) view.findViewById(R.h.bSW);
            this.ySe = (ImageView) view.findViewById(R.h.bSY);
            this.ySf = (TextView) view.findViewById(R.h.bTa);
            this.ySg = (TextView) view.findViewById(R.h.bSZ);
            this.yTv = (ViewGroup) view.findViewById(R.h.bZy);
            return this;
        }
    }

    public static class a extends b implements f {
        private q iYB = new r((f) this);
        private com.tencent.mm.ui.chatting.ChattingUI.a yyH;

        public final boolean aXP() {
            return false;
        }

        public final boolean ak(int i, boolean z) {
            if (z || i != 553648177) {
                return false;
            }
            return true;
        }

        public final View a(LayoutInflater layoutInflater, View view) {
            if (view != null && view.getTag() != null) {
                return view;
            }
            view = new p(layoutInflater, R.i.ddx);
            d s = new d().s(view, true);
            View be = ((e) g.h(e.class)).be(view.getContext());
            s.yTw = be;
            s.yTv.addView(be, new LayoutParams(-1, -1));
            view.setTag(s);
            return view;
        }

        public final void a(com.tencent.mm.ui.chatting.viewitems.b.a aVar, int i, com.tencent.mm.ui.chatting.ChattingUI.a aVar2, au auVar, String str) {
            com.tencent.mm.x.g.a I;
            this.yyH = aVar2;
            d dVar = (d) aVar;
            String str2 = auVar.field_content;
            aVar2.yEx.aR(auVar);
            aVar2.yEx.aS(auVar);
            aVar2.yEx.aT(auVar);
            x.d("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "filling Wxa dynamic from ChattingItem(%s)", str);
            if (str2 != null) {
                I = com.tencent.mm.x.g.a.I(str2, auVar.field_reserved);
            } else {
                x.e("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "amessage, msgid:%s, user:%s", Long.valueOf(auVar.field_msgId), str);
                I = null;
            }
            ar arVar = new ar(auVar, aVar2.yxU, i, null, (byte) 0);
            if (I != null) {
                CharSequence charSequence;
                dVar.yRJ.setVisibility(8);
                dVar.yRI.setVisibility(8);
                dVar.ySh.setVisibility(8);
                com.tencent.mm.x.e eVar = (com.tencent.mm.x.e) I.r(com.tencent.mm.x.e.class);
                if (dVar.yRM.n(eVar == null ? null : eVar.hcI, auVar.field_talker)) {
                    dVar.yRn.setBackgroundResource(R.g.bAX);
                } else {
                    dVar.yRn.setBackgroundResource(R.g.bAT);
                }
                com.tencent.mm.pluginsdk.model.app.f cT = com.tencent.mm.pluginsdk.model.app.g.cT(I.appId, I.fJh);
                if (cT != null && cT.YI()) {
                    b.b(aVar2, I, auVar);
                }
                if (I.gkB == null || I.gkB.length() == 0) {
                    dVar.yRL.setVisibility(8);
                } else {
                    dVar.yRL.setVisibility(0);
                    b(aVar2, dVar.yRL, (Object) ar.aae(I.gkB));
                }
                WxaAttributes rf = ((com.tencent.mm.plugin.appbrand.n.c) g.h(com.tencent.mm.plugin.appbrand.n.c.class)).rf(I.hfi);
                dVar.yRO.setVisibility(0);
                dVar.yRF.setVisibility(8);
                dVar.yRR.setVisibility(0);
                dVar.yRP.setVisibility(8);
                if (rf != null) {
                    charSequence = rf.field_nickname;
                } else {
                    Object charSequence2 = I.fHv;
                }
                str2 = rf != null ? rf.field_brandIconURL : I.hfr;
                dVar.ySh.setVisibility(0);
                dVar.ySd.setVisibility(8);
                dVar.ySk.setText(I.title);
                dVar.ySd.setText(I.description);
                dVar.ySf.setText(charSequence2);
                switch (I.hfp) {
                    case 1:
                        dVar.ySg.setText(R.l.dEw);
                        break;
                    case 2:
                        dVar.ySg.setText(R.l.dEv);
                        break;
                    default:
                        dVar.ySg.setText(R.l.dEe);
                        break;
                }
                o.PG().a(str2, dVar.ySe, d.yTu);
                if (aVar2.yxU) {
                    dVar.yRN.setVisibility(8);
                } else if (com.tencent.mm.pluginsdk.model.app.g.g(cT)) {
                    dVar.yRN.setVisibility(0);
                    b.c(aVar2, dVar.yRN, ar.a(I, auVar));
                } else {
                    dVar.yRN.setVisibility(8);
                }
                com.tencent.mm.x.a aVar3 = (com.tencent.mm.x.a) I.r(com.tencent.mm.x.a.class);
                Bundle bundle = new Bundle();
                bundle.putString("app_id", I.hfj);
                bundle.putString("msg_id", auVar.field_msgId);
                bundle.putString("cache_key", aVar3 != null ? aVar3.hcl : null);
                bundle.putString("msg_title", I.title);
                bundle.putString("msg_path", I.hfh);
                bundle.putInt("msg_pkg_type", I.hfp);
                bundle.putInt("pkg_version", I.fJh);
                bundle.putInt("widget_type", 0);
                bundle.putInt("scene", aVar2.yAR ? 1008 : 1007);
                bundle.putInt("view_init_width", d.yTs);
                bundle.putInt("view_init_height", d.yTt);
                dVar.yTw.setTag(dVar);
                ((e) g.h(e.class)).a(k.bj(aVar2), dVar.yTw, bundle, this.iYB);
            }
            dVar.yRn.setTag(arVar);
            dVar.yRn.setOnClickListener(t(aVar2));
            com.tencent.mm.y.u.b t = u.GQ().t(k.bj(aVar2), true);
            c cVar = (c) t.get("listener", null);
            if (cVar == null) {
                cVar = new c();
                t.o("listener", cVar);
            }
            cVar.z(aVar2);
            if (this.vGb) {
                dVar.yRn.setOnLongClickListener(s(aVar2));
            }
        }

        public final boolean a(ContextMenu contextMenu, View view, au auVar) {
            int i = ((ar) view.getTag()).position;
            com.tencent.mm.x.g.a fV = com.tencent.mm.x.g.a.fV(this.yyH.dn(auVar.field_content, auVar.field_isSend));
            if (com.tencent.mm.pluginsdk.model.app.g.h(com.tencent.mm.pluginsdk.model.app.g.aZ(fV.appId, false)) && !i.an(auVar)) {
                if (fV.type == 6) {
                    com.tencent.mm.pluginsdk.model.app.b Sn = l.Sn(fV.for);
                    if ((Sn == null || !b.c(auVar, Sn.field_fileFullPath)) && !auVar.ckh()) {
                        contextMenu.add(i, 111, 0, this.yyH.getString(R.l.eEP));
                    }
                } else {
                    contextMenu.add(i, 111, 0, this.yyH.getString(R.l.eEP));
                }
            }
            com.tencent.mm.sdk.b.b diVar = new di();
            diVar.fsL.frh = auVar.field_msgId;
            com.tencent.mm.sdk.b.a.xmy.m(diVar);
            if (diVar.fsM.fsk || b.a(this.yyH.getContext(), fV)) {
                contextMenu.add(i, FileUtils.S_IWUSR, 0, view.getContext().getString(R.l.dRX));
            }
            if (!this.yyH.ctJ()) {
                contextMenu.add(i, 100, 0, this.yyH.getString(R.l.dRS));
            }
            h Jd = ((e) g.h(e.class)).Jd();
            if (Jd.Jf() || Jd.hi(fV.hfp)) {
                contextMenu.add(i, 132, 0, this.yyH.getString(R.l.dRZ));
                contextMenu.add(i, 131, 0, this.yyH.getString(R.l.dRY));
            }
            return true;
        }

        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.ChattingUI.a aVar, au auVar) {
            com.tencent.mm.x.g.a aVar2 = null;
            String str;
            switch (menuItem.getItemId()) {
                case 100:
                    str = auVar.field_content;
                    if (str != null) {
                        aVar2 = com.tencent.mm.x.g.a.fV(str);
                    }
                    if (aVar2 != null) {
                        l.fr(auVar.field_msgId);
                        if (19 == aVar2.type) {
                            com.tencent.mm.sdk.b.b mvVar = new mv();
                            mvVar.fFz.type = 3;
                            mvVar.fFz.frh = auVar.field_msgId;
                            com.tencent.mm.sdk.b.a.xmy.m(mvVar);
                        }
                        com.tencent.mm.pluginsdk.model.app.f aZ = com.tencent.mm.pluginsdk.model.app.g.aZ(aVar2.appId, false);
                        if (aZ != null && aZ.YI()) {
                            b.a(aVar, aVar2, auVar, aZ);
                        }
                    }
                    bb.aL(auVar.field_msgId);
                    break;
                case 111:
                    b.a(aVar, auVar, a(aVar, auVar));
                    break;
                case 131:
                    ((e) g.h(e.class)).Jd().bf(aVar.getContext());
                    break;
                case 132:
                    str = auVar.field_content;
                    if (str != null) {
                        aVar2 = com.tencent.mm.x.g.a.fV(str);
                    }
                    if (aVar2 != null) {
                        Bundle bundle = new Bundle();
                        bundle.putString("app_id", aVar2.hfj);
                        bundle.putString("msg_id", auVar.field_msgId);
                        bundle.putInt("pkg_type", aVar2.hfp);
                        bundle.putInt("pkg_version", aVar2.hfm);
                        ((e) g.h(e.class)).Jd().b(aVar.getContext(), bundle);
                        break;
                    }
                    break;
            }
            return false;
        }

        public final boolean b(View view, com.tencent.mm.ui.chatting.ChattingUI.a aVar, au auVar) {
            com.tencent.mm.modelstat.a.a(auVar, com.tencent.mm.modelstat.a.a.Click);
            String str = auVar.field_content;
            if (str == null) {
                return false;
            }
            com.tencent.mm.x.g.a fV = com.tencent.mm.x.g.a.fV(aVar.dn(str, auVar.field_isSend));
            if (fV == null) {
                return false;
            }
            com.tencent.mm.pluginsdk.model.app.f aZ = com.tencent.mm.pluginsdk.model.app.g.aZ(fV.appId, false);
            if (aZ != null && aZ.YI()) {
                b.a(aVar, fV, b.c(aVar, auVar), aZ, auVar.field_msgSvrId);
            }
            x.i("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "username: %s , path: %s ,appid %s ,url : %s, pkgType : %s, md5 : %s", fV.hfi, fV.hfh, fV.hfj, fV.url, Integer.valueOf(fV.hfp), fV.hfl);
            com.tencent.mm.sdk.b.b qrVar = new qr();
            qrVar.fJd.appId = fV.hfj;
            qrVar.fJd.userName = fV.hfi;
            qrVar.fJd.fJf = fV.hfh;
            qrVar.fJd.fJg = fV.hfp;
            qrVar.fJd.fJi = fV.hfl;
            qrVar.fJd.fJh = fV.hfq;
            qrVar.fJd.fJj = fV.hfp != 0;
            qrVar.fJd.fJl.hlj = aVar.csn();
            qrVar.fJd.fJl.hlk = fV.hfo;
            str = fV.hfn;
            StringBuilder stringBuilder;
            if (aVar.yAR) {
                qrVar.fJd.scene = 1008;
                stringBuilder = new StringBuilder(aVar.csn());
                stringBuilder.append(":");
                stringBuilder.append(a(aVar, auVar));
                stringBuilder.append(":");
                stringBuilder.append(str);
                qrVar.fJd.foi = stringBuilder.toString();
            } else {
                qrVar.fJd.scene = 1007;
                stringBuilder = new StringBuilder(a(aVar, auVar));
                stringBuilder.append(":");
                stringBuilder.append(str);
                qrVar.fJd.foi = stringBuilder.toString();
            }
            com.tencent.mm.sdk.b.a.xmy.m(qrVar);
            return true;
        }

        public final void q(View view, int i) {
            Object tag = view.getTag();
            if (tag instanceof d) {
                x.i("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "onWidgetStateChanged(%s, state : %d)", Integer.valueOf(view.hashCode()), Integer.valueOf(i));
                d dVar = (d) tag;
                switch (i) {
                    case 0:
                        dVar.jVr.setVisibility(0);
                        dVar.jVr.czW();
                        dVar.tvJ.setVisibility(4);
                        dVar.yTw.setVisibility(4);
                        return;
                    case 1:
                        dVar.jVr.ajR();
                        dVar.jVr.setVisibility(4);
                        dVar.yTw.setVisibility(4);
                        dVar.tvJ.setVisibility(0);
                        dVar.tvJ.setImageResource(R.k.dyF);
                        return;
                    case 4:
                        dVar.jVr.ajR();
                        dVar.jVr.setVisibility(4);
                        dVar.yTw.setVisibility(0);
                        dVar.tvJ.setVisibility(4);
                        return;
                    default:
                        dVar.jVr.ajR();
                        dVar.jVr.setVisibility(4);
                        dVar.yTw.setVisibility(4);
                        dVar.tvJ.setVisibility(0);
                        dVar.tvJ.setImageResource(R.k.dvT);
                        return;
                }
            }
        }
    }
}
