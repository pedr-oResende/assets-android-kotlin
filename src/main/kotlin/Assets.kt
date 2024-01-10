import com.tinify.Options
import com.tinify.Tinify
import java.io.File

class Assets(var filePath: FilePath) {
    var wasCompleted: Boolean = true

    fun generateAssets() {
        createOptimizedToolbarIcon()
        createOptimizedSplashBackground()
        createOptimizedPoweredByIcon()
        try {
            createAllSplashIconVersions()
            createAllLoginIconVersions()
            createAllPushIconVersions()
            createOneSignalLargeIcon()
        } catch (e: Exception) {
            println(e)
            wasCompleted = false
        }
    }

    protected fun createOptimizedToolbarIcon() {
        createOptimizedAssetFromImage(
            filePath.toolbarIconPath,
            filePath.getToolbarIconOutputPath(ResultFolder.NO_DPI_FOLDER)
        )
    }

    protected fun createOptimizedSplashBackground() {
        createOptimizedAssetFromImage(
            filePath.splashBackgroundPath,
            filePath.getSplashBackgroundOutputPath(ResultFolder.NO_DPI_FOLDER)
        )
    }

    protected fun createOptimizedPoweredByIcon() {
        createOptimizedAssetFromImage(
            filePath.poweredByIconPath,
            filePath.getPoweredByIconOutputPath(ResultFolder.XXXHDPI_FOLDER)
        )
    }

    @Throws(Exception::class)
    protected fun createAllSplashIconVersions() {
        val file = File(filePath.splashIconPath)

        if (file.exists()) {
            val size = 650
            val source = Tinify.fromFile(filePath.splashIconPath)

            val xxxhdpiOptions = Options()
            xxxhdpiOptions.with("method", "scale")
                .with("width", size)
            val xxxhdpiResized = source.resize(xxxhdpiOptions)
            xxxhdpiResized.toFile(filePath.getSplashIconOutputPath(ResultFolder.XXXHDPI_FOLDER))

            val xxhdpiOptions = Options()
            xxhdpiOptions.with("method", "scale")
                .with("width", Math.round((size * 0.75)))
            val xxhdpiResized = source.resize(xxhdpiOptions)
            xxhdpiResized.toFile(filePath.getSplashIconOutputPath(ResultFolder.XXHDPI_FOLDER))

            val xhdpiOptions = Options()
            xhdpiOptions.with("method", "scale")
                .with("width", Math.round(size * 0.5))
            val xhdpiResized = source.resize(xhdpiOptions)
            xhdpiResized.toFile(filePath.getSplashIconOutputPath(ResultFolder.XHDPI_FOLDER))

            val hdpiOptions = Options()
            hdpiOptions.with("method", "scale")
                .with("width", Math.round(size * 0.375))
            val hdpiResized = source.resize(hdpiOptions)
            hdpiResized.toFile(filePath.getSplashIconOutputPath(ResultFolder.HDPI_FOLDER))

            val mdpiOptions = Options()
            mdpiOptions.with("method", "scale")
                .with("width", Math.round(size * 0.25))
            val mdpiResized = source.resize(mdpiOptions)
            mdpiResized.toFile(filePath.getSplashIconOutputPath(ResultFolder.MDPI_FOLDER))

            println("Criei a logo da splash")
        } else {
            println("Não achei a logo da splash")
        }
    }

    @Throws(Exception::class)
    protected fun createAllLoginIconVersions() {
        val file = File(filePath.loginIconPath)
        if (file.exists()) {
            val size = 700
            val source = Tinify.fromFile(filePath.loginIconPath)

            val xxxhdpiOptions = Options()
            xxxhdpiOptions.with("method", "scale")
                .with("width", size)
            val xxxhdpiResized = source.resize(xxxhdpiOptions)
            xxxhdpiResized.toFile(filePath.getLoginIconOutputPath(ResultFolder.XXXHDPI_FOLDER))

            val xxhdpiOptions = Options()
            xxhdpiOptions.with("method", "scale")
                .with("width", Math.round((size * 0.75)))
            val xxhdpiResized = source.resize(xxhdpiOptions)
            xxhdpiResized.toFile(filePath.getLoginIconOutputPath(ResultFolder.XXHDPI_FOLDER))

            val xhdpiOptions = Options()
            xhdpiOptions.with("method", "scale")
                .with("width", Math.round(size * 0.5))
            val xhdpiResized = source.resize(xhdpiOptions)
            xhdpiResized.toFile(filePath.getLoginIconOutputPath(ResultFolder.XHDPI_FOLDER))

            val hdpiOptions = Options()
            hdpiOptions.with("method", "scale")
                .with("width", Math.round(size * 0.375))
            val hdpiResized = source.resize(hdpiOptions)
            hdpiResized.toFile(filePath.getLoginIconOutputPath(ResultFolder.HDPI_FOLDER))

            val mdpiOptions = Options()
            mdpiOptions.with("method", "scale")
                .with("width", Math.round(size * 0.25))
            val mdpiResized = source.resize(mdpiOptions)
            mdpiResized.toFile(filePath.getLoginIconOutputPath(ResultFolder.MDPI_FOLDER))

            println("Criei a logo do login")
        } else {
            println("Não achei a logo do login")
        }
    }

    @Throws(Exception::class)
    protected fun createAllPushIconVersions() {
        val file = File(filePath.pushIconPath)
        if (file.exists()) {
            val size = 96
            val source = Tinify.fromFile(filePath.pushIconPath)
            source.toFile(filePath.getPushIconOutputPath(ResultFolder.XXXHDPI_FOLDER))

            val xxhdpiOptions = Options()
            xxhdpiOptions.with("method", "scale")
                .with("width", Math.round((size * 0.75)))
            val xxhdpiResized = source.resize(xxhdpiOptions)
            xxhdpiResized.toFile(filePath.getPushIconOutputPath(ResultFolder.XXHDPI_FOLDER))

            val xhdpiOptions = Options()
            xhdpiOptions.with("method", "scale")
                .with("width", Math.round(size * 0.5))
            val xhdpiResized = source.resize(xhdpiOptions)
            xhdpiResized.toFile(filePath.getPushIconOutputPath(ResultFolder.XHDPI_FOLDER))

            val hdpiOptions = Options()
            hdpiOptions.with("method", "scale")
                .with("width", Math.round(size * 0.375))
            val hdpiResized = source.resize(hdpiOptions)
            hdpiResized.toFile(filePath.getPushIconOutputPath(ResultFolder.HDPI_FOLDER))

            val mdpiOptions = Options()
            mdpiOptions.with("method", "scale")
                .with("width", Math.round(size * 0.25))
            val mdpiResized = source.resize(mdpiOptions)
            mdpiResized.toFile(filePath.getPushIconOutputPath(ResultFolder.MDPI_FOLDER))

            println("Criei a logo de push")
        } else {
            println("Não achei a logo de push")
        }
    }

    protected fun createOneSignalLargeIcon() {
        createOptimizedAssetFromImage(
            filePath.playStoreIconLargePath,
            filePath.getPlayStoreIconLargeOutputPath(ResultFolder.XXXHDPI_FOLDER)
        )
    }

    protected fun createOptimizedAssetFromImage(inputPath: String, outputPath: String) {
        val file = File(inputPath)
        if (file.exists()) {
            try {
                val source = Tinify.fromFile(inputPath)
                source.toFile(outputPath)
                println("Criei o arquivo: $outputPath")
            } catch (e: Exception) {
                println("Ocorreu um erro ao processar as imagens")
                println(e)
            }
        } else {
            println("Não encontrei o caminho: $inputPath")
        }
    }
}
