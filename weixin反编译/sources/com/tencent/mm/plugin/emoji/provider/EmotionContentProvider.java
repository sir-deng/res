package com.tencent.mm.plugin.emoji.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.o;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.ArrayList;

public class EmotionContentProvider extends ContentProvider {
    private static final UriMatcher lFa;

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        lFa = uriMatcher;
        uriMatcher.addURI("com.tencent.mm.storage.provider.emotion", "EmojiGroupInfo", 1);
        lFa.addURI("com.tencent.mm.storage.provider.emotion", "userinfo", 2);
        lFa.addURI("com.tencent.mm.storage.provider.emotion", "GetEmotionListCache", 3);
        lFa.addURI("com.tencent.mm.storage.provider.emotion", "EmojiInfo", 4);
        lFa.addURI("com.tencent.mm.storage.provider.emotion", "EmojiInfoDesc", 5);
    }

    public boolean onCreate() {
        x.i("MicroMsg.EmotionContentProvider", "[onCreate]");
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        x.i("MicroMsg.EmotionContentProvider", "[query] path:%s selection:%s", uri.getPath(), str);
        switch (lFa.match(uri)) {
            case 1:
                as.Hm();
                return c.Fc().a(str, strArr2, 2);
            case 3:
                as.Hm();
                return c.Fc().a(str, strArr2, 2);
            case 4:
                as.Hm();
                return c.Fc().a(str, strArr2, 2);
            case 5:
                as.Hm();
                return c.Fc().a(str, strArr2, 2);
            default:
                return null;
        }
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        switch (lFa.match(uri)) {
            case 3:
                as.Hm();
                return Uri.withAppendedPath(uri, String.valueOf(c.Fc().insert("GetEmotionListCache", o.gKN.xrS, contentValues)));
            default:
                return uri;
        }
    }

    public int delete(Uri uri, String str, String[] strArr) {
        switch (lFa.match(uri)) {
            case 3:
                as.Hm();
                return c.Fc().delete("GetEmotionListCache", str, strArr);
            default:
                return 0;
        }
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        if (!g.Do().CF()) {
            return -1;
        }
        switch (lFa.match(uri)) {
            case 1:
                as.Hm();
                return c.Fc().update("EmojiGroupInfo", contentValues, str, strArr);
            case 2:
                as.Hm();
                c.Db().set(((Integer) contentValues.get(Columns.TYPE)).intValue(), contentValues.get(Columns.VALUE));
                return 0;
            default:
                return -1;
        }
    }

    public Bundle call(String str, String str2, Bundle bundle) {
        boolean z = true;
        x.d("MicroMsg.EmotionContentProvider", "[call] method:%s", str);
        Bundle bundle2;
        Bundle bundle3;
        Bundle bundle4;
        if (str.equals("getAccPath")) {
            bundle2 = new Bundle();
            bundle2.putString("path", g.Dq().gRT);
            return bundle2;
        } else if (str.equals("getEmojiKey")) {
            bundle2 = new Bundle();
            bundle2.putString("key", i.aCl().lCw.getKey());
            return bundle2;
        } else if (str.equals("ConfigStorage.getBoolean")) {
            bundle3 = new Bundle();
            as.Hm();
            bundle3.putBoolean("key", ((Boolean) c.Db().get(bundle.getInt("key"), Boolean.valueOf(false))).booleanValue());
            return bundle3;
        } else if (str.equals("ConfigStorage.getString")) {
            bundle4 = new Bundle();
            as.Hm();
            bundle4.putString("key", (String) c.Db().get(bundle.getInt("key"), (Object) ""));
            return bundle4;
        } else if (str.equals("getAllCustomEmoji")) {
            bundle2 = new Bundle(EmojiInfo.class.getClassLoader());
            bundle2.putParcelableArrayList(SlookAirButtonFrequentContactAdapter.DATA, i.aCl().aBK());
            return bundle2;
        } else {
            if (str.equals("getRamdomEmoji")) {
                if (bundle != null) {
                    bundle.setClassLoader(EmojiInfo.class.getClassLoader());
                    EmojiInfo emojiInfo = (EmojiInfo) bundle.getParcelable("emoji");
                    bundle3 = new Bundle(EmojiInfo.class.getClassLoader());
                    bundle3.putParcelable(SlookAirButtonFrequentContactAdapter.DATA, ((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().c(emojiInfo));
                    return bundle3;
                }
                String str3 = "MicroMsg.EmotionContentProvider";
                String str4 = "[getRamdomEmoji] extras:%s";
                Object[] objArr = new Object[1];
                if (bundle != null) {
                    z = false;
                }
                objArr[0] = Boolean.valueOf(z);
                x.e(str3, str4, objArr);
            } else if (str.equals("getCurLangDesc")) {
                bundle2 = new Bundle();
                bundle2.putString(SlookAirButtonFrequentContactAdapter.DATA, i.aCg().yF(str2));
                return bundle2;
            } else if (str.equals("countCustomEmoji")) {
                bundle4 = new Bundle();
                bundle4.putInt(SlookAirButtonFrequentContactAdapter.DATA, i.aCl().lCw.lP(true));
                return bundle4;
            } else if (str.equals("countProductId")) {
                bundle2 = new Bundle();
                bundle2.putInt(SlookAirButtonFrequentContactAdapter.DATA, i.aCl().lCw.yS(str2));
                return bundle2;
            } else if (str.equals("getDownloadedCount")) {
                bundle2 = new Bundle();
                bundle2.putInt(SlookAirButtonFrequentContactAdapter.DATA, i.aCl().aBJ());
                return bundle2;
            } else if (str.equals("getEmojiListByGroupId")) {
                bundle4 = new Bundle(EmojiInfo.class.getClassLoader());
                bundle4.putParcelableArrayList(SlookAirButtonFrequentContactAdapter.DATA, (ArrayList) ((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().yK(str2));
                return bundle4;
            } else if (str.equals("getEmojiGroupInfoList")) {
                bundle2 = new Bundle(EmojiGroupInfo.class.getClassLoader());
                bundle2.putParcelableArrayList(SlookAirButtonFrequentContactAdapter.DATA, i.aCl().aBI());
                return bundle2;
            }
            return null;
        }
    }
}
