package com.tencent.mm.ui.f.a;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.plugin.comm.a.d;
import com.tencent.mm.plugin.comm.a.h;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;
import com.tencent.xweb.p;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.JSEXECUTECHECK})
public final class f extends k {
    static final float[] zlf = new float[]{20.0f, 60.0f};
    static final float[] zlg = new float[]{40.0f, 60.0f};
    static final LayoutParams zlh = new LayoutParams(-1, -1);
    private MMWebView jAa;
    private String mUrl;
    private com.tencent.mm.ui.f.a.c.a zli;
    private ProgressDialog zlj;
    private ImageView zlk;
    private FrameLayout zll;

    private class a extends p {
        boolean zln;

        private a() {
            this.zln = true;
        }

        /* synthetic */ a(f fVar, byte b) {
            this();
        }

        public final boolean b(WebView webView, String str) {
            x.d("Facebook-WebView", "Redirect URL: " + str);
            if (str.startsWith("fbconnect://success")) {
                Bundle aas = e.aas(str);
                String string = aas.getString("error");
                if (string == null) {
                    string = aas.getString("error_type");
                }
                if (string == null) {
                    f.this.zli.k(aas);
                } else if (string.equals("access_denied") || string.equals("OAuthAccessDeniedException")) {
                    f.this.zli.onCancel();
                } else {
                    f.this.zli.a(new d(string));
                }
                f.this.dismiss();
                return true;
            } else if (str.startsWith("fbconnect://cancel")) {
                f.this.zli.onCancel();
                try {
                    f.this.dismiss();
                    return true;
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.FbDialog", e, "", new Object[0]);
                    return true;
                }
            } else if (str.contains("touch")) {
                return false;
            } else {
                f.this.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                return true;
            }
        }

        public final void a(WebView webView, int i, String str, String str2) {
            super.a(webView, i, str, str2);
            this.zln = false;
            f.this.zli.a(new b(str, i, str2));
            try {
                f.this.dismiss();
                f.this.zlj.dismiss();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.FbDialog", e, "", new Object[0]);
            }
        }

        public final void b(WebView webView, String str, Bitmap bitmap) {
            x.d("Facebook-WebView", "Webview loading URL: " + str);
            super.b(webView, str, bitmap);
            try {
                f.this.zlj.show();
                f.this.zlj.setOnDismissListener(new OnDismissListener() {
                    public final void onDismiss(DialogInterface dialogInterface) {
                        if (a.this.zln && f.this != null) {
                            f.this.zli.onCancel();
                            f.this.dismiss();
                        }
                    }
                });
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.FbDialog", e, "", new Object[0]);
            }
        }

        public final void a(WebView webView, String str) {
            super.a(webView, str);
            this.zln = false;
            try {
                f.this.zlj.dismiss();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.FbDialog", e, "", new Object[0]);
            }
            f.this.zll.setBackgroundColor(0);
            f.this.jAa.setVisibility(0);
            f.this.zlk.setVisibility(0);
        }
    }

    public f(Context context, String str, com.tencent.mm.ui.f.a.c.a aVar) {
        super(context, 16973840);
        this.mUrl = str;
        this.zli = aVar;
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.zlj = new ProgressDialog(getContext());
        this.zlj.requestWindowFeature(1);
        this.zlj.setMessage(getContext().getString(h.luj));
        requestWindowFeature(1);
        this.zll = new FrameLayout(getContext());
        this.zlk = new ImageView(getContext());
        this.zlk.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                f.this.zli.onCancel();
                f.this.dismiss();
            }
        });
        this.zlk.setImageDrawable(getContext().getResources().getDrawable(d.ltx));
        this.zlk.setVisibility(4);
        int intrinsicWidth = this.zlk.getDrawable().getIntrinsicWidth() / 2;
        View linearLayout = new LinearLayout(getContext());
        this.jAa = com.tencent.mm.ui.widget.MMWebView.a.co(getContext());
        this.jAa.setVerticalScrollBarEnabled(false);
        this.jAa.setHorizontalScrollBarEnabled(false);
        this.jAa.setWebViewClient(new a());
        this.jAa.getSettings().setJavaScriptEnabled(true);
        this.jAa.loadUrl(this.mUrl);
        this.jAa.setLayoutParams(zlh);
        this.jAa.setVisibility(4);
        linearLayout.setPadding(intrinsicWidth, intrinsicWidth, intrinsicWidth, intrinsicWidth);
        linearLayout.addView(this.jAa);
        this.zll.addView(linearLayout);
        this.zll.addView(this.zlk, new ViewGroup.LayoutParams(-2, -2));
        addContentView(this.zll, new ViewGroup.LayoutParams(-1, -1));
    }

    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        this.zli.onCancel();
        dismiss();
        return true;
    }
}
