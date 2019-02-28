package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.order.model.MallOrderDetailObject.HelpCenter;
import com.tencent.mm.plugin.order.model.MallTransactionObject;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.wallet_core.ui.c;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class a implements com.tencent.mm.plugin.order.model.a.a {
    public c pio;

    static /* synthetic */ void a(Context context, String str, MallTransactionObject mallTransactionObject) {
        String aD;
        Intent intent = new Intent();
        Uri parse = Uri.parse(str);
        String str2 = mallTransactionObject.fvD;
        String deviceID = q.getDeviceID(context);
        String str3 = "bssid";
        String str4 = d.DEVICE_TYPE;
        String str5 = Build.MODEL;
        String za = q.za();
        WifiManager wifiManager = (WifiManager) ad.getContext().getSystemService("wifi");
        if (wifiManager != null) {
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            if (connectionInfo != null) {
                aD = bi.aD(connectionInfo.getBSSID(), "");
                x.i("MicroMsg.DefaultOrderPrefFactory", "new url %s", parse.buildUpon().appendQueryParameter("trans_id", str2).appendQueryParameter("deviceid", deviceID).appendQueryParameter("bssid", aD).appendQueryParameter("deviceType", str4).appendQueryParameter("deviceName", str5).appendQueryParameter("ostype", za).build().toString());
                intent.putExtra("rawUrl", aD);
                intent.putExtra("geta8key_username", com.tencent.mm.y.q.FY());
                com.tencent.mm.bl.d.b(context, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
            }
        }
        aD = str3;
        x.i("MicroMsg.DefaultOrderPrefFactory", "new url %s", parse.buildUpon().appendQueryParameter("trans_id", str2).appendQueryParameter("deviceid", deviceID).appendQueryParameter("bssid", aD).appendQueryParameter("deviceType", str4).appendQueryParameter("deviceName", str5).appendQueryParameter("ostype", za).build().toString());
        intent.putExtra("rawUrl", aD);
        intent.putExtra("geta8key_username", com.tencent.mm.y.q.FY());
        com.tencent.mm.bl.d.b(context, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
    }

    public final List<Preference> a(final Context context, final f fVar, final MallTransactionObject mallTransactionObject) {
        Object obj;
        CharSequence string;
        f fVar2;
        com.tencent.mm.k.a Xv;
        String AX;
        f fVar3;
        String string2;
        h hVar;
        List<Preference> arrayList = new ArrayList();
        if (mallTransactionObject.fjM == 2) {
            obj = 1;
        } else {
            obj = null;
        }
        if (!(bi.oN(mallTransactionObject.pgh) || bi.oN(mallTransactionObject.iRs))) {
            d dVar = new d(context);
            dVar.lXl = mallTransactionObject.iRs;
            dVar.mName = mallTransactionObject.pgh;
            dVar.mOnClickListener = new OnClickListener() {
                public final void onClick(View view) {
                    if (!bi.oN(mallTransactionObject.pgg)) {
                        e.S(context, mallTransactionObject.pgg);
                    }
                }
            };
            arrayList.add(dVar);
            arrayList.add(new PreferenceSmallCategory(context));
        }
        i iVar = new i(context);
        iVar.piO = e.d(mallTransactionObject.loS, mallTransactionObject.pgf);
        if (obj != null) {
            string = context.getString(i.uZJ);
        } else if (mallTransactionObject.pfQ == 11) {
            string = context.getString(i.vaj);
        } else {
            string = context.getString(i.uZI);
        }
        iVar.setTitle(string);
        if (!bi.oN(mallTransactionObject.pfX)) {
            iVar.HU(mallTransactionObject.pfX);
        }
        arrayList.add(iVar);
        boolean z = false;
        if (mallTransactionObject.loS != mallTransactionObject.pgl) {
            h hVar2 = new h(context);
            hVar2.piL = false;
            hVar2.piM = true;
            arrayList.add(hVar2);
            fVar2 = new f(context);
            fVar2.setContent(e.d(mallTransactionObject.pgl, mallTransactionObject.pgf));
            fVar2.setTitle(i.vab);
            arrayList.add(fVar2);
            z = true;
        }
        if (!(mallTransactionObject.loS == mallTransactionObject.pgl || bi.oN(mallTransactionObject.pgk))) {
            g gVar = new g(context);
            gVar.setTitle(i.uZQ);
            gVar.jPY = fVar;
            String[] split = mallTransactionObject.pgk.split("\n");
            if (split.length == 1) {
                gVar.piE = split[0];
            } else {
                gVar.piE = context.getString(i.uZR, new Object[]{Integer.valueOf(split.length), e.d(mallTransactionObject.pgl - mallTransactionObject.loS, mallTransactionObject.pgf)});
                gVar.a(split, TruncateAt.MIDDLE);
            }
            arrayList.add(gVar);
        }
        h hVar3 = new h(context);
        hVar3.piL = z;
        hVar3.piM = true;
        arrayList.add(hVar3);
        if (obj == null && !bi.oN(mallTransactionObject.pgu)) {
            g.Dr();
            Xv = ((h) g.h(h.class)).Ff().Xv(mallTransactionObject.pgu);
            if (Xv != null && ((int) Xv.gKO) > 0) {
                AX = Xv.AX();
                fVar3 = new f(context);
                fVar3.setTitle(i.uGe);
                fVar3.setContent(AX);
                arrayList.add(fVar3);
            }
        }
        if (!(mallTransactionObject.pfQ != 31 || obj == null || bi.oN(mallTransactionObject.pgB))) {
            g.Dr();
            Xv = ((h) g.h(h.class)).Ff().Xv(mallTransactionObject.pgB);
            if (Xv != null && ((int) Xv.gKO) > 0) {
                AX = Xv.AX();
                fVar3 = new f(context);
                fVar3.setTitle(i.uZZ);
                fVar3.setContent(AX);
                arrayList.add(fVar3);
            }
        }
        if (!bi.oN(mallTransactionObject.desc)) {
            if (obj != null) {
                fVar2 = new f(context);
                if (mallTransactionObject.pfQ == 32 || mallTransactionObject.pfQ == 33 || mallTransactionObject.pfQ == 31) {
                    fVar2.setTitle(i.uZN);
                } else {
                    fVar2.setTitle(i.uZZ);
                }
                fVar2.setContent(mallTransactionObject.desc);
                arrayList.add(fVar2);
            } else {
                fVar2 = new f(context);
                if (mallTransactionObject.pfQ == 31) {
                    fVar2.setTitle(i.vaf);
                } else {
                    fVar2.setTitle(i.uFM);
                }
                if (bi.oN(mallTransactionObject.pfV)) {
                    fVar2.setContent(mallTransactionObject.desc);
                } else {
                    string2 = context.getString(i.uZM);
                    fVar2.a(mallTransactionObject.desc + " " + string2, mallTransactionObject.desc.length() + 1, string2.length() + (mallTransactionObject.desc.length() + 1), new OnClickListener() {
                        public final void onClick(View view) {
                            fVar2.setContent(mallTransactionObject.desc + "\n" + mallTransactionObject.pfV);
                            fVar.notifyDataSetChanged();
                        }
                    });
                }
                arrayList.add(fVar2);
            }
        }
        if (!bi.oN(mallTransactionObject.pgF)) {
            fVar2 = new f(context);
            fVar2.setTitle(i.uGm);
            fVar2.setContent(mallTransactionObject.pgF);
            arrayList.add(fVar2);
        }
        if (!bi.oN(mallTransactionObject.pgE)) {
            fVar2 = new f(context);
            fVar2.setTitle(i.vau);
            fVar2.setContent(mallTransactionObject.pgE);
            arrayList.add(fVar2);
        }
        if (!TextUtils.isEmpty(mallTransactionObject.pgw)) {
            fVar2 = new f(context);
            fVar2.setTitle(i.uZL);
            fVar2.setContent(mallTransactionObject.pgw);
            arrayList.add(fVar2);
        }
        if (!bi.oN(mallTransactionObject.pfU)) {
            fVar2 = new f(context);
            fVar2.setTitle(i.vaa);
            fVar2.setContent(mallTransactionObject.pfU);
            arrayList.add(fVar2);
        }
        if (!bi.oN(mallTransactionObject.pfZ)) {
            fVar2 = new f(context);
            fVar2.setTitle(i.vam);
            if (mallTransactionObject.pfQ != 31 || com.tencent.mm.y.q.FY().equals(mallTransactionObject.pgu) || mallTransactionObject.pgv <= 0 || bi.oN(mallTransactionObject.pgu) || bi.oN(mallTransactionObject.fvD)) {
                fVar2.setContent(mallTransactionObject.pfZ);
                if (!bi.oN(mallTransactionObject.pga)) {
                    fVar2.HT(mallTransactionObject.pga);
                }
            } else {
                string2 = context.getString(i.uUF);
                fVar2.a(mallTransactionObject.pfZ + " " + string2, mallTransactionObject.pfZ.length() + 1, (string2.length() + mallTransactionObject.pfZ.length()) + 1, new OnClickListener() {
                    public final void onClick(View view) {
                        com.tencent.mm.ui.base.h.a(context, context.getString(i.uTH), context.getString(i.dGE), context.getString(i.uUE), context.getString(i.dEy), new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent();
                                intent.putExtra("transaction_id", mallTransactionObject.fvD);
                                intent.putExtra("receiver_name", mallTransactionObject.pgu);
                                intent.putExtra("resend_msg_from_flag", 1);
                                com.tencent.mm.bl.d.b(context, "remittance", ".ui.RemittanceResendMsgUI", intent);
                            }
                        }, new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                            }
                        });
                    }
                });
            }
            arrayList.add(fVar2);
        }
        fVar2 = new f(context);
        fVar2.setTitle(i.uZP);
        fVar2.setContent(e.gT(mallTransactionObject.hBH));
        arrayList.add(fVar2);
        if (!bi.oN(mallTransactionObject.pgd)) {
            f fVar4 = new f(context);
            fVar4.setTitle(i.vac);
            AX = mallTransactionObject.pgd;
            if (!bi.oN(mallTransactionObject.pge)) {
                AX = AX + "(" + mallTransactionObject.pge + ")";
            }
            fVar4.setContent(AX);
            arrayList.add(fVar4);
        }
        if (!bi.oN(mallTransactionObject.fvD)) {
            fVar2 = new f(context);
            fVar2.setTitle(i.uGk);
            fVar2.setContent(mallTransactionObject.fvD);
            arrayList.add(fVar2);
        }
        if (!bi.oN(mallTransactionObject.pgc)) {
            fVar2 = new f(context);
            fVar2.setTitle(i.vak);
            if (mallTransactionObject.pfQ == 8) {
                fVar2.setContent(context.getString(i.val));
                c cVar = new c(context);
                final Bitmap b = com.tencent.mm.br.a.a.b(context, mallTransactionObject.pgc, 5, 0);
                cVar.piw = e.abo(mallTransactionObject.pgc);
                cVar.hmD = b;
                cVar.mOnClickListener = new OnClickListener() {
                    public final void onClick(View view) {
                        if (a.this.pio != null) {
                            a aVar = a.this;
                            Bitmap bitmap = b;
                            String str = mallTransactionObject.pgc;
                            if (aVar.pio != null) {
                                aVar.pio.fY(str, str);
                                aVar.pio.pdu = bitmap;
                                aVar.pio.pdv = bitmap;
                                aVar.pio.cCM();
                            }
                            a.this.pio.u(view, true);
                        }
                    }
                };
                arrayList.add(fVar2);
                arrayList.add(cVar);
            } else {
                fVar2.setContent(mallTransactionObject.pgc);
                arrayList.add(fVar2);
            }
        }
        Object obj2 = mallTransactionObject.pfF.size() == 0 ? null : 1;
        if (obj2 != null || (bi.oN(mallTransactionObject.pgp) && bi.oN(mallTransactionObject.pgg) && bi.oN(mallTransactionObject.pfI))) {
            hVar = new h(context);
            hVar.piL = true;
            hVar.kjW = false;
            arrayList.add(hVar);
        } else {
            hVar = new h(context);
            hVar.piL = true;
            arrayList.add(hVar);
            arrayList.add(com.tencent.mm.plugin.order.model.a.a(context, mallTransactionObject));
        }
        if (obj2 != null) {
            j jVar = new j(context);
            if (mallTransactionObject.pfG == 1) {
                if (!(bi.oN(mallTransactionObject.pgp) && bi.oN(mallTransactionObject.pgg) && bi.oN(mallTransactionObject.pfI))) {
                    if (bi.oN(mallTransactionObject.pgq)) {
                        jVar.piP = context.getString(i.vaq);
                    } else {
                        jVar.piP = mallTransactionObject.pgq;
                    }
                    jVar.piQ = new OnClickListener() {
                        public final void onClick(View view) {
                            List linkedList = new LinkedList();
                            List linkedList2 = new LinkedList();
                            if (!bi.oN(mallTransactionObject.pgg)) {
                                linkedList2.add(Integer.valueOf(0));
                                linkedList.add(context.getString(i.vao));
                            }
                            if (!bi.oN(mallTransactionObject.pfI)) {
                                linkedList2.add(Integer.valueOf(1));
                                linkedList.add(context.getString(i.vap));
                            }
                            if (!bi.oN(mallTransactionObject.pgp)) {
                                linkedList2.add(Integer.valueOf(2));
                                linkedList.add(context.getString(i.var));
                            }
                            if (linkedList2.size() == 1) {
                                com.tencent.mm.plugin.order.model.a.a(((Integer) linkedList2.get(0)).intValue(), context, mallTransactionObject);
                                return;
                            }
                            com.tencent.mm.ui.base.h.a(context, null, linkedList, linkedList2, null, true, new com.tencent.mm.ui.base.h.d() {
                                public final void cr(int i, int i2) {
                                    com.tencent.mm.plugin.order.model.a.a(i2, context, mallTransactionObject);
                                }
                            });
                        }
                    };
                }
            } else if (!bi.oN(mallTransactionObject.pgq)) {
                jVar.piP = mallTransactionObject.pgq;
                jVar.piQ = new OnClickListener() {
                    public final void onClick(View view) {
                        a.a(context, mallTransactionObject.pgp, mallTransactionObject);
                    }
                };
            }
            jVar.pfF = mallTransactionObject.pfF;
            jVar.mOnClickListener = new OnClickListener() {
                public final void onClick(View view) {
                    if (view.getTag() != null && (view.getTag() instanceof HelpCenter)) {
                        a.a(context, ((HelpCenter) view.getTag()).url, mallTransactionObject);
                    }
                }
            };
            hVar = new h(context);
            hVar.piL = true;
            arrayList.add(hVar);
            arrayList.add(jVar);
        }
        return arrayList;
    }
}
