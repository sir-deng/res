package com.tencent.mm.plugin.bottle.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ax.f;
import com.tencent.mm.f.b.cg;
import com.tencent.mm.plugin.bottle.a;
import com.tencent.mm.plugin.bottle.a.b;
import com.tencent.mm.plugin.bottle.a.i;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ae;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.e;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.o;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bb;
import com.tencent.mm.y.c;
import com.tencent.mm.y.k;
import com.tencent.mm.y.q;
import com.tencent.tmassistantsdk.downloadservice.Downloads;

public class BottleConversationUI extends MMActivity {
    private TextView emptyTipTv;
    private boolean isDeleteCancel = false;
    private ListView kHA;
    private a kHB;
    private String kHC;
    private d kHD = new d() {
        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            h.a((Context) BottleConversationUI.this, true, BottleConversationUI.this.getString(R.l.dMT), "", BottleConversationUI.this.getString(R.l.dMU), BottleConversationUI.this.getString(R.l.dEy), new OnClickListener(BottleConversationUI.this.talker) {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    as.Hm();
                    cg Fc = c.Fh().Fc(r9);
                    as.Hm();
                    c.Fe().b(new com.tencent.mm.ax.d(r9, Fc.field_msgSvrId));
                    as.Hm();
                    c.Fe().b(new f(r9, 0));
                    a.ihO.un();
                    BottleConversationUI.this.isDeleteCancel = false;
                    BottleConversationUI bottleConversationUI = BottleConversationUI.this;
                    Context context = BottleConversationUI.this;
                    BottleConversationUI.this.getString(R.l.dGZ);
                    bottleConversationUI.tipDialog = h.a(context, BottleConversationUI.this.getString(R.l.dHn), true, new OnCancelListener() {
                        public final void onCancel(DialogInterface dialogInterface) {
                            BottleConversationUI.this.isDeleteCancel = true;
                        }
                    });
                    bb.a(r9, new bb.a() {
                        public final boolean HH() {
                            return BottleConversationUI.this.isDeleteCancel;
                        }

                        public final void HG() {
                            if (BottleConversationUI.this.tipDialog != null) {
                                BottleConversationUI.this.tipDialog.dismiss();
                                BottleConversationUI.this.tipDialog = null;
                            }
                        }
                    });
                    as.Hm();
                    c.Fk().XE(r9);
                    b asn = i.asn();
                    String wt = com.tencent.mm.plugin.bottle.a.c.wt(r9);
                    asn.hiZ.delete("bottleinfo1", "bottleid= ?", new String[]{wt});
                    a.ihO.un();
                }
            }, null);
        }
    };
    private String talker;
    private r tipDialog = null;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    protected final int getLayoutId() {
        return R.i.dtj;
    }

    public void onDestroy() {
        this.kHB.aUU();
        super.onDestroy();
    }

    public void onResume() {
        super.onResume();
        as.Hm();
        c.Ff().a(this.kHB);
        as.Hm();
        c.Fk().a(this.kHB);
        this.kHB.a(null, null);
    }

    public void onPause() {
        as.Hm();
        c.Ff().b(this.kHB);
        as.Hm();
        c.Fk().b(this.kHB);
        as.Hm();
        cg sM = c.Fh().sM(8);
        if (sM != null && sM.field_msgId > 0) {
            x.d("MicroMsg.Bottle.BottleConversationUI", "resetUnread: lastReadTime = " + sM.field_createTime);
            as.Hm();
            c.Db().set(12306, Long.valueOf(sM.field_createTime));
        }
        as.Hm();
        ae XF = c.Fk().XF("floatbottle");
        if (XF == null || bi.oM(XF.field_username).length() <= 0) {
            x.e("MicroMsg.Bottle.BottleConversationUI", "resetUnread: can not find bottle");
        } else {
            XF.eP(0);
            as.Hm();
            if (c.Fk().a(XF, XF.field_username) == -1) {
                x.e("MicroMsg.Bottle.BottleConversationUI", "reset bottle unread failed");
            }
        }
        this.kHB.onPause();
        super.onPause();
    }

    protected final void initView() {
        int Gc = q.Gc() | Downloads.RECV_BUFFER_SIZE;
        int Gj = q.Gj() & -65;
        as.Hm();
        c.Db().set(7, Integer.valueOf(Gc));
        as.Hm();
        c.Db().set(34, Integer.valueOf(Gj));
        this.kHA = (ListView) findViewById(R.h.cSC);
        this.emptyTipTv = (TextView) findViewById(R.h.ceo);
        this.emptyTipTv.setText(R.l.dMV);
        this.kHB = new a(this, new o.a() {
            public final void XE() {
                BottleConversationUI bottleConversationUI = BottleConversationUI.this;
                String string = BottleConversationUI.this.getString(R.l.dMY);
                int FU = k.FU();
                if (FU <= 0) {
                    bottleConversationUI.setMMTitle(string);
                } else {
                    bottleConversationUI.setMMTitle(string + "(" + FU + ")");
                }
                if (BottleConversationUI.this.kHB.getCount() <= 0) {
                    BottleConversationUI.this.emptyTipTv.setVisibility(0);
                    BottleConversationUI.this.kHA.setVisibility(8);
                    return;
                }
                BottleConversationUI.this.emptyTipTv.setVisibility(8);
                BottleConversationUI.this.kHA.setVisibility(0);
            }

            public final void XF() {
            }
        });
        this.kHB.a(new MMSlideDelView.c() {
            public final int ci(View view) {
                return BottleConversationUI.this.kHA.getPositionForView(view);
            }
        });
        this.kHB.a(new MMSlideDelView.f() {
            public final void t(View view, int i) {
                BottleConversationUI.this.kHA.performItemClick(view, i, 0);
            }
        });
        this.kHB.a(new e() {
            public final void bp(Object obj) {
                if (obj == null) {
                    x.e("MicroMsg.Bottle.BottleConversationUI", "onItemDel object null");
                } else {
                    h.a((Context) BottleConversationUI.this, true, BottleConversationUI.this.getString(R.l.dMT), "", BottleConversationUI.this.getString(R.l.dMU), BottleConversationUI.this.getString(R.l.dEy), /* anonymous class already generated */, null);
                }
            }
        });
        this.kHA.setAdapter(this.kHB);
        final l lVar = new l(this);
        this.kHA.setOnItemLongClickListener(new OnItemLongClickListener() {
            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i < BottleConversationUI.this.kHA.getHeaderViewsCount()) {
                    x.w("MicroMsg.Bottle.BottleConversationUI", "on header view long click, ignore");
                } else {
                    lVar.a(view, i, j, BottleConversationUI.this, BottleConversationUI.this.kHD);
                }
                return true;
            }
        });
        this.kHA.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                ae aeVar = (ae) BottleConversationUI.this.kHB.getItem(i);
                Intent intent = new Intent();
                intent.addFlags(67108864);
                intent.putExtra("Chat_User", aeVar.field_username);
                intent.putExtra("finish_direct", true);
                intent.putExtra("key_need_send_video", false);
                a.ihN.e(intent, BottleConversationUI.this);
            }
        });
        a.ihO.un();
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                BottleConversationUI.this.finish();
                return true;
            }
        });
        String stringExtra = getIntent().getStringExtra("conversation_from");
        if (bi.oN(stringExtra) && bi.oN(this.kHC)) {
            addTextOptionMenu(0, getString(R.l.dXv), new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    Intent intent = new Intent();
                    intent.setClass(BottleConversationUI.this, BottleBeachUI.class);
                    BottleConversationUI.this.startActivity(intent);
                    BottleConversationUI.this.finish();
                    return true;
                }
            });
        } else if (!bi.oN(stringExtra)) {
            this.kHC = stringExtra;
        }
        AnonymousClass11 anonymousClass11 = new View.OnClickListener() {
            public final void onClick(View view) {
                BackwardSupportUtil.c.a(BottleConversationUI.this.kHA);
            }
        };
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
        this.talker = ((ae) this.kHB.getItem(adapterContextMenuInfo.position)).field_username;
        int i = R.l.dMR;
        Object[] objArr = new Object[1];
        a aVar = this.kHB;
        as.Hm();
        objArr[0] = aVar.A(c.Ff().Xv(this.talker));
        contextMenu.setHeaderTitle(getString(i, objArr));
        contextMenu.add(adapterContextMenuInfo.position, 0, 0, R.l.dMS);
    }
}
