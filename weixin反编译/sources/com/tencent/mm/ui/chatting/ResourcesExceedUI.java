package com.tencent.mm.ui.chatting;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.MMActivity;

public class ResourcesExceedUI extends MMActivity {
    private int type = 0;
    private TextView yGa;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.type = getIntent().getIntExtra("clean_view_type", 0);
        setMMTitle("");
        initView();
    }

    protected final void initView() {
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                ResourcesExceedUI.this.finish();
                return true;
            }
        });
        this.yGa = (TextView) findViewById(R.h.ccE);
        switch (this.type) {
            case 0:
                this.yGa.setText(R.l.eTq);
                return;
            case 1:
                this.yGa.setText(R.l.epC);
                return;
            case 2:
                this.yGa.setText(R.l.ehy);
                return;
            default:
                return;
        }
    }

    protected final int getLayoutId() {
        return R.i.dqY;
    }

    public void onDestroy() {
        super.onDestroy();
    }
}
