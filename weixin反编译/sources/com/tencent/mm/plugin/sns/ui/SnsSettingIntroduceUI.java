package com.tencent.mm.plugin.sns.ui;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mm.bl.d;
import com.tencent.mm.f.a.an;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sns.i;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.e.e;

public class SnsSettingIntroduceUI extends MMActivity {
    private Button rMm;
    private Button rMn;
    private Intent rMo;

    public void onDestroy() {
        super.onDestroy();
    }

    @TargetApi(17)
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        this.mController.hideTitleView();
        this.rMo = getIntent();
        this.rMm = (Button) findViewById(f.bLU);
        this.rMm.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                g.pWK.h(14090, Integer.valueOf(3));
                d.b(SnsSettingIntroduceUI.this, "sns", ".ui.SnsTimeLineUI", SnsSettingIntroduceUI.this.rMo);
                SnsSettingIntroduceUI.this.finish();
                SnsSettingIntroduceUI.this.overridePendingTransition(0, 0);
            }
        });
        g.pWK.h(14090, Integer.valueOf(1));
        this.rMn = (Button) findViewById(f.cnL);
        this.rMn.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                b anVar = new an();
                anVar.fpz.index = 3;
                a.xmy.m(anVar);
                d.b(SnsSettingIntroduceUI.this.mController.xRr, "setting", ".ui.setting.SettingsUI", new Intent());
                Intent intent = new Intent();
                intent.putExtra("enter_scene", e.xMP);
                d.b(SnsSettingIntroduceUI.this.mController.xRr, "setting", ".ui.setting.SettingsPrivacyUI", intent);
                g.pWK.h(14090, Integer.valueOf(2));
                SnsSettingIntroduceUI.this.finish();
            }
        });
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getAction() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        finish();
        g.pWK.h(14090, Integer.valueOf(3));
        return true;
    }

    protected final int getLayoutId() {
        return i.g.qNQ;
    }
}
