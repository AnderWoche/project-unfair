package de.moldiy.unfair.utils

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator
import com.toiletpapertycoon.utils.fontsizehandler.FontSizeHandler
import java.util.HashMap

class CustomFontSizeHandler(path: String) : FontSizeHandler {

    val fonts: MutableMap<Int, BitmapFont> = HashMap()

    private val generator = FreeTypeFontGenerator(Gdx.files.internal(path))

    val RUSSIAN_CHARACTERS = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗ" +
            "ИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ"
    val VIETNAMESE_CHARACTERS = "ĐđắảặằăấậâạàầẩăắẵẽêệếểễềịỉĩỉốỗôộọợỏờồổởớơựựƯữữừửủựụưùứýỳ́p"

    override fun getSizedBitmapFont(size: Int): BitmapFont {
        val fontSize = if(size < 3) 3 else size // if the fontSize is under 3 the generator crashes

        if (fonts.containsKey(fontSize)) {
            return fonts[fontSize]!!
        }

        val parameter = FreeTypeFontGenerator.FreeTypeFontParameter()

        parameter.size = fontSize
        parameter.characters = RUSSIAN_CHARACTERS + VIETNAMESE_CHARACTERS + FreeTypeFontGenerator.DEFAULT_CHARS
        val font = this.generator.generateFont(parameter)
        font.region.texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear)
        font.color = Color.BLACK
        this.fonts[fontSize] = font
        return font
    }

    override fun generatedFonts(): Int = fonts.size
}
