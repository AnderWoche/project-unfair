package de.moldiy.unfair

import com.badlogic.gdx.Application
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator
import com.toiletpapertycoon.generated.systems.FleksSystemLoader
import com.toiletpapertycoon.rx.Engine
import com.toiletpapertycoon.rx.RXGame
import com.toiletpapertycoon.rx.batch.SpriteBatcher
import com.toiletpapertycoon.rx.ecs.render.RenderSystem
import com.toiletpapertycoon.utils.Utils
import de.moldiy.unfair.utils.CustomFontSizeHandler
import ktx.async.KtxAsync

class SpaceExplorer : RXGame() {

    private lateinit var batch: Batch

    override fun create() {
        Utils.initAssetManager()
        KtxAsync.initiate()
        Gdx.app.logLevel = Application.LOG_DEBUG
        FreeTypeFontGenerator.setMaxTextureSize(2048)
        Utils.fontSizeHandler = CustomFontSizeHandler("fonts/OpenSans-Bold.ttf")
        batch = SpriteBatcher()

        super.create()

        setScreen(MainScreen())
    }

    override fun createEngine(): Engine {
        val engine = Engine(Object(), batch) { FleksSystemLoader.getSystems() }
//        engine.renderChain.renderInterceptors.insert(0, tptRenderInterceptor)
//            engine!!.world.system<LabelSystem>().newFontFactor = 15

        val world = engine.world
        world.system<RenderSystem>().debug = false

        return engine
    }

}
