package com.tencent.mm.ui.chatting.e;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView.t;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.f.b.cg;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.q;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.chatting.a.b.e;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.s;
import java.util.Date;
import java.util.LinkedList;

public final class d extends b {
    int jXj = -1;
    int yQf = 0;

    /* renamed from: com.tencent.mm.ui.chatting.e.d$1 */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ boolean yPQ = true;

        AnonymousClass1(boolean z) {
        }

        public final void run() {
            Object linkedList = new LinkedList();
            as.Hm();
            Cursor bA = c.Fh().bA(d.this.jXh, d.this.jXj);
            if (bA == null) {
                x.e("MicroMsg.FileHistoryListPresenter", "[loadData] cursor is null!");
                return;
            }
            q hG;
            if (s.eX(d.this.jXh)) {
                as.Hm();
                hG = c.Fo().hG(d.this.jXh);
            } else {
                hG = null;
            }
            long j = 0;
            while (bA.moveToNext()) {
                try {
                    cg auVar = new au();
                    auVar.b(bA);
                    String str = auVar.field_content;
                    if (str != null) {
                        com.tencent.mm.x.g.a fV = com.tencent.mm.x.g.a.fV(str);
                        if ((6 == fV.type ? 1 : null) != null) {
                            long b = com.tencent.mm.ui.gridviewheaders.a.cyc().b(new Date(auVar.field_createTime));
                            if (j != b) {
                                linkedList.add(new com.tencent.mm.ui.chatting.a.b.c(auVar.field_createTime));
                                d dVar = d.this;
                                dVar.yQf++;
                            }
                            String g = b.g(auVar, s.eX(d.this.jXh));
                            ag Xv = ((h) g.h(h.class)).Ff().Xv(g);
                            String str2 = "";
                            if (hG != null) {
                                str2 = hG.gw(g);
                            }
                            int RW = com.tencent.mm.pluginsdk.model.c.RW(fV.hcN);
                            a aVar = new a(auVar.field_createTime, fV.type, fV.title, auVar.field_msgId, Xv.field_username, Xv.AW(), Xv.field_conRemark, str2);
                            aVar.iconRes = RW;
                            aVar.desc = bi.by((long) fV.hcM);
                            linkedList.add(aVar);
                            j = b;
                        }
                    }
                } finally {
                    bA.close();
                }
            }
            d.this.jXe.addAll(linkedList);
            d.this.yPX = d.this.jXe;
            linkedList.clear();
            x.i("MicroMsg.FileHistoryListPresenter", "[loadData] data:%s", Integer.valueOf(d.this.jXe.size()));
            ah.y(new Runnable() {
                public final void run() {
                    if (d.this.yPU != null) {
                        d.this.yPU.z(AnonymousClass1.this.yPQ, d.this.jXe.size());
                    }
                }
            });
        }
    }

    class a extends com.tencent.mm.ui.chatting.a.b.b {
        public String desc;
        public int iconRes;

        public a(long j, int i, String str, long j2, String str2, String str3, String str4, String str5) {
            super(j, i, str, j2, str2, str3, str4, str5);
        }

        public final boolean ZM(String str) {
            if (str != null) {
                return super.ZM(str.toLowerCase());
            }
            return false;
        }

        public final int getType() {
            return 6;
        }
    }

    class b extends com.tencent.mm.ui.chatting.a.b.a {
        TextView ikM;
        ImageView jIs;

        public b(View view) {
            super(view);
            this.jIs = (ImageView) view.findViewById(R.h.cgK);
            this.ikL.setSingleLine(false);
            this.ikL.setMaxLines(2);
            this.ikM = (TextView) view.findViewById(R.h.cgz);
        }
    }

    static /* synthetic */ void a(d dVar, com.tencent.mm.ui.chatting.a.b.b bVar) {
        if (dVar.cwf()) {
            Intent intent = new Intent();
            intent.setClassName(dVar.mContext, "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
            intent.putExtra("app_msg_id", bVar.frh);
            dVar.mContext.startActivity(intent);
            return;
        }
        u.fJ(dVar.mContext);
    }

    public d(Context context) {
        super(context);
    }

    public final int getType() {
        return 6;
    }

    public final void cvf() {
        x.i("MicroMsg.FileHistoryListPresenter", "[loadData] isFirst:%s", Boolean.valueOf(true));
        this.yPU.cvj();
        g.Dr();
        g.Dt().F(new AnonymousClass1(true));
    }

    public final String Xf() {
        return this.mContext.getString(R.l.dDJ);
    }

    public final String cvi() {
        return this.mContext.getString(R.l.dDJ);
    }

    public final e cvg() {
        return new e() {
            public final void a(int i, com.tencent.mm.ui.chatting.a.b.b bVar) {
                x.i("MicroMsg.FileHistoryListPresenter", "[onItemClick] position:%s", Integer.valueOf(i));
                d.a(d.this, bVar);
            }

            public final void a(View view, int i, final com.tencent.mm.ui.chatting.a.b.b bVar) {
                x.i("MicroMsg.FileHistoryListPresenter", "[onItemLongClick] position:%s", Integer.valueOf(i));
                new l(view.getContext()).b(view, new OnCreateContextMenuListener() {
                    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                        contextMenu.add(0, 0, 0, view.getContext().getString(R.l.eET));
                        contextMenu.add(0, 1, 0, view.getContext().getString(R.l.dRa));
                        contextMenu.add(0, 2, 0, view.getContext().getString(R.l.dRS));
                    }
                }, new com.tencent.mm.ui.base.p.d() {
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                        as.Hm();
                        d.this.d(i, c.Fh().dI(bVar.frh));
                    }
                });
            }
        };
    }

    public final t l(ViewGroup viewGroup) {
        return new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.i.dih, viewGroup, false));
    }

    public final void a(com.tencent.mm.ui.chatting.a.b.a aVar, int i) {
        b bVar = (b) aVar;
        a aVar2 = (a) FW(i);
        if (bi.oN(aVar2.desc)) {
            bVar.ikM.setVisibility(8);
        } else {
            bVar.ikM.setVisibility(0);
            bVar.ikM.setText(bi.aD(aVar2.desc, ""));
        }
        bVar.jIs.setImageResource(aVar2.iconRes);
    }
}
