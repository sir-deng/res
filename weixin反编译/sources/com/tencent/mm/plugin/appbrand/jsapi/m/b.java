package com.tencent.mm.plugin.appbrand.jsapi.m;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.plugin.appbrand.jsapi.m.c.f;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;
import org.json.JSONException;
import org.json.JSONObject;

public final class b {

    public static class a implements OnTouchListener {
        private static volatile View jxH;
        private com.tencent.mm.y.u.b gQy;
        private Map<Integer, f> jxI = new HashMap();
        private boolean jxJ;
        private boolean jxK;
        private f jxL;
        private Runnable jxM;
        private int jxN;
        private float jxO;
        private MotionEvent jxP;
        private MotionEvent jxQ;
        private f jxR;
        private f jxS;
        private String mAppId;
        private View mView;

        static /* synthetic */ void a(a aVar, View view, MotionEvent motionEvent) {
            while (true) {
                ViewParent parent = view.getParent();
                if (parent == null || !(parent instanceof ViewGroup)) {
                    view.dispatchTouchEvent(motionEvent);
                } else {
                    ViewGroup viewGroup = (ViewGroup) parent;
                    motionEvent.offsetLocation(-(((float) viewGroup.getScrollX()) - view.getX()), -(((float) viewGroup.getScrollY()) - view.getY()));
                    view = (View) parent;
                }
            }
            view.dispatchTouchEvent(motionEvent);
        }

