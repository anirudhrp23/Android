package com.singlepointsol.customalertdialog

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class CustomAlertDialog : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(context)
        val inflater = activity?.layoutInflater
        builder.setView(inflater?.inflate(R.layout.custom_alert, null))
        return builder.create()

    }
}
