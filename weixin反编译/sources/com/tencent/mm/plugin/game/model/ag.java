package com.tencent.mm.plugin.game.model;

import com.tencent.mm.plugin.game.c.dn;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public final class ag {
    public String mAppId = "";
    public List<a> njf = new LinkedList();

    public static class a implements Serializable {
        public String fEx;
        public long mRP;
        public int njg;
        public int njh;
        public boolean nji;
        public String njj;
        public String tag;
    }

    public ag(String str) {
        if (!bi.oN(str)) {
            this.mAppId = str;
            this.njf.addAll(aRo());
        }
    }

    public ag(String str, List<dn> list) {
        if (!bi.oN(str) && list != null && !list.isEmpty()) {
            this.mAppId = str;
            this.njf.clear();
            for (dn dnVar : list) {
                a aVar = new a();
                aVar.njg = dnVar.npC;
                aVar.fEx = dnVar.kyG;
                aVar.tag = dnVar.npE;
                aVar.mRP = dnVar.npD;
                aVar.nji = dnVar.npF;
                aVar.njh = dnVar.npG;
                aVar.njj = dnVar.npH;
                this.njf.add(aVar);
            }
            aRp();
        }
    }

    private List<a> aRo() {
        Throwable e;
        String str = this.mAppId + "_ranks";
        List<a> linkedList = new LinkedList();
        byte[] CC = SubCoreGameCenter.aRO().CC(str);
        if (CC == null) {
            return linkedList;
        }
        InputStream byteArrayInputStream = new ByteArrayInputStream(CC);
        ObjectInput objectInputStream;
        try {
            objectInputStream = new ObjectInputStream(byteArrayInputStream);
            try {
                linkedList.addAll((List) objectInputStream.readObject());
                try {
                    byteArrayInputStream.close();
                } catch (IOException e2) {
                }
                try {
                    objectInputStream.close();
                } catch (IOException e3) {
                }
            } catch (Exception e4) {
                e = e4;
                try {
                    x.printErrStackTrace("MicroMsg.GamePBDataDetailRank", e, "", new Object[0]);
                    try {
                        byteArrayInputStream.close();
                    } catch (IOException e5) {
                    }
                    if (objectInputStream != null) {
                        try {
                            objectInputStream.close();
                        } catch (IOException e6) {
                        }
                    }
                    return linkedList;
                } catch (Throwable th) {
                    e = th;
                    try {
                        byteArrayInputStream.close();
                    } catch (IOException e7) {
                    }
                    if (objectInputStream != null) {
                        try {
                            objectInputStream.close();
                        } catch (IOException e8) {
                        }
                    }
                    throw e;
                }
            }
        } catch (Exception e9) {
            e = e9;
            objectInputStream = null;
            x.printErrStackTrace("MicroMsg.GamePBDataDetailRank", e, "", new Object[0]);
            byteArrayInputStream.close();
            if (objectInputStream != null) {
                objectInputStream.close();
            }
            return linkedList;
        } catch (Throwable th2) {
            e = th2;
            objectInputStream = null;
            byteArrayInputStream.close();
            if (objectInputStream != null) {
                objectInputStream.close();
            }
            throw e;
        }
        return linkedList;
    }

    public final void aRp() {
        Throwable e;
        String str = this.mAppId + "_ranks";
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutput objectOutputStream;
        try {
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            try {
                objectOutputStream.writeObject(this.njf);
                SubCoreGameCenter.aRO().n(str, byteArrayOutputStream.toByteArray());
                try {
                    objectOutputStream.close();
                } catch (IOException e2) {
                }
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e3) {
                }
            } catch (Exception e4) {
                e = e4;
                try {
                    x.printErrStackTrace("MicroMsg.GamePBDataDetailRank", e, "", new Object[0]);
                    if (objectOutputStream != null) {
                        try {
                            objectOutputStream.close();
                        } catch (IOException e5) {
                        }
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e6) {
                    }
                } catch (Throwable th) {
                    e = th;
                    if (objectOutputStream != null) {
                        try {
                            objectOutputStream.close();
                        } catch (IOException e7) {
                        }
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e8) {
                    }
                    throw e;
                }
            }
        } catch (Exception e9) {
            e = e9;
            objectOutputStream = null;
            x.printErrStackTrace("MicroMsg.GamePBDataDetailRank", e, "", new Object[0]);
            if (objectOutputStream != null) {
                objectOutputStream.close();
            }
            byteArrayOutputStream.close();
        } catch (Throwable th2) {
            e = th2;
            objectOutputStream = null;
            if (objectOutputStream != null) {
                objectOutputStream.close();
            }
            byteArrayOutputStream.close();
            throw e;
        }
    }
}
