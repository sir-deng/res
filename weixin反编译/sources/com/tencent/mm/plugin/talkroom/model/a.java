package com.tencent.mm.plugin.talkroom.model;

import com.tencent.mm.compatible.e.m;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;

public final class a {
    public static final int sgK;
    private static int sgX;

    static {
        int yw = m.yw();
        sgX = yw;
        sgK = (yw & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0 ? 16000 : 8000;
    }
}
