package com.tencent.mm.plugin.bottle.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ac.b;
import com.tencent.mm.ac.d;
import com.tencent.mm.ac.n;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.pluginsdk.g.a;
import com.tencent.mm.pluginsdk.model.p;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.q;

public class BottleWizardStep1 extends MMActivity {
    private ImageView kIb = null;

    static /* synthetic */ boolean a(BottleWizardStep1 bottleWizardStep1) {
        as.Hm();
        if (c.isSDCardAvailable()) {
            h.a((Context) bottleWizardStep1, "", bottleWizardStep1.getResources().getStringArray(R.c.bqN), "", new h.c() {
                public final void jo(int i) {
                    switch (i) {
                        case 0:
                            x.i("MicroMsg.BottleWizardStep1", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", Boolean.valueOf(a.a(BottleWizardStep1.this.mController.xRr, "android.permission.CAMERA", 16, "", "")), bi.chl(), BottleWizardStep1.this.mController.xRr);
                            if (a.a(BottleWizardStep1.this.mController.xRr, "android.permission.CAMERA", 16, "", "")) {
                                BottleWizardStep1.this.asx();
                                return;
                            }
                            return;
                        case 1:
                            k.a(BottleWizardStep1.this, 2, null);
                            return;
                        default:
                            return;
                    }
                }
            });
            return true;
        }
        u.fJ(bottleWizardStep1);
        return false;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public void onDestroy() {
        super.onDestroy();
    }

    private void asw() {
        Bitmap a;
        Bitmap a2 = b.a(com.tencent.mm.storage.x.Xk(q.FY()), false, -1);
        if (a2 == null) {
            a = b.a(q.FY(), false, -1);
        } else {
            a = a2;
        }
        this.kIb = (ImageView) findViewById(R.h.cpk);
        if (a != null) {
            this.kIb.setImageBitmap(a);
        }
    }

    protected void onResume() {
        super.onResume();
        initView();
        asw();
    }

    protected final int getLayoutId() {
        return R.i.dbG;
    }

    protected final void initView() {
        setMMTitle(R.l.dMO);
        ((LinearLayout) findViewById(R.h.cpl)).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                BottleWizardStep1.a(BottleWizardStep1.this);
            }
        });
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                BottleWizardStep1.this.aWY();
                BottleWizardStep1.this.finish();
                return true;
            }
        });
        addTextOptionMenu(0, getString(R.l.dGb), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                BottleWizardStep1.this.startActivity(new Intent().setClass(BottleWizardStep1.this, BottleWizardStep2.class));
                BottleWizardStep1.this.finish();
                return true;
            }
        });
    }

    private void asx() {
        if (!k.c((Activity) this, e.gJf, "microMsg." + System.currentTimeMillis() + ".jpg", 3)) {
            Toast.makeText(this, getString(R.l.eJI), 1).show();
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        x.i("MicroMsg.BottleWizardStep1", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 16:
                if (iArr[0] == 0) {
                    asx();
                    return;
                } else {
                    h.a((Context) this, getString(R.l.ezZ), getString(R.l.eAg), getString(R.l.esG), getString(R.l.cancel), false, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            BottleWizardStep1.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, null);
                    return;
                }
            default:
                return;
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        Context applicationContext;
        String b;
        Intent intent2;
        switch (i) {
            case 2:
                if (intent != null) {
                    applicationContext = getApplicationContext();
                    as.Hm();
                    b = k.b(applicationContext, intent, c.Fp());
                    if (b != null) {
                        intent2 = new Intent();
                        intent2.putExtra("CropImageMode", 1);
                        intent2.putExtra("CropImage_ImgPath", b);
                        StringBuilder stringBuilder = new StringBuilder();
                        n.JF();
                        intent2.putExtra("CropImage_OutputPath", stringBuilder.append(d.x(com.tencent.mm.storage.x.Xk(q.FY()), true)).append(".crop").toString());
                        com.tencent.mm.plugin.bottle.a.ihN.a(intent2, 4, this, intent);
                        return;
                    }
                    return;
                }
                return;
            case 3:
                applicationContext = getApplicationContext();
                as.Hm();
                b = k.b(applicationContext, intent, c.Fp());
                if (b != null) {
                    intent2 = new Intent();
                    intent2.putExtra("CropImageMode", 1);
                    intent2.putExtra("CropImage_OutputPath", b);
                    intent2.putExtra("CropImage_ImgPath", b);
                    com.tencent.mm.plugin.bottle.a.ihN.a((Activity) this, intent2, 4);
                    return;
                }
                return;
            case 4:
                if (intent != null) {
                    b = intent.getStringExtra("CropImage_OutputPath");
                    if (b == null) {
                        x.e("MicroMsg.BottleWizardStep1", "crop picture failed");
                        return;
                    } else {
                        new p(this.mController.xRr, b).c(2, new Runnable() {
                            public final void run() {
                                BottleWizardStep1.this.asw();
                            }
                        });
                        return;
                    }
                }
                return;
            default:
                return;
        }
    }
}
