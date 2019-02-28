package com.tencent.mm.ui.account;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ad.k;
import com.tencent.mm.bl.d;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.y.as;

public class LoginFaceUI extends LoginHistoryUI {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!this.xXt) {
            this.jjv = 4;
            this.xXr.setVisibility(0);
            this.xWZ.setVisibility(0);
            findViewById(R.h.cfO).setEnabled(false);
            ((TextView) findViewById(R.h.cfP)).setTextColor(getResources().getColorStateList(R.e.bum));
            ((TextView) findViewById(R.h.cfP)).setBackgroundResource(getResources().getColor(R.e.transparent));
            this.xWZ.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    g.pWK.h(11557, Integer.valueOf(2));
                    Intent intent = new Intent();
                    intent.putExtra("k_user_name", LoginFaceUI.this.xXn);
                    intent.putExtra("k_purpose", 2);
                    intent.putExtra("k_need_signature", true);
                    d.b(LoginFaceUI.this.mController.xRr, "facedetect", ".ui.FaceDetectUI", intent, 1025);
                }
            });
        }
    }

    protected final void afV() {
        int i = -1;
        super.afV();
        coB();
        final k vVar = new v(this.xXn, this.smV, "", 0);
        String str = "MicroMsg.LoginFaceUI";
        String str2 = "summerauth mAuthPwd len:%d content[%s] logindata.rawPsw len:%d content[%s]";
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(this.smV == null ? -1 : this.smV.length());
        objArr[1] = bi.Wz(this.smV);
        if (this.xXf.xXT != null) {
            i = this.xXf.xXT.length();
        }
        objArr[2] = Integer.valueOf(i);
        objArr[3] = bi.Wz(this.xXf.xXT);
        x.d(str, str2, objArr);
        getString(R.l.dGZ);
        this.inI = h.a((Context) this, getString(R.l.etS), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                as.CN().c(vVar);
                LoginFaceUI.this.coC();
            }
        });
        as.CN().a(vVar, 0);
    }
}
