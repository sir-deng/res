package com.tencent.mm.plugin.nearby.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.t;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bj;
import com.tencent.mm.y.c;

public class NearbyFriendsIntroUI extends MMActivity {
    private Button kxK;
    private View oTU;
    private CheckBox oTV;
    private i oTX = null;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(R.l.exE);
        initView();
    }

    protected final int getLayoutId() {
        return R.i.doQ;
    }

    protected final void initView() {
        this.oTU = View.inflate(this, R.i.dmH, null);
        this.oTV = (CheckBox) this.oTU.findViewById(R.h.csL);
        this.oTV.setChecked(false);
        this.kxK = (Button) findViewById(R.h.cyY);
        this.kxK.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (NearbyFriendsIntroUI.this.oTX == null) {
                    NearbyFriendsIntroUI.this.oTX = h.a(NearbyFriendsIntroUI.this.mController.xRr, NearbyFriendsIntroUI.this.getString(R.l.dGZ), NearbyFriendsIntroUI.this.oTU, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            boolean z = true;
                            as.Hm();
                            c.Db().set(4103, Boolean.valueOf(true));
                            as.Hm();
                            t Db = c.Db();
                            if (NearbyFriendsIntroUI.this.oTV.isChecked()) {
                                z = false;
                            }
                            Db.set(4104, Boolean.valueOf(z));
                            bj HX = bj.HX();
                            if (HX == null) {
                                NearbyFriendsIntroUI.this.startActivity(new Intent(NearbyFriendsIntroUI.this, NearbyPersonalInfoUI.class));
                            } else {
                                String oM = bi.oM(HX.getProvince());
                                bi.oM(HX.getCity());
                                int a = bi.a(Integer.valueOf(HX.fXa), 0);
                                if (oM.equals("") || a == 0) {
                                    NearbyFriendsIntroUI.this.startActivity(new Intent(NearbyFriendsIntroUI.this, NearbyPersonalInfoUI.class));
                                } else {
                                    NearbyFriendsIntroUI.this.startActivity(new Intent(NearbyFriendsIntroUI.this, NearbyFriendsUI.class));
                                }
                            }
                            NearbyFriendsIntroUI.this.finish();
                        }
                    }, null);
                } else {
                    NearbyFriendsIntroUI.this.oTX.show();
                }
            }
        });
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                NearbyFriendsIntroUI.this.aWY();
                NearbyFriendsIntroUI.this.finish();
                return true;
            }
        });
    }
}
