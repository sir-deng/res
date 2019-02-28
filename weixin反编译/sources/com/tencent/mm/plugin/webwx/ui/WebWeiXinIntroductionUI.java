package com.tencent.mm.plugin.webwx.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mm.R;
import com.tencent.mm.bl.d;
import com.tencent.mm.ui.MMActivity;

public class WebWeiXinIntroductionUI extends MMActivity {
    private Button tVr;

    protected final int getLayoutId() {
        return R.i.duj;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    protected final void initView() {
        setMMTitle("");
        this.tVr = (Button) findViewById(R.h.cZc);
        this.tVr.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("BaseScanUI_select_scan_mode", 1);
                intent.putExtra("BaseScanUI_only_scan_qrcode_with_zbar", true);
                intent.putExtra("GetFriendQRCodeUI.INTENT_FROM_ACTIVITY", 2);
                intent.putExtra("from_album", false);
                intent.putExtra("show_intro", false);
                intent.setFlags(65536);
                d.b(WebWeiXinIntroductionUI.this, "scanner", ".ui.BaseScanUI", intent);
            }
        });
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                WebWeiXinIntroductionUI.this.finish();
                return true;
            }
        });
    }
}
