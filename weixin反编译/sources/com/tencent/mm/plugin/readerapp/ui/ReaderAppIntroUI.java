package com.tencent.mm.plugin.readerapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.readerapp.a.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.y.bg;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;

public class ReaderAppIntroUI extends MMActivity {
    private int fFe = 0;

    protected final int getLayoutId() {
        return R.i.dqw;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    protected final void initView() {
        ImageView imageView = (ImageView) findViewById(R.h.cFT);
        TextView textView = (TextView) findViewById(R.h.cFU);
        this.fFe = getIntent().getIntExtra(Columns.TYPE, 0);
        if (this.fFe == 20) {
            setMMTitle(R.l.eoV);
            imageView.setImageResource(R.g.bFf);
            textView.setText(R.l.dWn);
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                ReaderAppIntroUI.this.finish();
                return true;
            }
        });
        addIconOptionMenu(0, R.k.dvn, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                a.ihN.d(new Intent().putExtra("Contact_User", bg.gW(ReaderAppIntroUI.this.fFe)), ReaderAppIntroUI.this);
                ReaderAppIntroUI.this.finish();
                return true;
            }
        });
    }
}
