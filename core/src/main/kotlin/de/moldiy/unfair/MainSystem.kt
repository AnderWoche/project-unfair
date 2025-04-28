package de.moldiy.unfair

import com.github.quillraven.fleks.Fixed
import com.github.quillraven.fleks.IntervalSystem
import com.toiletpapertycoon.rx.ecs.state.State
import com.toiletpapertycoon.scene2d_rx.annotations.AutoLoad
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@AutoLoad
class MainSystem : IntervalSystem(interval = Fixed(1F)) {

    val money = State(5000L)

    val formater = DateTimeFormatter.ofPattern("HH:mm:ss dd.MM.yyyy")
    val dateState = State(LocalDateTime.of(0, 1, 1, 0, 0, 0))

    // One Month Ingame is One Day in Reallive so a Month has 24 Days
    // One Day Ingame is One Hour in Reallive. 24 Hours in 60 Min. every 2.5min one hour passes
    // One Hour Ingame is 2.5min in Reallive.
    // One Minute Ingame is 24sec in reallive.

    val costPerTilePerMinute = 1
    var tilesOwned = 5 * 5


    var minuteCounter = 0
    override fun onTick() {
        dateState.value = dateState.value.plusSeconds(3)

        minuteCounter++
        if(minuteCounter == 20) {
            minuteCounter = 0

            money.value -= tilesOwned * costPerTilePerMinute

        }


    }
}
