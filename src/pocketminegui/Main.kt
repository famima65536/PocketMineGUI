package pocketminegui

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.stage.Stage

import java.io.File
import java.io.FileInputStream
import java.io.FileNotFoundException
import java.util.MissingResourceException
import java.util.Properties

class Main : Application() {

    @Throws(Exception::class)
    override fun start(primaryStage: Stage) {
        val root = FXMLLoader.load<Parent>(javaClass.getResource("fxml/console.fxml"))
        primaryStage.title = "PocketMineGUI"
        val propertiesFile = File("/_Developments/PocketMineGUI/server.properties")

        var serverName: String? = "";

        try {
            val properties = Properties()
            properties.load(FileInputStream(propertiesFile))
            serverName = properties.getProperty("motd")
        } catch (e: MissingResourceException) {
        } catch (e: FileNotFoundException) {
        }

//        primaryStage.title += "Server: ${serverName}!!"
        primaryStage.scene = Scene(root)
        primaryStage.show()

        primaryStage.minWidth = primaryStage.width
        primaryStage.minHeight = primaryStage.height


    }

    @Throws(Exception::class)
    override fun stop() {
    }

}

fun main(args: Array<String>) {
    Application.launch(*args)
}