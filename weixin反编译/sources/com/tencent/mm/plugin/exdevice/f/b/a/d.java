package com.tencent.mm.plugin.exdevice.f.b.a;

import com.tencent.mm.f.b.bv;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class d extends bv {
    public static a gKN;

    static {
        a aVar = new a();
        aVar.hUM = new Field[7];
        aVar.columns = new String[8];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "rankID";
        aVar.xrT.put("rankID", "TEXT");
        stringBuilder.append(" rankID TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "appusername";
        aVar.xrT.put("appusername", "TEXT");
        stringBuilder.append(" appusername TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "username";
        aVar.xrT.put("username", "TEXT");
        stringBuilder.append(" username TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "ranknum";
        aVar.xrT.put("ranknum", "INTEGER");
        stringBuilder.append(" ranknum INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "score";
        aVar.xrT.put("score", "INTEGER");
        stringBuilder.append(" score INTEGER");
        stringBuilder.append(", ");
        aVar.columns[5] = "likecount";
        aVar.xrT.put("likecount", "INTEGER default '0' ");
        stringBuilder.append(" likecount INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[6] = "selfLikeState";
        aVar.xrT.put("selfLikeState", "INTEGER default '3' ");
        stringBuilder.append(" selfLikeState INTEGER default '3' ");
        aVar.columns[7] = "rowid";
        aVar.xrU = stringBuilder.toString();
        gKN = aVar;
    }

    protected final a Aj() {
        return gKN;
    }

    public final String toString() {
        return (("{" + "username: " + this.field_username + " ranknum: " + this.field_ranknum + " score: " + this.field_score) + " likeCount:" + this.field_likecount + " selfLikeState:" + this.field_selfLikeState) + "}";
    }
}
