package mx.com.mxds.gstinv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import mx.com.mxds.gstinv.core.IConsumidorMsgOrdVentaNueva;
import mx.com.mxds.gstinv.core.IGestorInventarios;
import mx.com.mxds.gstinv.messageBroker.rabbitmq.ConsumidorOrdenVenta;

@SpringBootApplication
public class PryM06MicroGstInventariosApplication {

	public static void main(String[] args) {
		SpringApplication.run(PryM06MicroGstInventariosApplication.class, args);
	}
	
	@Bean
	public IConsumidorMsgOrdVentaNueva getConsumidorMensajes(Environment env, IGestorInventarios gestorInventario) {
		IConsumidorMsgOrdVentaNueva consumMessageBroker = new ConsumidorOrdenVenta (
			env.getProperty("mx.gstInventarios.messageBroker.host", "localhost"),
			env.getProperty("mx.gstInventarios.messageBroker.nomColaVtas","colaVentasDefault"),
			env.getProperty("mx.gstInventarios.messageBroker.exchangeVtas","exchangeDefault"),
			gestorInventario
		);
		consumMessageBroker.suscribirseAexchangeConfig();
		consumMessageBroker.consumirMensajes();
		return consumMessageBroker;		
	}

}
