package com.tencent.mm.ui.chatting.b;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ad.k;
import com.tencent.mm.af.a.e;
import com.tencent.mm.af.a.h;
import com.tencent.mm.af.a.j;
import com.tencent.mm.af.a.v;
import com.tencent.mm.af.d;
import com.tencent.mm.af.e.a.b;
import com.tencent.mm.af.f;
import com.tencent.mm.af.n;
import com.tencent.mm.af.y;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.protocal.c.hr;
import com.tencent.mm.protocal.c.hs;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.y.as;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

public final class c implements n {
    public p fhH;
    public d kKo;
    public i poA = null;
    public j poq;
    public boolean vus = false;
    public n yEM;
    public long yFh = -1;
    public com.tencent.mm.app.plugin.a.a yHq;
    public long yHr = 0;
    public boolean yHs = false;
    RelativeLayout yHt;
    TextView yHu;
    public com.tencent.mm.af.m.a.a yHv = new com.tencent.mm.af.m.a.a() {
        public final void kl(String str) {
            if (str == null) {
                x.i("MicroMsg.ChattingUI.BizMgr", "brand is null");
                return;
            }
            x.i("MicroMsg.ChattingUI.BizMgr", "BrandLogic.BrandIconService.BrandIconUpdateListener onUpdate");
            c.this.fhH.cpZ();
        }
    };
    protected final a yHw = new a() {
        public final boolean ctZ() {
            if (c.this.yHt == null) {
                g.a(c.this.fhH.cte(), R.h.cVX);
                c.this.yHt = (RelativeLayout) c.this.fhH.cte().findViewById(R.h.bNT);
                c.this.yHu = (TextView) c.this.fhH.cte().findViewById(R.h.bNU);
                c.this.yHu.setText(R.l.dQr);
            }
            c.this.yHt.setVisibility(0);
            c.this.fhH.ctg().postDelayed(new Runnable() {
                public final void run() {
                    if (!(c.this.yHt == null || c.this.yHt.getVisibility() == 8)) {
                        c.this.yHt.setVisibility(8);
                    }
                    c.this.fhH.crM();
                    c.this.fhH.cpZ();
                }
            }, 5000);
            return true;
        }
    };
    public com.tencent.mm.af.e.a yHx = new com.tencent.mm.af.e.a() {
        public final void a(final b bVar) {
            if (bVar != null && bVar.hrn == com.tencent.mm.af.e.a.a.hrl && bVar.hpQ != null && bVar.hpQ.equals(c.this.fhH.csn())) {
                as.Hm();
                final com.tencent.mm.k.a Xv = com.tencent.mm.y.c.Ff().Xv(bVar.hpQ);
                if (Xv == null || ((int) Xv.gKO) == 0) {
                    x.i("MicroMsg.ChattingUI.BizMgr", "Get contact from db return null.(username : %s)", bVar.hpQ);
                    return;
                }
                ah.y(new Runnable() {
                    public final void run() {
                        if (c.this.fhH.ctf() && bVar.hpQ.equals(c.this.fhH.csn())) {
                            x.i("MicroMsg.ChattingUI.BizMgr", "try to refresh footer.");
                            c.this.fhH.V(Xv);
                            c.this.kKo = f.jV(bVar.hpQ);
                            c.this.yEM.X(Xv);
                        }
                    }
                });
            }
        }
    };
    public com.tencent.mm.af.a.c yvJ;
    public com.tencent.mm.af.a.d.a ywo = new com.tencent.mm.af.a.d.a() {
        public final void a(com.tencent.mm.af.a.d.a.b bVar) {
            if (!c.this.vus || bVar == null || bVar.hsp != c.this.ctW()) {
                return;
            }
            if (c.this.fhH.ctD()) {
                x.i("MicroMsg.ChattingUI.BizMgr", "onNotifyChange fragment not foreground, return");
            } else if (bVar.hsz != com.tencent.mm.af.a.d.a.a.hsw) {
                x.i("MicroMsg.ChattingUI.BizMgr", "bizChatExtension bizChat change");
                c.this.yvJ = y.Mn().ag(c.this.ctW());
                if (c.this.yHs) {
                    c.this.fhH.mQ(e.c(c.this.yvJ));
                    c.this.fhH.crN();
                } else {
                    j ca = y.Mp().ca(c.this.yvJ.field_bizChatServId);
                    if (ca != null) {
                        c.this.poq = ca;
                    }
                }
                c.this.fhH.crM();
            } else if (c.this.yHs) {
                Toast.makeText(ad.getContext(), c.this.fhH.cte().getMMString(R.l.eFB), 1).show();
                c.this.fhH.cte().finish();
            }
        }
    };
    protected final ChatFooter.d yyA = new ChatFooter.d() {
        public final boolean lu(boolean z) {
            if (c.this.kKo == null) {
                return false;
            }
            d.b bK = c.this.kKo.bK(false);
            if (bK == null) {
                return false;
            }
            com.tencent.mm.af.d.b.c LK = bK.LK();
            if (LK == null || LK.hqO == null || LK.hqO.isEmpty()) {
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(((com.tencent.mm.af.j) LK.hqO.get(0)).value);
                AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                appBrandStatObject.scene = 1083;
                appBrandStatObject.foi = c.this.kKo.field_username;
                ((com.tencent.mm.plugin.appbrand.n.d) g.h(com.tencent.mm.plugin.appbrand.n.d.class)).a(c.this.fhH.cte().getContext(), jSONObject.optString("userName"), null, 0, 0, jSONObject.optString("pagePath"), appBrandStatObject, c.this.kKo.field_appId);
                return true;
            } catch (JSONException e) {
                return false;
            }
        }
    };

