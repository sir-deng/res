package com.tencent.mm.sandbox.updater;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ad.b;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.ax.q;
import com.tencent.mm.c.i;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.f.a.bf;
import com.tencent.mm.modelsimple.t;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.h.p;
import com.tencent.mm.pluginsdk.q.s;
import com.tencent.mm.protocal.c.aga;
import com.tencent.mm.protocal.c.agb;
import com.tencent.mm.protocal.c.ahj;
import com.tencent.mm.protocal.c.atf;
import com.tencent.mm.protocal.c.bph;
import com.tencent.mm.protocal.c.nw;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sandbox.a.a;
import com.tencent.mm.sandbox.monitor.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.y.as;
import com.tencent.mm.y.be;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public class Updater extends LinearLayout implements e, s {
    private boolean fpU;
    private int xku;
    private r xlA = null;
    private boolean xlB = false;
    private boolean xlC = false;
    private boolean xlD = false;
    private e xlE;
    private e xlF;

    static /* synthetic */ void a(Updater updater, Intent intent, com.tencent.mm.network.e eVar, a aVar) {
        intent.putExtra("intent_short_ips", bZV());
        intent.putExtra("intent_client_version", d.vHl);
        intent.putExtra("intent_extra_session", eVar.KD().CM());
        intent.putExtra("intent_extra_cookie", eVar.KD().Ky());
        intent.putExtra("intent_extra_ecdhkey", eVar.KD().KA());
        intent.putExtra("intent_extra_uin", eVar.KD().Cn());
        intent.putExtra("intent_update_type", updater.xku);
        intent.putExtra("intent_extra_desc", ((ahj) aVar.gLB.hnR.hnY).wvt);
        intent.putExtra("intent_extra_md5", aVar.ceQ());
        intent.putExtra("intent_extra_size", aVar.ceP());
        intent.putExtra("intent_extra_download_url", aVar.bYO());
        intent.putExtra("intent_extra_patchInfo", aVar.ceR());
        intent.putExtra("intent_extra_updateMode", f.fek);
        intent.putExtra("intent_extra_marketUrl", f.xmS);
        x.d("MicroMsg.NetSceneGetUpdateInfo", "summerupdate extInfo[%s], stack[%s]", bi.oM(n.b(((ahj) aVar.gLB.hnR.hnY).wvA)), bi.chl());
        intent.putExtra("intent_extra_extinfo", r0);
    }

    private Updater(Context context) {
        super(context);
    }

    public Updater(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void onStart() {
        as.CN().a(11, (e) this);
        g.pWK.a(405, 42, 1, true);
    }

    public final void onStop() {
        g.pWK.a(405, 43, 1, true);
        cancel();
    }

    public static Updater c(Context context, final OnCancelListener onCancelListener) {
        if (context == null) {
            return null;
        }
        if ((context instanceof Activity) && (((Activity) context).isFinishing() || ((Activity) context).getWindow() == null)) {
            x.e("MicroMsg.Updater", "showWithProgress, context isFinishing");
            return null;
        }
        ad.getContext().getSharedPreferences("system_config_prefs", 0).edit().putLong("recomended_update_ignore", bi.Wx()).commit();
        as.getNotification().cancel(34);
        x.i("MicroMsg.Updater", "showWithProgress");
        Updater updater = (Updater) View.inflate(context, R.i.dtz, null);
        updater.onStart();
        r a = r.a(context, context.getString(R.l.eSm), true, 0, null);
        a.setCancelable(true);
        a.setOnCancelListener(new OnCancelListener(updater) {
            final /* synthetic */ Updater xlG;

            public final void onCancel(DialogInterface dialogInterface) {
                as.getNotification().cancel(99);
                g.pWK.a(405, 47, 1, true);
                Updater.Dr(2);
                this.xlG.onStop();
                if (!this.xlG.xlB && onCancelListener != null) {
                    onCancelListener.onCancel(dialogInterface);
                }
            }
        });
        try {
            updater.xlA = a;
            updater.xlA.show();
            updater.fpU = true;
            g.pWK.a(405, 46, 1, true);
            return updater;
        } catch (Throwable e) {
            x.e("MicroMsg.Updater", "exception in showWithProgress, ", e.getMessage());
            x.printErrStackTrace("MicroMsg.Updater", e, "", new Object[0]);
            return null;
        }
    }

    public static Updater d(Context context, final OnCancelListener onCancelListener) {
        ad.getContext().getSharedPreferences("system_config_prefs", 0).edit().putLong("recomended_update_ignore", bi.Wx()).commit();
        as.getNotification().cancel(34);
        x.i("MicroMsg.Updater", "show update dialog");
        Updater updater = (Updater) View.inflate(context, R.i.dtz, null);
        updater.onStart();
        r a = r.a(context, "", true, 0, null);
        a.setCancelable(true);
        a.setOnCancelListener(new OnCancelListener(updater) {
            final /* synthetic */ Updater xlG;

            public final void onCancel(DialogInterface dialogInterface) {
                as.getNotification().cancel(99);
                g.pWK.a(405, 49, 1, true);
                Updater.Dr(2);
                this.xlG.onStop();
                if (!this.xlG.xlB && onCancelListener != null) {
                    onCancelListener.onCancel(dialogInterface);
                }
            }
        });
        g.pWK.a(405, 48, 1, true);
        updater.xlA = a;
        updater.fpU = false;
        return updater;
    }

    public static Updater eF(Context context) {
        ad.getContext().getSharedPreferences("system_config_prefs", 0).edit().putLong("recomended_update_ignore", bi.Wx()).commit();
        as.getNotification().cancel(34);
        g.pWK.a(405, 50, 1, true);
        x.i("MicroMsg.Updater", "updater silence");
        Updater updater = new Updater(context);
        updater.onStart();
        updater.xlC = true;
        return updater;
    }

    public static void dt(Context context) {
        context.startActivity(new Intent(context, AppInstallerUI.class));
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (i == 0 && i2 == 0) {
            g.pWK.a(405, 51, 1, true);
            x.i("MicroMsg.Updater", "isShow " + this.fpU);
            if (!(this.fpU || this.xlA == null)) {
                this.xlA.show();
            }
            this.xlB = true;
            if (this.xlA != null) {
                this.xlA.cancel();
            }
            final a aVar = (a) kVar;
            as.CN().a(new be(new be.a() {
                public final void a(final com.tencent.mm.network.e eVar) {
                    long j;
                    String bZL;
                    if (eVar == null) {
                        g.pWK.a(405, 52, 1, true);
                        Assert.assertTrue("updater invalid assert", false);
                    }
                    as.getNotification().cancel(34);
                    x.i("MicroMsg.Updater", "go to update");
                    if (!h.getExternalStorageState().equals("mounted")) {
                        x.e("MicroMsg.Updater", "no sdcard.");
                        g.pWK.a(405, 53, 1, true);
                        Updater.this.xlC = false;
                    }
                    int ceP = aVar.ceP();
                    i cj = i.cj(aVar.ceR());
                    String el = p.el(Updater.this.getContext());
                    i.a aVar = null;
                    if (cj != null) {
                        aVar = cj.ci(el);
                    }
                    if (aVar == null) {
                        j = (long) ceP;
                    } else {
                        j = (long) (aVar.size + ceP);
                    }
                    if (!com.tencent.mm.compatible.util.f.aD(j)) {
                        x.e("MicroMsg.Updater", "no enough space.");
                        g.pWK.a(405, 54, 1, true);
                        Updater.this.xlC = false;
                    }
                    if ((f.fek & 1) != 0) {
                        x.i("MicroMsg.Updater", "channel pack, not silence download.");
                        g.pWK.a(405, 55, 1, true);
                        Updater.this.xlC = false;
                    }
                    if (Updater.this.xku == 2 && !Updater.this.xlD) {
                        bZL = i.bZL();
                        if (!(c.Jg(aVar.ceQ()) == null || bi.oN(bZL) || !bZL.equals(aVar.ceQ()))) {
                            x.i("MicroMsg.Updater", "we already have this pack %s being to install, just ignore this update request", bZL);
                            g.pWK.a(405, 56, 1, true);
                            return;
                        }
                    }
                    ahj bYP = aVar.bYP();
                    if (bYP == null || bYP.wvx == 0 || bi.oN(bYP.wvy)) {
                        if (Updater.this.xlC) {
                            x.i("MicroMsg.Updater", "summerupdate gonna start UpdaterService checkcontrol");
                            g.pWK.a(405, 58, 1, true);
                            as.CN().a(725, Updater.this.xlE = new e() {
                                public final void a(int i, int i2, String str, k kVar) {
                                    as.CN().b(221, Updater.this.xlE);
                                    Updater.this.xlE = null;
                                    if (i == 0 && i2 == 0) {
                                        long j;
                                        t tVar = (t) kVar;
                                        if (((aga) tVar.hOJ.hnQ.hnY).kzz == 0) {
                                            String str2 = ((agb) tVar.hOJ.hnR.hnY).noL;
                                            if (!bi.oN(str2)) {
                                                Map y = bj.y(str2, "resourcecontrolinfo");
                                                if (y != null) {
                                                    str2 = (String) y.get(".resourcecontrolinfo.enableupdate");
                                                    String str3 = (String) y.get(".resourcecontrolinfo.expiredtime");
                                                    x.i("MicroMsg.NetSceneGetResourceControlInfo", "summerupdate getDisableUpdateTime values[%s]", y);
                                                    if (bi.getInt(str2, 1) == 0) {
                                                        j = bi.getLong(str3, 0);
                                                        if (j > System.currentTimeMillis() / 1000) {
                                                            x.i("MicroMsg.Updater", "summerupdate checkcontrol time[%d] > now[%d] control not auto download and ret", Long.valueOf(j), Long.valueOf(System.currentTimeMillis() / 1000));
                                                            g.pWK.a(405, 0, 1, true);
                                                            return;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        j = 0;
                                        if (j > System.currentTimeMillis() / 1000) {
                                            x.i("MicroMsg.Updater", "summerupdate checkcontrol time[%d] > now[%d] control not auto download and ret", Long.valueOf(j), Long.valueOf(System.currentTimeMillis() / 1000));
                                            g.pWK.a(405, 0, 1, true);
                                            return;
                                        }
                                    }
                                    x.i("MicroMsg.Updater", "summerupdate gonna start UpdaterService after checkcontrol");
                                    g.pWK.a(405, 59, 1, true);
                                    Intent intent = new Intent(Updater.this.getContext(), UpdaterService.class);
                                    Updater.a(Updater.this, intent, eVar, aVar);
                                    intent.putExtra("intent_extra_run_in_foreground", true);
                                    intent.putExtra("intent_extra_download_mode", 2);
                                    Updater.this.getContext().startService(intent);
                                }
                            });
                            as.CN().a(new t(), 0);
                        } else {
                            x.i("MicroMsg.Updater", "gonna start AppUpdaterUI");
                            Intent intent = new Intent(Updater.this.getContext(), AppUpdaterUI.class);
                            Updater.a(Updater.this, intent, eVar, aVar);
                            x.i("MicroMsg.Updater", "current updateType : %s", Integer.valueOf(Updater.this.xku));
                            if (Updater.this.xku == 1) {
                                intent.putExtra("intent_extra_download_mode", 0);
                                g.pWK.a(405, 60, 1, true);
                            } else {
                                g.pWK.a(405, 61, 1, true);
                                intent.putExtra("intent_extra_download_mode", 1);
                            }
                            Updater.this.getContext().startActivity(intent);
                        }
                        com.tencent.mm.r.c.Bx().o(262145, true);
                        com.tencent.mm.pluginsdk.model.app.a.bZn();
                        return;
                    }
                    bZL = bYP.wvy;
                    Intent intent2 = new Intent();
                    intent2.putExtra("rawUrl", bZL);
                    intent2.putExtra("showShare", false);
                    intent2.putExtra("show_bottom", false);
                    com.tencent.mm.bl.d.b(Updater.this.getContext(), "webview", ".ui.tools.WebViewUI", intent2);
                    i.cfj();
                    g.pWK.a(405, 57, 1, true);
                }
            }), 0);
            onStop();
            return;
        }
        g.pWK.a(405, 62, 1, true);
        if (this.xlA != null) {
            r rVar = this.xlA;
            if (rVar.kbr != null) {
                rVar.kbr.setVisibility(8);
            }
            final TextView textView = (TextView) this.xlA.findViewById(R.h.cwv);
            if (i == 4 && i2 == -18) {
                com.tencent.mm.sdk.b.a.xmy.m(new bf());
                com.tencent.mm.ad.n CN = as.CN();
                e anonymousClass4 = new e() {
                    public final void a(int i, int i2, String str, k kVar) {
                        as.CN().b(922, Updater.this.xlF);
                        Updater.this.xlE = null;
                        if (i == 0 && i2 == 0) {
                            bph bph = ((nw) ((b) kVar.hoq).hnR.hnY).wdz;
                            if (bph == null || bph.wYz != 3) {
                                if (Updater.this.xlA.findViewById(R.h.cwu) != null) {
                                    Updater.this.xlA.findViewById(R.h.cwu).setVisibility(8);
                                }
                                if (textView != null) {
                                    g.pWK.a(405, 63, 1, true);
                                    textView.setText(R.l.eSr);
                                    return;
                                }
                                return;
                            }
                            Intent intent = new Intent(Updater.this.getContext(), AppUpdaterUI.class);
                            Updater.a(intent, new e(bph));
                            Updater.this.getContext().startActivity(intent);
                            if (Updater.this.xlA != null) {
                                Updater.this.xlA.cancel();
                            }
                            Updater.this.onStop();
                            return;
                        }
                        if (Updater.this.xlA.findViewById(R.h.cwu) != null) {
                            Updater.this.xlA.findViewById(R.h.cwu).setVisibility(8);
                        }
                        if (textView != null) {
                            g.pWK.a(405, 63, 1, true);
                            textView.setText(R.l.eSr);
                        }
                    }
                };
                this.xlF = anonymousClass4;
                CN.a(922, anonymousClass4);
            } else if (textView != null) {
                g.pWK.a(405, 64, 1, true);
                textView.setText(R.l.eSh);
                com.tencent.mm.pluginsdk.ui.d.i.f(textView, 1);
            }
        }
        i.cfn();
        cancel();
    }

    public static void a(Intent intent, e eVar) {
        String str;
        intent.putExtra("intent_short_ips", bZV());
        intent.putExtra("intent_client_version", d.vHl);
        intent.putExtra("intent_update_type", 3);
        String str2 = "intent_extra_desc";
        boolean z = (eVar.nGS == null || eVar.nGS.isEmpty() || !eVar.nGS.containsKey(Integer.valueOf(4))) ? false : true;
        if (z) {
            HashMap hashMap = eVar.nGS;
            if (hashMap == null || hashMap.isEmpty()) {
                str = "";
            } else {
                str = "";
                LinkedList linkedList = (LinkedList) hashMap.get(Integer.valueOf(4));
                if (linkedList != null && !linkedList.isEmpty()) {
                    int size = linkedList.size();
                    int i = 0;
                    while (i < size) {
                        String str3;
                        atf atf = (atf) linkedList.get(i);
                        if (atf.lang.equalsIgnoreCase("default")) {
                            str3 = new String(Base64.decode(atf.content, 0));
                        } else if (atf.lang.equalsIgnoreCase(w.cfV())) {
                            str = new String(Base64.decode(atf.content, 0));
                            break;
                        } else {
                            str3 = str;
                        }
                        i++;
                        str = str3;
                    }
                }
            }
        } else {
            str = "";
        }
        intent.putExtra(str2, str);
        intent.putExtra("intent_extra_md5", eVar.nGW);
        intent.putExtra("intent_extra_size", eVar.fileSize);
        intent.putExtra("intent_extra_download_url", new String[]{eVar.nGV});
        intent.putExtra("intent_extra_patchInfo", eVar.cfe());
        intent.putExtra("intent_extra_updateMode", f.fek);
        intent.putExtra("intent_extra_marketUrl", f.xmS);
        intent.putExtra("intent_extra_extinfo", "<extinfo></extinfo>");
        intent.putExtra("intent_extra_tinker_patch", true);
        intent.putExtra("intent_extra_download_mode", 1);
    }

    private void cancel() {
        as.CN().b(11, (e) this);
    }

    private static String[] bZV() {
        int i = 0;
        if (com.tencent.mm.platformtools.r.ifw == null || com.tencent.mm.platformtools.r.ifw.length() <= 0) {
            String string = ad.getContext().getSharedPreferences("system_config_prefs", 0).getString("builtin_short_ips", "");
            if (string == null || string.length() <= 0) {
                string = "0,112.64.200.240,80|0,180.153.82.27,80|0,117.135.130.177,80";
            }
            List TT = com.tencent.mm.protocal.n.TT(string);
            String[] strArr = new String[TT.size()];
            while (i < TT.size()) {
                strArr[i] = ((com.tencent.mm.protocal.n) TT.get(i)).nWa;
                i++;
            }
            return strArr;
        }
        return new String[]{com.tencent.mm.platformtools.r.ifw};
    }

    public final void update(int i) {
        ac(i, false);
    }

    public final void ac(int i, boolean z) {
        x.i("MicroMsg.Updater", "summerupdate begin update routine, type=" + i);
        this.xku = i;
        this.xlD = z;
        g.pWK.a(405, 44, 1, true);
        as.CN().a(new a(i), 0);
    }

    public static void c(String str, int i, String str2, String str3) {
        Intent intent = new Intent(ad.getContext(), UpdaterService.class);
        intent.putExtra("intent_client_version", d.vHl);
        intent.putExtra("intent_update_type", 4);
        intent.putExtra("intent_extra_desc", str2);
        intent.putExtra("intent_extra_md5", str);
        intent.putExtra("intent_extra_size", i);
        intent.putExtra("intent_extra_download_url", new String[]{str3});
        intent.putExtra("intent_extra_updateMode", f.fek);
        intent.putExtra("intent_extra_marketUrl", f.xmS);
        intent.putExtra("intent_extra_run_in_foreground", true);
        intent.putExtra("intent_extra_download_mode", 2);
        g.pWK.a(405, 45, 1, true);
        ad.getContext().startService(intent);
    }

    public static void Dr(int i) {
        if (as.Hp()) {
            x.d("MicroMsg.Updater", "reportUpdateStat : opCode = " + i);
            as.Hm();
            com.tencent.mm.y.c.Fe().b(new q(i));
        }
    }
}
