import java.io.File

open class FilePath(
    private val parentPath: String
) {
    private var outputPath: String = parentPath + "res/"
    private var toolbarIconName: String = "nav_android.png"
    private var loginIconName: String = "login_IOS.png"
    private var splashIconName: String = "splash.png"
    private var poweredByIconName: String = "inchurch_android.png"
    private var splashBackgroundName: String = "background_android.png"
    private var playStoreIconName: String = "playstore-icon.png"
    private var pushIconName: String = "push.png"
    private var sheetInfoName: String = "planilha.csv"

    init {
        createAllFolders()
    }

    val toolbarIconPath: String
        get() = parentPath + toolbarIconName

    fun getToolbarIconOutputPath(resultFolder: ResultFolder): String {
        return outputPath + resultFolder.path + "ic_logo_toolbar.png"
    }

    val loginIconPath = parentPath + loginIconName

    fun getLoginIconOutputPath(resultFolder: ResultFolder): String {
        return outputPath + resultFolder.path + "ic_logo_app.png"
    }

    val poweredByIconPath = parentPath + poweredByIconName

    fun getPoweredByIconOutputPath(resultFolder: ResultFolder): String {
        return outputPath + resultFolder.path + "ic_powered_by.png"
    }

    val splashBackgroundPath = parentPath + splashBackgroundName

    fun getSplashBackgroundOutputPath(resultFolder: ResultFolder): String {
        return outputPath + resultFolder.path + "bg_splash.png"
    }

    val splashIconPath  = parentPath + splashIconName

    fun getSplashIconOutputPath(resultFolder: ResultFolder): String {
        return outputPath + resultFolder.path + "ic_logo_splash.png"
    }

    val playStoreIconLargePath = parentPath + playStoreIconName

    fun getPlayStoreIconLargeOutputPath(resultFolder: ResultFolder): String {
        return outputPath + resultFolder.path + "ic_onesignal_large_icon_default.png"
    }

    val pushIconPath = parentPath + pushIconName

    fun getPushIconOutputPath(resultFolder: ResultFolder): String {
        return outputPath + resultFolder.path + "ic_stat_onesignal_default.png"
    }

    val sheetInfoPath = parentPath + sheetInfoName


    private fun createAllFolders() {
        var file = File(outputPath + ResultFolder.NO_DPI_FOLDER.path)
        if (!file.exists()) {
            file.mkdirs()
        }

        file = File(outputPath + ResultFolder.MDPI_FOLDER.path)
        if (!file.exists()) {
            file.mkdirs()
        }

        file = File(outputPath + ResultFolder.HDPI_FOLDER.path)
        if (!file.exists()) {
            file.mkdirs()
        }

        file = File(outputPath + ResultFolder.XHDPI_FOLDER.path)
        if (!file.exists()) {
            file.mkdirs()
        }

        file = File(outputPath + ResultFolder.XXHDPI_FOLDER.path)
        if (!file.exists()) {
            file.mkdirs()
        }

        file = File(outputPath + ResultFolder.XXXHDPI_FOLDER.path)
        if (!file.exists()) {
            file.mkdirs()
        }
    }
}