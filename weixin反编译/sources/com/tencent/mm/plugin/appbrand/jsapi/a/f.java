package com.tencent.mm.plugin.appbrand.jsapi.a;

import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.ad.b;
import com.tencent.mm.bl.d;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.q.e;
import com.tencent.mm.plugin.appbrand.q.g;
import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.protocal.c.ea;
import com.tencent.mm.protocal.c.eb;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class f extends a {
    public static final int CTRL_INDEX = 208;
    public static final String NAME = "requestAuthUserAutoFillData";

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.a.f$2 */
    class AnonymousClass2 implements OnClickListener {
        final /* synthetic */ p jgX;

        AnonymousClass2(p pVar) {
            this.jgX = pVar;
        }

        public final void onClick(View view) {
            x.i("MicroMsg.JsApiRequestAuthUserAutoFillData", "do know the auth auto fill data protocol");
            String str = this.jgX.mContext.getString(j.iAW) + w.cfV();
            x.i("MicroMsg.JsApiRequestAuthUserAutoFillData", "do open url:" + str);
            Intent intent = new Intent();
            intent.putExtra("rawUrl", str);
            d.b(this.jgX.mContext, "webview", ".ui.tools.WebViewUI", intent);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.a.f$4 */
    class AnonymousClass4 implements DialogInterface.OnClickListener {
        final /* synthetic */ int gQv;
        final /* synthetic */ b hpF;
        final /* synthetic */ p jgX;
        final /* synthetic */ ea jkp;

        AnonymousClass4(ea eaVar, p pVar, int i, b bVar) {
            this.jkp = eaVar;
            this.jgX = pVar;
            this.gQv = i;
            this.hpF = bVar;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            x.i("MicroMsg.JsApiRequestAuthUserAutoFillData", "do not accept the auto fill data protocol");
            this.jkp.vQi = false;
            this.jgX.E(this.gQv, f.this.e("cancel", null));
            com.tencent.mm.ipcinvoker.wx_extension.b.a(this.hpF, new com.tencent.mm.ipcinvoker.wx_extension.b.a() {
                public final void a(int i, int i2, String str, b bVar) {
                    if (i == 0 && i2 == 0 && bVar.hnR.hnY != null) {
                        x.i("MicroMsg.JsApiRequestAuthUserAutoFillData", "requestAuthUserAutoFillData success");
                        return;
                    }
                    x.e("MicroMsg.JsApiRequestAuthUserAutoFillData", "requestAuthUserAutoFillData cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", Integer.valueOf(i), Integer.valueOf(i2), str, bVar.hnR.hnY);
                }
            });
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.a.f$3 */
    class AnonymousClass3 implements DialogInterface.OnClickListener {
        final /* synthetic */ int gQv;
        final /* synthetic */ b hpF;
        final /* synthetic */ p jgX;
        final /* synthetic */ ea jkp;

        AnonymousClass3(ea eaVar, p pVar, int i, b bVar) {
            this.jkp = eaVar;
            this.jgX = pVar;
            this.gQv = i;
            this.hpF = bVar;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            x.i("MicroMsg.JsApiRequestAuthUserAutoFillData", "do accept the auto fill data protocol");
            this.jkp.vQi = true;
            this.jgX.E(this.gQv, f.this.e("ok", null));
            com.tencent.mm.ipcinvoker.wx_extension.b.a(this.hpF, new com.tencent.mm.ipcinvoker.wx_extension.b.a() {
                public final void a(int i, int i2, String str, b bVar) {
                    if (i == 0 && i2 == 0 && bVar.hnR.hnY != null) {
                        x.i("MicroMsg.JsApiRequestAuthUserAutoFillData", "requestAuthUserAutoFillData success");
                        return;
                    }
                    x.e("MicroMsg.JsApiRequestAuthUserAutoFillData", "requestAuthUserAutoFillData cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", Integer.valueOf(i), Integer.valueOf(i2), str, bVar.hnR.hnY);
                }
            });
        }
    }

    public final void a(p pVar, JSONObject jSONObject, int i) {
        if (jSONObject == null) {
            x.e("MicroMsg.JsApiRequestAuthUserAutoFillData", "requestAuthUserAutoFillData data is invalid");
            pVar.E(i, e("fail:data is invalid", null));
            return;
        }
        int i2;
        LinkedList linkedList = new LinkedList();
        JSONArray optJSONArray = jSONObject.optJSONArray("fields");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            for (i2 = 0; i2 < optJSONArray.length(); i2++) {
                linkedList.add(optJSONArray.optString(i2));
            }
        }
        final Object optString = jSONObject.optString("wording");
        final int optInt = jSONObject.optInt("authStatus", 2);
        final LinkedList linkedList2 = new LinkedList();
        optJSONArray = jSONObject.optJSONArray("authGroupList");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            for (i2 = 0; i2 < optJSONArray.length(); i2++) {
                linkedList2.add("  " + optJSONArray.optString(i2));
            }
        }
        if (linkedList.size() == 0) {
            x.e("MicroMsg.JsApiRequestAuthUserAutoFillData", "requestAuthUserAutoFillData fields is empty");
            pVar.E(i, e("fail:fields is empty", null));
        } else if (TextUtils.isEmpty(optString)) {
            x.e("MicroMsg.JsApiRequestAuthUserAutoFillData", "requestAuthUserAutoFillData wording is empty");
            pVar.E(i, e("fail:wording is empty", null));
        } else {
            x.i("MicroMsg.JsApiRequestAuthUserAutoFillData", "requestAuthUserAutoFillData appId:%s", pVar.mAppId);
            x.i("MicroMsg.JsApiRequestAuthUserAutoFillData", "wording:%s, authType:%d, fieldIds:%s", optString, Integer.valueOf(optInt), jSONObject.optJSONArray("fields").toString());
            if (jSONObject.optJSONArray("authGroupList") != null) {
                x.i("MicroMsg.JsApiRequestAuthUserAutoFillData", "authGroupList:%s", jSONObject.optJSONArray("authGroupList").toString());
            }
            b.a aVar = new b.a();
            aVar.hnT = new ea();
            aVar.hnU = new eb();
            aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/autofill/authinfo";
            aVar.hnS = 1183;
            aVar.hnV = 0;
            aVar.hnW = 0;
            final b Kf = aVar.Kf();
            final ea eaVar = (ea) Kf.hnQ.hnY;
            eaVar.vQh = linkedList;
            eaVar.fGh = r0;
            eaVar.vQj = optInt;
            final p pVar2 = pVar;
            final int i3 = i;
            ah.y(new Runnable() {
                public final void run() {
                    f fVar = f.this;
                    p pVar = pVar2;
                    int i = i3;
                    ea eaVar = eaVar;
                    b bVar = Kf;
                    int i2 = optInt;
                    CharSequence charSequence = optString;
                    LinkedList linkedList = linkedList2;
                    String string = i2 == 2 ? pVar.mContext.getString(j.iAT) : pVar.mContext.getString(j.iAU);
                    String string2 = pVar.mContext.getString(j.iAV);
                    String string3 = pVar.mContext.getString(j.iAS);
                    CharSequence string4 = pVar.mContext.getString(j.iAR);
                    LayoutInflater layoutInflater = (LayoutInflater) pVar.mContext.getSystemService("layout_inflater");
                    View inflate = layoutInflater.inflate(h.izg, null);
                    TextView textView = (TextView) inflate.findViewById(g.ivV);
                    LinearLayout linearLayout = (LinearLayout) inflate.findViewById(g.ivW);
                    ((TextView) inflate.findViewById(g.ivU)).setText(charSequence);
                    textView.setText(string4);
                    textView.setOnClickListener(new AnonymousClass2(pVar));
                    linearLayout.removeAllViews();
                    if (linkedList == null || linkedList.size() <= 0) {
                        LayoutParams layoutParams = (LayoutParams) textView.getLayoutParams();
                        layoutParams.leftMargin = 0;
                        textView.setLayoutParams(layoutParams);
                        linearLayout.setVisibility(8);
                    } else {
                        linearLayout.setVisibility(0);
                        Iterator it = linkedList.iterator();
                        while (it.hasNext()) {
                            textView = (TextView) layoutInflater.inflate(h.izc, null);
                            textView.setText((String) it.next());
                            ViewGroup.LayoutParams layoutParams2 = new LayoutParams(-1, -2);
                            layoutParams2.bottomMargin = pVar.getContentView().getResources().getDimensionPixelOffset(e.ivc);
                            textView.setLayoutParams(layoutParams2);
                            linearLayout.addView(textView);
                        }
                    }
                    x.i("MicroMsg.JsApiRequestAuthUserAutoFillData", "show the auto fill data protocol dialog!");
                    com.tencent.mm.ui.base.h.a(pVar.mContext, false, string, inflate, string2, string3, (DialogInterface.OnClickListener) new AnonymousClass3(eaVar, pVar, i, bVar), (DialogInterface.OnClickListener) new AnonymousClass4(eaVar, pVar, i, bVar));
                }
            });
        }
    }
}
