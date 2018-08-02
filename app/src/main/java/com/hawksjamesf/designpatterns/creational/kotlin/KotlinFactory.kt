package com.hawksjamesf.designpatterns.creational.kotlin

import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.os.Bundle

/**
 * Copyright ® $ 2017
 * All right reserved.
 *
 * @author: hawks.jamesf
 * @since: Aug/02/2018  Thu
 */

interface ViewModel

//=========================================== abstract factory start
interface KotlinAbstractFactory<T> {
    fun create(): T
}

class AndroidViewModel : ViewModel {
    companion object : KotlinAbstractFactory<ViewModel> {
        override fun create(): ViewModel = AndroidViewModel()
    }

}

class CustomViewModel : ViewModel {
    companion object : KotlinAbstractFactory<ViewModel> {
        override fun create(): ViewModel = CustomViewModel()
    }
}

class Activity {
    fun call() {
        var androidViewModel = AndroidViewModel.Companion.create()
        var customViewModel = CustomViewModel.Companion.create()

    }
}
//=========================================== abstract factory end


//=========================================== abstract factory start
interface KotlinAbstractFactory2 {
    companion object {
        inline fun <reified T : ViewModel> create(): ViewModel = when (T::class) {
            AndroidViewModel2::class -> AndroidViewModel2()
            CustomViewModel2::class -> CustomViewModel2()
            else -> {
                throw IllegalArgumentException()
            }
        }
    }
}

class AndroidViewModel2 : ViewModel

class CustomViewModel2 : ViewModel

class Activity2 {
    fun call() {
        var androidViewModel2 = KotlinAbstractFactory2.create<AndroidViewModel2>()
        var customViewModel2 = KotlinAbstractFactory2.create<CustomViewModel2>()

    }
}

//=========================================== abstract factory end

//=========================================== factory method start
class Fragment {
    private var argument: Bundle? = null

    companion object {
        fun newInstance(bundle: Bundle): Fragment {
            val fragment = Fragment()
            fragment.argument = bundle
            return fragment
        }
    }
}
enum class Enum {
    ONE,
    TOW,
    THREE;
    companion object {
        fun valueOf(value: String): Enum? {
            Enum.values()
                    .filter { it.name == value }
                    .forEach { return it }

            return null
        }
    }
}

class Activity3 {
    fun call() {
        var fragment = Fragment.newInstance(bundle = Bundle())
        var enum = Enum.valueOf("ONE")
    }
}


//=========================================== factory method end


