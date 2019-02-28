package com.tencent.mm.plugin.ext.provider;

import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.f.a.fc;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

@JgClassChecked(author = 32, fComment = "checked", lastDate = "20141016", reviewer = 20, vComment = {EType.PROVIDERCHECK})
public class ExtControlProviderAccountSync extends ExtContentProviderBase {
    private static final UriMatcher mfY;

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        mfY = uriMatcher;
        uriMatcher.addURI("com.tencent.mm.plugin.ext.AccountSync", "accountSync", 1);
    }

    public String getType(Uri uri) {
        return null;
    }

    public boolean onCreate() {
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        x.d("MicroMsg.ExtControlAccountSyncProvider", "query()");
        a(uri, getContext(), mfY);
        if (uri == null) {
            pI(3);
            return null;
        } else if (bi.oN(this.mfS) || bi.oN(aGt())) {
            pI(3);
            return null;
        } else if (!arF()) {
            pI(1);
            return this.kAL;
        } else if (cA(getContext())) {
            switch (mfY.match(uri)) {
                case 1:
                    x.i("MicroMsg.ExtControlAccountSyncProvider", "startContactSync()");
                    if (a.xmy.m(new fc())) {
                        pI(0);
                        return null;
                    }
                    x.e("MicroMsg.ExtControlAccountSyncProvider", "AccountHelper == null");
                    pI(4);
                    return null;
                default:
                    pI(3);
                    return null;
            }
        } else {
            x.w("MicroMsg.ExtControlAccountSyncProvider", "invalid appid ! return null");
            pI(2);
            return null;
        }
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
