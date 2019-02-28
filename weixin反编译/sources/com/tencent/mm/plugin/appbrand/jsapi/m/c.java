package com.tencent.mm.plugin.appbrand.jsapi.m;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONException;
import org.json.JSONObject;

public final class c {

    public static class c extends com.tencent.mm.plugin.appbrand.jsapi.f {
        private static final int CTRL_INDEX = -2;
        private static final String NAME = "onTouchStart";
    }

    public static class e extends com.tencent.mm.plugin.appbrand.jsapi.f {
        private static final int CTRL_INDEX = -2;
        private static final String NAME = "onTouchEnd";
    }

    public static class f {
        public int id;
        public float x;
        public float y;

        public f(int i, float f, float f2) {
            this.id = i;
            this.x = f;
            this.y = f2;
        }

        public final void a(int i, float f, float f2) {
            this.id = i;
            this.x = f;
            this.y = f2;
        }

        public final JSONObject sO() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(SlookAirButtonFrequentContactAdapter.ID, this.id);
                jSONObject.put("x", (double) com.tencent.mm.plugin.appbrand.q.f.ab(this.x));
                jSONObject.put("y", (double) com.tencent.mm.plugin.appbrand.q.f.ab(this.y));
            } catch (JSONException e) {
            }
            return jSONObject;
        }

        public final String toString() {
            return sO().toString();
        }
    }

    public static class a extends com.tencent.mm.plugin.appbrand.jsapi.f {
        private static final int CTRL_INDEX = 137;
        private static final String NAME = "onLongPress";
    }

    public static class d extends com.tencent.mm.plugin.appbrand.jsapi.f {
        private static final int CTRL_INDEX = -2;
        private static final String NAME = "onTouchMove";
    }

    public static class b extends com.tencent.mm.plugin.appbrand.jsapi.f {
        private static final int CTRL_INDEX = -2;
        private static final String NAME = "onTouchCancel";
    }

    public static f bI(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return new f(0, (float) iArr[0], (float) iArr[1]);
    }

    public static void a(ViewGroup viewGroup, MotionEvent motionEvent) {
        int pointerId;
        int childCount = viewGroup.getChildCount();
        int actionIndex = motionEvent.getActionIndex();
        if (viewGroup.isMotionEventSplittingEnabled()) {
            pointerId = 1 << motionEvent.getPointerId(actionIndex);
        } else {
            pointerId = -1;
        }
        for (int i = childCount - 1; i >= 0; i--) {
            View childAt = viewGroup.getChildAt(i);
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (((Boolean) j.a(ViewGroup.class, "canViewReceivePointerEvents", viewGroup, new Class[]{View.class}, new Object[]{childAt}, Boolean.valueOf(false))).booleanValue()) {
                if (((Boolean) j.a(ViewGroup.class, "isTransformedTouchPointInView", viewGroup, new Class[]{Float.TYPE, Float.TYPE, View.class, PointF.class}, new Object[]{Float.valueOf(x), Float.valueOf(y), childAt, null}, Boolean.valueOf(false))).booleanValue() && childAt.isDuplicateParentStateEnabled()) {
                    if (childAt == null) {
                        x.v("MicroMsg.ViewMotionHelper", "child is null.");
                    } else {
                        actionIndex = motionEvent.getAction();
                        if (actionIndex == 3) {
                            motionEvent.setAction(3);
                            childAt.dispatchTouchEvent(motionEvent);
                            motionEvent.setAction(actionIndex);
                        } else {
                            int intValue = ((Integer) j.a(MotionEvent.class, "getPointerIdBits", motionEvent, new Class[0], new Object[0], Integer.valueOf(0))).intValue();
                            int i2 = intValue & pointerId;
                            if (i2 == 0) {
                                x.v("MicroMsg.ViewMotionHelper", "newPointerIdBits is 0.");
                            } else {
                                MotionEvent obtain;
                                boolean booleanValue = ((Boolean) j.a(View.class, "hasIdentityMatrix", childAt, new Class[0], new Object[0], Boolean.valueOf(false))).booleanValue();
                                if (i2 != intValue) {
                                    MotionEvent motionEvent2 = (MotionEvent) j.a("split", motionEvent, new Class[]{Integer.class}, new Object[]{Integer.valueOf(i2)}, null);
                                    obtain = motionEvent2 == null ? MotionEvent.obtain(motionEvent) : motionEvent2;
                                } else if (booleanValue) {
                                    float scrollX = (float) (viewGroup.getScrollX() - childAt.getLeft());
                                    float scrollY = (float) (viewGroup.getScrollY() - childAt.getTop());
                                    motionEvent.offsetLocation(scrollX, scrollY);
                                    childAt.dispatchTouchEvent(motionEvent);
                                    motionEvent.offsetLocation(-scrollX, -scrollY);
                                } else {
                                    obtain = MotionEvent.obtain(motionEvent);
                                }
                                obtain.offsetLocation((float) (viewGroup.getScrollX() - childAt.getLeft()), (float) (viewGroup.getScrollY() - childAt.getTop()));
                                if (!booleanValue) {
                                    obtain.transform((Matrix) j.a(View.class, "getInverseMatrix", childAt, new Class[0], new Object[0], null));
                                }
                                childAt.dispatchTouchEvent(obtain);
                                obtain.recycle();
                            }
                        }
                    }
                    if ((childAt instanceof com.tencent.mm.plugin.appbrand.jsapi.base.e) && ((com.tencent.mm.plugin.appbrand.jsapi.base.e) childAt).age()) {
                        return;
                    }
                }
            }
        }
    }
}
