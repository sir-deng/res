package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewStub;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.af.y;
import com.tencent.mm.ap.e;
import com.tencent.mm.ap.f;
import com.tencent.mm.f.a.co;
import com.tencent.mm.f.a.gn;
import com.tencent.mm.f.a.nj;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.protocal.c.cby;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.a.AnonymousClass5;
import com.tencent.mm.ui.chatting.b.v;
import com.tencent.mm.ui.chatting.p;
import com.tencent.mm.ui.chatting.q;
import com.tencent.mm.ui.chatting.r.g;
import com.tencent.mm.ui.chatting.r.j;
import com.tencent.mm.ui.chatting.r.m;
import com.tencent.mm.ui.chatting.r.o;
import com.tencent.mm.ui.widget.i;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bb;
import com.tencent.mm.y.r;
import com.tencent.mm.y.s;
import com.tencent.mm.y.t;
import java.util.LinkedList;
import java.util.List;

public abstract class b {
    private static long yMJ = 0;
    private static boolean yRa = false;
    protected boolean vGb;
    private c yRb;
    private d yRc;
    private boolean yRd = false;
    protected com.tencent.mm.ui.chatting.r.b yRe;
    protected com.tencent.mm.ui.chatting.r.c yRf;
    protected o yRg;
    protected g yRh;
    protected j yRi;
    protected m yRj;
    private final long yRk = 120000;
    public boolean yxU;

    public static class a {
        public ImageView ikK;
        public View kbO;
        public TextView ljv;
        public CheckBox mXO;
        public View nav;
        public ProgressBar pyj;
        public TextView qng;
        public ViewStub yRl;
        public View yRm;
        public View yRn;
        public ImageView yRo;
        public String yRp;
        public b yRq;

        public final void ds(View view) {
            this.nav = view;
            this.ljv = (TextView) view.findViewById(R.h.bVh);
            this.ikK = (ImageView) view.findViewById(R.h.bTw);
            this.yRm = view.findViewById(R.h.bUj);
            this.yRn = view.findViewById(R.h.bTF);
            this.yRo = (ImageView) view.findViewById(R.h.bVd);
            this.yRl = (ViewStub) view.findViewById(R.h.bUZ);
        }

        public final void nd(boolean z) {
            int i = z ? 0 : 8;
            if (!(this.mXO == null || this.mXO.getVisibility() == i)) {
                this.mXO.setVisibility(i);
            }
            if (this.kbO != null && this.kbO.getVisibility() != i) {
                this.kbO.setVisibility(i);
            }
        }

        public static void O(View view, int i) {
            if (view != null) {
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                layoutParams.width = i;
                view.setLayoutParams(layoutParams);
                view.requestLayout();
            }
        }
    }

    public static class d extends com.tencent.mm.ui.chatting.r.d {
        private b yRq;

        public d(com.tencent.mm.ui.chatting.ChattingUI.a aVar, b bVar) {
            super(aVar);
            this.yRq = bVar;
        }

        public void a(View view, com.tencent.mm.ui.chatting.ChattingUI.a aVar, au auVar) {
            view.getTag();
            this.yRq.b(view, aVar, auVar);
        }
    }

    private static class b implements com.tencent.mm.af.h.a {
        private String tQe;
        q yAM;

        protected b(q qVar, String str) {
            this.tQe = str;
            this.yAM = qVar;
        }

        public final void c(LinkedList<cby> linkedList) {
            int i = 0;
            y.Mm().b((com.tencent.mm.af.h.a) this);
            x.d("MicroMsg.ChattingItem", "onKFSceneEnd.");
            if (linkedList != null && linkedList.size() > 0) {
                x.i("MicroMsg.ChattingItem", "onKFSceneEnd, workers size : %d. callbackid=%s", Integer.valueOf(linkedList.size()), this.tQe);
                if (this.yAM != null) {
                    if (linkedList != null && linkedList.size() != 0) {
                        for (int i2 = 0; i2 < linkedList.size(); i2++) {
                            cby cby = (cby) linkedList.get(i2);
                            if (!(cby == null || bi.oN(cby.xhQ) || !cby.xhQ.equals(this.tQe))) {
                                x.i("MicroMsg.ChattingItem", "needCallback find match kfopenid");
                                if (!bi.oN(cby.wDh)) {
                                    x.i("MicroMsg.ChattingItem", "needCallback: true");
                                    i = 1;
                                    break;
                                }
                            }
                        }
                    }
                    if (i != 0) {
                        ah.y(new Runnable() {
                            public final void run() {
                                b.this.yAM.notifyDataSetChanged();
                            }
                        });
                    }
                }
            }
        }

        public final String Md() {
            return this.tQe;
        }
    }

    public class c implements OnLongClickListener {
        private int kMb;
        private int kMc;
        private OnCreateContextMenuListener pHg;
        private a yRs;
        private View yRt;
        private com.tencent.mm.ui.chatting.ChattingUI.a yyH;

        class a implements com.tencent.mm.ui.base.p.d {
            public au fou;

            a() {
            }

