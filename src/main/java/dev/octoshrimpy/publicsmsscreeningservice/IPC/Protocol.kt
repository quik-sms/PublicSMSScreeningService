package dev.octoshrimpy.publicsmsscreeningservice.IPC

object Protocol {
    const val VERSION = 1
    const val ACTION = "sms.screening.provider.PublicSMSScreeningService"

    const val SMS_SCREENING = 1
    const val SMS_SCREENING_RESULT = 2

    // request
    const val KEY_NUMBER = "number"
    const val KEY_SMS_CONTENT = "smsContent"
    const val KEY_SIM_SLOT = "simSlot"

    // response
    const val KEY_SHOULD_BLOCK = "shouldBlock"
    const val KEY_REASON = "reason"
}
