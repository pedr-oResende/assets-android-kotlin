import com.tinify.Tinify
import kotlin.system.exitProcess

private const val API_KEY_0 = "FMzr1VCxGDbNQtG0RY5TR6r5xwscFKGj"
private const val API_KEY_1 = "ffQ3ZrxFLWy8KsghHF7tpDyyGdwjgRC6"
private const val API_KEY_2 = "brrwqgKZ7dpYdKcBhZPxz6CbbtMDTF44"
private const val API_KEY_3 = "r6SNCtgFqlv14F83tMZwxJ4p3qt94sYv"
private const val API_KEY_4 = "9mDx3dg1NKdLH4TNvqcNshvMxtgzzLhn"
private const val API_KEY_5 = "SLtyLV57VFKW7KtVF90hpMqJtxH1hlSc"
private const val API_KEY_6 = "QgpXNtzCjQzNyNhMTL3WdH4SytgTScmy"
private const val API_KEY_7 = "9XJR4VvDSh7Xz51DRBb64JpHxKzSvpSl"
private const val API_KEY_8 = "6v8LYPbBTNnBmzPGXDj1c0vl42r5LQqX"

fun main(args: Array<String>) {
    val assets = mutableListOf<Assets>()
    val quantity = askQuantity()
    val keys = listOf(
        API_KEY_0,
        API_KEY_1,
        API_KEY_2,
        API_KEY_3,
        API_KEY_4,
        API_KEY_5,
        API_KEY_6,
        API_KEY_7,
        API_KEY_8,
    ).shuffled()

    repeat(quantity) {
        val filePath = FilePath(askUserParentPath())
        assets.add(Assets(filePath))
    }

    assets.forEach { asset ->
        Tinify.setKey(keys.first())

        asset.generateAssets()
        if (asset.wasCompleted) {
            println("Finalizado com sucesso")
        } else {
            println("Ocorreu um erro, verifique os assets")
        }
    }
    exitProcess(0)
}

private fun askQuantity(): Int {
    println("Quantos WL's diferentes?")
    val quantity = readln().toInt()
    return quantity
}


private fun askUserParentPath(): String {
    println("Digite o caminho da pasta dos assets")
    var path = readln()
    if (!path.endsWith("/")) {
        path = "$path/"
    }
    return path
}