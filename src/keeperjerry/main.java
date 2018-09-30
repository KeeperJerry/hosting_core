package keeperjerry;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;

public class main
{
    public static String getOsName()
    {
        if(config.OS == null)
        {
            config.OS = System.getProperty("os.name");
        }
        return config.OS;
    }

    public static boolean isWindows()
    {
        return getOsName().startsWith("Windows");
    }

    public static void main(String[] args) throws IOException, InterruptedException
    {
        if(isWindows() == true)
        {
            System.console();
        }

        System.out.println("================================================================================");
        System.out.println("<=- STARTER PROGRAM FOR SERVER SASHOK724-NEW'S | BY KEEPERJERRY v 1.1.0 BETA -=>");
        System.out.println("================================================================================");
		
		// Отладка версии Java
        ProcessBuilder version_java = new ProcessBuilder("java", "-version");
        System.out.println("<=-=-=-=-=-=-=-=-=-=-=-=- [DEBUG]: YOUR JAVA VERSION -=-=-=-=-=-=-=-=-=-=-=-=-=>");
        version_java.redirectErrorStream(true);
        version_java.redirectOutput(Redirect.INHERIT);
        Process java_process = version_java.start();
        java_process.waitFor();
        System.out.println("<=----------------------------------------------------------------------------=>");
		
		// Детект на винду
        if(isWindows() == true)
        {
            System.out.println("> [WARNING]: Detected system: " + getOsName() + " - replace a command for start!");
            config.server_start = config.launcher_name + ";" + config.server_name;
        }
        else
        {
            config.server_start = config.launcher_name + ":" + config.server_name;
        }
		
		// Отладка команды запуска
        System.out.println("> [DEBUG]: Check the start command:");
        System.out.println(">>> java -cp " + config.server_start + " " + config.server_class);

        ProcessBuilder server_work = new ProcessBuilder("java", "-cp", config.server_start, config.server_class, "-nogui"); // Команда запуска сервера
        server_work.redirectErrorStream(true);
        server_work.redirectInput(Redirect.INHERIT);
        server_work.redirectOutput(Redirect.INHERIT);
        server_work.redirectError(Redirect.INHERIT);

        System.out.println();
        System.out.println("================================================================================");
        System.out.println("<=-=-=-=-=-=-=-=-=-=-=-=-=- START LOGGING SERVER -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=>");
        System.out.println("================================================================================");
        System.out.println();
		
		// Запуск процесса сервера
        Process server_process = server_work.start();
        server_process.waitFor();

        System.out.println();
        System.out.println("================================================================================");
        System.out.println("<=-=-=-=-=-=-=-=-=-=-=-=-=- STOP LOGGING SERVER =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=>");
        System.out.println("================================================================================");
    }
}

