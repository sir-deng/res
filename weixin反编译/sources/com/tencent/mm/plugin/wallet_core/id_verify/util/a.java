package com.tencent.mm.plugin.wallet_core.id_verify.util;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.ad.b;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.bl.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.protocal.c.boy;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public final class a implements e {
    int itU = -1;
    private a sQr = null;
    WeakReference<MMActivity> sQs;
    WeakReference<com.tencent.mm.wallet_core.d.e> sQt;
    private boolean sQu = false;
    i sQv;

    /* renamed from: com.tencent.mm.plugin.wallet_core.id_verify.util.a$3 */
    static class AnonymousClass3 implements OnClickListener {
        final /* synthetic */ Activity ieT;
        final /* synthetic */ boolean sQz = false;

        AnonymousClass3(boolean z, Activity activity) {
            this.ieT = activity;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            x.i("MicroMsg.RealnameVerifyUtil", "showUploadCreditDialog click cancel");
            dialogInterface.dismiss();
            if (this.sQz) {
                this.ieT.finish();
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.id_verify.util.a$4 */
    static class AnonymousClass4 implements OnClickListener {
        final /* synthetic */ Activity ieT;
        final /* synthetic */ Bundle juD;
        final /* synthetic */ int sQw;
        final /* synthetic */ boolean sQz = false;

        AnonymousClass4(Bundle bundle, int i, Activity activity, boolean z) {
            this.juD = bundle;
            this.sQw = i;
            this.ieT = activity;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            x.i("MicroMsg.RealnameVerifyUtil", "showUploadCreditDialog click OK");
            x.i("MicroMsg.RealnameVerifyUtil", "showRealnameDialog click OK");
            Bundle bundle = this.juD;
            if (this.juD == null) {
                bundle = new Bundle();
            }
            bundle.putInt("real_name_verify_mode", 0);
            bundle.putInt("entry_scene", this.sQw);
            bundle.putBoolean("key_from_set_pwd", true);
            com.tencent.mm.wallet_core.a.a(this.ieT, com.tencent.mm.plugin.wallet_core.id_verify.a.class, bundle);
            com.tencent.mm.wallet_core.ui.e.a(19, bi.Wx(), this.sQw);
            dialogInterface.dismiss();
            if (this.sQz) {
                this.ieT.finish();
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.id_verify.util.a$5 */
    static class AnonymousClass5 implements OnCancelListener {
        final /* synthetic */ Activity ieT;
        final /* synthetic */ boolean sQz = false;

        AnonymousClass5(boolean z, Activity activity) {
            this.ieT = activity;
        }

        public final void onCancel(DialogInterface dialogInterface) {
            if (this.sQz) {
                this.ieT.finish();
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.id_verify.util.a$6 */
    static class AnonymousClass6 implements OnDismissListener {
        final /* synthetic */ Activity ieT;
        final /* synthetic */ boolean sQz = false;

        AnonymousClass6(boolean z, Activity activity) {
            this.ieT = activity;
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            if (this.sQz) {
                this.ieT.finish();
            }
        }
    }

    public interface a {
        boolean b(int i, int i2, String str, boolean z);
    }

    public final boolean a(MMActivity mMActivity, com.tencent.mm.wallet_core.d.e eVar, boolean z, int i) {
        this.sQu = false;
        g.Dr();
        long longValue = ((Long) g.Dq().Db().get(com.tencent.mm.storage.w.a.USERINFO_WALLET_REALNAME_DISCLAIMER_QUERY_EXPIRED_TIME_LONG_SYNC, Long.valueOf(0))).longValue();
        if (longValue > 0) {
            long currentTimeMillis = System.currentTimeMillis();
            com.tencent.mm.wallet_core.ui.e.a(5, bi.Wx(), i);
            if (currentTimeMillis < longValue) {
                x.i("MicroMsg.RealnameVerifyUtil", "getDisclaimer query is not expired. expiredTime = " + longValue);
                return false;
            }
            x.i("MicroMsg.RealnameVerifyUtil", "getDisclaimer query had expired. expiredTime = " + longValue);
        }
        if (mMActivity == null) {
            x.e("MicroMsg.RealnameVerifyUtil", "context is null");
        } else if (eVar == null) {
            x.e("MicroMsg.RealnameVerifyUtil", "netmgr is null");
        }
        return false;
    }

    private void aXK() {
        if (this.sQt != null && this.sQt.get() != null) {
            ((com.tencent.mm.wallet_core.d.e) this.sQt.get()).aXK();
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar instanceof com.tencent.mm.plugin.wallet_core.id_verify.model.e) {
            g.Dr();
            g.Dp().gRu.b(385, (e) this);
            aXK();
            if (i == 0 && i2 == 0) {
                com.tencent.mm.plugin.wallet_core.id_verify.model.e eVar = (com.tencent.mm.plugin.wallet_core.id_verify.model.e) kVar;
                boolean equals = eVar.sQb.equals("1");
                if (equals) {
                    x.i("MicroMsg.RealnameVerifyUtil", "user had agreed");
                    c(0, i2, str, equals);
                    return;
                }
                a((MMActivity) this.sQs.get(), (com.tencent.mm.wallet_core.d.e) this.sQt.get(), eVar.title, eVar.sQc, eVar.sQd, eVar.sQe, this.sQr, false, eVar.sQf);
                return;
            }
            c(2, i2, str, false);
        } else if (kVar instanceof com.tencent.mm.plugin.wallet_core.id_verify.model.a) {
            g.Dr();
            g.Dp().gRu.a(385, (e) this);
            aXK();
            if (i == 0 && i2 == 0) {
                c(0, i2, str, true);
            } else {
                c(3, i2, str, false);
            }
        }
    }

    public final void a(final MMActivity mMActivity, com.tencent.mm.wallet_core.d.e eVar, String str, String str2, final String str3, String str4, a aVar, boolean z, int i) {
        this.sQs = new WeakReference(mMActivity);
        this.sQt = new WeakReference(eVar);
        this.sQu = z;
        if (this.sQs != null && this.sQs.get() != null) {
            this.sQr = aVar;
            CharSequence charSequence = str + str2;
            com.tencent.mm.plugin.wallet_core.ui.g gVar = new com.tencent.mm.plugin.wallet_core.ui.g(mMActivity);
            final int i2 = i;
            gVar.sZF = new com.tencent.mm.plugin.wallet_core.ui.g.a() {
                public final void onClick(View view) {
                    com.tencent.mm.wallet_core.ui.e.a(3, bi.Wx(), i2);
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", str3);
                    intent.putExtra("showShare", false);
                    d.b(mMActivity, "webview", ".ui.tools.WebViewUI", intent);
                }
            };
            charSequence = com.tencent.mm.pluginsdk.ui.d.i.a((Context) mMActivity, charSequence);
            CharSequence spannableString = new SpannableString(charSequence);
            spannableString.setSpan(gVar, charSequence.length() - str2.length(), charSequence.length(), 33);
            View textView = new TextView(mMActivity);
            textView.setText(spannableString);
            textView.setTextSize(0, (float) com.tencent.mm.bu.a.aa(mMActivity, com.tencent.mm.plugin.wxpay.a.d.bvt));
            textView.setTextColor(mMActivity.getResources().getColorStateList(c.btv));
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            com.tencent.mm.wallet_core.ui.e.a(0, bi.Wx(), i);
            String string = mMActivity.getString(com.tencent.mm.plugin.wxpay.a.i.dEy);
            i2 = i;
            OnClickListener anonymousClass7 = new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    com.tencent.mm.wallet_core.ui.e.a(2, bi.Wx(), i2);
                    if (a.this.sQt != null && a.this.sQt.get() != null) {
                        g.Dr();
                        g.Dp().gRu.a(385, a.this);
                        ((com.tencent.mm.wallet_core.d.e) a.this.sQt.get()).a(new com.tencent.mm.plugin.wallet_core.id_verify.model.a(a.this.itU), true);
                    }
                }
            };
            i2 = i;
            this.sQv = h.a((Context) mMActivity, "", textView, str4, string, anonymousClass7, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    com.tencent.mm.wallet_core.ui.e.a(1, bi.Wx(), i2);
                    a.this.c(1, -1, "cancel", false);
                }
            });
        }
    }

    final void c(int i, int i2, String str, boolean z) {
        x.i("MicroMsg.RealnameVerifyUtil", "doGetDisclaimerCallback call");
        if (this.sQr != null) {
            g.Dr();
            g.Dq().Db().a(com.tencent.mm.storage.w.a.USERINFO_WALLET_DISCLAIMER_NEED_AGERR_INT_SYNC, Integer.valueOf(z ? 0 : 1));
            this.sQr.b(i, i2, str, z);
            if (this.sQv != null) {
                this.sQv.dismiss();
            }
            this.sQu = false;
            if (this.sQv != null) {
                x.i("MicroMsg.RealnameVerifyUtil", "getDisclaimerCallback : close mDisclaimerDialog");
                this.sQv = null;
            }
            if (this.sQt != null) {
                x.i("MicroMsg.RealnameVerifyUtil", "getDisclaimerCallback : clear mNetSceneMgr");
                this.sQt.clear();
                this.sQt = null;
            }
            if (this.sQs != null) {
                x.i("MicroMsg.RealnameVerifyUtil", "getDisclaimerCallback : clear mContextReference");
                this.sQs.clear();
                this.sQs = null;
            }
            x.i("MicroMsg.RealnameVerifyUtil", "getDisclaimerCallback : clear getDisclaimerCallback");
            this.sQr = null;
        }
    }

    private static JSONObject p(k kVar) {
        if (kVar != null && (kVar instanceof com.tencent.mm.wallet_core.tenpay.model.i)) {
            b bVar = ((com.tencent.mm.wallet_core.tenpay.model.i) kVar).gLB;
            if (bVar != null) {
                boy boy = (boy) bVar.hnR.hnY;
                if (boy.wyI != null) {
                    try {
                        return new JSONObject(n.b(boy.wyI));
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.RealnameVerifyUtil", e, "", new Object[0]);
                        return null;
                    }
                }
            }
        }
        return null;
    }

    public static boolean a(Activity activity, int i, k kVar, Bundle bundle, int i2) {
        if (i != 416) {
            x.i("MicroMsg.RealnameVerifyUtil", "don't need realname verify");
            return false;
        }
        x.i("MicroMsg.RealnameVerifyUtil", "need realname verify");
        return a(activity, kVar, bundle, false, null, i2, 2);
    }

    public static boolean a(Activity activity, k kVar, Bundle bundle, boolean z, OnClickListener onClickListener, int i, int i2) {
        String str;
        String str2 = "";
        String str3 = "";
        String str4 = "";
        String str5 = "";
        String str6 = "";
        JSONObject p = p(kVar);
        if (p != null) {
            if (p.has("real_name_info")) {
                p = p.optJSONObject("real_name_info");
            }
            str2 = p.optString("guide_flag", "0");
            str3 = p.optString("guide_wording");
            str4 = p.optString("left_button_wording", activity.getString(com.tencent.mm.plugin.wxpay.a.i.dEy));
            str5 = p.optString("right_button_wording", activity.getString(com.tencent.mm.plugin.wxpay.a.i.dGf));
            str6 = p.optString("upload_credit_url", "");
            str = str2;
        } else {
            str = str2;
        }
        x.i("MicroMsg.RealnameVerifyUtil", "guide_flag = " + str + ";upload_credit_url=" + str6);
        if ("1".equals(str)) {
            x.i("MicroMsg.RealnameVerifyUtil", "showRealnameDialog");
            return a(activity, bundle, i);
        } else if (!"2".equals(str) || bi.oN(str6)) {
            x.e("MicroMsg.RealnameVerifyUtil", "guide_flag=" + str + ";upload_credit_url=null?" + bi.oN(str6));
            return false;
        } else {
            x.i("MicroMsg.RealnameVerifyUtil", "showUploadCreditDialog");
            return a(activity, str3, str6, str4, str5, z, null);
        }
    }

    public static boolean a(Activity activity, Bundle bundle, int i) {
        x.i("MicroMsg.RealnameVerifyUtil", "showRealnameDialog call %d", Integer.valueOf(0));
        x.i("MicroMsg.RealnameVerifyUtil", "showRealnameDialog click OK");
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putInt("real_name_verify_mode", 0);
        bundle.putInt("entry_scene", i);
        com.tencent.mm.wallet_core.a.a(activity, com.tencent.mm.plugin.wallet_core.id_verify.a.class, bundle);
        com.tencent.mm.wallet_core.ui.e.a(19, bi.Wx(), i);
        return true;
    }

    public static boolean a(final Activity activity, String str, final String str2, String str3, String str4, final boolean z, OnClickListener onClickListener) {
        String string;
        String string2;
        OnClickListener anonymousClass9;
        if (bi.oN(str3)) {
            string = activity.getString(com.tencent.mm.plugin.wxpay.a.i.dEy);
        } else {
            string = str3;
        }
        if (bi.oN(str4)) {
            string2 = activity.getString(com.tencent.mm.plugin.wxpay.a.i.dGf);
        } else {
            string2 = str4;
        }
        if (onClickListener == null) {
            x.i("MicroMsg.RealnameVerifyUtil", "showRealnameDialog use default calcel listener");
            anonymousClass9 = new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    x.i("MicroMsg.RealnameVerifyUtil", "showUploadCreditDialog click cancel");
                    dialogInterface.dismiss();
                    if (z) {
                        activity.finish();
                    }
                }
            };
        } else {
            anonymousClass9 = onClickListener;
        }
        i a = h.a((Context) activity, str, "", string2, string, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                x.i("MicroMsg.RealnameVerifyUtil", "showUploadCreditDialog click OK");
                Intent intent = new Intent();
                intent.putExtra("rawUrl", str2);
                intent.putExtra("showShare", false);
                d.b(activity, "webview", ".ui.tools.WebViewUI", intent);
                dialogInterface.dismiss();
                if (z) {
                    activity.finish();
                }
            }
        }, anonymousClass9, c.buj);
        if (a != null) {
            a.setOnCancelListener(new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    if (z) {
                        activity.finish();
                    }
                }
            });
            a.setOnDismissListener(new OnDismissListener() {
                public final void onDismiss(DialogInterface dialogInterface) {
                    if (z) {
                        activity.finish();
                    }
                }
            });
        }
        return true;
    }
}