            public final void onMMMenuItemSelected(android.view.MenuItem r21, int r22) {
                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                /*
                r20 = this;
                r0 = r20;
                r2 = r0.fou;
                if (r2 != 0) goto L_0x0010;
            L_0x0006:
                r2 = "MicroMsg.ChattingItem";
                r3 = "context item select failed, null msg";
                com.tencent.mm.sdk.platformtools.x.e(r2, r3);
            L_0x000f:
                return;
            L_0x0010:
                r0 = r20;
                r2 = com.tencent.mm.ui.chatting.viewitems.b.c.this;
                r2 = com.tencent.mm.ui.chatting.viewitems.b.this;
                r0 = r20;
                r3 = com.tencent.mm.ui.chatting.viewitems.b.c.this;
                r3 = r3.yyH;
                r0 = r20;
                r4 = r0.fou;
                r0 = r21;
                r2.a(r0, r3, r4);
                r0 = r20;
                r2 = com.tencent.mm.ui.chatting.viewitems.b.c.this;
                r15 = r2.yyH;
                r0 = r20;
                r2 = com.tencent.mm.ui.chatting.viewitems.b.c.this;
                r0 = com.tencent.mm.ui.chatting.viewitems.b.this;
                r16 = r0;
                r2 = r15.yAM;
                r3 = r21.getGroupId();
                r2 = r2.getItem(r3);
                r14 = r2;
                r14 = (com.tencent.mm.storage.au) r14;
                if (r14 != 0) goto L_0x0050;
            L_0x0046:
                r2 = "MicroMsg.ChattingUI";
                r3 = "context item select failed, null msg";
                com.tencent.mm.sdk.platformtools.x.e(r2, r3);
                goto L_0x000f;
            L_0x0050:
                r5 = r15.yEy;
                r2 = r21.getItemId();
                switch(r2) {
                    case 103: goto L_0x01fd;
                    case 104: goto L_0x015f;
                    case 113: goto L_0x0222;
                    case 114: goto L_0x0203;
                    case 127: goto L_0x02fa;
                    default: goto L_0x0059;
                };
            L_0x0059:
                r2 = 0;
            L_0x005a:
                if (r2 != 0) goto L_0x000f;
            L_0x005c:
                r11 = r15.yEA;
                r2 = r21.getItemId();
                switch(r2) {
                    case 106: goto L_0x03d1;
                    case 107: goto L_0x0527;
                    case 129: goto L_0x0749;
                    default: goto L_0x0065;
                };
            L_0x0065:
                r2 = 0;
            L_0x0066:
                if (r2 != 0) goto L_0x000f;
            L_0x0068:
                r3 = r15.yEq;
                r2 = r21.getItemId();
                switch(r2) {
                    case 124: goto L_0x07fd;
                    default: goto L_0x0071;
                };
            L_0x0071:
                r2 = 0;
            L_0x0072:
                if (r2 != 0) goto L_0x000f;
            L_0x0074:
                r4 = r15.yEv;
                r2 = r21.getItemId();
                switch(r2) {
                    case 130: goto L_0x089a;
                    default: goto L_0x007d;
                };
            L_0x007d:
                r2 = 0;
            L_0x007e:
                if (r2 != 0) goto L_0x000f;
            L_0x0080:
                r4 = r15.yEB;
                r2 = r21.getItemId();
                switch(r2) {
                    case 110: goto L_0x0981;
                    default: goto L_0x0089;
                };
            L_0x0089:
                r2 = 0;
            L_0x008a:
                if (r2 != 0) goto L_0x000f;
            L_0x008c:
                r2 = r15.yyW;
                r3 = r21.getItemId();
                switch(r3) {
                    case 109: goto L_0x0b56;
                    default: goto L_0x0095;
                };
            L_0x0095:
                r2 = 0;
            L_0x0096:
                if (r2 != 0) goto L_0x000f;
            L_0x0098:
                r2 = r15.yED;
                r3 = r21.getItemId();
                switch(r3) {
                    case 116: goto L_0x0bc3;
                    default: goto L_0x00a1;
                };
            L_0x00a1:
                r2 = 0;
            L_0x00a2:
                if (r2 != 0) goto L_0x000f;
            L_0x00a4:
                r2 = r15.yEF;
                r3 = r21.getItemId();
                switch(r3) {
                    case 126: goto L_0x0bc9;
                    default: goto L_0x00ad;
                };
            L_0x00ad:
                r2 = 0;
            L_0x00ae:
                if (r2 != 0) goto L_0x000f;
            L_0x00b0:
                r2 = r21.getItemId();
                switch(r2) {
                    case 100: goto L_0x00b9;
                    case 102: goto L_0x0c0d;
                    case 103: goto L_0x0ca0;
                    case 108: goto L_0x0cc7;
                    case 112: goto L_0x0db1;
                    case 114: goto L_0x0e19;
                    case 122: goto L_0x0f80;
                    case 123: goto L_0x0f2d;
                    case 128: goto L_0x0d08;
                    case 133: goto L_0x0fe9;
                    default: goto L_0x00b7;
                };
            L_0x00b7:
                goto L_0x000f;
            L_0x00b9:
                r2 = r15.yyW;
                r3 = r14.cjL();
                if (r3 == 0) goto L_0x0bf6;
            L_0x00c1:
                r4 = r14.field_msgId;
                r3 = r2.yBy;
                r6 = r3.yyT;
                r3 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
                if (r3 != 0) goto L_0x00d0;
            L_0x00cb:
                r2 = r2.yBy;
                r2.crV();
            L_0x00d0:
                r2 = 1;
            L_0x00d1:
                if (r2 != 0) goto L_0x00f3;
            L_0x00d3:
                r2 = r14.aNJ();
                if (r2 == 0) goto L_0x0bf9;
            L_0x00d9:
                r3 = r15.yEs;
                r4 = r14.field_content;
                r2 = r3.fhH;
                r2 = r2.csW();
                r5 = r2.field_username;
                r6 = r14.field_msgId;
                r8 = com.tencent.mm.y.as.Dt();
                r2 = new com.tencent.mm.ui.chatting.b.s$2;
                r2.<init>(r4, r5, r6);
                r8.F(r2);
            L_0x00f3:
                r2 = r14.field_msgId;
                com.tencent.mm.y.bb.aL(r2);
                r2 = r14.aNJ();
                if (r2 == 0) goto L_0x0c06;
            L_0x00fe:
                r2 = com.tencent.mm.modelstat.b.hRo;
                r3 = com.tencent.mm.x.h.g(r14);
                r2.c(r14, r3);
            L_0x0107:
                r2 = "MicroMsg.ChattingUI";
                r3 = "delete msg, id:%d";
                r4 = 1;
                r4 = new java.lang.Object[r4];
                r5 = 0;
                r6 = r14.field_msgId;
                r6 = java.lang.Long.valueOf(r6);
                r4[r5] = r6;
                com.tencent.mm.sdk.platformtools.x.i(r2, r3, r4);
                r2 = r15.fBc;
                r2 = r2.field_username;
                r3 = "medianote";
                r2 = r2.equals(r3);
                if (r2 != 0) goto L_0x013c;
            L_0x0129:
                com.tencent.mm.y.as.Hm();
                r2 = com.tencent.mm.y.c.Fe();
                r3 = new com.tencent.mm.ax.e;
                r4 = r14.field_talker;
                r6 = r14.field_msgSvrId;
                r3.<init>(r4, r6);
                r2.b(r3);
            L_0x013c:
                r2 = r14.field_status;
                r3 = 1;
                if (r2 != r3) goto L_0x000f;
            L_0x0141:
                r2 = r14.field_isSend;
                r3 = 1;
                if (r2 != r3) goto L_0x000f;
            L_0x0146:
                r2 = "MicroMsg.ChattingUI";
                r3 = "delete a sending msg, publish SendMsgFailEvent";
                com.tencent.mm.sdk.platformtools.x.d(r2, r3);
                r2 = new com.tencent.mm.f.a.ou;
                r2.<init>();
                r3 = r2.fHF;
                r3.fou = r14;
                r3 = com.tencent.mm.sdk.b.a.xmy;
                r3.m(r2);
                goto L_0x000f;
            L_0x015f:
                r2 = r14.cjY();
                if (r2 != 0) goto L_0x016b;
            L_0x0165:
                r2 = r14.cjZ();
                if (r2 == 0) goto L_0x01b9;
            L_0x016b:
                r2 = r14.cjY();
                if (r2 == 0) goto L_0x01bc;
            L_0x0171:
                r2 = com.tencent.mm.plugin.emoji.b.c.class;
                r2 = com.tencent.mm.kernel.g.k(r2);
                r2 = (com.tencent.mm.plugin.emoji.b.c) r2;
                r2 = r2.getEmojiMgr();
                r3 = r14.field_imgPath;
                r2 = r2.yI(r3);
                r3 = r2;
            L_0x0184:
                r2 = r14.field_talker;
                r4 = com.tencent.mm.y.s.eX(r2);
                if (r4 == 0) goto L_0x1039;
            L_0x018c:
                r2 = r14.field_content;
                r2 = com.tencent.mm.y.bb.hS(r2);
                r4 = r2;
            L_0x0193:
                r2 = com.tencent.mm.plugin.emoji.b.c.class;
                r2 = com.tencent.mm.kernel.g.k(r2);
                r2 = (com.tencent.mm.plugin.emoji.b.c) r2;
                r2 = r2.getEmojiMgr();
                r6 = r5.fhH;
                r6 = r6.cte();
                r6 = r6.getContext();
                r7 = 0;
                r2 = r2.a(r6, r3, r7, r4);
                if (r2 == 0) goto L_0x01b9;
            L_0x01b0:
                r2 = r5.fhH;
                r2 = r2.ctp();
                r2.ccz();
            L_0x01b9:
                r2 = 1;
                goto L_0x005a;
            L_0x01bc:
                r2 = r14.field_content;
                r3 = com.tencent.mm.storage.aj.XW(r2);
                r2 = r14.field_content;
                r4 = r14.field_reserved;
                r2 = com.tencent.mm.x.g.a.I(r2, r4);
                if (r2 != 0) goto L_0x103c;
            L_0x01cc:
                r2 = new com.tencent.mm.x.g$a;
                r2.<init>();
                r3 = r3.frM;
                r2.hcO = r3;
                r3 = r2;
            L_0x01d6:
                r2 = r3.hcO;
                r2 = com.tencent.mm.sdk.platformtools.bi.oN(r2);
                if (r2 != 0) goto L_0x01b9;
            L_0x01de:
                r2 = r3.hcO;
                r4 = "-1";
                r2 = r2.equals(r4);
                if (r2 != 0) goto L_0x01b9;
            L_0x01e9:
                r2 = com.tencent.mm.plugin.emoji.b.c.class;
                r2 = com.tencent.mm.kernel.g.k(r2);
                r2 = (com.tencent.mm.plugin.emoji.b.c) r2;
                r2 = r2.getEmojiMgr();
                r3 = r3.hcO;
                r2 = r2.yI(r3);
                r3 = r2;
                goto L_0x0184;
            L_0x01fd:
                r2 = r5.aN(r14);
                goto L_0x005a;
            L_0x0203:
                r2 = r14.cjY();
                if (r2 != 0) goto L_0x020f;
            L_0x0209:
                r2 = r14.cjZ();
                if (r2 == 0) goto L_0x021f;
            L_0x020f:
                r2 = r5.fhH;
                r2 = r2.cte();
                r2 = r2.getContext();
                com.tencent.mm.ui.chatting.ah.b(r14, r2);
                r2 = 1;
                goto L_0x005a;
            L_0x021f:
                r2 = 0;
                goto L_0x005a;
            L_0x0222:
                r2 = r14.cjY();
                if (r2 != 0) goto L_0x022e;
            L_0x0228:
                r2 = r14.cjZ();
                if (r2 == 0) goto L_0x02c9;
            L_0x022e:
                r2 = new java.util.LinkedList;
                r2.<init>();
                r2.add(r14);
                r3 = r5.fhH;
                r3 = r3.cte();
                r3 = r3.getContext();
                r4 = r5.fhH;
                r4 = r4.csR();
                r6 = r5.fhH;
                r6 = r6.csW();
                r6 = r6.field_username;
                r7 = 0;
                com.tencent.mm.ui.chatting.j.a(r3, r2, r4, r6, r7);
                r2 = r14.cjY();
                if (r2 == 0) goto L_0x02cc;
            L_0x0258:
                r2 = com.tencent.mm.plugin.emoji.b.c.class;
                r2 = com.tencent.mm.kernel.g.k(r2);
                r2 = (com.tencent.mm.plugin.emoji.b.c) r2;
                r2 = r2.getEmojiMgr();
                r3 = r14.field_imgPath;
                r2 = r2.yI(r3);
                r3 = r2;
            L_0x026b:
                if (r3 == 0) goto L_0x02c9;
            L_0x026d:
                r2 = r5.fhH;
                r2 = r2.csW();
                r2 = r2.field_username;
                r4 = com.tencent.mm.y.s.eX(r2);
                if (r4 == 0) goto L_0x0281;
            L_0x027b:
                r2 = r14.field_content;
                r2 = com.tencent.mm.y.bb.hS(r2);
            L_0x0281:
                r4 = com.tencent.mm.plugin.report.service.g.pWK;
                r5 = 12789; // 0x31f5 float:1.7921E-41 double:6.3186E-320;
                r6 = 10;
                r6 = new java.lang.Object[r6];
                r7 = 0;
                r8 = 1;
                r8 = java.lang.Integer.valueOf(r8);
                r6[r7] = r8;
                r7 = 1;
                r8 = r3.Nx();
                r6[r7] = r8;
                r7 = 2;
                r8 = 0;
                r8 = java.lang.Integer.valueOf(r8);
                r6[r7] = r8;
                r7 = 3;
                r8 = r3.field_designerID;
                r6[r7] = r8;
                r7 = 4;
                r8 = r3.field_groupId;
                r6[r7] = r8;
                r7 = 5;
                r6[r7] = r2;
                r2 = 6;
                r7 = "";
                r6[r2] = r7;
                r2 = 7;
                r7 = "";
                r6[r2] = r7;
                r2 = 8;
                r7 = "";
                r6[r2] = r7;
                r2 = 9;
                r3 = r3.field_activityid;
                r6[r2] = r3;
                r4.h(r5, r6);
            L_0x02c9:
                r2 = 1;
                goto L_0x005a;
            L_0x02cc:
                r2 = r14.field_content;
                r3 = com.tencent.mm.storage.aj.XW(r2);
                r2 = r3.frM;
                r2 = com.tencent.mm.sdk.platformtools.bi.oN(r2);
                if (r2 != 0) goto L_0x02c9;
            L_0x02da:
                r2 = r3.frM;
                r4 = "-1";
                r2 = r2.equals(r4);
                if (r2 != 0) goto L_0x02c9;
            L_0x02e5:
                r2 = com.tencent.mm.plugin.emoji.b.c.class;
                r2 = com.tencent.mm.kernel.g.k(r2);
                r2 = (com.tencent.mm.plugin.emoji.b.c) r2;
                r2 = r2.getEmojiMgr();
                r3 = r3.frM;
                r2 = r2.yI(r3);
                r3 = r2;
                goto L_0x026b;
            L_0x02fa:
                r2 = r14.cjY();
                if (r2 == 0) goto L_0x03a1;
            L_0x0300:
                r2 = com.tencent.mm.plugin.emoji.b.c.class;
                r2 = com.tencent.mm.kernel.g.k(r2);
                r2 = (com.tencent.mm.plugin.emoji.b.c) r2;
                r2 = r2.getEmojiMgr();
                r3 = r14.field_imgPath;
                r2 = r2.yI(r3);
            L_0x0312:
                if (r2 == 0) goto L_0x0366;
            L_0x0314:
                r3 = com.tencent.mm.plugin.report.service.g.pWK;
                r4 = 12789; // 0x31f5 float:1.7921E-41 double:6.3186E-320;
                r6 = 11;
                r6 = new java.lang.Object[r6];
                r7 = 0;
                r8 = 2;
                r8 = java.lang.Integer.valueOf(r8);
                r6[r7] = r8;
                r7 = 1;
                r8 = r2.Nx();
                r6[r7] = r8;
                r7 = 2;
                r8 = 0;
                r8 = java.lang.Integer.valueOf(r8);
                r6[r7] = r8;
                r7 = 3;
                r8 = r2.field_designerID;
                r6[r7] = r8;
                r7 = 4;
                r8 = r2.field_groupId;
                r6[r7] = r8;
                r7 = 5;
                r8 = "";
                r6[r7] = r8;
                r7 = 6;
                r8 = "";
                r6[r7] = r8;
                r7 = 7;
                r8 = "";
                r6[r7] = r8;
                r7 = 8;
                r8 = "";
                r6[r7] = r8;
                r7 = 9;
                r8 = "";
                r6[r7] = r8;
                r7 = 10;
                r8 = r2.field_activityid;
                r6[r7] = r8;
                r3.h(r4, r6);
            L_0x0366:
                if (r2 != 0) goto L_0x03ce;
            L_0x0368:
                r2 = "";
            L_0x036b:
                r3 = com.tencent.mm.sdk.platformtools.bi.oN(r2);
                if (r3 != 0) goto L_0x039e;
            L_0x0371:
                r3 = new android.content.Intent;
                r3.<init>();
                r4 = "preceding_scence";
                r6 = 3;
                r3.putExtra(r4, r6);
                r4 = "download_entrance_scene";
                r6 = 16;
                r3.putExtra(r4, r6);
                r4 = "extra_id";
                r3.putExtra(r4, r2);
                r2 = r5.fhH;
                r2 = r2.cte();
                r2 = r2.getContext();
                r4 = "emoji";
                r5 = ".ui.EmojiStoreDetailUI";
                com.tencent.mm.bl.d.b(r2, r4, r5, r3);
            L_0x039e:
                r2 = 1;
                goto L_0x005a;
            L_0x03a1:
                r2 = r14.field_content;
                r3 = com.tencent.mm.storage.aj.XW(r2);
                r2 = r3.frM;
                r2 = com.tencent.mm.sdk.platformtools.bi.oN(r2);
                if (r2 != 0) goto L_0x039e;
            L_0x03af:
                r2 = r3.frM;
                r4 = "-1";
                r2 = r2.equals(r4);
                if (r2 != 0) goto L_0x039e;
            L_0x03ba:
                r2 = com.tencent.mm.plugin.emoji.b.c.class;
                r2 = com.tencent.mm.kernel.g.k(r2);
                r2 = (com.tencent.mm.plugin.emoji.b.c) r2;
                r2 = r2.getEmojiMgr();
                r3 = r3.frM;
                r2 = r2.yI(r3);
                goto L_0x0312;
            L_0x03ce:
                r2 = r2.field_groupId;
                goto L_0x036b;
            L_0x03d1:
                r2 = com.tencent.mm.modelvideo.o.Ub();
                r3 = r14.field_imgPath;
                r12 = r2.nv(r3);
                if (r12 == 0) goto L_0x051c;
            L_0x03dd:
                r2 = r12.status;
                r3 = 199; // 0xc7 float:2.79E-43 double:9.83E-322;
                if (r2 != r3) goto L_0x04bb;
            L_0x03e3:
                com.tencent.mm.modelvideo.o.Ub();
                r2 = r14.field_imgPath;
                r13 = com.tencent.mm.modelvideo.s.nx(r2);
                if (r12 == 0) goto L_0x045e;
            L_0x03ee:
                r2 = 0;
                r3 = r12.Uk();
                r3 = com.tencent.mm.y.s.eX(r3);
                if (r3 == 0) goto L_0x0401;
            L_0x03f9:
                r2 = r12.Uk();
                r2 = com.tencent.mm.y.m.gn(r2);
            L_0x0401:
                r3 = com.tencent.mm.plugin.report.service.g.pWK;
                r4 = 106; // 0x6a float:1.49E-43 double:5.24E-322;
                r6 = 215; // 0xd7 float:3.01E-43 double:1.06E-321;
                r8 = 1;
                r10 = 0;
                r3.a(r4, r6, r8, r10);
                r3 = com.tencent.mm.plugin.report.service.g.pWK;
                r4 = 12084; // 0x2f34 float:1.6933E-41 double:5.9703E-320;
                r5 = 8;
                r5 = new java.lang.Object[r5];
                r6 = 0;
                r7 = r12.hmZ;
                r7 = java.lang.Integer.valueOf(r7);
                r5[r6] = r7;
                r6 = 1;
                r7 = r12.hXv;
                r7 = r7 * 1000;
                r7 = java.lang.Integer.valueOf(r7);
                r5[r6] = r7;
                r6 = 2;
                r7 = 0;
                r7 = java.lang.Integer.valueOf(r7);
                r5[r6] = r7;
                r6 = 3;
                r7 = 2;
                r7 = java.lang.Integer.valueOf(r7);
                r5[r6] = r7;
                r6 = 4;
                r7 = r12.Uk();
                r5[r6] = r7;
                r6 = 5;
                r2 = java.lang.Integer.valueOf(r2);
                r5[r6] = r2;
                r2 = 6;
                r6 = r12.Un();
                r6 = com.tencent.mm.modelvideo.r.nu(r6);
                r5[r2] = r6;
                r2 = 7;
                r6 = r12.hXs;
                r6 = java.lang.Long.valueOf(r6);
                r5[r2] = r6;
                r3.h(r4, r5);
            L_0x045e:
                r2 = com.tencent.mm.modelvideo.t.nK(r13);
                r3 = com.tencent.mm.sdk.platformtools.bi.oN(r2);
                if (r3 == 0) goto L_0x0489;
            L_0x0468:
                r2 = r11.fhH;
                r2 = r2.cte();
                r2 = r2.getContext();
                r3 = r11.fhH;
                r3 = r3.cte();
                r4 = com.tencent.mm.R.l.eTt;
                r3 = r3.getMMString(r4);
                r4 = 1;
                r2 = android.widget.Toast.makeText(r2, r3, r4);
                r2.show();
            L_0x0486:
                r2 = 1;
                goto L_0x0066;
            L_0x0489:
                r3 = r11.fhH;
                r3 = r3.cte();
                r3 = r3.getContext();
                r4 = r11.fhH;
                r4 = r4.cte();
                r5 = com.tencent.mm.R.l.eTu;
                r6 = 1;
                r6 = new java.lang.Object[r6];
                r7 = 0;
                r6[r7] = r2;
                r4 = r4.getMMString(r5, r6);
                r5 = 1;
                r3 = android.widget.Toast.makeText(r3, r4, r5);
                r3.show();
                r3 = r11.fhH;
                r3 = r3.cte();
                r3 = r3.getContext();
                com.tencent.mm.pluginsdk.ui.tools.k.b(r2, r3);
                goto L_0x0486;
            L_0x04bb:
                r2 = r12.getFileName();
                r3 = 6;
                r11.dq(r2, r3);
                r2 = new android.content.Intent;
                r3 = r11.fhH;
                r3 = r3.cte();
                r3 = r3.getContext();
                r4 = com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.class;
                r2.<init>(r3, r4);
                r3 = "img_gallery_msg_id";
                r4 = r14.field_msgId;
                r2.putExtra(r3, r4);
                r3 = "img_gallery_msg_svr_id";
                r4 = r14.field_msgSvrId;
                r2.putExtra(r3, r4);
                r3 = "img_gallery_talker";
                r4 = r14.field_talker;
                r2.putExtra(r3, r4);
                r3 = "img_gallery_chatroom_name";
                r4 = r14.field_talker;
                r2.putExtra(r3, r4);
                r3 = "img_gallery_enter_video_opcode";
                r4 = r14.field_msgId;
                r6 = 2;
                r4 = com.tencent.mm.modelvideo.t.d(r4, r6);
                r2.putExtra(r3, r4);
                r3 = r11.fhH;
                com.tencent.mm.ui.chatting.b.g.a(r3, r14, r2);
                r3 = r11.fhH;
                r3 = r3.cte();
                r3.startActivity(r2);
                r2 = r11.fhH;
                r2 = r2.cte();
                r3 = 0;
                r4 = 0;
                r2.overridePendingTransition(r3, r4);
                goto L_0x0486;
            L_0x051c:
                r2 = "MicroMsg.ChattingUI.VideoImp";
                r3 = "save video but videoInfo is null!";
                com.tencent.mm.sdk.platformtools.x.e(r2, r3);
                goto L_0x0486;
            L_0x0527:
                com.tencent.mm.y.as.Hm();
                r2 = com.tencent.mm.y.c.isSDCardAvailable();
                if (r2 != 0) goto L_0x053f;
            L_0x0530:
                r2 = r11.fhH;
                r2 = r2.cte();
                r2 = r2.getContext();
                com.tencent.mm.ui.base.u.fJ(r2);
                goto L_0x0065;
            L_0x053f:
                r2 = r14.field_imgPath;
                r2 = com.tencent.mm.modelvideo.t.nJ(r2);
                if (r2 == 0) goto L_0x073e;
            L_0x0547:
                r3 = r14.ckh();
                if (r3 == 0) goto L_0x058a;
            L_0x054d:
                r2 = "MicroMsg.ChattingUI.VideoImp";
                r3 = "video is clean!!!";
                com.tencent.mm.sdk.platformtools.x.i(r2, r3);
                r2 = r11.fhH;
                r2 = r2.cte();
                r2 = r2.getContext();
                r3 = r11.fhH;
                r3 = r3.cte();
                r3 = r3.getContext();
                r4 = com.tencent.mm.R.l.eTh;
                r3 = r3.getString(r4);
                r4 = r11.fhH;
                r4 = r4.cte();
                r4 = r4.getContext();
                r5 = com.tencent.mm.R.l.dGZ;
                r4 = r4.getString(r5);
                r5 = new com.tencent.mm.ui.chatting.b.ad$2;
                r5.<init>();
                com.tencent.mm.ui.base.h.a(r2, r3, r4, r5);
                goto L_0x0065;
            L_0x058a:
                com.tencent.mm.modelvideo.o.Ub();
                r3 = r14.field_imgPath;
                r3 = com.tencent.mm.modelvideo.s.nx(r3);
                r3 = com.tencent.mm.ui.chatting.b.g.c(r14, r3);
                if (r3 == 0) goto L_0x0627;
            L_0x0599:
                r3 = "MicroMsg.ChattingUI.VideoImp";
                r4 = "video is expired";
                com.tencent.mm.sdk.platformtools.x.i(r3, r4);
                r3 = r2.getFileName();
                r4 = 3;
                r11.dq(r3, r4);
                r3 = new android.content.Intent;
                r4 = r11.fhH;
                r4 = r4.cte();
                r4 = r4.getContext();
                r5 = com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.class;
                r3.<init>(r4, r5);
                r4 = "img_gallery_msg_id";
                r6 = r14.field_msgId;
                r3.putExtra(r4, r6);
                r4 = "img_gallery_msg_svr_id";
                r6 = r14.field_msgSvrId;
                r3.putExtra(r4, r6);
                r4 = "img_gallery_talker";
                r5 = r14.field_talker;
                r3.putExtra(r4, r5);
                r4 = "img_gallery_chatroom_name";
                r5 = r14.field_talker;
                r3.putExtra(r4, r5);
                r4 = "img_gallery_enter_video_opcode";
                r6 = r14.field_msgId;
                r5 = 1;
                r5 = com.tencent.mm.modelvideo.t.d(r6, r5);
                r3.putExtra(r4, r5);
                r4 = r11.fhH;
                com.tencent.mm.ui.chatting.b.g.a(r4, r14, r3);
                r4 = r11.fhH;
                r4 = r4.cte();
                r4.startActivity(r3);
                r3 = r11.fhH;
                r3 = r3.cte();
                r4 = 0;
                r5 = 0;
                r3.overridePendingTransition(r4, r5);
                r2 = r2.Up();
                if (r2 == 0) goto L_0x0617;
            L_0x0607:
                r2 = "MicroMsg.ChattingUI.VideoImp";
                r3 = "start complete online video";
                com.tencent.mm.sdk.platformtools.x.i(r2, r3);
                r2 = r14.field_imgPath;
                com.tencent.mm.modelvideo.t.nN(r2);
                goto L_0x0065;
            L_0x0617:
                r2 = "MicroMsg.ChattingUI.VideoImp";
                r3 = "start complete offline video";
                com.tencent.mm.sdk.platformtools.x.i(r2, r3);
                r2 = r14.field_imgPath;
                com.tencent.mm.modelvideo.t.nF(r2);
                goto L_0x0065;
            L_0x0627:
                r3 = r2.status;
                r4 = 199; // 0xc7 float:2.79E-43 double:9.83E-322;
                if (r3 != r4) goto L_0x06a2;
            L_0x062d:
                r3 = new android.content.Intent;
                r4 = r11.fhH;
                r4 = r4.cte();
                r4 = r4.getContext();
                r5 = com.tencent.mm.ui.transmit.MsgRetransmitUI.class;
                r3.<init>(r4, r5);
                r4 = "Retr_length";
                r5 = r2.hXv;
                r3.putExtra(r4, r5);
                r4 = "Retr_File_Name";
                r5 = r14.field_imgPath;
                r3.putExtra(r4, r5);
                r4 = "Retr_video_isexport";
                r2 = r2.hXz;
                r3.putExtra(r4, r2);
                r2 = "Retr_Msg_Id";
                r4 = r14.field_msgId;
                r3.putExtra(r2, r4);
                r2 = "Retr_From";
                r4 = "chattingui";
                r3.putExtra(r2, r4);
                r2 = "MicroMsg.ChattingUI.VideoImp";
                r4 = new java.lang.StringBuilder;
                r5 = "dkvideo msg.getType():";
                r4.<init>(r5);
                r5 = r14.getType();
                r4 = r4.append(r5);
                r4 = r4.toString();
                com.tencent.mm.sdk.platformtools.x.d(r2, r4);
                r2 = r14.cjX();
                if (r2 == 0) goto L_0x069a;
            L_0x0687:
                r2 = "Retr_Msg_Type";
                r4 = 11;
                r3.putExtra(r2, r4);
            L_0x068f:
                r2 = r11.fhH;
                r2 = r2.cte();
                r2.startActivity(r3);
                goto L_0x0065;
            L_0x069a:
                r2 = "Retr_Msg_Type";
                r4 = 1;
                r3.putExtra(r2, r4);
                goto L_0x068f;
            L_0x06a2:
                r3 = r14.cjW();
                if (r3 != 0) goto L_0x06ae;
            L_0x06a8:
                r3 = r14.cjX();
                if (r3 == 0) goto L_0x0733;
            L_0x06ae:
                r3 = r2.getFileName();
                r4 = 3;
                r11.dq(r3, r4);
                r3 = new android.content.Intent;
                r4 = r11.fhH;
                r4 = r4.cte();
                r4 = r4.getContext();
                r5 = com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.class;
                r3.<init>(r4, r5);
                r4 = "img_gallery_msg_id";
                r6 = r14.field_msgId;
                r3.putExtra(r4, r6);
                r4 = "img_gallery_msg_svr_id";
                r6 = r14.field_msgSvrId;
                r3.putExtra(r4, r6);
                r4 = "img_gallery_talker";
                r5 = r14.field_talker;
                r3.putExtra(r4, r5);
                r4 = "img_gallery_chatroom_name";
                r5 = r14.field_talker;
                r3.putExtra(r4, r5);
                r4 = "img_gallery_enter_video_opcode";
                r6 = r14.field_msgId;
                r5 = 1;
                r5 = com.tencent.mm.modelvideo.t.d(r6, r5);
                r3.putExtra(r4, r5);
                r4 = r11.fhH;
                com.tencent.mm.ui.chatting.b.g.a(r4, r14, r3);
                r4 = r11.fhH;
                r4 = r4.cte();
                r4.startActivity(r3);
                r3 = r11.fhH;
                r3 = r3.cte();
                r4 = 0;
                r5 = 0;
                r3.overridePendingTransition(r4, r5);
                r2 = r2.Up();
                if (r2 == 0) goto L_0x0723;
            L_0x0713:
                r2 = "MicroMsg.ChattingUI.VideoImp";
                r3 = "start complete online video";
                com.tencent.mm.sdk.platformtools.x.i(r2, r3);
                r2 = r14.field_imgPath;
                com.tencent.mm.modelvideo.t.nN(r2);
                goto L_0x0065;
            L_0x0723:
                r2 = "MicroMsg.ChattingUI.VideoImp";
                r3 = "start complete offline video";
                com.tencent.mm.sdk.platformtools.x.i(r2, r3);
                r2 = r14.field_imgPath;
                com.tencent.mm.modelvideo.t.nF(r2);
                goto L_0x0065;
            L_0x0733:
                r2 = "MicroMsg.ChattingUI.VideoImp";
                r3 = "retranmist video unknow status.";
                com.tencent.mm.sdk.platformtools.x.w(r2, r3);
                goto L_0x0065;
            L_0x073e:
                r2 = "MicroMsg.ChattingUI.VideoImp";
                r3 = "retransmit video but videoInfo is null!";
                com.tencent.mm.sdk.platformtools.x.e(r2, r3);
                goto L_0x0065;
            L_0x0749:
                r4 = r21.getIntent();
                r3 = 0;
                r2 = 0;
                r5 = 2;
                r5 = new int[r5];
                if (r4 != 0) goto L_0x07d5;
            L_0x0754:
                r4 = "MicroMsg.ChattingUI.VideoImp";
                r6 = "[LONGCLICK_MENU_MUTE_PLAY] intent is null!";
                com.tencent.mm.sdk.platformtools.x.e(r4, r6);
            L_0x075d:
                r4 = new android.content.Intent;
                r6 = r11.fhH;
                r6 = r6.cte();
                r6 = r6.getContext();
                r7 = com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.class;
                r4.<init>(r6, r7);
                r6 = "img_gallery_msg_id";
                r8 = r14.field_msgId;
                r4.putExtra(r6, r8);
                r6 = "img_gallery_msg_svr_id";
                r8 = r14.field_msgSvrId;
                r4.putExtra(r6, r8);
                r6 = "img_gallery_talker";
                r7 = r14.field_talker;
                r4.putExtra(r6, r7);
                r6 = "img_gallery_chatroom_name";
                r7 = r14.field_talker;
                r4.putExtra(r6, r7);
                r6 = "img_gallery_left";
                r7 = 0;
                r7 = r5[r7];
                r4.putExtra(r6, r7);
                r6 = "img_gallery_top";
                r7 = 1;
                r5 = r5[r7];
                r4.putExtra(r6, r5);
                r5 = "img_gallery_width";
                r4.putExtra(r5, r3);
                r3 = "img_gallery_height";
                r4.putExtra(r3, r2);
                r2 = "img_gallery_enter_video_opcode";
                r6 = r14.field_msgId;
                r3 = 3;
                r3 = com.tencent.mm.modelvideo.t.d(r6, r3);
                r4.putExtra(r2, r3);
                r2 = r11.fhH;
                com.tencent.mm.ui.chatting.b.g.a(r2, r14, r4);
                r2 = r11.fhH;
                r2 = r2.cte();
                r2.startActivity(r4);
                r2 = r11.fhH;
                r2 = r2.cte();
                r3 = 0;
                r4 = 0;
                r2.overridePendingTransition(r3, r4);
                r2 = 1;
                goto L_0x0066;
            L_0x07d5:
                r2 = "img_gallery_width";
                r3 = 0;
                r3 = r4.getIntExtra(r2, r3);
                r2 = "img_gallery_height";
                r6 = 0;
                r2 = r4.getIntExtra(r2, r6);
                r6 = 0;
                r7 = "img_gallery_left";
                r8 = 0;
                r7 = r4.getIntExtra(r7, r8);
                r5[r6] = r7;
                r6 = 1;
                r7 = "img_gallery_top";
                r8 = 0;
                r4 = r4.getIntExtra(r7, r8);
                r5[r6] = r4;
                goto L_0x075d;
            L_0x07fd:
                r2 = "MicroMsg.ChattingUI.TranslateImp";
                r4 = "longclick transalte type: %d isShowTranslated: %s";
                r5 = 2;
                r5 = new java.lang.Object[r5];
                r6 = 0;
                r7 = r14.getType();
                r7 = java.lang.Integer.valueOf(r7);
                r5[r6] = r7;
                r6 = 1;
                r7 = r14.ckl();
                r7 = java.lang.Boolean.valueOf(r7);
                r5[r6] = r7;
                com.tencent.mm.sdk.platformtools.x.d(r2, r4, r5);
                com.tencent.mm.y.as.Hm();
                r2 = com.tencent.mm.y.c.Db();
                r4 = 327712; // 0x50020 float:4.59222E-40 double:1.61911E-318;
                r5 = 0;
                r5 = java.lang.Boolean.valueOf(r5);
                r2 = r2.get(r4, r5);
                r2 = (java.lang.Boolean) r2;
                r2 = r2.booleanValue();
                if (r2 != 0) goto L_0x0893;
            L_0x083a:
                com.tencent.mm.y.as.Hm();
                r2 = com.tencent.mm.y.c.Db();
                r4 = 327712; // 0x50020 float:4.59222E-40 double:1.61911E-318;
                r5 = 1;
                r5 = java.lang.Boolean.valueOf(r5);
                r2.set(r4, r5);
                r2 = new com.tencent.mm.ui.base.i$a;
                r4 = r3.fhH;
                r4 = r4.cte();
                r4 = r4.getContext();
                r2.<init>(r4);
                r4 = r3.fhH;
                r4 = r4.cte();
                r5 = com.tencent.mm.R.l.dTw;
                r4 = r4.getMMString(r5);
                r2.Zn(r4);
                r4 = r3.fhH;
                r4 = r4.cte();
                r5 = com.tencent.mm.R.l.dTx;
                r4 = r4.getMMString(r5);
                r2.Zm(r4);
                r4 = com.tencent.mm.R.l.epx;
                r4 = r2.EV(r4);
                r5 = new com.tencent.mm.ui.chatting.b.ac$1;
                r0 = r21;
                r5.<init>(r3, r14, r0);
                r4.a(r5);
                r2 = r2.ale();
                r2.show();
            L_0x0890:
                r2 = 1;
                goto L_0x0072;
            L_0x0893:
                r21.getGroupId();
                r3.aV(r14);
                goto L_0x0890;
            L_0x089a:
                r2 = "MicroMsg.ChattingUI.GetImageImp";
                r3 = "long click go to photo eidt";
                com.tencent.mm.sdk.platformtools.x.i(r2, r3);
                r2 = r21.getIntent();
                if (r2 != 0) goto L_0x08b5;
            L_0x08a9:
                r2 = "MicroMsg.ChattingUI.GetImageImp";
                r3 = "[LONGCLICK_MENU_PHOTO_EDIT] intent is null!";
                com.tencent.mm.sdk.platformtools.x.e(r2, r3);
                r2 = 1;
                goto L_0x007e;
            L_0x08b5:
                r3 = "img_gallery_width";
                r5 = 0;
                r11 = r2.getIntExtra(r3, r5);
                r3 = "img_gallery_height";
                r5 = 0;
                r12 = r2.getIntExtra(r3, r5);
                r3 = 2;
                r10 = new int[r3];
                r3 = 0;
                r5 = "img_gallery_left";
                r6 = 0;
                r5 = r2.getIntExtra(r5, r6);
                r10[r3] = r5;
                r3 = 1;
                r5 = "img_gallery_top";
                r6 = 0;
                r2 = r2.getIntExtra(r5, r6);
                r10[r3] = r2;
                r9 = 0;
                r2 = r4.fhH;
                r2 = r2.csR();
                if (r2 == 0) goto L_0x08e9;
            L_0x08e7:
                r9 = r14.field_talker;
            L_0x08e9:
                r2 = 0;
                r6 = r14.field_msgId;
                r18 = 0;
                r3 = (r6 > r18 ? 1 : (r6 == r18 ? 0 : -1));
                if (r3 <= 0) goto L_0x08fc;
            L_0x08f2:
                r2 = com.tencent.mm.ap.o.PC();
                r6 = r14.field_msgId;
                r2 = r2.bj(r6);
            L_0x08fc:
                if (r2 == 0) goto L_0x0906;
            L_0x08fe:
                r6 = r2.hBA;
                r18 = 0;
                r3 = (r6 > r18 ? 1 : (r6 == r18 ? 0 : -1));
                if (r3 > 0) goto L_0x1036;
            L_0x0906:
                r6 = r14.field_msgSvrId;
                r18 = 0;
                r3 = (r6 > r18 ? 1 : (r6 == r18 ? 0 : -1));
                if (r3 <= 0) goto L_0x1036;
            L_0x090e:
                r2 = com.tencent.mm.ap.o.PC();
                r6 = r14.field_msgSvrId;
                r2 = r2.bi(r6);
                r3 = r2;
            L_0x0919:
                if (r3 != 0) goto L_0x095a;
            L_0x091b:
                r2 = "";
            L_0x091e:
                if (r3 == 0) goto L_0x096b;
            L_0x0920:
                r3 = r3.status;
                r5 = -1;
                if (r3 == r5) goto L_0x096b;
            L_0x0925:
                r3 = r14.field_status;
                r5 = 5;
                if (r3 == r5) goto L_0x096b;
            L_0x092a:
                r3 = "MicroMsg.ChattingUI.GetImageImp";
                r5 = "[LONGCLICK_MENU_PHOTO_EDIT] msgId:%s imgFullPath:%s";
                r6 = 2;
                r6 = new java.lang.Object[r6];
                r7 = 0;
                r0 = r14.field_msgId;
                r18 = r0;
                r8 = java.lang.Long.valueOf(r18);
                r6[r7] = r8;
                r7 = 1;
                r6[r7] = r2;
                com.tencent.mm.sdk.platformtools.x.i(r3, r5, r6);
                r2 = r4.fhH;
                r2 = r2.cte();
                r2 = (com.tencent.mm.ui.chatting.ChattingUI.a) r2;
                r4 = r14.field_msgId;
                r6 = r14.field_msgSvrId;
                r8 = r14.field_talker;
                r13 = 1;
                r3 = r14;
                com.tencent.mm.ui.chatting.viewitems.x.c.a(r2, r3, r4, r6, r8, r9, r10, r11, r12, r13);
            L_0x0957:
                r2 = 1;
                goto L_0x007e;
            L_0x095a:
                r2 = com.tencent.mm.ap.o.PC();
                r5 = r3.hBB;
                r6 = "";
                r7 = "";
                r2 = r2.m(r5, r6, r7);
                goto L_0x091e;
            L_0x096b:
                r2 = "MicroMsg.ChattingUI.GetImageImp";
                r3 = "raw img not get successfully ,msgId:%s";
                r4 = 1;
                r4 = new java.lang.Object[r4];
                r5 = 0;
                r6 = r14.field_msgId;
                r6 = java.lang.Long.valueOf(r6);
                r4[r5] = r6;
                com.tencent.mm.sdk.platformtools.x.e(r2, r3, r4);
                goto L_0x0957;
            L_0x0981:
                com.tencent.mm.y.as.Hm();
                r2 = com.tencent.mm.y.c.isSDCardAvailable();
                if (r2 != 0) goto L_0x099a;
            L_0x098a:
                r2 = r4.fhH;
                r2 = r2.cte();
                r2 = r2.getContext();
                com.tencent.mm.ui.base.u.fJ(r2);
            L_0x0997:
                r2 = 1;
                goto L_0x008a;
            L_0x099a:
                r2 = 0;
                r6 = r14.field_msgId;
                r8 = 0;
                r3 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
                if (r3 <= 0) goto L_0x09ad;
            L_0x09a3:
                r2 = com.tencent.mm.ap.o.PC();
                r6 = r14.field_msgId;
                r2 = r2.bj(r6);
            L_0x09ad:
                if (r2 == 0) goto L_0x09b7;
            L_0x09af:
                r6 = r2.hBA;
                r8 = 0;
                r3 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
                if (r3 > 0) goto L_0x1033;
            L_0x09b7:
                r6 = r14.field_msgSvrId;
                r8 = 0;
                r3 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
                if (r3 <= 0) goto L_0x1033;
            L_0x09bf:
                r2 = com.tencent.mm.ap.o.PC();
                r6 = r14.field_msgSvrId;
                r2 = r2.bi(r6);
                r3 = r2;
            L_0x09ca:
                if (r3 == 0) goto L_0x0997;
            L_0x09cc:
                r2 = r14.field_isSend;
                r5 = 1;
                if (r2 != r5) goto L_0x0a1d;
            L_0x09d1:
                r2 = r3.Pk();
                if (r2 == 0) goto L_0x0a1b;
            L_0x09d7:
                r2 = 1;
            L_0x09d8:
                r5 = r14.ckh();
                if (r5 == 0) goto L_0x0a43;
            L_0x09de:
                r2 = "MicroMsg.ChattingUI.SendImgImp";
                r3 = "image is clean!!!";
                com.tencent.mm.sdk.platformtools.x.i(r2, r3);
                r2 = r4.fhH;
                r2 = r2.cte();
                r2 = r2.getContext();
                r3 = r4.fhH;
                r3 = r3.cte();
                r3 = r3.getContext();
                r5 = com.tencent.mm.R.l.epz;
                r3 = r3.getString(r5);
                r5 = r4.fhH;
                r5 = r5.cte();
                r5 = r5.getContext();
                r6 = com.tencent.mm.R.l.dGZ;
                r5 = r5.getString(r6);
                r6 = new com.tencent.mm.ui.chatting.b.v$3;
                r6.<init>();
                com.tencent.mm.ui.base.h.a(r2, r3, r5, r6);
                goto L_0x0997;
            L_0x0a1b:
                r2 = 0;
                goto L_0x09d8;
            L_0x0a1d:
                r2 = r3.Pk();
                if (r2 != 0) goto L_0x0a25;
            L_0x0a23:
                r2 = 0;
                goto L_0x09d8;
            L_0x0a25:
                r2 = com.tencent.mm.ap.f.a(r3);
                r5 = com.tencent.mm.ap.o.PC();
                r2 = r2.hBB;
                r6 = "";
                r7 = "";
                r2 = r5.m(r2, r6, r7);
                r2 = com.tencent.mm.a.e.bO(r2);
                if (r2 != 0) goto L_0x0a41;
            L_0x0a3f:
                r2 = 0;
                goto L_0x09d8;
            L_0x0a41:
                r2 = 1;
                goto L_0x09d8;
            L_0x0a43:
                r5 = com.tencent.mm.ap.o.PC();
                r6 = com.tencent.mm.ap.f.c(r3);
                r7 = "";
                r8 = "";
                r5 = r5.m(r6, r7, r8);
                r5 = com.tencent.mm.ui.chatting.b.g.c(r14, r5);
                if (r5 == 0) goto L_0x0ab3;
            L_0x0a5b:
                r2 = "MicroMsg.ChattingUI.SendImgImp";
                r3 = "img is expired or clean!!!";
                com.tencent.mm.sdk.platformtools.x.i(r2, r3);
                r2 = new android.content.Intent;
                r3 = r4.fhH;
                r3 = r3.cte();
                r3 = r3.getContext();
                r5 = com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.class;
                r2.<init>(r3, r5);
                r3 = "img_gallery_msg_id";
                r6 = r14.field_msgId;
                r2.putExtra(r3, r6);
                r3 = "img_gallery_msg_svr_id";
                r6 = r14.field_msgSvrId;
                r2.putExtra(r3, r6);
                r3 = "img_gallery_talker";
                r5 = r14.field_talker;
                r2.putExtra(r3, r5);
                r3 = "img_gallery_chatroom_name";
                r5 = r14.field_talker;
                r2.putExtra(r3, r5);
                r3 = "img_gallery_is_restransmit_after_download";
                r5 = 1;
                r2.putExtra(r3, r5);
                r3 = "Retr_show_success_tips";
                r5 = 1;
                r2.putExtra(r3, r5);
                r3 = r4.fhH;
                com.tencent.mm.ui.chatting.b.g.a(r3, r14, r2);
                r3 = r4.fhH;
                r3 = r3.cte();
                r3.startActivity(r2);
                goto L_0x0997;
            L_0x0ab3:
                r5 = r3.offset;
                r6 = r3.hmZ;
                if (r5 < r6) goto L_0x0b0d;
            L_0x0ab9:
                r5 = r3.hmZ;
                if (r5 == 0) goto L_0x0b0d;
            L_0x0abd:
                r5 = new android.content.Intent;
                r6 = r4.fhH;
                r6 = r6.cte();
                r6 = r6.getContext();
                r7 = com.tencent.mm.ui.transmit.MsgRetransmitUI.class;
                r5.<init>(r6, r7);
                r6 = "Retr_File_Name";
                r7 = com.tencent.mm.ap.o.PC();
                r3 = com.tencent.mm.ap.f.c(r3);
                r8 = "";
                r9 = "";
                r3 = r7.m(r3, r8, r9);
                r5.putExtra(r6, r3);
                r3 = "Retr_Msg_Id";
                r6 = r14.field_msgId;
                r5.putExtra(r3, r6);
                r3 = "Retr_Msg_Type";
                r6 = 0;
                r5.putExtra(r3, r6);
                r3 = "Retr_show_success_tips";
                r6 = 1;
                r5.putExtra(r3, r6);
                r3 = "Retr_Compress_Type";
                r5.putExtra(r3, r2);
                r2 = r4.fhH;
                r2 = r2.cte();
                r2.startActivity(r5);
                goto L_0x0997;
            L_0x0b0d:
                r3 = new android.content.Intent;
                r5 = r4.fhH;
                r5 = r5.cte();
                r5 = r5.getContext();
                r6 = com.tencent.mm.ui.transmit.MsgRetransmitUI.class;
                r3.<init>(r5, r6);
                r5 = "Retr_File_Name";
                r6 = com.tencent.mm.ap.o.PC();
                r7 = r14.field_imgPath;
                r8 = 1;
                r6 = r6.B(r7, r8);
                r3.putExtra(r5, r6);
                r5 = "Retr_Msg_Id";
                r6 = r14.field_msgId;
                r3.putExtra(r5, r6);
                r5 = "Retr_Msg_Type";
                r6 = 0;
                r3.putExtra(r5, r6);
                r5 = "Retr_show_success_tips";
                r6 = 1;
                r3.putExtra(r5, r6);
                r5 = "Retr_Compress_Type";
                r3.putExtra(r5, r2);
                r2 = r4.fhH;
                r2 = r2.cte();
                r2.startActivity(r3);
                goto L_0x0997;
            L_0x0b56:
                com.tencent.mm.y.as.Hm();
                r3 = com.tencent.mm.y.c.isSDCardAvailable();
                if (r3 != 0) goto L_0x0b6f;
            L_0x0b5f:
                r2 = r2.fhH;
                r2 = r2.cte();
                r2 = r2.getContext();
                com.tencent.mm.ui.base.u.fJ(r2);
            L_0x0b6c:
                r2 = 1;
                goto L_0x0096;
            L_0x0b6f:
                r3 = new com.tencent.mm.modelvoice.n;
                r4 = r14.field_content;
                r3.<init>(r4);
                r4 = new android.content.Intent;
                r5 = r2.fhH;
                r5 = r5.cte();
                r5 = r5.getContext();
                r6 = com.tencent.mm.ui.transmit.MsgRetransmitUI.class;
                r4.<init>(r5, r6);
                r5 = "Retr_File_Name";
                r6 = r14.field_imgPath;
                r4.putExtra(r5, r6);
                r5 = "Retr_length";
                r6 = r3.time;
                r3 = (int) r6;
                r4.putExtra(r5, r3);
                r3 = "MicroMsg.ChattingUI.VoiceImp";
                r5 = new java.lang.StringBuilder;
                r6 = "voice msg.getType():";
                r5.<init>(r6);
                r6 = r14.getType();
                r5 = r5.append(r6);
                r5 = r5.toString();
                com.tencent.mm.sdk.platformtools.x.d(r3, r5);
                r3 = "Retr_Msg_Type";
                r5 = 7;
                r4.putExtra(r3, r5);
                r2 = r2.fhH;
                r2 = r2.cte();
                r2.startActivity(r4);
                goto L_0x0b6c;
            L_0x0bc3:
                r2.aO(r14);
                r2 = 1;
                goto L_0x00a2;
            L_0x0bc9:
                r3 = r14.aNL();
                if (r3 == 0) goto L_0x0bf3;
            L_0x0bcf:
                r3 = new java.util.LinkedList;
                r3.<init>();
                r3.add(r14);
                r4 = r2.fhH;
                r4 = r4.cte();
                r4 = r4.getContext();
                r5 = r2.fhH;
                r5 = r5.csR();
                r2 = r2.fhH;
                r2 = r2.csW();
                r2 = r2.field_username;
                r6 = 0;
                com.tencent.mm.ui.chatting.j.a(r4, r3, r5, r2, r6);
            L_0x0bf3:
                r2 = 1;
                goto L_0x00ae;
            L_0x0bf6:
                r2 = 0;
                goto L_0x00d1;
            L_0x0bf9:
                r2 = r14.cjW();
                if (r2 == 0) goto L_0x00f3;
            L_0x0bff:
                r2 = r14.field_imgPath;
                com.tencent.mm.pluginsdk.model.k.Sb(r2);
                goto L_0x00f3;
            L_0x0c06:
                r2 = com.tencent.mm.modelstat.b.hRo;
                r2.v(r14);
                goto L_0x0107;
            L_0x0c0d:
                r2 = r15.yAM;
                r3 = r21.getGroupId();
                r2 = r2.getItem(r3);
                r2 = (com.tencent.mm.storage.au) r2;
                r2 = r2.field_content;
                r3 = "MicroMsg.ChattingUI";
                r4 = new java.lang.StringBuilder;
                r5 = "groupId = ";
                r4.<init>(r5);
                r5 = r21.getGroupId();
                r4 = r4.append(r5);
                r5 = ", content length: ";
                r4 = r4.append(r5);
                if (r2 != 0) goto L_0x0c90;
            L_0x0c37:
                r2 = 0;
            L_0x0c38:
                r2 = r4.append(r2);
                r2 = r2.toString();
                com.tencent.mm.sdk.platformtools.x.d(r3, r2);
                r2 = r15.yAM;
                r3 = r21.getGroupId();
                r2 = r2.getItem(r3);
                r2 = (com.tencent.mm.storage.au) r2;
                r3 = r15.aA(r2);
                r2 = r15.mCW;	 Catch:{ Exception -> 0x0c95 }
                r2.setText(r3);	 Catch:{ Exception -> 0x0c95 }
            L_0x0c58:
                r2 = r15.getContext();
                r4 = r15.getContext();
                r5 = com.tencent.mm.R.l.dEE;
                r4 = r4.getString(r5);
                com.tencent.mm.ui.base.h.bu(r2, r4);
                r2 = com.tencent.mm.plugin.secinforeport.a.a.qlf;
                r4 = 1;
                r5 = new java.lang.StringBuilder;
                r5.<init>();
                r2 = r15.yAM;
                r6 = r21.getGroupId();
                r2 = r2.getItem(r6);
                r2 = (com.tencent.mm.storage.au) r2;
                r6 = r2.field_msgSvrId;
                r2 = r5.append(r6);
                r2 = r2.toString();
                r3 = com.tencent.mm.sdk.platformtools.bi.We(r3);
                com.tencent.mm.plugin.secinforeport.a.a.d(r4, r2, r3);
                goto L_0x000f;
            L_0x0c90:
                r2 = r2.length();
                goto L_0x0c38;
            L_0x0c95:
                r2 = move-exception;
                r2 = "MicroMsg.ChattingUI";
                r4 = "clip.setText error ";
                com.tencent.mm.sdk.platformtools.x.e(r2, r4);
                goto L_0x0c58;
            L_0x0ca0:
                r2 = r15.yyW;
                r2 = r2.aP(r14);
                if (r2 != 0) goto L_0x000f;
            L_0x0ca8:
                r2 = r15.yEB;
                r2 = r2.aP(r14);
                if (r2 != 0) goto L_0x000f;
            L_0x0cb0:
                r2 = r14.cjV();
                if (r2 == 0) goto L_0x0cbd;
            L_0x0cb6:
                r2 = r15.yEJ;
                r2.aH(r14);
                goto L_0x000f;
            L_0x0cbd:
                r2 = r15.yEF;
                r2 = r2.aP(r14);
                if (r2 != 0) goto L_0x000f;
            L_0x0cc5:
                goto L_0x000f;
            L_0x0cc7:
                r3 = new android.content.Intent;
                r2 = r15.getContext();
                r4 = com.tencent.mm.ui.transmit.MsgRetransmitUI.class;
                r3.<init>(r2, r4);
                r2 = r15.yAM;
                r4 = r21.getGroupId();
                r2 = r2.getItem(r4);
                r2 = (com.tencent.mm.storage.au) r2;
                r2 = r15.aA(r2);
                r4 = r14.cjO();
                if (r4 == 0) goto L_0x0cfa;
            L_0x0ce8:
                r4 = "Retr_Msg_content";
                r3.putExtra(r4, r2);
                r2 = "Retr_Msg_Type";
                r4 = 6;
                r3.putExtra(r2, r4);
            L_0x0cf5:
                r15.startActivity(r3);
                goto L_0x000f;
            L_0x0cfa:
                r4 = "Retr_Msg_content";
                r3.putExtra(r4, r2);
                r2 = "Retr_Msg_Type";
                r4 = 4;
                r3.putExtra(r2, r4);
                goto L_0x0cf5;
            L_0x0d08:
                r2 = r14.field_content;
                r3 = r14.field_isSend;
                r2 = r15.dn(r2, r3);
                r3 = com.tencent.mm.x.g.a.fV(r2);
                r4 = new android.content.Intent;
                r2 = r15.getContext();
                r5 = com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI.class;
                r4.<init>(r2, r5);
                r2 = 1;
                if (r3 == 0) goto L_0x0d71;
            L_0x0d22:
                r5 = r3.type;
                r6 = 6;
                if (r5 == r6) goto L_0x0d2c;
            L_0x0d27:
                r5 = r3.type;
                r6 = 2;
                if (r5 != r6) goto L_0x0d71;
            L_0x0d2c:
                r5 = com.tencent.mm.pluginsdk.model.app.an.aqK();
                r3 = r3.for;
                r3 = r5.Se(r3);
                if (r3 == 0) goto L_0x0d40;
            L_0x0d38:
                r3 = r3.field_fileFullPath;
                r3 = com.tencent.mm.modelsfs.FileOp.bO(r3);
                if (r3 != 0) goto L_0x0d41;
            L_0x0d40:
                r2 = 0;
            L_0x0d41:
                r3 = r14.cjW();
                if (r3 == 0) goto L_0x0d86;
            L_0x0d47:
                com.tencent.mm.modelvideo.o.Ub();
                r3 = r14.field_imgPath;
                r3 = com.tencent.mm.modelvideo.s.nx(r3);
                r3 = com.tencent.mm.modelsfs.FileOp.bO(r3);
                if (r3 != 0) goto L_0x0d57;
            L_0x0d56:
                r2 = 0;
            L_0x0d57:
                if (r2 != 0) goto L_0x0d9d;
            L_0x0d59:
                r2 = r15.getContext();
                r3 = com.tencent.mm.R.l.dXO;
                r3 = r15.getMMString(r3);
                r4 = "";
                r5 = new com.tencent.mm.ui.chatting.ChattingUI$a$14;
                r5.<init>();
                r6 = 0;
                com.tencent.mm.ui.base.h.a(r2, r3, r4, r5, r6);
                goto L_0x000f;
            L_0x0d71:
                r3 = r14.cjT();
                if (r3 == 0) goto L_0x0d41;
            L_0x0d77:
                com.tencent.mm.ap.o.PC();
                r3 = com.tencent.mm.ap.g.p(r14);
                r3 = com.tencent.mm.sdk.platformtools.bi.oN(r3);
                if (r3 == 0) goto L_0x0d41;
            L_0x0d84:
                r2 = 0;
                goto L_0x0d41;
            L_0x0d86:
                r3 = r14.cjX();
                if (r3 == 0) goto L_0x0d57;
            L_0x0d8c:
                com.tencent.mm.modelvideo.o.Ub();
                r3 = r14.field_imgPath;
                r3 = com.tencent.mm.modelvideo.s.nx(r3);
                r3 = com.tencent.mm.modelsfs.FileOp.bO(r3);
                if (r3 != 0) goto L_0x0d57;
            L_0x0d9b:
                r2 = 0;
                goto L_0x0d57;
            L_0x0d9d:
                r2 = "exdevice_open_scene_type";
                r3 = 1;
                r4.putExtra(r2, r3);
                r2 = "Retr_Msg_Id";
                r6 = r14.field_msgId;
                r4.putExtra(r2, r6);
                r15.startActivity(r4);
                goto L_0x000f;
            L_0x0db1:
                com.tencent.mm.y.as.Hm();
                r2 = com.tencent.mm.y.c.isSDCardAvailable();
                if (r2 != 0) goto L_0x0dc3;
            L_0x0dba:
                r2 = r15.getContext();
                com.tencent.mm.ui.base.u.fJ(r2);
                goto L_0x000f;
            L_0x0dc3:
                r2 = 0;
                r4 = r14.field_msgId;
                r6 = 0;
                r3 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
                if (r3 <= 0) goto L_0x0dd6;
            L_0x0dcc:
                r2 = com.tencent.mm.ap.o.PC();
                r4 = r14.field_msgId;
                r2 = r2.bj(r4);
            L_0x0dd6:
                if (r2 == 0) goto L_0x0de0;
            L_0x0dd8:
                r4 = r2.hBA;
                r6 = 0;
                r3 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
                if (r3 > 0) goto L_0x0df2;
            L_0x0de0:
                r4 = r14.field_msgSvrId;
                r6 = 0;
                r3 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
                if (r3 <= 0) goto L_0x0df2;
            L_0x0de8:
                r2 = com.tencent.mm.ap.o.PC();
                r4 = r14.field_msgSvrId;
                r2 = r2.bi(r4);
            L_0x0df2:
                if (r2 == 0) goto L_0x000f;
            L_0x0df4:
                r3 = com.tencent.mm.ap.o.PC();
                r2 = r2.hBB;
                r4 = "";
                r5 = "";
                r2 = r3.m(r2, r4, r5);
                r3 = com.tencent.mm.a.e.bO(r2);
                if (r3 == 0) goto L_0x000f;
            L_0x0e0a:
                r3 = r15.getContext();
                r4 = com.tencent.mm.R.l.dGu;
                r4 = r15.getMMString(r4);
                com.tencent.mm.pluginsdk.h.c.a(r3, r4, r2);
                goto L_0x000f;
            L_0x0e19:
                r2 = r14.cjV();
                if (r2 == 0) goto L_0x0e47;
            L_0x0e1f:
                r2 = r14.field_content;
                r3 = r14.field_isSend;
                r2 = r15.dn(r2, r3);
                r3 = r15.getContext();
                com.tencent.mm.ui.chatting.ah.k(r2, r3);
            L_0x0e2e:
                r2 = "MicroMsg.ChattingUI";
                r3 = "type is %d";
                r4 = 1;
                r4 = new java.lang.Object[r4];
                r5 = 0;
                r6 = r14.getType();
                r6 = java.lang.Integer.valueOf(r6);
                r4[r5] = r6;
                com.tencent.mm.sdk.platformtools.x.i(r2, r3, r4);
                goto L_0x000f;
            L_0x0e47:
                r2 = r14.cjL();
                if (r2 == 0) goto L_0x0e90;
            L_0x0e4d:
                r2 = r15.getContext();
                if (r2 != 0) goto L_0x0e5d;
            L_0x0e53:
                r2 = "MicroMsg.LongClickBrandServiceHelper";
                r3 = "showAcceptVoiceConnector: context is null";
                com.tencent.mm.sdk.platformtools.x.w(r2, r3);
                goto L_0x0e2e;
            L_0x0e5d:
                if (r14 != 0) goto L_0x0e69;
            L_0x0e5f:
                r2 = "MicroMsg.LongClickBrandServiceHelper";
                r3 = "showAcceptVoiceConnector: msg is null";
                com.tencent.mm.sdk.platformtools.x.w(r2, r3);
                goto L_0x0e2e;
            L_0x0e69:
                com.tencent.mm.y.as.Hm();
                r3 = com.tencent.mm.y.c.isSDCardAvailable();
                if (r3 != 0) goto L_0x0e7f;
            L_0x0e72:
                com.tencent.mm.ui.base.u.fJ(r2);
                r2 = "MicroMsg.LongClickBrandServiceHelper";
                r3 = "showAcceptVoiceConnector: sd card not available";
                com.tencent.mm.sdk.platformtools.x.w(r2, r3);
                goto L_0x0e2e;
            L_0x0e7f:
                r3 = com.tencent.mm.af.f.LS();
                r3 = com.tencent.mm.ui.chatting.ah.dn(r3);
                r4 = new com.tencent.mm.ui.chatting.ah$4;
                r4.<init>(r14, r2);
                com.tencent.mm.ui.chatting.ah.a(r3, r2, r4);
                goto L_0x0e2e;
            L_0x0e90:
                r2 = r14.cjT();
                if (r2 == 0) goto L_0x0ea6;
            L_0x0e96:
                r2 = r15.getContext();
                r0 = r16;
                r3 = r0.a(r15, r14);
                r4 = r15.yAR;
                com.tencent.mm.ui.chatting.ah.a(r14, r2, r3, r4);
                goto L_0x0e2e;
            L_0x0ea6:
                r2 = r14.cjW();
                if (r2 == 0) goto L_0x0eb5;
            L_0x0eac:
                r2 = r15.getContext();
                com.tencent.mm.ui.chatting.ah.a(r14, r2);
                goto L_0x0e2e;
            L_0x0eb5:
                r2 = r14.aNL();
                if (r2 == 0) goto L_0x0ef1;
            L_0x0ebb:
                r2 = r14.field_content;
                r3 = r15.getContext();
                if (r3 != 0) goto L_0x0ece;
            L_0x0ec3:
                r2 = "MicroMsg.LongClickBrandServiceHelper";
                r3 = "showAcceptLocationConnector: context is null";
                com.tencent.mm.sdk.platformtools.x.w(r2, r3);
                goto L_0x0e2e;
            L_0x0ece:
                r4 = com.tencent.mm.sdk.platformtools.bi.oN(r2);
                if (r4 == 0) goto L_0x0edf;
            L_0x0ed4:
                r2 = "MicroMsg.LongClickBrandServiceHelper";
                r3 = "showAcceptLocationConnector: locationXML is null";
                com.tencent.mm.sdk.platformtools.x.w(r2, r3);
                goto L_0x0e2e;
            L_0x0edf:
                r4 = com.tencent.mm.af.f.LV();
                r4 = com.tencent.mm.ui.chatting.ah.dn(r4);
                r5 = new com.tencent.mm.ui.chatting.ah$7;
                r5.<init>(r2, r3);
                com.tencent.mm.ui.chatting.ah.a(r4, r3, r5);
                goto L_0x0e2e;
            L_0x0ef1:
                r2 = r14.cjU();
                if (r2 == 0) goto L_0x0e2e;
            L_0x0ef7:
                r2 = r14.field_content;
                r3 = r15.getContext();
                if (r3 != 0) goto L_0x0f0a;
            L_0x0eff:
                r2 = "MicroMsg.LongClickBrandServiceHelper";
                r3 = "showAcceptPersonalCardConnector: context is null";
                com.tencent.mm.sdk.platformtools.x.w(r2, r3);
                goto L_0x0e2e;
            L_0x0f0a:
                r4 = com.tencent.mm.sdk.platformtools.bi.oN(r2);
                if (r4 == 0) goto L_0x0f1b;
            L_0x0f10:
                r2 = "MicroMsg.LongClickBrandServiceHelper";
                r3 = "showAcceptPersonalCardConnector: locationXML is null";
                com.tencent.mm.sdk.platformtools.x.w(r2, r3);
                goto L_0x0e2e;
            L_0x0f1b:
                r4 = com.tencent.mm.af.f.LX();
                r4 = com.tencent.mm.ui.chatting.ah.dn(r4);
                r5 = new com.tencent.mm.ui.chatting.ah$8;
                r5.<init>(r2, r3);
                com.tencent.mm.ui.chatting.ah.a(r4, r3, r5);
                goto L_0x0e2e;
            L_0x0f2d:
                r2 = "MicroMsg.ChattingUI";
                r3 = "[oneliang][longclick_menu_revoke] type:%d,item.getGroupId:%d";
                r4 = 2;
                r4 = new java.lang.Object[r4];
                r5 = 0;
                r6 = r14.getType();
                r6 = java.lang.Integer.valueOf(r6);
                r4[r5] = r6;
                r5 = 1;
                r6 = r21.getGroupId();
                r6 = java.lang.Integer.valueOf(r6);
                r4[r5] = r6;
                com.tencent.mm.sdk.platformtools.x.d(r2, r3, r4);
                r2 = r21.getGroupId();
                r15.yFo = r2;
                r2 = new com.tencent.mm.modelsimple.z;
                r3 = com.tencent.mm.R.l.dSX;
                r3 = r15.getMMString(r3);
                r2.<init>(r14, r3);
                r3 = r15.getContext();
                r4 = com.tencent.mm.R.l.dSW;
                r4 = r15.getMMString(r4);
                r5 = 1;
                r6 = new com.tencent.mm.ui.chatting.ChattingUI$a$24;
                r6.<init>(r14, r2);
                r3 = com.tencent.mm.ui.base.h.a(r3, r4, r5, r6);
                r15.tipDialog = r3;
                r3 = com.tencent.mm.y.as.CN();
                r4 = 0;
                r3.a(r2, r4);
                goto L_0x000f;
            L_0x0f80:
                r2 = r15.yFm;
                if (r2 != 0) goto L_0x0fdf;
            L_0x0f84:
                r2 = r15.yFl;
                if (r2 != 0) goto L_0x0f9f;
            L_0x0f88:
                r2 = com.tencent.mm.R.h.cVZ;
                r2 = r15.findViewById(r2);
                r2 = (android.view.ViewStub) r2;
                if (r2 == 0) goto L_0x0f95;
            L_0x0f92:
                r2.inflate();
            L_0x0f95:
                r2 = com.tencent.mm.R.h.bUc;
                r2 = r15.findViewById(r2);
                r2 = (com.tencent.mm.ui.chatting.ChattingFooterMoreBtnBar) r2;
                r15.yFl = r2;
            L_0x0f9f:
                r2 = new com.tencent.mm.ui.chatting.s;
                r4 = r15.yFl;
                r5 = r15.yAM;
                r3 = r15.yEM;
                r6 = r3.ctp();
                r3 = r15.yEM;
                r7 = r3.ctq();
                r8 = r15.fBc;
                r9 = r15.yxU;
                r3 = r15;
                r2.<init>(r3, r4, r5, r6, r7, r8, r9);
                r15.yFm = r2;
            L_0x0fbb:
                r2 = r15.yFl;
                r2.csu();
                r2 = r15.yFm;
                r2.aw(r14);
                r2 = r15.yFm;
                r3 = r15.yEG;
                r3 = r3.yJu;
                r2.yAH = r3;
                r2 = r15.fBc;
                r2 = r2.ciN();
                if (r2 == 0) goto L_0x0fda;
            L_0x0fd5:
                r2 = com.tencent.mm.R.h.cvU;
                r15.removeOptionMenu(r2);
            L_0x0fda:
                r15.ctI();
                goto L_0x000f;
            L_0x0fdf:
                r2 = r15.yFm;
                r3 = r15.fBc;
                r4 = r15.yxU;
                r2.b(r3, r4);
                goto L_0x0fbb;
            L_0x0fe9:
                com.tencent.mm.y.as.Hm();
                r2 = com.tencent.mm.y.c.Db();
                r3 = com.tencent.mm.storage.w.a.USERINFO_POSITION_REMIND_MSG_TIP_IN_BOOLEAN;
                r4 = 1;
                r4 = java.lang.Boolean.valueOf(r4);
                r2 = r2.get(r3, r4);
                r2 = (java.lang.Boolean) r2;
                r2 = r2.booleanValue();
                if (r2 == 0) goto L_0x102e;
            L_0x1003:
                r2 = r15.getContext();
                r3 = com.tencent.mm.R.l.eEJ;
                r3 = r15.getMMString(r3);
                r4 = com.tencent.mm.R.l.eEK;
                r4 = r15.getMMString(r4);
                r5 = new com.tencent.mm.ui.chatting.ChattingUI$a$15;
                r5.<init>(r14);
                com.tencent.mm.ui.base.h.a(r2, r3, r4, r5);
                com.tencent.mm.y.as.Hm();
                r2 = com.tencent.mm.y.c.Db();
                r3 = com.tencent.mm.storage.w.a.USERINFO_POSITION_REMIND_MSG_TIP_IN_BOOLEAN;
                r4 = 0;
                r4 = java.lang.Boolean.valueOf(r4);
                r2.a(r3, r4);
                goto L_0x000f;
            L_0x102e:
                r15.az(r14);
                goto L_0x000f;
            L_0x1033:
                r3 = r2;
                goto L_0x09ca;
            L_0x1036:
                r3 = r2;
                goto L_0x0919;
            L_0x1039:
                r4 = r2;
                goto L_0x0193;
            L_0x103c:
                r3 = r2;
                goto L_0x01d6;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.viewitems.b.c.a.onMMMenuItemSelected(android.view.MenuItem, int):void");
            }
        }

        static /* synthetic */ void a(c cVar, ContextMenu contextMenu, au auVar, int i) {
            if (!com.tencent.mm.storage.x.Xg(cVar.yyH.fBc.field_username) && contextMenu != null && (contextMenu instanceof n) && auVar.getType() != 318767153) {
                if (auVar.getType() == 49) {
                    com.tencent.mm.x.g.a I = com.tencent.mm.x.g.a.I(auVar.field_content, auVar.field_reserved);
                    if (I == null || I.type == 6 || I.type == 38 || I.type == 39) {
                        return;
                    }
                }
                Object obj = contextMenu.findItem(116) != null ? 1 : null;
                n nVar = (n) contextMenu;
                Object linkedList = new LinkedList();
                List<MenuItem> list = nVar.ykH;
                for (MenuItem menuItem : list) {
                    com.tencent.mm.ui.base.o oVar;
                    if (menuItem.getItemId() == 116) {
                        oVar = new com.tencent.mm.ui.base.o(com.tencent.mm.plugin.appbrand.jsapi.map.d.CTRL_INDEX, i);
                        oVar.setTitle(cVar.yyH.getMMString(R.l.dSk));
                        linkedList.add(menuItem);
                        linkedList.add(oVar);
                    } else if (obj == null && menuItem.getItemId() == 100) {
                        oVar = new com.tencent.mm.ui.base.o(com.tencent.mm.plugin.appbrand.jsapi.map.d.CTRL_INDEX, i);
                        oVar.setTitle(cVar.yyH.getMMString(R.l.dSk));
                        linkedList.add(oVar);
                        linkedList.add(menuItem);
                    } else {
                        linkedList.add(menuItem);
                    }
                }
                list.clear();
                list.addAll(linkedList);
                linkedList.clear();
            }
        }

        public c(com.tencent.mm.ui.chatting.ChattingUI.a aVar) {
            this.yyH = aVar;
            if (aVar instanceof com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.a) {
                this.pHg = new com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.b(aVar);
            } else {
                this.pHg = new OnCreateContextMenuListener(b.this) {
                    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                        ar arVar = (ar) view.getTag();
                        if (arVar != null) {
                            int i = arVar.position;
                            au auVar = arVar.fFE;
                            if (auVar == null) {
                                x.e("MicroMsg.ChattingItem", "msg is null!");
                                return;
                            }
                            boolean a = b.this.a(contextMenu, view, auVar);
                            if (com.tencent.mm.storage.x.Xf(c.this.yyH.csn()) || com.tencent.mm.storage.x.Xd(c.this.yyH.csn())) {
                                x.i("MicroMsg.ChattingItem", "on create context menu, match qcontact or tcontact, remove favorite menu item");
                                contextMenu.removeItem(116);
                            }
                            if (a) {
                                if (c.this.yyH.ctJ()) {
                                    contextMenu.add(i, 100, 0, view.getContext().getString(R.l.dRS));
                                }
                                if ((b.this.cwn() && c.this.yyH.ctJ()) || c.this.yyH.fBc.ciN()) {
                                    contextMenu.add(i, 122, 0, c.this.yyH.getMMString(R.l.dRV));
                                }
                                if (contextMenu.findItem(123) != null) {
                                    contextMenu.removeItem(100);
                                }
                                c.a(c.this, contextMenu, auVar, i);
                                return;
                            }
                            if (auVar.cjT()) {
                                as.Hm();
                                if (com.tencent.mm.y.c.isSDCardAvailable()) {
                                    v vVar = c.this.yyH.yEB;
                                    contextMenu.add(i, 100, 0, vVar.fhH.cte().getMMString(R.l.dRR));
                                    e eVar = null;
                                    if (auVar.field_msgId > 0) {
                                        eVar = com.tencent.mm.ap.o.PC().bj(auVar.field_msgId);
                                    }
                                    if ((eVar == null || eVar.hBA <= 0) && auVar.field_msgSvrId > 0) {
                                        eVar = com.tencent.mm.ap.o.PC().bi(auVar.field_msgSvrId);
                                    }
                                    if (auVar.field_isSend == 1 || (eVar != null && auVar.field_isSend == 0 && eVar.offset >= eVar.hmZ && eVar.hmZ != 0)) {
                                        contextMenu.add(i, 110, 0, vVar.fhH.cte().getMMString(R.l.eEP));
                                    }
                                    String m = eVar == null ? "" : com.tencent.mm.ap.o.PC().m(eVar.hBB, "", "");
                                    if (eVar != null && com.tencent.mm.a.e.bO(m)) {
                                        contextMenu.add(i, MMGIFException.D_GIF_ERR_IMAGE_DEFECT, 0, vVar.fhH.cte().getMMString(R.l.dQV));
                                    }
                                    if (auVar.field_status == 5) {
                                        contextMenu.add(i, 103, 0, c.this.yyH.getMMString(R.l.dSa));
                                        f.c(com.tencent.mm.ap.o.PC().n(auVar));
                                    }
                                    if (contextMenu.findItem(123) != null) {
                                        contextMenu.removeItem(100);
                                    }
                                    c.a(c.this, contextMenu, auVar, i);
                                }
                            }
                            if (auVar.cjP()) {
                                contextMenu.add(i, 100, 0, c.this.yyH.getMMString(R.l.dRS));
                            }
                            if (auVar.field_status == 5) {
                                contextMenu.add(i, 103, 0, c.this.yyH.getMMString(R.l.dSa));
                                f.c(com.tencent.mm.ap.o.PC().n(auVar));
                            }
                            if (contextMenu.findItem(123) != null) {
                                contextMenu.removeItem(100);
                            }
                            c.a(c.this, contextMenu, auVar, i);
                        }
                    }
                };
            }
            this.yRs = new a();
        }

