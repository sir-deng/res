package com.tencent.mm.plugin.appbrand.debugger;

import android.content.Context;
import android.content.DialogInterface;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.q.d;
import com.tencent.mm.plugin.appbrand.q.f;
import com.tencent.mm.plugin.appbrand.q.g;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.protocal.c.bwx;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;
import java.util.Iterator;
import java.util.LinkedList;

public final class p extends FrameLayout {
    private g iTJ;
    ImageView iUA;
    ImageView iUB;
    View iUC;
    boolean iUD = false;
    private a iUE;
    private i iUF;
    ViewGroup iUq;
    RemoteDebugMoveView iUr;
    private LinkedList<String> iUs = new LinkedList();
    TextView iUt;
    TextView iUu;
    TextView iUv;
    TextView iUw;
    TextView iUx;
    TextView iUy;
    TextView iUz;
    OnClickListener mOnClickListener = new OnClickListener() {
        public final void onClick(View view) {
            p pVar = p.this;
            if (view.getId() == g.ixh) {
                pVar.iUD = true;
                pVar.show();
                RemoteDebugMoveView remoteDebugMoveView = pVar.iUr;
                remoteDebugMoveView.postDelayed(new Runnable() {
                    public final void run() {
                        if (RemoteDebugMoveView.this.getY() + ((float) RemoteDebugMoveView.this.getHeight()) > ((float) RemoteDebugMoveView.this.iTV)) {
                            RemoteDebugMoveView.this.setY((float) (RemoteDebugMoveView.this.iTV - RemoteDebugMoveView.this.getHeight()));
                        }
                    }
                }, 50);
            } else if (view.getId() == g.ixc) {
                pVar.iUD = false;
                pVar.show();
            } else if (view.getId() == g.ixj) {
                pVar.acQ();
            }
        }
    };

    /* renamed from: com.tencent.mm.plugin.appbrand.debugger.p$8 */
    class AnonymousClass8 implements Runnable {
        final /* synthetic */ int iUH;
        final /* synthetic */ bwx iUI;

        AnonymousClass8(int i, bwx bwx) {
            this.iUH = i;
            this.iUI = bwx;
        }

        public final void run() {
            p.a(p.this, "cmdId " + this.iUH + ", errCode " + this.iUI.fun);
        }
    }

    public interface a {
        void acF();
    }

    static /* synthetic */ void a(p pVar, String str) {
        pVar.iUs.add(0, str);
        while (pVar.iUs.size() > 10) {
            pVar.iUs.removeLast();
        }
        StringBuilder stringBuilder = new StringBuilder();
        Iterator it = pVar.iUs.iterator();
        while (it.hasNext()) {
            stringBuilder.append((String) it.next());
            stringBuilder.append("\n");
        }
        pVar.iUz.setText(stringBuilder.toString());
        if (pVar.iUD) {
            pVar.iUz.setVisibility(0);
        } else {
            pVar.iUz.setVisibility(8);
        }
    }

    static /* synthetic */ void h(p pVar) {
        if (pVar.iTJ.isBusy() || !pVar.iTJ.it()) {
            pVar.iUA.setImageResource(f.ivA);
            pVar.iUt.setText(pVar.getContext().getString(j.iDE));
            return;
        }
        pVar.iUA.setImageResource(f.ivB);
        pVar.iUt.setText(pVar.getContext().getString(j.iDF));
    }

    public p(Context context, g gVar, a aVar) {
        super(context);
        this.iTJ = gVar;
        this.iUE = aVar;
        setLayoutParams(new LayoutParams(-1, -1));
        setBackgroundColor(getContext().getResources().getColor(d.transparent));
        setId(g.ivX);
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (acP()) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public final void bringToFront() {
        if (this.iUq == null) {
            x.w("MicroMsg.RemoteDebugView", "bringoFront mContentView is null");
        } else {
            this.iUq.bringChildToFront(this);
        }
    }

    public final void acO() {
        ah.y(new Runnable() {
            public final void run() {
                if (p.this.iUq == null) {
                    x.w("MicroMsg.RemoteDebugView", "showDebugView mContentView is null");
                } else if (p.this.acP()) {
                    p.this.setVisibility(0);
                    if (p.this.iUq.indexOfChild(p.this) == -1) {
                        p.this.iUq.addView(p.this);
                    }
                    p.this.iUq.bringChildToFront(p.this);
                    p.this.setBackgroundColor(p.this.getContext().getResources().getColor(d.bsK));
                } else {
                    p.this.setBackgroundColor(p.this.getContext().getResources().getColor(d.transparent));
                }
            }
        });
    }

    private boolean acP() {
        if (!(this.iTJ.acC() || this.iTJ.acD())) {
            if (!(this.iTJ.getStatus() == 5)) {
                return false;
            }
        }
        return true;
    }

    final void acQ() {
        if (this.iUF == null || !this.iUF.isShowing()) {
            this.iUF = h.a(getContext(), getContext().getString(j.iDD), "", getContext().getString(j.dGf), getContext().getString(j.dEy), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    if (p.this.iUE != null) {
                        p.this.iUE.acF();
                    }
                }
            }, null);
        }
    }

    public final void acR() {
        ah.y(new Runnable() {
            public final void run() {
                if (p.this.iTJ.acC()) {
                    p.this.iUB.setImageResource(f.ivB);
                    p.this.iUu.setText(p.this.getContext().getString(j.iDA));
                } else if (p.this.iTJ.it()) {
                    p.this.iUB.setImageResource(f.ivB);
                    p.this.iUu.setText(p.this.getContext().getString(j.iDB));
                } else {
                    p.this.iUB.setImageResource(f.ivA);
                    p.this.iUu.setText(p.this.getContext().getString(j.iDz));
                }
                p.h(p.this);
            }
        });
    }

    public final void show() {
        if (this.iUD) {
            this.iUC.setVisibility(0);
            if (this.iUs.size() > 0) {
                this.iUz.setVisibility(0);
            } else {
                this.iUz.setVisibility(8);
            }
            this.iUx.setVisibility(8);
        } else {
            this.iUC.setVisibility(8);
            this.iUz.setVisibility(8);
            this.iUx.setVisibility(0);
        }
        invalidate();
    }

    public final void acS() {
        acO();
        acR();
    }

    public final void rG(final String str) {
        if (!bi.oN(str)) {
            ah.y(new Runnable() {
                public final void run() {
                    p.a(p.this, str);
                }
            });
        }
    }
}
