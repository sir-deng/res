package com.tencent.mm.plugin.fts.a.a;

import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.f.b.be;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class c extends be {
    public static a gKN;

    static {
        a aVar = new a();
        aVar.hUM = new Field[12];
        aVar.columns = new String[13];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "featureId";
        aVar.xrT.put("featureId", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" featureId INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xrS = "featureId";
        aVar.columns[1] = "title";
        aVar.xrT.put("title", "TEXT");
        stringBuilder.append(" title TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "titlePY";
        aVar.xrT.put("titlePY", "TEXT");
        stringBuilder.append(" titlePY TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "titleShortPY";
        aVar.xrT.put("titleShortPY", "TEXT");
        stringBuilder.append(" titleShortPY TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "tag";
        aVar.xrT.put("tag", "TEXT");
        stringBuilder.append(" tag TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "actionType";
        aVar.xrT.put("actionType", "INTEGER default '0' ");
        stringBuilder.append(" actionType INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[6] = SlookSmartClipMetaTag.TAG_TYPE_URL;
        aVar.xrT.put(SlookSmartClipMetaTag.TAG_TYPE_URL, "TEXT");
        stringBuilder.append(" url TEXT");
        stringBuilder.append(", ");
        aVar.columns[7] = "helpUrl";
        aVar.xrT.put("helpUrl", "TEXT");
        stringBuilder.append(" helpUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[8] = "updateUrl";
        aVar.xrT.put("updateUrl", "TEXT");
        stringBuilder.append(" updateUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[9] = "androidUrl";
        aVar.xrT.put("androidUrl", "TEXT");
        stringBuilder.append(" androidUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[10] = "iconPath";
        aVar.xrT.put("iconPath", "TEXT");
        stringBuilder.append(" iconPath TEXT");
        stringBuilder.append(", ");
        aVar.columns[11] = "timestamp";
        aVar.xrT.put("timestamp", "LONG default '0' ");
        stringBuilder.append(" timestamp LONG default '0' ");
        aVar.columns[12] = "rowid";
        aVar.xrU = stringBuilder.toString();
        gKN = aVar;
    }

    protected final a Aj() {
        return gKN;
    }

    public c() {
        this.field_featureId = 0;
        this.field_title = "";
        this.field_titlePY = "";
        this.field_titleShortPY = "";
        this.field_tag = "";
        this.field_actionType = 0;
        this.field_url = "";
        this.field_helpUrl = "";
        this.field_updateUrl = "";
        this.field_androidUrl = "";
        this.field_iconPath = "";
    }

    public final String toString() {
        return "Feature [field_featureId=" + this.field_featureId + ", field_title=" + this.field_title + ", field_titlePY=" + this.field_titlePY + ", field_titleShortPY=" + this.field_titleShortPY + ", field_tag=" + this.field_tag + ", field_actionType=" + this.field_actionType + ", field_url=" + this.field_url + ", field_helpUrl=" + this.field_helpUrl + ", field_updateUrl=" + this.field_updateUrl + ", field_androidUrl=" + this.field_androidUrl + ", field_iconPath=" + this.field_iconPath + "]";
    }
}
