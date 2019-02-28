package com.tencent.mm.plugin.mmsight.model;

import android.graphics.Point;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public final class g {

    private static class a implements Comparator<Size> {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            Size size = (Size) obj;
            Size size2 = (Size) obj2;
            int i = size.height * size.width;
            int i2 = size2.height * size2.width;
            if (i2 < i) {
                return -1;
            }
            return i2 > i ? 1 : 0;
        }
    }

    public static class b {
        public Point oyr;
        public Point oys;
        public Point oyt;
        public Point oyu;
        public Point oyv;
        public Point oyw;

        public final String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            if (this.oyr != null) {
                stringBuffer.append(this.oyr.toString() + ",");
            }
            if (this.oys != null) {
                stringBuffer.append(this.oys.toString() + ",");
            }
            if (this.oyt != null) {
                stringBuffer.append(this.oyt.toString() + ",");
            }
            if (this.oyu != null) {
                stringBuffer.append(this.oyu.toString() + ",");
            }
            if (this.oyv != null) {
                stringBuffer.append(this.oyv.toString() + ",");
            }
            if (this.oyw != null) {
                stringBuffer.append(this.oyw.toString() + ",");
            }
            return stringBuffer.toString();
        }
    }

    public static b a(Parameters parameters, Point point, int i, boolean z) {
        return b(parameters, point, i, z);
    }

    public static b b(Parameters parameters, Point point, int i, boolean z) {
        int i2;
        ArrayList arrayList = new ArrayList(parameters.getSupportedPreviewSizes());
        Collections.sort(arrayList, new a());
        ArrayList arrayList2 = new ArrayList(parameters.getSupportedPictureSizes());
        x.i("MicroMsg.MMSightCameraInfo", "supportedPreviewSizes: %s", d.bj(arrayList));
        float f = ((float) point.x) / ((float) point.y);
        x.i("MicroMsg.MMSightCameraInfo", "screen.x: %d, screen.y: %d, ratio: %f, upperBoundPrewView: %s lowerBoundPreView: %s", Integer.valueOf(point.x), Integer.valueOf(point.y), Float.valueOf(f), Integer.valueOf(i), Integer.valueOf(0));
        long eZ = bi.eZ(ad.getContext());
        x.d("MicroMsg.MMSightCameraInfo", "systemAvailableMemInMB: %d", Long.valueOf(eZ));
        b bVar = new b();
        bVar.oyr = a(arrayList, point, z, i);
        if (bVar.oyr != null) {
            bVar.oys = d.a(point, bVar.oyr, z);
            bVar.oyt = d.a(point, bVar.oyr, z, true);
            i2 = 0;
        } else {
            Point point2 = new Point();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Size size = (Size) it.next();
                point2.x = size.width;
                point2.y = size.height;
                if (point2.x == point2.y) {
                    x.i("MicroMsg.MMSightCameraInfo", "exclude square curSize: %s", point2);
                } else {
                    Point a = d.a(point, point2, z);
                    if (a == null) {
                        x.i("MicroMsg.MMSightCameraInfo", "curSize: %s, can not find crop size", point2);
                    } else {
                        x.i("MicroMsg.MMSightCameraInfo", "preViewPoint: %s --> bestSize %s ", point2, a);
                        bVar.oyv = new Point(a.x, a.y);
                        bVar.oyu = new Point(point2.x, point2.y);
                        bVar.oyw = d.a(point, point2, z, true);
                        if (Math.min(a.x, a.y) <= i) {
                            if (Math.min(a.x, a.y) < 0) {
                                return null;
                            }
                            bVar.oyr = new Point(point2.x, point2.y);
                            bVar.oys = a;
                            bVar.oyt = d.a(point, bVar.oyr, z, true);
                            x.i("MicroMsg.MMSightCameraInfo", "find bestPreviewSize  %s -> %s findcount %d", r5, a, Integer.valueOf(1));
                            i2 = 1;
                        }
                    }
                }
            }
            i2 = 0;
        }
        x.i("MicroMsg.MMSightCameraInfo", "final tryFindBestSize prewViewSize %s cropSize %s findcount %d", bVar.oyr, bVar.oys, Integer.valueOf(i2));
        return bVar;
    }

    public static b c(Parameters parameters, Point point, int i, boolean z) {
        ArrayList arrayList = new ArrayList(parameters.getSupportedPreviewSizes());
        Collections.sort(arrayList, new a());
        ArrayList arrayList2 = new ArrayList(parameters.getSupportedPictureSizes());
        x.i("MicroMsg.MMSightCameraInfo", "supportedPreviewSizes: %s", d.bj(arrayList));
        float f = ((float) point.x) / ((float) point.y);
        x.i("MicroMsg.MMSightCameraInfo", "screen.x: %d, screen.y: %d, ratio: %f, upperBoundPrewView: %s", Integer.valueOf(point.x), Integer.valueOf(point.y), Float.valueOf(f), Integer.valueOf(i));
        long eZ = bi.eZ(ad.getContext());
        x.d("MicroMsg.MMSightCameraInfo", "systemAvailableMemInMB: %d", Long.valueOf(eZ));
        b bVar = new b();
        bVar.oyr = a(arrayList, point, z, i);
        if (bVar.oyr == null) {
            Point point2 = new Point();
            Math.min(point.x, point.y);
            Math.max(point.x, point.y);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Size size = (Size) it.next();
                point2.x = size.width;
                point2.y = size.height;
                if (point2.x != point2.y && Math.min(point2.x, point2.y) <= i && Math.max(point2.x, point2.y) <= MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN && d.b(point, point2, z) != null) {
                    bVar.oyr = null;
                    break;
                }
            }
        } else {
            bVar.oys = d.b(point, bVar.oyr, z);
            bVar.oyt = d.b(point, bVar.oyr, z, true);
        }
        x.i("MicroMsg.MMSightCameraInfo", "final tryFindBestSize prewViewSize %s cropSize %s findcount %d with any way", bVar.oyr, bVar.oys, Integer.valueOf(0));
        return bVar;
    }

    private static Point a(ArrayList<Size> arrayList, Point point, boolean z, int i) {
        int i2 = point.x;
        int i3 = point.y;
        if ((i3 * i) % i2 != 0) {
            return null;
        }
        int i4;
        i2 = (i3 * i) / i2;
        if (z) {
            i4 = i ^ i2;
            i3 = i4 ^ i2;
            i2 = i4 ^ i3;
            i4 = i3;
            i3 = i2;
        } else {
            i3 = i;
            i4 = i2;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Size size = (Size) it.next();
            if (size.width == i3 && size.height == i4) {
                x.i("MicroMsg.MMSightCameraInfo", "findEqualsPrewViewSize FindBestSize %d %d", Integer.valueOf(i3), Integer.valueOf(i4));
                return new Point(i3, i4);
            } else if (Math.min(size.width, size.height) < i) {
                return null;
            }
        }
        return null;
    }
}
