package com.lukita.notesapp.utils

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

fun FragmentManager.addFragment(
    containerViewId: Int,
    fragment: Fragment,
    tag: String? = null
) {
    this.beginTransaction().add(containerViewId, fragment, tag).commit()
}

fun FragmentManager.replaceFragment(
    containerViewId: Int,
    fragment: Fragment,
    tag: String? = null
) {
    this.beginTransaction().replace(containerViewId, fragment, tag).commit()
}

fun Context.startActivity(cls: Class<*>, flag: Int? = null, extras: Bundle? = null) {
    val intent = Intent(this, cls)
    if (flag != null ) intent.addFlags(flag)
    extras?.let { intent.putExtras(it) }
    startActivity(intent)
}

fun Any.showLongToast(message: String? = null, stringRes: Int? = null) {
    when {
        message != null -> Toast.makeText(this as Context, message, Toast.LENGTH_LONG).show()
        stringRes != null -> Toast.makeText(this as Context, stringRes, Toast.LENGTH_LONG).show()
        else -> Log.d("NotesTag", "Make sure to add a message")
    }
}

fun Any.showShortToast(message: String? = null, stringRes: Int? = null) {
    when {
        message != null -> Toast.makeText(this as Context, message, Toast.LENGTH_SHORT).show()
        stringRes != null -> Toast.makeText(this as Context, stringRes, Toast.LENGTH_SHORT).show()
        else -> Log.d("NotesTag", "Make sure to add a message")
    }
}

fun View.onClick(listener: (View) -> Unit) {
    setOnClickListener { v -> listener(v) }
}