        public final boolean onLongClick(View view) {
            if (view.getTag(R.h.cSM) instanceof int[]) {
                int[] iArr = (int[]) view.getTag(R.h.cSM);
                l(view, iArr[0], iArr[1]);
            } else if (!(this.kMb == 0 && this.kMc == 0) && this.yRt.equals(view)) {
                l(view, this.kMb, this.kMc);
            } else {
                view.setOnTouchListener(new OnTouchListener() {
                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        c.this.kMb = (int) motionEvent.getRawX();
                        c.this.kMc = (int) motionEvent.getRawY();
                        c.this.yRt = view;
                        return false;
                    }
                });
            }
            return true;
        }

        private void l(View view, int i, int i2) {
            ar arVar = (ar) view.getTag();
            if (arVar != null) {
                this.yRs.fou = arVar.fFE;
                new i(this.yyH.getContext()).a(view, this.pHg, this.yRs, i, i2);
            }
        }
    }

    public abstract View a(LayoutInflater layoutInflater, View view);

    public abstract void a(a aVar, int i, com.tencent.mm.ui.chatting.ChattingUI.a aVar2, au auVar, String str);

    public abstract boolean a(ContextMenu contextMenu, View view, au auVar);

    public abstract boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.ChattingUI.a aVar, au auVar);

    abstract boolean aXP();

    public abstract boolean ak(int i, boolean z);

    public abstract boolean b(View view, com.tencent.mm.ui.chatting.ChattingUI.a aVar, au auVar);

    public static void q(ImageView imageView, String str) {
        if (bi.oN(str)) {
            imageView.setImageResource(R.g.bBC);
        } else {
            com.tencent.mm.pluginsdk.ui.a.b.a(imageView, str);
        }
    }

    public static int fP(Context context) {
        float ev = com.tencent.mm.bu.a.ev(context);
        if (ev == 0.875f) {
            return com.tencent.mm.bu.a.ab(context, R.f.bwW);
        }
        if (ev == 1.125f) {
            return com.tencent.mm.bu.a.ab(context, R.f.bwS);
        }
        if (ev == 1.25f) {
            return com.tencent.mm.bu.a.ab(context, R.f.bwX);
        }
        if (ev == 1.375f) {
            return com.tencent.mm.bu.a.ab(context, R.f.bwN);
        }
        if (ev == 1.625f || ev == 1.875f || ev == 2.025f) {
            return com.tencent.mm.bu.a.ab(context, R.f.bwO);
        }
        return com.tencent.mm.bu.a.ab(context, R.f.bwV);
    }

    public static int fQ(Context context) {
        float ev = com.tencent.mm.bu.a.ev(context);
        if (!(ev == 0.875f || ev == 1.125f)) {
            if (ev == 1.25f) {
                return com.tencent.mm.bu.a.ab(context, R.f.bwM);
            }
            if (ev == 1.375f) {
                return com.tencent.mm.bu.a.ab(context, R.f.bwK);
            }
            if (ev == 1.625f || ev == 1.875f || ev == 2.025f) {
                return com.tencent.mm.bu.a.ab(context, R.f.bwO);
            }
        }
        return com.tencent.mm.bu.a.ab(context, R.f.bwL);
    }

    public static void r(ImageView imageView, String str) {
        if (bi.oN(str)) {
            imageView.setImageResource(R.g.bAa);
        } else {
            com.tencent.mm.pluginsdk.ui.a.b.o(imageView, str);
        }
    }

    public final void a(a aVar, int i, com.tencent.mm.ui.chatting.ChattingUI.a aVar2, au auVar) {
        long j = yMJ + 30000;
        long currentTimeMillis = System.currentTimeMillis();
        yMJ = currentTimeMillis;
        if (j < currentTimeMillis) {
            as.Hm();
            yRa = com.tencent.mm.y.c.isSDCardAvailable();
        }
        this.vGb = yRa;
        String str = null;
        if (cwl()) {
            str = a(aVar2, auVar);
            a(aVar, aVar2, auVar, str);
            a(aVar, aVar2, str, auVar);
        }
        a(aVar, i, aVar2, auVar, str);
    }

    protected boolean cwl() {
        return true;
    }

    protected void a(a aVar, com.tencent.mm.ui.chatting.ChattingUI.a aVar2, au auVar, String str) {
        if (str != null && aVar.qng != null && auVar != null) {
            CharSequence charSequence = null;
            if (auVar.field_isSend == 0 && !bi.oN(auVar.gkL)) {
                com.tencent.mm.af.g ke = y.Mk().ke(auVar.gkL);
                Object obj = 1;
                if (ke == null || bi.oN(ke.field_openId) || bi.oN(ke.field_nickname)) {
                    x.i("MicroMsg.ChattingItem", "fillingUsername:need getKfInfo");
                } else {
                    charSequence = ke.field_nickname;
                    obj = null;
                }
                if (obj != null || com.tencent.mm.af.i.a(ke)) {
                    y.Mm().a(new b(aVar2.yAM, auVar.gkL));
                    y.Mm().af(aVar2.yAM.talker, auVar.gkL);
                }
            } else if (r(aVar2) && aVar2.yEK.cua()) {
                charSequence = aVar2.yEL.yHs ? com.tencent.mm.pluginsdk.ui.d.i.b(aVar2.getContext(), aVar2.gw(auVar.field_bizChatUserId), aVar.qng.getTextSize()) : com.tencent.mm.pluginsdk.ui.d.i.b(aVar2.getContext(), aVar2.gw(str), aVar.qng.getTextSize());
            }
            a(aVar, charSequence);
        }
    }

    protected boolean r(com.tencent.mm.ui.chatting.ChattingUI.a aVar) {
        if (aXP()) {
            return false;
        }
        if (aVar.yAR || aVar.yEL.vus) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String a(com.tencent.mm.ui.chatting.ChattingUI.a r4, com.tencent.mm.storage.au r5) {
        /*
        r3 = this;
        r0 = r3.aXP();
        if (r0 == 0) goto L_0x000b;
    L_0x0006:
        r0 = r4.yAM;
        r1 = r0.hnt;
    L_0x000a:
        return r1;
    L_0x000b:
        r0 = r4.yAM;
        r1 = r0.talker;
        r0 = r3.r(r4);
        if (r0 == 0) goto L_0x000a;
    L_0x0015:
        r0 = r4.yAR;
        if (r0 == 0) goto L_0x002b;
    L_0x0019:
        r0 = r5.field_content;
        r0 = com.tencent.mm.y.bb.hS(r0);
        if (r1 == 0) goto L_0x0030;
    L_0x0021:
        if (r0 == 0) goto L_0x0030;
    L_0x0023:
        r2 = r0.length();
        if (r2 <= 0) goto L_0x0030;
    L_0x0029:
        r1 = r0;
        goto L_0x000a;
    L_0x002b:
        if (r5 == 0) goto L_0x0030;
    L_0x002d:
        r0 = r5.field_bizChatUserId;
        goto L_0x0029;
    L_0x0030:
        r0 = r1;
        goto L_0x0029;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.viewitems.b.a(com.tencent.mm.ui.chatting.ChattingUI$a, com.tencent.mm.storage.au):java.lang.String");
    }

    protected static String b(com.tencent.mm.ui.chatting.ChattingUI.a aVar, au auVar) {
        String str = auVar.field_talker;
        if (!aVar.yEL.vus || aVar.yEL.yvJ == null) {
            return str;
        }
        return aVar.yEL.yvJ.field_bizChatServId;
    }

    public static String a(au auVar, boolean z, boolean z2) {
        String str = null;
        if (auVar == null) {
            return null;
        }
        if (auVar.field_isSend == 1) {
            return com.tencent.mm.y.q.FY();
        }
        if (z) {
            str = bb.hS(auVar.field_content);
        } else if (z2) {
            str = auVar.field_bizChatUserId;
        }
        if (bi.oN(str)) {
            return auVar.field_talker;
        }
        return str;
    }

    protected static void a(a aVar, CharSequence charSequence) {
        if (aVar != null && aVar.qng != null) {
            if (charSequence == null) {
                aVar.qng.setVisibility(8);
                return;
            }
            aVar.qng.setText(charSequence);
            aVar.qng.setVisibility(0);
        }
    }

    protected final c s(com.tencent.mm.ui.chatting.ChattingUI.a aVar) {
        if (this.yRb == null) {
            this.yRb = new c(aVar);
        }
        return this.yRb;
    }

    protected final d t(com.tencent.mm.ui.chatting.ChattingUI.a aVar) {
        if (this.yRc == null) {
            if (aVar instanceof com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.a) {
                com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.a aVar2 = (com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.a) aVar;
                this.yRc = new AnonymousClass5(aVar2, this);
            } else {
                this.yRc = new d(aVar, this);
            }
        }
        return this.yRc;
    }

    protected final com.tencent.mm.ui.chatting.r.b u(com.tencent.mm.ui.chatting.ChattingUI.a aVar) {
        if (this.yRe == null) {
            this.yRe = new com.tencent.mm.ui.chatting.r.b(aVar);
        }
        return this.yRe;
    }

    protected final com.tencent.mm.ui.chatting.r.c v(com.tencent.mm.ui.chatting.ChattingUI.a aVar) {
        if (this.yRf == null) {
            this.yRf = new com.tencent.mm.ui.chatting.r.c(aVar);
        }
        return this.yRf;
    }

    protected final o w(com.tencent.mm.ui.chatting.ChattingUI.a aVar) {
        if (this.yRg == null) {
            this.yRg = new o(aVar);
        }
        return this.yRg;
    }

    protected final j x(com.tencent.mm.ui.chatting.ChattingUI.a aVar) {
        if (this.yRi == null) {
            this.yRi = new j(aVar);
        }
        return this.yRi;
    }

    protected final void a(a aVar, com.tencent.mm.ui.chatting.ChattingUI.a aVar2, String str, au auVar) {
        String str2 = null;
        if (aVar.ikK != null) {
            if (!s.hq(str) || str.equals(s.hhb[0])) {
                Object obj;
                ar arVar;
                ar obj2;
                if (auVar != null && !bi.oN(auVar.gkL)) {
                    if (aVar2.yAR) {
                        str2 = aVar2.csn();
                    }
                    arVar = new ar(str, str2);
                    arVar.yXz = auVar.gkL;
                    com.tencent.mm.pluginsdk.ui.a.b.g(aVar.ikK, auVar.gkL, R.g.bzE);
                    obj2 = arVar;
                } else if (auVar == null || !aVar2.yEL.vus) {
                    if (aVar2.yAR) {
                        str2 = aVar2.csn();
                    }
                    arVar = new ar(str, str2);
                    q(aVar.ikK, str);
                    obj2 = arVar;
                } else {
                    arVar = new ar(auVar.field_bizChatUserId, null);
                    com.tencent.mm.ap.a.a PG = com.tencent.mm.ap.o.PG();
                    com.tencent.mm.ui.chatting.b.c cVar = aVar2.yEL;
                    com.tencent.mm.af.a.j kn = cVar.yvJ.kn(auVar.field_bizChatUserId);
                    if (kn != null) {
                        str2 = kn.field_headImageUrl;
                    }
                    PG.a(str2, aVar.ikK, aVar2.yAM.liE);
                    obj2 = arVar;
                }
                aVar.ikK.setVisibility(0);
                aVar.ikK.setTag(obj2);
                if (!this.yRd) {
                    this.yRd = true;
                    if (!(aVar2 instanceof com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.a)) {
                        if (auVar == null || bi.oN(auVar.gkL)) {
                            this.yRe = new com.tencent.mm.ui.chatting.r.b(aVar2);
                            this.yRf = new com.tencent.mm.ui.chatting.r.c(aVar2);
                        } else {
                            this.yRe = new com.tencent.mm.ui.chatting.r.a(aVar2);
                        }
                        aVar.ikK.setOnClickListener(this.yRe);
                        aVar.ikK.setOnLongClickListener(this.yRf);
                    }
                }
                p.dn(aVar.ikK);
                aVar.ikK.setContentDescription(r.gw(str) + aVar2.getContext().getString(R.l.bLJ));
                if (aVar.yRl == null) {
                    return;
                }
                if (auVar == null || auVar.gkD == null || !auVar.gkD.contains("watch_msg_source_type")) {
                    aVar.yRl.setVisibility(8);
                    return;
                }
                int intValue;
                try {
                    intValue = Integer.valueOf((String) bj.y(auVar.gkD, "msgsource").get(".msgsource.watch_msg_source_type")).intValue();
                } catch (Exception e) {
                    intValue = 0;
                }
                if (intValue <= 0 || intValue > 4) {
                    aVar.yRl.setVisibility(8);
                    return;
                } else {
                    aVar.yRl.setVisibility(0);
                    return;
                }
            }
            aVar.ikK.setVisibility(8);
        }
    }

    protected static void a(com.tencent.mm.ui.chatting.ChattingUI.a aVar, View view, String str) {
        if (com.tencent.mm.pluginsdk.model.app.g.Sg(str)) {
            Object bVar = new com.tencent.mm.pluginsdk.ui.chat.l.b();
            bVar.appId = str;
            bVar.fFG = "message";
            a(aVar, view, bVar);
            return;
        }
        view.setTag(new com.tencent.mm.pluginsdk.ui.chat.l.b());
    }

    protected static void a(com.tencent.mm.ui.chatting.ChattingUI.a aVar, View view, au auVar, com.tencent.mm.x.g.a aVar2, String str, long j) {
        if (com.tencent.mm.pluginsdk.model.app.g.Sg(aVar2.appId)) {
            int i = aVar.yxU ? 2 : 1;
            Object aVar3 = new com.tencent.mm.pluginsdk.ui.chat.l.a();
            aVar3.appId = aVar2.appId;
            aVar3.fFG = "message";
            aVar3.ffM = str;
            aVar3.fGc = c(aVar, auVar);
            aVar3.vyl = aVar2.type;
            aVar3.scene = i;
            aVar3.vym = aVar2.mediaTagName;
            aVar3.fGj = j;
            a(aVar, view, aVar3);
            return;
        }
        view.setTag(new com.tencent.mm.pluginsdk.ui.chat.l.b());
    }

    private static void a(com.tencent.mm.ui.chatting.ChattingUI.a aVar, View view, Object obj) {
        view.setTag(obj);
        view.setOnClickListener(aVar.yAM.yBF);
    }

    protected static void a(com.tencent.mm.ui.chatting.ChattingUI.a aVar, ImageView imageView, String str) {
        Bitmap b = com.tencent.mm.pluginsdk.model.app.g.b(str, 2, com.tencent.mm.bu.a.getDensity(aVar.getContext()));
        if (b == null || b.isRecycled()) {
            a(aVar, imageView, BitmapFactory.decodeResource(aVar.getResources(), R.g.bEn));
        } else {
            a(aVar, imageView, b);
        }
    }

    private static void a(com.tencent.mm.ui.chatting.ChattingUI.a aVar, ImageView imageView, Bitmap bitmap) {
        Drawable bitmapDrawable = new BitmapDrawable(bitmap);
        int dimension = (int) aVar.getResources().getDimension(R.f.bvX);
        bitmapDrawable.setBounds(0, 0, dimension, dimension);
        imageView.setImageDrawable(bitmapDrawable);
    }

    protected static void a(com.tencent.mm.ui.chatting.ChattingUI.a aVar, TextView textView, String str) {
        Bitmap b = com.tencent.mm.pluginsdk.model.app.g.b(str, 2, com.tencent.mm.bu.a.getDensity(aVar.getContext()));
        if (b == null || b.isRecycled()) {
            a(aVar, textView, BitmapFactory.decodeResource(aVar.getResources(), R.g.bEn));
        } else {
            a(aVar, textView, b);
        }
    }

    private static void a(com.tencent.mm.ui.chatting.ChattingUI.a aVar, TextView textView, Bitmap bitmap) {
        Drawable bitmapDrawable = new BitmapDrawable(bitmap);
        int dimension = (int) aVar.getResources().getDimension(R.f.bvX);
        bitmapDrawable.setBounds(0, 0, dimension, dimension);
        textView.setCompoundDrawables(bitmapDrawable, null, null, null);
    }

    protected final void b(com.tencent.mm.ui.chatting.ChattingUI.a aVar, View view, Object obj) {
        view.setTag(obj);
        if (this.yRh == null) {
            this.yRh = new g(aVar);
        }
        view.setOnClickListener(this.yRh);
    }

    protected static void c(com.tencent.mm.ui.chatting.ChattingUI.a aVar, View view, Object obj) {
        view.setTag(obj);
        view.setOnClickListener(aVar.yAM.yBJ);
    }

    public final boolean a(com.tencent.mm.ui.chatting.ChattingUI.a aVar, com.tencent.mm.x.g.a aVar2, au auVar) {
        if (bi.oN(aVar2.heZ)) {
            return false;
        }
        com.tencent.mm.ui.chatting.a.a(com.tencent.mm.ui.chatting.a.a.EnterCompleteVideo, auVar, aVar2.hfg, aVar2.hff);
        String str = auVar.field_imgPath;
        Intent intent = new Intent();
        intent.putExtra("IsAd", false);
        intent.putExtra("KStremVideoUrl", aVar2.heZ);
        intent.putExtra("KThumUrl", aVar2.hfe);
        intent.putExtra("KThumbPath", str);
        intent.putExtra("KSta_StremVideoAduxInfo", aVar2.hff);
        intent.putExtra("KSta_StremVideoPublishId", aVar2.hfg);
        intent.putExtra("KSta_SourceType", 2);
        intent.putExtra("KSta_Scene", aVar.yAR ? com.tencent.mm.ui.chatting.a.b.TalkChat.value : com.tencent.mm.ui.chatting.a.b.Chat.value);
        intent.putExtra("KSta_FromUserName", a(aVar, auVar));
        intent.putExtra("KSta_ChatName", aVar.csn());
        intent.putExtra("KSta_MsgId", auVar.field_msgSvrId);
        intent.putExtra("KSta_SnsStatExtStr", aVar2.fHB);
        if (aVar.yAR) {
            intent.putExtra("KSta_ChatroomMembercount", com.tencent.mm.y.m.gn(aVar.csn()));
        }
        intent.putExtra("KMediaId", "fakeid_" + auVar.field_msgId);
        intent.putExtra("KMediaVideoTime", aVar2.hfa);
        intent.putExtra("StremWebUrl", aVar2.hfd);
        intent.putExtra("StreamWording", aVar2.hfc);
        intent.putExtra("KMediaTitle", aVar2.title);
        com.tencent.mm.bl.d.b(aVar.getContext(), "sns", ".ui.VideoAdPlayerUI", intent);
        return true;
    }

    protected final void a(com.tencent.mm.ui.chatting.ChattingUI.a aVar, String str, String str2, String str3, int i, String str4, boolean z, long j, long j2, au auVar) {
        if ((str == null || str.length() == 0) && (str2 == null || str2.length() == 0)) {
            x.e("MicroMsg.ChattingItem", "url, lowUrl both are empty");
            return;
        }
        if (ao.isMobile(aVar.getContext()) ? str2 != null && str2.length() > 0 : str == null || str.length() <= 0) {
            str = str2;
        }
        Intent intent = new Intent();
        intent.putExtra("msg_id", j);
        intent.putExtra("rawUrl", str);
        intent.putExtra("version_name", str3);
        intent.putExtra("version_code", i);
        intent.putExtra("usePlugin", z);
        intent.putExtra("geta8key_username", aVar.csn());
        intent.putExtra("KPublisherId", "msg_" + Long.toString(j2));
        intent.putExtra("KAppId", str4);
        intent.putExtra("pre_username", a(aVar, auVar));
        intent.putExtra("prePublishId", "msg_" + Long.toString(j2));
        if (auVar != null) {
            intent.putExtra("preUsername", a(aVar, auVar));
        }
        intent.putExtra("preChatName", aVar.csn());
        intent.putExtra("preChatTYPE", t.N(a(aVar, auVar), aVar.csn()));
        intent.putExtra("preMsgIndex", 0);
        com.tencent.mm.bl.d.b(aVar.getContext(), "webview", ".ui.tools.WebViewUI", intent);
    }

    protected static boolean cz(String str) {
        return com.tencent.mm.pluginsdk.model.app.g.cz(str);
    }

    protected static PackageInfo getPackageInfo(Context context, String str) {
        String str2;
        PackageInfo packageInfo = null;
        if (str == null || str.length() == 0) {
            str2 = packageInfo;
        } else {
            com.tencent.mm.pluginsdk.model.app.f aZ = com.tencent.mm.pluginsdk.model.app.g.aZ(str, true);
            if (aZ == null) {
                Object str22 = packageInfo;
            } else {
                str22 = aZ.field_packageName;
            }
        }
        if (str22 == null) {
            return packageInfo;
        }
        try {
            return context.getPackageManager().getPackageInfo(str22, 0);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.ChattingItem", e, "", new Object[0]);
            return packageInfo;
        }
    }

    protected final void a(int i, a aVar, au auVar, String str, boolean z, com.tencent.mm.ui.chatting.ChattingUI.a aVar2) {
        if (auVar.field_isSend == 1) {
            int i2;
            aVar.yRo.setTag(new ar(auVar, z, i, str, (byte) 0));
            ImageView imageView = aVar.yRo;
            if (this.yRj == null) {
                this.yRj = new m(aVar2);
            }
            imageView.setOnClickListener(this.yRj);
            switch (auVar.field_status) {
                case 1:
                case 2:
                case 3:
                case 4:
                    i2 = -1;
                    break;
                case 5:
                    i2 = R.g.bGw;
                    break;
                default:
                    x.e("MicroMsg.ChattingItem", "getMsgStateResId: not found this state");
                    i2 = -1;
                    break;
            }
            if (i2 != -1) {
                aVar.yRo.setImageResource(i2);
                aVar.yRo.setVisibility(0);
                aVar.yRo.setContentDescription(ad.getContext().getString(R.l.evW));
                if (aVar.pyj != null) {
                    aVar.pyj.setVisibility(8);
                    return;
                }
                return;
            }
            aVar.yRo.setVisibility(8);
        }
    }

    public static void a(com.tencent.mm.ui.chatting.ChattingUI.a aVar, com.tencent.mm.x.g.a aVar2, String str, com.tencent.mm.pluginsdk.model.app.f fVar, long j) {
        int i = aVar.yxU ? 2 : 1;
        int i2 = (fVar == null || !com.tencent.mm.pluginsdk.model.app.p.m(aVar.getContext(), fVar.field_packageName)) ? 6 : 3;
        if (aVar2.type == 2) {
            i2 = 4;
        } else if (aVar2.type == 5) {
            i2 = 1;
        }
        com.tencent.mm.sdk.b.b njVar = new nj();
        njVar.fGg.context = aVar.getContext();
        njVar.fGg.scene = i;
        njVar.fGg.fGh = aVar2.appId;
        njVar.fGg.packageName = fVar == null ? null : fVar.field_packageName;
        njVar.fGg.msgType = aVar2.type;
        njVar.fGg.fAJ = str;
        njVar.fGg.fGi = i2;
        njVar.fGg.mediaTagName = aVar2.mediaTagName;
        njVar.fGg.fGj = j;
        njVar.fGg.fGk = "";
        com.tencent.mm.sdk.b.a.xmy.m(njVar);
    }

    protected static void a(com.tencent.mm.ui.chatting.ChattingUI.a aVar, com.tencent.mm.x.g.a aVar2, au auVar, com.tencent.mm.pluginsdk.model.app.f fVar) {
        com.tencent.mm.pluginsdk.q.j jVar = com.tencent.mm.pluginsdk.q.a.vjc;
        if (jVar != null) {
            int i = aVar.yAR ? 2 : 1;
            jVar.a(aVar.getContext(), aVar2.appId, fVar == null ? null : fVar.field_packageName, c(aVar, auVar), aVar2.type, aVar2.mediaTagName, i);
        }
    }

    protected static void b(com.tencent.mm.ui.chatting.ChattingUI.a aVar, com.tencent.mm.x.g.a aVar2, au auVar) {
        com.tencent.mm.pluginsdk.q.j jVar = com.tencent.mm.pluginsdk.q.a.vjc;
        if (jVar != null) {
            int i = aVar.yAR ? 2 : 1;
            String c = c(aVar, auVar);
            aVar.getContext();
            jVar.a(aVar2.appId, c, aVar2.type, i, aVar2.mediaTagName, auVar.field_msgSvrId);
        }
    }

    protected static boolean a(com.tencent.mm.ui.chatting.ChattingUI.a aVar, com.tencent.mm.pluginsdk.model.app.f fVar) {
        com.tencent.mm.pluginsdk.q.j jVar = com.tencent.mm.pluginsdk.q.a.vjc;
        if (com.tencent.mm.pluginsdk.model.app.g.a(aVar.getContext(), fVar) || jVar == null) {
            return false;
        }
        if (!bi.oN(fVar.fRD)) {
            x.i("MicroMsg.ChattingItem", "oversea game info and gpdownload url is not empty, jump to google play directy:[%s], jump result: [%b]", fVar.fRD, Boolean.valueOf(com.tencent.mm.pluginsdk.model.app.q.aY(aVar.getContext(), fVar.fRD)));
            if (com.tencent.mm.pluginsdk.model.app.q.aY(aVar.getContext(), fVar.fRD)) {
                return true;
            }
        }
        int i = aVar.yxU ? 2 : 1;
        com.tencent.mm.sdk.b.b gnVar = new gn();
        gnVar.fxx.actionCode = 2;
        gnVar.fxx.scene = i;
        gnVar.fxx.appId = fVar.field_appId;
        gnVar.fxx.context = aVar.getContext();
        com.tencent.mm.sdk.b.a.xmy.m(gnVar);
        aVar.getContext();
        jVar.L(fVar.field_appId, i, i);
        return true;
    }

    public static String c(com.tencent.mm.ui.chatting.ChattingUI.a aVar, au auVar) {
        String csn = aVar.csn();
        if (s.eX(csn)) {
            return bb.hS(auVar.field_content);
        }
        return csn;
    }

    public static void a(au auVar, EmojiInfo emojiInfo) {
        com.tencent.mm.sdk.b.b coVar = new co();
        coVar.frG.frH = emojiInfo;
        coVar.frG.frH.talker = auVar != null ? auVar.field_talker : null;
        coVar.frG.scene = 0;
        com.tencent.mm.sdk.b.a.xmy.m(coVar);
    }

    protected static boolean a(au auVar, com.tencent.mm.ui.chatting.ChattingUI.a aVar) {
        int i;
        if (System.currentTimeMillis() - auVar.field_createTime > 120000) {
            i = 1;
        } else {
            boolean i2 = false;
        }
        if (i2 != 0) {
            return false;
        }
        if (aVar != null && aVar.yAM.talker.equals(aVar.yAM.hnt) && auVar.field_status == 2) {
            return false;
        }
        x.d("MicroMsg.ChattingItem", "[oneliang][isRevokeMsgEnable] enable:%d", Integer.valueOf(com.tencent.mm.j.g.Af().getInt("ShowRevokeMsgEntry", 1)));
        if (1 == com.tencent.mm.j.g.Af().getInt("ShowRevokeMsgEntry", 1)) {
            return true;
        }
        return false;
    }

    protected static boolean ZX(String str) {
        return !(s.gU(str) || s.hj(str) || s.gI(str) || s.hr(str)) || s.eX(str);
    }

    protected static boolean cwm() {
        String value = com.tencent.mm.j.g.Af().getValue("ShowSendOK");
        if (1 == (bi.oN(value) ? 0 : bi.Wo(value))) {
            return true;
        }
        return false;
    }

    protected static boolean a(q qVar, long j) {
        if (j > 0) {
            if (qVar.yBY == -1) {
                qVar.yBY = 0;
                Cursor cursor = qVar.getCursor();
                int position = cursor.getPosition();
                int count = cursor.getCount();
                x.i("MicroMsg.ChattingListAdapter", "curPos %d, curCount %d", Integer.valueOf(position), Integer.valueOf(count));
                if (cursor.moveToLast()) {
                    do {
                        qVar.yCd = null;
                        qVar.yCd = q.a(qVar.yCd, cursor);
                        if (qVar.yCd.field_isSend == 1) {
                            if ((qVar.yCd.gkC & 4) != 4) {
                                qVar.yBY = qVar.yCd.field_msgId;
                            }
                        }
                    } while (cursor.moveToPrevious());
                }
                if (count < 0) {
                    if (count > 0) {
                        cursor.moveToPosition(0);
                    }
                } else if (position < count) {
                    cursor.moveToPosition(position);
                } else if (count > 0) {
                    cursor.moveToPosition(count - 1);
                }
            }
            if (qVar.yBY == j) {
                return true;
            }
        }
        return false;
    }

    protected boolean cwn() {
        return true;
    }
}
