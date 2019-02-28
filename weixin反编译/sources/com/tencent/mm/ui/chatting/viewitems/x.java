package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ap.e;
import com.tencent.mm.ap.f;
import com.tencent.mm.ap.g;
import com.tencent.mm.ap.n;
import com.tencent.mm.ap.o;
import com.tencent.mm.f.a.di;
import com.tencent.mm.f.b.cg;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.y.as;
import com.tencent.mm.y.q;
import com.tencent.mm.y.s;
import com.tencent.wcdb.FileUtils;
import java.util.Map;

public final class x {

    static class d extends com.tencent.mm.ui.chatting.viewitems.b.a {
        TextView mDG;
        ProgressBar pyj;
        ImageView yRZ;
        ImageView ySW;
        TextView yVv;
        ImageView yVw;
        View yVx;

        public final com.tencent.mm.ui.chatting.viewitems.b.a q(View view, boolean z) {
            super.ds(view);
            this.ljv = (TextView) view.findViewById(R.h.bVh);
            this.ySW = (ImageView) view.findViewById(R.h.bTK);
            this.mXO = (CheckBox) view.findViewById(R.h.bTE);
            this.kbO = view.findViewById(R.h.bUE);
            this.yVx = view.findViewById(R.h.cUi);
            if (z) {
                this.qng = (TextView) view.findViewById(R.h.bVm);
                this.pyj = (ProgressBar) view.findViewById(R.h.ccX);
            } else {
                this.pyj = (ProgressBar) view.findViewById(R.h.cUg);
                this.yVv = (TextView) view.findViewById(R.h.cUh);
                this.qng = (TextView) view.findViewById(R.h.bVm);
                this.yRZ = (ImageView) view.findViewById(R.h.bVf);
            }
            this.yVw = (ImageView) view.findViewById(R.h.bTM);
            this.mDG = (TextView) view.findViewById(R.h.bTn);
            return this;
        }
    }

    public static class b extends b {
        private c yVt;
        private com.tencent.mm.ui.chatting.ChattingUI.a yyH;

        public final boolean aXP() {
            return true;
        }

        public final boolean ak(int i, boolean z) {
            if (z && (i == 3 || i == 23 || i == 13 || i == 39 || i == 33)) {
                return true;
            }
            return false;
        }

        public final View a(LayoutInflater layoutInflater, View view) {
            if (view != null && view.getTag() != null) {
                return view;
            }
            view = new p(layoutInflater, R.i.deh);
            view.setTag(new d().q(view, false));
            return view;
        }

