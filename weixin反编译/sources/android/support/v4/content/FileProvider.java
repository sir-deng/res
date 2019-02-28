package android.support.v4.content;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.webkit.MimeTypeMap;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class FileProvider extends ContentProvider {
    private static final String[] tv = new String[]{"_display_name", "_size"};
    private static final File tw = new File("/");
    private static HashMap<String, a> tx = new HashMap();
    private a ty;

    interface a {
        File a(Uri uri);
    }

    static class b implements a {
        final HashMap<String, File> tA = new HashMap();
        private final String tz;

        public b(String str) {
            this.tz = str;
        }

        public final File a(Uri uri) {
            String encodedPath = uri.getEncodedPath();
            int indexOf = encodedPath.indexOf(47, 1);
            String decode = Uri.decode(encodedPath.substring(1, indexOf));
            String decode2 = Uri.decode(encodedPath.substring(indexOf + 1));
            File file = (File) this.tA.get(decode);
            if (file == null) {
                throw new IllegalArgumentException("Unable to find configured root for " + uri);
            }
            File file2 = new File(file, decode2);
            try {
                File canonicalFile = file2.getCanonicalFile();
                if (canonicalFile.getPath().startsWith(file.getPath())) {
                    return canonicalFile;
                }
                throw new SecurityException("Resolved path jumped beyond configured root");
            } catch (IOException e) {
                throw new IllegalArgumentException("Failed to resolve canonical path for " + file2);
            }
        }
    }

    public boolean onCreate() {
        return true;
    }

    public void attachInfo(Context context, ProviderInfo providerInfo) {
        super.attachInfo(context, providerInfo);
        if (providerInfo.exported) {
            throw new SecurityException("Provider must not be exported");
        } else if (providerInfo.grantUriPermissions) {
            this.ty = c(context, providerInfo.authority);
        } else {
            throw new SecurityException("Provider must grant uri permissions");
        }
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Object obj;
        File a = this.ty.a(uri);
        if (strArr == null) {
            strArr = tv;
        }
        Object obj2 = new String[strArr.length];
        Object obj3 = new Object[strArr.length];
        int length = strArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3;
            obj = strArr[i];
            if ("_display_name".equals(obj)) {
                obj2[i2] = "_display_name";
                i3 = i2 + 1;
                obj3[i2] = a.getName();
            } else if ("_size".equals(obj)) {
                obj2[i2] = "_size";
                i3 = i2 + 1;
                obj3[i2] = Long.valueOf(a.length());
            } else {
                i3 = i2;
            }
            i++;
            i2 = i3;
        }
        obj = new String[i2];
        System.arraycopy(obj2, 0, obj, 0, i2);
        Object obj4 = new Object[i2];
        System.arraycopy(obj3, 0, obj4, 0, i2);
        Cursor matrixCursor = new MatrixCursor(obj, 1);
        matrixCursor.addRow(obj4);
        return matrixCursor;
    }

    public String getType(Uri uri) {
        File a = this.ty.a(uri);
        int lastIndexOf = a.getName().lastIndexOf(46);
        if (lastIndexOf >= 0) {
            String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(a.getName().substring(lastIndexOf + 1));
            if (mimeTypeFromExtension != null) {
                return mimeTypeFromExtension;
            }
        }
        return "application/octet-stream";
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        throw new UnsupportedOperationException("No external inserts");
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new UnsupportedOperationException("No external updates");
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return this.ty.a(uri).delete() ? 1 : 0;
    }

    public ParcelFileDescriptor openFile(Uri uri, String str) {
        int i;
        File a = this.ty.a(uri);
        if ("r".equals(str)) {
            i = SQLiteDatabase.CREATE_IF_NECESSARY;
        } else if ("w".equals(str) || "wt".equals(str)) {
            i = 738197504;
        } else if ("wa".equals(str)) {
            i = 704643072;
        } else if ("rw".equals(str)) {
            i = 939524096;
        } else if ("rwt".equals(str)) {
            i = 1006632960;
        } else {
            throw new IllegalArgumentException("Invalid mode: " + str);
        }
        return ParcelFileDescriptor.open(a, i);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.support.v4.content.FileProvider.a c(android.content.Context r10, java.lang.String r11) {
        /*
        r2 = 0;
        r9 = 1;
        r3 = tx;
        monitor-enter(r3);
        r0 = tx;	 Catch:{ all -> 0x003e }
        r0 = r0.get(r11);	 Catch:{ all -> 0x003e }
        r0 = (android.support.v4.content.FileProvider.a) r0;	 Catch:{ all -> 0x003e }
        if (r0 != 0) goto L_0x00fb;
    L_0x000f:
        r0 = new android.support.v4.content.FileProvider$b;	 Catch:{ IOException -> 0x0034, XmlPullParserException -> 0x008d }
        r0.<init>(r11);	 Catch:{ IOException -> 0x0034, XmlPullParserException -> 0x008d }
        r1 = r10.getPackageManager();	 Catch:{ IOException -> 0x0034, XmlPullParserException -> 0x008d }
        r4 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
        r1 = r1.resolveContentProvider(r11, r4);	 Catch:{ IOException -> 0x0034, XmlPullParserException -> 0x008d }
        r4 = r10.getPackageManager();	 Catch:{ IOException -> 0x0034, XmlPullParserException -> 0x008d }
        r5 = "android.support.FILE_PROVIDER_PATHS";
        r4 = r1.loadXmlMetaData(r4, r5);	 Catch:{ IOException -> 0x0034, XmlPullParserException -> 0x008d }
        if (r4 != 0) goto L_0x004a;
    L_0x002b:
        r0 = new java.lang.IllegalArgumentException;	 Catch:{ IOException -> 0x0034, XmlPullParserException -> 0x008d }
        r1 = "Missing android.support.FILE_PROVIDER_PATHS meta-data";
        r0.<init>(r1);	 Catch:{ IOException -> 0x0034, XmlPullParserException -> 0x008d }
        throw r0;	 Catch:{ IOException -> 0x0034, XmlPullParserException -> 0x008d }
    L_0x0034:
        r0 = move-exception;
        r1 = new java.lang.IllegalArgumentException;	 Catch:{ all -> 0x003e }
        r2 = "Failed to parse android.support.FILE_PROVIDER_PATHS meta-data";
        r1.<init>(r2, r0);	 Catch:{ all -> 0x003e }
        throw r1;	 Catch:{ all -> 0x003e }
    L_0x003e:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x003e }
        throw r0;
    L_0x0041:
        r1 = r1.getCanonicalFile();	 Catch:{ IOException -> 0x00df, XmlPullParserException -> 0x008d }
        r6 = r0.tA;	 Catch:{ IOException -> 0x0034, XmlPullParserException -> 0x008d }
        r6.put(r5, r1);	 Catch:{ IOException -> 0x0034, XmlPullParserException -> 0x008d }
    L_0x004a:
        r1 = r4.next();	 Catch:{ IOException -> 0x0034, XmlPullParserException -> 0x008d }
        if (r1 == r9) goto L_0x00f6;
    L_0x0050:
        r5 = 2;
        if (r1 != r5) goto L_0x004a;
    L_0x0053:
        r1 = r4.getName();	 Catch:{ IOException -> 0x0034, XmlPullParserException -> 0x008d }
        r5 = 0;
        r6 = "name";
        r5 = r4.getAttributeValue(r5, r6);	 Catch:{ IOException -> 0x0034, XmlPullParserException -> 0x008d }
        r6 = 0;
        r7 = "path";
        r6 = r4.getAttributeValue(r6, r7);	 Catch:{ IOException -> 0x0034, XmlPullParserException -> 0x008d }
        r7 = "root-path";
        r7 = r7.equals(r1);	 Catch:{ IOException -> 0x0034, XmlPullParserException -> 0x008d }
        if (r7 == 0) goto L_0x0097;
    L_0x0070:
        r1 = tw;	 Catch:{ IOException -> 0x0034, XmlPullParserException -> 0x008d }
        r7 = 1;
        r7 = new java.lang.String[r7];	 Catch:{ IOException -> 0x0034, XmlPullParserException -> 0x008d }
        r8 = 0;
        r7[r8] = r6;	 Catch:{ IOException -> 0x0034, XmlPullParserException -> 0x008d }
        r1 = a(r1, r7);	 Catch:{ IOException -> 0x0034, XmlPullParserException -> 0x008d }
    L_0x007c:
        if (r1 == 0) goto L_0x004a;
    L_0x007e:
        r6 = android.text.TextUtils.isEmpty(r5);	 Catch:{ IOException -> 0x0034, XmlPullParserException -> 0x008d }
        if (r6 == 0) goto L_0x0041;
    L_0x0084:
        r0 = new java.lang.IllegalArgumentException;	 Catch:{ IOException -> 0x0034, XmlPullParserException -> 0x008d }
        r1 = "Name must not be empty";
        r0.<init>(r1);	 Catch:{ IOException -> 0x0034, XmlPullParserException -> 0x008d }
        throw r0;	 Catch:{ IOException -> 0x0034, XmlPullParserException -> 0x008d }
    L_0x008d:
        r0 = move-exception;
        r1 = new java.lang.IllegalArgumentException;	 Catch:{ all -> 0x003e }
        r2 = "Failed to parse android.support.FILE_PROVIDER_PATHS meta-data";
        r1.<init>(r2, r0);	 Catch:{ all -> 0x003e }
        throw r1;	 Catch:{ all -> 0x003e }
    L_0x0097:
        r7 = "files-path";
        r7 = r7.equals(r1);	 Catch:{ IOException -> 0x0034, XmlPullParserException -> 0x008d }
        if (r7 == 0) goto L_0x00af;
    L_0x00a0:
        r1 = r10.getFilesDir();	 Catch:{ IOException -> 0x0034, XmlPullParserException -> 0x008d }
        r7 = 1;
        r7 = new java.lang.String[r7];	 Catch:{ IOException -> 0x0034, XmlPullParserException -> 0x008d }
        r8 = 0;
        r7[r8] = r6;	 Catch:{ IOException -> 0x0034, XmlPullParserException -> 0x008d }
        r1 = a(r1, r7);	 Catch:{ IOException -> 0x0034, XmlPullParserException -> 0x008d }
        goto L_0x007c;
    L_0x00af:
        r7 = "cache-path";
        r7 = r7.equals(r1);	 Catch:{ IOException -> 0x0034, XmlPullParserException -> 0x008d }
        if (r7 == 0) goto L_0x00c7;
    L_0x00b8:
        r1 = r10.getCacheDir();	 Catch:{ IOException -> 0x0034, XmlPullParserException -> 0x008d }
        r7 = 1;
        r7 = new java.lang.String[r7];	 Catch:{ IOException -> 0x0034, XmlPullParserException -> 0x008d }
        r8 = 0;
        r7[r8] = r6;	 Catch:{ IOException -> 0x0034, XmlPullParserException -> 0x008d }
        r1 = a(r1, r7);	 Catch:{ IOException -> 0x0034, XmlPullParserException -> 0x008d }
        goto L_0x007c;
    L_0x00c7:
        r7 = "external-path";
        r1 = r7.equals(r1);	 Catch:{ IOException -> 0x0034, XmlPullParserException -> 0x008d }
        if (r1 == 0) goto L_0x00fd;
    L_0x00d0:
        r1 = android.os.Environment.getExternalStorageDirectory();	 Catch:{ IOException -> 0x0034, XmlPullParserException -> 0x008d }
        r7 = 1;
        r7 = new java.lang.String[r7];	 Catch:{ IOException -> 0x0034, XmlPullParserException -> 0x008d }
        r8 = 0;
        r7[r8] = r6;	 Catch:{ IOException -> 0x0034, XmlPullParserException -> 0x008d }
        r1 = a(r1, r7);	 Catch:{ IOException -> 0x0034, XmlPullParserException -> 0x008d }
        goto L_0x007c;
    L_0x00df:
        r0 = move-exception;
        r2 = new java.lang.IllegalArgumentException;	 Catch:{ IOException -> 0x0034, XmlPullParserException -> 0x008d }
        r4 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0034, XmlPullParserException -> 0x008d }
        r5 = "Failed to resolve canonical path for ";
        r4.<init>(r5);	 Catch:{ IOException -> 0x0034, XmlPullParserException -> 0x008d }
        r1 = r4.append(r1);	 Catch:{ IOException -> 0x0034, XmlPullParserException -> 0x008d }
        r1 = r1.toString();	 Catch:{ IOException -> 0x0034, XmlPullParserException -> 0x008d }
        r2.<init>(r1, r0);	 Catch:{ IOException -> 0x0034, XmlPullParserException -> 0x008d }
        throw r2;	 Catch:{ IOException -> 0x0034, XmlPullParserException -> 0x008d }
    L_0x00f6:
        r1 = tx;	 Catch:{ all -> 0x003e }
        r1.put(r11, r0);	 Catch:{ all -> 0x003e }
    L_0x00fb:
        monitor-exit(r3);	 Catch:{ all -> 0x003e }
        return r0;
    L_0x00fd:
        r1 = r2;
        goto L_0x007c;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.content.FileProvider.c(android.content.Context, java.lang.String):android.support.v4.content.FileProvider$a");
    }

    private static File a(File file, String... strArr) {
        int i = 0;
        File file2 = file;
        while (i <= 0) {
            File file3;
            String str = strArr[0];
            if (str != null) {
                file3 = new File(file2, str);
            } else {
                file3 = file2;
            }
            i++;
            file2 = file3;
        }
        return file2;
    }
}
