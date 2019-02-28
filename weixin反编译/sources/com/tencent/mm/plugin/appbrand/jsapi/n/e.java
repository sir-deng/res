package com.tencent.mm.plugin.appbrand.jsapi.n;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.webkit.ValueCallback;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.v;
import com.tencent.mm.plugin.webview.modeltools.c;
import com.tencent.mm.plugin.webview.modeltools.g;
import com.tencent.mm.plugin.webview.stub.WebviewScanImageActivity;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;
import org.json.JSONObject;

public class e implements OnCreateContextMenuListener, com.tencent.mm.plugin.appbrand.jsapi.n.c.b {
    private String jAd;
    MMWebViewWithJsApi jAj;
    private b jAk;
    private a jAl;
    private d jAm;
    private com.tencent.mm.plugin.webview.ui.tools.e jAn;
    private l jAo;
    private String jAp;
    int jAq;
    int jAr;
    g jAs;
    com.tencent.xweb.WebView.a jAt;
    com.tencent.xweb.WebView.a jAu;
    private final c jAv = new c();
    private final c.c jAw;
    private com.tencent.mm.plugin.webview.ui.tools.widget.g jAx = new com.tencent.mm.plugin.webview.ui.tools.widget.g() {
        public final Bundle e(int i, Bundle bundle) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("key_webview_container_env", "miniProgram");
            switch (i) {
                case 101:
                    bundle.setClassLoader(e.class.getClassLoader());
                    com.tencent.mm.bl.d.b(e.this.jAj.getContext(), bundle.getString("open_ui_with_webview_ui_plugin_name"), bundle.getString("open_ui_with_webview_ui_plugin_entry"), new Intent().putExtras(bundle.getBundle("open_ui_with_webview_ui_extras")));
                    break;
                case v.CTRL_INDEX /*139*/:
                    try {
                        e.this.jAw.u(new JSONObject(bundle.getString("info")));
                        break;
                    } catch (Exception e) {
                        break;
                    }
                case com.tencent.mm.plugin.appbrand.jsapi.map.b.CTRL_INDEX /*140*/:
                    bundle2.putInt("key_webview_preverify_info_scene", 1);
                    bundle2.putString("key_webview_preverify_info_source_appid", e.this.jAw.getAppId());
                    break;
                case com.tencent.mm.plugin.appbrand.jsapi.contact.c.CTRL_INDEX /*145*/:
                    bundle2.putStringArray("key_webview_apbrand_jsapi_report_args", e.this.jAw.aij());
                    break;
            }
            return bundle2;
        }

        public final void f(String str, final String str2, int i, int i2) {
            x.d("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "result: " + str2);
            if (e.this.jAs != null && str != null && str.equals(e.this.jAs.tBB) && i == 22) {
                if (e.this.jAs != null) {
                    e.this.jAs.bSt();
                }
                e.this.jAq = i;
                e.this.jAr = i2;
                if (str2 != null && e.this.jAo != null) {
                    e.this.jAw.runOnUiThread(new Runnable() {
                        public final void run() {
                            e.this.jAp = str2;
                            e.this.jAo.b(e.this.jAj, new OnCreateContextMenuListener() {
                                public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                                    if (e.this.jAt != null) {
                                        x.d("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "show webkit menu");
                                        e.this.b(contextMenu, e.this.jAt);
                                        e.this.jAt = null;
                                    } else if (e.this.jAu != null) {
                                        x.d("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "show IX5 menu");
                                        e.this.a(contextMenu, e.this.jAu);
                                        e.this.jAu = null;
                                    }
                                }
                            }, null);
                            e.this.jAo.bCH();
                        }
                    });
                }
            }
        }
    };
    private g.c jAy = new g.c() {
        public final void ty(String str) {
            try {
                if (e.this.jAm != null) {
                    e.this.jAm.c(str, new int[]{5});
                    return;
                }
                x.i("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "viewCaptureCallback, invoker is null");
            } catch (RemoteException e) {
                x.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "recog failed");
            }
        }
    };

    private class a extends com.tencent.mm.plugin.webview.ui.tools.widget.d {
        a(MMWebViewWithJsApi mMWebViewWithJsApi) {
            super(mMWebViewWithJsApi);
        }

        public final void d(WebView webView, String str) {
            super.d(webView, str);
            e.this.jAw.tv(str);
        }

        protected final void onClose() {
            e.this.jAw.aig();
        }

        public final void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
            a(valueCallback, null, str, str2);
        }

        public final boolean a(WebView webView, ValueCallback<Uri[]> valueCallback, com.tencent.xweb.j.a aVar) {
            if (aVar.getMode() != 0) {
                return false;
            }
            if (aVar.getAcceptTypes() == null || aVar.getAcceptTypes().length <= 0) {
                x.i("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "onShowFileChooser, mode = MODE_OPEN, but params.getAcceptTypes is null");
                return true;
            }
            String str = aVar.getAcceptTypes()[0];
            String str2 = "*";
            if (aVar.isCaptureEnabled()) {
                if ("image/*".equalsIgnoreCase(str)) {
                    str2 = "camera";
                } else if ("video/*".equalsIgnoreCase(str)) {
                    str2 = "camcorder";
                }
            }
            a(null, valueCallback, str, str2);
            return true;
        }

        private void a(ValueCallback<Uri> valueCallback, ValueCallback<Uri[]> valueCallback2, String str, String str2) {
            if (e.this.jAj.getContext() instanceof MMActivity) {
                final MMActivity mMActivity = (MMActivity) e.this.jAj.getContext();
                mMActivity.jCj = new com.tencent.mm.ui.MMActivity.a() {
                    public final void b(int i, int i2, Intent intent) {
                        e.this.jAv.b(mMActivity, i, i2, intent);
                    }
                };
                e.this.jAv.a(mMActivity, e.this.jAn, valueCallback, valueCallback2, str, str2);
            }
        }
    }

    private class b extends com.tencent.mm.plugin.webview.ui.tools.widget.e {
        b(MMWebView mMWebView) {
            super(mMWebView);
        }

        protected final com.tencent.mm.plugin.webview.ui.tools.widget.g ail() {
            return e.this.jAx;
        }

        protected final void a(d dVar, com.tencent.mm.plugin.webview.ui.tools.e eVar) {
            e.this.jAm = dVar;
            e.this.jAn = eVar;
            try {
                Bundle bundle = new Bundle();
                bundle.putString("key_webview_container_env", "miniProgram");
                Bundle bundle2 = new Bundle();
                bundle2.putBundle("jsapiargs", bundle);
                dVar.a(20, bundle2, this.jAa.hashCode());
            } catch (RemoteException e) {
                x.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "onServiceConnected, invoke AC_SET_INITIAL_ARGS, ex = " + e.getMessage());
            }
        }

        protected final void a(WebView webView, String str, Bitmap bitmap) {
            e.this.jAd = str;
            e.this.jAw.aif();
        }

        protected final void e(WebView webView, String str) {
            e.this.jAd = str;
            e.this.jAw.tw(str);
        }

        protected final int aim() {
            return 49;
        }

        protected final void e(Bundle bundle, String str) {
            super.e(bundle, str);
            bundle.putString("geta8key_data_appid", e.this.jAw.getAppId());
        }
    }

