package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.VoiceSearchLayout;
import com.tencent.mm.pluginsdk.ui.d;
import com.tencent.mm.protocal.c.bfp;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.voicesearch.VoiceSearchResultUI;
import com.tencent.mm.ui.voicesearch.b;
import com.tencent.mm.ui.widget.i;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.r;
import com.tencent.mm.y.s;

public class ChatroomContactUI extends MMActivity implements e, a {
    private int kMb = 0;
    private int kMc = 0;
    private i kMf;
    private d lfI = new d(new OnScrollListener() {
        public final void onScrollStateChanged(AbsListView absListView, int i) {
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    });
    private p.d mbC = new p.d() {
        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            switch (menuItem.getItemId()) {
                case 1:
                    ChatroomContactUI.aag(ChatroomContactUI.this.yZe);
                    return;
                default:
                    return;
            }
        }
    };
    private TextView mxu;
    private ListView nVe;
    private b yZc;
    private String yZe;
    private ContactCountView yZp;
    private VoiceSearchLayout zal;
    private com.tencent.mm.pluginsdk.ui.tools.p zam;
    private d zan;

    static /* synthetic */ void a(ChatroomContactUI chatroomContactUI, String str) {
        if (str == null || str.length() <= 0) {
            if (chatroomContactUI.yZp != null) {
                chatroomContactUI.yZp.setVisible(true);
            }
        } else if (chatroomContactUI.yZp != null) {
            chatroomContactUI.yZp.setVisible(false);
        }
        if (str == null || str.length() == 0) {
            chatroomContactUI.nVe.setAdapter(chatroomContactUI.zan);
            chatroomContactUI.nVe.setBackgroundColor(chatroomContactUI.getResources().getColor(R.e.btQ));
            chatroomContactUI.zan.notifyDataSetChanged();
            chatroomContactUI.yZc.nG(false);
            chatroomContactUI.zan.XH();
            return;
        }
        chatroomContactUI.nVe.setAdapter(chatroomContactUI.yZc);
        chatroomContactUI.nVe.setBackgroundColor(chatroomContactUI.getResources().getColor(R.e.white));
        chatroomContactUI.yZc.nG(true);
        b bVar = chatroomContactUI.yZc;
        String aaR = b.aaR(str);
        if (!(aaR == null || aaR.equals(bVar.zzC))) {
            bVar.ab(new Runnable() {
                public final void run() {
                    b.this.zzF = true;
                    b.this.hfI.clear();
                }
            });
        }
        bVar.zzC = aaR;
        bVar.yvM = null;
        if (bVar.zzC == null) {
            bVar.zzC = "";
        }
        bVar.aUU();
        bVar.XH();
        chatroomContactUI.yZc.notifyDataSetChanged();
    }

    static /* synthetic */ void aag(String str) {
        as.Hm();
        x Xv = c.Ff().Xv(str);
        Xv.Ao();
        s.t(Xv);
        if (s.eX(str)) {
            as.Hm();
            c.Ff().XB(str);
            as.Hm();
            c.Fo().hM(str);
            return;
        }
        as.Hm();
        c.Ff().a(str, Xv);
    }

    static /* synthetic */ void b(ChatroomContactUI chatroomContactUI, String str) {
        if (str != null && str.length() > 0) {
            if (s.hg(str)) {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ChatroomContactUI", "error, 4.5 do not contain this contact %s", str);
                return;
            }
            Intent intent = new Intent(chatroomContactUI.mController.xRr, ChattingUI.class);
            intent.addFlags(67108864);
            intent.putExtra("Chat_User", str);
            intent.putExtra("Chat_Mode", 1);
            chatroomContactUI.mController.xRr.startActivity(intent);
            if (str != null && str.length() > 0) {
                e.a(intent, str);
                chatroomContactUI.startActivity(intent);
            }
        }
    }

