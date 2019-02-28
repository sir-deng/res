package com.tencent.mm.ui.chatting;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.bl.d;
import com.tencent.mm.f.a.pa;
import com.tencent.mm.pluginsdk.model.app.aj;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.t;
import com.tencent.mm.pluginsdk.model.app.w;
import com.tencent.mm.pluginsdk.q;
import com.tencent.mm.pluginsdk.q.j;
import com.tencent.mm.protocal.c.aqe;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.chatting.r.n;
import com.tencent.mm.ui.chatting.viewitems.ar;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bb;
import com.tencent.mm.y.s;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.LinkedList;

public final class c implements OnClickListener, e, t {
    private ProgressDialog inI;
    private a yyK;

    static /* synthetic */ void a(c cVar, final k kVar) {
        as.CN().a(kVar, 0);
        Context thisActivity = cVar.yyK.thisActivity();
        cVar.yyK.getString(R.l.dGZ);
        cVar.inI = h.a(thisActivity, cVar.yyK.getString(R.l.dHn), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                as.CN().c(kVar);
                an.aRP().b(2, c.this);
            }
        });
    }

    public c(a aVar) {
        this.yyK = aVar;
    }

    public final void onClick(View view) {
        boolean z = true;
        boolean z2 = false;
        String str;
        if (view.getTag() == null) {
            x.e("MicroMsg.AppSpamClickListener", "onClick tag is null");
        } else if (view.getTag() instanceof ar) {
            ar arVar = (ar) view.getTag();
            if (arVar == null) {
                x.e("MicroMsg.AppSpamClickListener", "ItemDataTag is null");
                return;
            }
            str = arVar.fFo.appId;
            if (bi.oN(str)) {
                x.e("MicroMsg.AppSpamClickListener", "appId is null or nil");
            } else if (g.aZ(str, false) == null) {
                x.e("MicroMsg.AppSpamClickListener", "get null appinfo : appid = " + str);
            } else {
                z2 = true;
            }
            if (z2) {
                int i;
                String hS;
                an.aRP().a(2, (t) this);
                if (this.yyK.yAR) {
                    i = 2;
                } else {
                    i = 1;
                }
                str = this.yyK.csn();
                if (s.eX(str)) {
                    hS = bb.hS(arVar.fFE.field_content);
                } else {
                    hS = str;
                }
                final com.tencent.mm.x.g.a aVar = arVar.fFo;
                h.a(this.yyK.thisActivity(), this.yyK.getString(R.l.dFN), this.yyK.getString(R.l.dFO), this.yyK.getString(R.l.dCn), this.yyK.getString(R.l.eDd), new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        c.a(c.this, new com.tencent.mm.pluginsdk.model.app.x(2, new aj(aVar.appId, 0, "1")));
                        j jVar = q.a.vjc;
                        if (jVar != null) {
                            c.this.yyK.thisActivity();
                            jVar.a(hS, aVar.appId, aVar.type, i, aVar.mediaTagName, 1);
                        }
                    }
                }, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        c.a(c.this, new com.tencent.mm.pluginsdk.model.app.x(2, new aj(aVar.appId, 0, "0")));
                        j jVar = q.a.vjc;
                        if (jVar != null) {
                            c.this.yyK.thisActivity();
                            jVar.a(hS, aVar.appId, aVar.type, i, aVar.mediaTagName, 2);
                        }
                    }
                });
            }
        } else if (view.getTag() instanceof n) {
            final n nVar = (n) view.getTag();
            if (nVar == null) {
                x.e("MicroMsg.AppSpamClickListener", "TemplateItemDataTag is null");
            } else if (nVar == null || bi.oN(nVar.hdN) || nVar.fFE == null) {
                String str2 = "MicroMsg.AppSpamClickListener";
                str = "wrong args, tag is null ? ";
                Object[] objArr = new Object[1];
                if (nVar != null) {
                    z = false;
                }
                objArr[0] = Boolean.valueOf(z);
                x.e(str2, str, objArr);
            } else {
                String[] strArr = new String[]{this.yyK.thisActivity().getString(R.l.eRq), this.yyK.thisActivity().getString(R.l.eRr), this.yyK.thisActivity().getString(R.l.dEy)};
                h.a(this.yyK.thisActivity(), null, strArr, null, true, new com.tencent.mm.ui.base.h.c() {
                    public final void jo(int i) {
                        switch (i) {
                            case 0:
                                Intent intent = new Intent();
                                try {
                                    intent.putExtra("rawUrl", String.format("https://mp.weixin.qq.com/mp/readtemplate?t=wxm-appmsg-inform&bizusername=%s&tid=%s&mid=%s&mtime=%s&scene=%s#wechat_redirect", new Object[]{URLEncoder.encode(nVar.sfb, "UTF-8"), URLEncoder.encode(nVar.hdN, "UTF-8"), Long.valueOf(nVar.fFE.field_msgSvrId), Integer.valueOf((int) (nVar.fFE.field_createTime / 1000)), Integer.valueOf(42)}));
                                    intent.putExtra("show_bottom", false);
                                    intent.putExtra("showShare", false);
                                    d.b(c.this.yyK.thisActivity(), "webview", ".ui.tools.WebViewUI", intent);
                                    return;
                                } catch (UnsupportedEncodingException e) {
                                    x.e("MicroMsg.AppSpamClickListener", "exception in expore, %s", e.getMessage());
                                    return;
                                }
                            case 1:
                                x.d("MicroMsg.AppSpamClickListener", "hakon refulse, fromUserName = %s, templateId = %s", nVar.sfb, nVar.hdN);
                                as.CN().a(1030, c.this);
                                aqe aqe = new aqe();
                                aqe.vNC = 1;
                                aqe.wDI = nVar.hdN;
                                aqe.fpg = "";
                                LinkedList linkedList = new LinkedList();
                                linkedList.add(aqe);
                                b paVar = new pa();
                                paVar.fHL.fGc = nVar.sfb;
                                paVar.fHL.fHM = linkedList;
                                if (com.tencent.mm.sdk.b.a.xmy.m(paVar)) {
                                    c cVar = c.this;
                                    Context thisActivity = c.this.yyK.thisActivity();
                                    c.this.yyK.getString(R.l.dGZ);
                                    cVar.inI = h.a(thisActivity, c.this.yyK.getString(R.l.dHn), true, new OnCancelListener() {
                                        public final void onCancel(DialogInterface dialogInterface) {
                                            as.CN().b(1030, c.this);
                                        }
                                    });
                                    return;
                                }
                                return;
                            default:
                                return;
                        }
                    }
                });
            }
        }
    }

    public final void a(int i, int i2, String str, w wVar) {
        x.d("MicroMsg.AppSpamClickListener", "appsettings errType = " + i + ", errCode = " + i2);
        if (this.inI != null && this.inI.isShowing()) {
            this.inI.dismiss();
            this.inI = null;
        }
        an.aRP().b(2, this);
        if (i == 0 && i2 == 0) {
            h.bu(this.yyK.thisActivity(), this.yyK.getString(R.l.enf));
        } else if (!com.tencent.mm.ui.t.a.a(this.yyK.thisActivity(), i, i2, str, 4)) {
            Toast.makeText(this.yyK.thisActivity(), this.yyK.getString(R.l.emD, Integer.valueOf(i), Integer.valueOf(i2)), 0).show();
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (this.inI != null && this.inI.isShowing()) {
            this.inI.dismiss();
            this.inI = null;
        }
        as.CN().b(1030, (e) this);
        if (i == 0 && i2 == 0) {
            h.bu(this.yyK.thisActivity(), this.yyK.getString(R.l.enf));
            return;
        }
        Toast.makeText(this.yyK.thisActivity(), this.yyK.getString(R.l.eRs, Integer.valueOf(i), Integer.valueOf(i2)), 0).show();
    }
}
