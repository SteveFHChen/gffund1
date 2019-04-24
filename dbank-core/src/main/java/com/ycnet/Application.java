package com.ycnet;

import com.ycnet.mirage.context.MirageApplication;
import com.ycnet.mirage.filecenter.client.core.FileServer;
import com.ycnet.mirage.filecenter.client.service.IFileClient;
import com.ycnet.mirage.filecenter.client.service.impl.FileClient;
import com.ycnet.mirage.integration.config.EnableGateway;
import com.ycnet.mirage.repository.MirageRepositoryFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.io.IOException;

/**
 * 系统的applicationContext
 * User: guozp
 * Date: 14-3-11
 * Time: 上午12:15
 */
@MirageApplication
@EnableGateway
@PropertySource(value = "classpath:/application.properties")
@EnableJpaRepositories(repositoryFactoryBeanClass = MirageRepositoryFactoryBean.class, basePackages = "com.ycnet.dbank.repository")
public class Application {

    //文件服务器地址
    @Value("${fileServerUrl}")
    private String fileServerUrl;

    /**
     * 文件服务器客户端
     * @return
     * @throws IOException
     */
    @Bean
    public IFileClient fileClient() throws IOException {
        return new FileClient(new FileServer[]{new FileServer(fileServerUrl)});
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
