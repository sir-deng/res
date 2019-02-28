package com.tencent.mm.plugin.appbrand.ipc;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.view.KeyEvent;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.b;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPluginUI;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.mm.plugin.appbrand.ui.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;
import com.tencent.wcdb.database.SQLiteDatabase;

@com.tencent.mm.ui.base.a(7)
public class AppBrandProcessProxyUI extends MMActivity implements b {
    private int jeh = 0;
    private AppBrandProxyUIProcessTask jei;
    private ProcessRequest jej;
    private boolean jek = false;
    private volatile boolean jel = false;
    private i jem;
    private a jen;

    private class a implements OnClickListener, OnDismissListener {
        private boolean jev;

        private a() {
            this.jev = false;
        }

        /* synthetic */ a(AppBrandProcessProxyUI appBrandProcessProxyUI, byte b) {
            this();
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            kq(i);
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            kq(-2);
            AppBrandProcessProxyUI.this.a(null);
        }

        private void kq(int i) {
            if (!this.jev) {
                this.jev = true;
                ResultReceiver resultReceiver = (ResultReceiver) AppBrandProcessProxyUI.this.getIntent().getParcelableExtra("key_result_receiver");
                if (resultReceiver != null) {
                    resultReceiver.send(i, null);
                }
            }
        }
    }

