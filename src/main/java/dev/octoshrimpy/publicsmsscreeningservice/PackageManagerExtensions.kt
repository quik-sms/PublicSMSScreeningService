package dev.octoshrimpy.publicsmsscreeningservice

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.content.pm.ResolveInfo
import android.os.Build
import dev.octoshrimpy.publicsmsscreeningservice.IPC.Protocol


@SuppressLint("QueryPermissionsNeeded")
fun PackageManager.queryPublicScreeningProviders(): List<ResolveInfo> {
    val intent = Intent(Protocol.ACTION)
    val services = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        queryIntentServices(intent, PackageManager.ResolveInfoFlags.of(0))
    } else {
        @Suppress("DEPRECATION")
        queryIntentServices(intent, 0)
    }

    return services.filter { it.serviceInfo?.exported == true }
}
