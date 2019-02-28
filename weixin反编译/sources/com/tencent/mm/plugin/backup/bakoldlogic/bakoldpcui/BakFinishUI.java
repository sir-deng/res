package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e.e;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;

public class BakFinishUI extends MMWizardActivity implements e {
    private ag handler = new ag(Looper.getMainLooper());
    private int kxw;
    private TextView kxy;

    protected final int getLayoutId() {
        return R.i.dbb;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!getIntent().getExtras().getBoolean("WizardRootKillSelf", false)) {
            this.kxw = getIntent().getIntExtra("cmd", -1);
            x.i("MicroMsg.BakFinishUI", "BakFinishUI onCreate nowCmd:%d", Integer.valueOf(this.kxw));
            initView();
            a.aqS().aqT().kwG = this;
        }
    }

    protected final void initView() {
        setMMTitle(R.l.dKx);
        this.kxy = (TextView) findViewById(R.h.bMv);
        if (6 == this.kxw) {
            this.kxy.setText(getString(R.l.dKw));
        } else if (1 == this.kxw) {
            this.kxy.setText(getString(R.l.dKp));
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                a.aqS().aqT().kwO = -1;
                BakFinishUI.this.En(1);
                return true;
            }
        });
    }

    public void onDestroy() {
        super.onDestroy();
        a.aqS().aqT().kwG = null;
        x.i("MicroMsg.BakFinishUI", "BakFinishUI onDestroy nowCmd:%d", Integer.valueOf(this.kxw));
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        a.aqS().aqT().kwO = -1;
        En(1);
        return true;
    }

    public final void ari() {
        this.handler.post(new Runnable() {
            public final void run() {
                a.aqS().aqT().kwO = -1;
                BakFinishUI.this.En(1);
            }
        });
    }

    public final void onError(int i) {
        this.handler.post(new Runnable() {
            public final void run() {
                x.d("MicroMsg.BakFinishUI", "BakFinishUI onCloseSocket");
                MMWizardActivity.A(BakFinishUI.this, new Intent(BakFinishUI.this, BakConnErrorUI.class));
            }
        });
    }
}
