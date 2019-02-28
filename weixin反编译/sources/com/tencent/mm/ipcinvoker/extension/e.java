package com.tencent.mm.ipcinvoker.extension;

import com.tencent.mm.ipcinvoker.e.b;
import junit.framework.Assert;

public final class e<T> {
    private volatile T gOJ;
    private Class<T> targetClass;

    public e(Class<T> cls) {
        Assert.assertNotNull(cls);
        this.targetClass = cls;
    }

    public final T get() {
        if (this.gOJ == null) {
            synchronized (this) {
                if (this.gOJ == null) {
                    this.gOJ = b.e(this.targetClass);
                }
            }
        }
        return this.gOJ;
    }
}