    protected final int getLayoutId() {
        return R.i.dcS;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(R.l.dCY);
        initView();
        as.CN().a(138, (e) this);
        as.Hm();
        c.Ff().a(this.zan);
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
        as.Hm();
        if (c.Ff().Xv(this.yZe) == null) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ChatroomContactUI", "onCreateContextMenu, contact is null, username = " + this.yZe);
        } else if (s.gF(this.yZe)) {
            contextMenu.setHeaderTitle(com.tencent.mm.pluginsdk.ui.d.i.a(view.getContext(), r.gw(this.yZe)));
            contextMenu.add(adapterContextMenuInfo.position, 1, 0, R.l.dDc);
        }
    }

    public final void initView() {
        ((TextView) findViewById(R.h.cez)).setVisibility(8);
        this.nVe = (ListView) findViewById(R.h.bJf);
        this.nVe.setAdapter(null);
        this.mxu = (TextView) findViewById(R.h.cez);
        this.mxu.setText(R.l.dDe);
        String str = "@all.chatroom.contact";
        this.zan = new d(this, str);
        this.zan.mb(true);
        this.yZc = new b(this.mController.xRr, 1);
        this.yZc.yYA = str;
        this.zam = new com.tencent.mm.pluginsdk.ui.tools.p((byte) 0);
        this.zam.a(new com.tencent.mm.pluginsdk.ui.tools.p.a() {
            public final void XC() {
            }

            public final void XD() {
            }

            public final void pd(String str) {
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChatroomContactUI", "onSearchBarChange %s", str);
                ChatroomContactUI.a(ChatroomContactUI.this, t.oL(str));
            }

            public final void XA() {
            }

            public final void XB() {
            }

            public final void asZ() {
                com.tencent.mm.sdk.platformtools.x.v("MicroMsg.ChatroomContactUI", "onVoiceSearchStart");
                ChatroomContactUI.this.aWY();
            }

            public final void ata() {
            }

            public final void a(boolean z, String[] strArr, long j, int i) {
                com.tencent.mm.sdk.platformtools.x.v("MicroMsg.ChatroomContactUI", "onVoiceReturn");
                Intent intent;
                if (z) {
                    intent = new Intent(ChatroomContactUI.this.mController.xRr, VoiceSearchResultUI.class);
                    intent.putExtra("VoiceSearchResultUI_Resultlist", strArr);
                    intent.putExtra("VoiceSearchResultUI_VoiceId", j);
                    intent.putExtra("VoiceSearchResultUI_ShowType", i);
                    ChatroomContactUI.this.mController.xRr.startActivity(intent);
                    return;
                }
                intent = new Intent(ChatroomContactUI.this.mController.xRr, VoiceSearchResultUI.class);
                intent.putExtra("VoiceSearchResultUI_Resultlist", new String[0]);
                intent.putExtra("VoiceSearchResultUI_Error", ChatroomContactUI.this.mController.xRr.getString(R.l.eiR));
                intent.putExtra("VoiceSearchResultUI_VoiceId", j);
                intent.putExtra("VoiceSearchResultUI_ShowType", i);
                ChatroomContactUI.this.mController.xRr.startActivity(intent);
            }

            public final boolean pc(String str) {
                return false;
            }
        });
        a(this.zam);
        this.zan.a(new MMSlideDelView.c() {
            public final int ci(View view) {
                return ChatroomContactUI.this.nVe.getPositionForView(view);
            }
        });
        this.zan.a(new f() {
            public final void t(View view, int i) {
                ChatroomContactUI.this.nVe.performItemClick(view, i, 0);
            }
        });
        this.zan.a(new MMSlideDelView.e() {
            public final void bp(Object obj) {
                if (obj == null) {
                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ChatroomContactUI", "onItemDel object null");
                    return;
                }
                ChatroomContactUI.aag(obj.toString());
                ChatroomContactUI.this.aVL();
            }
        });
        this.nVe.setOnScrollListener(this.lfI);
        this.zan.vuA = this.lfI;
        this.kMf = new i(this.mController.xRr);
        this.nVe.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChatroomContactUI", "onItemClick " + i + (ChatroomContactUI.this.yZc == null ? ChatroomContactUI.this.yZc : Boolean.valueOf(ChatroomContactUI.this.yZc.zzG)));
                if (i >= ChatroomContactUI.this.nVe.getHeaderViewsCount()) {
                    int headerViewsCount = i - ChatroomContactUI.this.nVe.getHeaderViewsCount();
                    if (ChatroomContactUI.this.yZc == null || !ChatroomContactUI.this.yZc.zzG) {
                        ChatroomContactUI.b(ChatroomContactUI.this, ((x) ChatroomContactUI.this.zan.getItem(headerViewsCount)).field_username);
                        return;
                    }
                    boolean rq = ChatroomContactUI.this.yZc.rq(headerViewsCount);
                    boolean Hj = ChatroomContactUI.this.yZc.Hj(headerViewsCount);
                    com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChatroomContactUI", "onItemClick " + Hj);
                    Intent intent;
                    if (Hj) {
                        ChatroomContactUI.this.yZc.aaQ(ChatroomContactUI.this.zam == null ? "" : ChatroomContactUI.this.zam.bVF());
                    } else if (rq) {
                        bfp Hi = ChatroomContactUI.this.yZc.Hi(headerViewsCount);
                        String str = Hi.wfM.wRo;
                        as.Hm();
                        ag Xv = c.Ff().Xv(str);
                        if (com.tencent.mm.k.a.ga(Xv.field_type)) {
                            intent = new Intent();
                            intent.putExtra("Contact_User", str);
                            intent.putExtra("Contact_Scene", 3);
                            if (str != null && str.length() > 0) {
                                if (Xv.ciN()) {
                                    g.pWK.k(10298, str + ",3");
                                }
                                e.a(intent, str);
                                com.tencent.mm.bl.d.b(ChatroomContactUI.this, "profile", ".ui.ContactInfoUI", intent);
                                return;
                            }
                            return;
                        }
                        Intent intent2 = new Intent();
                        intent2.putExtra("Contact_User", Hi.wfM.wRo);
                        intent2.putExtra("Contact_Alias", Hi.hxj);
                        intent2.putExtra("Contact_Nick", Hi.wzM.wRo);
                        intent2.putExtra("Contact_Signature", Hi.hxh);
                        intent2.putExtra("Contact_RegionCode", RegionCodeDecoder.ai(Hi.hxn, Hi.hxf, Hi.hxg));
                        intent2.putExtra("Contact_Sex", Hi.hxe);
                        intent2.putExtra("Contact_VUser_Info", Hi.wCr);
                        intent2.putExtra("Contact_VUser_Info_Flag", Hi.wCq);
                        intent2.putExtra("Contact_KWeibo_flag", Hi.wCu);
                        intent2.putExtra("Contact_KWeibo", Hi.wCs);
                        intent2.putExtra("Contact_KWeiboNick", Hi.wCt);
                        intent2.putExtra("Contact_KSnsIFlag", Hi.wCw.hxp);
                        intent2.putExtra("Contact_KSnsBgId", Hi.wCw.hxr);
                        intent2.putExtra("Contact_KSnsBgUrl", Hi.wCw.hxq);
                        if (Hi.wCx != null) {
                            try {
                                intent2.putExtra("Contact_customInfo", Hi.wCx.toByteArray());
                            } catch (Throwable e) {
                                com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.ChatroomContactUI", e, "", new Object[0]);
                            }
                        }
                        if ((Hi.wCq & 8) > 0) {
                            g.pWK.k(10298, str + ",3");
                        }
                        com.tencent.mm.bl.d.b(ChatroomContactUI.this, "profile", ".ui.ContactInfoUI", intent2);
                    } else {
                        ag oz = ChatroomContactUI.this.yZc.oz(headerViewsCount);
                        if (oz == null) {
                            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ChatroomContactUI", "on Contact ListView ItemClick, the item contact shoud not be null. count:%d, pos:%d ", Integer.valueOf(ChatroomContactUI.this.yZc.getCount()), Integer.valueOf(headerViewsCount));
                            return;
                        }
                        x.m(ChatroomContactUI.this.zam.bVF(), 9, 3, headerViewsCount + 1);
                        String str2 = oz.field_username;
                        intent = new Intent(ChatroomContactUI.this.mController.xRr, ChattingUI.class);
                        intent.addFlags(67108864);
                        intent.putExtra("Chat_User", str2);
                        intent.putExtra("Chat_Mode", 1);
                        ChatroomContactUI.this.mController.xRr.startActivity(intent);
                    }
                }
            }
        });
        this.nVe.setOnItemLongClickListener(new OnItemLongClickListener() {
            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChatroomContactUI", "onItemLongClick, targetview is SearchBar::ListView, pos = " + i);
                if (i < ChatroomContactUI.this.nVe.getHeaderViewsCount()) {
                    com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ChatroomContactUI", "on item long click, but match header view");
                    return true;
                } else if (ChatroomContactUI.this.yZc != null && ChatroomContactUI.this.yZc.zzG) {
                    return true;
                } else {
                    String str = ((x) ChatroomContactUI.this.zan.getItem(i - ChatroomContactUI.this.nVe.getHeaderViewsCount())).field_username;
                    if (s.hg(str) || s.hh(str)) {
                        return true;
                    }
                    ChatroomContactUI.this.yZe = str;
                    ChatroomContactUI.this.kMf.a(view, i, j, ChatroomContactUI.this, ChatroomContactUI.this.mbC, ChatroomContactUI.this.kMb, ChatroomContactUI.this.kMc);
                    return true;
                }
            }
        });
        this.nVe.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        ChatroomContactUI.this.aWY();
                        ChatroomContactUI.this.kMb = (int) motionEvent.getRawX();
                        ChatroomContactUI.this.kMc = (int) motionEvent.getRawY();
                        break;
                }
                if (ChatroomContactUI.this.zan != null) {
                    d f = ChatroomContactUI.this.zan;
                    if (f.hxF != null) {
                        f.hxF.onTouchEvent(motionEvent);
                    }
                }
                if (ChatroomContactUI.this.yZc != null) {
                    b d = ChatroomContactUI.this.yZc;
                    if (d.hxF != null) {
                        d.hxF.onTouchEvent(motionEvent);
                    }
                }
                return false;
            }
        });
        ListView listView = this.nVe;
        View contactCountView = new ContactCountView(this);
        this.yZp = contactCountView;
        listView.addFooterView(contactCountView, null, false);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                ChatroomContactUI.this.finish();
                return false;
            }
        });
        addIconOptionMenu(0, R.l.dCx, R.k.duZ, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                Intent intent = new Intent(ChatroomContactUI.this, SelectContactUI.class);
                intent.putExtra("titile", ChatroomContactUI.this.getString(R.l.dDy));
                intent.putExtra("list_type", 0);
                intent.putExtra("list_attr", s.p(s.zcA, 256, WXMediaMessage.TITLE_LENGTH_LIMIT));
                ChatroomContactUI.this.mController.xRr.startActivity(intent);
                return false;
            }
        });
        AnonymousClass4 anonymousClass4 = new OnClickListener() {
            public final void onClick(View view) {
                BackwardSupportUtil.c.a(ChatroomContactUI.this.nVe);
            }
        };
        this.nVe.setAdapter(this.zan);
        this.yZc.nG(false);
        this.nVe.setVisibility(0);
        this.zal = new VoiceSearchLayout(this);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(14);
        this.zal.setLayoutParams(layoutParams);
        this.zal.Cn(BackwardSupportUtil.b.b((Context) this, 100.0f));
        this.zal.setVisibility(8);
        ((ViewGroup) findViewById(R.h.cXn)).addView(this.zal);
        if (this.zal != null) {
            this.zal.vtj = new VoiceSearchLayout.b() {
                public final void lg(boolean z) {
                    com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChatroomContactUI", "visible " + z);
                    if (z) {
                        int firstVisiblePosition = ChatroomContactUI.this.nVe.getFirstVisiblePosition();
                        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChatroomContactUI", "getFirstVisiblePosition  " + firstVisiblePosition);
                        if (firstVisiblePosition > 0) {
                            ChatroomContactUI.this.nVe.post(new Runnable() {
                                public final void run() {
                                    ChatroomContactUI.this.nVe.setSelection(0);
                                }
                            });
                        }
                    }
                }
            };
        }
        if (this.zan.getCount() == 0) {
            this.mxu.setSingleLine(false);
            this.mxu.setPadding(40, 0, 40, 0);
            this.mxu.setVisibility(0);
        }
    }

    protected void onResume() {
        super.onResume();
        if (this.yZp != null) {
            this.yZp.zaq = 2;
            this.yZp.cwC();
        }
        as.Hm();
        c.Fo().c(this);
        if (!(this.zam == null || this.zal == null)) {
            com.tencent.mm.bl.d.cdJ();
            if (com.tencent.mm.aq.b.PZ() || !w.cfV().equals("zh_CN")) {
                this.zam.vFI = false;
            } else {
                this.zam.vFI = true;
                this.zam.o(this.zal);
            }
        }
        if (this.yZc != null) {
            this.yZc.onResume();
        }
    }

    protected void onPause() {
        super.onPause();
        as.Hm();
        c.Fo().j(this);
        if (this.zam != null) {
            com.tencent.mm.pluginsdk.ui.tools.p pVar = this.zam;
            pVar.cyP();
            pVar.cancel();
        }
        if (this.yZc != null) {
            this.yZc.onPause();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        as.CN().b(138, (e) this);
        as.Hm();
        c.Ff().b(this.zan);
        d dVar = this.zan;
        if (dVar.hxF != null) {
            dVar.hxF.detach();
            dVar.hxF = null;
        }
        this.zan.aUU();
        this.zan.xQN = null;
        this.yZc.detach();
        this.yZc.aUU();
    }

    private void aVL() {
        if (this.zan != null) {
            this.zan.a(null, null);
        }
        if (this.yZc != null) {
            this.yZc.a(null, null);
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (t.bF(this) && !com.tencent.mm.ui.t.a.a(this, i, i2, str, 4) && i == 0 && i2 == 0) {
            switch (kVar.getType()) {
                case 138:
                    aVL();
                    return;
                default:
                    return;
            }
        }
    }

    public final void a(String str, l lVar) {
        if (this.yZp != null) {
            this.yZp.zaq = 2;
            this.yZp.cwC();
        }
    }
}
