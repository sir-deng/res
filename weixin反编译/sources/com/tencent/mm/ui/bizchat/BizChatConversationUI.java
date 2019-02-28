package com.tencent.mm.ui.bizchat;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ad.k;
import com.tencent.mm.af.a.j;
import com.tencent.mm.af.n;
import com.tencent.mm.af.y;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.protocal.c.ws;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.conversation.BaseConversationUI;
import com.tencent.mm.ui.conversation.BaseConversationUI.b;
import com.tencent.mm.ui.g;
import com.tencent.mm.ui.v;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.i;
import com.tencent.mm.y.s;
import java.util.Iterator;
import java.util.LinkedList;

public class BizChatConversationUI extends BaseConversationUI {
    private View contentView;

    public static class a extends b implements n, m.b {
        private TextView emptyTipTv;
        private String hqP;
        private boolean isCurrentActivity;
        private boolean isDeleteCancel = false;
        private ListView kHA;
        private d kHD;
        private com.tencent.mm.ui.tools.m kLQ;
        private int kMb = 0;
        private int kMc = 0;
        private long kMn;
        private String kMt;
        private r tipDialog;
        private LinearLayout ywj;
        private b ywk;
        private j ywl;
        private int ywm = 0;
        private com.tencent.mm.af.a.b.a ywn = new com.tencent.mm.af.a.b.a() {
            public final void a(com.tencent.mm.af.a.b.a.b bVar) {
                if (bVar != null && bVar.hsq != null && a.this.kMt.equals(bVar.hsq.field_brandUserName)) {
                    x.i("MicroMsg.BizChatConversationFmUI", "bizChatExtension bizChatConv change");
                    a.this.ywk.fV(bVar.hsp);
                    if (a.this.isCurrentActivity) {
                        a.this.ywk.XH();
                    }
                }
            }
        };
        private com.tencent.mm.af.a.d.a ywo = new com.tencent.mm.af.a.d.a() {
            public final void a(com.tencent.mm.af.a.d.a.b bVar) {
                if (bVar != null && bVar.hsA != null && a.this.kMt.equals(bVar.hsA.field_brandUserName)) {
                    x.i("MicroMsg.BizChatConversationFmUI", "bizChatExtension bizChat change");
                    a.this.ywk.fV(bVar.hsp);
                    if (a.this.isCurrentActivity) {
                        a.this.ywk.XH();
                    }
                }
            }
        };
        private com.tencent.mm.af.c.a ywp = new com.tencent.mm.af.c.a() {
            public final void a(com.tencent.mm.af.c.a.a aVar) {
                String d = a.this.crw();
                if (aVar != null && !bi.oN(aVar.hpQ) && aVar.hpQ.equals(d)) {
                    int l = a.this.ywm;
                    a.this.ywm = g.bl(a.this.getContext(), d);
                    if (a.this.ywm != l) {
                        a.this.cru();
                    }
                }
            }
        };

