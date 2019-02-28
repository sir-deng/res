package com.tencent.mm.vending.a;

import android.database.Cursor;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;

public abstract class b<_Struct, _Item> extends com.tencent.mm.vending.base.b<_Struct, Cursor> {
    public Cursor BA = null;
    protected Map<Integer, _Item> kOy = null;
    public int mCount;
    public a zJY;
    protected _Item zJZ;

    public interface a {
        void bCA();

        void bCz();
    }

    public abstract _Item a(_Item _item, Cursor cursor);

    public abstract Cursor bCE();

    protected /* synthetic */ Object prepareVendingDataAsynchronous() {
        if (this.zJY != null) {
            this.zJY.bCz();
        }
        Cursor bCE = bCE();
        if (this.zJY != null) {
            this.zJY.bCA();
        }
        return bCE;
    }

    public b(_Item _item) {
        this.zJZ = _item;
        this.mCount = -1;
        cAv();
    }

    private Cursor getCursor() {
        if (this.BA == null || this.BA.isClosed()) {
            Assert.assertNotNull(this.BA);
        }
        return this.BA;
    }

    public void destroyAsynchronous() {
        aUU();
    }

    public final void aUU() {
        if (this.kOy != null) {
            this.kOy.clear();
        }
        if (this.BA != null) {
            this.BA.close();
        }
        this.mCount = -1;
    }

    public final void cAv() {
        if (this.kOy == null) {
            this.kOy = new HashMap();
        }
    }

    public final int cAw() {
        if (this.mCount < 0) {
            this.mCount = getCursor().getCount();
        }
        return this.mCount;
    }

    public final _Item getItem(int i) {
        _Item _item;
        if (this.kOy != null) {
            _item = this.kOy.get(Integer.valueOf(i));
            if (_item != null) {
                return _item;
            }
        }
        if (i < 0 || !getCursor().moveToPosition(i)) {
            return null;
        }
        if (this.kOy == null) {
            return a(this.zJZ, getCursor());
        }
        _item = a(null, getCursor());
        this.kOy.put(Integer.valueOf(i), _item);
        return _item;
    }
}
