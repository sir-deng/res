package oicq.wlogin_sdk.request;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.security.Key;
import java.util.TreeMap;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.SecretKeySpec;
import oicq.wlogin_sdk.sharemem.WloginSigInfo;
import oicq.wlogin_sdk.sharemem.WloginSimpleInfo;
import oicq.wlogin_sdk.tools.util;

public final class c {
    TreeMap<Long, WloginAllSigInfo> AFm = new TreeMap();
    Context _context;

    public c(Context context) {
        this._context = context;
    }

    public final synchronized int a(long j, long j2, long j3, long j4, long j5, long j6, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, byte[] bArr6, byte[] bArr7, byte[] bArr8, byte[] bArr9, byte[] bArr10, byte[] bArr11, byte[] bArr12, byte[] bArr13, byte[] bArr14, byte[] bArr15, byte[] bArr16, byte[][] bArr17) {
        int i;
        WloginAllSigInfo wloginAllSigInfo;
        Object obj;
        WloginAllSigInfo wloginAllSigInfo2 = (WloginAllSigInfo) this.AFm.get(new Long(j));
        if (wloginAllSigInfo2 == null) {
            wloginAllSigInfo = new WloginAllSigInfo();
        } else {
            wloginAllSigInfo = wloginAllSigInfo2;
        }
        Object obj2 = new byte[0];
        WloginSigInfo wloginSigInfo = (WloginSigInfo) wloginAllSigInfo._tk_map.get(new Long(j2));
        if (wloginSigInfo == null || wloginSigInfo._en_A1 == null) {
            obj = obj2;
        } else {
            obj = (byte[]) wloginSigInfo._en_A1.clone();
        }
        wloginAllSigInfo._useInfo = new WloginSimpleInfo(j, bArr, bArr2, bArr3, bArr4);
        int put_siginfo = wloginAllSigInfo.put_siginfo(j2, j3, j4, j5, j6, bArr5, bArr6, bArr7, bArr8, bArr9, bArr10, bArr11, bArr12, bArr13, bArr14, bArr15, bArr16, bArr17);
        util.adi("before put_siginfo, ret=" + put_siginfo);
        if (this._context != null) {
            TreeMap bX = bX(this._context, "tk_file");
            if (bX == null) {
                bX = new TreeMap();
            }
            util.adi("after loadTKTreeMap");
            bX.put(new Long(j), wloginAllSigInfo.get_clone());
            put_siginfo = a(bX, "tk_file");
            util.adi("after refreshTKTreeMap, ret=" + put_siginfo);
        }
        i = put_siginfo;
        if (i != 0) {
            wloginSigInfo = (WloginSigInfo) wloginAllSigInfo._tk_map.get(new Long(j2));
            if (wloginSigInfo != null) {
                wloginSigInfo._en_A1 = (byte[]) obj.clone();
            }
        }
        this.AFm.put(new Long(j), wloginAllSigInfo);
        return i;
    }

    private synchronized WloginAllSigInfo gM(long j) {
        WloginAllSigInfo wloginAllSigInfo;
        util.gp("get_all_siginfo", "uin=" + j);
        wloginAllSigInfo = (WloginAllSigInfo) this.AFm.get(new Long(j));
        if (wloginAllSigInfo == null) {
            if (this._context == null) {
                wloginAllSigInfo = null;
            } else {
                TreeMap bX = bX(this._context, "tk_file");
                if (bX == null) {
                    wloginAllSigInfo = null;
                } else {
                    wloginAllSigInfo = (WloginAllSigInfo) bX.get(new Long(j));
                    if (wloginAllSigInfo == null) {
                        util.gp("get_all_siginfo", "null");
                        wloginAllSigInfo = null;
                    } else {
                        this.AFm.put(new Long(j), wloginAllSigInfo);
                        wloginAllSigInfo = wloginAllSigInfo.get_clone();
                    }
                }
            }
        }
        return wloginAllSigInfo;
    }

