package com.singlepointsol.alertdialog
import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.DialogFragment
class AlertDialogFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Delete files")
        builder.setMessage("Do you want to delete all the files?")
        builder.setPositiveButton("Yes") { dialog, which ->
            Toast.makeText(requireContext(), "Files deleted", Toast.LENGTH_LONG).show()
        }
        builder.setNegativeButton("No") { dialog, which ->
            Toast.makeText(requireContext(), "Files not deleted", Toast.LENGTH_LONG).show()
        }
        return builder.create()
    }
}