    public static boolean u(Intent intent) {
        if (intent == null) {
            return false;
        }
        try {
            if (intent.getComponent() != null && intent.getComponent().getShortClassName().equals(".plugin.appbrand.ipc.AppBrandProcessProxyUI") && intent.getIntExtra("key_running_mode", -1) == 10000) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public static void m(Context context, Intent intent) {
        if (!(context instanceof AppBrandUI) || (context instanceof AppBrandPluginUI)) {
            context.startActivity(intent);
        } else {
            context.startActivity(new Intent(context, AppBrandProcessProxyUI.class).putExtra("key_running_mode", 10000).putExtra("key_proxy_launch_target_intent", intent).putExtra("key_proxy_launch_appbrand_ui_class", context.getClass()).addFlags(SQLiteDatabase.CREATE_IF_NECESSARY));
        }
    }

    static <_Req extends ProcessRequest, _Result extends ProcessResult> void a(Context context, Class<? extends AppBrandProcessProxyUI> cls, _Req _req, final b<_Result> bVar) {
        Context context2;
        Class cls2;
        Parcelable parcelable;
        if (context == null) {
            context2 = ad.getContext();
        } else {
            context2 = context;
        }
        String name = _req.afD().getName();
        if (cls == null) {
            cls2 = AppBrandProcessProxyUI.class;
        } else {
            Class<? extends AppBrandProcessProxyUI> cls22 = cls;
        }
        Intent putExtra = new Intent(context2, cls22).putExtra("key_model_class_name", name);
        String str = "key_result_receiver";
        if (bVar == null) {
            parcelable = null;
        } else {
            parcelable = new ResultReceiver(ag.fetchFreeHandler(Looper.getMainLooper())) {
                protected final void onReceiveResult(int i, Bundle bundle) {
                    if (bundle == null) {
                        bVar.c(null);
                        return;
                    }
                    bundle.setClassLoader(AppBrandProcessProxyUI.class.getClassLoader());
                    bVar.c((ProcessResult) bundle.getParcelable("key_result_parcel"));
                }
            };
        }
        putExtra = putExtra.putExtra(str, parcelable).putExtra("appbrand_report_key_target_activity", _req.afC()).putExtra("key_running_mode", 1);
        putExtra.putExtra("key_request_parcel", _req);
        if (context2 instanceof Activity) {
            putExtra.putExtra("key_need_light_status", j.c(((Activity) context2).getWindow()));
        } else {
            putExtra.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        }
        if (AppBrandProcessProxyUI.class == cls || !(context2 instanceof Activity)) {
            context2.startActivity(putExtra);
        } else {
            ((Activity) context2).startActivityForResult(putExtra, 0);
        }
    }

    static void a(Context context, Class<? extends AppBrandProcessProxyUI> cls, String str, String str2, String str3, String str4, final OnClickListener onClickListener, final OnClickListener onClickListener2, final OnClickListener onClickListener3) {
        if (context == null) {
            context = ad.getContext();
        }
        Intent putExtra = new Intent(context, cls).putExtra("key_running_mode", 2).putExtra("key_result_receiver", new ResultReceiver(ag.fetchFreeHandler(Looper.getMainLooper())) {
            protected final void onReceiveResult(int i, Bundle bundle) {
                if (-1 == i && onClickListener != null) {
                    onClickListener.onClick(null, i);
                }
                if (-2 == i && onClickListener2 != null) {
                    onClickListener2.onClick(null, i);
                }
                if (-3 == i && onClickListener3 != null) {
                    onClickListener3.onClick(null, i);
                }
            }
        }).putExtra("key_alert_message", str).putExtra("key_alert_title", str2).putExtra("key_alert_confirm", str3).putExtra("key_alert_deny", str4);
        if (!(context instanceof Activity)) {
            putExtra.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        }
        context.startActivity(putExtra);
    }

    public final int getLayoutId() {
        return -1;
    }

    protected final void onCreateBeforeSetContentView() {
        super.onCreateBeforeSetContentView();
        supportRequestWindowFeature(1);
    }

    public void onCreate(Bundle bundle) {
        boolean z = false;
        super.onCreate(bundle);
        overridePendingTransition(0, 0);
        j.a(getWindow());
        j.a(getWindow(), getIntent().getBooleanExtra("key_need_light_status", false));
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        if (getIntent() == null) {
            finish();
            return;
        }
        String stringExtra;
        switch (getIntent().getIntExtra("key_running_mode", 0)) {
            case 1:
                getIntent().setExtrasClassLoader(AppBrandProcessProxyUI.class.getClassLoader());
                stringExtra = getIntent().getStringExtra("key_model_class_name");
                x.i("MicroMsg.AppBrandProcessProxyUI", "onCreate, modelClass = %s", stringExtra);
                if (!bi.oN(stringExtra)) {
                    this.jei = a.su(stringExtra);
                    if (this.jei == null) {
                        x.e("MicroMsg.AppBrandProcessProxyUI", "onCreate unknown model class = %s", stringExtra);
                    } else if (getIntent().getBooleanExtra("key_request_need_params", true)) {
                        this.jej = (ProcessRequest) getIntent().getParcelableExtra("key_request_parcel");
                        if (this.jej == null) {
                            x.e("MicroMsg.AppBrandProcessProxyUI", "onCreate unknown request class = %s", stringExtra);
                        } else {
                            this.jei.jeE = this;
                            this.jei.a(this.jej);
                            z = true;
                        }
                    } else {
                        this.jej = null;
                    }
                }
                if (!z) {
                    finish();
                    return;
                }
                return;
            case 2:
                String nilAs = nilAs(getIntent().getStringExtra("key_alert_title"), "");
                stringExtra = nilAs(getIntent().getStringExtra("key_alert_message"), getString(q.j.dGZ));
                String nilAs2 = nilAs(getIntent().getStringExtra("key_alert_confirm"), "");
                final String nilAs3 = nilAs(getIntent().getStringExtra("key_alert_deny"), "");
                this.jen = new a();
                this.jem = h.a((Context) this, stringExtra, nilAs, nilAs2, nilAs3, false, this.jen, this.jen);
                this.jem.setOnDismissListener(this.jen);
                this.jem.setOnKeyListener(new OnKeyListener() {
                    public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                        if (i == 4 && keyEvent.getAction() == 1) {
                            if (!bi.oN(nilAs3)) {
                                AppBrandProcessProxyUI.this.jen.onClick(AppBrandProcessProxyUI.this.jem, -3);
                                dialogInterface.dismiss();
                            }
                            AppBrandProcessProxyUI.this.a(null);
                        }
                        return false;
                    }
                });
                return;
            case 10000:
                Intent intent = (Intent) getIntent().getParcelableExtra("key_proxy_launch_target_intent");
                if (intent != null) {
                    if (intent.getComponent() != null) {
                        try {
                            Class.forName(intent.getComponent().getClassName());
                        } catch (Exception e) {
                            x.e("MicroMsg.AppBrandProcessProxyUI", "proxyLaunch, Class.forName %s, e = %s", intent.getComponent().getClassName(), e);
                        }
                    }
                    try {
                        startActivity(intent);
                        return;
                    } catch (Exception e2) {
                        try {
                            x.e("MicroMsg.AppBrandProcessProxyUI", "start targetActivity, %s, e = %s", intent, e2);
                            return;
                        } catch (Exception e3) {
                            return;
                        }
                    }
                }
                finish();
                return;
            default:
                finish();
                return;
        }
    }

    private static String nilAs(String str, String str2) {
        return bi.oN(str) ? str2 : str;
    }

    protected void onResume() {
        super.onResume();
        int intExtra = getIntent().getIntExtra("key_running_mode", 0);
        if (intExtra == 10000) {
            intExtra = this.jeh + 1;
            this.jeh = intExtra;
            if (intExtra > 1) {
                try {
                    Class cls = (Class) getIntent().getSerializableExtra("key_proxy_launch_appbrand_ui_class");
                    if (cls == null) {
                        finish();
                        return;
                    }
                    startActivity(new Intent(this, cls).putExtra("key_appbrand_bring_ui_to_front", true).addFlags(SQLiteDatabase.CREATE_IF_NECESSARY));
                    finish();
                } catch (Exception e) {
                    finish();
                }
            }
        } else if (intExtra == 2) {
            x.d("MicroMsg.AppBrandProcessProxyUI", "onResume, RUNNING_MODE_SHOW_ALERT");
        } else {
            x.d("MicroMsg.AppBrandProcessProxyUI", "onResume, mFinishOnNextResume = %b, finishing = %b, request = %s", Boolean.valueOf(this.jek), Boolean.valueOf(afv()), this.jej.getClass().getName());
            if (this.jek && this.jej.afB() && !r0) {
                a(null);
            }
            this.jek = true;
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.jem != null && this.jem.isShowing()) {
            this.jem.dismiss();
            this.jem = null;
            this.jen = null;
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        x.d("MicroMsg.AppBrandProcessProxyUI", "onActivityResult, requestCode = %d, resultCode = %d, request = %s", Integer.valueOf(i), Integer.valueOf(i2), this.jej.getClass().getName());
        this.jek = false;
    }

    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
        if (this.jei != null) {
            this.jei.afA();
        }
    }

    public final MMActivity afu() {
        return this;
    }

    public final void a(final ProcessResult processResult) {
        this.jel = true;
        runOnUiThread(new Runnable() {
            public final void run() {
                AppBrandProcessProxyUI.this.b(processResult);
                AppBrandProcessProxyUI.this.finish();
            }
        });
    }

    public final boolean afv() {
        return this.xQV || isFinishing() || this.jel;
    }

    public final void b(ProcessResult processResult) {
        ResultReceiver resultReceiver = (ResultReceiver) getIntent().getParcelableExtra("key_result_receiver");
        if (resultReceiver != null && processResult != null) {
            Bundle bundle = new Bundle(2);
            bundle.putParcelable("key_result_parcel", processResult);
            resultReceiver.send(0, bundle);
        }
    }
}
