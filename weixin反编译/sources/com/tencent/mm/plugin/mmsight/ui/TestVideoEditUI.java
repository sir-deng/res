package com.tencent.mm.plugin.mmsight.ui;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mm.api.e;
import com.tencent.mm.api.j;
import com.tencent.mm.api.l;
import com.tencent.mm.api.m;
import com.tencent.mm.api.m.a.a;
import com.tencent.mm.api.m.c;
import com.tencent.mm.plugin.u.a.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import java.io.IOException;

public class TestVideoEditUI extends MMActivity implements e {
    private m oIZ;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        fullScreenNoTitleBar(true);
        FrameLayout frameLayout = (FrameLayout) findViewById(d.content);
        this.oIZ = m.fdT.sV();
        m mVar = this.oIZ;
        a aVar = new a();
        aVar.fdV = false;
        aVar.fdX = true;
        aVar.fdY = new Rect(0, 0, 1080, 1080);
        aVar.fdU = c.fdZ;
        mVar.a(aVar.th());
        View ai = this.oIZ.ai(this.mController.xRr);
        ai.a(this);
        frameLayout.addView(ai, new LayoutParams(-1, -1));
        ai.fdI = new l() {
            public final void a(com.tencent.mm.api.d dVar) {
                x.i("MicroMsg.TestVideoEditUI", "[onSelectedFeature] features:%s", dVar.name());
            }

            public final void a(com.tencent.mm.api.d dVar, int i) {
                x.i("MicroMsg.TestVideoEditUI", "[onSelectedDetailFeature] features:%s index:%s", dVar.name(), Integer.valueOf(i));
            }

            public final void aF(boolean z) {
                if (z) {
                    TestVideoEditUI.this.showVKB();
                } else {
                    TestVideoEditUI.this.df(TestVideoEditUI.this.mController.contentView);
                }
            }
        };
    }

    protected void onDestroy() {
        super.onDestroy();
        this.oIZ.onDestroy();
    }

    public void onBackPressed() {
        if (!this.oIZ.sT()) {
            finish();
        }
    }

    public void onSwipeBack() {
        super.onSwipeBack();
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.u.a.e.oKG;
    }

    public final void onFinish() {
        this.oIZ.a(new j() {
            public final void b(Exception exception) {
            }

            public final void a(Bitmap bitmap, boolean z) {
                x.i("MicroMsg.TestVideoEditUI", "[onSuccess] w:%s h:%s", Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()));
                try {
                    com.tencent.mm.sdk.platformtools.d.a(bitmap, 100, CompressFormat.PNG, com.tencent.mm.compatible.util.e.gJe + String.format("%s%d.%s", new Object[]{"wx_photo_edit_", Long.valueOf(System.currentTimeMillis()), "png"}), true);
                } catch (IOException e) {
                }
            }
        });
    }

    public final void sX() {
        finish();
    }
}
