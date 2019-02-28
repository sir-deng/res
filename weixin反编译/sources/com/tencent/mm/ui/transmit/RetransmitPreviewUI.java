package com.tencent.mm.ui.transmit;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bw.g;
import com.tencent.mm.ui.MMActivity;

public class RetransmitPreviewUI extends MMActivity {
    private TextView kO = null;
    private String text = null;

    protected final int getLayoutId() {
        return R.i.ddK;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle("");
        this.text = getIntent().getStringExtra("Retr_Msg_content");
        this.kO = (TextView) findViewById(R.h.ckq);
        this.kO.setText(g.chT().a(this.mController.xRr, this.text, this.kO.getTextSize()));
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                RetransmitPreviewUI.this.finish();
                return true;
            }
        });
    }

    public void onBackPressed() {
        finish();
    }

    protected void onDestroy() {
        super.onDestroy();
    }
}
