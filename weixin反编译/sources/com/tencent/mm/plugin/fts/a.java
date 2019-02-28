package com.tencent.mm.plugin.fts;

import android.database.Cursor;
import android.database.CursorWrapper;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashSet;
import java.util.Iterator;

public final class a extends CursorWrapper {
    private static HashSet<Cursor> mOM = new HashSet();

    public a(Cursor cursor) {
        super(cursor);
        mOM.add(cursor);
        x.v("MicroMsg.FTS.FTSCursor", "add cursor %d", Integer.valueOf(cursor.hashCode()));
    }

    public final void close() {
        super.close();
        mOM.remove(getWrappedCursor());
        x.v("MicroMsg.FTS.FTSCursor", "remove cursor %d", Integer.valueOf(r0.hashCode()));
    }

    public static final void aNu() {
        Iterator it = mOM.iterator();
        while (it.hasNext()) {
            Cursor cursor = (Cursor) it.next();
            if (!cursor.isClosed()) {
                try {
                    cursor.close();
                } catch (Exception e) {
                }
                x.e("MicroMsg.FTS.FTSCursor", "not close cursor!!! %d", Integer.valueOf(cursor.hashCode()));
            }
        }
        mOM.clear();
    }
}
