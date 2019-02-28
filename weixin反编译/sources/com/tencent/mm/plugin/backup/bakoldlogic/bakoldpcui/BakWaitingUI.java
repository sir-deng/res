package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.bl.d;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e.c;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;

public class BakWaitingUI extends MMWizardActivity implements c {
    private ag handler = new ag(Looper.getMainLooper());
    private boolean kxP;
    private int pK;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!getIntent().getExtras().getBoolean("WizardRootKillSelf", false)) {
            a.aqS().aqT().kwE = this;
            this.pK = a.aqS().aqT().kwL;
            this.kxP = getIntent().getBooleanExtra("from_back_finish", false);
            x.i("MicroMsg.BakWaitingUI", "BakWaitingUI onCreate nowCmd:%d isFromFinish:%b", Integer.valueOf(this.pK), Boolean.valueOf(this.kxP));
            initView();
            arp();
        }
    }

    protected final void initView() {
        setMMTitle(R.l.dKx);
        if (this.kxP) {
            findViewById(R.h.bMz).setVisibility(8);
        } else {
            findViewById(R.h.bMz).setVisibility(0);
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                BakWaitingUI.this.En(1);
                return true;
            }
        });
    }

    protected final int getLayoutId() {
        return R.i.dbd;
    }

    public final void nm(int i) {
        this.pK = i;
        this.handler.post(new Runnable() {
            public final void run() {
                BakWaitingUI.this.arp();
            }
        });
    }

    public void onDestroy() {
        super.onDestroy();
        a.aqS().aqT().kwE = null;
        x.i("MicroMsg.BakWaitingUI", "BakWaitingUI onDestroy nowCmd:%d isFromFinish:%b", Integer.valueOf(this.pK), Boolean.valueOf(this.kxP));
    }

    public final void nn(final int i) {
        this.handler.post(new Runnable() {
            public final void run() {
                x.d("MicroMsg.BakWaitingUI", "BakWaitingUI onCloseSocket errType: %d", Integer.valueOf(i));
                if (i == -1) {
                    x.d("MicroMsg.BakWaitingUI", "BakToPcUI jump tips");
                    Intent intent = new Intent();
                    intent.putExtra("title", BakWaitingUI.this.getString(R.l.dJp));
                    intent.putExtra("rawUrl", BakWaitingUI.this.getString(R.l.dIM, new Object[]{w.cfV()}));
                    intent.putExtra("showShare", false);
                    intent.putExtra("neverGetA8Key", true);
                    d.b(BakWaitingUI.this, "webview", ".ui.tools.WebViewUI", intent);
                }
            }
        });
    }

    final void arp() {
        if (6 == this.pK || 1 == this.pK) {
            Intent intent = new Intent(this, BakOperatingUI.class);
            intent.putExtra("cmd", this.pK);
            MMWizardActivity.A(this, intent);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        En(1);
        return true;
    }

    public final void onError(final int i) {
        this.handler.post(new Runnable() {
            public final void run() {
                x.d("MicroMsg.BakWaitingUI", "BakWaitingUI onCloseSocket errType: %d", Integer.valueOf(i));
                if (i == -1) {
                    x.d("MicroMsg.BakWaitingUI", "BakToPcUI jump tips");
                    Intent intent = new Intent();
                    intent.putExtra("title", BakWaitingUI.this.getString(R.l.dJp));
                    intent.putExtra("rawUrl", BakWaitingUI.this.getString(R.l.dIM, new Object[]{w.cfV()}));
                    intent.putExtra("showShare", false);
                    intent.putExtra("neverGetA8Key", true);
                    d.b(BakWaitingUI.this, "webview", ".ui.tools.WebViewUI", intent);
                    return;
                }
                MMWizardActivity.A(BakWaitingUI.this, new Intent(BakWaitingUI.this, BakConnErrorUI.class));
            }
        });
    }
}
