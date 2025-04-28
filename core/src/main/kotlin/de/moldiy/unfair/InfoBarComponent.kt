package de.moldiy.unfair

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.utils.Align
import com.github.quillraven.fleks.Entity
import com.toiletpapertycoon.rx.ecs.css.CssProperties
import com.toiletpapertycoon.rx.ecs.css.fit
import com.toiletpapertycoon.rx.rx.RXComponent

class InfoBarComponent : RXComponent() {


    override fun Entity.render() {
        val mainSystem = world.system<MainSystem>()
        span {
            css {
                mobile {
                    display = CssProperties.Display.Fixed
                    width = fit
                    height = 50
                    marginBottom = fit

                    align = Align.center or Align.left

                    backgroundColor = Color.LIGHT_GRAY
                }
            }

            label {
                val money = bind(mainSystem.money)
                var moneyString = money.toString()
                if(moneyString.length < 4) {
                    val missing = 4 - moneyString.length
                    var missingNumbers = ""
                    for(i in 0 until missing) missingNumbers += "0"
                    moneyString = missingNumbers + moneyString
                }
                val index = moneyString.length - 2
                val part1 = moneyString.substring(0, index)
                val part2 = moneyString.substring(index)

                moneyString = "$part1,$part2 M-Coins"

                setText(moneyString)
                css {
                    mobile {
                        marginLeft = 10
                    }
                }
            }

            div { css { mobile { width = fit } } }

            label {
                val localDate = bind(mainSystem.dateState)
                val formated = mainSystem.formater.format(localDate)
                setText("$formated")
                css {
                    mobile {
                        marginRight = 10
                    }
                }
            }

        }
    }
}
