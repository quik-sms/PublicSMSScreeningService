package dev.octoshrimpy.publicsmsscreeningservice.IPC

data class SMSScreeningCapability(
    val blocking: BlockingCapability,
    val features: Set<ScreeningFeatures>
) {
    val canBlockWithoutPermission: Boolean
        get() = blocking == BlockingCapability.BLOCK_WITHOUT_PERMISSION
}

enum class BlockingCapability {
    /** Is capable of blocking numbers without permission from the user or calling app **/
    BLOCK_WITHOUT_PERMISSION,
    /** Is capable of blocking numbers with permission from the user or calling app **/
    BLOCK_WITH_PERMISSION,
    /** Is only capable of determining if a number should be blocked,
     * and must forward this to the calling app
     */
    CANT_BLOCK
}

enum class ScreeningFeatures {
    /** Is capable of reading message content to make blocking decision */
    SMS_CONTENT,
    /** Is capable of reading SIM slot **/
    SIM_SLOT
}