        public final void a(com.tencent.mm.ui.chatting.viewitems.b.a aVar, int i, com.tencent.mm.ui.chatting.ChattingUI.a aVar2, au auVar, String str) {
            boolean z;
            com.tencent.mm.ap.n.d bm;
            int i2;
            View view;
            this.yyH = aVar2;
            aVar = (d) aVar;
            boolean containsKey = n.Pt().hDK.containsKey(Long.valueOf(auVar.field_msgId));
            e n = o.PC().n(auVar);
            if (n == null || containsKey) {
                z = false;
            } else {
                boolean z2;
                if (n.Pt().bl(n.hBA)) {
                    bm = n.Pt().bm(n.hBA);
                    i2 = (int) bm.fAH;
                    z2 = i2 == 0 ? true : ((int) bm.oJ) == i2 && i2 != 0;
                } else {
                    z2 = f.b(n);
                }
                z = z2;
            }
            g PC = o.PC();
            ImageView imageView = aVar.ySW;
            String str2 = auVar.field_imgPath;
            float density = com.tencent.mm.bu.a.getDensity(aVar2.getContext());
            int i3 = auVar.gkE;
            int i4 = auVar.gkF;
            int i5 = R.g.bAI;
            ImageView imageView2 = aVar.yVw;
            int i6 = R.g.bAF;
            if (z) {
                view = null;
            } else {
                view = aVar.yVx;
            }
            if (!(PC.a(imageView, str2, density, i3, i4, i5, imageView2, i6, 0, view) || this.vGb)) {
                aVar.ySW.setImageDrawable(com.tencent.mm.bu.a.b(aVar2.getContext(), R.g.bEm));
            }
            if (n != null || containsKey) {
                Object obj = (z || auVar.field_status == 5) ? 1 : null;
                if (containsKey) {
                    aVar.yVv.setText("0%");
                } else {
                    int i7;
                    TextView textView = aVar.yVv;
                    StringBuilder stringBuilder = new StringBuilder();
                    if (n != null) {
                        i2 = n.hmZ;
                        i7 = n.offset;
                        if (n.Pt().bl(n.hBA)) {
                            bm = n.Pt().bm(n.hBA);
                            i2 = (int) bm.fAH;
                            i7 = (int) bm.oJ;
                        }
                        if (n.Pk()) {
                            e hT = o.PC().hT(n.hBK);
                            if (n.Pt().bl((long) n.hBK)) {
                                bm = n.Pt().bm((long) n.hBK);
                                i2 = (int) bm.fAH;
                                i7 = (int) bm.oJ;
                            } else {
                                i2 = hT.hmZ;
                                i7 = hT.offset;
                            }
                        }
                        if (i2 > 0) {
                            i7 = i7 >= i2 ? 100 : (i7 * 100) / i2;
                            textView.setText(stringBuilder.append(i7).append("%").toString());
                        }
                    }
                    i7 = 0;
                    textView.setText(stringBuilder.append(i7).append("%").toString());
                }
                aVar.pyj.setVisibility(obj != null ? 8 : 0);
                aVar.yVv.setVisibility(obj != null ? 8 : 0);
                aVar.yVx.setVisibility(obj != null ? 8 : 0);
            } else {
                aVar.yVx.setVisibility(8);
                aVar.pyj.setVisibility(8);
                aVar.yVv.setVisibility(8);
            }
            aVar.yRn.setTag(new ar(auVar, aVar2.yxU, i, auVar.field_talker, (byte) 0));
            View view2 = aVar.yRn;
            if (this.yVt == null) {
                this.yVt = new c(this.yyH, this);
            }
            view2.setOnClickListener(this.yVt);
            aVar.yRn.setOnTouchListener(aVar2.yAM.yBC);
            aVar.yRn.setOnLongClickListener(s(aVar2));
            aVar.ySW.setContentDescription(aVar2.getString(R.l.dRw));
            if (b.cwm()) {
                aVar.pyj.setVisibility(8);
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactInfoUI", "[oneliang]%s,%s", Long.valueOf(auVar.field_msgId), Integer.valueOf(auVar.field_status));
                if (b.cwm()) {
                    if (auVar.field_status == 2 && b.a(aVar2.yAM, auVar.field_msgId)) {
                        if (aVar.yRZ != null) {
                            aVar.yRZ.setVisibility(0);
                        }
                    } else if (aVar.yRZ != null) {
                        aVar.yRZ.setVisibility(8);
                    }
                }
            }
            a(i, aVar, auVar, aVar2.yAM.hnt, aVar2.yxU, aVar2);
            x.a(auVar, this, aVar2, aVar);
        }

