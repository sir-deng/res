package com.tencent.mm.ui.bindqq;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.os.Build.VERSION;
import android.view.View;
import android.widget.EditText;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.al;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.btu;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.y.as;

public final class b implements e {
    Context context;
    i pDT = null;
    private View pDU = null;
    SecurityImage xSF = null;
    r xXM = null;
    String xXT = "";
    private String xXV = "";
    private String xXW;
    private byte[] xXX = null;
    private a yvr;

    public interface a {
        void crs();

        boolean t(int i, int i2, String str);
    }

    class b extends com.tencent.mm.ui.applet.SecurityImage.b {
        b() {
        }

        public final void cox() {
            b.this.EP();
            as.CN().a(new al(5, b.this.xXT, b.this.xSF.xXV, b.this.xSF.cpt(), b.this.xSF.xXW, true, 1), 0);
        }
    }

    public b(Context context, a aVar) {
        this.context = context;
        this.yvr = aVar;
    }

    public final void EP() {
        as.CN().a(384, (e) this);
    }

    public final void onDetach() {
        as.CN().b(384, (e) this);
        if (this.yvr != null) {
            this.yvr.crs();
        }
    }

    public final void crt() {
        this.pDU = View.inflate(this.context, R.i.drY, null);
        final EditText editText = (EditText) this.pDU.findViewById(R.h.cLG);
        editText.setHint(R.l.dSv);
        this.pDT = h.a(this.context, this.context.getString(R.l.dSw), this.pDU, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                b.this.pDT = null;
                b bVar = b.this;
                String trim = editText.getText().toString().trim();
                bVar.EP();
                bVar.xXT = trim;
                Context context = bVar.context;
                bVar.context.getString(R.l.dGZ);
                bVar.xXM = h.a(context, bVar.context.getString(R.l.eKs), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        b.this.onDetach();
                    }
                });
                as.CN().a(new al(5, bVar.xXT, "", "", "", false, 1), 0);
            }
        }, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                b.this.pDT = null;
                b.this.onDetach();
            }
        });
    }

    @TargetApi(17)
    public final void a(int i, int i2, String str, k kVar) {
        onDetach();
        if (kVar != null && kVar.getType() == 384) {
            byte[] a;
            if (this.xXM != null) {
                this.xXM.dismiss();
                this.xXM = null;
            }
            this.xXV = n.a(((btu) ((al) kVar).gLB.hnR.hnY).wwh);
            al alVar = (al) kVar;
            if (((btu) alVar.gLB.hnR.hnY).vPT == null || ((btu) alVar.gLB.hnR.hnY).vPT.wRk <= 0) {
                a = n.a(((btu) alVar.gLB.hnR.hnY).vNQ);
            } else {
                a = g.Do().Cx().aQ(alVar.hpJ);
            }
            this.xXX = a;
            if (this.yvr == null || !this.yvr.t(i, i2, str)) {
                if (this.context instanceof Activity) {
                    Activity activity = (Activity) this.context;
                    if (!activity.isFinishing()) {
                        if (VERSION.SDK_INT >= 17 && activity.isDestroyed()) {
                            return;
                        }
                    }
                    return;
                }
                com.tencent.mm.g.a eC;
                if (i == 4) {
                    switch (i2) {
                        case -311:
                        case -310:
                        case -6:
                            if (!as.Hp()) {
                                return;
                            }
                            if (this.xSF == null) {
                                this.xSF = com.tencent.mm.ui.applet.SecurityImage.a.a(this.context, R.l.eEv, 0, this.xXX, this.xXV, this.xXW, new OnClickListener() {
                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                        final k alVar = new al(5, b.this.xXT, b.this.xSF.xXV, b.this.xSF.cpt(), b.this.xSF.xXW, true, 1);
                                        b.this.EP();
                                        as.CN().a(alVar, 0);
                                        b bVar = b.this;
                                        Context context = b.this.context;
                                        b.this.context.getString(R.l.dGZ);
                                        bVar.xXM = h.a(context, b.this.context.getString(R.l.etS), true, new OnCancelListener() {
                                            public final void onCancel(DialogInterface dialogInterface) {
                                                b.this.onDetach();
                                                as.CN().c(alVar);
                                            }
                                        });
                                    }
                                }, null, new OnDismissListener() {
                                    public final void onDismiss(DialogInterface dialogInterface) {
                                        b.this.xSF = null;
                                    }
                                }, new b());
                                return;
                            } else {
                                this.xSF.a(0, this.xXX, this.xXV, this.xXW);
                                return;
                            }
                        case -72:
                            this.pDT = h.h(this.context, R.l.dSx, R.l.dGZ);
                            return;
                        case -34:
                            this.pDT = h.b(this.context, this.context.getString(R.l.dMf), this.context.getString(R.l.dGZ), true);
                            return;
                        case -3:
                            this.pDT = h.a(this.context, this.context.getString(R.l.dQZ), this.context.getString(R.l.dGZ), new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    b.this.pDT = null;
                                    b.this.onDetach();
                                    b.this.crt();
                                }
                            }, null);
                            return;
                        default:
                            eC = com.tencent.mm.g.a.eC(str);
                            if (eC != null) {
                                eC.a(this.context, null, null);
                                return;
                            }
                            return;
                    }
                }
                eC = com.tencent.mm.g.a.eC(str);
                if (eC != null) {
                    eC.a(this.context, null, null);
                }
            }
        }
    }
}
