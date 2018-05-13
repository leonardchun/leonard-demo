package com.leonard.cache;

import io.undertow.Undertow;
import io.undertow.UndertowOptions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.undertow.UndertowBuilderCustomizer;
import org.springframework.boot.context.embedded.undertow.UndertowEmbeddedServletContainer;
import org.springframework.boot.context.embedded.undertow.UndertowEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import javax.net.ssl.*;
import java.io.InputStream;
import java.security.KeyStore;

@Slf4j
@Configuration()
public class SSLConfig {
	@Value("${dssg.esb.ssl.key-store}")
	private String keystore;

	@Value("${dssg.esb.ssl.trust-store}")
	private String truststore;

	@Value("${dssg.esb.ssl.password}")
	private String storepassword;

	@Value("${dssg.esb.ssl-port}")
	private int sslport;

	@Value("${dssg.esb.io-threads}")
	private int iothreads;

	@Value("${dssg.esb.worker-threads}")
	private int workerthreads;

	@Bean
	public EmbeddedServletContainerCustomizer containerCustomizer() {
		return new EmbeddedServletContainerCustomizer() {
			@Override
			public void customize(ConfigurableEmbeddedServletContainer container) {
				log.info("customer initialize config ssl for cache.");

				if (container instanceof UndertowEmbeddedServletContainerFactory) {
					UndertowEmbeddedServletContainerFactory factory = (UndertowEmbeddedServletContainerFactory) container;
					/*factory.addBuilderCustomizers(new UndertowBuilderCustomizer() {
						@Override
						public void customize(Undertow.Builder builder) {
							builder.addHttpListener(esbport, "0.0.0.0");
							builder.setIoThreads(iothreads);
							builder.setWorkerThreads(workerthreads);
						}
					});*/

					factory.addBuilderCustomizers(new UndertowBuilderCustomizer() {
						@Override
						public void customize(Undertow.Builder builder) {
							try {
								SSLContext sslContext = createSSLContext(loadKeyStore(keystore), loadKeyStore(keystore));
								builder.setServerOption(UndertowOptions.ENABLE_HTTP2, true);
								builder.addHttpsListener(sslport, "0.0.0.0", sslContext);
								builder.setIoThreads(iothreads);
								builder.setWorkerThreads(workerthreads);
							}
							catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				}

				if (container instanceof UndertowEmbeddedServletContainer) {
					UndertowEmbeddedServletContainer undertowContainer = (UndertowEmbeddedServletContainer) container;
				}

			}
		};
	}

	private  KeyStore loadKeyStore(String name) throws Exception {
		final InputStream stream;
		//stream = Application.class.getResourceAsStream("/"+name);
		//stream = Application.class.getClassLoader().getResourceAsStream("/" + name);
		ClassPathResource classPathResource = new ClassPathResource(name);
		stream = classPathResource.getInputStream();
		try(InputStream is = stream) {
			KeyStore loadedKeystore = KeyStore.getInstance("JKS");
			loadedKeystore.load(is, storepassword.toCharArray());
			return loadedKeystore;
		}
	}


	private  SSLContext createSSLContext(final KeyStore keyStore, final KeyStore trustStore) throws Exception {
		KeyManager[] keyManagers;
		KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
		keyManagerFactory.init(keyStore,storepassword.toCharArray());
		keyManagers = keyManagerFactory.getKeyManagers();
		TrustManager[] trustManagers;
		TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
		trustManagerFactory.init(trustStore);
		trustManagers = trustManagerFactory.getTrustManagers();
		SSLContext sslContext;
		sslContext = SSLContext.getInstance("TLS");
		sslContext.init(keyManagers, trustManagers, null);
		return sslContext;
	}

}
