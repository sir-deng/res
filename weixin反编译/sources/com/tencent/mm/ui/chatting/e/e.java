package com.tencent.mm.ui.chatting.e;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.database.Cursor;
import android.graphics.Rect;
import android.os.Looper;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.g;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.q;
import android.view.View;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ad.k;
import com.tencent.mm.ap.d.a;
import com.tencent.mm.f.a.cg;
import com.tencent.mm.f.a.gm;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.a.a.c;
import com.tencent.mm.ui.chatting.ac;
import com.tencent.mm.ui.chatting.gallery.d;
import com.tencent.mm.ui.chatting.gallery.g.b;
import com.tencent.mm.ui.chatting.gallery.i;
import com.tencent.mm.ui.chatting.j;
import com.tencent.mm.y.as;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public final class e implements a, s.a, com.tencent.mm.ui.chatting.c.a.a, b {
    static int count = 0;
    private ArrayList<c> jXe = null;
    private String jXh;
    private Context mContext;
    private ag mHandler = new ag(Looper.getMainLooper());
    private int mSW = 0;
    private long yGO;
    private com.tencent.mm.sdk.b.c yIZ = new com.tencent.mm.sdk.b.c<gm>() {
        {
            this.xmG = gm.class.getName().hashCode();
        }

        public final /* bridge */ /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            gm gmVar = (gm) bVar;
            e.a(e.this, gmVar.fxt.frh, gmVar);
            return false;
        }
    };
    private int yQf = 0;
    private com.tencent.mm.ui.chatting.c.a.b yQj;
    com.tencent.mm.ui.chatting.a.a yQk;
    private GridLayoutManager yQl;
    boolean yQm = false;
    private int yQn = 0;
    private boolean yQo = false;

    static /* synthetic */ void a(e eVar, long j, gm gmVar) {
        int i = -1;
        for (c cVar : eVar.yQk.jTb) {
            i++;
            if (cVar.fFE != null && cVar.fFE.field_msgId == j) {
                break;
            }
        }
        i = -1;
        GridLayoutManager gridLayoutManager = (GridLayoutManager) eVar.fN(eVar.mContext);
        int fa = gridLayoutManager.fa();
        x.i("MicroMsg.MediaHistoryGalleryPresenter", "[getPhotoInfo] msgId:%s pos:%s [%s:%s]", Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(fa), Integer.valueOf(gridLayoutManager.fb()));
        if (i >= fa && i <= r0) {
            View childAt = eVar.yQj.getChildAt(i - fa);
            if (childAt != null) {
                int[] iArr = new int[2];
                childAt.getLocationInWindow(iArr);
                gmVar.fxu.fpF = iArr[0];
                gmVar.fxu.fpG = iArr[1];
                gmVar.fxu.fpH = childAt.getWidth();
                gmVar.fxu.fpI = childAt.getHeight();
            }
        }
    }

    static /* synthetic */ void a(e eVar, au auVar) {
        r bq = i.bq(auVar);
        if (bq == null) {
            x.e("MicroMsg.MediaHistoryGalleryPresenter", "[saveVideo] info == null");
            return;
        }
        o.Ub().a(eVar, Looper.getMainLooper());
        if (bq.Up()) {
            x.i("MicroMsg.MediaHistoryGalleryPresenter", "start complete online video");
            t.nN(auVar.field_imgPath);
            return;
        }
        x.i("MicroMsg.MediaHistoryGalleryPresenter", "start complete offline video");
        t.Z(auVar.field_imgPath, 10);
        t.nF(auVar.field_imgPath);
    }

    static /* synthetic */ void a(e eVar, final au auVar, com.tencent.mm.ap.e eVar2) {
        String str = "MicroMsg.MediaHistoryGalleryPresenter";
        String str2 = "[downloadImg] %s %s ";
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(auVar == null);
        objArr[1] = Boolean.valueOf(eVar2 == null);
        x.e(str, str2, objArr);
        if (auVar != null) {
            if (auVar.getType() == 268435505) {
                l.a(auVar, new l.a() {
                    public final void ey(int i, int i2) {
                        if (i == i2) {
                            x.i("MicroMsg.MediaHistoryGalleryPresenter", "[onSceneProgressEnd] MsgId:%s", Long.valueOf(auVar.field_msgId));
                            e.this.yQn = e.this.yQn - 1;
                            if (!com.tencent.mm.ui.chatting.gallery.b.b(e.this.mContext, auVar, false)) {
                                e.this.yQo = true;
                            }
                            if (!e.this.cwg()) {
                                return;
                            }
                            if (e.this.yQo) {
                                e.this.mHandler.post(new Runnable() {
                                    public final void run() {
                                        if (e.this.yQj != null) {
                                            e.this.yQj.Gb(R.l.elQ);
                                        }
                                    }
                                });
                            } else {
                                e.this.mHandler.post(new Runnable() {
                                    public final void run() {
                                        if (e.this.yQj != null) {
                                            e.this.yQj.cvb();
                                        }
                                    }
                                });
                            }
                        }
                    }
                });
            } else if (eVar2 != null && com.tencent.mm.ap.o.PD().a(eVar2.hBA, auVar.field_msgId, 0, Integer.valueOf(-1), -1, eVar, 0) == -2) {
                x.w("MicroMsg.MediaHistoryGalleryPresenter", "[downloadImg] this img has download! %s", eVar2.hBB);
                eVar.yQn--;
                com.tencent.mm.ui.chatting.gallery.b.b(eVar.mContext, auVar, false);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ int b(com.tencent.mm.ui.chatting.e.e r13, java.util.List r14) {
        /*
        r3 = 0;
        r12 = 2;
        r11 = 1;
        r2 = 0;
        if (r14 != 0) goto L_0x0007;
    L_0x0006:
        return r2;
    L_0x0007:
        r4 = r14.iterator();
        r1 = r2;
    L_0x000c:
        r0 = r4.hasNext();
        if (r0 == 0) goto L_0x00f4;
    L_0x0012:
        r0 = r4.next();
        r0 = (com.tencent.mm.storage.au) r0;
        r5 = r0.ckh();
        if (r5 == 0) goto L_0x0022;
    L_0x001e:
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x000c;
    L_0x0022:
        r5 = com.tencent.mm.ui.chatting.gallery.b.aX(r0);
        if (r5 == 0) goto L_0x0057;
    L_0x0028:
        r5 = com.tencent.mm.ui.chatting.gallery.i.bq(r0);
        if (r5 == 0) goto L_0x0117;
    L_0x002e:
        r6 = "MicroMsg.MediaHistoryGalleryPresenter";
        r7 = "[checkLegal] getStatus:%s";
        r8 = new java.lang.Object[r11];
        r9 = r5.status;
        r9 = java.lang.Integer.valueOf(r9);
        r8[r2] = r9;
        com.tencent.mm.sdk.platformtools.x.i(r6, r7, r8);
        r0 = c(r0, r5);
    L_0x0045:
        if (r5 == 0) goto L_0x0053;
    L_0x0047:
        r5 = r5.status;
        r6 = 198; // 0xc6 float:2.77E-43 double:9.8E-322;
        if (r5 == r6) goto L_0x0053;
    L_0x004d:
        r0 = com.tencent.mm.modelsfs.FileOp.bO(r0);
        if (r0 != 0) goto L_0x0114;
    L_0x0053:
        r0 = r1 + 1;
    L_0x0055:
        r1 = r0;
        goto L_0x000c;
    L_0x0057:
        r5 = com.tencent.mm.ui.chatting.gallery.d.bl(r0);
        if (r5 == 0) goto L_0x0070;
    L_0x005d:
        r6 = "MicroMsg.MediaHistoryGalleryPresenter";
        r7 = "[checkLegal] getStatus:%s";
        r8 = new java.lang.Object[r11];
        r9 = r5.status;
        r9 = java.lang.Integer.valueOf(r9);
        r8[r2] = r9;
        com.tencent.mm.sdk.platformtools.x.i(r6, r7, r8);
    L_0x0070:
        r6 = r0.getType();
        r7 = 268435505; // 0x10000031 float:2.5243696E-29 double:1.32624761E-315;
        if (r6 != r7) goto L_0x00b4;
    L_0x0079:
        r0 = com.tencent.mm.ui.chatting.gallery.b.bg(r0);
        r5 = "MicroMsg.MediaHistoryGalleryPresenter";
        r6 = "[checkLegal] is appmsg! null?%s,exists:%s";
        r7 = new java.lang.Object[r12];
        r8 = com.tencent.mm.sdk.platformtools.bi.oN(r0);
        r8 = java.lang.Boolean.valueOf(r8);
        r7[r2] = r8;
        r8 = new java.io.File;
        r9 = "";
        r9 = com.tencent.mm.sdk.platformtools.bi.aD(r0, r9);
        r8.<init>(r9);
        r8 = r8.exists();
        r8 = java.lang.Boolean.valueOf(r8);
        r7[r11] = r8;
        com.tencent.mm.sdk.platformtools.x.i(r5, r6, r7);
        r0 = com.tencent.mm.modelsfs.FileOp.bO(r0);
        if (r0 != 0) goto L_0x00f2;
    L_0x00ae:
        r1 = r1 + 1;
        r0 = r1;
    L_0x00b1:
        r1 = r0;
        goto L_0x000c;
    L_0x00b4:
        if (r5 == 0) goto L_0x0112;
    L_0x00b6:
        r0 = com.tencent.mm.ui.chatting.gallery.d.d(r0, r5);
    L_0x00ba:
        r6 = "MicroMsg.MediaHistoryGalleryPresenter";
        r7 = "[checkLegal] null?%s,exists:%s";
        r8 = new java.lang.Object[r12];
        r9 = com.tencent.mm.sdk.platformtools.bi.oN(r0);
        r9 = java.lang.Boolean.valueOf(r9);
        r8[r2] = r9;
        r9 = new java.io.File;
        r10 = "";
        r10 = com.tencent.mm.sdk.platformtools.bi.aD(r0, r10);
        r9.<init>(r10);
        r9 = r9.exists();
        r9 = java.lang.Boolean.valueOf(r9);
        r8[r11] = r9;
        com.tencent.mm.sdk.platformtools.x.i(r6, r7, r8);
        if (r5 == 0) goto L_0x00ae;
    L_0x00e7:
        r5 = r5.status;
        r6 = -1;
        if (r5 == r6) goto L_0x00ae;
    L_0x00ec:
        r0 = com.tencent.mm.modelsfs.FileOp.bO(r0);
        if (r0 == 0) goto L_0x00ae;
    L_0x00f2:
        r0 = r1;
        goto L_0x00b1;
    L_0x00f4:
        r0 = "MicroMsg.MediaHistoryGalleryPresenter";
        r3 = "[checkLegal] count:%s size:%s";
        r4 = new java.lang.Object[r12];
        r5 = java.lang.Integer.valueOf(r1);
        r4[r2] = r5;
        r2 = r14.size();
        r2 = java.lang.Integer.valueOf(r2);
        r4[r11] = r2;
        com.tencent.mm.sdk.platformtools.x.i(r0, r3, r4);
        r2 = r1;
        goto L_0x0006;
    L_0x0112:
        r0 = r3;
        goto L_0x00ba;
    L_0x0114:
        r0 = r1;
        goto L_0x0055;
    L_0x0117:
        r0 = r3;
        goto L_0x0045;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.e.e.b(com.tencent.mm.ui.chatting.e.e, java.util.List):int");
    }

    static /* synthetic */ LinkedList c(e eVar, List list) {
        LinkedList linkedList = new LinkedList();
        for (au auVar : list) {
            if (com.tencent.mm.ui.chatting.gallery.b.aW(auVar)) {
                if (d.bl(auVar).Pj()) {
                    eVar.yQn--;
                    com.tencent.mm.ui.chatting.gallery.b.b(eVar.mContext, auVar, false);
                } else {
                    linkedList.add(auVar);
                }
            } else if (auVar.getType() == 268435505) {
                if (bi.oN(com.tencent.mm.ui.chatting.gallery.b.bg(auVar)) || !new File(com.tencent.mm.ui.chatting.gallery.b.bg(auVar)).exists()) {
                    linkedList.add(auVar);
                } else {
                    eVar.yQn--;
                    com.tencent.mm.ui.chatting.gallery.b.b(eVar.mContext, auVar, false);
                }
            }
        }
        return linkedList;
    }

    static /* synthetic */ LinkedList d(e eVar, List list) {
        LinkedList linkedList = new LinkedList();
        for (au auVar : list) {
            if (com.tencent.mm.ui.chatting.gallery.b.aX(auVar)) {
                if (i.bq(auVar).Uq()) {
                    eVar.yQn--;
                    com.tencent.mm.ui.chatting.gallery.b.a(eVar.mContext, auVar, false);
                } else {
                    linkedList.add(auVar);
                }
            }
        }
        return linkedList;
    }

    public final /* synthetic */ void a(com.tencent.mm.ui.chatting.h.a aVar) {
        this.yQj = (com.tencent.mm.ui.chatting.c.a.b) aVar;
        this.yQj.a(this);
        this.yIZ.cfB();
        a.yNw.a(this);
    }

    public final /* bridge */ /* synthetic */ RecyclerView.a cuU() {
        return this.yQk;
    }

    public e(Context context) {
        this.mContext = context;
        this.jXe = new ArrayList();
    }

    public final void onDetach() {
        this.yIZ.dead();
        this.yQj.a(null);
        this.yQj = null;
        com.tencent.mm.ap.o.PD().a((a) this);
        o.Ub().a((s.a) this);
        a.yNw.detach();
    }

    public final <T extends h> T fN(Context context) {
        if (this.yQl == null) {
            this.yQl = new GridLayoutManager(context, 4);
            this.yQl.RB = new GridLayoutManager.b() {
                public final int ba(int i) {
                    if (((c) e.this.jXe.get(i)).type == Integer.MAX_VALUE) {
                        return 4;
                    }
                    return 1;
                }
            };
        }
        return this.yQl;
    }

    public final g fO(final Context context) {
        return new g() {
            public final void a(Rect rect, View view, RecyclerView recyclerView, q qVar) {
                int dimension = (int) context.getResources().getDimension(R.f.bvM);
                rect.bottom = dimension;
                rect.top = dimension;
                rect.left = dimension;
                rect.right = dimension;
            }
        };
    }

    public final RecyclerView.a aw(String str, long j) {
        this.jXh = str;
        this.yGO = j;
        if (j == -1) {
            this.yQk = new com.tencent.mm.ui.chatting.a.a(this.mContext, this.jXe, str);
        } else {
            this.yQk = new com.tencent.mm.ui.chatting.a.a(this.mContext, this.jXe, str, j);
        }
        this.yQk.yGQ = new com.tencent.mm.ui.chatting.a.a.b() {
            public final void a(boolean z, c cVar, int i) {
                x.i("MicroMsg.MediaHistoryGalleryPresenter", "[onCheck] isChecked :%s pos:%s", Boolean.valueOf(z), Integer.valueOf(i));
                if (!z || a.yNw.yLS.size() < 9) {
                    if (z) {
                        a.yNw.bm(cVar.fFE);
                    } else {
                        a.yNw.bn(cVar.fFE);
                    }
                    e.this.yQj.Ga(a.yNw.yLS.size());
                    return;
                }
                Toast.makeText(e.this.mContext, e.this.mContext.getResources().getString(R.l.elL, new Object[]{Integer.valueOf(9)}), 1).show();
                e.this.yQk.bj(i);
            }
        };
        return this.yQk;
    }

    public final String Xf() {
        return this.mContext.getString(R.l.dDN);
    }

    public final void FZ(int i) {
        x.i("MicroMsg.MediaHistoryGalleryPresenter", "[handleSelectedItem] type:%s", Integer.valueOf(i));
        final List<au> list = a.yNw.yLS;
        switch (i) {
            case 0:
                com.tencent.mm.plugin.report.service.g.pWK.a(219, 19, 1, true);
                j.a(this.mContext, list, this.jXh.toLowerCase().endsWith("@chatroom"), this.jXh, new ac() {
                    public final void csH() {
                    }

                    public final void a(ac.a aVar) {
                    }

                    public final void b(ac.a aVar) {
                    }

                    public final boolean csI() {
                        return true;
                    }
                });
                this.yQj.cuX();
                return;
            case 1:
                com.tencent.mm.plugin.report.service.g.pWK.a(219, 18, 1, true);
                final cg cgVar = new cg();
                if (com.tencent.mm.pluginsdk.model.h.a(this.mContext, cgVar, this.jXh, list, false, false)) {
                    b(cgVar);
                    dt(list);
                } else if (list.size() > 1) {
                    com.tencent.mm.ui.base.h.a(this.mContext, cgVar.frk.frq >= 0 ? this.mContext.getString(R.l.efH) : this.mContext.getString(R.l.efG), "", cgVar.frk.frq >= 0 ? this.mContext.getString(R.l.dUn) : this.mContext.getString(R.l.eAq), this.mContext.getString(R.l.dUl), new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            if (cgVar.frk.type != 14 || cgVar.frk.frm.wlY.size() != 0) {
                                e.this.b(cgVar);
                                e.dt(list);
                            }
                        }
                    }, null);
                } else {
                    com.tencent.mm.ui.base.h.h(this.mContext, cgVar.frk.frq, 0);
                }
                this.yQj.cuX();
                return;
            case 2:
                ds(list);
                return;
            case 3:
                this.yQj.cva();
                final List arrayList = new ArrayList();
                for (au auVar : list) {
                    if (!(com.tencent.mm.ui.chatting.gallery.b.aY(auVar) || com.tencent.mm.ui.chatting.gallery.b.aZ(auVar))) {
                        arrayList.add(auVar);
                    }
                }
                if (arrayList.size() != list.size()) {
                    com.tencent.mm.ui.base.h.a(this.mContext, R.l.elH, R.l.dGZ, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            e.this.dr(arrayList);
                        }
                    }, null);
                    return;
                } else {
                    dr(arrayList);
                    return;
                }
            default:
                return;
        }
    }

    public final int cuV() {
        return a.yNw.yLS.size();
    }

    public final void cuW() {
        this.yQk.yGR = true;
        a.yNw.yNu = true;
        GridLayoutManager gridLayoutManager = (GridLayoutManager) fN(this.mContext);
        int fa = gridLayoutManager.fa();
        this.yQk.b(fa, (gridLayoutManager.fb() - fa) + 1, Integer.valueOf(0));
    }

    public final void cuX() {
        this.yQk.yGR = false;
        a.yNw.clear();
        a.yNw.yNu = false;
        this.yQk.UR.notifyChanged();
    }

    public final boolean cuY() {
        return a.yNw.yNu;
    }

    public final void onResume() {
        if (this.yQm && a.yNw.yNu) {
            this.yQj.Ga(a.yNw.yLS.size());
            this.yQk.UR.notifyChanged();
        }
    }

    public final void cvr() {
        this.yQm = true;
    }

    public final void clear() {
    }

    public final void a(long j, long j2, int i, int i2, Object obj, int i3, int i4, k kVar) {
        x.d("MicroMsg.MediaHistoryGalleryPresenter", "[onImgTaskProgress] offset:%s totalLen:%s", Integer.valueOf(i3), Integer.valueOf(i4));
    }

    public final void a(long j, long j2, int i, int i2, Object obj, int i3, int i4, String str, k kVar) {
        x.i("MicroMsg.MediaHistoryGalleryPresenter", "[onImgTaskEnd] mNeedDownloadCount:%s imgLocalId:%s msgLocalId:%s err[%s:%s:%s]", Integer.valueOf(this.yQn), Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (this.yQj.cvc()) {
            this.yQn--;
            as.Hm();
            if (!com.tencent.mm.ui.chatting.gallery.b.b(this.mContext, com.tencent.mm.y.c.Fh().dI(j2), false)) {
                this.yQo = true;
            }
            if (!cwg()) {
                return;
            }
            if (this.yQo) {
                this.mHandler.post(new Runnable() {
                    public final void run() {
                        if (e.this.yQj != null) {
                            e.this.yQj.Gb(R.l.elQ);
                        }
                    }
                });
            } else {
                this.mHandler.post(new Runnable() {
                    public final void run() {
                        if (e.this.yQj != null) {
                            e.this.yQj.cvb();
                        }
                    }
                });
            }
        }
    }

    public final void a(long j, long j2, int i, int i2, Object obj) {
    }

    public final void cuZ() {
        com.tencent.mm.ap.o.PD().a((a) this);
        o.Ub().a((s.a) this);
        this.yQj.cuZ();
    }

    public final void a(s.a.a aVar) {
        if (this.yQj.cvc()) {
            r nJ = t.nJ(aVar.fileName);
            x.d("MicroMsg.MediaHistoryGalleryPresenter", "[notifyChanged] mNeedDownloadCount:%s statusType:%s %s", Integer.valueOf(this.yQn), aVar.hXM, aVar.fileName);
            if (nJ == null) {
                x.e("MicroMsg.MediaHistoryGalleryPresenter", "[notifyChanged] videoInfo is null!");
                cuZ();
                this.yQj.Gb(0);
            } else if (nJ.Uq()) {
                this.yQn--;
                as.Hm();
                com.tencent.mm.ui.chatting.gallery.b.a(this.mContext, com.tencent.mm.y.c.Fh().dI((long) nJ.hXw), false);
            }
            if (!cwg()) {
                return;
            }
            if (this.yQo) {
                this.mHandler.post(new Runnable() {
                    public final void run() {
                        if (e.this.yQj != null) {
                            e.this.yQj.Gb(R.l.elQ);
                        }
                    }
                });
            } else {
                this.mHandler.post(new Runnable() {
                    public final void run() {
                        if (e.this.yQj != null) {
                            e.this.yQj.cvb();
                        }
                    }
                });
            }
        }
    }

    private void dr(final List<au> list) {
        com.tencent.mm.sdk.f.e.post(new Runnable() {
            public final void run() {
                int b = e.b(e.this, list);
                if (list.size() == b) {
                    e.this.mHandler.post(new Runnable() {
                        public final void run() {
                            e.this.yQj.Gb(R.l.elP);
                        }
                    });
                    return;
                }
                e.this.yQo = b > 0;
                List<au> c = e.c(e.this, list);
                List<au> d = e.d(e.this, list);
                x.i("MicroMsg.MediaHistoryGalleryPresenter", "[innerHandleSave] needDownloadImageList size:%s needDownloadVideoList:%s", Integer.valueOf(c.size()), Integer.valueOf(d.size()));
                e.this.yQn = c.size() + d.size();
                if (ao.isWifi(ad.getContext()) || e.this.yQn != list.size()) {
                    for (au auVar : c) {
                        e.a(e.this, auVar, d.bl(auVar));
                    }
                    for (au auVar2 : d) {
                        e.a(e.this, auVar2);
                    }
                    if (e.this.yQo && e.this.yQn == 0) {
                        e.this.mHandler.post(new Runnable() {
                            public final void run() {
                                e.this.yQj.Gb(R.l.elQ);
                            }
                        });
                    }
                    if (e.this.cwg() && !e.this.yQo) {
                        e.this.mHandler.post(new Runnable() {
                            public final void run() {
                                if (e.this.yQj != null) {
                                    e.this.yQj.cvb();
                                }
                            }
                        });
                        return;
                    }
                    return;
                }
                e.this.mHandler.post(new Runnable() {
                    public final void run() {
                        e.this.yQj.Gb(R.l.elP);
                    }
                });
            }
        }, "handleSave");
    }

    private boolean cwg() {
        return this.yQn == 0;
    }

    private static String c(au auVar, r rVar) {
        String Um;
        if (rVar.hXC == -1) {
            Um = rVar.Um();
            if (com.tencent.mm.a.e.bO(Um)) {
                return Um;
            }
            o.Ub();
            return s.nx(auVar.field_imgPath);
        }
        o.Ub();
        Um = s.nx(auVar.field_imgPath);
        if (auVar.field_isSend != 1 || rVar.hXF == null || !rVar.hXF.wEa) {
            return Um;
        }
        try {
            String mk = FileOp.mk(Um);
            if (!mk.endsWith("/")) {
                mk = mk + "/";
            }
            mk = mk + com.tencent.mm.a.e.bR(Um) + "_hd.mp4";
            x.i("MicroMsg.MediaHistoryGalleryPresenter", "local capture video, hdFilePath: %s, exist: %s", mk, Boolean.valueOf(FileOp.bO(mk)));
            if (!FileOp.bO(mk)) {
                mk = Um;
            }
            return mk;
        } catch (Exception e) {
            x.e("MicroMsg.MediaHistoryGalleryPresenter", "try to get hd filePath error: %s", e.getMessage());
            return Um;
        }
    }

    private void ds(final List<au> list) {
        com.tencent.mm.plugin.report.service.g.pWK.h(11627, Integer.valueOf(5));
        final Set treeSet = new TreeSet();
        for (au auVar : list) {
            treeSet.add(Long.valueOf(auVar.field_msgId));
        }
        com.tencent.mm.ui.base.h.a(this.mContext, this.mContext.getString(R.l.dUg), "", this.mContext.getString(R.l.dYG), this.mContext.getString(R.l.dEy), new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                x.i("MicroMsg.MediaHistoryGalleryPresenter", "delete message");
                com.tencent.mm.ui.chatting.h.a(e.this.mContext, treeSet, new ac() {
                    public final void csH() {
                    }

                    public final void a(ac.a aVar) {
                        if (aVar == ac.a.del) {
                            e.this.jXe.removeAll(list);
                        }
                    }

                    public final void b(ac.a aVar) {
                        x.i("MicroMsg.MediaHistoryGalleryPresenter", "[requestExitSelectedMode] %s del size:%s job:%s", Thread.currentThread(), Integer.valueOf(list.size()), aVar);
                        if (aVar == ac.a.del) {
                            e.this.yQj.cuX();
                        }
                    }

                    public final boolean csI() {
                        return true;
                    }
                });
            }
        }, null);
    }

    private static void dt(List<au> list) {
        for (au a : list) {
            com.tencent.mm.ui.chatting.a.a(com.tencent.mm.ui.chatting.a.c.Fav, com.tencent.mm.ui.chatting.a.d.Samll, a, 0);
        }
    }

    private void b(cg cgVar) {
        cgVar.frk.frr = 45;
        cgVar.frk.activity = (Activity) this.mContext;
        com.tencent.mm.sdk.b.a.xmy.m(cgVar);
        if (cgVar.frl.ret != -2 && cgVar.frl.ret <= 0 && cgVar.frl.ret <= 0) {
            if (14 != cgVar.frk.type) {
                x.d("MicroMsg.MediaHistoryGalleryPresenter", "not record type, do not report");
            } else if (cgVar.frk.frn == null) {
                x.e("MicroMsg.MediaHistoryGalleryPresenter", "want to report record fav, but type count is null");
            } else {
                com.tencent.mm.plugin.report.service.g.pWK.h(11142, Integer.valueOf(cgVar.frk.frn.wmo), Integer.valueOf(cgVar.frk.frn.wmp), Integer.valueOf(cgVar.frk.frn.wmq), Integer.valueOf(cgVar.frk.frn.wmr), Integer.valueOf(cgVar.frk.frn.wms), Integer.valueOf(cgVar.frk.frn.wmt), Integer.valueOf(cgVar.frk.frn.wmu), Integer.valueOf(cgVar.frk.frn.wmv), Integer.valueOf(cgVar.frk.frn.wmw), Integer.valueOf(cgVar.frk.frn.wmx), Integer.valueOf(cgVar.frk.frn.wmy), Integer.valueOf(cgVar.frk.frn.wmz), Integer.valueOf(cgVar.frk.frn.wmA), Integer.valueOf(cgVar.frk.frn.wmB), Integer.valueOf(cgVar.frk.frn.wmC));
            }
        }
    }

    public final void y(final boolean z, final int i) {
        if (z || this.mSW + this.yQf != this.jXe.size()) {
            this.yQk.yGP = true;
            this.yQj.mY(z);
            com.tencent.mm.kernel.g.Dr();
            com.tencent.mm.kernel.g.Dt().F(new Runnable() {
                public final void run() {
                    Cursor O;
                    if (z) {
                        e eVar;
                        if (e.this.yGO == -1) {
                            eVar = e.this;
                            as.Hm();
                            eVar.mSW = com.tencent.mm.y.c.Fh().Fv(e.this.jXh);
                        } else {
                            eVar = e.this;
                            as.Hm();
                            eVar.mSW = com.tencent.mm.y.c.Fi().au(e.this.jXh, e.this.yGO);
                        }
                    }
                    int k = (i < 0 || e.this.mSW - i <= 200) ? 200 : e.this.mSW - i;
                    x.i("MicroMsg.MediaHistoryGalleryPresenter", "offset:%s limit:%s", Integer.valueOf(i), Integer.valueOf(k));
                    LinkedList linkedList = new LinkedList();
                    if (e.this.yGO == -1) {
                        as.Hm();
                        O = com.tencent.mm.y.c.Fh().O(e.this.jXh, e.this.jXe.size() - e.this.yQf, k);
                    } else {
                        as.Hm();
                        O = com.tencent.mm.y.c.Fi().b(e.this.jXh, e.this.yGO, e.this.jXe.size() - e.this.yQf, k);
                    }
                    if (O == null) {
                        x.e("MicroMsg.MediaHistoryGalleryPresenter", "[loadData] NULL == cursor ");
                        return;
                    }
                    au auVar;
                    long b;
                    long j = 0;
                    while (O.moveToNext()) {
                        try {
                            auVar = new au();
                            auVar.b(O);
                            b = com.tencent.mm.ui.gridviewheaders.a.cyc().b(new Date(auVar.field_createTime));
                            if (j != b) {
                                linkedList.add(new c(auVar.field_createTime));
                                e.this.yQf = e.this.yQf + 1;
                            }
                            linkedList.add(new c(auVar));
                            j = b;
                        } finally {
                            O.close();
                        }
                    }
                    LinkedList linkedList2 = new LinkedList();
                    if (linkedList.size() - e.this.yQf == k) {
                        Cursor l;
                        long j2 = ((c) linkedList.get(0)).hQu;
                        com.tencent.mm.ui.gridviewheaders.a.cyc();
                        b = com.tencent.mm.ui.gridviewheaders.a.gs(j2);
                        x.i("MicroMsg.MediaHistoryGalleryPresenter", "[loadData] list size:%s start:%s end:%s", Integer.valueOf(linkedList.size()), Long.valueOf(b), Long.valueOf(j2));
                        if (e.this.yGO == -1) {
                            as.Hm();
                            l = com.tencent.mm.y.c.Fh().l(e.this.jXh, b, j2);
                        } else {
                            as.Hm();
                            l = com.tencent.mm.y.c.Fi().a(e.this.jXh, e.this.yGO, b, j2);
                        }
                        Date date = new Date(j2);
                        b = com.tencent.mm.ui.gridviewheaders.a.cyc().b(date);
                        while (l != null) {
                            try {
                                if (!l.moveToNext()) {
                                    break;
                                }
                                auVar = new au();
                                auVar.b(l);
                                j2 = com.tencent.mm.ui.gridviewheaders.a.cyc().b(new Date(auVar.field_createTime));
                                if (b != j2 && com.tencent.mm.ui.gridviewheaders.a.cyc().b(date) != j2) {
                                    linkedList2.add(new c(auVar.field_createTime));
                                    e.this.yQf = e.this.yQf + 1;
                                    b = j2;
                                } else if (linkedList.size() > 0 && linkedList2.size() == 0) {
                                    linkedList2.add(0, linkedList.remove(0));
                                }
                                linkedList2.add(new c(auVar));
                            } catch (Throwable th) {
                                if (l != null) {
                                    l.close();
                                }
                            }
                        }
                        if (l != null) {
                            l.close();
                        }
                    }
                    final int size = linkedList.size() + linkedList2.size();
                    e.this.jXe.addAll(0, linkedList2);
                    e.this.jXe.addAll(linkedList2.size(), linkedList);
                    linkedList.clear();
                    linkedList2.clear();
                    e.this.yQf = 0;
                    x.i("MicroMsg.MediaHistoryGalleryPresenter", "[loadData] %s", Integer.valueOf(e.this.jXe.size()));
                    ah.y(new Runnable() {
                        public final void run() {
                            e.this.yQk.yGP = false;
                            if (e.this.yQj != null) {
                                e.this.yQj.z(z, size);
                            }
                        }
                    });
                }
            });
            return;
        }
        x.i("MicroMsg.MediaHistoryGalleryPresenter", "[loadData] that's all msg :%s offset:%s", Integer.valueOf(this.mSW), Integer.valueOf(i));
    }
}
