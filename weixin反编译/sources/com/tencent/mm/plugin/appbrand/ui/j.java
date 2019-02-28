package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Environment;
import android.view.Display;
import android.view.View;
import android.view.View.OnSystemUiVisibilityChangeListener;
import android.view.Window;
import android.view.WindowManager;
import com.tencent.mm.compatible.g.a;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.u;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.Properties;

public enum j {
    ;
    
    private static Boolean jQM;
    private static final Method jSQ = null;

    public static Drawable c(Context context, int i, int i2) {
        Bitmap decodeResource = a.decodeResource(context.getResources(), i);
        if (decodeResource == null) {
            return null;
        }
        Drawable bitmapDrawable = new BitmapDrawable(context.getResources(), decodeResource);
        bitmapDrawable.setColorFilter(i2, Mode.SRC_ATOP);
        return bitmapDrawable;
    }

    public static void s(View view, int i) {
        if (view != null && view.getVisibility() != i) {
            view.setVisibility(i);
        }
    }

    public static k cg(final Context context) {
        View inflate = View.inflate(context, h.izX, null);
        final k kVar = new k(context, q.k.iEu);
        kVar.setContentView(inflate);
        kVar.setCancelable(true);
        kVar.setCanceledOnTouchOutside(false);
        kVar.setOnCancelListener(new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                if (context instanceof MMActivity) {
                    ((MMActivity) context).finish();
                }
                kVar.setOnCancelListener(null);
            }
        });
        return kVar;
    }

    public static int[] alC() {
        r1 = new int[2];
        Display defaultDisplay = ((WindowManager) ad.getContext().getSystemService("window")).getDefaultDisplay();
        r1[0] = defaultDisplay.getWidth();
        r1[1] = defaultDisplay.getHeight();
        return r1;
    }

    public static void a(Window window) {
        if (window == null || VERSION.SDK_INT < 21) {
            return;
        }
        if ((window.getAttributes().flags & Integer.MIN_VALUE) == 0 || window.getStatusBarColor() != 0) {
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(0);
        }
    }

    public static boolean b(Window window) {
        return a(window, true);
    }

    public static boolean a(Window window, boolean z) {
        if (window == null || window.getDecorView() == null || VERSION.SDK_INT < 23) {
            return false;
        }
        if (com.tencent.mm.compatible.util.h.zq() && alp()) {
            return false;
        }
        View decorView = window.getDecorView();
        int systemUiVisibility = decorView.getSystemUiVisibility();
        if (z) {
            systemUiVisibility |= 8192;
        } else {
            systemUiVisibility &= -8193;
        }
        decorView.setSystemUiVisibility(systemUiVisibility);
        return true;
    }

    public static boolean c(Window window) {
        if (window == null || window.getDecorView() == null || VERSION.SDK_INT < 23 || (window.getDecorView().getSystemUiVisibility() & 8192) == 0) {
            return false;
        }
        return true;
    }

    public static boolean j(Activity activity) {
        try {
            Method method = jSQ;
            if (method != null) {
                method.setAccessible(true);
                return ((Boolean) method.invoke(activity, new Object[0])).booleanValue();
            }
            x.d("MicroMsg.AppBrandUIUtil", "isInMultiWindowMode method null");
            return false;
        } catch (Exception e) {
            x.d("MicroMsg.AppBrandUIUtil", "isInMultiWindowMode, exp %s", e);
        }
    }

    public static Activity ch(Context context) {
        Context context2;
        if (context == null || !(context instanceof ContextWrapper) || (context instanceof Activity)) {
            context2 = context;
        } else {
            context2 = ((ContextWrapper) context).getBaseContext();
        }
        return context2 instanceof Activity ? (Activity) context2 : null;
    }

    public static boolean bK(View view) {
        if (VERSION.SDK_INT < 24) {
            return false;
        }
        if (view == null) {
            return false;
        }
        Context context = view.getContext();
        if ((context instanceof ContextWrapper) && !(context instanceof Activity)) {
            context = ((ContextWrapper) context).getBaseContext();
        }
        return (context instanceof Activity) && j((Activity) context);
    }

    public static int alt() {
        return u.ai(ad.getContext(), com.tencent.mm.bu.a.fromDPToPix(ad.getContext(), 25));
    }

    public static boolean zq() {
        return com.tencent.mm.compatible.util.h.zq();
    }

    public static long uW(String str) {
        return v(str, -1);
    }

    public static int aM(String str, int i) {
        return (int) v(str, Long.valueOf((long) i).longValue());
    }

    private static long v(String str, long j) {
        if (bi.oN(str)) {
            return j;
        }
        if (str.startsWith("#") && str.length() == 4) {
            StringBuilder stringBuilder = new StringBuilder(str);
            stringBuilder.insert(2, str.charAt(1));
            stringBuilder.insert(4, str.charAt(2));
            stringBuilder.insert(6, str.charAt(3));
            str = stringBuilder.toString();
        }
        try {
            return 4294967295L & ((long) Color.parseColor(str));
        } catch (Exception e) {
            x.e("MicroMsg.AppBrandUIUtil", "Failed to parse color: %s", str);
            return j;
        }
    }

    private static boolean alp() {
        Throwable e;
        if (jQM == null) {
            FileInputStream fileInputStream;
            try {
                fileInputStream = new FileInputStream(new File(Environment.getRootDirectory(), "build.prop"));
                try {
                    Properties properties = new Properties();
                    properties.load(fileInputStream);
                    jQM = Boolean.valueOf(properties.getProperty("ro.miui.ui.version.name", "").contains("V8"));
                    try {
                        fileInputStream.close();
                    } catch (Exception e2) {
                    }
                } catch (Exception e3) {
                    e = e3;
                    try {
                        x.printErrStackTrace("MicroMsg.AppBrandUIUtil", e, "** failed to fetch miui prop, assume we are not on miui. **", new Object[0]);
                        jQM = Boolean.valueOf(false);
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception e4) {
                            }
                        }
                        return jQM.booleanValue();
                    } catch (Throwable th) {
                        e = th;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception e5) {
                            }
                        }
                        throw e;
                    }
                }
            } catch (Exception e6) {
                e = e6;
                fileInputStream = null;
                x.printErrStackTrace("MicroMsg.AppBrandUIUtil", e, "** failed to fetch miui prop, assume we are not on miui. **", new Object[0]);
                jQM = Boolean.valueOf(false);
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                return jQM.booleanValue();
            } catch (Throwable th2) {
                e = th2;
                fileInputStream = null;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw e;
            }
        }
        return jQM.booleanValue();
    }

    private static int b(Window window, boolean z) {
        int systemUiVisibility = window.getDecorView().getSystemUiVisibility();
        if (z) {
            systemUiVisibility = (systemUiVisibility | WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) | 256;
            if (VERSION.SDK_INT >= 20) {
                systemUiVisibility = (systemUiVisibility | WXMediaMessage.TITLE_LENGTH_LIMIT) | 2;
            }
            systemUiVisibility |= 4;
            if (VERSION.SDK_INT >= 19) {
                systemUiVisibility |= Downloads.RECV_BUFFER_SIZE;
            }
        } else {
            systemUiVisibility = (systemUiVisibility & -1025) & -257;
            if (VERSION.SDK_INT >= 20) {
                systemUiVisibility = (systemUiVisibility & -513) & -3;
            }
            systemUiVisibility &= -5;
            if (VERSION.SDK_INT >= 19) {
                systemUiVisibility &= -4097;
            }
        }
        x.i("MicroMsg.AppBrandUIUtil", "hy: setting ui visibility: %d", Integer.valueOf(systemUiVisibility));
        return systemUiVisibility;
    }

    public static void c(final Window window, boolean z) {
        if (z) {
            window.getDecorView().setSystemUiVisibility(b(window, true));
            window.getDecorView().setOnSystemUiVisibilityChangeListener(new OnSystemUiVisibilityChangeListener() {
                public final void onSystemUiVisibilityChange(int i) {
                    x.d("MicroMsg.AppBrandUIUtil", "visibility = " + i);
                    if ((i & 4) == 0) {
                        window.getDecorView().setSystemUiVisibility(j.b(window, true));
                    }
                }
            });
            window.addFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            return;
        }
        window.getDecorView().setSystemUiVisibility(b(window, false));
        window.getDecorView().setOnSystemUiVisibilityChangeListener(null);
        window.clearFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
    }
}