    static /* synthetic */ void c(e eVar, String str) {
        Intent intent = new Intent();
        intent.putExtra("Retr_File_Name", str);
        intent.putExtra("Retr_Compress_Type", 0);
        intent.putExtra("Retr_Msg_Type", 0);
        if (intent.getIntExtra("Retr_Msg_Type", -1) < 0) {
            intent.putExtra("Retr_Msg_Type", 4);
        }
        com.tencent.mm.bl.d.a(eVar.jAj.getContext(), ".ui.transmit.MsgRetransmitUI", intent);
    }

    static /* synthetic */ void d(e eVar, String str) {
        try {
            if (eVar.jAm.Px(str) == 0) {
                Toast.makeText(eVar.jAj.getContext(), eVar.jAj.getContext().getString(R.l.egi), 0).show();
            }
        } catch (Exception e) {
            x.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "favoriteUrl fail, ex = " + e.getMessage());
        }
    }

    public e(c.c cVar) {
        this.jAw = cVar;
        this.jAj = (MMWebViewWithJsApi) cVar.aie();
        this.jAk = new b(this.jAj);
        this.jAl = new a(this.jAj);
        this.jAj.setWebViewClient(this.jAk);
        this.jAj.setWebChromeClient(this.jAl);
        this.jAj.tQU = true;
        this.jAo = new l(this.jAj.getContext());
        this.jAo.a(this.jAj, this, null);
        this.jAo.e(new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                if (e.this.jAs != null && e.this.jAm != null) {
                    try {
                        e.this.jAm.Pz(e.this.jAs.tBB);
                        e.this.jAs.bSt();
                    } catch (Exception e) {
                        x.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "cancel capture failed");
                    }
                }
            }
        });
    }

    public final void cleanup() {
        this.jAk.cleanup();
        this.jAj.destroy();
    }

    private boolean a(ContextMenu contextMenu, final String str) {
        boolean isSDCardAvailable;
        try {
            isSDCardAvailable = this.jAm.isSDCardAvailable();
        } catch (Exception e) {
            x.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "onCreateContextMenu fail, ex = " + e.getMessage());
            isSDCardAvailable = false;
        }
        if (!isSDCardAvailable) {
            return true;
        }
        if (this.jAn == null) {
            return true;
        }
        contextMenu.setHeaderTitle(R.l.eYG);
        try {
            isSDCardAvailable = this.jAm.aPk();
        } catch (Exception e2) {
            x.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "get has setuin failed : %s", e2.getMessage());
            isSDCardAvailable = false;
        }
        x.i("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "hasSetAcc = %b, canShareImage = %b, canFavImage = %b", Boolean.valueOf(isSDCardAvailable), Boolean.valueOf(this.jAn.bTg().ceq()), Boolean.valueOf(this.jAn.bTg().cer()));
        if (isSDCardAvailable && r3) {
            contextMenu.add(0, 0, 0, this.jAj.getContext().getString(R.l.eBX)).setOnMenuItemClickListener(new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    try {
                        s.a(e.this.jAj.getContext(), str, com.tencent.xweb.b.cJc().getCookie(str), e.this.jAm.isSDCardAvailable(), new com.tencent.mm.pluginsdk.ui.tools.s.b() {
                            public final void tx(String str) {
                                if (bi.oN(str)) {
                                    x.w("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "share image to friend fail, imgPath is null");
                                } else {
                                    e.c(e.this, str);
                                }
                            }
                        });
                    } catch (Exception e) {
                        x.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "onMenuItemClick fail, ex = " + e.getMessage());
                    }
                    return true;
                }
            });
        }
        contextMenu.add(0, 0, 0, this.jAj.getContext().getString(R.l.eHt)).setOnMenuItemClickListener(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                boolean isSDCardAvailable;
                try {
                    isSDCardAvailable = e.this.jAm.isSDCardAvailable();
                } catch (Exception e) {
                    x.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "onMenuItemClick fail, ex = " + e.getMessage());
                    isSDCardAvailable = false;
                }
                try {
                    s.a(e.this.jAj.getContext(), str, com.tencent.xweb.b.cJc().getCookie(str), isSDCardAvailable);
                } catch (Exception e2) {
                    x.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "save to sdcard failed : %s", e2.getMessage());
                }
                return true;
            }
        });
        if (isSDCardAvailable && r4) {
            contextMenu.add(0, 0, 0, this.jAj.getContext().getString(R.l.eAq)).setOnMenuItemClickListener(new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    try {
                        boolean isSDCardAvailable = e.this.jAm.isSDCardAvailable();
                        String replaceAll = str.replaceAll("tp=webp", "");
                        s.a(e.this.jAj.getContext(), replaceAll, com.tencent.xweb.b.cJc().getCookie(replaceAll), isSDCardAvailable, new com.tencent.mm.pluginsdk.ui.tools.s.b() {
                            public final void tx(String str) {
                                e.d(e.this, str);
                            }
                        });
                    } catch (Exception e) {
                        x.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "onMenuItemClick fail, ex = " + e.getMessage());
                    }
                    return true;
                }
            });
        }
        if (this.jAp == null) {
            return false;
        }
        CharSequence string;
        final String str2 = this.jAp;
        if (com.tencent.mm.plugin.scanner.a.aF(this.jAq, this.jAp)) {
            string = this.jAj.getContext().getString(R.l.eCE);
        } else {
            string = this.jAj.getContext().getString(R.l.eCD);
        }
        contextMenu.add(0, 0, 0, string).setOnMenuItemClickListener(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                e eVar = e.this;
                String str = str2;
                String i = e.this.jAd;
                String str2 = str;
                int i2 = e.this.jAq;
                int i3 = e.this.jAr;
                if (str != null) {
                    Intent intent = new Intent();
                    intent.setClass(eVar.jAj.getContext(), WebviewScanImageActivity.class);
                    intent.putExtra("key_string_for_scan", str);
                    intent.putExtra("key_string_for_url", i);
                    intent.putExtra("key_string_for_image_url", str2);
                    intent.putExtra("key_codetype_for_scan", i2);
                    intent.putExtra("key_codeversion_for_scan", i3);
                    eVar.jAj.getContext().startActivity(intent);
                }
                return false;
            }
        });
        this.jAp = null;
        return true;
    }

    private void a(ContextMenu contextMenu, com.tencent.xweb.WebView.a aVar) {
        if (!a(contextMenu, aVar.mExtra) && this.jAn.bTg().ceo()) {
            this.jAu = aVar;
            this.jAs = new g();
            this.jAs.a(this.jAj, this.jAy);
        }
    }

    private void b(ContextMenu contextMenu, com.tencent.xweb.WebView.a aVar) {
        if (!a(contextMenu, aVar.mExtra) && this.jAn.bTg().ceo()) {
            this.jAt = aVar;
            this.jAs = new g();
            this.jAs.a(this.jAj, this.jAy);
        }
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        com.tencent.xweb.WebView.a hitTestResult;
        if (view instanceof android.webkit.WebView) {
            hitTestResult = this.jAj.getHitTestResult();
            if (hitTestResult != null) {
                if (hitTestResult.mType == 5 || hitTestResult.mType == 8) {
                    b(contextMenu, hitTestResult);
                }
            }
        } else if (view instanceof MMWebView) {
            hitTestResult = ((MMWebView) view).getHitTestResult();
            if (hitTestResult == null) {
                return;
            }
            if (hitTestResult.mType == 5 || hitTestResult.mType == 8) {
                a(contextMenu, hitTestResult);
            }
        }
    }
}
