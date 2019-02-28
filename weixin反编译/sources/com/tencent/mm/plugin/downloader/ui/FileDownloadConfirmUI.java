package com.tencent.mm.plugin.downloader.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.plugin.downloader.b.b;
import com.tencent.mm.plugin.downloader.b.c;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.base.i.a;

public class FileDownloadConfirmUI extends MMBaseActivity {
    private i ien = null;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(b.empty);
        final long longExtra = getIntent().getLongExtra("extra_download_id", -1);
        OnClickListener anonymousClass1 = new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                f.aAK().bY(longExtra);
                x.i("MicroMsg.FileDownloadConfirmUI", "Remove task: %d", Long.valueOf(longExtra));
            }
        };
        OnClickListener anonymousClass2 = new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        };
        OnDismissListener anonymousClass3 = new OnDismissListener() {
            public final void onDismiss(DialogInterface dialogInterface) {
                FileDownloadConfirmUI.this.finish();
            }
        };
        a aVar = new a(this);
        aVar.Zm("");
        aVar.ET(c.lwM);
        aVar.EV(c.dHo).a(anonymousClass1);
        aVar.EW(c.dGc).b(anonymousClass2);
        aVar.a(anonymousClass3);
        this.ien = aVar.ale();
        this.ien.show();
        x.i("MicroMsg.FileDownloadConfirmUI", "Confirm Dialog");
    }

    public void onNewIntent(Intent intent) {
        x.i("MicroMsg.FileDownloadConfirmUI", "onNewIntent");
    }

    protected void onStop() {
        super.onStop();
        this.ien.dismiss();
    }
}
