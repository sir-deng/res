package com.tencent.mm.plugin.webview.ui.tools;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.http.SslCertificate;
import android.net.http.SslCertificate.DName;
import android.net.http.SslError;
import android.util.Base64;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.R;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.WebView;
import com.tencent.xweb.h;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20141210", reviewer = 20, vComment = {EType.HTTPSCHECK})
public final class b {
    Context context;
    private final SimpleDateFormat pOG = new SimpleDateFormat("yyyy-MM-dd HH:mmZ", Locale.getDefault());
    WebView tCV;
    Map<String, List<h>> tCW;
    Map<String, Boolean> tCX;

    public b(Context context, WebView webView) {
        this.context = context;
        this.tCV = webView;
        this.tCW = new HashMap();
        this.tCX = new HashMap();
    }

    public final void a(final String str, h hVar, SslError sslError) {
        x.e("MicroMsg.WebView.MMSslErrorHandler", "onReceiveSslError, currentUrl = %s", str);
        if (this.tCV == null) {
            x.e("MicroMsg.WebView.MMSslErrorHandler", "onReceiveSslError fail, has been detached");
        } else if (bi.oN(str)) {
            hVar.cancel();
        } else {
            try {
                URL url = new URL(str);
                if (url.getHost().endsWith(".qq.com") || url.getHost().endsWith(".linkedin.com")) {
                    Boolean bool = (Boolean) this.tCX.get(str);
                    if (bool != null) {
                        x.v("MicroMsg.WebView.MMSslErrorHandler", "onReceiveSslError, already selected = %b", bool);
                        if (bool.booleanValue()) {
                            hVar.proceed();
                            return;
                        } else {
                            hVar.cancel();
                            return;
                        }
                    }
                    List list = (List) this.tCW.get(str);
                    if (list == null || list.size() == 0) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("1");
                        stringBuilder.append(",");
                        stringBuilder.append(a(str, sslError));
                        x.i("MicroMsg.WebView.MMSslErrorHandler", "reportWebViewSslError, value = %s", stringBuilder.toString());
                        g.pWK.k(11098, r0);
                        list = new ArrayList();
                        list.add(hVar);
                        this.tCW.put(str, list);
                        com.tencent.mm.ui.base.h.a(this.context, false, this.context.getString(R.l.eYj, new Object[]{url.getHost()}), this.context.getString(R.l.eYk), this.context.getString(R.l.dEC), this.context.getString(R.l.dDZ), new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                List<h> list = (List) b.this.tCW.get(str);
                                if (list == null) {
                                    x.e("MicroMsg.WebView.MMSslErrorHandler", "onReceivedSslError, continue selected, list should not be null");
                                    return;
                                }
                                b.this.tCX.put(str, Boolean.valueOf(true));
                                x.i("MicroMsg.WebView.MMSslErrorHandler", "onReceivedSslError, continue selected, list size = %d", Integer.valueOf(list.size()));
                                for (h proceed : list) {
                                    proceed.proceed();
                                }
                                list.clear();
                            }
                        }, new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                List<h> list = (List) b.this.tCW.get(str);
                                if (list == null) {
                                    x.e("MicroMsg.WebView.MMSslErrorHandler", "onReceivedSslError, cancel selected, list should not be null");
                                    return;
                                }
                                b.this.tCX.put(str, Boolean.valueOf(false));
                                x.i("MicroMsg.WebView.MMSslErrorHandler", "onReceivedSslError, cancel selected, list size = %d", Integer.valueOf(list.size()));
                                for (h cancel : list) {
                                    cancel.cancel();
                                }
                                list.clear();
                                b.this.tCV.clearSslPreferences();
                            }
                        });
                        return;
                    }
                    list.add(hVar);
                    return;
                }
                x.d("MicroMsg.WebView.MMSslErrorHandler", "host = " + url.getHost() + ", but it not end with '.qq.com' or '.linkedin.com'");
                hVar.cancel();
            } catch (Exception e) {
                x.e("MicroMsg.WebView.MMSslErrorHandler", "create url fail : " + e.getLocalizedMessage());
            }
        }
    }

    @TargetApi(14)
    private String a(String str, SslError sslError) {
        try {
            Object obj;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("<sslerror>");
            stringBuilder.append("<primaryerror>");
            if (sslError == null) {
                obj = "-1";
            } else {
                obj = Integer.valueOf(sslError.getPrimaryError());
            }
            stringBuilder.append(obj);
            stringBuilder.append("</primaryerror>");
            stringBuilder.append("<clienttime>");
            stringBuilder.append(Base64.encodeToString(this.pOG.format(new Date()).getBytes(), 0));
            stringBuilder.append("</clienttime>");
            stringBuilder.append("<currenturl>");
            if (!bi.oN(str)) {
                stringBuilder.append(bi.Wm(str));
            }
            stringBuilder.append("</currenturl>");
            SslCertificate certificate = sslError == null ? null : sslError.getCertificate();
            if (certificate != null) {
                DName issuedBy = certificate.getIssuedBy();
                if (issuedBy != null) {
                    stringBuilder.append("<issuedby>");
                    if (issuedBy.getDName() != null) {
                        stringBuilder.append(Base64.encodeToString(issuedBy.getDName().getBytes(), 0));
                    }
                    stringBuilder.append("</issuedby>");
                }
                issuedBy = certificate.getIssuedTo();
                if (issuedBy != null) {
                    stringBuilder.append("<issuedto>");
                    if (issuedBy.getDName() != null) {
                        stringBuilder.append(Base64.encodeToString(issuedBy.getDName().getBytes(), 0));
                    }
                    stringBuilder.append("</issuedto>");
                }
                String validNotAfter = certificate.getValidNotAfter();
                if (validNotAfter != null) {
                    stringBuilder.append("<getvalidnotafter>");
                    stringBuilder.append(Base64.encodeToString(validNotAfter.getBytes(), 0));
                    stringBuilder.append("</getvalidnotafter>");
                }
                String validNotBefore = certificate.getValidNotBefore();
                if (validNotBefore != null) {
                    stringBuilder.append("<getvalidnotbefore>");
                    stringBuilder.append(Base64.encodeToString(validNotBefore.getBytes(), 0));
                    stringBuilder.append("</getvalidnotbefore>");
                }
            }
            stringBuilder.append("</sslerror>");
            return stringBuilder.toString();
        } catch (Exception e) {
            x.w("MicroMsg.WebView.MMSslErrorHandler", "buildXml ex = %s", e.getMessage());
            return "";
        }
    }
}
