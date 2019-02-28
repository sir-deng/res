package com.tencent.mm.pluginsdk.e.a;

import android.database.MatrixCursor;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.sdk.platformtools.x;

public final class a {
    public static final String[] vjz = new String[]{"retCode", SlookSmartClipMetaTag.TAG_TYPE_URL};

    public static MatrixCursor BQ(int i) {
        x.i("MicroMsg.ExtCommonUtils", "returnMatrix = " + i);
        MatrixCursor matrixCursor = new MatrixCursor(com.tencent.mm.plugin.ext.b.a.mfw);
        matrixCursor.addRow(new Object[]{Integer.valueOf(i)});
        return matrixCursor;
    }

    public static MatrixCursor RT(String str) {
        x.i("MicroMsg.ExtCommonUtils", new StringBuilder("returnMatrix = 4207").toString());
        MatrixCursor matrixCursor = new MatrixCursor(vjz);
        matrixCursor.addRow(new Object[]{Integer.valueOf(4207), str});
        return matrixCursor;
    }
}
