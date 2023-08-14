package com.programalol.usuario.application.config;

import com.programalol.usuario.infraestructure.driver_adapters.nosql_repository.ResultadoDataGatewayImpl;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

@Configuration
public class QuartzConfig {

    @Bean
    public JobDetailFactoryBean jobDetail() {
        JobDetailFactoryBean factory = new JobDetailFactoryBean();
        factory.setJobClass(ResultadoDataGatewayImpl.class);// Define la clase del trabajo a ejecutar
        factory.setDurability(true);// Indica que el trabajo debe ser persistente incluso si no hay disparadores asociados
        return factory;
    }

    @Bean
    public SimpleTriggerFactoryBean trigger(JobDetail job) {
        SimpleTriggerFactoryBean factory = new SimpleTriggerFactoryBean();
        factory.setJobDetail(job); // Asigna el trabajo que se ejecutará cuando el desencadenador se active
        factory.setRepeatInterval(5000);  // Intervalo de repetición en milisegundos (5 segundos)
        factory.setRepeatCount(SimpleTrigger.REPEAT_INDEFINITELY);// Se repite indefinidamente
        return factory;
    }
}
