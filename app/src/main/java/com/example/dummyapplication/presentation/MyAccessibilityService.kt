package com.example.dummyapplication.presentation

import android.accessibilityservice.AccessibilityService
import android.accessibilityservice.AccessibilityServiceInfo
import android.content.pm.PackageManager
import android.util.Log
import android.view.accessibility.AccessibilityEvent
import android.widget.Toast

class MyAccessibilityService: AccessibilityService() {

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {

        if (event?.eventType == AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED) {
            val packageName = event.packageName?.toString()
            if (packageName == "com.whatsapp") {
                Toast.makeText(this, "WhatsApp Launched.", Toast.LENGTH_SHORT).show()
                Log.d("MyTag","WhatsApp Launched.")
            }
        }

    }

    override fun onInterrupt() {
        TODO("Not yet implemented")
    }


    override fun onServiceConnected() {

        super.onServiceConnected()
        serviceInfo.apply {
            eventTypes = AccessibilityEvent.TYPE_VIEW_CLICKED or AccessibilityEvent.TYPE_VIEW_FOCUSED or AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED

            feedbackType = AccessibilityServiceInfo.FEEDBACK_SPOKEN
            notificationTimeout=100
        }
        this.serviceInfo = serviceInfo

    }

}