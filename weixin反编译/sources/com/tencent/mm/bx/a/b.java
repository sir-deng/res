package com.tencent.mm.bx.a;

import android.database.sqlite.SQLiteClosable;
import android.util.SparseArray;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class b<T extends a> extends SQLiteClosable {
    int mStartPos = 0;
    SparseArray<Object> xKj = new SparseArray();
    int xKk;
    HashMap<Object, T> xKl = new HashMap();
    ArrayList<Object> xKm;
    T xKn;

    public abstract ArrayList<T> ah(ArrayList<Object> arrayList);

    public abstract T clM();

    final void b(Object obj, T t) {
        this.xKl.put(obj, t);
    }

    public final boolean DX(int i) {
        return this.xKj.indexOfKey(i) >= 0;
    }

    public final void eM(int i, int i2) {
        if (i2 != 0) {
            x.e("MicroMsg.CursorDataWindow", "newcursor rowEnd with error %d rowNum : %d", Integer.valueOf(i2), Integer.valueOf(i));
            this.xKj.remove(i);
        } else if (this.xKn != null) {
            Object key = this.xKn.getKey();
            b(key, this.xKn);
            this.xKj.put(i, key);
        }
    }

    public final void abi() {
        x.i("MicroMsg.CursorDataWindow", "clearData");
        this.xKj.clear();
        this.xKl.clear();
    }

    protected void onAllReferencesReleased() {
        abi();
    }

    final void r(Object[] objArr) {
        SparseArray sparseArray = new SparseArray();
        int i = 0;
        for (int i2 = 0; i2 < this.xKj.size(); i2++) {
            int keyAt = this.xKj.keyAt(i2);
            Object valueAt = this.xKj.valueAt(i2);
            Object obj = 1;
            for (Object equals : objArr) {
                if (equals.equals(valueAt)) {
                    i++;
                    obj = null;
                    break;
                }
            }
            if (obj != null) {
                sparseArray.put(keyAt - i, valueAt);
            } else {
                x.i("MicroMsg.CursorDataWindow", "newcursor delete index : " + i2 + " obj : " + valueAt);
            }
        }
        if (this.xKj.size() != sparseArray.size()) {
            x.i("MicroMsg.CursorDataWindow", "newcursor oldposition size :" + this.xKj.size() + " newposistion Size : " + sparseArray.size());
        }
        this.xKj = sparseArray;
    }

    public final boolean ce(Object obj) {
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length == 1) {
                if (this.xKl == null || !this.xKl.containsKey(objArr[0])) {
                    return false;
                }
                return true;
            }
        }
        return this.xKl != null && this.xKl.containsKey(obj);
    }
}
