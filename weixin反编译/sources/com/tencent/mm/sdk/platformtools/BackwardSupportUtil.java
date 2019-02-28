package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.widget.ListView;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.modelsfs.FileOp;
import java.io.InputStream;

public final class BackwardSupportUtil {

    public static class ExifHelper {

        public static class LatLongData implements Parcelable {
            public static final Creator<LatLongData> CREATOR = new Creator<LatLongData>() {
                public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                    LatLongData latLongData = new LatLongData();
                    latLongData.fAo = parcel.readFloat();
                    latLongData.hDw = parcel.readFloat();
                    return latLongData;
                }

                public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                    return new LatLongData[i];
                }
            };
            public float fAo;
            public float hDw;

            public LatLongData() {
                this.fAo = 0.0f;
                this.hDw = 0.0f;
            }

            public LatLongData(float f, float f2) {
                this.fAo = f;
                this.hDw = f2;
            }

            public int hashCode() {
                return ((int) (this.fAo * 10000.0f)) + ((int) (this.hDw * 10000.0f));
            }

            public boolean equals(Object obj) {
                if (!(obj instanceof LatLongData)) {
                    return false;
                }
                LatLongData latLongData = (LatLongData) obj;
                if (Math.abs(this.fAo - latLongData.fAo) >= 1.0E-6f || Math.abs(this.hDw - latLongData.hDw) >= 1.0E-6f) {
                    return false;
                }
                return true;
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeFloat(this.fAo);
                parcel.writeFloat(this.hDw);
            }
        }

        public static int Vo(String str) {
            if (bi.oN(str)) {
                x.d("MicroMsg.SDK.BackwardSupportUtil", "filepath is null or nil");
                return 0;
            } else if (FileOp.bO(str)) {
                return Exif.fromFile(str).getOrientationInDegree();
            } else {
                x.d("MicroMsg.SDK.BackwardSupportUtil", "file not exist:[%s]", str);
                return 0;
            }
        }

        public static LatLongData Vp(String str) {
            if (bi.oN(str)) {
                x.d("MicroMsg.SDK.BackwardSupportUtil", "filepath is null or nil");
                return null;
            } else if (FileOp.bO(str)) {
                com.tencent.mm.compatible.util.Exif.a location = Exif.fromFile(str).getLocation();
                if (location == null) {
                    return null;
                }
                LatLongData latLongData = new LatLongData();
                latLongData.fAo = (float) location.latitude;
                latLongData.hDw = (float) location.longitude;
                return latLongData;
            } else {
                x.d("MicroMsg.SDK.BackwardSupportUtil", "file not exist:[%s]", str);
                return null;
            }
        }
    }

    public static class a {
        public static void c(View view, Animation animation) {
            if (VERSION.SDK_INT >= 8) {
                c cVar = new c();
                animation.cancel();
                return;
            }
            b bVar = new b();
            if (view != null) {
                view.setAnimation(null);
            }
        }
    }

    public static class b {
        public static Bitmap b(String str, float f) {
            float f2 = 160.0f * f;
            Bitmap c = d.c(str, f);
            if (c != null) {
                c.setDensity((int) f2);
            }
            return c;
        }

        public static int b(Context context, float f) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            return Math.round((((float) displayMetrics.densityDpi) * f) / 160.0f);
        }

        public static Bitmap a(InputStream inputStream, float f) {
            float f2 = 160.0f * f;
            Bitmap a = d.a(inputStream, f, 0, 0);
            if (a != null) {
                a.setDensity((int) f2);
            }
            return a;
        }

        public static String eH(Context context) {
            String str;
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            Configuration configuration = context.getResources().getConfiguration();
            String str2 = "";
            if (displayMetrics.density < 1.0f) {
                str = str2 + "LDPI";
            } else if (displayMetrics.density >= 1.5f) {
                str = str2 + "HDPI";
            } else {
                str = str2 + "MDPI";
            }
            return str + (configuration.orientation == 2 ? "_L" : "_P");
        }
    }

    public static class c {
        public static void a(ListView listView) {
            if (listView != null) {
                if (VERSION.SDK_INT >= 8) {
                    bc bcVar = new bc();
                    if (listView.getFirstVisiblePosition() > 10) {
                        listView.setSelection(10);
                    }
                    if (VERSION.SDK_INT >= 8) {
                        listView.smoothScrollToPosition(0);
                        return;
                    }
                    return;
                }
                bb bbVar = new bb();
                listView.setSelection(0);
            }
        }

        public static void b(ListView listView, int i) {
            if (listView != null) {
                if (VERSION.SDK_INT >= 8) {
                    bc bcVar = new bc();
                    int firstVisiblePosition = listView.getFirstVisiblePosition();
                    if (firstVisiblePosition > i && firstVisiblePosition - i > 10) {
                        listView.setSelection(i + 10);
                    } else if (firstVisiblePosition < i && i - firstVisiblePosition > 10) {
                        listView.setSelection(i - 10);
                    }
                    if (VERSION.SDK_INT >= 8) {
                        listView.smoothScrollToPosition(i);
                        return;
                    }
                    return;
                }
                bb bbVar = new bb();
                listView.setSelection(i);
            }
        }
    }
}
