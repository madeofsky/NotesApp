package com.lukita.notesapp.utils

import android.content.Context
import android.content.Intent
import android.os.Bundle
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