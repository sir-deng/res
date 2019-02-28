package com.tencent.mm.plugin.appbrand.jsapi.a;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.CountDownTimer;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.ad.b;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.modelappbrand.a.f;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.q.d;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.plugin.appbrand.ui.AppBrandRedirectUI;
import com.tencent.mm.plugin.appbrand.widget.sms.EditVerifyCodeView;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.anb;
import com.tencent.mm.protocal.c.anc;
import com.tencent.mm.protocal.c.bhr;
import com.tencent.mm.protocal.c.bhs;
import com.tencent.mm.protocal.c.ob;
import com.tencent.mm.protocal.c.oc;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.base.r;
import com.tencent.wcdb.FileUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public final class c extends com.tencent.mm.plugin.appbrand.jsapi.a {
    public static final int CTRL_INDEX = 209;
    public static final String NAME = "getPhoneNumber";
    String atl;
    String fBa = "";
    int jgb;
    p jjI;
    private String jjJ;
    private boolean jjK;
    String jjL;
    String jjM;
    String jjN = "";
    boolean jjO = false;
    View jjP;
    EditVerifyCodeView jjQ;
    TextView jjR;
    a jjS;
    com.tencent.mm.plugin.af.a jjT = null;
    private i jjU;
    int jjV = 0;
    int jjW = 0;
    int jjX = 0;
    com.tencent.mm.plugin.af.a.a jjY = new com.tencent.mm.plugin.af.a.a() {
        public final void sD(String str) {
            x.i("MicroMsg.JsApiGetPhoneNumber", "smsListener onchange");
            x.d("MicroMsg.JsApiGetPhoneNumber", "smsVerifyCode:%s", str);
            c.this.jjQ.setText(str);
        }
    };
    String signature;

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.a.c$13 */
    class AnonymousClass13 implements OnClickListener {
        final /* synthetic */ boolean jkj;

        AnonymousClass13(boolean z) {
            this.jkj = z;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            x.i("MicroMsg.JsApiGetPhoneNumber", "confirm login");
            dialogInterface.dismiss();
            if (this.jkj) {
                c.a(c.this);
                c.b(c.this);
                return;
            }
            x.i("MicroMsg.JsApiGetPhoneNumber", "not need to verify sms, and do callback");
            c.this.afY();
            g.pWK.h(14249, c.this.jjI.mAppId, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(c.this.jjW), Integer.valueOf(c.this.jjX), Integer.valueOf(c.this.jjV));
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.a.c$8 */
    class AnonymousClass8 implements com.tencent.mm.ui.MMActivity.a {
        final /* synthetic */ MMActivity jke;

        AnonymousClass8(MMActivity mMActivity) {
            this.jke = mMActivity;
        }

        public final void b(int i, int i2, Intent intent) {
            if (i == 100) {
                c.this.jjW = 1;
                if (i2 == -1) {
                    c.this.jjX = 1;
                    x.i("MicroMsg.JsApiGetPhoneNumber", "mmOnActivityResult RESULT_OK");
                    g.pWK.h(14249, c.this.jjI.mAppId, Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(c.this.jjW), Integer.valueOf(c.this.jjX), Integer.valueOf(c.this.jjV));
                    h.bu(this.jke.mController.xRr, this.jke.getResources().getString(j.iBw));
                    c.this.afX();
                } else {
                    c.this.jjX = 0;
                    c.this.jjI.E(c.this.jgb, c.this.e("fail:user cancel", null));
                    x.e("MicroMsg.JsApiGetPhoneNumber", "mmOnActivityResult RESULT_CANCEL OR RESULT_FIRST_USER");
                    g.pWK.h(14249, c.this.jjI.mAppId, Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(c.this.jjW), Integer.valueOf(c.this.jjX), Integer.valueOf(c.this.jjV));
                }
                this.jke.jCj = null;
            }
        }
    }

    class a extends CountDownTimer {
        public a() {
            super(60000, 1000);
        }

        public final void onTick(long j) {
            c.this.jjR.setText(c.this.jjI.getContentView().getResources().getString(j.iBG, new Object[]{(j / 1000)}));
        }

        public final void onFinish() {
            c.this.afZ();
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.a.c$12 */
    class AnonymousClass12 implements View.OnClickListener {
        final /* synthetic */ View jkh;

        AnonymousClass12(View view) {
            this.jkh = view;
        }

        public final void onClick(View view) {
            if (this.jkh.getParent() != null) {
                ((ViewGroup) this.jkh.getParent()).removeAllViews();
            }
            h.a(c.this.jjI.mContext, false, c.this.jjI.getContentView().getResources().getString(j.iBA), this.jkh, c.this.jjI.getContentView().getResources().getString(j.iBz), "", new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            }, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.a.c$5 */
    class AnonymousClass5 implements com.tencent.mm.ipcinvoker.wx_extension.b.a {
        final /* synthetic */ r jkb;

        AnonymousClass5(r rVar) {
            this.jkb = rVar;
        }

        public final void a(int i, int i2, String str, b bVar) {
            this.jkb.dismiss();
            if (i == 0 && i2 == 0 && bVar.hnR.hnY != null) {
                x.i("MicroMsg.JsApiGetPhoneNumber", "checkVerifyCode success");
                final oc ocVar = (oc) bVar.hnR.hnY;
                c.this.jjI.getContentView().post(new Runnable() {
                    public final void run() {
                        if (ocVar.status == 0) {
                            x.d("MicroMsg.JsApiGetPhoneNumber", "encryptedData:%s, iv:%s", ocVar.jjM, ocVar.atl);
                            if (!TextUtils.isEmpty(ocVar.jjM)) {
                                c.this.jjM = ocVar.jjM;
                            }
                            if (!TextUtils.isEmpty(ocVar.atl)) {
                                c.this.atl = ocVar.atl;
                            }
                        }
                        c cVar = c.this;
                        int i = ocVar.status;
                        x.i("MicroMsg.JsApiGetPhoneNumber", "handleCheckVerifyCodeStatus:%d", Integer.valueOf(i));
                        if (i == 0) {
                            g.pWK.h(14249, cVar.jjI.mAppId, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(cVar.jjW), Integer.valueOf(cVar.jjX), Integer.valueOf(cVar.jjV));
                            cVar.afY();
                        } else if (i == 1) {
                            cVar.sC(cVar.jjI.getContentView().getResources().getString(j.iBJ));
                            g.pWK.h(14249, cVar.jjI.mAppId, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(cVar.jjW), Integer.valueOf(cVar.jjX), Integer.valueOf(cVar.jjV));
                        } else if (i == 3 || i == 4) {
                            h.a(cVar.jjI.mContext, cVar.jjI.getContentView().getResources().getString(j.iBL), "", false, new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.dismiss();
                                    x.e("MicroMsg.JsApiGetPhoneNumber", "verify code is error, do send the right code");
                                    c.a(c.this);
                                }
                            });
                        } else {
                            cVar.sC(cVar.jjI.getContentView().getResources().getString(j.iBO));
                            g.pWK.h(14249, cVar.jjI.mAppId, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(cVar.jjW), Integer.valueOf(cVar.jjX), Integer.valueOf(cVar.jjV));
                        }
                    }
                });
                return;
            }
            x.e("MicroMsg.JsApiGetPhoneNumber", "getPhoneNumber checkVerifyCode cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", Integer.valueOf(i), Integer.valueOf(i2), str, bVar.hnR.hnY);
            c.this.jjI.E(c.this.jgb, c.this.e("fail:checkVerifyCode cgi fail", null));
            g.pWK.h(14249, c.this.jjI.mAppId, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(c.this.jjW), Integer.valueOf(c.this.jjX), Integer.valueOf(c.this.jjV));
        }
    }

    static /* synthetic */ void a(c cVar) {
        x.i("MicroMsg.JsApiGetPhoneNumber", "showVerifyMobileDialog");
        LayoutInflater layoutInflater = (LayoutInflater) cVar.jjI.mContext.getSystemService("layout_inflater");
        if (cVar.jjP == null) {
            cVar.jjP = layoutInflater.inflate(q.h.izP, null);
            cVar.jjQ = (EditVerifyCodeView) cVar.jjP.findViewById(q.g.ixp);
            cVar.jjR = (TextView) cVar.jjP.findViewById(q.g.ixm);
        }
        if (cVar.jjP.getParent() != null) {
            ((ViewGroup) cVar.jjP.getParent()).removeAllViews();
        }
        TextView textView = (TextView) cVar.jjP.findViewById(q.g.ixq);
        if (cVar.jjN == null) {
            cVar.jjN = "";
        }
        textView.setText(cVar.jjI.getContentView().getResources().getString(j.iBP, new Object[]{cVar.jjN}));
        cVar.jjQ.setText("");
        cVar.afZ();
        OnClickListener anonymousClass18 = new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                x.i("MicroMsg.JsApiGetPhoneNumber", "to verify sms");
                if (!TextUtils.isEmpty(c.this.jjQ.mBuilder.toString()) && c.this.jjQ.mBuilder.toString().length() == 6) {
                    x.e("MicroMsg.JsApiGetPhoneNumber", "code is length is 6");
                    dialogInterface.dismiss();
                    c.this.aga();
                    c.this.jjP.post(new Runnable() {
                        public final void run() {
                            ((MMActivity) c.this.jjI.mContext).aWY();
                        }
                    });
                    c cVar = c.this;
                    String str = c.this.jjQ.mBuilder.toString().toString();
                    x.i("MicroMsg.JsApiGetPhoneNumber", "doVerifyCode");
                    com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
                    aVar.hnT = new ob();
                    aVar.hnU = new oc();
                    aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/checkverifycode";
                    aVar.hnS = HardCoderJNI.FUNC_REG_ANR_CALLBACK;
                    aVar.hnV = 0;
                    aVar.hnW = 0;
                    b Kf = aVar.Kf();
                    ob obVar = (ob) Kf.hnQ.hnY;
                    obVar.fGh = cVar.jjI.mAppId;
                    obVar.fBa = cVar.fBa;
                    obVar.sVt = str;
                    com.tencent.mm.ipcinvoker.wx_extension.b.a(Kf, new AnonymousClass5(h.a(cVar.jjI.mContext, "", false, null)));
                } else if (TextUtils.isEmpty(c.this.jjQ.mBuilder.toString()) || c.this.jjQ.mBuilder.toString().length() >= 6) {
                    x.e("MicroMsg.JsApiGetPhoneNumber", "code is empty");
                    h.bu(c.this.jjI.mContext, c.this.jjI.getContentView().getResources().getString(j.iBM));
                } else {
                    h.bu(c.this.jjI.mContext, c.this.jjI.getContentView().getResources().getString(j.iBN));
                    x.e("MicroMsg.JsApiGetPhoneNumber", "code is length is < 6");
                }
            }
        };
        cVar.jjU = h.a(cVar.jjI.mContext, false, cVar.jjI.getContentView().getResources().getString(j.iBQ), cVar.jjP, cVar.jjI.getContentView().getResources().getString(j.dGf), cVar.jjI.getContentView().getResources().getString(j.dEy), anonymousClass18, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                x.i("MicroMsg.JsApiGetPhoneNumber", "cancel to verify sms");
                dialogInterface.dismiss();
                c.this.jjI.E(c.this.jgb, c.this.e("fail:cancel to verify sms", null));
                c.this.aga();
                c.this.jjP.post(new Runnable() {
                    public final void run() {
                        ((MMActivity) c.this.jjI.mContext).aWY();
                    }
                });
                g.pWK.h(14249, c.this.jjI.mAppId, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(c.this.jjW), Integer.valueOf(c.this.jjX), Integer.valueOf(c.this.jjV));
            }
        });
        cVar.jjU.a(cVar.jjI.getContentView().getResources().getString(j.dGf), false, anonymousClass18);
        cVar.jjP.post(new Runnable() {
            public final void run() {
                ((MMActivity) c.this.jjI.mContext).showVKB();
            }
        });
    }

    static /* synthetic */ void b(c cVar) {
        x.i("MicroMsg.JsApiGetPhoneNumber", "doSendVerifyCode");
        com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
        aVar.hnT = new bhr();
        aVar.hnU = new bhs();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/sendverifycode";
        aVar.hnS = WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
        aVar.hnV = 0;
        aVar.hnW = 0;
        b Kf = aVar.Kf();
        bhr bhr = (bhr) Kf.hnQ.hnY;
        bhr.fGh = cVar.jjI.mAppId;
        bhr.fBa = cVar.fBa;
        final r a = h.a(cVar.jjI.mContext, "", false, null);
        com.tencent.mm.ipcinvoker.wx_extension.b.a(Kf, new com.tencent.mm.ipcinvoker.wx_extension.b.a() {
            public final void a(int i, int i2, String str, b bVar) {
                a.dismiss();
                if (i == 0 && i2 == 0 && bVar.hnR.hnY != null) {
                    final bhs bhs = (bhs) bVar.hnR.hnY;
                    x.i("MicroMsg.JsApiGetPhoneNumber", "SendVerifyCode cgi success");
                    c.this.jjI.getContentView().post(new Runnable() {
                        public final void run() {
                            c cVar = c.this;
                            int i = bhs.status;
                            x.i("MicroMsg.JsApiGetPhoneNumber", "handleSendVerifyCodeStatus:%d", Integer.valueOf(i));
                            if (i == 0) {
                                x.i("MicroMsg.JsApiGetPhoneNumber", "startSmsListener");
                                if (cVar.jjS != null) {
                                    cVar.jjS.cancel();
                                } else {
                                    cVar.jjS = new a();
                                }
                                cVar.jjS.start();
                                if (cVar.jjT == null) {
                                    cVar.jjT = new com.tencent.mm.plugin.af.a(cVar.jjI.mContext);
                                }
                                cVar.jjT.qEe = cVar.jjI.getContentView().getResources().getStringArray(q.b.iuQ);
                                cVar.jjT.qEc = cVar.jjY;
                                com.tencent.mm.plugin.appbrand.a.a(cVar.jjI.mAppId, new android.support.v4.app.a.a() {
                                    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
                                        if (i != FileUtils.S_IWUSR) {
                                            x.e("MicroMsg.JsApiGetPhoneNumber", "requestSMSPermission requestCode is not for sms");
                                        } else if (iArr == null || iArr.length <= 0) {
                                            String str = "MicroMsg.JsApiGetPhoneNumber";
                                            String str2 = "requestSMSPermission, grantResults length is:%d requestCode:%d, permissions:%s, stack:%s";
                                            Object[] objArr = new Object[4];
                                            objArr[0] = Integer.valueOf(iArr == null ? -1 : iArr.length);
                                            objArr[1] = Integer.valueOf(i);
                                            objArr[2] = strArr;
                                            objArr[3] = bi.chl();
                                            x.w(str, str2, objArr);
                                        } else if (iArr[0] == 0) {
                                            x.i("MicroMsg.JsApiGetPhoneNumber", "requestSMSPermission permission is grant for sms");
                                            if (c.this.jjT != null) {
                                                c.this.jjT.start();
                                            }
                                        } else {
                                            x.e("MicroMsg.JsApiGetPhoneNumber", "requestSMSPermission sys perm denied for sms");
                                        }
                                    }
                                });
                                boolean a = com.tencent.mm.pluginsdk.g.a.a((Activity) cVar.jjI.mContext, "android.permission.READ_SMS", FileUtils.S_IWUSR, "", "");
                                if (a) {
                                    com.tencent.mm.plugin.appbrand.a.pj(cVar.jjI.mAppId);
                                }
                                if (a) {
                                    x.i("MicroMsg.JsApiGetPhoneNumber", "request sms permission success");
                                } else {
                                    x.e("MicroMsg.JsApiGetPhoneNumber", "request sms permission fail");
                                }
                                cVar.jjT.start();
                            } else if (i == 1 || i != 2) {
                                cVar.sC(cVar.jjI.getContentView().getResources().getString(j.iBI));
                                g.pWK.h(14249, cVar.jjI.mAppId, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(cVar.jjW), Integer.valueOf(cVar.jjX), Integer.valueOf(cVar.jjV));
                            } else {
                                cVar.sC(cVar.jjI.getContentView().getResources().getString(j.iBJ));
                                g.pWK.h(14249, cVar.jjI.mAppId, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(cVar.jjW), Integer.valueOf(cVar.jjX), Integer.valueOf(cVar.jjV));
                            }
                        }
                    });
                    return;
                }
                x.e("MicroMsg.JsApiGetPhoneNumber", "getPhoneNumber SendVerifyCode cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", Integer.valueOf(i), Integer.valueOf(i2), str, bVar.hnR.hnY);
                c.this.jjI.E(c.this.jgb, c.this.e("fail:SendVerifyCode cgi fail", null));
                g.pWK.h(14249, c.this.jjI.mAppId, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(c.this.jjW), Integer.valueOf(c.this.jjX), Integer.valueOf(c.this.jjV));
            }
        });
    }

    public final void a(final p pVar, JSONObject jSONObject, int i) {
        if (jSONObject == null) {
            x.e("MicroMsg.JsApiGetPhoneNumber", "getPhoneNumber data is null");
            pVar.E(i, e("fail:data is null", null));
            return;
        }
        this.jjI = pVar;
        this.jgb = i;
        x.i("MicroMsg.JsApiGetPhoneNumber", "getPhoneNumber data:%s", jSONObject.toString());
        Object optString = jSONObject.optString("api_name", "webapi_getuserwxphone");
        boolean optBoolean = jSONObject.optBoolean("with_credentials", true);
        if (TextUtils.isEmpty(optString)) {
            x.e("MicroMsg.JsApiGetPhoneNumber", "getPhoneNumber api_name is null");
            pVar.E(i, e("fail:api_name is null", null));
            return;
        }
        com.tencent.mm.plugin.appbrand.c.a(pVar.mAppId, new com.tencent.mm.plugin.appbrand.c.b() {
            public final void onDestroy() {
                x.i("MicroMsg.JsApiGetPhoneNumber", "AppBrandLifeCycle onDestroy");
                com.tencent.mm.plugin.appbrand.c.b(pVar.mAppId, this);
                c.this.aga();
            }
        });
        this.jjJ = optString;
        this.jjK = optBoolean;
        afX();
    }

    final void afX() {
        x.i("MicroMsg.JsApiGetPhoneNumber", "requestBindPhoneNumber");
        JSONStringer jSONStringer = new JSONStringer();
        try {
            jSONStringer.object();
            jSONStringer.key("api_name");
            jSONStringer.value(this.jjJ);
            jSONStringer.key("with_credentials");
            jSONStringer.value(this.jjK);
            jSONStringer.endObject();
        } catch (JSONException e) {
            x.e("MicroMsg.JsApiGetPhoneNumber", "JSONException:%s", e.getMessage());
        }
        x.i("MicroMsg.JsApiGetPhoneNumber", "getPhoneNumber appId:%s, api_name:%s, with_credentials:%b", this.jjI.mAppId, this.jjJ, Boolean.valueOf(this.jjK));
        com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
        aVar.hnT = new anb();
        aVar.hnU = new anc();
        aVar.uri = "/cgi-bin/mmbiz-bin/js-getuserwxphone";
        aVar.hnS = 1141;
        aVar.hnV = 0;
        aVar.hnW = 0;
        b Kf = aVar.Kf();
        anb anb = (anb) Kf.hnQ.hnY;
        anb.nlV = this.jjI.mAppId;
        anb.kyn = new com.tencent.mm.bp.b(jSONStringer.toString().getBytes());
        com.tencent.mm.ipcinvoker.wx_extension.b.a(Kf, new com.tencent.mm.ipcinvoker.wx_extension.b.a() {
            public final void a(int i, int i2, String str, b bVar) {
                if (i == 0 && i2 == 0 && bVar.hnR.hnY != null) {
                    x.i("MicroMsg.JsApiGetPhoneNumber", "JsOperateWxData success");
                    final anc anc = (anc) bVar.hnR.hnY;
                    c.this.jjI.getContentView().post(new Runnable() {
                        public final void run() {
                            e eVar = c.this;
                            anc anc = anc;
                            x.i("MicroMsg.JsApiGetPhoneNumber", "handleOperateWxData");
                            Object obj = "";
                            if (anc.kyn != null) {
                                obj = anc.kyn.cec();
                            }
                            x.i("MicroMsg.JsApiGetPhoneNumber", "resp data:%s", obj);
                            if (TextUtils.isEmpty(obj)) {
                                x.e("MicroMsg.JsApiGetPhoneNumber", "resp data is empty");
                                eVar.jjI.E(eVar.jgb, eVar.e("fail:resp data is empty", null));
                                return;
                            }
                            String str;
                            CharSequence charSequence;
                            String str2 = anc.vML;
                            CharSequence charSequence2 = anc.noG;
                            String str3 = "";
                            String str4 = "";
                            if (anc.wAw != null) {
                                str3 = anc.wAw.nkL;
                                eVar.jjN = anc.wAw.jjN;
                                str = anc.wAw.wzQ;
                                charSequence = str3;
                            } else {
                                str = str4;
                                Object charSequence3 = str3;
                            }
                            x.i("MicroMsg.JsApiGetPhoneNumber", "appName:%s, desc:%s, IconUrl:%s, ext_desc:%s", charSequence2, charSequence3, str2, eVar.jjN);
                            JSONObject jSONObject = null;
                            try {
                                jSONObject = new JSONObject(obj);
                            } catch (JSONException e) {
                                x.e("MicroMsg.JsApiGetPhoneNumber", "new data json exception:%s", e.getMessage());
                            }
                            if (jSONObject == null) {
                                x.e("MicroMsg.JsApiGetPhoneNumber", "jsonObj is null");
                                eVar.jjI.E(eVar.jgb, eVar.e("fail:jsonObj is null", null));
                                return;
                            }
                            boolean z;
                            eVar.jjL = jSONObject.optString(SlookAirButtonFrequentContactAdapter.DATA);
                            JSONObject optJSONObject = jSONObject.optJSONObject(SlookAirButtonFrequentContactAdapter.DATA);
                            if (optJSONObject == null && !TextUtils.isEmpty(eVar.jjL)) {
                                try {
                                    optJSONObject = new JSONObject(eVar.jjL);
                                } catch (JSONException e2) {
                                    x.e("MicroMsg.JsApiGetPhoneNumber", "new dataJson exist exception, e:%s", e2.getMessage());
                                }
                            }
                            if (optJSONObject != null) {
                                eVar.fBa = optJSONObject.optString("mobile");
                                boolean optBoolean = optJSONObject.optBoolean("need_auth", false);
                                eVar.jjO = optJSONObject.optBoolean("allow_send_sms", false);
                                z = optBoolean;
                            } else {
                                z = false;
                            }
                            eVar.signature = jSONObject.optString("signature");
                            eVar.jjM = jSONObject.optString("encryptedData");
                            eVar.atl = jSONObject.optString("iv");
                            x.i("MicroMsg.JsApiGetPhoneNumber", "mobile:%s, need_auth:%b, allow_send_sms:%b", eVar.fBa, Boolean.valueOf(z), Boolean.valueOf(eVar.jjO));
                            if (eVar.jjV == 0) {
                                if (TextUtils.isEmpty(eVar.fBa)) {
                                    eVar.jjV = 3;
                                } else if (z) {
                                    eVar.jjV = 2;
                                } else {
                                    eVar.jjV = 1;
                                }
                            }
                            if (TextUtils.isEmpty(eVar.fBa)) {
                                x.i("MicroMsg.JsApiGetPhoneNumber", "show the confirm bind phone dialog");
                                h.a(eVar.jjI.mContext, eVar.jjI.getContentView().getResources().getString(j.iBD), eVar.jjI.getContentView().getResources().getString(j.iBE), eVar.jjI.getContentView().getResources().getString(j.iBK), eVar.jjI.getContentView().getResources().getString(j.dEy), false, new OnClickListener() {
                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                        x.i("MicroMsg.JsApiGetPhoneNumber", "confirm bind phone number");
                                        dialogInterface.dismiss();
                                        c cVar = c.this;
                                        x.i("MicroMsg.JsApiGetPhoneNumber", "doBindPhoneNumber()");
                                        Intent intent = new Intent(cVar.jjI.mContext, AppBrandRedirectUI.class);
                                        intent.putExtra("key_from_scene", 0);
                                        MMActivity mMActivity = (MMActivity) cVar.jjI.mContext;
                                        mMActivity.jCj = new AnonymousClass8(mMActivity);
                                        mMActivity.startActivityForResult(intent, 100);
                                    }
                                }, new OnClickListener() {
                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                        x.i("MicroMsg.JsApiGetPhoneNumber", "cancel to bind phone number");
                                        dialogInterface.dismiss();
                                        c.this.jjI.E(c.this.jgb, c.this.e("fail:cancel to bind phone", null));
                                        g.pWK.h(14249, c.this.jjI.mAppId, Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(c.this.jjW), Integer.valueOf(c.this.jjX), Integer.valueOf(c.this.jjV));
                                    }
                                });
                                return;
                            }
                            x.i("MicroMsg.JsApiGetPhoneNumber", "show the confirm login dialog");
                            LayoutInflater layoutInflater = (LayoutInflater) eVar.jjI.mContext.getSystemService("layout_inflater");
                            View inflate = layoutInflater.inflate(q.h.izo, null);
                            ImageView imageView = (ImageView) inflate.findViewById(q.g.iwl);
                            TextView textView = (TextView) inflate.findViewById(q.g.iwi);
                            ImageView imageView2 = (ImageView) inflate.findViewById(q.g.iwn);
                            TextView textView2 = (TextView) inflate.findViewById(q.g.iwj);
                            TextView textView3 = (TextView) inflate.findViewById(q.g.iwm);
                            View inflate2 = layoutInflater.inflate(q.h.izn, null);
                            TextView textView4 = (TextView) inflate2.findViewById(q.g.iwk);
                            if (bi.oN(str)) {
                                str = eVar.jjI.getContentView().getResources().getString(j.iBx);
                            }
                            String string = eVar.jjI.getContentView().getResources().getString(j.iBy);
                            com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a aVar = new com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a();
                            aVar.appId = eVar.jjI.mAppId;
                            aVar.fDk = eVar.jjI.jJw.jKx;
                            aVar.fqZ = 8;
                            a aVar2 = new a(l.a(aVar.acv()));
                            CharSequence spannableString = new SpannableString(str + string);
                            spannableString.setSpan(aVar2, str.length(), str.length() + string.length(), 18);
                            textView4.setMovementMethod(LinkMovementMethod.getInstance());
                            textView4.setText(spannableString);
                            if (TextUtils.isEmpty(charSequence2)) {
                                textView.setVisibility(8);
                            } else {
                                textView.setText(charSequence2);
                                textView.setVisibility(0);
                            }
                            textView2.setText(charSequence3);
                            if (TextUtils.isEmpty(eVar.jjN)) {
                                textView3.setVisibility(8);
                            } else {
                                textView3.setText(eVar.jjN);
                                textView3.setVisibility(0);
                            }
                            if (TextUtils.isEmpty(str2)) {
                                imageView.setImageDrawable(com.tencent.mm.modelappbrand.a.a.Jo());
                            } else {
                                com.tencent.mm.modelappbrand.a.b.Jp().a(imageView, str2, com.tencent.mm.modelappbrand.a.a.Jo(), f.hmb);
                            }
                            imageView2.setOnClickListener(new AnonymousClass12(inflate2));
                            h.a(eVar.jjI.mContext, false, eVar.jjI.getContentView().getResources().getString(j.iBC), inflate, eVar.jjI.getContentView().getResources().getString(j.iBB), eVar.jjI.getContentView().getResources().getString(j.dEy), new AnonymousClass13(z), new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    x.i("MicroMsg.JsApiGetPhoneNumber", "cancel to confirm login");
                                    dialogInterface.dismiss();
                                    c.this.jjI.E(c.this.jgb, c.this.e("fail:cancel to confirm login", null));
                                    g.pWK.h(14249, c.this.jjI.mAppId, Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(c.this.jjW), Integer.valueOf(c.this.jjX), Integer.valueOf(c.this.jjV));
                                }
                            });
                        }
                    });
                    return;
                }
                x.e("MicroMsg.JsApiGetPhoneNumber", "getPhoneNumber JsOperateWxData cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", Integer.valueOf(i), Integer.valueOf(i2), str, bVar.hnR.hnY);
                c.this.jjI.E(c.this.jgb, c.this.e("fail:JsOperateWxData cgi fail", null));
            }
        });
    }

    final void afY() {
        x.i("MicroMsg.JsApiGetPhoneNumber", "doSuccCallback");
        Map hashMap = new HashMap(5);
        hashMap.put("encryptedData", this.jjM);
        hashMap.put("iv", this.atl);
        this.jjI.E(this.jgb, e("ok", hashMap));
    }

    final void afZ() {
        x.i("MicroMsg.JsApiGetPhoneNumber", "updateSendText()");
        Object string = this.jjI.getContentView().getResources().getString(j.iBF);
        Object string2 = this.jjI.getContentView().getResources().getString(j.iBH);
        CharSequence spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append(string);
        spannableStringBuilder.append(string2);
        int length = string.length();
        int length2 = string2.length();
        spannableStringBuilder.setSpan(new ClickableSpan() {
            public final void onClick(View view) {
                x.i("MicroMsg.JsApiGetPhoneNumber", "click the resend spanBuilder, do resend sms");
                if (c.this.jjO) {
                    c.b(c.this);
                    return;
                }
                x.e("MicroMsg.JsApiGetPhoneNumber", "allow_send_sms is false, show send_verify_code_frequent error");
                c.this.sC(c.this.jjI.getContentView().getResources().getString(j.iBJ));
            }
        }, length, length + length2, 17);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(this.jjI.mContext.getResources().getColor(d.btd)), length, length2 + length, 17);
        this.jjR.setText(spannableStringBuilder);
        this.jjR.setMovementMethod(LinkMovementMethod.getInstance());
    }

    final void sC(String str) {
        aga();
        h.a(this.jjI.mContext, str, "", false, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                c.this.jjI.E(c.this.jgb, c.this.e("fail", null));
            }
        });
    }

    final void aga() {
        x.i("MicroMsg.JsApiGetPhoneNumber", "stopSmsListener");
        if (this.jjS != null) {
            this.jjS.cancel();
        }
        if (this.jjT != null) {
            this.jjT.stop();
            this.jjT.qEc = null;
        }
    }
}
