package com.tencent.mm.ipcinvoker.d;

import junit.framework.Assert;

public class d {
    public String fpd;
    public com.tencent.mm.ipcinvoker.d gOG;
    private String process;

    public <T extends b> d(String str, Class<T> cls) {
        Assert.assertNotNull(str);
        Assert.assertNotNull(cls);
        this.process = str;
        this.fpd = cls.getName();
        this.gOG = new com.tencent.mm.ipcinvoker.d(str);
    }
}
