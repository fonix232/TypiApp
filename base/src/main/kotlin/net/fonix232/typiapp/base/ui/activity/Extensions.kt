package net.fonix232.typiapp.base.ui.activity

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.commitNow
import androidx.navigation.fragment.NavHostFragment

fun <B : ViewDataBinding> AppCompatActivity.bind(@LayoutRes layout: Int): Lazy<B> = lazy {
    (DataBindingUtil.setContentView(this, layout) as B)
}

fun FragmentActivity.setupNavHostFragment(
    fragmentTag: String,
    containerId: Int,
    navGraphId: Int,
    args: Bundle? = null
) {
    // If the Nav Host fragment exists, return it
    (supportFragmentManager.findFragmentByTag(fragmentTag) as NavHostFragment?)?.let { return }

    // Otherwise, create it and return it.
    val navHostFragment = NavHostFragment.create(navGraphId, args)
    supportFragmentManager.commitNow {
        add(containerId, navHostFragment, fragmentTag)
        setPrimaryNavigationFragment(navHostFragment)
    }
}
