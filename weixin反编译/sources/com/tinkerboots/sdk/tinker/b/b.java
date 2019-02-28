package com.tinkerboots.sdk.tinker.b;

import android.content.Context;
import com.tencent.tinker.lib.b.a;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tinkerboots.sdk.b.c;
import java.io.File;

public final class b extends a {
    public b(Context context) {
        super(context);
    }

    public final int db(String str, String str2) {
        File file = new File(str);
        com.tencent.tinker.lib.f.a.i("Tinker.TinkerServerPatchListener", "receive a patch file: %s, file size:%d", str, Long.valueOf(SharePatchFileUtil.af(file)));
        int db = super.db(str, str2);
        if (db != 0) {
            return db;
        }
        if (c.cKj()) {
            return -20;
        }
        return 0;
    }
}
