package com.tencent.mm.ui.conversation;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.af.w;
import com.tencent.mm.af.y;
import com.tencent.mm.f.a.l;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.f.b.ak;
import com.tencent.mm.f.b.cg;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.bdg;
import com.tencent.mm.protocal.c.bet;
import com.tencent.mm.protocal.c.qi;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ae;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.e;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.v;
import com.tencent.mm.ui.widget.i;
import com.tencent.mm.x.m;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bb;
import com.tencent.mm.y.c;
import com.tencent.mm.y.s;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

public class BizConversationUI extends BaseConversationUI {
    private View contentView;

    public static class a extends com.tencent.mm.ui.conversation.BaseConversationUI.b {
        private ae conversation;
        private TextView emptyTipTv;
        private String hpQ;
        private boolean isDeleteCancel = false;
        private int kMb = 0;
        private int kMc = 0;
        private i kMf;
        private d otp = new d() {
            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                switch (menuItem.getItemId()) {
                    case 1:
                        as.Hm();
                        ag Xv = c.Ff().Xv(a.this.talker);
                        if (Xv == null) {
                            x.e("MicroMsg.BizConversationUI", "changed biz stick status failed, contact is null, talker = " + a.this.talker);
                            return;
                        } else if (Xv.AS()) {
                            g.pWK.h(13307, Xv.field_username, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(2));
                            s.s(a.this.talker, true);
                            return;
                        } else {
                            g.pWK.h(13307, Xv.field_username, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(2));
                            s.r(a.this.talker, true);
                            return;
                        }
                    case 2:
                        as.Hm();
                        com.tencent.mm.ui.tools.b.a(y.Ml().jN(a.this.talker), a.this.thisActivity(), c.Ff().Xv(a.this.talker), 2);
                        return;
                    case 3:
                        a.b(a.this, a.this.talker);
                        return;
                    default:
                        return;
                }
            }
        };
        private com.tencent.mm.sdk.b.c pXb = new com.tencent.mm.sdk.b.c<l>() {
            {
                this.xmG = l.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                l lVar = (l) bVar;
                if (!(lVar == null || lVar.foa == null || lVar.foa.fob)) {
                    a.this.zfm = 0;
                }
                return false;
            }
        };
        private String talker = "";
        private r tipDialog = null;
        private ListView zfj;
        private a zfk;
        private String zfl;
        private long zfm = 0;

        private static class b extends bdg {
            public long wTv;
            public int zfp;

            private b() {
                this.zfp = -1;
            }

            /* synthetic */ b(byte b) {
                this();
            }
        }

        private static class a extends d {
            private String fDP;
            HashMap<String, b> zfo = new HashMap();

            public a(Context context, String str, com.tencent.mm.ui.o.a aVar) {
                super(context, aVar);
                this.fDP = str;
            }

            public final void XH() {
                as.Hm();
                setCursor(c.Fk().c(s.hgU, this.koG, this.fDP));
                if (this.xQN != null) {
                    this.xQN.XE();
                }
                super.notifyDataSetChanged();
            }

