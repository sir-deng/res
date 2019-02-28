package com.tencent.mm.plugin.traceroute.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.plugin.traceroute.a.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;

public class NetworkDiagnoseIntroUI extends MMActivity {
    private Button slF;
    private TextView slG;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    protected final void initView() {
        this.slF = (Button) findViewById(R.h.cPm);
        this.slF.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                as.Hm();
                if (!c.isSDCardAvailable()) {
                    u.fJ(NetworkDiagnoseIntroUI.this);
                } else if (as.CN().Ks() == 0) {
                    Toast.makeText(NetworkDiagnoseIntroUI.this, NetworkDiagnoseIntroUI.this.getString(R.l.eiR), 0).show();
                } else {
                    NetworkDiagnoseIntroUI.this.startActivity(new Intent(NetworkDiagnoseIntroUI.this, NetworkDiagnoseUI.class));
                    NetworkDiagnoseIntroUI.this.finish();
                }
            }
        });
        this.slG = (TextView) findViewById(R.h.czn);
        this.slG.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("title", NetworkDiagnoseIntroUI.this.getString(R.l.eBl));
                intent.putExtra("rawUrl", NetworkDiagnoseIntroUI.this.getString(R.l.eSB));
                intent.putExtra("showShare", false);
                a.ihN.j(intent, NetworkDiagnoseIntroUI.this.mController.xRr);
            }
        });
        setMMTitle("");
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                NetworkDiagnoseIntroUI.this.finish();
                return true;
            }
        });
    }

    protected final int getLayoutId() {
        return R.i.doZ;
    }
}
