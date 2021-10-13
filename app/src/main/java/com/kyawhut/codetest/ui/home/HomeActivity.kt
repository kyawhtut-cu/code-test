package com.kyawhut.codetest.ui.home

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.kyawhut.codetest.R
import com.kyawhut.codetest.base.BaseActivity
import com.kyawhut.codetest.databinding.ActivityHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : BaseActivity<ActivityHomeBinding>() {

    override val layoutID: Int
        get() = R.layout.activity_home

    private val navController: NavController by lazy {
        findNavController(R.id.nav_host_fragment)
    }

    private val navigationChangeListener: NavController.OnDestinationChangedListener by lazy {
        NavController.OnDestinationChangedListener { _, destination, _ ->
            val title = when (destination.id) {
                R.id.sale_fragment -> getString(R.string.sale_fragment_label)
                R.id.detail_fragment -> getString(R.string.detail_fragment_label)
                else -> getString(R.string.app_name)
            }
            vb.toolbar.title = title
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(vb.toolbar)
    }

    override fun onResume() {
        super.onResume()
        navController.addOnDestinationChangedListener(navigationChangeListener)
    }

    override fun onPause() {
        super.onPause()
        navController.removeOnDestinationChangedListener(navigationChangeListener)
    }
}
