package com.tencent.mm.ui.chatting.e;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.g;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.q;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.f.a.cg;
import com.tencent.mm.pluginsdk.ui.tools.p;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.a.b.f;
import com.tencent.mm.ui.chatting.ac;
import com.tencent.mm.ui.chatting.c.b.a;
import com.tencent.mm.ui.chatting.j;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bb;
import com.tencent.mm.y.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public abstract class b implements f, a {
    protected ArrayList<com.tencent.mm.ui.chatting.a.b.b> jXe = null;
    protected String jXh;
    protected Context mContext;
    private boolean vGb = false;
    private long yMJ = 0;
    protected com.tencent.mm.ui.chatting.c.b.b yPU;
    com.tencent.mm.ui.chatting.a.b yPV;
    private LinearLayoutManager yPW;
    protected ArrayList<com.tencent.mm.ui.chatting.a.b.b> yPX = null;

    public final /* bridge */ /* synthetic */ void a(com.tencent.mm.ui.chatting.h.a aVar) {
        com.tencent.mm.ui.chatting.c.b.b bVar = (com.tencent.mm.ui.chatting.c.b.b) aVar;
        this.yPU = bVar;
        bVar.a(this);
    }

    public final /* synthetic */ h fN(Context context) {
        if (this.yPW == null) {
            this.yPW = new LinearLayoutManager();
        }
        return this.yPW;
    }

    public b(Context context) {
        this.mContext = context;
        this.jXe = new ArrayList();
    }

    public final void onDetach() {
        this.yPU.a(null);
        this.yPU = null;
        if (this.yPV != null) {
            com.tencent.mm.ui.chatting.a.b.yHc = null;
            com.tencent.mm.ui.chatting.a.b.yHd = null;
        }
    }

    public final g cve() {
        return new g() {
            int hX = ((int) b.this.mContext.getResources().getDimension(R.f.bup));
            int yPY = b.this.mContext.getResources().getColor(R.e.bsl);
            ColorDrawable yPZ = new ColorDrawable(this.yPY);

            public final void a(Canvas canvas, RecyclerView recyclerView, q qVar) {
                int paddingLeft = recyclerView.getPaddingLeft();
                int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
                int childCount = recyclerView.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = recyclerView.getChildAt(i);
                    if (childAt.getTag() != null) {
                        com.tencent.mm.ui.chatting.a.b.b FW = b.this.FW(((Integer) childAt.getTag()).intValue() + 1);
                        if (FW == null || FW.getType() != Integer.MAX_VALUE) {
                            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                            int bottom = layoutParams.bottomMargin + childAt.getBottom();
                            this.yPZ.setBounds(paddingLeft, bottom, width, this.hX + bottom);
                            this.yPZ.draw(canvas);
                        }
                    }
                }
            }
        };
    }

    public final com.tencent.mm.ui.chatting.a.b.b FW(int i) {
        if (this.jXe == null || this.jXe.size() <= i) {
            return null;
        }
        return (com.tencent.mm.ui.chatting.a.b.b) this.jXe.get(i);
    }

    public final RecyclerView.a ZT(String str) {
        this.jXh = str;
        this.yPV = new com.tencent.mm.ui.chatting.a.b(this.mContext, this);
        com.tencent.mm.ui.chatting.a.b.yHc = cvg();
        return this.yPV;
    }

    public final int getCount() {
        if (this.jXe == null) {
            return 0;
        }
        return this.jXe.size();
    }

    public final p.a cvh() {
        return new p.a() {
            private al ljB = new al(as.Dt().oFY.getLooper(), new al.a() {
                public final boolean uG() {
                    String str = "MicroMsg.BaseHistoryListPresenter";
                    String str2 = "[onTimerExpired]  mDataListCache is null?:%s mSearchText is null?:%s";
                    Object[] objArr = new Object[2];
                    objArr[0] = Boolean.valueOf(b.this.yPX == null);
                    objArr[1] = Boolean.valueOf(bi.oN(AnonymousClass2.this.yHe));
                    x.i(str, str2, objArr);
                    if (bi.oN(AnonymousClass2.this.yHe)) {
                        b.this.yPV.yHe = AnonymousClass2.this.yHe;
                        if (b.this.yPX == null) {
                            b.this.cvf();
                        } else {
                            b.this.jXe = b.this.yPX;
                            ah.y(new Runnable() {
                                public final void run() {
                                    b.this.yPU.bo(AnonymousClass2.this.yHe, false);
                                    b.this.yPV.UR.notifyChanged();
                                }
                            });
                        }
                    } else {
                        b.this.jXe = b.this.yPX;
                        ArrayList arrayList = new ArrayList();
                        Iterator it = b.this.jXe.iterator();
                        while (it.hasNext()) {
                            com.tencent.mm.ui.chatting.a.b.b bVar = (com.tencent.mm.ui.chatting.a.b.b) it.next();
                            if (bVar.ZM(AnonymousClass2.this.yHe)) {
                                arrayList.add(bVar);
                            }
                        }
                        b.this.jXe = arrayList;
                        b.this.yPV.yHe = AnonymousClass2.this.yHe;
                        ah.y(new Runnable() {
                            public final void run() {
                                b.this.yPV.UR.notifyChanged();
                                b.this.yPU.bo(AnonymousClass2.this.yHe, b.this.jXe.isEmpty());
                            }
                        });
                    }
                    return false;
                }
            }, false);
            String yHe = "";

            public final void asZ() {
            }

            public final void ata() {
            }

            public final void a(boolean z, String[] strArr, long j, int i) {
            }

            public final void XB() {
            }

            public final void XA() {
                x.d("MicroMsg.BaseHistoryListPresenter", "onQuitSearch");
                if (b.this.yPU != null) {
                    b.this.yPU.onFinish();
                }
            }

            public final void pd(String str) {
                if (!this.yHe.equals(str)) {
                    this.yHe = str;
                    this.ljB.TN();
                    this.ljB.K(500, 500);
                }
            }

            public final boolean pc(String str) {
                return false;
            }

            public final void XC() {
            }

            public final void XD() {
                x.i("MicroMsg.BaseHistoryListPresenter", "onSearchEditTextReady");
            }
        };
    }

    protected static String g(au auVar, boolean z) {
        String str = null;
        if (auVar == null) {
            return null;
        }
        if (auVar.field_isSend == 1) {
            return com.tencent.mm.y.q.FY();
        }
        if (z) {
            str = bb.hS(auVar.field_content);
        }
        if (bi.oN(str)) {
            return auVar.field_talker;
        }
        return str;
    }

    public final void d(int i, final au auVar) {
        x.i("MicroMsg.BaseHistoryListPresenter", "[handleSelectedItem] index:%s", Integer.valueOf(i));
        switch (i) {
            case 0:
                com.tencent.mm.plugin.report.service.g.pWK.a(219, 19, 1, true);
                boolean endsWith = this.jXh.toLowerCase().endsWith("@chatroom");
                List arrayList = new ArrayList(1);
                arrayList.add(auVar);
                j.a(this.mContext, arrayList, endsWith, this.jXh, new ac() {
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
                return;
            case 1:
                com.tencent.mm.sdk.b.b cgVar = new cg();
                List arrayList2 = new ArrayList(1);
                arrayList2.add(auVar);
                if (com.tencent.mm.pluginsdk.model.h.a(this.mContext, cgVar, this.jXh, arrayList2, false, false)) {
                    cgVar.frk.frr = 45;
                    cgVar.frk.activity = (Activity) this.mContext;
                    com.tencent.mm.sdk.b.a.xmy.m(cgVar);
                    if (cgVar.frl.ret != -2 && cgVar.frl.ret <= 0 && cgVar.frl.ret <= 0) {
                        if (14 != cgVar.frk.type) {
                            x.d("MicroMsg.BaseHistoryListPresenter", "not record type, do not report");
                            return;
                        } else if (cgVar.frk.frn == null) {
                            x.e("MicroMsg.BaseHistoryListPresenter", "want to report record fav, but type count is null");
                            return;
                        } else {
                            com.tencent.mm.plugin.report.service.g.pWK.h(11142, Integer.valueOf(cgVar.frk.frn.wmo), Integer.valueOf(cgVar.frk.frn.wmp), Integer.valueOf(cgVar.frk.frn.wmq), Integer.valueOf(cgVar.frk.frn.wmr), Integer.valueOf(cgVar.frk.frn.wms), Integer.valueOf(cgVar.frk.frn.wmt), Integer.valueOf(cgVar.frk.frn.wmu), Integer.valueOf(cgVar.frk.frn.wmv), Integer.valueOf(cgVar.frk.frn.wmw), Integer.valueOf(cgVar.frk.frn.wmx), Integer.valueOf(cgVar.frk.frn.wmy), Integer.valueOf(cgVar.frk.frn.wmz), Integer.valueOf(cgVar.frk.frn.wmA), Integer.valueOf(cgVar.frk.frn.wmB), Integer.valueOf(cgVar.frk.frn.wmC));
                            return;
                        }
                    }
                    return;
                }
                x.e("MicroMsg.BaseHistoryListPresenter", "[handleFav] err!");
                return;
            case 2:
                com.tencent.mm.plugin.report.service.g.pWK.h(11627, Integer.valueOf(5));
                final Set treeSet = new TreeSet();
                treeSet.add(Long.valueOf(auVar.field_msgId));
                com.tencent.mm.ui.base.h.a(this.mContext, this.mContext.getString(R.l.dUg), "", this.mContext.getString(R.l.dYG), this.mContext.getString(R.l.dEy), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        x.i("MicroMsg.BaseHistoryListPresenter", "delete message");
                        com.tencent.mm.ui.chatting.h.a(b.this.mContext, treeSet, new ac() {
                            public final void csH() {
                            }

                            public final void a(ac.a aVar) {
                                if (aVar == ac.a.del) {
                                    com.tencent.mm.ui.chatting.a.b.b anonymousClass1 = new com.tencent.mm.ui.chatting.a.b.b() {
                                        public final int getType() {
                                            return -1;
                                        }
                                    };
                                    anonymousClass1.frh = auVar.field_msgId;
                                    b.this.jXe.remove(anonymousClass1);
                                    b.this.yPX.remove(anonymousClass1);
                                }
                            }

                            public final void b(ac.a aVar) {
                                x.i("MicroMsg.BaseHistoryListPresenter", "[requestExitSelectedMode] %s del ", Thread.currentThread(), aVar);
                                if (aVar == ac.a.del) {
                                    b.this.yPV.UR.notifyChanged();
                                }
                            }

                            public final boolean csI() {
                                return true;
                            }
                        });
                    }
                }, null);
                return;
            default:
                return;
        }
    }

    protected final boolean cwf() {
        long j = this.yMJ + 30000;
        long currentTimeMillis = System.currentTimeMillis();
        this.yMJ = currentTimeMillis;
        if (j < currentTimeMillis) {
            as.Hm();
            this.vGb = c.isSDCardAvailable();
        }
        return this.vGb;
    }
}
