package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bl.d;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;

public class FreeWifiIntroductionUI extends MMActivity {
    private int cPf;
    private Button mMd;
    private Button mNx;
    private Button mNy;
    private CheckBox mNz;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    protected final void initView() {
        this.mNx = (Button) findViewById(R.h.bYV);
        this.mNz = (CheckBox) findViewById(R.h.bJG);
        this.mMd = (Button) findViewById(R.h.coB);
        this.mNy = (Button) findViewById(R.h.cUk);
        this.cPf = getIntent().getIntExtra("free_wifi_source", 1);
        if (this.cPf == 3) {
            setMMTitle(R.l.evt);
            ((TextView) findViewById(R.h.cjA)).setText(R.l.evr);
            ((TextView) findViewById(R.h.cjv)).setText(R.l.evq);
            this.mMd.setVisibility(8);
        } else {
            setMMTitle(R.l.ekp);
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                FreeWifiIntroductionUI.this.finish();
                return false;
            }
        });
        this.mNx.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                as.Hm();
                c.Db().set(303104, Integer.valueOf(1));
                Intent intent = FreeWifiIntroductionUI.this.getIntent();
                intent.setClass(FreeWifiIntroductionUI.this, FreeWifiEntryUI.class);
                FreeWifiIntroductionUI.this.startActivity(intent);
                FreeWifiIntroductionUI.this.finish();
            }
        });
        this.mNz.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    FreeWifiIntroductionUI.this.mNx.setEnabled(true);
                } else {
                    FreeWifiIntroductionUI.this.mNx.setEnabled(false);
                }
            }
        });
        this.mNy.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                String string;
                if (FreeWifiIntroductionUI.this.cPf == 3) {
                    string = FreeWifiIntroductionUI.this.getString(R.l.evs);
                } else {
                    string = FreeWifiIntroductionUI.this.getString(R.l.ekm);
                }
                Intent intent = new Intent();
                intent.putExtra("rawUrl", string);
                intent.putExtra("showShare", false);
                intent.putExtra("show_bottom", false);
                d.b(FreeWifiIntroductionUI.this, "webview", ".ui.tools.WebViewUI", intent);
            }
        });
        this.mMd.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                String string = FreeWifiIntroductionUI.this.getString(R.l.ejZ);
                Intent intent = new Intent();
                intent.putExtra("rawUrl", string);
                intent.putExtra("showShare", false);
                intent.putExtra("show_bottom", false);
                d.b(FreeWifiIntroductionUI.this, "webview", ".ui.tools.WebViewUI", intent);
            }
        });
    }

    protected final int getForceOrientation() {
        return 1;
    }

    protected final int getLayoutId() {
        return R.i.diF;
    }
}
