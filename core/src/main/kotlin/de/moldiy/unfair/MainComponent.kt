package de.moldiy.unfair

import com.github.quillraven.fleks.Entity
import com.toiletpapertycoon.rx.rx.RXComponent

class MainComponent : RXComponent() {

    override fun Entity.render() {
        include(InfoBarComponent())
    }
}
