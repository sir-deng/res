package com.tencent.mm.ui.account;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ad.k;
import com.tencent.mm.bl.d;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.y.as;

public class LoginVoiceUI extends LoginHistoryUI {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!this.xXt) {
            this.jjv = 1;
            this.ueF.setVisibility(0);
            this.xWY.setVisibility(0);
            LayoutParams layoutParams = (LayoutParams) this.xWX.getLayoutParams();
            layoutParams.gravity = 1;
            layoutParams.leftMargin = 0;
            this.xWX.setLayoutParams(layoutParams);
            findViewById(R.h.cWr).setEnabled(false);
            ((TextView) findViewById(R.h.cWw)).setTextColor(getResources().getColorStateList(R.e.bum));
            ((TextView) findViewById(R.h.cWw)).setBackgroundResource(getResources().getColor(R.e.transparent));
            this.xWY.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    g.pWK.h(11557, Integer.valueOf(2));
                    Intent intent = new Intent();
                    intent.putExtra("Kusername", LoginVoiceUI.this.xXn);
                    intent.putExtra("kscene_type", 1);
                    d.b(LoginVoiceUI.this.mController.xRr, "voiceprint", ".ui.VoiceLoginUI", intent, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
                }
            });
        }
    }

    public final boolean coF() {
        return false;
    }

    protected final void afV() {
        int i = -1;
        super.afV();
        coB();
        final k vVar = new v(this.xXn, this.smV, "", 0);
        vVar.mA(this.smV);
        String str = "MicroMsg.LoginVoiceUI";
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
                LoginVoiceUI.this.coC();
            }
        });
        as.CN().a(vVar, 0);
    }
}
