package com.tencent.mm.plugin.gallery.model;

import android.net.Uri;
import android.provider.MediaStore.Images.Media;
import com.tencent.mm.plugin.gallery.model.GalleryItem.AlbumItem;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

public final class i extends k {
    private String[] mWY = new String[]{"camera", "screenshot", "download"};

    protected final int getType() {
        return 1;
    }

    public final ArrayList<AlbumItem> aOF() {
        return super.aOF();
    }

    public final Uri aOH() {
        return Media.EXTERNAL_CONTENT_URI;
    }

    public final String[] getProjection() {
        return new String[]{"_id", "_data", "bucket_display_name", "count(*)", "COALESCE(" + k.mXc, k.mXb + ",0) AS " + mXd, k.mXc, k.mXb, "mime_type"};
    }

    public final String getSelection() {
        return "0==0) GROUP BY (bucket_display_name";
    }

    public final String aOJ() {
        return k.mXd + " desc,_id desc";
    }

    protected final String aOK() {
        return "bucket_display_name";
    }

    protected final String[] aOI() {
        return new String[]{"_id", "_data", "COALESCE(" + k.mXc, k.mXb + ",0) AS " + mXd, k.mXc, k.mXb, "mime_type"};
    }

    protected final String BZ(String str) {
        if (!bi.oN(str)) {
            return "bucket_display_name=\"" + str + "\"";
        }
        x.w("MicroMsg.ImageQuery", "get media item selection, but album name is null, do select all");
        String stringBuilder = new StringBuilder("_size>10240").toString();
        String[] strArr = this.mWY;
        int length = strArr.length;
        int i = 0;
        while (i < length) {
            i++;
            stringBuilder = stringBuilder + " or lower(_data) like '%" + strArr[i] + "%'";
        }
        x.d("MicroMsg.ImageQuery", "where %s", stringBuilder);
        return stringBuilder;
    }
}
