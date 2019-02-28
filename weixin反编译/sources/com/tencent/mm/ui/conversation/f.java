package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.content.Context;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import com.tencent.mm.R;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.f.b.ak;
import com.tencent.mm.k.a;
import com.tencent.mm.modelsimple.aj;
import com.tencent.mm.modelstat.b;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ae;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.conversation.b.AnonymousClass5;
import com.tencent.mm.ui.conversation.b.AnonymousClass6;
import com.tencent.mm.ui.widget.i;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bb;
import com.tencent.mm.y.c;
import com.tencent.mm.y.s;

public final class f implements OnCreateContextMenuListener, OnItemLongClickListener {
    private Activity activity;
    private ae conversation = null;
    private d otp = new d() {
        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            int i2 = 4;
            switch (menuItem.getItemId()) {
                case 4:
                    if (s.eX(f.this.talker)) {
                        g.pWK.h(14553, Integer.valueOf(1), Integer.valueOf(1), f.this.talker);
                    } else {
                        g.pWK.h(14553, Integer.valueOf(0), Integer.valueOf(1), f.this.talker);
                    }
                    if (f.this.conversation.xGE != null) {
                        x.i("MicroMsg.ConversationClickListener", "summerdel talker[%s] activity[%s] username[%s] latestInsertMsg[%s, %s, %s]", f.this.talker, f.this.activity, f.this.conversation.field_username, Long.valueOf(f.this.conversation.xGE.field_msgId), f.this.conversation.xGE.field_content, Long.valueOf(f.this.conversation.xGE.field_createTime));
                    } else {
                        x.i("MicroMsg.ConversationClickListener", "summerdel talker[%s] activity[%s] username[%s] latestInsertMsg is null", f.this.talker, f.this.activity, f.this.conversation.field_username);
                    }
                    b.a(f.this.talker, f.this.activity, f.this.conversation, null, true, false);
                    i2 = 1;
                    break;
                case 5:
                    x.d("MicroMsg.ConversationClickListener", "placed to the top");
                    s.r(f.this.talker, true);
                    as.Hm();
                    ag Xv = c.Ff().Xv(f.this.talker);
                    if (Xv != null && Xv.ciN()) {
                        g.pWK.h(13307, Xv.field_username, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
                    }
                    h.bu(f.this.activity, f.this.activity.getString(R.l.euA));
                    b.hRo.c(true, f.this.talker, true);
                    break;
                case 6:
                    x.d("MicroMsg.ConversationClickListener", "unplaced to the top");
                    s.s(f.this.talker, true);
                    as.Hm();
                    ag Xv2 = c.Ff().Xv(f.this.talker);
                    if (Xv2 != null && Xv2.ciN()) {
                        g.pWK.h(13307, Xv2.field_username, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1));
                    }
                    h.bu(f.this.activity, f.this.activity.getString(R.l.euB));
                    b.hRo.c(true, f.this.talker, false);
                    i2 = 5;
                    break;
                case 7:
                    x.d("MicroMsg.ConversationClickListener", "jacks mark read: %s", f.this.talker);
                    as.Hm();
                    c.Fk().XH(f.this.talker);
                    MMAppMgr.cancelNotification(f.this.talker);
                    aj.S(f.this.talker, 1);
                    b.hRo.I(f.this.talker, false);
                    i2 = 3;
                    break;
                case 8:
                    x.d("MicroMsg.ConversationClickListener", "jacks set unread: %s", f.this.talker);
                    as.Hm();
                    c.Fk().XI(f.this.talker);
                    b.hRo.I(f.this.talker, true);
                    i2 = 2;
                    break;
                case 9:
                    x.d("MicroMsg.ConversationClickListener", "jacks clear history: %s", f.this.talker);
                    f.this.talker.endsWith("@chatroom");
                    String a = f.this.talker;
                    Context c = f.this.activity;
                    PBool pBool = new PBool();
                    pBool.value = false;
                    c.getString(R.l.dGZ);
                    bb.a(a, new AnonymousClass6(pBool, h.a(c, c.getString(R.l.dHn), true, new AnonymousClass5(pBool))));
                    i2 = -1;
                    break;
                case 10:
                    x.d("MicroMsg.ConversationClickListener", "delete biz service: %s", f.this.talker);
                    as.Hm();
                    com.tencent.mm.ui.tools.b.a(com.tencent.mm.af.f.jV(f.this.talker), f.this.activity, c.Ff().Xv(f.this.talker), 1);
                    break;
            }
            i2 = -1;
            if (i2 > 0) {
                g.pWK.h(11090, Integer.valueOf(i2));
                x.d("MicroMsg.ConversationClickListener", "jacks kv long click: %d", Integer.valueOf(i2));
            }
        }
    };
    private String talker = "";
    private ListView zeU;
    private g zfz;
    private int[] zgs = new int[2];

    public f(g gVar, ListView listView, Activity activity, int[] iArr) {
        this.zfz = gVar;
        this.zeU = listView;
        this.activity = activity;
        this.zgs = iArr;
    }

    public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i < this.zeU.getHeaderViewsCount()) {
            x.d("MicroMsg.ConversationClickListener", "on long click header view");
            return true;
        }
        this.conversation = (ae) this.zfz.DV(i - this.zeU.getHeaderViewsCount());
        if (this.conversation == null) {
            x.e("MicroMsg.ConversationClickListener", "headercount:%d, postion:%d", Integer.valueOf(this.zeU.getHeaderViewsCount()), Integer.valueOf(i));
            return true;
        }
        this.talker = this.conversation.field_username;
        new i(this.activity).a(view, i, j, this, this.otp, this.zgs[0], this.zgs[1]);
        if (s.eX(this.talker)) {
            g.pWK.h(14553, Integer.valueOf(1), Integer.valueOf(0), this.talker);
        } else {
            g.pWK.h(14553, Integer.valueOf(0), Integer.valueOf(0), this.talker);
        }
        return true;
    }

    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        int i = 1;
        as.Hm();
        ag Xv = c.Ff().Xv(this.talker);
        if (Xv == null) {
            x.e("MicroMsg.ConversationClickListener", "onCreateContextMenu, contact is null, talker = " + this.talker);
            return;
        }
        CharSequence AX = Xv.AX();
        if (AX.toLowerCase().endsWith("@chatroom") && t.oN(Xv.field_nickname)) {
            AX = this.activity.getString(R.l.dSY);
        }
        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
        contextMenu.setHeaderTitle(com.tencent.mm.pluginsdk.ui.d.i.a(this.activity, AX));
        if (((this.conversation != null ? 1 : 0) & s.b(this.conversation)) != 0) {
            String str = this.talker;
            as.Hm();
            ak XF = c.Fk().XF(str);
            if (XF == null) {
                i = 0;
            } else if (XF.field_unReadCount > 0 || XF.gd(1048576)) {
                i = 0;
            }
            if (i != 0) {
                contextMenu.add(adapterContextMenuInfo.position, 8, 0, R.l.euy);
            } else {
                contextMenu.add(adapterContextMenuInfo.position, 7, 0, R.l.euw);
            }
        }
        if (this.conversation != null && s.a(this.conversation)) {
            as.Hm();
            if (c.Fk().XM(this.talker)) {
                contextMenu.add(adapterContextMenuInfo.position, 6, 0, R.l.euz);
            } else if (Xv.ciN()) {
                contextMenu.add(adapterContextMenuInfo.position, 5, 0, R.l.dXn);
            } else {
                contextMenu.add(adapterContextMenuInfo.position, 5, 0, R.l.eux);
            }
        }
        if (Xv.ciN() && a.ga(Xv.field_type) && !s.hr(Xv.field_username) && !s.gU(Xv.field_username)) {
            com.tencent.mm.af.d jV = com.tencent.mm.af.f.jV(Xv.field_username);
            if (jV != null && jV.Lh()) {
                contextMenu.add(adapterContextMenuInfo.position, 10, 0, R.l.euv);
            }
        }
        if (this.conversation != null && this.conversation.field_conversationTime != -1) {
            if (s.gN(this.talker)) {
                contextMenu.add(adapterContextMenuInfo.position, 4, 0, R.l.euE);
            } else if (s.gO(this.talker)) {
                contextMenu.add(adapterContextMenuInfo.position, 4, 0, R.l.euD);
            } else {
                contextMenu.add(adapterContextMenuInfo.position, 4, 0, R.l.euC);
            }
        }
    }
}
