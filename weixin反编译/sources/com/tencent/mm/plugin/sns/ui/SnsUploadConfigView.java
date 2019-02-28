package com.tencent.mm.plugin.sns.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mm.ad.e;
import com.tencent.mm.bl.d;
import com.tencent.mm.f.a.fr;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.protocal.c.apl;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.i.a.a;
import com.tencent.mm.ui.i.a.b;
import com.tencent.mm.ui.i.a.c;
import com.tencent.mm.ui.v;
import com.tencent.mm.y.q;

public class SnsUploadConfigView extends LinearLayout implements e, a, b {
    private static String ffM = "com.tencent.mm";
    private Context context;
    private ProgressDialog nRI = null;
    boolean rLT = false;
    boolean rRA = false;
    private boolean rRB = false;
    private boolean rRC = true;
    private boolean rRD = false;
    apl rRE = new apl();
    com.tencent.mm.ui.i.a rRF = new com.tencent.mm.ui.i.a();
    ImageView rRv;
    ImageView rRw;
    ImageView rRx;
    private boolean rRy = false;
    boolean rRz = false;

    static /* synthetic */ void k(SnsUploadConfigView snsUploadConfigView) {
        x.e("MicroMsg.SnsUploadConfigView", "dealWithRefreshTokenFail");
        if (snsUploadConfigView.rRz) {
            String string = snsUploadConfigView.getContext().getString(j.dGZ);
            h.a(snsUploadConfigView.getContext(), snsUploadConfigView.getContext().getString(j.eey), string, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    Intent intent = new Intent();
                    intent.putExtra("is_force_unbind", true);
                    intent.putExtra("shake_music", true);
                    d.a(SnsUploadConfigView.this.getContext(), ".ui.account.FacebookAuthUI", intent, 8);
                }
            }, null);
        }
        snsUploadConfigView.rRz = false;
        snsUploadConfigView.iR(false);
    }

    public SnsUploadConfigView(final Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        this.context = context;
        View inflate = v.fw(context).inflate(g.qOk, this, true);
        this.rRv = (ImageView) inflate.findViewById(f.qLu);
        this.rRw = (ImageView) inflate.findViewById(f.qLw);
        this.rRx = (ImageView) inflate.findViewById(f.qLv);
        if (!com.tencent.mm.aq.b.PX()) {
            this.rRx.setVisibility(8);
        }
        if (!com.tencent.mm.aq.b.PZ()) {
            this.rRw.setVisibility(8);
        }
        if (!q.Gx()) {
            this.rRv.setVisibility(8);
        }
        this.rRx.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (SnsUploadConfigView.this.rRB || !SnsUploadConfigView.this.rLT) {
                    SnsUploadConfigView.this.rRB = !SnsUploadConfigView.this.rRB;
                    SnsUploadConfigView.this.bCK();
                    return;
                }
                h.h(context, j.qSq, j.dGZ);
            }
        });
        this.rRv.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                SnsUploadConfigView.this.rRz = !SnsUploadConfigView.this.rRz;
                if (SnsUploadConfigView.this.rRz) {
                    SnsUploadConfigView.this.rLT = false;
                }
                SnsUploadConfigView.this.iR(false);
            }
        });
        this.rRw.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                SnsUploadConfigView.this.rRA = !SnsUploadConfigView.this.rRA;
                if (SnsUploadConfigView.this.rRA) {
                    SnsUploadConfigView.this.rLT = false;
                }
                SnsUploadConfigView.this.bCL();
            }
        });
    }

    public final void bCJ() {
        this.rRy = false;
        this.rRz = false;
        this.rRA = false;
        this.rRB = false;
        this.rRx.setImageResource(i.qPn);
        this.rRv.setImageResource(i.qPh);
        this.rRw.setImageResource(i.qPr);
    }

    final void bCK() {
        if (this.rRB) {
            boolean z;
            com.tencent.mm.kernel.g.Dr();
            int e = bi.e((Integer) com.tencent.mm.kernel.g.Dq().Db().get(9, null));
            if (e == 0) {
                h.a(getContext(), j.eOi, j.dGZ, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        com.tencent.mm.plugin.sns.c.a.ihN.h(new Intent(), SnsUploadConfigView.this.context);
                    }
                }, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
            } else if (e != 0) {
                z = true;
                if (z) {
                    this.rRB = false;
                    return;
                } else {
                    this.rRx.setImageResource(i.qPo);
                    return;
                }
            }
            z = false;
            if (z) {
                this.rRx.setImageResource(i.qPo);
                return;
            } else {
                this.rRB = false;
                return;
            }
        }
        this.rRx.setImageResource(i.qPn);
    }

    final void iR(boolean z) {
        if (this.rRz) {
            boolean z2;
            if (q.Gz()) {
                z2 = true;
            } else {
                h.a(getContext(), j.eLD, j.dGZ, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        d.a(SnsUploadConfigView.this.getContext(), ".ui.account.FacebookAuthUI", new Intent().putExtra("shake_music", true));
                    }
                }, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                z2 = false;
            }
            if (z2) {
                if (!(z || this.rRD || !q.Gz())) {
                    final com.tencent.mm.sdk.b.b frVar = new fr();
                    frVar.frD = new Runnable() {
                        public final void run() {
                            if (!frVar.fvV.fqR) {
                                SnsUploadConfigView.k(SnsUploadConfigView.this);
                            }
                        }
                    };
                    com.tencent.mm.sdk.b.a.xmy.a(frVar, Looper.myLooper());
                }
                this.rRv.setImageResource(i.qPi);
                return;
            }
            this.rRz = false;
            return;
        }
        this.rRv.setImageResource(i.qPh);
    }

    final void bCL() {
        if (this.rRA) {
            boolean z;
            if (this.rRF.czn()) {
                z = true;
            } else {
                h.a(getContext(), j.eNS, j.dGZ, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        SnsUploadConfigView snsUploadConfigView = SnsUploadConfigView.this;
                        Context context = SnsUploadConfigView.this.getContext();
                        SnsUploadConfigView.this.getContext().getString(j.dGZ);
                        snsUploadConfigView.nRI = h.a(context, SnsUploadConfigView.this.getContext().getString(j.eRP), true, new OnCancelListener() {
                            public final void onCancel(DialogInterface dialogInterface) {
                            }
                        });
                        SnsUploadConfigView.this.rRF.a(SnsUploadConfigView.this, SnsUploadConfigView.this.getContext());
                    }
                }, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                z = false;
            }
            if (z) {
                this.rRw.setImageResource(i.qPs);
                return;
            } else {
                this.rRA = false;
                return;
            }
        }
        this.rRw.setImageResource(i.qPr);
    }

    public final int bCM() {
        if (this.rLT) {
            return 1;
        }
        return 0;
    }

    public final void iS(boolean z) {
        this.rLT = z;
        if (z) {
            bCJ();
        }
    }

    public final int bCN() {
        int i = 0;
        if (this.rRy) {
            i = 1;
        }
        if (this.rRz) {
            i |= 2;
        }
        if (this.rRA) {
            i |= 8;
        }
        if (this.rRB) {
            return i | 4;
        }
        return i;
    }

    private void rX(int i) {
        h.a(getContext(), i, j.dGZ, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        }, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
    }

    public final void a(int r1, int r2, java.lang.String r3, com.tencent.mm.ad.k r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = this;
        if (r1 != 0) goto L_0x0006;
    L_0x0002:
        if (r2 != 0) goto L_0x0006;
    L_0x0004:
        if (r4 != 0) goto L_0x0006;
    L_0x0006:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.ui.SnsUploadConfigView.a(int, int, java.lang.String, com.tencent.mm.ad.k):void");
    }

    public final void a(c cVar) {
        if (this.nRI != null) {
            this.nRI.cancel();
        }
        switch (cVar) {
            case Finished:
                this.rRA = true;
                rX(j.eRR);
                break;
            case Canceled:
                this.rRA = false;
                break;
            case Failed:
                this.rRA = false;
                rX(j.eRQ);
                break;
        }
        bCL();
    }

    public final void b(c cVar) {
        switch (cVar) {
            case Failed:
                this.rRA = false;
                break;
        }
        bCL();
    }
}
