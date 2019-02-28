package com.tencent.magicbrush.vulkan;

import com.tencent.magicbrush.a.b;

public class VulkanJniExport {
    public static native boolean isSupportVulkan();

    static {
        b.loadLibrary("mmvulkan");
    }
}
