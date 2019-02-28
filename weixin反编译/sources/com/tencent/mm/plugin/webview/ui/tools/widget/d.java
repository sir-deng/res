package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.webkit.GeolocationPermissions.Callback;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;
import com.tencent.xweb.WebView;
import com.tencent.xweb.e;
import com.tencent.xweb.f;
import com.tencent.xweb.j;

public class d extends j {
    private Activity fBA;
    private int nfb = 0;

    public d(MMWebViewWithJsApi mMWebViewWithJsApi) {
        this.fBA = (Activity) mMWebViewWithJsApi.getContext();
    }

    public void d(WebView webView, String str) {
        super.d(webView, str);
    }

    public final void onGeolocationPermissionsShowPrompt(final String str, final Callback callback) {
        h.a(this.fBA, false, this.fBA.getString(R.l.eYD, new Object[]{str}), this.fBA.getString(R.l.eYE), this.fBA.getString(R.l.dGf), this.fBA.getString(R.l.dEy), new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                callback.invoke(str, true, true);
            }
        }, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                callback.invoke(str, false, false);
            }
        });
    }

    public final boolean a(WebView webView, String str, String str2, final f fVar) {
        i a;
        this.nfb++;
        if (this.nfb > 2) {
            a = h.a(this.fBA, str2, "", this.fBA.getString(R.l.eYy), this.fBA.getString(R.l.dGf), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    fVar.cancel();
                    if (dialogInterface != null) {
                        dialogInterface.dismiss();
                    }
                    d.this.onClose();
                }
            }, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    fVar.confirm();
                }
            }, R.e.btd);
        } else {
            a = h.a(this.fBA, str2, "", this.fBA.getString(R.l.dGf), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    fVar.confirm();
                }
            });
        }
        if (a == null) {
            return super.a(webView, str, str2, fVar);
        }
        a.setCanceledOnTouchOutside(false);
        a.mn(false);
        return true;
    }

    public final boolean b(WebView webView, String str, String str2, final f fVar) {
        i a;
        this.nfb++;
        if (this.nfb > 2) {
            a = h.a(this.fBA, str2, "", this.fBA.getString(R.l.eYy), this.fBA.getString(R.l.dGf), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    fVar.cancel();
                    if (dialogInterface != null) {
                        dialogInterface.dismiss();
                    }
                    d.this.onClose();
                }
            }, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    fVar.confirm();
                }
            }, R.e.brB);
        } else {
            a = h.a(this.fBA, false, str2, "", this.fBA.getString(R.l.dGf), this.fBA.getString(R.l.dEy), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    fVar.confirm();
                }
            }, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    fVar.cancel();
                }
            });
        }
        if (a == null) {
            return super.b(webView, str, str2, fVar);
        }
        a.setCancelable(false);
        a.setCanceledOnTouchOutside(false);
        return true;
    }

    public final boolean a(WebView webView, String str, String str2, String str3, e eVar) {
        return super.a(webView, str, str2, str3, eVar);
    }

    public void onClose() {
        this.fBA.finish();
    }
}
