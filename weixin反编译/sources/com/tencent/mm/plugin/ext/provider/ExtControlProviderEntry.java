package com.tencent.mm.plugin.ext.provider;

import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.bl.d;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.plugin.ext.b;
import com.tencent.mm.pluginsdk.e.a.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bj;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.wcdb.database.SQLiteDatabase;

@JgClassChecked(author = 32, fComment = "checked", lastDate = "20141016", reviewer = 20, vComment = {EType.PROVIDERCHECK})
public class ExtControlProviderEntry extends ExtContentProviderBase {
    private static final UriMatcher mfY;
    private String[] mfJ;
    private int mfK;
    private boolean mfZ;
    private Context mga;

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        mfY = uriMatcher;
        uriMatcher.addURI("com.tencent.mm.plugin.ext.entry", "view_profile", 2);
        mfY.addURI("com.tencent.mm.plugin.ext.entry", "to_chatting", 3);
        mfY.addURI("com.tencent.mm.plugin.ext.entry", "to_nearby", 4);
        mfY.addURI("com.tencent.mm.plugin.ext.entry", "sns_comment_detail", 5);
        mfY.addURI("com.tencent.mm.plugin.ext.entry", "share_time_line", 6);
    }

    public String getType(Uri uri) {
        return null;
    }

    public boolean onCreate() {
        return true;
    }

    public ExtControlProviderEntry() {
        this.mfZ = false;
        this.mfJ = null;
        this.mfK = -1;
    }

    public ExtControlProviderEntry(String[] strArr, int i, Context context) {
        this.mfZ = false;
        this.mfJ = null;
        this.mfK = -1;
        this.mfZ = true;
        this.mfJ = strArr;
        this.mfK = i;
        this.mga = context;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        x.i("MicroMsg.ExtControlEntryProvider", "ExtControlProviderEntry query() mIsLocalUsed :" + this.mfZ);
        if (this.mfZ) {
            a(uri, this.mga, this.mfK, this.mfJ);
            if (bi.oN(this.mfS)) {
                x.e("MicroMsg.ExtControlEntryProvider", "AppID == null");
                cw(3, 7);
                return a.BQ(7);
            } else if (bi.oN(aGt())) {
                x.e("MicroMsg.ExtControlEntryProvider", "PkgName == null");
                cw(3, 6);
                return a.BQ(6);
            } else {
                int aGu = aGu();
                if (aGu != 1) {
                    x.e("MicroMsg.ExtControlEntryProvider", "invalid appid ! return code = " + aGu);
                    cw(2, aGu);
                    return a.BQ(aGu);
                }
            }
        }
        this.mga = getContext();
        a(uri, this.mga, mfY);
        if (uri == null) {
            pI(3);
            return null;
        } else if (bi.oN(this.mfS) || bi.oN(aGt())) {
            pI(3);
            return a.BQ(3);
        } else if (!arF()) {
            pI(1);
            return this.kAL;
        } else if (!cA(this.mga)) {
            x.w("MicroMsg.ExtControlEntryProvider", "invalid appid ! return null");
            pI(2);
            return null;
        }
        String oM = bi.oM(uri.getQueryParameter("source"));
        if (!this.mfZ) {
            this.mfK = mfY.match(uri);
        }
        switch (this.mfK) {
            case 2:
                return m(strArr2);
            case 3:
                return b(strArr2, oM);
            case 4:
                if (this.mga == null) {
                    pI(4);
                    return null;
                }
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.tencent.mm", "com.tencent.mm.plugin.nearby.ui.NearbyFriendsUI"));
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                this.mga.startActivity(intent);
                pI(0);
                return a.BQ(1);
            case 5:
                return n(strArr2);
            case 6:
                if (strArr2 == null || strArr2.length <= 0) {
                    x.w("MicroMsg.ExtControlEntryProvider", "wrong args");
                    pI(3);
                    return null;
                } else if (this.mga == null) {
                    pI(4);
                    return null;
                } else {
                    Intent intent2 = new Intent();
                    intent2.setComponent(new ComponentName("com.tencent.mm", "com.tencent.mm.ui.tools.ShareToTimeLineUI"));
                    intent2.setAction("android.intent.action.SEND");
                    intent2.addCategory("android.intent.category.DEFAULT");
                    intent2.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                    intent2.putExtra("android.intent.extra.TEXT", strArr2[1] == null ? "" : strArr2[1]);
                    if (strArr2[0] != null && strArr2[0].trim().length() > 0) {
                        intent2.putExtra("android.intent.extra.STREAM", Uri.parse(strArr2[0]));
                    }
                    intent2.putExtra("Ksnsupload_empty_img", true);
                    intent2.setType("image/*");
                    this.mga.startActivity(intent2);
                    pI(0);
                    return a.BQ(1);
                }
            default:
                cw(3, 15);
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

    private Cursor m(String[] strArr) {
        if (strArr == null || strArr.length <= 0) {
            x.w("MicroMsg.ExtControlEntryProvider", "wrong args");
            pI(3);
            return null;
        }
        String str = strArr[0];
        if (str == null || str.length() <= 0) {
            x.w("MicroMsg.ExtControlEntryProvider", "contactId == null");
            pI(3);
            return null;
        }
        try {
            as.Hm();
            ag fP = c.Ff().fP(com.tencent.mm.plugin.ext.a.a.Ad(str));
            if (fP == null || ((int) fP.gKO) <= 0 || this.mga == null) {
                pI(3);
                return null;
            }
            Intent intent = new Intent();
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            intent.putExtra("Contact_User", fP.field_username);
            d.b(this.mga, "profile", ".ui.ContactInfoUI", intent);
            pI(0);
            return a.BQ(1);
        } catch (Throwable e) {
            x.w("MicroMsg.ExtControlEntryProvider", e.getMessage());
            x.printErrStackTrace("MicroMsg.ExtControlEntryProvider", e, "", new Object[0]);
            pI(3);
            return null;
        }
    }

    private Cursor b(String[] strArr, String str) {
        x.i("MicroMsg.ExtControlEntryProvider", "toChattingUI");
        if (strArr == null || strArr.length <= 0) {
            x.w("MicroMsg.ExtControlEntryProvider", "wrong args");
            cw(3, 3601);
            return a.BQ(3601);
        } else if (bi.oN(str)) {
            x.w("MicroMsg.ExtControlEntryProvider", "callSource == null");
            cw(3, 3602);
            return a.BQ(3602);
        } else {
            String str2 = strArr[0];
            if (str2 == null || str2.length() <= 0) {
                x.w("MicroMsg.ExtControlEntryProvider", "contactId == null");
                cw(3, 3603);
                return a.BQ(3603);
            }
            ag Xv;
            boolean z = str != null && str.equalsIgnoreCase("openapi");
            if (z) {
                try {
                    bj Yt = b.aGj().Yt(str2);
                    if (Yt == null || bi.oN(Yt.field_openId) || bi.oN(Yt.field_username)) {
                        x.e("MicroMsg.ExtControlEntryProvider", "openidInApp is null");
                        cw(3, 3604);
                        return a.BQ(3604);
                    }
                    as.Hm();
                    Xv = c.Ff().Xv(Yt.field_username);
                } catch (Throwable e) {
                    x.w("MicroMsg.ExtControlEntryProvider", e.getMessage());
                    x.printErrStackTrace("MicroMsg.ExtControlEntryProvider", e, "", new Object[0]);
                    J(5, 4, 12);
                    return a.BQ(12);
                }
            }
            as.Hm();
            Xv = c.Ff().fP(com.tencent.mm.plugin.ext.a.a.Ad(str2));
            if (Xv == null || ((int) Xv.gKO) <= 0 || this.mga == null) {
                x.e("MicroMsg.ExtControlEntryProvider", "wrong args ct");
                cw(3, 3605);
                return a.BQ(3605);
            }
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.tencent.mm", "com.tencent.mm.ui.chatting.ChattingUI"));
            intent.putExtra("Chat_User", Xv.field_username);
            intent.putExtra("finish_direct", true);
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            intent.addFlags(67108864);
            this.mga.startActivity(intent);
            J(4, 0, 1);
            return a.BQ(1);
        }
    }

    private Cursor n(String[] strArr) {
        if (strArr == null || strArr.length <= 0) {
            x.w("MicroMsg.ExtControlEntryProvider", "wrong args");
            pI(3);
            return null;
        }
        String str = strArr[0];
        if (str == null || str.length() <= 0) {
            x.w("MicroMsg.ExtControlEntryProvider", "wrong args");
            pI(3);
            return null;
        }
        try {
            long Ad = com.tencent.mm.plugin.ext.a.a.Ad(str);
            if (Ad <= 0) {
                pI(3);
                return null;
            } else if (this.mga == null) {
                pI(4);
                return null;
            } else {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.tencent.mm", "com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI"));
                intent.putExtra("INTENT_SNS_LOCAL_ID", (int) Ad);
                intent.addCategory("android.intent.category.DEFAULT");
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                this.mga.startActivity(intent);
                pI(0);
                return a.BQ(1);
            }
        } catch (Throwable e) {
            x.w("MicroMsg.ExtControlEntryProvider", e.getMessage());
            x.printErrStackTrace("MicroMsg.ExtControlEntryProvider", e, "", new Object[0]);
            pI(3);
            return null;
        }
    }
}
