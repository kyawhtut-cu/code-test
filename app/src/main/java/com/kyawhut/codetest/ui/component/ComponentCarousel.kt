package com.kyawhut.codetest.ui.component

import android.content.Context
import android.os.CountDownTimer
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.databinding.BindingAdapter
import androidx.viewpager2.widget.ViewPager2
import com.kyawhut.codetest.R
import com.kyawhut.codetest.databinding.ViewCarouselBinding
import com.kyawhut.codetest.rv.adapter.CarouselAdapter

/**
 * @author kyawhtut
 * @date 10/14/21
 */
class ComponentCarousel @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet?,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    companion object {
        private const val DEFAULT_TIMER: Long = 5000L

        @JvmStatic
        @BindingAdapter(
            "carouselItem",
            "carouselChangeListener",
            "carouselItemClickListener",
            requireAll = false
        )
        fun ComponentCarousel.bindCarousel(
            carouselItemList: List<String>?,
            itemChangeListener: ((Int) -> Unit)?,
            clickListener: ((Int, String) -> Unit)?
        ) {
            this.addCarousel(*((carouselItemList ?: listOf()).toTypedArray()))
            itemChangeListener?.let {
                this.setOnCarouselChangeListener(it)
            }
            clickListener?.let {
                this.setOnItemClickListener(it)
            }
        }
    }

    private val vb: ViewCarouselBinding = ViewCarouselBinding.inflate(
        LayoutInflater.from(context),
        this,
        true
    )

    private var onClickListener: ((Int, String) -> Unit)? = null
    private var onCarouselChangeListener: ((Int) -> Unit)? = null
    private var autoSlider: CountDownTimer? = null

    private val adapter: CarouselAdapter by lazy {
        CarouselAdapter { index, item ->
            onClickListener?.invoke(index, item)
        }
    }

    private val pageChangeListener = object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            onCarouselChangeListener?.invoke(position)
        }
    }

    var isEnableAutoSlide: Boolean = false

    private var carouselIndex: Int = 0
        set(value) {
            field = value
            if (value > adapter.itemCount) return
            vb.vpCarousel.setCurrentItem(value, true)
        }

    var currentItem: Int
        get() = vb.vpCarousel.currentItem
        set(value) {
            carouselIndex = value
        }

    var sliderMilli: Long = DEFAULT_TIMER
        set(value) {
            field = value
            autoSlider?.cancel()
            autoSlider = object : CountDownTimer(value, 1000) {
                override fun onFinish() {
                    carouselIndex = if (vb.vpCarousel.currentItem > adapter.itemCount) 0
                    else vb.vpCarousel.currentItem + 1
                    startAutoSlider()
                }

                override fun onTick(millisUntilFinished: Long) {
                }
            }
            startAutoSlider()
        }

    init {
        val a = context.obtainStyledAttributes(
            attrs, R.styleable.ComponentCarousel,
            defStyleAttr,
            0
        )
        try {
            isEnableAutoSlide = a.getBoolean(R.styleable.ComponentCarousel_autoSlide, false)
            sliderMilli = a.getInt(
                R.styleable.ComponentCarousel_sliderMilli, DEFAULT_TIMER.toInt()
            ).toLong()
        } finally {
            a.recycle()
        }
    }

    override fun onFinishInflate() {
        super.onFinishInflate()
        vb.apply {
            carouselAdapter = this@ComponentCarousel.adapter
            executePendingBindings()
        }
    }

    fun setOnItemClickListener(callback: (Int, String) -> Unit) {
        this.onClickListener = callback
    }

    fun setOnCarouselChangeListener(callback: (Int) -> Unit) {
        this.onCarouselChangeListener = callback
    }

    fun addCarousel(imageURL: String) {
        adapter.addItem(imageURL)
        startAutoSlider()
    }

    fun addCarousel(index: Int, imageURL: String) {
        adapter.addItem(index, imageURL)
        startAutoSlider()
    }

    fun addCarousel(vararg imageURL: String) {
        adapter.addAll(imageURL.toList())
        startAutoSlider()
    }

    fun addCarousel(index: Int, vararg imageURL: String) {
        adapter.addAll(index, imageURL.toList())
        startAutoSlider()
    }

    fun clearCarousel() {
        adapter.clear()
        autoSlider?.cancel()
    }

    fun onResume() {
        vb.vpCarousel.registerOnPageChangeCallback(pageChangeListener)
        startAutoSlider()
    }

    fun onPause() {
        vb.vpCarousel.unregisterOnPageChangeCallback(pageChangeListener)
        autoSlider?.cancel()
    }

    private fun startAutoSlider() {
        if (adapter.itemCount == 0 || adapter.itemCount == 1 || !isEnableAutoSlide) return
        autoSlider?.start()
    }
}
