package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.smtt.sdk.WebView;

public abstract class WebSearchBaseActivity extends CustomStatusBarMMActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        cnJ();
        oj(WebView.NIGHT_MODE_COLOR);
        if (getSupportActionBar() != null) {
            getSupportActionBar().getCustomView().setBackgroundColor(getResources().getColor(R.e.buh));
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.e.buh)));
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                WebSearchBaseActivity.this.finish();
                return true;
            }
        });
    }

    protected final int getStatusBarColor() {
        return getResources().getColor(R.e.buh);
    }
}
