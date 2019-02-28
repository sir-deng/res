package com.tencent.mm.plugin.music.model.g;

import android.text.TextUtils;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.c;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.y.as;
import com.tencent.wcdb.FileUtils;
import java.util.HashMap;
import java.util.Map;

public final class g {
    private static HashMap<Integer, Boolean> oSp = new HashMap();
    private static HashMap<Integer, Long> oSq = new HashMap();

    static {
        oSp.put(Integer.valueOf(0), Boolean.valueOf(false));
        oSp.put(Integer.valueOf(1), Boolean.valueOf(false));
        oSp.put(Integer.valueOf(4), Boolean.valueOf(false));
        oSp.put(Integer.valueOf(5), Boolean.valueOf(false));
        oSp.put(Integer.valueOf(6), Boolean.valueOf(false));
        oSp.put(Integer.valueOf(7), Boolean.valueOf(false));
        oSp.put(Integer.valueOf(8), Boolean.valueOf(false));
        oSp.put(Integer.valueOf(9), Boolean.valueOf(false));
        oSq.put(Integer.valueOf(0), Long.valueOf(0));
        oSq.put(Integer.valueOf(1), Long.valueOf(0));
        oSq.put(Integer.valueOf(4), Long.valueOf(0));
        oSq.put(Integer.valueOf(5), Long.valueOf(0));
        oSq.put(Integer.valueOf(6), Long.valueOf(0));
        oSq.put(Integer.valueOf(7), Long.valueOf(0));
        oSq.put(Integer.valueOf(8), Long.valueOf(0));
        oSq.put(Integer.valueOf(9), Long.valueOf(0));
    }

    public static boolean tY(int i) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - ((Long) oSq.get(Integer.valueOf(i))).longValue() < 10000) {
            return ((Boolean) oSp.get(Integer.valueOf(i))).booleanValue();
        }
        oSq.put(Integer.valueOf(i), Long.valueOf(currentTimeMillis));
        c fp = com.tencent.mm.y.c.c.IL().fp("100283");
        if (fp.isValid()) {
            Map civ = fp.civ();
            if (civ == null) {
                x.e("MicroMsg.Music.MusicPlayerSwitcher", "supportQQMusicPlayer args == null");
                return tZ(i);
            } else if (!civ.containsKey("support_player_flag")) {
                x.e("MicroMsg.Music.MusicPlayerSwitcher", "supportQQMusicPlayer not contain the support_player_flag key");
                return tZ(i);
            } else if (TextUtils.isEmpty((CharSequence) civ.get("support_player_flag"))) {
                x.e("MicroMsg.Music.MusicPlayerSwitcher", "supportQQMusicPlayer not contain the the value is empty");
                return tZ(i);
            } else {
                int intValue;
                boolean db;
                try {
                    intValue = Integer.valueOf((String) civ.get("support_player_flag"), 16).intValue();
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.Music.MusicPlayerSwitcher", e, "supportQQMusicPlayer", new Object[0]);
                    intValue = 0;
                }
                x.i("MicroMsg.Music.MusicPlayerSwitcher", "supportQQMusicPlayer contain support_player_flag:%s", r0);
                as.Hm();
                currentTimeMillis = ((Long) com.tencent.mm.y.c.Db().get(a.USERINFO_MUSIC_SUPPORT_PLAYER_FLAG_SEQUENCE_LONG_SYNC, Long.valueOf(0))).longValue();
                if (currentTimeMillis == 0) {
                    x.i("MicroMsg.Music.MusicPlayerSwitcher", "sequence is 0");
                    as.Hm();
                    com.tencent.mm.y.c.Db().a(a.USERINFO_MUSIC_SUPPORT_PLAYER_FLAG_SEQUENCE_LONG_SYNC, Long.valueOf(fp.field_sequence));
                    as.Hm();
                    com.tencent.mm.y.c.Db().a(a.USERINFO_MUSIC_PLAYER_SWITCH_FLAG_INT_SYNC, Integer.valueOf(intValue));
                    db = db(i, intValue);
                } else if (currentTimeMillis == fp.field_sequence) {
                    x.i("MicroMsg.Music.MusicPlayerSwitcher", "sequence is equal, check flag from local switch flag");
                    as.Hm();
                    db = db(i, ((Integer) com.tencent.mm.y.c.Db().get(a.USERINFO_MUSIC_PLAYER_SWITCH_FLAG_INT_SYNC, Integer.valueOf(intValue))).intValue());
                } else {
                    x.i("MicroMsg.Music.MusicPlayerSwitcher", "sequence is diff, update local data");
                    as.Hm();
                    com.tencent.mm.y.c.Db().a(a.USERINFO_MUSIC_SUPPORT_PLAYER_FLAG_SEQUENCE_LONG_SYNC, Long.valueOf(fp.field_sequence));
                    as.Hm();
                    com.tencent.mm.y.c.Db().a(a.USERINFO_MUSIC_PLAYER_SWITCH_FLAG_INT_SYNC, Integer.valueOf(intValue));
                    db = db(i, intValue);
                }
                oSp.put(Integer.valueOf(i), Boolean.valueOf(db));
                return db;
            }
        }
        x.e("MicroMsg.Music.MusicPlayerSwitcher", "supportQQMusicPlayer item.isValid is false");
        return tZ(i);
    }

    private static boolean tZ(int i) {
        as.Hm();
        boolean db = db(i, ((Integer) com.tencent.mm.y.c.Db().get(a.USERINFO_MUSIC_PLAYER_SWITCH_FLAG_INT_SYNC, Integer.valueOf(0))).intValue());
        x.i("MicroMsg.Music.MusicPlayerSwitcher", "checkLocalSupportPlayerFlag support_player_flag:%s", Integer.toHexString(r0));
        oSp.put(Integer.valueOf(i), Boolean.valueOf(db));
        return db;
    }

    private static boolean db(int i, int i2) {
        if (i == 0 && (i2 & 1) > 0) {
            x.i("MicroMsg.Music.MusicPlayerSwitcher", "support CHATTING_UI");
            return true;
        } else if (i == 1 && (i2 & 2) > 0) {
            x.i("MicroMsg.Music.MusicPlayerSwitcher", "support SNS_TIMELINE_UI");
            return true;
        } else if (i == 4 && (i2 & 4) > 0) {
            x.i("MicroMsg.Music.MusicPlayerSwitcher", "support SHAKE_MUSIC_UI");
            return true;
        } else if (i == 5 && (i2 & 8) > 0) {
            x.i("MicroMsg.Music.MusicPlayerSwitcher", "support PRODUCT_UI");
            return true;
        } else if (i == 6 && (i2 & 16) > 0) {
            x.i("MicroMsg.Music.MusicPlayerSwitcher", "support FAVORITE_UI");
            return true;
        } else if (i == 7 && (i2 & 32) > 0) {
            x.i("MicroMsg.Music.MusicPlayerSwitcher", "support WEBVIEW_UI");
            return true;
        } else if (i == 8 && (i2 & 64) > 0) {
            x.i("MicroMsg.Music.MusicPlayerSwitcher", "support SNS_USER_TIMELINE_UI");
            return true;
        } else if (i != 9 || (i2 & FileUtils.S_IWUSR) <= 0) {
            x.i("MicroMsg.Music.MusicPlayerSwitcher", "QQMusicPlayer not support this scene %d", Integer.valueOf(i));
            return false;
        } else {
            x.i("MicroMsg.Music.MusicPlayerSwitcher", "support SEARCH_TIMELINE_UI");
            return true;
        }
    }
}
