package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.modelsimple.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.MMEditText.c;
import com.tencent.mm.y.as;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;

public class ShareToQQWeiboUI extends MMActivity implements e {
    private ProgressDialog inI = null;
    private EditText pwv;
    private TextView qmF;

    protected final int getLayoutId() {
        return R.i.dfE;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        as.CN().a(26, (e) this);
        initView();
    }

    public void onDestroy() {
        as.CN().b(26, (e) this);
        super.onDestroy();
    }

    protected final void initView() {
        setMMTitle(R.l.ePA);
        this.pwv = (EditText) findViewById(R.h.content);
        this.qmF = (TextView) findViewById(R.h.cZN);
        String stringExtra = getIntent().getStringExtra("content");
        Object stringExtra2 = getIntent().getStringExtra("shortUrl");
        this.pwv.addTextChangedListener(new c(this.pwv, this.qmF, 280));
        if (stringExtra.contains(stringExtra2)) {
            this.pwv.setText(stringExtra.trim());
        } else {
            this.pwv.setText(stringExtra + " " + stringExtra2);
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                ShareToQQWeiboUI.this.aWY();
                ShareToQQWeiboUI.this.finish();
                return true;
            }
        });
        addTextOptionMenu(0, getString(R.l.dGP), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                final k adVar = new ad(ShareToQQWeiboUI.this.getIntent().getIntExtra(Columns.TYPE, 0), ShareToQQWeiboUI.this.getIntent().getStringExtra("shortUrl"), ShareToQQWeiboUI.this.pwv.getText().toString());
                as.CN().a(adVar, 0);
                ShareToQQWeiboUI shareToQQWeiboUI = ShareToQQWeiboUI.this;
                Context context = ShareToQQWeiboUI.this.mController.xRr;
                ShareToQQWeiboUI.this.getString(R.l.dGZ);
                shareToQQWeiboUI.inI = h.a(context, ShareToQQWeiboUI.this.getString(R.l.euN), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        as.CN().c(adVar);
                    }
                });
                return true;
            }
        });
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.ShareToQQWeiboUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (kVar.getType() == 26) {
            if (this.inI != null) {
                this.inI.dismiss();
                this.inI = null;
            }
            if (i == 0 && i2 == 0) {
                aWY();
                setResult(-1);
                finish();
                return;
            }
            setResult(1, new Intent().putExtra("err_code", i2));
            Toast.makeText(this, getString(R.l.ePv, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
        }
    }
}
