package com.tencent.mm.ui.tools;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.bl.d;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.transmit.ShareImageSelectorUI;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import java.util.ArrayList;

@a(7)
public class ShareImageRedirectUI extends MMBaseActivity {
    private String imagePath;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.i("MicroMsg.ShareImageRedirectUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.CAMERA", 16, "", "")), bi.chl(), this);
        if (com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.CAMERA", 16, "", "")) {
            asx();
        }
    }

    private void asx() {
        k.c((Activity) this, e.gJf, "microMsg." + System.currentTimeMillis() + ".jpg", 0);
        getWindow().getDecorView().setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                Toast.makeText(ShareImageRedirectUI.this, R.l.ePG, 1).show();
                ShareImageRedirectUI.this.finish();
                return false;
            }
        });
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        x.i("MicroMsg.ShareImageRedirectUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 16:
                if (iArr[0] == 0) {
                    asx();
                    return;
                } else {
                    h.a((Context) this, getString(R.l.ezZ), getString(R.l.eAg), getString(R.l.esG), getString(R.l.cancel), false, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            ShareImageRedirectUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            ShareImageRedirectUI.this.finish();
                        }
                    }, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            ShareImageRedirectUI.this.finish();
                        }
                    });
                    return;
                }
            default:
                return;
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        ArrayList arrayList = null;
        getWindow().getDecorView().setOnTouchListener(null);
        if (i2 != -1) {
            finish();
            return;
        }
        Intent intent2;
        switch (i) {
            case 0:
                Context applicationContext = getApplicationContext();
                as.Hm();
                this.imagePath = k.b(applicationContext, intent, c.Fp());
                if (this.imagePath != null) {
                    intent2 = new Intent(this, ShareImageSelectorUI.class);
                    intent2.putExtra("intent_extra_image_path", this.imagePath);
                    startActivityForResult(intent2, 2);
                    return;
                }
                return;
            case 2:
                if (intent != null) {
                    arrayList = intent.getStringArrayListExtra("Select_Contact");
                }
                if (arrayList != null && arrayList.size() == 1) {
                    Intent intent3 = new Intent(this, ChattingUI.class);
                    intent3.putExtra("Chat_User", (String) arrayList.get(0));
                    startActivity(intent3);
                    finish();
                    return;
                } else if (arrayList == null || arrayList.size() <= 1) {
                    intent2 = new Intent();
                    intent2.putExtra("Ksnsupload_type", 0);
                    intent2.putExtra("sns_kemdia_path", this.imagePath);
                    d.b(this, "sns", ".ui.SnsUploadUI", intent2);
                    finish();
                    return;
                } else {
                    finish();
                    return;
                }
            default:
                return;
        }
    }
}
