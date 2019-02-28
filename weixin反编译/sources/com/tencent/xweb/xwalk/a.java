package com.tencent.xweb.xwalk;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Process;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.c;
import com.tencent.xweb.c.d;
import com.tencent.xweb.g;
import com.tencent.xweb.k;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.xwalk.core.Log;
import org.xwalk.core.R;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkInitializer;
import org.xwalk.core.XWalkPreferences;
import org.xwalk.core.XWalkUpdater;
import org.xwalk.core.XWalkUpdater.UpdateConfig;

public final class a implements d {
    WebView ABC;
    ScrollView ABD = null;
    TextView ABE = null;
    TextView ABF = null;
    TextView ABG = null;
    View ABH;
    boolean ABI = false;
    String ABJ = "tools";
    Context Azr;

    static class a extends UpdateConfig {
        String ABS;

        public a(String str, String str2) {
            int i = 100000;
            int availableVersion = XWalkEnvironment.getAvailableVersion();
            if (availableVersion >= 100000) {
                i = availableVersion + 1;
            }
            this(i);
            this.ABS = str;
            this.isMatchMd5 = false;
            this.isPatchUpdate = false;
            this.versionDetail = "local:" + str2;
        }

        public final boolean checkValid() {
            return true;
        }

        private a(int i) {
            super(null, false, i);
        }
    }

    class b extends l {
        boolean ABT = false;
        private ProgressDialog ABU;

        public b(Context context) {
            super(context);
        }

        public final void onXWalkUpdateProgress(int i) {
            super.onXWalkUpdateProgress(i);
            if (!this.ABT) {
                ade("正在下载runtime");
                this.ABU.setProgress(i);
            }
        }

        public final void onXWalkUpdateFailed(int i) {
            super.onXWalkUpdateFailed(i);
            this.ABU.setCancelable(true);
            this.ABU.setCanceledOnTouchOutside(true);
            ade("更新失败, error code = :" + i);
        }

        public final void onXWalkUpdateCancelled() {
            super.onXWalkUpdateCancelled();
            this.ABU.setCancelable(true);
            this.ABU.setCanceledOnTouchOutside(true);
            ade("更新失败, 更新被取消");
        }

        public final void onXWalkUpdateCompleted() {
            super.onXWalkUpdateCompleted();
            ade("更新完成，点任意位置重启进程生效");
            this.ABU.setCancelable(true);
            this.ABU.setCanceledOnTouchOutside(true);
            this.ABU.setProgress(100);
            this.ABT = true;
        }

