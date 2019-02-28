package com.tencent.mm.storage.emotion;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.mm.bx.g;
import com.tencent.mm.bx.g.a;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

public final class c extends i<b> implements a {
    public static final String[] gLy = new String[]{i.a(b.gKN, "EmojiInfoDesc")};
    public e gLA;
    public SharedPreferences xJd;

    public final /* synthetic */ boolean b(com.tencent.mm.sdk.e.c cVar) {
        b bVar = (b) cVar;
        if (bVar != null) {
            if (bVar.Nx().length() == 32) {
                bVar.field_md5_lang = bVar.field_md5 + bVar.field_lang;
                long replace = this.gLA.replace("EmojiInfoDesc", "md5_lang", bVar.vP());
                if (replace != -1) {
                    WI(bVar.Nx());
                }
                return replace >= 0;
            }
        }
        return false;
    }

    public c(e eVar) {
        this(eVar, b.gKN, "EmojiInfoDesc");
    }

    private c(e eVar, com.tencent.mm.sdk.e.c.a aVar, String str) {
        super(eVar, aVar, str, null);
        this.gLA = eVar;
        this.xJd = PreferenceManager.getDefaultSharedPreferences(ad.getContext());
    }

    public final int a(g gVar) {
        if (gVar != null) {
            this.gLA = gVar;
        }
        return 0;
    }

    public final boolean Yy(String str) {
        boolean z = true;
        boolean z2 = false;
        Cursor cursor = null;
        try {
            cursor = this.gLA.a(String.format("select %s from %s where %s=?", new Object[]{"click_flag", "EmojiInfoDesc", "groupId"}), new String[]{str}, 2);
            if (cursor != null && cursor.moveToFirst()) {
                if ((cursor.getInt(cursor.getColumnIndex("click_flag")) & 1) != 1) {
                    z = false;
                }
                z2 = z;
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Exception e) {
            x.w("MicroMsg.emoji.EmojiInfoDescStorage", "[isPurChase] Exception:%s", e.toString());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
        return z2;
    }

    public final boolean Yz(String str) {
        boolean z = true;
        boolean z2 = false;
        Cursor cursor = null;
        try {
            cursor = this.gLA.a(String.format("select %s from %s where %s=?", new Object[]{"download_flag", "EmojiInfoDesc", "groupId"}), new String[]{str}, 2);
            if (cursor != null && cursor.moveToFirst()) {
                if ((cursor.getInt(cursor.getColumnIndex("download_flag")) & 1) != 1) {
                    z = false;
                }
                z2 = z;
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Exception e) {
            x.w("MicroMsg.emoji.EmojiInfoDescStorage", "[isPurChase] Exception:%s", e.toString());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
        return z2;
    }

    public final boolean YA(String str) {
        boolean z = false;
        if (!TextUtils.isEmpty(str)) {
            Cursor cursor = null;
            try {
                cursor = this.gLA.a(String.format("select %s from %s where %s=?", new Object[]{"desc", "EmojiInfoDesc", "groupId"}), new String[]{str}, 2);
                if (cursor != null && cursor.moveToFirst()) {
                    z = true;
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Exception e) {
                x.w("MicroMsg.emoji.EmojiInfoDescStorage", e.toString());
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
        return z;
    }
}
