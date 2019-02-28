package com.tencent.mm.plugin.nearby.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Message;
import android.view.View;
import android.widget.CheckBox;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.ax.n;
import com.tencent.mm.be.l;
import com.tencent.mm.bl.d;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiScanCode;
import com.tencent.mm.plugin.nearby.a.c;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.o;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bj;
import com.tencent.mm.y.q;
import com.tencent.mm.y.s;
import java.util.Timer;
import java.util.TimerTask;
import junit.framework.Assert;

public final class a implements e, com.tencent.mm.pluginsdk.c.a, b {
    private static boolean oTW = true;
    private Context context;
    private f inW;
    private x jQP;
    private c oTT;
    private View oTU;
    private CheckBox oTV;
    private i oTX = null;
    private r tipDialog;

    /* renamed from: com.tencent.mm.plugin.nearby.ui.a$6 */
    static class AnonymousClass6 extends ag {
        final /* synthetic */ boolean kIh;
        final /* synthetic */ o kIi = null;

        AnonymousClass6(boolean z, o oVar) {
            this.kIh = z;
        }

        public final void handleMessage(Message message) {
            int i;
            int Gj = q.Gj();
            if (this.kIh) {
                i = Gj & -513;
            } else {
                i = Gj | WXMediaMessage.TITLE_LENGTH_LIMIT;
            }
            as.Hm();
            com.tencent.mm.y.c.Db().set(34, Integer.valueOf(i));
            as.Hm();
            com.tencent.mm.y.c.Fe().b(new n("", "", "", "", "", "", "", "", i, "", ""));
            if (!this.kIh) {
                l.TF().TA();
                as.CN().a(new c(2, 0.0f, 0.0f, 0, 0, "", ""), 0);
            }
            if (this.kIi != null) {
                this.kIi.a(null, null);
            }
        }
    }

    public a(Context context) {
        this.context = context;
        this.oTU = View.inflate(context, R.i.dmH, null);
        this.oTV = (CheckBox) this.oTU.findViewById(R.h.csL);
        this.oTV.setChecked(false);
        as.CN().a((int) JsApiScanCode.CTRL_INDEX, (e) this);
    }

