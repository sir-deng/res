package com.tencent.mm.plugin.facedetect.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.bl.d;
import com.tencent.mm.plugin.facedetect.a.g;
import com.tencent.mm.plugin.facedetect.a.h;
import com.tencent.mm.plugin.facedetect.b.l;
import com.tencent.mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.mm.protocal.c.aog;
import com.tencent.mm.protocal.c.aze;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.y.q;
import java.util.ArrayList;
import java.util.List;

@a(3)
public class FaceDetectConfirmUI extends MMActivity implements e {
    private String appId;
    private int hMM;
    private String jND;
    private String jsl;
    private String mkX = null;
    private TextView moq;
    private TextView mor;
    private TextView mos;
    private Button mot;
    private List<aog> mou = new ArrayList();
    private aze mov = null;
    private r tipDialog;

    protected final int getLayoutId() {
        return g.mjo;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.appId = getIntent().getStringExtra("k_app_id");
        this.jsl = getIntent().getStringExtra("request_verify_pre_info");
        this.jND = getIntent().getStringExtra("key_function_name");
        this.hMM = getIntent().getIntExtra("key_business_type", -1);
        setMMTitle(getString(h.mjC));
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                x.i("MicroMsg.FaceDetectConfirmUI", "alvinluo cancel with back button");
                FaceDetectConfirmUI.this.aHN();
                return false;
            }
        });
        this.moq = (TextView) findViewById(com.tencent.mm.plugin.facedetect.a.e.miG);
        this.mor = (TextView) findViewById(com.tencent.mm.plugin.facedetect.a.e.miQ);
        this.mos = (TextView) findViewById(com.tencent.mm.plugin.facedetect.a.e.miP);
        this.mot = (Button) findViewById(com.tencent.mm.plugin.facedetect.a.e.mjj);
        this.mot.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                Intent intent = new Intent(FaceDetectConfirmUI.this, FaceDetectPrepareUI.class);
                Bundle extras = FaceDetectConfirmUI.this.getIntent().getExtras();
                if (extras != null) {
                    extras.putString("key_feedback_url", "http://support.qq.com/product/19936");
                    intent.putExtras(extras);
                    FaceDetectConfirmUI.this.startActivityForResult(intent, 1);
                    return;
                }
                x.e("MicroMsg.FaceDetectConfirmUI", "alvinluo extras is null when start FaceDetectPrepareUI");
            }
        });
        x.i("MicroMsg.FaceDetectConfirmUI", "alvinluo start get confirm info");
        Context context = this.mController.xRr;
        getString(h.dGZ);
        this.tipDialog = com.tencent.mm.ui.base.h.a(context, getString(h.dHn), false, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
        k lVar = new l(this.appId, this.jsl);
        com.tencent.mm.kernel.g.CN().a(1147, (e) this);
        com.tencent.mm.kernel.g.CN().a(lVar, 0);
    }

    private void aHN() {
        Intent intent = new Intent();
        intent.putExtra("err_code", com.tencent.mm.plugin.facedetect.model.k.pO(90024));
        intent.putExtra("err_msg", "user cancel in confirm ui");
        FaceDetectReporter.aHr().a(this.hMM, false, 3, 1, 90024);
        FaceDetectReporter.aHr().mmG = System.currentTimeMillis();
        FaceDetectReporter.aHr().bk(this.jND, this.hMM);
        setResult(0, intent);
        finish();
    }

    public void finish() {
        dismissDialog();
        super.finish();
    }

    private void dismissDialog() {
        if (this.tipDialog != null && this.tipDialog.isShowing()) {
            this.tipDialog.dismiss();
        }
    }

    public void onBackPressed() {
        aHN();
        super.onBackPressed();
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.FaceDetectConfirmUI", "alvinluo scene: %d, errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(kVar.getType()), Integer.valueOf(i), Integer.valueOf(i2), str);
        if (i == 0 && i2 == 0) {
            this.mou = ((l) kVar).mkV;
            this.mov = ((l) kVar).mkW;
            this.mkX = ((l) kVar).mkX;
            if (bi.oN(this.mkX)) {
                this.mkX = getString(h.mjB);
            }
            dismissDialog();
            this.mot.setEnabled(true);
            this.moq.setText(this.mkX);
            x.i("MicroMsg.FaceDetectConfirmUI", "alvinluo refreshView");
            if (this.mov != null) {
                if (!bi.oN(this.mov.fzT)) {
                    x.v("MicroMsg.FaceDetectConfirmUI", "alvinluo provider wording: %s", this.mov.fzT);
                    this.mor.setVisibility(0);
                    this.mor.setText(this.mov.fzT);
                }
                if (!bi.oN(this.mov.wMP)) {
                    x.v("MicroMsg.FaceDetectConfirmUI", "alvinluo protocal url wording: %s", this.mov.wMP);
                    this.mos.setVisibility(0);
                    this.mos.setText(this.mov.wMP);
                    if (!bi.oN(this.mov.url)) {
                        x.v("MicroMsg.FaceDetectConfirmUI", "alvinluo protocal url: %s", this.mov.url);
                        final String str2 = this.mov.url;
                        this.mos.setOnClickListener(new OnClickListener() {
                            public final void onClick(View view) {
                                Intent intent = new Intent();
                                intent.putExtra("rawUrl", str2);
                                intent.putExtra("showShare", false);
                                intent.putExtra("geta8key_username", q.FY());
                                d.b(FaceDetectConfirmUI.this, "webview", ".ui.tools.WebViewUI", intent);
                            }
                        });
                    }
                }
            }
        } else {
            if (bi.oN(str)) {
                str = getString(h.mjN);
            }
            dismissDialog();
            com.tencent.mm.ui.base.h.a((Context) this, str, getString(h.dGZ), false, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    Intent intent = new Intent();
                    intent.putExtra("err_code", com.tencent.mm.plugin.facedetect.model.k.pO(90022));
                    intent.putExtra("err_msg", "get confirm info error");
                    FaceDetectReporter.aHr().a(FaceDetectConfirmUI.this.hMM, false, 3, 2, 90022);
                    FaceDetectReporter.aHr().mmG = System.currentTimeMillis();
                    FaceDetectReporter.aHr().bk(FaceDetectConfirmUI.this.jND, FaceDetectConfirmUI.this.hMM);
                    FaceDetectConfirmUI.this.setResult(-1, intent);
                    FaceDetectConfirmUI.this.finish();
                }
            });
        }
        com.tencent.mm.kernel.g.CN().b(1147, (e) this);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.i("MicroMsg.FaceDetectConfirmUI", "onActiviyResult reqeustCode: %d, resultCode: %d", Integer.valueOf(i), Integer.valueOf(i2));
        FaceDetectReporter.aHr().mmG = System.currentTimeMillis();
        FaceDetectReporter.aHr().bk(this.jND, this.hMM);
        setResult(i2, intent);
        finish();
    }
}
