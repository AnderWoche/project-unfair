package de.moldiy.unfair

import com.github.quillraven.fleks.IntervalSystem
import com.toiletpapertycoon.scene2d_rx.annotations.AutoLoad

@AutoLoad
class TempSystem : IntervalSystem(enabled = false) {
    override fun onTick() {
    }
}