    public final synchronized WloginSigInfo N(long j, long j2) {
        WloginSigInfo wloginSigInfo;
        util.gp("get_siginfo", "uin=" + j + "appid=" + j2);
        WloginAllSigInfo gM = gM(j);
        if (gM == null) {
            wloginSigInfo = null;
        } else {
            wloginSigInfo = (WloginSigInfo) gM._tk_map.get(new Long(j2));
            if (wloginSigInfo == null) {
                wloginSigInfo = null;
            }
        }
        return wloginSigInfo;
    }

    public final synchronized void h(Long l) {
        this.AFm.remove(l);
        if (this._context != null) {
            TreeMap bX = bX(this._context, "tk_file");
            if (bX != null) {
                bX.remove(l);
                a(bX, "tk_file");
            }
        }
    }

    private synchronized int a(TreeMap treeMap, String str) {
        int i;
        i = 0;
        if (str == "tk_file") {
            i = b(treeMap, str);
        }
        return i;
    }

    private synchronized int b(TreeMap treeMap, String str) {
        int a;
        try {
            Key secretKeySpec = new SecretKeySpec(i.AFO, "DESede");
            Cipher instance = Cipher.getInstance("DESede");
            instance.init(1, secretKeySpec);
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new CipherOutputStream(byteArrayOutputStream, instance));
            objectOutputStream.writeObject(treeMap);
            objectOutputStream.close();
            a = a(this._context, str, byteArrayOutputStream.toByteArray());
        } catch (Exception e) {
            Writer stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter, true);
            e.printStackTrace(printWriter);
            printWriter.flush();
            stringWriter.flush();
            util.gq("exception", stringWriter.toString());
            a = -1022;
        }
        return a;
    }

    private static TreeMap bX(Context context, String str) {
        Exception e;
        TreeMap treeMap = null;
        byte[] bY = bY(context, str);
        if (bY == null) {
            return null;
        }
        Key secretKeySpec;
        Cipher instance;
        ObjectInputStream objectInputStream;
        TreeMap treeMap2;
        byte[] iY;
        Key secretKeySpec2;
        Cipher instance2;
        try {
            secretKeySpec = new SecretKeySpec(i.AFO, "DESede");
            instance = Cipher.getInstance("DESede");
            instance.init(2, secretKeySpec);
            objectInputStream = new ObjectInputStream(new CipherInputStream(new ByteArrayInputStream(bY), instance));
            treeMap2 = (TreeMap) objectInputStream.readObject();
            if (treeMap2 != null) {
                try {
                    objectInputStream.close();
                    return treeMap2;
                } catch (Exception e2) {
                    Exception exception = e2;
                    treeMap = treeMap2;
                    e = exception;
                }
            } else {
                treeMap = treeMap2;
                try {
                    iY = util.iY(context);
                    if (iY != null && iY.length > 0) {
                        secretKeySpec2 = new SecretKeySpec(iY, "DESede");
                        instance2 = Cipher.getInstance("DESede");
                        instance2.init(2, secretKeySpec2);
                        objectInputStream = new ObjectInputStream(new CipherInputStream(new ByteArrayInputStream(bY), instance2));
                        treeMap2 = (TreeMap) objectInputStream.readObject();
                        if (treeMap2 != null) {
                            try {
                                objectInputStream.close();
                                return treeMap2;
                            } catch (Exception e3) {
                            }
                        }
                        treeMap = treeMap2;
                    }
                } catch (Exception e4) {
                    treeMap2 = treeMap;
                }
                try {
                    iY = util.iX(context);
                    if (iY != null && iY.length > 0) {
                        secretKeySpec2 = new SecretKeySpec(oicq.wlogin_sdk.tools.c.cf(iY), "DESede");
                        instance2 = Cipher.getInstance("DESede");
                        instance2.init(2, secretKeySpec2);
                        objectInputStream = new ObjectInputStream(new CipherInputStream(new ByteArrayInputStream(bY), instance2));
                        treeMap2 = (TreeMap) objectInputStream.readObject();
                        if (treeMap2 != null) {
                            try {
                                objectInputStream.close();
                                return treeMap2;
                            } catch (Exception e5) {
                            }
                        }
                        treeMap = treeMap2;
                    }
                } catch (Exception e6) {
                    treeMap2 = treeMap;
                }
                try {
                    iY = util.iW(context);
                    if (iY != null && iY.length > 0) {
                        secretKeySpec2 = new SecretKeySpec(oicq.wlogin_sdk.tools.c.cf(iY), "DESede");
                        instance2 = Cipher.getInstance("DESede");
                        instance2.init(2, secretKeySpec2);
                        objectInputStream = new ObjectInputStream(new CipherInputStream(new ByteArrayInputStream(bY), instance2));
                        treeMap2 = (TreeMap) objectInputStream.readObject();
                        if (treeMap2 != null) {
                            try {
                                objectInputStream.close();
                                return treeMap2;
                            } catch (Exception e7) {
                            }
                        }
                        treeMap = treeMap2;
                    }
                } catch (Exception e8) {
                    treeMap2 = treeMap;
                }
                try {
                    secretKeySpec = new SecretKeySpec(new String("%4;7t>;28<fc.5*6").getBytes(), "DESede");
                    instance = Cipher.getInstance("DESede");
                    instance.init(2, secretKeySpec);
                    objectInputStream = new ObjectInputStream(new CipherInputStream(new ByteArrayInputStream(bY), instance));
                    treeMap2 = (TreeMap) objectInputStream.readObject();
                    if (treeMap2 != null) {
                        return treeMap2;
                    }
                    try {
                        objectInputStream.close();
                        return treeMap2;
                    } catch (Exception e9) {
                        return treeMap2;
                    }
                } catch (Exception e10) {
                    return treeMap;
                }
            }
        } catch (Exception e11) {
            e = e11;
            Writer stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter, true);
            e.printStackTrace(printWriter);
            printWriter.flush();
            stringWriter.flush();
            util.gq("exception", stringWriter.toString());
            iY = util.iY(context);
            secretKeySpec2 = new SecretKeySpec(iY, "DESede");
            instance2 = Cipher.getInstance("DESede");
            instance2.init(2, secretKeySpec2);
            objectInputStream = new ObjectInputStream(new CipherInputStream(new ByteArrayInputStream(bY), instance2));
            treeMap2 = (TreeMap) objectInputStream.readObject();
            if (treeMap2 != null) {
                objectInputStream.close();
                return treeMap2;
            }
            treeMap = treeMap2;
            iY = util.iX(context);
            secretKeySpec2 = new SecretKeySpec(oicq.wlogin_sdk.tools.c.cf(iY), "DESede");
            instance2 = Cipher.getInstance("DESede");
            instance2.init(2, secretKeySpec2);
            objectInputStream = new ObjectInputStream(new CipherInputStream(new ByteArrayInputStream(bY), instance2));
            treeMap2 = (TreeMap) objectInputStream.readObject();
            if (treeMap2 != null) {
                objectInputStream.close();
                return treeMap2;
            }
            treeMap = treeMap2;
            iY = util.iW(context);
            secretKeySpec2 = new SecretKeySpec(oicq.wlogin_sdk.tools.c.cf(iY), "DESede");
            instance2 = Cipher.getInstance("DESede");
            instance2.init(2, secretKeySpec2);
            objectInputStream = new ObjectInputStream(new CipherInputStream(new ByteArrayInputStream(bY), instance2));
            treeMap2 = (TreeMap) objectInputStream.readObject();
            if (treeMap2 != null) {
                objectInputStream.close();
                return treeMap2;
            }
            treeMap = treeMap2;
            secretKeySpec = new SecretKeySpec(new String("%4;7t>;28<fc.5*6").getBytes(), "DESede");
            instance = Cipher.getInstance("DESede");
            instance.init(2, secretKeySpec);
            objectInputStream = new ObjectInputStream(new CipherInputStream(new ByteArrayInputStream(bY), instance));
            treeMap2 = (TreeMap) objectInputStream.readObject();
            if (treeMap2 != null) {
                return treeMap2;
            }
            objectInputStream.close();
            return treeMap2;
        }
    }

    private static int a(Context context, String str, byte[] bArr) {
        Exception e;
        a aVar = null;
        try {
            a aVar2 = new a(context, str);
            try {
                SQLiteDatabase writableDatabase = aVar2.getWritableDatabase();
                try {
                    writableDatabase.execSQL("CREATE TABLE IF NOT EXISTS " + str + " (ID INTEGER PRIMARY KEY, " + str + " BLOB);");
                    try {
                        String str2 = str;
                        Cursor query = writableDatabase.query(str2, new String[]{"ID"}, "ID=0", null, null, null, null);
                        if (query.getCount() == 0) {
                            try {
                                writableDatabase.execSQL("insert into " + str + " (ID, " + str + ") values (?,?);", new Object[]{Integer.valueOf(0), new byte[1]});
                            } catch (Exception e2) {
                                util.j(e2);
                                query.close();
                                aVar2.close();
                                return -1022;
                            }
                        }
                        try {
                            writableDatabase.execSQL("update " + str + " set " + str + " =? where ID=0", new Object[]{bArr});
                            query.close();
                            aVar2.close();
                            return 0;
                        } catch (Exception e22) {
                            util.j(e22);
                            query.close();
                            aVar2.close();
                            return -1022;
                        }
                    } catch (Exception e222) {
                        util.j(e222);
                        aVar2.close();
                        return -1022;
                    }
                } catch (Exception e2222) {
                    util.j(e2222);
                    aVar2.close();
                    return -1022;
                }
            } catch (Exception e3) {
                e2222 = e3;
                aVar = aVar2;
            }
        } catch (Exception e4) {
            e2222 = e4;
            util.j(e2222);
            if (aVar != null) {
                aVar.close();
            }
            return -1022;
        }
    }

    private static byte[] bY(Context context, String str) {
        Exception e;
        a aVar;
        Boolean valueOf = Boolean.valueOf(false);
        try {
            a aVar2 = new a(context, str);
            try {
                SQLiteDatabase readableDatabase = aVar2.getReadableDatabase();
                Cursor query;
                try {
                    Cursor rawQuery = readableDatabase.rawQuery("select count(*) from sqlite_master where type ='table' and name ='" + str + "' ", null);
                    try {
                        if (rawQuery.moveToNext() && rawQuery.getInt(0) > 0) {
                            valueOf = Boolean.valueOf(true);
                        }
                        if (!(rawQuery == null || rawQuery.isClosed())) {
                            rawQuery.close();
                        }
                        if (valueOf.booleanValue()) {
                            String str2 = str;
                            query = readableDatabase.query(str2, new String[]{str}, "ID=0", null, null, null, null);
                            if (query.getCount() == 0) {
                                query.close();
                                aVar2.close();
                                return null;
                            }
                            query.moveToFirst();
                            byte[] blob = query.getBlob(0);
                            query.close();
                            aVar2.close();
                            return blob;
                        }
                        aVar2.close();
                        return null;
                    } catch (SQLException e2) {
                        e = e2;
                        query = rawQuery;
                        util.j(e);
                        if (!(query == null || query.isClosed())) {
                            query.close();
                        }
                        aVar2.close();
                        return null;
                    }
                } catch (SQLException e3) {
                    e = e3;
                    query = null;
                }
            } catch (Exception e4) {
                e = e4;
                aVar = aVar2;
            }
        } catch (Exception e5) {
            e = e5;
            aVar = null;
            util.j(e);
            if (aVar != null) {
                aVar.close();
            }
            return null;
        }
    }
}
