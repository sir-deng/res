package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import com.tencent.mm.plugin.wenote.model.a.p;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class h {
    private static volatile h tZI = null;
    private p tZJ = null;

    private h() {
    }

    public static h bXw() {
        if (tZI == null) {
            synchronized (h.class) {
                if (tZI == null) {
                    tZI = new h();
                }
            }
        }
        return tZI;
    }

    public final p bXx() {
        if (this.tZJ != null) {
            return this.tZJ;
        }
        as.Hm();
        String str = (String) c.Db().get(a.USERINFO_WENOTE_KEEP_TOP_DATA_STRING_SYNC, (Object) "");
        x.d("WNNoteKeepTopManager", "getCurrentTopItem itemStr: %s", str);
        if (bi.oN(str)) {
            return null;
        }
        byte[] Wj = bi.Wj(str);
        if (Wj.length <= 0) {
            return null;
        }
        this.tZJ = bc(Wj);
        String str2 = "WNNoteKeepTopManager";
        String str3 = "getCurrentTopItem item: %s";
        Object[] objArr = new Object[1];
        objArr[0] = this.tZJ != null ? this.tZJ.bWH() : "null";
        x.d(str2, str3, objArr);
        return this.tZJ;
    }

    public final void a(p pVar) {
        this.tZJ = pVar;
        byte[] b = b(this.tZJ);
        String str = "";
        if (b != null && b.length > 0) {
            str = bi.bA(b);
        }
        String str2 = "WNNoteKeepTopManager";
        String str3 = "setCurrentTopItem item: %s";
        Object[] objArr = new Object[1];
        objArr[0] = this.tZJ != null ? this.tZJ.bWH() : "null";
        x.i(str2, str3, objArr);
        x.i("WNNoteKeepTopManager", "setCurrentTopItem itemStr: %s", str);
        as.Hm();
        c.Db().a(a.USERINFO_WENOTE_KEEP_TOP_DATA_STRING_SYNC, bi.oM(str));
    }

    private static p bc(byte[] bArr) {
        ObjectInputStream objectInputStream;
        Exception e;
        Throwable th;
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        ByteArrayInputStream byteArrayInputStream;
        try {
            byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                objectInputStream = new ObjectInputStream(byteArrayInputStream);
            } catch (Exception e2) {
                e = e2;
                objectInputStream = null;
                try {
                    x.e("WNNoteKeepTopManager", "toObject exception:%s", e);
                    if (objectInputStream != null) {
                        try {
                            objectInputStream.close();
                        } catch (Exception e3) {
                            x.e("WNNoteKeepTopManager", "toObject close exception:%s", e3);
                            return null;
                        }
                    }
                    if (byteArrayInputStream != null) {
                        byteArrayInputStream.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (objectInputStream != null) {
                        try {
                            objectInputStream.close();
                        } catch (Exception e4) {
                            x.e("WNNoteKeepTopManager", "toObject close exception:%s", e4);
                            throw th;
                        }
                    }
                    if (byteArrayInputStream != null) {
                        byteArrayInputStream.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                objectInputStream = null;
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
                if (byteArrayInputStream != null) {
                    byteArrayInputStream.close();
                }
                throw th;
            }
            try {
                p pVar = (p) objectInputStream.readObject();
                try {
                    objectInputStream.close();
                    byteArrayInputStream.close();
                    return pVar;
                } catch (Exception e42) {
                    x.e("WNNoteKeepTopManager", "toObject close exception:%s", e42);
                    return pVar;
                }
            } catch (Exception e5) {
                e3 = e5;
                x.e("WNNoteKeepTopManager", "toObject exception:%s", e3);
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
                if (byteArrayInputStream != null) {
                    byteArrayInputStream.close();
                }
                return null;
            }
        } catch (Exception e6) {
            e3 = e6;
            objectInputStream = null;
            byteArrayInputStream = null;
            x.e("WNNoteKeepTopManager", "toObject exception:%s", e3);
            if (objectInputStream != null) {
                objectInputStream.close();
            }
            if (byteArrayInputStream != null) {
                byteArrayInputStream.close();
            }
            return null;
        } catch (Throwable th4) {
            th = th4;
            objectInputStream = null;
            byteArrayInputStream = null;
            if (objectInputStream != null) {
                objectInputStream.close();
            }
            if (byteArrayInputStream != null) {
                byteArrayInputStream.close();
            }
            throw th;
        }
    }

    private static byte[] b(p pVar) {
        Exception e;
        Throwable th;
        byte[] bArr = null;
        if (pVar != null) {
            ByteArrayOutputStream byteArrayOutputStream;
            ObjectOutputStream objectOutputStream;
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                    try {
                        objectOutputStream.writeObject(pVar);
                        objectOutputStream.flush();
                        bArr = byteArrayOutputStream.toByteArray();
                        try {
                            objectOutputStream.close();
                            byteArrayOutputStream.close();
                        } catch (Exception e2) {
                            x.e("WNNoteKeepTopManager", "toByteArray close exception:%s", e2);
                        }
                    } catch (Exception e3) {
                        e2 = e3;
                    }
                } catch (Exception e4) {
                    e2 = e4;
                    objectOutputStream = bArr;
                    try {
                        x.e("WNNoteKeepTopManager", "toByteArray exception:%s", e2);
                        if (objectOutputStream != null) {
                            try {
                                objectOutputStream.close();
                            } catch (Exception e22) {
                                x.e("WNNoteKeepTopManager", "toByteArray close exception:%s", e22);
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        return bArr;
                    } catch (Throwable th2) {
                        th = th2;
                        if (objectOutputStream != null) {
                            try {
                                objectOutputStream.close();
                            } catch (Exception e222) {
                                x.e("WNNoteKeepTopManager", "toByteArray close exception:%s", e222);
                                throw th;
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    objectOutputStream = bArr;
                    th = th3;
                    if (objectOutputStream != null) {
                        objectOutputStream.close();
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    throw th;
                }
            } catch (Exception e5) {
                e222 = e5;
                objectOutputStream = bArr;
                byteArrayOutputStream = bArr;
                x.e("WNNoteKeepTopManager", "toByteArray exception:%s", e222);
                if (objectOutputStream != null) {
                    objectOutputStream.close();
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                return bArr;
            } catch (Throwable th32) {
                objectOutputStream = bArr;
                byteArrayOutputStream = bArr;
                th = th32;
                if (objectOutputStream != null) {
                    objectOutputStream.close();
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                throw th;
            }
        }
        return bArr;
    }
}
