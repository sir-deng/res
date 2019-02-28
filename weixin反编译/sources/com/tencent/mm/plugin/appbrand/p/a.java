package com.tencent.mm.plugin.appbrand.p;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.h;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;

public final class a extends i<a> {
    public static final String[] iHj = new String[]{i.a(a.iHi, "AppBrandCommonKVBinaryData")};

    static final class a extends c {
        static final com.tencent.mm.sdk.e.c.a iHi = c.D(a.class);
        @h(chA = "$$invalid", chB = 1)
        public String field_key;
        public byte[] field_value;

        a() {
        }

        protected final com.tencent.mm.sdk.e.c.a Aj() {
            return iHi;
        }

        public final void b(Cursor cursor) {
            this.field_key = cursor.getString(0);
            this.field_value = cursor.getBlob(1);
        }

        public final ContentValues vP() {
            ContentValues contentValues = new ContentValues(2);
            contentValues.put("key", this.field_key);
            contentValues.put(Columns.VALUE, this.field_value);
            return contentValues;
        }
    }

    public a(e eVar) {
        super(eVar, a.iHi, "AppBrandCommonKVBinaryData", null);
    }

    public final void k(String str, byte[] bArr) {
        if (!bi.oN(str)) {
            c aVar = new a();
            aVar.field_key = str;
            aVar.field_value = bArr;
            super.a(aVar);
        }
    }

    public final <T extends com.tencent.mm.bp.a> T g(String str, Class<T> cls) {
        byte[] bArr;
        T t;
        if (!bi.oN(str)) {
            c aVar = new a();
            aVar.field_key = str;
            if (super.b(aVar, new String[0])) {
                bArr = aVar.field_value;
                if (bi.by(bArr)) {
                    return null;
                }
                try {
                    t = (com.tencent.mm.bp.a) cls.newInstance();
                    t.aH(bArr);
                    return t;
                } catch (Exception e) {
                    x.e("MicroMsg.AppBrandCommonKVBinaryDataStorage", "getProto class[%s] e = %s", cls.getSimpleName(), e);
                    return null;
                }
            }
        }
        bArr = null;
        if (bi.by(bArr)) {
            return null;
        }
        t = (com.tencent.mm.bp.a) cls.newInstance();
        t.aH(bArr);
        return t;
    }
}
