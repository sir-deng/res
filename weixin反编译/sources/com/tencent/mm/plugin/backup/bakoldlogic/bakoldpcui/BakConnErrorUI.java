package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;

public class BakConnErrorUI extends MMWizardActivity {
    private int kxw;

    protected final int getLayoutId() {
        return R.i.dba;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!getIntent().getExtras().getBoolean("WizardRootKillSelf", false)) {
            this.kxw = getIntent().getIntExtra("cmd", -1);
            x.i("MicroMsg.BakFinishUI", "BakConnErrorUI onCreate nowCmd:%d", Integer.valueOf(this.kxw));
            initView();
            a.aqS().aqT().kwO = -1;
        }
    }

    protected final void initView() {
        setMMTitle(R.l.dKx);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                BakConnErrorUI.this.En(1);
                return true;
            }
        });
    }

    public void onDestroy() {
        super.onDestroy();
        a.aqS().aqT().kwG = null;
        x.i("MicroMsg.BakFinishUI", "BakConnErrorUI onDestroy nowCmd:%d", Integer.valueOf(this.kxw));
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        En(1);
        return true;
    }
}
