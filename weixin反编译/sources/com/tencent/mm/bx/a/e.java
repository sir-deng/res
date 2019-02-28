package com.tencent.mm.bx.a;

import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.DataSetObserver;
import android.util.SparseArray;
import com.tencent.mm.bx.a.f.a;
import com.tencent.wcdb.AbstractCursor;
import java.util.HashMap;

public final class e extends AbstractCursor implements d {
    private DataSetObserver mObserver = new DataSetObserver() {
        public final void onChanged() {
            e.this.mPos = -1;
        }

        public final void onInvalidated() {
            e.this.mPos = -1;
        }
    };
    private d xKt;
    public d[] xKu;

    public e(d[] dVarArr) {
        int i = 0;
        this.xKu = dVarArr;
        this.xKt = dVarArr[0];
        while (i < this.xKu.length) {
            if (this.xKu[i] != null) {
                this.xKu[i].registerDataSetObserver(this.mObserver);
            }
            i++;
        }
    }

    public final int getCount() {
        int i = 0;
        int length = this.xKu.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (this.xKu[i2] != null) {
                i += this.xKu[i2].getCount();
            }
        }
        return i;
    }

    public final boolean onMove(int i, int i2) {
        this.xKt = null;
        int length = this.xKu.length;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            if (this.xKu[i4] != null) {
                if (i2 < this.xKu[i4].getCount() + i3) {
                    this.xKt = this.xKu[i4];
                    break;
                }
                i3 += this.xKu[i4].getCount();
            }
        }
        if (this.xKt != null) {
            return this.xKt.moveToPosition(i2 - i3);
        }
        return false;
    }

    public final String getString(int i) {
        return this.xKt.getString(i);
    }

    public final short getShort(int i) {
        return this.xKt.getShort(i);
    }

    public final int getInt(int i) {
        return this.xKt.getInt(i);
    }

    public final long getLong(int i) {
        return this.xKt.getLong(i);
    }

    public final float getFloat(int i) {
        return this.xKt.getFloat(i);
    }

    public final double getDouble(int i) {
        return this.xKt.getDouble(i);
    }

    public final boolean isNull(int i) {
        return this.xKt.isNull(i);
    }

    public final byte[] getBlob(int i) {
        return this.xKt.getBlob(i);
    }

    public final String[] getColumnNames() {
        if (this.xKt != null) {
            return this.xKt.getColumnNames();
        }
        return new String[0];
    }

    public final void deactivate() {
        int length = this.xKu.length;
        for (int i = 0; i < length; i++) {
            if (this.xKu[i] != null) {
                this.xKu[i].deactivate();
            }
        }
        super.deactivate();
    }

    public final void close() {
        int length = this.xKu.length;
        for (int i = 0; i < length; i++) {
            if (this.xKu[i] != null) {
                this.xKu[i].close();
            }
        }
        super.close();
    }

    public final void registerContentObserver(ContentObserver contentObserver) {
        int length = this.xKu.length;
        for (int i = 0; i < length; i++) {
            if (this.xKu[i] != null) {
                this.xKu[i].registerContentObserver(contentObserver);
            }
        }
    }

    public final void unregisterContentObserver(ContentObserver contentObserver) {
        int length = this.xKu.length;
        for (int i = 0; i < length; i++) {
            if (this.xKu[i] != null) {
                this.xKu[i].unregisterContentObserver(contentObserver);
            }
        }
    }

    public final void registerDataSetObserver(DataSetObserver dataSetObserver) {
        int length = this.xKu.length;
        for (int i = 0; i < length; i++) {
            if (this.xKu[i] != null) {
                this.xKu[i].registerDataSetObserver(dataSetObserver);
            }
        }
    }

    public final void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        int length = this.xKu.length;
        for (int i = 0; i < length; i++) {
            if (this.xKu[i] != null) {
                this.xKu[i].unregisterDataSetObserver(dataSetObserver);
            }
        }
    }

    public final boolean requery() {
        int length = this.xKu.length;
        int i = 0;
        while (i < length) {
            if (this.xKu[i] != null && !this.xKu[i].requery()) {
                return false;
            }
            i++;
        }
        return true;
    }

    public final void a(a aVar) {
        int length = this.xKu.length;
        for (int i = 0; i < length; i++) {
            if (this.xKu[i] != null) {
                this.xKu[i].a(aVar);
            }
        }
    }

    public final void lQ(boolean z) {
        int length = this.xKu.length;
        for (int i = 0; i < length; i++) {
            if (this.xKu[i] != null) {
                this.xKu[i].lQ(z);
            }
        }
    }

    public final boolean clE() {
        int length = this.xKu.length;
        boolean z = true;
        int i = 0;
        while (i < length) {
            if (!(this.xKu[i] == null || this.xKu[i].clE())) {
                z = false;
            }
            i++;
        }
        return z;
    }

    public final a DV(int i) {
        int length = this.xKu.length;
        for (int i2 = 0; i2 < length; i2++) {
            int count = this.xKu[i2].getCount();
            if (i < count) {
                return this.xKu[i2].DV(i);
            }
            i -= count;
        }
        return null;
    }

    public final boolean a(Object obj, a aVar) {
        boolean z = false;
        int length = this.xKu.length;
        int i = 0;
        while (i < length) {
            if (this.xKu[i] != null && this.xKu[i].a(obj, aVar)) {
                z = true;
            }
            i++;
        }
        return z;
    }

    public final SparseArray<Object>[] clC() {
        int length = this.xKu.length;
        SparseArray<Object>[] sparseArrayArr = new SparseArray[length];
        for (int i = 0; i < length; i++) {
            SparseArray[] clC = this.xKu[i].clC();
            sparseArrayArr[i] = clC != null ? clC[0] : null;
        }
        return sparseArrayArr;
    }

    public final HashMap clD() {
        return null;
    }

    public final boolean DU(int i) {
        int length = this.xKu.length;
        boolean z = true;
        int i2 = 0;
        while (i2 < length) {
            if (!(this.xKu[i2] == null || this.xKu[i2].DU(i))) {
                z = false;
            }
            i2++;
        }
        return z;
    }

    public final boolean ce(Object obj) {
        boolean z = false;
        int length = this.xKu.length;
        int i = 0;
        while (i < length) {
            if (this.xKu[i] != null && this.xKu[i].ce(obj)) {
                z = true;
            }
            i++;
        }
        return z;
    }

    public final a cf(Object obj) {
        return this.xKt.cf(obj);
    }

    public final void DW(int i) {
        int length = this.xKu.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (this.xKu[i2] != null) {
                this.xKu[i2].DW(i);
            }
        }
    }

    public final void copyStringToBuffer(int i, CharArrayBuffer charArrayBuffer) {
    }
}