    /* renamed from: com.tencent.mm.ui.chatting.b.c$14 */
    class AnonymousClass14 implements OnClickListener {
        final /* synthetic */ boolean yHD;

        public AnonymousClass14(boolean z) {
            this.yHD = z;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            c.this.kKo.field_hadAlert = 1;
            d dVar = c.this.kKo;
            if (dVar != null) {
                dVar.field_brandFlag |= 4;
                f.g(dVar);
            }
            if (this.yHD) {
                c.this.fhH.cte().startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
                return;
            }
            y.Mu().kh(c.this.fhH.csn());
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.b.c$7 */
    class AnonymousClass7 implements OnCancelListener {
        final /* synthetic */ com.tencent.mm.af.a.x yxs;

        AnonymousClass7(com.tencent.mm.af.a.x xVar) {
            this.yxs = xVar;
        }

        public final void onCancel(DialogInterface dialogInterface) {
            as.CN().c(this.yxs);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.b.c$5 */
    class AnonymousClass5 implements OnClickListener {
        final /* synthetic */ LinkedList yHz;

        AnonymousClass5(LinkedList linkedList) {
            this.yHz = linkedList;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            hs hsVar = new hs();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.yHz.size()) {
                    hr hrVar = new hr();
                    hrVar.vUi = (String) this.yHz.get(i3);
                    hsVar.vUj.add(hrVar);
                    i2 = i3 + 1;
                } else {
                    c cVar = c.this;
                    x.i("MicroMsg.ChattingUI.BizMgr", "updateBizChatMemberList()");
                    String mMString = cVar.fhH.cte().getMMString(R.l.eFl);
                    y.Mr();
                    com.tencent.mm.af.a.x a = h.a(cVar.yvJ.field_brandUserName, cVar.yvJ.field_bizChatServId, null, hsVar, cVar);
                    Context context = cVar.fhH.cte().getContext();
                    cVar.fhH.cte().getMMString(R.l.dGZ);
                    cVar.fhH.b(com.tencent.mm.ui.base.h.a(context, mMString, true, new AnonymousClass7(a)));
                    return;
                }
            }
        }
    }

    public interface a {
        boolean ctZ();
    }

    public c(p pVar) {
        this.fhH = pVar;
    }

    public final void a(int i, k kVar) {
        if (kVar.getType() == 1357) {
            this.fhH.dismissDialog();
            if (i != 0) {
                Toast.makeText(ad.getContext(), this.fhH.cte().getMMString(R.l.eFg), 0).show();
            }
        }
    }

    public final long ctW() {
        return this.yvJ == null ? -1 : this.yvJ.field_bizChatLocalId;
    }

    public final void ctX() {
        as.Dt().g(new Runnable() {
            public final void run() {
                if (c.this.vus && c.this.fhH.ctm() != null && !c.this.fhH.ctm().yBT) {
                    e.d(c.this.yvJ);
                }
            }
        }, 500);
    }

    public final String ZO(String str) {
        if (!TextUtils.isEmpty(str) && str.contains("http://weixin.qq.com/emoticonstore/")) {
            String substring = str.substring(str.lastIndexOf("/") + 1);
            if (com.tencent.mm.k.a.ga(this.fhH.csW().field_type) && this.fhH.csW().ciN() && this.kKo != null) {
                d.b bK = this.kKo.bK(false);
                if (!(bK == null || TextUtils.isEmpty(bK.LJ()) || !substring.contains(bK.LJ()))) {
                    return substring;
                }
            }
        }
        return null;
    }

    final String az(LinkedList<String> linkedList) {
        if (linkedList.size() <= 0) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder(this.yvJ.gw((String) linkedList.get(0)));
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 >= linkedList.size()) {
                return stringBuilder.toString();
            }
            stringBuilder.append(this.fhH.cte().getContext().getString(R.l.dQK)).append(this.yvJ.gw((String) linkedList.get(i2)));
            i = i2 + 1;
        }
    }

    public final void ctY() {
        if (this.vus) {
            y.Mr();
            g.Dp().gRu.a(new v(this.fhH.csn(), this.yvJ.field_bizChatServId, (int) (System.currentTimeMillis() / 1000)), 0);
        }
    }
}
