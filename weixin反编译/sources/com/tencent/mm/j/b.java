package com.tencent.mm.j;

import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class b {
    public static int zG() {
        return bi.getInt(g.Af().getValue("InputLimitSessionTextMsg"), 8192) * 2;
    }

    public static int zH() {
        return bi.getInt(g.Af().getValue("InputLimitSNSObjectText"), MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN) * 2;
    }

    public static int zI() {
        return bi.getInt(g.Af().getValue("SnsCommentMaxSize"), 1000) * 2;
    }

    public static int zJ() {
        return bi.getInt(g.Af().getValue("InputLimitFavText"), 100000) * 2;
    }

    public static int zK() {
        return bi.getInt(g.Af().getValue("InputLimitSendEmotionBufSize"), 1048576);
    }

    public static int zL() {
        int i = WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
        try {
            return bi.getInt(g.Af().getValue("InputLimitSendEmotionWidth"), WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        } catch (Exception e) {
            x.j("MicroMsg.BoundaryConfig", "getCustomEmojiMaxWidthAndHeight:%s", e);
            return i;
        }
    }

    public static int zM() {
        int i = 5242880;
        try {
            return bi.getInt(g.Af().getValue("InputLimitSendAppMsgEmotionBufSize"), 5242880);
        } catch (Exception e) {
            x.j("MicroMsg.BoundaryConfig", "getAppEmojiMsgMaxSize:%s", e);
            return i;
        }
    }

    public static int zN() {
        return bi.getInt(g.Af().getValue("InputLimitFavImageSize"), 26214400);
    }

    public static int zO() {
        return bi.getInt(g.Af().getValue("InputLimitVideoSize"), 26214400);
    }

    public static String zP() {
        return g.Af().getValue("InputLimitForbiddenChar");
    }
}
