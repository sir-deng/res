package com.tencent.mm.plugin.appbrand.collector;

import com.tencent.mm.sdk.platformtools.x;

public final class e {
    public static StringBuilder a(TimePoint timePoint) {
        StringBuilder stringBuilder = new StringBuilder();
        if (timePoint == null) {
            x.i("MicroMsg.CostTimeUtil", "print failed, headPoint is null.");
            return stringBuilder;
        }
        stringBuilder.append(0).append(". ").append(timePoint.name).append(" : ");
        stringBuilder.append(timePoint.iOX);
        stringBuilder.append(", ");
        stringBuilder.append(timePoint.iOW.get());
        stringBuilder.append(", ");
        stringBuilder.append(timePoint.iOX.get() - timePoint.iOX.get());
        int i = 0;
        TimePoint timePoint2 = timePoint;
        while (timePoint2.iOY.get() != null) {
            TimePoint timePoint3 = (TimePoint) timePoint2.iOY.get();
            stringBuilder.append("\n");
            stringBuilder.append(i + 1).append(". ").append(timePoint3.name).append(" : ");
            stringBuilder.append(((double) (timePoint3.iOX.get() - timePoint2.iOX.get())) / 1000000.0d);
            i++;
            timePoint2 = timePoint3;
        }
        stringBuilder.append("\n");
        stringBuilder.append("total cost : ").append(((double) (timePoint2.iOX.get() - timePoint.iOX.get())) / 1000000.0d);
        return stringBuilder;
    }
}
