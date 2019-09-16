package com.newgeneration.kedditbysteps.commons

import androidx.fragment.app.Fragment
import io.reactivex.disposables.CompositeDisposable

open class RxBaseFragment : Fragment() {

    var subscriptions = CompositeDisposable()

    override fun onResume() {
        super.onResume()
        subscriptions = CompositeDisposable()
    }

    override fun onPause() {
        super.onPause()
       /* if(!subscriptions.isUnsubscribed){
            subscriptions.unsubscribe()
        }*/
        subscriptions.clear()
    }
}