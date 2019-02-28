package com.tencent.mm.ui.chatting.e;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
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
import com.tencent.mm.ap.o;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.f.b.cg;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.favorite.d;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.q;
import com.tencent.mm.ui.chatting.a.b.e;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.s;
import java.util.Date;
import java.util.LinkedList;

public final class f extends b {
    int jXj = -1;
    private int mSW = 0;
    int yQf = 0;

    /* renamed from: com.tencent.mm.ui.chatting.e.f$1 */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ boolean yPQ = true;

        AnonymousClass1(boolean z) {
        }

        public final void run() {
            LinkedList linkedList = new LinkedList();
            as.Hm();
            Cursor bA = c.Fh().bA(f.this.jXh, f.this.jXj);
            if (bA == null) {
                x.e("MicroMsg.MusicHistoryListPresenter", "[loadData] cursor is null!");
                return;
            }
            q hG;
            if (s.eX(f.this.jXh)) {
                as.Hm();
                hG = c.Fo().hG(f.this.jXh);
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
                        if ((3 == fV.type ? 1 : null) != null) {
                            long b = com.tencent.mm.ui.gridviewheaders.a.cyc().b(new Date(auVar.field_createTime));
                            if (j != b) {
                                linkedList.add(new com.tencent.mm.ui.chatting.a.b.c(auVar.field_createTime));
                                f fVar = f.this;
                                fVar.yQf++;
                            }
                            String g = b.g(auVar, s.eX(f.this.jXh));
                            ag Xv = ((h) g.h(h.class)).Ff().Xv(g);
                            String str2 = "";
                            if (hG != null) {
                                str2 = hG.gw(g);
                            }
                            int RW = com.tencent.mm.pluginsdk.model.c.RW(fV.hcN);
                            String appName = d.getAppName(f.this.mContext, fV.fHu);
                            as.Hm();
                            ag Xv2 = c.Ff().Xv(fV.fHu);
                            if (Xv2 == null || !Xv2.field_username.equals(fV.fHu)) {
                                com.tencent.mm.y.ak.a.hhv.a(fV.fHu, "", null);
                            } else {
                                appName = Xv2.AX();
                            }
                            a aVar = new a(auVar.field_createTime, fV.type, fV.title, auVar.field_msgId, Xv.field_username, Xv.AW(), Xv.field_conRemark, str2);
                            aVar.bhd = bi.oN(appName) ? fV.description : appName;
                            aVar.appId = fV.appId;
                            aVar.imagePath = auVar.field_imgPath;
                            aVar.iconRes = RW;
                            linkedList.add(aVar);
                            j = b;
                        }
                    }
                } finally {
                    bA.close();
                }
            }
            f.this.jXe.addAll(linkedList);
            f.this.yPX = f.this.jXe;
            linkedList.clear();
            ah.y(new Runnable() {
                public final void run() {
                    if (f.this.yPU != null) {
                        f.this.yPU.z(AnonymousClass1.this.yPQ, f.this.jXe.size());
                    }
                }
            });
        }
    }

    class a extends com.tencent.mm.ui.chatting.a.b.b {
        public String appId;
        public String bhd;
        public int iconRes;
        public String imagePath;

        public a(long j, int i, String str, long j2, String str2, String str3, String str4, String str5) {
            super(j, i, str, j2, str2, str3, str4, str5);
        }

        public final boolean ZM(String str) {
            if (str == null) {
                return false;
            }
            Object toLowerCase = str.toLowerCase();
            if (com.tencent.mm.ui.chatting.a.b.b.ZN(toLowerCase)) {
                if (!bi.oN(this.bhd) && this.bhd.toLowerCase().contains(toLowerCase)) {
                    return true;
                }
            } else if (!bi.oN(this.bhd) && fT(toLowerCase, this.bhd.toLowerCase())) {
                return true;
            }
            return super.ZM(toLowerCase);
        }

        public final int getType() {
            return 3;
        }
    }

    class b extends com.tencent.mm.ui.chatting.a.b.a {
        TextView ikM;
        ImageView jIs;
        TextView mDG;
        ImageView mDQ;

        public b(View view) {
            super(view);
            this.jIs = (ImageView) view.findViewById(R.h.cgK);
            this.ikM = (TextView) view.findViewById(R.h.cgw);
            this.ikM.setVisibility(8);
            this.mDG = (TextView) view.findViewById(R.h.chb);
            this.mDQ = (ImageView) view.findViewById(R.h.cgO);
            this.mDQ.setImageResource(R.g.bDT);
            this.mDQ.setVisibility(0);
        }
    }

    public f(Context context) {
        super(context);
    }

    public final int getType() {
        return 3;
    }

    public final void cvf() {
        this.yPU.cvj();
        g.Dr();
        g.Dt().F(new AnonymousClass1(true));
    }

    public final String Xf() {
        return this.mContext.getString(R.l.dDK);
    }

    public final String cvi() {
        return this.mContext.getString(R.l.dDK);
    }

    public final e cvg() {
        return new e() {
            public final void a(int i, com.tencent.mm.ui.chatting.a.b.b bVar) {
                as.Hm();
                cg dI = c.Fh().dI(bVar.frh);
                com.tencent.mm.x.g.a fV = com.tencent.mm.x.g.a.fV(dI.field_content);
                String A = p.A(fV.url, "message");
                String A2 = p.A(fV.hcL, "message");
                PackageInfo packageInfo = f.getPackageInfo(f.this.mContext, fV.appId);
                f.this.a(A, A2, packageInfo == null ? null : packageInfo.versionName, packageInfo == null ? 0 : packageInfo.versionCode, fV.appId, dI.field_msgId, dI.field_msgSvrId, dI);
            }

            public final void a(View view, int i, final com.tencent.mm.ui.chatting.a.b.b bVar) {
                x.i("MicroMsg.MusicHistoryListPresenter", "[onItemLongClick] position:%s", Integer.valueOf(i));
                new l(view.getContext()).b(view, new OnCreateContextMenuListener() {
                    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                        contextMenu.add(0, 0, 0, view.getContext().getString(R.l.eET));
                        contextMenu.add(0, 1, 0, view.getContext().getString(R.l.dRa));
                        contextMenu.add(0, 2, 0, view.getContext().getString(R.l.dRS));
                    }
                }, new com.tencent.mm.ui.base.p.d() {
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                        as.Hm();
                        f.this.d(i, c.Fh().dI(bVar.frh));
                    }
                });
            }
        };
    }

    public final t l(ViewGroup viewGroup) {
        return new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.i.dtA, viewGroup, false));
    }

    public final void a(com.tencent.mm.ui.chatting.a.b.a aVar, int i) {
        b bVar = (b) aVar;
        a aVar2 = (a) FW(i);
        bVar.ljv.setText(com.tencent.mm.plugin.favorite.a.g.e(this.mContext, aVar2.timestamp));
        Bitmap a = o.PC().a(aVar2.imagePath, com.tencent.mm.bu.a.getDensity(this.mContext), false);
        if (a == null || a.isRecycled()) {
            a = com.tencent.mm.pluginsdk.model.app.g.b(aVar2.appId, 1, com.tencent.mm.bu.a.getDensity(this.mContext));
            if (a == null || a.isRecycled()) {
                bVar.jIs.setImageResource(R.k.dvO);
                bVar.mDG.setText(bi.aD(aVar2.bhd, ""));
                com.tencent.mm.ui.chatting.a.b.a.d(bVar.mDG, this.yPV.yHe);
            }
        }
        bVar.jIs.setImageBitmap(a);
        bVar.mDG.setText(bi.aD(aVar2.bhd, ""));
        com.tencent.mm.ui.chatting.a.b.a.d(bVar.mDG, this.yPV.yHe);
    }

    protected final void a(String str, String str2, String str3, int i, String str4, long j, long j2, au auVar) {
        if ((str == null || str.length() == 0) && (str2 == null || str2.length() == 0)) {
            x.e("MicroMsg.MusicHistoryListPresenter", "url, lowUrl both are empty");
            return;
        }
        if (ao.isMobile(this.mContext) ? str2 != null && str2.length() > 0 : str == null || str.length() <= 0) {
            str = str2;
        }
        Intent intent = new Intent();
        intent.putExtra("msg_id", j);
        intent.putExtra("rawUrl", str);
        intent.putExtra("version_name", str3);
        intent.putExtra("version_code", i);
        intent.putExtra("usePlugin", true);
        intent.putExtra("geta8key_username", this.jXh);
        intent.putExtra("KPublisherId", "msg_" + Long.toString(j2));
        intent.putExtra("KAppId", str4);
        String g = b.g(auVar, s.eX(this.jXh));
        intent.putExtra("pre_username", g);
        intent.putExtra("prePublishId", "msg_" + Long.toString(j2));
        if (auVar != null) {
            intent.putExtra("preUsername", g);
        }
        intent.putExtra("preChatName", this.jXh);
        intent.putExtra("preChatTYPE", com.tencent.mm.y.t.N(g, this.jXh));
        intent.putExtra("preMsgIndex", 0);
        com.tencent.mm.bl.d.b(this.mContext, "webview", ".ui.tools.WebViewUI", intent);
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
            x.printErrStackTrace("MicroMsg.MusicHistoryListPresenter", e, "", new Object[0]);
            return packageInfo;
        }
    }
}
