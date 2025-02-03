package fr.uphf.questease;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication(scanBasePackages = "fr.uphf.questease")
public class QuesteaseApplication implements ApplicationListener<WebServerInitializedEvent> {

	private static Environment environment;

	public static void main(String[] args) throws UnknownHostException {
		var context = SpringApplication.run(QuesteaseApplication.class, args);
		environment = context.getEnvironment();

		String ip = InetAddress.getLocalHost().getHostAddress();
		String port = environment.getProperty("server.port", "8080"); // Par défaut 8080

		System.out.println("\n🚀 Serveur lancé sur : http://" + ip + ":" + port + "\n");
	}

	@Override
	public void onApplicationEvent(WebServerInitializedEvent event) {
		String ip = "127.0.0.1"; // Localhost par défaut
		try {
			ip = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		int port = event.getWebServer().getPort();
		System.out.println("\n🚀 Serveur accessible sur : http://" + ip + ":" + port + "\n");
	}
}


