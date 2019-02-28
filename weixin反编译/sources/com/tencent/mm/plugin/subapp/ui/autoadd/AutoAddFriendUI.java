package com.tencent.mm.plugin.subapp.ui.autoadd;

import android.os.Bundle;
import android.util.SparseIntArray;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.j.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.e;
import com.tencent.mm.protocal.c.wu;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.q;

public class AutoAddFriendUI extends MMActivity {
    private MMSwitchBtn scM = null;
    private TextView scN = null;
    private MMSwitchBtn scO = null;
    private SparseIntArray scP = new SparseIntArray();
    private int status;

    static /* synthetic */ boolean a(AutoAddFriendUI autoAddFriendUI, boolean z, int i, int i2) {
        x.d("MicroMsg.AutoAddFriendUI", "switch change : open = " + z + " item value = " + i + " functionId = " + i2);
        if (z) {
            autoAddFriendUI.status |= i;
        } else {
            autoAddFriendUI.status &= i ^ -1;
        }
        autoAddFriendUI.scP.put(i2, z ? 1 : 2);
        return true;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(R.l.dHw);
        this.status = q.Gc();
        initView();
    }

    private boolean vj(int i) {
        return (this.status & i) != 0;
    }

    protected final int getLayoutId() {
        return R.i.daO;
    }

    protected final void initView() {
        this.scM = (MMSwitchBtn) findViewById(R.h.czm);
        this.scN = (TextView) findViewById(R.h.bLz);
        this.scO = (MMSwitchBtn) findViewById(R.h.bLy);
        this.scM.nJ(vj(32));
        if (bEN() == 1) {
            this.scO.nJ(vj(2097152));
            this.scO.zEt = new a() {
                public final void cy(boolean z) {
                    AutoAddFriendUI.a(AutoAddFriendUI.this, z, 2097152, 32);
                }
            };
        } else {
            this.scN.setVisibility(8);
            this.scO.setVisibility(8);
        }
        this.scM.zEt = new a() {
            public final void cy(boolean z) {
                AutoAddFriendUI.a(AutoAddFriendUI.this, z, 32, 4);
            }
        };
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AutoAddFriendUI.this.finish();
                return true;
            }
        });
    }

    private static int bEN() {
        int i;
        String value = g.Af().getValue("AutoAddFriendShow");
        if (bi.oN(value)) {
            value = "0";
        }
        try {
            i = bi.getInt(value, 0);
        } catch (Exception e) {
            i = 0;
        }
        x.d("MicroMsg.AutoAddFriendUI", "getAutoAddDynamicConfig, autoAdd = %d", Integer.valueOf(i));
        return i;
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onPause() {
        super.onPause();
        as.Hm();
        c.Db().set(7, Integer.valueOf(this.status));
        for (int i = 0; i < this.scP.size(); i++) {
            int keyAt = this.scP.keyAt(i);
            int valueAt = this.scP.valueAt(i);
            com.tencent.mm.bp.a wuVar = new wu();
            wuVar.wnP = keyAt;
            wuVar.wnQ = valueAt;
            as.Hm();
            c.Fe().b(new e.a(23, wuVar));
            x.d("MicroMsg.AutoAddFriendUI", "switch  " + keyAt + " " + valueAt);
        }
        this.scP.clear();
    }

    protected void onDestroy() {
        super.onDestroy();
    }
}
