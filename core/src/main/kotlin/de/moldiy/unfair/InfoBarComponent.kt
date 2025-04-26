package de.moldiy.unfair

import com.badlogic.gdx.graphics.Color
import com.github.quillraven.fleks.Entity
import com.toiletpapertycoon.rx.ecs.css.CssProperties
import com.toiletpapertycoon.rx.ecs.css.fit
import com.toiletpapertycoon.rx.rx.RXComponent

class InfoBarComponent : RXComponent() {



    override fun Entity.render() {
        div {
            css {
                mobile {
                    display = CssProperties.Display.Fixed
                    width = fit
                    height = 50
                    marginBottom = fit

                    backgroundColor = Color.LIGHT_GRAY
                }
            }
        }
    }
}
