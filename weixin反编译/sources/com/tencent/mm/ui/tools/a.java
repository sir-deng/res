package com.tencent.mm.ui.tools;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.format.DateFormat;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.a.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.u;
import com.tencent.mm.v.a.k;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public final class a {

    /* renamed from: com.tencent.mm.ui.tools.a$1 */
    static class AnonymousClass1 extends AsyncTask<Integer, Integer, Integer> {
        private String filePath;
        final /* synthetic */ Intent kBc;
        final /* synthetic */ int pa;
        private Uri uri;
        final /* synthetic */ Intent val$intent;
        final /* synthetic */ u yAz;
        private ProgressDialog zpP;
        private boolean zpQ;
        final /* synthetic */ String zpR;
        final /* synthetic */ a zpS = null;

        public AnonymousClass1(Intent intent, u uVar, String str, a aVar, Intent intent2, int i) {
            this.kBc = intent;
            this.yAz = uVar;
            this.zpR = str;
            this.val$intent = intent2;
            this.pa = 203;
        }

        protected final /* synthetic */ Object doInBackground(Object[] objArr) {
            return cyu();
        }

        protected final /* synthetic */ void onPostExecute(Object obj) {
            if (!(this.zpQ || bi.oN(this.filePath))) {
                if (this.zpS != null) {
                    this.val$intent.putExtra("CropImage_OutputPath", this.zpS.Mz(this.filePath));
                }
                this.val$intent.putExtra("CropImage_ImgPath", this.filePath);
                this.yAz.startActivityForResult(this.val$intent, this.pa);
            }
            this.zpP.dismiss();
        }

        protected final void onPreExecute() {
            try {
                this.uri = this.kBc.getData();
                this.zpQ = false;
                Context context = this.yAz.getContext();
                this.yAz.getString(k.dGZ);
                this.zpP = h.a(context, this.yAz.getString(k.hah), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AnonymousClass1.this.zpQ = true;
                    }
                });
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.AsyncObtainImage", e, "", new Object[0]);
            }
        }

        private Integer cyu() {
            try {
                if (this.uri != null) {
                    this.filePath = a.v(this.zpR, d.l(this.uri));
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.AsyncObtainImage", e, "", new Object[0]);
            }
            return null;
        }
    }

    public interface a {
        String Mz(String str);
    }

    public static void a(Activity activity, Intent intent, Intent intent2, String str, int i) {
        b(activity, intent, intent2, str, i, null);
    }

    public static void b(Activity activity, Intent intent, Intent intent2, String str, int i, a aVar) {
        if (intent == null || intent.getData() == null) {
            boolean z;
            String str2 = "MicroMsg.AsyncObtainImage";
            String str3 = "param error, %b";
            Object[] objArr = new Object[1];
            if (intent == null) {
                z = true;
            } else {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            x.e(str2, str3, objArr);
        } else if (intent.getData().toString().startsWith("content://com.google.android.gallery3d")) {
            final Intent intent3 = intent;
            final Activity activity2 = activity;
            final String str4 = str;
            final a aVar2 = aVar;
            final Intent intent4 = intent2;
            final int i2 = i;
            new AsyncTask<Integer, Integer, Integer>() {
                private String filePath;
                private Uri uri;
                private ProgressDialog zpP;
                private boolean zpQ;

                protected final /* synthetic */ Object doInBackground(Object[] objArr) {
                    return cyu();
                }

                protected final /* synthetic */ void onPostExecute(Object obj) {
                    if (this.zpQ || bi.oN(this.filePath)) {
                        x.e("MicroMsg.AsyncObtainImage", "onPostExecute error, filePath:%s", this.filePath);
                    } else {
                        if (aVar2 != null) {
                            intent4.putExtra("CropImage_OutputPath", aVar2.Mz(this.filePath));
                        }
                        intent4.putExtra("CropImage_ImgPath", this.filePath);
                        activity2.startActivityForResult(intent4, i2);
                    }
                    this.zpP.dismiss();
                }

                protected final void onPreExecute() {
                    try {
                        this.uri = intent3.getData();
                        this.zpQ = false;
                        Context context = activity2;
                        activity2.getString(k.dGZ);
                        this.zpP = h.a(context, activity2.getString(k.hah), true, new OnCancelListener() {
                            public final void onCancel(DialogInterface dialogInterface) {
                                AnonymousClass2.this.zpQ = true;
                            }
                        });
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.AsyncObtainImage", e, "onPreExecute", new Object[0]);
                    }
                }

                private Integer cyu() {
                    try {
                        if (this.uri != null) {
                            this.filePath = a.v(str4, d.l(this.uri));
                        }
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.AsyncObtainImage", e, "doInBackground", new Object[0]);
                    }
                    return null;
                }
            }.execute(new Integer[]{Integer.valueOf(0)});
        } else {
            String c = c(activity, intent, str);
            x.i("MicroMsg.AsyncObtainImage", "resolvePhotoFromIntent, filePath:%s", c);
            if (!bi.oN(c)) {
                if (aVar != null) {
                    intent2.putExtra("CropImage_OutputPath", aVar.Mz(c));
                }
                intent2.putExtra("CropImage_ImgPath", c);
                activity.startActivityForResult(intent2, i);
            }
        }
    }

    public static String c(Context context, Intent intent, String str) {
        String str2 = null;
        if (context == null || intent == null || str == null) {
            x.e("MicroMsg.AsyncObtainImage", "resolvePhotoFromIntent fail, invalid argument");
        } else {
            Uri parse = Uri.parse(intent.toURI());
            Cursor query = context.getContentResolver().query(parse, null, null, null, null);
            if (query != null && query.getCount() > 0) {
                x.i("MicroMsg.AsyncObtainImage", "resolve photo from cursor");
                try {
                    if (parse.toString().startsWith("content://com.google.android.gallery3d")) {
                        str2 = v(str, d.l(intent.getData()));
                    } else {
                        query.moveToFirst();
                        str2 = query.getString(query.getColumnIndex("_data"));
                        x.i("MicroMsg.AsyncObtainImage", "photo from resolver, path:" + str2);
                    }
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.AsyncObtainImage", e, "resolve photo error.", new Object[0]);
                }
            } else if (intent.getData() != null) {
                String path = intent.getData().getPath();
                if (!new File(path).exists()) {
                    path = null;
                }
                x.i("MicroMsg.AsyncObtainImage", "photo file from data, path:" + path);
                if (path == null) {
                    path = intent.getData().getHost();
                    if (new File(path).exists()) {
                        str2 = path;
                    }
                    x.i("MicroMsg.AsyncObtainImage", "photo file from data, host:" + str2);
                } else {
                    str2 = path;
                }
            } else if (intent.getAction() == null || !intent.getAction().equals("inline-data")) {
                if (query != null) {
                    query.close();
                }
                x.e("MicroMsg.AsyncObtainImage", "resolve photo from intent failed");
            } else {
                str2 = v(str, (Bitmap) intent.getExtras().get(SlookAirButtonFrequentContactAdapter.DATA));
                x.i("MicroMsg.AsyncObtainImage", "resolve photo from action-inline-data:%s", str2);
            }
            if (query != null) {
                query.close();
            }
        }
        return str2;
    }

    public static String v(String str, Bitmap bitmap) {
        try {
            String str2 = str + (g.s(DateFormat.format("yyyy-MM-dd-HH-mm-ss", System.currentTimeMillis()).toString().getBytes()) + ".jpg");
            File file = new File(str2);
            if (!file.exists()) {
                file.createNewFile();
            }
            OutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
            bitmap.compress(CompressFormat.PNG, 100, bufferedOutputStream);
            bufferedOutputStream.close();
            x.i("MicroMsg.AsyncObtainImage", "photo image from data, path:" + str2);
            return str2;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.AsyncObtainImage", e, "saveBmp Error.", new Object[0]);
            return null;
        }
    }
}
