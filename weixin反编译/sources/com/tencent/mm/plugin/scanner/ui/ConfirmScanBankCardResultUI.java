package com.tencent.mm.plugin.scanner.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.f.a.ok;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.HashMap;
import java.util.Map;

@a(3)
public class ConfirmScanBankCardResultUI extends MMActivity {
    protected static final Map<String, Bitmap> qaY = new HashMap();
    protected Bitmap mBmp = null;
    private String qaX = null;
    private ImageView qaZ;
    private EditText qba;

    public static void c(Bitmap bitmap, String str) {
        if (bitmap != null && !bitmap.isRecycled() && !bi.oN(str)) {
            Intent intent = new Intent();
            intent.setClass(ad.getContext(), ConfirmScanBankCardResultUI.class);
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            intent.putExtra("_card_num_", str);
            String str2 = "_image_cache_key_" + str;
            qaY.put(str2, bitmap);
            intent.putExtra("_image_cache_key_", str2);
            ad.getContext().startActivity(intent);
        }
    }

    public void onCreate(Bundle bundle) {
        Object obj;
        super.onCreate(bundle);
        setMMTitle(R.l.eIC);
        if (getIntent() == null) {
            x.e("MicroMsg.ConfirmScanBankCardResultUI", "intent is null, return");
            obj = null;
        } else {
            this.qaX = getIntent().getStringExtra("_image_cache_key_");
            if (bi.oN(this.qaX)) {
                x.e("MicroMsg.ConfirmScanBankCardResultUI", "bmp cache key is null or nil");
                obj = null;
            } else {
                this.mBmp = (Bitmap) qaY.get(this.qaX);
                if (this.mBmp == null || this.mBmp.isRecycled()) {
                    x.e("MicroMsg.ConfirmScanBankCardResultUI", "bmp invalid, return");
                    obj = null;
                } else {
                    obj = 1;
                }
            }
        }
        if (obj == null) {
            finish();
            return;
        }
        CharSequence stringExtra = getIntent().getStringExtra("_card_num_");
        if (bi.oN(stringExtra)) {
            x.e("MicroMsg.ConfirmScanBankCardResultUI", "cardNum is null or nil");
            finish();
            return;
        }
        this.qaZ = (ImageView) findViewById(R.h.coT);
        this.qba = (EditText) findViewById(R.h.cde);
        this.qaZ.setImageBitmap(this.mBmp);
        this.qba.setText(stringExtra);
        findViewById(R.h.bPi).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (ConfirmScanBankCardResultUI.this.qba != null) {
                    String obj = ConfirmScanBankCardResultUI.this.qba.getEditableText().toString();
                    if (!bi.oN(obj)) {
                        b okVar = new ok();
                        okVar.fHe.action = 1;
                        okVar.fHe.cardNum = obj;
                        com.tencent.mm.sdk.b.a.xmy.m(okVar);
                        super.finish();
                    }
                }
            }
        });
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                ConfirmScanBankCardResultUI.this.finish();
                return true;
            }
        });
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.qaZ != null) {
            this.qaZ.setImageBitmap(null);
        }
        if (!bi.oN(this.qaX)) {
            qaY.remove(this.qaX);
        }
        if (this.mBmp != null) {
            this.mBmp.recycle();
        }
    }

    public void finish() {
        Intent intent = new Intent();
        intent.putExtra("BaseScanUI_select_scan_mode", 7);
        intent.putExtra("scan_bankcard_with_confirm_ui", true);
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        intent.setClass(this, BaseScanUI.class);
        startActivity(intent);
        super.finish();
    }

    protected final int getLayoutId() {
        return R.i.deN;
    }

    protected final int getForceOrientation() {
        return 1;
    }
}
