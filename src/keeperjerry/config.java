/*
	Конфигурационный файл настройки ядра
	Переменная "server_class" - это "Main-Class" в файле сервера "MANIFEST.MF"
*/

package keeperjerry;

public class config
{
    public static String OS = null; // Переменная для проверки Windows
    public static String server_start = null; // Переменная для команды запуска
    public static String launcher_name = "Launcher.jar"; // Имя файла лаунчера (полностью с .jar)
    public static String server_name = "Thermos.jar"; // Имя файла сервера (полностью с .jar)
    public static String server_class = "cpw.mods.fml.relauncher.ServerLaunchWrapper"; // Класс сервера

}

