/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upraxis.msinaction.config;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;
import java.io.IOException;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.env.Environment;

/**
 *
 * @author Jesse Ballera
 */
@Configuration
public class LogbackConfig implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    Environment environment;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        try {
            configureLogback();
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }

    private void configureLogback() throws IOException {
        LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
        try {
            JoranConfigurator jc = new JoranConfigurator();
            jc.setContext(context);
            context.reset(); // override default configuration
            // inject the name of the current application as "application-name"
            // property of the LoggerContext
            context.putProperty("LOG_DIR", environment.getProperty("logback.log.directory"));
            context.putProperty("LOG_NAME_FILE", environment.getProperty("logback.log.logFileName"));
            context.putProperty("LOG_NAME_ERROR", environment.getProperty("logback.log.logFileError"));
            context.putProperty("LOG_NAME_DB", environment.getProperty("logback.log.logFileDB"));
            context.putProperty("LOG_NAME_TIME_REQUEST", environment.getProperty("logback.log.logFileTimeRequest"));
            
            context.putProperty("LOG_ANALYSER_DIR", environment.getProperty("logback.log.analyzer.directory"));
            context.putProperty("LOG_NAME_ANALYZER", environment.getProperty("logback.log.analyzer.fileName"));

//            context.putProperty("ERROR_MAIL_PASSWORD", logbackErrorMailPassword);
//            context.putProperty("SUPPORT_EMAIL_ID", supportEmail);
            context.putProperty("ENV", environment.getProperty("spring.profiles.active"));
            ClassLoader classLoader = getClass().getClassLoader();
            jc.doConfigure(classLoader.getResourceAsStream(environment.getProperty("logback.log.fileDirectory")));
        } catch (JoranException e) {
            e.printStackTrace(System.out);
        }
    }
}