    public final boolean ww(String str) {
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetLBS", "handleEvent : key = " + str);
        if (bi.oM(str).length() <= 0) {
            return false;
        }
        if (str.equals("contact_info_lbs_go_lbs")) {
            as.Hm();
            Boolean bool = (Boolean) com.tencent.mm.y.c.Db().get(4103, null);
            if (bool == null || !bool.booleanValue()) {
                d.y(this.context, "nearby", ".ui.NearbyFriendsIntroUI");
            } else {
                bj HX = bj.HX();
                if (HX == null) {
                    d.y(this.context, "nearby", ".ui.NearbyPersonalInfoUI");
                } else {
                    String oM = bi.oM(HX.getProvince());
                    String oM2 = bi.oM(HX.getCity());
                    int i = HX.fXa;
                    if (oM.equals("") || oM2.equals("") || i == 0) {
                        d.y(this.context, "nearby", ".ui.NearbyPersonalInfoUI");
                    } else {
                        as.Hm();
                        bool = (Boolean) com.tencent.mm.y.c.Db().get(4104, null);
                        if (bool == null || !bool.booleanValue()) {
                            com.tencent.mm.bj.a.dW(this.context);
                            ((Activity) this.context).finish();
                        } else if (this.oTX == null) {
                            this.oTX = h.a(this.context, this.context.getString(R.l.dGZ), this.oTU, new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    as.Hm();
                                    com.tencent.mm.y.c.Db().set(4104, Boolean.valueOf(!a.this.oTV.isChecked()));
                                    com.tencent.mm.bj.a.dW(a.this.context);
                                    ((Activity) a.this.context).finish();
                                }
                            }, new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                }
                            });
                        } else {
                            this.oTX.show();
                        }
                    }
                }
            }
            return true;
        } else if (str.equals("contact_info_lbs_install")) {
            g(this.context, true);
            return true;
        } else if (str.equals("contact_info_lbs_clear_info")) {
            h.a(this.context, R.l.exm, R.l.exl, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    a.this.oTT = new c(2, 0.0f, 0.0f, 0, 0, "", "");
                    as.CN().a(a.this.oTT, 0);
                    a aVar = a.this;
                    Context a = a.this.context;
                    a.this.context.getString(R.l.dGZ);
                    aVar.tipDialog = h.a(a, a.this.context.getString(R.l.exp), true, new OnCancelListener() {
                        public final void onCancel(DialogInterface dialogInterface) {
                            as.CN().c(a.this.oTT);
                        }
                    });
                }
            }, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            return true;
        } else if (str.equals("contact_info_lbs_uninstall")) {
            h.a(this.context, this.context.getString(R.l.eMR), "", this.context.getString(R.l.dEz), this.context.getString(R.l.dEy), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    a.g(a.this.context, false);
                }
            }, null);
            return true;
        } else {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ContactWidgetLBS", "handleEvent : unExpected key = " + str);
            return false;
        }
    }

    public final boolean a(f fVar, x xVar, boolean z, int i) {
        boolean z2 = false;
        Assert.assertTrue(fVar != null);
        if (xVar != null) {
            z2 = true;
        }
        Assert.assertTrue(z2);
        Assert.assertTrue(s.gV(xVar.field_username));
        as.Hm();
        com.tencent.mm.y.c.Db().a(this);
        com.tencent.mm.sdk.platformtools.x.v("MicroMsg.ContactWidgetLBS", "listener added");
        this.jQP = xVar;
        this.inW = fVar;
        oTW = true;
        fVar.addPreferencesFromResource(R.o.fbI);
        asy();
        return true;
    }

    private void asy() {
        int i;
        boolean z;
        boolean z2 = true;
        boolean z3 = (q.Gj() & WXMediaMessage.TITLE_LENGTH_LIMIT) == 0;
        HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.inW.Zu("contact_info_header_helper");
        helperHeaderPreference.af(this.jQP.field_username, this.jQP.AX(), this.context.getString(R.l.dVw));
        if (z3) {
            i = 1;
        } else {
            i = 0;
        }
        helperHeaderPreference.nP(i);
        this.inW.bl("contact_info_lbs_install", z3);
        f fVar = this.inW;
        String str = "contact_info_lbs_go_lbs";
        if (z3) {
            z = false;
        } else {
            z = true;
        }
        fVar.bl(str, z);
        fVar = this.inW;
        str = "contact_info_lbs_clear_info";
        if (z3) {
            z = false;
        } else {
            z = true;
        }
        fVar.bl(str, z);
        f fVar2 = this.inW;
        String str2 = "contact_info_lbs_uninstall";
        if (z3) {
            z2 = false;
        }
        fVar2.bl(str2, z2);
    }

    public static void g(Context context, boolean z) {
        String string = z ? context.getString(R.l.eMO) : context.getString(R.l.eMV);
        oTW = z;
        context.getString(R.l.dGZ);
        final r a = h.a(context, string, true, null);
        final ag anonymousClass6 = new AnonymousClass6(z, null);
        new Timer().schedule(new TimerTask() {
            public final void run() {
                if (a != null) {
                    a.dismiss();
                    anonymousClass6.sendEmptyMessage(0);
                }
            }
        }, 1500);
    }

    public final boolean asz() {
        as.Hm();
        com.tencent.mm.y.c.Db().b(this);
        as.CN().b((int) JsApiScanCode.CTRL_INDEX, (e) this);
        com.tencent.mm.plugin.nearby.a.ihO.un();
        return true;
    }

    public final void a(int i, m mVar, Object obj) {
        int p = bi.p(obj, 0);
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetLBS", "onNotifyChange event:%d obj:%d stg:%s", Integer.valueOf(i), Integer.valueOf(p), mVar);
        as.Hm();
        if (mVar != com.tencent.mm.y.c.Db() || p <= 0) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ContactWidgetLBS", "onNotifyChange error obj:%d stg:%s", Integer.valueOf(p), mVar);
        } else if (p == 40 || p == 34 || p == 7) {
            asy();
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (this.oTT != null || ((c) kVar).IY() != 2) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ContactWidgetLBS", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
            if (kVar.getType() == JsApiScanCode.CTRL_INDEX) {
                int i3;
                if (this.tipDialog != null) {
                    this.tipDialog.dismiss();
                    this.tipDialog = null;
                }
                if (i == 0 && i2 == 0) {
                    i3 = R.l.exo;
                } else {
                    i3 = R.l.exn;
                }
                if (((c) kVar).IY() == 2 && oTW) {
                    h.a(this.context, i3, R.l.dGZ, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    this.oTT = null;
                }
            }
        }
    }
}