            protected final void a(ae aeVar, boolean z, int i, boolean z2) {
                if (aeVar != null) {
                    b bVar;
                    b bVar2 = (b) this.zfo.get(aeVar.field_username);
                    if (bVar2 == null) {
                        bVar2 = new b();
                        this.zfo.put(aeVar.field_username, bVar2);
                        bVar = bVar2;
                    } else {
                        bVar = bVar2;
                    }
                    if (bVar.zfp <= 0) {
                        bVar.wPU = z;
                        boolean z3 = bVar.wPX || aeVar.field_unReadCount > 0;
                        bVar.wPX = z3;
                        bVar.npC = i + 1;
                        if (z2) {
                            bVar.zfp = bVar.npC;
                        }
                        bVar.wPW = (int) (System.currentTimeMillis() / 1000);
                        if (aeVar.field_lastSeq != bVar.wTv) {
                            bVar.wTv = aeVar.field_lastSeq;
                            cg Fd = ((h) com.tencent.mm.kernel.g.h(h.class)).aZO().Fd(aeVar.field_username);
                            if (Fd != null && Fd.cjK()) {
                                com.tencent.mm.x.l wr = ((com.tencent.mm.plugin.biz.a.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.biz.a.a.class)).wr(Fd.field_content);
                                if (wr != null || (!bi.cC(wr.hfI) && !bi.oN(((m) wr.hfI.get(0)).url))) {
                                    try {
                                        Uri parse = Uri.parse(((m) wr.hfI.get(0)).url);
                                        bVar.wPS = bi.getLong(parse.getQueryParameter("mid"), 0);
                                        bVar.wPT = bi.getInt(parse.getQueryParameter("idx"), 0);
                                    } catch (UnsupportedOperationException e) {
                                        x.w("MicroMsg.ConversationAdapter", "exposeLog exp %s", e.getMessage());
                                    } catch (Exception e2) {
                                        x.w("MicroMsg.ConversationAdapter", "exposeLog exp %s", e2.getMessage());
                                    }
                                }
                            }
                        }
                    }
                }
            }

            public final void a(ae aeVar, int i) {
                as.Hm();
                a(aeVar, c.Fk().g(aeVar), i, true);
            }
        }

        static /* synthetic */ void a(a aVar) {
            if (as.Hp() && "officialaccounts".equals(aVar.hpQ)) {
                int i;
                long currentTimeMillis = System.currentTimeMillis();
                int i2 = 0;
                int i3 = 0;
                int i4 = 0;
                long j = 0;
                StringBuilder stringBuilder = new StringBuilder("");
                as.Hm();
                Cursor c = c.Fk().c(s.hgU, null, aVar.hpQ);
                if (c != null) {
                    int columnIndex = c.getColumnIndex("unReadCount");
                    int columnIndex2 = c.getColumnIndex("conversationTime");
                    int columnIndex3 = c.getColumnIndex("flag");
                    int count = c.getCount();
                    ae aeVar = new ae();
                    while (c.moveToNext()) {
                        aeVar.ak(c.getLong(columnIndex3));
                        i = c.getInt(columnIndex);
                        if (i > 0) {
                            j = c.getLong(columnIndex2);
                            i3++;
                            i2 += i;
                        } else {
                            i = 0;
                        }
                        stringBuilder.append(c.isFirst() ? "" : ".").append(i);
                        as.Hm();
                        if (c.Fk().g(aeVar)) {
                            i4++;
                        }
                    }
                    c.close();
                    i = i2;
                    i2 = i3;
                    i3 = i4;
                    i4 = count;
                } else {
                    i = 0;
                    i2 = 0;
                    i3 = 0;
                    i4 = 0;
                }
                g.pWK.h(13771, Integer.valueOf(i4), Integer.valueOf(i2), Integer.valueOf(i), Long.valueOf(j / 1000), Integer.valueOf(i3), stringBuilder.toString());
                x.v("MicroMsg.BizConversationUI", "report use time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            }
        }

        static /* synthetic */ void a(a aVar, int i) {
            if (i <= 0) {
                aVar.emptyTipTv.setVisibility(0);
                aVar.zfj.setVisibility(8);
                return;
            }
            aVar.emptyTipTv.setVisibility(8);
            aVar.zfj.setVisibility(0);
        }

        static /* synthetic */ void b(a aVar) {
            if (aVar.zfm != 0 && "officialaccounts".equals(aVar.hpQ)) {
                g.pWK.h(13932, Integer.valueOf(((int) (System.currentTimeMillis() - aVar.zfm)) / 1000));
            }
        }

        static /* synthetic */ void b(a aVar, String str) {
            if (bi.oN(str)) {
                x.e("MicroMsg.BizConversationUI", "Delete Conversation and messages fail because username is null or nil.");
                return;
            }
            if ("officialaccounts".equals(aVar.hpQ)) {
                g.pWK.h(13773, Integer.valueOf(0), Integer.valueOf(aVar.conversation.field_unReadCount), Integer.valueOf(0), aVar.conversation.field_username);
            }
            as.Hm();
            cg Fc = c.Fh().Fc(str);
            com.tencent.mm.bp.a qiVar = new qi();
            qiVar.wfM = new bet().Vf(bi.oM(str));
            qiVar.vNT = Fc.field_msgSvrId;
            as.Hm();
            c.Fe().b(new com.tencent.mm.plugin.messenger.foundation.a.a.e.a(8, qiVar));
            aVar.isDeleteCancel = false;
            Context thisActivity = aVar.thisActivity();
            aVar.getString(R.l.dGZ);
            final ProgressDialog a = com.tencent.mm.ui.base.h.a(thisActivity, aVar.getString(R.l.dHn), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    a.this.isDeleteCancel = true;
                }
            });
            bb.a(str, new com.tencent.mm.y.bb.a() {
                public final boolean HH() {
                    return a.this.isDeleteCancel;
                }

                public final void HG() {
                    if (a != null) {
                        a.dismiss();
                    }
                }
            });
            as.Hm();
            ag Xv = c.Ff().Xv(str);
            as.Hm();
            ak XF = c.Fk().XF(str);
            as.Hm();
            c.Fk().XE(str);
            if (XF == null) {
                return;
            }
            if (XF.gd(4194304) || (Xv != null && Xv.ciN() && !com.tencent.mm.k.a.ga(Xv.field_type) && XF.field_conversationTime < y.Mx())) {
                as.CN().a(new com.tencent.mm.modelsimple.i(str), 0);
            }
        }

