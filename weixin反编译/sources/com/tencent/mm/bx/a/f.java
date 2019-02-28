package com.tencent.mm.bx.a;

import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.DataSetObserver;
import android.util.SparseArray;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.AbstractCursor;
import com.tencent.wcdb.Cursor;
import com.tencent.wcdb.DatabaseUtils;
import com.tencent.wcdb.database.SQLiteCursorDriver;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteDatabase.CursorFactory;
import com.tencent.wcdb.database.SQLiteProgram;
import com.tencent.wcdb.support.CancellationSignal;
import com.tencent.wcdb.support.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class f extends AbstractCursor implements d {
    public static final CursorFactory FACTORY = new CursorFactory() {
        public final Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteProgram sQLiteProgram) {
            return new f(sQLiteCursorDriver, str, (h) sQLiteProgram);
        }

        public final SQLiteProgram newQuery(SQLiteDatabase sQLiteDatabase, String str, Object[] objArr, CancellationSignal cancellationSignal) {
            return new h(sQLiteDatabase, str, cancellationSignal);
        }
    };
    private Map<String, Integer> mColumnNameMap;
    private final String[] mColumns;
    private int mCount = -1;
    private final SQLiteCursorDriver mDriver;
    private final String mEditTable;
    private final Throwable mStackTrace;
    private int pageSize = 3000;
    c xKA;
    private boolean xKB;
    private final h xKw;
    public a xKx;
    private boolean xKy;
    private b<a> xKz;

    public interface a {
        ArrayList<a> ah(ArrayList<Object> arrayList);

        a clM();
    }

    public f(SQLiteCursorDriver sQLiteCursorDriver, String str, h hVar) {
        if (hVar == null) {
            throw new IllegalArgumentException("query object cannot be null");
        }
        this.mStackTrace = null;
        this.mDriver = sQLiteCursorDriver;
        this.mEditTable = str;
        this.mColumnNameMap = null;
        this.xKw = hVar;
        this.mColumns = hVar.getColumnNames();
        this.mRowIdColumnIndex = DatabaseUtils.findRowIdColumnIndex(this.mColumns);
    }

    public final void DW(int i) {
        if (i <= 15000 && i >= MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN) {
            this.pageSize = i;
        }
    }

    public final void lQ(boolean z) {
        this.xKy = z;
    }

    public final boolean onMove(int i, int i2) {
        if (!this.xKy) {
            boolean z;
            if (this.xKA == null) {
                clN();
            }
            c cVar = this.xKA;
            int i3 = i2 / cVar.xKp;
            if (cVar.xKo.indexOfKey(i3) >= 0) {
                if (((Object[]) cVar.xKo.get(i3))[(i2 % cVar.xKp) * cVar.columnCount] != null) {
                    z = true;
                    if (!z) {
                        DY((i2 / this.pageSize) * this.pageSize);
                    }
                    this.xKA.moveToPosition(i2);
                }
            }
            z = false;
            if (z) {
                DY((i2 / this.pageSize) * this.pageSize);
            }
            this.xKA.moveToPosition(i2);
        } else if (this.xKz == null || !this.xKz.DX(i2)) {
            DY((i2 / this.pageSize) * this.pageSize);
        }
        return true;
    }

    private void clN() {
        if (this.xKA == null) {
            this.xKA = new c(this.mColumns, (byte) 0);
        }
    }

    public final int getCount() {
        if (this.mCount == -1) {
            this.mCount = DY(0);
            if (this.xKz != null) {
                boolean z = this.mCount != -1 && this.mCount == this.xKz.xKj.size();
                this.xKB = z;
            }
        }
        if (!this.xKy || !this.xKB) {
            return this.mCount;
        }
        if (this.xKz == null) {
            return 0;
        }
        return this.xKz.xKj.size();
    }

    protected final void checkPosition() {
        super.checkPosition();
    }

    private int DY(int i) {
        if (this.xKy) {
            if (this.xKz == null) {
                this.xKz = new b<a>() {
                    public final a clM() {
                        f fVar = f.this;
                        return fVar.xKx != null ? fVar.xKx.clM() : null;
                    }

                    public final ArrayList<a> ah(ArrayList<Object> arrayList) {
                        f fVar = f.this;
                        return fVar.xKx != null ? fVar.xKx.ah(arrayList) : null;
                    }
                };
            }
            this.xKz.mStartPos = i;
            return this.xKw.a(this.xKz, i, this.pageSize);
        }
        clN();
        return this.xKw.a(this.xKA, i, this.pageSize);
    }

    public final int getColumnIndex(String str) {
        int i;
        Object str2;
        if (this.mColumnNameMap == null) {
            String[] strArr = this.mColumns;
            int length = strArr.length;
            Map hashMap = new HashMap(length, 1.0f);
            for (i = 0; i < length; i++) {
                hashMap.put(strArr[i], Integer.valueOf(i));
            }
            this.mColumnNameMap = hashMap;
        }
        i = str2.lastIndexOf(46);
        if (i != -1) {
            Exception exception = new Exception();
            Log.e("WCDB.SQLiteNewCursor", "requesting column name with table name -- " + str2, exception);
            str2 = str2.substring(i + 1);
        }
        Integer num = (Integer) this.mColumnNameMap.get(str2);
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }

    public final String[] getColumnNames() {
        return this.mColumns;
    }

    public final void deactivate() {
        super.deactivate();
        this.mDriver.cursorDeactivated();
    }

    public final void close() {
        super.close();
        synchronized (this) {
            this.xKw.close();
            this.mDriver.cursorClosed();
        }
    }

    public final boolean requery() {
        boolean z = false;
        if (isClosed()) {
            return z;
        }
        synchronized (this) {
            if (this.xKw.getDatabase().isOpen()) {
                if (this.xKz != null) {
                    this.xKz.abi();
                }
                this.mPos = -1;
                this.mCount = -1;
                this.mDriver.cursorRequeried(this);
                try {
                    return super.requery();
                } catch (IllegalStateException e) {
                    Log.w("WCDB.SQLiteNewCursor", "requery() failed " + e.getMessage(), e);
                    return z;
                }
            }
            return z;
        }
    }

    protected final void finalize() {
        try {
            if (this.xKz != null) {
                close();
            }
            super.finalize();
        } catch (Throwable th) {
            super.finalize();
        }
    }

    public final String getString(int i) {
        if (this.xKy) {
            return null;
        }
        return this.xKA.getString(i);
    }

    public final short getShort(int i) {
        if (this.xKy) {
            return (short) 0;
        }
        return this.xKA.getShort(i);
    }

    public final int getInt(int i) {
        if (this.xKy) {
            return 0;
        }
        return this.xKA.getInt(i);
    }

    public final long getLong(int i) {
        if (this.xKy) {
            return 0;
        }
        return this.xKA.getLong(i);
    }

    public final float getFloat(int i) {
        if (this.xKy) {
            return 0.0f;
        }
        return this.xKA.getFloat(i);
    }

    public final double getDouble(int i) {
        if (this.xKy) {
            return 0.0d;
        }
        return this.xKA.getDouble(i);
    }

    public final boolean isNull(int i) {
        if (this.xKy) {
            return false;
        }
        return this.xKA.isNull(i);
    }

    public final byte[] getBlob(int i) {
        if (this.xKy) {
            return null;
        }
        return this.xKA.getBlob(i);
    }

    public final a DV(int i) {
        a aVar = null;
        int i2 = 0;
        if (this.xKz != null) {
            b bVar = this.xKz;
            if (bVar.DX(i)) {
                Object obj = bVar.xKj.get(i);
                aVar = (a) bVar.xKl.get(obj);
                if (aVar == null) {
                    x.i("MicroMsg.CursorDataWindow", "get data null %s", obj);
                    if (bVar.xKm.size() != 0) {
                        ArrayList ah = bVar.ah(bVar.xKm);
                        if (ah != null) {
                            while (i2 < ah.size()) {
                                aVar = (a) ah.get(i2);
                                if (aVar != null) {
                                    bVar.b(aVar.getKey(), aVar);
                                } else {
                                    x.e("MicroMsg.CursorDataWindow", "newcursor obj is null");
                                }
                                i2++;
                            }
                        }
                        bVar.xKm.clear();
                    }
                    aVar = (a) bVar.xKl.get(obj);
                    if (aVar == null) {
                        x.e("MicroMsg.CursorDataWindow", "newcursor error obj : " + obj + "pos:" + i);
                    }
                }
            } else {
                x.e("MicroMsg.CursorDataWindow", "newcursor cursor getItem error: pos " + i + " loaded num :" + bVar.xKj.size());
            }
        }
        return aVar;
    }

    public final boolean a(Object obj, a aVar) {
        if (this.xKy && this.xKz != null) {
            if (!this.xKB && (obj instanceof Object[]) && this.xKz.ce(obj)) {
                this.mCount -= ((Object[]) obj).length;
                this.pageSize -= ((Object[]) obj).length;
            }
            b bVar = this.xKz;
            if (aVar != null) {
                x.v("MicroMsg.CursorDataWindow", "newcursor cursor update Memory key : " + obj + "values : " + aVar);
                bVar.b(obj, aVar);
            } else if (obj instanceof Object[]) {
                Object[] objArr = (Object[]) obj;
                for (Object remove : objArr) {
                    bVar.xKl.remove(remove);
                }
                bVar.r(objArr);
            } else {
                if (bVar.xKm == null) {
                    bVar.xKm = new ArrayList();
                }
                if (!bVar.xKm.contains(obj)) {
                    bVar.xKm.add(obj);
                    x.i("MicroMsg.CursorDataWindow", "newcursor cursor clearData : " + obj);
                }
                bVar.xKl.remove(obj);
            }
        } else if (!this.xKy) {
            c cVar = this.xKA;
            cVar.mPos = 0;
            cVar.xKo.clear();
        }
        return false;
    }

    public final boolean clE() {
        return this.xKB;
    }

    public final boolean DU(int i) {
        if (!this.xKy) {
            return false;
        }
        b bVar = this.xKz;
        if (i > 50) {
            return false;
        }
        if (bVar.xKk < 10) {
            return true;
        }
        if (((double) i) / ((double) bVar.xKk) < 0.1d) {
            return true;
        }
        return false;
    }

    public final boolean ce(Object obj) {
        if (this.xKy && this.xKz != null) {
            return this.xKz.ce(obj);
        }
        return false;
    }

    public final a cf(Object obj) {
        if (!this.xKy) {
            Log.e("WCDB.SQLiteNewCursor", "newcursor getItemByKey error " + obj);
            return null;
        } else if (this.xKz == null) {
            Log.e("WCDB.SQLiteNewCursor", "newcursor error getItemByKey window is null");
            return null;
        } else {
            b bVar = this.xKz;
            if (bVar.xKl != null) {
                return (a) bVar.xKl.get(obj);
            }
            return null;
        }
    }

    public final void copyStringToBuffer(int i, CharArrayBuffer charArrayBuffer) {
    }

    public final void registerContentObserver(ContentObserver contentObserver) {
    }

    public final void registerDataSetObserver(DataSetObserver dataSetObserver) {
    }

    public final void unregisterContentObserver(ContentObserver contentObserver) {
    }

    public final void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
    }

    public final void a(a aVar) {
        this.xKx = aVar;
    }

    public final SparseArray<Object>[] clC() {
        if (!this.xKy) {
            return null;
        }
        return new SparseArray[]{this.xKz.xKj};
    }

    public final HashMap clD() {
        return this.xKz.xKl;
    }
}
