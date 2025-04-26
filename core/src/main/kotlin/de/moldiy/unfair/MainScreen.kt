package de.moldiy.unfair

import com.toiletpapertycoon.rx.ecs.RXSystem
import com.toiletpapertycoon.rx.screen.RXScreen

class MainScreen : RXScreen() {

    override fun show() {
//        val gameModel = engine.model as GameModel
        val world = engine.world

        val rxSystem = world.system<RXSystem>()
        rxSystem.createRXCamera()

        rxSystem.setComponent(MainComponent())
    }

    override fun dispose() {
    }

    override fun hide() {
    }

    override fun pause() {
    }

    override fun render(p0: Float) {
    }

    override fun resize(p0: Int, p1: Int) {
    }

    override fun resume() {
    }
}