        public final boolean a(ContextMenu contextMenu, View view, au auVar) {
            as.Hm();
            if (com.tencent.mm.y.c.isSDCardAvailable() && view != null) {
                int i = ((ar) view.getTag()).position;
                e eVar = null;
                if (auVar.field_msgId > 0) {
                    eVar = o.PC().bj(auVar.field_msgId);
                }
                if ((eVar == null || eVar.hBA <= 0) && auVar.field_msgSvrId > 0) {
                    eVar = o.PC().bi(auVar.field_msgSvrId);
                }
                if (eVar.Pk() && eVar.hmZ == 0) {
                    eVar = o.PC().hT(eVar.hBK);
                }
                contextMenu.add(i, 110, 0, view.getContext().getString(R.l.eEP));
                if (auVar.field_status == 5) {
                    contextMenu.add(i, 103, 0, view.getContext().getString(R.l.dST));
                }
                if (com.tencent.mm.af.f.LT() && !this.yyH.ctJ()) {
                    contextMenu.add(i, 114, 0, view.getContext().getString(R.l.dRO));
                }
                if (com.tencent.mm.bl.d.Pu("favorite")) {
                    contextMenu.add(i, 116, 0, view.getContext().getString(R.l.eAq));
                }
                com.tencent.mm.sdk.b.b diVar = new di();
                diVar.fsL.frh = auVar.field_msgId;
                com.tencent.mm.sdk.b.a.xmy.m(diVar);
                if (diVar.fsM.fsk || com.tencent.mm.pluginsdk.model.app.g.R(this.yyH.getContext(), auVar.getType())) {
                    contextMenu.add(i, FileUtils.S_IWUSR, 0, view.getContext().getString(R.l.dRX));
                }
                if (com.tencent.mm.bl.d.Pu("photoedit") && r0.status != -1) {
                    int width;
                    int height;
                    MenuItem add = contextMenu.add(i, 130, 0, view.getContext().getString(R.l.dRv));
                    int[] iArr = new int[2];
                    if (view != null) {
                        width = view.getWidth();
                        height = view.getHeight();
                        view.getLocationInWindow(iArr);
                    } else {
                        height = 0;
                        width = 0;
                    }
                    Intent intent = new Intent();
                    intent.putExtra("img_gallery_width", width).putExtra("img_gallery_height", height).putExtra("img_gallery_left", iArr[0]).putExtra("img_gallery_top", iArr[1]);
                    add.setIntent(intent);
                }
                if (!auVar.cjK() && auVar.cjT() && ((auVar.field_status == 2 || auVar.gkH == 1) && b.a(auVar, this.yyH) && b.ZX(auVar.field_talker))) {
                    contextMenu.add(i, 123, 0, view.getContext().getString(R.l.dSb));
                }
                if (!this.yyH.ctJ()) {
                    contextMenu.add(i, 100, 0, view.getContext().getString(R.l.dRR));
                }
            }
            return true;
        }

        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.ChattingUI.a aVar, au auVar) {
            if (100 == menuItem.getItemId()) {
                x.a(auVar, this, aVar);
            }
            return false;
        }

        public final boolean b(View view, com.tencent.mm.ui.chatting.ChattingUI.a aVar, au auVar) {
            return false;
        }

        public static void a(com.tencent.mm.ui.chatting.viewitems.b.a aVar, int i, int i2) {
            int i3 = i2 > 0 ? i >= i2 ? 100 : (int) ((((long) i) * 100) / ((long) i2)) : 0;
            d dVar = (d) aVar;
            if (i3 < 100 || dVar.yVv.getVisibility() == 0) {
                dVar.yVv.setText(i3 + "%");
                if (b.cwm()) {
                    dVar.pyj.setVisibility(8);
                } else {
                    dVar.pyj.setVisibility(0);
                }
                dVar.yVv.setVisibility(0);
                dVar.yVx.setVisibility(0);
            }
        }

