package com.tencent.mm.plugin.wear.model.e;

import android.content.Intent;
import android.os.Build.VERSION;
import com.tencent.liteav.network.TXCStreamUploader;
import com.tencent.mm.bl.d;
import com.tencent.mm.f.a.kt;
import com.tencent.mm.f.a.nq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

public final class e extends a {
    public final List<Integer> bPu() {
        List<Integer> arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(TXCStreamUploader.TXE_UPLOAD_ERROR_NO_DATA));
        arrayList.add(Integer.valueOf(11014));
        arrayList.add(Integer.valueOf(TXCStreamUploader.TXE_UPLOAD_ERROR_NO_NETWORK));
        return arrayList;
    }

    protected final byte[] n(int i, byte[] bArr) {
        switch (i) {
            case TXCStreamUploader.TXE_UPLOAD_ERROR_NO_DATA /*11013*/:
                a.xmy.m(new kt());
                break;
            case 11014:
                List aZV = ((h) g.h(h.class)).aZO().aZV();
                if (aZV.size() != 1) {
                    Intent intent = new Intent();
                    intent.addFlags(67108864);
                    intent.addFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
                    if (VERSION.SDK_INT < 16) {
                        intent.putExtra("resend_fail_messages", true);
                    }
                    intent.putExtra("From_fail_notify", true);
                    x.d("MicroMsg.Wear.HttpFailMsgServer", "startMainUI");
                    d.a(ad.getContext(), "com.tencent.mm.ui.LauncherUI", intent);
                    break;
                }
                String str = ((au) aZV.get(0)).field_talker;
                Intent intent2 = new Intent();
                intent2.putExtra("Main_User", str);
                intent2.putExtra("From_fail_notify", true);
                intent2.addFlags(67108864);
                intent2.addFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
                if (VERSION.SDK_INT < 16) {
                    intent2.putExtra("resend_fail_messages", true);
                }
                x.d("MicroMsg.Wear.HttpFailMsgServer", "startChattingUI talker=%s", str);
                d.a(ad.getContext(), "com.tencent.mm.ui.LauncherUI", intent2);
                break;
            case TXCStreamUploader.TXE_UPLOAD_ERROR_NO_NETWORK /*11015*/:
                a.xmy.m(new nq());
                break;
        }
        return null;
    }
}
