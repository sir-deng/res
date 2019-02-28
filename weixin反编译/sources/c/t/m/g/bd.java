package c.t.m.g;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class bd {
    private a a;

    class a extends SQLiteOpenHelper {
        public a(Context context, String str) {
            super(context, str, null, 1);
        }

        private void a() {
            Throwable th;
            try {
                List arrayList = new ArrayList();
                int a = v.a("apn_cache_num", 1, 100, 8);
                SQLiteDatabase writableDatabase = getWritableDatabase();
                Cursor query;
                try {
                    query = writableDatabase.query("halley_schedule_tbl", new String[]{"apn"}, null, null, null, null, "key");
                    if (query != null) {
                        try {
                            int count = query.getCount() - a;
                            if (count > 0 && query.moveToFirst()) {
                                while (true) {
                                    CharSequence string = query.getString(query.getColumnIndex("apn"));
                                    if (!(TextUtils.isEmpty(string) || arrayList.contains(string))) {
                                        arrayList.add(string);
                                    }
                                    if (!query.moveToNext()) {
                                        break;
                                    }
                                    int i = count - 1;
                                    if (count <= 0) {
                                        break;
                                    }
                                    count = i;
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (query != null) {
                                query.close();
                            }
                            throw th;
                        }
                    }
                    if (query != null) {
                        query.close();
                    }
                    if (arrayList.size() > 0) {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            writableDatabase.delete("halley_schedule_tbl", "apn=?", new String[]{(String) it.next()});
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    query = null;
                }
            } catch (Exception e) {
            }
        }

        public final synchronized void a(String str, byte[] bArr) {
            try {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                int delete = writableDatabase.delete("halley_schedule_tbl", "apn=?", new String[]{str});
                ContentValues contentValues = new ContentValues();
                contentValues.put("apn", str);
                contentValues.put("result", bArr);
                contentValues.put("timestamp", Long.valueOf(System.currentTimeMillis()));
                if (-1 != writableDatabase.insert("halley_schedule_tbl", null, contentValues) && delete <= 0) {
                    a();
                }
            } catch (Throwable th) {
            }
        }

        public final synchronized byte[] a(String str) {
            byte[] blob;
            Throwable th;
            try {
                Cursor query;
                try {
                    query = getReadableDatabase().query("halley_schedule_tbl", null, "apn=?", new String[]{str}, null, null, null);
                    if (query != null) {
                        try {
                            if (query.moveToFirst()) {
                                blob = query.getBlob(query.getColumnIndex("result"));
                                if (!cg.a(blob)) {
                                    if (query != null) {
                                        query.close();
                                    }
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (query != null) {
                                query.close();
                            }
                            throw th;
                        }
                    }
                    if (query != null) {
                        query.close();
                    }
                    blob = null;
                } catch (Throwable th3) {
                    th = th3;
                    query = null;
                }
            } catch (Throwable th4) {
            }
            return blob;
        }

        public final void onCreate(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS halley_schedule_tbl (key INTEGER PRIMARY KEY AUTOINCREMENT,apn TEXT,result BLOB,timestamp INTEGER);");
            } catch (Exception e) {
            }
        }

        public final void onOpen(SQLiteDatabase sQLiteDatabase) {
            super.onOpen(sQLiteDatabase);
            try {
                int version = sQLiteDatabase.getVersion();
                if (version == 0) {
                    return;
                }
                if (version <= 0) {
                    onUpgrade(sQLiteDatabase, version, 1);
                } else if (version > 1) {
                    onDowngrade(sQLiteDatabase, version, 1);
                }
            } catch (Exception e) {
            }
        }

        public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            try {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS halley_schedule_tbl");
            } catch (SQLException e) {
            }
            try {
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS halley_schedule_tbl (key INTEGER PRIMARY KEY AUTOINCREMENT,apn TEXT,result BLOB,timestamp INTEGER);");
            } catch (SQLException e2) {
                throw e2;
            } catch (Exception e3) {
            }
        }

        public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            try {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS halley_schedule_tbl");
            } catch (SQLException e) {
            }
            try {
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS halley_schedule_tbl (key INTEGER PRIMARY KEY AUTOINCREMENT,apn TEXT,result BLOB,timestamp INTEGER);");
            } catch (SQLException e2) {
                throw e2;
            } catch (Exception e3) {
            }
        }
    }

    public bd(String str) {
        this.a = new a(m.a(), "halley_schedule_" + m.b() + "_" + m.h() + "_" + str + ".db");
    }

    public final synchronized void a(String str, byte[] bArr) {
        if (!(TextUtils.isEmpty(str) || bArr == null)) {
            this.a.a(str, bArr);
        }
    }

    public final synchronized byte[] a(String str) {
        return this.a.a(str);
    }
}