        public static void a(com.tencent.mm.ui.chatting.viewitems.b.a aVar, boolean z) {
            if (z) {
                d dVar = (d) aVar;
                dVar.pyj.setVisibility(4);
                dVar.yVv.setVisibility(4);
                dVar.yVx.setVisibility(4);
            }
        }
    }

    public static class c extends com.tencent.mm.ui.chatting.r.d {
        private b yVu;

        public c(com.tencent.mm.ui.chatting.ChattingUI.a aVar, b bVar) {
            super(aVar);
            this.yVu = bVar;
        }

        public final void a(View view, com.tencent.mm.ui.chatting.ChattingUI.a aVar, au auVar) {
            e eVar;
            Map y;
            String str;
            e a;
            String str2;
            com.tencent.mm.ui.chatting.ChattingUI.a aVar2;
            com.tencent.mm.x.g.a fU;
            ar arVar = (ar) view.getTag();
            com.tencent.mm.modelstat.b.hRo.w(arVar.fFE);
            cg cgVar = arVar.fFE;
            com.tencent.mm.modelstat.a.a(cgVar, com.tencent.mm.modelstat.a.a.Click);
            int[] iArr = new int[2];
            int i = 0;
            int i2 = 0;
            if (view != null) {
                view.getLocationInWindow(iArr);
                i = view.getWidth();
                i2 = view.getHeight();
            }
            if (cgVar.field_isSend == 1) {
                e bj = o.PC().bj(cgVar.field_msgId);
                if (bj.hBA != 0) {
                    eVar = bj;
                    y = bj.y(cgVar.field_content, "msg");
                    if (y != null) {
                        bi.getLong((String) y.get(".msg.img.$hdlength"), 0);
                    }
                    as.Hm();
                    if (!com.tencent.mm.y.c.isSDCardAvailable()) {
                        u.fJ(this.yyH.getContext());
                    } else if (cgVar.field_isSend == 1) {
                        if (com.tencent.mm.a.e.bO(o.PC().m(f.c(eVar), "", ""))) {
                            if (com.tencent.mm.a.e.bO(o.PC().m(eVar.hBB, "", ""))) {
                                a(cgVar.field_msgId, cgVar.field_msgSvrId, arVar.userName, arVar.chatroomName, iArr, i, i2);
                            } else {
                                a(this.yyH, cgVar, eVar.hBI, eVar.fGj, arVar.userName, arVar.chatroomName, iArr, i, i2, false);
                            }
                        } else {
                            a(this.yyH, cgVar, eVar.hBI, eVar.fGj, arVar.userName, arVar.chatroomName, iArr, i, i2, false);
                        }
                    } else if (eVar.Pj()) {
                        if (eVar.status == -1) {
                            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.DesignerClickListener", "retry downloadImg, %d", Long.valueOf(eVar.hBA));
                            eVar.eR(0);
                            eVar.fEo = 256;
                            o.PC().a(Long.valueOf(eVar.hBA), eVar);
                        }
                        a(cgVar.field_msgId, cgVar.field_msgSvrId, arVar.userName, arVar.chatroomName, iArr, i, i2);
                    } else {
                        str = eVar.hBB;
                        if (eVar.Pk()) {
                            a = f.a(eVar);
                            if (a != null && a.hBA > 0 && a.Pj() && com.tencent.mm.a.e.bO(o.PC().m(a.hBB, "", ""))) {
                                str2 = a.hBB;
                                aVar2 = this.yyH;
                                o.PC().m(str2, "", "");
                                a(aVar2, cgVar, eVar.hBI, eVar.fGj, arVar.userName, arVar.chatroomName, iArr, i, i2, false);
                            }
                        }
                        str2 = str;
                        aVar2 = this.yyH;
                        o.PC().m(str2, "", "");
                        a(aVar2, cgVar, eVar.hBI, eVar.fGj, arVar.userName, arVar.chatroomName, iArr, i, i2, false);
                    }
                    fU = com.tencent.mm.x.g.a.fU(auVar.field_content);
                    if (fU != null && !bi.oN(fU.appId) && this.yVu != null) {
                        com.tencent.mm.pluginsdk.model.app.f aZ = com.tencent.mm.pluginsdk.model.app.g.aZ(fU.appId, false);
                        if (aZ != null && aZ.YI()) {
                            b.a(aVar, fU, this.yVu instanceof a ? b.c(aVar, auVar) : q.FY(), aZ, auVar.field_msgSvrId);
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
            eVar = o.PC().bi(cgVar.field_msgSvrId);
            y = bj.y(cgVar.field_content, "msg");
            if (y != null) {
                bi.getLong((String) y.get(".msg.img.$hdlength"), 0);
            }
            as.Hm();
            if (!com.tencent.mm.y.c.isSDCardAvailable()) {
                u.fJ(this.yyH.getContext());
            } else if (cgVar.field_isSend == 1) {
                if (com.tencent.mm.a.e.bO(o.PC().m(f.c(eVar), "", ""))) {
                    if (com.tencent.mm.a.e.bO(o.PC().m(eVar.hBB, "", ""))) {
                        a(cgVar.field_msgId, cgVar.field_msgSvrId, arVar.userName, arVar.chatroomName, iArr, i, i2);
                    } else {
                        a(this.yyH, cgVar, eVar.hBI, eVar.fGj, arVar.userName, arVar.chatroomName, iArr, i, i2, false);
                    }
                } else {
                    a(this.yyH, cgVar, eVar.hBI, eVar.fGj, arVar.userName, arVar.chatroomName, iArr, i, i2, false);
                }
            } else if (eVar.Pj()) {
                if (eVar.status == -1) {
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.DesignerClickListener", "retry downloadImg, %d", Long.valueOf(eVar.hBA));
                    eVar.eR(0);
                    eVar.fEo = 256;
                    o.PC().a(Long.valueOf(eVar.hBA), eVar);
                }
                a(cgVar.field_msgId, cgVar.field_msgSvrId, arVar.userName, arVar.chatroomName, iArr, i, i2);
            } else {
                str = eVar.hBB;
                if (eVar.Pk()) {
                    a = f.a(eVar);
                    str2 = a.hBB;
                    aVar2 = this.yyH;
                    o.PC().m(str2, "", "");
                    a(aVar2, cgVar, eVar.hBI, eVar.fGj, arVar.userName, arVar.chatroomName, iArr, i, i2, false);
                }
                str2 = str;
                aVar2 = this.yyH;
                o.PC().m(str2, "", "");
                a(aVar2, cgVar, eVar.hBI, eVar.fGj, arVar.userName, arVar.chatroomName, iArr, i, i2, false);
            }
            fU = com.tencent.mm.x.g.a.fU(auVar.field_content);
            if (fU != null) {
            }
        }

        private void a(long j, long j2, String str, String str2, int[] iArr, int i, int i2) {
            String str3;
            int i3;
            Bundle bundle;
            Intent intent = new Intent(this.yyH.getContext(), ImageGalleryUI.class);
            intent.putExtra("img_gallery_msg_id", j);
            intent.putExtra("show_search_chat_content_result", this.yyH.yEG.yAH);
            intent.putExtra("img_gallery_msg_svr_id", j2);
            intent.putExtra("key_is_biz_chat", this.yyH.yEL.vus);
            intent.putExtra("key_biz_chat_id", this.yyH.yEL.ctW());
            intent.putExtra("img_gallery_talker", str);
            intent.putExtra("img_gallery_chatroom_name", str2);
            intent.putExtra("img_gallery_left", iArr[0]);
            intent.putExtra("img_gallery_top", iArr[1]);
            intent.putExtra("img_gallery_width", i);
            intent.putExtra("img_gallery_height", i2);
            intent.putExtra("img_gallery_enter_from_chatting_ui", this.yyH.yEG.yJq);
            intent.putExtra("img_gallery_enter_from_appbrand_service_chatting_ui", com.tencent.mm.storage.x.fX(str));
            String csn = this.yyH.csn();
            Bundle bundle2 = new Bundle();
            if (this.yyH.yAR) {
                str3 = "stat_scene";
                i3 = 2;
                bundle = bundle2;
            } else {
                str3 = "stat_scene";
                if (s.gI(csn)) {
                    i3 = 7;
                    bundle = bundle2;
                } else {
                    i3 = 1;
                    bundle = bundle2;
                }
            }
            bundle.putInt(str3, i3);
            bundle2.putString("stat_msg_id", "msg_" + Long.toString(j2));
            bundle2.putString("stat_chat_talker_username", csn);
            bundle2.putString("stat_send_msg_user", str);
            intent.putExtra("_stat_obj", bundle2);
            this.yyH.startActivity(intent);
            this.yyH.overridePendingTransition(0, 0);
        }

        public static void a(com.tencent.mm.ui.chatting.ChattingUI.a aVar, au auVar, long j, long j2, String str, String str2, int[] iArr, int i, int i2, boolean z) {
            String str3;
            int i3;
            Bundle bundle;
            Intent intent = new Intent(aVar.getContext(), ImageGalleryUI.class);
            intent.putExtra("img_gallery_msg_id", j);
            intent.putExtra("img_gallery_msg_svr_id", j2);
            intent.putExtra("show_search_chat_content_result", aVar.yEG.yAH);
            intent.putExtra("key_is_biz_chat", aVar.yEL.vus);
            intent.putExtra("key_biz_chat_id", aVar.yEL.ctW());
            intent.putExtra("img_gallery_talker", str);
            intent.putExtra("img_gallery_chatroom_name", str2);
            intent.putExtra("img_gallery_left", iArr[0]);
            intent.putExtra("img_gallery_top", iArr[1]);
            intent.putExtra("img_gallery_width", i);
            intent.putExtra("img_gallery_height", i2);
            intent.putExtra("img_gallery_enter_from_chatting_ui", aVar.yEG.yJq);
            intent.putExtra("img_gallery_enter_PhotoEditUI", z);
            intent.putExtra("img_gallery_enter_from_appbrand_service_chatting_ui", com.tencent.mm.storage.x.fX(str));
            String csn = aVar.csn();
            if (auVar.field_isSend == 1) {
                str = aVar.yAM.hnt;
            }
            Bundle bundle2 = new Bundle();
            if (aVar.yAR) {
                str3 = "stat_scene";
                i3 = 2;
                bundle = bundle2;
            } else {
                str3 = "stat_scene";
                if (s.gI(csn)) {
                    i3 = 7;
                    bundle = bundle2;
                } else {
                    i3 = 1;
                    bundle = bundle2;
                }
            }
            bundle.putInt(str3, i3);
            bundle2.putString("stat_msg_id", "msg_" + Long.toString(j2));
            bundle2.putString("stat_chat_talker_username", csn);
            bundle2.putString("stat_send_msg_user", str);
            intent.putExtra("_stat_obj", bundle2);
            aVar.startActivity(intent);
            aVar.overridePendingTransition(0, 0);
        }
    }

    public static class a extends b {
        private c yVt;
        private com.tencent.mm.ui.chatting.ChattingUI.a yyH;

        public final boolean aXP() {
            return false;
        }

        public final boolean ak(int i, boolean z) {
            if (z || (i != 39 && i != 3 && i != 23 && i != 13 && i != 33)) {
                return false;
            }
            return true;
        }

        public final View a(LayoutInflater layoutInflater, View view) {
            if (view != null && view.getTag() != null) {
                return view;
            }
            view = new p(layoutInflater, R.i.ddE);
            view.setTag(new d().q(view, true));
            return view;
        }

        public final String a(com.tencent.mm.ui.chatting.ChattingUI.a aVar, au auVar) {
            return super.a(aVar, auVar);
        }

        public final void a(com.tencent.mm.ui.chatting.viewitems.b.a aVar, int i, com.tencent.mm.ui.chatting.ChattingUI.a aVar2, au auVar, String str) {
            this.yyH = aVar2;
            aVar2.yEx.aS(auVar);
            d dVar = (d) aVar;
            boolean a = o.PC().a(dVar.ySW, auVar.field_imgPath, com.tencent.mm.bu.a.getDensity(aVar2.getContext()), auVar.gkE, auVar.gkF, R.g.bAI, dVar.yVw, R.g.bAF, 1, null);
            dVar.yVx.setVisibility(0);
            dVar.pyj.setVisibility(8);
            if (!(a || this.vGb)) {
                dVar.ySW.setImageBitmap(BitmapFactory.decodeResource(aVar2.getResources(), R.g.bEm));
            }
            String str2 = null;
            if (aVar2.yxU) {
                str2 = auVar.field_talker;
            }
            dVar.yRn.setTag(new ar(auVar, aVar2.yxU, i, str, str2));
            View view = dVar.yRn;
            if (this.yVt == null) {
                this.yVt = new c(this.yyH, this);
            }
            view.setOnClickListener(this.yVt);
            dVar.yRn.setOnLongClickListener(s(aVar2));
            dVar.yRn.setOnTouchListener(aVar2.yAM.yBC);
            x.a(auVar, this, aVar2, dVar);
        }

        protected final boolean r(com.tencent.mm.ui.chatting.ChattingUI.a aVar) {
            return aVar.yxU;
        }

        public final boolean a(ContextMenu contextMenu, View view, au auVar) {
            as.Hm();
            if (!(!com.tencent.mm.y.c.isSDCardAvailable() || view == null || auVar == null)) {
                int i = ((ar) view.getTag()).position;
                e eVar = null;
                if (auVar.field_msgId > 0) {
                    eVar = o.PC().bj(auVar.field_msgId);
                }
                if ((eVar == null || eVar.hBA <= 0) && auVar.field_msgSvrId > 0) {
                    eVar = o.PC().bi(auVar.field_msgSvrId);
                }
                contextMenu.add(i, 110, 0, view.getContext().getString(R.l.eEP));
                if (com.tencent.mm.af.f.LT() && !this.yyH.ctJ()) {
                    contextMenu.add(i, 114, 0, view.getContext().getString(R.l.dRO));
                }
                if (com.tencent.mm.bl.d.Pu("favorite")) {
                    contextMenu.add(i, 116, 0, view.getContext().getString(R.l.eAq));
                }
                com.tencent.mm.sdk.b.b diVar = new di();
                diVar.fsL.frh = auVar.field_msgId;
                com.tencent.mm.sdk.b.a.xmy.m(diVar);
                if (diVar.fsM.fsk || com.tencent.mm.pluginsdk.model.app.g.R(this.yyH.getContext(), auVar.getType())) {
                    contextMenu.add(i, FileUtils.S_IWUSR, 0, view.getContext().getString(R.l.dRX));
                }
                if (!(!com.tencent.mm.bl.d.Pu("photoedit") || r0 == null || r0.status == -1)) {
                    int width;
                    int height;
                    MenuItem add = contextMenu.add(i, 130, 0, view.getContext().getString(R.l.dRv));
                    int[] iArr = new int[2];
                    if (view != null) {
                        width = view.getWidth();
                        height = view.getHeight();
                        view.getLocationInWindow(iArr);
                    } else {
                        height = 0;
                        width = 0;
                    }
                    Intent intent = new Intent();
                    intent.putExtra("img_gallery_width", width).putExtra("img_gallery_height", height).putExtra("img_gallery_left", iArr[0]).putExtra("img_gallery_top", iArr[1]);
                    add.setIntent(intent);
                }
                if (!this.yyH.ctJ()) {
                    contextMenu.add(i, 100, 0, view.getContext().getString(R.l.dRR));
                }
            }
            return true;
        }

        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.ChattingUI.a aVar, au auVar) {
            if (100 == menuItem.getItemId()) {
                x.a(auVar, this, aVar);
            }
            return false;
        }

        public final boolean b(View view, com.tencent.mm.ui.chatting.ChattingUI.a aVar, au auVar) {
            return false;
        }

        public static void a(Context context, com.tencent.mm.ui.chatting.viewitems.b.a aVar, au auVar, boolean z) {
            if (true == z) {
                d dVar = (d) aVar;
                o.PC().a(dVar.ySW, auVar.field_imgPath, com.tencent.mm.bu.a.getDensity(context), auVar.gkE, auVar.gkF, R.g.bAI, dVar.yVw, R.g.bAH, 1, null);
            }
        }
    }

    static /* synthetic */ void a(au auVar, b bVar, com.tencent.mm.ui.chatting.ChattingUI.a aVar) {
        com.tencent.mm.x.g.a fU = com.tencent.mm.x.g.a.fU(auVar.field_content);
        if (fU != null && !bi.oN(fU.appId)) {
            com.tencent.mm.pluginsdk.model.app.f aZ = com.tencent.mm.pluginsdk.model.app.g.aZ(fU.appId, false);
            if (aZ != null && aZ.YI()) {
                b.a(aVar, fU, auVar, aZ);
            }
        }
    }

    static /* synthetic */ void a(au auVar, b bVar, com.tencent.mm.ui.chatting.ChattingUI.a aVar, d dVar) {
        com.tencent.mm.x.g.a fU = com.tencent.mm.x.g.a.fU(auVar.field_content);
        if (fU == null || bi.oN(fU.appId)) {
            dVar.mDG.setVisibility(8);
            return;
        }
        String str = fU.appId;
        com.tencent.mm.pluginsdk.model.app.f cT = com.tencent.mm.pluginsdk.model.app.g.cT(str, fU.fJh);
        if (cT != null && cT.YI()) {
            b.b(aVar, fU, auVar);
        }
        String str2 = (cT == null || cT.field_appName == null || cT.field_appName.trim().length() <= 0) ? fU.appName : cT.field_appName;
        if (b.cz(str2)) {
            dVar.mDG.setText(com.tencent.mm.pluginsdk.model.app.g.a(aVar.getContext(), cT, str2));
            dVar.mDG.setVisibility(0);
            if (cT == null || !cT.YI()) {
                b.a(aVar, dVar.mDG, str);
            } else {
                b.a(aVar, dVar.mDG, auVar, fU, cT.field_packageName, auVar.field_msgSvrId);
            }
            b.a(aVar, dVar.mDG, str);
            return;
        }
        dVar.mDG.setVisibility(8);
    }
}
