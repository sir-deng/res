package com.tencent.mm.bu;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

public final class a {
    private static float density = -1.0f;
    private static float gPL = 0.0f;
    private static a xjJ = null;
    private static SparseIntArray xjK = new SparseIntArray();

    public interface a {
        int ceG();

        ColorStateList ceH();

        Drawable ceI();

        int ceJ();

        String ceK();
    }

    public static int c(Context context, int i) {
        if (xjJ != null) {
            return xjJ.ceG();
        }
        if (context != null) {
            return context.getResources().getColor(i);
        }
        x.e("MicroMsg.ResourceHelper", "get color, resId %d, but context is null", Integer.valueOf(i));
        return 0;
    }

    public static ColorStateList Z(Context context, int i) {
        if (xjJ != null) {
            return xjJ.ceH();
        }
        if (context != null) {
            return context.getResources().getColorStateList(i);
        }
        x.e("MicroMsg.ResourceHelper", "get color state list, resId %d, but context is null", Integer.valueOf(i));
        return null;
    }

    public static Drawable b(Context context, int i) {
        if (xjJ != null) {
            return xjJ.ceI();
        }
        if (context != null) {
            return context.getResources().getDrawable(i);
        }
        x.e("MicroMsg.ResourceHelper", "get drawable, resId %d, but context is null", Integer.valueOf(i));
        return null;
    }

    public static int aa(Context context, int i) {
        float f = 1.625f;
        float f2 = gPL;
        if (f2 <= 1.625f) {
            f = f2;
        }
        int i2;
        if (xjJ != null) {
            i2 = xjK.get(i, 0);
            if (i2 == 0) {
                i2 = xjJ.ceJ();
                xjK.put(i, i2);
            }
            return (int) (f * ((float) i2));
        } else if (context == null) {
            x.e("MicroMsg.ResourceHelper", "get dimension pixel size, resId %d, but context is null", Integer.valueOf(i));
            return 0;
        } else {
            i2 = xjK.get(i, 0);
            if (i2 == 0) {
                i2 = context.getResources().getDimensionPixelSize(i);
                xjK.put(i, i2);
            }
            return (int) (f * ((float) i2));
        }
    }

    public static int ab(Context context, int i) {
        int i2;
        if (xjJ != null) {
            i2 = xjK.get(i, 0);
            if (i2 != 0) {
                return i2;
            }
            i2 = xjJ.ceJ();
            xjK.put(i, i2);
            return i2;
        } else if (context == null) {
            x.e("MicroMsg.ResourceHelper", "get dimension pixel size, resId %d, but context is null", Integer.valueOf(i));
            return 0;
        } else {
            i2 = xjK.get(i, 0);
            if (i2 != 0) {
                return i2;
            }
            i2 = context.getResources().getDimensionPixelSize(i);
            xjK.put(i, i2);
            return i2;
        }
    }

    public static String ac(Context context, int i) {
        if (xjJ != null) {
            return xjJ.ceK();
        }
        if (context != null) {
            return context.getResources().getString(i);
        }
        x.e("MicroMsg.ResourceHelper", "get string, resId %d, but context is null", Integer.valueOf(i));
        return "";
    }

    public static float getDensity(Context context) {
        if (context == null) {
            context = ad.getContext();
        }
        if (density < 0.0f) {
            density = context.getResources().getDisplayMetrics().density;
        }
        return density;
    }

    public static int fromDPToPix(Context context, int i) {
        return Math.round(getDensity(context) * ((float) i));
    }

    public static int ad(Context context, int i) {
        return Math.round(((float) i) / getDensity(context));
    }

    public static float ev(Context context) {
        if (gPL == 0.0f) {
            if (context == null) {
                gPL = 1.0f;
            } else {
                gPL = context.getSharedPreferences(ad.cgf(), 0).getFloat("text_size_scale_key", 1.0f);
            }
        }
        return gPL;
    }

    public static int ew(Context context) {
        float ev = ev(context);
        if (ev == 0.875f) {
            return 1;
        }
        if (ev == 1.0f) {
            return 2;
        }
        if (ev == 1.125f) {
            return 3;
        }
        if (ev == 1.25f) {
            return 4;
        }
        if (ev == 1.375f) {
            return 5;
        }
        if (ev == 1.625f) {
            return 6;
        }
        if (ev == 1.875f) {
            return 7;
        }
        if (ev == 2.025f) {
            return 8;
        }
        return 2;
    }

    public static float ex(Context context) {
        if (ez(context)) {
            return 1.3f;
        }
        return 1.0f;
    }

    public static float ey(Context context) {
        if (ez(context)) {
            return 1.2f;
        }
        return 1.0f;
    }

    public static void h(Context context, float f) {
        Editor edit = context.getSharedPreferences(ad.cgf(), 0).edit();
        edit.putFloat("text_size_scale_key", f);
        edit.commit();
        gPL = f;
    }

    public static boolean ez(Context context) {
        float ev = ev(context);
        gPL = ev;
        return Float.compare(ev, 1.125f) > 0;
    }

    public static boolean eA(Context context) {
        float ev = ev(context);
        gPL = ev;
        if (ev == 0.875f) {
            return true;
        }
        return false;
    }

    public static int eB(Context context) {
        if (xjJ != null) {
            return 0;
        }
        if (context != null) {
            return context.getResources().getDisplayMetrics().widthPixels;
        }
        x.e("MicroMsg.ResourceHelper", "get widthPixels but context is null");
        return 0;
    }

    public static int eC(Context context) {
        if (xjJ != null) {
            return 0;
        }
        if (context != null) {
            return context.getResources().getDisplayMetrics().heightPixels;
        }
        x.e("MicroMsg.ResourceHelper", "get heightPixels but context is null");
        return 0;
    }
}