        private void ade(String str) {
            if (this.ABU == null) {
                this.ABU = new ProgressDialog(this.mContext);
                this.ABU.setProgressStyle(1);
                this.ABU.setMessage(str);
                this.ABU.setOnCancelListener(new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        a.this.ady();
                    }
                });
                this.ABU.setCancelable(false);
                this.ABU.show();
            }
            this.ABU.setMessage(str);
        }
    }

    public a(WebView webView) {
        this.Azr = webView.getContext();
        this.ABC = webView;
        cJP();
        cJN();
    }

    public final void cJs() {
        if (k.cJh().Azt) {
            a(k.cJh().Azt, null, false);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean acZ(java.lang.String r11) {
        /*
        r10 = this;
        r5 = -1;
        r2 = 0;
        r4 = 1;
        r0 = "debugmm.qq.com";
        r0 = r11.contains(r0);
        if (r0 == 0) goto L_0x00b6;
    L_0x000c:
        r1 = android.net.Uri.parse(r11);
        r0 = r1.getQueryParameterNames();
        if (r0 == 0) goto L_0x00b6;
    L_0x0016:
        r3 = r0.size();
        if (r3 <= 0) goto L_0x00b6;
    L_0x001c:
        r3 = r0.iterator();
    L_0x0020:
        r0 = r3.hasNext();
        if (r0 == 0) goto L_0x00b6;
    L_0x0026:
        r0 = r3.next();
        r0 = (java.lang.String) r0;
        if (r0 == 0) goto L_0x0020;
    L_0x002e:
        r6 = r0.hashCode();
        switch(r6) {
            case -677737752: goto L_0x0077;
            default: goto L_0x0035;
        };
    L_0x0035:
        r0 = r5;
    L_0x0036:
        switch(r0) {
            case 0: goto L_0x003a;
            default: goto L_0x0039;
        };
    L_0x0039:
        goto L_0x0020;
    L_0x003a:
        r0 = "forcex5";
        r0 = r1.getBooleanQueryParameter(r0, r2);
        if (r0 == 0) goto L_0x0082;
    L_0x0043:
        r0 = com.tencent.xweb.k.cJh();
        r1 = "tools";
        r2 = com.tencent.xweb.WebView.c.WV_KIND_X5;
        r0.a(r1, r2);
        r0 = com.tencent.xweb.k.cJh();
        r1 = "appbrand";
        r2 = com.tencent.xweb.WebView.c.WV_KIND_X5;
        r0.a(r1, r2);
        r0 = com.tencent.xweb.k.cJh();
        r1 = "support";
        r2 = com.tencent.xweb.WebView.c.WV_KIND_X5;
        r0.a(r1, r2);
        r0 = com.tencent.xweb.k.cJh();
        r1 = com.tencent.xweb.g.a.RT_TYPE_X5;
        r0.a(r1);
        r0 = "force use x5 switch is on ";
        r10.add(r0);
    L_0x0076:
        return r4;
    L_0x0077:
        r6 = "forcex5";
        r0 = r0.equals(r6);
        if (r0 == 0) goto L_0x0035;
    L_0x0080:
        r0 = r2;
        goto L_0x0036;
    L_0x0082:
        r0 = com.tencent.xweb.k.cJh();
        r1 = "tools";
        r2 = com.tencent.xweb.WebView.c.WV_KIND_NONE;
        r0.a(r1, r2);
        r0 = com.tencent.xweb.k.cJh();
        r1 = "appbrand";
        r2 = com.tencent.xweb.WebView.c.WV_KIND_NONE;
        r0.a(r1, r2);
        r0 = com.tencent.xweb.k.cJh();
        r1 = "support";
        r2 = com.tencent.xweb.WebView.c.WV_KIND_NONE;
        r0.a(r1, r2);
        r0 = com.tencent.xweb.k.cJh();
        r1 = com.tencent.xweb.g.a.RT_TYPE_AUTO;
        r0.a(r1);
        r0 = "force use x5 switch is off ";
        r10.add(r0);
        goto L_0x0076;
    L_0x00b6:
        r0 = "public.debugxweb.qq.com";
        r0 = r11.contains(r0);
        if (r0 == 0) goto L_0x011b;
    L_0x00bf:
        r1 = android.net.Uri.parse(r11);
        r0 = r1.getQueryParameterNames();
        if (r0 == 0) goto L_0x0076;
    L_0x00c9:
        r3 = r0.size();
        if (r3 <= 0) goto L_0x0076;
    L_0x00cf:
        r3 = r0.iterator();
    L_0x00d3:
        r0 = r3.hasNext();
        if (r0 == 0) goto L_0x0076;
    L_0x00d9:
        r0 = r3.next();
        r0 = (java.lang.String) r0;
        if (r0 == 0) goto L_0x00d3;
    L_0x00e1:
        r6 = r0.hashCode();
        switch(r6) {
            case -1157057597: goto L_0x0110;
            default: goto L_0x00e8;
        };
    L_0x00e8:
        r0 = r5;
    L_0x00e9:
        switch(r0) {
            case 0: goto L_0x00ed;
            default: goto L_0x00ec;
        };
    L_0x00ec:
        goto L_0x00d3;
    L_0x00ed:
        r0 = com.tencent.xweb.k.cJh();
        r6 = "enable_local_debug";
        r6 = r1.getBooleanQueryParameter(r6, r2);
        r0 = r0.Azr;
        r7 = "wcwebview";
        r0 = r0.getSharedPreferences(r7, r2);
        r0 = r0.edit();
        r7 = "m_bEnableLocalDebug";
        r0 = r0.putBoolean(r7, r6);
        r0.commit();
        goto L_0x00d3;
    L_0x0110:
        r6 = "enable_local_debug";
        r0 = r0.equals(r6);
        if (r0 == 0) goto L_0x00e8;
    L_0x0119:
        r0 = r2;
        goto L_0x00e9;
    L_0x011b:
        r0 = com.tencent.xweb.k.cJh();
        r0 = r0.Azr;
        r1 = "wcwebview";
        r0 = r0.getSharedPreferences(r1, r2);
        r1 = "m_bEnableLocalDebug";
        r6 = r0.getBoolean(r1, r2);
        r0 = "debugxweb.qq.com";
        r0 = r11.contains(r0);
        if (r0 == 0) goto L_0x0212;
    L_0x0138:
        r7 = android.net.Uri.parse(r11);
        r0 = r7.getQueryParameterNames();
        if (r0 == 0) goto L_0x0148;
    L_0x0142:
        r1 = r0.size();
        if (r1 != 0) goto L_0x014f;
    L_0x0148:
        if (r6 == 0) goto L_0x0076;
    L_0x014a:
        r10.cJQ();
        goto L_0x0076;
    L_0x014f:
        r8 = r0.iterator();
        r1 = r2;
        r3 = r2;
    L_0x0155:
        r0 = r8.hasNext();
        if (r0 == 0) goto L_0x0209;
    L_0x015b:
        r0 = r8.next();
        r0 = (java.lang.String) r0;
        if (r0 == 0) goto L_0x016e;
    L_0x0163:
        r9 = r0.hashCode();
        switch(r9) {
            case -604633792: goto L_0x0194;
            case -82035977: goto L_0x0173;
            case 386281809: goto L_0x0189;
            case 724449292: goto L_0x017e;
            default: goto L_0x016a;
        };
    L_0x016a:
        r0 = r5;
    L_0x016b:
        switch(r0) {
            case 0: goto L_0x019f;
            case 1: goto L_0x01b3;
            case 2: goto L_0x01d2;
            case 3: goto L_0x0202;
            default: goto L_0x016e;
        };
    L_0x016e:
        r0 = r1;
        r1 = r3;
    L_0x0170:
        r3 = r1;
        r1 = r0;
        goto L_0x0155;
    L_0x0173:
        r9 = "inspector";
        r0 = r0.equals(r9);
        if (r0 == 0) goto L_0x016a;
    L_0x017c:
        r0 = r2;
        goto L_0x016b;
    L_0x017e:
        r9 = "use_testconfig";
        r0 = r0.equals(r9);
        if (r0 == 0) goto L_0x016a;
    L_0x0187:
        r0 = r4;
        goto L_0x016b;
    L_0x0189:
        r9 = "set_grayvalue";
        r0 = r0.equals(r9);
        if (r0 == 0) goto L_0x016a;
    L_0x0192:
        r0 = 2;
        goto L_0x016b;
    L_0x0194:
        r9 = "kill_all";
        r0 = r0.equals(r9);
        if (r0 == 0) goto L_0x016a;
    L_0x019d:
        r0 = 3;
        goto L_0x016b;
    L_0x019f:
        r0 = "inspector";
        r0 = r7.getBooleanQueryParameter(r0, r2);
        r3 = com.tencent.xweb.k.cJh();
        r3.oi(r0);
        r3 = 0;
        r10.a(r0, r3, r4);
        r3 = r4;
        goto L_0x0155;
    L_0x01b3:
        r0 = "use_testconfig";
        r0 = r7.getBooleanQueryParameter(r0, r2);
        r3 = com.tencent.xweb.k.cJh();
        r3.ok(r0);
        if (r0 == 0) goto L_0x01cb;
    L_0x01c3:
        r0 = "使用测试config";
        r10.bw(r0, r4);
    L_0x01c9:
        r3 = r4;
        goto L_0x0155;
    L_0x01cb:
        r0 = "使用正式config";
        r10.bw(r0, r4);
        goto L_0x01c9;
    L_0x01d2:
        r0 = "set_grayvalue";
        r0 = r7.getQueryParameter(r0);	 Catch:{ Exception -> 0x01f8 }
        r0 = java.lang.Integer.parseInt(r0);	 Catch:{ Exception -> 0x01f8 }
        org.xwalk.core.XWalkEnvironment.setGrayValueForTest(r0);
        r3 = new java.lang.StringBuilder;
        r9 = "灰度值设为";
        r3.<init>(r9);
        r0 = r0 % 10000;
        r0 = r3.append(r0);
        r0 = r0.toString();
        r10.bw(r0, r4);
        r3 = r4;
        goto L_0x0155;
    L_0x01f8:
        r0 = move-exception;
        r0 = "灰度值设置失败，参数解析错误";
        r10.bw(r0, r4);
        r3 = r4;
        goto L_0x0155;
    L_0x0202:
        r10.ady();
        r0 = r4;
        r1 = r4;
        goto L_0x0170;
    L_0x0209:
        if (r1 == 0) goto L_0x0210;
    L_0x020b:
        r10.ady();
        goto L_0x0076;
    L_0x0210:
        if (r3 != 0) goto L_0x0076;
    L_0x0212:
        if (r6 == 0) goto L_0x021a;
    L_0x0214:
        r4 = r10.adc(r11);
        goto L_0x0076;
    L_0x021a:
        r4 = r2;
        goto L_0x0076;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.xweb.xwalk.a.acZ(java.lang.String):boolean");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean adc(java.lang.String r8) {
        /*
        r7 = this;
        r2 = 0;
        r1 = 1;
        r0 = "debugxweb.qq.com";
        r0 = r8.contains(r0);
        if (r0 == 0) goto L_0x019f;
    L_0x000b:
        r4 = android.net.Uri.parse(r8);
        r0 = r4.getQueryParameterNames();
        if (r0 == 0) goto L_0x001b;
    L_0x0015:
        r3 = r0.size();
        if (r3 != 0) goto L_0x0020;
    L_0x001b:
        r7.cJQ();
        r0 = r1;
    L_0x001f:
        return r0;
    L_0x0020:
        r5 = r0.iterator();
    L_0x0024:
        r0 = r5.hasNext();
        if (r0 == 0) goto L_0x019c;
    L_0x002a:
        r0 = r5.next();
        r0 = (java.lang.String) r0;
        if (r0 == 0) goto L_0x0024;
    L_0x0032:
        r3 = -1;
        r6 = r0.hashCode();
        switch(r6) {
            case -974615216: goto L_0x0064;
            case -748036674: goto L_0x0059;
            case 368659514: goto L_0x006f;
            case 603805332: goto L_0x0043;
            case 989541982: goto L_0x0085;
            case 1874228874: goto L_0x004e;
            case 2135256815: goto L_0x007a;
            default: goto L_0x003a;
        };
    L_0x003a:
        r0 = r3;
    L_0x003b:
        switch(r0) {
            case 0: goto L_0x003f;
            case 1: goto L_0x0090;
            case 2: goto L_0x00be;
            case 3: goto L_0x014a;
            case 4: goto L_0x0164;
            case 5: goto L_0x016d;
            case 6: goto L_0x0197;
            default: goto L_0x003e;
        };
    L_0x003e:
        goto L_0x0024;
    L_0x003f:
        r7.ol(r2);
        goto L_0x0024;
    L_0x0043:
        r6 = "load_local_xwalk";
        r0 = r0.equals(r6);
        if (r0 == 0) goto L_0x003a;
    L_0x004c:
        r0 = r2;
        goto L_0x003b;
    L_0x004e:
        r6 = "set_web_config";
        r0 = r0.equals(r6);
        if (r0 == 0) goto L_0x003a;
    L_0x0057:
        r0 = r1;
        goto L_0x003b;
    L_0x0059:
        r6 = "set_appbrand_config";
        r0 = r0.equals(r6);
        if (r0 == 0) goto L_0x003a;
    L_0x0062:
        r0 = 2;
        goto L_0x003b;
    L_0x0064:
        r6 = "show_webview_version";
        r0 = r0.equals(r6);
        if (r0 == 0) goto L_0x003a;
    L_0x006d:
        r0 = 3;
        goto L_0x003b;
    L_0x006f:
        r6 = "clear_commands";
        r0 = r0.equals(r6);
        if (r0 == 0) goto L_0x003a;
    L_0x0078:
        r0 = 4;
        goto L_0x003b;
    L_0x007a:
        r6 = "set_config_url";
        r0 = r0.equals(r6);
        if (r0 == 0) goto L_0x003a;
    L_0x0083:
        r0 = 5;
        goto L_0x003b;
    L_0x0085:
        r6 = "check_xwalk_update";
        r0 = r0.equals(r6);
        if (r0 == 0) goto L_0x003a;
    L_0x008e:
        r0 = 6;
        goto L_0x003b;
    L_0x0090:
        r0 = "set_web_config";
        r0 = r4.getQueryParameter(r0);	 Catch:{ Exception -> 0x00bb }
        r0 = com.tencent.xweb.WebView.c.valueOf(r0);	 Catch:{ Exception -> 0x00bb }
        r3 = com.tencent.xweb.k.cJh();	 Catch:{ Exception -> 0x00bb }
        r6 = "tools";
        r3.a(r6, r0);	 Catch:{ Exception -> 0x00bb }
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00bb }
        r6 = "打开网页将使用:";
        r3.<init>(r6);	 Catch:{ Exception -> 0x00bb }
        r0 = r3.append(r0);	 Catch:{ Exception -> 0x00bb }
        r0 = r0.toString();	 Catch:{ Exception -> 0x00bb }
        r3 = 1;
        r7.bw(r0, r3);	 Catch:{ Exception -> 0x00bb }
        goto L_0x0024;
    L_0x00bb:
        r0 = move-exception;
        goto L_0x0024;
    L_0x00be:
        r0 = "set_appbrand_config";
        r0 = r4.getQueryParameter(r0);	 Catch:{ Exception -> 0x0109 }
        r0 = com.tencent.xweb.WebView.c.valueOf(r0);	 Catch:{ Exception -> 0x0109 }
        r3 = com.tencent.xweb.k.cJh();	 Catch:{ Exception -> 0x0109 }
        r6 = "appbrand";
        r3.a(r6, r0);	 Catch:{ Exception -> 0x0109 }
        r3 = com.tencent.xweb.k.cJh();	 Catch:{ Exception -> 0x0109 }
        r6 = "support";
        r3.a(r6, r0);	 Catch:{ Exception -> 0x0109 }
        r3 = com.tencent.xweb.xwalk.a.AnonymousClass18.AAP;	 Catch:{ Exception -> 0x0109 }
        r6 = r0.ordinal();	 Catch:{ Exception -> 0x0109 }
        r3 = r3[r6];	 Catch:{ Exception -> 0x0109 }
        switch(r3) {
            case 1: goto L_0x00ea;
            case 2: goto L_0x010c;
            case 3: goto L_0x012b;
            default: goto L_0x00e8;
        };	 Catch:{ Exception -> 0x0109 }
    L_0x00e8:
        goto L_0x0024;
    L_0x00ea:
        r3 = com.tencent.xweb.k.cJh();	 Catch:{ Exception -> 0x0109 }
        r6 = com.tencent.xweb.g.a.RT_TYPE_MMV8;	 Catch:{ Exception -> 0x0109 }
        r3.a(r6);	 Catch:{ Exception -> 0x0109 }
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0109 }
        r6 = "打开小程序将使用:";
        r3.<init>(r6);	 Catch:{ Exception -> 0x0109 }
        r0 = r3.append(r0);	 Catch:{ Exception -> 0x0109 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x0109 }
        r3 = 1;
        r7.bw(r0, r3);	 Catch:{ Exception -> 0x0109 }
        goto L_0x0024;
    L_0x0109:
        r0 = move-exception;
        goto L_0x0024;
    L_0x010c:
        r3 = com.tencent.xweb.k.cJh();	 Catch:{ Exception -> 0x0109 }
        r6 = com.tencent.xweb.g.a.RT_TYPE_X5;	 Catch:{ Exception -> 0x0109 }
        r3.a(r6);	 Catch:{ Exception -> 0x0109 }
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0109 }
        r6 = "打开小程序将使用:";
        r3.<init>(r6);	 Catch:{ Exception -> 0x0109 }
        r0 = r3.append(r0);	 Catch:{ Exception -> 0x0109 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x0109 }
        r3 = 1;
        r7.bw(r0, r3);	 Catch:{ Exception -> 0x0109 }
        goto L_0x0024;
    L_0x012b:
        r3 = com.tencent.xweb.k.cJh();	 Catch:{ Exception -> 0x0109 }
        r6 = com.tencent.xweb.g.a.RT_TYPE_MMV8;	 Catch:{ Exception -> 0x0109 }
        r3.a(r6);	 Catch:{ Exception -> 0x0109 }
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0109 }
        r6 = "打开小程序将使用:";
        r3.<init>(r6);	 Catch:{ Exception -> 0x0109 }
        r0 = r3.append(r0);	 Catch:{ Exception -> 0x0109 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x0109 }
        r3 = 1;
        r7.bw(r0, r3);	 Catch:{ Exception -> 0x0109 }
        goto L_0x0024;
    L_0x014a:
        r0 = "show_webview_version";
        r0 = r4.getBooleanQueryParameter(r0, r2);
        r3 = com.tencent.xweb.k.cJh();
        r3.oj(r1);
        r7.cJN();
        r3 = com.tencent.xweb.k.cJh();
        r3.oj(r0);
        goto L_0x0024;
    L_0x0164:
        r0 = 0;
        r3 = "0";
        com.tencent.xweb.a.a(r0, r3);
        goto L_0x0024;
    L_0x016d:
        r0 = "set_config_url";
        r0 = r4.getQueryParameter(r0);	 Catch:{ Exception -> 0x018e }
        r3 = r7.Azr;
        org.xwalk.core.XWalkEnvironment.setTestDownLoadUrl(r3, r0);
        r3 = new java.lang.StringBuilder;
        r6 = "测试连接设置为:";
        r3.<init>(r6);
        r0 = r3.append(r0);
        r0 = r0.toString();
        r7.bw(r0, r1);
        goto L_0x0024;
    L_0x018e:
        r0 = move-exception;
        r0 = "测试连接设置失败，格式错误";
        r7.bw(r0, r1);
        goto L_0x0024;
    L_0x0197:
        r7.cJR();
        goto L_0x0024;
    L_0x019c:
        r0 = r1;
        goto L_0x001f;
    L_0x019f:
        r0 = r2;
        goto L_0x001f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.xweb.xwalk.a.adc(java.lang.String):boolean");
    }

    private void cJN() {
        if (k.cJh().Azv && this.ABG == null) {
            View scrollView = new ScrollView(this.Azr);
            this.ABG = new TextView(this.Azr);
            this.ABG.setBackgroundColor(-1);
            scrollView.addView(this.ABG);
            this.ABG.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    a.this.cJO();
                }
            });
            cJO();
            this.ABC.getTopView().addView(scrollView);
        }
    }

    final void cJO() {
        if (this.ABG != null) {
            String xWalkUpdateConfigUrl = XWalkEnvironment.getXWalkUpdateConfigUrl();
            String str = "\n\n" + this.ABC.getAbstractInfo();
            if (WebView.getCurWebType() != c.WV_KIND_CW) {
                str = str + "\n xwebsdk is = 17 apk ver is " + XWalkEnvironment.getAvailableVersion();
            }
            StringBuilder append = new StringBuilder().append(str).append("\n\n current js engine: =  ").append(g.cJf()).append("\n prefered js engine =  ").append(g.b(com.tencent.xweb.g.a.RT_TYPE_AUTO, "appbrand", this.Azr)).append("\n isWaitingForUpdate = ");
            com.tencent.xweb.xwalk.a.c.cJU();
            CharSequence stringBuilder = append.append(com.tencent.xweb.xwalk.a.c.cJV()).append("\n local gray value = ").append(XWalkEnvironment.getGrayValue()).append("\n config url = ").append(xWalkUpdateConfigUrl).append("\n\n apilevel = ").append(VERSION.SDK_INT).append("\n device is  ").append(Build.BRAND).append(" ").append(Build.MODEL).toString();
            xWalkUpdateConfigUrl = com.tencent.xweb.a.getAbstractInfo();
            if (!(xWalkUpdateConfigUrl == null || xWalkUpdateConfigUrl.isEmpty())) {
                stringBuilder = stringBuilder + "\n\n ------dump commands start:------\n" + xWalkUpdateConfigUrl + "\n ------dump commands end------";
            }
            xWalkUpdateConfigUrl = "";
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                if (com.tencent.xweb.xwalk.a.c.cJW()) {
                    xWalkUpdateConfigUrl = (((((xWalkUpdateConfigUrl + "going to update to apk ver = " + com.tencent.xweb.xwalk.a.c.cKa().ACO) + "\n update time is = " + simpleDateFormat.format(new Date(com.tencent.xweb.xwalk.a.c.cKa().ACX))) + "\n is patch update = " + com.tencent.xweb.xwalk.a.c.cKa().ACW) + "\n can use cellular = " + com.tencent.xweb.xwalk.a.c.cKa().ACN) + "\n try count = " + com.tencent.xweb.xwalk.a.c.cKa().ACZ) + "\n";
                }
                xWalkUpdateConfigUrl = xWalkUpdateConfigUrl + " last fetch config time = " + simpleDateFormat.format(new Date(com.tencent.xweb.xwalk.a.c.cKa().ACV));
            } catch (Exception e) {
            }
            if (!(xWalkUpdateConfigUrl == null || xWalkUpdateConfigUrl.isEmpty())) {
                stringBuilder = stringBuilder + "\n\n ------dump schedule updateInfo start:------\n" + xWalkUpdateConfigUrl + "\n ------dump schedule updateInfo end------";
            }
            xWalkUpdateConfigUrl = XWalkEnvironment.getXWalkInitializeLog();
            if (!(xWalkUpdateConfigUrl == null || xWalkUpdateConfigUrl.isEmpty())) {
                stringBuilder = stringBuilder + "\n\n ------dump xweb log------\n" + xWalkUpdateConfigUrl;
            }
            this.ABG.setText(stringBuilder);
        }
    }

    final void cJP() {
        if (k.cJh().Azu && this.ABF == null) {
            this.ABF = new TextView(this.Azr);
            this.ABF.setOnLongClickListener(new OnLongClickListener() {
                public final boolean onLongClick(View view) {
                    a.this.cJQ();
                    return true;
                }
            });
            if (this.ABF != null) {
                CharSequence versionInfo = this.ABC.getVersionInfo();
                int indexOf = versionInfo.indexOf(",apkversion");
                if (indexOf > 0) {
                    versionInfo = versionInfo.substring(0, indexOf);
                }
                this.ABF.setText(versionInfo);
            }
            this.ABC.getTopView().addView(this.ABF);
        }
    }

    final void e(c cVar) {
        switch (cVar) {
            case WV_KIND_CW:
                ((RadioButton) this.ABH.findViewById(R.id.WV_XWALK)).setChecked(true);
                return;
            case WV_KIND_X5:
                ((RadioButton) this.ABH.findViewById(R.id.WV_X5)).setChecked(true);
                return;
            case WV_KIND_SYS:
                ((RadioButton) this.ABH.findViewById(R.id.WV_SYS)).setChecked(true);
                return;
            case WV_KIND_NONE:
                ((RadioButton) this.ABH.findViewById(R.id.WV_AUTO)).setChecked(true);
                return;
            default:
                return;
        }
    }

    final boolean cJQ() {
        if (this.ABH != null) {
            this.ABH.setVisibility(0);
        } else {
            this.ABH = ((LayoutInflater) this.Azr.getSystemService("layout_inflater")).inflate(R.layout.debug_menu, this.ABC.getTopView(), true).findViewById(R.id.view_root);
            ((Button) this.ABH.findViewById(R.id.button_close_menu)).setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    a.this.ABH.setVisibility(8);
                }
            });
            final CheckBox checkBox = (CheckBox) this.ABH.findViewById(R.id.checked_show_version);
            checkBox.setChecked(k.cJh().Azu);
            checkBox.setOnCheckedChangeListener(new OnCheckedChangeListener() {
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    k cJh = k.cJh();
                    if (z != cJh.Azu) {
                        cJh.Azu = z;
                        cJh.Azr.getSharedPreferences("wcwebview", 0).edit().putBoolean("bShowVersion", cJh.Azu).commit();
                    }
                    if (z) {
                        a.this.cJP();
                        a.this.ABF.setVisibility(0);
                    } else if (a.this.ABF != null) {
                        a.this.ABF.setVisibility(8);
                    }
                }
            });
            ((TextView) this.ABH.findViewById(R.id.check_text)).setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    checkBox.setChecked(!checkBox.isChecked());
                }
            });
            final EditText editText = (EditText) this.ABH.findViewById(R.id.txtin_grayvalue);
            if (editText != null) {
                editText.setInputType(2);
                editText.setText(XWalkEnvironment.getGrayValue());
                editText.addTextChangedListener(new TextWatcher() {
                    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    }

                    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    }

                    public final void afterTextChanged(Editable editable) {
                        int i = 0;
                        try {
                            i = Integer.parseInt(editText.getText().toString());
                        } catch (Exception e) {
                        }
                        XWalkEnvironment.setGrayValueForTest(i);
                    }
                });
            }
            ((Spinner) this.ABH.findViewById(R.id.selector_webviewmodule)).setOnItemSelectedListener(new OnItemSelectedListener() {
                public final void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                    int i2 = 1;
                    String[] stringArray = a.this.Azr.getResources().getStringArray(R.array.webviewuimodules);
                    a.this.ABJ = stringArray[i];
                    a aVar = a.this;
                    aVar.ABI = true;
                    if (aVar.ABJ.equals("all")) {
                        String[] stringArray2 = aVar.Azr.getResources().getStringArray(R.array.webviewmodules);
                        c acY = k.cJh().acY(stringArray2[0]);
                        while (i2 < stringArray2.length) {
                            if (k.cJh().acY(stringArray2[i2]) != acY) {
                                ((RadioButton) aVar.ABH.findViewById(R.id.WV_AUTO)).setChecked(false);
                                ((RadioButton) aVar.ABH.findViewById(R.id.WV_XWALK)).setChecked(false);
                                ((RadioButton) aVar.ABH.findViewById(R.id.WV_X5)).setChecked(false);
                                ((RadioButton) aVar.ABH.findViewById(R.id.WV_SYS)).setChecked(false);
                                break;
                            }
                            i2++;
                        }
                        aVar.e(acY);
                    } else {
                        aVar.e(k.cJh().acY(aVar.ABJ));
                    }
                    aVar.ABI = false;
                }

                public final void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            ((RadioGroup) this.ABH.findViewById(R.id.web_select)).setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                public final void onCheckedChanged(RadioGroup radioGroup, int i) {
                    if (!a.this.ABI) {
                        c cVar = c.WV_KIND_NONE;
                        if (i == R.id.WV_AUTO) {
                            cVar = c.WV_KIND_NONE;
                        } else if (i == R.id.WV_XWALK) {
                            cVar = c.WV_KIND_CW;
                        } else if (i == R.id.WV_X5) {
                            cVar = c.WV_KIND_X5;
                        } else if (i == R.id.WV_SYS) {
                            cVar = c.WV_KIND_SYS;
                        }
                        if (a.this.ABJ.equals("all")) {
                            String[] stringArray = a.this.Azr.getResources().getStringArray(R.array.webviewmodules);
                            for (int i2 = 0; i2 < stringArray.length; i2++) {
                                k.cJh().a(stringArray[i2], cVar);
                                Log.d("WebDebugPage", "webview " + stringArray[i2] + " change to=" + cVar);
                            }
                            return;
                        }
                        k.cJh().a(a.this.ABJ, cVar);
                        Log.d("WebDebugPage", "webview change to=" + cVar);
                    }
                }
            });
            switch (k.cJh().Azw) {
                case RT_TYPE_AUTO:
                    ((RadioButton) this.ABH.findViewById(R.id.v8_auto)).setChecked(true);
                    break;
                case RT_TYPE_SYS:
                    ((RadioButton) this.ABH.findViewById(R.id.v8_sys)).setChecked(true);
                    break;
                case RT_TYPE_X5:
                    ((RadioButton) this.ABH.findViewById(R.id.v8_x5)).setChecked(true);
                    break;
                case RT_TYPE_NATIVE_SCRIPT:
                    ((RadioButton) this.ABH.findViewById(R.id.v8_nativescript)).setChecked(true);
                    break;
                case RT_TYPE_MMV8:
                    ((RadioButton) this.ABH.findViewById(R.id.v8_mmv8)).setChecked(true);
                    break;
            }
            ((RadioGroup) this.ABH.findViewById(R.id.v8_select)).setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                public final void onCheckedChanged(RadioGroup radioGroup, int i) {
                    com.tencent.xweb.g.a aVar = com.tencent.xweb.g.a.RT_TYPE_AUTO;
                    if (i == R.id.v8_auto) {
                        aVar = com.tencent.xweb.g.a.RT_TYPE_AUTO;
                    } else if (i == R.id.v8_sys) {
                        aVar = com.tencent.xweb.g.a.RT_TYPE_SYS;
                    } else if (i == R.id.v8_x5) {
                        aVar = com.tencent.xweb.g.a.RT_TYPE_X5;
                    } else if (i == R.id.v8_nativescript) {
                        aVar = com.tencent.xweb.g.a.RT_TYPE_NATIVE_SCRIPT;
                    } else if (i == R.id.v8_mmv8) {
                        aVar = com.tencent.xweb.g.a.RT_TYPE_MMV8;
                    }
                    k.cJh().a(aVar);
                    Log.d("WebDebugPage", "v8 type change to=" + aVar);
                }
            });
            ((Button) this.ABH.findViewById(R.id.button_kill)).setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    a.this.ABH.setVisibility(8);
                    a.this.ady();
                }
            });
            final Button button = (Button) this.ABH.findViewById(R.id.btn_debug);
            a(k.cJh().Azt, button, false);
            button.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    boolean z = !k.cJh().Azt;
                    k.cJh().oi(z);
                    a.this.a(z, button, true);
                }
            });
            ((Button) this.ABH.findViewById(R.id.button_clear)).setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    XWalkEnvironment.clearAllVersion(a.this.Azr);
                }
            });
            ((Button) this.ABH.findViewById(R.id.button_refreshLog)).setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    ((TextView) a.this.ABH.findViewById(R.id.txtVersion)).setText(a.this.ABC.getVersionInfo() + "\n" + XWalkInitializer.getXWalkInitializeLog());
                }
            });
            ((Button) this.ABH.findViewById(R.id.button_loadLocalApk)).setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    a.this.ol(true);
                }
            });
            button = (Button) this.ABH.findViewById(R.id.button_config);
            button.setText(k.cJh().Azx ? "使用正式版config" : "使用测试config");
            button.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    k.cJh().ok(!k.cJh().Azx);
                    button.setText(k.cJh().Azx ? "使用正式版config" : "使用测试config");
                }
            });
            ((Button) this.ABH.findViewById(R.id.button_update)).setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    a.this.cJR();
                }
            });
            ((TextView) this.ABH.findViewById(R.id.txtVersion)).setText(this.ABC.getVersionInfo() + "\n" + XWalkInitializer.getXWalkInitializeLog());
            ((LinearLayout) this.ABH.findViewById(R.id.config_memu)).setVisibility(8);
            ((Button) this.ABH.findViewById(R.id.button_change_to_xweb)).setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    if (XWalkEnvironment.getAvailableVersion() < 0) {
                        a.this.acZ("http://debugxweb.qq.com/?set_web_config=WV_KIND_CW&set_appbrand_config=WV_KIND_CW&set_config_url=https://dldir1.qq.com/weixin/android/wxweb/updateConfig_gray1.xml&check_xwalk_update");
                        return;
                    }
                    k.cJh().a("tools", c.WV_KIND_CW);
                    k.cJh().a("appbrand", c.WV_KIND_CW);
                    k.cJh().a("support", c.WV_KIND_CW);
                    a.this.add("已使用XWeb，点任意位置重启进程生效\n");
                }
            });
            ((Button) this.ABH.findViewById(R.id.button_change_to_x5)).setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    k.cJh().a("tools", c.WV_KIND_X5);
                    k.cJh().a("appbrand", c.WV_KIND_X5);
                    k.cJh().a("support", c.WV_KIND_X5);
                    if (WebView.getTbsCoreVersion(a.this.Azr) <= 0) {
                        a.this.bw("已切换x5，但是x5未ready，点任意位置重启进程生效\n", true);
                    } else {
                        a.this.add("已使用x5，点任意位置重启进程生效\n");
                    }
                }
            });
            ((Button) this.ABH.findViewById(R.id.button_change_to_sys)).setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    k.cJh().a("tools", c.WV_KIND_SYS);
                    k.cJh().a("appbrand", c.WV_KIND_SYS);
                    k.cJh().a("support", c.WV_KIND_SYS);
                    a.this.add("已使用system，点任意位置重启进程生效\n");
                }
            });
            ((Button) this.ABH.findViewById(R.id.button_change_to_auto)).setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    k.cJh().a("tools", c.WV_KIND_NONE);
                    k.cJh().a("appbrand", c.WV_KIND_NONE);
                    k.cJh().a("support", c.WV_KIND_NONE);
                    a.this.add("已使用AUTO，点任意位置重启进程生效\n");
                }
            });
            ((Button) this.ABH.findViewById(R.id.button_advanced)).setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    LinearLayout linearLayout = (LinearLayout) a.this.ABH.findViewById(R.id.config_memu);
                    if (linearLayout.getVisibility() == 8) {
                        linearLayout.setVisibility(0);
                        ((Button) view).setText("隐藏高级设置");
                        return;
                    }
                    linearLayout.setVisibility(8);
                    ((Button) view).setText("高级设置");
                }
            });
        }
        return true;
    }

    final void cJR() {
        com.tencent.xweb.a.a(null, "0");
        Editor edit = XWalkEnvironment.getSharedPreferencesForUpdateConfig().edit();
        edit.putLong("nLastFetchConfigTime", 0);
        edit.putBoolean("bCanUseCellular", true);
        edit.putLong("nTimeToUpdate", 100);
        edit.commit();
        com.tencent.xweb.xwalk.a.c.cKa().ACV = 100;
        com.tencent.xweb.xwalk.a.c.cKa().ACN = true;
        com.tencent.xweb.xwalk.a.c.cKa().ACX = 100;
        new b(this.Azr).cJT();
    }

    final void ady() {
        ActivityManager activityManager = (ActivityManager) this.Azr.getSystemService("activity");
        int myPid = Process.myPid();
        int myUid = Process.myUid();
        for (RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
            if (runningAppProcessInfo.uid == myUid && runningAppProcessInfo.pid != myPid) {
                String str = runningAppProcessInfo.processName;
                if (str == null || !str.contains("com.tencent.mm") || runningAppProcessInfo.processName.contains("tools") || runningAppProcessInfo.processName.contains("appbrand") || runningAppProcessInfo.processName.contains("support")) {
                    Process.killProcess(runningAppProcessInfo.pid);
                }
            }
        }
        Process.killProcess(myPid);
    }

    public final void a(boolean z, Button button, boolean z2) {
        try {
            XWalkPreferences.setValue(XWalkPreferences.REMOTE_DEBUGGING, z);
        } catch (Exception e) {
        }
        try {
            if (VERSION.SDK_INT >= 19) {
                android.webkit.WebView.setWebContentsDebuggingEnabled(z);
            }
        } catch (Exception e2) {
        }
        try {
            com.tencent.smtt.sdk.WebView.setWebContentsDebuggingEnabled(z);
        } catch (Exception e3) {
        }
        if (z2 && this.ABC.getX5WebViewExtension() != null) {
            if (z) {
                this.ABC.loadUrl("http://debugx5.qq.com/?inspector=true");
            } else {
                this.ABC.loadUrl("http://debugx5.qq.com/?inspector=false");
            }
        }
        if (button == null) {
            return;
        }
        if (z) {
            button.setText("关闭远程调试模式");
        } else {
            button.setText("打开远程调试模式");
        }
    }

    final void ol(final boolean z) {
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (externalStorageDirectory == null) {
            bw("请确认应用权限，在权限管理打开应用的读写存储权限", true);
        } else if (externalStorageDirectory.listFiles() == null) {
            bw("请确认应用权限，在权限管理打开应用的读写存储权限", true);
        } else {
            externalStorageDirectory.toString();
            try {
                File[] listFiles = new File(externalStorageDirectory.getPath() + "/apkxwebtest").listFiles();
                if (listFiles == null || listFiles.length == 0) {
                    bw("apkxwebtest目录下没有.zip文件,请确认应用权限，在权限管理打开应用的读写存储权限", true);
                    return;
                }
                for (int i = 0; i < listFiles.length; i++) {
                    if (listFiles[i].getName().endsWith(".zip")) {
                        final String absolutePath = listFiles[i].getAbsolutePath();
                        final String name = listFiles[i].getName();
                        if (z) {
                            new Builder(this.Azr).setTitle("提示").setMessage("确定加载:" + name + "?").setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    a.this.y(absolutePath, name, z);
                                }
                            }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                }
                            }).show();
                            return;
                        } else {
                            y(absolutePath, name, z);
                            return;
                        }
                    }
                }
                bw("apkxwebtest目录下没有.zip文件", true);
            } catch (Exception e) {
                bw("没有找到apkxwebtest目录,请确认应用权限，在权限管理打开应用的读写存储权限", true);
            }
        }
    }

    final void y(String str, String str2, boolean z) {
        UpdateConfig aVar = new a(str, str2);
        try {
            File file = new File(XWalkEnvironment.getDownloadZipDir(aVar.apkVer));
            if (file.exists()) {
                file.delete();
            }
            FileInputStream fileInputStream = new FileInputStream(str);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[1048576];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                fileOutputStream.write(bArr, 0, read);
            }
            fileOutputStream.flush();
            fileInputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
        }
        try {
            Integer onHandleFile = XWalkUpdater.onHandleFile(aVar);
            if (onHandleFile.intValue() == 0) {
                bw("安装" + str2 + "成功", z);
            } else {
                bw("安装" + str2 + "失败,错误码=" + onHandleFile, true);
            }
        } catch (Exception e2) {
            bw("安装失败", true);
            Log.e("WebDebugPage", "install local apk failed : " + e2.getMessage());
        }
    }

    final void bw(String str, boolean z) {
        if (z) {
            Builder builder = new Builder(this.Azr);
            builder.setMessage(str);
            builder.create().show();
            return;
        }
        Log.e("WebDebugPage", str);
    }

    final void add(String str) {
        Builder builder = new Builder(this.Azr);
        builder.setMessage(str);
        builder.create();
        builder.setCancelable(true);
        builder.setOnCancelListener(new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                a.this.ady();
            }
        });
        builder.show();
    }
}
