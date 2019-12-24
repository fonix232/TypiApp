package net.fonix232.typiapp.base.ui.activity

import android.graphics.Color
import android.os.Bundle
import androidx.annotation.NavigationRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import net.fonix232.typiapp.base.R
import net.fonix232.typiapp.base.databinding.ActivityBinding
import org.koin.androidx.fragment.android.setupKoinFragmentFactory

abstract class BaseActivity(
    @NavigationRes private val navRes: Int,
    private val args: Bundle? = null
) : AppCompatActivity() {

    open val binding: ActivityBinding by bind(R.layout.activity)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.navHost.setBackgroundColor(Color.WHITE)
        setupKoinFragmentFactory()
        setupNavHostFragment("main", R.id.nav_host, navRes)
    }
}
