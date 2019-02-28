package com.tencent.mm.plugin.appbrand.dynamic.ui;

import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMSwitchBtn;

public class WxaWidgetPerformanceUI extends MMActivity {
    MMSwitchBtn iYs;
    MMSwitchBtn iYt;
    MMSwitchBtn iYu;

    private static class a implements h<IPCVoid, IPCVoid> {
        private a() {
        }

        public final /* synthetic */ void a(Object obj, i iVar) {
            com.tencent.mm.plugin.appbrand.collector.c.clear();
        }
    }

    private static class b implements h<IPCBoolean, IPCVoid> {
        private b() {
        }

        public final /* synthetic */ void a(Object obj, i iVar) {
            if (((IPCBoolean) obj).value) {
                com.tencent.mm.plugin.appbrand.collector.c.qK("jsapi_draw_canvas");
            } else {
                com.tencent.mm.plugin.appbrand.collector.c.qL("jsapi_draw_canvas");
            }
        }
    }

    private static class c implements h<IPCBoolean, IPCVoid> {
        private c() {
        }

        public final /* synthetic */ void a(Object obj, i iVar) {
            if (((IPCBoolean) obj).value) {
                com.tencent.mm.plugin.appbrand.collector.c.qK("widget_launch");
            } else {
                com.tencent.mm.plugin.appbrand.collector.c.qL("widget_launch");
            }
        }
    }

    private static class d implements h<IPCBoolean, IPCVoid> {
        private d() {
        }

        public final /* synthetic */ void a(Object obj, i iVar) {
            com.tencent.mm.plugin.appbrand.collector.c.cu(((IPCBoolean) obj).value);
        }
    }

    private static class e implements j<IPCString, IPCString> {
        private e() {
        }

        public final /* synthetic */ Object at(Object obj) {
            return new IPCString(com.tencent.mm.plugin.appbrand.collector.c.qJ(((IPCString) obj).value).toString());
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                WxaWidgetPerformanceUI.this.finish();
                return false;
            }
        });
        setMMTitle(com.tencent.mm.plugin.appbrand.wxawidget.b.e.kmY);
        final TextView textView = (TextView) findViewById(com.tencent.mm.plugin.appbrand.wxawidget.b.b.kmD);
        final View findViewById = findViewById(com.tencent.mm.plugin.appbrand.wxawidget.b.b.kmJ);
        findViewById.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                String stringBuilder = com.tencent.mm.plugin.appbrand.collector.c.qJ("jsapi_draw_canvas").toString();
                StringBuilder stringBuilder2 = new StringBuilder();
                if (stringBuilder != null && stringBuilder.length() > 0) {
                    stringBuilder2.append("data size :").append(com.tencent.mm.plugin.appbrand.collector.c.aW("jsapi_draw_canvas", "__invoke_jsapi_data_size")).append("\n").append(stringBuilder);
                }
                IPCString iPCString = (IPCString) f.a("com.tencent.mm:support", new IPCString("widget_launch"), e.class);
                if (iPCString != null) {
                    stringBuilder2.append("\n\n").append(iPCString);
                }
                if (com.tencent.mm.plugin.appbrand.collector.f.abH()) {
                    stringBuilder2.append("\n\n").append(com.tencent.mm.plugin.appbrand.collector.f.abI());
                }
                textView.setText(stringBuilder2.toString());
            }
        });
        findViewById(com.tencent.mm.plugin.appbrand.wxawidget.b.b.bWi).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                f.a("com.tencent.mm:support", null, a.class, null);
                com.tencent.mm.plugin.appbrand.collector.c.clear();
                com.tencent.mm.plugin.appbrand.collector.f.reset();
                textView.setText(com.tencent.mm.plugin.appbrand.collector.c.qJ("jsapi_draw_canvas").toString());
            }
        });
        MMSwitchBtn mMSwitchBtn = (MMSwitchBtn) findViewById(com.tencent.mm.plugin.appbrand.wxawidget.b.b.kmF);
        boolean abG = com.tencent.mm.plugin.appbrand.collector.c.abG();
        mMSwitchBtn.nJ(abG);
        mMSwitchBtn.zEt = new com.tencent.mm.ui.widget.MMSwitchBtn.a() {
            public final void cy(boolean z) {
                f.a("com.tencent.mm:support", new IPCBoolean(z), d.class, null);
                com.tencent.mm.plugin.appbrand.collector.c.cu(z);
                findViewById.setEnabled(z);
                WxaWidgetPerformanceUI.this.iYs.setEnabled(z);
                WxaWidgetPerformanceUI.this.iYt.setEnabled(z);
                WxaWidgetPerformanceUI.this.iYu.setEnabled(z);
            }
        };
        findViewById.setEnabled(abG);
        this.iYs = (MMSwitchBtn) findViewById(com.tencent.mm.plugin.appbrand.wxawidget.b.b.kmf);
        this.iYs.setEnabled(abG);
        this.iYs.nJ(com.tencent.mm.plugin.appbrand.collector.c.qM("jsapi_draw_canvas"));
        this.iYs.zEt = new com.tencent.mm.ui.widget.MMSwitchBtn.a() {
            public final void cy(boolean z) {
                f.a("com.tencent.mm:support", new IPCBoolean(z), b.class, null);
                if (z) {
                    com.tencent.mm.plugin.appbrand.collector.c.qK("jsapi_draw_canvas");
                } else {
                    com.tencent.mm.plugin.appbrand.collector.c.qL("jsapi_draw_canvas");
                }
            }
        };
        this.iYt = (MMSwitchBtn) findViewById(com.tencent.mm.plugin.appbrand.wxawidget.b.b.kmh);
        this.iYt.setEnabled(abG);
        this.iYt.nJ(com.tencent.mm.plugin.appbrand.collector.c.qM("widget_launch"));
        this.iYt.zEt = new com.tencent.mm.ui.widget.MMSwitchBtn.a() {
            public final void cy(boolean z) {
                f.a("com.tencent.mm:support", new IPCBoolean(z), c.class, null);
                if (z) {
                    com.tencent.mm.plugin.appbrand.collector.c.qK("widget_launch");
                } else {
                    com.tencent.mm.plugin.appbrand.collector.c.qL("widget_launch");
                }
            }
        };
        this.iYu = (MMSwitchBtn) findViewById(com.tencent.mm.plugin.appbrand.wxawidget.b.b.kmg);
        this.iYu.setEnabled(abG);
        this.iYu.nJ(com.tencent.mm.plugin.appbrand.collector.f.abH());
        this.iYu.zEt = new com.tencent.mm.ui.widget.MMSwitchBtn.a() {
            public final void cy(boolean z) {
                com.tencent.mm.plugin.appbrand.collector.f.cv(z);
            }
        };
    }

    public void finish() {
        if (!isFinishing() && !this.xQV) {
            if (VERSION.SDK_INT >= 21) {
                finishAndRemoveTask();
            } else {
                super.finish();
            }
            TypedArray obtainStyledAttributes = obtainStyledAttributes(16973825, new int[]{16842938, 16842939});
            int resourceId = obtainStyledAttributes.getResourceId(0, 0);
            int resourceId2 = obtainStyledAttributes.getResourceId(1, 0);
            obtainStyledAttributes.recycle();
            overridePendingTransition(resourceId, resourceId2);
        }
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.appbrand.wxawidget.b.c.kmT;
    }
}
