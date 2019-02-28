package com.tencent.mm.ui.account;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.c.a;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.account.mobile.MobileInputUI;
import com.tencent.mm.ui.base.b;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bi;

@Deprecated
public class LoginSelectorUI extends MMActivity implements OnClickListener {
    private View ogB;
    private TextView xYa;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitleVisibility(8);
        a.ihO.uq();
        as.CJ();
        initView();
    }

    protected final int getLayoutId() {
        return R.i.drO;
    }

    public void onResume() {
        super.onResume();
        as.CJ();
    }

    protected final void initView() {
        Button button = (Button) findViewById(R.h.cLa);
        Button button2 = (Button) findViewById(R.h.cLj);
        this.xYa = (TextView) findViewById(R.h.cKW);
        this.ogB = findViewById(R.h.cKX);
        button.setOnClickListener(this);
        button2.setOnClickListener(this);
        this.xYa.setText(w.g(this.mController.xRr, R.c.bqS, R.l.dFG));
        this.ogB.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("not_auth_setting", true);
                a.ihN.r(intent, LoginSelectorUI.this.mController.xRr);
            }
        });
        if (f.xmV) {
            a.ihO.e(this);
        } else {
            a.ihO.aq(this);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
            Intent at = a.ihN.at(this);
            at.addFlags(67108864);
            at.putExtra("can_finish", true);
            startActivity(at);
            finish();
            b.fH(this);
        }
        return super.onKeyDown(i, keyEvent);
    }

    public void onClick(View view) {
        boolean z = true;
        if (R.h.cLa == view.getId()) {
            Intent intent = new Intent(this, MobileInputUI.class);
            intent.putExtra("mobile_input_purpose", 1);
            startActivity(intent);
        } else if (R.h.cLj != view.getId()) {
        } else {
            if (d.vHo) {
                String string = getString(R.l.dXX, new Object[]{"0x" + Integer.toHexString(d.vHl), w.cfV()});
                Intent intent2 = new Intent();
                intent2.putExtra("rawUrl", string);
                intent2.putExtra("showShare", false);
                intent2.putExtra("show_bottom", false);
                intent2.putExtra("needRedirect", false);
                intent2.putExtra("neverGetA8Key", true);
                intent2.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vHy);
                intent2.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vHv);
                a.ihN.j(intent2, this);
                return;
            }
            if (bi.HU().HV() <= 0) {
                z = false;
            }
            Intent intent3;
            if (z) {
                intent3 = new Intent(this, RegByMobileRegAIOUI.class);
                intent3.putExtra("login_type", 0);
                startActivity(intent3);
                return;
            }
            intent3 = new Intent(this, MobileInputUI.class);
            intent3.putExtra("mobile_input_purpose", 2);
            startActivity(intent3);
        }
    }
}