        static /* synthetic */ void a(a aVar, final long j) {
            x.i("MicroMsg.BizChatConversationFmUI", "deleteChatroom");
            y.Mn().ag(j);
            aVar.isDeleteCancel = false;
            Context thisActivity = aVar.thisActivity();
            aVar.getString(R.l.dGZ);
            aVar.tipDialog = h.a(thisActivity, aVar.getString(R.l.dHn), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    a.this.isDeleteCancel = true;
                }
            });
            i.a(aVar.kMt, j, new com.tencent.mm.y.bb.a() {
                public final boolean HH() {
                    return a.this.isDeleteCancel;
                }

                public final void HG() {
                    int i = 0;
                    if (a.this.tipDialog != null) {
                        y.Mn().aU(j);
                        y.Mo().aU(j);
                        com.tencent.mm.af.a.b Mo = y.Mo();
                        String a = a.this.kMt;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("select count(*) from BizChatConversation");
                        stringBuilder.append(" where brandUserName = '").append(a).append("' ");
                        Cursor a2 = Mo.gLA.a(stringBuilder.toString(), null, 2);
                        if (a2 != null) {
                            if (a2.moveToFirst()) {
                                i = a2.getInt(0);
                            }
                            a2.close();
                        }
                        if (i <= 0) {
                            as.Hm();
                            c.Fk().XE(a.this.kMt);
                        }
                        a.this.tipDialog.dismiss();
                    }
                }
            });
        }

        static /* synthetic */ void a(a aVar, LinkedList linkedList) {
            if (linkedList.size() == 0) {
                x.i("MicroMsg.BizChatConversationFmUI", "userIdList is empty");
                return;
            }
            SharedPreferences sharedPreferences = aVar.getSharedPreferences(ad.cgf(), 0);
            if (sharedPreferences.getBoolean("FIRST_TIME_IN_BIZCHAT_CONV_" + aVar.kMt, true)) {
                x.i("MicroMsg.BizChatConversationFmUI", "updateData");
                long currentTimeMillis = System.currentTimeMillis();
                e eVar = y.Mp().gLA;
                long j = 0;
                if (eVar instanceof com.tencent.mm.bx.h) {
                    j = ((com.tencent.mm.bx.h) eVar).dA(Thread.currentThread().getId());
                }
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    String str = (String) it.next();
                    com.tencent.mm.af.a.c ko = y.Mn().ko(str);
                    if (!(ko == null || ko.Mz())) {
                        j ca = y.Mp().ca(str);
                        str = ca != null ? ca.field_userName : null;
                        if (!(str == null || str.equals(ko.field_chatName))) {
                            ko.field_chatName = str;
                            y.Mn().b(ko);
                        }
                    }
                }
                if (eVar instanceof com.tencent.mm.bx.h) {
                    as.Hm();
                    c.Fc().fT(j);
                }
                sharedPreferences.edit().putBoolean("FIRST_TIME_IN_BIZCHAT_CONV_" + aVar.kMt, false).commit();
                x.d("MicroMsg.BizChatConversationFmUI", "updateData use time:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            }
        }

        static /* synthetic */ void m(a aVar) {
            aVar.ywl = y.Mp().ca(y.Mp().cb(aVar.kMt));
            if (aVar.ywl == null || bi.oN(aVar.ywl.field_addMemberUrl)) {
                Toast.makeText(aVar.thisActivity(), aVar.getString(R.l.dMA), 0).show();
                aVar.crv();
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("rawUrl", aVar.ywl.field_addMemberUrl);
            x.i("MicroMsg.BizChatConversationFmUI", "KRawUrl :%s", aVar.ywl.field_addMemberUrl);
            intent.putExtra("useJs", true);
            intent.addFlags(67108864);
            com.tencent.mm.bl.d.b(aVar.getContext(), "webview", ".ui.tools.WebViewUI", intent, 1);
        }

        public final void onActivityCreated(Bundle bundle) {
            super.onActivityCreated(bundle);
            this.kMt = thisActivity().getIntent().getStringExtra("Contact_User");
            x.i("MicroMsg.BizChatConversationFmUI", "[regitListener]");
            y.Mo().a(this.ywn, thisActivity().getMainLooper());
            y.Mn().a(this.ywo, thisActivity().getMainLooper());
            y.Ms().a(this.ywp, thisActivity().getMainLooper());
            as.Hm();
            c.Fk().a(this);
            this.emptyTipTv = (TextView) findViewById(R.h.ceo);
            this.emptyTipTv.setText(R.l.euF);
            this.kHA = (ListView) findViewById(R.h.cSC);
            cru();
            this.ywk = new b(thisActivity(), new com.tencent.mm.ui.o.a() {
                public final void XE() {
                    a.this.setMMTitle(com.tencent.mm.y.r.gw(a.this.kMt));
                    if (a.this.ywk.getCount() <= 0) {
                        a.this.emptyTipTv.setVisibility(0);
                        a.this.kHA.setVisibility(8);
                        return;
                    }
                    a.this.emptyTipTv.setVisibility(8);
                    if (a.this.kHA != null) {
                        a.this.kHA.setVisibility(0);
                    }
                }

                public final void XF() {
                }
            }, this.kMt);
            this.ywk.a(new MMSlideDelView.c() {
                public final int ci(View view) {
                    return a.this.kHA.getPositionForView(view);
                }
            });
            this.ywk.a(new f() {
                public final void t(View view, int i) {
                    a.this.kHA.performItemClick(view, i, 0);
                }
            });
            this.ywk.a(new MMSlideDelView.e() {
                public final void bp(Object obj) {
                    if (obj == null) {
                        x.e("MicroMsg.BizChatConversationFmUI", "onItemDel object null");
                    }
                }
            });
            this.kHA.setAdapter(this.ywk);
            this.kHD = new d() {
                public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                    com.tencent.mm.af.a.a aT;
                    switch (menuItem.getItemId()) {
                        case 0:
                            a.a(a.this, a.this.kMn);
                            return;
                        case 1:
                            aT = y.Mo().aT(a.this.kMn);
                            aT.field_unReadCount = 1;
                            aT.field_atCount = 0;
                            y.Mo().b(aT);
                            com.tencent.mm.modelstat.b.hRo.I(aT.field_brandUserName, true);
                            return;
                        case 2:
                            y.Mo().aV(a.this.kMn);
                            com.tencent.mm.modelstat.b.hRo.I(y.Mo().aT(a.this.kMn).field_brandUserName, false);
                            return;
                        case 3:
                            aT = y.Mo().aT(a.this.kMn);
                            if (y.Mo().aW(a.this.kMn)) {
                                y.Mo().aY(a.this.kMn);
                                com.tencent.mm.modelstat.b.hRo.c(true, aT.field_brandUserName, false);
                                return;
                            }
                            y.Mo().aX(a.this.kMn);
                            com.tencent.mm.modelstat.b.hRo.c(true, aT.field_brandUserName, true);
                            return;
                        default:
                            return;
                    }
                }
            };
            final com.tencent.mm.ui.widget.i iVar = new com.tencent.mm.ui.widget.i(thisActivity());
            this.kHA.setOnTouchListener(new OnTouchListener() {
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 0) {
                        a.this.kMb = (int) motionEvent.getRawX();
                        a.this.kMc = (int) motionEvent.getRawY();
                    }
                    return false;
                }
            });
            this.kHA.setOnItemLongClickListener(new OnItemLongClickListener() {
                public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                    iVar.a(view, i, j, a.this, a.this.kHD, a.this.kMb, a.this.kMc);
                    return true;
                }
            });
            this.kHA.setOnItemClickListener(new OnItemClickListener() {
                public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    a.this.fW(((com.tencent.mm.af.a.a) a.this.ywk.getItem(i)).field_bizChatId);
                }
            });
            setBackBtn(new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    a.this.finish();
                    return true;
                }
            });
            addIconOptionMenu(1, R.l.eRz, R.k.dvl, new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    x.v("MicroMsg.BizChatConversationFmUI", "search btn was clicked.");
                    Intent intent = new Intent(a.this.getContext(), BizChatSearchUI.class);
                    intent.putExtra("enterprise_biz_name", a.this.kMt);
                    intent.putExtra("biz_chat_search_scene", 1);
                    intent.putExtra("biz_chat_search_text", "");
                    intent.addFlags(67108864);
                    a.this.startActivity(intent);
                    return true;
                }
            });
            addIconOptionMenu(2, R.l.dCx, R.k.duZ, new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    if (a.this.kLQ != null) {
                        a.this.kLQ.dismiss();
                        a.this.kLQ = null;
                    }
                    a.this.kLQ = new com.tencent.mm.ui.tools.m(a.this.getContext());
                    a.this.kLQ.rQF = new p.c() {
                        public final void a(com.tencent.mm.ui.base.n nVar) {
                            if (a.this.ywm == 1) {
                                nVar.aj(2, R.l.ecu, R.k.dve);
                                g.n(a.this.getContext(), a.this.kMt, 6);
                            }
                            nVar.aj(1, R.l.dMz, R.k.dva);
                            nVar.aj(4, R.l.dMy, R.k.dvc);
                            nVar.aj(3, R.l.dCy, R.k.dvn);
                        }
                    };
                    a.this.kLQ.rQG = new d() {
                        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                            Intent intent;
                            switch (menuItem.getItemId()) {
                                case 1:
                                    a.m(a.this);
                                    return;
                                case 2:
                                    g.o(a.this.getContext(), a.this.kMt, 6);
                                    return;
                                case 3:
                                    if (bi.oN(a.this.hqP)) {
                                        a.this.hqP = y.Ml().jN(a.this.kMt).Ls();
                                    }
                                    if (!bi.oN(a.this.hqP) && y.Mv().jz(a.this.hqP)) {
                                        y.Ms();
                                        com.tencent.mm.af.c.a(a.this.hqP, null);
                                    }
                                    intent = new Intent();
                                    intent.putExtra("Contact_User", a.this.kMt);
                                    com.tencent.mm.bl.d.b(a.this.thisActivity(), "profile", ".ui.ContactInfoUI", intent);
                                    return;
                                case 4:
                                    if (bi.oN(a.this.kMt)) {
                                        x.e("MicroMsg.BizChatConversationFmUI", "brandUserName null");
                                        return;
                                    }
                                    intent = new Intent(a.this.getContext(), BizChatFavUI.class);
                                    intent.putExtra("Contact_User", a.this.kMt);
                                    intent.addFlags(67108864);
                                    a.this.startActivity(intent);
                                    return;
                                default:
                                    return;
                            }
                        }
                    };
                    a.this.kLQ.dN();
                    return false;
                }
            });
            crv();
            as.Dt().g(new Runnable() {
                public final void run() {
                    x.i("MicroMsg.BizChatConversationFmUI", "updateChatInfoFromSvr");
                    LinkedList linkedList = new LinkedList();
                    LinkedList linkedList2 = new LinkedList();
                    Cursor km = y.Mo().km(a.this.kMt);
                    if (km.moveToFirst()) {
                        while (!km.isAfterLast()) {
                            com.tencent.mm.af.a.a aVar = new com.tencent.mm.af.a.a();
                            aVar.b(km);
                            km.moveToNext();
                            com.tencent.mm.af.a.c ag = y.Mn().ag(aVar.field_bizChatId);
                            if (ag.MA()) {
                                if (ag.Mz()) {
                                    linkedList2.add(ag.field_bizChatServId);
                                } else {
                                    linkedList.add(ag.field_bizChatServId);
                                }
                            }
                        }
                    }
                    km.close();
                    if (linkedList2.size() > 0) {
                        y.Mr().a(linkedList2, a.this.kMt);
                    }
                    a.a(a.this, linkedList);
                    if (linkedList.size() > 0) {
                        y.Mr().b(linkedList, a.this.kMt);
                    }
                }
            }, 300);
            String crw = crw();
            if (crw != null) {
                y.Ms();
                com.tencent.mm.af.c.a(crw, null);
                x.e("MicroMsg.BizChatConversationFmUI", "update father attr from svr mainBizName:%s", crw);
            } else {
                x.e("MicroMsg.BizChatConversationFmUI", "mainBizName is null!!!");
            }
            Looper.myQueue().addIdleHandler(new IdleHandler() {
                public final boolean queueIdle() {
                    a.this.hqP = y.Ml().jN(a.this.kMt).Ls();
                    int intExtra = a.this.thisActivity().getIntent().getIntExtra("biz_chat_from_scene", 7);
                    int i = -1;
                    if (a.this.ywk != null) {
                        i = a.this.ywk.getCount();
                    }
                    com.tencent.mm.af.b jA = y.Ms().jA(a.this.hqP);
                    int i2 = jA != null ? jA.field_qyUin : 0;
                    int i3 = jA != null ? jA.field_userUin : 0;
                    int jC = y.Ms().jC(a.this.kMt);
                    long j = jA != null ? jA.field_wwCorpId : 0;
                    long j2 = jA != null ? jA.field_wwUserVid : 0;
                    com.tencent.mm.plugin.report.service.g.pWK.h(12648, a.this.hqP, a.this.kMt, Integer.valueOf(intExtra), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(jC), Integer.valueOf(i3), Long.valueOf(j), Long.valueOf(j2));
                    x.d("MicroMsg.BizChatConversationFmUI", "bizchat report belong:%s,brandUserName:%s,fromScene:%s,itemCount:%s,fatherUin:%d,childUin:%d,userUin:%d,wwCorpId:%l,wwUserVidL%l", a.this.hqP, a.this.kMt, Integer.valueOf(intExtra), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(jC), Integer.valueOf(i3), Long.valueOf(j), Long.valueOf(j2));
                    return false;
                }
            });
            Intent intent = thisActivity().getIntent();
            if (t.a(intent, "biz_chat_need_to_jump_to_chatting_ui", false)) {
                long longExtra = intent.getLongExtra("biz_chat_chat_id", -1);
                if (longExtra != -1) {
                    fW(longExtra);
                }
            }
        }

        protected final int getLayoutId() {
            return R.i.dgB;
        }

        public final String getUserName() {
            if (bi.oN(this.hqP)) {
                return this.kMt;
            }
            return this.hqP;
        }

        public final void onDestroy() {
            x.i("MicroMsg.BizChatConversationFmUI", "[unRegitListener]");
            y.Mo().a(this.ywn);
            y.Mn().a(this.ywo);
            y.Ms().a(this.ywp);
            if (as.Hp()) {
                as.Hm();
                c.Fk().b(this);
            }
            this.ywk.aUU();
            b bVar = this.ywk;
            if (bVar.yvZ != null) {
                bVar.yvZ.clear();
                bVar.yvZ = null;
            }
            super.onDestroy();
        }

        public final void onResume() {
            super.onResume();
            as.Hm();
            ag Xv = c.Ff().Xv(this.kMt);
            if (Xv == null || !com.tencent.mm.k.a.ga(Xv.field_type)) {
                finish();
                return;
            }
            com.tencent.mm.af.d jV = com.tencent.mm.af.f.jV(this.kMt);
            if (jV == null || jV.field_enterpriseFather == null || !s.gH(jV.field_enterpriseFather)) {
                finish();
                return;
            }
            if (Xv.AP()) {
                setTitleMuteIconVisibility(0);
            } else {
                setTitleMuteIconVisibility(8);
            }
            this.isCurrentActivity = true;
            this.ywk.a(null, null);
            as.getNotification().eq(this.kMt);
        }

        public final void onPause() {
            x.i("MicroMsg.BizChatConversationFmUI", "on pause");
            as.Hm();
            c.Fk().XH(this.kMt);
            com.tencent.mm.af.a.b Mo = y.Mo();
            String str = this.kMt;
            if (bi.oN(str)) {
                x.e("MicroMsg.BizConversationStorage", "brandUserName is null");
            } else {
                boolean fD = Mo.gLA.fD("BizChatConversation", "update BizChatConversation set newUnReadCount = 0 where newUnReadCount != 0 and brandUserName = '" + str + "'");
                x.d("MicroMsg.BizConversationStorage", "resetNewUnreadCount :%s,sql:%s", Boolean.valueOf(fD), str);
            }
            if (this.ywk != null) {
                this.ywk.onPause();
            }
            this.isCurrentActivity = false;
            as.getNotification().eq("");
            super.onPause();
        }

        public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
            AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
            com.tencent.mm.af.a.a aVar = (com.tencent.mm.af.a.a) this.ywk.getItem(adapterContextMenuInfo.position);
            this.kMn = aVar.field_bizChatId;
            if (aVar.field_unReadCount <= 0) {
                contextMenu.add(adapterContextMenuInfo.position, 1, 0, R.l.euy);
            } else {
                contextMenu.add(adapterContextMenuInfo.position, 2, 0, R.l.euw);
            }
            y.Mo();
            if (com.tencent.mm.af.a.b.c(aVar)) {
                contextMenu.add(adapterContextMenuInfo.position, 3, 1, R.l.euz);
            } else {
                contextMenu.add(adapterContextMenuInfo.position, 3, 1, R.l.eux);
            }
            contextMenu.add(adapterContextMenuInfo.position, 0, 2, R.l.euC);
        }

        public final void onActivityResult(int i, int i2, Intent intent) {
            super.onActivityResult(i, i2, intent);
            if (i2 == -1) {
                switch (i) {
                    case 1:
                        boolean z;
                        Bundle bundleExtra = intent.getBundleExtra("result_data");
                        if (bundleExtra != null) {
                            String str;
                            x.i("MicroMsg.BizChatConversationFmUI", "bundle != null");
                            String string = bundleExtra.getString("enterprise_members");
                            ws wsVar = new ws();
                            com.tencent.mm.af.a.c cVar = new com.tencent.mm.af.a.c();
                            if (this.ywl != null) {
                                str = this.ywl.field_addMemberUrl;
                            } else {
                                str = null;
                            }
                            cVar.field_addMemberUrl = str;
                            cVar.field_brandUserName = this.kMt;
                            if (!com.tencent.mm.af.a.e.a(cVar, string, null, wsVar)) {
                                z = false;
                            } else if (cVar.field_bizChatLocalId != -1) {
                                fW(cVar.field_bizChatLocalId);
                                z = true;
                            } else {
                                y.Mr();
                                final com.tencent.mm.af.a.n a = com.tencent.mm.af.a.h.a(this.kMt, wsVar, (n) this);
                                Context thisActivity = thisActivity();
                                getString(R.l.dGZ);
                                this.tipDialog = h.a(thisActivity, getString(R.l.dHn), true, new OnCancelListener() {
                                    public final void onCancel(DialogInterface dialogInterface) {
                                        y.Mr();
                                        com.tencent.mm.af.a.h.f(a);
                                    }
                                });
                                z = true;
                            }
                        } else {
                            z = false;
                        }
                        if (!z) {
                            Toast.makeText(thisActivity(), getString(R.l.eFk), 0).show();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }

        public final void a(int i, k kVar) {
            if (this.tipDialog != null) {
                this.tipDialog.dismiss();
                this.tipDialog = null;
            }
            if (kVar.getType() == 1355) {
                com.tencent.mm.af.a.c ko = y.Mn().ko(((com.tencent.mm.af.a.n) kVar).MF().wfx.wnN.vUb);
                if (ko == null) {
                    Toast.makeText(ad.getContext(), getString(R.l.eFk), 0).show();
                } else {
                    fW(ko.field_bizChatLocalId);
                }
            }
        }

        private void cru() {
            String crw = crw();
            this.ywm = g.bl(getContext(), crw);
            if (this.ywm == 2 && this.ywj == null) {
                this.ywj = (LinearLayout) findViewById(R.h.bottom_bar);
                LayoutParams layoutParams = this.ywj.getLayoutParams();
                layoutParams.height = com.tencent.mm.bu.a.aa(getContext(), R.f.buI);
                this.ywj.setLayoutParams(layoutParams);
                View inflate = v.fw(getContext()).inflate(R.i.dgC, this.ywj, false);
                float ev = com.tencent.mm.bu.a.ev(getContext());
                ImageView imageView = (ImageView) inflate.findViewById(R.h.coQ);
                int i = imageView.getLayoutParams().height;
                imageView.getLayoutParams().height = (int) (((float) i) * ev);
                imageView.getLayoutParams().width = (int) (ev * ((float) i));
                imageView.requestLayout();
                ((TextView) inflate.findViewById(R.h.cSB)).setText(R.l.ecp);
                this.ywj.addView(inflate);
                inflate.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        g.o(a.this.getContext(), a.this.crw(), 4);
                    }
                });
                g.n(getContext(), this.kMt, 4);
                g.bm(getContext(), crw);
            }
            if (this.ywj == null) {
                return;
            }
            if (this.ywm == 2) {
                this.ywj.setVisibility(0);
            } else {
                this.ywj.setVisibility(8);
            }
        }

        private void crv() {
            boolean z = false;
            String cb = y.Mp().cb(this.kMt);
            this.ywl = y.Mp().ca(cb);
            String str = "MicroMsg.BizChatConversationFmUI";
            String str2 = "updateBizChatMyUserInfo: %s:%s,myBizChatUserInfo is null:%s";
            Object[] objArr = new Object[3];
            objArr[0] = this.kMt;
            objArr[1] = cb;
            if (this.ywl == null) {
                z = true;
            }
            objArr[2] = Boolean.valueOf(z);
            x.i(str, str2, objArr);
            if (bi.oN(cb) || this.ywl == null || this.ywl.MA() || bi.oN(this.ywl.field_addMemberUrl)) {
                y.Mr();
                com.tencent.mm.af.a.h.a(this.kMt, (n) this);
                Context thisActivity = thisActivity();
                getString(R.l.dGZ);
                this.tipDialog = h.a(thisActivity, getString(R.l.dHn), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        a.this.finish();
                    }
                });
            }
        }

        private String crw() {
            if (bi.oN(this.hqP)) {
                this.hqP = y.Ml().jN(this.kMt).Ls();
            }
            return this.hqP;
        }

        private void fW(long j) {
            Bundle bundle = new Bundle();
            bundle.putLong("key_biz_chat_id", j);
            bundle.putBoolean("finish_direct", false);
            bundle.putBoolean("key_need_send_video", false);
            bundle.putBoolean("key_is_biz_chat", true);
            this.ui.startChatting(this.kMt, bundle, true);
        }

        public final void a(int i, m mVar, Object obj) {
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.contentView = v.fw(this).inflate(R.i.dbx, null);
        setContentView(this.contentView);
        this.conversationFm = new a();
        getSupportFragmentManager().aT().a(R.h.cwx, this.conversationFm).commit();
        com.tencent.mm.pluginsdk.e.a(this, this.contentView);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        com.tencent.mm.pluginsdk.e.a(this, this.contentView);
    }
}
