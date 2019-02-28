package com.tencent.mm.ui.bizchat;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ad.k;
import com.tencent.mm.af.a.b.a;
import com.tencent.mm.af.a.b.a.b;
import com.tencent.mm.af.a.c;
import com.tencent.mm.af.a.h;
import com.tencent.mm.af.a.s;
import com.tencent.mm.af.a.w;
import com.tencent.mm.af.n;
import com.tencent.mm.af.y;
import com.tencent.mm.ap.o;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.c.hp;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.e;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.y.as;

public class BizChatFavUI extends MMActivity implements n {
    private TextView emptyTipTv;
    private boolean isCurrentActivity;
    private r jQQ;
    private ListView kHA;
    private d kHD;
    private long kMn;
    private String kMt;
    private a ywn;
    private com.tencent.mm.af.a.d.a ywo;
    private c ywt;

    static /* synthetic */ void a(BizChatFavUI bizChatFavUI, long j) {
        x.i("MicroMsg.BizChatFavUI", "deleteFromFav");
        c ag = y.Mn().ag(j);
        ag.field_bitFlag &= -9;
        x.i("MicroMsg.BizChatFavUI", "deleteFromFav:bitFlag %s", Integer.valueOf(ag.field_bitFlag));
        hp hpVar = new hp();
        hpVar.vUb = ag.field_bizChatServId;
        hpVar.vUd = ag.field_bitFlag;
        y.Mr();
        final w a = h.a(ag.field_brandUserName, hpVar, (n) bizChatFavUI);
        bizChatFavUI.jQQ = com.tencent.mm.ui.base.h.a((Context) bizChatFavUI, "", false, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                y.Mr();
                h.f(a);
            }
        });
    }

    static /* synthetic */ void b(BizChatFavUI bizChatFavUI, long j) {
        Intent intent = new Intent(bizChatFavUI, ChattingUI.class);
        intent.addFlags(67108864);
        intent.putExtra("Chat_User", bizChatFavUI.kMt);
        intent.putExtra("key_biz_chat_id", j);
        intent.putExtra("finish_direct", true);
        intent.putExtra("key_need_send_video", false);
        intent.putExtra("key_is_biz_chat", true);
        bizChatFavUI.startActivity(intent);
        ah.h(new Runnable() {
            public final void run() {
                BizChatFavUI.this.finish();
            }
        }, 500);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kMt = getIntent().getStringExtra("Contact_User");
        x.i("MicroMsg.BizChatFavUI", "[regitListener]");
        this.ywn = new a() {
            public final void a(b bVar) {
                if (bVar != null && bVar.hsq != null && BizChatFavUI.this.kMt.equals(bVar.hsq.field_brandUserName)) {
                    x.i("MicroMsg.BizChatFavUI", "bizChatExtension bizChatConv change");
                    if (BizChatFavUI.this.isCurrentActivity) {
                        BizChatFavUI.this.ywt.XH();
                    }
                }
            }
        };
        this.ywo = new com.tencent.mm.af.a.d.a() {
            public final void a(com.tencent.mm.af.a.d.a.b bVar) {
                if (bVar != null && bVar.hsA != null) {
                    x.i("MicroMsg.BizChatFavUI", "bizChatExtension bizChat change");
                    c ag = y.Mn().ag(bVar.hsp);
                    x.d("MicroMsg.BizChatFavUI", "needToUpdate:%s", Boolean.valueOf(ag.field_needToUpdate));
                    if (BizChatFavUI.this.isCurrentActivity) {
                        BizChatFavUI.this.ywt.XH();
                    }
                }
            }
        };
        y.Mo().a(this.ywn, getMainLooper());
        y.Mn().a(this.ywo, getMainLooper());
        initView();
        y.Mr();
        g.Dp().gRu.a(new s(this.kMt), 0);
    }

    protected final int getLayoutId() {
        return R.i.dgy;
    }

    public void onDestroy() {
        x.i("MicroMsg.BizChatFavUI", "[unRegitListener]");
        y.Mo().a(this.ywn);
        y.Mn().a(this.ywo);
        this.ywt.aUU();
        super.onDestroy();
    }

    public void onResume() {
        super.onResume();
        as.Hm();
        ag Xv = com.tencent.mm.y.c.Ff().Xv(this.kMt);
        if (Xv == null || !com.tencent.mm.k.a.ga(Xv.field_type)) {
            finish();
            return;
        }
        setTitleMuteIconVisibility(8);
        this.isCurrentActivity = true;
        this.ywt.a(null, null);
        as.getNotification().eq(this.kMt);
    }

    public void onPause() {
        this.ywt.onPause();
        this.isCurrentActivity = false;
        as.getNotification().eq("");
        super.onPause();
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
        this.kMn = ((c) this.ywt.getItem(adapterContextMenuInfo.position)).field_bizChatLocalId;
        contextMenu.add(adapterContextMenuInfo.position, 0, 1, R.l.dMC);
    }

    public final void a(int i, k kVar) {
        if (this.jQQ != null) {
            this.jQQ.dismiss();
        }
    }

    protected final void initView() {
        this.kHA = (ListView) findViewById(R.h.cSC);
        this.emptyTipTv = (TextView) findViewById(R.h.ceo);
        this.emptyTipTv.setText(R.l.dMB);
        this.kHA.setOnScrollListener(new OnScrollListener() {
            public final void onScrollStateChanged(AbsListView absListView, int i) {
                o.PG().bp(i);
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        this.ywt = new c(this, new com.tencent.mm.ui.o.a() {
            public final void XE() {
                BizChatFavUI.this.setMMTitle(com.tencent.mm.y.r.gw(BizChatFavUI.this.kMt));
                if (BizChatFavUI.this.ywt.getCount() <= 0) {
                    BizChatFavUI.this.emptyTipTv.setVisibility(0);
                    BizChatFavUI.this.kHA.setVisibility(8);
                    return;
                }
                BizChatFavUI.this.emptyTipTv.setVisibility(8);
                BizChatFavUI.this.kHA.setVisibility(0);
            }

            public final void XF() {
            }
        }, this.kMt);
        this.ywt.a(new MMSlideDelView.c() {
            public final int ci(View view) {
                return BizChatFavUI.this.kHA.getPositionForView(view);
            }
        });
        this.ywt.a(new f() {
            public final void t(View view, int i) {
                BizChatFavUI.this.kHA.performItemClick(view, i, 0);
            }
        });
        this.ywt.a(new e() {
            public final void bp(Object obj) {
                if (obj == null) {
                    x.e("MicroMsg.BizChatFavUI", "onItemDel object null");
                }
            }
        });
        this.kHA.setAdapter(this.ywt);
        this.kHD = new d() {
            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                switch (menuItem.getItemId()) {
                    case 0:
                        BizChatFavUI.a(BizChatFavUI.this, BizChatFavUI.this.kMn);
                        return;
                    default:
                        return;
                }
            }
        };
        final l lVar = new l(this);
        this.kHA.setOnItemLongClickListener(new OnItemLongClickListener() {
            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i < BizChatFavUI.this.kHA.getHeaderViewsCount()) {
                    x.w("MicroMsg.BizChatFavUI", "on header view long click, ignore");
                } else {
                    lVar.a(view, i, j, BizChatFavUI.this, BizChatFavUI.this.kHD);
                }
                return true;
            }
        });
        this.kHA.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                BizChatFavUI.b(BizChatFavUI.this, ((c) BizChatFavUI.this.ywt.getItem(i)).field_bizChatLocalId);
            }
        });
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                BizChatFavUI.this.finish();
                return true;
            }
        });
    }
}