        public a(p pVar, com.tencent.mm.y.u.b bVar) {
            Assert.assertNotNull(pVar);
            Assert.assertNotNull(bVar);
            this.gQy = bVar;
            this.mAppId = pVar.mAppId;
            this.jxN = pVar.hashCode();
            this.jxO = (float) ViewConfiguration.get(pVar.mContext).getScaledTouchSlop();
            this.jxR = new f();
            this.jxS = new f();
            this.jxM = new Runnable() {
                public final void run() {
                    if (a.this.jxJ) {
                        f bI = c.bI(a.this.mView);
                        if (Math.abs(a.this.jxL.x - bI.x) > 1.0f || Math.abs(a.this.jxL.y - bI.y) > 1.0f) {
                            x.v("MicroMsg.OnTouchListenerImpl", "check long press timeout, but view has moved.");
                            return;
                        } else if (a.this.jxI.size() != 1) {
                            x.v("MicroMsg.OnTouchListenerImpl", "check long press timeout, but more then one point.");
                            return;
                        } else if (Math.abs(a.this.jxR.x - a.this.jxS.x) > a.this.jxO || Math.abs(a.this.jxR.y - a.this.jxS.y) > a.this.jxO) {
                            x.v("MicroMsg.OnTouchListenerImpl", "check long press timeout, but point has moved(%s, %s, %s, %s).", Float.valueOf(a.this.jxR.x), Float.valueOf(a.this.jxS.x), Float.valueOf(a.this.jxR.y), Float.valueOf(a.this.jxS.y));
                            return;
                        } else {
                            x.v("MicroMsg.OnTouchListenerImpl", "check long press timeout, publish event(%s, %s, %s, %s).", Float.valueOf(a.this.jxR.x), Float.valueOf(a.this.jxS.x), Float.valueOf(a.this.jxR.y), Float.valueOf(a.this.jxS.y));
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put(SlookAirButtonFrequentContactAdapter.DATA, a.this.gQy.getString(SlookAirButtonFrequentContactAdapter.DATA, ""));
                                jSONObject.put("touch", a.this.jxR.sO());
                            } catch (JSONException e) {
                            }
                            if (!a.this.gQy.getBoolean("disableScroll", false)) {
                                a.this.jxP = MotionEvent.obtain(a.this.jxQ);
                                a.this.jxP.setAction(0);
                                a.this.gQy.u("fakeDownEvent", true);
                                a.this.mView.getParent().requestDisallowInterceptTouchEvent(true);
                                a.this.mView.setDuplicateParentStateEnabled(false);
                                a.a(a.this, a.this.mView, MotionEvent.obtain(a.this.jxP));
                            }
                            a.this.a(new com.tencent.mm.plugin.appbrand.jsapi.m.c.a(), jSONObject.toString());
                            return;
                        }
                    }
                    x.v("MicroMsg.OnTouchListenerImpl", "check long press timeout, but pressed is false or pointer is null.");
                }
            };
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean onTouch(android.view.View r19, android.view.MotionEvent r20) {
            /*
            r18 = this;
            r2 = jxH;
            if (r2 == 0) goto L_0x0019;
        L_0x0004:
            r2 = jxH;
            r0 = r19;
            r2 = r2.equals(r0);
            if (r2 != 0) goto L_0x0019;
        L_0x000e:
            r2 = "MicroMsg.OnTouchListenerImpl";
            r3 = "onTouch, not current motion view";
            com.tencent.mm.sdk.platformtools.x.v(r2, r3);
            r4 = 0;
        L_0x0018:
            return r4;
        L_0x0019:
            r0 = r20;
            r1 = r18;
            r1.jxQ = r0;
            r7 = r20.getActionMasked();
            r2 = r20.getActionIndex();
            r20.getPointerCount();
            r0 = r20;
            r8 = r0.getPointerId(r2);
            r0 = r20;
            r9 = r0.getX(r2);
            r0 = r20;
            r10 = r0.getY(r2);
            r5 = 0;
            if (r7 == 0) goto L_0x0057;
        L_0x003f:
            r0 = r18;
            r2 = r0.gQy;
            r3 = "isTouching";
            r2 = r2.hD(r3);
            if (r2 != 0) goto L_0x0057;
        L_0x004c:
            r2 = android.support.v4.view.z.ak(r19);
            if (r2 != 0) goto L_0x0057;
        L_0x0052:
            r2 = 3;
            if (r7 == r2) goto L_0x0057;
        L_0x0055:
            r4 = 0;
            goto L_0x0018;
        L_0x0057:
            r0 = r18;
            r2 = r0.gQy;
            r3 = "data";
            r4 = "";
            r11 = r2.getString(r3, r4);
            r0 = r18;
            r2 = r0.gQy;
            r3 = "disableScroll";
            r4 = 0;
            r12 = r2.getBoolean(r3, r4);
            r0 = r18;
            r2 = r0.gQy;
            r3 = "fakeDownEvent";
            r4 = 0;
            r3 = r2.getBoolean(r3, r4);
            r0 = r18;
            r2 = r0.gQy;
            r4 = "onLongClick";
            r6 = 0;
            r2 = r2.getBoolean(r4, r6);
            r0 = r18;
            r4 = r0.gQy;
            r6 = "enableLongClick";
            r13 = 0;
            r4 = r4.getBoolean(r6, r13);
            r0 = r18;
            r0.jxK = r4;
            r0 = r18;
            r4 = r0.jxS;
            r4.a(r8, r9, r10);
            r4 = r12 | r2;
            switch(r7) {
                case 0: goto L_0x00a7;
                case 1: goto L_0x028c;
                case 2: goto L_0x0192;
                case 3: goto L_0x02f3;
                case 4: goto L_0x00a5;
                case 5: goto L_0x0394;
                case 6: goto L_0x02c8;
                default: goto L_0x00a5;
            };
        L_0x00a5:
            goto L_0x0018;
        L_0x00a7:
            r0 = r18;
            r6 = r0.jxP;
            if (r6 == 0) goto L_0x0391;
        L_0x00ad:
            r14 = r20.getDownTime();
            r0 = r18;
            r6 = r0.jxP;
            r16 = r6.getDownTime();
            r6 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1));
            if (r6 == 0) goto L_0x0391;
        L_0x00bd:
            r3 = 0;
            r0 = r18;
            r6 = r0.gQy;
            r13 = "fakeDownEvent";
            r14 = 0;
            r6.u(r13, r14);
            r6 = "MicroMsg.OnTouchListenerImpl";
            r13 = "try to handle fake event failed";
            com.tencent.mm.sdk.platformtools.x.v(r6, r13);
            r6 = r3;
        L_0x00d3:
            if (r12 != 0) goto L_0x00d7;
        L_0x00d5:
            if (r6 == 0) goto L_0x0269;
        L_0x00d7:
            r3 = r19.getParent();
            r12 = 1;
            r3.requestDisallowInterceptTouchEvent(r12);
            r3 = 0;
            r0 = r19;
            r0.setDuplicateParentStateEnabled(r3);
            r3 = "MicroMsg.OnTouchListenerImpl";
            r12 = "onLongClick fake down event.";
            com.tencent.mm.sdk.platformtools.x.i(r3, r12);
        L_0x00ee:
            if (r6 == 0) goto L_0x0271;
        L_0x00f0:
            r3 = 1;
            r2 = 1;
            r0 = r18;
            r4 = r0.gQy;
            r12 = "fakeDownEvent";
            r13 = 0;
            r4.u(r12, r13);
            r0 = r18;
            r4 = r0.gQy;
            r12 = "onLongClick";
            r13 = 1;
            r4.u(r12, r13);
        L_0x0108:
            r0 = r18;
            r4 = r0.gQy;
            r12 = "isTouching";
            r13 = 1;
            r4.u(r12, r13);
            r0 = r18;
            r4 = r0.jxK;
            if (r4 == 0) goto L_0x0137;
        L_0x0119:
            if (r3 != 0) goto L_0x0137;
        L_0x011b:
            r0 = r18;
            r4 = r0.jxI;
            r12 = java.lang.Integer.valueOf(r8);
            r4 = r4.containsKey(r12);
            if (r4 != 0) goto L_0x0137;
        L_0x0129:
            r0 = r18;
            r4 = r0.jxM;
            r12 = android.view.ViewConfiguration.getLongPressTimeout();
            r12 = (long) r12;
            r0 = r19;
            r0.postDelayed(r4, r12);
        L_0x0137:
            r4 = r2;
        L_0x0138:
            r2 = 0;
            r2 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1));
            if (r2 < 0) goto L_0x0286;
        L_0x013d:
            r2 = 0;
            r2 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1));
            if (r2 < 0) goto L_0x0286;
        L_0x0142:
            r2 = r19.getWidth();
            r2 = (float) r2;
            r2 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1));
            if (r2 > 0) goto L_0x0286;
        L_0x014b:
            r2 = r19.getHeight();
            r2 = (float) r2;
            r2 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1));
            if (r2 > 0) goto L_0x0286;
        L_0x0154:
            r2 = 1;
        L_0x0155:
            if (r2 == 0) goto L_0x0018;
        L_0x0157:
            r12 = new com.tencent.mm.plugin.appbrand.jsapi.m.c$f;
            r12.<init>(r8, r9, r10);
            if (r7 != 0) goto L_0x0289;
        L_0x015e:
            if (r3 != 0) goto L_0x0289;
        L_0x0160:
            r2 = 1;
        L_0x0161:
            r0 = r18;
            r1 = r19;
            r0.f(r1, r2);
            r0 = r18;
            r2 = r0.jxI;
            r3 = java.lang.Integer.valueOf(r8);
            r2 = r2.containsKey(r3);
            if (r2 == 0) goto L_0x038e;
        L_0x0176:
            r2 = 1;
        L_0x0177:
            r0 = r18;
            r3 = r0.jxI;
            r5 = java.lang.Integer.valueOf(r8);
            r3.put(r5, r12);
            if (r6 != 0) goto L_0x0018;
        L_0x0184:
            if (r2 != 0) goto L_0x0018;
        L_0x0186:
            r2 = new com.tencent.mm.plugin.appbrand.jsapi.m.c$c;
            r2.<init>();
            r0 = r18;
            r0.a(r12, r2, r11);
            goto L_0x0018;
        L_0x0192:
            r2 = 0;
            r3 = r2;
        L_0x0194:
            r2 = r20.getPointerCount();
            if (r3 >= r2) goto L_0x024c;
        L_0x019a:
            r0 = r20;
            r5 = r0.getX(r3);
            r0 = r20;
            r6 = r0.getY(r3);
            r0 = r20;
            r2 = r0.getPointerId(r3);
            r0 = r18;
            r7 = r0.jxI;
            r2 = java.lang.Integer.valueOf(r2);
            r2 = r7.get(r2);
            r2 = (com.tencent.mm.plugin.appbrand.jsapi.m.c.f) r2;
            if (r2 == 0) goto L_0x0247;
        L_0x01bc:
            r7 = r2.x;
            r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1));
            if (r5 != 0) goto L_0x01c8;
        L_0x01c2:
            r2 = r2.y;
            r2 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1));
            if (r2 == 0) goto L_0x0247;
        L_0x01c8:
            r2 = 1;
        L_0x01c9:
            if (r2 == 0) goto L_0x0018;
        L_0x01cb:
            r0 = r18;
            r2 = r0.jxI;
            r2 = r2.size();
            r3 = 1;
            if (r2 != r3) goto L_0x0216;
        L_0x01d6:
            r0 = r18;
            r2 = r0.jxJ;
            if (r2 == 0) goto L_0x0216;
        L_0x01dc:
            r0 = r18;
            r2 = r0.jxR;
            r2 = r2.x;
            r0 = r18;
            r3 = r0.jxS;
            r3 = r3.x;
            r2 = r2 - r3;
            r2 = java.lang.Math.abs(r2);
            r0 = r18;
            r3 = r0.jxO;
            r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1));
            if (r2 > 0) goto L_0x020e;
        L_0x01f5:
            r0 = r18;
            r2 = r0.jxR;
            r2 = r2.y;
            r0 = r18;
            r3 = r0.jxS;
            r3 = r3.y;
            r2 = r2 - r3;
            r2 = java.lang.Math.abs(r2);
            r0 = r18;
            r3 = r0.jxO;
            r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1));
            if (r2 <= 0) goto L_0x0216;
        L_0x020e:
            r2 = 0;
            r0 = r18;
            r1 = r19;
            r0.f(r1, r2);
        L_0x0216:
            r3 = new org.json.JSONObject;
            r3.<init>();
            r5 = new org.json.JSONArray;
            r5.<init>();
            r2 = "data";
            r3.put(r2, r11);	 Catch:{ JSONException -> 0x038b }
            r2 = "touches";
            r3.put(r2, r5);	 Catch:{ JSONException -> 0x038b }
        L_0x022c:
            r0 = r18;
            r1 = r20;
            r6 = r0.y(r1);
            r2 = r6.length;
            if (r2 <= 0) goto L_0x024f;
        L_0x0237:
            r2 = 0;
        L_0x0238:
            r7 = r6.length;
            if (r2 >= r7) goto L_0x024f;
        L_0x023b:
            r7 = r6[r2];
            r7 = r7.sO();
            r5.put(r7);
            r2 = r2 + 1;
            goto L_0x0238;
        L_0x0247:
            r2 = r3 + 1;
            r3 = r2;
            goto L_0x0194;
        L_0x024c:
            r2 = 0;
            goto L_0x01c9;
        L_0x024f:
            r0 = r18;
            r2 = r0.jxI;
            r2 = r2.size();
            if (r2 == 0) goto L_0x0018;
        L_0x0259:
            r2 = new com.tencent.mm.plugin.appbrand.jsapi.m.c$d;
            r2.<init>();
            r3 = r3.toString();
            r0 = r18;
            r0.a(r2, r3);
            goto L_0x0018;
        L_0x0269:
            r3 = 1;
            r0 = r19;
            r0.setDuplicateParentStateEnabled(r3);
            goto L_0x00ee;
        L_0x0271:
            jxH = r19;
            r3 = com.tencent.mm.plugin.appbrand.jsapi.m.c.bI(r19);
            r0 = r18;
            r0.jxL = r3;
            r0 = r18;
            r3 = r0.jxR;
            r3.a(r8, r9, r10);
            r3 = r2;
            r2 = r4;
            goto L_0x0108;
        L_0x0286:
            r2 = 0;
            goto L_0x0155;
        L_0x0289:
            r2 = 0;
            goto L_0x0161;
        L_0x028c:
            if (r12 != 0) goto L_0x0290;
        L_0x028e:
            if (r2 == 0) goto L_0x02ec;
        L_0x0290:
            r2 = r19.getParent();
            r3 = 0;
            r2.requestDisallowInterceptTouchEvent(r3);
        L_0x0298:
            r2 = 0;
            jxH = r2;
            r0 = r18;
            r2 = r0.gQy;
            r3 = "isTouching";
            r5 = 0;
            r2.u(r3, r5);
            r0 = r18;
            r2 = r0.gQy;
            r3 = "disableScroll-nextState";
            r2 = r2.containsKey(r3);
            if (r2 == 0) goto L_0x02c8;
        L_0x02b3:
            r0 = r18;
            r2 = r0.gQy;
            r3 = "disableScroll";
            r0 = r18;
            r5 = r0.gQy;
            r6 = "disableScroll-nextState";
            r5 = r5.getBoolean(r6, r12);
            r2.u(r3, r5);
        L_0x02c8:
            r0 = r18;
            r2 = r0.jxI;
            r3 = java.lang.Integer.valueOf(r8);
            r2 = r2.remove(r3);
            r2 = (com.tencent.mm.plugin.appbrand.jsapi.m.c.f) r2;
            if (r2 == 0) goto L_0x0018;
        L_0x02d8:
            r3 = 0;
            r0 = r18;
            r1 = r19;
            r0.f(r1, r3);
            r3 = new com.tencent.mm.plugin.appbrand.jsapi.m.c$e;
            r3.<init>();
            r0 = r18;
            r0.a(r2, r3, r11);
            goto L_0x0018;
        L_0x02ec:
            r2 = 0;
            r0 = r19;
            r0.setDuplicateParentStateEnabled(r2);
            goto L_0x0298;
        L_0x02f3:
            r3 = 0;
            jxH = r3;
            r3 = 0;
            r0 = r18;
            r1 = r19;
            r0.f(r1, r3);
            if (r12 != 0) goto L_0x0302;
        L_0x0300:
            if (r2 == 0) goto L_0x036b;
        L_0x0302:
            r2 = r19.getParent();
            r3 = 0;
            r2.requestDisallowInterceptTouchEvent(r3);
        L_0x030a:
            r0 = r18;
            r2 = r0.gQy;
            r3 = "isTouching";
            r5 = 0;
            r2.u(r3, r5);
            r0 = r18;
            r2 = r0.gQy;
            r3 = "disableScroll-nextState";
            r2 = r2.containsKey(r3);
            if (r2 == 0) goto L_0x0337;
        L_0x0322:
            r0 = r18;
            r2 = r0.gQy;
            r3 = "disableScroll";
            r0 = r18;
            r5 = r0.gQy;
            r6 = "disableScroll-nextState";
            r5 = r5.getBoolean(r6, r12);
            r2.u(r3, r5);
        L_0x0337:
            r2 = android.support.v4.view.z.ak(r19);
            if (r2 == 0) goto L_0x0380;
        L_0x033d:
            r3 = new org.json.JSONObject;
            r3.<init>();
            r5 = new org.json.JSONArray;
            r5.<init>();
            r2 = "data";
            r3.put(r2, r11);	 Catch:{ JSONException -> 0x0389 }
            r2 = "touches";
            r3.put(r2, r5);	 Catch:{ JSONException -> 0x0389 }
        L_0x0353:
            r0 = r18;
            r1 = r20;
            r6 = r0.y(r1);
            r2 = 0;
        L_0x035c:
            r7 = r6.length;
            if (r2 >= r7) goto L_0x0372;
        L_0x035f:
            r7 = r6[r2];
            r7 = r7.sO();
            r5.put(r7);
            r2 = r2 + 1;
            goto L_0x035c;
        L_0x036b:
            r2 = 0;
            r0 = r19;
            r0.setDuplicateParentStateEnabled(r2);
            goto L_0x030a;
        L_0x0372:
            r2 = new com.tencent.mm.plugin.appbrand.jsapi.m.c$b;
            r2.<init>();
            r3 = r3.toString();
            r0 = r18;
            r0.a(r2, r3);
        L_0x0380:
            r0 = r18;
            r2 = r0.jxI;
            r2.clear();
            goto L_0x0018;
        L_0x0389:
            r2 = move-exception;
            goto L_0x0353;
        L_0x038b:
            r2 = move-exception;
            goto L_0x022c;
        L_0x038e:
            r2 = r5;
            goto L_0x0177;
        L_0x0391:
            r6 = r3;
            goto L_0x00d3;
        L_0x0394:
            r6 = r3;
            r3 = r2;
            goto L_0x0138;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.m.b.a.onTouch(android.view.View, android.view.MotionEvent):boolean");
        }

        private void f(View view, boolean z) {
            this.mView = view;
            this.jxJ = z;
            if (!z) {
                this.gQy.u("fakeDownEvent", false);
                this.gQy.u("onLongClick", false);
                this.mView.removeCallbacks(this.jxM);
                this.jxR.a(-1, 0.0f, 0.0f);
                this.jxP = null;
            }
        }

        private void a(f fVar, com.tencent.mm.plugin.appbrand.jsapi.f fVar2, String str) {
            if (fVar != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(SlookAirButtonFrequentContactAdapter.DATA, str);
                    jSONObject.put("touch", fVar.sO());
                } catch (JSONException e) {
                }
                a(fVar2, jSONObject.toString());
            }
        }

        private void a(com.tencent.mm.plugin.appbrand.jsapi.f fVar, String str) {
            com.tencent.mm.plugin.appbrand.jsapi.f aA = fVar.aA(this.mAppId, this.jxN);
            aA.mData = str;
            aA.afI();
        }

        private f[] y(MotionEvent motionEvent) {
            int i = 0;
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < motionEvent.getPointerCount(); i2++) {
                f fVar = (f) this.jxI.get(Integer.valueOf(motionEvent.getPointerId(i2)));
                if (fVar != null) {
                    fVar.x = motionEvent.getX(i2);
                    fVar.y = motionEvent.getY(i2);
                    arrayList.add(fVar);
                }
            }
            f[] fVarArr = new f[arrayList.size()];
            while (i < arrayList.size()) {
                fVarArr[i] = (f) arrayList.get(i);
                i++;
            }
            return fVarArr;
        }
    }
}