        static /* synthetic */ void c(a aVar) {
            if (aVar.zfk != null) {
                LinkedList linkedList = new LinkedList();
                for (Entry entry : aVar.zfk.zfo.entrySet()) {
                    b bVar = (b) entry.getValue();
                    bdg bdg = new bdg();
                    bdg.vTX = (String) entry.getKey();
                    bdg.wPS = bVar.wPS;
                    bdg.wPT = bVar.wPT;
                    bdg.npC = bVar.npC;
                    bdg.wPV = bVar.zfp > 0;
                    bdg.wPX = bVar.wPX;
                    bdg.wPU = bVar.wPU;
                    bdg.wPW = bVar.wPW;
                    linkedList.add(bdg);
                }
                com.tencent.mm.kernel.g.Dp().gRu.a(new w(linkedList), 0);
                x.d("MicroMsg.BizConversationUI", "reportExpose size:%d", Integer.valueOf(linkedList.size()));
            }
        }

        public final void onActivityCreated(Bundle bundle) {
            super.onActivityCreated(bundle);
            this.hpQ = thisActivity().getIntent().getStringExtra("enterprise_biz_name");
            if (bi.oN(this.hpQ)) {
                this.hpQ = "officialaccounts";
            }
            if (bi.oM(this.hpQ).equals("officialaccounts")) {
                g.pWK.k(11404, "");
            }
            this.zfl = thisActivity().getIntent().getStringExtra("enterprise_biz_display_name");
            if (bi.oN(this.zfl)) {
                this.zfl = getString(R.l.dMu);
            }
            setMMTitle(this.zfl);
            this.zfj = (ListView) findViewById(R.h.cSC);
            this.emptyTipTv = (TextView) findViewById(R.h.ceo);
            this.emptyTipTv.setText(R.l.ebM);
            setBackBtn(new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    a.this.finish();
                    return true;
                }
            });
            setToTop(new OnClickListener() {
                public final void onClick(View view) {
                    com.tencent.mm.platformtools.a.b.a(a.this.zfj);
                }
            });
            this.zfk = new a(thisActivity(), this.hpQ, new com.tencent.mm.ui.o.a() {
                public final void XE() {
                    a.a(a.this, a.this.zfk.getCount());
                }

                public final void XF() {
                }
            });
            this.zfk.a(new MMSlideDelView.c() {
                public final int ci(View view) {
                    return a.this.zfj.getPositionForView(view);
                }
            });
            this.zfk.a(new f() {
                public final void t(View view, int i) {
                    a.this.zfj.performItemClick(view, i, 0);
                }
            });
            this.zfj.setAdapter(this.zfk);
            this.kMf = new i(thisActivity());
            this.zfj.setOnItemClickListener(new OnItemClickListener() {
                public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    a.this.conversation = (ae) a.this.zfk.getItem(i);
                    a.this.talker = a.this.conversation.field_username;
                    ak f = a.this.conversation;
                    if (f == null) {
                        x.e("MicroMsg.BizConversationUI", "user should not be null. position:%d, size:%d", Integer.valueOf(i), Integer.valueOf(a.this.zfk.getCount()));
                        a.this.zfk.notifyDataSetChanged();
                        return;
                    }
                    Bundle bundle = new Bundle();
                    bundle.putInt("biz_click_item_unread_count", a.this.conversation.field_unReadCount);
                    bundle.putInt("biz_click_item_position", i + 1);
                    a.this.ui.startChatting(f.field_username, bundle, true);
                    a.this.zfk.a(f, i);
                }
            });
            this.zfj.setOnTouchListener(new OnTouchListener() {
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    switch (motionEvent.getAction()) {
                        case 0:
                            a.this.kMb = (int) motionEvent.getRawX();
                            a.this.kMc = (int) motionEvent.getRawY();
                            break;
                    }
                    return false;
                }
            });
            this.zfj.setOnItemLongClickListener(new OnItemLongClickListener() {
                public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                    a.this.conversation = (ae) a.this.zfk.getItem(i);
                    a.this.talker = a.this.conversation.field_username;
                    a.this.kMf.a(view, i, j, a.this, a.this.otp, a.this.kMb, a.this.kMc);
                    return true;
                }
            });
            this.zfk.a(new MMSlideDelView.c() {
                public final int ci(View view) {
                    return a.this.zfj.getPositionForView(view);
                }
            });
            this.zfk.a(new f() {
                public final void t(View view, int i) {
                    a.this.zfj.performItemClick(view, i, 0);
                }
            });
            this.zfk.a(new e() {
                public final void bp(Object obj) {
                    if (obj == null) {
                        x.e("MicroMsg.BizConversationUI", "onItemDel object null");
                        return;
                    }
                    a.b(a.this, obj.toString());
                }
            });
            if ("officialaccounts".equals(this.hpQ)) {
                com.tencent.mm.storage.c fp = com.tencent.mm.y.c.c.IL().fp("100045");
                boolean z = fp.isValid() && "1".equals(fp.civ().get("isOpenSearch"));
                x.d("MicroMsg.BizConversationUI", "open search entrance:%b", Boolean.valueOf(z));
                if (z) {
                    addIconOptionMenu(1, R.l.eRz, R.k.dvl, new OnMenuItemClickListener() {
                        public final boolean onMenuItemClick(MenuItem menuItem) {
                            if (com.tencent.mm.plugin.aj.a.g.Ae(0)) {
                                Intent QT = com.tencent.mm.bb.b.QT();
                                QT.putExtra("title", a.this.getString(R.l.ekX));
                                QT.putExtra("searchbar_tips", a.this.getString(R.l.ekX));
                                QT.putExtra("KRightBtn", true);
                                QT.putExtra("ftsneedkeyboard", true);
                                QT.putExtra("publishIdPrefix", "bs");
                                QT.putExtra("ftsType", 2);
                                QT.putExtra("ftsbizscene", 11);
                                Map b = com.tencent.mm.bb.b.b(11, true, 2);
                                String zZ = com.tencent.mm.plugin.aj.a.g.zZ(bi.Wo((String) b.get("scene")));
                                b.put("sessionId", zZ);
                                QT.putExtra("sessionId", zZ);
                                QT.putExtra("rawUrl", com.tencent.mm.bb.b.r(b));
                                QT.putExtra("key_load_js_without_delay", true);
                                QT.addFlags(67108864);
                                com.tencent.mm.bl.d.b(ad.getContext(), "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", QT);
                            } else {
                                x.e("MicroMsg.BizConversationUI", "fts h5 template not avail");
                            }
                            return true;
                        }
                    });
                }
            }
            as.Hm();
            c.Fk().a(this.zfk);
            this.zfm = System.currentTimeMillis();
            com.tencent.mm.sdk.b.a.xmy.b(this.pXb);
        }

        protected final int getLayoutId() {
            return R.i.dtj;
        }

        public final String getUserName() {
            return this.hpQ;
        }

        public final void onDestroy() {
            as.Dt().F(new Runnable() {
                public final void run() {
                    a.a(a.this);
                    a.b(a.this);
                    a.c(a.this);
                }
            });
            com.tencent.mm.sdk.b.a.xmy.c(this.pXb);
            if (as.Hp()) {
                as.Hm();
                c.Fk().b(this.zfk);
            }
            if (this.zfk != null) {
                this.zfk.onDestroy();
            }
            super.onDestroy();
        }

        public final void onResume() {
            x.v("MicroMsg.BizConversationUI", "on resume");
            if (this.zfk != null) {
                this.zfk.onResume();
            }
            super.onResume();
        }

        public final void onPause() {
            x.i("MicroMsg.BizConversationUI", "on pause");
            as.Hm();
            c.Fk().XH(this.hpQ);
            if (this.zfk != null) {
                this.zfk.onPause();
            }
            super.onPause();
        }

        public final void onActivityResult(int i, int i2, Intent intent) {
            super.onActivityResult(i, i2, intent);
            if (!(this.talker == null || this.talker.isEmpty())) {
                this.talker = "";
            }
            if (i2 == -1) {
            }
        }

        public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
            super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
            as.Hm();
            ag Xv = c.Ff().Xv(this.talker);
            if (Xv == null) {
                x.e("MicroMsg.BizConversationUI", "onCreateContextMenu, contact is null, talker = " + this.talker);
                return;
            }
            CharSequence AX = Xv.AX();
            if (AX.toLowerCase().endsWith("@chatroom") && bi.oN(Xv.field_nickname)) {
                AX = getString(R.l.dSY);
            }
            AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
            contextMenu.setHeaderTitle(com.tencent.mm.pluginsdk.ui.d.i.a(thisActivity(), AX));
            if (com.tencent.mm.k.a.ga(Xv.field_type)) {
                if (Xv.AS()) {
                    contextMenu.add(adapterContextMenuInfo.position, 1, 0, R.l.euz);
                } else {
                    contextMenu.add(adapterContextMenuInfo.position, 1, 0, R.l.dXn);
                }
                contextMenu.add(adapterContextMenuInfo.position, 2, 0, R.l.euv);
            }
            contextMenu.add(adapterContextMenuInfo.position, 3, 0, R.l.euC);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (as.Hp()) {
            this.contentView = v.fw(this).inflate(R.i.dbx, null);
            setContentView(this.contentView);
            this.conversationFm = new a();
            getSupportFragmentManager().aT().a(R.h.cwx, this.conversationFm).commit();
            com.tencent.mm.pluginsdk.e.a(this, this.contentView);
            return;
        }
        x.e("MicroMsg.BizConversationUI", "onCreate acc not ready!!!");
        finish();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        com.tencent.mm.pluginsdk.e.a(this, this.contentView);
    }
}
