package com.tencent.mm.plugin.emoji.h;

import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.protocal.c.sx;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;

public final class a {
    public static boolean aDF() {
        return i.aCl().lCx.ckP();
    }

    public static boolean d(sx sxVar) {
        return sxVar == null ? false : zu(sxVar.vPI);
    }

    public static boolean b(EmojiGroupInfo emojiGroupInfo) {
        return emojiGroupInfo == null ? false : zu(emojiGroupInfo.field_productID);
    }

    public static boolean zu(String str) {
        return str == null ? false : str.equals(aEi());
    }

    public static final String aEi() {
        return EmojiGroupInfo.xIE;
    }
}
